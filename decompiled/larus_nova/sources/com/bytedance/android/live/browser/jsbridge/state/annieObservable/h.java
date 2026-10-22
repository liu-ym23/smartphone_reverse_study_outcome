package com.bytedance.android.live.browser.jsbridge.state.annieObservable;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.bl.LiveMessage;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.ss.ugc.live.sdk.message.stream.IStreamMessage;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class h extends com.bytedance.android.annie.api.data.subscribe.a<JsonObject> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<MessageType, Pair<Subject<JsonObject>, Function0<Unit>>> f63934c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Gson f63935d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DataCenter f63936e;

    public static final class a<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f63937a = null;

        static {
            f63937a = new a();
        }

        public a() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            JsonObject r101 = (JsonObject) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            int r102 = com.bytedance.android.live.browser.jsbridge.d.f63189a;
            String r103 = com.bytedance.android.live.browser.jsbridge.d.b(r101.get("message_method").getAsString());
            JsonObject r104 = new JsonObject();
            com.bytedance.android.live.browser.jsbridge.d.c(r101, r103);
            r104.add("data_v2", GsonProtectorUtils.toJsonTree(GsonHelper.getLynxWorkaround(), r101));
            r104.addProperty("messageType", r103);
            return r104;
        }
    }

    @Override // com.bytedance.android.annie.api.data.subscribe.g
    public final /* bridge */ /* synthetic */ Object g() {
        return null;
    }

    @Override // com.bytedance.android.annie.api.data.subscribe.g
    public final String key() {
        com.bytedance.android.live.browser.jsbridge.i.e.f r100 = com.bytedance.android.live.browser.jsbridge.i.e.f.f63209b;
        return "room_message";
    }

    @Override // com.bytedance.android.annie.api.data.subscribe.e
    public final void onRelease() {
        Iterator<T> r100 = this.f63934c.values().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((Function0) ((Pair) r100.next()).getSecond()).invoke();
        goto L4
    }

    @Override // com.bytedance.android.annie.api.data.subscribe.a
    public final Observable<JsonObject> j(String r110) {
        Intrinsics.checkNotNullParameter(r110, "path");
        MessageType[] r100 = MessageType.values();
        int r101 = r100.length;
        int r102 = 0;
    L4:
        if (r102 >= r101) goto L19;
        final MessageType r103 = r100[r102];
        if (Intrinsics.areEqual(r103.getWsMethod(), r110) == false) goto L8;
    L15:
        boolean r104 = true;
    L16:
        if (r104 == true) goto L20;
        r102 = r102 + 1;
    L20:
        if (r103 != null) goto L22;
        return null;
    L22:
        Pair<Subject<JsonObject>, Function0<Unit>> r111 = this.f63934c.get(r103);
        if (r111 == null) goto L25;
        Subject<JsonObject> r112 = r111.getFirst();
    L39:
        if (r112 != null) goto L41;
        return null;
    L41:
        return r112.map(a.f63937a);
    L25:
        PublishSubject r113 = PublishSubject.create();
        if (IStreamMessage.class.isAssignableFrom(LiveMessage.getMessageClass(r103.getWsMethod())) == false) goto L35;
        ALogger.i("RoomMessageState", "register stream listener for " + r103.getWsMethod());
        RoomContext r105 = RoomContext.a.c(RoomContext.Companion, this.f63936e, 0, 2);
        if (r105 == null) goto L37;
        com.bytedance.live.datacontext.j<emc.a> r106 = r105.getStreamMessageManager();
        if (r106 == null) goto L37;
        final emc.a r107 = r106.getValue();
        if (r107 == null) goto L37;
        final j r108 = new j(this, r113);
        r107.addMessageListener(r103.getIntType(), r108);
        this.f63934c.put(r103, new Pair(r113, new RoomMessageState$obtainObservable$$inlined$also$lambda$1(this, r103, r107, r108)));
        r112 = r113;
    L37:
        r112 = null;
        goto L39
    L35:
        final vlc.d r109 = (vlc.d) this.f63936e.get("data_message_manager", null);
        if (r109 == null) goto L37;
        final i r114 = new i(this, r113);
        r109.addMessageListener(r103.getIntType(), r114);
        this.f63934c.put(r103, new Pair(r113, new RoomMessageState$obtainObservable$$inlined$also$lambda$2(this, r103, r109, r114)));
        r112 = r113;
        goto L39
    L8:
        if (Intrinsics.areEqual(r103.getWsMethod(), MessageType.WEBCAST + r110) == true) goto L15;
        if (Intrinsics.areEqual(r103.getWsMethod(), MessageType.WEBCAST_OPEN + r110) == true) goto L15;
        if (Intrinsics.areEqual(r103.getWsMethod(), "WebcastContentOpen" + r110) == true) goto L15;
        r104 = false;
        goto L16
    L19:
        r103 = null;
        goto L20
    }

    public h(Gson r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "jsGson");
        Intrinsics.checkNotNullParameter(r101, "mDataCenter");
        super(true);
        this.f63935d = r100;
        this.f63936e = r101;
        this.f63934c = new ConcurrentHashMap();
    }
}

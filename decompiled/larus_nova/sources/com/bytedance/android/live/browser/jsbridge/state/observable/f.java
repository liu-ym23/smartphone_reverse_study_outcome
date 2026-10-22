package com.bytedance.android.live.browser.jsbridge.state.observable;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.browser.jsbridge.i;
import com.bytedance.android.live.browser.jsbridge.state.BaseObservableState;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class f extends BaseObservableState<JsonObject> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentHashMap<MessageType, Pair<Subject<JsonObject>, Function0<Unit>>> f63966e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Gson f63967f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final DataCenter f63968g;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f63969a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f63970b;

        public a(f r100, String r101) {
            this.f63969a = r100;
            this.f63970b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            JsonObject r101 = (JsonObject) r100;
            int r102 = com.bytedance.android.live.browser.jsbridge.d.f63189a;
            String r103 = com.bytedance.android.live.browser.jsbridge.d.b(r101.get("message_method").getAsString());
            JsonObject r104 = new JsonObject();
            com.bytedance.android.live.browser.jsbridge.d.c(r101, this.f63970b);
            r104.add("data_v2", GsonProtectorUtils.toJsonTree(GsonHelper.getLynxWorkaround(), r101));
            r104.addProperty("messageType", r103);
            this.f63969a.h(r104);
        }
    }

    @Override // com.bytedance.android.live.browser.jsbridge.state.a
    public final /* bridge */ /* synthetic */ Object b() {
        return null;
    }

    @Override // com.bytedance.android.live.browser.jsbridge.state.BaseObservableState
    public final void i() {
        Iterator<T> r100 = this.f63966e.values().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((Function0) ((Pair) r100.next()).getSecond()).invoke();
        goto L4
    }

    @Override // com.bytedance.android.live.browser.jsbridge.state.a
    public final i.f d() {
        return i.e.f.f63209b;
    }

    @Override // com.bytedance.android.live.browser.jsbridge.state.BaseObservableState, com.bytedance.android.live.browser.jsbridge.i.b
    public final Observable<JsonElement> a(String r110) {
        Intrinsics.checkNotNullParameter(r110, "keyParam");
        List r100 = StringsKt.split$default(r110, new String[]{"."}, false, 0, 6, null);
        Subject<JsonObject> r101 = null;
        if (r100.size() <= 1) goto L5;
        String r102 = (String) ListProtector.get(r100, 1);
    L6:
        if (r102 == null) goto L8;
        MessageType[] r103 = MessageType.values();
        int r104 = r103.length;
        int r105 = 0;
    L10:
        if (r105 >= r104) goto L25;
        final MessageType r106 = r103[r105];
        if (Intrinsics.areEqual(r106.getWsMethod(), r102) == false) goto L14;
    L21:
        boolean r107 = true;
    L22:
        if (r107 == true) goto L26;
        r105 = r105 + 1;
    L26:
        if (r106 == null) goto L28;
        Pair<Subject<JsonObject>, Function0<Unit>> r108 = this.f63966e.get(r106);
        if (r108 == null) goto L32;
        r101 = r108.getFirst();
    L36:
        if (r101 == null) goto L39;
        r101.subscribe(new a(this, r102));
    L39:
        return super.a(r110);
    L32:
        final vlc.d r109 = (vlc.d) this.f63968g.get("data_message_manager", null);
        if (r109 == null) goto L36;
        PublishSubject r111 = PublishSubject.create();
        final g r112 = new g(this, r111);
        r109.addMessageListener(r106.getIntType(), r112);
        this.f63966e.put(r106, new Pair(r111, new RoomMessageState$obtainObservable$$inlined$also$lambda$1(this, r106, r109, r112)));
        r101 = r111;
        goto L36
    L28:
        return super.a(r110);
    L14:
        if (Intrinsics.areEqual(r106.getWsMethod(), MessageType.WEBCAST.concat(r102)) == true) goto L21;
        if (Intrinsics.areEqual(r106.getWsMethod(), MessageType.WEBCAST_OPEN.concat(r102)) == true) goto L21;
        if (Intrinsics.areEqual(r106.getWsMethod(), "WebcastContentOpen".concat(r102)) == true) goto L21;
        r107 = false;
        goto L22
    L25:
        r106 = null;
        goto L26
    L8:
        return super.a(r110);
    L5:
        r102 = null;
        goto L6
    }

    public f(Gson r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "jsGson");
        Intrinsics.checkNotNullParameter(r101, "mDataCenter");
        super(true);
        this.f63967f = r100;
        this.f63968g = r101;
        this.f63966e = new ConcurrentHashMap();
    }
}

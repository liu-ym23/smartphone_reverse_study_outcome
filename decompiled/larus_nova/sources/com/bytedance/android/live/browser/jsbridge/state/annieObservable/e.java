package com.bytedance.android.live.browser.jsbridge.state.annieObservable;

import com.bytedance.android.annie.api.data.subscribe.BaseDataObsProvider;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.live.datacontext.n;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class e extends BaseDataObsProvider<JsonObject> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Disposable> f63930b;

    @Override // com.bytedance.android.annie.api.data.subscribe.g
    public final Object g() {
        RoomContext.a r100 = RoomContext.Companion;
        RoomContext r101 = RoomContext.a.c(r100, null, 0, 3);
        if (r101 == null) goto L8;
        n<JsonObject> r102 = r101.getCurrentMatchInfo();
        if (r102 == null) goto L8;
        JsonObject r103 = r102.getValue();
        if (r103 == null) goto L8;
    L9:
        RoomContext r104 = RoomContext.a.c(r100, null, 0, 3);
        if (r104 == null) goto L15;
        n<JsonObject> r105 = r104.getCurrentActiveTabId();
        if (r105 == null) goto L15;
        JsonObject r106 = r105.getValue();
        if (r106 == null) goto L15;
    L16:
        RoomContext r107 = RoomContext.a.c(r100, null, 0, 3);
        if (r107 == null) goto L22;
        n<JsonObject> r108 = r107.getLastMatchInfo();
        if (r108 == null) goto L22;
        JsonObject r109 = r108.getValue();
        if (r109 == null) goto L22;
    L23:
        JsonObject r110 = new JsonObject();
        r110.add("matchInfo", r103);
        r110.add("tabInfo", r106);
        r110.add("lastMatchInfo", r109);
        return r110;
    L22:
        r109 = new JsonObject();
    L15:
        r106 = new JsonObject();
    L8:
        r103 = new JsonObject();
        goto L9
    }

    @Override // com.bytedance.android.annie.api.data.subscribe.g
    public final String key() {
        com.bytedance.android.live.browser.jsbridge.i.e.b r100 = com.bytedance.android.live.browser.jsbridge.i.e.b.f63204b;
        return "current_live_multitab_info";
    }

    @Override // com.bytedance.android.annie.api.data.subscribe.e
    public final void onRelease() {
        Iterator r100 = CollectionsKt.toList(this.f63930b).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((Disposable) r100.next()).dispose();
        goto L4
    L6:
        ((ArrayList) this.f63930b).clear();
    }

    public e() {
        ArrayList r100 = new ArrayList();
        this.f63930b = r100;
        RoomContext.a r101 = RoomContext.Companion;
        RoomContext r102 = RoomContext.a.c(r101, null, 0, 3);
        if (r102 == null) goto L11;
        n<JsonObject> r103 = r102.getCurrentMatchInfo();
        if (r103 == null) goto L11;
        Observable<sh6.b<JsonObject>> r104 = r103.a();
        if (r104 == null) goto L11;
        Disposable r105 = r104.subscribe(new b(this));
        if (r105 == null) goto L11;
        r100.add(r105);
    L11:
        RoomContext r106 = RoomContext.a.c(r101, null, 0, 3);
        if (r106 == null) goto L20;
        n<JsonObject> r107 = r106.getCurrentMatchInfo();
        if (r107 == null) goto L20;
        Observable<sh6.b<JsonObject>> r108 = r107.a();
        if (r108 == null) goto L20;
        Disposable r109 = r108.subscribe(new c(this));
        if (r109 == null) goto L20;
        r100.add(r109);
    L20:
        RoomContext r110 = RoomContext.a.c(r101, null, 0, 3);
        if (r110 == null) goto L30;
        n<JsonObject> r111 = r110.getCurrentActiveTabId();
        if (r111 == null) goto L31;
        Observable<sh6.b<JsonObject>> r112 = r111.a();
        if (r112 == null) goto L32;
        Disposable r113 = r112.subscribe(new d(this));
        if (r113 == null) goto L33;
        r100.add(r113);
        return;
    L33:
        return;
    L32:
        return;
    L31:
        return;
    }
}

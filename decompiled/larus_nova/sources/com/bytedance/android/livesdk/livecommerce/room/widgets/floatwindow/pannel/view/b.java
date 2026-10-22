package com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.view;

import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.livesdk.livecommerce.event.a2;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes10.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f152185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ lk2.b f152186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f152187c;

    public b(a r100, lk2.b r101, boolean r102) {
        this.f152185a = r100;
        this.f152186b = r101;
        this.f152187c = r102;
    }

    public final void a() {
        a2 r100 = new a2();
        LiveRoomParams r101 = this.f152185a.f152181h;
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.getAuthorId();
    L6:
        r100.f("anchor_id", r103);
        r100.f("product_id", this.f152186b.f509558d);
        r100.f(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_ID, this.f152186b.f509559e);
        r100.f(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, this.f152186b.f509560f);
        LiveRoomParams r104 = this.f152185a.f152181h;
        if (r104 == null) goto L9;
        r102 = r104.getRoomId();
    L9:
        r100.f("room_id", r102);
        if (this.f152187c == false) goto L12;
        String r105 = BitableAnalytic.LinkSceneClickType.EXPAND;
    L13:
        r100.f("click_type", r105);
        r100.g(this.f152186b.f509557c);
        r100.k();
        return;
    L12:
        r105 = "close";
        goto L13
    L5:
        r103 = null;
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

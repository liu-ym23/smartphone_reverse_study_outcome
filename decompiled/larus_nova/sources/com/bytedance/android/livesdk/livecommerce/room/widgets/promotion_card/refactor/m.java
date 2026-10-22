package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor;

import com.bytedance.android.livesdk.livecommerce.event.q1;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes10.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RoomContextController f152364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f152365b;

    public m(RoomContextController r100, String r101) {
        this.f152364a = r100;
        this.f152365b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        q1 r100 = new q1(this.f152364a);     // Catch: Throwable -> L4
        r100.f("product_id", this.f152365b);     // Catch: Throwable -> L4
        r100.f("status", "in");     // Catch: Throwable -> L4
        r100.k();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

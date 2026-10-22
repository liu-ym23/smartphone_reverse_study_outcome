package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor;

import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.livesdk.livecommerce.event.s0;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECUIPromotion f152370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RoomContextController f152371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Map f152372c;

    public o(ECUIPromotion r100, RoomContextController r101, Map r102) {
        this.f152370a = r100;
        this.f152371b = r101;
        this.f152372c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long r100 = this.f152370a.liveRoomType;     // Catch: Throwable -> L11
        if (r100 != 1) goto L6;
        String r101 = "anchor_insurance";
    L9:
        s0 r102 = new s0(r101, this.f152371b);     // Catch: Throwable -> L11
        r102.m(this.f152372c);     // Catch: Throwable -> L11
        r102.k();     // Catch: Throwable -> L11
        return;
    L6:
        if (r100 != 2) goto L8;
        r101 = "save_insurance";
        goto L9
    L8:
        r101 = "error_insurance";
    L11:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L15;
        return;
    L15:
        throw th;
    }
}

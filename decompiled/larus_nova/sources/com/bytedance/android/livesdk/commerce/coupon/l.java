package com.bytedance.android.livesdk.commerce.coupon;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class l<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveCouponPresenter f119625a;

    public l(LiveCouponPresenter r100) {
        this.f119625a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        LiveCouponPresenter.d0(this.f119625a, "ttlive_live_coupon_getcurrent", 1, new String[]{"room_id", String.valueOf(this.f119625a.f119544b)});
        LiveCouponPresenter.b r102 = (LiveCouponPresenter.b) this.f119625a.f531633a;
        if (r102 == null) goto L6;
        r102.Z80();
        return;
    }
}

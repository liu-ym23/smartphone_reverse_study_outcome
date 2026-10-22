package com.bytedance.android.livesdk.commerce.coupon;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveCouponPresenter f119622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f119623b;

    public j(LiveCouponPresenter r100, String r101) {
        this.f119622a = r100;
        this.f119623b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        LiveCouponPresenter.c0(this.f119622a, null, false);
        LiveCouponPresenter.d0(this.f119622a, "ttlive_live_coupon_apply", 1, new String[]{"room_id", String.valueOf(this.f119622a.f119544b), "meta_id", String.valueOf(this.f119623b)});
    }
}

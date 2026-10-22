package com.bytedance.android.livesdk.commerce.coupon;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes8.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveCouponPresenter f119619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f119620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f119621c;

    public i(LiveCouponPresenter r100, Function0 r101, String r102) {
        this.f119619a = r100;
        this.f119620b = r101;
        this.f119621c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        LiveCouponPresenter.c0(this.f119619a, (c) r100, true);
        this.f119620b.invoke();
        LiveCouponPresenter.d0(this.f119619a, "ttlive_live_coupon_apply", 0, new String[]{"room_id", String.valueOf(this.f119619a.f119544b), "meta_id", String.valueOf(this.f119621c)});
    }
}

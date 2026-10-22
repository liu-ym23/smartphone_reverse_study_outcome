package com.bytedance.android.shopping.store.home.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes14.dex */
public final class l<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECShopBackgroundPresenterBrand.a f184223a;

    public l(ECShopBackgroundPresenterBrand.a r100) {
        this.f184223a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Float r101 = (Float) r100;
        if (r101.floatValue() < 0) goto L7;
        ECShopBackgroundPresenterBrand r102 = this.f184223a.f183894a;
        int r103 = ECShopBackgroundPresenterBrand.G;
        ECShopBackgroundPresenterBrand.r0(r102, r102.t0(), r101.floatValue());
        return;
    }
}

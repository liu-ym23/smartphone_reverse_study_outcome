package com.bytedance.android.shopping.store.home.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes14.dex */
public final class m<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECShopBackgroundPresenterBrand.a f184233a;

    public m(ECShopBackgroundPresenterBrand.a r100) {
        this.f184233a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        ECShopBackgroundPresenterBrand r101 = this.f184233a.f183894a;
        int r102 = ECShopBackgroundPresenterBrand.G;
        ECShopBackgroundPresenterBrand.s0(r101, r101.u0(), ((Float) r100).floatValue());
    }
}

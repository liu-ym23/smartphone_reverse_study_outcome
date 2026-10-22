package com.bytedance.android.shopping.store.home.presenter;

import android.view.ViewGroup;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes14.dex */
public final class o<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECShopBackgroundPresenterBrand.a f184246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f184247b;

    public o(ECShopBackgroundPresenterBrand.a r100, float r101) {
        this.f184246a = r100;
        this.f184247b = r101;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Integer r101 = (Integer) r100;
        ECShopBackgroundPresenterBrand r102 = this.f184246a.f183894a;
        int r103 = ECShopBackgroundPresenterBrand.G;
        ViewGroup r104 = r102.v0();
        if (r104 == null) goto L6;
        r104.setY(this.f184247b - r101.intValue());
        return;
    }
}

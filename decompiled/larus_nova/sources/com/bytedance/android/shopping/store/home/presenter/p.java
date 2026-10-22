package com.bytedance.android.shopping.store.home.presenter;

import android.view.ViewGroup;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes14.dex */
public final class p<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECShopBackgroundPresenterBrand.a f184261a;

    public p(ECShopBackgroundPresenterBrand.a r100) {
        this.f184261a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Float r101 = (Float) r100;
        if (r101.floatValue() < 0) goto L10;
        ECShopBackgroundPresenterBrand r102 = this.f184261a.f183894a;
        int r103 = ECShopBackgroundPresenterBrand.G;
        ViewGroup r104 = r102.v0();
        if (r104 == null) goto L9;
        float r105 = 1;
        ViewExtensionsKt.g(r104, (r105 - r101.floatValue()) * 20.0f, (r105 - r101.floatValue()) * 20.0f, 0.0f, 0.0f);
        return;
    L9:
        return;
    }
}

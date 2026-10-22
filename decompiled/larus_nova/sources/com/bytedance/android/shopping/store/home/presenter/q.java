package com.bytedance.android.shopping.store.home.presenter;

import android.view.View;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class q<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECShopBackgroundPresenterBrand.a f184363a;

    public q(ECShopBackgroundPresenterBrand.a r100) {
        this.f184363a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Float r101 = (Float) r100;
        if (r101.floatValue() < 0) goto L10;
        ECShopBackgroundPresenterBrand r102 = this.f184363a.f183894a;
        View r103 = r102.C;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("topbarBackgroundMask");
    L8:
        ECShopBackgroundPresenterBrand.r0(r102, r103, r101.floatValue());
        return;
    }
}

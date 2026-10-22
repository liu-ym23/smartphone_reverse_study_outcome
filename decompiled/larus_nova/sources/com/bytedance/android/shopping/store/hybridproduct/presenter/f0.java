package com.bytedance.android.shopping.store.hybridproduct.presenter;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class f0 implements sm.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShopSlicedProductCardPresenter f185376a;

    public f0(ShopSlicedProductCardPresenter r100) {
        this.f185376a = r100;
    }

    @Override // sm.n
    public final void a(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCtx");
        ShopSlicedProductCardPresenter r101 = this.f185376a;
        com.bytedance.android.ecom.arch.slice.render.r r102 = r101.f185320p;
        if (r102 == null) goto L6;
        r102.a(r100, r101.f185317m);
        return;
    }
}

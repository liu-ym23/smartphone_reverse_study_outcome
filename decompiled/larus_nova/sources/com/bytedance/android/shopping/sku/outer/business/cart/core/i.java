package com.bytedance.android.shopping.sku.outer.business.cart.core;

import com.bytedance.android.shopping.sku.common.monitor.chain.SkuYataAddCartChain;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonToast;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes13.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SkuOuterAddToCartHelper f183090a;

    public i(SkuOuterAddToCartHelper r100) {
        this.f183090a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        this.f183090a.f183070f.c(null, r101);
        mh3.a r102 = this.f183090a.f183065a;
        if (r102 != null) goto L5;
    L7:
        SkuCommonToast.c("添加失败，请稍后重试");
        return;
    L5:
        if (r102.f513944e == null) goto L7;
        SkuYataAddCartChain.c(null, r101);
        goto L7
    }
}

package com.bytedance.android.shopping.sku.outer.business.cart.core;

import com.bytedance.android.shopping.sku.common.monitor.chain.SkuYataAddCartChain;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes13.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SkuOuterAddToCartHelper f183085a;

    public f(SkuOuterAddToCartHelper r100) {
        this.f183085a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        String r102 = this.f183085a.f183067c.f();
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L10:
        if (r103 == true) goto L12;
        int r104 = b.f183073a;
        b.b(null, this.f183085a.f183067c.f(), false);
    L13:
        this.f183085a.c(null);
        this.f183085a.f183070f.b(null, r101);
        mh3.a r105 = this.f183085a.f183065a;
        if (r105 != null) goto L16;
        return;
    L16:
        if (r105.f513944e == null) goto L20;
        SkuYataAddCartChain.b(null, r101);
        return;
    L20:
        return;
    L12:
        int r106 = b.f183073a;
        b.a(null, Integer.valueOf(this.f183085a.f183067c.e()), this.f183085a.f183067c.c(), this.f183085a.f183067c.d());
        goto L13
    L5:
        if (r102.length() == 0) goto L8;
        r103 = false;
        goto L10
    }
}

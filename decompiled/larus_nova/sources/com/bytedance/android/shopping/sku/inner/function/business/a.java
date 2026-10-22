package com.bytedance.android.shopping.sku.inner.function.business;

import com.bytedance.android.shopping.sku.outer.business.cart.repo.SkuOuterAddToCartResponse;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements com.bytedance.android.shopping.sku.common.ability.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f182920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f182921b;

    @Override // com.bytedance.android.shopping.sku.common.ability.a
    public final void a() {
    }

    public a(b r100, Function1 r101) {
        this.f182920a = r100;
        this.f182921b = r101;
    }

    @Override // com.bytedance.android.shopping.sku.common.ability.a
    public final void b(th3.c r100, Throwable r101) {
        Integer r102 = null;
        if (r101 != null) goto L8;
        if (r100 == null) goto L8;
        if (r100.f545928a != 0) goto L8;
        this.f182920a.f182923b.n20().b("加购成功");
        Function1 r103 = this.f182921b;
        int r104 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        r103.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L8:
        this.f182920a.f182923b.n20().b("加购失败");
        b r105 = this.f182920a;
        if (r100 == null) goto L11;
        r102 = Integer.valueOf(r100.f545928a);
    L11:
        b.d(r105, r102, r101, this.f182921b);
    }

    @Override // com.bytedance.android.shopping.sku.common.ability.a
    public final void c(SkuOuterAddToCartResponse r100, Throwable r101) {
        Integer r102 = null;
        if (r101 != null) goto L8;
        if (r100 == null) goto L8;
        if (r100.getStatusCode() != 0) goto L8;
        this.f182920a.f182923b.n20().b("加购成功");
        Function1 r103 = this.f182921b;
        int r104 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        r103.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L8:
        this.f182920a.f182923b.n20().b("加购失败");
        b r105 = this.f182920a;
        if (r100 == null) goto L11;
        r102 = Integer.valueOf(r100.getStatusCode());
    L11:
        b.d(r105, r102, r101, this.f182921b);
    }
}

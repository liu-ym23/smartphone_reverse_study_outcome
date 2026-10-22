package com.bytedance.android.livesdk.livecommerce.saascoupon;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import el2.n;

/* JADX INFO: loaded from: classes10.dex */
public final class SaasCouponModule_ProvideFactory implements Factory<n> {
    private final a module;

    @Override // javax.inject.Provider
    public n get() {
        return provideInstance(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public SaasCouponModule_ProvideFactory(a r100) {
        this.module = r100;
    }

    public static SaasCouponModule_ProvideFactory create(a r100) {
        return new SaasCouponModule_ProvideFactory(r100);
    }

    public static n provideInstance(a r100) {
        return proxyProvide(r100);
    }

    public static n proxyProvide(a r100) {
        r100.getClass();
        return (n) Preconditions.checkNotNull(new SaasCouponService(), "Cannot return null from a non-@Nullable @Provides method");
    }
}

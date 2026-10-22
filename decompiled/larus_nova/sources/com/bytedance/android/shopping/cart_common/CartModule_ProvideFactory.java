package com.bytedance.android.shopping.cart_common;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import sc3.e;

/* JADX INFO: loaded from: classes13.dex */
public final class CartModule_ProvideFactory implements Factory<e> {
    private final a module;

    @Override // javax.inject.Provider
    public e get() {
        return provideInstance(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public CartModule_ProvideFactory(a r100) {
        this.module = r100;
    }

    public static CartModule_ProvideFactory create(a r100) {
        return new CartModule_ProvideFactory(r100);
    }

    public static e provideInstance(a r100) {
        return proxyProvide(r100);
    }

    public static e proxyProvide(a r100) {
        r100.getClass();
        return (e) Preconditions.checkNotNull(new b(), "Cannot return null from a non-@Nullable @Provides method");
    }
}

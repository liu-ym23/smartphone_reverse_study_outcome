package com.bytedance.android.shopping.di;

import dagger.internal.Factory;
import gd3.g;
import sc3.e;

/* JADX INFO: loaded from: classes13.dex */
public final class CartModuleFallback_ProvideFactory implements Factory<e> {
    private final g module;

    @Override // javax.inject.Provider
    public e get() {
        return provideInstance(null);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public CartModuleFallback_ProvideFactory(g r100) {
    }

    public static CartModuleFallback_ProvideFactory create(g r100) {
        return new CartModuleFallback_ProvideFactory(r100);
    }

    public static e provideInstance(g r100) {
        return proxyProvide(r100);
    }

    public static e proxyProvide(g r100) {
        throw null;
    }
}

package com.bytedance.android.shopping.di;

import dagger.internal.Factory;
import gd3.e;
import sc3.c;

/* JADX INFO: loaded from: classes13.dex */
public final class BuyNowModuleFallback_ProvideFactory implements Factory<c> {
    private final e module;

    @Override // javax.inject.Provider
    public c get() {
        return provideInstance(null);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public BuyNowModuleFallback_ProvideFactory(e r100) {
    }

    public static BuyNowModuleFallback_ProvideFactory create(e r100) {
        return new BuyNowModuleFallback_ProvideFactory(r100);
    }

    public static c provideInstance(e r100) {
        return proxyProvide(r100);
    }

    public static c proxyProvide(e r100) {
        throw null;
    }
}

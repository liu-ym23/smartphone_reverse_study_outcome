package com.bytedance.android.shopping.di;

import dagger.internal.Factory;
import gd3.b;
import p83.d;

/* JADX INFO: loaded from: classes13.dex */
public final class AnchorModuleFallback_ProvideFactory implements Factory<d> {
    private final b module;

    @Override // javax.inject.Provider
    public d get() {
        return provideInstance(null);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public AnchorModuleFallback_ProvideFactory(b r100) {
    }

    public static AnchorModuleFallback_ProvideFactory create(b r100) {
        return new AnchorModuleFallback_ProvideFactory(r100);
    }

    public static d provideInstance(b r100) {
        return proxyProvide(r100);
    }

    public static d proxyProvide(b r100) {
        throw null;
    }
}

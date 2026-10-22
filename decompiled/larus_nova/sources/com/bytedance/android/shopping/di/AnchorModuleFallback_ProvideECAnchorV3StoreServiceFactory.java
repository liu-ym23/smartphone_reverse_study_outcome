package com.bytedance.android.shopping.di;

import dagger.internal.Factory;
import gd3.b;
import p83.e;

/* JADX INFO: loaded from: classes13.dex */
public final class AnchorModuleFallback_ProvideECAnchorV3StoreServiceFactory implements Factory<e> {
    private final b module;

    @Override // javax.inject.Provider
    public e get() {
        return provideInstance(null);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public AnchorModuleFallback_ProvideECAnchorV3StoreServiceFactory(b r100) {
    }

    public static AnchorModuleFallback_ProvideECAnchorV3StoreServiceFactory create(b r100) {
        return new AnchorModuleFallback_ProvideECAnchorV3StoreServiceFactory(r100);
    }

    public static e provideInstance(b r100) {
        return proxyProvideECAnchorV3StoreService(r100);
    }

    public static e proxyProvideECAnchorV3StoreService(b r100) {
        throw null;
    }
}

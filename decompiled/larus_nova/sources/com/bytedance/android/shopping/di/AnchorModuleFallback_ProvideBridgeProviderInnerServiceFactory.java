package com.bytedance.android.shopping.di;

import dagger.internal.Factory;
import g33.e;
import gd3.b;

/* JADX INFO: loaded from: classes13.dex */
public final class AnchorModuleFallback_ProvideBridgeProviderInnerServiceFactory implements Factory<e> {
    private final b module;

    @Override // javax.inject.Provider
    public e get() {
        return provideInstance(null);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public AnchorModuleFallback_ProvideBridgeProviderInnerServiceFactory(b r100) {
    }

    public static AnchorModuleFallback_ProvideBridgeProviderInnerServiceFactory create(b r100) {
        return new AnchorModuleFallback_ProvideBridgeProviderInnerServiceFactory(r100);
    }

    public static e provideInstance(b r100) {
        return proxyProvideBridgeProviderInnerService(r100);
    }

    public static e proxyProvideBridgeProviderInnerService(b r100) {
        throw null;
    }
}

package com.bytedance.android.shopping.di;

import com.bytedance.android.shopping.hybrid.EShoppingBridgeProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import g33.e;
import gd3.a;

/* JADX INFO: loaded from: classes13.dex */
public final class AnchorModule_ProvideBridgeProviderInnerServiceFactory implements Factory<e> {
    private final a module;

    @Override // javax.inject.Provider
    public e get() {
        return provideInstance(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public AnchorModule_ProvideBridgeProviderInnerServiceFactory(a r100) {
        this.module = r100;
    }

    public static AnchorModule_ProvideBridgeProviderInnerServiceFactory create(a r100) {
        return new AnchorModule_ProvideBridgeProviderInnerServiceFactory(r100);
    }

    public static e provideInstance(a r100) {
        return proxyProvideBridgeProviderInnerService(r100);
    }

    public static e proxyProvideBridgeProviderInnerService(a r100) {
        r100.getClass();
        return (e) Preconditions.checkNotNull(EShoppingBridgeProvider.f176198a, "Cannot return null from a non-@Nullable @Provides method");
    }
}

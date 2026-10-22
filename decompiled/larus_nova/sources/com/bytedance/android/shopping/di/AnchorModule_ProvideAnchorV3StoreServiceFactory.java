package com.bytedance.android.shopping.di;

import com.bytedance.android.shopping.anchorv3.ECAnchorV3Helper;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import gd3.a;
import p83.e;

/* JADX INFO: loaded from: classes13.dex */
public final class AnchorModule_ProvideAnchorV3StoreServiceFactory implements Factory<e> {
    private final a module;

    @Override // javax.inject.Provider
    public e get() {
        return provideInstance(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public AnchorModule_ProvideAnchorV3StoreServiceFactory(a r100) {
        this.module = r100;
    }

    public static AnchorModule_ProvideAnchorV3StoreServiceFactory create(a r100) {
        return new AnchorModule_ProvideAnchorV3StoreServiceFactory(r100);
    }

    public static e provideInstance(a r100) {
        return proxyProvideAnchorV3StoreService(r100);
    }

    public static e proxyProvideAnchorV3StoreService(a r100) {
        r100.getClass();
        return (e) Preconditions.checkNotNull(ECAnchorV3Helper.f164389a, "Cannot return null from a non-@Nullable @Provides method");
    }
}

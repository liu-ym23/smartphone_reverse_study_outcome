package com.bytedance.android.livesdk.livecommerce;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import el2.k;
import sg2.i;

/* JADX INFO: loaded from: classes10.dex */
public final class ECLiveCommerceModel_ProvideLiveServiceFactory implements Factory<k> {
    private final i module;

    @Override // javax.inject.Provider
    public k get() {
        return provideInstance(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ECLiveCommerceModel_ProvideLiveServiceFactory(i r100) {
        this.module = r100;
    }

    public static ECLiveCommerceModel_ProvideLiveServiceFactory create(i r100) {
        return new ECLiveCommerceModel_ProvideLiveServiceFactory(r100);
    }

    public static k provideInstance(i r100) {
        return proxyProvideLiveService(r100);
    }

    public static k proxyProvideLiveService(i r100) {
        r100.getClass();
        return (k) Preconditions.checkNotNull(i.f541808d, "Cannot return null from a non-@Nullable @Provides method");
    }
}

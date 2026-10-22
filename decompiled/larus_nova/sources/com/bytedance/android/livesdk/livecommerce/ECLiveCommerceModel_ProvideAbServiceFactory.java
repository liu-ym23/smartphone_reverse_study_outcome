package com.bytedance.android.livesdk.livecommerce;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import el2.g;
import sg2.i;

/* JADX INFO: loaded from: classes10.dex */
public final class ECLiveCommerceModel_ProvideAbServiceFactory implements Factory<g> {
    private final i module;

    @Override // javax.inject.Provider
    public g get() {
        return provideInstance(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ECLiveCommerceModel_ProvideAbServiceFactory(i r100) {
        this.module = r100;
    }

    public static ECLiveCommerceModel_ProvideAbServiceFactory create(i r100) {
        return new ECLiveCommerceModel_ProvideAbServiceFactory(r100);
    }

    public static g provideInstance(i r100) {
        return proxyProvideAbService(r100);
    }

    public static g proxyProvideAbService(i r100) {
        r100.getClass();
        return (g) Preconditions.checkNotNull(i.f541806b, "Cannot return null from a non-@Nullable @Provides method");
    }
}

package com.bytedance.android.livesdk.livecommerce;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import el2.i;

/* JADX INFO: loaded from: classes10.dex */
public final class ECLiveCommerceModel_ProvideEventServiceFactory implements Factory<i> {
    private final sg2.i module;

    @Override // javax.inject.Provider
    public i get() {
        return provideInstance(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ECLiveCommerceModel_ProvideEventServiceFactory(sg2.i r100) {
        this.module = r100;
    }

    public static ECLiveCommerceModel_ProvideEventServiceFactory create(sg2.i r100) {
        return new ECLiveCommerceModel_ProvideEventServiceFactory(r100);
    }

    public static i provideInstance(sg2.i r100) {
        return proxyProvideEventService(r100);
    }

    public static i proxyProvideEventService(sg2.i r100) {
        r100.getClass();
        return (i) Preconditions.checkNotNull(sg2.i.f541807c, "Cannot return null from a non-@Nullable @Provides method");
    }
}

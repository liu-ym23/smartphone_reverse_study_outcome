package com.bytedance.android.livesdk.livecommerce;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import el2.l;
import sg2.i;

/* JADX INFO: loaded from: classes10.dex */
public final class ECLiveCommerceModel_ProvideNetServiceFactory implements Factory<l> {
    private final i module;

    @Override // javax.inject.Provider
    public l get() {
        return provideInstance(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ECLiveCommerceModel_ProvideNetServiceFactory(i r100) {
        this.module = r100;
    }

    public static ECLiveCommerceModel_ProvideNetServiceFactory create(i r100) {
        return new ECLiveCommerceModel_ProvideNetServiceFactory(r100);
    }

    public static l provideInstance(i r100) {
        return proxyProvideNetService(r100);
    }

    public static l proxyProvideNetService(i r100) {
        r100.getClass();
        return (l) Preconditions.checkNotNull(i.f541805a, "Cannot return null from a non-@Nullable @Provides method");
    }
}

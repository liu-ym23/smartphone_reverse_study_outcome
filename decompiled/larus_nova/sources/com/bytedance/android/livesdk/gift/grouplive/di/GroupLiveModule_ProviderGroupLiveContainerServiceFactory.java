package com.bytedance.android.livesdk.gift.grouplive.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import h12.b;
import wy1.c;

/* JADX INFO: loaded from: classes9.dex */
public final class GroupLiveModule_ProviderGroupLiveContainerServiceFactory implements Factory<b> {
    private final c module;

    @Override // javax.inject.Provider
    public b get() {
        return providerGroupLiveContainerService(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public GroupLiveModule_ProviderGroupLiveContainerServiceFactory(c r100) {
        this.module = r100;
    }

    public static GroupLiveModule_ProviderGroupLiveContainerServiceFactory create(c r100) {
        return new GroupLiveModule_ProviderGroupLiveContainerServiceFactory(r100);
    }

    public static b providerGroupLiveContainerService(c r100) {
        r100.getClass();
        return (b) Preconditions.checkNotNullFromProvides(new wy1.b());
    }
}

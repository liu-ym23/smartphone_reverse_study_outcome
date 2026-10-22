package com.bytedance.android.livesdk.livecommerce;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import fi2.b;
import sg2.c0;
import sg2.d0;

/* JADX INFO: loaded from: classes10.dex */
public final class LiveUserDataCenterModule_ProvideJumpDispatcherFactoryFactory implements Factory<b> {
    private final d0 module;

    @Override // javax.inject.Provider
    public b get() {
        return provideInstance(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public LiveUserDataCenterModule_ProvideJumpDispatcherFactoryFactory(d0 r100) {
        this.module = r100;
    }

    public static LiveUserDataCenterModule_ProvideJumpDispatcherFactoryFactory create(d0 r100) {
        return new LiveUserDataCenterModule_ProvideJumpDispatcherFactoryFactory(r100);
    }

    public static b provideInstance(d0 r100) {
        return proxyProvideJumpDispatcherFactory(r100);
    }

    public static b proxyProvideJumpDispatcherFactory(d0 r100) {
        r100.getClass();
        return (b) Preconditions.checkNotNull(new c0(), "Cannot return null from a non-@Nullable @Provides method");
    }
}

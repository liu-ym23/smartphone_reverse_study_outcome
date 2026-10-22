package com.bytedance.android.live.broadcastgame.di;

import com.bytedance.android.live.broadcastgame.f0;
import dagger.internal.Factory;
import i10.g;

/* JADX INFO: loaded from: classes45.dex */
public final class OpenPlatformModuleFallback_ProvideOpenPlatformServiceFactory implements Factory<f0> {
    private final g module;

    @Override // javax.inject.Provider
    public f0 get() {
        return provideOpenPlatformService(null);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public OpenPlatformModuleFallback_ProvideOpenPlatformServiceFactory(g r100) {
    }

    public static OpenPlatformModuleFallback_ProvideOpenPlatformServiceFactory create(g r100) {
        return new OpenPlatformModuleFallback_ProvideOpenPlatformServiceFactory(r100);
    }

    public static f0 provideOpenPlatformService(g r100) {
        throw null;
    }
}

package com.bytedance.android.live.broadcastgame.opengame.di;

import com.bytedance.android.live.broadcastgame.f0;
import com.bytedance.android.live.broadcastgame.opengame.s;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import p10.a;

/* JADX INFO: loaded from: classes45.dex */
public final class OpenPlatformModule_ProvideOpenPlatformServiceFactory implements Factory<f0> {
    private final a module;

    @Override // javax.inject.Provider
    public f0 get() {
        return provideOpenPlatformService(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public OpenPlatformModule_ProvideOpenPlatformServiceFactory(a r100) {
        this.module = r100;
    }

    public static OpenPlatformModule_ProvideOpenPlatformServiceFactory create(a r100) {
        return new OpenPlatformModule_ProvideOpenPlatformServiceFactory(r100);
    }

    public static f0 provideOpenPlatformService(a r100) {
        r100.getClass();
        return (f0) Preconditions.checkNotNullFromProvides(new s());
    }
}

package com.bytedance.android.live.broadcastgame.opengame.di;

import com.bytedance.android.live.broadcastgame.e0;
import com.bytedance.android.live.broadcastgame.opengame.performance.OpenPlatformPerfDog;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import p10.a;

/* JADX INFO: loaded from: classes45.dex */
public final class OpenPlatformModule_ProvideOpenPlatformPerfDogFactory implements Factory<e0> {
    private final a module;

    @Override // javax.inject.Provider
    public e0 get() {
        return provideOpenPlatformPerfDog(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public OpenPlatformModule_ProvideOpenPlatformPerfDogFactory(a r100) {
        this.module = r100;
    }

    public static OpenPlatformModule_ProvideOpenPlatformPerfDogFactory create(a r100) {
        return new OpenPlatformModule_ProvideOpenPlatformPerfDogFactory(r100);
    }

    public static e0 provideOpenPlatformPerfDog(a r100) {
        r100.getClass();
        return (e0) Preconditions.checkNotNullFromProvides(OpenPlatformPerfDog.f60705p);
    }
}

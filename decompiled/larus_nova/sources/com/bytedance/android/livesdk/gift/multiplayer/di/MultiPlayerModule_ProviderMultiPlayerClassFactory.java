package com.bytedance.android.livesdk.gift.multiplayer.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import h12.e;
import hz1.a;
import hz1.b;

/* JADX INFO: loaded from: classes9.dex */
public final class MultiPlayerModule_ProviderMultiPlayerClassFactory implements Factory<e> {
    private final b module;

    @Override // javax.inject.Provider
    public e get() {
        return providerMultiPlayerClass(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public MultiPlayerModule_ProviderMultiPlayerClassFactory(b r100) {
        this.module = r100;
    }

    public static MultiPlayerModule_ProviderMultiPlayerClassFactory create(b r100) {
        return new MultiPlayerModule_ProviderMultiPlayerClassFactory(r100);
    }

    public static e providerMultiPlayerClass(b r100) {
        r100.getClass();
        return (e) Preconditions.checkNotNullFromProvides(new a());
    }
}

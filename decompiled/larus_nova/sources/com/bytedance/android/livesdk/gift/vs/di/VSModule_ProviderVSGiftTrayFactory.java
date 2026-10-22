package com.bytedance.android.livesdk.gift.vs.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import h12.g;
import z12.b;
import z12.c;

/* JADX INFO: loaded from: classes9.dex */
public final class VSModule_ProviderVSGiftTrayFactory implements Factory<g> {
    private final c module;

    @Override // javax.inject.Provider
    public g get() {
        return providerVSGiftTray(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public VSModule_ProviderVSGiftTrayFactory(c r100) {
        this.module = r100;
    }

    public static VSModule_ProviderVSGiftTrayFactory create(c r100) {
        return new VSModule_ProviderVSGiftTrayFactory(r100);
    }

    public static g providerVSGiftTray(c r100) {
        r100.getClass();
        return (g) Preconditions.checkNotNullFromProvides(new b());
    }
}

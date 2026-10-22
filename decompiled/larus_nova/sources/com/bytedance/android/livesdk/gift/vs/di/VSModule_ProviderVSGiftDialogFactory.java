package com.bytedance.android.livesdk.gift.vs.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import h12.f;
import z12.a;
import z12.c;

/* JADX INFO: loaded from: classes9.dex */
public final class VSModule_ProviderVSGiftDialogFactory implements Factory<f> {
    private final c module;

    @Override // javax.inject.Provider
    public f get() {
        return providerVSGiftDialog(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public VSModule_ProviderVSGiftDialogFactory(c r100) {
        this.module = r100;
    }

    public static VSModule_ProviderVSGiftDialogFactory create(c r100) {
        return new VSModule_ProviderVSGiftDialogFactory(r100);
    }

    public static f providerVSGiftDialog(c r100) {
        r100.getClass();
        return (f) Preconditions.checkNotNullFromProvides(new a());
    }
}

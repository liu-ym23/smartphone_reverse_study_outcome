package com.bytedance.android.livesdk.gift.fastgift.di;

import com.bytedance.android.livesdk.gift.platform.business.h;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes9.dex */
public final class FastGiftModule_ProvideFastGiftPluginFactoryFactory implements Factory<h.a> {
    private final e module;

    @Override // javax.inject.Provider
    public h.a get() {
        return provideFastGiftPluginFactory(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public FastGiftModule_ProvideFastGiftPluginFactoryFactory(e r100) {
        this.module = r100;
    }

    public static FastGiftModule_ProvideFastGiftPluginFactoryFactory create(e r100) {
        return new FastGiftModule_ProvideFastGiftPluginFactoryFactory(r100);
    }

    public static h.a provideFastGiftPluginFactory(e r100) {
        r100.getClass();
        return (h.a) Preconditions.checkNotNullFromProvides(new c());
    }
}

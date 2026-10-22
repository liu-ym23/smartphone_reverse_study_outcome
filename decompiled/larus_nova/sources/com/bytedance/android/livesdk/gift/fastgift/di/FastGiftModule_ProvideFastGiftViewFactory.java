package com.bytedance.android.livesdk.gift.fastgift.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import h12.h;

/* JADX INFO: loaded from: classes9.dex */
public final class FastGiftModule_ProvideFastGiftViewFactory implements Factory<h> {
    private final e module;

    @Override // javax.inject.Provider
    public h get() {
        return provideFastGiftView(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public FastGiftModule_ProvideFastGiftViewFactory(e r100) {
        this.module = r100;
    }

    public static FastGiftModule_ProvideFastGiftViewFactory create(e r100) {
        return new FastGiftModule_ProvideFastGiftViewFactory(r100);
    }

    public static h provideFastGiftView(e r100) {
        r100.getClass();
        return (h) Preconditions.checkNotNullFromProvides(new d());
    }
}

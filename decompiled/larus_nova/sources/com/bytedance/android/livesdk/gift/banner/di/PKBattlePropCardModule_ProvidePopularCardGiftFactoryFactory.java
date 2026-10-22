package com.bytedance.android.livesdk.gift.banner.di;

import com.bytedance.android.livesdk.gift.platform.business.h;
import cy1.c;
import cy1.d;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes9.dex */
public final class PKBattlePropCardModule_ProvidePopularCardGiftFactoryFactory implements Factory<h.a> {
    private final d module;

    @Override // javax.inject.Provider
    public h.a get() {
        return providePopularCardGiftFactory(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public PKBattlePropCardModule_ProvidePopularCardGiftFactoryFactory(d r100) {
        this.module = r100;
    }

    public static PKBattlePropCardModule_ProvidePopularCardGiftFactoryFactory create(d r100) {
        return new PKBattlePropCardModule_ProvidePopularCardGiftFactoryFactory(r100);
    }

    public static h.a providePopularCardGiftFactory(d r100) {
        r100.getClass();
        return (h.a) Preconditions.checkNotNullFromProvides(new c());
    }
}

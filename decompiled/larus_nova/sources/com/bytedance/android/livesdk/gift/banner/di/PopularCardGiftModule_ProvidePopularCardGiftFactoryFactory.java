package com.bytedance.android.livesdk.gift.banner.di;

import com.bytedance.android.livesdk.gift.platform.business.h;
import cy1.e;
import cy1.f;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes9.dex */
public final class PopularCardGiftModule_ProvidePopularCardGiftFactoryFactory implements Factory<h.a> {
    private final f module;

    @Override // javax.inject.Provider
    public h.a get() {
        return providePopularCardGiftFactory(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public PopularCardGiftModule_ProvidePopularCardGiftFactoryFactory(f r100) {
        this.module = r100;
    }

    public static PopularCardGiftModule_ProvidePopularCardGiftFactoryFactory create(f r100) {
        return new PopularCardGiftModule_ProvidePopularCardGiftFactoryFactory(r100);
    }

    public static h.a providePopularCardGiftFactory(f r100) {
        r100.getClass();
        return (h.a) Preconditions.checkNotNullFromProvides(new e());
    }
}

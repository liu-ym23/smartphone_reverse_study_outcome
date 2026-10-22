package com.bytedance.android.livesdk.gift.banner.di;

import com.bytedance.android.livesdk.gift.platform.business.h;
import cy1.a;
import cy1.b;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes9.dex */
public final class BannerGiftModule_ProvideBannerGiftFactoryFactory implements Factory<h.a> {
    private final b module;

    @Override // javax.inject.Provider
    public h.a get() {
        return provideBannerGiftFactory(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public BannerGiftModule_ProvideBannerGiftFactoryFactory(b r100) {
        this.module = r100;
    }

    public static BannerGiftModule_ProvideBannerGiftFactoryFactory create(b r100) {
        return new BannerGiftModule_ProvideBannerGiftFactoryFactory(r100);
    }

    public static h.a provideBannerGiftFactory(b r100) {
        r100.getClass();
        return (h.a) Preconditions.checkNotNullFromProvides(new a());
    }
}

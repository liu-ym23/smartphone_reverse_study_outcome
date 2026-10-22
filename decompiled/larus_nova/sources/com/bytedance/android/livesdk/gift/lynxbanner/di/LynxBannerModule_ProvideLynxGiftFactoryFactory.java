package com.bytedance.android.livesdk.gift.lynxbanner.di;

import com.bytedance.android.livesdk.gift.platform.business.h;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dz1.a;
import dz1.b;

/* JADX INFO: loaded from: classes9.dex */
public final class LynxBannerModule_ProvideLynxGiftFactoryFactory implements Factory<h.a> {
    private final b module;

    @Override // javax.inject.Provider
    public h.a get() {
        return provideLynxGiftFactory(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public LynxBannerModule_ProvideLynxGiftFactoryFactory(b r100) {
        this.module = r100;
    }

    public static LynxBannerModule_ProvideLynxGiftFactoryFactory create(b r100) {
        return new LynxBannerModule_ProvideLynxGiftFactoryFactory(r100);
    }

    public static h.a provideLynxGiftFactory(b r100) {
        r100.getClass();
        return (h.a) Preconditions.checkNotNullFromProvides(new a());
    }
}

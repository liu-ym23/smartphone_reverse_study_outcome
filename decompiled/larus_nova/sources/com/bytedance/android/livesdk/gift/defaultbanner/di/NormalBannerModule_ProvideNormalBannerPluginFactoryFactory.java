package com.bytedance.android.livesdk.gift.defaultbanner.di;

import com.bytedance.android.livesdk.gift.platform.business.h;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import hy1.a;
import hy1.b;

/* JADX INFO: loaded from: classes9.dex */
public final class NormalBannerModule_ProvideNormalBannerPluginFactoryFactory implements Factory<h.a> {
    private final b module;

    @Override // javax.inject.Provider
    public h.a get() {
        return provideNormalBannerPluginFactory(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public NormalBannerModule_ProvideNormalBannerPluginFactoryFactory(b r100) {
        this.module = r100;
    }

    public static NormalBannerModule_ProvideNormalBannerPluginFactoryFactory create(b r100) {
        return new NormalBannerModule_ProvideNormalBannerPluginFactoryFactory(r100);
    }

    public static h.a provideNormalBannerPluginFactory(b r100) {
        r100.getClass();
        return (h.a) Preconditions.checkNotNullFromProvides(new a());
    }
}

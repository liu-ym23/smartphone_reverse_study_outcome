package com.bytedance.android.livesdk.gift.goods.di;

import com.bytedance.android.livesdk.gift.platform.business.h;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import py1.a;
import py1.b;

/* JADX INFO: loaded from: classes9.dex */
public final class GoodModule_ProvideGoodsPluginFactoryFactory implements Factory<h.a> {
    private final b module;

    @Override // javax.inject.Provider
    public h.a get() {
        return provideGoodsPluginFactory(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public GoodModule_ProvideGoodsPluginFactoryFactory(b r100) {
        this.module = r100;
    }

    public static GoodModule_ProvideGoodsPluginFactoryFactory create(b r100) {
        return new GoodModule_ProvideGoodsPluginFactoryFactory(r100);
    }

    public static h.a provideGoodsPluginFactory(b r100) {
        r100.getClass();
        return (h.a) Preconditions.checkNotNullFromProvides(new a());
    }
}

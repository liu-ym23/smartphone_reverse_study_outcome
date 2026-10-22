package com.bytedance.android.livesdk.gift.redpacket.di;

import com.bytedance.android.livesdk.gift.platform.business.h;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import u12.a;
import u12.b;

/* JADX INFO: loaded from: classes9.dex */
public final class PopularBoxGiftModule_ProvidePopularBoxGiftFactoryFactory implements Factory<h.a> {
    private final b module;

    @Override // javax.inject.Provider
    public h.a get() {
        return providePopularBoxGiftFactory(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public PopularBoxGiftModule_ProvidePopularBoxGiftFactoryFactory(b r100) {
        this.module = r100;
    }

    public static PopularBoxGiftModule_ProvidePopularBoxGiftFactoryFactory create(b r100) {
        return new PopularBoxGiftModule_ProvidePopularBoxGiftFactoryFactory(r100);
    }

    public static h.a providePopularBoxGiftFactory(b r100) {
        r100.getClass();
        return (h.a) Preconditions.checkNotNullFromProvides(new a());
    }
}

package com.bytedance.android.livesdk.gift.redpacket.di;

import com.bytedance.android.livesdk.gift.platform.business.h;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import u12.c;
import u12.d;

/* JADX INFO: loaded from: classes9.dex */
public final class RechargeCouponModule_ProvideRedPacketGiftFactoryFactory implements Factory<h.a> {
    private final d module;

    @Override // javax.inject.Provider
    public h.a get() {
        return provideRedPacketGiftFactory(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public RechargeCouponModule_ProvideRedPacketGiftFactoryFactory(d r100) {
        this.module = r100;
    }

    public static RechargeCouponModule_ProvideRedPacketGiftFactoryFactory create(d r100) {
        return new RechargeCouponModule_ProvideRedPacketGiftFactoryFactory(r100);
    }

    public static h.a provideRedPacketGiftFactory(d r100) {
        r100.getClass();
        return (h.a) Preconditions.checkNotNullFromProvides(new c());
    }
}

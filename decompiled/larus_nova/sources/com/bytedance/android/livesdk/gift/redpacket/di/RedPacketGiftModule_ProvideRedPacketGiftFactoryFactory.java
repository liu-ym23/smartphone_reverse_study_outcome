package com.bytedance.android.livesdk.gift.redpacket.di;

import com.bytedance.android.livesdk.gift.platform.business.h;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import u12.e;
import u12.f;

/* JADX INFO: loaded from: classes9.dex */
public final class RedPacketGiftModule_ProvideRedPacketGiftFactoryFactory implements Factory<h.a> {
    private final f module;

    @Override // javax.inject.Provider
    public h.a get() {
        return provideRedPacketGiftFactory(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public RedPacketGiftModule_ProvideRedPacketGiftFactoryFactory(f r100) {
        this.module = r100;
    }

    public static RedPacketGiftModule_ProvideRedPacketGiftFactoryFactory create(f r100) {
        return new RedPacketGiftModule_ProvideRedPacketGiftFactoryFactory(r100);
    }

    public static h.a provideRedPacketGiftFactory(f r100) {
        r100.getClass();
        return (h.a) Preconditions.checkNotNullFromProvides(new e());
    }
}

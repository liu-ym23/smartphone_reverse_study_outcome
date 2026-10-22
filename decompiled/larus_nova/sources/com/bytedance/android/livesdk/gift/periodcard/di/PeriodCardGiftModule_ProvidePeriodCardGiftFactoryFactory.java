package com.bytedance.android.livesdk.gift.periodcard.di;

import com.bytedance.android.livesdk.gift.platform.business.h;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import jz1.a;
import jz1.b;

/* JADX INFO: loaded from: classes9.dex */
public final class PeriodCardGiftModule_ProvidePeriodCardGiftFactoryFactory implements Factory<h.a> {
    private final b module;

    @Override // javax.inject.Provider
    public h.a get() {
        return providePeriodCardGiftFactory(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public PeriodCardGiftModule_ProvidePeriodCardGiftFactoryFactory(b r100) {
        this.module = r100;
    }

    public static PeriodCardGiftModule_ProvidePeriodCardGiftFactoryFactory create(b r100) {
        return new PeriodCardGiftModule_ProvidePeriodCardGiftFactoryFactory(r100);
    }

    public static h.a providePeriodCardGiftFactory(b r100) {
        r100.getClass();
        return (h.a) Preconditions.checkNotNullFromProvides(new a());
    }
}

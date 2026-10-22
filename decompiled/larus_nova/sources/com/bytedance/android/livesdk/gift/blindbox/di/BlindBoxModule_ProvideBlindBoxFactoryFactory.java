package com.bytedance.android.livesdk.gift.blindbox.di;

import com.bytedance.android.livesdk.gift.platform.business.h;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import ey1.a;
import ey1.b;

/* JADX INFO: loaded from: classes9.dex */
public final class BlindBoxModule_ProvideBlindBoxFactoryFactory implements Factory<h.a> {
    private final b module;

    @Override // javax.inject.Provider
    public h.a get() {
        return provideBlindBoxFactory(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public BlindBoxModule_ProvideBlindBoxFactoryFactory(b r100) {
        this.module = r100;
    }

    public static BlindBoxModule_ProvideBlindBoxFactoryFactory create(b r100) {
        return new BlindBoxModule_ProvideBlindBoxFactoryFactory(r100);
    }

    public static h.a provideBlindBoxFactory(b r100) {
        r100.getClass();
        return (h.a) Preconditions.checkNotNullFromProvides(new a());
    }
}

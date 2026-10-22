package com.bytedance.android.live.revenue.service.recharge.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import q01.a;

/* JADX INFO: loaded from: classes47.dex */
public final class RechargeServiceModule_ProvideRegistrarFactory implements Factory<a> {
    private final z01.a module;

    @Override // javax.inject.Provider
    public a get() {
        return provideRegistrar(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public RechargeServiceModule_ProvideRegistrarFactory(z01.a r100) {
        this.module = r100;
    }

    public static RechargeServiceModule_ProvideRegistrarFactory create(z01.a r100) {
        return new RechargeServiceModule_ProvideRegistrarFactory(r100);
    }

    public static a provideRegistrar(z01.a r100) {
        r100.getClass();
        return (a) Preconditions.checkNotNullFromProvides(new y01.a());
    }
}

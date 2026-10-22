package com.bytedance.android.live.revenue.service.gift.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import q01.a;
import s01.b;

/* JADX INFO: loaded from: classes47.dex */
public final class GiftServiceModule_ProvideRegistrarFactory implements Factory<a> {
    private final t01.a module;

    @Override // javax.inject.Provider
    public a get() {
        return provideRegistrar(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public GiftServiceModule_ProvideRegistrarFactory(t01.a r100) {
        this.module = r100;
    }

    public static GiftServiceModule_ProvideRegistrarFactory create(t01.a r100) {
        return new GiftServiceModule_ProvideRegistrarFactory(r100);
    }

    public static a provideRegistrar(t01.a r100) {
        r100.getClass();
        return (a) Preconditions.checkNotNullFromProvides(new b());
    }
}

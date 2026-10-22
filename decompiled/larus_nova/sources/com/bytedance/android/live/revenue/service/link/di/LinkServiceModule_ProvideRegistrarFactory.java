package com.bytedance.android.live.revenue.service.link.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import q01.a;
import v01.b;

/* JADX INFO: loaded from: classes47.dex */
public final class LinkServiceModule_ProvideRegistrarFactory implements Factory<a> {
    private final v01.a module;

    @Override // javax.inject.Provider
    public a get() {
        return provideRegistrar(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public LinkServiceModule_ProvideRegistrarFactory(v01.a r100) {
        this.module = r100;
    }

    public static LinkServiceModule_ProvideRegistrarFactory create(v01.a r100) {
        return new LinkServiceModule_ProvideRegistrarFactory(r100);
    }

    public static a provideRegistrar(v01.a r100) {
        r100.getClass();
        return (a) Preconditions.checkNotNullFromProvides(new b());
    }
}

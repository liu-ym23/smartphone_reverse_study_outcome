package com.bytedance.android.ec.diff.lib.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import gi.c;
import hi.a;
import hi.b;

/* JADX INFO: loaded from: classes43.dex */
public final class ToCServiceModule_ProvideTuringFactory implements Factory<a> {
    private final c module;

    @Override // javax.inject.Provider
    public a get() {
        return provideInstance(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ToCServiceModule_ProvideTuringFactory(c r100) {
        this.module = r100;
    }

    public static ToCServiceModule_ProvideTuringFactory create(c r100) {
        return new ToCServiceModule_ProvideTuringFactory(r100);
    }

    public static a provideInstance(c r100) {
        return proxyProvideTuring(r100);
    }

    public static a proxyProvideTuring(c r100) {
        r100.getClass();
        return (a) Preconditions.checkNotNull(b.f485260a, "Cannot return null from a non-@Nullable @Provides method");
    }
}

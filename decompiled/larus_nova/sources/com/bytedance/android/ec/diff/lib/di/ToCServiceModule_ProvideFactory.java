package com.bytedance.android.ec.diff.lib.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import fi.a;
import fi.b;
import gi.c;

/* JADX INFO: loaded from: classes43.dex */
public final class ToCServiceModule_ProvideFactory implements Factory<b> {
    private final c module;

    @Override // javax.inject.Provider
    public b get() {
        return provideInstance(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ToCServiceModule_ProvideFactory(c r100) {
        this.module = r100;
    }

    public static ToCServiceModule_ProvideFactory create(c r100) {
        return new ToCServiceModule_ProvideFactory(r100);
    }

    public static b provideInstance(c r100) {
        return proxyProvide(r100);
    }

    public static b proxyProvide(c r100) {
        r100.getClass();
        return (b) Preconditions.checkNotNull(a.f477219b, "Cannot return null from a non-@Nullable @Provides method");
    }
}

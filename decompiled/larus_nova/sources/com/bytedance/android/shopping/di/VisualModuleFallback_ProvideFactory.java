package com.bytedance.android.shopping.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import gd3.o;
import gd3.p;
import n83.i;

/* JADX INFO: loaded from: classes13.dex */
public final class VisualModuleFallback_ProvideFactory implements Factory<i> {
    private final p module;

    @Override // javax.inject.Provider
    public i get() {
        return provideInstance(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public VisualModuleFallback_ProvideFactory(p r100) {
        this.module = r100;
    }

    public static VisualModuleFallback_ProvideFactory create(p r100) {
        return new VisualModuleFallback_ProvideFactory(r100);
    }

    public static i provideInstance(p r100) {
        return proxyProvide(r100);
    }

    public static i proxyProvide(p r100) {
        r100.getClass();
        return (i) Preconditions.checkNotNull(new o(), "Cannot return null from a non-@Nullable @Provides method");
    }
}

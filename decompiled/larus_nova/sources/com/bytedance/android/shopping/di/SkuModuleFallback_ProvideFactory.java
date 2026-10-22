package com.bytedance.android.shopping.di;

import dagger.internal.Factory;
import gd3.n;
import sc3.i;

/* JADX INFO: loaded from: classes13.dex */
public final class SkuModuleFallback_ProvideFactory implements Factory<i> {
    private final n module;

    @Override // javax.inject.Provider
    public i get() {
        return provideInstance(null);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public SkuModuleFallback_ProvideFactory(n r100) {
    }

    public static SkuModuleFallback_ProvideFactory create(n r100) {
        return new SkuModuleFallback_ProvideFactory(r100);
    }

    public static i provideInstance(n r100) {
        return proxyProvide(r100);
    }

    public static i proxyProvide(n r100) {
        throw null;
    }
}

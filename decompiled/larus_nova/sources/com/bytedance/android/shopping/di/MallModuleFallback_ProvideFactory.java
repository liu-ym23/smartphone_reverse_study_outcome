package com.bytedance.android.shopping.di;

import dagger.internal.Factory;
import gd3.k;
import n83.h;

/* JADX INFO: loaded from: classes13.dex */
public final class MallModuleFallback_ProvideFactory implements Factory<h> {
    private final k module;

    @Override // javax.inject.Provider
    public h get() {
        return provideInstance(null);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public MallModuleFallback_ProvideFactory(k r100) {
    }

    public static MallModuleFallback_ProvideFactory create(k r100) {
        return new MallModuleFallback_ProvideFactory(r100);
    }

    public static h provideInstance(k r100) {
        return proxyProvide(r100);
    }

    public static h proxyProvide(k r100) {
        throw null;
    }
}

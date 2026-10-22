package com.bytedance.android.shopping.di;

import dagger.internal.Factory;
import gd3.h;
import sc3.g;

/* JADX INFO: loaded from: classes13.dex */
public final class CollectModuleFallback_ProvideFactory implements Factory<g> {
    private final h module;

    @Override // javax.inject.Provider
    public g get() {
        return provideInstance(null);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public CollectModuleFallback_ProvideFactory(h r100) {
    }

    public static CollectModuleFallback_ProvideFactory create(h r100) {
        return new CollectModuleFallback_ProvideFactory(r100);
    }

    public static g provideInstance(h r100) {
        return proxyProvide(r100);
    }

    public static g proxyProvide(h r100) {
        throw null;
    }
}

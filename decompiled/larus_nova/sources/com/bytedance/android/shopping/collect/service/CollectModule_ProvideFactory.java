package com.bytedance.android.shopping.collect.service;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import rb3.a;
import rb3.b;
import sc3.g;

/* JADX INFO: loaded from: classes13.dex */
public final class CollectModule_ProvideFactory implements Factory<g> {
    private final a module;

    @Override // javax.inject.Provider
    public g get() {
        return provideInstance(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public CollectModule_ProvideFactory(a r100) {
        this.module = r100;
    }

    public static CollectModule_ProvideFactory create(a r100) {
        return new CollectModule_ProvideFactory(r100);
    }

    public static g provideInstance(a r100) {
        return proxyProvide(r100);
    }

    public static g proxyProvide(a r100) {
        r100.getClass();
        return (g) Preconditions.checkNotNull(new b(), "Cannot return null from a non-@Nullable @Provides method");
    }
}

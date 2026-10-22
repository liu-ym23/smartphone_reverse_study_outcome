package com.bytedance.android.shopping.di;

import dagger.internal.Factory;
import gd3.l;
import sc3.h;

/* JADX INFO: loaded from: classes13.dex */
public final class OrderListModuleFallback_ProvideFactory implements Factory<h> {
    private final l module;

    @Override // javax.inject.Provider
    public h get() {
        return provideInstance(null);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public OrderListModuleFallback_ProvideFactory(l r100) {
    }

    public static OrderListModuleFallback_ProvideFactory create(l r100) {
        return new OrderListModuleFallback_ProvideFactory(r100);
    }

    public static h provideInstance(l r100) {
        return proxyProvide(r100);
    }

    public static h proxyProvide(l r100) {
        throw null;
    }
}

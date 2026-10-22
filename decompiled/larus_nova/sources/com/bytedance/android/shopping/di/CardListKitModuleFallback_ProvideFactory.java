package com.bytedance.android.shopping.di;

import dagger.internal.Factory;
import gd3.f;
import sc3.d;

/* JADX INFO: loaded from: classes13.dex */
public final class CardListKitModuleFallback_ProvideFactory implements Factory<d> {
    private final f module;

    @Override // javax.inject.Provider
    public d get() {
        return provideInstance(null);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public CardListKitModuleFallback_ProvideFactory(f r100) {
    }

    public static CardListKitModuleFallback_ProvideFactory create(f r100) {
        return new CardListKitModuleFallback_ProvideFactory(r100);
    }

    public static d provideInstance(f r100) {
        return proxyProvide(r100);
    }

    public static d proxyProvide(f r100) {
        throw null;
    }
}

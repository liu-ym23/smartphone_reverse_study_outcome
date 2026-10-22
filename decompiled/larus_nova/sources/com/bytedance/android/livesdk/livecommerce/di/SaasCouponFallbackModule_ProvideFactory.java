package com.bytedance.android.livesdk.livecommerce.di;

import dagger.internal.Factory;
import el2.n;
import hh2.h;

/* JADX INFO: loaded from: classes10.dex */
public final class SaasCouponFallbackModule_ProvideFactory implements Factory<n> {
    private final h module;

    @Override // javax.inject.Provider
    public n get() {
        return provideInstance(null);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public SaasCouponFallbackModule_ProvideFactory(h r100) {
    }

    public static SaasCouponFallbackModule_ProvideFactory create(h r100) {
        return new SaasCouponFallbackModule_ProvideFactory(r100);
    }

    public static n provideInstance(h r100) {
        return proxyProvide(r100);
    }

    public static n proxyProvide(h r100) {
        throw null;
    }
}

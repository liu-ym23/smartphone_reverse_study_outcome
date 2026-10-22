package com.bytedance.android.ec.innerflow;

import dagger.internal.Factory;
import qk.b;

/* JADX INFO: loaded from: classes44.dex */
public final class InflowServiceModule_ProvideFactory implements Factory<b> {
    private final pk.b module;

    @Override // javax.inject.Provider
    public b get() {
        return provideInstance(null);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public InflowServiceModule_ProvideFactory(pk.b r100) {
    }

    public static InflowServiceModule_ProvideFactory create(pk.b r100) {
        return new InflowServiceModule_ProvideFactory(r100);
    }

    public static b provideInstance(pk.b r100) {
        return proxyProvide(r100);
    }

    public static b proxyProvide(pk.b r100) {
        throw null;
    }
}

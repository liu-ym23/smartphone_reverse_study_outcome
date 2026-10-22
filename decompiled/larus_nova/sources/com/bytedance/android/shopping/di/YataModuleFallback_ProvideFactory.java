package com.bytedance.android.shopping.di;

import dagger.internal.Factory;
import gd3.q;
import sc3.j;

/* JADX INFO: loaded from: classes13.dex */
public final class YataModuleFallback_ProvideFactory implements Factory<j> {
    private final q module;

    @Override // javax.inject.Provider
    public j get() {
        return provideInstance(null);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public YataModuleFallback_ProvideFactory(q r100) {
    }

    public static YataModuleFallback_ProvideFactory create(q r100) {
        return new YataModuleFallback_ProvideFactory(r100);
    }

    public static j provideInstance(q r100) {
        return proxyProvide(r100);
    }

    public static j proxyProvide(q r100) {
        throw null;
    }
}

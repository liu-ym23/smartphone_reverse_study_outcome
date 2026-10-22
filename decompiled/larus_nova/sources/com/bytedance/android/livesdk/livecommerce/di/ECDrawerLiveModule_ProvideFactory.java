package com.bytedance.android.livesdk.livecommerce.di;

import dagger.internal.Factory;
import el2.h;
import hh2.b;

/* JADX INFO: loaded from: classes10.dex */
public final class ECDrawerLiveModule_ProvideFactory implements Factory<h> {
    private final b module;

    @Override // javax.inject.Provider
    public h get() {
        return provideInstance(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ECDrawerLiveModule_ProvideFactory(b r100) {
        this.module = r100;
    }

    public static ECDrawerLiveModule_ProvideFactory create(b r100) {
        return new ECDrawerLiveModule_ProvideFactory(r100);
    }

    public static h provideInstance(b r100) {
        return proxyProvide(r100);
    }

    public static h proxyProvide(b r100) {
        r100.getClass();
        return null;
    }
}

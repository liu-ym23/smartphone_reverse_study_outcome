package com.bytedance.android.livesdk.livecommerce.di;

import dagger.internal.Factory;
import hh2.d;
import sg2.w;

/* JADX INFO: loaded from: classes10.dex */
public final class IronListMissionFallbackModule_ProvideFactory implements Factory<w> {
    private final d module;

    @Override // javax.inject.Provider
    public w get() {
        return provideInstance(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public IronListMissionFallbackModule_ProvideFactory(d r100) {
        this.module = r100;
    }

    public static IronListMissionFallbackModule_ProvideFactory create(d r100) {
        return new IronListMissionFallbackModule_ProvideFactory(r100);
    }

    public static w provideInstance(d r100) {
        return proxyProvide(r100);
    }

    public static w proxyProvide(d r100) {
        r100.getClass();
        return null;
    }
}

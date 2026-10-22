package com.bytedance.android.live.browser.di;

import com.bytedance.android.live.browser.jsbridge.g;
import com.bytedance.android.live.browser.jsbridge.prefetch.i;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import s20.f;

/* JADX INFO: loaded from: classes45.dex */
public final class JsBridgeModule_ProvideLocalPrefetchConfigFactory implements Factory<g> {
    private final f module;

    @Override // javax.inject.Provider
    public g get() {
        return provideLocalPrefetchConfig(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public JsBridgeModule_ProvideLocalPrefetchConfigFactory(f r100) {
        this.module = r100;
    }

    public static JsBridgeModule_ProvideLocalPrefetchConfigFactory create(f r100) {
        return new JsBridgeModule_ProvideLocalPrefetchConfigFactory(r100);
    }

    public static g provideLocalPrefetchConfig(f r100) {
        r100.getClass();
        return (g) Preconditions.checkNotNullFromProvides(new i());
    }
}

package com.bytedance.android.live.browser.di;

import com.bytedance.android.live.browser.jsbridge.g;
import com.bytedance.android.live.browser.jsbridge.prefetch.j;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import s20.f;

/* JADX INFO: loaded from: classes45.dex */
public final class JsBridgeModule_ProvidePrefetchConfigFactory implements Factory<g> {
    private final f module;

    @Override // javax.inject.Provider
    public g get() {
        return providePrefetchConfig(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public JsBridgeModule_ProvidePrefetchConfigFactory(f r100) {
        this.module = r100;
    }

    public static JsBridgeModule_ProvidePrefetchConfigFactory create(f r100) {
        return new JsBridgeModule_ProvidePrefetchConfigFactory(r100);
    }

    public static g providePrefetchConfig(f r100) {
        r100.getClass();
        return (g) Preconditions.checkNotNullFromProvides(new j());
    }
}

package com.bytedance.android.live.browser.di;

import com.bytedance.android.live.browser.jsbridge.h;
import com.bytedance.android.live.browser.jsbridge.prefetch.LivePrefetchProcessor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import s20.f;

/* JADX INFO: loaded from: classes45.dex */
public final class JsBridgeModule_ProvideWebPrefetchProcessorFactory implements Factory<h> {
    private final f module;

    @Override // javax.inject.Provider
    public h get() {
        return provideWebPrefetchProcessor(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public JsBridgeModule_ProvideWebPrefetchProcessorFactory(f r100) {
        this.module = r100;
    }

    public static JsBridgeModule_ProvideWebPrefetchProcessorFactory create(f r100) {
        return new JsBridgeModule_ProvideWebPrefetchProcessorFactory(r100);
    }

    public static h provideWebPrefetchProcessor(f r100) {
        r100.getClass();
        return (h) Preconditions.checkNotNullFromProvides(new LivePrefetchProcessor());
    }
}

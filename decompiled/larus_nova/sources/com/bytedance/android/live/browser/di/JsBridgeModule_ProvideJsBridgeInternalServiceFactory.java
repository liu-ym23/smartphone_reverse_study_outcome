package com.bytedance.android.live.browser.di;

import com.bytedance.android.live.browser.jsbridge.JsBridgeService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import s20.f;

/* JADX INFO: loaded from: classes45.dex */
public final class JsBridgeModule_ProvideJsBridgeInternalServiceFactory implements Factory<JsBridgeService> {
    private final f module;

    @Override // javax.inject.Provider
    public JsBridgeService get() {
        return provideJsBridgeInternalService(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public JsBridgeModule_ProvideJsBridgeInternalServiceFactory(f r100) {
        this.module = r100;
    }

    public static JsBridgeModule_ProvideJsBridgeInternalServiceFactory create(f r100) {
        return new JsBridgeModule_ProvideJsBridgeInternalServiceFactory(r100);
    }

    public static JsBridgeService provideJsBridgeInternalService(f r100) {
        r100.getClass();
        return (JsBridgeService) Preconditions.checkNotNullFromProvides(new JsBridgeService());
    }
}

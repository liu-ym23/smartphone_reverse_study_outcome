package com.bytedance.android.live.browser.di;

import com.bytedance.android.live.browser.w;
import dagger.internal.Factory;
import s20.g;

/* JADX INFO: loaded from: classes45.dex */
public final class LiveLynxModuleFallback_ProvideLynxServiceFactory implements Factory<w> {
    private final g module;

    @Override // javax.inject.Provider
    public w get() {
        return provideLynxService(null);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public LiveLynxModuleFallback_ProvideLynxServiceFactory(g r100) {
    }

    public static LiveLynxModuleFallback_ProvideLynxServiceFactory create(g r100) {
        return new LiveLynxModuleFallback_ProvideLynxServiceFactory(r100);
    }

    public static w provideLynxService(g r100) {
        throw null;
    }
}

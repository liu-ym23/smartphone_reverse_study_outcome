package com.bytedance.android.live.openplatform.impl.base.di;

import dagger.internal.Factory;
import po0.b;
import so0.a;

/* JADX INFO: loaded from: classes46.dex */
public final class MiniAppAnchorModuleFallback_ProvideMiniAppAnchorServiceFactory implements Factory<a> {
    private final b module;

    @Override // javax.inject.Provider
    public a get() {
        return provideMiniAppAnchorService(null);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public MiniAppAnchorModuleFallback_ProvideMiniAppAnchorServiceFactory(b r100) {
    }

    public static MiniAppAnchorModuleFallback_ProvideMiniAppAnchorServiceFactory create(b r100) {
        return new MiniAppAnchorModuleFallback_ProvideMiniAppAnchorServiceFactory(r100);
    }

    public static a provideMiniAppAnchorService(b r100) {
        throw null;
    }
}

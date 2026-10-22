package com.bytedance.android.live.openplatform.impl.base.di;

import dagger.internal.Factory;
import po0.c;
import vo0.a;

/* JADX INFO: loaded from: classes46.dex */
public final class MiniGameAnchorModuleFallback_ProvideMiniGameAnchorServiceFactory implements Factory<a> {
    private final c module;

    @Override // javax.inject.Provider
    public a get() {
        return provideMiniGameAnchorService(null);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public MiniGameAnchorModuleFallback_ProvideMiniGameAnchorServiceFactory(c r100) {
    }

    public static MiniGameAnchorModuleFallback_ProvideMiniGameAnchorServiceFactory create(c r100) {
        return new MiniGameAnchorModuleFallback_ProvideMiniGameAnchorServiceFactory(r100);
    }

    public static a provideMiniGameAnchorService(c r100) {
        throw null;
    }
}

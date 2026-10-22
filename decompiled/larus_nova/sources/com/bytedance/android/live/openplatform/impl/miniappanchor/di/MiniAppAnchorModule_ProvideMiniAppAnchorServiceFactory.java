package com.bytedance.android.live.openplatform.impl.miniappanchor.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import so0.a;

/* JADX INFO: loaded from: classes46.dex */
public final class MiniAppAnchorModule_ProvideMiniAppAnchorServiceFactory implements Factory<a> {
    private final qp0.a module;

    @Override // javax.inject.Provider
    public a get() {
        return provideMiniAppAnchorService(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public MiniAppAnchorModule_ProvideMiniAppAnchorServiceFactory(qp0.a r100) {
        this.module = r100;
    }

    public static MiniAppAnchorModule_ProvideMiniAppAnchorServiceFactory create(qp0.a r100) {
        return new MiniAppAnchorModule_ProvideMiniAppAnchorServiceFactory(r100);
    }

    public static a provideMiniAppAnchorService(qp0.a r100) {
        r100.getClass();
        return (a) Preconditions.checkNotNullFromProvides(new bp0.a());
    }
}

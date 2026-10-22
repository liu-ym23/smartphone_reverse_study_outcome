package com.bytedance.android.live.openplatform.impl.minigameanchor.di;

import com.bytedance.android.live.openplatform.impl.minigameanchor.MiniGameAnchorServiceImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import vo0.a;

/* JADX INFO: loaded from: classes46.dex */
public final class MiniGameAnchorModule_ProvideMiniGameAnchorServiceFactory implements Factory<a> {
    private final ar0.a module;

    @Override // javax.inject.Provider
    public a get() {
        return provideMiniGameAnchorService(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public MiniGameAnchorModule_ProvideMiniGameAnchorServiceFactory(ar0.a r100) {
        this.module = r100;
    }

    public static MiniGameAnchorModule_ProvideMiniGameAnchorServiceFactory create(ar0.a r100) {
        return new MiniGameAnchorModule_ProvideMiniGameAnchorServiceFactory(r100);
    }

    public static a provideMiniGameAnchorService(ar0.a r100) {
        r100.getClass();
        return (a) Preconditions.checkNotNullFromProvides(new MiniGameAnchorServiceImpl());
    }
}

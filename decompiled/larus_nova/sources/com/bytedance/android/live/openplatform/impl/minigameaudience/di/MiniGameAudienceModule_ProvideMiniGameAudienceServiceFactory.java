package com.bytedance.android.live.openplatform.impl.minigameaudience.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import er0.b;
import wo0.a;

/* JADX INFO: loaded from: classes46.dex */
public final class MiniGameAudienceModule_ProvideMiniGameAudienceServiceFactory implements Factory<a> {
    private final hr0.a module;

    @Override // javax.inject.Provider
    public a get() {
        return provideMiniGameAudienceService(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public MiniGameAudienceModule_ProvideMiniGameAudienceServiceFactory(hr0.a r100) {
        this.module = r100;
    }

    public static MiniGameAudienceModule_ProvideMiniGameAudienceServiceFactory create(hr0.a r100) {
        return new MiniGameAudienceModule_ProvideMiniGameAudienceServiceFactory(r100);
    }

    public static a provideMiniGameAudienceService(hr0.a r100) {
        r100.getClass();
        return (a) Preconditions.checkNotNullFromProvides(new b());
    }
}

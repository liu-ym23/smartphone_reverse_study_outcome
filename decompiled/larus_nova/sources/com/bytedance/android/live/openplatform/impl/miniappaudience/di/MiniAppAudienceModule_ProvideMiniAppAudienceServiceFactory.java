package com.bytedance.android.live.openplatform.impl.miniappaudience.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import to0.a;

/* JADX INFO: loaded from: classes46.dex */
public final class MiniAppAudienceModule_ProvideMiniAppAudienceServiceFactory implements Factory<a> {
    private final jq0.a module;

    @Override // javax.inject.Provider
    public a get() {
        return provideMiniAppAudienceService(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public MiniAppAudienceModule_ProvideMiniAppAudienceServiceFactory(jq0.a r100) {
        this.module = r100;
    }

    public static MiniAppAudienceModule_ProvideMiniAppAudienceServiceFactory create(jq0.a r100) {
        return new MiniAppAudienceModule_ProvideMiniAppAudienceServiceFactory(r100);
    }

    public static a provideMiniAppAudienceService(jq0.a r100) {
        r100.getClass();
        return (a) Preconditions.checkNotNullFromProvides(new fq0.a());
    }
}

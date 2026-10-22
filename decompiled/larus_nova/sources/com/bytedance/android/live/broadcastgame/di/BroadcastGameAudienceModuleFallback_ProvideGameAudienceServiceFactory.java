package com.bytedance.android.live.broadcastgame.di;

import com.bytedance.android.live.broadcastgame.api.f;
import dagger.internal.Factory;
import i10.d;

/* JADX INFO: loaded from: classes45.dex */
public final class BroadcastGameAudienceModuleFallback_ProvideGameAudienceServiceFactory implements Factory<f> {
    private final d module;

    @Override // javax.inject.Provider
    public f get() {
        return provideGameAudienceService(null);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public BroadcastGameAudienceModuleFallback_ProvideGameAudienceServiceFactory(d r100) {
    }

    public static BroadcastGameAudienceModuleFallback_ProvideGameAudienceServiceFactory create(d r100) {
        return new BroadcastGameAudienceModuleFallback_ProvideGameAudienceServiceFactory(r100);
    }

    public static f provideGameAudienceService(d r100) {
        throw null;
    }
}

package com.bytedance.android.live.broadcastgame.di;

import com.bytedance.android.live.broadcastgame.api.f;
import com.bytedance.android.live.broadcastgame.y;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import i10.c;

/* JADX INFO: loaded from: classes45.dex */
public final class BroadcastGameAudienceModule_ProvideGameAudienceServiceFactory implements Factory<f> {
    private final c module;

    @Override // javax.inject.Provider
    public f get() {
        return provideGameAudienceService(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public BroadcastGameAudienceModule_ProvideGameAudienceServiceFactory(c r100) {
        this.module = r100;
    }

    public static BroadcastGameAudienceModule_ProvideGameAudienceServiceFactory create(c r100) {
        return new BroadcastGameAudienceModule_ProvideGameAudienceServiceFactory(r100);
    }

    public static f provideGameAudienceService(c r100) {
        r100.getClass();
        return (f) Preconditions.checkNotNullFromProvides(new y());
    }
}

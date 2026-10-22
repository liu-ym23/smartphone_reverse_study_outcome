package com.bytedance.android.live.broadcastgame.di;

import com.bytedance.android.live.broadcastgame.api.e;
import com.bytedance.android.live.broadcastgame.x;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import i10.b;

/* JADX INFO: loaded from: classes45.dex */
public final class BroadcastGameAnchorModule_ProvideGameAnchorServiceFactory implements Factory<e> {
    private final b module;

    @Override // javax.inject.Provider
    public e get() {
        return provideGameAnchorService(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public BroadcastGameAnchorModule_ProvideGameAnchorServiceFactory(b r100) {
        this.module = r100;
    }

    public static BroadcastGameAnchorModule_ProvideGameAnchorServiceFactory create(b r100) {
        return new BroadcastGameAnchorModule_ProvideGameAnchorServiceFactory(r100);
    }

    public static e provideGameAnchorService(b r100) {
        r100.getClass();
        return (e) Preconditions.checkNotNullFromProvides(new x());
    }
}

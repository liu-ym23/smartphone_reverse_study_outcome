package com.bytedance.android.live.broadcastgame.di;

import com.bytedance.android.live.broadcastgame.api.d;
import dagger.internal.Factory;
import i10.a;

/* JADX INFO: loaded from: classes45.dex */
public final class BdpLiveModuleFallback_ProvideBdpRegisterServiceFactory implements Factory<d> {
    private final a module;

    @Override // javax.inject.Provider
    public d get() {
        return provideBdpRegisterService(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public BdpLiveModuleFallback_ProvideBdpRegisterServiceFactory(a r100) {
        this.module = r100;
    }

    public static BdpLiveModuleFallback_ProvideBdpRegisterServiceFactory create(a r100) {
        return new BdpLiveModuleFallback_ProvideBdpRegisterServiceFactory(r100);
    }

    public static d provideBdpRegisterService(a r100) {
        r100.getClass();
        return null;
    }
}

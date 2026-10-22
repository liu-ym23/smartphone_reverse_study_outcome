package com.bytedance.android.livesdk.livecommerce.crossplatform.saas;

import com.bytedance.android.livesdk.livecommerce.router.d;
import dagger.internal.Factory;
import gh2.a;

/* JADX INFO: loaded from: classes10.dex */
public final class LiveLynxRouterModule_ProvideFactory implements Factory<d> {
    private final a module;

    @Override // javax.inject.Provider
    public d get() {
        provideInstance(this.module);
        return null;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        get();
        return null;
    }

    public LiveLynxRouterModule_ProvideFactory(a r100) {
        this.module = r100;
    }

    public static LiveLynxRouterModule_ProvideFactory create(a r100) {
        return new LiveLynxRouterModule_ProvideFactory(r100);
    }

    public static d provideInstance(a r100) {
        proxyProvide(r100);
        return null;
    }

    public static d proxyProvide(a r100) {
        r100.getClass();
        return null;
    }
}

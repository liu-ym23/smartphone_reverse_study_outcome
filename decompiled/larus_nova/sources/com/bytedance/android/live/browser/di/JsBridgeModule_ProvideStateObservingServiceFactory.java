package com.bytedance.android.live.browser.di;

import com.bytedance.android.live.browser.jsbridge.state.StateObservingService;
import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import s20.f;

/* JADX INFO: loaded from: classes45.dex */
public final class JsBridgeModule_ProvideStateObservingServiceFactory implements Factory<StateObservingService> {
    private final Provider<Gson> gsonProvider;
    private final f module;

    @Override // javax.inject.Provider
    public StateObservingService get() {
        return provideStateObservingService(this.module, this.gsonProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public JsBridgeModule_ProvideStateObservingServiceFactory(f r100, Provider<Gson> r101) {
        this.module = r100;
        this.gsonProvider = r101;
    }

    public static JsBridgeModule_ProvideStateObservingServiceFactory create(f r100, Provider<Gson> r101) {
        return new JsBridgeModule_ProvideStateObservingServiceFactory(r100, r101);
    }

    public static StateObservingService provideStateObservingService(f r100, Gson r101) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "gson");
        return (StateObservingService) Preconditions.checkNotNullFromProvides(new StateObservingService(r101));
    }
}

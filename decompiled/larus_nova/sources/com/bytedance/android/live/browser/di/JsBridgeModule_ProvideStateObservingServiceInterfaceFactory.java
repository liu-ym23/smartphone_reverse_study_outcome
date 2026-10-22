package com.bytedance.android.live.browser.di;

import com.bytedance.android.live.browser.jsbridge.i;
import com.bytedance.android.live.browser.jsbridge.state.StateObservingService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import s20.f;

/* JADX INFO: loaded from: classes45.dex */
public final class JsBridgeModule_ProvideStateObservingServiceInterfaceFactory implements Factory<i> {
    private final f module;
    private final Provider<StateObservingService> stateObservingServiceProvider;

    @Override // javax.inject.Provider
    public i get() {
        return provideStateObservingServiceInterface(this.module, this.stateObservingServiceProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public JsBridgeModule_ProvideStateObservingServiceInterfaceFactory(f r100, Provider<StateObservingService> r101) {
        this.module = r100;
        this.stateObservingServiceProvider = r101;
    }

    public static JsBridgeModule_ProvideStateObservingServiceInterfaceFactory create(f r100, Provider<StateObservingService> r101) {
        return new JsBridgeModule_ProvideStateObservingServiceInterfaceFactory(r100, r101);
    }

    public static i provideStateObservingServiceInterface(f r100, StateObservingService r101) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "stateObservingService");
        return (i) Preconditions.checkNotNullFromProvides(r101);
    }
}

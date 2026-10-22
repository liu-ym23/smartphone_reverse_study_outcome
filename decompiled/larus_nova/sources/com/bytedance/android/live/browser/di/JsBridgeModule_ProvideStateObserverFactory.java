package com.bytedance.android.live.browser.di;

import com.bytedance.android.live.browser.jsbridge.i;
import com.bytedance.android.live.browser.jsbridge.state.StateObserver;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import s20.f;

/* JADX INFO: loaded from: classes45.dex */
public final class JsBridgeModule_ProvideStateObserverFactory implements Factory<i.d> {
    private final f module;

    @Override // javax.inject.Provider
    public i.d get() {
        return provideStateObserver(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public JsBridgeModule_ProvideStateObserverFactory(f r100) {
        this.module = r100;
    }

    public static JsBridgeModule_ProvideStateObserverFactory create(f r100) {
        return new JsBridgeModule_ProvideStateObserverFactory(r100);
    }

    public static i.d provideStateObserver(f r100) {
        r100.getClass();
        return (i.d) Preconditions.checkNotNullFromProvides(new StateObserver());
    }
}

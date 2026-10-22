package com.bytedance.android.live.lynx.di;

import com.bytedance.android.live.browser.w;
import com.bytedance.android.live.lynx.d;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import ml0.a;

/* JADX INFO: loaded from: classes46.dex */
public final class LiveLynxModule_ProvideLynxServiceFactory implements Factory<w> {
    private final a module;

    @Override // javax.inject.Provider
    public w get() {
        return provideLynxService(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public LiveLynxModule_ProvideLynxServiceFactory(a r100) {
        this.module = r100;
    }

    public static LiveLynxModule_ProvideLynxServiceFactory create(a r100) {
        return new LiveLynxModule_ProvideLynxServiceFactory(r100);
    }

    public static w provideLynxService(a r100) {
        r100.getClass();
        return (w) Preconditions.checkNotNullFromProvides(new d());
    }
}

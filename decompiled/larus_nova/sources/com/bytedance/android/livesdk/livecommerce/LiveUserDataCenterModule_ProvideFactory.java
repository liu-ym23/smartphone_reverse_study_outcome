package com.bytedance.android.livesdk.livecommerce;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import sg2.b0;
import sg2.d0;
import sg2.y;

/* JADX INFO: loaded from: classes10.dex */
public final class LiveUserDataCenterModule_ProvideFactory implements Factory<y> {
    private final d0 module;

    @Override // javax.inject.Provider
    public y get() {
        return provideInstance(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public LiveUserDataCenterModule_ProvideFactory(d0 r100) {
        this.module = r100;
    }

    public static LiveUserDataCenterModule_ProvideFactory create(d0 r100) {
        return new LiveUserDataCenterModule_ProvideFactory(r100);
    }

    public static y provideInstance(d0 r100) {
        return proxyProvide(r100);
    }

    public static y proxyProvide(d0 r100) {
        r100.getClass();
        return (y) Preconditions.checkNotNull(new b0(), "Cannot return null from a non-@Nullable @Provides method");
    }
}

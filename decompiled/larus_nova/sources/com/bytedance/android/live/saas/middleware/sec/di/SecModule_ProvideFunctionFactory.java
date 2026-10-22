package com.bytedance.android.live.saas.middleware.sec.di;

import com.bytedance.android.live.saas.middleware.base.BaseFunction;
import com.bytedance.android.live.saas.middleware.sec.ISecSdk;
import com.bytedance.android.live.saas.middleware.sec.SecConfig;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes47.dex */
public final class SecModule_ProvideFunctionFactory implements Factory<BaseFunction<ISecSdk, SecConfig>> {
    private final SecModule module;

    @Override // javax.inject.Provider
    public BaseFunction<ISecSdk, SecConfig> get() {
        return provideFunction(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public SecModule_ProvideFunctionFactory(SecModule r100) {
        this.module = r100;
    }

    public static SecModule_ProvideFunctionFactory create(SecModule r100) {
        return new SecModule_ProvideFunctionFactory(r100);
    }

    public static BaseFunction<ISecSdk, SecConfig> provideFunction(SecModule r100) {
        return (BaseFunction) Preconditions.checkNotNullFromProvides(r100.provideFunction());
    }
}

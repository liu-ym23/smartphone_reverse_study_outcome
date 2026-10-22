package com.bytedance.android.live.saas.middleware.npth.di;

import com.bytedance.android.live.saas.middleware.base.BaseFunction;
import com.bytedance.android.live.saas.middleware.npth.NpthConfig;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes47.dex */
public final class NpthModule_ProvideFunctionFactory implements Factory<BaseFunction<Object, NpthConfig>> {
    private final NpthModule module;

    @Override // javax.inject.Provider
    public BaseFunction<Object, NpthConfig> get() {
        return provideFunction(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public NpthModule_ProvideFunctionFactory(NpthModule r100) {
        this.module = r100;
    }

    public static NpthModule_ProvideFunctionFactory create(NpthModule r100) {
        return new NpthModule_ProvideFunctionFactory(r100);
    }

    public static BaseFunction<Object, NpthConfig> provideFunction(NpthModule r100) {
        return (BaseFunction) Preconditions.checkNotNullFromProvides(r100.provideFunction());
    }
}

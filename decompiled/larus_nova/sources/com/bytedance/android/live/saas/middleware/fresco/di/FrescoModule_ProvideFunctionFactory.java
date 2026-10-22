package com.bytedance.android.live.saas.middleware.fresco.di;

import com.bytedance.android.live.saas.middleware.base.BaseFunction;
import com.bytedance.android.live.saas.middleware.fresco.FrescoConfig;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes47.dex */
public final class FrescoModule_ProvideFunctionFactory implements Factory<BaseFunction<Object, FrescoConfig>> {
    private final FrescoModule module;

    @Override // javax.inject.Provider
    public BaseFunction<Object, FrescoConfig> get() {
        return provideFunction(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public FrescoModule_ProvideFunctionFactory(FrescoModule r100) {
        this.module = r100;
    }

    public static FrescoModule_ProvideFunctionFactory create(FrescoModule r100) {
        return new FrescoModule_ProvideFunctionFactory(r100);
    }

    public static BaseFunction<Object, FrescoConfig> provideFunction(FrescoModule r100) {
        return (BaseFunction) Preconditions.checkNotNullFromProvides(r100.provideFunction());
    }
}

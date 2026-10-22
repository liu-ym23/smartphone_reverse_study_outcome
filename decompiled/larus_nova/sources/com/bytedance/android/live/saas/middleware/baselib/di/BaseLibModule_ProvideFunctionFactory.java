package com.bytedance.android.live.saas.middleware.baselib.di;

import com.bytedance.android.live.saas.middleware.base.BaseFunction;
import com.bytedance.android.live.saas.middleware.baselib.BaseLibConfig;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes47.dex */
public final class BaseLibModule_ProvideFunctionFactory implements Factory<BaseFunction<Object, BaseLibConfig>> {
    private final BaseLibModule module;

    @Override // javax.inject.Provider
    public BaseFunction<Object, BaseLibConfig> get() {
        return provideFunction(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public BaseLibModule_ProvideFunctionFactory(BaseLibModule r100) {
        this.module = r100;
    }

    public static BaseLibModule_ProvideFunctionFactory create(BaseLibModule r100) {
        return new BaseLibModule_ProvideFunctionFactory(r100);
    }

    public static BaseFunction<Object, BaseLibConfig> provideFunction(BaseLibModule r100) {
        return (BaseFunction) Preconditions.checkNotNullFromProvides(r100.provideFunction());
    }
}

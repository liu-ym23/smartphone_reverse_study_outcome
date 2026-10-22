package com.bytedance.android.live.saas.middleware.applog.di;

import com.bytedance.android.live.saas.middleware.applog.AppLogConfig;
import com.bytedance.android.live.saas.middleware.applog.IAppLog;
import com.bytedance.android.live.saas.middleware.base.BaseFunction;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes47.dex */
public final class AppLogModule_ProvideFunctionFactory implements Factory<BaseFunction<IAppLog, AppLogConfig>> {
    private final AppLogModule module;

    @Override // javax.inject.Provider
    public BaseFunction<IAppLog, AppLogConfig> get() {
        return provideFunction(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public AppLogModule_ProvideFunctionFactory(AppLogModule r100) {
        this.module = r100;
    }

    public static AppLogModule_ProvideFunctionFactory create(AppLogModule r100) {
        return new AppLogModule_ProvideFunctionFactory(r100);
    }

    public static BaseFunction<IAppLog, AppLogConfig> provideFunction(AppLogModule r100) {
        return (BaseFunction) Preconditions.checkNotNullFromProvides(r100.provideFunction());
    }
}

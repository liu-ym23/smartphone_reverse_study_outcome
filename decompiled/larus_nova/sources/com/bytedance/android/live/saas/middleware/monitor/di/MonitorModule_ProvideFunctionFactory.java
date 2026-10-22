package com.bytedance.android.live.saas.middleware.monitor.di;

import com.bytedance.android.live.saas.middleware.base.BaseFunction;
import com.bytedance.android.live.saas.middleware.monitor.IMonitorReport;
import com.bytedance.android.live.saas.middleware.monitor.MonitorConfig;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes47.dex */
public final class MonitorModule_ProvideFunctionFactory implements Factory<BaseFunction<IMonitorReport, MonitorConfig>> {
    private final MonitorModule module;

    @Override // javax.inject.Provider
    public BaseFunction<IMonitorReport, MonitorConfig> get() {
        return provideFunction(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public MonitorModule_ProvideFunctionFactory(MonitorModule r100) {
        this.module = r100;
    }

    public static MonitorModule_ProvideFunctionFactory create(MonitorModule r100) {
        return new MonitorModule_ProvideFunctionFactory(r100);
    }

    public static BaseFunction<IMonitorReport, MonitorConfig> provideFunction(MonitorModule r100) {
        return (BaseFunction) Preconditions.checkNotNullFromProvides(r100.provideFunction());
    }
}

package com.bytedance.android.live.saas.middleware.monitor;

import com.bytedance.android.live.saas.middleware.base.BaseFunction;
import com.bytedance.android.live.saas.middleware.di.FuncType;
import dagger.MembersInjector;
import java.util.Map;
import javax.inject.Named;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes47.dex */
public final class MonitorProxy_MembersInjector implements MembersInjector<MonitorProxy> {
    private final Provider<Map<FuncType, BaseFunction<IMonitorReport, MonitorConfig>>> mFunctionMapProvider;

    public MonitorProxy_MembersInjector(Provider<Map<FuncType, BaseFunction<IMonitorReport, MonitorConfig>>> r100) {
        this.mFunctionMapProvider = r100;
    }

    public static MembersInjector<MonitorProxy> create(Provider<Map<FuncType, BaseFunction<IMonitorReport, MonitorConfig>>> r100) {
        return new MonitorProxy_MembersInjector(r100);
    }

    /* JADX INFO: renamed from: injectMembers, reason: avoid collision after fix types in other method */
    public void injectMembers2(MonitorProxy r100) {
        injectMFunctionMap(r100, this.mFunctionMapProvider.get());
    }

    @Override // dagger.MembersInjector
    public /* bridge */ /* synthetic */ void injectMembers(MonitorProxy r100) {
        injectMembers2(r100);
    }

    @Named("monitor")
    public static void injectMFunctionMap(MonitorProxy r100, Map<FuncType, BaseFunction<IMonitorReport, MonitorConfig>> r101) {
        r100.mFunctionMap = r101;
    }
}

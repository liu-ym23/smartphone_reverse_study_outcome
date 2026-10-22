package com.bytedance.android.live.saas.middleware.applog;

import com.bytedance.android.live.saas.middleware.base.BaseFunction;
import com.bytedance.android.live.saas.middleware.di.FuncType;
import dagger.MembersInjector;
import java.util.Map;
import javax.inject.Named;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes47.dex */
public final class AppLogProxy_MembersInjector implements MembersInjector<AppLogProxy> {
    private final Provider<Map<FuncType, BaseFunction<IAppLog, AppLogConfig>>> mFunctionMapProvider;

    public AppLogProxy_MembersInjector(Provider<Map<FuncType, BaseFunction<IAppLog, AppLogConfig>>> r100) {
        this.mFunctionMapProvider = r100;
    }

    public static MembersInjector<AppLogProxy> create(Provider<Map<FuncType, BaseFunction<IAppLog, AppLogConfig>>> r100) {
        return new AppLogProxy_MembersInjector(r100);
    }

    /* JADX INFO: renamed from: injectMembers, reason: avoid collision after fix types in other method */
    public void injectMembers2(AppLogProxy r100) {
        injectMFunctionMap(r100, this.mFunctionMapProvider.get());
    }

    @Override // dagger.MembersInjector
    public /* bridge */ /* synthetic */ void injectMembers(AppLogProxy r100) {
        injectMembers2(r100);
    }

    @Named("applog")
    public static void injectMFunctionMap(AppLogProxy r100, Map<FuncType, BaseFunction<IAppLog, AppLogConfig>> r101) {
        r100.mFunctionMap = r101;
    }
}

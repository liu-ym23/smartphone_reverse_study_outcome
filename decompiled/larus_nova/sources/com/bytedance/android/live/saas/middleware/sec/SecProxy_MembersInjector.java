package com.bytedance.android.live.saas.middleware.sec;

import com.bytedance.android.live.saas.middleware.base.BaseFunction;
import com.bytedance.android.live.saas.middleware.di.FuncType;
import dagger.MembersInjector;
import java.util.Map;
import javax.inject.Named;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes47.dex */
public final class SecProxy_MembersInjector implements MembersInjector<SecProxy> {
    private final Provider<Map<FuncType, BaseFunction<ISecSdk, SecConfig>>> taskMapProvider;

    public SecProxy_MembersInjector(Provider<Map<FuncType, BaseFunction<ISecSdk, SecConfig>>> r100) {
        this.taskMapProvider = r100;
    }

    public static MembersInjector<SecProxy> create(Provider<Map<FuncType, BaseFunction<ISecSdk, SecConfig>>> r100) {
        return new SecProxy_MembersInjector(r100);
    }

    /* JADX INFO: renamed from: injectMembers, reason: avoid collision after fix types in other method */
    public void injectMembers2(SecProxy r100) {
        injectTaskMap(r100, this.taskMapProvider.get());
    }

    @Override // dagger.MembersInjector
    public /* bridge */ /* synthetic */ void injectMembers(SecProxy r100) {
        injectMembers2(r100);
    }

    @Named("sec")
    public static void injectTaskMap(SecProxy r100, Map<FuncType, BaseFunction<ISecSdk, SecConfig>> r101) {
        r100.taskMap = r101;
    }
}

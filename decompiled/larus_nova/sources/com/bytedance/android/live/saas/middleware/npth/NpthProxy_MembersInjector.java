package com.bytedance.android.live.saas.middleware.npth;

import com.bytedance.android.live.saas.middleware.base.BaseFunction;
import com.bytedance.android.live.saas.middleware.di.FuncType;
import dagger.MembersInjector;
import java.util.Map;
import javax.inject.Named;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes47.dex */
public final class NpthProxy_MembersInjector implements MembersInjector<NpthProxy> {
    private final Provider<Map<FuncType, BaseFunction<Object, NpthConfig>>> mFunctionMapProvider;

    public NpthProxy_MembersInjector(Provider<Map<FuncType, BaseFunction<Object, NpthConfig>>> r100) {
        this.mFunctionMapProvider = r100;
    }

    public static MembersInjector<NpthProxy> create(Provider<Map<FuncType, BaseFunction<Object, NpthConfig>>> r100) {
        return new NpthProxy_MembersInjector(r100);
    }

    /* JADX INFO: renamed from: injectMembers, reason: avoid collision after fix types in other method */
    public void injectMembers2(NpthProxy r100) {
        injectMFunctionMap(r100, this.mFunctionMapProvider.get());
    }

    @Override // dagger.MembersInjector
    public /* bridge */ /* synthetic */ void injectMembers(NpthProxy r100) {
        injectMembers2(r100);
    }

    @Named("npth")
    public static void injectMFunctionMap(NpthProxy r100, Map<FuncType, BaseFunction<Object, NpthConfig>> r101) {
        r100.mFunctionMap = r101;
    }
}

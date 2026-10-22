package com.bytedance.android.live.saas.middleware.baselib;

import com.bytedance.android.live.saas.middleware.base.BaseFunction;
import com.bytedance.android.live.saas.middleware.di.FuncType;
import dagger.MembersInjector;
import java.util.Map;
import javax.inject.Named;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes47.dex */
public final class BaseLibProxy_MembersInjector implements MembersInjector<BaseLibProxy> {
    private final Provider<Map<FuncType, BaseFunction<Object, BaseLibConfig>>> mFunctionMapProvider;

    public BaseLibProxy_MembersInjector(Provider<Map<FuncType, BaseFunction<Object, BaseLibConfig>>> r100) {
        this.mFunctionMapProvider = r100;
    }

    public static MembersInjector<BaseLibProxy> create(Provider<Map<FuncType, BaseFunction<Object, BaseLibConfig>>> r100) {
        return new BaseLibProxy_MembersInjector(r100);
    }

    /* JADX INFO: renamed from: injectMembers, reason: avoid collision after fix types in other method */
    public void injectMembers2(BaseLibProxy r100) {
        injectMFunctionMap(r100, this.mFunctionMapProvider.get());
    }

    @Override // dagger.MembersInjector
    public /* bridge */ /* synthetic */ void injectMembers(BaseLibProxy r100) {
        injectMembers2(r100);
    }

    @Named("baselib")
    public static void injectMFunctionMap(BaseLibProxy r100, Map<FuncType, BaseFunction<Object, BaseLibConfig>> r101) {
        r100.mFunctionMap = r101;
    }
}

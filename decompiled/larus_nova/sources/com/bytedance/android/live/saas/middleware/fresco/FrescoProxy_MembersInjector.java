package com.bytedance.android.live.saas.middleware.fresco;

import com.bytedance.android.live.saas.middleware.base.BaseFunction;
import com.bytedance.android.live.saas.middleware.di.FuncType;
import dagger.MembersInjector;
import java.util.Map;
import javax.inject.Named;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes47.dex */
public final class FrescoProxy_MembersInjector implements MembersInjector<FrescoProxy> {
    private final Provider<Map<FuncType, BaseFunction<Object, FrescoConfig>>> mFunctionMapProvider;

    public FrescoProxy_MembersInjector(Provider<Map<FuncType, BaseFunction<Object, FrescoConfig>>> r100) {
        this.mFunctionMapProvider = r100;
    }

    public static MembersInjector<FrescoProxy> create(Provider<Map<FuncType, BaseFunction<Object, FrescoConfig>>> r100) {
        return new FrescoProxy_MembersInjector(r100);
    }

    /* JADX INFO: renamed from: injectMembers, reason: avoid collision after fix types in other method */
    public void injectMembers2(FrescoProxy r100) {
        injectMFunctionMap(r100, this.mFunctionMapProvider.get());
    }

    @Override // dagger.MembersInjector
    public /* bridge */ /* synthetic */ void injectMembers(FrescoProxy r100) {
        injectMembers2(r100);
    }

    @Named("fresco")
    public static void injectMFunctionMap(FrescoProxy r100, Map<FuncType, BaseFunction<Object, FrescoConfig>> r101) {
        r100.mFunctionMap = r101;
    }
}

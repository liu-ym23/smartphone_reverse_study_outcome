package com.bytedance.android.live.saas.middleware.network;

import com.bytedance.android.live.saas.middleware.base.BaseFunction;
import com.bytedance.android.live.saas.middleware.di.FuncType;
import dagger.MembersInjector;
import java.util.Map;
import javax.inject.Named;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes47.dex */
public final class NetworkProxy_MembersInjector implements MembersInjector<NetworkProxy> {
    private final Provider<Map<FuncType, BaseFunction<Object, NetworkConfig>>> cornetFunctionProvider;

    public NetworkProxy_MembersInjector(Provider<Map<FuncType, BaseFunction<Object, NetworkConfig>>> r100) {
        this.cornetFunctionProvider = r100;
    }

    public static MembersInjector<NetworkProxy> create(Provider<Map<FuncType, BaseFunction<Object, NetworkConfig>>> r100) {
        return new NetworkProxy_MembersInjector(r100);
    }

    /* JADX INFO: renamed from: injectMembers, reason: avoid collision after fix types in other method */
    public void injectMembers2(NetworkProxy r100) {
        injectCornetFunction(r100, this.cornetFunctionProvider.get());
    }

    @Override // dagger.MembersInjector
    public /* bridge */ /* synthetic */ void injectMembers(NetworkProxy r100) {
        injectMembers2(r100);
    }

    @Named("cornet")
    public static void injectCornetFunction(NetworkProxy r100, Map<FuncType, BaseFunction<Object, NetworkConfig>> r101) {
        r100.cornetFunction = r101;
    }
}

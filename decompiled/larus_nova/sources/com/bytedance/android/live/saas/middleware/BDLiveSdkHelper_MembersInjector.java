package com.bytedance.android.live.saas.middleware;

import dagger.MembersInjector;
import java.util.Set;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes47.dex */
public final class BDLiveSdkHelper_MembersInjector implements MembersInjector<BDLiveSdkHelper> {
    private final Provider<Set<IBDLiveSdkInit>> providersProvider;

    public BDLiveSdkHelper_MembersInjector(Provider<Set<IBDLiveSdkInit>> r100) {
        this.providersProvider = r100;
    }

    public static MembersInjector<BDLiveSdkHelper> create(Provider<Set<IBDLiveSdkInit>> r100) {
        return new BDLiveSdkHelper_MembersInjector(r100);
    }

    /* JADX INFO: renamed from: injectMembers, reason: avoid collision after fix types in other method */
    public void injectMembers2(BDLiveSdkHelper r100) {
        injectProviders(r100, this.providersProvider.get());
    }

    @Override // dagger.MembersInjector
    public /* bridge */ /* synthetic */ void injectMembers(BDLiveSdkHelper r100) {
        injectMembers2(r100);
    }

    public static void injectProviders(BDLiveSdkHelper r100, Set<IBDLiveSdkInit> r101) {
        r100.providers = r101;
    }
}

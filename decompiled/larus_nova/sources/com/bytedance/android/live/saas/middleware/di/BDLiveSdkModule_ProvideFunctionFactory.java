package com.bytedance.android.live.saas.middleware.di;

import com.bytedance.android.live.saas.middleware.IBDLiveSdkInit;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes47.dex */
public final class BDLiveSdkModule_ProvideFunctionFactory implements Factory<IBDLiveSdkInit> {
    private final BDLiveSdkModule module;

    @Override // javax.inject.Provider
    public IBDLiveSdkInit get() {
        return provideFunction(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public BDLiveSdkModule_ProvideFunctionFactory(BDLiveSdkModule r100) {
        this.module = r100;
    }

    public static BDLiveSdkModule_ProvideFunctionFactory create(BDLiveSdkModule r100) {
        return new BDLiveSdkModule_ProvideFunctionFactory(r100);
    }

    public static IBDLiveSdkInit provideFunction(BDLiveSdkModule r100) {
        return (IBDLiveSdkInit) Preconditions.checkNotNullFromProvides(r100.provideFunction());
    }
}

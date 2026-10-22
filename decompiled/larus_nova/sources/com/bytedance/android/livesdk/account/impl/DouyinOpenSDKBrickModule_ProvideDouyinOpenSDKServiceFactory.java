package com.bytedance.android.livesdk.account.impl;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes7.dex */
public final class DouyinOpenSDKBrickModule_ProvideDouyinOpenSDKServiceFactory implements Factory<od1.a> {
    private final i module;

    @Override // javax.inject.Provider
    public od1.a get() {
        return provideDouyinOpenSDKService(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public DouyinOpenSDKBrickModule_ProvideDouyinOpenSDKServiceFactory(i r100) {
        this.module = r100;
    }

    public static DouyinOpenSDKBrickModule_ProvideDouyinOpenSDKServiceFactory create(i r100) {
        return new DouyinOpenSDKBrickModule_ProvideDouyinOpenSDKServiceFactory(r100);
    }

    public static od1.a provideDouyinOpenSDKService(i r100) {
        r100.getClass();
        return (od1.a) Preconditions.checkNotNullFromProvides(new f());
    }
}

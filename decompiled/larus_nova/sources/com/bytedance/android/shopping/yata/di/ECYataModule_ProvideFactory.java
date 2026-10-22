package com.bytedance.android.shopping.yata.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import ml3.a;
import sc3.j;

/* JADX INFO: loaded from: classes14.dex */
public final class ECYataModule_ProvideFactory implements Factory<j> {
    private final a module;

    @Override // javax.inject.Provider
    public j get() {
        return provideInstance(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ECYataModule_ProvideFactory(a r100) {
        this.module = r100;
    }

    public static ECYataModule_ProvideFactory create(a r100) {
        return new ECYataModule_ProvideFactory(r100);
    }

    public static j provideInstance(a r100) {
        return proxyProvide(r100);
    }

    public static j proxyProvide(a r100) {
        r100.getClass();
        return (j) Preconditions.checkNotNull(new ol3.a(), "Cannot return null from a non-@Nullable @Provides method");
    }
}

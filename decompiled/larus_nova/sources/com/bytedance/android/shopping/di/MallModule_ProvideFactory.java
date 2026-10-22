package com.bytedance.android.shopping.di;

import com.bytedance.android.shopping.mall.impl.a;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import gd3.j;
import n83.h;

/* JADX INFO: loaded from: classes13.dex */
public final class MallModule_ProvideFactory implements Factory<h> {
    private final j module;

    @Override // javax.inject.Provider
    public h get() {
        return provideInstance(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public MallModule_ProvideFactory(j r100) {
        this.module = r100;
    }

    public static MallModule_ProvideFactory create(j r100) {
        return new MallModule_ProvideFactory(r100);
    }

    public static h provideInstance(j r100) {
        return proxyProvide(r100);
    }

    public static h proxyProvide(j r100) {
        r100.getClass();
        return (h) Preconditions.checkNotNull(new a(), "Cannot return null from a non-@Nullable @Provides method");
    }
}

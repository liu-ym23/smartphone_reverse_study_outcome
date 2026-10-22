package com.bytedance.android.shopping.orderlist.common.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import fg3.a;
import sc3.h;

/* JADX INFO: loaded from: classes13.dex */
public final class OrderListModule_ProvideFactory implements Factory<h> {
    private final a module;

    @Override // javax.inject.Provider
    public h get() {
        return provideInstance(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public OrderListModule_ProvideFactory(a r100) {
        this.module = r100;
    }

    public static OrderListModule_ProvideFactory create(a r100) {
        return new OrderListModule_ProvideFactory(r100);
    }

    public static h provideInstance(a r100) {
        return proxyProvide(r100);
    }

    public static h proxyProvide(a r100) {
        r100.getClass();
        return (h) Preconditions.checkNotNull(new com.bytedance.android.shopping.orderlist.common.service.a(), "Cannot return null from a non-@Nullable @Provides method");
    }
}

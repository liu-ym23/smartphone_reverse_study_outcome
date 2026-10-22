package com.bytedance.android.livesdk.feed.di;

import dagger.internal.Factory;
import rv1.a;
import uv1.d;

/* JADX INFO: loaded from: classes8.dex */
public final class DrawerCategoryModuleFallback_ProvideDrawerCategoryServiceFactory implements Factory<d> {
    private final a module;

    @Override // javax.inject.Provider
    public d get() {
        return provideDrawerCategoryService(null);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public DrawerCategoryModuleFallback_ProvideDrawerCategoryServiceFactory(a r100) {
    }

    public static DrawerCategoryModuleFallback_ProvideDrawerCategoryServiceFactory create(a r100) {
        return new DrawerCategoryModuleFallback_ProvideDrawerCategoryServiceFactory(r100);
    }

    public static d provideDrawerCategoryService(a r100) {
        throw null;
    }
}

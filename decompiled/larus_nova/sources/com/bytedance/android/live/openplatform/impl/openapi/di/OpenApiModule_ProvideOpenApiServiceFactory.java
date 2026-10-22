package com.bytedance.android.live.openplatform.impl.openapi.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import or0.a;
import yo0.b;

/* JADX INFO: loaded from: classes46.dex */
public final class OpenApiModule_ProvideOpenApiServiceFactory implements Factory<b> {
    private final a module;

    @Override // javax.inject.Provider
    public b get() {
        return provideOpenApiService(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public OpenApiModule_ProvideOpenApiServiceFactory(a r100) {
        this.module = r100;
    }

    public static OpenApiModule_ProvideOpenApiServiceFactory create(a r100) {
        return new OpenApiModule_ProvideOpenApiServiceFactory(r100);
    }

    public static b provideOpenApiService(a r100) {
        r100.getClass();
        return (b) Preconditions.checkNotNullFromProvides(new com.bytedance.android.live.openplatform.impl.openapi.a());
    }
}

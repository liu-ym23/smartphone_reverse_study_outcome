package com.bytedance.android.livesdk.feed.di;

import com.bytedance.android.livesdk.feed.preview.a;
import dagger.internal.Factory;
import rv1.c;

/* JADX INFO: loaded from: classes8.dex */
public final class PreviewModuleFallback_ProvidePreviewFactoryFactory implements Factory<a> {
    private final c module;

    @Override // javax.inject.Provider
    public a get() {
        return providePreviewFactory(null);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public PreviewModuleFallback_ProvidePreviewFactoryFactory(c r100) {
    }

    public static PreviewModuleFallback_ProvidePreviewFactoryFactory create(c r100) {
        return new PreviewModuleFallback_ProvidePreviewFactoryFactory(r100);
    }

    public static a providePreviewFactory(c r100) {
        throw null;
    }
}

package com.bytedance.android.livesdk.feed.preview.di;

import com.bytedance.android.livesdk.feed.preview.a;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import pw1.b;

/* JADX INFO: loaded from: classes8.dex */
public final class FeedPreviewModule_ProvidePreviewFactoryFactory implements Factory<a> {
    private final b module;

    @Override // javax.inject.Provider
    public a get() {
        return providePreviewFactory(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public FeedPreviewModule_ProvidePreviewFactoryFactory(b r100) {
        this.module = r100;
    }

    public static FeedPreviewModule_ProvidePreviewFactoryFactory create(b r100) {
        return new FeedPreviewModule_ProvidePreviewFactoryFactory(r100);
    }

    public static a providePreviewFactory(b r100) {
        r100.getClass();
        return (a) Preconditions.checkNotNullFromProvides(new pw1.a());
    }
}

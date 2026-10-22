package com.bytedance.android.livesdk.gift.guide.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import h12.a;
import yy1.b;

/* JADX INFO: loaded from: classes9.dex */
public final class CommentModule_ProviderCommentGuideViewFactory implements Factory<a> {
    private final b module;

    @Override // javax.inject.Provider
    public a get() {
        return providerCommentGuideView(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public CommentModule_ProviderCommentGuideViewFactory(b r100) {
        this.module = r100;
    }

    public static CommentModule_ProviderCommentGuideViewFactory create(b r100) {
        return new CommentModule_ProviderCommentGuideViewFactory(r100);
    }

    public static a providerCommentGuideView(b r100) {
        r100.getClass();
        return (a) Preconditions.checkNotNullFromProvides(new yy1.a());
    }
}

package com.bytedance.android.livesdk.gift.guide.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import h12.d;
import yy1.e;

/* JADX INFO: loaded from: classes9.dex */
public final class GuideModule_ProvideGuidePresenterFactory implements Factory<d> {
    private final e module;

    @Override // javax.inject.Provider
    public d get() {
        return provideGuidePresenter(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public GuideModule_ProvideGuidePresenterFactory(e r100) {
        this.module = r100;
    }

    public static GuideModule_ProvideGuidePresenterFactory create(e r100) {
        return new GuideModule_ProvideGuidePresenterFactory(r100);
    }

    public static d provideGuidePresenter(e r100) {
        r100.getClass();
        return (d) Preconditions.checkNotNullFromProvides(new yy1.d());
    }
}

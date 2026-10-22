package com.bytedance.android.livesdk.gift.guide.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import h12.c;
import yy1.e;

/* JADX INFO: loaded from: classes9.dex */
public final class GuideModule_ProvideGuideDialogFactory implements Factory<c> {
    private final e module;

    @Override // javax.inject.Provider
    public c get() {
        return provideGuideDialog(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public GuideModule_ProvideGuideDialogFactory(e r100) {
        this.module = r100;
    }

    public static GuideModule_ProvideGuideDialogFactory create(e r100) {
        return new GuideModule_ProvideGuideDialogFactory(r100);
    }

    public static c provideGuideDialog(e r100) {
        r100.getClass();
        return (c) Preconditions.checkNotNullFromProvides(new yy1.c());
    }
}

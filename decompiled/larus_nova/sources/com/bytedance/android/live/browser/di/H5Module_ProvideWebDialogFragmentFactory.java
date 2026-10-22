package com.bytedance.android.live.browser.di;

import com.bytedance.android.live.browser.IH5AssistService;
import com.bytedance.android.live.browser.webview.fragment.BaseWebDialogFragment;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import jc1.k;
import s20.c;

/* JADX INFO: loaded from: classes45.dex */
public final class H5Module_ProvideWebDialogFragmentFactory implements Factory<BaseWebDialogFragment> {
    private final c module;

    @Override // javax.inject.Provider
    public BaseWebDialogFragment get() {
        return provideWebDialogFragment(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public H5Module_ProvideWebDialogFragmentFactory(c r100) {
        this.module = r100;
    }

    public static H5Module_ProvideWebDialogFragmentFactory create(c r100) {
        return new H5Module_ProvideWebDialogFragmentFactory(r100);
    }

    public static BaseWebDialogFragment provideWebDialogFragment(c r100) {
        r100.getClass();
        IH5AssistService r101 = (IH5AssistService) k.f(IH5AssistService.class);
        if (r101 == null) goto L5;
        BaseWebDialogFragment r102 = r101.createWebDialogFragment();
    L7:
        return (BaseWebDialogFragment) Preconditions.checkNotNullFromProvides(r102);
    L5:
        r102 = null;
        goto L7
    }
}

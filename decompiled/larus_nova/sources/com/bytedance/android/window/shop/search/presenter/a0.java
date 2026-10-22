package com.bytedance.android.window.shop.search.presenter;

import android.view.View;

/* JADX INFO: loaded from: classes14.dex */
public final class a0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WindowSearchTitlePresenter f189731a;

    public a0(WindowSearchTitlePresenter r100) {
        this.f189731a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        WindowSearchTitlePresenter.F(this.f189731a, WindowSearchBasePresenter.SearchMode.BUTTON);
    }
}

package com.bytedance.android.window.shop.search.presenter;

import android.view.View;

/* JADX INFO: loaded from: classes14.dex */
public final class m implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WindowSearchResultTopBarPresenter f189749a;

    public m(WindowSearchResultTopBarPresenter r100) {
        this.f189749a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f189749a.F().getData().putExtra("sug_enter_type", 2);
        WindowSearchResultTopBarPresenter.E(this.f189749a, 10);
    }
}

package com.bytedance.android.shopping.store.search.presenter;

import android.view.View;
import android.widget.EditText;

/* JADX INFO: loaded from: classes14.dex */
public final class f0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShopSearchTitlePresenter f186081a;

    public f0(ShopSearchTitlePresenter r100) {
        this.f186081a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        EditText r101 = this.f186081a.f186058f;
        if (r101 == null) goto L6;
        r101.setText("");
        return;
    }
}

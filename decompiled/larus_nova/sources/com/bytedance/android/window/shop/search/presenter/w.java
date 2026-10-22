package com.bytedance.android.window.shop.search.presenter;

import android.view.View;
import android.widget.EditText;

/* JADX INFO: loaded from: classes14.dex */
public final class w implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WindowSearchTitlePresenter f189764a;

    public w(WindowSearchTitlePresenter r100) {
        this.f189764a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        EditText r101 = this.f189764a.f189724g;
        if (r101 == null) goto L6;
        r101.setText("");
        return;
    }
}

package com.bytedance.android.window.shop.search.presenter;

import android.view.KeyEvent;
import android.widget.TextView;

/* JADX INFO: loaded from: classes14.dex */
public final class z implements TextView.OnEditorActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WindowSearchTitlePresenter f189767a;

    public z(WindowSearchTitlePresenter r100) {
        this.f189767a = r100;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r100, int r101, KeyEvent r102) {
        if (r101 != 3) goto L6;
        WindowSearchTitlePresenter.F(this.f189767a, WindowSearchBasePresenter.SearchMode.KEYBOARD);
        return true;
    L6:
        return false;
    }
}

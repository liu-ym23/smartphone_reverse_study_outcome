package com.bytedance.android.shopping.store.search.presenter;

import android.view.KeyEvent;
import android.widget.TextView;
import com.bytedance.android.shopping.store.home.presenter.ShopSearchBasePresenter;

/* JADX INFO: loaded from: classes14.dex */
public final class i0 implements TextView.OnEditorActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShopSearchTitlePresenter f186090a;

    public i0(ShopSearchTitlePresenter r100) {
        this.f186090a = r100;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r100, int r101, KeyEvent r102) {
        if (r101 != 3) goto L6;
        ShopSearchTitlePresenter.G(this.f186090a, ShopSearchBasePresenter.SearchMode.KEYBOARD);
        return true;
    L6:
        return false;
    }
}

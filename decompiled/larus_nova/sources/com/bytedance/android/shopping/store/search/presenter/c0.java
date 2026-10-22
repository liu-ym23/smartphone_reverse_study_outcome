package com.bytedance.android.shopping.store.search.presenter;

import android.widget.EditText;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes14.dex */
public final class c0<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShopSearchTitlePresenter f186075a;

    public c0(ShopSearchTitlePresenter r100) {
        this.f186075a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        String r101 = (String) r100;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.length() <= 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L11;
        r101 = null;
    L11:
        if (r101 == null) goto L20;
        EditText r103 = this.f186075a.f186058f;
        if (r103 == null) goto L15;
        r103.setText(r101);
    L15:
        EditText r104 = this.f186075a.f186058f;
        if (r104 == null) goto L21;
        r104.setSelection(r101.length());
        return;
    L21:
        return;
    L20:
        return;
    L7:
        r102 = false;
        goto L8
    }
}

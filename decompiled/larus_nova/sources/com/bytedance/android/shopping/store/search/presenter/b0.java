package com.bytedance.android.shopping.store.search.presenter;

import android.widget.EditText;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes14.dex */
public final class b0<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShopSearchTitlePresenter f186073a;

    public b0(ShopSearchTitlePresenter r100) {
        this.f186073a = r100;
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
        if (r101 == null) goto L17;
        EditText r103 = this.f186073a.f186058f;
        if (r103 == null) goto L18;
        r103.setHint(r101);
        return;
    L18:
        return;
    L17:
        return;
    L7:
        r102 = false;
        goto L8
    }
}

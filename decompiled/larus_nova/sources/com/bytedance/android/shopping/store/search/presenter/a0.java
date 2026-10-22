package com.bytedance.android.shopping.store.search.presenter;

import android.text.Editable;
import android.widget.EditText;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a0<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShopSearchTitlePresenter f186071a;

    public a0(ShopSearchTitlePresenter r100) {
        this.f186071a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        String r101 = (String) r100;
        if (r101 == null) goto L24;
        EditText r102 = this.f186071a.f186058f;
        if (r102 == null) goto L7;
        Editable r103 = r102.getText();
    L8:
        boolean r104 = true;
        if ((!Intrinsics.areEqual(r101, String.valueOf(r103))) == true) goto L11;
    L13:
        r104 = false;
    L14:
        if (r104 == true) goto L17;
        r101 = null;
    L17:
        if (r101 == null) goto L24;
        EditText r105 = this.f186071a.f186058f;
        if (r105 == null) goto L21;
        r105.setText(r101);
    L21:
        EditText r106 = this.f186071a.f186058f;
        if (r106 == null) goto L24;
        r106.setSelection(r101.length());
        goto L24
    L11:
        if (this.f186071a.f186062j == true) goto L13;
    L7:
        r103 = null;
    L24:
        this.f186071a.f186062j = false;
    }
}

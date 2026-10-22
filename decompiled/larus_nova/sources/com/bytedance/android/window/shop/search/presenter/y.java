package com.bytedance.android.window.shop.search.presenter;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class y implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WindowSearchTitlePresenter f189766a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public y(WindowSearchTitlePresenter r100) {
        this.f189766a = r100;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        EditText r101 = this.f189766a.f189724g;
        if (r101 == null) goto L11;
        if (r101 == null) goto L8;
        Editable r102 = r101.getText();
        if (r102 == null) goto L8;
        int r103 = r102.length();
    L9:
        r101.setSelection(r103);
        return;
    L8:
        r103 = 0;
        goto L9
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        if (TextUtils.isEmpty(r100) == true) goto L12;
        ImageView r104 = this.f189766a.f189725h;
        if (r104 == null) goto L12;
        if (r104.getVisibility() != 8) goto L12;
        ImageView r105 = this.f189766a.f189725h;
        if (r105 == null) goto L21;
        r105.setVisibility(0);
    L21:
        if ((!Intrinsics.areEqual(String.valueOf(r100), WindowSearchTitlePresenter.E(this.f189766a).getSearchContent().a())) == false) goto L23;
        WindowSearchTitlePresenter r106 = this.f189766a;
        r106.f189728k = true;
        WindowSearchTitlePresenter.E(r106).getSearchContent().g(String.valueOf(r100));
    L23:
        WindowSearchTitlePresenter.E(this.f189766a).getSugRequestParam().getClass();
        return;
    L12:
        if (TextUtils.isEmpty(r100) == false) goto L21;
        ImageView r107 = this.f189766a.f189725h;
        if (r107 == null) goto L21;
        if (r107.getVisibility() != 0) goto L21;
        ImageView r108 = this.f189766a.f189725h;
        if (r108 == null) goto L21;
        r108.setVisibility(8);
        goto L21
    }
}

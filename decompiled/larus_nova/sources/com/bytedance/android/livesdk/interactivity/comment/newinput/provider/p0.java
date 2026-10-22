package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;

/* JADX INFO: loaded from: classes9.dex */
public final class p0 implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j0.c f135946a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public p0(j0.c r100) {
        this.f135946a = r100;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        EditText r101 = this.f135946a.f135513b.f135496a;
        if (r101 == null) goto L12;
        Editable r102 = r101.getText();
        if (r102 != null) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r102) == false) goto L10;
        this.f135946a.k(false);
        return;
    L10:
        this.f135946a.k(true);
        return;
    }
}

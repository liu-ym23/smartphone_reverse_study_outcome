package com.bytedance.android.live.effect.sticker.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes45.dex */
public final class p implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StickerSearchBox f68591a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public p(StickerSearchBox r100) {
        this.f68591a = r100;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        int r101 = 0;
        if (r100 == null) goto L10;
        boolean r102 = true;
        if (r100.length() != 0) goto L7;
        boolean r103 = true;
    L8:
        if (r103 != true) goto L10;
    L11:
        ImageView r104 = StickerSearchBox.R5(this.f68591a);
        if (r102 == false) goto L14;
        r101 = 8;
    L14:
        r104.setVisibility(r101);
        j r105 = this.f68591a.f68490d;
        if (r105 == null) goto L22;
        if (r100 == null) goto L19;
        String r106 = r100.toString();
        if (r106 == null) goto L19;
    L20:
        r105.c(r102, r106);
        return;
    L19:
        r106 = "";
        goto L20
    L22:
        return;
    L7:
        r103 = false;
    L10:
        r102 = false;
        goto L11
    }
}

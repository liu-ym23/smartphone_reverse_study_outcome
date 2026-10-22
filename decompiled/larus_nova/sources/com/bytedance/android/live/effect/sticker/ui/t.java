package com.bytedance.android.live.effect.sticker.ui;

import android.view.View;

/* JADX INFO: loaded from: classes45.dex */
public final class t implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StickerSearchBox f68785a;

    public t(StickerSearchBox r100) {
        this.f68785a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        StickerSearchBox.S5(this.f68785a).setText("");
        j r101 = this.f68785a.f68490d;
        if (r101 == null) goto L6;
        r101.d();
        return;
    }
}

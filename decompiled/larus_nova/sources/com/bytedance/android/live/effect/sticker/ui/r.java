package com.bytedance.android.live.effect.sticker.ui;

import android.view.View;

/* JADX INFO: loaded from: classes45.dex */
public final class r implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StickerSearchBox f68593a;

    public r(StickerSearchBox r100) {
        this.f68593a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        j r101 = this.f68593a.f68490d;
        if (r101 == null) goto L6;
        r101.b();
        return;
    }
}

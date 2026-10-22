package com.bytedance.android.live.effect.sticker.ui;

import android.view.View;

/* JADX INFO: loaded from: classes45.dex */
public final class q implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StickerSearchBox f68592a;

    public q(StickerSearchBox r100) {
        this.f68592a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        StickerSearchBox.S5(this.f68592a).setCursorVisible(true);
    }
}

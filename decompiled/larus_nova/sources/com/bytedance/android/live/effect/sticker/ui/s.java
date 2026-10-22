package com.bytedance.android.live.effect.sticker.ui;

import android.view.View;

/* JADX INFO: loaded from: classes45.dex */
public final class s implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StickerSearchBox f68594a;

    public s(StickerSearchBox r100) {
        this.f68594a = r100;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r100, boolean r101) {
        j r102 = this.f68594a.f68490d;
        if (r102 == null) goto L6;
        r102.e();
        return;
    }
}

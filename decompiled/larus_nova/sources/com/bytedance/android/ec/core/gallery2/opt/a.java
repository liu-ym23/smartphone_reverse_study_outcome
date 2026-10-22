package com.bytedance.android.ec.core.gallery2.opt;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GalleryTitleItemView f44090a;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        if (this.f44090a.getLineCount() <= 3) goto L5;
        this.f44090a.setTextSize(11.0f);
    L6:
        this.f44090a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        return;
    L5:
        this.f44090a.setTextSize(14.0f);
        goto L6
    }

    public a(GalleryTitleItemView r100) {
        this.f44090a = r100;
    }
}

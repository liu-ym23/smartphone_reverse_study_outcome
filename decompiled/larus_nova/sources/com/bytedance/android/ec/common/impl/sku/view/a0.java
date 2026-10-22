package com.bytedance.android.ec.common.impl.sku.view;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes43.dex */
public final class a0 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SpecItemOptimizeView f43475a;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        if (this.f43475a.f43456l.getLineCount() <= 1) goto L5;
        this.f43475a.f43456l.setTextSize(13.0f);
    L6:
        this.f43475a.f43456l.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        return;
    L5:
        this.f43475a.f43456l.setTextSize(14.0f);
        goto L6
    }

    public a0(SpecItemOptimizeView r100) {
        this.f43475a = r100;
    }
}

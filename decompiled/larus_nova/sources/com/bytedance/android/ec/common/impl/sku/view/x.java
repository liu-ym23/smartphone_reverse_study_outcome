package com.bytedance.android.ec.common.impl.sku.view;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes43.dex */
public final class x implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SpecItemOptimizeView f43583a;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        if (this.f43583a.f43452h.getLineCount() <= 1) goto L5;
        this.f43583a.f43452h.setTextSize(13.0f);
        this.f43583a.f43452h.setGravity(16);
    L6:
        this.f43583a.f43452h.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        return;
    L5:
        this.f43583a.f43452h.setTextSize(14.0f);
        this.f43583a.f43452h.setGravity(17);
        goto L6
    }

    public x(SpecItemOptimizeView r100) {
        this.f43583a = r100;
    }
}

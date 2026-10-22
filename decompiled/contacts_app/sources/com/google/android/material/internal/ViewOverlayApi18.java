package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* JADX INFO: loaded from: classes2.dex */
class ViewOverlayApi18 implements ViewOverlayImpl {
    private final ViewOverlay viewOverlay;

    ViewOverlayApi18(View r1) {
        this.viewOverlay = r1.getOverlay();
    }

    @Override // com.google.android.material.internal.ViewOverlayImpl
    public void add(Drawable r1) {
        this.viewOverlay.add(r1);
    }

    @Override // com.google.android.material.internal.ViewOverlayImpl
    public void remove(Drawable r1) {
        this.viewOverlay.remove(r1);
    }
}

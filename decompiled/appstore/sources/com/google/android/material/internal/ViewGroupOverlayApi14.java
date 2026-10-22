package com.google.android.material.internal;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
class ViewGroupOverlayApi14 extends ViewOverlayApi14 implements ViewGroupOverlayImpl {
    public ViewGroupOverlayApi14(Context r10, ViewGroup r11, View r12) {
        super(r10, r11, r12);
    }

    public static ViewGroupOverlayApi14 createFrom(ViewGroup r10) {
        return (ViewGroupOverlayApi14) ViewOverlayApi14.createFrom(r10);
    }

    @Override // com.google.android.material.internal.ViewGroupOverlayImpl
    public void add(@NonNull View r10) {
        this.overlayViewGroup.add(r10);
    }

    @Override // com.google.android.material.internal.ViewGroupOverlayImpl
    public void remove(@NonNull View r10) {
        this.overlayViewGroup.remove(r10);
    }
}

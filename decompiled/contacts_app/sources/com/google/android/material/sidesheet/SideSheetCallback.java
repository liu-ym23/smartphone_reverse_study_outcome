package com.google.android.material.sidesheet;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public abstract class SideSheetCallback implements SheetCallback {
    void onLayout(View r1) {
    }

    @Override // com.google.android.material.sidesheet.SheetCallback
    public abstract void onSlide(View r1, float r2);

    @Override // com.google.android.material.sidesheet.SheetCallback
    public abstract void onStateChanged(View r1, int r2);

    public SideSheetCallback() {
    }
}

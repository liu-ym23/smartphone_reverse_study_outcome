package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

/* JADX INFO: loaded from: classes2.dex */
public class VisibilityAwareImageButton extends ImageButton {
    private int userSetVisibility;

    public VisibilityAwareImageButton(Context r2) {
        this(r2, null);
    }

    public VisibilityAwareImageButton(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public VisibilityAwareImageButton(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.userSetVisibility = getVisibility();
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int r2) {
        internalSetVisibility(r2, true);
    }

    public final void internalSetVisibility(int r1, boolean r2) {
        super.setVisibility(r1);
        if (r2 == false) goto L6;
        this.userSetVisibility = r1;
        return;
    }

    public final int getUserSetVisibility() {
        return this.userSetVisibility;
    }
}

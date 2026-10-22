package com.google.android.material.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"AppCompatCustomView"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class VisibilityAwareImageButton extends ImageButton {
    private int userSetVisibility;

    public VisibilityAwareImageButton(Context r10) {
        this(r10, null);
    }

    public final int getUserSetVisibility() {
        return this.userSetVisibility;
    }

    public final void internalSetVisibility(int r10, boolean r11) {
        super.setVisibility(r10);
        if (r11 == false) goto L6;
        this.userSetVisibility = r10;
        return;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int r10) {
        internalSetVisibility(r10, true);
    }

    public VisibilityAwareImageButton(Context r10, AttributeSet r11) {
        this(r10, r11, 0);
    }

    public VisibilityAwareImageButton(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.userSetVisibility = getVisibility();
    }
}

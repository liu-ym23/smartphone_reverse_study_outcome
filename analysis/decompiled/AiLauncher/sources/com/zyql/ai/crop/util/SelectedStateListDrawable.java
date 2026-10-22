package com.zyql.ai.crop.util;

import android.R;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import androidx.core.graphics.BlendModeCompat;
import t0.C5499a;

/* loaded from: classes4.dex */
public class SelectedStateListDrawable extends StateListDrawable {
    private final int mSelectionColor;

    public SelectedStateListDrawable(Drawable drawable, int i10) {
        this.mSelectionColor = i10;
        addState(new int[]{R.attr.state_selected}, drawable);
        addState(new int[0], drawable);
    }

    @Override // android.graphics.drawable.StateListDrawable, android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.StateListDrawable, android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean z10 = false;
        for (int i10 : iArr) {
            if (i10 == 16842913) {
                z10 = true;
            }
        }
        if (z10) {
            super.setColorFilter(C5499a.a(this.mSelectionColor, BlendModeCompat.SRC_ATOP));
        } else {
            super.clearColorFilter();
        }
        return super.onStateChange(iArr);
    }
}

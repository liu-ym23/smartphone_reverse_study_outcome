package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseProgressIndicatorSpec {
    public int hideAnimationBehavior;
    public int[] indicatorColors;
    public int showAnimationBehavior;
    public int trackColor;
    public int trackCornerRadius;
    public int trackThickness;

    abstract void validateSpec();

    protected BaseProgressIndicatorSpec(Context r9, AttributeSet r10, int r11, int r12) {
        this.indicatorColors = new int[0];
        int r1 = r9.getResources().getDimensionPixelSize(R.dimen.mtrl_progress_track_thickness);
        TypedArray r13 = ThemeEnforcement.obtainStyledAttributes(r9, r10, R.styleable.BaseProgressIndicator, r11, r12, new int[0]);
        this.trackThickness = MaterialResources.getDimensionPixelSize(r9, r13, R.styleable.BaseProgressIndicator_trackThickness, r1);
        this.trackCornerRadius = Math.min(MaterialResources.getDimensionPixelSize(r9, r13, R.styleable.BaseProgressIndicator_trackCornerRadius, 0), this.trackThickness / 2);
        this.showAnimationBehavior = r13.getInt(R.styleable.BaseProgressIndicator_showAnimationBehavior, 0);
        this.hideAnimationBehavior = r13.getInt(R.styleable.BaseProgressIndicator_hideAnimationBehavior, 0);
        loadIndicatorColors(r9, r13);
        loadTrackColor(r9, r13);
        r13.recycle();
    }

    private void loadIndicatorColors(Context r5, TypedArray r6) {
        if (r6.hasValue(R.styleable.BaseProgressIndicator_indicatorColor) == true) goto L7;
        this.indicatorColors = new int[]{MaterialColors.getColor(r5, R.attr.colorPrimary, -1)};
        return;
    L7:
        if (r6.peekValue(R.styleable.BaseProgressIndicator_indicatorColor).type == 1) goto L10;
        this.indicatorColors = new int[]{r6.getColor(R.styleable.BaseProgressIndicator_indicatorColor, -1)};
        return;
    L10:
        int[] r7 = r5.getResources().getIntArray(r6.getResourceId(R.styleable.BaseProgressIndicator_indicatorColor, -1));
        this.indicatorColors = r7;
        if (r7.length == 0) goto L14;
        return;
    L14:
        throw new IllegalArgumentException("indicatorColors cannot be empty when indicatorColor is not used.");
    }

    private void loadTrackColor(Context r3, TypedArray r4) {
        if (r4.hasValue(R.styleable.BaseProgressIndicator_trackColor) == false) goto L6;
        this.trackColor = r4.getColor(R.styleable.BaseProgressIndicator_trackColor, -1);
        return;
    L6:
        this.trackColor = this.indicatorColors[0];
        TypedArray r5 = r3.getTheme().obtainStyledAttributes(new int[]{android.R.attr.disabledAlpha});
        float r6 = r5.getFloat(0, 0.2f);
        r5.recycle();
        this.trackColor = MaterialColors.compositeARGBWithAlpha(this.trackColor, (int) (r6 * 255.0f));
    }

    public boolean isShowAnimationEnabled() {
        if (this.showAnimationBehavior == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isHideAnimationEnabled() {
        if (this.hideAnimationBehavior == 0) goto L5;
        return true;
    L5:
        return false;
    }
}

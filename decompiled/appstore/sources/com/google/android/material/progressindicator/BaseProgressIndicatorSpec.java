package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StyleRes;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseProgressIndicatorSpec {
    public int hideAnimationBehavior;

    @NonNull
    public int[] indicatorColors;
    public int showAnimationBehavior;

    @ColorInt
    public int trackColor;

    @Px
    public int trackCornerRadius;

    @Px
    public int trackThickness;

    public BaseProgressIndicatorSpec(@NonNull Context r10, @Nullable AttributeSet r11, @AttrRes int r12, @StyleRes int r13) {
        this.indicatorColors = new int[0];
        int r14 = r10.getResources().getDimensionPixelSize(R.dimen.mtrl_progress_track_thickness);
        TypedArray r15 = ThemeEnforcement.obtainStyledAttributes(r10, r11, R.styleable.BaseProgressIndicator, r12, r13, new int[0]);
        this.trackThickness = MaterialResources.getDimensionPixelSize(r10, r15, R.styleable.BaseProgressIndicator_trackThickness, r14);
        this.trackCornerRadius = Math.min(MaterialResources.getDimensionPixelSize(r10, r15, R.styleable.BaseProgressIndicator_trackCornerRadius, 0), this.trackThickness / 2);
        this.showAnimationBehavior = r15.getInt(R.styleable.BaseProgressIndicator_showAnimationBehavior, 0);
        this.hideAnimationBehavior = r15.getInt(R.styleable.BaseProgressIndicator_hideAnimationBehavior, 0);
        loadIndicatorColors(r10, r15);
        loadTrackColor(r10, r15);
        r15.recycle();
    }

    private void loadIndicatorColors(@NonNull Context r10, @NonNull TypedArray r11) {
        int r12 = R.styleable.BaseProgressIndicator_indicatorColor;
        if (r11.hasValue(r12) == true) goto L7;
        this.indicatorColors = new int[]{MaterialColors.getColor(r10, R.attr.colorPrimary, -1)};
        return;
    L7:
        if (r11.peekValue(r12).type == 1) goto L10;
        this.indicatorColors = new int[]{r11.getColor(r12, -1)};
        return;
    L10:
        int[] r13 = r10.getResources().getIntArray(r11.getResourceId(r12, -1));
        this.indicatorColors = r13;
        if (r13.length == 0) goto L14;
        return;
    L14:
        throw new IllegalArgumentException("indicatorColors cannot be empty when indicatorColor is not used.");
    }

    private void loadTrackColor(@NonNull Context r10, @NonNull TypedArray r11) {
        int r12 = R.styleable.BaseProgressIndicator_trackColor;
        if (r11.hasValue(r12) == false) goto L6;
        this.trackColor = r11.getColor(r12, -1);
        return;
    L6:
        this.trackColor = this.indicatorColors[0];
        TypedArray r13 = r10.getTheme().obtainStyledAttributes(new int[]{android.R.attr.disabledAlpha});
        float r14 = r13.getFloat(0, 0.2f);
        r13.recycle();
        int r15 = (int) (r14 * 255.0f);
        this.trackColor = MaterialColors.compositeARGBWithAlpha(this.trackColor, r15);
    }

    public boolean isHideAnimationEnabled() {
        if (this.hideAnimationBehavior == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isShowAnimationEnabled() {
        if (this.showAnimationBehavior == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public abstract void validateSpec();
}

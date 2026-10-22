package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;

/* JADX INFO: loaded from: classes3.dex */
public final class LinearProgressIndicatorSpec extends BaseProgressIndicatorSpec {
    boolean drawHorizontallyInverse;
    public int indeterminateAnimationType;
    public int indicatorDirection;

    public LinearProgressIndicatorSpec(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, R.attr.linearProgressIndicatorStyle);
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicatorSpec
    public void validateSpec() {
        if (this.indeterminateAnimationType == 0) goto L5;
        return;
    L5:
        if (this.trackCornerRadius > 0) goto L12;
        if (this.indicatorColors.length < 3) goto L10;
        return;
    L10:
        throw new IllegalArgumentException("Contiguous indeterminate animation must be used with 3 or more indicator colors.");
    L12:
        throw new IllegalArgumentException("Rounded corners are not supported in contiguous indeterminate animation.");
    }

    public LinearProgressIndicatorSpec(@NonNull Context r10, @Nullable AttributeSet r11, @AttrRes int r12) {
        this(r10, r11, r12, LinearProgressIndicator.DEF_STYLE_RES);
    }

    public LinearProgressIndicatorSpec(@NonNull Context r10, @Nullable AttributeSet r11, @AttrRes int r12, @StyleRes int r13) {
        super(r10, r11, r12, r13);
        boolean r14 = false;
        TypedArray r15 = ThemeEnforcement.obtainStyledAttributes(r10, r11, R.styleable.LinearProgressIndicator, R.attr.linearProgressIndicatorStyle, LinearProgressIndicator.DEF_STYLE_RES, new int[0]);
        this.indeterminateAnimationType = r15.getInt(R.styleable.LinearProgressIndicator_indeterminateAnimationType, 1);
        this.indicatorDirection = r15.getInt(R.styleable.LinearProgressIndicator_indicatorDirectionLinear, 0);
        r15.recycle();
        validateSpec();
        if (this.indicatorDirection != 1) goto L5;
        r14 = true;
    L5:
        this.drawHorizontallyInverse = r14;
    }
}

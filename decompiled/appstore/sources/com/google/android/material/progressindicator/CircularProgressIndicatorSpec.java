package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StyleRes;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;

/* JADX INFO: loaded from: classes3.dex */
public final class CircularProgressIndicatorSpec extends BaseProgressIndicatorSpec {
    public int indicatorDirection;

    @Px
    public int indicatorInset;

    @Px
    public int indicatorSize;

    public CircularProgressIndicatorSpec(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, R.attr.circularProgressIndicatorStyle);
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicatorSpec
    public void validateSpec() {
    }

    public CircularProgressIndicatorSpec(@NonNull Context r10, @Nullable AttributeSet r11, @AttrRes int r12) {
        this(r10, r11, r12, CircularProgressIndicator.DEF_STYLE_RES);
    }

    public CircularProgressIndicatorSpec(@NonNull Context r10, @Nullable AttributeSet r11, @AttrRes int r12, @StyleRes int r13) {
        super(r10, r11, r12, r13);
        int r14 = r10.getResources().getDimensionPixelSize(R.dimen.mtrl_progress_circular_size_medium);
        int r15 = r10.getResources().getDimensionPixelSize(R.dimen.mtrl_progress_circular_inset_medium);
        TypedArray r16 = ThemeEnforcement.obtainStyledAttributes(r10, r11, R.styleable.CircularProgressIndicator, r12, r13, new int[0]);
        this.indicatorSize = Math.max(MaterialResources.getDimensionPixelSize(r10, r16, R.styleable.CircularProgressIndicator_indicatorSize, r14), this.trackThickness * 2);
        this.indicatorInset = MaterialResources.getDimensionPixelSize(r10, r16, R.styleable.CircularProgressIndicator_indicatorInset, r15);
        this.indicatorDirection = r16.getInt(R.styleable.CircularProgressIndicator_indicatorDirectionCircular, 0);
        r16.recycle();
        validateSpec();
    }
}

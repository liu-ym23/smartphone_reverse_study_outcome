package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;

/* JADX INFO: loaded from: classes2.dex */
public final class CircularProgressIndicatorSpec extends BaseProgressIndicatorSpec {
    public int indicatorDirection;
    public int indicatorInset;
    public int indicatorSize;

    @Override // com.google.android.material.progressindicator.BaseProgressIndicatorSpec
    void validateSpec() {
    }

    public CircularProgressIndicatorSpec(Context r2, AttributeSet r3) {
        this(r2, r3, R.attr.circularProgressIndicatorStyle);
    }

    public CircularProgressIndicatorSpec(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, CircularProgressIndicator.DEF_STYLE_RES);
    }

    public CircularProgressIndicatorSpec(Context r10, AttributeSet r11, int r12, int r13) {
        super(r10, r11, r12, r13);
        int r0 = r10.getResources().getDimensionPixelSize(R.dimen.mtrl_progress_circular_size_medium);
        int r1 = r10.getResources().getDimensionPixelSize(R.dimen.mtrl_progress_circular_inset_medium);
        TypedArray r14 = ThemeEnforcement.obtainStyledAttributes(r10, r11, R.styleable.CircularProgressIndicator, r12, r13, new int[0]);
        this.indicatorSize = Math.max(MaterialResources.getDimensionPixelSize(r10, r14, R.styleable.CircularProgressIndicator_indicatorSize, r0), this.trackThickness * 2);
        this.indicatorInset = MaterialResources.getDimensionPixelSize(r10, r14, R.styleable.CircularProgressIndicator_indicatorInset, r1);
        this.indicatorDirection = r14.getInt(R.styleable.CircularProgressIndicator_indicatorDirectionCircular, 0);
        r14.recycle();
        validateSpec();
    }
}

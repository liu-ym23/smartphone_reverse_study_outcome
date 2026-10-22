package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
public final class LinearProgressIndicator extends BaseProgressIndicator<LinearProgressIndicatorSpec> {
    public static final int DEF_STYLE_RES = 0;
    public static final int INDETERMINATE_ANIMATION_TYPE_CONTIGUOUS = 0;
    public static final int INDETERMINATE_ANIMATION_TYPE_DISJOINT = 1;
    public static final int INDICATOR_DIRECTION_END_TO_START = 3;
    public static final int INDICATOR_DIRECTION_LEFT_TO_RIGHT = 0;
    public static final int INDICATOR_DIRECTION_RIGHT_TO_LEFT = 1;
    public static final int INDICATOR_DIRECTION_START_TO_END = 2;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface IndeterminateAnimationType {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface IndicatorDirection {
    }

    static {
        DEF_STYLE_RES = R.style.Widget_MaterialComponents_LinearProgressIndicator;
    }

    public LinearProgressIndicator(@NonNull Context r10) {
        this(r10, null);
    }

    private void initializeDrawables() {
        setIndeterminateDrawable(IndeterminateDrawable.createLinearDrawable(getContext(), (LinearProgressIndicatorSpec) this.spec));
        setProgressDrawable(DeterminateDrawable.createLinearDrawable(getContext(), (LinearProgressIndicatorSpec) this.spec));
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public /* bridge */ /* synthetic */ BaseProgressIndicatorSpec createSpec(@NonNull Context r10, @NonNull AttributeSet r11) {
        return createSpec(r10, r11);
    }

    public int getIndeterminateAnimationType() {
        return ((LinearProgressIndicatorSpec) this.spec).indeterminateAnimationType;
    }

    public int getIndicatorDirection() {
        return ((LinearProgressIndicatorSpec) this.spec).indicatorDirection;
    }

    @Override // android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        S r15 = this.spec;
        LinearProgressIndicatorSpec r16 = (LinearProgressIndicatorSpec) r15;
        boolean r17 = true;
        if (((LinearProgressIndicatorSpec) r15).indicatorDirection != 1) goto L5;
    L14:
        r16.drawHorizontallyInverse = r17;
        return;
    L5:
        if (ViewCompat.A(this) != 1) goto L9;
        if (((LinearProgressIndicatorSpec) this.spec).indicatorDirection == 2) goto L14;
    L9:
        if (ViewCompat.A(this) == 0) goto L11;
    L13:
        r17 = false;
        goto L14
    L11:
        if (((LinearProgressIndicatorSpec) this.spec).indicatorDirection != 3) goto L13;
        goto L13
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onSizeChanged(int r10, int r11, int r12, int r13) {
        int r14 = r10 - (getPaddingLeft() + getPaddingRight());
        int r15 = r11 - (getPaddingTop() + getPaddingBottom());
        IndeterminateDrawable<LinearProgressIndicatorSpec> r16 = getIndeterminateDrawable();
        if (r16 == null) goto L5;
        r16.setBounds(0, 0, r14, r15);
    L5:
        DeterminateDrawable<LinearProgressIndicatorSpec> r17 = getProgressDrawable();
        if (r17 == null) goto L9;
        r17.setBounds(0, 0, r14, r15);
        return;
    }

    public void setIndeterminateAnimationType(int r10) {
        if (((LinearProgressIndicatorSpec) this.spec).indeterminateAnimationType != r10) goto L6;
        return;
    L6:
        if (visibleToUser() == true) goto L8;
    L12:
        S r11 = this.spec;
        ((LinearProgressIndicatorSpec) r11).indeterminateAnimationType = r10;
        ((LinearProgressIndicatorSpec) r11).validateSpec();
        if (r10 != 0) goto L15;
        getIndeterminateDrawable().setAnimatorDelegate(new LinearIndeterminateContiguousAnimatorDelegate((LinearProgressIndicatorSpec) this.spec));
    L16:
        invalidate();
        return;
    L15:
        getIndeterminateDrawable().setAnimatorDelegate(new LinearIndeterminateDisjointAnimatorDelegate(getContext(), (LinearProgressIndicatorSpec) this.spec));
        goto L16
    L8:
        if (isIndeterminate() == false) goto L12;
        throw new IllegalStateException("Cannot change indeterminate animation type while the progress indicator is show in indeterminate mode.");
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setIndicatorColor(@NonNull int... r10) {
        super.setIndicatorColor(r10);
        ((LinearProgressIndicatorSpec) this.spec).validateSpec();
    }

    public void setIndicatorDirection(int r10) {
        S r11 = this.spec;
        ((LinearProgressIndicatorSpec) r11).indicatorDirection = r10;
        LinearProgressIndicatorSpec r12 = (LinearProgressIndicatorSpec) r11;
        boolean r13 = true;
        if (r10 != 1) goto L5;
    L14:
        r12.drawHorizontallyInverse = r13;
        invalidate();
        return;
    L5:
        if (ViewCompat.A(this) != 1) goto L9;
        if (((LinearProgressIndicatorSpec) this.spec).indicatorDirection == 2) goto L14;
    L9:
        if (ViewCompat.A(this) == 0) goto L11;
    L13:
        r13 = false;
        goto L14
    L11:
        if (r10 != 3) goto L13;
        goto L13
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setProgressCompat(int r10, boolean r11) {
        S r12 = this.spec;
        if (r12 != 0) goto L5;
    L9:
        super.setProgressCompat(r10, r11);
        return;
    L5:
        if (((LinearProgressIndicatorSpec) r12).indeterminateAnimationType != 0) goto L9;
        if (isIndeterminate() == false) goto L9;
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setTrackCornerRadius(int r10) {
        super.setTrackCornerRadius(r10);
        ((LinearProgressIndicatorSpec) this.spec).validateSpec();
        invalidate();
    }

    public LinearProgressIndicator(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, R.attr.linearProgressIndicatorStyle);
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public LinearProgressIndicatorSpec createSpec(@NonNull Context r10, @NonNull AttributeSet r11) {
        return new LinearProgressIndicatorSpec(r10, r11);
    }

    public LinearProgressIndicator(@NonNull Context r10, @Nullable AttributeSet r11, @AttrRes int r12) {
        super(r10, r11, r12, DEF_STYLE_RES);
        initializeDrawables();
    }
}

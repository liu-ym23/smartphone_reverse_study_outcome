package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
public final class CircularProgressIndicator extends BaseProgressIndicator<CircularProgressIndicatorSpec> {
    public static final int DEF_STYLE_RES = 0;
    public static final int INDICATOR_DIRECTION_CLOCKWISE = 0;
    public static final int INDICATOR_DIRECTION_COUNTERCLOCKWISE = 1;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface IndicatorDirection {
    }

    static {
        DEF_STYLE_RES = R.style.Widget_MaterialComponents_CircularProgressIndicator;
    }

    public CircularProgressIndicator(@NonNull Context r10) {
        this(r10, null);
    }

    private void initializeDrawables() {
        setIndeterminateDrawable(IndeterminateDrawable.createCircularDrawable(getContext(), (CircularProgressIndicatorSpec) this.spec));
        setProgressDrawable(DeterminateDrawable.createCircularDrawable(getContext(), (CircularProgressIndicatorSpec) this.spec));
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public /* bridge */ /* synthetic */ BaseProgressIndicatorSpec createSpec(@NonNull Context r10, @NonNull AttributeSet r11) {
        return createSpec(r10, r11);
    }

    public int getIndicatorDirection() {
        return ((CircularProgressIndicatorSpec) this.spec).indicatorDirection;
    }

    @Px
    public int getIndicatorInset() {
        return ((CircularProgressIndicatorSpec) this.spec).indicatorInset;
    }

    @Px
    public int getIndicatorSize() {
        return ((CircularProgressIndicatorSpec) this.spec).indicatorSize;
    }

    public void setIndicatorDirection(int r10) {
        ((CircularProgressIndicatorSpec) this.spec).indicatorDirection = r10;
        invalidate();
    }

    public void setIndicatorInset(@Px int r10) {
        S r11 = this.spec;
        if (((CircularProgressIndicatorSpec) r11).indicatorInset == r10) goto L6;
        ((CircularProgressIndicatorSpec) r11).indicatorInset = r10;
        invalidate();
        return;
    }

    public void setIndicatorSize(@Px int r10) {
        int r11 = Math.max(r10, getTrackThickness() * 2);
        S r12 = this.spec;
        if (((CircularProgressIndicatorSpec) r12).indicatorSize == r11) goto L6;
        ((CircularProgressIndicatorSpec) r12).indicatorSize = r11;
        ((CircularProgressIndicatorSpec) r12).validateSpec();
        invalidate();
        return;
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setTrackThickness(int r10) {
        super.setTrackThickness(r10);
        ((CircularProgressIndicatorSpec) this.spec).validateSpec();
    }

    public CircularProgressIndicator(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, R.attr.circularProgressIndicatorStyle);
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public CircularProgressIndicatorSpec createSpec(@NonNull Context r10, @NonNull AttributeSet r11) {
        return new CircularProgressIndicatorSpec(r10, r11);
    }

    public CircularProgressIndicator(@NonNull Context r10, @Nullable AttributeSet r11, @AttrRes int r12) {
        super(r10, r11, r12, DEF_STYLE_RES);
        initializeDrawables();
    }
}

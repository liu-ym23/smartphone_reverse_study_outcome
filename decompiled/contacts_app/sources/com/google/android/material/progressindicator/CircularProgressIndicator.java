package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public final class CircularProgressIndicator extends BaseProgressIndicator<CircularProgressIndicatorSpec> {
    public static final int DEF_STYLE_RES = 0;
    public static final int INDICATOR_DIRECTION_CLOCKWISE = 0;
    public static final int INDICATOR_DIRECTION_COUNTERCLOCKWISE = 1;

    @Retention(RetentionPolicy.SOURCE)
    public @interface IndicatorDirection {
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    /* bridge */ /* synthetic */ BaseProgressIndicatorSpec createSpec(Context r1, AttributeSet r2) {
        return createSpec(r1, r2);
    }

    static {
        DEF_STYLE_RES = R.style.Widget_MaterialComponents_CircularProgressIndicator;
    }

    public CircularProgressIndicator(Context r2) {
        this(r2, null);
    }

    public CircularProgressIndicator(Context r2, AttributeSet r3) {
        this(r2, r3, R.attr.circularProgressIndicatorStyle);
    }

    public CircularProgressIndicator(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4, DEF_STYLE_RES);
        initializeDrawables();
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    CircularProgressIndicatorSpec createSpec(Context r1, AttributeSet r2) {
        return new CircularProgressIndicatorSpec(r1, r2);
    }

    private void initializeDrawables() {
        setIndeterminateDrawable(IndeterminateDrawable.createCircularDrawable(getContext(), (CircularProgressIndicatorSpec) this.spec));
        setProgressDrawable(DeterminateDrawable.createCircularDrawable(getContext(), (CircularProgressIndicatorSpec) this.spec));
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setTrackThickness(int r1) {
        super.setTrackThickness(r1);
        ((CircularProgressIndicatorSpec) this.spec).validateSpec();
    }

    public int getIndicatorInset() {
        return ((CircularProgressIndicatorSpec) this.spec).indicatorInset;
    }

    public void setIndicatorInset(int r2) {
        if (((CircularProgressIndicatorSpec) this.spec).indicatorInset == r2) goto L6;
        ((CircularProgressIndicatorSpec) this.spec).indicatorInset = r2;
        invalidate();
        return;
    }

    public int getIndicatorSize() {
        return ((CircularProgressIndicatorSpec) this.spec).indicatorSize;
    }

    public void setIndicatorSize(int r2) {
        int r3 = Math.max(r2, getTrackThickness() * 2);
        if (((CircularProgressIndicatorSpec) this.spec).indicatorSize == r3) goto L6;
        ((CircularProgressIndicatorSpec) this.spec).indicatorSize = r3;
        ((CircularProgressIndicatorSpec) this.spec).validateSpec();
        invalidate();
        return;
    }

    public int getIndicatorDirection() {
        return ((CircularProgressIndicatorSpec) this.spec).indicatorDirection;
    }

    public void setIndicatorDirection(int r2) {
        ((CircularProgressIndicatorSpec) this.spec).indicatorDirection = r2;
        invalidate();
    }
}

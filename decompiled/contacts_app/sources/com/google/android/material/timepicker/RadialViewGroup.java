package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RelativeCornerSize;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class RadialViewGroup extends ConstraintLayout {
    static final int LEVEL_1 = 1;
    static final int LEVEL_2 = 2;
    static final float LEVEL_RADIUS_RATIO = 0.66f;
    private static final String SKIP_TAG = "skip";
    private MaterialShapeDrawable background;
    private int radius;
    private final Runnable updateLayoutParametersRunnable;

    public RadialViewGroup(Context r2) {
        this(r2, null);
    }

    public RadialViewGroup(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public RadialViewGroup(Context r3, AttributeSet r4, int r5) {
        super(r3, r4, r5);
        LayoutInflater.from(r3).inflate(R.layout.material_radial_view_group, this);
        ViewCompat.setBackground(this, createBackground());
        TypedArray r6 = r3.obtainStyledAttributes(r4, R.styleable.RadialViewGroup, r5, 0);
        this.radius = r6.getDimensionPixelSize(R.styleable.RadialViewGroup_materialCircleRadius, 0);
        this.updateLayoutParametersRunnable = new RadialViewGroup$$ExternalSyntheticLambda0(this);
        r6.recycle();
    }

    private Drawable createBackground() {
        MaterialShapeDrawable r0 = new MaterialShapeDrawable();
        this.background = r0;
        r0.setCornerSize(new RelativeCornerSize(0.5f));
        this.background.setFillColor(ColorStateList.valueOf(-1));
        return this.background;
    }

    @Override // android.view.View
    public void setBackgroundColor(int r1) {
        this.background.setFillColor(ColorStateList.valueOf(r1));
    }

    @Override // android.view.ViewGroup
    public void addView(View r1, int r2, ViewGroup.LayoutParams r3) {
        super.addView(r1, r2, r3);
        if (r1.getId() != (-1)) goto L5;
        r1.setId(ViewCompat.generateViewId());
    L5:
        updateLayoutParamsAsync();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View r1) {
        super.onViewRemoved(r1);
        updateLayoutParamsAsync();
    }

    private void updateLayoutParamsAsync() {
        Handler r0 = getHandler();
        if (r0 == null) goto L6;
        r0.removeCallbacks(this.updateLayoutParametersRunnable);
        r0.post(this.updateLayoutParametersRunnable);
        return;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        updateLayoutParams();
    }

    protected void updateLayoutParams() {
        ConstraintSet r0 = new ConstraintSet();
        r0.clone(this);
        HashMap r1 = new HashMap();
        int r2 = 0;
    L4:
        if (r2 >= getChildCount()) goto L18;
        View r3 = getChildAt(r2);
        if (r3.getId() == R.id.circle_center) goto L17;
        if (shouldSkipView(r3) == true) goto L17;
        int r4 = (Integer) r3.getTag(R.id.material_clock_level);
        if (r4 != null) goto L14;
        r4 = 1;
    L14:
        if (r1.containsKey(r4) == true) goto L16;
        r1.put(r4, new ArrayList());
    L16:
        ((List) r1.get(r4)).add(r3);
    L17:
        r2 = r2 + 1;
        goto L4
    L18:
        Iterator r5 = r1.entrySet().iterator();
    L20:
        if (r5.hasNext() == false) goto L22;
        Map.Entry r6 = (Map.Entry) r5.next();
        addConstraints((List) r6.getValue(), r0, getLeveledRadius(((Integer) r6.getKey()).intValue()));
        goto L20
    L22:
        r0.applyTo(this);
    }

    private void addConstraints(List<View> r4, ConstraintSet r5, int r6) {
        Iterator<View> r3 = r4.iterator();
        float r0 = 0.0f;
    L4:
        if (r3.hasNext() == false) goto L6;
        r5.constrainCircle(r3.next().getId(), R.id.circle_center, r6, r0);
        r0 = r0 + (360.0f / r4.size());
        goto L4
    }

    public void setRadius(int r1) {
        this.radius = r1;
        updateLayoutParams();
    }

    public int getRadius() {
        return this.radius;
    }

    int getLeveledRadius(int r2) {
        int r1 = this.radius;
        if (r2 == 2) goto L5;
        return r1;
    L5:
        return Math.round(r1 * LEVEL_RADIUS_RATIO);
    }

    private static boolean shouldSkipView(View r1) {
        return SKIP_TAG.equals(r1.getTag());
    }
}

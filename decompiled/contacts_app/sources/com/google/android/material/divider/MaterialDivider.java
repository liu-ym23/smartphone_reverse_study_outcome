package com.google.android.material.divider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialDivider extends View {
    private static final int DEF_STYLE_RES = 0;
    private int color;
    private final MaterialShapeDrawable dividerDrawable;
    private int insetEnd;
    private int insetStart;
    private int thickness;

    static {
        DEF_STYLE_RES = R.style.Widget_MaterialComponents_MaterialDivider;
    }

    public MaterialDivider(Context r2) {
        this(r2, null);
    }

    public MaterialDivider(Context r2, AttributeSet r3) {
        this(r2, r3, R.attr.materialDividerStyle);
    }

    public MaterialDivider(Context r8, AttributeSet r9, int r10) {
        int r4 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r8, r9, r10, r4), r9, r10);
        Context r11 = getContext();
        this.dividerDrawable = new MaterialShapeDrawable();
        TypedArray r12 = ThemeEnforcement.obtainStyledAttributes(r11, r9, R.styleable.MaterialDivider, r10, r4, new int[0]);
        this.thickness = r12.getDimensionPixelSize(R.styleable.MaterialDivider_dividerThickness, getResources().getDimensionPixelSize(R.dimen.material_divider_thickness));
        this.insetStart = r12.getDimensionPixelOffset(R.styleable.MaterialDivider_dividerInsetStart, 0);
        this.insetEnd = r12.getDimensionPixelOffset(R.styleable.MaterialDivider_dividerInsetEnd, 0);
        setDividerColor(MaterialResources.getColorStateList(r11, r12, R.styleable.MaterialDivider_dividerColor).getDefaultColor());
        r12.recycle();
    }

    @Override // android.view.View
    protected void onMeasure(int r2, int r3) {
        super.onMeasure(r2, r3);
        int r4 = View.MeasureSpec.getMode(r3);
        int r5 = getMeasuredHeight();
        if (r4 == Integer.MIN_VALUE) goto L5;
        if (r4 == 0) goto L5;
        return;
    L5:
        int r6 = this.thickness;
        if (r6 <= 0) goto L9;
        if (r5 == r6) goto L9;
        r5 = r6;
    L9:
        setMeasuredDimension(getMeasuredWidth(), r5);
    }

    @Override // android.view.View
    protected void onDraw(Canvas r7) {
        super.onDraw(r7);
        boolean r2 = true;
        if (ViewCompat.getLayoutDirection(this) == 1) goto L6;
        r2 = false;
    L6:
        if (r2 == false) goto L8;
        int r0 = this.insetEnd;
    L9:
        if (r2 == false) goto L11;
        int r3 = getWidth();
        int r4 = this.insetStart;
    L12:
        this.dividerDrawable.setBounds(r0, 0, r3 - r4, getBottom() - getTop());
        this.dividerDrawable.draw(r7);
        return;
    L11:
        r3 = getWidth();
        r4 = this.insetEnd;
        goto L12
    L8:
        r0 = this.insetStart;
        goto L9
    }

    public void setDividerThickness(int r2) {
        if (this.thickness == r2) goto L6;
        this.thickness = r2;
        requestLayout();
        return;
    }

    public void setDividerThicknessResource(int r2) {
        setDividerThickness(getContext().getResources().getDimensionPixelSize(r2));
    }

    public int getDividerThickness() {
        return this.thickness;
    }

    public void setDividerInsetStart(int r1) {
        this.insetStart = r1;
    }

    public void setDividerInsetStartResource(int r2) {
        setDividerInsetStart(getContext().getResources().getDimensionPixelOffset(r2));
    }

    public int getDividerInsetStart() {
        return this.insetStart;
    }

    public void setDividerInsetEnd(int r1) {
        this.insetEnd = r1;
    }

    public void setDividerInsetEndResource(int r2) {
        setDividerInsetEnd(getContext().getResources().getDimensionPixelOffset(r2));
    }

    public int getDividerInsetEnd() {
        return this.insetEnd;
    }

    public void setDividerColor(int r2) {
        if (this.color == r2) goto L6;
        this.color = r2;
        this.dividerDrawable.setFillColor(ColorStateList.valueOf(r2));
        invalidate();
        return;
    }

    public void setDividerColorResource(int r2) {
        setDividerColor(ContextCompat.getColor(getContext(), r2));
    }

    public int getDividerColor() {
        return this.color;
    }
}

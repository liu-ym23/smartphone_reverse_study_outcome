package com.google.android.material.divider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.google.android.material.g.c;
import com.google.android.material.internal.l;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.theme.a.a;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialDivider extends View {
    private static final int DEF_STYLE_RES = 0;
    private int color;
    private final MaterialShapeDrawable dividerDrawable;
    private int insetEnd;
    private int insetStart;
    private int thickness;

    static {
        DEF_STYLE_RES = ZeusTransformUtils.mapRes(R.style.Widget_MaterialComponents_MaterialDivider, "style", "Widget_MaterialComponents_MaterialDivider");
    }

    public MaterialDivider(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null);
    }

    public MaterialDivider(Context r4, AttributeSet r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.attr.materialDividerStyle, "attr", "materialDividerStyle"));
    }

    public MaterialDivider(Context r9, AttributeSet r10, int r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r3 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        int r6 = DEF_STYLE_RES;
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(a.a(r12, r3, r11, r6), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r3, r11);
        Context r13 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        this.dividerDrawable = new MaterialShapeDrawable();
        TypedArray r14 = l.a(r13, r3, R.styleable.MaterialDivider, r11, r6, new int[0]);
        this.thickness = r14.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.MaterialDivider_dividerThickness, "styleable", "MaterialDivider_dividerThickness"), ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.material_divider_thickness, "dimen", "material_divider_thickness")));
        this.insetStart = r14.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.styleable.MaterialDivider_dividerInsetStart, "styleable", "MaterialDivider_dividerInsetStart"), 0);
        this.insetEnd = r14.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.styleable.MaterialDivider_dividerInsetEnd, "styleable", "MaterialDivider_dividerInsetEnd"), 0);
        setDividerColor(c.a(r13, r14, ZeusTransformUtils.mapRes(R.styleable.MaterialDivider_dividerColor, "styleable", "MaterialDivider_dividerColor")).getDefaultColor());
        r14.recycle();
    }

    @Override // android.view.View
    public void onMeasure(int r2, int r3) {
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
    public void onDraw(Canvas r7) {
        super.onDraw(r7);
        boolean r2 = true;
        if (ViewCompat.i(this) == 1) goto L6;
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

    public void setDividerThicknessResource(int r4) {
        setDividerThickness(ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDimensionPixelSize(r4));
    }

    public int getDividerThickness() {
        return this.thickness;
    }

    public void setDividerInsetStart(int r1) {
        this.insetStart = r1;
    }

    public void setDividerInsetStartResource(int r4) {
        setDividerInsetStart(ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDimensionPixelOffset(r4));
    }

    public int getDividerInsetStart() {
        return this.insetStart;
    }

    public void setDividerInsetEnd(int r1) {
        this.insetEnd = r1;
    }

    public void setDividerInsetEndResource(int r4) {
        setDividerInsetEnd(ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDimensionPixelOffset(r4));
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

    public void setDividerColorResource(int r4) {
        setDividerColor(androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4));
    }

    public int getDividerColor() {
        return this.color;
    }
}

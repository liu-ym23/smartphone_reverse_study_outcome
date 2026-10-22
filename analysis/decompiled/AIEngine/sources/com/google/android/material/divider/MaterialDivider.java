package com.google.android.material.divider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import b5.a;
import com.google.android.material.internal.i;
import com.stepos.aiengine.R;
import w4.c;
import y4.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class MaterialDivider extends View {

    /* renamed from: a, reason: collision with root package name */
    public final g f4992a;

    /* renamed from: b, reason: collision with root package name */
    public int f4993b;

    /* renamed from: c, reason: collision with root package name */
    public int f4994c;

    /* renamed from: d, reason: collision with root package name */
    public int f4995d;

    /* renamed from: e, reason: collision with root package name */
    public int f4996e;

    public MaterialDivider(Context context, AttributeSet attributeSet) {
        super(a.a(context, attributeSet, R.attr.materialDividerStyle, R.style.Widget_MaterialComponents_MaterialDivider), attributeSet, R.attr.materialDividerStyle);
        Context context2 = getContext();
        this.f4992a = new g();
        TypedArray typedArrayD = i.d(context2, attributeSet, k4.a.f9914t, R.attr.materialDividerStyle, R.style.Widget_MaterialComponents_MaterialDivider, new int[0]);
        this.f4993b = typedArrayD.getDimensionPixelSize(3, getResources().getDimensionPixelSize(R.dimen.material_divider_thickness));
        this.f4995d = typedArrayD.getDimensionPixelOffset(2, 0);
        this.f4996e = typedArrayD.getDimensionPixelOffset(1, 0);
        setDividerColor(c.a(context2, typedArrayD, 0).getDefaultColor());
        typedArrayD.recycle();
    }

    public int getDividerColor() {
        return this.f4994c;
    }

    public int getDividerInsetEnd() {
        return this.f4996e;
    }

    public int getDividerInsetStart() {
        return this.f4995d;
    }

    public int getDividerThickness() {
        return this.f4993b;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int width;
        int i10;
        super.onDraw(canvas);
        boolean z = getLayoutDirection() == 1;
        int i11 = z ? this.f4996e : this.f4995d;
        if (z) {
            width = getWidth();
            i10 = this.f4995d;
        } else {
            width = getWidth();
            i10 = this.f4996e;
        }
        int i12 = width - i10;
        int bottom = getBottom() - getTop();
        g gVar = this.f4992a;
        gVar.setBounds(i11, 0, i12, bottom);
        gVar.draw(canvas);
    }

    @Override // android.view.View
    public final void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int mode = View.MeasureSpec.getMode(i11);
        int measuredHeight = getMeasuredHeight();
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int i12 = this.f4993b;
            if (i12 > 0 && measuredHeight != i12) {
                measuredHeight = i12;
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
    }

    public void setDividerColor(int i10) {
        if (this.f4994c != i10) {
            this.f4994c = i10;
            this.f4992a.n(ColorStateList.valueOf(i10));
            invalidate();
        }
    }

    public void setDividerColorResource(int i10) {
        setDividerColor(getContext().getColor(i10));
    }

    public void setDividerInsetEnd(int i10) {
        this.f4996e = i10;
    }

    public void setDividerInsetEndResource(int i10) {
        setDividerInsetEnd(getContext().getResources().getDimensionPixelOffset(i10));
    }

    public void setDividerInsetStart(int i10) {
        this.f4995d = i10;
    }

    public void setDividerInsetStartResource(int i10) {
        setDividerInsetStart(getContext().getResources().getDimensionPixelOffset(i10));
    }

    public void setDividerThickness(int i10) {
        if (this.f4993b != i10) {
            this.f4993b = i10;
            requestLayout();
        }
    }

    public void setDividerThicknessResource(int i10) {
        setDividerThickness(getContext().getResources().getDimensionPixelSize(i10));
    }
}

package com.google.android.material.divider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.stepos.stepclaw.R;
import k4.v;
import p1.k;
import t1.j;
import x1.a;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class MaterialDivider extends View {

    /* renamed from: a, reason: collision with root package name */
    public final j f1312a;

    /* renamed from: b, reason: collision with root package name */
    public int f1313b;

    /* renamed from: c, reason: collision with root package name */
    public int f1314c;
    public int d;

    /* renamed from: e, reason: collision with root package name */
    public int f1315e;

    public MaterialDivider(Context context, AttributeSet attributeSet) {
        super(a.a(context, attributeSet, R.attr.materialDividerStyle, R.style.Widget_MaterialComponents_MaterialDivider), attributeSet, R.attr.materialDividerStyle);
        Context context2 = getContext();
        this.f1312a = new j();
        TypedArray typedArrayE = k.e(context2, attributeSet, d1.a.f1770l, R.attr.materialDividerStyle, R.style.Widget_MaterialComponents_MaterialDivider, new int[0]);
        this.f1313b = typedArrayE.getDimensionPixelSize(3, getResources().getDimensionPixelSize(R.dimen.material_divider_thickness));
        this.d = typedArrayE.getDimensionPixelOffset(2, 0);
        this.f1315e = typedArrayE.getDimensionPixelOffset(1, 0);
        setDividerColor(v.D(context2, typedArrayE, 0).getDefaultColor());
        typedArrayE.recycle();
    }

    public int getDividerColor() {
        return this.f1314c;
    }

    public int getDividerInsetEnd() {
        return this.f1315e;
    }

    public int getDividerInsetStart() {
        return this.d;
    }

    public int getDividerThickness() {
        return this.f1313b;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int width;
        int i8;
        super.onDraw(canvas);
        boolean z = getLayoutDirection() == 1;
        int i9 = z ? this.f1315e : this.d;
        if (z) {
            width = getWidth();
            i8 = this.d;
        } else {
            width = getWidth();
            i8 = this.f1315e;
        }
        int i10 = width - i8;
        int bottom = getBottom() - getTop();
        j jVar = this.f1312a;
        jVar.setBounds(i9, 0, i10, bottom);
        jVar.draw(canvas);
    }

    @Override // android.view.View
    public final void onMeasure(int i8, int i9) {
        super.onMeasure(i8, i9);
        int mode = View.MeasureSpec.getMode(i9);
        int measuredHeight = getMeasuredHeight();
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int i10 = this.f1313b;
            if (i10 > 0 && measuredHeight != i10) {
                measuredHeight = i10;
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
    }

    public void setDividerColor(int i8) {
        if (this.f1314c != i8) {
            this.f1314c = i8;
            this.f1312a.m(ColorStateList.valueOf(i8));
            invalidate();
        }
    }

    public void setDividerColorResource(int i8) {
        setDividerColor(getContext().getColor(i8));
    }

    public void setDividerInsetEnd(int i8) {
        this.f1315e = i8;
    }

    public void setDividerInsetEndResource(int i8) {
        setDividerInsetEnd(getContext().getResources().getDimensionPixelOffset(i8));
    }

    public void setDividerInsetStart(int i8) {
        this.d = i8;
    }

    public void setDividerInsetStartResource(int i8) {
        setDividerInsetStart(getContext().getResources().getDimensionPixelOffset(i8));
    }

    public void setDividerThickness(int i8) {
        if (this.f1313b != i8) {
            this.f1313b = i8;
            requestLayout();
        }
    }

    public void setDividerThicknessResource(int i8) {
        setDividerThickness(getContext().getResources().getDimensionPixelSize(i8));
    }
}

package com.google.android.material.divider;

import W2.c;
import Z2.h;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.a;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.r;
import d3.C3953a;

/* loaded from: classes2.dex */
public class MaterialDivider extends View {

    /* renamed from: f, reason: collision with root package name */
    public static final int f20867f = R$style.Widget_MaterialComponents_MaterialDivider;

    /* renamed from: a, reason: collision with root package name */
    public final h f20868a;

    /* renamed from: b, reason: collision with root package name */
    public int f20869b;

    /* renamed from: c, reason: collision with root package name */
    public int f20870c;

    /* renamed from: d, reason: collision with root package name */
    public int f20871d;

    /* renamed from: e, reason: collision with root package name */
    public int f20872e;

    public MaterialDivider(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialDividerStyle);
    }

    public int getDividerColor() {
        return this.f20870c;
    }

    public int getDividerInsetEnd() {
        return this.f20872e;
    }

    public int getDividerInsetStart() {
        return this.f20871d;
    }

    public int getDividerThickness() {
        return this.f20869b;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int width;
        int i10;
        super.onDraw(canvas);
        boolean z10 = getLayoutDirection() == 1;
        int i11 = z10 ? this.f20872e : this.f20871d;
        if (z10) {
            width = getWidth();
            i10 = this.f20871d;
        } else {
            width = getWidth();
            i10 = this.f20872e;
        }
        this.f20868a.setBounds(i11, 0, width - i10, getBottom() - getTop());
        this.f20868a.draw(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int mode = View.MeasureSpec.getMode(i11);
        int measuredHeight = getMeasuredHeight();
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int i12 = this.f20869b;
            if (i12 > 0 && measuredHeight != i12) {
                measuredHeight = i12;
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
    }

    public void setDividerColor(int i10) {
        if (this.f20870c != i10) {
            this.f20870c = i10;
            this.f20868a.g0(ColorStateList.valueOf(i10));
            invalidate();
        }
    }

    public void setDividerColorResource(int i10) {
        setDividerColor(a.c(getContext(), i10));
    }

    public void setDividerInsetEnd(int i10) {
        this.f20872e = i10;
    }

    public void setDividerInsetEndResource(int i10) {
        setDividerInsetEnd(getContext().getResources().getDimensionPixelOffset(i10));
    }

    public void setDividerInsetStart(int i10) {
        this.f20871d = i10;
    }

    public void setDividerInsetStartResource(int i10) {
        setDividerInsetStart(getContext().getResources().getDimensionPixelOffset(i10));
    }

    public void setDividerThickness(int i10) {
        if (this.f20869b != i10) {
            this.f20869b = i10;
            requestLayout();
        }
    }

    public void setDividerThicknessResource(int i10) {
        setDividerThickness(getContext().getResources().getDimensionPixelSize(i10));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialDivider(Context context, AttributeSet attributeSet, int i10) {
        int i11 = f20867f;
        super(C3953a.d(context, attributeSet, i10, i11), attributeSet, i10);
        Context context2 = getContext();
        this.f20868a = new h();
        TypedArray typedArrayI = r.i(context2, attributeSet, R$styleable.MaterialDivider, i10, i11, new int[0]);
        this.f20869b = typedArrayI.getDimensionPixelSize(R$styleable.MaterialDivider_dividerThickness, getResources().getDimensionPixelSize(R$dimen.material_divider_thickness));
        this.f20871d = typedArrayI.getDimensionPixelOffset(R$styleable.MaterialDivider_dividerInsetStart, 0);
        this.f20872e = typedArrayI.getDimensionPixelOffset(R$styleable.MaterialDivider_dividerInsetEnd, 0);
        setDividerColor(c.a(context2, typedArrayI, R$styleable.MaterialDivider_dividerColor).getDefaultColor());
        typedArrayI.recycle();
    }
}

package com.google.android.material.divider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.content.ContextCompat;
import c3.AbstractC0873c;
import com.stepos.ability.R;
import e3.k;
import i3.a;

/* loaded from: classes3.dex */
public class MaterialDivider extends View {

    /* renamed from: a, reason: collision with root package name */
    public final k f2443a;
    public int b;
    public int c;
    public int d;
    public int e;

    public MaterialDivider(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(a.a(context, attributeSet, R.attr.materialDividerStyle, R.style.Widget_MaterialComponents_MaterialDivider), attributeSet, R.attr.materialDividerStyle);
        Context context2 = getContext();
        this.f2443a = new k();
        TypedArray typedArrayD = com.google.android.material.internal.k.d(context2, attributeSet, P2.a.u, R.attr.materialDividerStyle, R.style.Widget_MaterialComponents_MaterialDivider, new int[0]);
        this.b = typedArrayD.getDimensionPixelSize(3, getResources().getDimensionPixelSize(R.dimen.material_divider_thickness));
        this.d = typedArrayD.getDimensionPixelOffset(2, 0);
        this.e = typedArrayD.getDimensionPixelOffset(1, 0);
        setDividerColor(AbstractC0873c.a(context2, typedArrayD, 0).getDefaultColor());
        typedArrayD.recycle();
    }

    public int getDividerColor() {
        return this.c;
    }

    @Px
    public int getDividerInsetEnd() {
        return this.e;
    }

    @Px
    public int getDividerInsetStart() {
        return this.d;
    }

    public int getDividerThickness() {
        return this.b;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int width;
        int i;
        super.onDraw(canvas);
        boolean z10 = getLayoutDirection() == 1;
        int i6 = z10 ? this.e : this.d;
        if (z10) {
            width = getWidth();
            i = this.d;
        } else {
            width = getWidth();
            i = this.e;
        }
        int i10 = width - i;
        int bottom = getBottom() - getTop();
        k kVar = this.f2443a;
        kVar.setBounds(i6, 0, i10, bottom);
        kVar.draw(canvas);
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i6) {
        super.onMeasure(i, i6);
        int mode = View.MeasureSpec.getMode(i6);
        int measuredHeight = getMeasuredHeight();
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int i10 = this.b;
            if (i10 > 0 && measuredHeight != i10) {
                measuredHeight = i10;
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
    }

    public void setDividerColor(@ColorInt int i) {
        if (this.c != i) {
            this.c = i;
            this.f2443a.q(ColorStateList.valueOf(i));
            invalidate();
        }
    }

    public void setDividerColorResource(@ColorRes int i) {
        setDividerColor(ContextCompat.getColor(getContext(), i));
    }

    public void setDividerInsetEnd(@Px int i) {
        this.e = i;
    }

    public void setDividerInsetEndResource(@DimenRes int i) {
        setDividerInsetEnd(getContext().getResources().getDimensionPixelOffset(i));
    }

    public void setDividerInsetStart(@Px int i) {
        this.d = i;
    }

    public void setDividerInsetStartResource(@DimenRes int i) {
        setDividerInsetStart(getContext().getResources().getDimensionPixelOffset(i));
    }

    public void setDividerThickness(@Px int i) {
        if (this.b != i) {
            this.b = i;
            requestLayout();
        }
    }

    public void setDividerThicknessResource(@DimenRes int i) {
        setDividerThickness(getContext().getResources().getDimensionPixelSize(i));
    }
}

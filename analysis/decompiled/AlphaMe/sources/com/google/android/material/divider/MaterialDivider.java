package com.google.android.material.divider;

import B0.f;
import C1.a;
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
import androidx.core.content.b;
import com.google.android.material.internal.l;
import com.stepos.alphame.R;
import m1.AbstractC0769a;
import y1.j;

/* loaded from: classes.dex */
public class MaterialDivider extends View {

    /* renamed from: a, reason: collision with root package name */
    public final j f10743a;

    /* renamed from: b, reason: collision with root package name */
    public int f10744b;

    /* renamed from: c, reason: collision with root package name */
    public int f10745c;

    /* renamed from: d, reason: collision with root package name */
    public int f10746d;

    /* renamed from: e, reason: collision with root package name */
    public int f10747e;

    public MaterialDivider(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(a.b(context, attributeSet, R.attr.materialDividerStyle, R.style.Widget_MaterialComponents_MaterialDivider), attributeSet, R.attr.materialDividerStyle);
        Context context2 = getContext();
        this.f10743a = new j();
        TypedArray typedArrayE = l.e(context2, attributeSet, AbstractC0769a.f13554t, R.attr.materialDividerStyle, R.style.Widget_MaterialComponents_MaterialDivider, new int[0]);
        this.f10744b = typedArrayE.getDimensionPixelSize(3, getResources().getDimensionPixelSize(R.dimen.material_divider_thickness));
        this.f10746d = typedArrayE.getDimensionPixelOffset(2, 0);
        this.f10747e = typedArrayE.getDimensionPixelOffset(1, 0);
        setDividerColor(f.y(context2, typedArrayE, 0).getDefaultColor());
        typedArrayE.recycle();
    }

    public int getDividerColor() {
        return this.f10745c;
    }

    @Px
    public int getDividerInsetEnd() {
        return this.f10747e;
    }

    @Px
    public int getDividerInsetStart() {
        return this.f10746d;
    }

    public int getDividerThickness() {
        return this.f10744b;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int width;
        int i4;
        super.onDraw(canvas);
        boolean z4 = getLayoutDirection() == 1;
        int i5 = z4 ? this.f10747e : this.f10746d;
        if (z4) {
            width = getWidth();
            i4 = this.f10746d;
        } else {
            width = getWidth();
            i4 = this.f10747e;
        }
        int i6 = width - i4;
        j jVar = this.f10743a;
        jVar.setBounds(i5, 0, i6, getBottom() - getTop());
        jVar.draw(canvas);
    }

    @Override // android.view.View
    public final void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        int mode = View.MeasureSpec.getMode(i5);
        int measuredHeight = getMeasuredHeight();
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int i6 = this.f10744b;
            if (i6 > 0 && measuredHeight != i6) {
                measuredHeight = i6;
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
    }

    public void setDividerColor(@ColorInt int i4) {
        if (this.f10745c != i4) {
            this.f10745c = i4;
            this.f10743a.o(ColorStateList.valueOf(i4));
            invalidate();
        }
    }

    public void setDividerColorResource(@ColorRes int i4) {
        setDividerColor(b.a(getContext(), i4));
    }

    public void setDividerInsetEnd(@Px int i4) {
        this.f10747e = i4;
    }

    public void setDividerInsetEndResource(@DimenRes int i4) {
        setDividerInsetEnd(getContext().getResources().getDimensionPixelOffset(i4));
    }

    public void setDividerInsetStart(@Px int i4) {
        this.f10746d = i4;
    }

    public void setDividerInsetStartResource(@DimenRes int i4) {
        setDividerInsetStart(getContext().getResources().getDimensionPixelOffset(i4));
    }

    public void setDividerThickness(@Px int i4) {
        if (this.f10744b != i4) {
            this.f10744b = i4;
            requestLayout();
        }
    }

    public void setDividerThicknessResource(@DimenRes int i4) {
        setDividerThickness(getContext().getResources().getDimensionPixelSize(i4));
    }
}

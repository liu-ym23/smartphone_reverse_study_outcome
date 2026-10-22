package com.google.android.material.divider;

import a1.C0409b;
import a1.C0411d;
import a1.C0417j;
import a1.C0418k;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.a;
import com.google.android.material.internal.o;
import q1.C0981c;
import t1.C1115h;
import x1.C1282a;

/* loaded from: classes.dex */
public class MaterialDivider extends View {

    /* renamed from: f, reason: collision with root package name */
    private static final int f12801f = C0417j.f6932w;

    /* renamed from: a, reason: collision with root package name */
    private final C1115h f12802a;

    /* renamed from: b, reason: collision with root package name */
    private int f12803b;

    /* renamed from: c, reason: collision with root package name */
    private int f12804c;

    /* renamed from: d, reason: collision with root package name */
    private int f12805d;

    /* renamed from: e, reason: collision with root package name */
    private int f12806e;

    public MaterialDivider(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0409b.f6732s);
    }

    public int getDividerColor() {
        return this.f12804c;
    }

    public int getDividerInsetEnd() {
        return this.f12806e;
    }

    public int getDividerInsetStart() {
        return this.f12805d;
    }

    public int getDividerThickness() {
        return this.f12803b;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        int i5;
        super.onDraw(canvas);
        boolean z5 = getLayoutDirection() == 1;
        int i6 = z5 ? this.f12806e : this.f12805d;
        if (z5) {
            width = getWidth();
            i5 = this.f12805d;
        } else {
            width = getWidth();
            i5 = this.f12806e;
        }
        this.f12802a.setBounds(i6, 0, width - i5, getBottom() - getTop());
        this.f12802a.draw(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
        int mode = View.MeasureSpec.getMode(i6);
        int measuredHeight = getMeasuredHeight();
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int i7 = this.f12803b;
            if (i7 > 0 && measuredHeight != i7) {
                measuredHeight = i7;
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
    }

    public void setDividerColor(int i5) {
        if (this.f12804c != i5) {
            this.f12804c = i5;
            this.f12802a.g0(ColorStateList.valueOf(i5));
            invalidate();
        }
    }

    public void setDividerColorResource(int i5) {
        setDividerColor(a.c(getContext(), i5));
    }

    public void setDividerInsetEnd(int i5) {
        this.f12806e = i5;
    }

    public void setDividerInsetEndResource(int i5) {
        setDividerInsetEnd(getContext().getResources().getDimensionPixelOffset(i5));
    }

    public void setDividerInsetStart(int i5) {
        this.f12805d = i5;
    }

    public void setDividerInsetStartResource(int i5) {
        setDividerInsetStart(getContext().getResources().getDimensionPixelOffset(i5));
    }

    public void setDividerThickness(int i5) {
        if (this.f12803b != i5) {
            this.f12803b = i5;
            requestLayout();
        }
    }

    public void setDividerThicknessResource(int i5) {
        setDividerThickness(getContext().getResources().getDimensionPixelSize(i5));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialDivider(Context context, AttributeSet attributeSet, int i5) {
        int i6 = f12801f;
        super(C1282a.d(context, attributeSet, i5, i6), attributeSet, i5);
        Context context2 = getContext();
        this.f12802a = new C1115h();
        TypedArray typedArrayI = o.i(context2, attributeSet, C0418k.f7130f3, i5, i6, new int[0]);
        this.f12803b = typedArrayI.getDimensionPixelSize(C0418k.f7154j3, getResources().getDimensionPixelSize(C0411d.f6747B));
        this.f12805d = typedArrayI.getDimensionPixelOffset(C0418k.f7148i3, 0);
        this.f12806e = typedArrayI.getDimensionPixelOffset(C0418k.f7142h3, 0);
        setDividerColor(C0981c.a(context2, typedArrayI, C0418k.f7136g3).getDefaultColor());
        typedArrayI.recycle();
    }
}

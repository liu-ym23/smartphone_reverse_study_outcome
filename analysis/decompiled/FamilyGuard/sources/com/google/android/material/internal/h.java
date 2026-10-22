package com.google.android.material.internal;

import a1.C0418k;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.appcompat.widget.LinearLayoutCompat;

/* loaded from: classes.dex */
public class h extends LinearLayoutCompat {

    /* renamed from: p, reason: collision with root package name */
    private Drawable f13011p;

    /* renamed from: q, reason: collision with root package name */
    private final Rect f13012q;

    /* renamed from: r, reason: collision with root package name */
    private final Rect f13013r;

    /* renamed from: s, reason: collision with root package name */
    private int f13014s;

    /* renamed from: t, reason: collision with root package name */
    protected boolean f13015t;

    /* renamed from: u, reason: collision with root package name */
    boolean f13016u;

    public h(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.f13011p;
        if (drawable != null) {
            if (this.f13016u) {
                this.f13016u = false;
                Rect rect = this.f13012q;
                Rect rect2 = this.f13013r;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.f13015t) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.f13014s, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @Override // android.view.View
    public void drawableHotspotChanged(float f5, float f6) {
        super.drawableHotspotChanged(f5, f6);
        Drawable drawable = this.f13011p;
        if (drawable != null) {
            drawable.setHotspot(f5, f6);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f13011p;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        this.f13011p.setState(getDrawableState());
    }

    @Override // android.view.View
    public Drawable getForeground() {
        return this.f13011p;
    }

    @Override // android.view.View
    public int getForegroundGravity() {
        return this.f13014s;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f13011p;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
        super.onLayout(z5, i5, i6, i7, i8);
        this.f13016u = z5 | this.f13016u;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i5, int i6, int i7, int i8) {
        super.onSizeChanged(i5, i6, i7, i8);
        this.f13016u = true;
    }

    @Override // android.view.View
    public void setForeground(Drawable drawable) {
        Drawable drawable2 = this.f13011p;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.f13011p);
            }
            this.f13011p = drawable;
            this.f13016u = true;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.f13014s == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setForegroundGravity(int i5) {
        if (this.f13014s != i5) {
            if ((8388615 & i5) == 0) {
                i5 |= 8388611;
            }
            if ((i5 & 112) == 0) {
                i5 |= 48;
            }
            this.f13014s = i5;
            if (i5 == 119 && this.f13011p != null) {
                this.f13011p.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f13011p;
    }

    public h(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f13012q = new Rect();
        this.f13013r = new Rect();
        this.f13014s = 119;
        this.f13015t = true;
        this.f13016u = false;
        TypedArray typedArrayI = o.i(context, attributeSet, C0418k.f7230w1, i5, 0, new int[0]);
        this.f13014s = typedArrayI.getInt(C0418k.f7242y1, this.f13014s);
        Drawable drawable = typedArrayI.getDrawable(C0418k.f7236x1);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.f13015t = typedArrayI.getBoolean(C0418k.f7248z1, true);
        typedArrayI.recycle();
    }
}

package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.google.android.material.R$styleable;

/* loaded from: classes2.dex */
public class h extends LinearLayoutCompat {

    /* renamed from: a, reason: collision with root package name */
    public Drawable f21082a;

    /* renamed from: b, reason: collision with root package name */
    public final Rect f21083b;

    /* renamed from: c, reason: collision with root package name */
    public final Rect f21084c;

    /* renamed from: d, reason: collision with root package name */
    public int f21085d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f21086e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f21087f;

    public h(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.f21082a;
        if (drawable != null) {
            if (this.f21087f) {
                this.f21087f = false;
                Rect rect = this.f21083b;
                Rect rect2 = this.f21084c;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.f21086e) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.f21085d, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @Override // android.view.View
    public void drawableHotspotChanged(float f10, float f11) {
        super.drawableHotspotChanged(f10, f11);
        Drawable drawable = this.f21082a;
        if (drawable != null) {
            drawable.setHotspot(f10, f11);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f21082a;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        this.f21082a.setState(getDrawableState());
    }

    @Override // android.view.View
    public Drawable getForeground() {
        return this.f21082a;
    }

    @Override // android.view.View
    public int getForegroundGravity() {
        return this.f21085d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f21082a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        this.f21087f = z10 | this.f21087f;
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f21087f = true;
    }

    @Override // android.view.View
    public void setForeground(Drawable drawable) {
        Drawable drawable2 = this.f21082a;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.f21082a);
            }
            this.f21082a = drawable;
            this.f21087f = true;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.f21085d == 119) {
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
    public void setForegroundGravity(int i10) {
        if (this.f21085d != i10) {
            if ((8388615 & i10) == 0) {
                i10 |= 8388611;
            }
            if ((i10 & 112) == 0) {
                i10 |= 48;
            }
            this.f21085d = i10;
            if (i10 == 119 && this.f21082a != null) {
                this.f21082a.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f21082a;
    }

    public h(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f21083b = new Rect();
        this.f21084c = new Rect();
        this.f21085d = 119;
        this.f21086e = true;
        this.f21087f = false;
        TypedArray typedArrayI = r.i(context, attributeSet, R$styleable.ForegroundLinearLayout, i10, 0, new int[0]);
        this.f21085d = typedArrayI.getInt(R$styleable.ForegroundLinearLayout_android_foregroundGravity, this.f21085d);
        Drawable drawable = typedArrayI.getDrawable(R$styleable.ForegroundLinearLayout_android_foreground);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.f21086e = typedArrayI.getBoolean(R$styleable.ForegroundLinearLayout_foregroundInsidePadding, true);
        typedArrayI.recycle();
    }
}

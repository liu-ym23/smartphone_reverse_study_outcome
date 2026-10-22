package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.A;
import androidx.core.view.N;
import androidx.core.view.a0;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;

/* loaded from: classes2.dex */
public class n extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public Drawable f21131a;

    /* renamed from: b, reason: collision with root package name */
    public Rect f21132b;

    /* renamed from: c, reason: collision with root package name */
    public Rect f21133c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f21134d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f21135e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f21136f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f21137g;

    public class a implements A {
        public a() {
        }

        @Override // androidx.core.view.A
        public a0 a(View view, a0 a0Var) {
            n nVar = n.this;
            if (nVar.f21132b == null) {
                nVar.f21132b = new Rect();
            }
            n.this.f21132b.set(a0Var.k(), a0Var.m(), a0Var.l(), a0Var.j());
            n.this.a(a0Var);
            n.this.setWillNotDraw(!a0Var.n() || n.this.f21131a == null);
            n.this.postInvalidateOnAnimation();
            return a0Var.c();
        }
    }

    public n(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void a(a0 a0Var) {
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f21132b == null || this.f21131a == null) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(getScrollX(), getScrollY());
        if (this.f21134d) {
            this.f21133c.set(0, 0, width, this.f21132b.top);
            this.f21131a.setBounds(this.f21133c);
            this.f21131a.draw(canvas);
        }
        if (this.f21135e) {
            this.f21133c.set(0, height - this.f21132b.bottom, width, height);
            this.f21131a.setBounds(this.f21133c);
            this.f21131a.draw(canvas);
        }
        if (this.f21136f) {
            Rect rect = this.f21133c;
            Rect rect2 = this.f21132b;
            rect.set(0, rect2.top, rect2.left, height - rect2.bottom);
            this.f21131a.setBounds(this.f21133c);
            this.f21131a.draw(canvas);
        }
        if (this.f21137g) {
            Rect rect3 = this.f21133c;
            Rect rect4 = this.f21132b;
            rect3.set(width - rect4.right, rect4.top, width, height - rect4.bottom);
            this.f21131a.setBounds(this.f21133c);
            this.f21131a.draw(canvas);
        }
        canvas.restoreToCount(iSave);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = this.f21131a;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = this.f21131a;
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public void setDrawBottomInsetForeground(boolean z10) {
        this.f21135e = z10;
    }

    public void setDrawLeftInsetForeground(boolean z10) {
        this.f21136f = z10;
    }

    public void setDrawRightInsetForeground(boolean z10) {
        this.f21137g = z10;
    }

    public void setDrawTopInsetForeground(boolean z10) {
        this.f21134d = z10;
    }

    public void setScrimInsetForeground(Drawable drawable) {
        this.f21131a = drawable;
    }

    public n(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f21133c = new Rect();
        this.f21134d = true;
        this.f21135e = true;
        this.f21136f = true;
        this.f21137g = true;
        TypedArray typedArrayI = r.i(context, attributeSet, R$styleable.ScrimInsetsFrameLayout, i10, R$style.Widget_Design_ScrimInsetsFrameLayout, new int[0]);
        this.f21131a = typedArrayI.getDrawable(R$styleable.ScrimInsetsFrameLayout_insetForeground);
        typedArrayI.recycle();
        setWillNotDraw(true);
        N.u0(this, new a());
    }
}

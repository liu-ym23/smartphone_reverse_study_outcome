package com.stepos.common.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.VectorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public class PageIndicator extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private int f14050a;

    /* renamed from: b, reason: collision with root package name */
    private int f14051b;

    /* renamed from: c, reason: collision with root package name */
    private int f14052c;

    /* renamed from: d, reason: collision with root package name */
    private int f14053d;

    /* renamed from: e, reason: collision with root package name */
    private int f14054e;

    /* renamed from: f, reason: collision with root package name */
    private int f14055f;

    /* renamed from: g, reason: collision with root package name */
    private int f14056g;

    /* renamed from: h, reason: collision with root package name */
    private int f14057h;

    public PageIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, H1.c.f2062i);
    }

    public static /* synthetic */ void a(View view, ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        Drawable background = view.getBackground();
        if (background instanceof GradientDrawable) {
            ((GradientDrawable) background).setColor(iIntValue);
        } else if (background instanceof ColorDrawable) {
            ((ColorDrawable) background).setColor(iIntValue);
        } else if (background instanceof ShapeDrawable) {
            ((ShapeDrawable) background).getPaint().setColor(iIntValue);
        } else if (background instanceof VectorDrawable) {
            Drawable drawableR = androidx.core.graphics.drawable.a.r((VectorDrawable) background);
            androidx.core.graphics.drawable.a.n(drawableR, iIntValue);
            drawableR.mutate();
            view.setBackground(drawableR);
        } else if (background != null) {
            background.setColorFilter(new PorterDuffColorFilter(iIntValue, PorterDuff.Mode.SRC_IN));
        }
        view.invalidate();
    }

    private ValueAnimator b(final View view, int i5, int i6) {
        ValueAnimator valueAnimatorOfArgb = ValueAnimator.ofArgb(i5, i6);
        valueAnimatorOfArgb.setDuration(200L);
        valueAnimatorOfArgb.setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f));
        valueAnimatorOfArgb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.common.widget.h
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                PageIndicator.a(view, valueAnimator);
            }
        });
        return valueAnimatorOfArgb;
    }

    private void c(Context context, AttributeSet attributeSet, int i5) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, H1.m.f2682w3, i5, 0);
        this.f14052c = typedArrayObtainStyledAttributes.getDimensionPixelSize(H1.m.f2700z3, N1.i.b(context, 6.0f));
        this.f14053d = typedArrayObtainStyledAttributes.getDimensionPixelSize(H1.m.f2389A3, N1.i.b(context, 10.0f));
        this.f14054e = typedArrayObtainStyledAttributes.getResourceId(H1.m.f2407D3, H1.g.f2173I);
        this.f14055f = typedArrayObtainStyledAttributes.getResourceId(H1.m.f2694y3, H1.g.f2201q);
        this.f14056g = typedArrayObtainStyledAttributes.getColor(H1.m.f2401C3, -1);
        this.f14057h = typedArrayObtainStyledAttributes.getColor(H1.m.f2688x3, -1);
        setOrientation(typedArrayObtainStyledAttributes.getInt(H1.m.f2395B3, 0) != 0 ? 1 : 0);
        typedArrayObtainStyledAttributes.recycle();
        N1.a.e(this, 2);
        d();
    }

    private void d() {
        removeAllViews();
        int iC = this.f14056g;
        if (iC == 0) {
            iC = androidx.core.content.a.c(getContext(), H1.e.f2102x);
        }
        int iC2 = this.f14057h;
        if (iC2 == 0) {
            iC2 = androidx.core.content.a.c(getContext(), H1.e.f2101w);
        }
        int i5 = 0;
        while (i5 < this.f14050a) {
            View view = new View(getContext());
            boolean z5 = i5 == this.f14051b;
            view.setBackgroundResource(z5 ? this.f14054e : this.f14055f);
            e(view, z5 ? iC2 : iC, z5 ? iC : iC2);
            view.setSelected(z5);
            int i6 = this.f14052c;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i6, i6);
            if (getOrientation() != 0) {
                layoutParams.topMargin = i5 == 0 ? 0 : this.f14053d;
            } else if (i5 != 0) {
                layoutParams.setMarginStart(this.f14053d);
            }
            addView(view, layoutParams);
            i5++;
        }
    }

    private void e(View view, int i5, int i6) {
        int i7 = H1.h.f2246e0;
        Object tag = view.getTag(i7);
        if (tag instanceof ValueAnimator) {
            ((ValueAnimator) tag).cancel();
        }
        ValueAnimator valueAnimatorB = b(view, i5, i6);
        view.setTag(i7, valueAnimatorB);
        valueAnimatorB.start();
    }

    public int getDefaultIndicatorColor() {
        return this.f14057h;
    }

    public int getItemCount() {
        return this.f14050a;
    }

    public int getSelectedIndicatorColor() {
        return this.f14056g;
    }

    public int getSelectedItemPosition() {
        return this.f14051b;
    }

    public void setDefaultIndicatorColor(int i5) {
        this.f14057h = i5;
        d();
    }

    public void setItemCount(int i5) {
        this.f14050a = i5;
        d();
    }

    public void setSelectedIndicatorColor(int i5) {
        this.f14056g = i5;
        d();
    }

    public void setSelectedItemPosition(int i5) {
        if (i5 < 0 || i5 >= getChildCount()) {
            return;
        }
        int iC = this.f14056g;
        if (iC == 0) {
            iC = androidx.core.content.a.c(getContext(), H1.e.f2102x);
        }
        int iC2 = this.f14057h;
        if (iC2 == 0) {
            iC2 = androidx.core.content.a.c(getContext(), H1.e.f2101w);
        }
        View childAt = getChildAt(this.f14051b);
        if (childAt != null) {
            childAt.setSelected(false);
            e(childAt, iC, iC2);
        }
        this.f14051b = i5;
        View childAt2 = getChildAt(i5);
        if (childAt2 != null) {
            childAt2.setSelected(true);
            e(childAt2, iC2, iC);
        }
    }

    public PageIndicator(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        c(context, attributeSet, i5);
    }
}

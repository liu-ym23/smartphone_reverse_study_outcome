package stepos.support.v7.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.coordinatorlayout.widget.ViewGroupUtils;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.appbar.AppBarLayout;
import com.stepos.ability.R;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public abstract class D extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public boolean f6447a;
    public final int b;
    public Toolbar c;
    public View d;
    public View e;
    public int f;
    public int g;
    public int h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public final Rect f6448j;
    public final A k;
    public boolean l;
    public boolean m;
    public Drawable n;
    public Drawable o;
    public int p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f6449q;

    /* renamed from: r, reason: collision with root package name */
    public ValueAnimator f6450r;

    /* renamed from: s, reason: collision with root package name */
    public long f6451s;

    /* renamed from: t, reason: collision with root package name */
    public int f6452t;
    public C1987f u;

    /* renamed from: v, reason: collision with root package name */
    public int f6453v;

    /* renamed from: w, reason: collision with root package name */
    public WindowInsetsCompat f6454w;

    public D(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.steposCollapsingToolbarLayoutStyle);
        this.f6447a = true;
        this.f6448j = new Rect();
        this.f6452t = -1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(y0.f6647a);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(0);
        typedArrayObtainStyledAttributes.recycle();
        if (!zHasValue) {
            throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
        }
        StepOSCollapsingToolbarLayout stepOSCollapsingToolbarLayout = (StepOSCollapsingToolbarLayout) this;
        A a3 = new A(stepOSCollapsingToolbarLayout);
        this.k = a3;
        a3.E = AbstractC2010z.d;
        a3.j();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, P2.a.h, R.attr.steposCollapsingToolbarLayoutStyle, R.style.Widget_Design_CollapsingToolbar);
        int i = typedArrayObtainStyledAttributes2.getInt(9, 8388691);
        if (a3.g != i) {
            a3.g = i;
            a3.j();
        }
        int i6 = typedArrayObtainStyledAttributes2.getInt(2, 8388627);
        if (a3.h != i6) {
            a3.h = i6;
            a3.j();
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes2.getDimensionPixelSize(10, 0);
        this.i = dimensionPixelSize;
        this.h = dimensionPixelSize;
        this.g = dimensionPixelSize;
        this.f = dimensionPixelSize;
        if (typedArrayObtainStyledAttributes2.hasValue(13)) {
            this.f = typedArrayObtainStyledAttributes2.getDimensionPixelSize(13, 0);
        }
        if (typedArrayObtainStyledAttributes2.hasValue(12)) {
            this.h = typedArrayObtainStyledAttributes2.getDimensionPixelSize(12, 0);
        }
        if (typedArrayObtainStyledAttributes2.hasValue(14)) {
            this.g = typedArrayObtainStyledAttributes2.getDimensionPixelSize(14, 0);
        }
        if (typedArrayObtainStyledAttributes2.hasValue(11)) {
            this.i = typedArrayObtainStyledAttributes2.getDimensionPixelSize(11, 0);
        }
        this.l = typedArrayObtainStyledAttributes2.getBoolean(28, true);
        setTitle(typedArrayObtainStyledAttributes2.getText(26));
        a3.l(R.style.TextAppearance_Design_CollapsingToolbar_Expanded);
        a3.k(androidx.appcompat.R.style.TextAppearance_AppCompat_Widget_ActionBar_Title);
        if (typedArrayObtainStyledAttributes2.hasValue(16)) {
            a3.l(typedArrayObtainStyledAttributes2.getResourceId(16, 0));
        }
        if (typedArrayObtainStyledAttributes2.hasValue(4)) {
            a3.k(typedArrayObtainStyledAttributes2.getResourceId(4, 0));
        }
        this.f6452t = typedArrayObtainStyledAttributes2.getDimensionPixelSize(22, -1);
        this.f6451s = typedArrayObtainStyledAttributes2.getInt(21, 600);
        setContentScrim(typedArrayObtainStyledAttributes2.getDrawable(6));
        setStatusBarScrim(typedArrayObtainStyledAttributes2.getDrawable(23));
        this.b = typedArrayObtainStyledAttributes2.getResourceId(32, -1);
        typedArrayObtainStyledAttributes2.recycle();
        setWillNotDraw(false);
        ViewCompat.setOnApplyWindowInsetsListener(this, new C2003s(stepOSCollapsingToolbarLayout));
    }

    public static H0 d(View view) {
        H0 h02 = (H0) view.getTag(R.id.view_offset_helper);
        if (h02 != null) {
            return h02;
        }
        H0 h03 = new H0(view);
        view.setTag(R.id.view_offset_helper, h03);
        return h03;
    }

    public abstract int a();

    public final void b() {
        if (this.f6447a) {
            Toolbar toolbar = null;
            this.c = null;
            this.d = null;
            int i = this.b;
            if (i != -1) {
                Toolbar toolbar2 = (Toolbar) findViewById(i);
                this.c = toolbar2;
                if (toolbar2 != null) {
                    ViewParent parent = toolbar2.getParent();
                    View view = toolbar2;
                    while (parent != this && parent != null) {
                        if (parent instanceof View) {
                            view = (View) parent;
                        }
                        parent = parent.getParent();
                        view = view;
                    }
                    this.d = view;
                }
            }
            if (this.c == null) {
                int childCount = getChildCount();
                int i6 = 0;
                while (true) {
                    if (i6 >= childCount) {
                        break;
                    }
                    View childAt = getChildAt(i6);
                    if (childAt instanceof Toolbar) {
                        toolbar = (Toolbar) childAt;
                        break;
                    }
                    i6++;
                }
                this.c = toolbar;
            }
            e();
            this.f6447a = false;
        }
    }

    public final int c(View view) {
        H0 h0D = d(view);
        C c = (C) view.getLayoutParams();
        int i = h0D.b;
        return ((getHeight() - Math.max(i, this.f6454w != null ? a() : i)) - view.getHeight()) - ((FrameLayout.LayoutParams) c).bottomMargin;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        Canvas canvas2;
        int iA;
        Drawable drawable;
        super.draw(canvas);
        b();
        if (this.c == null && (drawable = this.n) != null && this.p > 0) {
            drawable.mutate().setAlpha(this.p);
            this.n.draw(canvas);
        }
        if (this.l && this.m) {
            A a3 = this.k;
            TextPaint textPaint = a3.f6383D;
            int iSave = canvas.save();
            if (a3.f6399w == null || !a3.b) {
                canvas2 = canvas;
            } else {
                float f = a3.f6394q;
                float f7 = a3.f6395r + 0.0f;
                if (A.f(a3.c, 0.0f)) {
                    f7 += 0.0f;
                }
                float f9 = f7;
                textPaint.ascent();
                textPaint.descent();
                float f10 = a3.f6401z;
                if (f10 != 1.0f) {
                    canvas.scale(f10, f10, f, f9);
                }
                CharSequence charSequence = a3.f6399w;
                canvas2 = canvas;
                canvas2.drawText(charSequence, 0, charSequence.length(), f, f9, textPaint);
            }
            canvas2.restoreToCount(iSave);
        } else {
            canvas2 = canvas;
        }
        if (this.o == null || this.p <= 0 || (iA = a()) <= 0) {
            return;
        }
        this.o.setBounds(0, -this.f6453v, getWidth(), iA - this.f6453v);
        this.o.mutate().setAlpha(this.p);
        this.o.draw(canvas2);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j5) {
        boolean z10;
        View view2;
        Drawable drawable = this.n;
        if (drawable == null || this.p <= 0 || ((view2 = this.d) == null || view2 == this ? view != this.c : view != view2)) {
            z10 = false;
        } else {
            drawable.mutate().setAlpha(this.p);
            this.n.draw(canvas);
            z10 = true;
        }
        return super.drawChild(canvas, view, j5) || z10;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        ColorStateList colorStateList;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.o;
        boolean z10 = false;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState);
        Drawable drawable2 = this.n;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        A a3 = this.k;
        if (a3 != null) {
            a3.f6381B = drawableState;
            ColorStateList colorStateList2 = a3.l;
            if ((colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = a3.k) != null && colorStateList.isStateful())) {
                a3.j();
                z10 = true;
            }
            state |= z10;
        }
        if (state) {
            invalidate();
        }
    }

    public final void e() {
        View view;
        if (!this.l && (view = this.e) != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.e);
            }
        }
        if (!this.l || this.c == null) {
            return;
        }
        if (this.e == null) {
            this.e = new View(getContext());
        }
        if (this.e.getParent() == null) {
            this.c.addView(this.e, -1, -1);
        }
    }

    public final void f() {
        if (this.n == null && this.o == null) {
            return;
        }
        setScrimsShown(getHeight() + this.f6453v < getScrimVisibleHeightTrigger());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        C c = new C(-1, -1);
        c.f6446a = 0;
        c.b = 0.5f;
        return c;
    }

    public int getCollapsedTitleGravity() {
        return this.k.h;
    }

    @NonNull
    public Typeface getCollapsedTitleTypeface() {
        Typeface typeface = this.k.f6396s;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    @Nullable
    public Drawable getContentScrim() {
        return this.n;
    }

    public int getExpandedTitleGravity() {
        return this.k.g;
    }

    public int getExpandedTitleMarginBottom() {
        return this.i;
    }

    public int getExpandedTitleMarginEnd() {
        return this.h;
    }

    public int getExpandedTitleMarginStart() {
        return this.f;
    }

    public int getExpandedTitleMarginTop() {
        return this.g;
    }

    @NonNull
    public Typeface getExpandedTitleTypeface() {
        Typeface typeface = this.k.f6397t;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public int getScrimAlpha() {
        return this.p;
    }

    public long getScrimAnimationDuration() {
        return this.f6451s;
    }

    public int getScrimVisibleHeightTrigger() {
        int i = this.f6452t;
        if (i >= 0) {
            return i;
        }
        int iA = a();
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        return minimumHeight > 0 ? Math.min((minimumHeight * 2) + iA, getHeight()) : getHeight() / 3;
    }

    @Nullable
    public Drawable getStatusBarScrim() {
        return this.o;
    }

    @Nullable
    public CharSequence getTitle() {
        if (this.l) {
            return this.c.getTitle();
        }
        return null;
    }

    public O getTitleScaleControl() {
        return this.k;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Object parent = getParent();
        if (parent instanceof AppBarLayout) {
            ViewCompat.setFitsSystemWindows(this, ViewCompat.getFitsSystemWindows((View) parent));
            if (this.u == null) {
                this.u = new C1987f(this, 1);
            }
            ((AppBarLayout) parent).c(this.u);
            ViewCompat.requestApplyInsets(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        ArrayList arrayList;
        ViewParent parent = getParent();
        C1987f c1987f = this.u;
        if (c1987f != null && (parent instanceof AppBarLayout) && (arrayList = ((AppBarLayout) parent).h) != null) {
            arrayList.remove(c1987f);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i, int i6, int i10, int i11) {
        View view;
        super.onLayout(z10, i, i6, i10, i11);
        if (this.f6454w != null) {
            int iA = a();
            int childCount = getChildCount();
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = getChildAt(i12);
                if (!ViewCompat.getFitsSystemWindows(childAt) && childAt.getTop() < iA) {
                    ViewCompat.offsetTopAndBottom(childAt, iA);
                }
            }
        }
        int childCount2 = getChildCount();
        for (int i13 = 0; i13 < childCount2; i13++) {
            H0 h0D = d(getChildAt(i13));
            View view2 = h0D.f6468a;
            h0D.b = view2.getTop();
            h0D.c = view2.getLeft();
        }
        if (this.l && (view = this.e) != null) {
            boolean z11 = ViewCompat.isAttachedToWindow(view) && this.e.getVisibility() == 0;
            this.m = z11;
            if (z11) {
                boolean z12 = ViewCompat.getLayoutDirection(this) == 1;
                View view3 = this.d;
                if (view3 == null) {
                    view3 = this.c;
                }
                int iC = c(view3);
                View view4 = this.e;
                Rect rect = this.f6448j;
                ViewGroupUtils.getDescendantRect(this, view4, rect);
                int titleMarginEnd = rect.left + (z12 ? this.c.getTitleMarginEnd() : this.c.getTitleMarginStart());
                int titleMarginTop = this.c.getTitleMarginTop() + rect.top + iC;
                int titleMarginStart = rect.right + (z12 ? this.c.getTitleMarginStart() : this.c.getTitleMarginEnd());
                int titleMarginBottom = (rect.bottom + iC) - this.c.getTitleMarginBottom();
                A a3 = this.k;
                Rect rect2 = a3.e;
                if (rect2.left != titleMarginEnd || rect2.top != titleMarginTop || rect2.right != titleMarginStart || rect2.bottom != titleMarginBottom) {
                    rect2.set(titleMarginEnd, titleMarginTop, titleMarginStart, titleMarginBottom);
                    a3.f6382C = true;
                    a3.h();
                }
                int i14 = z12 ? this.h : this.f;
                int i15 = rect.top + this.g;
                int i16 = (i10 - i) - (z12 ? this.f : this.h);
                int i17 = (i11 - i6) - this.i;
                Rect rect3 = a3.d;
                if (rect3.left != i14 || rect3.top != i15 || rect3.right != i16 || rect3.bottom != i17) {
                    rect3.set(i14, i15, i16, i17);
                    a3.f6382C = true;
                    a3.h();
                }
                a3.j();
            }
        }
        f();
        int childCount3 = getChildCount();
        for (int i18 = 0; i18 < childCount3; i18++) {
            d(getChildAt(i18)).a();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i6) {
        int height;
        int height2;
        b();
        super.onMeasure(i, i6);
        int mode = View.MeasureSpec.getMode(i6);
        int iA = a();
        if (mode == 0 && iA > 0) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + iA, BasicMeasure.EXACTLY));
        }
        if (this.c != null) {
            if (this.l) {
                A a3 = this.k;
                if (TextUtils.isEmpty(a3.f6398v)) {
                    a3.n(this.c.getTitle());
                }
            }
            View view = this.d;
            if (view != null && view != this) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    height2 = view.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                } else {
                    height2 = view.getHeight();
                }
                setMinimumHeight(height2);
                return;
            }
            Toolbar toolbar = this.c;
            ViewGroup.LayoutParams layoutParams2 = toolbar.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                height = toolbar.getMeasuredHeight() + marginLayoutParams2.topMargin + marginLayoutParams2.bottomMargin;
            } else {
                height = toolbar.getHeight();
            }
            setMinimumHeight(height);
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i6, int i10, int i11) {
        super.onSizeChanged(i, i6, i10, i11);
        Drawable drawable = this.n;
        if (drawable != null) {
            drawable.setBounds(0, 0, i, i6);
        }
    }

    public void setCollapsedTitleGravity(int i) {
        A a3 = this.k;
        if (a3.h != i) {
            a3.h = i;
            a3.j();
        }
    }

    public void setCollapsedTitleTextAppearance(@StyleRes int i) {
        this.k.k(i);
    }

    public void setCollapsedTitleTextColor(@NonNull ColorStateList colorStateList) {
        A a3 = this.k;
        if (a3.l != colorStateList) {
            a3.l = colorStateList;
            a3.j();
        }
    }

    public void setCollapsedTitleTypeface(@Nullable Typeface typeface) {
        A a3 = this.k;
        if (A.c(a3.f6396s, typeface)) {
            a3.f6396s = typeface;
            a3.j();
        }
    }

    public void setContentScrim(@Nullable Drawable drawable) {
        Drawable drawable2 = this.n;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.n = drawableMutate;
            if (drawableMutate != null) {
                drawableMutate.setBounds(0, 0, getWidth(), getHeight());
                this.n.setCallback(this);
                this.n.setAlpha(this.p);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setContentScrimColor(@ColorInt int i) {
        setContentScrim(new ColorDrawable(i));
    }

    public void setContentScrimResource(@DrawableRes int i) {
        setContentScrim(ContextCompat.getDrawable(getContext(), i));
    }

    public void setExpandedTitleColor(@ColorInt int i) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i));
    }

    public void setExpandedTitleGravity(int i) {
        A a3 = this.k;
        if (a3.g != i) {
            a3.g = i;
            a3.j();
        }
    }

    public void setExpandedTitleMarginBottom(int i) {
        this.i = i;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int i) {
        this.h = i;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int i) {
        this.f = i;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int i) {
        this.g = i;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(@StyleRes int i) {
        this.k.l(i);
    }

    public void setExpandedTitleTextColor(@NonNull ColorStateList colorStateList) {
        A a3 = this.k;
        if (a3.k != colorStateList) {
            a3.k = colorStateList;
            a3.j();
        }
    }

    public void setExpandedTitleTypeface(@Nullable Typeface typeface) {
        A a3 = this.k;
        if (A.c(a3.f6397t, typeface)) {
            a3.f6397t = typeface;
            a3.j();
        }
    }

    public void setScrimAlpha(int i) {
        Toolbar toolbar;
        if (i != this.p) {
            if (this.n != null && (toolbar = this.c) != null) {
                ViewCompat.postInvalidateOnAnimation(toolbar);
            }
            this.p = i;
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setScrimAnimationDuration(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) long j5) {
        this.f6451s = j5;
    }

    public void setScrimVisibleHeightTrigger(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int i) {
        if (this.f6452t != i) {
            this.f6452t = i;
            f();
        }
    }

    public void setScrimsShown(boolean z10) {
        boolean z11 = ViewCompat.isLaidOut(this) && !isInEditMode();
        if (this.f6449q != z10) {
            if (z11) {
                int i = z10 ? 255 : 0;
                b();
                ValueAnimator valueAnimator = this.f6450r;
                if (valueAnimator == null) {
                    ValueAnimator valueAnimator2 = new ValueAnimator();
                    this.f6450r = valueAnimator2;
                    valueAnimator2.setDuration(this.f6451s);
                    this.f6450r.setInterpolator(i > this.p ? AbstractC2010z.f6648a : AbstractC2010z.b);
                    this.f6450r.addUpdateListener(new B(this, 0));
                } else if (valueAnimator.isRunning()) {
                    this.f6450r.cancel();
                }
                this.f6450r.setIntValues(this.p, i);
                this.f6450r.start();
            } else {
                setScrimAlpha(z10 ? 255 : 0);
            }
            this.f6449q = z10;
        }
    }

    public void setStatusBarScrim(@Nullable Drawable drawable) {
        Drawable drawable2 = this.o;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.o = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.o.setState(getDrawableState());
                }
                DrawableCompat.setLayoutDirection(this.o, ViewCompat.getLayoutDirection(this));
                this.o.setVisible(getVisibility() == 0, false);
                this.o.setCallback(this);
                this.o.setAlpha(this.p);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setStatusBarScrimColor(@ColorInt int i) {
        setStatusBarScrim(new ColorDrawable(i));
    }

    public void setStatusBarScrimResource(@DrawableRes int i) {
        setStatusBarScrim(ContextCompat.getDrawable(getContext(), i));
    }

    public void setTitle(@Nullable CharSequence charSequence) {
        this.k.n(charSequence);
    }

    public void setTitleEnabled(boolean z10) {
        if (z10 != this.l) {
            this.l = z10;
            e();
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z10 = i == 0;
        Drawable drawable = this.o;
        if (drawable != null && drawable.isVisible() != z10) {
            this.o.setVisible(z10, false);
        }
        Drawable drawable2 = this.n;
        if (drawable2 == null || drawable2.isVisible() == z10) {
            return;
        }
        this.n.setVisible(z10, false);
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.n || drawable == this.o;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        C c = new C(context, attributeSet);
        c.f6446a = 0;
        c.b = 0.5f;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, P2.a.i);
        c.f6446a = typedArrayObtainStyledAttributes.getInt(0, 0);
        c.b = typedArrayObtainStyledAttributes.getFloat(1, 0.5f);
        typedArrayObtainStyledAttributes.recycle();
        return c;
    }

    public void setCollapsedTitleTextColor(@ColorInt int i) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateDefaultLayoutParams() {
        C c = new C(-1, -1);
        c.f6446a = 0;
        c.b = 0.5f;
        return c;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        C c = new C(layoutParams);
        c.f6446a = 0;
        c.b = 0.5f;
        return c;
    }
}

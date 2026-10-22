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
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.view.A;
import androidx.core.view.N;
import androidx.core.view.a0;
import com.google.android.material.R$id;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.appbar.AppBarLayout;
import u0.C5566a;
import w0.C5715a;

/* loaded from: classes5.dex */
public class f extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public boolean f41592a;

    /* renamed from: b, reason: collision with root package name */
    public int f41593b;

    /* renamed from: c, reason: collision with root package name */
    public Toolbar f41594c;

    /* renamed from: d, reason: collision with root package name */
    public View f41595d;

    /* renamed from: e, reason: collision with root package name */
    public View f41596e;

    /* renamed from: f, reason: collision with root package name */
    public int f41597f;

    /* renamed from: g, reason: collision with root package name */
    public int f41598g;

    /* renamed from: h, reason: collision with root package name */
    public int f41599h;

    /* renamed from: i, reason: collision with root package name */
    public int f41600i;

    /* renamed from: j, reason: collision with root package name */
    public final Rect f41601j;

    /* renamed from: k, reason: collision with root package name */
    public final e f41602k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f41603l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f41604m;

    /* renamed from: n, reason: collision with root package name */
    public Drawable f41605n;

    /* renamed from: o, reason: collision with root package name */
    public Drawable f41606o;

    /* renamed from: p, reason: collision with root package name */
    public int f41607p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f41608q;

    /* renamed from: r, reason: collision with root package name */
    public ValueAnimator f41609r;

    /* renamed from: s, reason: collision with root package name */
    public long f41610s;

    /* renamed from: t, reason: collision with root package name */
    public int f41611t;

    /* renamed from: u, reason: collision with root package name */
    public AppBarLayout.h f41612u;

    /* renamed from: v, reason: collision with root package name */
    public int f41613v;

    /* renamed from: w, reason: collision with root package name */
    public a0 f41614w;

    public class a implements A {
        public a() {
        }

        @Override // androidx.core.view.A
        public a0 a(View view, a0 a0Var) {
            return f.this.k(a0Var);
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            f.this.setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    public class d implements AppBarLayout.h {
        public d() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.b
        public void a(AppBarLayout appBarLayout, int i10) {
            f fVar = f.this;
            fVar.f41613v = i10;
            int iB = fVar.b();
            int childCount = f.this.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = f.this.getChildAt(i11);
                c cVar = (c) childAt.getLayoutParams();
                x xVarI = f.i(childAt);
                int i12 = cVar.f41617a;
                if (i12 == 1) {
                    xVarI.d(C5715a.b(-i10, 0, f.this.h(childAt)));
                } else if (i12 == 2) {
                    xVarI.d(Math.round((-i10) * cVar.f41618b));
                }
            }
            f.this.n();
            f fVar2 = f.this;
            if (fVar2.f41606o != null && iB > 0) {
                N.Y(fVar2);
            }
            f.this.f41602k.L(Math.abs(i10) / ((f.this.getHeight() - N.w(f.this)) - iB));
        }
    }

    public f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static int g(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return view.getHeight();
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return view.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public static x i(View view) {
        int i10 = R$id.view_offset_helper;
        x xVar = (x) view.getTag(i10);
        if (xVar != null) {
            return xVar;
        }
        x xVar2 = new x(view);
        view.setTag(i10, xVar2);
        return xVar2;
    }

    public final void a(int i10) {
        c();
        ValueAnimator valueAnimator = this.f41609r;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.f41609r = valueAnimator2;
            valueAnimator2.setDuration(this.f41610s);
            this.f41609r.setInterpolator(i10 > this.f41607p ? stepos.support.v7.widget.d.f41534c : stepos.support.v7.widget.d.f41535d);
            this.f41609r.addUpdateListener(new b());
        } else if (valueAnimator.isRunning()) {
            this.f41609r.cancel();
        }
        this.f41609r.setIntValues(this.f41607p, i10);
        this.f41609r.start();
    }

    public int b() {
        a0 a0Var = this.f41614w;
        if (a0Var != null) {
            return a0Var.m();
        }
        return 0;
    }

    public final void c() {
        if (this.f41592a) {
            Toolbar toolbar = null;
            this.f41594c = null;
            this.f41595d = null;
            int i10 = this.f41593b;
            if (i10 != -1) {
                Toolbar toolbar2 = (Toolbar) findViewById(i10);
                this.f41594c = toolbar2;
                if (toolbar2 != null) {
                    this.f41595d = d(toolbar2);
                }
            }
            if (this.f41594c == null) {
                int childCount = getChildCount();
                int i11 = 0;
                while (true) {
                    if (i11 >= childCount) {
                        break;
                    }
                    View childAt = getChildAt(i11);
                    if (childAt instanceof Toolbar) {
                        toolbar = (Toolbar) childAt;
                        break;
                    }
                    i11++;
                }
                this.f41594c = toolbar;
            }
            m();
            this.f41592a = false;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    public final View d(View view) {
        for (ViewParent parent = view.getParent(); parent != this && parent != null; parent = parent.getParent()) {
            if (parent instanceof View) {
                view = parent;
            }
        }
        return view;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int iB;
        Drawable drawable;
        super.draw(canvas);
        c();
        if (this.f41594c == null && (drawable = this.f41605n) != null && this.f41607p > 0) {
            drawable.mutate().setAlpha(this.f41607p);
            this.f41605n.draw(canvas);
        }
        if (this.f41603l && this.f41604m) {
            this.f41602k.k(canvas);
        }
        if (this.f41606o == null || this.f41607p <= 0 || (iB = b()) <= 0) {
            return;
        }
        this.f41606o.setBounds(0, -this.f41613v, getWidth(), iB - this.f41613v);
        this.f41606o.mutate().setAlpha(this.f41607p);
        this.f41606o.draw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j10) {
        boolean z10;
        if (this.f41605n == null || this.f41607p <= 0 || !j(view)) {
            z10 = false;
        } else {
            this.f41605n.mutate().setAlpha(this.f41607p);
            this.f41605n.draw(canvas);
            z10 = true;
        }
        return super.drawChild(canvas, view, j10) || z10;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f41606o;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState);
        Drawable drawable2 = this.f41605n;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        e eVar = this.f41602k;
        if (eVar != null) {
            state |= eVar.N(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public c generateDefaultLayoutParams() {
        return new c(-1, -1);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new c(layoutParams);
    }

    public int getCollapsedTitleGravity() {
        return this.f41602k.m();
    }

    public Typeface getCollapsedTitleTypeface() {
        return this.f41602k.n();
    }

    public Drawable getContentScrim() {
        return this.f41605n;
    }

    public int getExpandedTitleGravity() {
        return this.f41602k.q();
    }

    public int getExpandedTitleMarginBottom() {
        return this.f41600i;
    }

    public int getExpandedTitleMarginEnd() {
        return this.f41599h;
    }

    public int getExpandedTitleMarginStart() {
        return this.f41597f;
    }

    public int getExpandedTitleMarginTop() {
        return this.f41598g;
    }

    public Typeface getExpandedTitleTypeface() {
        return this.f41602k.r();
    }

    public int getScrimAlpha() {
        return this.f41607p;
    }

    public long getScrimAnimationDuration() {
        return this.f41610s;
    }

    public int getScrimVisibleHeightTrigger() {
        int i10 = this.f41611t;
        if (i10 >= 0) {
            return i10;
        }
        int iB = b();
        int iW = N.w(this);
        return iW > 0 ? Math.min((iW * 2) + iB, getHeight()) : getHeight() / 3;
    }

    public Drawable getStatusBarScrim() {
        return this.f41606o;
    }

    public CharSequence getTitle() {
        if (this.f41603l) {
            return this.f41594c.getTitle();
        }
        return null;
    }

    public n getTitleScaleControl() {
        return this.f41602k;
    }

    public final int h(View view) {
        x xVarI = i(view);
        return ((getHeight() - Math.max(xVarI.b(), this.f41614w != null ? b() : xVarI.b())) - view.getHeight()) - ((FrameLayout.LayoutParams) ((c) view.getLayoutParams())).bottomMargin;
    }

    public final boolean j(View view) {
        View view2 = this.f41595d;
        return (view2 == null || view2 == this) ? view == this.f41594c : view == view2;
    }

    public a0 k(a0 a0Var) {
        a0 a0Var2 = N.r(this) ? a0Var : null;
        if (!B0.c.a(this.f41614w, a0Var2)) {
            this.f41614w = a0Var2;
            requestLayout();
        }
        return a0Var.c();
    }

    public void l(boolean z10, boolean z11) {
        if (this.f41608q != z10) {
            if (z11) {
                a(z10 ? 255 : 0);
            } else {
                setScrimAlpha(z10 ? 255 : 0);
            }
            this.f41608q = z10;
        }
    }

    public final void m() {
        View view;
        if (!this.f41603l && (view = this.f41596e) != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f41596e);
            }
        }
        if (!this.f41603l || this.f41594c == null) {
            return;
        }
        if (this.f41596e == null) {
            this.f41596e = new View(getContext());
        }
        if (this.f41596e.getParent() == null) {
            this.f41594c.addView(this.f41596e, -1, -1);
        }
    }

    public final void n() {
        if (this.f41605n == null && this.f41606o == null) {
            return;
        }
        setScrimsShown(getHeight() + this.f41613v < getScrimVisibleHeightTrigger());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Object parent = getParent();
        if (parent instanceof AppBarLayout) {
            N.q0(this, N.r((View) parent));
            if (this.f41612u == null) {
                this.f41612u = new d();
            }
            ((AppBarLayout) parent).g(this.f41612u);
            N.e0(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        ViewParent parent = getParent();
        AppBarLayout.h hVar = this.f41612u;
        if (hVar != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).C(hVar);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        View view;
        super.onLayout(z10, i10, i11, i12, i13);
        if (this.f41614w != null) {
            int iB = b();
            int childCount = getChildCount();
            for (int i14 = 0; i14 < childCount; i14++) {
                View childAt = getChildAt(i14);
                if (!N.r(childAt) && childAt.getTop() < iB) {
                    N.T(childAt, iB);
                }
            }
        }
        int childCount2 = getChildCount();
        for (int i15 = 0; i15 < childCount2; i15++) {
            i(getChildAt(i15)).c();
        }
        if (this.f41603l && (view = this.f41596e) != null) {
            boolean z11 = N.M(view) && this.f41596e.getVisibility() == 0;
            this.f41604m = z11;
            if (z11) {
                boolean z12 = N.u(this) == 1;
                View view2 = this.f41595d;
                if (view2 == null) {
                    view2 = this.f41594c;
                }
                int iH = h(view2);
                androidx.coordinatorlayout.widget.b.a(this, this.f41596e, this.f41601j);
                this.f41602k.B(this.f41601j.left + (z12 ? this.f41594c.getTitleMarginEnd() : this.f41594c.getTitleMarginStart()), this.f41601j.top + iH + this.f41594c.getTitleMarginTop(), this.f41601j.right + (z12 ? this.f41594c.getTitleMarginStart() : this.f41594c.getTitleMarginEnd()), (this.f41601j.bottom + iH) - this.f41594c.getTitleMarginBottom());
                this.f41602k.G(z12 ? this.f41599h : this.f41597f, this.f41601j.top + this.f41598g, (i12 - i10) - (z12 ? this.f41597f : this.f41599h), (i13 - i11) - this.f41600i);
                this.f41602k.z();
            }
        }
        n();
        int childCount3 = getChildCount();
        for (int i16 = 0; i16 < childCount3; i16++) {
            i(getChildAt(i16)).a();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        c();
        super.onMeasure(i10, i11);
        int mode = View.MeasureSpec.getMode(i11);
        int iB = b();
        if (mode == 0 && iB > 0) {
            super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + iB, 1073741824));
        }
        if (this.f41594c != null) {
            if (this.f41603l && TextUtils.isEmpty(this.f41602k.s())) {
                this.f41602k.O(this.f41594c.getTitle());
            }
            View view = this.f41595d;
            if (view == null || view == this) {
                setMinimumHeight(g(this.f41594c));
            } else {
                setMinimumHeight(g(view));
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        Drawable drawable = this.f41605n;
        if (drawable != null) {
            drawable.setBounds(0, 0, i10, i11);
        }
    }

    public void setCollapsedTitleGravity(int i10) {
        this.f41602k.E(i10);
    }

    public void setCollapsedTitleTextAppearance(int i10) {
        this.f41602k.C(i10);
    }

    public void setCollapsedTitleTextColor(int i10) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i10));
    }

    public void setCollapsedTitleTypeface(Typeface typeface) {
        this.f41602k.F(typeface);
    }

    public void setContentScrim(Drawable drawable) {
        Drawable drawable2 = this.f41605n;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.f41605n = drawableMutate;
            if (drawableMutate != null) {
                drawableMutate.setBounds(0, 0, getWidth(), getHeight());
                this.f41605n.setCallback(this);
                this.f41605n.setAlpha(this.f41607p);
            }
            N.Y(this);
        }
    }

    public void setContentScrimColor(int i10) {
        setContentScrim(new ColorDrawable(i10));
    }

    public void setContentScrimResource(int i10) {
        setContentScrim(androidx.core.content.a.e(getContext(), i10));
    }

    public void setExpandedTitleColor(int i10) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i10));
    }

    public void setExpandedTitleGravity(int i10) {
        this.f41602k.J(i10);
    }

    public void setExpandedTitleMarginBottom(int i10) {
        this.f41600i = i10;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int i10) {
        this.f41599h = i10;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int i10) {
        this.f41597f = i10;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int i10) {
        this.f41598g = i10;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(int i10) {
        this.f41602k.H(i10);
    }

    public void setExpandedTitleTextColor(ColorStateList colorStateList) {
        this.f41602k.I(colorStateList);
    }

    public void setExpandedTitleTypeface(Typeface typeface) {
        this.f41602k.K(typeface);
    }

    public void setScrimAlpha(int i10) {
        Toolbar toolbar;
        if (i10 != this.f41607p) {
            if (this.f41605n != null && (toolbar = this.f41594c) != null) {
                N.Y(toolbar);
            }
            this.f41607p = i10;
            N.Y(this);
        }
    }

    public void setScrimAnimationDuration(long j10) {
        this.f41610s = j10;
    }

    public void setScrimVisibleHeightTrigger(int i10) {
        if (this.f41611t != i10) {
            this.f41611t = i10;
            n();
        }
    }

    public void setScrimsShown(boolean z10) {
        l(z10, N.N(this) && !isInEditMode());
    }

    public void setStatusBarScrim(Drawable drawable) {
        Drawable drawable2 = this.f41606o;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.f41606o = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.f41606o.setState(getDrawableState());
                }
                C5566a.m(this.f41606o, N.u(this));
                this.f41606o.setVisible(getVisibility() == 0, false);
                this.f41606o.setCallback(this);
                this.f41606o.setAlpha(this.f41607p);
            }
            N.Y(this);
        }
    }

    public void setStatusBarScrimColor(int i10) {
        setStatusBarScrim(new ColorDrawable(i10));
    }

    public void setStatusBarScrimResource(int i10) {
        setStatusBarScrim(androidx.core.content.a.e(getContext(), i10));
    }

    public void setTitle(CharSequence charSequence) {
        this.f41602k.O(charSequence);
    }

    public void setTitleEnabled(boolean z10) {
        if (z10 != this.f41603l) {
            this.f41603l = z10;
            m();
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        boolean z10 = i10 == 0;
        Drawable drawable = this.f41606o;
        if (drawable != null && drawable.isVisible() != z10) {
            this.f41606o.setVisible(z10, false);
        }
        Drawable drawable2 = this.f41605n;
        if (drawable2 == null || drawable2.isVisible() == z10) {
            return;
        }
        this.f41605n.setVisible(z10, false);
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f41605n || drawable == this.f41606o;
    }

    public f(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f41592a = true;
        this.f41601j = new Rect();
        this.f41611t = -1;
        v.a(context);
        e eVar = new e(this);
        this.f41602k = eVar;
        eVar.Q(stepos.support.v7.widget.d.f41541j);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CollapsingToolbarLayout, i10, R$style.Widget_Design_CollapsingToolbar);
        eVar.J(typedArrayObtainStyledAttributes.getInt(R$styleable.CollapsingToolbarLayout_expandedTitleGravity, 8388691));
        eVar.E(typedArrayObtainStyledAttributes.getInt(R$styleable.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_expandedTitleMargin, 0);
        this.f41600i = dimensionPixelSize;
        this.f41599h = dimensionPixelSize;
        this.f41598g = dimensionPixelSize;
        this.f41597f = dimensionPixelSize;
        int i11 = R$styleable.CollapsingToolbarLayout_expandedTitleMarginStart;
        if (typedArrayObtainStyledAttributes.hasValue(i11)) {
            this.f41597f = typedArrayObtainStyledAttributes.getDimensionPixelSize(i11, 0);
        }
        int i12 = R$styleable.CollapsingToolbarLayout_expandedTitleMarginEnd;
        if (typedArrayObtainStyledAttributes.hasValue(i12)) {
            this.f41599h = typedArrayObtainStyledAttributes.getDimensionPixelSize(i12, 0);
        }
        int i13 = R$styleable.CollapsingToolbarLayout_expandedTitleMarginTop;
        if (typedArrayObtainStyledAttributes.hasValue(i13)) {
            this.f41598g = typedArrayObtainStyledAttributes.getDimensionPixelSize(i13, 0);
        }
        int i14 = R$styleable.CollapsingToolbarLayout_expandedTitleMarginBottom;
        if (typedArrayObtainStyledAttributes.hasValue(i14)) {
            this.f41600i = typedArrayObtainStyledAttributes.getDimensionPixelSize(i14, 0);
        }
        this.f41603l = typedArrayObtainStyledAttributes.getBoolean(R$styleable.CollapsingToolbarLayout_titleEnabled, true);
        setTitle(typedArrayObtainStyledAttributes.getText(R$styleable.CollapsingToolbarLayout_title));
        eVar.H(R$style.TextAppearance_Design_CollapsingToolbar_Expanded);
        eVar.C(androidx.appcompat.R$style.TextAppearance_AppCompat_Widget_ActionBar_Title);
        int i15 = R$styleable.CollapsingToolbarLayout_expandedTitleTextAppearance;
        if (typedArrayObtainStyledAttributes.hasValue(i15)) {
            eVar.H(typedArrayObtainStyledAttributes.getResourceId(i15, 0));
        }
        int i16 = R$styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance;
        if (typedArrayObtainStyledAttributes.hasValue(i16)) {
            eVar.C(typedArrayObtainStyledAttributes.getResourceId(i16, 0));
        }
        this.f41611t = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_scrimVisibleHeightTrigger, -1);
        this.f41610s = typedArrayObtainStyledAttributes.getInt(R$styleable.CollapsingToolbarLayout_scrimAnimationDuration, 600);
        setContentScrim(typedArrayObtainStyledAttributes.getDrawable(R$styleable.CollapsingToolbarLayout_contentScrim));
        setStatusBarScrim(typedArrayObtainStyledAttributes.getDrawable(R$styleable.CollapsingToolbarLayout_statusBarScrim));
        this.f41593b = typedArrayObtainStyledAttributes.getResourceId(R$styleable.CollapsingToolbarLayout_toolbarId, -1);
        typedArrayObtainStyledAttributes.recycle();
        setWillNotDraw(false);
        N.u0(this, new a());
    }

    public void setCollapsedTitleTextColor(ColorStateList colorStateList) {
        this.f41602k.D(colorStateList);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    public static class c extends FrameLayout.LayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public int f41617a;

        /* renamed from: b, reason: collision with root package name */
        public float f41618b;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f41617a = 0;
            this.f41618b = 0.5f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CollapsingToolbarLayout_Layout);
            this.f41617a = typedArrayObtainStyledAttributes.getInt(R$styleable.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
            a(typedArrayObtainStyledAttributes.getFloat(R$styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5f));
            typedArrayObtainStyledAttributes.recycle();
        }

        public void a(float f10) {
            this.f41618b = f10;
        }

        public c(int i10, int i11) {
            super(i10, i11);
            this.f41617a = 0;
            this.f41618b = 0.5f;
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f41617a = 0;
            this.f41618b = 0.5f;
        }
    }
}

package stepos.support.v7.widget;

import a1.C0413f;
import a1.C0417j;
import a1.C0418k;
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
import androidx.core.view.H;
import androidx.core.view.InterfaceC0479y;
import androidx.core.view.Y;
import com.google.android.material.appbar.AppBarLayout;

/* loaded from: classes.dex */
public class g extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private boolean f22023a;

    /* renamed from: b, reason: collision with root package name */
    private int f22024b;

    /* renamed from: c, reason: collision with root package name */
    private Toolbar f22025c;

    /* renamed from: d, reason: collision with root package name */
    private View f22026d;

    /* renamed from: e, reason: collision with root package name */
    private View f22027e;

    /* renamed from: f, reason: collision with root package name */
    private int f22028f;

    /* renamed from: g, reason: collision with root package name */
    private int f22029g;

    /* renamed from: h, reason: collision with root package name */
    private int f22030h;

    /* renamed from: i, reason: collision with root package name */
    private int f22031i;

    /* renamed from: j, reason: collision with root package name */
    private final Rect f22032j;

    /* renamed from: k, reason: collision with root package name */
    final f f22033k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f22034l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f22035m;

    /* renamed from: n, reason: collision with root package name */
    private Drawable f22036n;

    /* renamed from: o, reason: collision with root package name */
    Drawable f22037o;

    /* renamed from: p, reason: collision with root package name */
    private int f22038p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f22039q;

    /* renamed from: r, reason: collision with root package name */
    private ValueAnimator f22040r;

    /* renamed from: s, reason: collision with root package name */
    private long f22041s;

    /* renamed from: t, reason: collision with root package name */
    private int f22042t;

    /* renamed from: u, reason: collision with root package name */
    private AppBarLayout.h f22043u;

    /* renamed from: v, reason: collision with root package name */
    int f22044v;

    /* renamed from: w, reason: collision with root package name */
    Y f22045w;

    class a implements InterfaceC0479y {
        a() {
        }

        @Override // androidx.core.view.InterfaceC0479y
        public Y a(View view, Y y5) {
            return g.this.k(y5);
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            g.this.setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    private class d implements AppBarLayout.h {
        d() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.b
        public void a(AppBarLayout appBarLayout, int i5) {
            g gVar = g.this;
            gVar.f22044v = i5;
            int iB = gVar.b();
            int childCount = g.this.getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = g.this.getChildAt(i6);
                c cVar = (c) childAt.getLayoutParams();
                B bI = g.i(childAt);
                int i7 = cVar.f22048a;
                if (i7 == 1) {
                    bI.d(B.a.b(-i5, 0, g.this.h(childAt)));
                } else if (i7 == 2) {
                    bI.d(Math.round((-i5) * cVar.f22049b));
                }
            }
            g.this.n();
            g gVar2 = g.this;
            if (gVar2.f22037o != null && iB > 0) {
                H.a0(gVar2);
            }
            g.this.f22033k.L(Math.abs(i5) / ((g.this.getHeight() - H.z(g.this)) - iB));
        }
    }

    public g(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(int i5) {
        c();
        ValueAnimator valueAnimator = this.f22040r;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.f22040r = valueAnimator2;
            valueAnimator2.setDuration(this.f22041s);
            this.f22040r.setInterpolator(i5 > this.f22038p ? e.f21965c : e.f21966d);
            this.f22040r.addUpdateListener(new b());
        } else if (valueAnimator.isRunning()) {
            this.f22040r.cancel();
        }
        this.f22040r.setIntValues(this.f22038p, i5);
        this.f22040r.start();
    }

    private void c() {
        if (this.f22023a) {
            Toolbar toolbar = null;
            this.f22025c = null;
            this.f22026d = null;
            int i5 = this.f22024b;
            if (i5 != -1) {
                Toolbar toolbar2 = (Toolbar) findViewById(i5);
                this.f22025c = toolbar2;
                if (toolbar2 != null) {
                    this.f22026d = d(toolbar2);
                }
            }
            if (this.f22025c == null) {
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
                this.f22025c = toolbar;
            }
            m();
            this.f22023a = false;
        }
    }

    private View d(View view) {
        for (ViewParent parent = view.getParent(); parent != this && parent != null; parent = parent.getParent()) {
            if (parent instanceof View) {
                view = parent;
            }
        }
        return view;
    }

    private static int g(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return view.getHeight();
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return view.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    static B i(View view) {
        int i5 = C0413f.f6837T;
        B b6 = (B) view.getTag(i5);
        if (b6 != null) {
            return b6;
        }
        B b7 = new B(view);
        view.setTag(i5, b7);
        return b7;
    }

    private boolean j(View view) {
        View view2 = this.f22026d;
        return (view2 == null || view2 == this) ? view == this.f22025c : view == view2;
    }

    private void m() {
        View view;
        if (!this.f22034l && (view = this.f22027e) != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f22027e);
            }
        }
        if (!this.f22034l || this.f22025c == null) {
            return;
        }
        if (this.f22027e == null) {
            this.f22027e = new View(getContext());
        }
        if (this.f22027e.getParent() == null) {
            this.f22025c.addView(this.f22027e, -1, -1);
        }
    }

    protected int b() {
        Y y5 = this.f22045w;
        if (y5 != null) {
            return y5.k();
        }
        return 0;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int iB;
        Drawable drawable;
        super.draw(canvas);
        c();
        if (this.f22025c == null && (drawable = this.f22036n) != null && this.f22038p > 0) {
            drawable.mutate().setAlpha(this.f22038p);
            this.f22036n.draw(canvas);
        }
        if (this.f22034l && this.f22035m) {
            this.f22033k.k(canvas);
        }
        if (this.f22037o == null || this.f22038p <= 0 || (iB = b()) <= 0) {
            return;
        }
        this.f22037o.setBounds(0, -this.f22044v, getWidth(), iB - this.f22044v);
        this.f22037o.mutate().setAlpha(this.f22038p);
        this.f22037o.draw(canvas);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j5) {
        boolean z5;
        if (this.f22036n == null || this.f22038p <= 0 || !j(view)) {
            z5 = false;
        } else {
            this.f22036n.mutate().setAlpha(this.f22038p);
            this.f22036n.draw(canvas);
            z5 = true;
        }
        return super.drawChild(canvas, view, j5) || z5;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f22037o;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState);
        Drawable drawable2 = this.f22036n;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        f fVar = this.f22033k;
        if (fVar != null) {
            state |= fVar.N(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public c generateDefaultLayoutParams() {
        return new c(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new c(layoutParams);
    }

    public int getCollapsedTitleGravity() {
        return this.f22033k.m();
    }

    public Typeface getCollapsedTitleTypeface() {
        return this.f22033k.n();
    }

    public Drawable getContentScrim() {
        return this.f22036n;
    }

    public int getExpandedTitleGravity() {
        return this.f22033k.q();
    }

    public int getExpandedTitleMarginBottom() {
        return this.f22031i;
    }

    public int getExpandedTitleMarginEnd() {
        return this.f22030h;
    }

    public int getExpandedTitleMarginStart() {
        return this.f22028f;
    }

    public int getExpandedTitleMarginTop() {
        return this.f22029g;
    }

    public Typeface getExpandedTitleTypeface() {
        return this.f22033k.r();
    }

    int getScrimAlpha() {
        return this.f22038p;
    }

    public long getScrimAnimationDuration() {
        return this.f22041s;
    }

    public int getScrimVisibleHeightTrigger() {
        int i5 = this.f22042t;
        if (i5 >= 0) {
            return i5;
        }
        int iB = b();
        int iZ = H.z(this);
        return iZ > 0 ? Math.min((iZ * 2) + iB, getHeight()) : getHeight() / 3;
    }

    public Drawable getStatusBarScrim() {
        return this.f22037o;
    }

    public CharSequence getTitle() {
        if (this.f22034l) {
            return this.f22025c.getTitle();
        }
        return null;
    }

    public p getTitleScaleControl() {
        return this.f22033k;
    }

    final int h(View view) {
        B bI = i(view);
        return ((getHeight() - Math.max(bI.b(), this.f22045w != null ? b() : bI.b())) - view.getHeight()) - ((FrameLayout.LayoutParams) ((c) view.getLayoutParams())).bottomMargin;
    }

    Y k(Y y5) {
        Y y6 = H.u(this) ? y5 : null;
        if (!D.c.a(this.f22045w, y6)) {
            this.f22045w = y6;
            requestLayout();
        }
        return y5.c();
    }

    public void l(boolean z5, boolean z6) {
        if (this.f22039q != z5) {
            if (z6) {
                a(z5 ? 255 : 0);
            } else {
                setScrimAlpha(z5 ? 255 : 0);
            }
            this.f22039q = z5;
        }
    }

    final void n() {
        if (this.f22036n == null && this.f22037o == null) {
            return;
        }
        setScrimsShown(getHeight() + this.f22044v < getScrimVisibleHeightTrigger());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Object parent = getParent();
        if (parent instanceof AppBarLayout) {
            H.s0(this, H.u((View) parent));
            if (this.f22043u == null) {
                this.f22043u = new d();
            }
            ((AppBarLayout) parent).g(this.f22043u);
            H.g0(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        ViewParent parent = getParent();
        AppBarLayout.h hVar = this.f22043u;
        if (hVar != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).C(hVar);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
        View view;
        super.onLayout(z5, i5, i6, i7, i8);
        if (this.f22045w != null) {
            int iB = b();
            int childCount = getChildCount();
            for (int i9 = 0; i9 < childCount; i9++) {
                View childAt = getChildAt(i9);
                if (!H.u(childAt) && childAt.getTop() < iB) {
                    H.V(childAt, iB);
                }
            }
        }
        int childCount2 = getChildCount();
        for (int i10 = 0; i10 < childCount2; i10++) {
            i(getChildAt(i10)).c();
        }
        if (this.f22034l && (view = this.f22027e) != null) {
            boolean z6 = H.P(view) && this.f22027e.getVisibility() == 0;
            this.f22035m = z6;
            if (z6) {
                boolean z7 = H.x(this) == 1;
                View view2 = this.f22026d;
                if (view2 == null) {
                    view2 = this.f22025c;
                }
                int iH = h(view2);
                androidx.coordinatorlayout.widget.b.a(this, this.f22027e, this.f22032j);
                this.f22033k.B(this.f22032j.left + (z7 ? this.f22025c.getTitleMarginEnd() : this.f22025c.getTitleMarginStart()), this.f22032j.top + iH + this.f22025c.getTitleMarginTop(), this.f22032j.right + (z7 ? this.f22025c.getTitleMarginStart() : this.f22025c.getTitleMarginEnd()), (this.f22032j.bottom + iH) - this.f22025c.getTitleMarginBottom());
                this.f22033k.G(z7 ? this.f22030h : this.f22028f, this.f22032j.top + this.f22029g, (i7 - i5) - (z7 ? this.f22028f : this.f22030h), (i8 - i6) - this.f22031i);
                this.f22033k.z();
            }
        }
        n();
        int childCount3 = getChildCount();
        for (int i11 = 0; i11 < childCount3; i11++) {
            i(getChildAt(i11)).a();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i5, int i6) {
        c();
        super.onMeasure(i5, i6);
        int mode = View.MeasureSpec.getMode(i6);
        int iB = b();
        if (mode == 0 && iB > 0) {
            super.onMeasure(i5, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + iB, 1073741824));
        }
        if (this.f22025c != null) {
            if (this.f22034l && TextUtils.isEmpty(this.f22033k.s())) {
                this.f22033k.O(this.f22025c.getTitle());
            }
            View view = this.f22026d;
            if (view == null || view == this) {
                setMinimumHeight(g(this.f22025c));
            } else {
                setMinimumHeight(g(view));
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i5, int i6, int i7, int i8) {
        super.onSizeChanged(i5, i6, i7, i8);
        Drawable drawable = this.f22036n;
        if (drawable != null) {
            drawable.setBounds(0, 0, i5, i6);
        }
    }

    public void setCollapsedTitleGravity(int i5) {
        this.f22033k.E(i5);
    }

    public void setCollapsedTitleTextAppearance(int i5) {
        this.f22033k.C(i5);
    }

    public void setCollapsedTitleTextColor(int i5) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i5));
    }

    public void setCollapsedTitleTypeface(Typeface typeface) {
        this.f22033k.F(typeface);
    }

    public void setContentScrim(Drawable drawable) {
        Drawable drawable2 = this.f22036n;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.f22036n = drawableMutate;
            if (drawableMutate != null) {
                drawableMutate.setBounds(0, 0, getWidth(), getHeight());
                this.f22036n.setCallback(this);
                this.f22036n.setAlpha(this.f22038p);
            }
            H.a0(this);
        }
    }

    public void setContentScrimColor(int i5) {
        setContentScrim(new ColorDrawable(i5));
    }

    public void setContentScrimResource(int i5) {
        setContentScrim(androidx.core.content.a.e(getContext(), i5));
    }

    public void setExpandedTitleColor(int i5) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i5));
    }

    public void setExpandedTitleGravity(int i5) {
        this.f22033k.J(i5);
    }

    public void setExpandedTitleMarginBottom(int i5) {
        this.f22031i = i5;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int i5) {
        this.f22030h = i5;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int i5) {
        this.f22028f = i5;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int i5) {
        this.f22029g = i5;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(int i5) {
        this.f22033k.H(i5);
    }

    public void setExpandedTitleTextColor(ColorStateList colorStateList) {
        this.f22033k.I(colorStateList);
    }

    public void setExpandedTitleTypeface(Typeface typeface) {
        this.f22033k.K(typeface);
    }

    void setScrimAlpha(int i5) {
        Toolbar toolbar;
        if (i5 != this.f22038p) {
            if (this.f22036n != null && (toolbar = this.f22025c) != null) {
                H.a0(toolbar);
            }
            this.f22038p = i5;
            H.a0(this);
        }
    }

    public void setScrimAnimationDuration(long j5) {
        this.f22041s = j5;
    }

    public void setScrimVisibleHeightTrigger(int i5) {
        if (this.f22042t != i5) {
            this.f22042t = i5;
            n();
        }
    }

    public void setScrimsShown(boolean z5) {
        l(z5, H.Q(this) && !isInEditMode());
    }

    public void setStatusBarScrim(Drawable drawable) {
        Drawable drawable2 = this.f22037o;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.f22037o = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.f22037o.setState(getDrawableState());
                }
                androidx.core.graphics.drawable.a.m(this.f22037o, H.x(this));
                this.f22037o.setVisible(getVisibility() == 0, false);
                this.f22037o.setCallback(this);
                this.f22037o.setAlpha(this.f22038p);
            }
            H.a0(this);
        }
    }

    public void setStatusBarScrimColor(int i5) {
        setStatusBarScrim(new ColorDrawable(i5));
    }

    public void setStatusBarScrimResource(int i5) {
        setStatusBarScrim(androidx.core.content.a.e(getContext(), i5));
    }

    public void setTitle(CharSequence charSequence) {
        this.f22033k.O(charSequence);
    }

    public void setTitleEnabled(boolean z5) {
        if (z5 != this.f22034l) {
            this.f22034l = z5;
            m();
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i5) {
        super.setVisibility(i5);
        boolean z5 = i5 == 0;
        Drawable drawable = this.f22037o;
        if (drawable != null && drawable.isVisible() != z5) {
            this.f22037o.setVisible(z5, false);
        }
        Drawable drawable2 = this.f22036n;
        if (drawable2 == null || drawable2.isVisible() == z5) {
            return;
        }
        this.f22036n.setVisible(z5, false);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f22036n || drawable == this.f22037o;
    }

    public g(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f22023a = true;
        this.f22032j = new Rect();
        this.f22042t = -1;
        z.a(context);
        f fVar = new f(this);
        this.f22033k = fVar;
        fVar.Q(e.f21972j);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0418k.f7044S0, i5, C0417j.f6914e);
        fVar.J(typedArrayObtainStyledAttributes.getInt(C0418k.f7068W0, 8388691));
        fVar.E(typedArrayObtainStyledAttributes.getInt(C0418k.f7050T0, 8388627));
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(C0418k.f7074X0, 0);
        this.f22031i = dimensionPixelSize;
        this.f22030h = dimensionPixelSize;
        this.f22029g = dimensionPixelSize;
        this.f22028f = dimensionPixelSize;
        int i6 = C0418k.f7093a1;
        if (typedArrayObtainStyledAttributes.hasValue(i6)) {
            this.f22028f = typedArrayObtainStyledAttributes.getDimensionPixelSize(i6, 0);
        }
        int i7 = C0418k.f7086Z0;
        if (typedArrayObtainStyledAttributes.hasValue(i7)) {
            this.f22030h = typedArrayObtainStyledAttributes.getDimensionPixelSize(i7, 0);
        }
        int i8 = C0418k.f7100b1;
        if (typedArrayObtainStyledAttributes.hasValue(i8)) {
            this.f22029g = typedArrayObtainStyledAttributes.getDimensionPixelSize(i8, 0);
        }
        int i9 = C0418k.f7080Y0;
        if (typedArrayObtainStyledAttributes.hasValue(i9)) {
            this.f22031i = typedArrayObtainStyledAttributes.getDimensionPixelSize(i9, 0);
        }
        this.f22034l = typedArrayObtainStyledAttributes.getBoolean(C0418k.f7140h1, true);
        setTitle(typedArrayObtainStyledAttributes.getText(C0418k.f7134g1));
        fVar.H(C0417j.f6911b);
        fVar.C(g.i.f16977b);
        int i10 = C0418k.f7107c1;
        if (typedArrayObtainStyledAttributes.hasValue(i10)) {
            fVar.H(typedArrayObtainStyledAttributes.getResourceId(i10, 0));
        }
        int i11 = C0418k.f7056U0;
        if (typedArrayObtainStyledAttributes.hasValue(i11)) {
            fVar.C(typedArrayObtainStyledAttributes.getResourceId(i11, 0));
        }
        this.f22042t = typedArrayObtainStyledAttributes.getDimensionPixelSize(C0418k.f7121e1, -1);
        this.f22041s = typedArrayObtainStyledAttributes.getInt(C0418k.f7114d1, 600);
        setContentScrim(typedArrayObtainStyledAttributes.getDrawable(C0418k.f7062V0));
        setStatusBarScrim(typedArrayObtainStyledAttributes.getDrawable(C0418k.f7128f1));
        this.f22024b = typedArrayObtainStyledAttributes.getResourceId(C0418k.f7146i1, -1);
        typedArrayObtainStyledAttributes.recycle();
        setWillNotDraw(false);
        H.w0(this, new a());
    }

    public void setCollapsedTitleTextColor(ColorStateList colorStateList) {
        this.f22033k.D(colorStateList);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    public static class c extends FrameLayout.LayoutParams {

        /* renamed from: a, reason: collision with root package name */
        int f22048a;

        /* renamed from: b, reason: collision with root package name */
        float f22049b;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f22048a = 0;
            this.f22049b = 0.5f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0418k.f7152j1);
            this.f22048a = typedArrayObtainStyledAttributes.getInt(C0418k.f7158k1, 0);
            a(typedArrayObtainStyledAttributes.getFloat(C0418k.f7164l1, 0.5f));
            typedArrayObtainStyledAttributes.recycle();
        }

        public void a(float f5) {
            this.f22049b = f5;
        }

        public c(int i5, int i6) {
            super(i5, i6);
            this.f22048a = 0;
            this.f22049b = 0.5f;
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f22048a = 0;
            this.f22049b = 0.5f;
        }
    }
}

package stepos.support.v7.widget;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.provider.Settings;
import android.util.AttributeSet;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.view.InterfaceC1336y;
import androidx.dynamicanimation.animation.e;
import stepos.support.v7.app.l;
import stepos.support.v7.appcompat.R$dimen;
import stepos.support.v7.appcompat.R$styleable;

/* loaded from: classes5.dex */
public class PopupNestedScrollingLayout extends ViewGroup implements InterfaceC1336y {

    /* renamed from: L, reason: collision with root package name */
    public static final Interpolator f41226L = D0.a.a(0.2f, 0.03f, 0.0f, 1.0f);

    /* renamed from: M, reason: collision with root package name */
    public static float f41227M = 0.88f;

    /* renamed from: N, reason: collision with root package name */
    public static float f41228N = 340.0f;

    /* renamed from: O, reason: collision with root package name */
    public static float f41229O = 0.93f;

    /* renamed from: P, reason: collision with root package name */
    public static float f41230P = 400.0f;

    /* renamed from: Q, reason: collision with root package name */
    public static float f41231Q = 0.98f;

    /* renamed from: R, reason: collision with root package name */
    public static float f41232R = 300.0f;

    /* renamed from: A, reason: collision with root package name */
    public boolean f41233A;

    /* renamed from: B, reason: collision with root package name */
    public boolean f41234B;

    /* renamed from: C, reason: collision with root package name */
    public int f41235C;

    /* renamed from: D, reason: collision with root package name */
    public boolean f41236D;

    /* renamed from: E, reason: collision with root package name */
    public boolean f41237E;

    /* renamed from: F, reason: collision with root package name */
    public boolean f41238F;

    /* renamed from: G, reason: collision with root package name */
    public float f41239G;

    /* renamed from: H, reason: collision with root package name */
    public float f41240H;

    /* renamed from: I, reason: collision with root package name */
    public boolean f41241I;

    /* renamed from: J, reason: collision with root package name */
    public View f41242J;

    /* renamed from: K, reason: collision with root package name */
    public int f41243K;

    /* renamed from: a, reason: collision with root package name */
    public final OverScroller f41244a;

    /* renamed from: b, reason: collision with root package name */
    public final float f41245b;

    /* renamed from: c, reason: collision with root package name */
    public final VelocityTracker f41246c;

    /* renamed from: d, reason: collision with root package name */
    public final int f41247d;

    /* renamed from: e, reason: collision with root package name */
    public final TimeInterpolator f41248e;

    /* renamed from: f, reason: collision with root package name */
    public final androidx.dynamicanimation.animation.i f41249f;

    /* renamed from: g, reason: collision with root package name */
    public final float f41250g;

    /* renamed from: h, reason: collision with root package name */
    public final float f41251h;

    /* renamed from: i, reason: collision with root package name */
    public final int f41252i;

    /* renamed from: j, reason: collision with root package name */
    public final int f41253j;

    /* renamed from: k, reason: collision with root package name */
    public final int f41254k;

    /* renamed from: l, reason: collision with root package name */
    public final int f41255l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f41256m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f41257n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f41258o;

    /* renamed from: p, reason: collision with root package name */
    public int f41259p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f41260q;

    /* renamed from: r, reason: collision with root package name */
    public int f41261r;

    /* renamed from: s, reason: collision with root package name */
    public int f41262s;

    /* renamed from: t, reason: collision with root package name */
    public int f41263t;

    /* renamed from: u, reason: collision with root package name */
    public int f41264u;

    /* renamed from: v, reason: collision with root package name */
    public int f41265v;

    /* renamed from: w, reason: collision with root package name */
    public int f41266w;

    /* renamed from: x, reason: collision with root package name */
    public l.a f41267x;

    /* renamed from: y, reason: collision with root package name */
    public final Runnable f41268y;

    /* renamed from: z, reason: collision with root package name */
    public e f41269z;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PopupNestedScrollingLayout.this.l();
        }
    }

    public class b implements e.r {
        public b() {
        }

        @Override // androidx.dynamicanimation.animation.e.r
        public void b(androidx.dynamicanimation.animation.e eVar, float f10, float f11) {
            PopupNestedScrollingLayout.this.n((int) f10);
        }
    }

    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f41272a;

        public c(int i10) {
            this.f41272a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            PopupNestedScrollingLayout.this.n(this.f41272a);
        }
    }

    public interface e {
        void a(int i10);
    }

    public PopupNestedScrollingLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static View f(ViewGroup viewGroup, float f10, float f11) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (i(childAt, f10, f11)) {
                return childAt;
            }
        }
        return null;
    }

    public static boolean i(View view, float f10, float f11) {
        float x10 = view.getX();
        float y10 = view.getY();
        return f10 >= x10 && f11 >= y10 && f10 < ((float) view.getWidth()) + x10 && f11 < ((float) view.getHeight()) + y10;
    }

    private void r(int i10) {
        this.f41261r = i10;
        if (i10 == 0) {
            n(this.f41265v);
        } else if (i10 == 1) {
            n(0);
        } else {
            if (i10 != 2) {
                return;
            }
            n(-this.f41264u);
        }
    }

    private void setSpringForce(int i10) {
        if (this.f41261r == i10) {
            this.f41249f.B(new androidx.dynamicanimation.animation.j().f(f41231Q).h(f41232R));
            return;
        }
        if (i10 == 0 || i10 == 1) {
            this.f41249f.B(new androidx.dynamicanimation.animation.j().f(f41227M).h(f41228N));
        } else {
            if (i10 != 2) {
                return;
            }
            this.f41249f.B(new androidx.dynamicanimation.animation.j().f(f41229O).h(f41230P));
        }
    }

    public boolean b(View view, boolean z10) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            view.getScrollX();
            view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                if (b(viewGroup.getChildAt(childCount), true)) {
                    return true;
                }
            }
        }
        if (z10) {
            return view.canScrollVertically(-1) || view.canScrollVertically(1);
        }
        return false;
    }

    public final void c() {
        if (this.f41267x == null || this.f41233A || !j()) {
            return;
        }
        o();
    }

    public boolean d() throws Settings.SettingNotFoundException {
        float f10;
        try {
            f10 = Settings.Global.getFloat(getContext().getContentResolver(), "transition_animation_scale");
        } catch (Exception unused) {
            f10 = 1.0f;
        }
        return f10 != 0.0f;
    }

    public final void e() {
    }

    public final int g(int i10) {
        if (!this.f41233A && this.f41235C != 0) {
            return i10;
        }
        int i11 = this.f41262s - (i10 == 0 ? this.f41265v : i10 == 1 ? 0 : -this.f41264u);
        int iAbs = Math.abs(i11);
        if (i11 > 0) {
            if (i10 != 2) {
                if (i10 == 1) {
                    return (iAbs <= this.f41252i || this.f41235C != 0) ? 1 : 0;
                }
                return 0;
            }
            int i12 = this.f41264u;
            int i13 = this.f41252i;
            if (iAbs > i12 + i13) {
                return 0;
            }
            return iAbs > i13 ? 1 : 2;
        }
        if (i10 != 0) {
            if (i10 == 1) {
                return (iAbs <= this.f41252i || !this.f41233A || this.f41258o) ? 1 : 2;
            }
            return 2;
        }
        if (this.f41235C == 2) {
            return (iAbs <= this.f41252i || !this.f41233A) ? 0 : 2;
        }
        int i14 = this.f41265v;
        int i15 = this.f41252i;
        if (iAbs <= i14 + i15 || !this.f41233A || this.f41258o) {
            return iAbs > i15 ? 1 : 0;
        }
        return 2;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new d(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new d(getContext(), attributeSet);
    }

    public int getCurrentScrollY() {
        return this.f41262s;
    }

    public int getPositionState() {
        return this.f41261r;
    }

    public int getUncollapsibleHeight() {
        return this.f41264u;
    }

    public final int h(int i10, float f10) {
        boolean z10 = this.f41233A;
        if ((!z10 && this.f41235C != 0) || this.f41258o) {
            return i10;
        }
        int i11 = this.f41262s;
        if (i11 < (-this.f41264u) || i11 >= 0) {
            int i12 = this.f41235C;
            return i12 == 2 ? f10 > 0.0f ? 2 : 0 : (f10 >= 0.0f || i12 != 0) ? 1 : 0;
        }
        if (this.f41235C == 1) {
            return f10 > 0.0f ? 2 : 1;
        }
        if (f10 < 0.0f || !z10) {
            return (f10 >= (-this.f41250g) || i10 != 0) ? 1 : 0;
        }
        return 2;
    }

    public final boolean j() {
        int i10 = this.f41235C;
        return (i10 == 1 || this.f41261r == 1) ? this.f41262s <= (-(this.f41255l - this.f41253j)) && !this.f41256m : i10 == 2 && Math.abs(this.f41262s - this.f41265v) >= this.f41255l - this.f41253j && !this.f41256m;
    }

    public final int k(int i10, boolean z10) {
        int i11 = this.f41262s;
        int i12 = i11 + i10;
        int i13 = this.f41265v;
        if (i12 > i13) {
            i10 = i13 - i11;
        }
        if (!this.f41233A) {
            int i14 = this.f41235C;
            if (i14 == 1 && (i10 < 0 || !z10)) {
                i10 = v(i10, i11);
            } else if (i14 == 2 && (i10 < 0 || !z10)) {
                i10 = v(i10, i11 - i13);
            } else if (this.f41261r == 1 && i10 < 0) {
                i10 = v(i10, i11);
            }
        } else if (this.f41258o && i10 < 0 && i11 <= 0) {
            i10 = v(i10, i11);
        } else if (this.f41235C == 1 && i10 > 0 && !z10) {
            i10 = v(i10, i11);
        }
        this.f41249f.d();
        m(i10);
        return i10;
    }

    public final void l() {
        l.a aVar = this.f41267x;
        if (aVar != null) {
            aVar.b();
        }
        this.f41256m = true;
    }

    public final void m(int i10) {
        q(-i10);
        int i11 = this.f41262s + i10;
        this.f41262s = i11;
        e eVar = this.f41269z;
        if (eVar != null) {
            eVar.a(i11);
        }
        if (this.f41262s >= 0 || this.f41267x == null) {
            return;
        }
        this.f41267x.c(Math.abs(r2) / this.f41264u);
    }

    public void n(int i10) {
        m(i10 - this.f41262s);
    }

    public final void o() {
        if (!this.f41238F && post(this.f41268y)) {
            this.f41238F = true;
        }
        if (this.f41238F) {
            return;
        }
        l();
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        Configuration configuration = getResources().getConfiguration();
        int systemWindowInsetTop = windowInsets.getSystemWindowInsetTop();
        setPadding(getPaddingLeft(), configuration.orientation == 1 ? this.f41247d + systemWindowInsetTop : systemWindowInsetTop, getPaddingRight(), getPaddingBottom());
        return windowInsets.inset(0, systemWindowInsetTop, 0, 0);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        requestLayout();
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R$dimen.stepos_lite_popup_padding_horizontal_f);
        setPadding(dimensionPixelOffset, getPaddingTop(), dimensionPixelOffset, getPaddingBottom());
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003a  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            int r0 = r5.getActionMasked()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L3e
            if (r0 == r2) goto L3a
            r3 = 2
            if (r0 == r3) goto L11
            r5 = 3
            if (r0 == r5) goto L3a
            goto L60
        L11:
            float r0 = r5.getY()
            float r3 = r4.f41239G
            float r0 = r0 - r3
            boolean r3 = r4.f41234B
            if (r3 != 0) goto L33
            android.view.View r3 = r4.f41242J
            if (r3 == 0) goto L33
            boolean r3 = r4.b(r3, r2)
            if (r3 != 0) goto L33
            float r0 = java.lang.Math.abs(r0)
            int r3 = r4.f41253j
            float r3 = (float) r3
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L33
            r4.f41234B = r2
        L33:
            float r5 = r5.getY()
            r4.f41240H = r5
            goto L60
        L3a:
            r4.e()
            goto L60
        L3e:
            r4.p()
            float r0 = r5.getY()
            r4.f41239G = r0
            float r0 = r5.getY()
            r4.f41240H = r0
            float r5 = r5.getX()
            float r0 = r4.f41239G
            android.view.View r5 = f(r4, r5, r0)
            r4.f41242J = r5
            if (r5 == 0) goto L5d
            r5 = r2
            goto L5e
        L5d:
            r5 = r1
        L5e:
            r4.f41241I = r5
        L60:
            boolean r5 = r4.f41234B
            if (r5 == 0) goto L69
            boolean r4 = r4.f41257n
            if (r4 != 0) goto L69
            return r2
        L69:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.PopupNestedScrollingLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int width = getWidth();
        int measuredHeight = (getMeasuredHeight() - this.f41264u) - this.f41262s;
        int paddingLeft = getPaddingLeft();
        int paddingRight = width - getPaddingRight();
        int childCount = getChildCount();
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            d dVar = (d) childAt.getLayoutParams();
            if (childAt.getVisibility() != 8 && !dVar.f41274a) {
                int i15 = measuredHeight + ((ViewGroup.MarginLayoutParams) dVar).topMargin;
                int measuredHeight2 = childAt.getMeasuredHeight() + i15;
                int measuredWidth = childAt.getMeasuredWidth();
                int i16 = (((paddingRight - paddingLeft) - measuredWidth) / 2) + paddingLeft;
                childAt.layout(i16, i15, measuredWidth + i16, measuredHeight2);
                measuredHeight = measuredHeight2 + ((ViewGroup.MarginLayoutParams) dVar).bottomMargin;
            }
        }
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt2 = getChildAt(i17);
            d dVar2 = (d) childAt2.getLayoutParams();
            if (childAt2.getVisibility() != 8 && dVar2.f41274a) {
                int height = (((getHeight() - childAt2.getMeasuredHeight()) - (dVar2.f41275b ? 0 : getPaddingBottom())) - ((ViewGroup.MarginLayoutParams) dVar2).bottomMargin) + this.f41243K;
                int measuredHeight3 = childAt2.getMeasuredHeight() + height;
                int measuredWidth2 = childAt2.getMeasuredWidth();
                int i18 = (((paddingRight - paddingLeft) - measuredWidth2) / 2) + paddingLeft;
                childAt2.layout(i18, height, measuredWidth2 + i18, measuredHeight3);
            }
        }
        if (this.f41235C == 2 && this.f41261r != 2 && z10) {
            r(0);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        if (this.f41266w < size2) {
            this.f41266w = size2;
        }
        int iMin = Math.min(size2, this.f41266w);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        int measuredHeight = paddingTop;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            d dVar = (d) childAt.getLayoutParams();
            if (childAt.getVisibility() != 8 && !dVar.f41276c) {
                measureChildWithMargins(childAt, iMakeMeasureSpec, 0, iMakeMeasureSpec2, measuredHeight);
                if (!dVar.f41275b) {
                    measuredHeight += childAt.getMeasuredHeight();
                }
            }
        }
        int i13 = iMin - measuredHeight;
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt2 = getChildAt(i14);
            d dVar2 = (d) childAt2.getLayoutParams();
            if (childAt2.getVisibility() != 8 && dVar2.f41276c) {
                if ((childAt2 instanceof LitePopupContentFrameLayout) && this.f41235C == 1) {
                    LitePopupContentFrameLayout litePopupContentFrameLayout = (LitePopupContentFrameLayout) childAt2;
                    if (this.f41260q) {
                        litePopupContentFrameLayout.setLimitHeight((this.f41264u - measuredHeight) + getPaddingTop());
                    }
                }
                childAt2.measure(ViewGroup.getChildMeasureSpec(iMakeMeasureSpec, getPaddingLeft() + getPaddingRight() + ((ViewGroup.MarginLayoutParams) dVar2).leftMargin + ((ViewGroup.MarginLayoutParams) dVar2).rightMargin, ((ViewGroup.MarginLayoutParams) dVar2).width), ViewGroup.getChildMeasureSpec(iMakeMeasureSpec2, getPaddingTop() + getPaddingBottom() + ((ViewGroup.MarginLayoutParams) dVar2).topMargin + ((ViewGroup.MarginLayoutParams) dVar2).bottomMargin + measuredHeight, i13));
                measuredHeight += childAt2.getMeasuredHeight();
            }
        }
        this.f41264u = Math.min(this.f41263t, (measuredHeight - getPaddingTop()) - getPaddingBottom());
        this.f41265v = Math.max(0, ((measuredHeight - getPaddingBottom()) - getPaddingTop()) - this.f41264u);
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f10, float f11) {
        boolean z10 = this.f41262s <= this.f41265v || j();
        if (z10) {
            boolean zCanScrollVertically = view.canScrollVertically(-1);
            if (f11 < 0.0f && zCanScrollVertically && this.f41261r == 0) {
                return false;
            }
            if (s(f11)) {
                int iH = h(this.f41261r, -f11);
                this.f41259p = iH;
                if (this.f41261r != iH) {
                    t(iH);
                } else {
                    z10 = !zCanScrollVertically;
                }
            }
            if (view instanceof StepOSRecyclerView) {
                ((StepOSRecyclerView) view).setOverScrollEnable(false);
            }
        }
        return z10;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr) {
        onNestedPreScroll(view, i10, i11, iArr, 0);
    }

    @Override // androidx.core.view.InterfaceC1335x
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13, int i14) {
    }

    @Override // androidx.core.view.InterfaceC1335x
    public void onNestedScrollAccepted(View view, View view2, int i10, int i11) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i10) {
        return onStartNestedScroll(view, view2, i10, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002b  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            android.view.VelocityTracker r0 = r4.f41246c
            r0.addMovement(r5)
            int r0 = r5.getAction()
            r1 = 0
            r2 = 2
            r3 = 1
            if (r0 == r3) goto L2b
            if (r0 == r2) goto L14
            r5 = 3
            if (r0 == r5) goto L2b
            goto L7c
        L14:
            boolean r0 = r4.f41241I
            if (r0 == 0) goto L7c
            float r0 = r5.getY()
            float r2 = r4.f41240H
            float r0 = r0 - r2
            float r5 = r5.getY()
            r4.f41240H = r5
            float r5 = -r0
            int r5 = (int) r5
            r4.k(r5, r1)
            goto L7c
        L2b:
            boolean r5 = r4.f41241I
            if (r5 == 0) goto L56
            android.view.VelocityTracker r5 = r4.f41246c
            r0 = 1000(0x3e8, float:1.401E-42)
            r5.computeCurrentVelocity(r0)
            android.view.VelocityTracker r5 = r4.f41246c
            float r5 = r5.getYVelocity()
            boolean r0 = r4.s(r5)
            if (r0 == 0) goto L4c
            int r0 = r4.f41261r
            int r5 = r4.h(r0, r5)
            r4.t(r5)
            goto L74
        L4c:
            int r5 = r4.f41261r
            int r5 = r4.g(r5)
            r4.t(r5)
            goto L74
        L56:
            boolean r5 = r4.f41236D
            if (r5 == 0) goto L6b
            android.content.res.Resources r5 = r4.getResources()
            android.content.res.Configuration r5 = r5.getConfiguration()
            int r5 = r5.orientation
            if (r5 == r2) goto L6a
            int r5 = r4.f41261r
            if (r5 != r3) goto L6b
        L6a:
            r1 = r3
        L6b:
            stepos.support.v7.app.l$a r5 = r4.f41267x
            if (r5 == 0) goto L74
            if (r1 == 0) goto L74
            r5.a(r3)
        L74:
            r4.c()
            android.view.VelocityTracker r4 = r4.f41246c
            r4.clear()
        L7c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.PopupNestedScrollingLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p() {
        this.f41234B = false;
        this.f41256m = false;
        this.f41257n = false;
        this.f41238F = false;
        this.f41258o = false;
        this.f41259p = -1;
    }

    public final void q(int i10) {
        int i11 = this.f41262s;
        int i12 = (-i10) + i11 >= 0 ? -this.f41243K : (i11 <= 0 || i10 <= 0) ? i10 : i10 - i11;
        this.f41243K += i12;
        int childCount = getChildCount();
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (((d) childAt.getLayoutParams()).f41274a) {
                childAt.offsetTopAndBottom(i12);
            } else {
                childAt.offsetTopAndBottom(i10);
            }
        }
    }

    public final boolean s(float f10) {
        return Math.abs(f10) > this.f41245b;
    }

    public void setDismissedOnTouchOutside(boolean z10) {
        this.f41236D = z10;
    }

    public void setMaxHeight(int i10) {
        this.f41266w = i10;
    }

    public void setOnDismissedListener(l.a aVar) {
        this.f41267x = aVar;
    }

    public void setScrollListener(e eVar) {
        this.f41269z = eVar;
    }

    public void setScrollPopupFirstOnTop(boolean z10) {
        this.f41237E = z10;
    }

    public void setScrollToDismissEnabled(boolean z10) {
        this.f41233A = z10;
    }

    public void setStyle(int i10) {
        this.f41235C = i10;
    }

    public void setUncollapsibleHeight(int i10) {
        this.f41263t = i10;
        requestLayout();
    }

    public void t(int i10) {
        setSpringForce(i10);
        this.f41261r = i10;
        if (i10 == 0) {
            u(this.f41265v);
            return;
        }
        if (i10 == 1) {
            u(0);
            return;
        }
        if (i10 != 2) {
            return;
        }
        this.f41249f.d();
        l.a aVar = this.f41267x;
        if (aVar != null) {
            aVar.a(false);
        }
    }

    public final void u(int i10) {
        if (this.f41262s == i10) {
            return;
        }
        this.f41249f.d();
        this.f41249f.q(this.f41262s);
        this.f41249f.y().g(i10);
        if (d()) {
            this.f41249f.t();
        } else {
            post(new c(i10));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x003e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0040 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int v(int r6, int r7) {
        /*
            r5 = this;
            int r0 = r5.f41254k
            if (r7 == 0) goto L43
            if (r0 == 0) goto L43
            int r1 = r5.f41261r
            r2 = 1
            if (r1 != r2) goto Lf
            int r3 = r7 * r6
            if (r3 > 0) goto L15
        Lf:
            if (r1 != 0) goto L41
            int r1 = r7 * r6
            if (r1 <= 0) goto L41
        L15:
            int r1 = java.lang.Math.abs(r7)
            float r1 = (float) r1
            r3 = 1065353216(0x3f800000, float:1.0)
            float r1 = r1 * r3
            float r4 = (float) r0
            float r1 = r1 / r4
            android.animation.TimeInterpolator r5 = r5.f41248e
            float r5 = r5.getInterpolation(r1)
            float r3 = r3 - r5
            r5 = 0
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 >= 0) goto L2c
            r3 = r5
        L2c:
            float r5 = (float) r6
            float r5 = r5 * r3
            int r5 = (int) r5
            if (r6 <= 0) goto L34
            if (r5 != 0) goto L37
            goto L38
        L34:
            if (r5 != 0) goto L37
            r5 = -1
        L37:
            r2 = r5
        L38:
            int r5 = java.lang.Math.abs(r7)
            if (r5 < r0) goto L40
            r5 = 0
            return r5
        L40:
            return r2
        L41:
            int r6 = r6 / 2
        L43:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.PopupNestedScrollingLayout.v(int, int):int");
    }

    public PopupNestedScrollingLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f41248e = D0.a.a(0.12f, 0.0f, 0.33f, 1.0f);
        this.f41256m = false;
        this.f41260q = true;
        this.f41261r = 1;
        this.f41262s = 0;
        this.f41268y = new a();
        this.f41233A = true;
        this.f41235C = 0;
        this.f41236D = true;
        this.f41237E = false;
        this.f41238F = false;
        this.f41243K = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PopupNestedScrollingLayout, i10, 0);
        this.f41266w = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.PopupNestedScrollingLayout_steposLayoutMaxHeight, -1);
        this.f41247d = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.PopupNestedScrollingLayout_steposTopPaddingP, getResources().getDimensionPixelSize(R$dimen.stepos_lite_popup_padding_top));
        typedArrayObtainStyledAttributes.recycle();
        this.f41244a = new OverScroller(context, f41226L);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f41245b = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f41250g = getResources().getDimensionPixelSize(R$dimen.stepos_config_popup_nested_scroll_abandon_velocity);
        this.f41251h = getResources().getDimensionPixelSize(R$dimen.stepos_config_popup_nested_fling_down_velocity);
        this.f41246c = VelocityTracker.obtain();
        setClipToPadding(false);
        this.f41253j = viewConfiguration.getScaledTouchSlop();
        this.f41254k = context.getResources().getDimensionPixelSize(R$dimen.stepos_lite_popup_over_scroll_distance);
        this.f41255l = context.getResources().getDimensionPixelSize(R$dimen.stepos_lite_popup_dismiss_triggered_distance);
        this.f41252i = context.getResources().getDimensionPixelSize(R$dimen.stepos_lite_popup_scroll_down_threshold);
        this.f41263t = context.getResources().getDimensionPixelSize(R$dimen.stepos_lite_popup_middle_state_height);
        androidx.dynamicanimation.animation.i iVar = new androidx.dynamicanimation.animation.i(new androidx.dynamicanimation.animation.g());
        this.f41249f = iVar;
        iVar.c(new b());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof d ? new d((d) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new d((ViewGroup.MarginLayoutParams) layoutParams) : new d(layoutParams);
    }

    @Override // androidx.core.view.InterfaceC1335x
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr, int i12) {
        boolean z10 = false;
        boolean z11 = i11 > 0 && (((!this.f41237E ? this.f41262s < this.f41265v : this.f41262s <= this.f41265v) && this.f41235C != 1) || (this.f41262s < 0 && this.f41235C == 1));
        if (i11 < 0 && !view.canScrollVertically(-1)) {
            z10 = true;
        }
        if (z11 || (z10 && !this.f41258o)) {
            iArr[1] = k(i11, true);
        } else if (i11 != 0) {
            this.f41258o = true;
        }
    }

    @Override // androidx.core.view.InterfaceC1336y
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        if (i13 >= 0 || view.canScrollVertically(-1) || this.f41258o) {
            return;
        }
        iArr[1] = k(i13, true);
    }

    @Override // androidx.core.view.InterfaceC1335x
    public boolean onStartNestedScroll(View view, View view2, int i10, int i11) {
        if (view2 instanceof StepOSRecyclerView) {
            ((StepOSRecyclerView) view2).setOverScrollEnable(true);
        }
        this.f41259p = -1;
        return (i10 & 2) != 0;
    }

    @Override // androidx.core.view.InterfaceC1335x
    public void onStopNestedScroll(View view, int i10) {
        if (this.f41249f.i()) {
            return;
        }
        int iG = g(this.f41261r);
        int i11 = this.f41259p;
        if (i11 != -1 && i11 != 2) {
            iG = i11;
        }
        t(iG);
        c();
    }

    public static class d extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public boolean f41274a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f41275b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f41276c;

        public d(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PopupNestedScrollingLayout_LayoutParams);
            this.f41274a = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PopupNestedScrollingLayout_LayoutParams_layout_nested_alignParentBottom, false);
            this.f41275b = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PopupNestedScrollingLayout_LayoutParams_layout_nested_ignoreParentPadding, false);
            this.f41276c = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PopupNestedScrollingLayout_LayoutParams_layout_nested_scrollview, false);
            typedArrayObtainStyledAttributes.recycle();
        }

        public d(int i10, int i11) {
            super(i10, i11);
        }

        public d(d dVar) {
            super((ViewGroup.MarginLayoutParams) dVar);
            this.f41274a = dVar.f41274a;
            this.f41275b = dVar.f41275b;
            this.f41276c = dVar.f41276c;
        }

        public d(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public d(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }
}

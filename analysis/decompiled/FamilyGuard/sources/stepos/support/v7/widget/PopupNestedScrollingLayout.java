package stepos.support.v7.widget;

import P.e;
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
import androidx.core.view.InterfaceC0477w;
import stepos.support.v7.app.m;

/* loaded from: classes.dex */
public class PopupNestedScrollingLayout extends ViewGroup implements InterfaceC0477w {

    /* renamed from: L, reason: collision with root package name */
    private static final Interpolator f21606L = androidx.core.view.animation.a.a(0.2f, 0.03f, 0.0f, 1.0f);

    /* renamed from: M, reason: collision with root package name */
    public static float f21607M = 0.88f;

    /* renamed from: Q, reason: collision with root package name */
    public static float f21608Q = 340.0f;

    /* renamed from: R, reason: collision with root package name */
    public static float f21609R = 0.93f;

    /* renamed from: S, reason: collision with root package name */
    public static float f21610S = 400.0f;

    /* renamed from: T, reason: collision with root package name */
    public static float f21611T = 0.98f;

    /* renamed from: U, reason: collision with root package name */
    public static float f21612U = 300.0f;

    /* renamed from: A, reason: collision with root package name */
    private boolean f21613A;

    /* renamed from: B, reason: collision with root package name */
    private boolean f21614B;

    /* renamed from: C, reason: collision with root package name */
    private int f21615C;

    /* renamed from: D, reason: collision with root package name */
    private boolean f21616D;

    /* renamed from: E, reason: collision with root package name */
    private boolean f21617E;

    /* renamed from: F, reason: collision with root package name */
    private boolean f21618F;

    /* renamed from: G, reason: collision with root package name */
    private float f21619G;

    /* renamed from: H, reason: collision with root package name */
    private float f21620H;

    /* renamed from: I, reason: collision with root package name */
    private boolean f21621I;

    /* renamed from: J, reason: collision with root package name */
    private View f21622J;

    /* renamed from: K, reason: collision with root package name */
    private int f21623K;

    /* renamed from: a, reason: collision with root package name */
    private final OverScroller f21624a;

    /* renamed from: b, reason: collision with root package name */
    private final float f21625b;

    /* renamed from: c, reason: collision with root package name */
    private final VelocityTracker f21626c;

    /* renamed from: d, reason: collision with root package name */
    private final int f21627d;

    /* renamed from: e, reason: collision with root package name */
    private final TimeInterpolator f21628e;

    /* renamed from: f, reason: collision with root package name */
    private final P.i f21629f;

    /* renamed from: g, reason: collision with root package name */
    private final float f21630g;

    /* renamed from: h, reason: collision with root package name */
    private final float f21631h;

    /* renamed from: i, reason: collision with root package name */
    private final int f21632i;

    /* renamed from: j, reason: collision with root package name */
    private final int f21633j;

    /* renamed from: k, reason: collision with root package name */
    private final int f21634k;

    /* renamed from: l, reason: collision with root package name */
    private final int f21635l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f21636m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f21637n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f21638o;

    /* renamed from: p, reason: collision with root package name */
    private int f21639p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f21640q;

    /* renamed from: r, reason: collision with root package name */
    private int f21641r;

    /* renamed from: s, reason: collision with root package name */
    private int f21642s;

    /* renamed from: t, reason: collision with root package name */
    private int f21643t;

    /* renamed from: u, reason: collision with root package name */
    private int f21644u;

    /* renamed from: v, reason: collision with root package name */
    private int f21645v;

    /* renamed from: w, reason: collision with root package name */
    private int f21646w;

    /* renamed from: x, reason: collision with root package name */
    private m.a f21647x;

    /* renamed from: y, reason: collision with root package name */
    private final Runnable f21648y;

    /* renamed from: z, reason: collision with root package name */
    private e f21649z;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PopupNestedScrollingLayout.this.r();
        }
    }

    class b implements e.r {
        b() {
        }

        @Override // P.e.r
        public void a(P.e eVar, float f5, float f6) {
            PopupNestedScrollingLayout.this.t((int) f5);
        }
    }

    class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f21652a;

        c(int i5) {
            this.f21652a = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            PopupNestedScrollingLayout.this.t(this.f21652a);
        }
    }

    public interface e {
        void a(int i5);
    }

    public PopupNestedScrollingLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void A(int i5) {
        if (this.f21642s == i5) {
            return;
        }
        this.f21629f.d();
        this.f21629f.m(this.f21642s);
        this.f21629f.u().g(i5);
        if (d()) {
            this.f21629f.p();
        } else {
            post(new c(i5));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x003e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0040 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int B(int r6, int r7) {
        /*
            r5 = this;
            int r0 = r5.f21634k
            if (r7 == 0) goto L43
            if (r0 == 0) goto L43
            int r1 = r5.f21641r
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
            android.animation.TimeInterpolator r5 = r5.f21628e
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
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.PopupNestedScrollingLayout.B(int, int):int");
    }

    private void c() {
        if (this.f21647x == null || this.f21613A || !p()) {
            return;
        }
        u();
    }

    private void e() {
    }

    private static View f(ViewGroup viewGroup, float f5, float f6) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (i(childAt, f5, f6)) {
                return childAt;
            }
        }
        return null;
    }

    private int g(int i5) {
        if (!this.f21613A && this.f21615C != 0) {
            return i5;
        }
        int i6 = this.f21642s - (i5 == 0 ? this.f21645v : i5 == 1 ? 0 : -this.f21644u);
        int iAbs = Math.abs(i6);
        if (i6 > 0) {
            if (i5 != 2) {
                if (i5 == 1) {
                    return (iAbs <= this.f21632i || this.f21615C != 0) ? 1 : 0;
                }
                return 0;
            }
            int i7 = this.f21644u;
            int i8 = this.f21632i;
            if (iAbs > i7 + i8) {
                return 0;
            }
            return iAbs > i8 ? 1 : 2;
        }
        if (i5 != 0) {
            if (i5 == 1) {
                return (iAbs <= this.f21632i || !this.f21613A || this.f21638o) ? 1 : 2;
            }
            return 2;
        }
        if (this.f21615C == 2) {
            return (iAbs <= this.f21632i || !this.f21613A) ? 0 : 2;
        }
        int i9 = this.f21645v;
        int i10 = this.f21632i;
        if (iAbs <= i9 + i10 || !this.f21613A || this.f21638o) {
            return iAbs > i10 ? 1 : 0;
        }
        return 2;
    }

    private int h(int i5, float f5) {
        boolean z5 = this.f21613A;
        if ((!z5 && this.f21615C != 0) || this.f21638o) {
            return i5;
        }
        int i6 = this.f21642s;
        if (i6 < (-this.f21644u) || i6 >= 0) {
            int i7 = this.f21615C;
            return i7 == 2 ? f5 > 0.0f ? 2 : 0 : (f5 >= 0.0f || i7 != 0) ? 1 : 0;
        }
        if (this.f21615C == 1) {
            return f5 > 0.0f ? 2 : 1;
        }
        if (f5 < 0.0f || !z5) {
            return (f5 >= (-this.f21630g) || i5 != 0) ? 1 : 0;
        }
        return 2;
    }

    private static boolean i(View view, float f5, float f6) {
        float x5 = view.getX();
        float y5 = view.getY();
        return f5 >= x5 && f6 >= y5 && f5 < ((float) view.getWidth()) + x5 && f6 < ((float) view.getHeight()) + y5;
    }

    private boolean p() {
        int i5 = this.f21615C;
        return (i5 == 1 || this.f21641r == 1) ? this.f21642s <= (-(this.f21635l - this.f21633j)) && !this.f21636m : i5 == 2 && Math.abs(this.f21642s - this.f21645v) >= this.f21635l - this.f21633j && !this.f21636m;
    }

    private int q(int i5, boolean z5) {
        int i6 = this.f21642s;
        int i7 = i6 + i5;
        int i8 = this.f21645v;
        if (i7 > i8) {
            i5 = i8 - i6;
        }
        if (!this.f21613A) {
            int i9 = this.f21615C;
            if (i9 == 1 && (i5 < 0 || !z5)) {
                i5 = B(i5, i6);
            } else if (i9 == 2 && (i5 < 0 || !z5)) {
                i5 = B(i5, i6 - i8);
            } else if (this.f21641r == 1 && i5 < 0) {
                i5 = B(i5, i6);
            }
        } else if (this.f21638o && i5 < 0 && i6 <= 0) {
            i5 = B(i5, i6);
        } else if (this.f21615C == 1 && i5 > 0 && !z5) {
            i5 = B(i5, i6);
        }
        this.f21629f.d();
        s(i5);
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        m.a aVar = this.f21647x;
        if (aVar != null) {
            aVar.c();
        }
        this.f21636m = true;
    }

    private void s(int i5) {
        w(-i5);
        int i6 = this.f21642s + i5;
        this.f21642s = i6;
        e eVar = this.f21649z;
        if (eVar != null) {
            eVar.a(i6);
        }
        if (this.f21642s >= 0 || this.f21647x == null) {
            return;
        }
        this.f21647x.b(Math.abs(r2) / this.f21644u);
    }

    private void setSpringForce(int i5) {
        if (this.f21641r == i5) {
            this.f21629f.x(new P.j().f(f21611T).h(f21612U));
            return;
        }
        if (i5 == 0 || i5 == 1) {
            this.f21629f.x(new P.j().f(f21607M).h(f21608Q));
        } else {
            if (i5 != 2) {
                return;
            }
            this.f21629f.x(new P.j().f(f21609R).h(f21610S));
        }
    }

    private void u() {
        if (!this.f21618F && post(this.f21648y)) {
            this.f21618F = true;
        }
        if (this.f21618F) {
            return;
        }
        r();
    }

    private void v() {
        this.f21614B = false;
        this.f21636m = false;
        this.f21637n = false;
        this.f21618F = false;
        this.f21638o = false;
        this.f21639p = -1;
    }

    private void w(int i5) {
        int i6 = this.f21642s;
        int i7 = (-i5) + i6 >= 0 ? -this.f21623K : (i6 <= 0 || i5 <= 0) ? i5 : i5 - i6;
        this.f21623K += i7;
        int childCount = getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (((d) childAt.getLayoutParams()).f21654a) {
                childAt.offsetTopAndBottom(i7);
            } else {
                childAt.offsetTopAndBottom(i5);
            }
        }
    }

    private void x(int i5) {
        this.f21641r = i5;
        if (i5 == 0) {
            t(this.f21645v);
        } else if (i5 == 1) {
            t(0);
        } else {
            if (i5 != 2) {
                return;
            }
            t(-this.f21644u);
        }
    }

    private boolean y(float f5) {
        return Math.abs(f5) > this.f21625b;
    }

    protected boolean b(View view, boolean z5) {
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
        if (z5) {
            return view.canScrollVertically(-1) || view.canScrollVertically(1);
        }
        return false;
    }

    public boolean d() throws Settings.SettingNotFoundException {
        float f5;
        try {
            f5 = Settings.Global.getFloat(getContext().getContentResolver(), "transition_animation_scale");
        } catch (Exception unused) {
            f5 = 1.0f;
        }
        return f5 != 0.0f;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new d(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new d(getContext(), attributeSet);
    }

    public int getCurrentScrollY() {
        return this.f21642s;
    }

    public int getPositionState() {
        return this.f21641r;
    }

    public int getUncollapsibleHeight() {
        return this.f21644u;
    }

    @Override // androidx.core.view.InterfaceC0477w
    public void j(View view, int i5, int i6, int i7, int i8, int i9, int[] iArr) {
        if (i8 >= 0 || view.canScrollVertically(-1) || this.f21638o) {
            return;
        }
        iArr[1] = q(i8, true);
    }

    @Override // androidx.core.view.InterfaceC0476v
    public void k(View view, int i5, int i6, int i7, int i8, int i9) {
    }

    @Override // androidx.core.view.InterfaceC0476v
    public boolean l(View view, View view2, int i5, int i6) {
        if (view2 instanceof StepOSRecyclerView) {
            ((StepOSRecyclerView) view2).setOverScrollEnable(true);
        }
        this.f21639p = -1;
        return (i5 & 2) != 0;
    }

    @Override // androidx.core.view.InterfaceC0476v
    public void m(View view, View view2, int i5, int i6) {
    }

    @Override // androidx.core.view.InterfaceC0476v
    public void n(View view, int i5) {
        if (this.f21629f.i()) {
            return;
        }
        int iG = g(this.f21641r);
        int i6 = this.f21639p;
        if (i6 != -1 && i6 != 2) {
            iG = i6;
        }
        z(iG);
        c();
    }

    @Override // androidx.core.view.InterfaceC0476v
    public void o(View view, int i5, int i6, int[] iArr, int i7) {
        boolean z5 = false;
        boolean z6 = i6 > 0 && (((!this.f21617E ? this.f21642s < this.f21645v : this.f21642s <= this.f21645v) && this.f21615C != 1) || (this.f21642s < 0 && this.f21615C == 1));
        if (i6 < 0 && !view.canScrollVertically(-1)) {
            z5 = true;
        }
        if (z6 || (z5 && !this.f21638o)) {
            iArr[1] = q(i6, true);
        } else if (i6 != 0) {
            this.f21638o = true;
        }
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        Configuration configuration = getResources().getConfiguration();
        int systemWindowInsetTop = windowInsets.getSystemWindowInsetTop();
        setPadding(getPaddingLeft(), configuration.orientation == 1 ? this.f21627d + systemWindowInsetTop : systemWindowInsetTop, getPaddingRight(), getPaddingBottom());
        return windowInsets.inset(0, systemWindowInsetTop, 0, 0);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        requestLayout();
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(X4.d.f5885V);
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
            float r3 = r4.f21619G
            float r0 = r0 - r3
            boolean r3 = r4.f21614B
            if (r3 != 0) goto L33
            android.view.View r3 = r4.f21622J
            if (r3 == 0) goto L33
            boolean r3 = r4.b(r3, r2)
            if (r3 != 0) goto L33
            float r0 = java.lang.Math.abs(r0)
            int r3 = r4.f21633j
            float r3 = (float) r3
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L33
            r4.f21614B = r2
        L33:
            float r5 = r5.getY()
            r4.f21620H = r5
            goto L60
        L3a:
            r4.e()
            goto L60
        L3e:
            r4.v()
            float r0 = r5.getY()
            r4.f21619G = r0
            float r0 = r5.getY()
            r4.f21620H = r0
            float r5 = r5.getX()
            float r0 = r4.f21619G
            android.view.View r5 = f(r4, r5, r0)
            r4.f21622J = r5
            if (r5 == 0) goto L5d
            r5 = r2
            goto L5e
        L5d:
            r5 = r1
        L5e:
            r4.f21621I = r5
        L60:
            boolean r5 = r4.f21614B
            if (r5 == 0) goto L69
            boolean r4 = r4.f21637n
            if (r4 != 0) goto L69
            return r2
        L69:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.PopupNestedScrollingLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
        int width = getWidth();
        int measuredHeight = (getMeasuredHeight() - this.f21644u) - this.f21642s;
        int paddingLeft = getPaddingLeft();
        int paddingRight = width - getPaddingRight();
        int childCount = getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            d dVar = (d) childAt.getLayoutParams();
            if (childAt.getVisibility() != 8 && !dVar.f21654a) {
                int i10 = measuredHeight + ((ViewGroup.MarginLayoutParams) dVar).topMargin;
                int measuredHeight2 = childAt.getMeasuredHeight() + i10;
                int measuredWidth = childAt.getMeasuredWidth();
                int i11 = (((paddingRight - paddingLeft) - measuredWidth) / 2) + paddingLeft;
                childAt.layout(i11, i10, measuredWidth + i11, measuredHeight2);
                measuredHeight = measuredHeight2 + ((ViewGroup.MarginLayoutParams) dVar).bottomMargin;
            }
        }
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt2 = getChildAt(i12);
            d dVar2 = (d) childAt2.getLayoutParams();
            if (childAt2.getVisibility() != 8 && dVar2.f21654a) {
                int height = (((getHeight() - childAt2.getMeasuredHeight()) - (dVar2.f21655b ? 0 : getPaddingBottom())) - ((ViewGroup.MarginLayoutParams) dVar2).bottomMargin) + this.f21623K;
                int measuredHeight3 = childAt2.getMeasuredHeight() + height;
                int measuredWidth2 = childAt2.getMeasuredWidth();
                int i13 = (((paddingRight - paddingLeft) - measuredWidth2) / 2) + paddingLeft;
                childAt2.layout(i13, height, measuredWidth2 + i13, measuredHeight3);
            }
        }
        if (this.f21615C == 2 && this.f21641r != 2 && z5) {
            x(0);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i5, int i6) {
        int size = View.MeasureSpec.getSize(i5);
        int size2 = View.MeasureSpec.getSize(i6);
        if (this.f21646w < size2) {
            this.f21646w = size2;
        }
        int iMin = Math.min(size2, this.f21646w);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        int measuredHeight = paddingTop;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            d dVar = (d) childAt.getLayoutParams();
            if (childAt.getVisibility() != 8 && !dVar.f21656c) {
                measureChildWithMargins(childAt, iMakeMeasureSpec, 0, iMakeMeasureSpec2, measuredHeight);
                if (!dVar.f21655b) {
                    measuredHeight += childAt.getMeasuredHeight();
                }
            }
        }
        int i8 = iMin - measuredHeight;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt2 = getChildAt(i9);
            d dVar2 = (d) childAt2.getLayoutParams();
            if (childAt2.getVisibility() != 8 && dVar2.f21656c) {
                if ((childAt2 instanceof LitePopupContentFrameLayout) && this.f21615C == 1) {
                    LitePopupContentFrameLayout litePopupContentFrameLayout = (LitePopupContentFrameLayout) childAt2;
                    if (this.f21640q) {
                        litePopupContentFrameLayout.setLimitHeight((this.f21644u - measuredHeight) + getPaddingTop());
                    }
                }
                childAt2.measure(ViewGroup.getChildMeasureSpec(iMakeMeasureSpec, getPaddingLeft() + getPaddingRight() + ((ViewGroup.MarginLayoutParams) dVar2).leftMargin + ((ViewGroup.MarginLayoutParams) dVar2).rightMargin, ((ViewGroup.MarginLayoutParams) dVar2).width), ViewGroup.getChildMeasureSpec(iMakeMeasureSpec2, getPaddingTop() + getPaddingBottom() + ((ViewGroup.MarginLayoutParams) dVar2).topMargin + ((ViewGroup.MarginLayoutParams) dVar2).bottomMargin + measuredHeight, i8));
                measuredHeight += childAt2.getMeasuredHeight();
            }
        }
        this.f21644u = Math.min(this.f21643t, (measuredHeight - getPaddingTop()) - getPaddingBottom());
        this.f21645v = Math.max(0, ((measuredHeight - getPaddingBottom()) - getPaddingTop()) - this.f21644u);
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f5, float f6) {
        boolean z5 = this.f21642s <= this.f21645v || p();
        if (z5) {
            boolean zCanScrollVertically = view.canScrollVertically(-1);
            if (f6 < 0.0f && zCanScrollVertically && this.f21641r == 0) {
                return false;
            }
            if (y(f6)) {
                int iH = h(this.f21641r, -f6);
                this.f21639p = iH;
                if (this.f21641r != iH) {
                    z(iH);
                } else {
                    z5 = !zCanScrollVertically;
                }
            }
            if (view instanceof StepOSRecyclerView) {
                ((StepOSRecyclerView) view).setOverScrollEnable(false);
            }
        }
        return z5;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i5, int i6, int[] iArr) {
        o(view, i5, i6, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i5) {
        return l(view, view2, i5, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        n(view, 0);
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
            android.view.VelocityTracker r0 = r4.f21626c
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
            boolean r0 = r4.f21621I
            if (r0 == 0) goto L7c
            float r0 = r5.getY()
            float r2 = r4.f21620H
            float r0 = r0 - r2
            float r5 = r5.getY()
            r4.f21620H = r5
            float r5 = -r0
            int r5 = (int) r5
            r4.q(r5, r1)
            goto L7c
        L2b:
            boolean r5 = r4.f21621I
            if (r5 == 0) goto L56
            android.view.VelocityTracker r5 = r4.f21626c
            r0 = 1000(0x3e8, float:1.401E-42)
            r5.computeCurrentVelocity(r0)
            android.view.VelocityTracker r5 = r4.f21626c
            float r5 = r5.getYVelocity()
            boolean r0 = r4.y(r5)
            if (r0 == 0) goto L4c
            int r0 = r4.f21641r
            int r5 = r4.h(r0, r5)
            r4.z(r5)
            goto L74
        L4c:
            int r5 = r4.f21641r
            int r5 = r4.g(r5)
            r4.z(r5)
            goto L74
        L56:
            boolean r5 = r4.f21616D
            if (r5 == 0) goto L6b
            android.content.res.Resources r5 = r4.getResources()
            android.content.res.Configuration r5 = r5.getConfiguration()
            int r5 = r5.orientation
            if (r5 == r2) goto L6a
            int r5 = r4.f21641r
            if (r5 != r3) goto L6b
        L6a:
            r1 = r3
        L6b:
            stepos.support.v7.app.m$a r5 = r4.f21647x
            if (r5 == 0) goto L74
            if (r1 == 0) goto L74
            r5.a(r3)
        L74:
            r4.c()
            android.view.VelocityTracker r4 = r4.f21626c
            r4.clear()
        L7c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.PopupNestedScrollingLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setDismissedOnTouchOutside(boolean z5) {
        this.f21616D = z5;
    }

    public void setMaxHeight(int i5) {
        this.f21646w = i5;
    }

    public void setOnDismissedListener(m.a aVar) {
        this.f21647x = aVar;
    }

    public void setScrollListener(e eVar) {
        this.f21649z = eVar;
    }

    public void setScrollPopupFirstOnTop(boolean z5) {
        this.f21617E = z5;
    }

    public void setScrollToDismissEnabled(boolean z5) {
        this.f21613A = z5;
    }

    public void setStyle(int i5) {
        this.f21615C = i5;
    }

    public void setUncollapsibleHeight(int i5) {
        this.f21643t = i5;
        requestLayout();
    }

    public void t(int i5) {
        s(i5 - this.f21642s);
    }

    public void z(int i5) {
        setSpringForce(i5);
        this.f21641r = i5;
        if (i5 == 0) {
            A(this.f21645v);
            return;
        }
        if (i5 == 1) {
            A(0);
            return;
        }
        if (i5 != 2) {
            return;
        }
        this.f21629f.d();
        m.a aVar = this.f21647x;
        if (aVar != null) {
            aVar.a(false);
        }
    }

    public PopupNestedScrollingLayout(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f21628e = androidx.core.view.animation.a.a(0.12f, 0.0f, 0.33f, 1.0f);
        this.f21636m = false;
        this.f21640q = true;
        this.f21641r = 1;
        this.f21642s = 0;
        this.f21648y = new a();
        this.f21613A = true;
        this.f21615C = 0;
        this.f21616D = true;
        this.f21617E = false;
        this.f21618F = false;
        this.f21623K = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, X4.l.f6379x2, i5, 0);
        this.f21646w = typedArrayObtainStyledAttributes.getDimensionPixelSize(X4.l.f6385y2, -1);
        this.f21627d = typedArrayObtainStyledAttributes.getDimensionPixelSize(X4.l.f6391z2, getResources().getDimensionPixelSize(X4.d.f5886W));
        typedArrayObtainStyledAttributes.recycle();
        this.f21624a = new OverScroller(context, f21606L);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f21625b = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f21630g = getResources().getDimensionPixelSize(X4.d.f5879P);
        this.f21631h = getResources().getDimensionPixelSize(X4.d.f5878O);
        this.f21626c = VelocityTracker.obtain();
        setClipToPadding(false);
        this.f21633j = viewConfiguration.getScaledTouchSlop();
        this.f21634k = context.getResources().getDimensionPixelSize(X4.d.f5884U);
        this.f21635l = context.getResources().getDimensionPixelSize(X4.d.f5882S);
        this.f21632i = context.getResources().getDimensionPixelSize(X4.d.f5887X);
        this.f21643t = context.getResources().getDimensionPixelSize(X4.d.f5883T);
        P.i iVar = new P.i(new P.g());
        this.f21629f = iVar;
        iVar.c(new b());
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof d ? new d((d) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new d((ViewGroup.MarginLayoutParams) layoutParams) : new d(layoutParams);
    }

    public static class d extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        boolean f21654a;

        /* renamed from: b, reason: collision with root package name */
        boolean f21655b;

        /* renamed from: c, reason: collision with root package name */
        boolean f21656c;

        public d(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, X4.l.f6080A2);
            this.f21654a = typedArrayObtainStyledAttributes.getBoolean(X4.l.f6086B2, false);
            this.f21655b = typedArrayObtainStyledAttributes.getBoolean(X4.l.f6092C2, false);
            this.f21656c = typedArrayObtainStyledAttributes.getBoolean(X4.l.f6098D2, false);
            typedArrayObtainStyledAttributes.recycle();
        }

        public d(int i5, int i6) {
            super(i5, i6);
        }

        public d(d dVar) {
            super((ViewGroup.MarginLayoutParams) dVar);
            this.f21654a = dVar.f21654a;
            this.f21655b = dVar.f21655b;
            this.f21656c = dVar.f21656c;
        }

        public d(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public d(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }
}

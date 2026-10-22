package androidx.swiperefreshlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.ListView;
import androidx.core.view.C1334w;
import androidx.core.view.C1337z;
import androidx.core.view.InterfaceC1331t;
import androidx.core.view.InterfaceC1332u;
import androidx.core.view.InterfaceC1333v;
import androidx.core.view.InterfaceC1335x;
import androidx.core.view.InterfaceC1336y;
import androidx.core.view.N;

/* loaded from: classes.dex */
public class SwipeRefreshLayout extends ViewGroup implements InterfaceC1336y, InterfaceC1335x, InterfaceC1332u, InterfaceC1331t, InterfaceC1333v {

    /* renamed from: P, reason: collision with root package name */
    public static final String f14965P = "SwipeRefreshLayout";

    /* renamed from: Q, reason: collision with root package name */
    public static final int[] f14966Q = {R.attr.enabled};

    /* renamed from: A, reason: collision with root package name */
    public int f14967A;

    /* renamed from: B, reason: collision with root package name */
    public int f14968B;

    /* renamed from: C, reason: collision with root package name */
    public androidx.swiperefreshlayout.widget.b f14969C;

    /* renamed from: D, reason: collision with root package name */
    public Animation f14970D;

    /* renamed from: E, reason: collision with root package name */
    public Animation f14971E;

    /* renamed from: F, reason: collision with root package name */
    public Animation f14972F;

    /* renamed from: G, reason: collision with root package name */
    public Animation f14973G;

    /* renamed from: H, reason: collision with root package name */
    public Animation f14974H;

    /* renamed from: I, reason: collision with root package name */
    public boolean f14975I;

    /* renamed from: J, reason: collision with root package name */
    public int f14976J;

    /* renamed from: K, reason: collision with root package name */
    public boolean f14977K;

    /* renamed from: L, reason: collision with root package name */
    public boolean f14978L;

    /* renamed from: M, reason: collision with root package name */
    public Animation.AnimationListener f14979M;

    /* renamed from: N, reason: collision with root package name */
    public final Animation f14980N;

    /* renamed from: O, reason: collision with root package name */
    public final Animation f14981O;

    /* renamed from: a, reason: collision with root package name */
    public View f14982a;

    /* renamed from: b, reason: collision with root package name */
    public j f14983b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f14984c;

    /* renamed from: d, reason: collision with root package name */
    public int f14985d;

    /* renamed from: e, reason: collision with root package name */
    public float f14986e;

    /* renamed from: f, reason: collision with root package name */
    public float f14987f;

    /* renamed from: g, reason: collision with root package name */
    public final C1337z f14988g;

    /* renamed from: h, reason: collision with root package name */
    public final C1334w f14989h;

    /* renamed from: i, reason: collision with root package name */
    public final int[] f14990i;

    /* renamed from: j, reason: collision with root package name */
    public final int[] f14991j;

    /* renamed from: k, reason: collision with root package name */
    public final int[] f14992k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f14993l;

    /* renamed from: m, reason: collision with root package name */
    public int f14994m;

    /* renamed from: n, reason: collision with root package name */
    public int f14995n;

    /* renamed from: o, reason: collision with root package name */
    public float f14996o;

    /* renamed from: p, reason: collision with root package name */
    public float f14997p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f14998q;

    /* renamed from: r, reason: collision with root package name */
    public int f14999r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f15000s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f15001t;

    /* renamed from: u, reason: collision with root package name */
    public final DecelerateInterpolator f15002u;

    /* renamed from: v, reason: collision with root package name */
    public androidx.swiperefreshlayout.widget.a f15003v;

    /* renamed from: w, reason: collision with root package name */
    public int f15004w;

    /* renamed from: x, reason: collision with root package name */
    public int f15005x;

    /* renamed from: y, reason: collision with root package name */
    public float f15006y;

    /* renamed from: z, reason: collision with root package name */
    public int f15007z;

    public class a implements Animation.AnimationListener {
        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            j jVar;
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (!swipeRefreshLayout.f14984c) {
                swipeRefreshLayout.m();
                return;
            }
            swipeRefreshLayout.f14969C.setAlpha(255);
            SwipeRefreshLayout.this.f14969C.start();
            SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
            if (swipeRefreshLayout2.f14975I && (jVar = swipeRefreshLayout2.f14983b) != null) {
                jVar.a();
            }
            SwipeRefreshLayout swipeRefreshLayout3 = SwipeRefreshLayout.this;
            swipeRefreshLayout3.f14995n = swipeRefreshLayout3.f15003v.getTop();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public class b extends Animation {
        public b() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f10, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(f10);
        }
    }

    public class c extends Animation {
        public c() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f10, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(1.0f - f10);
        }
    }

    public class d extends Animation {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15011a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f15012b;

        public d(int i10, int i11) {
            this.f15011a = i10;
            this.f15012b = i11;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f10, Transformation transformation) {
            SwipeRefreshLayout.this.f14969C.setAlpha((int) (this.f15011a + ((this.f15012b - r0) * f10)));
        }
    }

    public class e implements Animation.AnimationListener {
        public e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (swipeRefreshLayout.f15000s) {
                return;
            }
            swipeRefreshLayout.t(null);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public class f extends Animation {
        public f() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f10, Transformation transformation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            int iAbs = !swipeRefreshLayout.f14977K ? swipeRefreshLayout.f14967A - Math.abs(swipeRefreshLayout.f15007z) : swipeRefreshLayout.f14967A;
            SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
            SwipeRefreshLayout.this.setTargetOffsetTopAndBottom((swipeRefreshLayout2.f15005x + ((int) ((iAbs - r1) * f10))) - swipeRefreshLayout2.f15003v.getTop());
            SwipeRefreshLayout.this.f14969C.e(1.0f - f10);
        }
    }

    public class g extends Animation {
        public g() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f10, Transformation transformation) {
            SwipeRefreshLayout.this.k(f10);
        }
    }

    public class h extends Animation {
        public h() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f10, Transformation transformation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            float f11 = swipeRefreshLayout.f15006y;
            swipeRefreshLayout.setAnimationProgress(f11 + ((-f11) * f10));
            SwipeRefreshLayout.this.k(f10);
        }
    }

    public interface i {
    }

    public interface j {
        void a();
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14984c = false;
        this.f14986e = -1.0f;
        this.f14990i = new int[2];
        this.f14991j = new int[2];
        this.f14992k = new int[2];
        this.f14999r = -1;
        this.f15004w = -1;
        this.f14979M = new a();
        this.f14980N = new f();
        this.f14981O = new g();
        this.f14985d = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f14994m = getResources().getInteger(R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.f15002u = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f14976J = (int) (displayMetrics.density * 40.0f);
        e();
        setChildrenDrawingOrderEnabled(true);
        int i10 = (int) (displayMetrics.density * 64.0f);
        this.f14967A = i10;
        this.f14986e = i10;
        this.f14988g = new C1337z(this);
        this.f14989h = new C1334w(this);
        setNestedScrollingEnabled(true);
        int i11 = -this.f14976J;
        this.f14995n = i11;
        this.f15007z = i11;
        k(1.0f);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f14966Q);
        setEnabled(typedArrayObtainStyledAttributes.getBoolean(0, true));
        typedArrayObtainStyledAttributes.recycle();
    }

    private void l(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f14999r) {
            this.f14999r = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }

    private void setColorViewAlpha(int i10) {
        this.f15003v.getBackground().setAlpha(i10);
        this.f14969C.setAlpha(i10);
    }

    public final void b(int i10, Animation.AnimationListener animationListener) {
        this.f15005x = i10;
        this.f14980N.reset();
        this.f14980N.setDuration(200L);
        this.f14980N.setInterpolator(this.f15002u);
        if (animationListener != null) {
            this.f15003v.b(animationListener);
        }
        this.f15003v.clearAnimation();
        this.f15003v.startAnimation(this.f14980N);
    }

    public final void c(int i10, Animation.AnimationListener animationListener) {
        if (this.f15000s) {
            u(i10, animationListener);
            return;
        }
        this.f15005x = i10;
        this.f14981O.reset();
        this.f14981O.setDuration(200L);
        this.f14981O.setInterpolator(this.f15002u);
        if (animationListener != null) {
            this.f15003v.b(animationListener);
        }
        this.f15003v.clearAnimation();
        this.f15003v.startAnimation(this.f14981O);
    }

    public boolean d() {
        View view = this.f14982a;
        return view instanceof ListView ? ((ListView) view).canScrollList(-1) : view.canScrollVertically(-1);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent == null || keyEvent.getAction() != 1 || keyEvent.getKeyCode() != 285) {
            return super.dispatchKeyEvent(keyEvent);
        }
        o(true, true);
        return true;
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f10, float f11, boolean z10) {
        return this.f14989h.a(f10, f11, z10);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f10, float f11) {
        return this.f14989h.b(f10, f11);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i10, int i11, int[] iArr, int[] iArr2) {
        return this.f14989h.c(i10, i11, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i10, int i11, int i12, int i13, int[] iArr) {
        return this.f14989h.f(i10, i11, i12, i13, iArr);
    }

    public final void e() {
        this.f15003v = new androidx.swiperefreshlayout.widget.a(getContext());
        androidx.swiperefreshlayout.widget.b bVar = new androidx.swiperefreshlayout.widget.b(getContext());
        this.f14969C = bVar;
        bVar.l(1);
        this.f15003v.setImageDrawable(this.f14969C);
        this.f15003v.setVisibility(8);
        addView(this.f15003v);
    }

    public void f(int i10, int i11, int i12, int i13, int[] iArr, int i14, int[] iArr2) {
        if (i14 == 0) {
            this.f14989h.e(i10, i11, i12, i13, iArr, i14, iArr2);
        }
    }

    public final void g() {
        if (this.f14982a == null) {
            for (int i10 = 0; i10 < getChildCount(); i10++) {
                View childAt = getChildAt(i10);
                if (!childAt.equals(this.f15003v)) {
                    this.f14982a = childAt;
                    return;
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i10, int i11) {
        int i12 = this.f15004w;
        return i12 < 0 ? i11 : i11 == i10 + (-1) ? i12 : i11 >= i12 ? i11 + 1 : i11;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f14988g.a();
    }

    public int getProgressCircleDiameter() {
        return this.f14976J;
    }

    public int getProgressViewEndOffset() {
        return this.f14967A;
    }

    public int getProgressViewStartOffset() {
        return this.f15007z;
    }

    public final void h(float f10) {
        if (f10 > this.f14986e) {
            n(true, true);
            return;
        }
        this.f14984c = false;
        this.f14969C.j(0.0f, 0.0f);
        c(this.f14995n, !this.f15000s ? new e() : null);
        this.f14969C.d(false);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return this.f14989h.k();
    }

    public final boolean i(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.f14989h.m();
    }

    public final void j(float f10) {
        this.f14969C.d(true);
        float fMin = Math.min(1.0f, Math.abs(f10 / this.f14986e));
        float fMax = (((float) Math.max(fMin - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float fAbs = Math.abs(f10) - this.f14986e;
        int i10 = this.f14968B;
        if (i10 <= 0) {
            i10 = this.f14977K ? this.f14967A - this.f15007z : this.f14967A;
        }
        float f11 = i10;
        double dMax = Math.max(0.0f, Math.min(fAbs, f11 * 2.0f) / f11) / 4.0f;
        float fPow = ((float) (dMax - Math.pow(dMax, 2.0d))) * 2.0f;
        int i11 = this.f15007z + ((int) ((f11 * fMin) + (f11 * fPow * 2.0f)));
        if (this.f15003v.getVisibility() != 0) {
            this.f15003v.setVisibility(0);
        }
        if (!this.f15000s) {
            this.f15003v.setScaleX(1.0f);
            this.f15003v.setScaleY(1.0f);
        }
        if (this.f15000s) {
            setAnimationProgress(Math.min(1.0f, f10 / this.f14986e));
        }
        if (f10 < this.f14986e) {
            if (this.f14969C.getAlpha() > 76 && !i(this.f14972F)) {
                s();
            }
        } else if (this.f14969C.getAlpha() < 255 && !i(this.f14973G)) {
            r();
        }
        this.f14969C.j(0.0f, Math.min(0.8f, fMax * 0.8f));
        this.f14969C.e(Math.min(1.0f, fMax));
        this.f14969C.g((((fMax * 0.4f) - 0.25f) + (fPow * 2.0f)) * 0.5f);
        setTargetOffsetTopAndBottom(i11 - this.f14995n);
    }

    public void k(float f10) {
        setTargetOffsetTopAndBottom((this.f15005x + ((int) ((this.f15007z - r0) * f10))) - this.f15003v.getTop());
    }

    public void m() {
        this.f15003v.clearAnimation();
        this.f14969C.stop();
        this.f15003v.setVisibility(8);
        setColorViewAlpha(255);
        if (this.f15000s) {
            setAnimationProgress(0.0f);
        } else {
            setTargetOffsetTopAndBottom(this.f15007z - this.f14995n);
        }
        this.f14995n = this.f15003v.getTop();
    }

    public final void n(boolean z10, boolean z11) {
        if (this.f14984c != z10) {
            this.f14975I = z11;
            g();
            this.f14984c = z10;
            if (z10) {
                b(this.f14995n, this.f14979M);
            } else {
                t(this.f14979M);
            }
        }
    }

    public final void o(boolean z10, boolean z11) {
        if (!z10 || this.f14984c == z10) {
            n(z10, false);
            return;
        }
        this.f14984c = z10;
        setTargetOffsetTopAndBottom((!this.f14977K ? this.f14967A + this.f15007z : this.f14967A) - this.f14995n);
        this.f14975I = z11;
        v(this.f14979M);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m();
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0058  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            r4.g()
            int r0 = r5.getActionMasked()
            boolean r1 = r4.f15001t
            r2 = 0
            if (r1 == 0) goto L10
            if (r0 != 0) goto L10
            r4.f15001t = r2
        L10:
            boolean r1 = r4.isEnabled()
            if (r1 == 0) goto L81
            boolean r1 = r4.f15001t
            if (r1 != 0) goto L81
            boolean r1 = r4.d()
            if (r1 != 0) goto L81
            boolean r1 = r4.f14984c
            if (r1 != 0) goto L81
            boolean r1 = r4.f14993l
            if (r1 == 0) goto L29
            goto L81
        L29:
            if (r0 == 0) goto L5d
            r1 = 1
            r3 = -1
            if (r0 == r1) goto L58
            r1 = 2
            if (r0 == r1) goto L3d
            r1 = 3
            if (r0 == r1) goto L58
            r1 = 6
            if (r0 == r1) goto L39
            goto L7e
        L39:
            r4.l(r5)
            goto L7e
        L3d:
            int r0 = r4.f14999r
            if (r0 != r3) goto L49
            java.lang.String r4 = androidx.swiperefreshlayout.widget.SwipeRefreshLayout.f14965P
            java.lang.String r5 = "Got ACTION_MOVE event but don't have an active pointer id."
            android.util.Log.e(r4, r5)
            return r2
        L49:
            int r0 = r5.findPointerIndex(r0)
            if (r0 >= 0) goto L50
            return r2
        L50:
            float r5 = r5.getY(r0)
            r4.q(r5)
            goto L7e
        L58:
            r4.f14998q = r2
            r4.f14999r = r3
            goto L7e
        L5d:
            int r0 = r4.f15007z
            androidx.swiperefreshlayout.widget.a r1 = r4.f15003v
            int r1 = r1.getTop()
            int r0 = r0 - r1
            r4.setTargetOffsetTopAndBottom(r0)
            int r0 = r5.getPointerId(r2)
            r4.f14999r = r0
            r4.f14998q = r2
            int r0 = r5.findPointerIndex(r0)
            if (r0 >= 0) goto L78
            return r2
        L78:
            float r5 = r5.getY(r0)
            r4.f14997p = r5
        L7e:
            boolean r4 = r4.f14998q
            return r4
        L81:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() == 0) {
            return;
        }
        if (this.f14982a == null) {
            g();
        }
        View view = this.f14982a;
        if (view == null) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
        int measuredWidth2 = this.f15003v.getMeasuredWidth();
        int measuredHeight2 = this.f15003v.getMeasuredHeight();
        int i14 = measuredWidth / 2;
        int i15 = measuredWidth2 / 2;
        int i16 = this.f14995n;
        this.f15003v.layout(i14 - i15, i16, i14 + i15, measuredHeight2 + i16);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.f14982a == null) {
            g();
        }
        View view = this.f14982a;
        if (view == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        this.f15003v.measure(View.MeasureSpec.makeMeasureSpec(this.f14976J, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f14976J, 1073741824));
        this.f15004w = -1;
        for (int i12 = 0; i12 < getChildCount(); i12++) {
            if (getChildAt(i12) == this.f15003v) {
                this.f15004w = i12;
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f10, float f11, boolean z10) {
        return dispatchNestedFling(f10, f11, z10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f10, float f11) {
        return dispatchNestedPreFling(f10, f11);
    }

    @Override // androidx.core.view.InterfaceC1335x
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr, int i12) {
        if (i12 == 0) {
            onNestedPreScroll(view, i10, i11, iArr);
        }
    }

    @Override // androidx.core.view.InterfaceC1336y
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        if (i14 != 0) {
            return;
        }
        int i15 = iArr[1];
        f(i10, i11, i12, i13, this.f14991j, i14, iArr);
        int i16 = i13 - (iArr[1] - i15);
        if ((i16 == 0 ? i13 + this.f14991j[1] : i16) >= 0 || d()) {
            return;
        }
        float fAbs = this.f14987f + Math.abs(r14);
        this.f14987f = fAbs;
        j(fAbs);
        iArr[1] = iArr[1] + i16;
    }

    @Override // androidx.core.view.InterfaceC1335x
    public void onNestedScrollAccepted(View view, View view2, int i10, int i11) {
        if (i11 == 0) {
            onNestedScrollAccepted(view, view2, i10);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setRefreshing(savedState.mRefreshing);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.f14984c);
    }

    @Override // androidx.core.view.InterfaceC1335x
    public boolean onStartNestedScroll(View view, View view2, int i10, int i11) {
        if (i11 == 0) {
            return onStartNestedScroll(view, view2, i10);
        }
        return false;
    }

    @Override // androidx.core.view.InterfaceC1335x
    public void onStopNestedScroll(View view, int i10) {
        if (i10 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.f15001t && actionMasked == 0) {
            this.f15001t = false;
        }
        if (!isEnabled() || this.f15001t || d() || this.f14984c || this.f14993l) {
            return false;
        }
        if (actionMasked == 0) {
            this.f14999r = motionEvent.getPointerId(0);
            this.f14998q = false;
        } else {
            if (actionMasked == 1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f14999r);
                if (iFindPointerIndex < 0) {
                    Log.e(f14965P, "Got ACTION_UP event but don't have an active pointer id.");
                    return false;
                }
                if (this.f14998q) {
                    float y10 = (motionEvent.getY(iFindPointerIndex) - this.f14996o) * 0.5f;
                    this.f14998q = false;
                    h(y10);
                }
                this.f14999r = -1;
                return false;
            }
            if (actionMasked == 2) {
                int iFindPointerIndex2 = motionEvent.findPointerIndex(this.f14999r);
                if (iFindPointerIndex2 < 0) {
                    Log.e(f14965P, "Got ACTION_MOVE event but have an invalid active pointer id.");
                    return false;
                }
                float y11 = motionEvent.getY(iFindPointerIndex2);
                q(y11);
                if (this.f14998q) {
                    float f10 = (y11 - this.f14996o) * 0.5f;
                    if (f10 <= 0.0f) {
                        return false;
                    }
                    getParent().requestDisallowInterceptTouchEvent(true);
                    j(f10);
                }
            } else {
                if (actionMasked == 3) {
                    return false;
                }
                if (actionMasked == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    if (actionIndex < 0) {
                        Log.e(f14965P, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                        return false;
                    }
                    this.f14999r = motionEvent.getPointerId(actionIndex);
                } else if (actionMasked == 6) {
                    l(motionEvent);
                }
            }
        }
        return true;
    }

    public final Animation p(int i10, int i11) {
        d dVar = new d(i10, i11);
        dVar.setDuration(300L);
        this.f15003v.b(null);
        this.f15003v.clearAnimation();
        this.f15003v.startAnimation(dVar);
        return dVar;
    }

    public final void q(float f10) {
        float f11 = this.f14997p;
        float f12 = f10 - f11;
        int i10 = this.f14985d;
        if (f12 <= i10 || this.f14998q) {
            return;
        }
        this.f14996o = f11 + i10;
        this.f14998q = true;
        this.f14969C.setAlpha(76);
    }

    public final void r() {
        this.f14973G = p(this.f14969C.getAlpha(), 255);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z10) {
        View view;
        if (!this.f14978L || (view = this.f14982a) == null || N.O(view)) {
            super.requestDisallowInterceptTouchEvent(z10);
        }
    }

    public final void s() {
        this.f14972F = p(this.f14969C.getAlpha(), 76);
    }

    public void setAnimationProgress(float f10) {
        this.f15003v.setScaleX(f10);
        this.f15003v.setScaleY(f10);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(int... iArr) {
        g();
        this.f14969C.f(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i10 = 0; i10 < iArr.length; i10++) {
            iArr2[i10] = androidx.core.content.a.c(context, iArr[i10]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i10) {
        this.f14986e = i10;
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        if (z10) {
            return;
        }
        m();
    }

    @Deprecated
    public void setLegacyRequestDisallowInterceptTouchEventEnabled(boolean z10) {
        this.f14978L = z10;
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z10) {
        this.f14989h.n(z10);
    }

    public void setOnChildScrollUpCallback(i iVar) {
    }

    public void setOnRefreshListener(j jVar) {
        this.f14983b = jVar;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i10) {
        setProgressBackgroundColorSchemeResource(i10);
    }

    public void setProgressBackgroundColorSchemeColor(int i10) {
        this.f15003v.setBackgroundColor(i10);
    }

    public void setProgressBackgroundColorSchemeResource(int i10) {
        setProgressBackgroundColorSchemeColor(androidx.core.content.a.c(getContext(), i10));
    }

    public void setRefreshing(boolean z10) {
        o(z10, false);
    }

    public void setSize(int i10) {
        if (i10 == 0 || i10 == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i10 == 0) {
                this.f14976J = (int) (displayMetrics.density * 56.0f);
            } else {
                this.f14976J = (int) (displayMetrics.density * 40.0f);
            }
            this.f15003v.setImageDrawable(null);
            this.f14969C.l(i10);
            this.f15003v.setImageDrawable(this.f14969C);
        }
    }

    public void setSlingshotDistance(int i10) {
        this.f14968B = i10;
    }

    public void setTargetOffsetTopAndBottom(int i10) {
        this.f15003v.bringToFront();
        N.T(this.f15003v, i10);
        this.f14995n = this.f15003v.getTop();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i10) {
        return this.f14989h.p(i10);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        this.f14989h.r();
    }

    public void t(Animation.AnimationListener animationListener) {
        c cVar = new c();
        this.f14971E = cVar;
        cVar.setDuration(150L);
        this.f15003v.b(animationListener);
        this.f15003v.clearAnimation();
        this.f15003v.startAnimation(this.f14971E);
    }

    public final void u(int i10, Animation.AnimationListener animationListener) {
        this.f15005x = i10;
        this.f15006y = this.f15003v.getScaleX();
        h hVar = new h();
        this.f14974H = hVar;
        hVar.setDuration(150L);
        if (animationListener != null) {
            this.f15003v.b(animationListener);
        }
        this.f15003v.clearAnimation();
        this.f15003v.startAnimation(this.f14974H);
    }

    public final void v(Animation.AnimationListener animationListener) {
        this.f15003v.setVisibility(0);
        this.f14969C.setAlpha(255);
        b bVar = new b();
        this.f14970D = bVar;
        bVar.setDuration(this.f14994m);
        if (animationListener != null) {
            this.f15003v.b(animationListener);
        }
        this.f15003v.clearAnimation();
        this.f15003v.startAnimation(this.f14970D);
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        final boolean mRefreshing;

        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcelable parcelable, boolean z10) {
            super(parcelable);
            this.mRefreshing = z10;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeByte(this.mRefreshing ? (byte) 1 : (byte) 0);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.mRefreshing = parcel.readByte() != 0;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr) {
        if (i11 > 0) {
            float f10 = this.f14987f;
            if (f10 > 0.0f) {
                float f11 = i11;
                if (f11 > f10) {
                    iArr[1] = (int) f10;
                    this.f14987f = 0.0f;
                } else {
                    this.f14987f = f10 - f11;
                    iArr[1] = i11;
                }
                j(this.f14987f);
            }
        }
        if (this.f14977K && i11 > 0 && this.f14987f == 0.0f && Math.abs(i11 - iArr[1]) > 0) {
            this.f15003v.setVisibility(8);
        }
        int[] iArr2 = this.f14990i;
        if (dispatchNestedPreScroll(i10 - iArr[0], i11 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i10) {
        this.f14988g.b(view, view2, i10);
        startNestedScroll(i10 & 2);
        this.f14987f = 0.0f;
        this.f14993l = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i10) {
        return (!isEnabled() || this.f15001t || this.f14984c || (i10 & 2) == 0) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        this.f14988g.d(view);
        this.f14993l = false;
        float f10 = this.f14987f;
        if (f10 > 0.0f) {
            h(f10);
            this.f14987f = 0.0f;
        } else {
            post(new Runnable() { // from class: androidx.swiperefreshlayout.widget.c
                @Override // java.lang.Runnable
                public final void run() {
                    this.f15058a.m();
                }
            });
        }
        stopNestedScroll();
    }

    @Override // androidx.core.view.InterfaceC1335x
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13, int i14) {
        onNestedScroll(view, i10, i11, i12, i13, i14, this.f14992k);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13) {
        onNestedScroll(view, i10, i11, i12, i13, 0, this.f14992k);
    }
}

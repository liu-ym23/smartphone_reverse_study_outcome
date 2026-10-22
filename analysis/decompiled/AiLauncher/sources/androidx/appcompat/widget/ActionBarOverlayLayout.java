package androidx.appcompat.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.view.menu.i;
import androidx.core.view.C1337z;
import androidx.core.view.InterfaceC1335x;
import androidx.core.view.InterfaceC1336y;
import androidx.core.view.a0;

@SuppressLint({"UnknownNullness"})
/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements InterfaceC1312z, InterfaceC1335x, InterfaceC1336y {

    /* renamed from: G, reason: collision with root package name */
    public static final int[] f8740G = {R$attr.actionBarSize, R.attr.windowContentOverlay};

    /* renamed from: H, reason: collision with root package name */
    public static final androidx.core.view.a0 f8741H = new a0.a().d(t0.e.b(0, 1, 0, 1)).a();

    /* renamed from: I, reason: collision with root package name */
    public static final Rect f8742I = new Rect();

    /* renamed from: A, reason: collision with root package name */
    public ViewPropertyAnimator f8743A;

    /* renamed from: B, reason: collision with root package name */
    public final AnimatorListenerAdapter f8744B;

    /* renamed from: C, reason: collision with root package name */
    public final Runnable f8745C;

    /* renamed from: D, reason: collision with root package name */
    public final Runnable f8746D;

    /* renamed from: E, reason: collision with root package name */
    public final C1337z f8747E;

    /* renamed from: F, reason: collision with root package name */
    public final f f8748F;

    /* renamed from: a, reason: collision with root package name */
    public int f8749a;

    /* renamed from: b, reason: collision with root package name */
    public int f8750b;

    /* renamed from: c, reason: collision with root package name */
    public ContentFrameLayout f8751c;

    /* renamed from: d, reason: collision with root package name */
    public ActionBarContainer f8752d;

    /* renamed from: e, reason: collision with root package name */
    public A f8753e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f8754f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f8755g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f8756h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f8757i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f8758j;

    /* renamed from: k, reason: collision with root package name */
    public int f8759k;

    /* renamed from: l, reason: collision with root package name */
    public int f8760l;

    /* renamed from: m, reason: collision with root package name */
    public final Rect f8761m;

    /* renamed from: n, reason: collision with root package name */
    public final Rect f8762n;

    /* renamed from: o, reason: collision with root package name */
    public final Rect f8763o;

    /* renamed from: p, reason: collision with root package name */
    public final Rect f8764p;

    /* renamed from: q, reason: collision with root package name */
    public final Rect f8765q;

    /* renamed from: r, reason: collision with root package name */
    public final Rect f8766r;

    /* renamed from: s, reason: collision with root package name */
    public final Rect f8767s;

    /* renamed from: t, reason: collision with root package name */
    public final Rect f8768t;

    /* renamed from: u, reason: collision with root package name */
    public androidx.core.view.a0 f8769u;

    /* renamed from: v, reason: collision with root package name */
    public androidx.core.view.a0 f8770v;

    /* renamed from: w, reason: collision with root package name */
    public androidx.core.view.a0 f8771w;

    /* renamed from: x, reason: collision with root package name */
    public androidx.core.view.a0 f8772x;

    /* renamed from: y, reason: collision with root package name */
    public d f8773y;

    /* renamed from: z, reason: collision with root package name */
    public OverScroller f8774z;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f8743A = null;
            actionBarOverlayLayout.f8758j = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f8743A = null;
            actionBarOverlayLayout.f8758j = false;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.n();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f8743A = actionBarOverlayLayout.f8752d.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.f8744B);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.n();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f8743A = actionBarOverlayLayout.f8752d.animate().translationY(-ActionBarOverlayLayout.this.f8752d.getHeight()).setListener(ActionBarOverlayLayout.this.f8744B);
        }
    }

    public interface d {
        void a();

        void b();

        void c(boolean z10);

        void d();

        void e();

        void onWindowVisibilityChanged(int i10);
    }

    public static class e extends ViewGroup.MarginLayoutParams {
        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public e(int i10, int i11) {
            super(i10, i11);
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public static final class f extends View {
        public f(Context context) {
            super(context);
            setWillNotDraw(true);
        }

        @Override // android.view.View
        public int getWindowSystemUiVisibility() {
            return 0;
        }
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8750b = 0;
        this.f8761m = new Rect();
        this.f8762n = new Rect();
        this.f8763o = new Rect();
        this.f8764p = new Rect();
        this.f8765q = new Rect();
        this.f8766r = new Rect();
        this.f8767s = new Rect();
        this.f8768t = new Rect();
        androidx.core.view.a0 a0Var = androidx.core.view.a0.f13159b;
        this.f8769u = a0Var;
        this.f8770v = a0Var;
        this.f8771w = a0Var;
        this.f8772x = a0Var;
        this.f8744B = new a();
        this.f8745C = new b();
        this.f8746D = new c();
        o(context);
        this.f8747E = new C1337z(this);
        f fVar = new f(context);
        this.f8748F = fVar;
        addView(fVar);
    }

    @Override // androidx.appcompat.widget.InterfaceC1312z
    public boolean a() {
        u();
        return this.f8753e.a();
    }

    @Override // androidx.appcompat.widget.InterfaceC1312z
    public boolean b() {
        u();
        return this.f8753e.b();
    }

    @Override // androidx.appcompat.widget.InterfaceC1312z
    public boolean c() {
        u();
        return this.f8753e.c();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    @Override // androidx.appcompat.widget.InterfaceC1312z
    public boolean d() {
        u();
        return this.f8753e.d();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f8754f != null) {
            int bottom = this.f8752d.getVisibility() == 0 ? (int) (this.f8752d.getBottom() + this.f8752d.getTranslationY() + 0.5f) : 0;
            this.f8754f.setBounds(0, bottom, getWidth(), this.f8754f.getIntrinsicHeight() + bottom);
            this.f8754f.draw(canvas);
        }
    }

    @Override // androidx.appcompat.widget.InterfaceC1312z
    public void e() {
        u();
        this.f8753e.e();
    }

    @Override // androidx.appcompat.widget.InterfaceC1312z
    public boolean f() {
        u();
        return this.f8753e.f();
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    @Override // androidx.appcompat.widget.InterfaceC1312z
    public void g(int i10) {
        u();
        if (i10 == 2) {
            this.f8753e.n();
        } else if (i10 == 5) {
            this.f8753e.t();
        } else {
            if (i10 != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f8752d;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f8747E.a();
    }

    public CharSequence getTitle() {
        u();
        return this.f8753e.getTitle();
    }

    public final void h() {
        n();
        this.f8746D.run();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean i(android.view.View r2, android.graphics.Rect r3, boolean r4, boolean r5, boolean r6, boolean r7) {
        /*
            r1 = this;
            android.view.ViewGroup$LayoutParams r1 = r2.getLayoutParams()
            androidx.appcompat.widget.ActionBarOverlayLayout$e r1 = (androidx.appcompat.widget.ActionBarOverlayLayout.e) r1
            r2 = 1
            if (r4 == 0) goto L13
            int r4 = r1.leftMargin
            int r0 = r3.left
            if (r4 == r0) goto L13
            r1.leftMargin = r0
            r4 = r2
            goto L14
        L13:
            r4 = 0
        L14:
            if (r5 == 0) goto L1f
            int r5 = r1.topMargin
            int r0 = r3.top
            if (r5 == r0) goto L1f
            r1.topMargin = r0
            r4 = r2
        L1f:
            if (r7 == 0) goto L2a
            int r5 = r1.rightMargin
            int r7 = r3.right
            if (r5 == r7) goto L2a
            r1.rightMargin = r7
            r4 = r2
        L2a:
            if (r6 == 0) goto L35
            int r5 = r1.bottomMargin
            int r3 = r3.bottom
            if (r5 == r3) goto L35
            r1.bottomMargin = r3
            return r2
        L35:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarOverlayLayout.i(android.view.View, android.graphics.Rect, boolean, boolean, boolean, boolean):boolean");
    }

    public final boolean j() {
        androidx.core.view.N.e(this.f8748F, f8741H, this.f8764p);
        return !this.f8764p.equals(f8742I);
    }

    @Override // android.view.ViewGroup
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public e generateDefaultLayoutParams() {
        return new e(-1, -1);
    }

    @Override // android.view.ViewGroup
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final A m(View view) {
        if (view instanceof A) {
            return (A) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    public void n() {
        removeCallbacks(this.f8745C);
        removeCallbacks(this.f8746D);
        ViewPropertyAnimator viewPropertyAnimator = this.f8743A;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public final void o(Context context) {
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f8740G);
        this.f8749a = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        this.f8754f = drawable;
        setWillNotDraw(drawable == null);
        typedArrayObtainStyledAttributes.recycle();
        this.f8774z = new OverScroller(context);
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        u();
        androidx.core.view.a0 a0VarZ = androidx.core.view.a0.z(windowInsets, this);
        boolean zI = i(this.f8752d, new Rect(a0VarZ.k(), a0VarZ.m(), a0VarZ.l(), a0VarZ.j()), true, true, false, true);
        androidx.core.view.N.e(this, a0VarZ, this.f8761m);
        Rect rect = this.f8761m;
        androidx.core.view.a0 a0VarO = a0VarZ.o(rect.left, rect.top, rect.right, rect.bottom);
        this.f8769u = a0VarO;
        boolean z10 = true;
        if (!this.f8770v.equals(a0VarO)) {
            this.f8770v = this.f8769u;
            zI = true;
        }
        if (this.f8762n.equals(this.f8761m)) {
            z10 = zI;
        } else {
            this.f8762n.set(this.f8761m);
        }
        if (z10) {
            requestLayout();
        }
        return a0VarZ.a().c().b().x();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        o(getContext());
        androidx.core.view.N.e0(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        n();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i15 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin + paddingLeft;
                int i16 = ((ViewGroup.MarginLayoutParams) eVar).topMargin + paddingTop;
                childAt.layout(i15, i16, measuredWidth + i15, measuredHeight + i16);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int measuredHeight;
        u();
        measureChildWithMargins(this.f8752d, i10, 0, i11, 0);
        e eVar = (e) this.f8752d.getLayoutParams();
        int iMax = Math.max(0, this.f8752d.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin + ((ViewGroup.MarginLayoutParams) eVar).rightMargin);
        int iMax2 = Math.max(0, this.f8752d.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar).topMargin + ((ViewGroup.MarginLayoutParams) eVar).bottomMargin);
        int iCombineMeasuredStates = View.combineMeasuredStates(0, this.f8752d.getMeasuredState());
        boolean z10 = (androidx.core.view.N.H(this) & 256) != 0;
        if (z10) {
            measuredHeight = this.f8749a;
            if (this.f8756h && this.f8752d.getTabContainer() != null) {
                measuredHeight += this.f8749a;
            }
        } else {
            measuredHeight = this.f8752d.getVisibility() != 8 ? this.f8752d.getMeasuredHeight() : 0;
        }
        this.f8763o.set(this.f8761m);
        this.f8771w = this.f8769u;
        if (this.f8755g || z10 || !j()) {
            this.f8771w = new a0.a(this.f8771w).d(t0.e.b(this.f8771w.k(), this.f8771w.m() + measuredHeight, this.f8771w.l(), this.f8771w.j())).a();
        } else {
            Rect rect = this.f8763o;
            rect.top += measuredHeight;
            rect.bottom = rect.bottom;
            this.f8771w = this.f8771w.o(0, measuredHeight, 0, 0);
        }
        i(this.f8751c, this.f8763o, true, true, true, true);
        if (!this.f8772x.equals(this.f8771w)) {
            androidx.core.view.a0 a0Var = this.f8771w;
            this.f8772x = a0Var;
            androidx.core.view.N.f(this.f8751c, a0Var);
        }
        measureChildWithMargins(this.f8751c, i10, 0, i11, 0);
        e eVar2 = (e) this.f8751c.getLayoutParams();
        int iMax3 = Math.max(iMax, this.f8751c.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar2).leftMargin + ((ViewGroup.MarginLayoutParams) eVar2).rightMargin);
        int iMax4 = Math.max(iMax2, this.f8751c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar2).topMargin + ((ViewGroup.MarginLayoutParams) eVar2).bottomMargin);
        int iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f8751c.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i10, iCombineMeasuredStates2), View.resolveSizeAndState(Math.max(iMax4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i11, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f10, float f11, boolean z10) {
        if (!this.f8757i || !z10) {
            return false;
        }
        if (w(f11)) {
            h();
        } else {
            v();
        }
        this.f8758j = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f10, float f11) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr) {
    }

    @Override // androidx.core.view.InterfaceC1336y
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        onNestedScroll(view, i10, i11, i12, i13, i14);
    }

    @Override // androidx.core.view.InterfaceC1335x
    public void onNestedScrollAccepted(View view, View view2, int i10, int i11) {
        if (i11 == 0) {
            onNestedScrollAccepted(view, view2, i10);
        }
    }

    @Override // androidx.core.view.InterfaceC1335x
    public boolean onStartNestedScroll(View view, View view2, int i10, int i11) {
        return i11 == 0 && onStartNestedScroll(view, view2, i10);
    }

    @Override // androidx.core.view.InterfaceC1335x
    public void onStopNestedScroll(View view, int i10) {
        if (i10 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // android.view.View
    @Deprecated
    public void onWindowSystemUiVisibilityChanged(int i10) {
        super.onWindowSystemUiVisibilityChanged(i10);
        u();
        int i11 = this.f8760l ^ i10;
        this.f8760l = i10;
        boolean z10 = (i10 & 4) == 0;
        boolean z11 = (i10 & 256) != 0;
        d dVar = this.f8773y;
        if (dVar != null) {
            dVar.c(!z11);
            if (z10 || !z11) {
                this.f8773y.a();
            } else {
                this.f8773y.d();
            }
        }
        if ((i11 & 256) == 0 || this.f8773y == null) {
            return;
        }
        androidx.core.view.N.e0(this);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        this.f8750b = i10;
        d dVar = this.f8773y;
        if (dVar != null) {
            dVar.onWindowVisibilityChanged(i10);
        }
    }

    public boolean p() {
        return this.f8755g;
    }

    @Override // androidx.appcompat.widget.InterfaceC1312z
    public void q(Menu menu, i.a aVar) {
        u();
        this.f8753e.q(menu, aVar);
    }

    @Override // androidx.appcompat.widget.InterfaceC1312z
    public void r() {
        u();
        this.f8753e.p();
    }

    public final void s() {
        n();
        postDelayed(this.f8746D, 600L);
    }

    public void setActionBarHideOffset(int i10) {
        n();
        this.f8752d.setTranslationY(-Math.max(0, Math.min(i10, this.f8752d.getHeight())));
    }

    public void setActionBarVisibilityCallback(d dVar) {
        this.f8773y = dVar;
        if (getWindowToken() != null) {
            this.f8773y.onWindowVisibilityChanged(this.f8750b);
            int i10 = this.f8760l;
            if (i10 != 0) {
                onWindowSystemUiVisibilityChanged(i10);
                androidx.core.view.N.e0(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z10) {
        this.f8756h = z10;
    }

    public void setHideOnContentScrollEnabled(boolean z10) {
        if (z10 != this.f8757i) {
            this.f8757i = z10;
            if (z10) {
                return;
            }
            n();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i10) {
        u();
        this.f8753e.setIcon(i10);
    }

    public void setLogo(int i10) {
        u();
        this.f8753e.r(i10);
    }

    public void setOverlayMode(boolean z10) {
        this.f8755g = z10;
    }

    public void setShowingForActionMode(boolean z10) {
    }

    public void setUiOptions(int i10) {
    }

    @Override // androidx.appcompat.widget.InterfaceC1312z
    public void setWindowCallback(Window.Callback callback) {
        u();
        this.f8753e.setWindowCallback(callback);
    }

    @Override // androidx.appcompat.widget.InterfaceC1312z
    public void setWindowTitle(CharSequence charSequence) {
        u();
        this.f8753e.setWindowTitle(charSequence);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public final void t() {
        n();
        postDelayed(this.f8745C, 600L);
    }

    public void u() {
        if (this.f8751c == null) {
            this.f8751c = (ContentFrameLayout) findViewById(R$id.action_bar_activity_content);
            this.f8752d = (ActionBarContainer) findViewById(R$id.action_bar_container);
            this.f8753e = m(findViewById(R$id.action_bar));
        }
    }

    public final void v() {
        n();
        this.f8745C.run();
    }

    public final boolean w(float f10) {
        this.f8774z.fling(0, 0, 0, (int) f10, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.f8774z.getFinalY() > this.f8752d.getHeight();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new e(layoutParams);
    }

    @Override // androidx.core.view.InterfaceC1335x
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr, int i12) {
        if (i12 == 0) {
            onNestedPreScroll(view, i10, i11, iArr);
        }
    }

    @Override // androidx.core.view.InterfaceC1335x
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13, int i14) {
        if (i14 == 0) {
            onNestedScroll(view, i10, i11, i12, i13);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i10) {
        this.f8747E.b(view, view2, i10);
        this.f8759k = getActionBarHideOffset();
        n();
        d dVar = this.f8773y;
        if (dVar != null) {
            dVar.e();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i10) {
        if ((i10 & 2) == 0 || this.f8752d.getVisibility() != 0) {
            return false;
        }
        return this.f8757i;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        if (this.f8757i && !this.f8758j) {
            if (this.f8759k <= this.f8752d.getHeight()) {
                t();
            } else {
                s();
            }
        }
        d dVar = this.f8773y;
        if (dVar != null) {
            dVar.b();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13) {
        int i14 = this.f8759k + i11;
        this.f8759k = i14;
        setActionBarHideOffset(i14);
    }

    public void setIcon(Drawable drawable) {
        u();
        this.f8753e.setIcon(drawable);
    }
}

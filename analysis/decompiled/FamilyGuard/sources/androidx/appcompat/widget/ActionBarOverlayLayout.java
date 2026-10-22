package androidx.appcompat.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
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
import androidx.appcompat.view.menu.j;
import androidx.core.view.C0478x;
import androidx.core.view.InterfaceC0476v;
import androidx.core.view.InterfaceC0477w;
import androidx.core.view.Y;
import g.C0728a;

/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements G, InterfaceC0476v, InterfaceC0477w {

    /* renamed from: G, reason: collision with root package name */
    static final int[] f8030G = {C0728a.f16825b, R.attr.windowContentOverlay};

    /* renamed from: H, reason: collision with root package name */
    private static final androidx.core.view.Y f8031H = new Y.b().c(androidx.core.graphics.b.b(0, 1, 0, 1)).a();

    /* renamed from: I, reason: collision with root package name */
    private static final Rect f8032I = new Rect();

    /* renamed from: A, reason: collision with root package name */
    ViewPropertyAnimator f8033A;

    /* renamed from: B, reason: collision with root package name */
    final AnimatorListenerAdapter f8034B;

    /* renamed from: C, reason: collision with root package name */
    private final Runnable f8035C;

    /* renamed from: D, reason: collision with root package name */
    private final Runnable f8036D;

    /* renamed from: E, reason: collision with root package name */
    private final C0478x f8037E;

    /* renamed from: F, reason: collision with root package name */
    private final f f8038F;

    /* renamed from: a, reason: collision with root package name */
    private int f8039a;

    /* renamed from: b, reason: collision with root package name */
    private int f8040b;

    /* renamed from: c, reason: collision with root package name */
    private ContentFrameLayout f8041c;

    /* renamed from: d, reason: collision with root package name */
    ActionBarContainer f8042d;

    /* renamed from: e, reason: collision with root package name */
    private H f8043e;

    /* renamed from: f, reason: collision with root package name */
    private Drawable f8044f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f8045g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f8046h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f8047i;

    /* renamed from: j, reason: collision with root package name */
    boolean f8048j;

    /* renamed from: k, reason: collision with root package name */
    private int f8049k;

    /* renamed from: l, reason: collision with root package name */
    private int f8050l;

    /* renamed from: m, reason: collision with root package name */
    private final Rect f8051m;

    /* renamed from: n, reason: collision with root package name */
    private final Rect f8052n;

    /* renamed from: o, reason: collision with root package name */
    private final Rect f8053o;

    /* renamed from: p, reason: collision with root package name */
    private final Rect f8054p;

    /* renamed from: q, reason: collision with root package name */
    private final Rect f8055q;

    /* renamed from: r, reason: collision with root package name */
    private final Rect f8056r;

    /* renamed from: s, reason: collision with root package name */
    private final Rect f8057s;

    /* renamed from: t, reason: collision with root package name */
    private final Rect f8058t;

    /* renamed from: u, reason: collision with root package name */
    private androidx.core.view.Y f8059u;

    /* renamed from: v, reason: collision with root package name */
    private androidx.core.view.Y f8060v;

    /* renamed from: w, reason: collision with root package name */
    private androidx.core.view.Y f8061w;

    /* renamed from: x, reason: collision with root package name */
    private androidx.core.view.Y f8062x;

    /* renamed from: y, reason: collision with root package name */
    private d f8063y;

    /* renamed from: z, reason: collision with root package name */
    private OverScroller f8064z;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f8033A = null;
            actionBarOverlayLayout.f8048j = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f8033A = null;
            actionBarOverlayLayout.f8048j = false;
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.v();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f8033A = actionBarOverlayLayout.f8042d.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.f8034B);
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.v();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f8033A = actionBarOverlayLayout.f8042d.animate().translationY(-ActionBarOverlayLayout.this.f8042d.getHeight()).setListener(ActionBarOverlayLayout.this.f8034B);
        }
    }

    public interface d {
        void a();

        void b();

        void c(boolean z5);

        void d();

        void e();

        void onWindowVisibilityChanged(int i5);
    }

    public static class e extends ViewGroup.MarginLayoutParams {
        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public e(int i5, int i6) {
            super(i5, i6);
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    private static final class f extends View {
        f(Context context) {
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
        this.f8040b = 0;
        this.f8051m = new Rect();
        this.f8052n = new Rect();
        this.f8053o = new Rect();
        this.f8054p = new Rect();
        this.f8055q = new Rect();
        this.f8056r = new Rect();
        this.f8057s = new Rect();
        this.f8058t = new Rect();
        androidx.core.view.Y y5 = androidx.core.view.Y.f9771b;
        this.f8059u = y5;
        this.f8060v = y5;
        this.f8061w = y5;
        this.f8062x = y5;
        this.f8034B = new a();
        this.f8035C = new b();
        this.f8036D = new c();
        w(context);
        this.f8037E = new C0478x(this);
        f fVar = new f(context);
        this.f8038F = fVar;
        addView(fVar);
    }

    private void B() {
        v();
        this.f8035C.run();
    }

    private boolean C(float f5) {
        this.f8064z.fling(0, 0, 0, (int) f5, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.f8064z.getFinalY() > this.f8042d.getHeight();
    }

    private void p() {
        v();
        this.f8036D.run();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean q(android.view.View r2, android.graphics.Rect r3, boolean r4, boolean r5, boolean r6, boolean r7) {
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarOverlayLayout.q(android.view.View, android.graphics.Rect, boolean, boolean, boolean, boolean):boolean");
    }

    private boolean r() {
        androidx.core.view.H.f(this.f8038F, f8031H, this.f8054p);
        return !this.f8054p.equals(f8032I);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private H u(View view) {
        if (view instanceof H) {
            return (H) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    private void w(Context context) {
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f8030G);
        this.f8039a = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        this.f8044f = drawable;
        setWillNotDraw(drawable == null);
        typedArrayObtainStyledAttributes.recycle();
        this.f8064z = new OverScroller(context);
    }

    private void y() {
        v();
        postDelayed(this.f8036D, 600L);
    }

    private void z() {
        v();
        postDelayed(this.f8035C, 600L);
    }

    void A() {
        if (this.f8041c == null) {
            this.f8041c = (ContentFrameLayout) findViewById(g.f.f16920b);
            this.f8042d = (ActionBarContainer) findViewById(g.f.f16921c);
            this.f8043e = u(findViewById(g.f.f16919a));
        }
    }

    @Override // androidx.appcompat.widget.G
    public boolean a() {
        A();
        return this.f8043e.a();
    }

    @Override // androidx.appcompat.widget.G
    public void b() {
        A();
        this.f8043e.b();
    }

    @Override // androidx.appcompat.widget.G
    public boolean c() {
        A();
        return this.f8043e.c();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    @Override // androidx.appcompat.widget.G
    public boolean d() {
        A();
        return this.f8043e.d();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f8044f != null) {
            int bottom = this.f8042d.getVisibility() == 0 ? (int) (this.f8042d.getBottom() + this.f8042d.getTranslationY() + 0.5f) : 0;
            this.f8044f.setBounds(0, bottom, getWidth(), this.f8044f.getIntrinsicHeight() + bottom);
            this.f8044f.draw(canvas);
        }
    }

    @Override // androidx.appcompat.widget.G
    public boolean e() {
        A();
        return this.f8043e.e();
    }

    @Override // androidx.appcompat.widget.G
    public boolean f() {
        A();
        return this.f8043e.f();
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    @Override // androidx.appcompat.widget.G
    public void g(Menu menu, j.a aVar) {
        A();
        this.f8043e.g(menu, aVar);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f8042d;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f8037E.a();
    }

    public CharSequence getTitle() {
        A();
        return this.f8043e.getTitle();
    }

    @Override // androidx.appcompat.widget.G
    public void h(int i5) {
        A();
        if (i5 == 2) {
            this.f8043e.q();
        } else if (i5 == 5) {
            this.f8043e.s();
        } else {
            if (i5 != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    @Override // androidx.appcompat.widget.G
    public void i() {
        A();
        this.f8043e.h();
    }

    @Override // androidx.core.view.InterfaceC0477w
    public void j(View view, int i5, int i6, int i7, int i8, int i9, int[] iArr) {
        k(view, i5, i6, i7, i8, i9);
    }

    @Override // androidx.core.view.InterfaceC0476v
    public void k(View view, int i5, int i6, int i7, int i8, int i9) {
        if (i9 == 0) {
            onNestedScroll(view, i5, i6, i7, i8);
        }
    }

    @Override // androidx.core.view.InterfaceC0476v
    public boolean l(View view, View view2, int i5, int i6) {
        return i6 == 0 && onStartNestedScroll(view, view2, i5);
    }

    @Override // androidx.core.view.InterfaceC0476v
    public void m(View view, View view2, int i5, int i6) {
        if (i6 == 0) {
            onNestedScrollAccepted(view, view2, i5);
        }
    }

    @Override // androidx.core.view.InterfaceC0476v
    public void n(View view, int i5) {
        if (i5 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // androidx.core.view.InterfaceC0476v
    public void o(View view, int i5, int i6, int[] iArr, int i7) {
        if (i7 == 0) {
            onNestedPreScroll(view, i5, i6, iArr);
        }
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        A();
        androidx.core.view.Y yU = androidx.core.view.Y.u(windowInsets, this);
        boolean zQ = q(this.f8042d, new Rect(yU.i(), yU.k(), yU.j(), yU.h()), true, true, false, true);
        androidx.core.view.H.f(this, yU, this.f8051m);
        Rect rect = this.f8051m;
        androidx.core.view.Y yL = yU.l(rect.left, rect.top, rect.right, rect.bottom);
        this.f8059u = yL;
        boolean z5 = true;
        if (!this.f8060v.equals(yL)) {
            this.f8060v = this.f8059u;
            zQ = true;
        }
        if (this.f8052n.equals(this.f8051m)) {
            z5 = zQ;
        } else {
            this.f8052n.set(this.f8051m);
        }
        if (z5) {
            requestLayout();
        }
        return yU.a().c().b().s();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        w(getContext());
        androidx.core.view.H.g0(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        v();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i10 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin + paddingLeft;
                int i11 = ((ViewGroup.MarginLayoutParams) eVar).topMargin + paddingTop;
                childAt.layout(i10, i11, measuredWidth + i10, measuredHeight + i11);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i5, int i6) {
        int measuredHeight;
        A();
        measureChildWithMargins(this.f8042d, i5, 0, i6, 0);
        e eVar = (e) this.f8042d.getLayoutParams();
        int iMax = Math.max(0, this.f8042d.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin + ((ViewGroup.MarginLayoutParams) eVar).rightMargin);
        int iMax2 = Math.max(0, this.f8042d.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar).topMargin + ((ViewGroup.MarginLayoutParams) eVar).bottomMargin);
        int iCombineMeasuredStates = View.combineMeasuredStates(0, this.f8042d.getMeasuredState());
        boolean z5 = (androidx.core.view.H.K(this) & 256) != 0;
        if (z5) {
            measuredHeight = this.f8039a;
            if (this.f8046h && this.f8042d.getTabContainer() != null) {
                measuredHeight += this.f8039a;
            }
        } else {
            measuredHeight = this.f8042d.getVisibility() != 8 ? this.f8042d.getMeasuredHeight() : 0;
        }
        this.f8053o.set(this.f8051m);
        this.f8061w = this.f8059u;
        if (this.f8045g || z5 || !r()) {
            this.f8061w = new Y.b(this.f8061w).c(androidx.core.graphics.b.b(this.f8061w.i(), this.f8061w.k() + measuredHeight, this.f8061w.j(), this.f8061w.h())).a();
        } else {
            Rect rect = this.f8053o;
            rect.top += measuredHeight;
            rect.bottom = rect.bottom;
            this.f8061w = this.f8061w.l(0, measuredHeight, 0, 0);
        }
        q(this.f8041c, this.f8053o, true, true, true, true);
        if (!this.f8062x.equals(this.f8061w)) {
            androidx.core.view.Y y5 = this.f8061w;
            this.f8062x = y5;
            androidx.core.view.H.g(this.f8041c, y5);
        }
        measureChildWithMargins(this.f8041c, i5, 0, i6, 0);
        e eVar2 = (e) this.f8041c.getLayoutParams();
        int iMax3 = Math.max(iMax, this.f8041c.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar2).leftMargin + ((ViewGroup.MarginLayoutParams) eVar2).rightMargin);
        int iMax4 = Math.max(iMax2, this.f8041c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar2).topMargin + ((ViewGroup.MarginLayoutParams) eVar2).bottomMargin);
        int iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f8041c.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i5, iCombineMeasuredStates2), View.resolveSizeAndState(Math.max(iMax4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i6, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f5, float f6, boolean z5) {
        if (!this.f8047i || !z5) {
            return false;
        }
        if (C(f6)) {
            p();
        } else {
            B();
        }
        this.f8048j = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f5, float f6) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i5, int i6, int[] iArr) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i5, int i6, int i7, int i8) {
        int i9 = this.f8049k + i6;
        this.f8049k = i9;
        setActionBarHideOffset(i9);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i5) {
        this.f8037E.b(view, view2, i5);
        this.f8049k = getActionBarHideOffset();
        v();
        d dVar = this.f8063y;
        if (dVar != null) {
            dVar.e();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i5) {
        if ((i5 & 2) == 0 || this.f8042d.getVisibility() != 0) {
            return false;
        }
        return this.f8047i;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        if (this.f8047i && !this.f8048j) {
            if (this.f8049k <= this.f8042d.getHeight()) {
                z();
            } else {
                y();
            }
        }
        d dVar = this.f8063y;
        if (dVar != null) {
            dVar.b();
        }
    }

    @Override // android.view.View
    @Deprecated
    public void onWindowSystemUiVisibilityChanged(int i5) {
        super.onWindowSystemUiVisibilityChanged(i5);
        A();
        int i6 = this.f8050l ^ i5;
        this.f8050l = i5;
        boolean z5 = (i5 & 4) == 0;
        boolean z6 = (i5 & 256) != 0;
        d dVar = this.f8063y;
        if (dVar != null) {
            dVar.c(!z6);
            if (z5 || !z6) {
                this.f8063y.a();
            } else {
                this.f8063y.d();
            }
        }
        if ((i6 & 256) == 0 || this.f8063y == null) {
            return;
        }
        androidx.core.view.H.g0(this);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i5) {
        super.onWindowVisibilityChanged(i5);
        this.f8040b = i5;
        d dVar = this.f8063y;
        if (dVar != null) {
            dVar.onWindowVisibilityChanged(i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public e generateDefaultLayoutParams() {
        return new e(-1, -1);
    }

    public void setActionBarHideOffset(int i5) {
        v();
        this.f8042d.setTranslationY(-Math.max(0, Math.min(i5, this.f8042d.getHeight())));
    }

    public void setActionBarVisibilityCallback(d dVar) {
        this.f8063y = dVar;
        if (getWindowToken() != null) {
            this.f8063y.onWindowVisibilityChanged(this.f8040b);
            int i5 = this.f8050l;
            if (i5 != 0) {
                onWindowSystemUiVisibilityChanged(i5);
                androidx.core.view.H.g0(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z5) {
        this.f8046h = z5;
    }

    public void setHideOnContentScrollEnabled(boolean z5) {
        if (z5 != this.f8047i) {
            this.f8047i = z5;
            if (z5) {
                return;
            }
            v();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i5) {
        A();
        this.f8043e.setIcon(i5);
    }

    public void setLogo(int i5) {
        A();
        this.f8043e.k(i5);
    }

    public void setOverlayMode(boolean z5) {
        this.f8045g = z5;
    }

    public void setShowingForActionMode(boolean z5) {
    }

    public void setUiOptions(int i5) {
    }

    @Override // androidx.appcompat.widget.G
    public void setWindowCallback(Window.Callback callback) {
        A();
        this.f8043e.setWindowCallback(callback);
    }

    @Override // androidx.appcompat.widget.G
    public void setWindowTitle(CharSequence charSequence) {
        A();
        this.f8043e.setWindowTitle(charSequence);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    void v() {
        removeCallbacks(this.f8035C);
        removeCallbacks(this.f8036D);
        ViewPropertyAnimator viewPropertyAnimator = this.f8033A;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public boolean x() {
        return this.f8045g;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new e(layoutParams);
    }

    public void setIcon(Drawable drawable) {
        A();
        this.f8043e.setIcon(drawable);
    }
}

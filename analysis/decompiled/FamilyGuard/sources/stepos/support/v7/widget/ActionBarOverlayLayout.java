package stepos.support.v7.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Insets;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.core.view.C0478x;
import androidx.core.view.H;
import androidx.core.view.S;
import androidx.core.view.T;
import androidx.core.view.U;
import g.C0728a;
import stepos.support.v7.view.menu.h;

/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements l {

    /* renamed from: W, reason: collision with root package name */
    static final int[] f21484W = {C0728a.f16825b, R.attr.windowContentOverlay, X4.a.f5824B, X4.a.f5847w, X4.a.f5829e, X4.a.f5830f};

    /* renamed from: A, reason: collision with root package name */
    private S f21485A;

    /* renamed from: B, reason: collision with root package name */
    private boolean f21486B;

    /* renamed from: C, reason: collision with root package name */
    private boolean f21487C;

    /* renamed from: D, reason: collision with root package name */
    private int f21488D;

    /* renamed from: E, reason: collision with root package name */
    private boolean f21489E;

    /* renamed from: F, reason: collision with root package name */
    private int f21490F;

    /* renamed from: G, reason: collision with root package name */
    private boolean f21491G;

    /* renamed from: H, reason: collision with root package name */
    private boolean f21492H;

    /* renamed from: I, reason: collision with root package name */
    private final T f21493I;

    /* renamed from: J, reason: collision with root package name */
    private final T f21494J;

    /* renamed from: K, reason: collision with root package name */
    private final Runnable f21495K;

    /* renamed from: L, reason: collision with root package name */
    private final Runnable f21496L;

    /* renamed from: M, reason: collision with root package name */
    private final C0478x f21497M;

    /* renamed from: Q, reason: collision with root package name */
    private Drawable f21498Q;

    /* renamed from: R, reason: collision with root package name */
    private boolean f21499R;

    /* renamed from: S, reason: collision with root package name */
    private ObjectAnimator f21500S;

    /* renamed from: T, reason: collision with root package name */
    private ObjectAnimator f21501T;

    /* renamed from: U, reason: collision with root package name */
    private Interpolator f21502U;

    /* renamed from: V, reason: collision with root package name */
    private Interpolator f21503V;

    /* renamed from: a, reason: collision with root package name */
    private int f21504a;

    /* renamed from: b, reason: collision with root package name */
    private int f21505b;

    /* renamed from: c, reason: collision with root package name */
    private FitsWindowsContentLayout f21506c;

    /* renamed from: d, reason: collision with root package name */
    private ActionBarContainer f21507d;

    /* renamed from: e, reason: collision with root package name */
    private ActionBarContainer f21508e;

    /* renamed from: f, reason: collision with root package name */
    private View f21509f;

    /* renamed from: g, reason: collision with root package name */
    private ActionBarDropDownView f21510g;

    /* renamed from: h, reason: collision with root package name */
    private m f21511h;

    /* renamed from: i, reason: collision with root package name */
    private Drawable f21512i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f21513j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f21514k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f21515l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f21516m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f21517n;

    /* renamed from: o, reason: collision with root package name */
    private int f21518o;

    /* renamed from: p, reason: collision with root package name */
    private int f21519p;

    /* renamed from: q, reason: collision with root package name */
    private final Rect f21520q;

    /* renamed from: r, reason: collision with root package name */
    private final Rect f21521r;

    /* renamed from: s, reason: collision with root package name */
    private final Rect f21522s;

    /* renamed from: t, reason: collision with root package name */
    private final Rect f21523t;

    /* renamed from: u, reason: collision with root package name */
    private final Rect f21524u;

    /* renamed from: v, reason: collision with root package name */
    private final Rect f21525v;

    /* renamed from: w, reason: collision with root package name */
    private f f21526w;

    /* renamed from: x, reason: collision with root package name */
    private final int f21527x;

    /* renamed from: y, reason: collision with root package name */
    private androidx.core.widget.h f21528y;

    /* renamed from: z, reason: collision with root package name */
    private S f21529z;

    class a extends U {
        a() {
        }

        @Override // androidx.core.view.U, androidx.core.view.T
        public void c(View view) {
            ActionBarOverlayLayout.this.f21529z = null;
            ActionBarOverlayLayout.this.f21517n = false;
        }

        @Override // androidx.core.view.U, androidx.core.view.T
        public void d(View view) {
            ActionBarOverlayLayout.this.f21529z = null;
            ActionBarOverlayLayout.this.f21517n = false;
        }
    }

    class b extends U {
        b() {
        }

        @Override // androidx.core.view.U, androidx.core.view.T
        public void c(View view) {
            ActionBarOverlayLayout.this.f21485A = null;
            ActionBarOverlayLayout.this.f21517n = false;
        }

        @Override // androidx.core.view.U, androidx.core.view.T
        public void d(View view) {
            ActionBarOverlayLayout.this.f21485A = null;
            ActionBarOverlayLayout.this.f21517n = false;
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.A();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f21529z = H.d(actionBarOverlayLayout.f21508e).p(0.0f).j(ActionBarOverlayLayout.this.f21493I);
            if (ActionBarOverlayLayout.this.f21507d == null || ActionBarOverlayLayout.this.f21507d.getVisibility() == 8) {
                return;
            }
            ActionBarOverlayLayout actionBarOverlayLayout2 = ActionBarOverlayLayout.this;
            actionBarOverlayLayout2.f21485A = H.d(actionBarOverlayLayout2.f21507d).p(0.0f).j(ActionBarOverlayLayout.this.f21494J);
        }
    }

    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.A();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f21529z = H.d(actionBarOverlayLayout.f21508e).p(-ActionBarOverlayLayout.this.f21508e.getHeight()).j(ActionBarOverlayLayout.this.f21493I);
            if (ActionBarOverlayLayout.this.f21507d == null || ActionBarOverlayLayout.this.f21507d.getVisibility() == 8) {
                return;
            }
            ActionBarOverlayLayout actionBarOverlayLayout2 = ActionBarOverlayLayout.this;
            actionBarOverlayLayout2.f21485A = H.d(actionBarOverlayLayout2.f21507d).p(ActionBarOverlayLayout.this.f21507d.getHeight()).j(ActionBarOverlayLayout.this.f21494J);
        }
    }

    class e extends AnimatorListenerAdapter {
        e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            ActionBarOverlayLayout.this.f21509f.setVisibility(4);
        }
    }

    public interface f {
        void a();

        void b();

        void c(boolean z5);

        void d();

        void e();

        void onWindowVisibilityChanged(int i5);
    }

    public static class g extends ViewGroup.MarginLayoutParams {
        public g(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public g(int i5, int i6) {
            super(i5, i6);
        }

        public g(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21505b = 0;
        this.f21514k = true;
        this.f21520q = new Rect();
        this.f21521r = new Rect();
        this.f21522s = new Rect();
        this.f21523t = new Rect();
        this.f21524u = new Rect();
        this.f21525v = new Rect();
        this.f21527x = 600;
        this.f21488D = -1;
        this.f21492H = false;
        this.f21493I = new a();
        this.f21494J = new b();
        this.f21495K = new c();
        this.f21496L = new d();
        this.f21499R = false;
        B(context);
        this.f21497M = new C0478x(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        removeCallbacks(this.f21495K);
        removeCallbacks(this.f21496L);
        S s5 = this.f21529z;
        if (s5 != null) {
            s5.c();
        }
        S s6 = this.f21485A;
        if (s6 != null) {
            s6.c();
        }
    }

    private void B(Context context) {
        if (N1.a.c()) {
            f21484W[0] = X4.a.f5831g;
        }
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f21484W);
        this.f21504a = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        this.f21512i = drawable;
        setWillNotDraw(drawable == null);
        this.f21486B = typedArrayObtainStyledAttributes.getBoolean(2, false);
        this.f21487C = typedArrayObtainStyledAttributes.getBoolean(3, false);
        this.f21489E = typedArrayObtainStyledAttributes.getBoolean(4, this.f21489E);
        setOverlayMode(typedArrayObtainStyledAttributes.getBoolean(5, this.f21514k));
        typedArrayObtainStyledAttributes.recycle();
        this.f21513j = context.getApplicationInfo().targetSdkVersion < 19;
        this.f21528y = androidx.core.widget.h.a(context);
    }

    private void D() {
        A();
        postDelayed(this.f21496L, 600L);
    }

    private void E() {
        A();
        postDelayed(this.f21495K, 600L);
    }

    private void G() {
        A();
        this.f21495K.run();
    }

    private boolean H(float f5, float f6) {
        this.f21528y.c(0, 0, 0, (int) f6, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.f21528y.d() > this.f21508e.getHeight();
    }

    private void I() {
        if (this.f21503V == null) {
            this.f21503V = new PathInterpolator(0.3f, 0.0f, 0.67f, 1.0f);
        }
        if (this.f21501T == null) {
            ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this.f21498Q, "alpha", 127, 0);
            this.f21501T = objectAnimatorOfInt;
            objectAnimatorOfInt.setInterpolator(this.f21503V);
            this.f21501T.setDuration(230L);
            this.f21501T.addListener(new e());
        }
        this.f21501T.start();
    }

    private void J() {
        if (this.f21502U == null) {
            this.f21502U = new PathInterpolator(0.3f, 0.0f, 0.67f, 1.0f);
        }
        if (this.f21500S == null) {
            ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this.f21498Q, "alpha", 0, 255);
            this.f21500S = objectAnimatorOfInt;
            objectAnimatorOfInt.setInterpolator(this.f21502U);
            this.f21500S.setDuration(150L);
        }
        this.f21500S.start();
    }

    private void K() {
        ObjectAnimator objectAnimator = this.f21501T;
        if (objectAnimator == null || !objectAnimator.isRunning()) {
            return;
        }
        this.f21501T.cancel();
    }

    private void L() {
        ObjectAnimator objectAnimator = this.f21500S;
        if (objectAnimator == null || !objectAnimator.isRunning()) {
            return;
        }
        this.f21500S.cancel();
    }

    private void M() throws Resources.NotFoundException {
        int iX = H.x(this);
        int measuredWidth = this.f21509f.getMeasuredWidth();
        int measuredHeight = this.f21509f.getMeasuredHeight();
        int dimensionPixelSize = getResources().getDimensionPixelSize(X4.d.f5881R);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(X4.d.f5880Q);
        if (iX == 1) {
            int paddingLeft = getPaddingLeft() + dimensionPixelSize;
            int height = ((getHeight() - getPaddingBottom()) - dimensionPixelSize2) - measuredHeight;
            this.f21509f.layout(paddingLeft, height, measuredWidth + paddingLeft, measuredHeight + height);
        }
    }

    private void v() {
        A();
        this.f21496L.run();
    }

    private boolean w(Rect rect) {
        if (!this.f21489E) {
            rect.top = N1.i.e(getContext());
        }
        return C.g(this.f21508e, rect, true, true, true, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private m z(View view) {
        if (view instanceof m) {
            return (m) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    public boolean C() {
        return this.f21514k;
    }

    void F() {
        if (this.f21506c == null) {
            this.f21506c = (FitsWindowsContentLayout) findViewById(g.f.f16920b);
            this.f21508e = (ActionBarContainer) findViewById(X4.f.f5981b);
            this.f21511h = z(findViewById(X4.f.f5979a));
            this.f21507d = (ActionBarContainer) findViewById(X4.f.f5966N);
            this.f21509f = findViewById(X4.f.f5974V);
        }
    }

    @Override // stepos.support.v7.widget.l
    public boolean a() {
        F();
        return this.f21511h.a();
    }

    @Override // stepos.support.v7.widget.l
    public void b() {
        F();
        this.f21511h.b();
    }

    @Override // stepos.support.v7.widget.l
    public boolean c() {
        F();
        return this.f21511h.c();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof g;
    }

    @Override // stepos.support.v7.widget.l
    public boolean d() {
        F();
        return this.f21511h.d();
    }

    @Override // android.view.ViewGroup, android.view.View
    public WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        super.dispatchApplyWindowInsets(windowInsets);
        F();
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        Insets insets = windowInsets.getInsets(WindowInsets.Type.systemBars());
        rect.set(insets.left, insets.top, insets.right, insets.bottom);
        rect2.set(rect);
        int i5 = windowInsets.getInsets(WindowInsets.Type.ime()).bottom;
        if (i5 > insets.bottom) {
            rect.bottom = i5;
        }
        boolean zW = w(rect);
        this.f21523t.set(rect);
        this.f21520q.set(rect);
        ActionBarContainer actionBarContainer = this.f21507d;
        if (actionBarContainer != null) {
            zW |= C.g(actionBarContainer, rect2, true, false, true, this.f21487C);
            this.f21511h.z(this.f21507d);
        }
        if (!this.f21521r.equals(this.f21520q)) {
            this.f21521r.set(this.f21520q);
            zW = true;
        }
        if (zW) {
            this.f21525v.setEmpty();
            requestLayout();
        } else if (this.f21514k) {
            this.f21506c.dispatchFitSystemWindows(this.f21525v);
        }
        return windowInsets.consumeSystemWindowInsets();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f21512i == null || this.f21513j) {
            return;
        }
        int bottom = this.f21508e.getVisibility() == 0 ? (int) (this.f21508e.getBottom() + H.H(this.f21508e) + 0.5f) : 0;
        this.f21512i.setBounds(0, bottom, getWidth(), this.f21512i.getIntrinsicHeight() + bottom);
        this.f21512i.draw(canvas);
    }

    @Override // stepos.support.v7.widget.l
    public boolean e() {
        F();
        return this.f21511h.e();
    }

    @Override // stepos.support.v7.widget.l
    public boolean f() {
        F();
        return this.f21511h.f();
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f21508e;
        if (actionBarContainer != null) {
            return -((int) H.H(actionBarContainer));
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f21497M.a();
    }

    public CharSequence getTitle() {
        F();
        return this.f21511h.getTitle();
    }

    @Override // stepos.support.v7.widget.l
    public void h(int i5) {
        F();
        if (i5 == 2) {
            this.f21511h.q();
        } else if (i5 == 5) {
            this.f21511h.s();
        } else {
            if (i5 != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    @Override // stepos.support.v7.widget.l
    public void i() {
        F();
        this.f21511h.h();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        B(getContext());
        H.g0(this);
        setUiOptions(this.f21490F);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        A();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) throws Resources.NotFoundException {
        int measuredHeight;
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = (i7 - i5) - getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = (i8 - i6) - getPaddingBottom();
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                g gVar = (g) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight2 = childAt.getMeasuredHeight();
                int i10 = ((ViewGroup.MarginLayoutParams) gVar).leftMargin + paddingLeft;
                ActionBarContainer actionBarContainer = this.f21507d;
                if (childAt == actionBarContainer) {
                    measuredHeight = (paddingBottom - measuredHeight2) - ((ViewGroup.MarginLayoutParams) gVar).bottomMargin;
                } else if (childAt == this.f21509f) {
                    measuredHeight = ((paddingBottom - measuredHeight2) - ((ViewGroup.MarginLayoutParams) gVar).bottomMargin) - ((actionBarContainer == null || actionBarContainer.getVisibility() == 8) ? 0 : this.f21507d.getMeasuredHeight());
                    i10 = (paddingRight - measuredWidth) - ((ViewGroup.MarginLayoutParams) gVar).rightMargin;
                } else {
                    measuredHeight = paddingTop + ((ViewGroup.MarginLayoutParams) gVar).topMargin;
                }
                childAt.layout(i10, measuredHeight, measuredWidth + i10, measuredHeight2 + measuredHeight);
            }
        }
        M();
    }

    @Override // android.view.View
    protected void onMeasure(int i5, int i6) {
        int measuredHeight;
        ActionBarContainer actionBarContainer;
        int i7;
        F();
        View view = this.f21509f;
        if (view != null && view.getVisibility() != 8) {
            measureChildWithMargins(this.f21509f, i5, 0, i6, 0);
        }
        measureChildWithMargins(this.f21508e, i5, 0, i6, 0);
        g gVar = (g) this.f21508e.getLayoutParams();
        int measuredHeight2 = 0;
        int iMax = Math.max(0, this.f21508e.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) gVar).leftMargin + ((ViewGroup.MarginLayoutParams) gVar).rightMargin);
        int iMax2 = Math.max(0, this.f21508e.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) gVar).topMargin + ((ViewGroup.MarginLayoutParams) gVar).bottomMargin);
        int iH = C.h(0, H.y(this.f21508e));
        ActionBarContainer actionBarContainer2 = this.f21507d;
        if (actionBarContainer2 != null) {
            measureChildWithMargins(actionBarContainer2, i5, 0, i6, 0);
            g gVar2 = (g) this.f21507d.getLayoutParams();
            iMax = Math.max(iMax, this.f21507d.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) gVar2).leftMargin + ((ViewGroup.MarginLayoutParams) gVar2).rightMargin);
            iMax2 = Math.max(iMax2, this.f21507d.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) gVar2).topMargin + ((ViewGroup.MarginLayoutParams) gVar2).bottomMargin);
            iH = C.h(iH, H.y(this.f21507d));
        }
        View viewFindViewById = findViewById(X4.f.f6024w0);
        if (viewFindViewById != null) {
            measureChildWithMargins(viewFindViewById, i5, 0, i6, 0);
        }
        if (this.f21508e.getVisibility() != 8) {
            measuredHeight = this.f21508e.getMeasuredHeight();
            int i8 = this.f21523t.top;
            if (measuredHeight > i8) {
                measuredHeight -= i8;
            }
        } else {
            measuredHeight = 0;
        }
        if ((this.f21511h.v() || this.f21511h.y() || this.f21511h.H()) && (actionBarContainer = this.f21507d) != null && actionBarContainer.getVisibility() != 8 && (measuredHeight2 = this.f21507d.getMeasuredHeight()) > (i7 = this.f21523t.bottom)) {
            measuredHeight2 -= i7;
        }
        this.f21522s.set(this.f21520q);
        this.f21524u.set(this.f21523t);
        if (this.f21514k) {
            Rect rect = this.f21524u;
            rect.top += measuredHeight;
            rect.bottom += measuredHeight2;
            this.f21522s.setEmpty();
        } else {
            Rect rect2 = this.f21522s;
            rect2.top += measuredHeight;
            rect2.bottom += measuredHeight2;
            this.f21524u.setEmpty();
        }
        C.f(this.f21506c, this.f21522s, true, true, true, true);
        if (!this.f21525v.equals(this.f21524u)) {
            this.f21525v.set(this.f21524u);
            this.f21506c.dispatchFitSystemWindows(this.f21524u);
        }
        measureChildWithMargins(this.f21506c, i5, 0, i6, 0);
        g gVar3 = (g) this.f21506c.getLayoutParams();
        int iMax3 = Math.max(iMax, this.f21506c.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) gVar3).leftMargin + ((ViewGroup.MarginLayoutParams) gVar3).rightMargin);
        int iMax4 = Math.max(iMax2, this.f21506c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) gVar3).topMargin + ((ViewGroup.MarginLayoutParams) gVar3).bottomMargin);
        int iH2 = C.h(iH, H.y(this.f21506c));
        ActionBarDropDownView actionBarDropDownView = this.f21510g;
        if (actionBarDropDownView != null && actionBarDropDownView.getVisibility() != 8) {
            Rect rect3 = !this.f21514k ? this.f21522s : this.f21524u;
            int i9 = this.f21488D;
            if (i9 != -1) {
                rect3.top = i9;
            }
            C.g(this.f21510g, rect3, true, true, true, true);
            measureChildWithMargins(this.f21510g, i5, 0, i6, 0);
            iH2 = C.h(iH2, H.y(this.f21510g));
        }
        setMeasuredDimension(H.h0(Math.max(iMax3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i5, iH2), H.h0(Math.max(iMax4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i6, iH2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f5, float f6, boolean z5) {
        if (!this.f21516m || !z5) {
            return false;
        }
        if (H(f5, f6)) {
            v();
        } else {
            G();
        }
        this.f21517n = true;
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
        int i9 = this.f21518o + i6;
        this.f21518o = i9;
        setActionBarHideOffset(i9);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i5) {
        this.f21497M.b(view, view2, i5);
        this.f21518o = getActionBarHideOffset();
        A();
        f fVar = this.f21526w;
        if (fVar != null) {
            fVar.e();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i5) {
        if ((i5 & 2) == 0 || this.f21508e.getVisibility() != 0) {
            return false;
        }
        return this.f21516m;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        if (this.f21516m && !this.f21517n) {
            if (this.f21518o <= this.f21508e.getHeight()) {
                E();
            } else {
                D();
            }
        }
        f fVar = this.f21526w;
        if (fVar != null) {
            fVar.b();
        }
    }

    @Override // android.view.View
    public void onWindowSystemUiVisibilityChanged(int i5) {
        super.onWindowSystemUiVisibilityChanged(i5);
        F();
        int i6 = this.f21519p ^ i5;
        this.f21519p = i5;
        boolean z5 = (i5 & 4) == 0;
        boolean z6 = (i5 & 256) != 0;
        f fVar = this.f21526w;
        if (fVar != null) {
            fVar.c(!z6);
            if (z5 || !z6) {
                this.f21526w.a();
            } else {
                this.f21526w.d();
            }
        }
        if ((i6 & 256) == 0 || this.f21526w == null) {
            return;
        }
        H.g0(this);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i5) {
        super.onWindowVisibilityChanged(i5);
        this.f21505b = i5;
        f fVar = this.f21526w;
        if (fVar != null) {
            fVar.onWindowVisibilityChanged(i5);
        }
    }

    @Override // stepos.support.v7.widget.l
    public void r(Menu menu, h.a aVar) {
        F();
        this.f21511h.r(menu, aVar);
    }

    @Override // stepos.support.v7.widget.l
    public void s() {
        if (!this.f21492H || this.f21509f == null || this.f21499R) {
            return;
        }
        L();
        this.f21499R = true;
        this.f21509f.setVisibility(0);
        J();
        this.f21509f.setClickable(true);
    }

    public void setActionBarDropDownView(ActionBarDropDownView actionBarDropDownView) {
        this.f21510g = actionBarDropDownView;
    }

    public void setActionBarFitStatusBar(boolean z5) {
        this.f21489E = z5;
    }

    public void setActionBarHideOffset(int i5) {
        A();
        int iMax = Math.max(0, Math.min(i5, this.f21508e.getHeight()));
        H.F0(this.f21508e, -iMax);
        ActionBarContainer actionBarContainer = this.f21507d;
        if (actionBarContainer == null || actionBarContainer.getVisibility() == 8) {
            return;
        }
        H.F0(this.f21507d, (int) (this.f21507d.getHeight() * (iMax / r0)));
    }

    public void setActionBarVisibilityCallback(f fVar) {
        this.f21526w = fVar;
        if (getWindowToken() != null) {
            this.f21526w.onWindowVisibilityChanged(this.f21505b);
            int i5 = this.f21519p;
            if (i5 != 0) {
                onWindowSystemUiVisibilityChanged(i5);
                H.g0(this);
            }
        }
    }

    @Override // stepos.support.v7.widget.l
    public void setBackTopBackground(Drawable drawable) {
        if (this.f21492H) {
            if (drawable == null) {
                this.f21509f.setBackgroundResource(X4.e.f5939m);
            } else {
                this.f21498Q = drawable;
                this.f21509f.setBackground(drawable);
            }
        }
    }

    @Override // stepos.support.v7.widget.l
    public void setBackTopClickCallback(View.OnClickListener onClickListener) {
        this.f21509f.setOnClickListener(onClickListener);
    }

    @Override // stepos.support.v7.widget.l
    public void setBackTopEnable(boolean z5) {
        this.f21492H = z5;
        if (z5) {
            this.f21509f.setBackgroundResource(X4.e.f5939m);
        }
    }

    public void setDropDownShowStart(int i5) {
        this.f21488D = i5;
    }

    public void setFullWindowContent(boolean z5) {
        if (this.f21491G != z5) {
            this.f21491G = z5;
            requestLayout();
        }
    }

    public void setHasNonEmbeddedTabs(boolean z5) {
        this.f21515l = z5;
    }

    public void setHideOnContentScrollEnabled(boolean z5) {
        if (z5 != this.f21516m) {
            this.f21516m = z5;
            if (z5) {
                return;
            }
            A();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i5) {
        F();
        this.f21511h.setIcon(i5);
    }

    public void setLogo(int i5) {
        F();
        this.f21511h.k(i5);
    }

    public void setOverlayMode(boolean z5) {
        this.f21514k = z5;
        this.f21513j = z5 && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z5) {
    }

    public void setSplitBarFitSystemWindows(boolean z5) {
        this.f21487C = z5;
    }

    @Deprecated
    public void setTransStatusBarInStepOS3(boolean z5) {
    }

    public void setUiOptions(int i5) {
        this.f21490F = i5;
        int i6 = 0;
        boolean z5 = (i5 & 1) != 0;
        boolean z6 = z5 ? getContext().getResources().getBoolean(X4.b.f5854d) : this.f21486B;
        boolean z7 = i5 == 2;
        if (z6 && z7) {
            throw new IllegalStateException("You can't split action bar and use bottom menu in the same time.");
        }
        F();
        ActionBarContainer actionBarContainer = this.f21508e;
        ActionBarContextView actionBarContextView = actionBarContainer != null ? (ActionBarContextView) actionBarContainer.findViewById(X4.f.f5991g) : (ActionBarContextView) findViewById(X4.f.f5991g);
        if (z6) {
            if (this.f21507d == null || !this.f21511h.I()) {
                Log.e("ActionBarOverlayLayout", "Requested split action bar with incompatible window decor! Ignoring request.");
                return;
            } else {
                this.f21511h.C(this.f21507d);
                actionBarContextView.setSplitView(this.f21507d);
            }
        } else if (z7) {
            ActionBarContainer actionBarContainer2 = this.f21507d;
            if (actionBarContainer2 == null) {
                Log.e("ActionBarOverlayLayout", "Requested split action bar with incompatible window decor! Ignoring request.");
                return;
            }
            this.f21511h.C(actionBarContainer2);
        } else {
            this.f21511h.C(null);
            if (!actionBarContextView.q()) {
                actionBarContextView.setSplitView(null);
            }
        }
        this.f21511h.B(z6);
        this.f21511h.L(z7);
        this.f21511h.u(z5);
        actionBarContextView.setSplitToolbar(z6);
        actionBarContextView.setSplitWhenNarrow(z5);
        ActionBarContainer actionBarContainer3 = this.f21507d;
        if (actionBarContainer3 != null) {
            if (!this.f21511h.v() && !actionBarContextView.q() && !z7) {
                i6 = 8;
            }
            actionBarContainer3.setVisibility(i6);
        }
    }

    @Override // stepos.support.v7.widget.l
    public void setWindowCallback(Window.Callback callback) {
        F();
        this.f21511h.setWindowCallback(callback);
    }

    @Override // stepos.support.v7.widget.l
    public void setWindowTitle(CharSequence charSequence) {
        F();
        this.f21511h.setWindowTitle(charSequence);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // stepos.support.v7.widget.l
    public void t(Menu menu, h.a aVar) {
        F();
        this.f21511h.E(menu, aVar);
        if (this.f21511h.y() && menu == null) {
            this.f21511h.L(false);
        }
    }

    @Override // stepos.support.v7.widget.l
    public void u() {
        if (this.f21492H && this.f21509f != null && this.f21499R) {
            K();
            this.f21509f.setClickable(false);
            this.f21499R = false;
            I();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public g generateDefaultLayoutParams() {
        return new g(-1, -1);
    }

    @Override // android.view.ViewGroup
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public g generateLayoutParams(AttributeSet attributeSet) {
        return new g(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new g(layoutParams);
    }

    public void setIcon(Drawable drawable) {
        F();
        this.f21511h.setIcon(drawable);
    }
}

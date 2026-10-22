package stepos.support.v7.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
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
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.core.view.C1337z;
import androidx.core.view.N;
import androidx.core.view.U;
import androidx.core.view.V;
import androidx.core.view.W;
import com.stepos.launcher.assistant.slidepanel.ConstConfig;
import stepos.support.v7.appcompat.R$bool;
import stepos.support.v7.appcompat.R$dimen;
import stepos.support.v7.appcompat.R$drawable;
import stepos.support.v7.view.menu.g;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes5.dex */
public class ActionBarOverlayLayout extends ViewGroup implements j {

    /* renamed from: T, reason: collision with root package name */
    public static final int[] f41102T = {R$attr.actionBarSize, R.attr.windowContentOverlay, stepos.support.v7.appcompat.R$attr.steposWindowSplitActionBar, stepos.support.v7.appcompat.R$attr.steposSplitActionBarFloat, stepos.support.v7.appcompat.R$attr.steposActionBarFitStatusBar, stepos.support.v7.appcompat.R$attr.steposActionBarOverlayMode};

    /* renamed from: A, reason: collision with root package name */
    public U f41103A;

    /* renamed from: B, reason: collision with root package name */
    public boolean f41104B;

    /* renamed from: C, reason: collision with root package name */
    public boolean f41105C;

    /* renamed from: D, reason: collision with root package name */
    public int f41106D;

    /* renamed from: E, reason: collision with root package name */
    public boolean f41107E;

    /* renamed from: F, reason: collision with root package name */
    public int f41108F;

    /* renamed from: G, reason: collision with root package name */
    public boolean f41109G;

    /* renamed from: H, reason: collision with root package name */
    public boolean f41110H;

    /* renamed from: I, reason: collision with root package name */
    public final V f41111I;

    /* renamed from: J, reason: collision with root package name */
    public final V f41112J;

    /* renamed from: K, reason: collision with root package name */
    public final Runnable f41113K;

    /* renamed from: L, reason: collision with root package name */
    public final Runnable f41114L;

    /* renamed from: M, reason: collision with root package name */
    public final C1337z f41115M;

    /* renamed from: N, reason: collision with root package name */
    public Drawable f41116N;

    /* renamed from: O, reason: collision with root package name */
    public boolean f41117O;

    /* renamed from: P, reason: collision with root package name */
    public ObjectAnimator f41118P;

    /* renamed from: Q, reason: collision with root package name */
    public ObjectAnimator f41119Q;

    /* renamed from: R, reason: collision with root package name */
    public Interpolator f41120R;

    /* renamed from: S, reason: collision with root package name */
    public Interpolator f41121S;

    /* renamed from: a, reason: collision with root package name */
    public int f41122a;

    /* renamed from: b, reason: collision with root package name */
    public int f41123b;

    /* renamed from: c, reason: collision with root package name */
    public FitsWindowsContentLayout f41124c;

    /* renamed from: d, reason: collision with root package name */
    public ActionBarContainer f41125d;

    /* renamed from: e, reason: collision with root package name */
    public ActionBarContainer f41126e;

    /* renamed from: f, reason: collision with root package name */
    public View f41127f;

    /* renamed from: g, reason: collision with root package name */
    public ActionBarDropDownView f41128g;

    /* renamed from: h, reason: collision with root package name */
    public k f41129h;

    /* renamed from: i, reason: collision with root package name */
    public Drawable f41130i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f41131j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f41132k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f41133l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f41134m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f41135n;

    /* renamed from: o, reason: collision with root package name */
    public int f41136o;

    /* renamed from: p, reason: collision with root package name */
    public int f41137p;

    /* renamed from: q, reason: collision with root package name */
    public final Rect f41138q;

    /* renamed from: r, reason: collision with root package name */
    public final Rect f41139r;

    /* renamed from: s, reason: collision with root package name */
    public final Rect f41140s;

    /* renamed from: t, reason: collision with root package name */
    public final Rect f41141t;

    /* renamed from: u, reason: collision with root package name */
    public final Rect f41142u;

    /* renamed from: v, reason: collision with root package name */
    public final Rect f41143v;

    /* renamed from: w, reason: collision with root package name */
    public f f41144w;

    /* renamed from: x, reason: collision with root package name */
    public final int f41145x;

    /* renamed from: y, reason: collision with root package name */
    public androidx.core.widget.h f41146y;

    /* renamed from: z, reason: collision with root package name */
    public U f41147z;

    public class a extends W {
        public a() {
        }

        @Override // androidx.core.view.W, androidx.core.view.V
        public void c(View view) {
            ActionBarOverlayLayout.this.f41147z = null;
            ActionBarOverlayLayout.this.f41135n = false;
        }

        @Override // androidx.core.view.W, androidx.core.view.V
        public void d(View view) {
            ActionBarOverlayLayout.this.f41147z = null;
            ActionBarOverlayLayout.this.f41135n = false;
        }
    }

    public class b extends W {
        public b() {
        }

        @Override // androidx.core.view.W, androidx.core.view.V
        public void c(View view) {
            ActionBarOverlayLayout.this.f41103A = null;
            ActionBarOverlayLayout.this.f41135n = false;
        }

        @Override // androidx.core.view.W, androidx.core.view.V
        public void d(View view) {
            ActionBarOverlayLayout.this.f41103A = null;
            ActionBarOverlayLayout.this.f41135n = false;
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.A();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f41147z = N.d(actionBarOverlayLayout.f41126e).m(0.0f).h(ActionBarOverlayLayout.this.f41111I);
            if (ActionBarOverlayLayout.this.f41125d == null || ActionBarOverlayLayout.this.f41125d.getVisibility() == 8) {
                return;
            }
            ActionBarOverlayLayout actionBarOverlayLayout2 = ActionBarOverlayLayout.this;
            actionBarOverlayLayout2.f41103A = N.d(actionBarOverlayLayout2.f41125d).m(0.0f).h(ActionBarOverlayLayout.this.f41112J);
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.A();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f41147z = N.d(actionBarOverlayLayout.f41126e).m(-ActionBarOverlayLayout.this.f41126e.getHeight()).h(ActionBarOverlayLayout.this.f41111I);
            if (ActionBarOverlayLayout.this.f41125d == null || ActionBarOverlayLayout.this.f41125d.getVisibility() == 8) {
                return;
            }
            ActionBarOverlayLayout actionBarOverlayLayout2 = ActionBarOverlayLayout.this;
            actionBarOverlayLayout2.f41103A = N.d(actionBarOverlayLayout2.f41125d).m(ActionBarOverlayLayout.this.f41125d.getHeight()).h(ActionBarOverlayLayout.this.f41112J);
        }
    }

    public class e extends AnimatorListenerAdapter {
        public e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            ActionBarOverlayLayout.this.f41127f.setVisibility(4);
        }
    }

    public interface f {
        void a();

        void b();

        void c(boolean z10);

        void d();

        void e();

        void onWindowVisibilityChanged(int i10);
    }

    public static class g extends ViewGroup.MarginLayoutParams {
        public g(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public g(int i10, int i11) {
            super(i10, i11);
        }

        public g(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f41123b = 0;
        this.f41132k = true;
        this.f41138q = new Rect();
        this.f41139r = new Rect();
        this.f41140s = new Rect();
        this.f41141t = new Rect();
        this.f41142u = new Rect();
        this.f41143v = new Rect();
        this.f41145x = 600;
        this.f41106D = -1;
        this.f41110H = false;
        this.f41111I = new a();
        this.f41112J = new b();
        this.f41113K = new c();
        this.f41114L = new d();
        this.f41117O = false;
        B(context);
        this.f41115M = new C1337z(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        removeCallbacks(this.f41113K);
        removeCallbacks(this.f41114L);
        U u10 = this.f41147z;
        if (u10 != null) {
            u10.c();
        }
        U u11 = this.f41103A;
        if (u11 != null) {
            u11.c();
        }
    }

    private void B(Context context) {
        if (O6.c.c()) {
            f41102T[0] = stepos.support.v7.appcompat.R$attr.steposActionBarSizeFullScreen;
        }
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f41102T);
        this.f41122a = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        this.f41130i = drawable;
        setWillNotDraw(drawable == null);
        this.f41104B = typedArrayObtainStyledAttributes.getBoolean(2, false);
        this.f41105C = typedArrayObtainStyledAttributes.getBoolean(3, false);
        this.f41107E = typedArrayObtainStyledAttributes.getBoolean(4, this.f41107E);
        setOverlayMode(typedArrayObtainStyledAttributes.getBoolean(5, this.f41132k));
        typedArrayObtainStyledAttributes.recycle();
        this.f41131j = context.getApplicationInfo().targetSdkVersion < 19;
        this.f41146y = androidx.core.widget.h.a(context);
    }

    private void D() {
        A();
        postDelayed(this.f41114L, 600L);
    }

    private void E() {
        A();
        postDelayed(this.f41113K, 600L);
    }

    private void G() {
        A();
        this.f41113K.run();
    }

    private void v() {
        A();
        this.f41114L.run();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private k z(View view) {
        if (view instanceof k) {
            return (k) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    public boolean C() {
        return this.f41132k;
    }

    public void F() {
        if (this.f41124c == null) {
            this.f41124c = (FitsWindowsContentLayout) findViewById(R$id.action_bar_activity_content);
            this.f41126e = (ActionBarContainer) findViewById(stepos.support.v7.appcompat.R$id.action_bar_container);
            this.f41129h = z(findViewById(stepos.support.v7.appcompat.R$id.action_bar));
            this.f41125d = (ActionBarContainer) findViewById(stepos.support.v7.appcompat.R$id.split_action_bar);
            this.f41127f = findViewById(stepos.support.v7.appcompat.R$id.stepos_list_backtop_container);
        }
    }

    public final boolean H(float f10, float f11) {
        this.f41146y.c(0, 0, 0, (int) f11, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.f41146y.d() > this.f41126e.getHeight();
    }

    public final void I() {
        if (this.f41121S == null) {
            this.f41121S = new PathInterpolator(0.3f, 0.0f, 0.67f, 1.0f);
        }
        if (this.f41119Q == null) {
            ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this.f41116N, ConstConfig.KEY_VIEW_ALPHA_PROPERTY, 127, 0);
            this.f41119Q = objectAnimatorOfInt;
            objectAnimatorOfInt.setInterpolator(this.f41121S);
            this.f41119Q.setDuration(230L);
            this.f41119Q.addListener(new e());
        }
        this.f41119Q.start();
    }

    public final void J() {
        if (this.f41120R == null) {
            this.f41120R = new PathInterpolator(0.3f, 0.0f, 0.67f, 1.0f);
        }
        if (this.f41118P == null) {
            ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this.f41116N, ConstConfig.KEY_VIEW_ALPHA_PROPERTY, 0, 255);
            this.f41118P = objectAnimatorOfInt;
            objectAnimatorOfInt.setInterpolator(this.f41120R);
            this.f41118P.setDuration(150L);
        }
        this.f41118P.start();
    }

    public final void K() {
        ObjectAnimator objectAnimator = this.f41119Q;
        if (objectAnimator == null || !objectAnimator.isRunning()) {
            return;
        }
        this.f41119Q.cancel();
    }

    public final void L() {
        ObjectAnimator objectAnimator = this.f41118P;
        if (objectAnimator == null || !objectAnimator.isRunning()) {
            return;
        }
        this.f41118P.cancel();
    }

    public final void M() throws Resources.NotFoundException {
        int iU = N.u(this);
        int measuredWidth = this.f41127f.getMeasuredWidth();
        int measuredHeight = this.f41127f.getMeasuredHeight();
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.stepos_list_backtop_btn_margin_right);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R$dimen.stepos_list_backtop_btn_margin_bottom);
        if (iU == 1) {
            int paddingLeft = getPaddingLeft() + dimensionPixelSize;
            int height = ((getHeight() - getPaddingBottom()) - dimensionPixelSize2) - measuredHeight;
            this.f41127f.layout(paddingLeft, height, measuredWidth + paddingLeft, measuredHeight + height);
        }
    }

    @Override // stepos.support.v7.widget.j
    public boolean a() {
        F();
        return this.f41129h.a();
    }

    @Override // stepos.support.v7.widget.j
    public boolean b() {
        F();
        return this.f41129h.b();
    }

    @Override // stepos.support.v7.widget.j
    public boolean c() {
        F();
        return this.f41129h.c();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof g;
    }

    @Override // stepos.support.v7.widget.j
    public boolean d() {
        F();
        return this.f41129h.d();
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
        int i10 = windowInsets.getInsets(WindowInsets.Type.ime()).bottom;
        if (i10 > insets.bottom) {
            rect.bottom = i10;
        }
        boolean zW = w(rect);
        this.f41141t.set(rect);
        this.f41138q.set(rect);
        ActionBarContainer actionBarContainer = this.f41125d;
        if (actionBarContainer != null) {
            zW |= y.g(actionBarContainer, rect2, true, false, true, this.f41105C);
            this.f41129h.A(this.f41125d);
        }
        if (!this.f41139r.equals(this.f41138q)) {
            this.f41139r.set(this.f41138q);
            zW = true;
        }
        if (zW) {
            this.f41143v.setEmpty();
            requestLayout();
        } else if (this.f41132k) {
            this.f41124c.dispatchFitSystemWindows(this.f41143v);
        }
        return windowInsets.consumeSystemWindowInsets();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f41130i == null || this.f41131j) {
            return;
        }
        int bottom = this.f41126e.getVisibility() == 0 ? (int) (this.f41126e.getBottom() + N.E(this.f41126e) + 0.5f) : 0;
        this.f41130i.setBounds(0, bottom, getWidth(), this.f41130i.getIntrinsicHeight() + bottom);
        this.f41130i.draw(canvas);
    }

    @Override // stepos.support.v7.widget.j
    public void e() {
        F();
        this.f41129h.e();
    }

    @Override // stepos.support.v7.widget.j
    public boolean f() {
        F();
        return this.f41129h.f();
    }

    @Override // stepos.support.v7.widget.j
    public void g(int i10) {
        F();
        if (i10 == 2) {
            this.f41129h.n();
        } else if (i10 == 5) {
            this.f41129h.t();
        } else {
            if (i10 != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f41126e;
        if (actionBarContainer != null) {
            return -((int) N.E(actionBarContainer));
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f41115M.a();
    }

    public CharSequence getTitle() {
        F();
        return this.f41129h.getTitle();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        B(getContext());
        N.e0(this);
        setUiOptions(this.f41108F);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        A();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) throws Resources.NotFoundException {
        int measuredHeight;
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = (i12 - i10) - getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = (i13 - i11) - getPaddingBottom();
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                g gVar = (g) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight2 = childAt.getMeasuredHeight();
                int i15 = ((ViewGroup.MarginLayoutParams) gVar).leftMargin + paddingLeft;
                ActionBarContainer actionBarContainer = this.f41125d;
                if (childAt == actionBarContainer) {
                    measuredHeight = (paddingBottom - measuredHeight2) - ((ViewGroup.MarginLayoutParams) gVar).bottomMargin;
                } else if (childAt == this.f41127f) {
                    measuredHeight = ((paddingBottom - measuredHeight2) - ((ViewGroup.MarginLayoutParams) gVar).bottomMargin) - ((actionBarContainer == null || actionBarContainer.getVisibility() == 8) ? 0 : this.f41125d.getMeasuredHeight());
                    i15 = (paddingRight - measuredWidth) - ((ViewGroup.MarginLayoutParams) gVar).rightMargin;
                } else {
                    measuredHeight = paddingTop + ((ViewGroup.MarginLayoutParams) gVar).topMargin;
                }
                childAt.layout(i15, measuredHeight, measuredWidth + i15, measuredHeight2 + measuredHeight);
            }
        }
        M();
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int measuredHeight;
        ActionBarContainer actionBarContainer;
        int i12;
        F();
        View view = this.f41127f;
        if (view != null && view.getVisibility() != 8) {
            measureChildWithMargins(this.f41127f, i10, 0, i11, 0);
        }
        measureChildWithMargins(this.f41126e, i10, 0, i11, 0);
        g gVar = (g) this.f41126e.getLayoutParams();
        int measuredHeight2 = 0;
        int iMax = Math.max(0, this.f41126e.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) gVar).leftMargin + ((ViewGroup.MarginLayoutParams) gVar).rightMargin);
        int iMax2 = Math.max(0, this.f41126e.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) gVar).topMargin + ((ViewGroup.MarginLayoutParams) gVar).bottomMargin);
        int iH = y.h(0, N.v(this.f41126e));
        ActionBarContainer actionBarContainer2 = this.f41125d;
        if (actionBarContainer2 != null) {
            measureChildWithMargins(actionBarContainer2, i10, 0, i11, 0);
            g gVar2 = (g) this.f41125d.getLayoutParams();
            iMax = Math.max(iMax, this.f41125d.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) gVar2).leftMargin + ((ViewGroup.MarginLayoutParams) gVar2).rightMargin);
            iMax2 = Math.max(iMax2, this.f41125d.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) gVar2).topMargin + ((ViewGroup.MarginLayoutParams) gVar2).bottomMargin);
            iH = y.h(iH, N.v(this.f41125d));
        }
        View viewFindViewById = findViewById(stepos.support.v7.appcompat.R$id.top_shadow_mask);
        if (viewFindViewById != null) {
            measureChildWithMargins(viewFindViewById, i10, 0, i11, 0);
        }
        if (this.f41126e.getVisibility() != 8) {
            measuredHeight = this.f41126e.getMeasuredHeight();
            int i13 = this.f41141t.top;
            if (measuredHeight > i13) {
                measuredHeight -= i13;
            }
        } else {
            measuredHeight = 0;
        }
        if ((this.f41129h.z() || this.f41129h.v() || this.f41129h.D()) && (actionBarContainer = this.f41125d) != null && actionBarContainer.getVisibility() != 8 && (measuredHeight2 = this.f41125d.getMeasuredHeight()) > (i12 = this.f41141t.bottom)) {
            measuredHeight2 -= i12;
        }
        this.f41140s.set(this.f41138q);
        this.f41142u.set(this.f41141t);
        if (this.f41132k) {
            Rect rect = this.f41142u;
            rect.top += measuredHeight;
            rect.bottom += measuredHeight2;
            this.f41140s.setEmpty();
        } else {
            Rect rect2 = this.f41140s;
            rect2.top += measuredHeight;
            rect2.bottom += measuredHeight2;
            this.f41142u.setEmpty();
        }
        y.f(this.f41124c, this.f41140s, true, true, true, true);
        if (!this.f41143v.equals(this.f41142u)) {
            this.f41143v.set(this.f41142u);
            this.f41124c.dispatchFitSystemWindows(this.f41142u);
        }
        measureChildWithMargins(this.f41124c, i10, 0, i11, 0);
        g gVar3 = (g) this.f41124c.getLayoutParams();
        int iMax3 = Math.max(iMax, this.f41124c.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) gVar3).leftMargin + ((ViewGroup.MarginLayoutParams) gVar3).rightMargin);
        int iMax4 = Math.max(iMax2, this.f41124c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) gVar3).topMargin + ((ViewGroup.MarginLayoutParams) gVar3).bottomMargin);
        int iH2 = y.h(iH, N.v(this.f41124c));
        ActionBarDropDownView actionBarDropDownView = this.f41128g;
        if (actionBarDropDownView != null && actionBarDropDownView.getVisibility() != 8) {
            Rect rect3 = !this.f41132k ? this.f41140s : this.f41142u;
            int i14 = this.f41106D;
            if (i14 != -1) {
                rect3.top = i14;
            }
            y.g(this.f41128g, rect3, true, true, true, true);
            measureChildWithMargins(this.f41128g, i10, 0, i11, 0);
            iH2 = y.h(iH2, N.v(this.f41128g));
        }
        setMeasuredDimension(N.f0(Math.max(iMax3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i10, iH2), N.f0(Math.max(iMax4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i11, iH2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f10, float f11, boolean z10) {
        if (!this.f41134m || !z10) {
            return false;
        }
        if (H(f10, f11)) {
            v();
        } else {
            G();
        }
        this.f41135n = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f10, float f11) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13) {
        int i14 = this.f41136o + i11;
        this.f41136o = i14;
        setActionBarHideOffset(i14);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i10) {
        this.f41115M.b(view, view2, i10);
        this.f41136o = getActionBarHideOffset();
        A();
        f fVar = this.f41144w;
        if (fVar != null) {
            fVar.e();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i10) {
        if ((i10 & 2) == 0 || this.f41126e.getVisibility() != 0) {
            return false;
        }
        return this.f41134m;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        if (this.f41134m && !this.f41135n) {
            if (this.f41136o <= this.f41126e.getHeight()) {
                E();
            } else {
                D();
            }
        }
        f fVar = this.f41144w;
        if (fVar != null) {
            fVar.b();
        }
    }

    @Override // android.view.View
    public void onWindowSystemUiVisibilityChanged(int i10) {
        super.onWindowSystemUiVisibilityChanged(i10);
        F();
        int i11 = this.f41137p ^ i10;
        this.f41137p = i10;
        boolean z10 = (i10 & 4) == 0;
        boolean z11 = (i10 & 256) != 0;
        f fVar = this.f41144w;
        if (fVar != null) {
            fVar.c(!z11);
            if (z10 || !z11) {
                this.f41144w.a();
            } else {
                this.f41144w.d();
            }
        }
        if ((i11 & 256) == 0 || this.f41144w == null) {
            return;
        }
        N.e0(this);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        this.f41123b = i10;
        f fVar = this.f41144w;
        if (fVar != null) {
            fVar.onWindowVisibilityChanged(i10);
        }
    }

    @Override // stepos.support.v7.widget.j
    public void q(Menu menu, g.a aVar) {
        F();
        this.f41129h.q(menu, aVar);
    }

    @Override // stepos.support.v7.widget.j
    public void r() {
        F();
        this.f41129h.p();
    }

    @Override // stepos.support.v7.widget.j
    public void s() {
        if (!this.f41110H || this.f41127f == null || this.f41117O) {
            return;
        }
        L();
        this.f41117O = true;
        this.f41127f.setVisibility(0);
        J();
        this.f41127f.setClickable(true);
    }

    public void setActionBarDropDownView(ActionBarDropDownView actionBarDropDownView) {
        this.f41128g = actionBarDropDownView;
    }

    public void setActionBarFitStatusBar(boolean z10) {
        this.f41107E = z10;
    }

    public void setActionBarHideOffset(int i10) {
        A();
        int iMax = Math.max(0, Math.min(i10, this.f41126e.getHeight()));
        N.C0(this.f41126e, -iMax);
        ActionBarContainer actionBarContainer = this.f41125d;
        if (actionBarContainer == null || actionBarContainer.getVisibility() == 8) {
            return;
        }
        N.C0(this.f41125d, (int) (this.f41125d.getHeight() * (iMax / r0)));
    }

    public void setActionBarVisibilityCallback(f fVar) {
        this.f41144w = fVar;
        if (getWindowToken() != null) {
            this.f41144w.onWindowVisibilityChanged(this.f41123b);
            int i10 = this.f41137p;
            if (i10 != 0) {
                onWindowSystemUiVisibilityChanged(i10);
                N.e0(this);
            }
        }
    }

    @Override // stepos.support.v7.widget.j
    public void setBackTopBackground(Drawable drawable) {
        if (this.f41110H) {
            if (drawable == null) {
                this.f41127f.setBackgroundResource(R$drawable.stepos_list_backtop);
            } else {
                this.f41116N = drawable;
                this.f41127f.setBackground(drawable);
            }
        }
    }

    @Override // stepos.support.v7.widget.j
    public void setBackTopClickCallback(View.OnClickListener onClickListener) {
        this.f41127f.setOnClickListener(onClickListener);
    }

    @Override // stepos.support.v7.widget.j
    public void setBackTopEnable(boolean z10) {
        this.f41110H = z10;
        if (z10) {
            this.f41127f.setBackgroundResource(R$drawable.stepos_list_backtop);
        }
    }

    public void setDropDownShowStart(int i10) {
        this.f41106D = i10;
    }

    public void setFullWindowContent(boolean z10) {
        if (this.f41109G != z10) {
            this.f41109G = z10;
            requestLayout();
        }
    }

    public void setHasNonEmbeddedTabs(boolean z10) {
        this.f41133l = z10;
    }

    public void setHideOnContentScrollEnabled(boolean z10) {
        if (z10 != this.f41134m) {
            this.f41134m = z10;
            if (z10) {
                return;
            }
            A();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i10) {
        F();
        this.f41129h.setIcon(i10);
    }

    public void setLogo(int i10) {
        F();
        this.f41129h.r(i10);
    }

    public void setOverlayMode(boolean z10) {
        this.f41132k = z10;
        this.f41131j = z10 && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z10) {
    }

    public void setSplitBarFitSystemWindows(boolean z10) {
        this.f41105C = z10;
    }

    @Deprecated
    public void setTransStatusBarInStepOS3(boolean z10) {
    }

    public void setUiOptions(int i10) {
        this.f41108F = i10;
        int i11 = 0;
        boolean z10 = (i10 & 1) != 0;
        boolean z11 = z10 ? getContext().getResources().getBoolean(R$bool.stepos_split_action_bar_is_narrow) : this.f41104B;
        boolean z12 = i10 == 2;
        if (z11 && z12) {
            throw new IllegalStateException("You can't split action bar and use bottom menu in the same time.");
        }
        F();
        ActionBarContainer actionBarContainer = this.f41126e;
        ActionBarContextView actionBarContextView = actionBarContainer != null ? (ActionBarContextView) actionBarContainer.findViewById(stepos.support.v7.appcompat.R$id.action_context_bar) : (ActionBarContextView) findViewById(stepos.support.v7.appcompat.R$id.action_context_bar);
        if (z11) {
            if (this.f41125d == null || !this.f41129h.E()) {
                Log.e("ActionBarOverlayLayout", "Requested split action bar with incompatible window decor! Ignoring request.");
                return;
            } else {
                this.f41129h.B(this.f41125d);
                actionBarContextView.setSplitView(this.f41125d);
            }
        } else if (z12) {
            ActionBarContainer actionBarContainer2 = this.f41125d;
            if (actionBarContainer2 == null) {
                Log.e("ActionBarOverlayLayout", "Requested split action bar with incompatible window decor! Ignoring request.");
                return;
            }
            this.f41129h.B(actionBarContainer2);
        } else {
            this.f41129h.B(null);
            if (!actionBarContextView.q()) {
                actionBarContextView.setSplitView(null);
            }
        }
        this.f41129h.w(z11);
        this.f41129h.F(z12);
        this.f41129h.y(z10);
        actionBarContextView.setSplitToolbar(z11);
        actionBarContextView.setSplitWhenNarrow(z10);
        ActionBarContainer actionBarContainer3 = this.f41125d;
        if (actionBarContainer3 != null) {
            if (!this.f41129h.z() && !actionBarContextView.q() && !z12) {
                i11 = 8;
            }
            actionBarContainer3.setVisibility(i11);
        }
    }

    @Override // stepos.support.v7.widget.j
    public void setWindowCallback(Window.Callback callback) {
        F();
        this.f41129h.setWindowCallback(callback);
    }

    @Override // stepos.support.v7.widget.j
    public void setWindowTitle(CharSequence charSequence) {
        F();
        this.f41129h.setWindowTitle(charSequence);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // stepos.support.v7.widget.j
    public void t(Menu menu, g.a aVar) {
        F();
        this.f41129h.C(menu, aVar);
        if (this.f41129h.v() && menu == null) {
            this.f41129h.F(false);
        }
    }

    @Override // stepos.support.v7.widget.j
    public void u() {
        if (this.f41110H && this.f41127f != null && this.f41117O) {
            K();
            this.f41127f.setClickable(false);
            this.f41117O = false;
            I();
        }
    }

    public final boolean w(Rect rect) {
        if (!this.f41107E) {
            rect.top = O6.s.d(getContext());
        }
        return y.g(this.f41126e, rect, true, true, true, false);
    }

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
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new g(layoutParams);
    }

    public void setIcon(Drawable drawable) {
        F();
        this.f41129h.setIcon(drawable);
    }
}

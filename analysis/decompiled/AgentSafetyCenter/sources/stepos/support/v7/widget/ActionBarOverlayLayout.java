package stepos.support.v7.widget;

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
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.animation.PathInterpolator;
import android.widget.OverScroller;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import com.google.crypto.tink.shaded.protobuf.Reader;
import com.stepos.agentsafetycenter.R;
import java.lang.invoke.VarHandle;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public class ActionBarOverlayLayout extends ViewGroup implements b0 {
    public static final int[] U = {R.attr.actionBarSize, android.R.attr.windowContentOverlay, R.attr.steposWindowSplitActionBar, R.attr.steposSplitActionBarFloat, R.attr.steposActionBarFitStatusBar, R.attr.steposActionBarOverlayMode};
    public n3.o0 A;
    public n3.o0 B;
    public boolean C;
    public boolean D;
    public int E;
    public boolean F;
    public int G;
    public boolean H;
    public boolean I;
    public final g J;
    public final g K;
    public final h L;
    public final h M;
    public final h0.l0 N;
    public Drawable O;
    public boolean P;
    public ObjectAnimator Q;
    public ObjectAnimator R;
    public PathInterpolator S;
    public PathInterpolator T;

    /* renamed from: c, reason: collision with root package name */
    public int f12581c;

    /* renamed from: f, reason: collision with root package name */
    public FitsWindowsContentLayout f12582f;

    /* renamed from: g, reason: collision with root package name */
    public ActionBarContainer f12583g;

    /* renamed from: h, reason: collision with root package name */
    public ActionBarContainer f12584h;
    public View i;

    /* renamed from: j, reason: collision with root package name */
    public ActionBarDropDownView f12585j;

    /* renamed from: k, reason: collision with root package name */
    public c0 f12586k;

    /* renamed from: l, reason: collision with root package name */
    public Drawable f12587l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f12588m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f12589n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f12590o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f12591p;

    /* renamed from: q, reason: collision with root package name */
    public int f12592q;

    /* renamed from: r, reason: collision with root package name */
    public int f12593r;

    /* renamed from: s, reason: collision with root package name */
    public final Rect f12594s;

    /* renamed from: t, reason: collision with root package name */
    public final Rect f12595t;

    /* renamed from: u, reason: collision with root package name */
    public final Rect f12596u;

    /* renamed from: v, reason: collision with root package name */
    public final Rect f12597v;

    /* renamed from: w, reason: collision with root package name */
    public final Rect f12598w;

    /* renamed from: x, reason: collision with root package name */
    public final Rect f12599x;

    /* renamed from: y, reason: collision with root package name */
    public i f12600y;

    /* renamed from: z, reason: collision with root package name */
    public a1.g f12601z;

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12581c = 0;
        this.f12589n = true;
        this.f12594s = new Rect();
        this.f12595t = new Rect();
        this.f12596u = new Rect();
        this.f12597v = new Rect();
        this.f12598w = new Rect();
        this.f12599x = new Rect();
        this.E = -1;
        this.I = false;
        g gVar = new g(0);
        gVar.f12753h = this;
        VarHandle.storeStoreFence();
        this.J = gVar;
        g gVar2 = new g(1);
        gVar2.f12753h = this;
        VarHandle.storeStoreFence();
        this.K = gVar2;
        h hVar = new h(0);
        hVar.f12756f = this;
        VarHandle.storeStoreFence();
        this.L = hVar;
        h hVar2 = new h(1);
        hVar2.f12756f = this;
        VarHandle.storeStoreFence();
        this.M = hVar2;
        this.P = false;
        k(context);
        this.N = new h0.l0();
    }

    @Override // stepos.support.v7.widget.b0
    public final boolean a() {
        l();
        return this.f12586k.a();
    }

    @Override // stepos.support.v7.widget.b0
    public final void b() {
        l();
        this.f12586k.b();
    }

    @Override // stepos.support.v7.widget.b0
    public final void c(Menu menu, te.u uVar) {
        l();
        this.f12586k.c(menu, uVar);
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof j;
    }

    @Override // stepos.support.v7.widget.b0
    public final boolean d() {
        l();
        return this.f12586k.d();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        super.dispatchApplyWindowInsets(windowInsets);
        l();
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        Insets insets = windowInsets.getInsets(WindowInsets.Type.systemBars());
        rect.set(insets.left, insets.top, insets.right, insets.bottom);
        rect2.set(rect);
        int i = windowInsets.getInsets(WindowInsets.Type.ime()).bottom;
        if (i > insets.bottom) {
            rect.bottom = i;
        }
        if (!this.F) {
            rect.top = t1.e.k(getContext());
        }
        boolean z10 = true;
        boolean zA = x1.a(this.f12584h, rect, true, false);
        this.f12597v.set(rect);
        Rect rect3 = this.f12594s;
        rect3.set(rect);
        ActionBarContainer actionBarContainer = this.f12583g;
        if (actionBarContainer != null) {
            zA |= x1.a(actionBarContainer, rect2, false, this.D);
            this.f12586k.m(this.f12583g);
        }
        Rect rect4 = this.f12595t;
        if (rect4.equals(rect3)) {
            z10 = zA;
        } else {
            rect4.set(rect3);
        }
        Rect rect5 = this.f12599x;
        if (z10) {
            rect5.setEmpty();
            requestLayout();
        } else if (this.f12589n) {
            this.f12582f.dispatchFitSystemWindows(rect5);
        }
        return windowInsets.consumeSystemWindowInsets();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int translationY;
        super.draw(canvas);
        if (this.f12587l == null || this.f12588m) {
            return;
        }
        if (this.f12584h.getVisibility() == 0) {
            float bottom = this.f12584h.getBottom();
            ActionBarContainer actionBarContainer = this.f12584h;
            WeakHashMap weakHashMap = n3.k0.f8724a;
            translationY = (int) (actionBarContainer.getTranslationY() + bottom + 0.5f);
        } else {
            translationY = 0;
        }
        this.f12587l.setBounds(0, translationY, getWidth(), this.f12587l.getIntrinsicHeight() + translationY);
        this.f12587l.draw(canvas);
    }

    @Override // stepos.support.v7.widget.b0
    public final boolean e() {
        l();
        return this.f12586k.e();
    }

    @Override // stepos.support.v7.widget.b0
    public final boolean f() {
        l();
        return this.f12586k.f();
    }

    @Override // stepos.support.v7.widget.b0
    public final boolean g() {
        l();
        return this.f12586k.g();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new j(-1, -1);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new j(getContext(), attributeSet);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f12584h;
        if (actionBarContainer == null) {
            return 0;
        }
        WeakHashMap weakHashMap = n3.k0.f8724a;
        return -((int) actionBarContainer.getTranslationY());
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        h0.l0 l0Var = this.N;
        return l0Var.f5053b | l0Var.f5052a;
    }

    public CharSequence getTitle() {
        l();
        return this.f12586k.getTitle();
    }

    @Override // stepos.support.v7.widget.b0
    public final void h(int i) {
        l();
        if (i == 2) {
            this.f12586k.B();
        } else if (i == 5) {
            this.f12586k.C();
        } else {
            if (i != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    @Override // stepos.support.v7.widget.b0
    public final void i() {
        l();
        this.f12586k.i();
    }

    public final void j() {
        removeCallbacks(this.L);
        removeCallbacks(this.M);
        n3.o0 o0Var = this.A;
        if (o0Var != null) {
            o0Var.b();
        }
        n3.o0 o0Var2 = this.B;
        if (o0Var2 != null) {
            o0Var2.b();
        }
    }

    public final void k(Context context) {
        int[] iArr = U;
        iArr[0] = R.attr.steposActionBarSizeFullScreen;
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(iArr);
        typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        this.f12587l = drawable;
        setWillNotDraw(drawable == null);
        this.C = typedArrayObtainStyledAttributes.getBoolean(2, false);
        this.D = typedArrayObtainStyledAttributes.getBoolean(3, false);
        this.F = typedArrayObtainStyledAttributes.getBoolean(4, this.F);
        setOverlayMode(typedArrayObtainStyledAttributes.getBoolean(5, this.f12589n));
        typedArrayObtainStyledAttributes.recycle();
        this.f12588m = context.getApplicationInfo().targetSdkVersion < 19;
        a1.g gVar = new a1.g(26, false);
        gVar.f19f = new OverScroller(context);
        this.f12601z = gVar;
    }

    public final void l() {
        c0 wrapper;
        if (this.f12582f == null) {
            this.f12582f = (FitsWindowsContentLayout) findViewById(R.id.action_bar_activity_content);
            this.f12584h = (ActionBarContainer) findViewById(R.id.action_bar_container);
            KeyEvent.Callback callbackFindViewById = findViewById(R.id.action_bar);
            if (callbackFindViewById instanceof c0) {
                wrapper = (c0) callbackFindViewById;
            } else {
                if (!(callbackFindViewById instanceof Toolbar)) {
                    od.f.e("Can't make a decor toolbar out of ".concat(callbackFindViewById.getClass().getSimpleName()));
                    return;
                }
                wrapper = ((Toolbar) callbackFindViewById).getWrapper();
            }
            this.f12586k = wrapper;
            this.f12583g = (ActionBarContainer) findViewById(R.id.split_action_bar);
            this.i = findViewById(R.id.stepos_list_backtop_container);
        }
    }

    @Override // stepos.support.v7.widget.b0
    public final void o() {
        if (!this.I || this.i == null || this.P) {
            return;
        }
        ObjectAnimator objectAnimator = this.Q;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.Q.cancel();
        }
        this.P = true;
        this.i.setVisibility(0);
        if (this.S == null) {
            this.S = new PathInterpolator(0.3f, 0.0f, 0.67f, 1.0f);
        }
        if (this.Q == null) {
            ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this.O, "alpha", 0, 255);
            this.Q = objectAnimatorOfInt;
            objectAnimatorOfInt.setInterpolator(this.S);
            this.Q.setDuration(150L);
        }
        this.Q.start();
        this.i.setClickable(true);
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        k(getContext());
        WeakHashMap weakHashMap = n3.k0.f8724a;
        requestApplyInsets();
        setUiOptions(this.G);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        j();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i, int i3, int i10, int i11) throws Resources.NotFoundException {
        int measuredHeight;
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = (i10 - i) - getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = (i11 - i3) - getPaddingBottom();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                j jVar = (j) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight2 = childAt.getMeasuredHeight();
                int i13 = ((ViewGroup.MarginLayoutParams) jVar).leftMargin + paddingLeft;
                ActionBarContainer actionBarContainer = this.f12583g;
                if (childAt == actionBarContainer) {
                    measuredHeight = (paddingBottom - measuredHeight2) - ((ViewGroup.MarginLayoutParams) jVar).bottomMargin;
                } else if (childAt == this.i) {
                    measuredHeight = ((paddingBottom - measuredHeight2) - ((ViewGroup.MarginLayoutParams) jVar).bottomMargin) - ((actionBarContainer == null || actionBarContainer.getVisibility() == 8) ? 0 : this.f12583g.getMeasuredHeight());
                    i13 = (paddingRight - measuredWidth) - ((ViewGroup.MarginLayoutParams) jVar).rightMargin;
                } else {
                    measuredHeight = paddingTop + ((ViewGroup.MarginLayoutParams) jVar).topMargin;
                }
                childAt.layout(i13, measuredHeight, measuredWidth + i13, measuredHeight2 + measuredHeight);
            }
        }
        WeakHashMap weakHashMap = n3.k0.f8724a;
        int layoutDirection = getLayoutDirection();
        int measuredWidth2 = this.i.getMeasuredWidth();
        int measuredHeight3 = this.i.getMeasuredHeight();
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.stepos_list_backtop_btn_margin_right);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.stepos_list_backtop_btn_margin_bottom);
        if (layoutDirection == 1) {
            int paddingLeft2 = getPaddingLeft() + dimensionPixelSize;
            int height = ((getHeight() - getPaddingBottom()) - dimensionPixelSize2) - measuredHeight3;
            this.i.layout(paddingLeft2, height, measuredWidth2 + paddingLeft2, measuredHeight3 + height);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i3) {
        int measuredHeight;
        ActionBarContainer actionBarContainer;
        int i10;
        l();
        View view = this.i;
        if (view != null && view.getVisibility() != 8) {
            measureChildWithMargins(this.i, i, 0, i3, 0);
        }
        measureChildWithMargins(this.f12584h, i, 0, i3, 0);
        j jVar = (j) this.f12584h.getLayoutParams();
        int measuredHeight2 = 0;
        int iMax = Math.max(0, this.f12584h.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) jVar).leftMargin + ((ViewGroup.MarginLayoutParams) jVar).rightMargin);
        int iMax2 = Math.max(0, this.f12584h.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) jVar).topMargin + ((ViewGroup.MarginLayoutParams) jVar).bottomMargin);
        ActionBarContainer actionBarContainer2 = this.f12584h;
        WeakHashMap weakHashMap = n3.k0.f8724a;
        int measuredState = actionBarContainer2.getMeasuredState();
        Method method = x1.f12901a;
        ActionBarContainer actionBarContainer3 = this.f12583g;
        if (actionBarContainer3 != null) {
            measureChildWithMargins(actionBarContainer3, i, 0, i3, 0);
            j jVar2 = (j) this.f12583g.getLayoutParams();
            iMax = Math.max(iMax, this.f12583g.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) jVar2).leftMargin + ((ViewGroup.MarginLayoutParams) jVar2).rightMargin);
            iMax2 = Math.max(iMax2, this.f12583g.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) jVar2).topMargin + ((ViewGroup.MarginLayoutParams) jVar2).bottomMargin);
            measuredState |= this.f12583g.getMeasuredState();
        }
        View viewFindViewById = findViewById(R.id.top_shadow_mask);
        if (viewFindViewById != null) {
            measureChildWithMargins(viewFindViewById, i, 0, i3, 0);
        }
        int visibility = this.f12584h.getVisibility();
        Rect rect = this.f12597v;
        if (visibility != 8) {
            measuredHeight = this.f12584h.getMeasuredHeight();
            int i11 = rect.top;
            if (measuredHeight > i11) {
                measuredHeight -= i11;
            }
        } else {
            measuredHeight = 0;
        }
        if ((this.f12586k.k() || this.f12586k.l() || this.f12586k.t()) && (actionBarContainer = this.f12583g) != null && actionBarContainer.getVisibility() != 8 && (measuredHeight2 = this.f12583g.getMeasuredHeight()) > (i10 = rect.bottom)) {
            measuredHeight2 -= i10;
        }
        Rect rect2 = this.f12594s;
        Rect rect3 = this.f12596u;
        rect3.set(rect2);
        Rect rect4 = this.f12598w;
        rect4.set(rect);
        if (this.f12589n) {
            rect4.top += measuredHeight;
            rect4.bottom += measuredHeight2;
            rect3.setEmpty();
        } else {
            rect3.top += measuredHeight;
            rect3.bottom += measuredHeight2;
            rect4.setEmpty();
        }
        ViewGroup.LayoutParams layoutParams = this.f12582f.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int i12 = marginLayoutParams.leftMargin;
            int i13 = rect3.left;
            if (i12 != i13) {
                marginLayoutParams.leftMargin = i13;
            }
            int i14 = marginLayoutParams.topMargin;
            int i15 = rect3.top;
            if (i14 != i15) {
                marginLayoutParams.topMargin = i15;
            }
            int i16 = marginLayoutParams.rightMargin;
            int i17 = rect3.right;
            if (i16 != i17) {
                marginLayoutParams.rightMargin = i17;
            }
            int i18 = marginLayoutParams.bottomMargin;
            int i19 = rect3.bottom;
            if (i18 != i19) {
                marginLayoutParams.bottomMargin = i19;
            }
        }
        Rect rect5 = this.f12599x;
        if (!rect5.equals(rect4)) {
            rect5.set(rect4);
            this.f12582f.dispatchFitSystemWindows(rect4);
        }
        measureChildWithMargins(this.f12582f, i, 0, i3, 0);
        j jVar3 = (j) this.f12582f.getLayoutParams();
        int iMax3 = Math.max(iMax, this.f12582f.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) jVar3).leftMargin + ((ViewGroup.MarginLayoutParams) jVar3).rightMargin);
        int iMax4 = Math.max(iMax2, this.f12582f.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) jVar3).topMargin + ((ViewGroup.MarginLayoutParams) jVar3).bottomMargin);
        int measuredState2 = measuredState | this.f12582f.getMeasuredState();
        ActionBarDropDownView actionBarDropDownView = this.f12585j;
        if (actionBarDropDownView != null && actionBarDropDownView.getVisibility() != 8) {
            if (this.f12589n) {
                rect3 = rect4;
            }
            int i20 = this.E;
            if (i20 != -1) {
                rect3.top = i20;
            }
            x1.a(this.f12585j, rect3, true, true);
            measureChildWithMargins(this.f12585j, i, 0, i3, 0);
            measuredState2 |= this.f12585j.getMeasuredState();
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(getPaddingRight() + getPaddingLeft() + iMax3, getSuggestedMinimumWidth()), i, measuredState2), View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + iMax4, getSuggestedMinimumHeight()), i3, measuredState2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f5, float f10, boolean z10) {
        if (!this.f12590o || !z10) {
            return false;
        }
        ((OverScroller) this.f12601z.f19f).fling(0, 0, 0, (int) f10, 0, 0, Integer.MIN_VALUE, Reader.READ_DONE);
        if (((OverScroller) this.f12601z.f19f).getFinalY() > this.f12584h.getHeight()) {
            j();
            this.M.run();
        } else {
            j();
            this.L.run();
        }
        this.f12591p = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f5, float f10) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i, int i3, int i10, int i11) {
        int i12 = this.f12592q + i3;
        this.f12592q = i12;
        setActionBarHideOffset(i12);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i) {
        stepos.support.v7.app.t0 t0Var;
        k.k kVar;
        this.N.f5052a = i;
        this.f12592q = getActionBarHideOffset();
        j();
        i iVar = this.f12600y;
        if (iVar == null || (kVar = (t0Var = (stepos.support.v7.app.t0) iVar).f12498u) == null) {
            return;
        }
        kVar.a();
        t0Var.f12498u = null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.f12584h.getVisibility() != 0) {
            return false;
        }
        return this.f12590o;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        if (!this.f12590o || this.f12591p) {
            return;
        }
        if (this.f12592q <= this.f12584h.getHeight()) {
            j();
            postDelayed(this.L, 600L);
        } else {
            j();
            postDelayed(this.M, 600L);
        }
    }

    @Override // android.view.View
    public final void onWindowSystemUiVisibilityChanged(int i) {
        super.onWindowSystemUiVisibilityChanged(i);
        l();
        int i3 = this.f12593r ^ i;
        this.f12593r = i;
        boolean z10 = (i & 4) == 0;
        boolean z11 = (i & ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH) != 0;
        i iVar = this.f12600y;
        if (iVar != null) {
            stepos.support.v7.app.t0 t0Var = (stepos.support.v7.app.t0) iVar;
            t0Var.f12494q = !z11;
            if (z10 || !z11) {
                if (t0Var.f12495r) {
                    t0Var.f12495r = false;
                    t0Var.x(true);
                }
            } else if (!t0Var.f12495r) {
                t0Var.f12495r = true;
                t0Var.x(true);
            }
        }
        if ((i3 & ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH) == 0 || this.f12600y == null) {
            return;
        }
        WeakHashMap weakHashMap = n3.k0.f8724a;
        requestApplyInsets();
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.f12581c = i;
        i iVar = this.f12600y;
        if (iVar != null) {
            ((stepos.support.v7.app.t0) iVar).f12493p = i;
        }
    }

    @Override // stepos.support.v7.widget.b0
    public final void p(Menu menu, te.u uVar) {
        l();
        this.f12586k.h(menu, uVar);
        if (this.f12586k.l() && menu == null) {
            this.f12586k.y(false);
        }
    }

    @Override // stepos.support.v7.widget.b0
    public final void r() {
        if (this.I && this.i != null && this.P) {
            ObjectAnimator objectAnimator = this.R;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.R.cancel();
            }
            this.i.setClickable(false);
            this.P = false;
            if (this.T == null) {
                this.T = new PathInterpolator(0.3f, 0.0f, 0.67f, 1.0f);
            }
            if (this.R == null) {
                ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this.O, "alpha", 127, 0);
                this.R = objectAnimatorOfInt;
                objectAnimatorOfInt.setInterpolator(this.T);
                this.R.setDuration(230L);
                this.R.addListener(new bb.d(this, 9));
            }
            this.R.start();
        }
    }

    public void setActionBarDropDownView(ActionBarDropDownView actionBarDropDownView) {
        this.f12585j = actionBarDropDownView;
    }

    public void setActionBarFitStatusBar(boolean z10) {
        this.F = z10;
    }

    public void setActionBarHideOffset(int i) {
        j();
        int iMax = Math.max(0, Math.min(i, this.f12584h.getHeight()));
        WeakHashMap weakHashMap = n3.k0.f8724a;
        this.f12584h.setTranslationY(-iMax);
        ActionBarContainer actionBarContainer = this.f12583g;
        if (actionBarContainer == null || actionBarContainer.getVisibility() == 8) {
            return;
        }
        this.f12583g.setTranslationY((int) (this.f12583g.getHeight() * (iMax / r0)));
    }

    public void setActionBarVisibilityCallback(i iVar) {
        this.f12600y = iVar;
        if (getWindowToken() != null) {
            ((stepos.support.v7.app.t0) this.f12600y).f12493p = this.f12581c;
            int i = this.f12593r;
            if (i != 0) {
                onWindowSystemUiVisibilityChanged(i);
                WeakHashMap weakHashMap = n3.k0.f8724a;
                requestApplyInsets();
            }
        }
    }

    @Override // stepos.support.v7.widget.b0
    public void setBackTopBackground(Drawable drawable) {
        if (this.I) {
            if (drawable == null) {
                this.i.setBackgroundResource(R.drawable.stepos_list_backtop);
            } else {
                this.O = drawable;
                this.i.setBackground(drawable);
            }
        }
    }

    @Override // stepos.support.v7.widget.b0
    public void setBackTopClickCallback(View.OnClickListener onClickListener) {
        this.i.setOnClickListener(onClickListener);
    }

    @Override // stepos.support.v7.widget.b0
    public void setBackTopEnable(boolean z10) {
        this.I = z10;
        if (z10) {
            this.i.setBackgroundResource(R.drawable.stepos_list_backtop);
        }
    }

    public void setDropDownShowStart(int i) {
        this.E = i;
    }

    public void setFullWindowContent(boolean z10) {
        if (this.H != z10) {
            this.H = z10;
            requestLayout();
        }
    }

    public void setHideOnContentScrollEnabled(boolean z10) {
        if (z10 != this.f12590o) {
            this.f12590o = z10;
            if (z10) {
                return;
            }
            j();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i) {
        l();
        this.f12586k.setIcon(i);
    }

    public void setLogo(int i) {
        l();
        this.f12586k.s(i);
    }

    public void setOverlayMode(boolean z10) {
        this.f12589n = z10;
        this.f12588m = z10 && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setSplitBarFitSystemWindows(boolean z10) {
        this.D = z10;
    }

    public void setUiOptions(int i) {
        this.G = i;
        int i3 = 0;
        boolean z10 = (i & 1) != 0;
        boolean z11 = z10 ? getContext().getResources().getBoolean(R.bool.stepos_split_action_bar_is_narrow) : this.C;
        boolean z12 = i == 2;
        if (z11 && z12) {
            od.f.e("You can't split action bar and use bottom menu in the same time.");
            return;
        }
        l();
        ActionBarContainer actionBarContainer = this.f12584h;
        ActionBarContextView actionBarContextView = actionBarContainer != null ? (ActionBarContextView) actionBarContainer.findViewById(R.id.action_context_bar) : (ActionBarContextView) findViewById(R.id.action_context_bar);
        if (z11) {
            if (this.f12583g == null || !this.f12586k.v()) {
                Log.e("ActionBarOverlayLayout", "Requested split action bar with incompatible window decor! Ignoring request.");
                return;
            } else {
                this.f12586k.p(this.f12583g);
                actionBarContextView.setSplitView(this.f12583g);
            }
        } else if (z12) {
            ActionBarContainer actionBarContainer2 = this.f12583g;
            if (actionBarContainer2 == null) {
                Log.e("ActionBarOverlayLayout", "Requested split action bar with incompatible window decor! Ignoring request.");
                return;
            }
            this.f12586k.p(actionBarContainer2);
        } else {
            this.f12586k.p(null);
            if (!actionBarContextView.B) {
                actionBarContextView.setSplitView(null);
            }
        }
        this.f12586k.n(z11);
        this.f12586k.y(z12);
        this.f12586k.j(z10);
        actionBarContextView.setSplitToolbar(z11);
        actionBarContextView.setSplitWhenNarrow(z10);
        ActionBarContainer actionBarContainer3 = this.f12583g;
        if (actionBarContainer3 != null) {
            if (!this.f12586k.k() && !actionBarContextView.B && !z12) {
                i3 = 8;
            }
            actionBarContainer3.setVisibility(i3);
        }
    }

    @Override // stepos.support.v7.widget.b0
    public void setWindowCallback(Window.Callback callback) {
        l();
        this.f12586k.setWindowCallback(callback);
    }

    @Override // stepos.support.v7.widget.b0
    public void setWindowTitle(CharSequence charSequence) {
        l();
        this.f12586k.setWindowTitle(charSequence);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public void setIcon(Drawable drawable) {
        l();
        this.f12586k.setIcon(drawable);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new j(layoutParams);
    }

    public void setHasNonEmbeddedTabs(boolean z10) {
    }

    public void setShowingForActionMode(boolean z10) {
    }

    @Deprecated
    public void setTransStatusBarInStepOS3(boolean z10) {
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i, int i3, int[] iArr) {
    }
}

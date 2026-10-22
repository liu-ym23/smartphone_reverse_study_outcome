package stepos.support.v7.widget;

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
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.animation.PathInterpolator;
import android.widget.OverScroller;
import com.stepos.aiengine.R;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import stepos.support.v7.app.o0;
import stepos.support.v7.view.menu.g;
import v0.e0;
import v0.h0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements j {
    public static final int[] T = {R.attr.actionBarSize, android.R.attr.windowContentOverlay, R.attr.steposWindowSplitActionBar, R.attr.steposSplitActionBarFloat, R.attr.steposActionBarFitStatusBar, R.attr.steposActionBarOverlayMode};
    public h0 A;
    public boolean B;
    public boolean C;
    public int D;
    public boolean E;
    public int F;
    public boolean G;
    public boolean H;
    public final a I;
    public final b J;
    public final c K;
    public final d L;
    public final v0.q M;
    public Drawable N;
    public boolean O;
    public ObjectAnimator P;
    public ObjectAnimator Q;
    public PathInterpolator R;
    public PathInterpolator S;

    /* renamed from: a, reason: collision with root package name */
    public int f12475a;

    /* renamed from: b, reason: collision with root package name */
    public FitsWindowsContentLayout f12476b;

    /* renamed from: c, reason: collision with root package name */
    public ActionBarContainer f12477c;

    /* renamed from: d, reason: collision with root package name */
    public ActionBarContainer f12478d;

    /* renamed from: e, reason: collision with root package name */
    public View f12479e;
    public ActionBarDropDownView h;

    /* renamed from: j, reason: collision with root package name */
    public k f12480j;

    /* renamed from: k, reason: collision with root package name */
    public Drawable f12481k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f12482l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f12483m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f12484n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f12485o;

    /* renamed from: p, reason: collision with root package name */
    public int f12486p;

    /* renamed from: q, reason: collision with root package name */
    public int f12487q;
    public final Rect r;

    /* renamed from: s, reason: collision with root package name */
    public final Rect f12488s;

    /* renamed from: t, reason: collision with root package name */
    public final Rect f12489t;

    /* renamed from: u, reason: collision with root package name */
    public final Rect f12490u;

    /* renamed from: v, reason: collision with root package name */
    public final Rect f12491v;

    /* renamed from: w, reason: collision with root package name */
    public final Rect f12492w;

    /* renamed from: x, reason: collision with root package name */
    public e f12493x;

    /* renamed from: y, reason: collision with root package name */
    public androidx.core.widget.d f12494y;
    public h0 z;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends mb.y {
        public a() {
        }

        @Override // mb.y, v0.i0
        public final void c() {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.z = null;
            actionBarOverlayLayout.f12485o = false;
        }

        @Override // mb.y, v0.i0
        public final void d(View view) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.z = null;
            actionBarOverlayLayout.f12485o = false;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b extends mb.y {
        public b() {
        }

        @Override // mb.y, v0.i0
        public final void c() {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.A = null;
            actionBarOverlayLayout.f12485o = false;
        }

        @Override // mb.y, v0.i0
        public final void d(View view) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.A = null;
            actionBarOverlayLayout.f12485o = false;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            int[] iArr = ActionBarOverlayLayout.T;
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.h();
            h0 h0VarA = v0.e0.a(actionBarOverlayLayout.f12478d);
            h0VarA.h(0.0f);
            h0VarA.e(actionBarOverlayLayout.I);
            actionBarOverlayLayout.z = h0VarA;
            ActionBarContainer actionBarContainer = actionBarOverlayLayout.f12477c;
            if (actionBarContainer == null || actionBarContainer.getVisibility() == 8) {
                return;
            }
            h0 h0VarA2 = v0.e0.a(actionBarOverlayLayout.f12477c);
            h0VarA2.h(0.0f);
            h0VarA2.e(actionBarOverlayLayout.J);
            actionBarOverlayLayout.A = h0VarA2;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            int[] iArr = ActionBarOverlayLayout.T;
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.h();
            h0 h0VarA = v0.e0.a(actionBarOverlayLayout.f12478d);
            h0VarA.h(-actionBarOverlayLayout.f12478d.getHeight());
            h0VarA.e(actionBarOverlayLayout.I);
            actionBarOverlayLayout.z = h0VarA;
            ActionBarContainer actionBarContainer = actionBarOverlayLayout.f12477c;
            if (actionBarContainer == null || actionBarContainer.getVisibility() == 8) {
                return;
            }
            h0 h0VarA2 = v0.e0.a(actionBarOverlayLayout.f12477c);
            h0VarA2.h(actionBarOverlayLayout.f12477c.getHeight());
            h0VarA2.e(actionBarOverlayLayout.J);
            actionBarOverlayLayout.A = h0VarA2;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface e {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class f extends ViewGroup.MarginLayoutParams {
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12475a = 0;
        this.f12483m = true;
        this.r = new Rect();
        this.f12488s = new Rect();
        this.f12489t = new Rect();
        this.f12490u = new Rect();
        this.f12491v = new Rect();
        this.f12492w = new Rect();
        this.D = -1;
        this.H = false;
        this.I = new a();
        this.J = new b();
        this.K = new c();
        this.L = new d();
        this.O = false;
        i(context);
        this.M = new v0.q();
    }

    @Override // stepos.support.v7.widget.j
    public final boolean a() {
        j();
        return this.f12480j.a();
    }

    @Override // stepos.support.v7.widget.j
    public final boolean b() {
        j();
        return this.f12480j.b();
    }

    @Override // stepos.support.v7.widget.j
    public final boolean c() {
        j();
        return this.f12480j.c();
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof f;
    }

    @Override // stepos.support.v7.widget.j
    public final boolean d() {
        j();
        return this.f12480j.d();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        super.dispatchApplyWindowInsets(windowInsets);
        j();
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        Insets insets = windowInsets.getInsets(WindowInsets.Type.systemBars());
        rect.set(insets.left, insets.top, insets.right, insets.bottom);
        rect2.set(rect);
        int i10 = windowInsets.getInsets(WindowInsets.Type.ime()).bottom;
        if (i10 > insets.bottom) {
            rect.bottom = i10;
        }
        if (!this.E) {
            rect.top = l8.f.c(getContext());
        }
        boolean z = true;
        boolean zA = g0.a(this.f12478d, rect, true, false);
        this.f12490u.set(rect);
        Rect rect3 = this.r;
        rect3.set(rect);
        ActionBarContainer actionBarContainer = this.f12477c;
        if (actionBarContainer != null) {
            zA |= g0.a(actionBarContainer, rect2, false, this.C);
            this.f12480j.y(this.f12477c);
        }
        Rect rect4 = this.f12488s;
        if (rect4.equals(rect3)) {
            z = zA;
        } else {
            rect4.set(rect3);
        }
        Rect rect5 = this.f12492w;
        if (z) {
            rect5.setEmpty();
            requestLayout();
        } else if (this.f12483m) {
            this.f12476b.dispatchFitSystemWindows(rect5);
        }
        return windowInsets.consumeSystemWindowInsets();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int translationY;
        super.draw(canvas);
        if (this.f12481k == null || this.f12482l) {
            return;
        }
        if (this.f12478d.getVisibility() == 0) {
            float bottom = this.f12478d.getBottom();
            ActionBarContainer actionBarContainer = this.f12478d;
            WeakHashMap<View, h0> weakHashMap = v0.e0.f13274a;
            translationY = (int) (actionBarContainer.getTranslationY() + bottom + 0.5f);
        } else {
            translationY = 0;
        }
        this.f12481k.setBounds(0, translationY, getWidth(), this.f12481k.getIntrinsicHeight() + translationY);
        this.f12481k.draw(canvas);
    }

    @Override // stepos.support.v7.widget.j
    public final void e() {
        j();
        this.f12480j.e();
    }

    @Override // stepos.support.v7.widget.j
    public final boolean f() {
        j();
        return this.f12480j.f();
    }

    @Override // stepos.support.v7.widget.j
    public final void g(int i10) {
        j();
        if (i10 == 2) {
            this.f12480j.j();
        } else if (i10 == 5) {
            this.f12480j.q();
        } else {
            if (i10 != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new f(-1, -1);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f12478d;
        if (actionBarContainer == null) {
            return 0;
        }
        WeakHashMap<View, h0> weakHashMap = v0.e0.f13274a;
        return -((int) actionBarContainer.getTranslationY());
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        v0.q qVar = this.M;
        return qVar.f13333b | qVar.f13332a;
    }

    public CharSequence getTitle() {
        j();
        return this.f12480j.getTitle();
    }

    public final void h() {
        removeCallbacks(this.K);
        removeCallbacks(this.L);
        h0 h0Var = this.z;
        if (h0Var != null) {
            h0Var.b();
        }
        h0 h0Var2 = this.A;
        if (h0Var2 != null) {
            h0Var2.b();
        }
    }

    public final void i(Context context) {
        int[] iArr = T;
        iArr[0] = R.attr.steposActionBarSizeFullScreen;
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(iArr);
        typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        this.f12481k = drawable;
        setWillNotDraw(drawable == null);
        this.B = typedArrayObtainStyledAttributes.getBoolean(2, false);
        this.C = typedArrayObtainStyledAttributes.getBoolean(3, false);
        this.E = typedArrayObtainStyledAttributes.getBoolean(4, this.E);
        setOverlayMode(typedArrayObtainStyledAttributes.getBoolean(5, this.f12483m));
        typedArrayObtainStyledAttributes.recycle();
        this.f12482l = context.getApplicationInfo().targetSdkVersion < 19;
        androidx.core.widget.d dVar = new androidx.core.widget.d();
        dVar.f1578a = new OverScroller(context);
        this.f12494y = dVar;
    }

    public final void j() {
        k wrapper;
        if (this.f12476b == null) {
            this.f12476b = (FitsWindowsContentLayout) findViewById(R.id.action_bar_activity_content);
            this.f12478d = (ActionBarContainer) findViewById(R.id.action_bar_container);
            KeyEvent.Callback callbackFindViewById = findViewById(R.id.action_bar);
            if (callbackFindViewById instanceof k) {
                wrapper = (k) callbackFindViewById;
            } else {
                if (!(callbackFindViewById instanceof Toolbar)) {
                    throw new IllegalStateException("Can't make a decor toolbar out of ".concat(callbackFindViewById.getClass().getSimpleName()));
                }
                wrapper = ((Toolbar) callbackFindViewById).getWrapper();
            }
            this.f12480j = wrapper;
            this.f12477c = (ActionBarContainer) findViewById(R.id.split_action_bar);
            this.f12479e = findViewById(R.id.stepos_list_backtop_container);
        }
    }

    @Override // stepos.support.v7.widget.j
    public final void m(Menu menu, g.a aVar) {
        j();
        this.f12480j.m(menu, aVar);
    }

    @Override // stepos.support.v7.widget.j
    public final void n() {
        j();
        this.f12480j.l();
    }

    @Override // stepos.support.v7.widget.j
    public final void o() {
        if (!this.H || this.f12479e == null || this.O) {
            return;
        }
        ObjectAnimator objectAnimator = this.P;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.P.cancel();
        }
        this.O = true;
        this.f12479e.setVisibility(0);
        if (this.R == null) {
            this.R = new PathInterpolator(0.3f, 0.0f, 0.67f, 1.0f);
        }
        if (this.P == null) {
            ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this.N, "alpha", 0, 255);
            this.P = objectAnimatorOfInt;
            objectAnimatorOfInt.setInterpolator(this.R);
            this.P.setDuration(150L);
        }
        this.P.start();
        this.f12479e.setClickable(true);
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        i(getContext());
        WeakHashMap<View, h0> weakHashMap = v0.e0.f13274a;
        e0.c.b(this);
        setUiOptions(this.F);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i10, int i11, int i12, int i13) throws Resources.NotFoundException {
        int measuredHeight;
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = (i12 - i10) - getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = (i13 - i11) - getPaddingBottom();
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight2 = childAt.getMeasuredHeight();
                int i15 = ((ViewGroup.MarginLayoutParams) fVar).leftMargin + paddingLeft;
                ActionBarContainer actionBarContainer = this.f12477c;
                if (childAt == actionBarContainer) {
                    measuredHeight = (paddingBottom - measuredHeight2) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin;
                } else if (childAt == this.f12479e) {
                    measuredHeight = ((paddingBottom - measuredHeight2) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin) - ((actionBarContainer == null || actionBarContainer.getVisibility() == 8) ? 0 : this.f12477c.getMeasuredHeight());
                    i15 = (paddingRight - measuredWidth) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin;
                } else {
                    measuredHeight = paddingTop + ((ViewGroup.MarginLayoutParams) fVar).topMargin;
                }
                childAt.layout(i15, measuredHeight, measuredWidth + i15, measuredHeight2 + measuredHeight);
            }
        }
        WeakHashMap<View, h0> weakHashMap = v0.e0.f13274a;
        int layoutDirection = getLayoutDirection();
        int measuredWidth2 = this.f12479e.getMeasuredWidth();
        int measuredHeight3 = this.f12479e.getMeasuredHeight();
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.stepos_list_backtop_btn_margin_right);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.stepos_list_backtop_btn_margin_bottom);
        if (layoutDirection == 1) {
            int paddingLeft2 = getPaddingLeft() + dimensionPixelSize;
            int height = ((getHeight() - getPaddingBottom()) - dimensionPixelSize2) - measuredHeight3;
            this.f12479e.layout(paddingLeft2, height, measuredWidth2 + paddingLeft2, measuredHeight3 + height);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i10, int i11) {
        int measuredHeight;
        ActionBarContainer actionBarContainer;
        int i12;
        j();
        View view = this.f12479e;
        if (view != null && view.getVisibility() != 8) {
            measureChildWithMargins(this.f12479e, i10, 0, i11, 0);
        }
        measureChildWithMargins(this.f12478d, i10, 0, i11, 0);
        f fVar = (f) this.f12478d.getLayoutParams();
        int measuredHeight2 = 0;
        int iMax = Math.max(0, this.f12478d.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin + ((ViewGroup.MarginLayoutParams) fVar).rightMargin);
        int iMax2 = Math.max(0, this.f12478d.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) fVar).topMargin + ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
        ActionBarContainer actionBarContainer2 = this.f12478d;
        WeakHashMap<View, h0> weakHashMap = v0.e0.f13274a;
        int measuredState = actionBarContainer2.getMeasuredState();
        Method method = g0.f12796a;
        ActionBarContainer actionBarContainer3 = this.f12477c;
        if (actionBarContainer3 != null) {
            measureChildWithMargins(actionBarContainer3, i10, 0, i11, 0);
            f fVar2 = (f) this.f12477c.getLayoutParams();
            iMax = Math.max(iMax, this.f12477c.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) fVar2).leftMargin + ((ViewGroup.MarginLayoutParams) fVar2).rightMargin);
            iMax2 = Math.max(iMax2, this.f12477c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) fVar2).topMargin + ((ViewGroup.MarginLayoutParams) fVar2).bottomMargin);
            measuredState |= this.f12477c.getMeasuredState();
        }
        View viewFindViewById = findViewById(R.id.top_shadow_mask);
        if (viewFindViewById != null) {
            measureChildWithMargins(viewFindViewById, i10, 0, i11, 0);
        }
        int visibility = this.f12478d.getVisibility();
        Rect rect = this.f12490u;
        if (visibility != 8) {
            measuredHeight = this.f12478d.getMeasuredHeight();
            int i13 = rect.top;
            if (measuredHeight > i13) {
                measuredHeight -= i13;
            }
        } else {
            measuredHeight = 0;
        }
        if ((this.f12480j.x() || this.f12480j.r() || this.f12480j.B()) && (actionBarContainer = this.f12477c) != null && actionBarContainer.getVisibility() != 8 && (measuredHeight2 = this.f12477c.getMeasuredHeight()) > (i12 = rect.bottom)) {
            measuredHeight2 -= i12;
        }
        Rect rect2 = this.r;
        Rect rect3 = this.f12489t;
        rect3.set(rect2);
        Rect rect4 = this.f12491v;
        rect4.set(rect);
        if (this.f12483m) {
            rect4.top += measuredHeight;
            rect4.bottom += measuredHeight2;
            rect3.setEmpty();
        } else {
            rect3.top += measuredHeight;
            rect3.bottom += measuredHeight2;
            rect4.setEmpty();
        }
        ViewGroup.LayoutParams layoutParams = this.f12476b.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int i14 = marginLayoutParams.leftMargin;
            int i15 = rect3.left;
            if (i14 != i15) {
                marginLayoutParams.leftMargin = i15;
            }
            int i16 = marginLayoutParams.topMargin;
            int i17 = rect3.top;
            if (i16 != i17) {
                marginLayoutParams.topMargin = i17;
            }
            int i18 = marginLayoutParams.rightMargin;
            int i19 = rect3.right;
            if (i18 != i19) {
                marginLayoutParams.rightMargin = i19;
            }
            int i20 = marginLayoutParams.bottomMargin;
            int i21 = rect3.bottom;
            if (i20 != i21) {
                marginLayoutParams.bottomMargin = i21;
            }
        }
        Rect rect5 = this.f12492w;
        if (!rect5.equals(rect4)) {
            rect5.set(rect4);
            this.f12476b.dispatchFitSystemWindows(rect4);
        }
        measureChildWithMargins(this.f12476b, i10, 0, i11, 0);
        f fVar3 = (f) this.f12476b.getLayoutParams();
        int iMax3 = Math.max(iMax, this.f12476b.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) fVar3).leftMargin + ((ViewGroup.MarginLayoutParams) fVar3).rightMargin);
        int iMax4 = Math.max(iMax2, this.f12476b.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) fVar3).topMargin + ((ViewGroup.MarginLayoutParams) fVar3).bottomMargin);
        int measuredState2 = measuredState | this.f12476b.getMeasuredState();
        ActionBarDropDownView actionBarDropDownView = this.h;
        if (actionBarDropDownView != null && actionBarDropDownView.getVisibility() != 8) {
            if (this.f12483m) {
                rect3 = rect4;
            }
            int i22 = this.D;
            if (i22 != -1) {
                rect3.top = i22;
            }
            g0.a(this.h, rect3, true, true);
            measureChildWithMargins(this.h, i10, 0, i11, 0);
            measuredState2 |= this.h.getMeasuredState();
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(getPaddingRight() + getPaddingLeft() + iMax3, getSuggestedMinimumWidth()), i10, measuredState2), View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + iMax4, getSuggestedMinimumHeight()), i11, measuredState2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f8, float f9, boolean z) {
        if (!this.f12484n || !z) {
            return false;
        }
        this.f12494y.f1578a.fling(0, 0, 0, (int) f9, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (this.f12494y.f1578a.getFinalY() > this.f12478d.getHeight()) {
            h();
            this.L.run();
        } else {
            h();
            this.K.run();
        }
        this.f12485o = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f8, float f9) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i10, int i11, int i12, int i13) {
        int i14 = this.f12486p + i11;
        this.f12486p = i14;
        setActionBarHideOffset(i14);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i10) {
        o0 o0Var;
        k.g gVar;
        this.M.f13332a = i10;
        this.f12486p = getActionBarHideOffset();
        h();
        e eVar = this.f12493x;
        if (eVar == null || (gVar = (o0Var = (o0) eVar).f12191u) == null) {
            return;
        }
        gVar.a();
        o0Var.f12191u = null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i10) {
        if ((i10 & 2) == 0 || this.f12478d.getVisibility() != 0) {
            return false;
        }
        return this.f12484n;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        if (!this.f12484n || this.f12485o) {
            return;
        }
        if (this.f12486p <= this.f12478d.getHeight()) {
            h();
            postDelayed(this.K, 600L);
        } else {
            h();
            postDelayed(this.L, 600L);
        }
    }

    @Override // android.view.View
    public final void onWindowSystemUiVisibilityChanged(int i10) {
        super.onWindowSystemUiVisibilityChanged(i10);
        j();
        int i11 = this.f12487q ^ i10;
        this.f12487q = i10;
        boolean z = (i10 & 4) == 0;
        boolean z3 = (i10 & 256) != 0;
        e eVar = this.f12493x;
        if (eVar != null) {
            o0 o0Var = (o0) eVar;
            o0Var.f12188q = !z3;
            if (z || !z3) {
                if (o0Var.r) {
                    o0Var.r = false;
                    o0Var.x(true);
                }
            } else if (!o0Var.r) {
                o0Var.r = true;
                o0Var.x(true);
            }
        }
        if ((i11 & 256) == 0 || this.f12493x == null) {
            return;
        }
        WeakHashMap<View, h0> weakHashMap = v0.e0.f13274a;
        e0.c.b(this);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        this.f12475a = i10;
        e eVar = this.f12493x;
        if (eVar != null) {
            ((o0) eVar).f12187p = i10;
        }
    }

    @Override // stepos.support.v7.widget.j
    public final void q(Menu menu, g.a aVar) {
        j();
        this.f12480j.A(menu, aVar);
        if (this.f12480j.r() && menu == null) {
            this.f12480j.D(false);
        }
    }

    @Override // stepos.support.v7.widget.j
    public final void r() {
        if (this.H && this.f12479e != null && this.O) {
            ObjectAnimator objectAnimator = this.Q;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.Q.cancel();
            }
            this.f12479e.setClickable(false);
            this.O = false;
            if (this.S == null) {
                this.S = new PathInterpolator(0.3f, 0.0f, 0.67f, 1.0f);
            }
            if (this.Q == null) {
                ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this.N, "alpha", 127, 0);
                this.Q = objectAnimatorOfInt;
                objectAnimatorOfInt.setInterpolator(this.S);
                this.Q.setDuration(230L);
                this.Q.addListener(new com.google.android.material.appbar.h(this, 7));
            }
            this.Q.start();
        }
    }

    public void setActionBarDropDownView(ActionBarDropDownView actionBarDropDownView) {
        this.h = actionBarDropDownView;
    }

    public void setActionBarFitStatusBar(boolean z) {
        this.E = z;
    }

    public void setActionBarHideOffset(int i10) {
        h();
        int iMax = Math.max(0, Math.min(i10, this.f12478d.getHeight()));
        WeakHashMap<View, h0> weakHashMap = v0.e0.f13274a;
        this.f12478d.setTranslationY(-iMax);
        ActionBarContainer actionBarContainer = this.f12477c;
        if (actionBarContainer == null || actionBarContainer.getVisibility() == 8) {
            return;
        }
        this.f12477c.setTranslationY((int) (this.f12477c.getHeight() * (iMax / r0)));
    }

    public void setActionBarVisibilityCallback(e eVar) {
        this.f12493x = eVar;
        if (getWindowToken() != null) {
            ((o0) this.f12493x).f12187p = this.f12475a;
            int i10 = this.f12487q;
            if (i10 != 0) {
                onWindowSystemUiVisibilityChanged(i10);
                WeakHashMap<View, h0> weakHashMap = v0.e0.f13274a;
                e0.c.b(this);
            }
        }
    }

    @Override // stepos.support.v7.widget.j
    public void setBackTopBackground(Drawable drawable) {
        if (this.H) {
            if (drawable == null) {
                this.f12479e.setBackgroundResource(R.drawable.stepos_list_backtop);
            } else {
                this.N = drawable;
                this.f12479e.setBackground(drawable);
            }
        }
    }

    @Override // stepos.support.v7.widget.j
    public void setBackTopClickCallback(View.OnClickListener onClickListener) {
        this.f12479e.setOnClickListener(onClickListener);
    }

    @Override // stepos.support.v7.widget.j
    public void setBackTopEnable(boolean z) {
        this.H = z;
        if (z) {
            this.f12479e.setBackgroundResource(R.drawable.stepos_list_backtop);
        }
    }

    public void setDropDownShowStart(int i10) {
        this.D = i10;
    }

    public void setFullWindowContent(boolean z) {
        if (this.G != z) {
            this.G = z;
            requestLayout();
        }
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.f12484n) {
            this.f12484n = z;
            if (z) {
                return;
            }
            h();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i10) {
        j();
        this.f12480j.setIcon(i10);
    }

    public void setLogo(int i10) {
        j();
        this.f12480j.o(i10);
    }

    public void setOverlayMode(boolean z) {
        this.f12483m = z;
        this.f12482l = z && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setSplitBarFitSystemWindows(boolean z) {
        this.C = z;
    }

    public void setUiOptions(int i10) {
        this.F = i10;
        int i11 = 0;
        boolean z = (i10 & 1) != 0;
        boolean z3 = z ? getContext().getResources().getBoolean(R.bool.stepos_split_action_bar_is_narrow) : this.B;
        boolean z10 = i10 == 2;
        if (z3 && z10) {
            throw new IllegalStateException("You can't split action bar and use bottom menu in the same time.");
        }
        j();
        ActionBarContainer actionBarContainer = this.f12478d;
        ActionBarContextView actionBarContextView = actionBarContainer != null ? (ActionBarContextView) actionBarContainer.findViewById(R.id.action_context_bar) : (ActionBarContextView) findViewById(R.id.action_context_bar);
        if (z3) {
            if (this.f12477c == null || !this.f12480j.C()) {
                Log.e("ActionBarOverlayLayout", "Requested split action bar with incompatible window decor! Ignoring request.");
                return;
            } else {
                this.f12480j.z(this.f12477c);
                actionBarContextView.setSplitView(this.f12477c);
            }
        } else if (z10) {
            ActionBarContainer actionBarContainer2 = this.f12477c;
            if (actionBarContainer2 == null) {
                Log.e("ActionBarOverlayLayout", "Requested split action bar with incompatible window decor! Ignoring request.");
                return;
            }
            this.f12480j.z(actionBarContainer2);
        } else {
            this.f12480j.z(null);
            if (!actionBarContextView.A) {
                actionBarContextView.setSplitView(null);
            }
        }
        this.f12480j.s(z3);
        this.f12480j.D(z10);
        this.f12480j.w(z);
        actionBarContextView.setSplitToolbar(z3);
        actionBarContextView.setSplitWhenNarrow(z);
        ActionBarContainer actionBarContainer3 = this.f12477c;
        if (actionBarContainer3 != null) {
            if (!this.f12480j.x() && !actionBarContextView.A && !z10) {
                i11 = 8;
            }
            actionBarContainer3.setVisibility(i11);
        }
    }

    @Override // stepos.support.v7.widget.j
    public void setWindowCallback(Window.Callback callback) {
        j();
        this.f12480j.setWindowCallback(callback);
    }

    @Override // stepos.support.v7.widget.j
    public void setWindowTitle(CharSequence charSequence) {
        j();
        this.f12480j.setWindowTitle(charSequence);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new f(layoutParams);
    }

    public void setIcon(Drawable drawable) {
        j();
        this.f12480j.setIcon(drawable);
    }

    public void setHasNonEmbeddedTabs(boolean z) {
    }

    public void setShowingForActionMode(boolean z) {
    }

    @Deprecated
    public void setTransStatusBarInStepOS3(boolean z) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i10, int i11, int[] iArr) {
    }
}

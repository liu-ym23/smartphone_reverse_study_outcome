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
import androidx.appcompat.R;
import androidx.appcompat.view.ViewPropertyAnimatorCompatSet;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.widget.ScrollerCompat;
import java.lang.reflect.Method;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes4.dex */
public class ActionBarOverlayLayout extends ViewGroup implements H, NestedScrollingParent {

    /* renamed from: U, reason: collision with root package name */
    public static final int[] f6417U = {R.attr.actionBarSize, android.R.attr.windowContentOverlay, com.stepos.ability.R.attr.steposWindowSplitActionBar, com.stepos.ability.R.attr.steposSplitActionBarFloat, com.stepos.ability.R.attr.steposActionBarFitStatusBar, com.stepos.ability.R.attr.steposActionBarOverlayMode};

    /* renamed from: A, reason: collision with root package name */
    public int f6418A;

    /* renamed from: B, reason: collision with root package name */
    public boolean f6419B;

    /* renamed from: C, reason: collision with root package name */
    public int f6420C;

    /* renamed from: D, reason: collision with root package name */
    public boolean f6421D;
    public boolean E;

    /* renamed from: F, reason: collision with root package name */
    public final C1993i f6422F;

    /* renamed from: G, reason: collision with root package name */
    public final C1993i f6423G;

    /* renamed from: L, reason: collision with root package name */
    public final RunnableC1995j f6424L;

    /* renamed from: M, reason: collision with root package name */
    public final RunnableC1995j f6425M;

    /* renamed from: N, reason: collision with root package name */
    public final NestedScrollingParentHelper f6426N;

    /* renamed from: O, reason: collision with root package name */
    public Drawable f6427O;

    /* renamed from: P, reason: collision with root package name */
    public boolean f6428P;

    /* renamed from: Q, reason: collision with root package name */
    public ObjectAnimator f6429Q;

    /* renamed from: R, reason: collision with root package name */
    public ObjectAnimator f6430R;

    /* renamed from: S, reason: collision with root package name */
    public PathInterpolator f6431S;

    /* renamed from: T, reason: collision with root package name */
    public PathInterpolator f6432T;

    /* renamed from: a, reason: collision with root package name */
    public int f6433a;
    public FitsWindowsContentLayout b;
    public ActionBarContainer c;
    public ActionBarContainer d;
    public View e;
    public ActionBarDropDownView f;
    public I g;
    public Drawable h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f6434j;
    public boolean k;
    public boolean l;
    public int m;
    public int n;
    public final Rect o;
    public final Rect p;

    /* renamed from: q, reason: collision with root package name */
    public final Rect f6435q;

    /* renamed from: r, reason: collision with root package name */
    public final Rect f6436r;

    /* renamed from: s, reason: collision with root package name */
    public final Rect f6437s;

    /* renamed from: t, reason: collision with root package name */
    public final Rect f6438t;
    public InterfaceC1996k u;

    /* renamed from: v, reason: collision with root package name */
    public ScrollerCompat f6439v;

    /* renamed from: w, reason: collision with root package name */
    public ViewPropertyAnimatorCompat f6440w;

    /* renamed from: x, reason: collision with root package name */
    public ViewPropertyAnimatorCompat f6441x;
    public boolean y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f6442z;

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6433a = 0;
        this.f6434j = true;
        this.o = new Rect();
        this.p = new Rect();
        this.f6435q = new Rect();
        this.f6436r = new Rect();
        this.f6437s = new Rect();
        this.f6438t = new Rect();
        this.f6418A = -1;
        this.E = false;
        this.f6422F = new C1993i(this, 0);
        this.f6423G = new C1993i(this, 1);
        this.f6424L = new RunnableC1995j(this, 0);
        this.f6425M = new RunnableC1995j(this, 1);
        this.f6428P = false;
        f(context);
        this.f6426N = new NestedScrollingParentHelper(this);
    }

    @Override // stepos.support.v7.widget.H
    public final void a(Menu menu, Va.A a3) {
        g();
        this.g.a(menu, a3);
    }

    @Override // stepos.support.v7.widget.H
    public final void b() {
        if (!this.E || this.e == null || this.f6428P) {
            return;
        }
        ObjectAnimator objectAnimator = this.f6429Q;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.f6429Q.cancel();
        }
        this.f6428P = true;
        this.e.setVisibility(0);
        if (this.f6431S == null) {
            this.f6431S = new PathInterpolator(0.3f, 0.0f, 0.67f, 1.0f);
        }
        if (this.f6429Q == null) {
            ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this.f6427O, "alpha", 0, 255);
            this.f6429Q = objectAnimatorOfInt;
            objectAnimatorOfInt.setInterpolator(this.f6431S);
            this.f6429Q.setDuration(150L);
        }
        this.f6429Q.start();
        this.e.setClickable(true);
    }

    @Override // stepos.support.v7.widget.H
    public final void c(Menu menu, Va.A a3) {
        g();
        this.g.g(menu, a3);
        if (this.g.b() && menu == null) {
            this.g.m(false);
        }
    }

    @Override // stepos.support.v7.widget.H
    public final boolean canShowOverflowMenu() {
        g();
        return this.g.canShowOverflowMenu();
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C1997l;
    }

    @Override // stepos.support.v7.widget.H
    public final void d() {
        if (this.E && this.e != null && this.f6428P) {
            ObjectAnimator objectAnimator = this.f6430R;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.f6430R.cancel();
            }
            this.e.setClickable(false);
            this.f6428P = false;
            if (this.f6432T == null) {
                this.f6432T = new PathInterpolator(0.3f, 0.0f, 0.67f, 1.0f);
            }
            if (this.f6430R == null) {
                ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this.f6427O, "alpha", 127, 0);
                this.f6430R = objectAnimatorOfInt;
                objectAnimatorOfInt.setInterpolator(this.f6432T);
                this.f6430R.setDuration(230L);
                this.f6430R.addListener(new A6.m(this, 10));
            }
            this.f6430R.start();
        }
    }

    @Override // stepos.support.v7.widget.H
    public final void dismissPopups() {
        g();
        this.g.dismissPopupMenus();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        super.dispatchApplyWindowInsets(windowInsets);
        g();
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        Insets insets = windowInsets.getInsets(WindowInsets.Type.systemBars());
        rect.set(insets.left, insets.top, insets.right, insets.bottom);
        rect2.set(rect);
        int i = windowInsets.getInsets(WindowInsets.Type.ime()).bottom;
        if (i > insets.bottom) {
            rect.bottom = i;
        }
        if (!this.f6419B) {
            rect.top = a5.l.f(getContext());
        }
        boolean z10 = true;
        boolean zA = I0.a(this.d, rect, true, false);
        this.f6436r.set(rect);
        Rect rect3 = this.o;
        rect3.set(rect);
        ActionBarContainer actionBarContainer = this.c;
        if (actionBarContainer != null) {
            zA |= I0.a(actionBarContainer, rect2, false, this.f6442z);
            this.g.f(this.c);
        }
        Rect rect4 = this.p;
        if (rect4.equals(rect3)) {
            z10 = zA;
        } else {
            rect4.set(rect3);
        }
        Rect rect5 = this.f6438t;
        if (z10) {
            rect5.setEmpty();
            requestLayout();
        } else if (this.f6434j) {
            this.b.dispatchFitSystemWindows(rect5);
        }
        return windowInsets.consumeSystemWindowInsets();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int translationY;
        super.draw(canvas);
        if (this.h == null || this.i) {
            return;
        }
        if (this.d.getVisibility() == 0) {
            translationY = (int) (ViewCompat.getTranslationY(this.d) + this.d.getBottom() + 0.5f);
        } else {
            translationY = 0;
        }
        this.h.setBounds(0, translationY, getWidth(), this.h.getIntrinsicHeight() + translationY);
        this.h.draw(canvas);
    }

    public final void e() {
        removeCallbacks(this.f6424L);
        removeCallbacks(this.f6425M);
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.f6440w;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.cancel();
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = this.f6441x;
        if (viewPropertyAnimatorCompat2 != null) {
            viewPropertyAnimatorCompat2.cancel();
        }
    }

    public final void f(Context context) {
        int[] iArr = f6417U;
        iArr[0] = com.stepos.ability.R.attr.steposActionBarSizeFullScreen;
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(iArr);
        typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        this.h = drawable;
        setWillNotDraw(drawable == null);
        this.y = typedArrayObtainStyledAttributes.getBoolean(2, false);
        this.f6442z = typedArrayObtainStyledAttributes.getBoolean(3, false);
        this.f6419B = typedArrayObtainStyledAttributes.getBoolean(4, this.f6419B);
        setOverlayMode(typedArrayObtainStyledAttributes.getBoolean(5, this.f6434j));
        typedArrayObtainStyledAttributes.recycle();
        this.i = context.getApplicationInfo().targetSdkVersion < 19;
        this.f6439v = ScrollerCompat.create(context);
    }

    public final void g() {
        I wrapper;
        if (this.b == null) {
            this.b = (FitsWindowsContentLayout) findViewById(R.id.action_bar_activity_content);
            this.d = (ActionBarContainer) findViewById(com.stepos.ability.R.id.action_bar_container);
            KeyEvent.Callback callbackFindViewById = findViewById(com.stepos.ability.R.id.action_bar);
            if (callbackFindViewById instanceof I) {
                wrapper = (I) callbackFindViewById;
            } else {
                if (!(callbackFindViewById instanceof Toolbar)) {
                    throw new IllegalStateException("Can't make a decor toolbar out of ".concat(callbackFindViewById.getClass().getSimpleName()));
                }
                wrapper = ((Toolbar) callbackFindViewById).getWrapper();
            }
            this.g = wrapper;
            this.c = (ActionBarContainer) findViewById(com.stepos.ability.R.id.split_action_bar);
            this.e = findViewById(com.stepos.ability.R.id.stepos_list_backtop_container);
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new C1997l(-1, -1);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C1997l(getContext(), attributeSet);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.d;
        if (actionBarContainer != null) {
            return -((int) ViewCompat.getTranslationY(actionBarContainer));
        }
        return 0;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.f6426N.getNestedScrollAxes();
    }

    public CharSequence getTitle() {
        g();
        return this.g.getTitle();
    }

    @Override // stepos.support.v7.widget.H
    public final boolean hideOverflowMenu() {
        g();
        return this.g.hideOverflowMenu();
    }

    @Override // stepos.support.v7.widget.H
    public final void initFeature(int i) {
        g();
        if (i == 2) {
            this.g.initProgress();
        } else if (i == 5) {
            this.g.initIndeterminateProgress();
        } else {
            if (i != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    @Override // stepos.support.v7.widget.H
    public final boolean isOverflowMenuShowPending() {
        g();
        return this.g.isOverflowMenuShowPending();
    }

    @Override // stepos.support.v7.widget.H
    public final boolean isOverflowMenuShowing() {
        g();
        return this.g.isOverflowMenuShowing();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        f(getContext());
        ViewCompat.requestApplyInsets(this);
        setUiOptions(this.f6420C);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i, int i6, int i10, int i11) throws Resources.NotFoundException {
        int measuredHeight;
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = (i10 - i) - getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = (i11 - i6) - getPaddingBottom();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                C1997l c1997l = (C1997l) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight2 = childAt.getMeasuredHeight();
                int i13 = ((ViewGroup.MarginLayoutParams) c1997l).leftMargin + paddingLeft;
                ActionBarContainer actionBarContainer = this.c;
                if (childAt == actionBarContainer) {
                    measuredHeight = (paddingBottom - measuredHeight2) - ((ViewGroup.MarginLayoutParams) c1997l).bottomMargin;
                } else if (childAt == this.e) {
                    measuredHeight = ((paddingBottom - measuredHeight2) - ((ViewGroup.MarginLayoutParams) c1997l).bottomMargin) - ((actionBarContainer == null || actionBarContainer.getVisibility() == 8) ? 0 : this.c.getMeasuredHeight());
                    i13 = (paddingRight - measuredWidth) - ((ViewGroup.MarginLayoutParams) c1997l).rightMargin;
                } else {
                    measuredHeight = paddingTop + ((ViewGroup.MarginLayoutParams) c1997l).topMargin;
                }
                childAt.layout(i13, measuredHeight, measuredWidth + i13, measuredHeight2 + measuredHeight);
            }
        }
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int measuredWidth2 = this.e.getMeasuredWidth();
        int measuredHeight3 = this.e.getMeasuredHeight();
        int dimensionPixelSize = getResources().getDimensionPixelSize(com.stepos.ability.R.dimen.stepos_list_backtop_btn_margin_right);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(com.stepos.ability.R.dimen.stepos_list_backtop_btn_margin_bottom);
        if (layoutDirection == 1) {
            int paddingLeft2 = getPaddingLeft() + dimensionPixelSize;
            int height = ((getHeight() - getPaddingBottom()) - dimensionPixelSize2) - measuredHeight3;
            this.e.layout(paddingLeft2, height, measuredWidth2 + paddingLeft2, measuredHeight3 + height);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i6) {
        int measuredHeight;
        ActionBarContainer actionBarContainer;
        int i10;
        g();
        View view = this.e;
        if (view != null && view.getVisibility() != 8) {
            measureChildWithMargins(this.e, i, 0, i6, 0);
        }
        measureChildWithMargins(this.d, i, 0, i6, 0);
        C1997l c1997l = (C1997l) this.d.getLayoutParams();
        int measuredHeight2 = 0;
        int iMax = Math.max(0, this.d.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) c1997l).leftMargin + ((ViewGroup.MarginLayoutParams) c1997l).rightMargin);
        int iMax2 = Math.max(0, this.d.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) c1997l).topMargin + ((ViewGroup.MarginLayoutParams) c1997l).bottomMargin);
        int measuredState = ViewCompat.getMeasuredState(this.d);
        Method method = I0.f6469a;
        ActionBarContainer actionBarContainer2 = this.c;
        if (actionBarContainer2 != null) {
            measureChildWithMargins(actionBarContainer2, i, 0, i6, 0);
            C1997l c1997l2 = (C1997l) this.c.getLayoutParams();
            iMax = Math.max(iMax, this.c.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) c1997l2).leftMargin + ((ViewGroup.MarginLayoutParams) c1997l2).rightMargin);
            iMax2 = Math.max(iMax2, this.c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) c1997l2).topMargin + ((ViewGroup.MarginLayoutParams) c1997l2).bottomMargin);
            measuredState |= ViewCompat.getMeasuredState(this.c);
        }
        View viewFindViewById = findViewById(com.stepos.ability.R.id.top_shadow_mask);
        if (viewFindViewById != null) {
            measureChildWithMargins(viewFindViewById, i, 0, i6, 0);
        }
        int visibility = this.d.getVisibility();
        Rect rect = this.f6436r;
        if (visibility != 8) {
            measuredHeight = this.d.getMeasuredHeight();
            int i11 = rect.top;
            if (measuredHeight > i11) {
                measuredHeight -= i11;
            }
        } else {
            measuredHeight = 0;
        }
        if ((this.g.e() || this.g.b() || this.g.j()) && (actionBarContainer = this.c) != null && actionBarContainer.getVisibility() != 8 && (measuredHeight2 = this.c.getMeasuredHeight()) > (i10 = rect.bottom)) {
            measuredHeight2 -= i10;
        }
        Rect rect2 = this.o;
        Rect rect3 = this.f6435q;
        rect3.set(rect2);
        Rect rect4 = this.f6437s;
        rect4.set(rect);
        if (this.f6434j) {
            rect4.top += measuredHeight;
            rect4.bottom += measuredHeight2;
            rect3.setEmpty();
        } else {
            rect3.top += measuredHeight;
            rect3.bottom += measuredHeight2;
            rect4.setEmpty();
        }
        ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
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
        Rect rect5 = this.f6438t;
        if (!rect5.equals(rect4)) {
            rect5.set(rect4);
            this.b.dispatchFitSystemWindows(rect4);
        }
        measureChildWithMargins(this.b, i, 0, i6, 0);
        C1997l c1997l3 = (C1997l) this.b.getLayoutParams();
        int iMax3 = Math.max(iMax, this.b.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) c1997l3).leftMargin + ((ViewGroup.MarginLayoutParams) c1997l3).rightMargin);
        int iMax4 = Math.max(iMax2, this.b.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) c1997l3).topMargin + ((ViewGroup.MarginLayoutParams) c1997l3).bottomMargin);
        int measuredState2 = measuredState | ViewCompat.getMeasuredState(this.b);
        ActionBarDropDownView actionBarDropDownView = this.f;
        if (actionBarDropDownView != null && actionBarDropDownView.getVisibility() != 8) {
            if (this.f6434j) {
                rect3 = rect4;
            }
            int i20 = this.f6418A;
            if (i20 != -1) {
                rect3.top = i20;
            }
            I0.a(this.f, rect3, true, true);
            measureChildWithMargins(this.f, i, 0, i6, 0);
            measuredState2 |= ViewCompat.getMeasuredState(this.f);
        }
        setMeasuredDimension(ViewCompat.resolveSizeAndState(Math.max(getPaddingRight() + getPaddingLeft() + iMax3, getSuggestedMinimumWidth()), i, measuredState2), ViewCompat.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + iMax4, getSuggestedMinimumHeight()), i6, measuredState2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedFling(View view, float f, float f7, boolean z10) {
        if (!this.k || !z10) {
            return false;
        }
        this.f6439v.fling(0, 0, 0, (int) f7, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (this.f6439v.getFinalY() > this.d.getHeight()) {
            e();
            this.f6425M.run();
        } else {
            e();
            this.f6424L.run();
        }
        this.l = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedPreFling(View view, float f, float f7) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedPreScroll(View view, int i, int i6, int[] iArr) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedScroll(View view, int i, int i6, int i10, int i11) {
        int i12 = this.m + i6;
        this.m = i12;
        setActionBarHideOffset(i12);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedScrollAccepted(View view, View view2, int i) {
        stepos.support.v7.app.e0 e0Var;
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet;
        this.f6426N.onNestedScrollAccepted(view, view2, i);
        this.m = getActionBarHideOffset();
        e();
        InterfaceC1996k interfaceC1996k = this.u;
        if (interfaceC1996k == null || (viewPropertyAnimatorCompatSet = (e0Var = (stepos.support.v7.app.e0) interfaceC1996k).u) == null) {
            return;
        }
        viewPropertyAnimatorCompatSet.cancel();
        e0Var.u = null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.d.getVisibility() != 0) {
            return false;
        }
        return this.k;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onStopNestedScroll(View view) {
        if (!this.k || this.l) {
            return;
        }
        if (this.m <= this.d.getHeight()) {
            e();
            postDelayed(this.f6424L, 600L);
        } else {
            e();
            postDelayed(this.f6425M, 600L);
        }
    }

    @Override // android.view.View
    public final void onWindowSystemUiVisibilityChanged(int i) {
        super.onWindowSystemUiVisibilityChanged(i);
        g();
        int i6 = this.n ^ i;
        this.n = i;
        boolean z10 = (i & 4) == 0;
        boolean z11 = (i & 256) != 0;
        InterfaceC1996k interfaceC1996k = this.u;
        if (interfaceC1996k != null) {
            stepos.support.v7.app.e0 e0Var = (stepos.support.v7.app.e0) interfaceC1996k;
            e0Var.f6304q = !z11;
            if (z10 || !z11) {
                if (e0Var.f6305r) {
                    e0Var.f6305r = false;
                    e0Var.z(true);
                }
            } else if (!e0Var.f6305r) {
                e0Var.f6305r = true;
                e0Var.z(true);
            }
        }
        if ((i6 & 256) == 0 || this.u == null) {
            return;
        }
        ViewCompat.requestApplyInsets(this);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.f6433a = i;
        InterfaceC1996k interfaceC1996k = this.u;
        if (interfaceC1996k != null) {
            ((stepos.support.v7.app.e0) interfaceC1996k).p = i;
        }
    }

    public void setActionBarDropDownView(ActionBarDropDownView actionBarDropDownView) {
        this.f = actionBarDropDownView;
    }

    public void setActionBarFitStatusBar(boolean z10) {
        this.f6419B = z10;
    }

    public void setActionBarHideOffset(int i) {
        e();
        int iMax = Math.max(0, Math.min(i, this.d.getHeight()));
        ViewCompat.setTranslationY(this.d, -iMax);
        ActionBarContainer actionBarContainer = this.c;
        if (actionBarContainer == null || actionBarContainer.getVisibility() == 8) {
            return;
        }
        ViewCompat.setTranslationY(this.c, (int) (this.c.getHeight() * (iMax / r0)));
    }

    public void setActionBarVisibilityCallback(InterfaceC1996k interfaceC1996k) {
        this.u = interfaceC1996k;
        if (getWindowToken() != null) {
            ((stepos.support.v7.app.e0) this.u).p = this.f6433a;
            int i = this.n;
            if (i != 0) {
                onWindowSystemUiVisibilityChanged(i);
                ViewCompat.requestApplyInsets(this);
            }
        }
    }

    @Override // stepos.support.v7.widget.H
    public void setBackTopBackground(Drawable drawable) {
        if (this.E) {
            if (drawable == null) {
                this.e.setBackgroundResource(com.stepos.ability.R.drawable.stepos_list_backtop);
            } else {
                this.f6427O = drawable;
                this.e.setBackground(drawable);
            }
        }
    }

    @Override // stepos.support.v7.widget.H
    public void setBackTopClickCallback(View.OnClickListener onClickListener) {
        this.e.setOnClickListener(onClickListener);
    }

    @Override // stepos.support.v7.widget.H
    public void setBackTopEnable(boolean z10) {
        this.E = z10;
        if (z10) {
            this.e.setBackgroundResource(com.stepos.ability.R.drawable.stepos_list_backtop);
        }
    }

    public void setDropDownShowStart(int i) {
        this.f6418A = i;
    }

    public void setFullWindowContent(boolean z10) {
        if (this.f6421D != z10) {
            this.f6421D = z10;
            requestLayout();
        }
    }

    public void setHasNonEmbeddedTabs(boolean z10) {
    }

    public void setHideOnContentScrollEnabled(boolean z10) {
        if (z10 != this.k) {
            this.k = z10;
            if (z10) {
                return;
            }
            e();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i) {
        g();
        this.g.setIcon(i);
    }

    public void setLogo(int i) {
        g();
        this.g.setLogo(i);
    }

    @Override // stepos.support.v7.widget.H
    public final void setMenuPrepared() {
        g();
        this.g.setMenuPrepared();
    }

    public void setOverlayMode(boolean z10) {
        this.f6434j = z10;
        this.i = z10 && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z10) {
    }

    public void setSplitBarFitSystemWindows(boolean z10) {
        this.f6442z = z10;
    }

    @Deprecated
    public void setTransStatusBarInStepOS3(boolean z10) {
    }

    public void setUiOptions(int i) {
        this.f6420C = i;
        int i6 = 0;
        boolean z10 = (i & 1) != 0;
        boolean z11 = z10 ? getContext().getResources().getBoolean(com.stepos.ability.R.bool.stepos_split_action_bar_is_narrow) : this.y;
        boolean z12 = i == 2;
        if (z11 && z12) {
            throw new IllegalStateException("You can't split action bar and use bottom menu in the same time.");
        }
        g();
        ActionBarContainer actionBarContainer = this.d;
        ActionBarContextView actionBarContextView = actionBarContainer != null ? (ActionBarContextView) actionBarContainer.findViewById(com.stepos.ability.R.id.action_context_bar) : (ActionBarContextView) findViewById(com.stepos.ability.R.id.action_context_bar);
        if (z11) {
            if (this.c == null || !this.g.l()) {
                Log.e("ActionBarOverlayLayout", "Requested split action bar with incompatible window decor! Ignoring request.");
                return;
            } else {
                this.g.h(this.c);
                actionBarContextView.setSplitView(this.c);
            }
        } else if (z12) {
            ActionBarContainer actionBarContainer2 = this.c;
            if (actionBarContainer2 == null) {
                Log.e("ActionBarOverlayLayout", "Requested split action bar with incompatible window decor! Ignoring request.");
                return;
            }
            this.g.h(actionBarContainer2);
        } else {
            this.g.h(null);
            if (!actionBarContextView.f6412x) {
                actionBarContextView.setSplitView(null);
            }
        }
        this.g.c(z11);
        this.g.m(z12);
        this.g.d(z10);
        actionBarContextView.setSplitToolbar(z11);
        actionBarContextView.setSplitWhenNarrow(z10);
        ActionBarContainer actionBarContainer3 = this.c;
        if (actionBarContainer3 != null) {
            if (!this.g.e() && !actionBarContextView.f6412x && !z12) {
                i6 = 8;
            }
            actionBarContainer3.setVisibility(i6);
        }
    }

    @Override // stepos.support.v7.widget.H
    public void setWindowCallback(Window.Callback callback) {
        g();
        this.g.setWindowCallback(callback);
    }

    @Override // stepos.support.v7.widget.H
    public void setWindowTitle(CharSequence charSequence) {
        g();
        this.g.setWindowTitle(charSequence);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // stepos.support.v7.widget.H
    public final boolean showOverflowMenu() {
        g();
        return this.g.showOverflowMenu();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new C1997l(layoutParams);
    }

    public void setIcon(Drawable drawable) {
        g();
        this.g.setIcon(drawable);
    }
}

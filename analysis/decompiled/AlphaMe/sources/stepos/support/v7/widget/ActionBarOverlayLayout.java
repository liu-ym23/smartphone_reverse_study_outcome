package stepos.support.v7.widget;

import a.C0152a;
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
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.animation.PathInterpolator;
import android.widget.OverScroller;
import androidx.appcompat.widget.C0195d;
import com.stepos.activeview.moveline.item.ViewTweenItem;
import com.stepos.alphame.R;
import com.stepos.alphame.utils.Property;
import d.C0527a;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import stepos.support.v7.app.C0877w;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes2.dex */
public class ActionBarOverlayLayout extends ViewGroup implements C {

    /* renamed from: Q, reason: collision with root package name */
    public static final int[] f14752Q = {R.attr.actionBarSize, android.R.attr.windowContentOverlay, R.attr.steposWindowSplitActionBar, R.attr.steposSplitActionBarFloat, R.attr.steposActionBarFitStatusBar, R.attr.steposActionBarOverlayMode};

    /* renamed from: A, reason: collision with root package name */
    public int f14753A;

    /* renamed from: B, reason: collision with root package name */
    public boolean f14754B;

    /* renamed from: C, reason: collision with root package name */
    public int f14755C;

    /* renamed from: D, reason: collision with root package name */
    public boolean f14756D;

    /* renamed from: E, reason: collision with root package name */
    public boolean f14757E;

    /* renamed from: F, reason: collision with root package name */
    public final C0887g f14758F;

    /* renamed from: G, reason: collision with root package name */
    public final C0887g f14759G;

    /* renamed from: H, reason: collision with root package name */
    public final RunnableC0888h f14760H;

    /* renamed from: I, reason: collision with root package name */
    public final RunnableC0888h f14761I;

    /* renamed from: J, reason: collision with root package name */
    public final C0152a f14762J;

    /* renamed from: K, reason: collision with root package name */
    public Drawable f14763K;

    /* renamed from: L, reason: collision with root package name */
    public boolean f14764L;

    /* renamed from: M, reason: collision with root package name */
    public ObjectAnimator f14765M;

    /* renamed from: N, reason: collision with root package name */
    public ObjectAnimator f14766N;

    /* renamed from: O, reason: collision with root package name */
    public PathInterpolator f14767O;

    /* renamed from: P, reason: collision with root package name */
    public PathInterpolator f14768P;

    /* renamed from: a, reason: collision with root package name */
    public int f14769a;

    /* renamed from: b, reason: collision with root package name */
    public FitsWindowsContentLayout f14770b;

    /* renamed from: c, reason: collision with root package name */
    public ActionBarContainer f14771c;

    /* renamed from: d, reason: collision with root package name */
    public ActionBarContainer f14772d;

    /* renamed from: e, reason: collision with root package name */
    public View f14773e;

    /* renamed from: f, reason: collision with root package name */
    public ActionBarDropDownView f14774f;

    /* renamed from: g, reason: collision with root package name */
    public D f14775g;

    /* renamed from: h, reason: collision with root package name */
    public Drawable f14776h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f14777i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f14778j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f14779k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f14780l;

    /* renamed from: m, reason: collision with root package name */
    public int f14781m;

    /* renamed from: n, reason: collision with root package name */
    public int f14782n;

    /* renamed from: o, reason: collision with root package name */
    public final Rect f14783o;

    /* renamed from: p, reason: collision with root package name */
    public final Rect f14784p;

    /* renamed from: q, reason: collision with root package name */
    public final Rect f14785q;

    /* renamed from: r, reason: collision with root package name */
    public final Rect f14786r;

    /* renamed from: s, reason: collision with root package name */
    public final Rect f14787s;

    /* renamed from: t, reason: collision with root package name */
    public final Rect f14788t;

    /* renamed from: u, reason: collision with root package name */
    public InterfaceC0889i f14789u;

    /* renamed from: v, reason: collision with root package name */
    public C0527a f14790v;

    /* renamed from: w, reason: collision with root package name */
    public K.e0 f14791w;

    /* renamed from: x, reason: collision with root package name */
    public K.e0 f14792x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f14793y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f14794z;

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14769a = 0;
        this.f14778j = true;
        this.f14783o = new Rect();
        this.f14784p = new Rect();
        this.f14785q = new Rect();
        this.f14786r = new Rect();
        this.f14787s = new Rect();
        this.f14788t = new Rect();
        this.f14753A = -1;
        this.f14757E = false;
        this.f14758F = new C0887g(this, 0);
        this.f14759G = new C0887g(this, 1);
        this.f14760H = new RunnableC0888h(this, 0);
        this.f14761I = new RunnableC0888h(this, 1);
        this.f14764L = false;
        i(context);
        this.f14762J = new C0152a();
    }

    @Override // stepos.support.v7.widget.C
    public final void a(L3.k kVar, C0877w c0877w) {
        n();
        this.f14775g.a(kVar, c0877w);
    }

    @Override // stepos.support.v7.widget.C
    public final boolean b() {
        n();
        return this.f14775g.b();
    }

    @Override // stepos.support.v7.widget.C
    public final void c() {
        n();
        this.f14775g.c();
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0890j;
    }

    public final void d() {
        removeCallbacks(this.f14760H);
        removeCallbacks(this.f14761I);
        K.e0 e0Var = this.f14791w;
        if (e0Var != null) {
            e0Var.b();
        }
        K.e0 e0Var2 = this.f14792x;
        if (e0Var2 != null) {
            e0Var2.b();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        super.dispatchApplyWindowInsets(windowInsets);
        n();
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        Insets insets = windowInsets.getInsets(WindowInsets.Type.systemBars());
        rect.set(insets.left, insets.top, insets.right, insets.bottom);
        rect2.set(rect);
        int i4 = windowInsets.getInsets(WindowInsets.Type.ime()).bottom;
        if (i4 > insets.bottom) {
            rect.bottom = i4;
        }
        if (!this.f14754B) {
            rect.top = m2.o.g(getContext());
        }
        boolean zA = y0.a(this.f14772d, rect, true, false);
        this.f14786r.set(rect);
        Rect rect3 = this.f14783o;
        rect3.set(rect);
        ActionBarContainer actionBarContainer = this.f14771c;
        if (actionBarContainer != null) {
            zA |= y0.a(actionBarContainer, rect2, false, this.f14794z);
            this.f14775g.D(this.f14771c);
        }
        Rect rect4 = this.f14784p;
        boolean zEquals = rect4.equals(rect3);
        Rect rect5 = this.f14788t;
        if (zEquals) {
            if (!zA) {
                if (this.f14778j) {
                    this.f14770b.dispatchFitSystemWindows(rect5);
                }
            }
            return windowInsets.consumeSystemWindowInsets();
        }
        rect4.set(rect3);
        rect5.setEmpty();
        requestLayout();
        return windowInsets.consumeSystemWindowInsets();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int translationY;
        super.draw(canvas);
        if (this.f14776h == null || this.f14777i) {
            return;
        }
        if (this.f14772d.getVisibility() == 0) {
            float bottom = this.f14772d.getBottom();
            ActionBarContainer actionBarContainer = this.f14772d;
            WeakHashMap weakHashMap = K.S.f939a;
            translationY = (int) (actionBarContainer.getTranslationY() + bottom + 0.5f);
        } else {
            translationY = 0;
        }
        this.f14776h.setBounds(0, translationY, getWidth(), this.f14776h.getIntrinsicHeight() + translationY);
        this.f14776h.draw(canvas);
    }

    @Override // stepos.support.v7.widget.C
    public final boolean e() {
        n();
        return this.f14775g.e();
    }

    @Override // stepos.support.v7.widget.C
    public final boolean f() {
        n();
        return this.f14775g.f();
    }

    @Override // stepos.support.v7.widget.C
    public final boolean g() {
        n();
        return this.f14775g.g();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new C0890j(-1, -1);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0890j(getContext(), attributeSet);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f14772d;
        if (actionBarContainer == null) {
            return 0;
        }
        WeakHashMap weakHashMap = K.S.f939a;
        return -((int) actionBarContainer.getTranslationY());
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        C0152a c0152a = this.f14762J;
        return c0152a.f2262b | c0152a.f2261a;
    }

    public CharSequence getTitle() {
        n();
        return this.f14775g.getTitle();
    }

    @Override // stepos.support.v7.widget.C
    public final boolean h() {
        n();
        return this.f14775g.h();
    }

    public final void i(Context context) {
        int[] iArr = f14752Q;
        iArr[0] = R.attr.steposActionBarSizeFullScreen;
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(iArr);
        typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        this.f14776h = drawable;
        setWillNotDraw(drawable == null);
        this.f14793y = typedArrayObtainStyledAttributes.getBoolean(2, false);
        this.f14794z = typedArrayObtainStyledAttributes.getBoolean(3, false);
        this.f14754B = typedArrayObtainStyledAttributes.getBoolean(4, this.f14754B);
        setOverlayMode(typedArrayObtainStyledAttributes.getBoolean(5, this.f14778j));
        typedArrayObtainStyledAttributes.recycle();
        this.f14777i = context.getApplicationInfo().targetSdkVersion < 19;
        this.f14790v = new C0527a(context);
    }

    @Override // stepos.support.v7.widget.C
    public final void j() {
        if (!this.f14757E || this.f14773e == null || this.f14764L) {
            return;
        }
        ObjectAnimator objectAnimator = this.f14765M;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.f14765M.cancel();
        }
        this.f14764L = true;
        this.f14773e.setVisibility(0);
        if (this.f14767O == null) {
            this.f14767O = new PathInterpolator(0.3f, Property.DEFAULT_FLOAT_VALUE, 0.67f, 1.0f);
        }
        if (this.f14765M == null) {
            ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this.f14763K, ViewTweenItem.ALPHA, 0, 255);
            this.f14765M = objectAnimatorOfInt;
            objectAnimatorOfInt.setInterpolator(this.f14767O);
            this.f14765M.setDuration(150L);
        }
        this.f14765M.start();
        this.f14773e.setClickable(true);
    }

    @Override // stepos.support.v7.widget.C
    public final void k(int i4) {
        n();
        if (i4 == 2) {
            this.f14775g.C();
        } else if (i4 == 5) {
            this.f14775g.E();
        } else {
            if (i4 != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    @Override // stepos.support.v7.widget.C
    public final void l() {
        n();
        this.f14775g.i();
    }

    @Override // stepos.support.v7.widget.C
    public final void m(L3.k kVar, C0877w c0877w) {
        n();
        this.f14775g.u(kVar, c0877w);
        if (this.f14775g.l() && kVar == null) {
            this.f14775g.p(false);
        }
    }

    public final void n() {
        D wrapper;
        if (this.f14770b == null) {
            this.f14770b = (FitsWindowsContentLayout) findViewById(R.id.action_bar_activity_content);
            this.f14772d = (ActionBarContainer) findViewById(R.id.action_bar_container);
            KeyEvent.Callback callbackFindViewById = findViewById(R.id.action_bar);
            if (callbackFindViewById instanceof D) {
                wrapper = (D) callbackFindViewById;
            } else {
                if (!(callbackFindViewById instanceof Toolbar)) {
                    throw new IllegalStateException("Can't make a decor toolbar out of ".concat(callbackFindViewById.getClass().getSimpleName()));
                }
                wrapper = ((Toolbar) callbackFindViewById).getWrapper();
            }
            this.f14775g = wrapper;
            this.f14771c = (ActionBarContainer) findViewById(R.id.split_action_bar);
            this.f14773e = findViewById(R.id.stepos_list_backtop_container);
        }
    }

    @Override // stepos.support.v7.widget.C
    public final void o() {
        if (this.f14757E && this.f14773e != null && this.f14764L) {
            ObjectAnimator objectAnimator = this.f14766N;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.f14766N.cancel();
            }
            this.f14773e.setClickable(false);
            this.f14764L = false;
            if (this.f14768P == null) {
                this.f14768P = new PathInterpolator(0.3f, Property.DEFAULT_FLOAT_VALUE, 0.67f, 1.0f);
            }
            if (this.f14766N == null) {
                ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this.f14763K, ViewTweenItem.ALPHA, 127, 0);
                this.f14766N = objectAnimatorOfInt;
                objectAnimatorOfInt.setInterpolator(this.f14768P);
                this.f14766N.setDuration(230L);
                this.f14766N.addListener(new C0195d(13, this));
            }
            this.f14766N.start();
        }
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        i(getContext());
        WeakHashMap weakHashMap = K.S.f939a;
        K.H.c(this);
        setUiOptions(this.f14755C);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) throws Resources.NotFoundException {
        int measuredHeight;
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = (i6 - i4) - getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = (i7 - i5) - getPaddingBottom();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                C0890j c0890j = (C0890j) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight2 = childAt.getMeasuredHeight();
                int i9 = ((ViewGroup.MarginLayoutParams) c0890j).leftMargin + paddingLeft;
                ActionBarContainer actionBarContainer = this.f14771c;
                if (childAt == actionBarContainer) {
                    measuredHeight = (paddingBottom - measuredHeight2) - ((ViewGroup.MarginLayoutParams) c0890j).bottomMargin;
                } else if (childAt == this.f14773e) {
                    measuredHeight = ((paddingBottom - measuredHeight2) - ((ViewGroup.MarginLayoutParams) c0890j).bottomMargin) - ((actionBarContainer == null || actionBarContainer.getVisibility() == 8) ? 0 : this.f14771c.getMeasuredHeight());
                    i9 = (paddingRight - measuredWidth) - ((ViewGroup.MarginLayoutParams) c0890j).rightMargin;
                } else {
                    measuredHeight = paddingTop + ((ViewGroup.MarginLayoutParams) c0890j).topMargin;
                }
                childAt.layout(i9, measuredHeight, measuredWidth + i9, measuredHeight2 + measuredHeight);
            }
        }
        WeakHashMap weakHashMap = K.S.f939a;
        int layoutDirection = getLayoutDirection();
        int measuredWidth2 = this.f14773e.getMeasuredWidth();
        int measuredHeight3 = this.f14773e.getMeasuredHeight();
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.stepos_list_backtop_btn_margin_right);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.stepos_list_backtop_btn_margin_bottom);
        if (layoutDirection == 1) {
            int paddingLeft2 = getPaddingLeft() + dimensionPixelSize;
            int height = ((getHeight() - getPaddingBottom()) - dimensionPixelSize2) - measuredHeight3;
            this.f14773e.layout(paddingLeft2, height, measuredWidth2 + paddingLeft2, measuredHeight3 + height);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i4, int i5) {
        int measuredHeight;
        ActionBarContainer actionBarContainer;
        int i6;
        n();
        View view = this.f14773e;
        if (view != null && view.getVisibility() != 8) {
            measureChildWithMargins(this.f14773e, i4, 0, i5, 0);
        }
        measureChildWithMargins(this.f14772d, i4, 0, i5, 0);
        C0890j c0890j = (C0890j) this.f14772d.getLayoutParams();
        int measuredHeight2 = 0;
        int iMax = Math.max(0, this.f14772d.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) c0890j).leftMargin + ((ViewGroup.MarginLayoutParams) c0890j).rightMargin);
        int iMax2 = Math.max(0, this.f14772d.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) c0890j).topMargin + ((ViewGroup.MarginLayoutParams) c0890j).bottomMargin);
        ActionBarContainer actionBarContainer2 = this.f14772d;
        WeakHashMap weakHashMap = K.S.f939a;
        int measuredState = actionBarContainer2.getMeasuredState();
        Method method = y0.f15251a;
        ActionBarContainer actionBarContainer3 = this.f14771c;
        if (actionBarContainer3 != null) {
            measureChildWithMargins(actionBarContainer3, i4, 0, i5, 0);
            C0890j c0890j2 = (C0890j) this.f14771c.getLayoutParams();
            iMax = Math.max(iMax, this.f14771c.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) c0890j2).leftMargin + ((ViewGroup.MarginLayoutParams) c0890j2).rightMargin);
            iMax2 = Math.max(iMax2, this.f14771c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) c0890j2).topMargin + ((ViewGroup.MarginLayoutParams) c0890j2).bottomMargin);
            measuredState |= this.f14771c.getMeasuredState();
        }
        View viewFindViewById = findViewById(R.id.top_shadow_mask);
        if (viewFindViewById != null) {
            measureChildWithMargins(viewFindViewById, i4, 0, i5, 0);
        }
        int visibility = this.f14772d.getVisibility();
        Rect rect = this.f14786r;
        if (visibility != 8) {
            measuredHeight = this.f14772d.getMeasuredHeight();
            int i7 = rect.top;
            if (measuredHeight > i7) {
                measuredHeight -= i7;
            }
        } else {
            measuredHeight = 0;
        }
        if ((this.f14775g.k() || this.f14775g.l() || this.f14775g.y()) && (actionBarContainer = this.f14771c) != null && actionBarContainer.getVisibility() != 8 && (measuredHeight2 = this.f14771c.getMeasuredHeight()) > (i6 = rect.bottom)) {
            measuredHeight2 -= i6;
        }
        Rect rect2 = this.f14785q;
        rect2.set(this.f14783o);
        Rect rect3 = this.f14787s;
        rect3.set(rect);
        if (this.f14778j) {
            rect3.top += measuredHeight;
            rect3.bottom += measuredHeight2;
            rect2.setEmpty();
        } else {
            rect2.top += measuredHeight;
            rect2.bottom += measuredHeight2;
            rect3.setEmpty();
        }
        ViewGroup.LayoutParams layoutParams = this.f14770b.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int i8 = marginLayoutParams.leftMargin;
            int i9 = rect2.left;
            if (i8 != i9) {
                marginLayoutParams.leftMargin = i9;
            }
            int i10 = marginLayoutParams.topMargin;
            int i11 = rect2.top;
            if (i10 != i11) {
                marginLayoutParams.topMargin = i11;
            }
            int i12 = marginLayoutParams.rightMargin;
            int i13 = rect2.right;
            if (i12 != i13) {
                marginLayoutParams.rightMargin = i13;
            }
            int i14 = marginLayoutParams.bottomMargin;
            int i15 = rect2.bottom;
            if (i14 != i15) {
                marginLayoutParams.bottomMargin = i15;
            }
        }
        Rect rect4 = this.f14788t;
        if (!rect4.equals(rect3)) {
            rect4.set(rect3);
            this.f14770b.dispatchFitSystemWindows(rect3);
        }
        measureChildWithMargins(this.f14770b, i4, 0, i5, 0);
        C0890j c0890j3 = (C0890j) this.f14770b.getLayoutParams();
        int iMax3 = Math.max(iMax, this.f14770b.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) c0890j3).leftMargin + ((ViewGroup.MarginLayoutParams) c0890j3).rightMargin);
        int iMax4 = Math.max(iMax2, this.f14770b.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) c0890j3).topMargin + ((ViewGroup.MarginLayoutParams) c0890j3).bottomMargin);
        int measuredState2 = measuredState | this.f14770b.getMeasuredState();
        ActionBarDropDownView actionBarDropDownView = this.f14774f;
        if (actionBarDropDownView != null && actionBarDropDownView.getVisibility() != 8) {
            if (this.f14778j) {
                rect2 = rect3;
            }
            int i16 = this.f14753A;
            if (i16 != -1) {
                rect2.top = i16;
            }
            y0.a(this.f14774f, rect2, true, true);
            measureChildWithMargins(this.f14774f, i4, 0, i5, 0);
            measuredState2 |= this.f14774f.getMeasuredState();
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(getPaddingRight() + getPaddingLeft() + iMax3, getSuggestedMinimumWidth()), i4, measuredState2), View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + iMax4, getSuggestedMinimumHeight()), i5, measuredState2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f4, float f5, boolean z4) {
        if (!this.f14779k || !z4) {
            return false;
        }
        ((OverScroller) this.f14790v.f12410b).fling(0, 0, 0, (int) f5, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (((OverScroller) this.f14790v.f12410b).getFinalY() > this.f14772d.getHeight()) {
            d();
            this.f14761I.run();
        } else {
            d();
            this.f14760H.run();
        }
        this.f14780l = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f4, float f5) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i4, int i5, int[] iArr) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i4, int i5, int i6, int i7) {
        int i8 = this.f14781m + i5;
        this.f14781m = i8;
        setActionBarHideOffset(i8);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i4) {
        stepos.support.v7.app.g0 g0Var;
        j.m mVar;
        this.f14762J.f2261a = i4;
        this.f14781m = getActionBarHideOffset();
        d();
        InterfaceC0889i interfaceC0889i = this.f14789u;
        if (interfaceC0889i == null || (mVar = (g0Var = (stepos.support.v7.app.g0) interfaceC0889i).f14500u) == null) {
            return;
        }
        mVar.a();
        g0Var.f14500u = null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i4) {
        if ((i4 & 2) == 0 || this.f14772d.getVisibility() != 0) {
            return false;
        }
        return this.f14779k;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        if (!this.f14779k || this.f14780l) {
            return;
        }
        if (this.f14781m <= this.f14772d.getHeight()) {
            d();
            postDelayed(this.f14760H, 600L);
        } else {
            d();
            postDelayed(this.f14761I, 600L);
        }
    }

    @Override // android.view.View
    public final void onWindowSystemUiVisibilityChanged(int i4) {
        super.onWindowSystemUiVisibilityChanged(i4);
        n();
        int i5 = this.f14782n ^ i4;
        this.f14782n = i4;
        boolean z4 = (i4 & 4) == 0;
        boolean z5 = (i4 & 256) != 0;
        InterfaceC0889i interfaceC0889i = this.f14789u;
        if (interfaceC0889i != null) {
            ((stepos.support.v7.app.g0) interfaceC0889i).f14496q = !z5;
            if (z4 || !z5) {
                stepos.support.v7.app.g0 g0Var = (stepos.support.v7.app.g0) interfaceC0889i;
                if (g0Var.f14497r) {
                    g0Var.f14497r = false;
                    g0Var.z(true);
                }
            } else {
                stepos.support.v7.app.g0 g0Var2 = (stepos.support.v7.app.g0) interfaceC0889i;
                if (!g0Var2.f14497r) {
                    g0Var2.f14497r = true;
                    g0Var2.z(true);
                }
            }
        }
        if ((i5 & 256) == 0 || this.f14789u == null) {
            return;
        }
        WeakHashMap weakHashMap = K.S.f939a;
        K.H.c(this);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i4) {
        super.onWindowVisibilityChanged(i4);
        this.f14769a = i4;
        InterfaceC0889i interfaceC0889i = this.f14789u;
        if (interfaceC0889i != null) {
            ((stepos.support.v7.app.g0) interfaceC0889i).f14495p = i4;
        }
    }

    public void setActionBarDropDownView(ActionBarDropDownView actionBarDropDownView) {
        this.f14774f = actionBarDropDownView;
    }

    public void setActionBarFitStatusBar(boolean z4) {
        this.f14754B = z4;
    }

    public void setActionBarHideOffset(int i4) {
        d();
        int iMax = Math.max(0, Math.min(i4, this.f14772d.getHeight()));
        WeakHashMap weakHashMap = K.S.f939a;
        this.f14772d.setTranslationY(-iMax);
        ActionBarContainer actionBarContainer = this.f14771c;
        if (actionBarContainer == null || actionBarContainer.getVisibility() == 8) {
            return;
        }
        this.f14771c.setTranslationY((int) (this.f14771c.getHeight() * (iMax / r0)));
    }

    public void setActionBarVisibilityCallback(InterfaceC0889i interfaceC0889i) {
        this.f14789u = interfaceC0889i;
        if (getWindowToken() != null) {
            ((stepos.support.v7.app.g0) this.f14789u).f14495p = this.f14769a;
            int i4 = this.f14782n;
            if (i4 != 0) {
                onWindowSystemUiVisibilityChanged(i4);
                WeakHashMap weakHashMap = K.S.f939a;
                K.H.c(this);
            }
        }
    }

    @Override // stepos.support.v7.widget.C
    public void setBackTopBackground(Drawable drawable) {
        if (this.f14757E) {
            if (drawable == null) {
                this.f14773e.setBackgroundResource(R.drawable.stepos_list_backtop);
            } else {
                this.f14763K = drawable;
                this.f14773e.setBackground(drawable);
            }
        }
    }

    @Override // stepos.support.v7.widget.C
    public void setBackTopClickCallback(View.OnClickListener onClickListener) {
        this.f14773e.setOnClickListener(onClickListener);
    }

    @Override // stepos.support.v7.widget.C
    public void setBackTopEnable(boolean z4) {
        this.f14757E = z4;
        if (z4) {
            this.f14773e.setBackgroundResource(R.drawable.stepos_list_backtop);
        }
    }

    public void setDropDownShowStart(int i4) {
        this.f14753A = i4;
    }

    public void setFullWindowContent(boolean z4) {
        if (this.f14756D != z4) {
            this.f14756D = z4;
            requestLayout();
        }
    }

    public void setHasNonEmbeddedTabs(boolean z4) {
    }

    public void setHideOnContentScrollEnabled(boolean z4) {
        if (z4 != this.f14779k) {
            this.f14779k = z4;
            if (z4) {
                return;
            }
            d();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i4) {
        n();
        this.f14775g.setIcon(i4);
    }

    public void setLogo(int i4) {
        n();
        this.f14775g.x(i4);
    }

    public void setOverlayMode(boolean z4) {
        this.f14778j = z4;
        this.f14777i = z4 && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z4) {
    }

    public void setSplitBarFitSystemWindows(boolean z4) {
        this.f14794z = z4;
    }

    @Deprecated
    public void setTransStatusBarInStepOS3(boolean z4) {
    }

    public void setUiOptions(int i4) {
        this.f14755C = i4;
        int i5 = 0;
        boolean z4 = (i4 & 1) != 0;
        boolean z5 = z4 ? getContext().getResources().getBoolean(R.bool.stepos_split_action_bar_is_narrow) : this.f14793y;
        boolean z6 = i4 == 2;
        if (z5 && z6) {
            throw new IllegalStateException("You can't split action bar and use bottom menu in the same time.");
        }
        n();
        ActionBarContainer actionBarContainer = this.f14772d;
        ActionBarContextView actionBarContextView = actionBarContainer != null ? (ActionBarContextView) actionBarContainer.findViewById(R.id.action_context_bar) : (ActionBarContextView) findViewById(R.id.action_context_bar);
        if (z5) {
            if (this.f14771c == null || !this.f14775g.B()) {
                Log.e("ActionBarOverlayLayout", "Requested split action bar with incompatible window decor! Ignoring request.");
                return;
            } else {
                this.f14775g.A(this.f14771c);
                actionBarContextView.setSplitView(this.f14771c);
            }
        } else if (z6) {
            ActionBarContainer actionBarContainer2 = this.f14771c;
            if (actionBarContainer2 == null) {
                Log.e("ActionBarOverlayLayout", "Requested split action bar with incompatible window decor! Ignoring request.");
                return;
            }
            this.f14775g.A(actionBarContainer2);
        } else {
            this.f14775g.A(null);
            if (!actionBarContextView.f14726x) {
                actionBarContextView.setSplitView(null);
            }
        }
        this.f14775g.q(z5);
        this.f14775g.p(z6);
        this.f14775g.j(z4);
        actionBarContextView.setSplitToolbar(z5);
        actionBarContextView.setSplitWhenNarrow(z4);
        ActionBarContainer actionBarContainer3 = this.f14771c;
        if (actionBarContainer3 != null) {
            if (!this.f14775g.k() && !actionBarContextView.f14726x && !z6) {
                i5 = 8;
            }
            actionBarContainer3.setVisibility(i5);
        }
    }

    @Override // stepos.support.v7.widget.C
    public void setWindowCallback(Window.Callback callback) {
        n();
        this.f14775g.setWindowCallback(callback);
    }

    @Override // stepos.support.v7.widget.C
    public void setWindowTitle(CharSequence charSequence) {
        n();
        this.f14775g.setWindowTitle(charSequence);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new C0890j(layoutParams);
    }

    public void setIcon(Drawable drawable) {
        n();
        this.f14775g.setIcon(drawable);
    }
}

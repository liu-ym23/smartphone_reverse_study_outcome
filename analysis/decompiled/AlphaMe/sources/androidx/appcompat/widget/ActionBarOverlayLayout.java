package androidx.appcompat.widget;

import K.InterfaceC0086s;
import K.InterfaceC0087t;
import a.C0152a;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.stepos.alphame.R;
import e.EnumC0546d;
import java.util.WeakHashMap;
import k.C0661o;

@SuppressLint({"UnknownNullness"})
@RestrictTo({EnumC0546d.f12494c})
/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements InterfaceC0214m0, InterfaceC0086s, InterfaceC0087t {

    /* renamed from: C, reason: collision with root package name */
    public static final int[] f2754C = {R.attr.actionBarSize, android.R.attr.windowContentOverlay};

    /* renamed from: D, reason: collision with root package name */
    public static final K.z0 f2755D;

    /* renamed from: E, reason: collision with root package name */
    public static final Rect f2756E;

    /* renamed from: A, reason: collision with root package name */
    public final C0152a f2757A;

    /* renamed from: B, reason: collision with root package name */
    public final C0203h f2758B;

    /* renamed from: a, reason: collision with root package name */
    public int f2759a;

    /* renamed from: b, reason: collision with root package name */
    public int f2760b;

    /* renamed from: c, reason: collision with root package name */
    public ContentFrameLayout f2761c;

    /* renamed from: d, reason: collision with root package name */
    public ActionBarContainer f2762d;

    /* renamed from: e, reason: collision with root package name */
    public InterfaceC0216n0 f2763e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f2764f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f2765g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f2766h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f2767i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f2768j;

    /* renamed from: k, reason: collision with root package name */
    public int f2769k;

    /* renamed from: l, reason: collision with root package name */
    public int f2770l;

    /* renamed from: m, reason: collision with root package name */
    public final Rect f2771m;

    /* renamed from: n, reason: collision with root package name */
    public final Rect f2772n;

    /* renamed from: o, reason: collision with root package name */
    public final Rect f2773o;

    /* renamed from: p, reason: collision with root package name */
    public final Rect f2774p;

    /* renamed from: q, reason: collision with root package name */
    public K.z0 f2775q;

    /* renamed from: r, reason: collision with root package name */
    public K.z0 f2776r;

    /* renamed from: s, reason: collision with root package name */
    public K.z0 f2777s;

    /* renamed from: t, reason: collision with root package name */
    public K.z0 f2778t;

    /* renamed from: u, reason: collision with root package name */
    public InterfaceC0199f f2779u;

    /* renamed from: v, reason: collision with root package name */
    public OverScroller f2780v;

    /* renamed from: w, reason: collision with root package name */
    public ViewPropertyAnimator f2781w;

    /* renamed from: x, reason: collision with root package name */
    public final C0195d f2782x;

    /* renamed from: y, reason: collision with root package name */
    public final RunnableC0197e f2783y;

    /* renamed from: z, reason: collision with root package name */
    public final RunnableC0197e f2784z;

    static {
        K.q0 q0Var = new K.q0();
        q0Var.e(D.c.b(0, 1, 0, 1));
        f2755D = q0Var.b();
        f2756E = new Rect();
    }

    public ActionBarOverlayLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2760b = 0;
        this.f2771m = new Rect();
        this.f2772n = new Rect();
        this.f2773o = new Rect();
        this.f2774p = new Rect();
        new Rect();
        new Rect();
        new Rect();
        new Rect();
        K.z0 z0Var = K.z0.f1022b;
        this.f2775q = z0Var;
        this.f2776r = z0Var;
        this.f2777s = z0Var;
        this.f2778t = z0Var;
        this.f2782x = new C0195d(0, this);
        this.f2783y = new RunnableC0197e(this, 0);
        this.f2784z = new RunnableC0197e(this, 1);
        c(context);
        this.f2757A = new C0152a();
        C0203h c0203h = new C0203h(context);
        c0203h.setWillNotDraw(true);
        this.f2758B = c0203h;
        addView(c0203h);
    }

    public static boolean a(FrameLayout frameLayout, Rect rect, boolean z4) {
        boolean z5;
        C0201g c0201g = (C0201g) frameLayout.getLayoutParams();
        int i4 = ((ViewGroup.MarginLayoutParams) c0201g).leftMargin;
        int i5 = rect.left;
        if (i4 != i5) {
            ((ViewGroup.MarginLayoutParams) c0201g).leftMargin = i5;
            z5 = true;
        } else {
            z5 = false;
        }
        int i6 = ((ViewGroup.MarginLayoutParams) c0201g).topMargin;
        int i7 = rect.top;
        if (i6 != i7) {
            ((ViewGroup.MarginLayoutParams) c0201g).topMargin = i7;
            z5 = true;
        }
        int i8 = ((ViewGroup.MarginLayoutParams) c0201g).rightMargin;
        int i9 = rect.right;
        if (i8 != i9) {
            ((ViewGroup.MarginLayoutParams) c0201g).rightMargin = i9;
            z5 = true;
        }
        if (z4) {
            int i10 = ((ViewGroup.MarginLayoutParams) c0201g).bottomMargin;
            int i11 = rect.bottom;
            if (i10 != i11) {
                ((ViewGroup.MarginLayoutParams) c0201g).bottomMargin = i11;
                return true;
            }
        }
        return z5;
    }

    public final void b() {
        removeCallbacks(this.f2783y);
        removeCallbacks(this.f2784z);
        ViewPropertyAnimator viewPropertyAnimator = this.f2781w;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public final void c(Context context) {
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f2754C);
        this.f2759a = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        this.f2764f = drawable;
        setWillNotDraw(drawable == null);
        typedArrayObtainStyledAttributes.recycle();
        this.f2780v = new OverScroller(context);
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0201g;
    }

    @Override // K.InterfaceC0086s
    public final void d(View view, View view2, int i4, int i5) {
        if (i5 == 0) {
            onNestedScrollAccepted(view, view2, i4);
        }
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int translationY;
        super.draw(canvas);
        if (this.f2764f != null) {
            if (this.f2762d.getVisibility() == 0) {
                translationY = (int) (this.f2762d.getTranslationY() + this.f2762d.getBottom() + 0.5f);
            } else {
                translationY = 0;
            }
            this.f2764f.setBounds(0, translationY, getWidth(), this.f2764f.getIntrinsicHeight() + translationY);
            this.f2764f.draw(canvas);
        }
    }

    public final void e(int i4) {
        f();
        if (i4 == 2) {
            ((g1) this.f2763e).getClass();
            Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
        } else if (i4 == 5) {
            ((g1) this.f2763e).getClass();
            Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
        } else {
            if (i4 != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    public final void f() {
        InterfaceC0216n0 wrapper;
        if (this.f2761c == null) {
            this.f2761c = (ContentFrameLayout) findViewById(R.id.action_bar_activity_content);
            this.f2762d = (ActionBarContainer) findViewById(R.id.action_bar_container);
            KeyEvent.Callback callbackFindViewById = findViewById(R.id.action_bar);
            if (callbackFindViewById instanceof InterfaceC0216n0) {
                wrapper = (InterfaceC0216n0) callbackFindViewById;
            } else {
                if (!(callbackFindViewById instanceof Toolbar)) {
                    throw new IllegalStateException("Can't make a decor toolbar out of ".concat(callbackFindViewById.getClass().getSimpleName()));
                }
                wrapper = ((Toolbar) callbackFindViewById).getWrapper();
            }
            this.f2763e = wrapper;
        }
    }

    @Override // android.view.View
    public final boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    public final void g(C0661o c0661o, androidx.appcompat.app.s sVar) {
        f();
        g1 g1Var = (g1) this.f2763e;
        C0217o c0217o = g1Var.f3099m;
        Toolbar toolbar = g1Var.f3087a;
        if (c0217o == null) {
            g1Var.f3099m = new C0217o(toolbar.getContext());
        }
        C0217o c0217o2 = g1Var.f3099m;
        c0217o2.f3130e = sVar;
        if (c0661o == null && toolbar.f2984a == null) {
            return;
        }
        toolbar.e();
        C0661o c0661o2 = toolbar.f2984a.f2787p;
        if (c0661o2 == c0661o) {
            return;
        }
        if (c0661o2 != null) {
            c0661o2.r(toolbar.f2977K);
            c0661o2.r(toolbar.f2978L);
        }
        if (toolbar.f2978L == null) {
            toolbar.f2978L = new c1(toolbar);
        }
        c0217o2.f3142q = true;
        if (c0661o != null) {
            c0661o.b(c0217o2, toolbar.f2993j);
            c0661o.b(toolbar.f2978L, toolbar.f2993j);
        } else {
            c0217o2.k(toolbar.f2993j, null);
            toolbar.f2978L.k(toolbar.f2993j, null);
            c0217o2.a();
            toolbar.f2978L.a();
        }
        toolbar.f2984a.setPopupTheme(toolbar.f2994k);
        toolbar.f2984a.setPresenter(c0217o2);
        toolbar.f2977K = c0217o2;
        toolbar.s();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new C0201g(-1, -1);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0201g(getContext(), attributeSet);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f2762d;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        C0152a c0152a = this.f2757A;
        return c0152a.f2262b | c0152a.f2261a;
    }

    public CharSequence getTitle() {
        f();
        return ((g1) this.f2763e).f3087a.getTitle();
    }

    @Override // K.InterfaceC0086s
    public final void i(View view, int i4, int i5, int[] iArr, int i6) {
    }

    @Override // K.InterfaceC0086s
    public final void n(int i4, View view) {
        if (i4 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        f();
        K.z0 z0VarF = K.z0.f(this, windowInsets);
        boolean zA = a(this.f2762d, new Rect(z0VarF.b(), z0VarF.d(), z0VarF.c(), z0VarF.a()), false);
        WeakHashMap weakHashMap = K.S.f939a;
        Rect rect = this.f2771m;
        K.J.b(this, z0VarF, rect);
        int i4 = rect.left;
        int i5 = rect.top;
        int i6 = rect.right;
        int i7 = rect.bottom;
        K.x0 x0Var = z0VarF.f1023a;
        K.z0 z0VarI = x0Var.i(i4, i5, i6, i7);
        this.f2775q = z0VarI;
        if (!this.f2776r.equals(z0VarI)) {
            this.f2776r = this.f2775q;
            zA = true;
        }
        Rect rect2 = this.f2772n;
        if (rect2.equals(rect)) {
            if (zA) {
            }
            return x0Var.a().f1023a.c().f1023a.b().e();
        }
        rect2.set(rect);
        requestLayout();
        return x0Var.a().f1023a.c().f1023a.b().e();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        c(getContext());
        WeakHashMap weakHashMap = K.S.f939a;
        K.H.c(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                C0201g c0201g = (C0201g) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i9 = ((ViewGroup.MarginLayoutParams) c0201g).leftMargin + paddingLeft;
                int i10 = ((ViewGroup.MarginLayoutParams) c0201g).topMargin + paddingTop;
                childAt.layout(i9, i10, measuredWidth + i9, measuredHeight + i10);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00ab  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r12, int r13) {
        /*
            Method dump skipped, instructions count: 350
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarOverlayLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f4, float f5, boolean z4) {
        if (!this.f2767i || !z4) {
            return false;
        }
        this.f2780v.fling(0, 0, 0, (int) f5, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (this.f2780v.getFinalY() > this.f2762d.getHeight()) {
            b();
            this.f2784z.run();
        } else {
            b();
            this.f2783y.run();
        }
        this.f2768j = true;
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
        int i8 = this.f2769k + i5;
        this.f2769k = i8;
        setActionBarHideOffset(i8);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i4) {
        androidx.appcompat.app.N n4;
        j.m mVar;
        this.f2757A.f2261a = i4;
        this.f2769k = getActionBarHideOffset();
        b();
        InterfaceC0199f interfaceC0199f = this.f2779u;
        if (interfaceC0199f == null || (mVar = (n4 = (androidx.appcompat.app.N) interfaceC0199f).f2577t) == null) {
            return;
        }
        mVar.a();
        n4.f2577t = null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i4) {
        if ((i4 & 2) == 0 || this.f2762d.getVisibility() != 0) {
            return false;
        }
        return this.f2767i;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        if (!this.f2767i || this.f2768j) {
            return;
        }
        if (this.f2769k <= this.f2762d.getHeight()) {
            b();
            postDelayed(this.f2783y, 600L);
        } else {
            b();
            postDelayed(this.f2784z, 600L);
        }
    }

    @Override // android.view.View
    public final void onWindowSystemUiVisibilityChanged(int i4) {
        super.onWindowSystemUiVisibilityChanged(i4);
        f();
        int i5 = this.f2770l ^ i4;
        this.f2770l = i4;
        boolean z4 = (i4 & 4) == 0;
        boolean z5 = (i4 & 256) != 0;
        InterfaceC0199f interfaceC0199f = this.f2779u;
        if (interfaceC0199f != null) {
            ((androidx.appcompat.app.N) interfaceC0199f).f2573p = !z5;
            if (z4 || !z5) {
                androidx.appcompat.app.N n4 = (androidx.appcompat.app.N) interfaceC0199f;
                if (n4.f2574q) {
                    n4.f2574q = false;
                    n4.h0(true);
                }
            } else {
                androidx.appcompat.app.N n5 = (androidx.appcompat.app.N) interfaceC0199f;
                if (!n5.f2574q) {
                    n5.f2574q = true;
                    n5.h0(true);
                }
            }
        }
        if ((i5 & 256) == 0 || this.f2779u == null) {
            return;
        }
        WeakHashMap weakHashMap = K.S.f939a;
        K.H.c(this);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i4) {
        super.onWindowVisibilityChanged(i4);
        this.f2760b = i4;
        InterfaceC0199f interfaceC0199f = this.f2779u;
        if (interfaceC0199f != null) {
            ((androidx.appcompat.app.N) interfaceC0199f).f2572o = i4;
        }
    }

    @Override // K.InterfaceC0087t
    public final void p(View view, int i4, int i5, int i6, int i7, int i8, int[] iArr) {
        q(view, i4, i5, i6, i7, i8);
    }

    @Override // K.InterfaceC0086s
    public final void q(View view, int i4, int i5, int i6, int i7, int i8) {
        if (i8 == 0) {
            onNestedScroll(view, i4, i5, i6, i7);
        }
    }

    @Override // K.InterfaceC0086s
    public final boolean r(View view, View view2, int i4, int i5) {
        return i5 == 0 && onStartNestedScroll(view, view2, i4);
    }

    public void setActionBarHideOffset(int i4) {
        b();
        this.f2762d.setTranslationY(-Math.max(0, Math.min(i4, this.f2762d.getHeight())));
    }

    public void setActionBarVisibilityCallback(InterfaceC0199f interfaceC0199f) {
        this.f2779u = interfaceC0199f;
        if (getWindowToken() != null) {
            ((androidx.appcompat.app.N) this.f2779u).f2572o = this.f2760b;
            int i4 = this.f2770l;
            if (i4 != 0) {
                onWindowSystemUiVisibilityChanged(i4);
                WeakHashMap weakHashMap = K.S.f939a;
                K.H.c(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z4) {
        this.f2766h = z4;
    }

    public void setHideOnContentScrollEnabled(boolean z4) {
        if (z4 != this.f2767i) {
            this.f2767i = z4;
            if (z4) {
                return;
            }
            b();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i4) {
        f();
        g1 g1Var = (g1) this.f2763e;
        g1Var.f3090d = i4 != 0 ? Z2.I.o(g1Var.f3087a.getContext(), i4) : null;
        g1Var.d();
    }

    public void setLogo(int i4) {
        f();
        g1 g1Var = (g1) this.f2763e;
        g1Var.f3091e = i4 != 0 ? Z2.I.o(g1Var.f3087a.getContext(), i4) : null;
        g1Var.d();
    }

    public void setOverlayMode(boolean z4) {
        this.f2765g = z4;
    }

    public void setShowingForActionMode(boolean z4) {
    }

    public void setUiOptions(int i4) {
    }

    @Override // androidx.appcompat.widget.InterfaceC0214m0
    public void setWindowCallback(Window.Callback callback) {
        f();
        ((g1) this.f2763e).f3097k = callback;
    }

    @Override // androidx.appcompat.widget.InterfaceC0214m0
    public void setWindowTitle(CharSequence charSequence) {
        f();
        g1 g1Var = (g1) this.f2763e;
        if (g1Var.f3093g) {
            return;
        }
        g1Var.f3094h = charSequence;
        if ((g1Var.f3088b & 8) != 0) {
            Toolbar toolbar = g1Var.f3087a;
            toolbar.setTitle(charSequence);
            if (g1Var.f3093g) {
                K.S.i(toolbar.getRootView(), charSequence);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new C0201g(layoutParams);
    }

    public void setIcon(Drawable drawable) {
        f();
        g1 g1Var = (g1) this.f2763e;
        g1Var.f3090d = drawable;
        g1Var.d();
    }
}

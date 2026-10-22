package androidx.appcompat.widget;

import a1.k;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import com.stepos.stepclaw.R;
import e0.a0;
import e0.f0;
import e0.g0;
import e0.h;
import e0.h0;
import e0.i;
import e0.i0;
import e0.j;
import e0.j0;
import e0.t0;
import e0.u;
import e0.x0;
import g.b;
import g.c;
import g.d;
import g.e;
import g.e2;
import g.m0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@SuppressLint({"UnknownNullness"})
/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements h, i {
    public static final int[] A = {R.attr.actionBarSize, android.R.attr.windowContentOverlay};
    public static final x0 B;
    public static final Rect C;

    /* renamed from: a, reason: collision with root package name */
    public int f290a;

    /* renamed from: b, reason: collision with root package name */
    public ContentFrameLayout f291b;

    /* renamed from: c, reason: collision with root package name */
    public ActionBarContainer f292c;
    public m0 d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f293e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f294f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f295g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f296h;

    /* renamed from: j, reason: collision with root package name */
    public boolean f297j;

    /* renamed from: k, reason: collision with root package name */
    public int f298k;

    /* renamed from: l, reason: collision with root package name */
    public final Rect f299l;

    /* renamed from: m, reason: collision with root package name */
    public final Rect f300m;

    /* renamed from: n, reason: collision with root package name */
    public final Rect f301n;

    /* renamed from: o, reason: collision with root package name */
    public final Rect f302o;

    /* renamed from: p, reason: collision with root package name */
    public x0 f303p;

    /* renamed from: q, reason: collision with root package name */
    public x0 f304q;

    /* renamed from: r, reason: collision with root package name */
    public x0 f305r;

    /* renamed from: s, reason: collision with root package name */
    public x0 f306s;

    /* renamed from: t, reason: collision with root package name */
    public OverScroller f307t;

    /* renamed from: u, reason: collision with root package name */
    public ViewPropertyAnimator f308u;

    /* renamed from: v, reason: collision with root package name */
    public final k f309v;

    /* renamed from: w, reason: collision with root package name */
    public final b f310w;

    /* renamed from: x, reason: collision with root package name */
    public final b f311x;
    public final j y;
    public final e z;

    static {
        int i8 = Build.VERSION.SDK_INT;
        j0 i0Var = i8 >= 36 ? new i0() : i8 >= 35 ? new h0() : i8 >= 34 ? new g0() : new f0();
        i0Var.f(x.b.b(0, 1, 0, 1));
        B = i0Var.b();
        C = new Rect();
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f299l = new Rect();
        this.f300m = new Rect();
        this.f301n = new Rect();
        this.f302o = new Rect();
        new Rect();
        new Rect();
        new Rect();
        new Rect();
        x0 x0Var = x0.f2337b;
        this.f303p = x0Var;
        this.f304q = x0Var;
        this.f305r = x0Var;
        this.f306s = x0Var;
        this.f309v = new k(1, this);
        this.f310w = new b(this, 0);
        this.f311x = new b(this, 1);
        i(context);
        this.y = new j(0);
        e eVar = new e(context);
        eVar.setWillNotDraw(true);
        this.z = eVar;
        addView(eVar);
    }

    public static boolean g(View view, Rect rect, boolean z) {
        boolean z2;
        d dVar = (d) view.getLayoutParams();
        int i8 = ((ViewGroup.MarginLayoutParams) dVar).leftMargin;
        int i9 = rect.left;
        if (i8 != i9) {
            ((ViewGroup.MarginLayoutParams) dVar).leftMargin = i9;
            z2 = true;
        } else {
            z2 = false;
        }
        int i10 = ((ViewGroup.MarginLayoutParams) dVar).topMargin;
        int i11 = rect.top;
        if (i10 != i11) {
            ((ViewGroup.MarginLayoutParams) dVar).topMargin = i11;
            z2 = true;
        }
        int i12 = ((ViewGroup.MarginLayoutParams) dVar).rightMargin;
        int i13 = rect.right;
        if (i12 != i13) {
            ((ViewGroup.MarginLayoutParams) dVar).rightMargin = i13;
            z2 = true;
        }
        if (z) {
            int i14 = ((ViewGroup.MarginLayoutParams) dVar).bottomMargin;
            int i15 = rect.bottom;
            if (i14 != i15) {
                ((ViewGroup.MarginLayoutParams) dVar).bottomMargin = i15;
                return true;
            }
        }
        return z2;
    }

    @Override // e0.h
    public final void a(View view, View view2, int i8, int i9) {
        if (i9 == 0) {
            onNestedScrollAccepted(view, view2, i8);
        }
    }

    @Override // e0.h
    public final void b(View view, int i8) {
        if (i8 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof d;
    }

    @Override // e0.i
    public final void d(View view, int i8, int i9, int i10, int i11, int i12, int[] iArr) {
        e(view, i8, i9, i10, i11, i12);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int translationY;
        super.draw(canvas);
        if (this.f293e != null) {
            if (this.f292c.getVisibility() == 0) {
                translationY = (int) (this.f292c.getTranslationY() + this.f292c.getBottom() + 0.5f);
            } else {
                translationY = 0;
            }
            this.f293e.setBounds(0, translationY, getWidth(), this.f293e.getIntrinsicHeight() + translationY);
            this.f293e.draw(canvas);
        }
    }

    @Override // e0.h
    public final void e(View view, int i8, int i9, int i10, int i11, int i12) {
        if (i12 == 0) {
            onNestedScroll(view, i8, i9, i10, i11);
        }
    }

    @Override // e0.h
    public final boolean f(View view, View view2, int i8, int i9) {
        return i9 == 0 && onStartNestedScroll(view, view2, i8);
    }

    @Override // android.view.View
    public final boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new d(-1, -1);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new d(getContext(), attributeSet);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f292c;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        j jVar = this.y;
        return jVar.f2312c | jVar.f2311b;
    }

    public CharSequence getTitle() {
        j();
        return ((e2) this.d).f2691a.getTitle();
    }

    public final void h() {
        removeCallbacks(this.f310w);
        removeCallbacks(this.f311x);
        ViewPropertyAnimator viewPropertyAnimator = this.f308u;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public final void i(Context context) {
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(A);
        this.f290a = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        this.f293e = drawable;
        setWillNotDraw(drawable == null);
        typedArrayObtainStyledAttributes.recycle();
        this.f307t = new OverScroller(context);
    }

    public final void j() {
        m0 wrapper;
        if (this.f291b == null) {
            this.f291b = (ContentFrameLayout) findViewById(R.id.action_bar_activity_content);
            this.f292c = (ActionBarContainer) findViewById(R.id.action_bar_container);
            KeyEvent.Callback callbackFindViewById = findViewById(R.id.action_bar);
            if (callbackFindViewById instanceof m0) {
                wrapper = (m0) callbackFindViewById;
            } else {
                if (!(callbackFindViewById instanceof Toolbar)) {
                    throw new IllegalStateException("Can't make a decor toolbar out of ".concat(callbackFindViewById.getClass().getSimpleName()));
                }
                wrapper = ((Toolbar) callbackFindViewById).getWrapper();
            }
            this.d = wrapper;
        }
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        j();
        x0 x0VarC = x0.c(this, windowInsets);
        t0 t0Var = x0VarC.f2338a;
        boolean zG = g(this.f292c, new Rect(t0Var.j().f6232a, x0VarC.a(), t0Var.j().f6234c, t0Var.j().d), false);
        int[] iArr = a0.f2285a;
        Rect rect = this.f299l;
        u.a(this, x0VarC, rect);
        x0 x0VarM = t0Var.m(rect.left, rect.top, rect.right, rect.bottom);
        this.f303p = x0VarM;
        boolean z = true;
        if (!this.f304q.equals(x0VarM)) {
            this.f304q = this.f303p;
            zG = true;
        }
        Rect rect2 = this.f300m;
        if (rect2.equals(rect)) {
            z = zG;
        } else {
            rect2.set(rect);
        }
        if (z) {
            requestLayout();
        }
        return t0Var.a().f2338a.c().f2338a.b().b();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        i(getContext());
        int[] iArr = a0.f2285a;
        requestApplyInsets();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i8, int i9, int i10, int i11) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i13 = ((ViewGroup.MarginLayoutParams) dVar).leftMargin + paddingLeft;
                int i14 = ((ViewGroup.MarginLayoutParams) dVar).topMargin + paddingTop;
                childAt.layout(i13, i14, measuredWidth + i13, measuredHeight + i14);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00aa  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r13, int r14) {
        /*
            Method dump skipped, instructions count: 409
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarOverlayLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f3, float f7, boolean z) {
        if (!this.f296h || !z) {
            return false;
        }
        this.f307t.fling(0, 0, 0, (int) f7, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (this.f307t.getFinalY() > this.f292c.getHeight()) {
            h();
            this.f311x.run();
        } else {
            h();
            this.f310w.run();
        }
        this.f297j = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f3, float f7) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i8, int i9, int i10, int i11) {
        int i12 = this.f298k + i9;
        this.f298k = i12;
        setActionBarHideOffset(i12);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i8) {
        this.y.f2311b = i8;
        this.f298k = getActionBarHideOffset();
        h();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i8) {
        if ((i8 & 2) == 0 || this.f292c.getVisibility() != 0) {
            return false;
        }
        return this.f296h;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        if (!this.f296h || this.f297j) {
            return;
        }
        if (this.f298k <= this.f292c.getHeight()) {
            h();
            postDelayed(this.f310w, 600L);
        } else {
            h();
            postDelayed(this.f311x, 600L);
        }
    }

    @Override // android.view.View
    public final void onWindowSystemUiVisibilityChanged(int i8) {
        super.onWindowSystemUiVisibilityChanged(i8);
        j();
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i8) {
        super.onWindowVisibilityChanged(i8);
    }

    public void setActionBarHideOffset(int i8) {
        h();
        this.f292c.setTranslationY(-Math.max(0, Math.min(i8, this.f292c.getHeight())));
    }

    public void setActionBarVisibilityCallback(c cVar) {
        if (getWindowToken() != null) {
            throw null;
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.f295g = z;
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.f296h) {
            this.f296h = z;
            if (z) {
                return;
            }
            h();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i8) {
        j();
        e2 e2Var = (e2) this.d;
        e2Var.d = i8 != 0 ? b8.h.p(e2Var.f2691a.getContext(), i8) : null;
        e2Var.c();
    }

    public void setLogo(int i8) {
        j();
        e2 e2Var = (e2) this.d;
        e2Var.f2694e = i8 != 0 ? b8.h.p(e2Var.f2691a.getContext(), i8) : null;
        e2Var.c();
    }

    public void setOverlayMode(boolean z) {
        this.f294f = z;
    }

    public void setWindowCallback(Window.Callback callback) {
        j();
        ((e2) this.d).f2700k = callback;
    }

    public void setWindowTitle(CharSequence charSequence) {
        j();
        e2 e2Var = (e2) this.d;
        if (e2Var.f2696g) {
            return;
        }
        Toolbar toolbar = e2Var.f2691a;
        e2Var.f2697h = charSequence;
        if ((e2Var.f2692b & 8) != 0) {
            toolbar.setTitle(charSequence);
            if (e2Var.f2696g) {
                a0.f(toolbar.getRootView(), charSequence);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new d(layoutParams);
    }

    public void setIcon(Drawable drawable) {
        j();
        e2 e2Var = (e2) this.d;
        e2Var.d = drawable;
        e2Var.c();
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i8) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i8, int i9, int[] iArr) {
    }

    @Override // e0.h
    public final void c(View view, int i8, int i9, int[] iArr, int i10) {
    }
}

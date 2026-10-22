package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import bb.d;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import com.google.crypto.tink.shaded.protobuf.Reader;
import com.stepos.agentsafetycenter.R;
import f3.b;
import h.o0;
import h0.l0;
import java.lang.invoke.VarHandle;
import java.util.WeakHashMap;
import l.l;
import l.w;
import m.c;
import m.c1;
import m.e;
import m.f;
import m.k;
import m.q2;
import m.v2;
import n3.a1;
import n3.e0;
import n3.j1;
import n3.k0;
import n3.m1;
import n3.q;
import n3.r;
import n3.w0;
import n3.x0;
import n3.y0;
import n3.z0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements q, r {
    public static final int[] G = {R.attr.actionBarSize, android.R.attr.windowContentOverlay};
    public static final m1 H;
    public static final Rect I;
    public ViewPropertyAnimator A;
    public final d B;
    public final c C;
    public final c D;
    public final l0 E;
    public final f F;

    /* renamed from: c, reason: collision with root package name */
    public int f771c;

    /* renamed from: f, reason: collision with root package name */
    public int f772f;

    /* renamed from: g, reason: collision with root package name */
    public ContentFrameLayout f773g;

    /* renamed from: h, reason: collision with root package name */
    public ActionBarContainer f774h;
    public c1 i;

    /* renamed from: j, reason: collision with root package name */
    public Drawable f775j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f776k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f777l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f778m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f779n;

    /* renamed from: o, reason: collision with root package name */
    public int f780o;

    /* renamed from: p, reason: collision with root package name */
    public int f781p;

    /* renamed from: q, reason: collision with root package name */
    public final Rect f782q;

    /* renamed from: r, reason: collision with root package name */
    public final Rect f783r;

    /* renamed from: s, reason: collision with root package name */
    public final Rect f784s;

    /* renamed from: t, reason: collision with root package name */
    public final Rect f785t;

    /* renamed from: u, reason: collision with root package name */
    public m1 f786u;

    /* renamed from: v, reason: collision with root package name */
    public m1 f787v;

    /* renamed from: w, reason: collision with root package name */
    public m1 f788w;

    /* renamed from: x, reason: collision with root package name */
    public m1 f789x;

    /* renamed from: y, reason: collision with root package name */
    public m.d f790y;

    /* renamed from: z, reason: collision with root package name */
    public OverScroller f791z;

    static {
        int i = Build.VERSION.SDK_INT;
        a1 z0Var = i >= 36 ? new z0() : i >= 35 ? new y0() : i >= 34 ? new x0() : new w0();
        z0Var.e(b.a(0, 1, 0, 1));
        H = z0Var.b();
        I = new Rect();
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f772f = 0;
        this.f782q = new Rect();
        this.f783r = new Rect();
        this.f784s = new Rect();
        this.f785t = new Rect();
        new Rect();
        new Rect();
        new Rect();
        new Rect();
        m1 m1Var = m1.f8736b;
        this.f786u = m1Var;
        this.f787v = m1Var;
        this.f788w = m1Var;
        this.f789x = m1Var;
        this.B = new d(this, 3);
        c cVar = new c(0);
        cVar.f7885f = this;
        VarHandle.storeStoreFence();
        this.C = cVar;
        c cVar2 = new c(1);
        cVar2.f7885f = this;
        VarHandle.storeStoreFence();
        this.D = cVar2;
        c(context);
        this.E = new l0();
        f fVar = new f(context);
        fVar.setWillNotDraw(true);
        this.F = fVar;
        addView(fVar);
    }

    public static boolean a(View view, Rect rect, boolean z10) {
        boolean z11;
        e eVar = (e) view.getLayoutParams();
        int i = ((ViewGroup.MarginLayoutParams) eVar).leftMargin;
        int i3 = rect.left;
        if (i != i3) {
            ((ViewGroup.MarginLayoutParams) eVar).leftMargin = i3;
            z11 = true;
        } else {
            z11 = false;
        }
        int i10 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
        int i11 = rect.top;
        if (i10 != i11) {
            ((ViewGroup.MarginLayoutParams) eVar).topMargin = i11;
            z11 = true;
        }
        int i12 = ((ViewGroup.MarginLayoutParams) eVar).rightMargin;
        int i13 = rect.right;
        if (i12 != i13) {
            ((ViewGroup.MarginLayoutParams) eVar).rightMargin = i13;
            z11 = true;
        }
        if (z10) {
            int i14 = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
            int i15 = rect.bottom;
            if (i14 != i15) {
                ((ViewGroup.MarginLayoutParams) eVar).bottomMargin = i15;
                return true;
            }
        }
        return z11;
    }

    public final void b() {
        removeCallbacks(this.C);
        removeCallbacks(this.D);
        ViewPropertyAnimator viewPropertyAnimator = this.A;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public final void c(Context context) {
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(G);
        this.f771c = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        this.f775j = drawable;
        setWillNotDraw(drawable == null);
        typedArrayObtainStyledAttributes.recycle();
        this.f791z = new OverScroller(context);
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    public final void d(int i) {
        e();
        if (i == 2) {
            ((v2) this.i).getClass();
            Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
        } else if (i == 5) {
            ((v2) this.i).getClass();
            Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
        } else {
            if (i != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int translationY;
        super.draw(canvas);
        if (this.f775j != null) {
            if (this.f774h.getVisibility() == 0) {
                translationY = (int) (this.f774h.getTranslationY() + this.f774h.getBottom() + 0.5f);
            } else {
                translationY = 0;
            }
            this.f775j.setBounds(0, translationY, getWidth(), this.f775j.getIntrinsicHeight() + translationY);
            this.f775j.draw(canvas);
        }
    }

    public final void e() {
        c1 wrapper;
        if (this.f773g == null) {
            this.f773g = (ContentFrameLayout) findViewById(R.id.action_bar_activity_content);
            this.f774h = (ActionBarContainer) findViewById(R.id.action_bar_container);
            KeyEvent.Callback callbackFindViewById = findViewById(R.id.action_bar);
            if (callbackFindViewById instanceof c1) {
                wrapper = (c1) callbackFindViewById;
            } else {
                if (!(callbackFindViewById instanceof Toolbar)) {
                    od.f.e("Can't make a decor toolbar out of ".concat(callbackFindViewById.getClass().getSimpleName()));
                    return;
                }
                wrapper = ((Toolbar) callbackFindViewById).getWrapper();
            }
            this.i = wrapper;
        }
    }

    public final void f(Menu menu, w wVar) {
        e();
        v2 v2Var = (v2) this.i;
        Toolbar toolbar = v2Var.f8097a;
        if (v2Var.f8108m == null) {
            v2Var.f8108m = new k(toolbar.getContext());
        }
        k kVar = v2Var.f8108m;
        kVar.i = wVar;
        l lVar = (l) menu;
        if (lVar == null && toolbar.f804c == null) {
            return;
        }
        toolbar.f();
        l lVar2 = toolbar.f804c.f792t;
        if (lVar2 == lVar) {
            return;
        }
        if (lVar2 != null) {
            lVar2.r(toolbar.O);
            lVar2.r(toolbar.P);
        }
        if (toolbar.P == null) {
            toolbar.P = new q2(toolbar);
        }
        kVar.f7959u = true;
        Context context = toolbar.f812n;
        if (lVar != null) {
            lVar.b(kVar, context);
            lVar.b(toolbar.P, toolbar.f812n);
        } else {
            kVar.i(context, null);
            toolbar.P.i(toolbar.f812n, null);
            kVar.c();
            toolbar.P.c();
        }
        toolbar.f804c.setPopupTheme(toolbar.f813o);
        toolbar.f804c.setPresenter(kVar);
        toolbar.O = kVar;
        toolbar.t();
    }

    @Override // android.view.View
    public final boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new e(-1, -1);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f774h;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        l0 l0Var = this.E;
        return l0Var.f5053b | l0Var.f5052a;
    }

    public CharSequence getTitle() {
        e();
        return ((v2) this.i).f8097a.getTitle();
    }

    @Override // n3.q
    public final void j(int i, View view) {
        if (i == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // n3.r
    public final void k(View view, int i, int i3, int i10, int i11, int i12, int[] iArr) {
        l(view, i, i3, i10, i11, i12);
    }

    @Override // n3.q
    public final void l(View view, int i, int i3, int i10, int i11, int i12) {
        if (i12 == 0) {
            onNestedScroll(view, i, i3, i10, i11);
        }
    }

    @Override // n3.q
    public final boolean m(View view, View view2, int i, int i3) {
        return i3 == 0 && onStartNestedScroll(view, view2, i);
    }

    @Override // n3.q
    public final void n(View view, View view2, int i, int i3) {
        if (i3 == 0) {
            onNestedScrollAccepted(view, view2, i);
        }
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        e();
        m1 m1VarH = m1.h(this, windowInsets);
        boolean zA = a(this.f774h, new Rect(m1VarH.b(), m1VarH.d(), m1VarH.c(), m1VarH.a()), false);
        WeakHashMap weakHashMap = k0.f8724a;
        Rect rect = this.f782q;
        e0.a(this, m1VarH, rect);
        int i = rect.left;
        int i3 = rect.top;
        int i10 = rect.right;
        int i11 = rect.bottom;
        j1 j1Var = m1VarH.f8737a;
        m1 m1VarR = j1Var.r(i, i3, i10, i11);
        this.f786u = m1VarR;
        boolean z10 = true;
        if (!this.f787v.equals(m1VarR)) {
            this.f787v = this.f786u;
            zA = true;
        }
        Rect rect2 = this.f783r;
        if (rect2.equals(rect)) {
            z10 = zA;
        } else {
            rect2.set(rect);
        }
        if (z10) {
            requestLayout();
        }
        return j1Var.a().f8737a.c().f8737a.b().g();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        c(getContext());
        WeakHashMap weakHashMap = k0.f8724a;
        requestApplyInsets();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i, int i3, int i10, int i11) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i13 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin + paddingLeft;
                int i14 = ((ViewGroup.MarginLayoutParams) eVar).topMargin + paddingTop;
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
            Method dump skipped, instructions count: 397
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarOverlayLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f5, float f10, boolean z10) {
        if (!this.f778m || !z10) {
            return false;
        }
        this.f791z.fling(0, 0, 0, (int) f10, 0, 0, Integer.MIN_VALUE, Reader.READ_DONE);
        if (this.f791z.getFinalY() > this.f774h.getHeight()) {
            b();
            this.D.run();
        } else {
            b();
            this.C.run();
        }
        this.f779n = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f5, float f10) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i, int i3, int i10, int i11) {
        int i12 = this.f780o + i3;
        this.f780o = i12;
        setActionBarHideOffset(i12);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i) {
        o0 o0Var;
        k.k kVar;
        this.E.f5052a = i;
        this.f780o = getActionBarHideOffset();
        b();
        m.d dVar = this.f790y;
        if (dVar == null || (kVar = (o0Var = (o0) dVar).f4879s) == null) {
            return;
        }
        kVar.a();
        o0Var.f4879s = null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.f774h.getVisibility() != 0) {
            return false;
        }
        return this.f778m;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        if (!this.f778m || this.f779n) {
            return;
        }
        if (this.f780o <= this.f774h.getHeight()) {
            b();
            postDelayed(this.C, 600L);
        } else {
            b();
            postDelayed(this.D, 600L);
        }
    }

    @Override // android.view.View
    public final void onWindowSystemUiVisibilityChanged(int i) {
        super.onWindowSystemUiVisibilityChanged(i);
        e();
        int i3 = this.f781p ^ i;
        this.f781p = i;
        boolean z10 = (i & 4) == 0;
        boolean z11 = (i & ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH) != 0;
        m.d dVar = this.f790y;
        if (dVar != null) {
            o0 o0Var = (o0) dVar;
            o0Var.f4875o = !z11;
            if (z10 || !z11) {
                if (o0Var.f4876p) {
                    o0Var.f4876p = false;
                    o0Var.f(true);
                }
            } else if (!o0Var.f4876p) {
                o0Var.f4876p = true;
                o0Var.f(true);
            }
        }
        if ((i3 & ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH) == 0 || this.f790y == null) {
            return;
        }
        WeakHashMap weakHashMap = k0.f8724a;
        requestApplyInsets();
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.f772f = i;
        m.d dVar = this.f790y;
        if (dVar != null) {
            ((o0) dVar).f4874n = i;
        }
    }

    public void setActionBarHideOffset(int i) {
        b();
        this.f774h.setTranslationY(-Math.max(0, Math.min(i, this.f774h.getHeight())));
    }

    public void setActionBarVisibilityCallback(m.d dVar) {
        this.f790y = dVar;
        if (getWindowToken() != null) {
            ((o0) this.f790y).f4874n = this.f772f;
            int i = this.f781p;
            if (i != 0) {
                onWindowSystemUiVisibilityChanged(i);
                WeakHashMap weakHashMap = k0.f8724a;
                requestApplyInsets();
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z10) {
        this.f777l = z10;
    }

    public void setHideOnContentScrollEnabled(boolean z10) {
        if (z10 != this.f778m) {
            this.f778m = z10;
            if (z10) {
                return;
            }
            b();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i) {
        e();
        v2 v2Var = (v2) this.i;
        v2Var.f8100d = i != 0 ? id.k.v(i, v2Var.f8097a.getContext()) : null;
        v2Var.d();
    }

    public void setLogo(int i) {
        e();
        v2 v2Var = (v2) this.i;
        v2Var.f8101e = i != 0 ? id.k.v(i, v2Var.f8097a.getContext()) : null;
        v2Var.d();
    }

    public void setOverlayMode(boolean z10) {
        this.f776k = z10;
    }

    public void setWindowCallback(Window.Callback callback) {
        e();
        ((v2) this.i).f8106k = callback;
    }

    public void setWindowTitle(CharSequence charSequence) {
        e();
        v2 v2Var = (v2) this.i;
        if (v2Var.f8103g) {
            return;
        }
        Toolbar toolbar = v2Var.f8097a;
        v2Var.f8104h = charSequence;
        if ((v2Var.f8098b & 8) != 0) {
            toolbar.setTitle(charSequence);
            if (v2Var.f8103g) {
                k0.h(toolbar.getRootView(), charSequence);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new e(layoutParams);
    }

    public void setShowingForActionMode(boolean z10) {
    }

    public void setUiOptions(int i) {
    }

    public void setIcon(Drawable drawable) {
        e();
        v2 v2Var = (v2) this.i;
        v2Var.f8100d = drawable;
        v2Var.d();
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i, int i3, int[] iArr) {
    }

    @Override // n3.q
    public final void q(View view, int i, int i3, int[] iArr, int i10) {
    }
}

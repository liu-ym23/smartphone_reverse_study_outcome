package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
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
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.appcompat.view.menu.j;
import com.stepos.aiengine.R;
import java.util.WeakHashMap;
import v0.e0;
import v0.m0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@SuppressLint({"UnknownNullness"})
/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements d0, v0.o, v0.p {
    public static final int[] F = {R.attr.actionBarSize, android.R.attr.windowContentOverlay};
    public static final v0.m0 G;
    public static final Rect H;
    public final a A;
    public final b B;
    public final c C;
    public final v0.q D;
    public final f E;

    /* renamed from: a, reason: collision with root package name */
    public int f573a;

    /* renamed from: b, reason: collision with root package name */
    public int f574b;

    /* renamed from: c, reason: collision with root package name */
    public ContentFrameLayout f575c;

    /* renamed from: d, reason: collision with root package name */
    public ActionBarContainer f576d;

    /* renamed from: e, reason: collision with root package name */
    public e0 f577e;
    public Drawable h;

    /* renamed from: j, reason: collision with root package name */
    public boolean f578j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f579k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f580l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f581m;

    /* renamed from: n, reason: collision with root package name */
    public int f582n;

    /* renamed from: o, reason: collision with root package name */
    public int f583o;

    /* renamed from: p, reason: collision with root package name */
    public final Rect f584p;

    /* renamed from: q, reason: collision with root package name */
    public final Rect f585q;
    public final Rect r;

    /* renamed from: s, reason: collision with root package name */
    public final Rect f586s;

    /* renamed from: t, reason: collision with root package name */
    public v0.m0 f587t;

    /* renamed from: u, reason: collision with root package name */
    public v0.m0 f588u;

    /* renamed from: v, reason: collision with root package name */
    public v0.m0 f589v;

    /* renamed from: w, reason: collision with root package name */
    public v0.m0 f590w;

    /* renamed from: x, reason: collision with root package name */
    public d f591x;

    /* renamed from: y, reason: collision with root package name */
    public OverScroller f592y;
    public ViewPropertyAnimator z;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.z = null;
            actionBarOverlayLayout.f581m = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.z = null;
            actionBarOverlayLayout.f581m = false;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.q();
            actionBarOverlayLayout.z = actionBarOverlayLayout.f576d.animate().translationY(0.0f).setListener(actionBarOverlayLayout.A);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.q();
            actionBarOverlayLayout.z = actionBarOverlayLayout.f576d.animate().translationY(-actionBarOverlayLayout.f576d.getHeight()).setListener(actionBarOverlayLayout.A);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface d {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class e extends ViewGroup.MarginLayoutParams {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class f extends View {
        @Override // android.view.View
        public final int getWindowSystemUiVisibility() {
            return 0;
        }
    }

    static {
        int i10 = Build.VERSION.SDK_INT;
        m0.e dVar = i10 >= 34 ? new m0.d() : i10 >= 31 ? new m0.c() : new m0.b();
        dVar.f(n0.b.a(0, 1, 0, 1));
        G = dVar.b();
        H = new Rect();
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f574b = 0;
        this.f584p = new Rect();
        this.f585q = new Rect();
        this.r = new Rect();
        this.f586s = new Rect();
        new Rect();
        new Rect();
        new Rect();
        new Rect();
        v0.m0 m0Var = v0.m0.f13308b;
        this.f587t = m0Var;
        this.f588u = m0Var;
        this.f589v = m0Var;
        this.f590w = m0Var;
        this.A = new a();
        this.B = new b();
        this.C = new c();
        r(context);
        this.D = new v0.q();
        f fVar = new f(context);
        fVar.setWillNotDraw(true);
        this.E = fVar;
        addView(fVar);
    }

    public static boolean o(View view, Rect rect, boolean z) {
        boolean z3;
        e eVar = (e) view.getLayoutParams();
        int i10 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin;
        int i11 = rect.left;
        if (i10 != i11) {
            ((ViewGroup.MarginLayoutParams) eVar).leftMargin = i11;
            z3 = true;
        } else {
            z3 = false;
        }
        int i12 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
        int i13 = rect.top;
        if (i12 != i13) {
            ((ViewGroup.MarginLayoutParams) eVar).topMargin = i13;
            z3 = true;
        }
        int i14 = ((ViewGroup.MarginLayoutParams) eVar).rightMargin;
        int i15 = rect.right;
        if (i14 != i15) {
            ((ViewGroup.MarginLayoutParams) eVar).rightMargin = i15;
            z3 = true;
        }
        if (z) {
            int i16 = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
            int i17 = rect.bottom;
            if (i16 != i17) {
                ((ViewGroup.MarginLayoutParams) eVar).bottomMargin = i17;
                return true;
            }
        }
        return z3;
    }

    @Override // androidx.appcompat.widget.d0
    public final boolean a() {
        s();
        return this.f577e.a();
    }

    @Override // androidx.appcompat.widget.d0
    public final boolean b() {
        s();
        return this.f577e.b();
    }

    @Override // androidx.appcompat.widget.d0
    public final boolean c() {
        s();
        return this.f577e.c();
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    @Override // androidx.appcompat.widget.d0
    public final boolean d() {
        s();
        return this.f577e.d();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int translationY;
        super.draw(canvas);
        if (this.h != null) {
            if (this.f576d.getVisibility() == 0) {
                translationY = (int) (this.f576d.getTranslationY() + this.f576d.getBottom() + 0.5f);
            } else {
                translationY = 0;
            }
            this.h.setBounds(0, translationY, getWidth(), this.h.getIntrinsicHeight() + translationY);
            this.h.draw(canvas);
        }
    }

    @Override // androidx.appcompat.widget.d0
    public final void e() {
        s();
        this.f577e.e();
    }

    @Override // androidx.appcompat.widget.d0
    public final boolean f() {
        s();
        return this.f577e.f();
    }

    @Override // android.view.View
    public final boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    @Override // androidx.appcompat.widget.d0
    public final void g(int i10) {
        s();
        if (i10 == 2) {
            this.f577e.j();
        } else if (i10 == 5) {
            this.f577e.q();
        } else {
            if (i10 != 109) {
                return;
            }
            setOverlayMode(true);
        }
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
        ActionBarContainer actionBarContainer = this.f576d;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        v0.q qVar = this.D;
        return qVar.f13333b | qVar.f13332a;
    }

    public CharSequence getTitle() {
        s();
        return this.f577e.getTitle();
    }

    @Override // v0.o
    public final void h(int i10, View view) {
        if (i10 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // v0.o
    public final void i(View view, View view2, int i10, int i11) {
        if (i11 == 0) {
            onNestedScrollAccepted(view, view2, i10);
        }
    }

    @Override // v0.p
    public final void k(View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        l(view, i10, i11, i12, i13, i14);
    }

    @Override // v0.o
    public final void l(View view, int i10, int i11, int i12, int i13, int i14) {
        if (i14 == 0) {
            onNestedScroll(view, i10, i11, i12, i13);
        }
    }

    @Override // androidx.appcompat.widget.d0
    public final void m(Menu menu, j.a aVar) {
        s();
        this.f577e.m(menu, aVar);
    }

    @Override // androidx.appcompat.widget.d0
    public final void n() {
        s();
        this.f577e.l();
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        s();
        v0.m0 m0VarH = v0.m0.h(this, windowInsets);
        boolean zO = o(this.f576d, new Rect(m0VarH.b(), m0VarH.d(), m0VarH.c(), m0VarH.a()), false);
        WeakHashMap<View, v0.h0> weakHashMap = v0.e0.f13274a;
        Rect rect = this.f584p;
        e0.d.a(this, m0VarH, rect);
        int i10 = rect.left;
        int i11 = rect.top;
        int i12 = rect.right;
        int i13 = rect.bottom;
        m0.m mVar = m0VarH.f13309a;
        v0.m0 m0VarM = mVar.m(i10, i11, i12, i13);
        this.f587t = m0VarM;
        boolean z = true;
        if (!this.f588u.equals(m0VarM)) {
            this.f588u = this.f587t;
            zO = true;
        }
        Rect rect2 = this.f585q;
        if (rect2.equals(rect)) {
            z = zO;
        } else {
            rect2.set(rect);
        }
        if (z) {
            requestLayout();
        }
        return mVar.a().f13309a.c().f13309a.b().g();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        r(getContext());
        WeakHashMap<View, v0.h0> weakHashMap = v0.e0.f13274a;
        e0.c.b(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        q();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i10, int i11, int i12, int i13) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i15 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin + paddingLeft;
                int i16 = ((ViewGroup.MarginLayoutParams) eVar).topMargin + paddingTop;
                childAt.layout(i15, i16, measuredWidth + i15, measuredHeight + i16);
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
            Method dump skipped, instructions count: 371
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarOverlayLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f8, float f9, boolean z) {
        if (!this.f580l || !z) {
            return false;
        }
        this.f592y.fling(0, 0, 0, (int) f9, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (this.f592y.getFinalY() > this.f576d.getHeight()) {
            q();
            this.C.run();
        } else {
            q();
            this.B.run();
        }
        this.f581m = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f8, float f9) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i10, int i11, int i12, int i13) {
        int i14 = this.f582n + i11;
        this.f582n = i14;
        setActionBarHideOffset(i14);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i10) {
        androidx.appcompat.app.w wVar;
        k.g gVar;
        this.D.f13332a = i10;
        this.f582n = getActionBarHideOffset();
        q();
        d dVar = this.f591x;
        if (dVar == null || (gVar = (wVar = (androidx.appcompat.app.w) dVar).f389s) == null) {
            return;
        }
        gVar.a();
        wVar.f389s = null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i10) {
        if ((i10 & 2) == 0 || this.f576d.getVisibility() != 0) {
            return false;
        }
        return this.f580l;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        if (!this.f580l || this.f581m) {
            return;
        }
        if (this.f582n <= this.f576d.getHeight()) {
            q();
            postDelayed(this.B, 600L);
        } else {
            q();
            postDelayed(this.C, 600L);
        }
    }

    @Override // android.view.View
    @Deprecated
    public final void onWindowSystemUiVisibilityChanged(int i10) {
        super.onWindowSystemUiVisibilityChanged(i10);
        s();
        int i11 = this.f583o ^ i10;
        this.f583o = i10;
        boolean z = (i10 & 4) == 0;
        boolean z3 = (i10 & 256) != 0;
        d dVar = this.f591x;
        if (dVar != null) {
            androidx.appcompat.app.w wVar = (androidx.appcompat.app.w) dVar;
            wVar.f386o = !z3;
            if (z || !z3) {
                if (wVar.f387p) {
                    wVar.f387p = false;
                    wVar.g(true);
                }
            } else if (!wVar.f387p) {
                wVar.f387p = true;
                wVar.g(true);
            }
        }
        if ((i11 & 256) == 0 || this.f591x == null) {
            return;
        }
        WeakHashMap<View, v0.h0> weakHashMap = v0.e0.f13274a;
        e0.c.b(this);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        this.f574b = i10;
        d dVar = this.f591x;
        if (dVar != null) {
            ((androidx.appcompat.app.w) dVar).f385n = i10;
        }
    }

    @Override // v0.o
    public final boolean p(View view, View view2, int i10, int i11) {
        return i11 == 0 && onStartNestedScroll(view, view2, i10);
    }

    public final void q() {
        removeCallbacks(this.B);
        removeCallbacks(this.C);
        ViewPropertyAnimator viewPropertyAnimator = this.z;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public final void r(Context context) {
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(F);
        this.f573a = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        this.h = drawable;
        setWillNotDraw(drawable == null);
        typedArrayObtainStyledAttributes.recycle();
        this.f592y = new OverScroller(context);
    }

    public final void s() {
        e0 wrapper;
        if (this.f575c == null) {
            this.f575c = (ContentFrameLayout) findViewById(R.id.action_bar_activity_content);
            this.f576d = (ActionBarContainer) findViewById(R.id.action_bar_container);
            KeyEvent.Callback callbackFindViewById = findViewById(R.id.action_bar);
            if (callbackFindViewById instanceof e0) {
                wrapper = (e0) callbackFindViewById;
            } else {
                if (!(callbackFindViewById instanceof Toolbar)) {
                    throw new IllegalStateException("Can't make a decor toolbar out of ".concat(callbackFindViewById.getClass().getSimpleName()));
                }
                wrapper = ((Toolbar) callbackFindViewById).getWrapper();
            }
            this.f577e = wrapper;
        }
    }

    public void setActionBarHideOffset(int i10) {
        q();
        this.f576d.setTranslationY(-Math.max(0, Math.min(i10, this.f576d.getHeight())));
    }

    public void setActionBarVisibilityCallback(d dVar) {
        this.f591x = dVar;
        if (getWindowToken() != null) {
            ((androidx.appcompat.app.w) this.f591x).f385n = this.f574b;
            int i10 = this.f583o;
            if (i10 != 0) {
                onWindowSystemUiVisibilityChanged(i10);
                WeakHashMap<View, v0.h0> weakHashMap = v0.e0.f13274a;
                e0.c.b(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.f579k = z;
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.f580l) {
            this.f580l = z;
            if (z) {
                return;
            }
            q();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i10) {
        s();
        this.f577e.setIcon(i10);
    }

    public void setLogo(int i10) {
        s();
        this.f577e.o(i10);
    }

    public void setOverlayMode(boolean z) {
        this.f578j = z;
    }

    @Override // androidx.appcompat.widget.d0
    public void setWindowCallback(Window.Callback callback) {
        s();
        this.f577e.setWindowCallback(callback);
    }

    @Override // androidx.appcompat.widget.d0
    public void setWindowTitle(CharSequence charSequence) {
        s();
        this.f577e.setWindowTitle(charSequence);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new e(layoutParams);
    }

    public void setIcon(Drawable drawable) {
        s();
        this.f577e.setIcon(drawable);
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i10) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i10, int i11, int[] iArr) {
    }

    @Override // v0.o
    public final void j(View view, int i10, int i11, int[] iArr, int i12) {
    }
}

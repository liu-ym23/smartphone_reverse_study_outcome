package stepos.support.v7.widget;

import N1.h;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Insets;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.H;
import androidx.core.view.Y;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import stepos.support.v7.view.menu.h;

/* loaded from: classes.dex */
public class ActionBarCoordinatorLayout extends CoordinatorLayout implements l {

    /* renamed from: R, reason: collision with root package name */
    static final int[] f21449R = {X4.a.f5828d, X4.a.f5830f};

    /* renamed from: A, reason: collision with root package name */
    private ActionBarContainer f21450A;

    /* renamed from: B, reason: collision with root package name */
    private StepOSCollapsingToolbarLayout f21451B;

    /* renamed from: C, reason: collision with root package name */
    private ActionBarDropDownView f21452C;

    /* renamed from: D, reason: collision with root package name */
    private m f21453D;

    /* renamed from: E, reason: collision with root package name */
    private FrameLayout f21454E;

    /* renamed from: F, reason: collision with root package name */
    private final Rect f21455F;

    /* renamed from: G, reason: collision with root package name */
    private final Rect f21456G;

    /* renamed from: H, reason: collision with root package name */
    private final Rect f21457H;

    /* renamed from: I, reason: collision with root package name */
    private final Rect f21458I;

    /* renamed from: J, reason: collision with root package name */
    private final Rect f21459J;

    /* renamed from: K, reason: collision with root package name */
    private boolean f21460K;

    /* renamed from: L, reason: collision with root package name */
    private boolean f21461L;

    /* renamed from: M, reason: collision with root package name */
    private boolean f21462M;

    /* renamed from: Q, reason: collision with root package name */
    int f21463Q;

    /* renamed from: y, reason: collision with root package name */
    private FitsBottomContentLayout f21464y;

    /* renamed from: z, reason: collision with root package name */
    private StepOSAppBarLayout f21465z;

    public static class StepOSScrollingViewBehavior extends AppBarLayout.ScrollingViewBehavior {
        public StepOSScrollingViewBehavior() {
        }

        @Override // com.google.android.material.appbar.d, com.google.android.material.appbar.e
        protected void layoutChild(CoordinatorLayout coordinatorLayout, View view, int i5) {
            super.layoutChild(coordinatorLayout, view, i5);
            List<View> listE = coordinatorLayout.E(view);
            try {
                h.g gVarB = N1.h.b(this);
                if (((Integer) gVarB.a("getOverlapPixelsForOffset", View.class).a(this, (View) gVarB.a("findFirstDependency", List.class).a(this, listE))).intValue() == 0) {
                    view.layout(view.getLeft(), view.getTop() - getOverlayTop(), view.getRight(), view.getBottom() - getOverlayTop());
                }
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e6) {
                Log.e("ActionBarCoordinatorLayout", "StepOSScrollingViewBehavior layoutChild error :" + e6.getMessage());
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public Y onApplyWindowInsets(CoordinatorLayout coordinatorLayout, View view, Y y5) {
            return super.onApplyWindowInsets(coordinatorLayout, view, y5);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
            H.V(view, (view2.getBottom() - view.getTop()) - getOverlayTop());
            return false;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior, com.google.android.material.appbar.d, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i5, int i6, int i7, int i8) {
            int i9 = view.getLayoutParams().height;
            boolean zOnMeasureChild = super.onMeasureChild(coordinatorLayout, view, i5, i6, i7, i8);
            coordinatorLayout.X(view, i5, i6, View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight() + getOverlayTop(), i9 == -1 ? 1073741824 : Integer.MIN_VALUE), i8);
            return zOnMeasureChild;
        }

        public StepOSScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    class a implements AppBarLayout.h {
        a() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.b
        public void a(AppBarLayout appBarLayout, int i5) {
            ActionBarCoordinatorLayout.this.f21460K = i5 == 0;
        }
    }

    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ StepOSRecyclerView f21467a;

        b(StepOSRecyclerView stepOSRecyclerView) {
            this.f21467a = stepOSRecyclerView;
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarCoordinatorLayout.this.r0(this.f21467a);
        }
    }

    class c extends RecyclerView.OnScrollListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ StepOSRecyclerView f21469a;

        c(StepOSRecyclerView stepOSRecyclerView) {
            this.f21469a = stepOSRecyclerView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i5, int i6) {
            super.onScrolled(recyclerView, i5, i6);
            ActionBarCoordinatorLayout.this.r0(this.f21469a);
        }
    }

    public ActionBarCoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private StepOSRecyclerView p0(ViewGroup viewGroup) {
        StepOSRecyclerView stepOSRecyclerViewP0;
        for (int i5 = 0; i5 < viewGroup.getChildCount(); i5++) {
            View childAt = viewGroup.getChildAt(i5);
            if (childAt instanceof StepOSRecyclerView) {
                return (StepOSRecyclerView) childAt;
            }
            if ((childAt instanceof ViewGroup) && (stepOSRecyclerViewP0 = p0((ViewGroup) childAt)) != null) {
                return stepOSRecyclerViewP0;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private m q0(View view) {
        if (view instanceof m) {
            return (m) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0(RecyclerView recyclerView) {
        LinearLayoutManager linearLayoutManager;
        View viewFindViewByPosition;
        if ((recyclerView.getLayoutManager() instanceof LinearLayoutManager) && (linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager()) != null) {
            int itemCount = linearLayoutManager.getItemCount();
            int iFindLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            if (itemCount <= 0 || iFindLastVisibleItemPosition != itemCount - 1 || (viewFindViewByPosition = linearLayoutManager.findViewByPosition(linearLayoutManager.findLastVisibleItemPosition())) == null) {
                return;
            }
            int[] iArr = new int[2];
            viewFindViewByPosition.getLocationInWindow(iArr);
            int measuredHeight = iArr[1] + viewFindViewByPosition.getMeasuredHeight();
            View viewFindViewById = this.f21450A.findViewById(X4.f.f5975W);
            int[] iArr2 = new int[2];
            viewFindViewById.getLocationInWindow(iArr2);
            int i5 = iArr2[1];
            int i6 = measuredHeight - i5;
            viewFindViewById.setAlpha(i6 > 100 ? 1.0f : i5 > measuredHeight ? 0.0f : i6 / 100.0f);
        }
    }

    private void t0() {
        if (this.f21463Q > 100) {
            return;
        }
        float fAbs = Math.abs(r0) / 100.0f;
        View viewFindViewById = findViewById(X4.f.f5976X);
        if (viewFindViewById != null) {
            viewFindViewById.setAlpha(fAbs);
        }
    }

    @Override // stepos.support.v7.widget.l
    public boolean a() {
        s0();
        return this.f21453D.a();
    }

    @Override // stepos.support.v7.widget.l
    public void b() {
        s0();
        this.f21453D.b();
    }

    @Override // stepos.support.v7.widget.l
    public boolean c() {
        s0();
        return this.f21453D.c();
    }

    @Override // stepos.support.v7.widget.l
    public boolean d() {
        s0();
        return this.f21453D.d();
    }

    @Override // android.view.ViewGroup, android.view.View
    public WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        boolean z5;
        WindowInsets windowInsetsDispatchApplyWindowInsets = super.dispatchApplyWindowInsets(windowInsets);
        Rect rect = new Rect();
        Insets insets = windowInsets.getInsets(WindowInsets.Type.systemBars());
        rect.set(insets.left, insets.top, insets.right, insets.bottom);
        this.f21458I.set(rect);
        int i5 = windowInsets.getInsets(WindowInsets.Type.ime()).bottom;
        boolean z6 = true;
        if (i5 > insets.bottom) {
            rect.bottom = i5;
            z5 = true;
        } else {
            z5 = false;
        }
        Rect rect2 = this.f21456G;
        rect2.top = rect.top;
        rect2.bottom = rect.bottom;
        this.f21459J.set(rect);
        boolean zEquals = this.f21457H.equals(this.f21456G);
        ActionBarContainer actionBarContainer = this.f21450A;
        boolean zG = actionBarContainer != null ? C.g(actionBarContainer, this.f21458I, true, false, true, true) : false;
        this.f21453D.z(this.f21450A);
        this.f21457H.set(this.f21456G);
        if (this.f21462M) {
            int measuredHeight = this.f21465z.getMeasuredHeight();
            int totalScrollRange = this.f21465z.getTotalScrollRange();
            if (((CoordinatorLayout.f) this.f21454E.getLayoutParams()).f() instanceof StepOSScrollingViewBehavior) {
                this.f21457H.top = measuredHeight - totalScrollRange;
            }
        }
        ActionBarContainer actionBarContainer2 = this.f21450A;
        if (actionBarContainer2 != null && actionBarContainer2.getVisibility() != 8) {
            int measuredHeight2 = this.f21450A.getMeasuredHeight();
            int i6 = this.f21456G.bottom;
            if (measuredHeight2 > i6) {
                measuredHeight2 -= i6;
            }
            if (!z5) {
                this.f21457H.bottom += measuredHeight2;
            }
        }
        if (zEquals) {
            z6 = zG;
        } else {
            this.f21455F.set(this.f21457H);
            this.f21464y.dispatchFitSystemWindows(this.f21455F);
        }
        if (z6) {
            requestLayout();
        }
        return windowInsetsDispatchApplyWindowInsets;
    }

    @Override // stepos.support.v7.widget.l
    public boolean e() {
        s0();
        return this.f21453D.e();
    }

    @Override // stepos.support.v7.widget.l
    public boolean f() {
        s0();
        return this.f21453D.f();
    }

    public ActionBarDropDownView getActionBarDropDownView() {
        return this.f21452C;
    }

    public CharSequence getTitle() {
        s0();
        return this.f21453D.getTitle();
    }

    @Override // stepos.support.v7.widget.l
    public void h(int i5) {
    }

    @Override // stepos.support.v7.widget.l
    public void i() {
        s0();
        this.f21453D.h();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, androidx.core.view.InterfaceC0476v
    public void o(View view, int i5, int i6, int[] iArr, int i7) {
        super.o(view, i5, i6, iArr, i7);
        if (iArr[1] != 0) {
            return;
        }
        if (i6 >= 0) {
            this.f21463Q += i6;
        } else {
            int i8 = this.f21463Q;
            if (i8 > 0) {
                this.f21463Q = i8 + i6;
            }
        }
        t0();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f21461L) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
        StepOSRecyclerView stepOSRecyclerViewP0;
        super.onLayout(z5, i5, i6, i7, i8);
        if (this.f21450A.getVisibility() == 8 || (stepOSRecyclerViewP0 = p0(this.f21464y)) == null) {
            return;
        }
        stepOSRecyclerViewP0.post(new b(stepOSRecyclerViewP0));
        stepOSRecyclerViewP0.addOnScrollListener(new c(stepOSRecyclerViewP0));
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View
    protected void onMeasure(int i5, int i6) {
        int measuredHeight;
        super.onMeasure(i5, i6);
        ActionBarContainer actionBarContainer = this.f21450A;
        if (actionBarContainer == null || actionBarContainer.getVisibility() == 8) {
            measuredHeight = 0;
        } else {
            measuredHeight = this.f21450A.getMeasuredHeight();
            int i7 = this.f21456G.bottom;
            if (measuredHeight > i7) {
                measuredHeight -= i7;
            }
        }
        this.f21457H.set(this.f21456G);
        if (this.f21462M) {
            int measuredHeight2 = this.f21465z.getMeasuredHeight();
            int totalScrollRange = this.f21465z.getTotalScrollRange();
            CoordinatorLayout.c cVarF = ((CoordinatorLayout.f) this.f21454E.getLayoutParams()).f();
            if (cVarF instanceof StepOSScrollingViewBehavior) {
                int i8 = measuredHeight2 - totalScrollRange;
                ((StepOSScrollingViewBehavior) cVarF).setOverlayTop(i8);
                this.f21457H.top = i8;
            }
        }
        if (this.f21456G.bottom <= this.f21458I.bottom) {
            this.f21457H.bottom += measuredHeight;
        }
        if (!this.f21455F.equals(this.f21457H) || getHeight() == 0) {
            this.f21455F.set(this.f21457H);
            this.f21464y.dispatchFitSystemWindows(this.f21455F);
            super.onMeasure(i5, i6);
        }
        if (this.f21460K) {
            this.f21459J.top = this.f21465z.getMeasuredHeight() - this.f21456G.top;
        } else {
            this.f21459J.top = (int) (findViewById(X4.f.f5979a).getMeasuredHeight() + N1.i.a(54.0f, getContext()));
        }
        ActionBarDropDownView actionBarDropDownView = this.f21452C;
        if (actionBarDropDownView == null || actionBarDropDownView.getVisibility() == 8) {
            return;
        }
        C.g(this.f21452C, this.f21459J, true, true, true, true);
        measureChildWithMargins(this.f21452C, i5, 0, i6, 0);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f21461L) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // stepos.support.v7.widget.l
    public void r(Menu menu, h.a aVar) {
        s0();
        this.f21453D.r(menu, aVar);
    }

    @Override // stepos.support.v7.widget.l
    public void s() {
    }

    void s0() {
        if (this.f21464y == null) {
            this.f21464y = (FitsBottomContentLayout) findViewById(g.f.f16920b);
            this.f21465z = (StepOSAppBarLayout) findViewById(X4.f.f6003m);
            this.f21451B = (StepOSCollapsingToolbarLayout) findViewById(X4.f.f5981b);
            this.f21453D = q0(findViewById(X4.f.f5979a));
            this.f21450A = (ActionBarContainer) findViewById(X4.f.f5966N);
            this.f21454E = (FrameLayout) findViewById(X4.f.f6013r);
            this.f21464y.setActionBarOverlay(this.f21462M);
            this.f21464y.setInterceptNestedScrollEnabled(!this.f21461L);
            this.f21465z.g(new a());
        }
    }

    public void setActionBarCanScroll(boolean z5) {
        this.f21461L = z5;
        this.f21464y.setInterceptNestedScrollEnabled(!z5);
    }

    public void setActionBarFitStatusBar(boolean z5) {
    }

    @Override // stepos.support.v7.widget.l
    public void setBackTopBackground(Drawable drawable) {
    }

    @Override // stepos.support.v7.widget.l
    public void setBackTopClickCallback(View.OnClickListener onClickListener) {
    }

    @Override // stepos.support.v7.widget.l
    public void setBackTopEnable(boolean z5) {
    }

    public void setDropDownShowStart(int i5) {
    }

    public void setIcon(int i5) {
        s0();
        this.f21453D.setIcon(i5);
    }

    public void setLogo(int i5) {
        s0();
        this.f21453D.k(i5);
    }

    public void setShowingForActionMode(boolean z5) {
    }

    public void setSplitBarFitSystemWindows(boolean z5) {
    }

    public void setTransStatusBarInStepOS3(boolean z5) {
    }

    public void setUiOptions(int i5) {
        int i6 = 0;
        boolean z5 = i5 == 2;
        s0();
        StepOSCollapsingToolbarLayout stepOSCollapsingToolbarLayout = this.f21451B;
        ActionBarContextView actionBarContextView = stepOSCollapsingToolbarLayout != null ? (ActionBarContextView) stepOSCollapsingToolbarLayout.findViewById(X4.f.f5991g) : (ActionBarContextView) findViewById(X4.f.f5991g);
        if (z5) {
            ActionBarContainer actionBarContainer = this.f21450A;
            if (actionBarContainer == null) {
                Log.e("ActionBarCoordinatorLayout", "Requested split action bar with incompatible window decor! Ignoring request.");
                return;
            }
            this.f21453D.C(actionBarContainer);
        } else {
            this.f21453D.C(null);
            if (!actionBarContextView.q()) {
                actionBarContextView.setSplitView(null);
            }
        }
        this.f21453D.L(z5);
        ActionBarContainer actionBarContainer2 = this.f21450A;
        if (actionBarContainer2 != null) {
            if (!this.f21453D.v() && !actionBarContextView.q() && !z5) {
                i6 = 8;
            }
            actionBarContainer2.setVisibility(i6);
        }
    }

    @Override // stepos.support.v7.widget.l
    public void setWindowCallback(Window.Callback callback) {
        s0();
        this.f21453D.setWindowCallback(callback);
    }

    @Override // stepos.support.v7.widget.l
    public void setWindowTitle(CharSequence charSequence) {
        s0();
        this.f21453D.setWindowTitle(charSequence);
    }

    @Override // stepos.support.v7.widget.l
    public void t(Menu menu, h.a aVar) {
        s0();
        this.f21453D.E(menu, aVar);
        if (this.f21453D.y() && menu == null) {
            this.f21453D.L(false);
        }
    }

    @Override // stepos.support.v7.widget.l
    public void u() {
    }

    public ActionBarCoordinatorLayout(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f21455F = new Rect();
        this.f21456G = new Rect();
        this.f21457H = new Rect();
        this.f21458I = new Rect();
        this.f21459J = new Rect();
        this.f21460K = true;
        this.f21461L = true;
        this.f21462M = true;
        this.f21463Q = 0;
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f21449R);
        this.f21461L = typedArrayObtainStyledAttributes.getBoolean(0, this.f21461L);
        this.f21462M = typedArrayObtainStyledAttributes.getBoolean(1, this.f21462M);
        typedArrayObtainStyledAttributes.recycle();
    }

    public void setIcon(Drawable drawable) {
        s0();
        this.f21453D.setIcon(drawable);
    }
}

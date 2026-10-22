package stepos.support.v7.widget;

import O6.r;
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
import androidx.annotation.Keep;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.N;
import androidx.core.view.a0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import stepos.support.v7.appcompat.R$attr;
import stepos.support.v7.appcompat.R$id;
import stepos.support.v7.view.menu.g;

/* loaded from: classes5.dex */
public class ActionBarCoordinatorLayout extends CoordinatorLayout implements j {

    /* renamed from: O, reason: collision with root package name */
    public static final int[] f41067O = {R$attr.steposActionBarCanScroll, R$attr.steposActionBarOverlayMode};

    /* renamed from: A, reason: collision with root package name */
    public ActionBarContainer f41068A;

    /* renamed from: B, reason: collision with root package name */
    public StepOSCollapsingToolbarLayout f41069B;

    /* renamed from: C, reason: collision with root package name */
    public ActionBarDropDownView f41070C;

    /* renamed from: D, reason: collision with root package name */
    public k f41071D;

    /* renamed from: E, reason: collision with root package name */
    public FrameLayout f41072E;

    /* renamed from: F, reason: collision with root package name */
    public final Rect f41073F;

    /* renamed from: G, reason: collision with root package name */
    public final Rect f41074G;

    /* renamed from: H, reason: collision with root package name */
    public final Rect f41075H;

    /* renamed from: I, reason: collision with root package name */
    public final Rect f41076I;

    /* renamed from: J, reason: collision with root package name */
    public final Rect f41077J;

    /* renamed from: K, reason: collision with root package name */
    public boolean f41078K;

    /* renamed from: L, reason: collision with root package name */
    public boolean f41079L;

    /* renamed from: M, reason: collision with root package name */
    public boolean f41080M;

    /* renamed from: N, reason: collision with root package name */
    public int f41081N;

    /* renamed from: y, reason: collision with root package name */
    public FitsBottomContentLayout f41082y;

    /* renamed from: z, reason: collision with root package name */
    public StepOSAppBarLayout f41083z;

    @Keep
    public static class StepOSScrollingViewBehavior extends AppBarLayout.ScrollingViewBehavior {
        public StepOSScrollingViewBehavior() {
        }

        @Override // com.google.android.material.appbar.d, com.google.android.material.appbar.e
        public void layoutChild(CoordinatorLayout coordinatorLayout, View view, int i10) {
            super.layoutChild(coordinatorLayout, view, i10);
            List<View> listY = coordinatorLayout.y(view);
            try {
                r.g gVarB = O6.r.b(this);
                if (((Integer) gVarB.a("getOverlapPixelsForOffset", View.class).a(this, (View) gVarB.a("findFirstDependency", List.class).a(this, listY))).intValue() == 0) {
                    view.layout(view.getLeft(), view.getTop() - getOverlayTop(), view.getRight(), view.getBottom() - getOverlayTop());
                }
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e10) {
                Log.e("ActionBarCoordinatorLayout", "StepOSScrollingViewBehavior layoutChild error :" + e10.getMessage());
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public a0 onApplyWindowInsets(CoordinatorLayout coordinatorLayout, View view, a0 a0Var) {
            return super.onApplyWindowInsets(coordinatorLayout, view, a0Var);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
            N.T(view, (view2.getBottom() - view.getTop()) - getOverlayTop());
            return false;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior, com.google.android.material.appbar.d, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i10, int i11, int i12, int i13) {
            int i14 = view.getLayoutParams().height;
            boolean zOnMeasureChild = super.onMeasureChild(coordinatorLayout, view, i10, i11, i12, i13);
            coordinatorLayout.R(view, i10, i11, View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight() + getOverlayTop(), i14 == -1 ? 1073741824 : Integer.MIN_VALUE), i13);
            return zOnMeasureChild;
        }

        public StepOSScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public class a implements AppBarLayout.h {
        public a() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.b
        public void a(AppBarLayout appBarLayout, int i10) {
            ActionBarCoordinatorLayout.this.f41078K = i10 == 0;
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StepOSRecyclerView f41085a;

        public b(StepOSRecyclerView stepOSRecyclerView) {
            this.f41085a = stepOSRecyclerView;
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarCoordinatorLayout.this.l0(this.f41085a);
        }
    }

    public class c extends RecyclerView.OnScrollListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StepOSRecyclerView f41087a;

        public c(StepOSRecyclerView stepOSRecyclerView) {
            this.f41087a = stepOSRecyclerView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
            super.onScrolled(recyclerView, i10, i11);
            ActionBarCoordinatorLayout.this.l0(this.f41087a);
        }
    }

    public ActionBarCoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // stepos.support.v7.widget.j
    public boolean a() {
        m0();
        return this.f41071D.a();
    }

    @Override // stepos.support.v7.widget.j
    public boolean b() {
        m0();
        return this.f41071D.b();
    }

    @Override // stepos.support.v7.widget.j
    public boolean c() {
        m0();
        return this.f41071D.c();
    }

    @Override // stepos.support.v7.widget.j
    public boolean d() {
        m0();
        return this.f41071D.d();
    }

    @Override // android.view.ViewGroup, android.view.View
    public WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        boolean z10;
        WindowInsets windowInsetsDispatchApplyWindowInsets = super.dispatchApplyWindowInsets(windowInsets);
        Rect rect = new Rect();
        Insets insets = windowInsets.getInsets(WindowInsets.Type.systemBars());
        rect.set(insets.left, insets.top, insets.right, insets.bottom);
        this.f41076I.set(rect);
        int i10 = windowInsets.getInsets(WindowInsets.Type.ime()).bottom;
        boolean z11 = true;
        if (i10 > insets.bottom) {
            rect.bottom = i10;
            z10 = true;
        } else {
            z10 = false;
        }
        Rect rect2 = this.f41074G;
        rect2.top = rect.top;
        rect2.bottom = rect.bottom;
        this.f41077J.set(rect);
        boolean zEquals = this.f41075H.equals(this.f41074G);
        ActionBarContainer actionBarContainer = this.f41068A;
        boolean zG = actionBarContainer != null ? y.g(actionBarContainer, this.f41076I, true, false, true, true) : false;
        this.f41071D.A(this.f41068A);
        this.f41075H.set(this.f41074G);
        if (this.f41080M) {
            int measuredHeight = this.f41083z.getMeasuredHeight();
            int totalScrollRange = this.f41083z.getTotalScrollRange();
            if (((CoordinatorLayout.f) this.f41072E.getLayoutParams()).f() instanceof StepOSScrollingViewBehavior) {
                this.f41075H.top = measuredHeight - totalScrollRange;
            }
        }
        ActionBarContainer actionBarContainer2 = this.f41068A;
        if (actionBarContainer2 != null && actionBarContainer2.getVisibility() != 8) {
            int measuredHeight2 = this.f41068A.getMeasuredHeight();
            int i11 = this.f41074G.bottom;
            if (measuredHeight2 > i11) {
                measuredHeight2 -= i11;
            }
            if (!z10) {
                this.f41075H.bottom += measuredHeight2;
            }
        }
        if (zEquals) {
            z11 = zG;
        } else {
            this.f41073F.set(this.f41075H);
            this.f41082y.dispatchFitSystemWindows(this.f41073F);
        }
        if (z11) {
            requestLayout();
        }
        return windowInsetsDispatchApplyWindowInsets;
    }

    @Override // stepos.support.v7.widget.j
    public void e() {
        m0();
        this.f41071D.e();
    }

    @Override // stepos.support.v7.widget.j
    public boolean f() {
        m0();
        return this.f41071D.f();
    }

    @Override // stepos.support.v7.widget.j
    public void g(int i10) {
    }

    public ActionBarDropDownView getActionBarDropDownView() {
        return this.f41070C;
    }

    public CharSequence getTitle() {
        m0();
        return this.f41071D.getTitle();
    }

    public final StepOSRecyclerView j0(ViewGroup viewGroup) {
        StepOSRecyclerView stepOSRecyclerViewJ0;
        for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if (childAt instanceof StepOSRecyclerView) {
                return (StepOSRecyclerView) childAt;
            }
            if ((childAt instanceof ViewGroup) && (stepOSRecyclerViewJ0 = j0((ViewGroup) childAt)) != null) {
                return stepOSRecyclerViewJ0;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final k k0(View view) {
        if (view instanceof k) {
            return (k) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    public final void l0(RecyclerView recyclerView) {
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
            View viewFindViewById = this.f41068A.findViewById(R$id.stepos_nested_bottom_divider);
            int[] iArr2 = new int[2];
            viewFindViewById.getLocationInWindow(iArr2);
            int i10 = iArr2[1];
            int i11 = measuredHeight - i10;
            viewFindViewById.setAlpha(i11 > 100 ? 1.0f : i10 > measuredHeight ? 0.0f : i11 / 100.0f);
        }
    }

    public void m0() {
        if (this.f41082y == null) {
            this.f41082y = (FitsBottomContentLayout) findViewById(androidx.appcompat.R$id.action_bar_activity_content);
            this.f41083z = (StepOSAppBarLayout) findViewById(R$id.app_bar_layout);
            this.f41069B = (StepOSCollapsingToolbarLayout) findViewById(R$id.action_bar_container);
            this.f41071D = k0(findViewById(R$id.action_bar));
            this.f41068A = (ActionBarContainer) findViewById(R$id.split_action_bar);
            this.f41072E = (FrameLayout) findViewById(R$id.content_container);
            this.f41082y.setActionBarOverlay(this.f41080M);
            this.f41082y.setInterceptNestedScrollEnabled(!this.f41079L);
            this.f41083z.g(new a());
        }
    }

    public final void n0() {
        if (this.f41081N > 100) {
            return;
        }
        float fAbs = Math.abs(r0) / 100.0f;
        View viewFindViewById = findViewById(R$id.stepos_nested_top_divider);
        if (viewFindViewById != null) {
            viewFindViewById.setAlpha(fAbs);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f41079L) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        StepOSRecyclerView stepOSRecyclerViewJ0;
        super.onLayout(z10, i10, i11, i12, i13);
        if (this.f41068A.getVisibility() == 8 || (stepOSRecyclerViewJ0 = j0(this.f41082y)) == null) {
            return;
        }
        stepOSRecyclerViewJ0.post(new b(stepOSRecyclerViewJ0));
        stepOSRecyclerViewJ0.addOnScrollListener(new c(stepOSRecyclerViewJ0));
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int measuredHeight;
        super.onMeasure(i10, i11);
        ActionBarContainer actionBarContainer = this.f41068A;
        if (actionBarContainer == null || actionBarContainer.getVisibility() == 8) {
            measuredHeight = 0;
        } else {
            measuredHeight = this.f41068A.getMeasuredHeight();
            int i12 = this.f41074G.bottom;
            if (measuredHeight > i12) {
                measuredHeight -= i12;
            }
        }
        this.f41075H.set(this.f41074G);
        if (this.f41080M) {
            int measuredHeight2 = this.f41083z.getMeasuredHeight();
            int totalScrollRange = this.f41083z.getTotalScrollRange();
            CoordinatorLayout.c cVarF = ((CoordinatorLayout.f) this.f41072E.getLayoutParams()).f();
            if (cVarF instanceof StepOSScrollingViewBehavior) {
                int i13 = measuredHeight2 - totalScrollRange;
                ((StepOSScrollingViewBehavior) cVarF).setOverlayTop(i13);
                this.f41075H.top = i13;
            }
        }
        if (this.f41074G.bottom <= this.f41076I.bottom) {
            this.f41075H.bottom += measuredHeight;
        }
        if (!this.f41073F.equals(this.f41075H) || getHeight() == 0) {
            this.f41073F.set(this.f41075H);
            this.f41082y.dispatchFitSystemWindows(this.f41073F);
            super.onMeasure(i10, i11);
        }
        if (this.f41078K) {
            this.f41077J.top = this.f41083z.getMeasuredHeight() - this.f41074G.top;
        } else {
            this.f41077J.top = (int) (findViewById(R$id.action_bar).getMeasuredHeight() + O6.s.a(54.0f, getContext()));
        }
        ActionBarDropDownView actionBarDropDownView = this.f41070C;
        if (actionBarDropDownView == null || actionBarDropDownView.getVisibility() == 8) {
            return;
        }
        y.g(this.f41070C, this.f41077J, true, true, true, true);
        measureChildWithMargins(this.f41070C, i10, 0, i11, 0);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, androidx.core.view.InterfaceC1335x
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr, int i12) {
        super.onNestedPreScroll(view, i10, i11, iArr, i12);
        if (iArr[1] != 0) {
            return;
        }
        if (i11 >= 0) {
            this.f41081N += i11;
        } else {
            int i13 = this.f41081N;
            if (i13 > 0) {
                this.f41081N = i13 + i11;
            }
        }
        n0();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f41079L) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // stepos.support.v7.widget.j
    public void q(Menu menu, g.a aVar) {
        m0();
        this.f41071D.q(menu, aVar);
    }

    @Override // stepos.support.v7.widget.j
    public void r() {
        m0();
        this.f41071D.p();
    }

    @Override // stepos.support.v7.widget.j
    public void s() {
    }

    public void setActionBarCanScroll(boolean z10) {
        this.f41079L = z10;
        this.f41082y.setInterceptNestedScrollEnabled(!z10);
    }

    public void setActionBarFitStatusBar(boolean z10) {
    }

    @Override // stepos.support.v7.widget.j
    public void setBackTopBackground(Drawable drawable) {
    }

    @Override // stepos.support.v7.widget.j
    public void setBackTopClickCallback(View.OnClickListener onClickListener) {
    }

    @Override // stepos.support.v7.widget.j
    public void setBackTopEnable(boolean z10) {
    }

    public void setDropDownShowStart(int i10) {
    }

    public void setIcon(int i10) {
        m0();
        this.f41071D.setIcon(i10);
    }

    public void setLogo(int i10) {
        m0();
        this.f41071D.r(i10);
    }

    public void setShowingForActionMode(boolean z10) {
    }

    public void setSplitBarFitSystemWindows(boolean z10) {
    }

    public void setTransStatusBarInStepOS3(boolean z10) {
    }

    public void setUiOptions(int i10) {
        int i11 = 0;
        boolean z10 = i10 == 2;
        m0();
        StepOSCollapsingToolbarLayout stepOSCollapsingToolbarLayout = this.f41069B;
        ActionBarContextView actionBarContextView = stepOSCollapsingToolbarLayout != null ? (ActionBarContextView) stepOSCollapsingToolbarLayout.findViewById(R$id.action_context_bar) : (ActionBarContextView) findViewById(R$id.action_context_bar);
        if (z10) {
            ActionBarContainer actionBarContainer = this.f41068A;
            if (actionBarContainer == null) {
                Log.e("ActionBarCoordinatorLayout", "Requested split action bar with incompatible window decor! Ignoring request.");
                return;
            }
            this.f41071D.B(actionBarContainer);
        } else {
            this.f41071D.B(null);
            if (!actionBarContextView.q()) {
                actionBarContextView.setSplitView(null);
            }
        }
        this.f41071D.F(z10);
        ActionBarContainer actionBarContainer2 = this.f41068A;
        if (actionBarContainer2 != null) {
            if (!this.f41071D.z() && !actionBarContextView.q() && !z10) {
                i11 = 8;
            }
            actionBarContainer2.setVisibility(i11);
        }
    }

    @Override // stepos.support.v7.widget.j
    public void setWindowCallback(Window.Callback callback) {
        m0();
        this.f41071D.setWindowCallback(callback);
    }

    @Override // stepos.support.v7.widget.j
    public void setWindowTitle(CharSequence charSequence) {
        m0();
        this.f41071D.setWindowTitle(charSequence);
    }

    @Override // stepos.support.v7.widget.j
    public void t(Menu menu, g.a aVar) {
        m0();
        this.f41071D.C(menu, aVar);
        if (this.f41071D.v() && menu == null) {
            this.f41071D.F(false);
        }
    }

    @Override // stepos.support.v7.widget.j
    public void u() {
    }

    public ActionBarCoordinatorLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f41073F = new Rect();
        this.f41074G = new Rect();
        this.f41075H = new Rect();
        this.f41076I = new Rect();
        this.f41077J = new Rect();
        this.f41078K = true;
        this.f41079L = true;
        this.f41080M = true;
        this.f41081N = 0;
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f41067O);
        this.f41079L = typedArrayObtainStyledAttributes.getBoolean(0, this.f41079L);
        this.f41080M = typedArrayObtainStyledAttributes.getBoolean(1, this.f41080M);
        typedArrayObtainStyledAttributes.recycle();
    }

    public void setIcon(Drawable drawable) {
        m0();
        this.f41071D.setIcon(drawable);
    }
}

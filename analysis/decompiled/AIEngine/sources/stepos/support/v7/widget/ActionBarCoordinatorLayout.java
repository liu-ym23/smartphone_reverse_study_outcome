package stepos.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Insets;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.stepos.aiengine.R;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import l8.e;
import stepos.support.v7.view.menu.g;
import v0.h0;
import v0.m0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class ActionBarCoordinatorLayout extends CoordinatorLayout implements j {
    public static final int[] R = {R.attr.steposActionBarCanScroll, R.attr.steposActionBarOverlayMode};
    public FitsBottomContentLayout C;
    public StepOSAppBarLayout D;
    public ActionBarContainer E;
    public StepOSCollapsingToolbarLayout F;
    public k G;
    public FrameLayout H;
    public final Rect I;
    public final Rect J;
    public final Rect K;
    public final Rect L;
    public final Rect M;
    public boolean N;
    public boolean O;
    public final boolean P;
    public int Q;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @f.a
    public static class StepOSScrollingViewBehavior extends AppBarLayout.ScrollingViewBehavior {
        public StepOSScrollingViewBehavior() {
        }

        @Override // com.google.android.material.appbar.f, com.google.android.material.appbar.j
        public void layoutChild(CoordinatorLayout coordinatorLayout, View view, int i10) {
            super.layoutChild(coordinatorLayout, view, i10);
            ArrayList arrayListV = coordinatorLayout.v(view);
            try {
                e.d dVarA = l8.e.a(this);
                if (((Integer) dVarA.a("getOverlapPixelsForOffset", View.class).a(this, (View) dVarA.a("findFirstDependency", List.class).a(this, arrayListV))).intValue() == 0) {
                    view.layout(view.getLeft(), view.getTop() - getOverlayTop(), view.getRight(), view.getBottom() - getOverlayTop());
                }
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e10) {
                Log.e("ActionBarCoordinatorLayout", "StepOSScrollingViewBehavior layoutChild error :" + e10.getMessage());
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public m0 onApplyWindowInsets(CoordinatorLayout coordinatorLayout, View view, m0 m0Var) {
            return super.onApplyWindowInsets(coordinatorLayout, view, m0Var);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
            int bottom = (view2.getBottom() - view.getTop()) - getOverlayTop();
            WeakHashMap<View, h0> weakHashMap = v0.e0.f13274a;
            view.offsetTopAndBottom(bottom);
            return false;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior, com.google.android.material.appbar.f, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i10, int i11, int i12, int i13) {
            int i14 = view.getLayoutParams().height;
            boolean zOnMeasureChild = super.onMeasureChild(coordinatorLayout, view, i10, i11, i12, i13);
            coordinatorLayout.C(view, i10, i11, View.MeasureSpec.makeMeasureSpec(getOverlayTop() + view.getMeasuredHeight(), i14 == -1 ? 1073741824 : Integer.MIN_VALUE), i13);
            return zOnMeasureChild;
        }

        public StepOSScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements AppBarLayout.g {
        public a() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.a
        public final void a(int i10) {
            ActionBarCoordinatorLayout.this.N = i10 == 0;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StepOSRecyclerView f12461a;

        public b(StepOSRecyclerView stepOSRecyclerView) {
            this.f12461a = stepOSRecyclerView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActionBarCoordinatorLayout.K(ActionBarCoordinatorLayout.this, this.f12461a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class c extends RecyclerView.OnScrollListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StepOSRecyclerView f12463a;

        public c(StepOSRecyclerView stepOSRecyclerView) {
            this.f12463a = stepOSRecyclerView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public final void onScrolled(RecyclerView recyclerView, int i10, int i11) {
            super.onScrolled(recyclerView, i10, i11);
            ActionBarCoordinatorLayout.K(ActionBarCoordinatorLayout.this, this.f12463a);
        }
    }

    public ActionBarCoordinatorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.I = new Rect();
        this.J = new Rect();
        this.K = new Rect();
        this.L = new Rect();
        this.M = new Rect();
        this.N = true;
        this.O = true;
        this.P = true;
        this.Q = 0;
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(R);
        this.O = typedArrayObtainStyledAttributes.getBoolean(0, this.O);
        this.P = typedArrayObtainStyledAttributes.getBoolean(1, true);
        typedArrayObtainStyledAttributes.recycle();
    }

    public static void K(ActionBarCoordinatorLayout actionBarCoordinatorLayout, RecyclerView recyclerView) {
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
            int measuredHeight = viewFindViewByPosition.getMeasuredHeight() + iArr[1];
            View viewFindViewById = actionBarCoordinatorLayout.E.findViewById(R.id.stepos_nested_bottom_divider);
            int[] iArr2 = new int[2];
            viewFindViewById.getLocationInWindow(iArr2);
            int i10 = iArr2[1];
            int i11 = measuredHeight - i10;
            viewFindViewById.setAlpha(i11 > 100 ? 1.0f : i10 > measuredHeight ? 0.0f : i11 / 100.0f);
        }
    }

    public static StepOSRecyclerView L(ViewGroup viewGroup) {
        StepOSRecyclerView stepOSRecyclerViewL;
        for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if (childAt instanceof StepOSRecyclerView) {
                return (StepOSRecyclerView) childAt;
            }
            if ((childAt instanceof ViewGroup) && (stepOSRecyclerViewL = L((ViewGroup) childAt)) != null) {
                return stepOSRecyclerViewL;
            }
        }
        return null;
    }

    public final void M() {
        k wrapper;
        if (this.C == null) {
            this.C = (FitsBottomContentLayout) findViewById(R.id.action_bar_activity_content);
            this.D = (StepOSAppBarLayout) findViewById(R.id.app_bar_layout);
            this.F = (StepOSCollapsingToolbarLayout) findViewById(R.id.action_bar_container);
            KeyEvent.Callback callbackFindViewById = findViewById(R.id.action_bar);
            if (callbackFindViewById instanceof k) {
                wrapper = (k) callbackFindViewById;
            } else {
                if (!(callbackFindViewById instanceof Toolbar)) {
                    throw new IllegalStateException("Can't make a decor toolbar out of ".concat(callbackFindViewById.getClass().getSimpleName()));
                }
                wrapper = ((Toolbar) callbackFindViewById).getWrapper();
            }
            this.G = wrapper;
            this.E = (ActionBarContainer) findViewById(R.id.split_action_bar);
            this.H = (FrameLayout) findViewById(R.id.content_container);
            this.C.setActionBarOverlay(this.P);
            this.C.setInterceptNestedScrollEnabled(!this.O);
            this.D.c(new a());
        }
    }

    @Override // stepos.support.v7.widget.j
    public final boolean a() {
        M();
        return this.G.a();
    }

    @Override // stepos.support.v7.widget.j
    public final boolean b() {
        M();
        return this.G.b();
    }

    @Override // stepos.support.v7.widget.j
    public final boolean c() {
        M();
        return this.G.c();
    }

    @Override // stepos.support.v7.widget.j
    public final boolean d() {
        M();
        return this.G.d();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        boolean z;
        WindowInsets windowInsetsDispatchApplyWindowInsets = super.dispatchApplyWindowInsets(windowInsets);
        Rect rect = new Rect();
        Insets insets = windowInsets.getInsets(WindowInsets.Type.systemBars());
        rect.set(insets.left, insets.top, insets.right, insets.bottom);
        Rect rect2 = this.L;
        rect2.set(rect);
        int i10 = windowInsets.getInsets(WindowInsets.Type.ime()).bottom;
        boolean z3 = true;
        if (i10 > insets.bottom) {
            rect.bottom = i10;
            z = true;
        } else {
            z = false;
        }
        int i11 = rect.top;
        Rect rect3 = this.J;
        rect3.top = i11;
        rect3.bottom = rect.bottom;
        this.M.set(rect);
        Rect rect4 = this.K;
        boolean zEquals = rect4.equals(rect3);
        ActionBarContainer actionBarContainer = this.E;
        boolean zA = actionBarContainer != null ? g0.a(actionBarContainer, rect2, false, true) : false;
        this.G.y(this.E);
        rect4.set(rect3);
        if (this.P) {
            int measuredHeight = this.D.getMeasuredHeight();
            int totalScrollRange = this.D.getTotalScrollRange();
            if (((CoordinatorLayout.f) this.H.getLayoutParams()).f1456a instanceof StepOSScrollingViewBehavior) {
                rect4.top = measuredHeight - totalScrollRange;
            }
        }
        ActionBarContainer actionBarContainer2 = this.E;
        if (actionBarContainer2 != null && actionBarContainer2.getVisibility() != 8) {
            int measuredHeight2 = this.E.getMeasuredHeight();
            int i12 = rect3.bottom;
            if (measuredHeight2 > i12) {
                measuredHeight2 -= i12;
            }
            if (!z) {
                rect4.bottom += measuredHeight2;
            }
        }
        if (zEquals) {
            z3 = zA;
        } else {
            Rect rect5 = this.I;
            rect5.set(rect4);
            this.C.dispatchFitSystemWindows(rect5);
        }
        if (z3) {
            requestLayout();
        }
        return windowInsetsDispatchApplyWindowInsets;
    }

    @Override // stepos.support.v7.widget.j
    public final void e() {
        M();
        this.G.e();
    }

    @Override // stepos.support.v7.widget.j
    public final boolean f() {
        M();
        return this.G.f();
    }

    public ActionBarDropDownView getActionBarDropDownView() {
        return null;
    }

    public CharSequence getTitle() {
        M();
        return this.G.getTitle();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, v0.o
    public final void j(View view, int i10, int i11, int[] iArr, int i12) {
        super.j(view, i10, i11, iArr, i12);
        if (iArr[1] != 0) {
            return;
        }
        if (i11 >= 0) {
            this.Q += i11;
        } else {
            int i13 = this.Q;
            if (i13 > 0) {
                this.Q = i13 + i11;
            }
        }
        if (this.Q > 100) {
            return;
        }
        float fAbs = Math.abs(r1) / 100.0f;
        View viewFindViewById = findViewById(R.id.stepos_nested_top_divider);
        if (viewFindViewById != null) {
            viewFindViewById.setAlpha(fAbs);
        }
    }

    @Override // stepos.support.v7.widget.j
    public final void m(Menu menu, g.a aVar) {
        M();
        this.G.m(menu, aVar);
    }

    @Override // stepos.support.v7.widget.j
    public final void n() {
        M();
        this.G.l();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.O) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i10, int i11, int i12, int i13) {
        StepOSRecyclerView stepOSRecyclerViewL;
        super.onLayout(z, i10, i11, i12, i13);
        if (this.E.getVisibility() == 8 || (stepOSRecyclerViewL = L(this.C)) == null) {
            return;
        }
        stepOSRecyclerViewL.post(new b(stepOSRecyclerViewL));
        stepOSRecyclerViewL.addOnScrollListener(new c(stepOSRecyclerViewL));
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View
    public final void onMeasure(int i10, int i11) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        int measuredHeight;
        super.onMeasure(i10, i11);
        ActionBarContainer actionBarContainer = this.E;
        Rect rect = this.J;
        if (actionBarContainer == null || actionBarContainer.getVisibility() == 8) {
            measuredHeight = 0;
        } else {
            measuredHeight = this.E.getMeasuredHeight();
            int i12 = rect.bottom;
            if (measuredHeight > i12) {
                measuredHeight -= i12;
            }
        }
        Rect rect2 = this.K;
        rect2.set(rect);
        if (this.P) {
            int measuredHeight2 = this.D.getMeasuredHeight();
            int totalScrollRange = this.D.getTotalScrollRange();
            CoordinatorLayout.c cVar = ((CoordinatorLayout.f) this.H.getLayoutParams()).f1456a;
            if (cVar instanceof StepOSScrollingViewBehavior) {
                int i13 = measuredHeight2 - totalScrollRange;
                ((StepOSScrollingViewBehavior) cVar).setOverlayTop(i13);
                rect2.top = i13;
            }
        }
        if (rect.bottom <= this.L.bottom) {
            rect2.bottom += measuredHeight;
        }
        Rect rect3 = this.I;
        if (!rect3.equals(rect2) || getHeight() == 0) {
            rect3.set(rect2);
            this.C.dispatchFitSystemWindows(rect3);
            super.onMeasure(i10, i11);
        }
        boolean z = this.N;
        Rect rect4 = this.M;
        if (z) {
            rect4.top = this.D.getMeasuredHeight() - rect.top;
        } else {
            rect4.top = (int) (l8.f.a(54.0f, getContext()) + findViewById(R.id.action_bar).getMeasuredHeight());
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.O) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // stepos.support.v7.widget.j
    public final void q(Menu menu, g.a aVar) {
        M();
        this.G.A(menu, aVar);
        if (this.G.r() && menu == null) {
            this.G.D(false);
        }
    }

    public void setActionBarCanScroll(boolean z) {
        this.O = z;
        this.C.setInterceptNestedScrollEnabled(!z);
    }

    public void setIcon(int i10) {
        M();
        this.G.setIcon(i10);
    }

    public void setLogo(int i10) {
        M();
        this.G.o(i10);
    }

    public void setUiOptions(int i10) {
        int i11 = 0;
        boolean z = i10 == 2;
        M();
        StepOSCollapsingToolbarLayout stepOSCollapsingToolbarLayout = this.F;
        ActionBarContextView actionBarContextView = stepOSCollapsingToolbarLayout != null ? (ActionBarContextView) stepOSCollapsingToolbarLayout.findViewById(R.id.action_context_bar) : (ActionBarContextView) findViewById(R.id.action_context_bar);
        if (z) {
            ActionBarContainer actionBarContainer = this.E;
            if (actionBarContainer == null) {
                Log.e("ActionBarCoordinatorLayout", "Requested split action bar with incompatible window decor! Ignoring request.");
                return;
            }
            this.G.z(actionBarContainer);
        } else {
            this.G.z(null);
            if (!actionBarContextView.A) {
                actionBarContextView.setSplitView(null);
            }
        }
        this.G.D(z);
        ActionBarContainer actionBarContainer2 = this.E;
        if (actionBarContainer2 != null) {
            if (!this.G.x() && !actionBarContextView.A && !z) {
                i11 = 8;
            }
            actionBarContainer2.setVisibility(i11);
        }
    }

    @Override // stepos.support.v7.widget.j
    public void setWindowCallback(Window.Callback callback) {
        M();
        this.G.setWindowCallback(callback);
    }

    @Override // stepos.support.v7.widget.j
    public void setWindowTitle(CharSequence charSequence) {
        M();
        this.G.setWindowTitle(charSequence);
    }

    public void setIcon(Drawable drawable) {
        M();
        this.G.setIcon(drawable);
    }

    @Override // stepos.support.v7.widget.j
    public final void o() {
    }

    @Override // stepos.support.v7.widget.j
    public final void r() {
    }

    @Override // stepos.support.v7.widget.j
    public final void g(int i10) {
    }

    public void setActionBarFitStatusBar(boolean z) {
    }

    @Override // stepos.support.v7.widget.j
    public void setBackTopBackground(Drawable drawable) {
    }

    @Override // stepos.support.v7.widget.j
    public void setBackTopClickCallback(View.OnClickListener onClickListener) {
    }

    @Override // stepos.support.v7.widget.j
    public void setBackTopEnable(boolean z) {
    }

    public void setDropDownShowStart(int i10) {
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setSplitBarFitSystemWindows(boolean z) {
    }

    public void setTransStatusBarInStepOS3(boolean z) {
    }
}

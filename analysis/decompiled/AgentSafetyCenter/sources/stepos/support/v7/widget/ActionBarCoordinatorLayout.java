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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout$ScrollingViewBehavior;
import com.stepos.agentsafetycenter.R;
import java.lang.invoke.VarHandle;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public class ActionBarCoordinatorLayout extends androidx.coordinatorlayout.widget.a implements b0 {
    public static final int[] R = {R.attr.steposActionBarCanScroll, R.attr.steposActionBarOverlayMode};
    public FitsBottomContentLayout C;
    public StepOSAppBarLayout D;
    public ActionBarContainer E;
    public StepOSCollapsingToolbarLayout F;
    public c0 G;
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

    public ActionBarCoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
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

    public static void L(ActionBarCoordinatorLayout actionBarCoordinatorLayout, RecyclerView recyclerView) {
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
            int i = iArr2[1];
            int i3 = measuredHeight - i;
            viewFindViewById.setAlpha(i3 > 100 ? 1.0f : i > measuredHeight ? 0.0f : i3 / 100.0f);
        }
    }

    public static StepOSRecyclerView M(ViewGroup viewGroup) {
        StepOSRecyclerView stepOSRecyclerViewM;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof StepOSRecyclerView) {
                return (StepOSRecyclerView) childAt;
            }
            if ((childAt instanceof ViewGroup) && (stepOSRecyclerViewM = M((ViewGroup) childAt)) != null) {
                return stepOSRecyclerViewM;
            }
        }
        return null;
    }

    public final void N() {
        c0 wrapper;
        if (this.C == null) {
            this.C = (FitsBottomContentLayout) findViewById(R.id.action_bar_activity_content);
            this.D = (StepOSAppBarLayout) findViewById(R.id.app_bar_layout);
            this.F = (StepOSCollapsingToolbarLayout) findViewById(R.id.action_bar_container);
            KeyEvent.Callback callbackFindViewById = findViewById(R.id.action_bar);
            if (callbackFindViewById instanceof c0) {
                wrapper = (c0) callbackFindViewById;
            } else {
                if (!(callbackFindViewById instanceof Toolbar)) {
                    od.f.e("Can't make a decor toolbar out of ".concat(callbackFindViewById.getClass().getSimpleName()));
                    return;
                }
                wrapper = ((Toolbar) callbackFindViewById).getWrapper();
            }
            this.G = wrapper;
            this.E = (ActionBarContainer) findViewById(R.id.split_action_bar);
            this.H = (FrameLayout) findViewById(R.id.content_container);
            this.C.setActionBarOverlay(this.P);
            this.C.setInterceptNestedScrollEnabled(!this.O);
            StepOSAppBarLayout stepOSAppBarLayout = this.D;
            d dVar = new d(0);
            dVar.f12738b = this;
            VarHandle.storeStoreFence();
            stepOSAppBarLayout.c(dVar);
        }
    }

    @Override // stepos.support.v7.widget.b0
    public final boolean a() {
        N();
        return this.G.a();
    }

    @Override // stepos.support.v7.widget.b0
    public final void b() {
        N();
        this.G.b();
    }

    @Override // stepos.support.v7.widget.b0
    public final void c(Menu menu, te.u uVar) {
        N();
        this.G.c(menu, uVar);
    }

    @Override // stepos.support.v7.widget.b0
    public final boolean d() {
        N();
        return this.G.d();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        boolean z10;
        WindowInsets windowInsetsDispatchApplyWindowInsets = super.dispatchApplyWindowInsets(windowInsets);
        Rect rect = new Rect();
        Insets insets = windowInsets.getInsets(WindowInsets.Type.systemBars());
        rect.set(insets.left, insets.top, insets.right, insets.bottom);
        Rect rect2 = this.L;
        rect2.set(rect);
        int i = windowInsets.getInsets(WindowInsets.Type.ime()).bottom;
        boolean z11 = true;
        if (i > insets.bottom) {
            rect.bottom = i;
            z10 = true;
        } else {
            z10 = false;
        }
        int i3 = rect.top;
        Rect rect3 = this.J;
        rect3.top = i3;
        rect3.bottom = rect.bottom;
        this.M.set(rect);
        Rect rect4 = this.K;
        boolean zEquals = rect4.equals(rect3);
        ActionBarContainer actionBarContainer = this.E;
        boolean zA = actionBarContainer != null ? x1.a(actionBarContainer, rect2, false, true) : false;
        this.G.m(this.E);
        rect4.set(rect3);
        if (this.P) {
            int measuredHeight = this.D.getMeasuredHeight();
            int totalScrollRange = this.D.getTotalScrollRange();
            if (((b3.d) this.H.getLayoutParams()).f1877a instanceof StepOSScrollingViewBehavior) {
                rect4.top = measuredHeight - totalScrollRange;
            }
        }
        ActionBarContainer actionBarContainer2 = this.E;
        if (actionBarContainer2 != null && actionBarContainer2.getVisibility() != 8) {
            int measuredHeight2 = this.E.getMeasuredHeight();
            int i10 = rect3.bottom;
            if (measuredHeight2 > i10) {
                measuredHeight2 -= i10;
            }
            if (!z10) {
                rect4.bottom += measuredHeight2;
            }
        }
        if (zEquals) {
            z11 = zA;
        } else {
            Rect rect5 = this.I;
            rect5.set(rect4);
            this.C.dispatchFitSystemWindows(rect5);
        }
        if (z11) {
            requestLayout();
        }
        return windowInsetsDispatchApplyWindowInsets;
    }

    @Override // stepos.support.v7.widget.b0
    public final boolean e() {
        N();
        return this.G.e();
    }

    @Override // stepos.support.v7.widget.b0
    public final boolean f() {
        N();
        return this.G.f();
    }

    @Override // stepos.support.v7.widget.b0
    public final boolean g() {
        N();
        return this.G.g();
    }

    public ActionBarDropDownView getActionBarDropDownView() {
        return null;
    }

    public CharSequence getTitle() {
        N();
        return this.G.getTitle();
    }

    @Override // stepos.support.v7.widget.b0
    public final void i() {
        N();
        this.G.i();
    }

    @Override // androidx.coordinatorlayout.widget.a, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.O) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.a, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i, int i3, int i10, int i11) {
        StepOSRecyclerView stepOSRecyclerViewM;
        super.onLayout(z10, i, i3, i10, i11);
        if (this.E.getVisibility() == 8 || (stepOSRecyclerViewM = M(this.C)) == null) {
            return;
        }
        com.stepos.statsrpk.service.d dVar = new com.stepos.statsrpk.service.d(13);
        dVar.f2886g = this;
        dVar.f2885f = stepOSRecyclerViewM;
        VarHandle.storeStoreFence();
        stepOSRecyclerViewM.post(dVar);
        stepOSRecyclerViewM.addOnScrollListener(new e(this, stepOSRecyclerViewM));
    }

    @Override // androidx.coordinatorlayout.widget.a, android.view.View
    public final void onMeasure(int i, int i3) {
        int measuredHeight;
        super.onMeasure(i, i3);
        ActionBarContainer actionBarContainer = this.E;
        Rect rect = this.J;
        if (actionBarContainer == null || actionBarContainer.getVisibility() == 8) {
            measuredHeight = 0;
        } else {
            measuredHeight = this.E.getMeasuredHeight();
            int i10 = rect.bottom;
            if (measuredHeight > i10) {
                measuredHeight -= i10;
            }
        }
        Rect rect2 = this.K;
        rect2.set(rect);
        if (this.P) {
            int measuredHeight2 = this.D.getMeasuredHeight();
            int totalScrollRange = this.D.getTotalScrollRange();
            b3.a aVar = ((b3.d) this.H.getLayoutParams()).f1877a;
            if (aVar instanceof StepOSScrollingViewBehavior) {
                int i11 = measuredHeight2 - totalScrollRange;
                ((StepOSScrollingViewBehavior) aVar).setOverlayTop(i11);
                rect2.top = i11;
            }
        }
        if (rect.bottom <= this.L.bottom) {
            rect2.bottom += measuredHeight;
        }
        Rect rect3 = this.I;
        if (!rect3.equals(rect2) || getHeight() == 0) {
            rect3.set(rect2);
            this.C.dispatchFitSystemWindows(rect3);
            super.onMeasure(i, i3);
        }
        boolean z10 = this.N;
        Rect rect4 = this.M;
        if (z10) {
            rect4.top = this.D.getMeasuredHeight() - rect.top;
        } else {
            rect4.top = (int) (t1.e.e(54.0f, getContext()) + findViewById(R.id.action_bar).getMeasuredHeight());
        }
    }

    @Override // androidx.coordinatorlayout.widget.a, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.O) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // stepos.support.v7.widget.b0
    public final void p(Menu menu, te.u uVar) {
        N();
        this.G.h(menu, uVar);
        if (this.G.l() && menu == null) {
            this.G.y(false);
        }
    }

    @Override // n3.q
    public final void q(View view, int i, int i3, int[] iArr, int i10) {
        b3.a aVar;
        int childCount = getChildCount();
        boolean z10 = false;
        int iMax = 0;
        int iMax2 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                b3.d dVar = (b3.d) childAt.getLayoutParams();
                if (dVar.a(i10) && (aVar = dVar.f1877a) != null) {
                    int[] iArr2 = this.i;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    aVar.onNestedPreScroll(this, childAt, view, i, i3, iArr2, i10);
                    iMax = i > 0 ? Math.max(iMax, iArr2[0]) : Math.min(iMax, iArr2[0]);
                    iMax2 = i3 > 0 ? Math.max(iMax2, iArr2[1]) : Math.min(iMax2, iArr2[1]);
                    z10 = true;
                }
            }
        }
        iArr[0] = iMax;
        iArr[1] = iMax2;
        if (z10) {
            A(1);
        }
        if (iArr[1] != 0) {
            return;
        }
        int i12 = this.Q;
        if (i3 >= 0 || i12 > 0) {
            this.Q = i12 + i3;
        }
        if (this.Q > 100) {
            return;
        }
        float fAbs = Math.abs(r0) / 100.0f;
        View viewFindViewById = findViewById(R.id.stepos_nested_top_divider);
        if (viewFindViewById != null) {
            viewFindViewById.setAlpha(fAbs);
        }
    }

    public void setActionBarCanScroll(boolean z10) {
        this.O = z10;
        this.C.setInterceptNestedScrollEnabled(!z10);
    }

    public void setIcon(int i) {
        N();
        this.G.setIcon(i);
    }

    public void setLogo(int i) {
        N();
        this.G.s(i);
    }

    public void setUiOptions(int i) {
        int i3 = 0;
        boolean z10 = i == 2;
        N();
        StepOSCollapsingToolbarLayout stepOSCollapsingToolbarLayout = this.F;
        ActionBarContextView actionBarContextView = stepOSCollapsingToolbarLayout != null ? (ActionBarContextView) stepOSCollapsingToolbarLayout.findViewById(R.id.action_context_bar) : (ActionBarContextView) findViewById(R.id.action_context_bar);
        if (z10) {
            ActionBarContainer actionBarContainer = this.E;
            if (actionBarContainer == null) {
                Log.e("ActionBarCoordinatorLayout", "Requested split action bar with incompatible window decor! Ignoring request.");
                return;
            }
            this.G.p(actionBarContainer);
        } else {
            this.G.p(null);
            if (!actionBarContextView.B) {
                actionBarContextView.setSplitView(null);
            }
        }
        this.G.y(z10);
        ActionBarContainer actionBarContainer2 = this.E;
        if (actionBarContainer2 != null) {
            if (!this.G.k() && !actionBarContextView.B && !z10) {
                i3 = 8;
            }
            actionBarContainer2.setVisibility(i3);
        }
    }

    @Override // stepos.support.v7.widget.b0
    public void setWindowCallback(Window.Callback callback) {
        N();
        this.G.setWindowCallback(callback);
    }

    @Override // stepos.support.v7.widget.b0
    public void setWindowTitle(CharSequence charSequence) {
        N();
        this.G.setWindowTitle(charSequence);
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @f.a
    public static class StepOSScrollingViewBehavior extends AppBarLayout$ScrollingViewBehavior {
        public StepOSScrollingViewBehavior() {
        }

        @Override // com.google.android.material.appbar.i, com.google.android.material.appbar.l
        public void layoutChild(androidx.coordinatorlayout.widget.a aVar, View view, int i) {
            super.layoutChild(aVar, view, i);
            List listV = aVar.v(view);
            try {
                u9.e eVarA = u9.g.a(this);
                if (((Integer) eVarA.a("getOverlapPixelsForOffset", View.class).f14264a.invoke(this, (View) eVarA.a("findFirstDependency", List.class).f14264a.invoke(this, listV))).intValue() == 0) {
                    view.layout(view.getLeft(), view.getTop() - getOverlayTop(), view.getRight(), view.getBottom() - getOverlayTop());
                }
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e10) {
                Log.e("ActionBarCoordinatorLayout", "StepOSScrollingViewBehavior layoutChild error :" + e10.getMessage());
            }
        }

        @Override // com.google.android.material.appbar.AppBarLayout$ScrollingViewBehavior, b3.a
        public boolean onDependentViewChanged(androidx.coordinatorlayout.widget.a aVar, View view, View view2) {
            int bottom = (view2.getBottom() - view.getTop()) - getOverlayTop();
            WeakHashMap weakHashMap = n3.k0.f8724a;
            view.offsetTopAndBottom(bottom);
            return false;
        }

        @Override // com.google.android.material.appbar.i, b3.a
        public boolean onMeasureChild(androidx.coordinatorlayout.widget.a aVar, View view, int i, int i3, int i10, int i11) {
            int i12 = view.getLayoutParams().height;
            boolean zOnMeasureChild = super.onMeasureChild(aVar, view, i, i3, i10, i11);
            aVar.C(view, i, i3, View.MeasureSpec.makeMeasureSpec(getOverlayTop() + view.getMeasuredHeight(), i12 == -1 ? 1073741824 : Integer.MIN_VALUE), i11);
            return zOnMeasureChild;
        }

        public StepOSScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // b3.a
        public n3.m1 onApplyWindowInsets(androidx.coordinatorlayout.widget.a aVar, View view, n3.m1 m1Var) {
            return m1Var;
        }
    }

    public void setIcon(Drawable drawable) {
        N();
        this.G.setIcon(drawable);
    }

    @Override // stepos.support.v7.widget.b0
    public final void h(int i) {
    }

    public void setActionBarFitStatusBar(boolean z10) {
    }

    @Override // stepos.support.v7.widget.b0
    public void setBackTopBackground(Drawable drawable) {
    }

    @Override // stepos.support.v7.widget.b0
    public void setBackTopClickCallback(View.OnClickListener onClickListener) {
    }

    @Override // stepos.support.v7.widget.b0
    public void setBackTopEnable(boolean z10) {
    }

    public void setDropDownShowStart(int i) {
    }

    public void setShowingForActionMode(boolean z10) {
    }

    public void setSplitBarFitSystemWindows(boolean z10) {
    }

    public void setTransStatusBarInStepOS3(boolean z10) {
    }

    @Override // stepos.support.v7.widget.b0
    public final void o() {
    }

    @Override // stepos.support.v7.widget.b0
    public final void r() {
    }

    public ActionBarCoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionBarCoordinatorLayout(Context context) {
        this(context, null);
    }
}

package stepos.support.v7.widget;

import K.z0;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Insets;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.RunnableC0209k;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.android.material.appbar.AppBarLayout$ScrollingViewBehavior;
import com.stepos.alphame.R;
import com.stepos.alphame.utils.Property;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import stepos.support.v7.app.C0877w;

/* loaded from: classes2.dex */
public class ActionBarCoordinatorLayout extends CoordinatorLayout implements C {

    /* renamed from: O, reason: collision with root package name */
    public static final int[] f14729O = {R.attr.steposActionBarCanScroll, R.attr.steposActionBarOverlayMode};

    /* renamed from: A, reason: collision with root package name */
    public StepOSAppBarLayout f14730A;

    /* renamed from: B, reason: collision with root package name */
    public ActionBarContainer f14731B;

    /* renamed from: C, reason: collision with root package name */
    public StepOSCollapsingToolbarLayout f14732C;

    /* renamed from: D, reason: collision with root package name */
    public D f14733D;

    /* renamed from: E, reason: collision with root package name */
    public FrameLayout f14734E;

    /* renamed from: F, reason: collision with root package name */
    public final Rect f14735F;

    /* renamed from: G, reason: collision with root package name */
    public final Rect f14736G;

    /* renamed from: H, reason: collision with root package name */
    public final Rect f14737H;

    /* renamed from: I, reason: collision with root package name */
    public final Rect f14738I;

    /* renamed from: J, reason: collision with root package name */
    public final Rect f14739J;

    /* renamed from: K, reason: collision with root package name */
    public boolean f14740K;

    /* renamed from: L, reason: collision with root package name */
    public boolean f14741L;

    /* renamed from: M, reason: collision with root package name */
    public final boolean f14742M;

    /* renamed from: N, reason: collision with root package name */
    public int f14743N;

    /* renamed from: z, reason: collision with root package name */
    public FitsBottomContentLayout f14744z;

    @Keep
    public static class StepOSScrollingViewBehavior extends AppBarLayout$ScrollingViewBehavior {
        public StepOSScrollingViewBehavior() {
        }

        @Override // com.google.android.material.appbar.j, com.google.android.material.appbar.m
        public void layoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i4) {
            super.layoutChild(coordinatorLayout, view, i4);
            ArrayList arrayListV = coordinatorLayout.v(view);
            try {
                m2.f fVarA = m2.i.a(this);
                if (((Integer) fVarA.b("getOverlapPixelsForOffset", View.class).f13573a.invoke(this, (View) fVarA.b("findFirstDependency", List.class).f13573a.invoke(this, arrayListV))).intValue() == 0) {
                    view.layout(view.getLeft(), view.getTop() - getOverlayTop(), view.getRight(), view.getBottom() - getOverlayTop());
                }
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e4) {
                Log.e("ActionBarCoordinatorLayout", "StepOSScrollingViewBehavior layoutChild error :" + e4.getMessage());
            }
        }

        @Override // A.b
        @NonNull
        public z0 onApplyWindowInsets(CoordinatorLayout coordinatorLayout, View view, z0 z0Var) {
            return z0Var;
        }

        @Override // com.google.android.material.appbar.AppBarLayout$ScrollingViewBehavior, A.b
        public boolean onDependentViewChanged(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
            int bottom = (view2.getBottom() - view.getTop()) - getOverlayTop();
            WeakHashMap weakHashMap = K.S.f939a;
            view.offsetTopAndBottom(bottom);
            return false;
        }

        @Override // com.google.android.material.appbar.j, A.b
        public boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i4, int i5, int i6, int i7) {
            int i8 = view.getLayoutParams().height;
            boolean zOnMeasureChild = super.onMeasureChild(coordinatorLayout, view, i4, i5, i6, i7);
            coordinatorLayout.C(view, i4, i5, View.MeasureSpec.makeMeasureSpec(getOverlayTop() + view.getMeasuredHeight(), i8 == -1 ? 1073741824 : Integer.MIN_VALUE), i7);
            return zOnMeasureChild;
        }

        public StepOSScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public ActionBarCoordinatorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f14735F = new Rect();
        this.f14736G = new Rect();
        this.f14737H = new Rect();
        this.f14738I = new Rect();
        this.f14739J = new Rect();
        this.f14740K = true;
        this.f14741L = true;
        this.f14742M = true;
        this.f14743N = 0;
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f14729O);
        this.f14741L = typedArrayObtainStyledAttributes.getBoolean(0, this.f14741L);
        this.f14742M = typedArrayObtainStyledAttributes.getBoolean(1, true);
        typedArrayObtainStyledAttributes.recycle();
    }

    public static void K(ActionBarCoordinatorLayout actionBarCoordinatorLayout, StepOSRecyclerView stepOSRecyclerView) {
        LinearLayoutManager linearLayoutManager;
        View viewFindViewByPosition;
        actionBarCoordinatorLayout.getClass();
        if ((stepOSRecyclerView.getLayoutManager() instanceof LinearLayoutManager) && (linearLayoutManager = (LinearLayoutManager) stepOSRecyclerView.getLayoutManager()) != null) {
            int itemCount = linearLayoutManager.getItemCount();
            int iFindLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            if (itemCount <= 0 || iFindLastVisibleItemPosition != itemCount - 1 || (viewFindViewByPosition = linearLayoutManager.findViewByPosition(linearLayoutManager.findLastVisibleItemPosition())) == null) {
                return;
            }
            int[] iArr = new int[2];
            viewFindViewByPosition.getLocationInWindow(iArr);
            int measuredHeight = viewFindViewByPosition.getMeasuredHeight() + iArr[1];
            View viewFindViewById = actionBarCoordinatorLayout.f14731B.findViewById(R.id.stepos_nested_bottom_divider);
            int[] iArr2 = new int[2];
            viewFindViewById.getLocationInWindow(iArr2);
            int i4 = iArr2[1];
            int i5 = measuredHeight - i4;
            viewFindViewById.setAlpha(i5 > 100 ? 1.0f : i4 > measuredHeight ? Property.DEFAULT_FLOAT_VALUE : i5 / 100.0f);
        }
    }

    public static StepOSRecyclerView L(ViewGroup viewGroup) {
        StepOSRecyclerView stepOSRecyclerViewL;
        for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
            View childAt = viewGroup.getChildAt(i4);
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
        D wrapper;
        if (this.f14744z == null) {
            this.f14744z = (FitsBottomContentLayout) findViewById(R.id.action_bar_activity_content);
            this.f14730A = (StepOSAppBarLayout) findViewById(R.id.app_bar_layout);
            this.f14732C = (StepOSCollapsingToolbarLayout) findViewById(R.id.action_bar_container);
            KeyEvent.Callback callbackFindViewById = findViewById(R.id.action_bar);
            if (callbackFindViewById instanceof D) {
                wrapper = (D) callbackFindViewById;
            } else {
                if (!(callbackFindViewById instanceof Toolbar)) {
                    throw new IllegalStateException("Can't make a decor toolbar out of ".concat(callbackFindViewById.getClass().getSimpleName()));
                }
                wrapper = ((Toolbar) callbackFindViewById).getWrapper();
            }
            this.f14733D = wrapper;
            this.f14731B = (ActionBarContainer) findViewById(R.id.split_action_bar);
            this.f14734E = (FrameLayout) findViewById(R.id.content_container);
            this.f14744z.setActionBarOverlay(this.f14742M);
            this.f14744z.setInterceptNestedScrollEnabled(!this.f14741L);
            this.f14730A.c(new C0884d(this, 0));
        }
    }

    @Override // stepos.support.v7.widget.C
    public final void a(L3.k kVar, C0877w c0877w) {
        M();
        this.f14733D.a(kVar, c0877w);
    }

    @Override // stepos.support.v7.widget.C
    public final boolean b() {
        M();
        return this.f14733D.b();
    }

    @Override // stepos.support.v7.widget.C
    public final void c() {
        M();
        this.f14733D.c();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        boolean z4;
        WindowInsets windowInsetsDispatchApplyWindowInsets = super.dispatchApplyWindowInsets(windowInsets);
        Rect rect = new Rect();
        Insets insets = windowInsets.getInsets(WindowInsets.Type.systemBars());
        rect.set(insets.left, insets.top, insets.right, insets.bottom);
        Rect rect2 = this.f14738I;
        rect2.set(rect);
        int i4 = windowInsets.getInsets(WindowInsets.Type.ime()).bottom;
        if (i4 > insets.bottom) {
            rect.bottom = i4;
            z4 = true;
        } else {
            z4 = false;
        }
        int i5 = rect.top;
        Rect rect3 = this.f14736G;
        rect3.top = i5;
        rect3.bottom = rect.bottom;
        this.f14739J.set(rect);
        Rect rect4 = this.f14737H;
        boolean z5 = !rect4.equals(rect3);
        ActionBarContainer actionBarContainer = this.f14731B;
        boolean zA = actionBarContainer != null ? y0.a(actionBarContainer, rect2, false, true) : false;
        this.f14733D.D(this.f14731B);
        rect4.set(rect3);
        if (this.f14742M) {
            int measuredHeight = this.f14730A.getMeasuredHeight();
            int totalScrollRange = this.f14730A.getTotalScrollRange();
            if (((A.d) this.f14734E.getLayoutParams()).f5a instanceof StepOSScrollingViewBehavior) {
                rect4.top = measuredHeight - totalScrollRange;
            }
        }
        ActionBarContainer actionBarContainer2 = this.f14731B;
        if (actionBarContainer2 != null && actionBarContainer2.getVisibility() != 8) {
            int measuredHeight2 = this.f14731B.getMeasuredHeight();
            int i6 = rect3.bottom;
            if (measuredHeight2 > i6) {
                measuredHeight2 -= i6;
            }
            if (!z4) {
                rect4.bottom += measuredHeight2;
            }
        }
        if (!z5) {
            if (zA) {
            }
            return windowInsetsDispatchApplyWindowInsets;
        }
        Rect rect5 = this.f14735F;
        rect5.set(rect4);
        this.f14744z.dispatchFitSystemWindows(rect5);
        requestLayout();
        return windowInsetsDispatchApplyWindowInsets;
    }

    @Override // stepos.support.v7.widget.C
    public final boolean e() {
        M();
        return this.f14733D.e();
    }

    @Override // stepos.support.v7.widget.C
    public final boolean f() {
        M();
        return this.f14733D.f();
    }

    @Override // stepos.support.v7.widget.C
    public final boolean g() {
        M();
        return this.f14733D.g();
    }

    public ActionBarDropDownView getActionBarDropDownView() {
        return null;
    }

    public CharSequence getTitle() {
        M();
        return this.f14733D.getTitle();
    }

    @Override // stepos.support.v7.widget.C
    public final boolean h() {
        M();
        return this.f14733D.h();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, K.InterfaceC0086s
    public final void i(View view, int i4, int i5, int[] iArr, int i6) {
        super.i(view, i4, i5, iArr, i6);
        if (iArr[1] != 0) {
            return;
        }
        if (i5 >= 0) {
            this.f14743N += i5;
        } else {
            int i7 = this.f14743N;
            if (i7 > 0) {
                this.f14743N = i7 + i5;
            }
        }
        if (this.f14743N > 100) {
            return;
        }
        float fAbs = Math.abs(r1) / 100.0f;
        View viewFindViewById = findViewById(R.id.stepos_nested_top_divider);
        if (viewFindViewById != null) {
            viewFindViewById.setAlpha(fAbs);
        }
    }

    @Override // stepos.support.v7.widget.C
    public final void j() {
    }

    @Override // stepos.support.v7.widget.C
    public final void k(int i4) {
    }

    @Override // stepos.support.v7.widget.C
    public final void l() {
        M();
        this.f14733D.i();
    }

    @Override // stepos.support.v7.widget.C
    public final void m(L3.k kVar, C0877w c0877w) {
        M();
        this.f14733D.u(kVar, c0877w);
        if (this.f14733D.l() && kVar == null) {
            this.f14733D.p(false);
        }
    }

    @Override // stepos.support.v7.widget.C
    public final void o() {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f14741L) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        StepOSRecyclerView stepOSRecyclerViewL;
        super.onLayout(z4, i4, i5, i6, i7);
        if (this.f14731B.getVisibility() == 8 || (stepOSRecyclerViewL = L(this.f14744z)) == null) {
            return;
        }
        stepOSRecyclerViewL.post(new RunnableC0209k(20, this, stepOSRecyclerViewL));
        stepOSRecyclerViewL.addOnScrollListener(new C0885e(this, stepOSRecyclerViewL));
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View
    public final void onMeasure(int i4, int i5) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        int measuredHeight;
        super.onMeasure(i4, i5);
        ActionBarContainer actionBarContainer = this.f14731B;
        Rect rect = this.f14736G;
        if (actionBarContainer == null || actionBarContainer.getVisibility() == 8) {
            measuredHeight = 0;
        } else {
            measuredHeight = this.f14731B.getMeasuredHeight();
            int i6 = rect.bottom;
            if (measuredHeight > i6) {
                measuredHeight -= i6;
            }
        }
        Rect rect2 = this.f14737H;
        rect2.set(rect);
        if (this.f14742M) {
            int measuredHeight2 = this.f14730A.getMeasuredHeight();
            int totalScrollRange = this.f14730A.getTotalScrollRange();
            A.b bVar = ((A.d) this.f14734E.getLayoutParams()).f5a;
            if (bVar instanceof StepOSScrollingViewBehavior) {
                int i7 = measuredHeight2 - totalScrollRange;
                ((StepOSScrollingViewBehavior) bVar).setOverlayTop(i7);
                rect2.top = i7;
            }
        }
        if (rect.bottom <= this.f14738I.bottom) {
            rect2.bottom += measuredHeight;
        }
        Rect rect3 = this.f14735F;
        if (!rect3.equals(rect2) || getHeight() == 0) {
            rect3.set(rect2);
            this.f14744z.dispatchFitSystemWindows(rect3);
            super.onMeasure(i4, i5);
        }
        boolean z4 = this.f14740K;
        Rect rect4 = this.f14739J;
        if (z4) {
            rect4.top = this.f14730A.getMeasuredHeight() - rect.top;
        } else {
            rect4.top = (int) (m2.o.c(getContext(), 54.0f) + findViewById(R.id.action_bar).getMeasuredHeight());
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f14741L) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void setActionBarCanScroll(boolean z4) {
        this.f14741L = z4;
        this.f14744z.setInterceptNestedScrollEnabled(!z4);
    }

    public void setActionBarFitStatusBar(boolean z4) {
    }

    @Override // stepos.support.v7.widget.C
    public void setBackTopBackground(Drawable drawable) {
    }

    @Override // stepos.support.v7.widget.C
    public void setBackTopClickCallback(View.OnClickListener onClickListener) {
    }

    @Override // stepos.support.v7.widget.C
    public void setBackTopEnable(boolean z4) {
    }

    public void setDropDownShowStart(int i4) {
    }

    public void setIcon(int i4) {
        M();
        this.f14733D.setIcon(i4);
    }

    public void setLogo(int i4) {
        M();
        this.f14733D.x(i4);
    }

    public void setShowingForActionMode(boolean z4) {
    }

    public void setSplitBarFitSystemWindows(boolean z4) {
    }

    public void setTransStatusBarInStepOS3(boolean z4) {
    }

    public void setUiOptions(int i4) {
        int i5 = 0;
        boolean z4 = i4 == 2;
        M();
        StepOSCollapsingToolbarLayout stepOSCollapsingToolbarLayout = this.f14732C;
        ActionBarContextView actionBarContextView = stepOSCollapsingToolbarLayout != null ? (ActionBarContextView) stepOSCollapsingToolbarLayout.findViewById(R.id.action_context_bar) : (ActionBarContextView) findViewById(R.id.action_context_bar);
        if (z4) {
            ActionBarContainer actionBarContainer = this.f14731B;
            if (actionBarContainer == null) {
                Log.e("ActionBarCoordinatorLayout", "Requested split action bar with incompatible window decor! Ignoring request.");
                return;
            }
            this.f14733D.A(actionBarContainer);
        } else {
            this.f14733D.A(null);
            if (!actionBarContextView.f14726x) {
                actionBarContextView.setSplitView(null);
            }
        }
        this.f14733D.p(z4);
        ActionBarContainer actionBarContainer2 = this.f14731B;
        if (actionBarContainer2 != null) {
            if (!this.f14733D.k() && !actionBarContextView.f14726x && !z4) {
                i5 = 8;
            }
            actionBarContainer2.setVisibility(i5);
        }
    }

    @Override // stepos.support.v7.widget.C
    public void setWindowCallback(Window.Callback callback) {
        M();
        this.f14733D.setWindowCallback(callback);
    }

    @Override // stepos.support.v7.widget.C
    public void setWindowTitle(CharSequence charSequence) {
        M();
        this.f14733D.setWindowTitle(charSequence);
    }

    public void setIcon(Drawable drawable) {
        M();
        this.f14733D.setIcon(drawable);
    }
}

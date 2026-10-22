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
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.stepos.ability.R;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/* loaded from: classes4.dex */
public class ActionBarCoordinatorLayout extends CoordinatorLayout implements H {
    public static final int[] p = {R.attr.steposActionBarCanScroll, R.attr.steposActionBarOverlayMode};

    /* renamed from: a, reason: collision with root package name */
    public FitsBottomContentLayout f6414a;
    public StepOSAppBarLayout b;
    public ActionBarContainer c;
    public StepOSCollapsingToolbarLayout d;
    public I e;
    public FrameLayout f;
    public final Rect g;
    public final Rect h;
    public final Rect i;

    /* renamed from: j, reason: collision with root package name */
    public final Rect f6415j;
    public final Rect k;
    public boolean l;
    public boolean m;
    public final boolean n;
    public int o;

    @Keep
    public static class StepOSScrollingViewBehavior extends AppBarLayout.ScrollingViewBehavior {
        public StepOSScrollingViewBehavior() {
        }

        @Override // com.google.android.material.appbar.h, com.google.android.material.appbar.k
        public void layoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i) {
            super.layoutChild(coordinatorLayout, view, i);
            List<View> dependencies = coordinatorLayout.getDependencies(view);
            try {
                a5.e eVarA = a5.g.a(this);
                if (((Integer) eVarA.a("getOverlapPixelsForOffset", View.class).f1642a.invoke(this, (View) eVarA.a("findFirstDependency", List.class).f1642a.invoke(this, dependencies))).intValue() == 0) {
                    view.layout(view.getLeft(), view.getTop() - getOverlayTop(), view.getRight(), view.getBottom() - getOverlayTop());
                }
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                Log.e("ActionBarCoordinatorLayout", "StepOSScrollingViewBehavior layoutChild error :" + e.getMessage());
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        @NonNull
        public WindowInsetsCompat onApplyWindowInsets(CoordinatorLayout coordinatorLayout, View view, WindowInsetsCompat windowInsetsCompat) {
            return super.onApplyWindowInsets(coordinatorLayout, view, windowInsetsCompat);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onDependentViewChanged(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
            ViewCompat.offsetTopAndBottom(view, (view2.getBottom() - view.getTop()) - getOverlayTop());
            return false;
        }

        @Override // com.google.android.material.appbar.h, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i, int i6, int i10, int i11) {
            int i12 = view.getLayoutParams().height;
            boolean zOnMeasureChild = super.onMeasureChild(coordinatorLayout, view, i, i6, i10, i11);
            coordinatorLayout.onMeasureChild(view, i, i6, View.MeasureSpec.makeMeasureSpec(getOverlayTop() + view.getMeasuredHeight(), i12 == -1 ? BasicMeasure.EXACTLY : Integer.MIN_VALUE), i11);
            return zOnMeasureChild;
        }

        public StepOSScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public ActionBarCoordinatorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.g = new Rect();
        this.h = new Rect();
        this.i = new Rect();
        this.f6415j = new Rect();
        this.k = new Rect();
        this.l = true;
        this.m = true;
        this.n = true;
        this.o = 0;
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(p);
        this.m = typedArrayObtainStyledAttributes.getBoolean(0, this.m);
        this.n = typedArrayObtainStyledAttributes.getBoolean(1, true);
        typedArrayObtainStyledAttributes.recycle();
    }

    public static void e(ActionBarCoordinatorLayout actionBarCoordinatorLayout, RecyclerView recyclerView) {
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
            View viewFindViewById = actionBarCoordinatorLayout.c.findViewById(R.id.stepos_nested_bottom_divider);
            int[] iArr2 = new int[2];
            viewFindViewById.getLocationInWindow(iArr2);
            int i = iArr2[1];
            int i6 = measuredHeight - i;
            viewFindViewById.setAlpha(i6 > 100 ? 1.0f : i > measuredHeight ? 0.0f : i6 / 100.0f);
        }
    }

    public static StepOSRecyclerView f(ViewGroup viewGroup) {
        StepOSRecyclerView stepOSRecyclerViewF;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof StepOSRecyclerView) {
                return (StepOSRecyclerView) childAt;
            }
            if ((childAt instanceof ViewGroup) && (stepOSRecyclerViewF = f((ViewGroup) childAt)) != null) {
                return stepOSRecyclerViewF;
            }
        }
        return null;
    }

    @Override // stepos.support.v7.widget.H
    public final void a(Menu menu, Va.A a3) {
        g();
        this.e.a(menu, a3);
    }

    @Override // stepos.support.v7.widget.H
    public final void b() {
    }

    @Override // stepos.support.v7.widget.H
    public final void c(Menu menu, Va.A a3) {
        g();
        this.e.g(menu, a3);
        if (this.e.b() && menu == null) {
            this.e.m(false);
        }
    }

    @Override // stepos.support.v7.widget.H
    public final boolean canShowOverflowMenu() {
        g();
        return this.e.canShowOverflowMenu();
    }

    @Override // stepos.support.v7.widget.H
    public final void d() {
    }

    @Override // stepos.support.v7.widget.H
    public final void dismissPopups() {
        g();
        this.e.dismissPopupMenus();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        boolean z10;
        WindowInsets windowInsetsDispatchApplyWindowInsets = super.dispatchApplyWindowInsets(windowInsets);
        Rect rect = new Rect();
        Insets insets = windowInsets.getInsets(WindowInsets.Type.systemBars());
        rect.set(insets.left, insets.top, insets.right, insets.bottom);
        Rect rect2 = this.f6415j;
        rect2.set(rect);
        int i = windowInsets.getInsets(WindowInsets.Type.ime()).bottom;
        boolean z11 = true;
        if (i > insets.bottom) {
            rect.bottom = i;
            z10 = true;
        } else {
            z10 = false;
        }
        int i6 = rect.top;
        Rect rect3 = this.h;
        rect3.top = i6;
        rect3.bottom = rect.bottom;
        this.k.set(rect);
        Rect rect4 = this.i;
        boolean zEquals = rect4.equals(rect3);
        ActionBarContainer actionBarContainer = this.c;
        boolean zA = actionBarContainer != null ? I0.a(actionBarContainer, rect2, false, true) : false;
        this.e.f(this.c);
        rect4.set(rect3);
        if (this.n) {
            int measuredHeight = this.b.getMeasuredHeight();
            int totalScrollRange = this.b.getTotalScrollRange();
            if (((CoordinatorLayout.LayoutParams) this.f.getLayoutParams()).getBehavior() instanceof StepOSScrollingViewBehavior) {
                rect4.top = measuredHeight - totalScrollRange;
            }
        }
        ActionBarContainer actionBarContainer2 = this.c;
        if (actionBarContainer2 != null && actionBarContainer2.getVisibility() != 8) {
            int measuredHeight2 = this.c.getMeasuredHeight();
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
            Rect rect5 = this.g;
            rect5.set(rect4);
            this.f6414a.dispatchFitSystemWindows(rect5);
        }
        if (z11) {
            requestLayout();
        }
        return windowInsetsDispatchApplyWindowInsets;
    }

    public final void g() {
        I wrapper;
        if (this.f6414a == null) {
            this.f6414a = (FitsBottomContentLayout) findViewById(androidx.appcompat.R.id.action_bar_activity_content);
            this.b = (StepOSAppBarLayout) findViewById(R.id.app_bar_layout);
            this.d = (StepOSCollapsingToolbarLayout) findViewById(R.id.action_bar_container);
            KeyEvent.Callback callbackFindViewById = findViewById(R.id.action_bar);
            if (callbackFindViewById instanceof I) {
                wrapper = (I) callbackFindViewById;
            } else {
                if (!(callbackFindViewById instanceof Toolbar)) {
                    throw new IllegalStateException("Can't make a decor toolbar out of ".concat(callbackFindViewById.getClass().getSimpleName()));
                }
                wrapper = ((Toolbar) callbackFindViewById).getWrapper();
            }
            this.e = wrapper;
            this.c = (ActionBarContainer) findViewById(R.id.split_action_bar);
            this.f = (FrameLayout) findViewById(R.id.content_container);
            this.f6414a.setActionBarOverlay(this.n);
            this.f6414a.setInterceptNestedScrollEnabled(!this.m);
            this.b.c(new C1987f(this, 0));
        }
    }

    public ActionBarDropDownView getActionBarDropDownView() {
        return null;
    }

    public CharSequence getTitle() {
        g();
        return this.e.getTitle();
    }

    @Override // stepos.support.v7.widget.H
    public final boolean hideOverflowMenu() {
        g();
        return this.e.hideOverflowMenu();
    }

    @Override // stepos.support.v7.widget.H
    public final void initFeature(int i) {
    }

    @Override // stepos.support.v7.widget.H
    public final boolean isOverflowMenuShowPending() {
        g();
        return this.e.isOverflowMenuShowPending();
    }

    @Override // stepos.support.v7.widget.H
    public final boolean isOverflowMenuShowing() {
        g();
        return this.e.isOverflowMenuShowing();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.m) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i, int i6, int i10, int i11) {
        StepOSRecyclerView stepOSRecyclerViewF;
        super.onLayout(z10, i, i6, i10, i11);
        if (this.c.getVisibility() == 8 || (stepOSRecyclerViewF = f(this.f6414a)) == null) {
            return;
        }
        stepOSRecyclerViewF.post(new A.a(19, this, stepOSRecyclerViewF));
        stepOSRecyclerViewF.addOnScrollListener(new C1989g(this, stepOSRecyclerViewF));
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View
    public final void onMeasure(int i, int i6) {
        int measuredHeight;
        super.onMeasure(i, i6);
        ActionBarContainer actionBarContainer = this.c;
        Rect rect = this.h;
        if (actionBarContainer == null || actionBarContainer.getVisibility() == 8) {
            measuredHeight = 0;
        } else {
            measuredHeight = this.c.getMeasuredHeight();
            int i10 = rect.bottom;
            if (measuredHeight > i10) {
                measuredHeight -= i10;
            }
        }
        Rect rect2 = this.i;
        rect2.set(rect);
        if (this.n) {
            int measuredHeight2 = this.b.getMeasuredHeight();
            int totalScrollRange = this.b.getTotalScrollRange();
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.f.getLayoutParams()).getBehavior();
            if (behavior instanceof StepOSScrollingViewBehavior) {
                int i11 = measuredHeight2 - totalScrollRange;
                ((StepOSScrollingViewBehavior) behavior).setOverlayTop(i11);
                rect2.top = i11;
            }
        }
        if (rect.bottom <= this.f6415j.bottom) {
            rect2.bottom += measuredHeight;
        }
        Rect rect3 = this.g;
        if (!rect3.equals(rect2) || getHeight() == 0) {
            rect3.set(rect2);
            this.f6414a.dispatchFitSystemWindows(rect3);
            super.onMeasure(i, i6);
        }
        boolean z10 = this.l;
        Rect rect4 = this.k;
        if (z10) {
            rect4.top = this.b.getMeasuredHeight() - rect.top;
        } else {
            rect4.top = (int) (a5.l.c(54.0f, getContext()) + findViewById(R.id.action_bar).getMeasuredHeight());
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, androidx.core.view.NestedScrollingParent2
    public final void onNestedPreScroll(View view, int i, int i6, int[] iArr, int i10) {
        super.onNestedPreScroll(view, i, i6, iArr, i10);
        if (iArr[1] != 0) {
            return;
        }
        if (i6 >= 0) {
            this.o += i6;
        } else {
            int i11 = this.o;
            if (i11 > 0) {
                this.o = i11 + i6;
            }
        }
        if (this.o > 100) {
            return;
        }
        float fAbs = Math.abs(r1) / 100.0f;
        View viewFindViewById = findViewById(R.id.stepos_nested_top_divider);
        if (viewFindViewById != null) {
            viewFindViewById.setAlpha(fAbs);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.m) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void setActionBarCanScroll(boolean z10) {
        this.m = z10;
        this.f6414a.setInterceptNestedScrollEnabled(!z10);
    }

    public void setActionBarFitStatusBar(boolean z10) {
    }

    @Override // stepos.support.v7.widget.H
    public void setBackTopBackground(Drawable drawable) {
    }

    @Override // stepos.support.v7.widget.H
    public void setBackTopClickCallback(View.OnClickListener onClickListener) {
    }

    @Override // stepos.support.v7.widget.H
    public void setBackTopEnable(boolean z10) {
    }

    public void setDropDownShowStart(int i) {
    }

    public void setIcon(int i) {
        g();
        this.e.setIcon(i);
    }

    public void setLogo(int i) {
        g();
        this.e.setLogo(i);
    }

    @Override // stepos.support.v7.widget.H
    public final void setMenuPrepared() {
        g();
        this.e.setMenuPrepared();
    }

    public void setShowingForActionMode(boolean z10) {
    }

    public void setSplitBarFitSystemWindows(boolean z10) {
    }

    public void setTransStatusBarInStepOS3(boolean z10) {
    }

    public void setUiOptions(int i) {
        int i6 = 0;
        boolean z10 = i == 2;
        g();
        StepOSCollapsingToolbarLayout stepOSCollapsingToolbarLayout = this.d;
        ActionBarContextView actionBarContextView = stepOSCollapsingToolbarLayout != null ? (ActionBarContextView) stepOSCollapsingToolbarLayout.findViewById(R.id.action_context_bar) : (ActionBarContextView) findViewById(R.id.action_context_bar);
        if (z10) {
            ActionBarContainer actionBarContainer = this.c;
            if (actionBarContainer == null) {
                Log.e("ActionBarCoordinatorLayout", "Requested split action bar with incompatible window decor! Ignoring request.");
                return;
            }
            this.e.h(actionBarContainer);
        } else {
            this.e.h(null);
            if (!actionBarContextView.f6412x) {
                actionBarContextView.setSplitView(null);
            }
        }
        this.e.m(z10);
        ActionBarContainer actionBarContainer2 = this.c;
        if (actionBarContainer2 != null) {
            if (!this.e.e() && !actionBarContextView.f6412x && !z10) {
                i6 = 8;
            }
            actionBarContainer2.setVisibility(i6);
        }
    }

    @Override // stepos.support.v7.widget.H
    public void setWindowCallback(Window.Callback callback) {
        g();
        this.e.setWindowCallback(callback);
    }

    @Override // stepos.support.v7.widget.H
    public void setWindowTitle(CharSequence charSequence) {
        g();
        this.e.setWindowTitle(charSequence);
    }

    @Override // stepos.support.v7.widget.H
    public final boolean showOverflowMenu() {
        g();
        return this.e.showOverflowMenu();
    }

    public void setIcon(Drawable drawable) {
        g();
        this.e.setIcon(drawable);
    }
}

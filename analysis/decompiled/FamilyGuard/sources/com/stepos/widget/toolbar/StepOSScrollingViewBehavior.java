package com.stepos.widget.toolbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import j4.k;

/* loaded from: classes.dex */
public class StepOSScrollingViewBehavior extends CoordinatorLayout.c<View> {
    public StepOSScrollingViewBehavior() {
    }

    private final StepOSAppBarLayout c(CoordinatorLayout coordinatorLayout) {
        int childCount = coordinatorLayout.getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = coordinatorLayout.getChildAt(i5);
            if (childAt instanceof StepOSAppBarLayout) {
                return (StepOSAppBarLayout) childAt;
            }
        }
        return null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
        k.g(coordinatorLayout, "parent");
        k.g(view, "child");
        k.g(view2, "dependency");
        return view2 instanceof StepOSAppBarLayout;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
        k.g(coordinatorLayout, "parent");
        k.g(view, "child");
        k.g(view2, "dependency");
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i5) {
        k.g(coordinatorLayout, "parent");
        k.g(view, "child");
        StepOSAppBarLayout stepOSAppBarLayoutC = c(coordinatorLayout);
        boolean z5 = false;
        if (stepOSAppBarLayoutC == null) {
            return false;
        }
        if (stepOSAppBarLayoutC.getTop() == 0 && stepOSAppBarLayoutC.getBottom() == 0) {
            coordinatorLayout.W(stepOSAppBarLayoutC, i5);
        }
        a aVarA = stepOSAppBarLayoutC.a();
        int collapsedHeight = aVarA != null ? aVarA.getCollapsedHeight() : stepOSAppBarLayoutC.getBottom() - stepOSAppBarLayoutC.getTop();
        if (aVarA != null && aVarA.D()) {
            z5 = true;
        }
        int top = stepOSAppBarLayoutC.getTop();
        if (!z5) {
            top += collapsedHeight;
        }
        int paddingLeft = coordinatorLayout.getPaddingLeft();
        int width = coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight();
        int height = coordinatorLayout.getHeight() - coordinatorLayout.getPaddingBottom();
        int measuredHeight = stepOSAppBarLayoutC.getMeasuredHeight();
        if (!z5) {
            measuredHeight -= collapsedHeight;
        }
        if (measuredHeight > view.getPaddingTop()) {
            view.setPaddingRelative(view.getPaddingStart(), measuredHeight, view.getPaddingEnd(), view.getPaddingBottom());
        }
        view.layout(paddingLeft, top, width, height);
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.g(context, "context");
        k.g(attributeSet, "attrs");
    }
}

package com.stepos.widget.toolbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0003\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0003\u0010\tJ\u0019\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0013J'\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/stepos/widget/toolbar/StepOSScrollingViewBehavior;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$c;", "Landroid/view/View;", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "parent", "Lcom/stepos/widget/toolbar/StepOSAppBarLayout;", "findAppBarLayout", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;)Lcom/stepos/widget/toolbar/StepOSAppBarLayout;", "child", "dependency", "", "layoutDependsOn", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/View;)Z", "onDependentViewChanged", "", "layoutDirection", "onLayoutChild", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;I)Z", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public class StepOSScrollingViewBehavior extends CoordinatorLayout.c<View> {
    public StepOSScrollingViewBehavior() {
    }

    private final StepOSAppBarLayout findAppBarLayout(CoordinatorLayout parent) {
        int childCount = parent.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = parent.getChildAt(i10);
            if (childAt instanceof StepOSAppBarLayout) {
                return (StepOSAppBarLayout) childAt;
            }
        }
        return null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        kotlin.jvm.internal.p.i(parent, "parent");
        kotlin.jvm.internal.p.i(child, "child");
        kotlin.jvm.internal.p.i(dependency, "dependency");
        return dependency instanceof StepOSAppBarLayout;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        kotlin.jvm.internal.p.i(parent, "parent");
        kotlin.jvm.internal.p.i(child, "child");
        kotlin.jvm.internal.p.i(dependency, "dependency");
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onLayoutChild(CoordinatorLayout parent, View child, int layoutDirection) {
        kotlin.jvm.internal.p.i(parent, "parent");
        kotlin.jvm.internal.p.i(child, "child");
        StepOSAppBarLayout stepOSAppBarLayoutFindAppBarLayout = findAppBarLayout(parent);
        boolean backdropBlurEnabled = false;
        if (stepOSAppBarLayoutFindAppBarLayout == null) {
            return false;
        }
        if (stepOSAppBarLayoutFindAppBarLayout.getTop() == 0 && stepOSAppBarLayoutFindAppBarLayout.getBottom() == 0) {
            parent.Q(stepOSAppBarLayoutFindAppBarLayout, layoutDirection);
        }
        StepOSCollapsingTitleBar stepOSCollapsingTitleBarFindCollapsingTitleBar = stepOSAppBarLayoutFindAppBarLayout.findCollapsingTitleBar();
        StepOSTitleBar stepOSTitleBarFindTitleBar = stepOSAppBarLayoutFindAppBarLayout.findTitleBar();
        int collapsedHeight = stepOSCollapsingTitleBarFindCollapsingTitleBar != null ? stepOSCollapsingTitleBarFindCollapsingTitleBar.getCollapsedHeight() : stepOSAppBarLayoutFindAppBarLayout.getBottom() - stepOSAppBarLayoutFindAppBarLayout.getTop();
        if (stepOSCollapsingTitleBarFindCollapsingTitleBar != null) {
            backdropBlurEnabled = stepOSCollapsingTitleBarFindCollapsingTitleBar.getBackdropBlurEnabled();
        } else if (stepOSTitleBarFindTitleBar != null) {
            backdropBlurEnabled = stepOSTitleBarFindTitleBar.getBackdropBlurEnabled();
        }
        int top = stepOSAppBarLayoutFindAppBarLayout.getTop();
        if (!backdropBlurEnabled) {
            top += collapsedHeight;
        }
        int paddingLeft = parent.getPaddingLeft();
        int width = parent.getWidth() - parent.getPaddingRight();
        int height = parent.getHeight() - parent.getPaddingBottom();
        int measuredHeight = stepOSAppBarLayoutFindAppBarLayout.getMeasuredHeight();
        if (!backdropBlurEnabled) {
            measuredHeight -= collapsedHeight;
        }
        if (measuredHeight > child.getPaddingTop()) {
            child.setPaddingRelative(child.getPaddingStart(), measuredHeight, child.getPaddingEnd(), child.getPaddingBottom());
        }
        child.layout(paddingLeft, top, width, height);
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSScrollingViewBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(attrs, "attrs");
    }
}

package com.stepos.widget.toolbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0003\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0003\u0010\t¨\u0006\n"}, d2 = {"Lcom/stepos/widget/toolbar/StepOSScrollingViewBehavior;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", "Landroid/view/View;", AppAgent.CONSTRUCT, "()V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public class StepOSScrollingViewBehavior extends CoordinatorLayout.Behavior<View> {
    public StepOSScrollingViewBehavior() {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        k.f(parent, "parent");
        k.f(child, "child");
        k.f(dependency, "dependency");
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        k.f(parent, "parent");
        k.f(child, "child");
        k.f(dependency, "dependency");
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onLayoutChild(CoordinatorLayout parent, View child, int i) {
        k.f(parent, "parent");
        k.f(child, "child");
        int childCount = parent.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            parent.getChildAt(i6);
        }
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSScrollingViewBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        k.f(context, "context");
        k.f(attrs, "attrs");
    }
}

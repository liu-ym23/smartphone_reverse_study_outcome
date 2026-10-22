package com.stepos.widget.toolbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0003\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0003\u0010\t¨\u0006\n"}, d2 = {"com/stepos/widget/toolbar/StepOSAppBarLayout$Behavior", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", "", AppAgent.CONSTRUCT, "()V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class StepOSAppBarLayout$Behavior extends CoordinatorLayout.Behavior<Object> {

    /* renamed from: a, reason: collision with root package name */
    public WeakReference f4155a;
    public WeakReference b;

    public StepOSAppBarLayout$Behavior() {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onDetachedFromLayoutParams() {
        WeakReference weakReference = this.f4155a;
        if (weakReference != null && weakReference.get() != null) {
            throw new ClassCastException();
        }
        WeakReference weakReference2 = this.b;
        if (weakReference2 != null) {
        }
        WeakReference weakReference3 = this.b;
        if (weakReference3 != null) {
        }
        this.b = null;
        this.f4155a = null;
        super.onDetachedFromLayoutParams();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onInterceptTouchEvent(CoordinatorLayout parent, View view, MotionEvent motionEvent) {
        if (view != null) {
            throw new ClassCastException();
        }
        k.f(parent, "parent");
        k.f(null, "child");
        throw null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onLayoutChild(CoordinatorLayout parent, View view, int i) {
        if (view != null) {
            throw new ClassCastException();
        }
        k.f(parent, "parent");
        k.f(null, "child");
        throw null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onNestedFling(CoordinatorLayout parent, View view, View target, float f, float f7, boolean z10) {
        if (view != null) {
            throw new ClassCastException();
        }
        k.f(parent, "parent");
        k.f(null, "child");
        k.f(target, "target");
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onNestedPreFling(CoordinatorLayout parent, View view, View target, float f, float f7) {
        if (view != null) {
            throw new ClassCastException();
        }
        k.f(parent, "parent");
        k.f(null, "child");
        k.f(target, "target");
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onNestedPreScroll(CoordinatorLayout parent, View view, View target, int i, int i6, int[] consumed, int i10) {
        if (view != null) {
            throw new ClassCastException();
        }
        k.f(parent, "parent");
        k.f(null, "child");
        k.f(target, "target");
        k.f(consumed, "consumed");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onNestedScroll(CoordinatorLayout parent, View view, View view2, int i, int i6, int i10, int i11, int i12, int[] iArr) {
        if (view != null) {
            throw new ClassCastException();
        }
        k.f(parent, "parent");
        k.f(null, "child");
        throw null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onStartNestedScroll(CoordinatorLayout parent, View view, View view2, View view3, int i, int i6) {
        if (view != null) {
            throw new ClassCastException();
        }
        k.f(parent, "parent");
        k.f(null, "child");
        throw null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onStopNestedScroll(CoordinatorLayout parent, View view, View view2, int i) {
        if (view != null) {
            throw new ClassCastException();
        }
        k.f(parent, "parent");
        k.f(null, "child");
        throw null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onTouchEvent(CoordinatorLayout parent, View view, MotionEvent motionEvent) {
        if (view != null) {
            throw new ClassCastException();
        }
        k.f(parent, "parent");
        k.f(null, "child");
        throw null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSAppBarLayout$Behavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        k.f(context, "context");
        k.f(attrs, "attrs");
    }
}

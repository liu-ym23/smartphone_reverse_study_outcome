package com.stepos.widget.toolbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import b3.a;
import java.lang.ref.WeakReference;
import od.f;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class StepOSAppBarLayout$Behavior extends a {

    /* renamed from: a, reason: collision with root package name */
    public WeakReference f2891a;

    /* renamed from: b, reason: collision with root package name */
    public WeakReference f2892b;

    public StepOSAppBarLayout$Behavior(Context context, AttributeSet attributeSet) {
        context.getClass();
        attributeSet.getClass();
    }

    @Override // b3.a
    public final void onDetachedFromLayoutParams() {
        WeakReference weakReference = this.f2891a;
        if (weakReference != null && weakReference.get() != null) {
            f.j();
            return;
        }
        WeakReference weakReference2 = this.f2892b;
        if (weakReference2 != null) {
        }
        WeakReference weakReference3 = this.f2892b;
        if (weakReference3 != null) {
        }
        this.f2892b = null;
        this.f2891a = null;
        super.onDetachedFromLayoutParams();
    }

    @Override // b3.a
    public final boolean onInterceptTouchEvent(androidx.coordinatorlayout.widget.a aVar, View view, MotionEvent motionEvent) {
        if (view != null) {
            throw new ClassCastException();
        }
        aVar.getClass();
        throw null;
    }

    @Override // b3.a
    public final boolean onLayoutChild(androidx.coordinatorlayout.widget.a aVar, View view, int i) {
        throw new ClassCastException();
    }

    @Override // b3.a
    public final boolean onNestedFling(androidx.coordinatorlayout.widget.a aVar, View view, View view2, float f5, float f10, boolean z10) {
        if (view != null) {
            throw new ClassCastException();
        }
        aVar.getClass();
        throw null;
    }

    @Override // b3.a
    public final boolean onNestedPreFling(androidx.coordinatorlayout.widget.a aVar, View view, View view2, float f5, float f10) {
        if (view != null) {
            throw new ClassCastException();
        }
        aVar.getClass();
        throw null;
    }

    @Override // b3.a
    public final void onNestedPreScroll(androidx.coordinatorlayout.widget.a aVar, View view, View view2, int i, int i3, int[] iArr, int i10) {
        if (view != null) {
            throw new ClassCastException();
        }
        aVar.getClass();
        throw null;
    }

    @Override // b3.a
    public final void onNestedScroll(androidx.coordinatorlayout.widget.a aVar, View view, View view2, int i, int i3, int i10, int i11, int i12, int[] iArr) {
        if (view != null) {
            throw new ClassCastException();
        }
        aVar.getClass();
        throw null;
    }

    @Override // b3.a
    public final boolean onStartNestedScroll(androidx.coordinatorlayout.widget.a aVar, View view, View view2, View view3, int i, int i3) {
        if (view != null) {
            throw new ClassCastException();
        }
        aVar.getClass();
        throw null;
    }

    @Override // b3.a
    public final void onStopNestedScroll(androidx.coordinatorlayout.widget.a aVar, View view, View view2, int i) {
        if (view != null) {
            throw new ClassCastException();
        }
        aVar.getClass();
        throw null;
    }

    @Override // b3.a
    public final boolean onTouchEvent(androidx.coordinatorlayout.widget.a aVar, View view, MotionEvent motionEvent) {
        if (view != null) {
            throw new ClassCastException();
        }
        aVar.getClass();
        throw null;
    }

    public StepOSAppBarLayout$Behavior() {
    }
}

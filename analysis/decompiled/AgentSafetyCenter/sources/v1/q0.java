package v1;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.HashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class q0 extends ViewGroup {

    /* renamed from: c, reason: collision with root package name */
    public HashMap f14525c;

    /* renamed from: f, reason: collision with root package name */
    public HashMap f14526f;

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public final HashMap<r2.h, u1.g0> getHolderToLayoutNode() {
        return this.f14525c;
    }

    public final HashMap<u1.g0, r2.h> getLayoutNodeToHolder() {
        return this.f14526f;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final /* bridge */ /* synthetic */ ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i, int i3, int i10, int i11) {
        for (r2.h hVar : this.f14525c.keySet()) {
            hVar.layout(hVar.getLeft(), hVar.getTop(), hVar.getRight(), hVar.getBottom());
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i3) {
        int i10;
        if (!(View.MeasureSpec.getMode(i) == 1073741824)) {
            r1.a.a("widthMeasureSpec should be EXACTLY");
        }
        if (!(View.MeasureSpec.getMode(i3) == 1073741824)) {
            r1.a.a("heightMeasureSpec should be EXACTLY");
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i3));
        for (r2.h hVar : this.f14525c.keySet()) {
            int i11 = hVar.f10406y;
            if (i11 != Integer.MIN_VALUE && (i10 = hVar.f10407z) != Integer.MIN_VALUE) {
                hVar.measure(i11, i10);
            }
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        cleanupLayoutState(this);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            u1.g0 g0Var = (u1.g0) this.f14525c.get(childAt);
            if (childAt.isLayoutRequested() && g0Var != null) {
                u1.g0.V(g0Var, false, 7);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onDescendantInvalidated(View view, View view2) {
    }
}

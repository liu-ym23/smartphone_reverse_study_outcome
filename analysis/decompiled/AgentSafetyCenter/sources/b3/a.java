package b3;

import android.graphics.Rect;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.view.View;
import n3.m1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class a {
    public static Object getTag(View view) {
        return ((d) view.getLayoutParams()).f1893r;
    }

    public static void setTag(View view, Object obj) {
        ((d) view.getLayoutParams()).f1893r = obj;
    }

    public boolean blocksInteractionBelow(androidx.coordinatorlayout.widget.a aVar, View view) {
        return getScrimOpacity(aVar, view) > 0.0f;
    }

    public boolean getInsetDodgeRect(androidx.coordinatorlayout.widget.a aVar, View view, Rect rect) {
        return false;
    }

    public int getScrimColor(androidx.coordinatorlayout.widget.a aVar, View view) {
        return -16777216;
    }

    public float getScrimOpacity(androidx.coordinatorlayout.widget.a aVar, View view) {
        return 0.0f;
    }

    public boolean layoutDependsOn(androidx.coordinatorlayout.widget.a aVar, View view, View view2) {
        return false;
    }

    public boolean onDependentViewChanged(androidx.coordinatorlayout.widget.a aVar, View view, View view2) {
        return false;
    }

    public boolean onInterceptTouchEvent(androidx.coordinatorlayout.widget.a aVar, View view, MotionEvent motionEvent) {
        return false;
    }

    public boolean onLayoutChild(androidx.coordinatorlayout.widget.a aVar, View view, int i) {
        return false;
    }

    public boolean onMeasureChild(androidx.coordinatorlayout.widget.a aVar, View view, int i, int i3, int i10, int i11) {
        return false;
    }

    public boolean onNestedFling(androidx.coordinatorlayout.widget.a aVar, View view, View view2, float f5, float f10, boolean z10) {
        return false;
    }

    public boolean onNestedPreFling(androidx.coordinatorlayout.widget.a aVar, View view, View view2, float f5, float f10) {
        return false;
    }

    public void onNestedPreScroll(androidx.coordinatorlayout.widget.a aVar, View view, View view2, int i, int i3, int[] iArr, int i10) {
        if (i10 == 0) {
            onNestedPreScroll(aVar, view, view2, i, i3, iArr);
        }
    }

    public void onNestedScroll(androidx.coordinatorlayout.widget.a aVar, View view, View view2, int i, int i3, int i10, int i11, int i12, int[] iArr) {
        iArr[0] = iArr[0] + i10;
        iArr[1] = iArr[1] + i11;
        onNestedScroll(aVar, view, view2, i, i3, i10, i11, i12);
    }

    public void onNestedScrollAccepted(androidx.coordinatorlayout.widget.a aVar, View view, View view2, View view3, int i, int i3) {
        if (i3 == 0) {
            onNestedScrollAccepted(aVar, view, view2, view3, i);
        }
    }

    public boolean onRequestChildRectangleOnScreen(androidx.coordinatorlayout.widget.a aVar, View view, Rect rect, boolean z10) {
        return false;
    }

    public Parcelable onSaveInstanceState(androidx.coordinatorlayout.widget.a aVar, View view) {
        return View.BaseSavedState.EMPTY_STATE;
    }

    public boolean onStartNestedScroll(androidx.coordinatorlayout.widget.a aVar, View view, View view2, View view3, int i, int i3) {
        if (i3 == 0) {
            return onStartNestedScroll(aVar, view, view2, view3, i);
        }
        return false;
    }

    public void onStopNestedScroll(androidx.coordinatorlayout.widget.a aVar, View view, View view2, int i) {
        if (i == 0) {
            onStopNestedScroll(aVar, view, view2);
        }
    }

    public boolean onTouchEvent(androidx.coordinatorlayout.widget.a aVar, View view, MotionEvent motionEvent) {
        return false;
    }

    @Deprecated
    public void onNestedPreScroll(androidx.coordinatorlayout.widget.a aVar, View view, View view2, int i, int i3, int[] iArr) {
    }

    @Deprecated
    public void onNestedScrollAccepted(androidx.coordinatorlayout.widget.a aVar, View view, View view2, View view3, int i) {
    }

    @Deprecated
    public void onStopNestedScroll(androidx.coordinatorlayout.widget.a aVar, View view, View view2) {
    }

    @Deprecated
    public boolean onStartNestedScroll(androidx.coordinatorlayout.widget.a aVar, View view, View view2, View view3, int i) {
        return false;
    }

    @Deprecated
    public void onNestedScroll(androidx.coordinatorlayout.widget.a aVar, View view, View view2, int i, int i3, int i10, int i11, int i12) {
        if (i12 == 0) {
            onNestedScroll(aVar, view, view2, i, i3, i10, i11);
        }
    }

    @Deprecated
    public void onNestedScroll(androidx.coordinatorlayout.widget.a aVar, View view, View view2, int i, int i3, int i10, int i11) {
    }

    public void onDetachedFromLayoutParams() {
    }

    public void onAttachedToLayoutParams(d dVar) {
    }

    public m1 onApplyWindowInsets(androidx.coordinatorlayout.widget.a aVar, View view, m1 m1Var) {
        return m1Var;
    }

    public void onDependentViewRemoved(androidx.coordinatorlayout.widget.a aVar, View view, View view2) {
    }

    public void onRestoreInstanceState(androidx.coordinatorlayout.widget.a aVar, View view, Parcelable parcelable) {
    }
}

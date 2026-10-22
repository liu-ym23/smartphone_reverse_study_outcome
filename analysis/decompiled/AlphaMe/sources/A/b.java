package A;

import K.z0;
import android.graphics.Rect;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.baidu.mapapi.map.WeightedLatLng;
import com.stepos.alphame.utils.Property;

/* loaded from: classes.dex */
public abstract class b {
    @Nullable
    public static Object getTag(@NonNull View view) {
        return ((d) view.getLayoutParams()).f22r;
    }

    public static void setTag(@NonNull View view, @Nullable Object obj) {
        ((d) view.getLayoutParams()).f22r = obj;
    }

    public boolean blocksInteractionBelow(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view) {
        return getScrimOpacity(coordinatorLayout, view) > Property.DEFAULT_FLOAT_VALUE;
    }

    public boolean getInsetDodgeRect(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull Rect rect) {
        return false;
    }

    @ColorInt
    public int getScrimColor(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view) {
        return -16777216;
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getScrimOpacity(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view) {
        return Property.DEFAULT_FLOAT_VALUE;
    }

    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return false;
    }

    public z0 onApplyWindowInsets(CoordinatorLayout coordinatorLayout, View view, z0 z0Var) {
        return z0Var;
    }

    public void onAttachedToLayoutParams(@NonNull d dVar) {
    }

    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return false;
    }

    public void onDependentViewRemoved(CoordinatorLayout coordinatorLayout, View view, View view2) {
    }

    public void onDetachedFromLayoutParams() {
    }

    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
        return false;
    }

    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i4) {
        return false;
    }

    public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i4, int i5, int i6, int i7) {
        return false;
    }

    public boolean onNestedFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2, float f4, float f5, boolean z4) {
        return false;
    }

    public boolean onNestedPreFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2, float f4, float f5) {
        return false;
    }

    @Deprecated
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2, int i4, int i5, @NonNull int[] iArr) {
    }

    @Deprecated
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2, int i4, int i5, int i6, int i7) {
    }

    @Deprecated
    public void onNestedScrollAccepted(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2, @NonNull View view3, int i4) {
    }

    public boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z4) {
        return false;
    }

    public void onRestoreInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull Parcelable parcelable) {
    }

    @Nullable
    public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view) {
        return View.BaseSavedState.EMPTY_STATE;
    }

    @Deprecated
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2, @NonNull View view3, int i4) {
        return false;
    }

    @Deprecated
    public void onStopNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
    }

    public boolean onTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
        return false;
    }

    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2, int i4, int i5, @NonNull int[] iArr, int i6) {
        if (i6 == 0) {
            onNestedPreScroll(coordinatorLayout, view, view2, i4, i5, iArr);
        }
    }

    @Deprecated
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2, int i4, int i5, int i6, int i7, int i8) {
        if (i8 == 0) {
            onNestedScroll(coordinatorLayout, view, view2, i4, i5, i6, i7);
        }
    }

    public void onNestedScrollAccepted(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2, @NonNull View view3, int i4, int i5) {
        if (i5 == 0) {
            onNestedScrollAccepted(coordinatorLayout, view, view2, view3, i4);
        }
    }

    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2, @NonNull View view3, int i4, int i5) {
        if (i5 == 0) {
            return onStartNestedScroll(coordinatorLayout, view, view2, view3, i4);
        }
        return false;
    }

    public void onStopNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2, int i4) {
        if (i4 == 0) {
            onStopNestedScroll(coordinatorLayout, view, view2);
        }
    }

    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2, int i4, int i5, int i6, int i7, int i8, @NonNull int[] iArr) {
        iArr[0] = iArr[0] + i6;
        iArr[1] = iArr[1] + i7;
        onNestedScroll(coordinatorLayout, view, view2, i4, i5, i6, i7, i8);
    }
}

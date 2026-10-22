package androidx.core.view;

import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.ReplaceWith;
import java.util.Objects;

/* JADX INFO: loaded from: classes17.dex */
public final class ViewParentCompat {
    private static final String TAG = "ViewParentCompat";
    private static int[] sTempNestedScrollConsumed;

    public static class Api21Impl {
        private Api21Impl() {
        }

        public static void onStopNestedScroll(ViewParent r100, View r101) {
            r100.onStopNestedScroll(r101);
        }

        public static boolean onNestedPreFling(ViewParent r100, View r101, float r102, float r103) {
            return r100.onNestedPreFling(r101, r102, r103);
        }

        public static void onNestedScrollAccepted(ViewParent r100, View r101, View r102, int r103) {
            r100.onNestedScrollAccepted(r101, r102, r103);
        }

        public static boolean onStartNestedScroll(ViewParent r100, View r101, View r102, int r103) {
            return r100.onStartNestedScroll(r101, r102, r103);
        }

        public static boolean onNestedFling(ViewParent r100, View r101, float r102, float r103, boolean r104) {
            return r100.onNestedFling(r101, r102, r103, r104);
        }

        public static void onNestedPreScroll(ViewParent r100, View r101, int r102, int r103, int[] r104) {
            r100.onNestedPreScroll(r101, r102, r103, r104);
        }

        public static void onNestedScroll(ViewParent r100, View r101, int r102, int r103, int r104, int r105) {
            r100.onNestedScroll(r101, r102, r103, r104, r105);
        }
    }

    private ViewParentCompat() {
    }

    private static int[] getTempNestedScrollConsumed() {
        int[] r100 = sTempNestedScrollConsumed;
        if (r100 != null) goto L5;
        sTempNestedScrollConsumed = new int[2];
    L7:
        return sTempNestedScrollConsumed;
    L5:
        r100[0] = 0;
        r100[1] = 0;
        goto L7
    }

    public static void onStopNestedScroll(ViewParent r100, View r101) {
        onStopNestedScroll(r100, r101, 0);
    }

    public static void onStopNestedScroll(ViewParent r100, View r101, int r102) {
        if ((r100 instanceof NestedScrollingParent2) == false) goto L5;
        ((NestedScrollingParent2) r100).onStopNestedScroll(r101, r102);
        return;
    L5:
        if (r102 != 0) goto L13;
        Api21Impl.onStopNestedScroll(r100, r101);     // Catch: AbstractMethodError -> L8
        return;
    L8:
        Objects.toString(r100);
        return;
    }

    @ReplaceWith(expression = "parent.requestSendAccessibilityEvent(child, event)")
    public static boolean requestSendAccessibilityEvent(ViewParent r100, View r101, AccessibilityEvent r102) {
        return r100.requestSendAccessibilityEvent(r101, r102);
    }

    @ReplaceWith(expression = "parent.notifySubtreeAccessibilityStateChanged(child, source, changeType)")
    public static void notifySubtreeAccessibilityStateChanged(ViewParent r100, View r101, View r102, int r103) {
        r100.notifySubtreeAccessibilityStateChanged(r101, r102, r103);
    }

    public static boolean onNestedPreFling(ViewParent r100, View r101, float r102, float r103) {
        return Api21Impl.onNestedPreFling(r100, r101, r102, r103);
    L4:
        Objects.toString(r100);
        return false;
    }

    public static void onNestedScrollAccepted(ViewParent r100, View r101, View r102, int r103) {
        onNestedScrollAccepted(r100, r101, r102, r103, 0);
    }

    public static boolean onStartNestedScroll(ViewParent r100, View r101, View r102, int r103) {
        return onStartNestedScroll(r100, r101, r102, r103, 0);
    }

    public static boolean onNestedFling(ViewParent r100, View r101, float r102, float r103, boolean r104) {
        return Api21Impl.onNestedFling(r100, r101, r102, r103, r104);
    L4:
        Objects.toString(r100);
        return false;
    }

    public static void onNestedPreScroll(ViewParent r100, View r101, int r102, int r103, int[] r110) {
        onNestedPreScroll(r100, r101, r102, r103, r110, 0);
    }

    public static void onNestedScrollAccepted(ViewParent r100, View r101, View r102, int r103, int r104) {
        if ((r100 instanceof NestedScrollingParent2) == false) goto L5;
        ((NestedScrollingParent2) r100).onNestedScrollAccepted(r101, r102, r103, r104);
        return;
    L5:
        if (r104 != 0) goto L13;
        Api21Impl.onNestedScrollAccepted(r100, r101, r102, r103);     // Catch: AbstractMethodError -> L8
        return;
    L8:
        Objects.toString(r100);
        return;
    }

    public static boolean onStartNestedScroll(ViewParent r100, View r101, View r102, int r103, int r104) {
        if ((r100 instanceof NestedScrollingParent2) == true) goto L5;
        if (r104 != 0) goto L14;
        return Api21Impl.onStartNestedScroll(r100, r101, r102, r103);
    L9:
        Objects.toString(r100);
        return false;
    L14:
        return false;
    L5:
        return ((NestedScrollingParent2) r100).onStartNestedScroll(r101, r102, r103, r104);
    }

    public static void onNestedPreScroll(ViewParent r100, View r101, int r102, int r110, int[] r111, int r112) {
        if ((r100 instanceof NestedScrollingParent2) == false) goto L5;
        ((NestedScrollingParent2) r100).onNestedPreScroll(r101, r102, r110, r111, r112);
        return;
    L5:
        if (r112 != 0) goto L13;
        Api21Impl.onNestedPreScroll(r100, r101, r102, r110, r111);     // Catch: AbstractMethodError -> L8
        return;
    L8:
        Objects.toString(r100);
        return;
    }

    public static void onNestedScroll(ViewParent r100, View r101, int r110, int r111, int r112, int r113) {
        onNestedScroll(r100, r101, r110, r111, r112, r113, 0, getTempNestedScrollConsumed());
    }

    public static void onNestedScroll(ViewParent r100, View r101, int r110, int r111, int r112, int r113, int r114) {
        onNestedScroll(r100, r101, r110, r111, r112, r113, r114, getTempNestedScrollConsumed());
    }

    public static void onNestedScroll(ViewParent r110, View r111, int r112, int r113, int r114, int r115, int r116, int[] r117) {
        if ((r110 instanceof NestedScrollingParent3) == false) goto L5;
        ((NestedScrollingParent3) r110).onNestedScroll(r111, r112, r113, r114, r115, r116, r117);
        return;
    L5:
        r117[0] = r117[0] + r114;
        r117[1] = r117[1] + r115;
        if ((r110 instanceof NestedScrollingParent2) == false) goto L8;
        ((NestedScrollingParent2) r110).onNestedScroll(r111, r112, r113, r114, r115, r116);
        return;
    L8:
        if (r116 != 0) goto L17;
        Api21Impl.onNestedScroll(r110, r111, r112, r113, r114, r115);     // Catch: AbstractMethodError -> L11
        return;
    L11:
        Objects.toString(r110);
        return;
    }
}

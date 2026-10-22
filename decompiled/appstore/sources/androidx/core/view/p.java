package androidx.core.view;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.DoNotInline;

/* JADX INFO: loaded from: classes.dex */
public abstract class p {

    public static class a {
        @DoNotInline
        public static boolean a(ViewParent r10, View r11, float r12, float r13, boolean r14) {
            return r10.onNestedFling(r11, r12, r13, r14);
        }

        @DoNotInline
        public static boolean b(ViewParent r10, View r11, float r12, float r13) {
            return r10.onNestedPreFling(r11, r12, r13);
        }

        @DoNotInline
        public static void c(ViewParent r10, View r11, int r12, int r13, int[] r14) {
            r10.onNestedPreScroll(r11, r12, r13, r14);
        }

        @DoNotInline
        public static void d(ViewParent r10, View r11, int r12, int r13, int r14, int r15) {
            r10.onNestedScroll(r11, r12, r13, r14, r15);
        }

        @DoNotInline
        public static void e(ViewParent r10, View r11, View r12, int r13) {
            r10.onNestedScrollAccepted(r11, r12, r13);
        }

        @DoNotInline
        public static boolean f(ViewParent r10, View r11, View r12, int r13) {
            return r10.onStartNestedScroll(r11, r12, r13);
        }

        @DoNotInline
        public static void g(ViewParent r10, View r11) {
            r10.onStopNestedScroll(r11);
        }
    }

    public static boolean a(ViewParent r10, View r11, float r12, float r13, boolean r14) {
        return a.a(r10, r11, r12, r13, r14);
    L4:
        e = move-exception;
        Log.e("ViewParentCompat", "ViewParent " + r10 + " does not implement interface method onNestedFling", e);
        return false;
    }

    public static boolean b(ViewParent r10, View r11, float r12, float r13) {
        return a.b(r10, r11, r12, r13);
    L4:
        e = move-exception;
        Log.e("ViewParentCompat", "ViewParent " + r10 + " does not implement interface method onNestedPreFling", e);
        return false;
    }

    public static void c(ViewParent r10, View r11, int r12, int r13, int[] r14, int r15) {
        if ((r10 instanceof NestedScrollingParent2) == false) goto L5;
        ((NestedScrollingParent2) r10).onNestedPreScroll(r11, r12, r13, r14, r15);
        return;
    L5:
        if (r15 != 0) goto L14;
        a.c(r10, r11, r12, r13, r14);     // Catch: AbstractMethodError -> L8
        return;
    L8:
        e = move-exception;
        Log.e("ViewParentCompat", "ViewParent " + r10 + " does not implement interface method onNestedPreScroll", e);
        return;
    }

    public static void d(ViewParent r10, View r11, int r12, int r13, int r14, int r15, int r16, int[] r17) {
        if ((r10 instanceof NestedScrollingParent3) == false) goto L5;
        ((NestedScrollingParent3) r10).onNestedScroll(r11, r12, r13, r14, r15, r16, r17);
        return;
    L5:
        r17[0] = r17[0] + r14;
        r17[1] = r17[1] + r15;
        if ((r10 instanceof NestedScrollingParent2) == false) goto L8;
        ((NestedScrollingParent2) r10).onNestedScroll(r11, r12, r13, r14, r15, r16);
        return;
    L8:
        if (r16 != 0) goto L18;
        a.d(r10, r11, r12, r13, r14, r15);     // Catch: AbstractMethodError -> L11
        return;
    L11:
        e = move-exception;
        Log.e("ViewParentCompat", "ViewParent " + r10 + " does not implement interface method onNestedScroll", e);
        return;
    }

    public static void e(ViewParent r10, View r11, View r12, int r13, int r14) {
        if ((r10 instanceof NestedScrollingParent2) == false) goto L5;
        ((NestedScrollingParent2) r10).onNestedScrollAccepted(r11, r12, r13, r14);
        return;
    L5:
        if (r14 != 0) goto L14;
        a.e(r10, r11, r12, r13);     // Catch: AbstractMethodError -> L8
        return;
    L8:
        e = move-exception;
        Log.e("ViewParentCompat", "ViewParent " + r10 + " does not implement interface method onNestedScrollAccepted", e);
        return;
    }

    public static boolean f(ViewParent r10, View r11, View r12, int r13, int r14) {
        if ((r10 instanceof NestedScrollingParent2) == true) goto L5;
        if (r14 != 0) goto L15;
        return a.f(r10, r11, r12, r13);
    L9:
        e = move-exception;
        Log.e("ViewParentCompat", "ViewParent " + r10 + " does not implement interface method onStartNestedScroll", e);
        return false;
    L15:
        return false;
    L5:
        return ((NestedScrollingParent2) r10).onStartNestedScroll(r11, r12, r13, r14);
    }

    public static void g(ViewParent r10, View r11, int r12) {
        if ((r10 instanceof NestedScrollingParent2) == false) goto L5;
        ((NestedScrollingParent2) r10).onStopNestedScroll(r11, r12);
        return;
    L5:
        if (r12 != 0) goto L14;
        a.g(r10, r11);     // Catch: AbstractMethodError -> L8
        return;
    L8:
        e = move-exception;
        Log.e("ViewParentCompat", "ViewParent " + r10 + " does not implement interface method onStopNestedScroll", e);
        return;
    }
}

package androidx.core.view;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;

/* loaded from: classes.dex */
public final class P {

    static class a {
        static boolean a(ViewParent viewParent, View view, float f5, float f6, boolean z5) {
            return viewParent.onNestedFling(view, f5, f6, z5);
        }

        static boolean b(ViewParent viewParent, View view, float f5, float f6) {
            return viewParent.onNestedPreFling(view, f5, f6);
        }

        static void c(ViewParent viewParent, View view, int i5, int i6, int[] iArr) {
            viewParent.onNestedPreScroll(view, i5, i6, iArr);
        }

        static void d(ViewParent viewParent, View view, int i5, int i6, int i7, int i8) {
            viewParent.onNestedScroll(view, i5, i6, i7, i8);
        }

        static void e(ViewParent viewParent, View view, View view2, int i5) {
            viewParent.onNestedScrollAccepted(view, view2, i5);
        }

        static boolean f(ViewParent viewParent, View view, View view2, int i5) {
            return viewParent.onStartNestedScroll(view, view2, i5);
        }

        static void g(ViewParent viewParent, View view) {
            viewParent.onStopNestedScroll(view);
        }
    }

    public static boolean a(ViewParent viewParent, View view, float f5, float f6, boolean z5) {
        try {
            return a.a(viewParent, view, f5, f6, z5);
        } catch (AbstractMethodError e6) {
            Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedFling", e6);
            return false;
        }
    }

    public static boolean b(ViewParent viewParent, View view, float f5, float f6) {
        try {
            return a.b(viewParent, view, f5, f6);
        } catch (AbstractMethodError e6) {
            Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreFling", e6);
            return false;
        }
    }

    public static void c(ViewParent viewParent, View view, int i5, int i6, int[] iArr, int i7) {
        if (viewParent instanceof InterfaceC0476v) {
            ((InterfaceC0476v) viewParent).o(view, i5, i6, iArr, i7);
            return;
        }
        if (i7 == 0) {
            try {
                a.c(viewParent, view, i5, i6, iArr);
            } catch (AbstractMethodError e6) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreScroll", e6);
            }
        }
    }

    public static void d(ViewParent viewParent, View view, int i5, int i6, int i7, int i8, int i9, int[] iArr) {
        if (viewParent instanceof InterfaceC0477w) {
            ((InterfaceC0477w) viewParent).j(view, i5, i6, i7, i8, i9, iArr);
            return;
        }
        iArr[0] = iArr[0] + i7;
        iArr[1] = iArr[1] + i8;
        if (viewParent instanceof InterfaceC0476v) {
            ((InterfaceC0476v) viewParent).k(view, i5, i6, i7, i8, i9);
            return;
        }
        if (i9 == 0) {
            try {
                a.d(viewParent, view, i5, i6, i7, i8);
            } catch (AbstractMethodError e6) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScroll", e6);
            }
        }
    }

    public static void e(ViewParent viewParent, View view, View view2, int i5, int i6) {
        if (viewParent instanceof InterfaceC0476v) {
            ((InterfaceC0476v) viewParent).m(view, view2, i5, i6);
            return;
        }
        if (i6 == 0) {
            try {
                a.e(viewParent, view, view2, i5);
            } catch (AbstractMethodError e6) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScrollAccepted", e6);
            }
        }
    }

    public static boolean f(ViewParent viewParent, View view, View view2, int i5, int i6) {
        if (viewParent instanceof InterfaceC0476v) {
            return ((InterfaceC0476v) viewParent).l(view, view2, i5, i6);
        }
        if (i6 != 0) {
            return false;
        }
        try {
            return a.f(viewParent, view, view2, i5);
        } catch (AbstractMethodError e6) {
            Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStartNestedScroll", e6);
            return false;
        }
    }

    public static void g(ViewParent viewParent, View view, int i5) {
        if (viewParent instanceof InterfaceC0476v) {
            ((InterfaceC0476v) viewParent).n(view, i5);
            return;
        }
        if (i5 == 0) {
            try {
                a.g(viewParent, view);
            } catch (AbstractMethodError e6) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStopNestedScroll", e6);
            }
        }
    }
}

package androidx.core.view;

import android.os.Build;
import android.view.ViewGroup;

/* JADX INFO: compiled from: MarginLayoutParamsCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: compiled from: MarginLayoutParamsCompat.java */
    static class a {
        static int a(ViewGroup.MarginLayoutParams r0) {
            return r0.getMarginStart();
        }

        static int b(ViewGroup.MarginLayoutParams r0) {
            return r0.getMarginEnd();
        }

        static void a(ViewGroup.MarginLayoutParams r0, int r1) {
            r0.setMarginStart(r1);
        }

        static void b(ViewGroup.MarginLayoutParams r0, int r1) {
            r0.setMarginEnd(r1);
        }

        static boolean c(ViewGroup.MarginLayoutParams r0) {
            return r0.isMarginRelative();
        }

        static int d(ViewGroup.MarginLayoutParams r0) {
            return r0.getLayoutDirection();
        }

        static void c(ViewGroup.MarginLayoutParams r0, int r1) {
            r0.setLayoutDirection(r1);
        }

        static void d(ViewGroup.MarginLayoutParams r0, int r1) {
            r0.resolveLayoutDirection(r1);
        }
    }

    public static int a(ViewGroup.MarginLayoutParams r2) {
        if (Build.VERSION.SDK_INT < 17) goto L7;
        return a.a(r2);
    L7:
        return r2.leftMargin;
    }

    public static int b(ViewGroup.MarginLayoutParams r2) {
        if (Build.VERSION.SDK_INT < 17) goto L7;
        return a.b(r2);
    L7:
        return r2.rightMargin;
    }

    public static void a(ViewGroup.MarginLayoutParams r2, int r3) {
        if (Build.VERSION.SDK_INT < 17) goto L5;
        a.a(r2, r3);
        return;
    L5:
        r2.leftMargin = r3;
    }

    public static void b(ViewGroup.MarginLayoutParams r2, int r3) {
        if (Build.VERSION.SDK_INT < 17) goto L5;
        a.b(r2, r3);
        return;
    L5:
        r2.rightMargin = r3;
    }
}

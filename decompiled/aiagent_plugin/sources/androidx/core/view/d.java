package androidx.core.view;

import android.graphics.Rect;
import android.os.Build;
import android.view.Gravity;

/* JADX INFO: compiled from: GravityCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: compiled from: GravityCompat.java */
    static class a {
        static void a(int r0, int r1, int r2, Rect r3, Rect r4, int r5) {
            Gravity.apply(r0, r1, r2, r3, r4, r5);
        }

        static void a(int r0, int r1, int r2, Rect r3, int r4, int r5, Rect r6, int r7) {
            Gravity.apply(r0, r1, r2, r3, r4, r5, r6, r7);
        }

        static void a(int r0, Rect r1, Rect r2, int r3) {
            Gravity.applyDisplay(r0, r1, r2, r3);
        }
    }

    public static void a(int r2, int r3, int r4, Rect r5, Rect r6, int r7) {
        if (Build.VERSION.SDK_INT < 17) goto L5;
        a.a(r2, r3, r4, r5, r6, r7);
        return;
    L5:
        Gravity.apply(r2, r3, r4, r5, r6);
    }

    public static int a(int r2, int r3) {
        if (Build.VERSION.SDK_INT < 17) goto L7;
        return Gravity.getAbsoluteGravity(r2, r3);
    L7:
        return r2 & (-8388609);
    }
}

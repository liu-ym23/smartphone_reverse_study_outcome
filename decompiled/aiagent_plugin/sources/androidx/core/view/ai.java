package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.Window;

/* JADX INFO: compiled from: WindowCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class ai {

    /* JADX INFO: compiled from: WindowCompat.java */
    static class a {
        static void a(Window r1, boolean r2) {
            View r3 = r1.getDecorView();
            int r0 = r3.getSystemUiVisibility();
            if (r2 == false) goto L5;
            int r4 = r0 & (-1793);
        L6:
            r3.setSystemUiVisibility(r4);
            return;
        L5:
            r4 = r0 | 1792;
            goto L6
        }
    }

    /* JADX INFO: compiled from: WindowCompat.java */
    static class b {
        static void a(Window r0, boolean r1) {
            r0.setDecorFitsSystemWindows(r1);
        }
    }

    public static void a(Window r2, boolean r3) {
        if (Build.VERSION.SDK_INT < 30) goto L6;
        b.a(r2, r3);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 16) goto L10;
        a.a(r2, r3);
        return;
    }

    public static am a(Window r1, View r2) {
        return new am(r1, r2);
    }
}

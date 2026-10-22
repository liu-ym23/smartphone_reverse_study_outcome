package androidx.core.view.accessibility;

import android.os.Build;
import android.view.accessibility.AccessibilityEvent;

/* JADX INFO: compiled from: AccessibilityEventCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: androidx.core.view.accessibility.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AccessibilityEventCompat.java */
    static class C0036a {
        static void a(AccessibilityEvent r0, int r1) {
            r0.setContentChangeTypes(r1);
        }

        static int a(AccessibilityEvent r0) {
            return r0.getContentChangeTypes();
        }
    }

    public static void a(AccessibilityEvent r2, int r3) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        C0036a.a(r2, r3);
        return;
    }

    public static int a(AccessibilityEvent r2) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return 0;
    L5:
        return C0036a.a(r2);
    }
}

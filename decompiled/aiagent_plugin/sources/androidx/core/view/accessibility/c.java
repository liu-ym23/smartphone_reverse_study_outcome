package androidx.core.view.accessibility;

import android.os.Build;
import android.view.View;
import android.view.accessibility.AccessibilityRecord;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AccessibilityRecordCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AccessibilityRecord f1446a;

    /* JADX INFO: compiled from: AccessibilityRecordCompat.java */
    static class a {
        static int a(AccessibilityRecord r0) {
            return r0.getMaxScrollX();
        }

        static void a(AccessibilityRecord r0, int r1) {
            r0.setMaxScrollX(r1);
        }

        static int b(AccessibilityRecord r0) {
            return r0.getMaxScrollY();
        }

        static void b(AccessibilityRecord r0, int r1) {
            r0.setMaxScrollY(r1);
        }
    }

    /* JADX INFO: compiled from: AccessibilityRecordCompat.java */
    static class b {
        static void a(AccessibilityRecord r0, View r1, int r2) {
            r0.setSource(r1, r2);
        }
    }

    public static void a(AccessibilityRecord r2, View r3, int r4) {
        if (Build.VERSION.SDK_INT < 16) goto L6;
        b.a(r2, r3, r4);
        return;
    }

    public static void a(AccessibilityRecord r2, int r3) {
        if (Build.VERSION.SDK_INT < 15) goto L6;
        a.a(r2, r3);
        return;
    }

    public static void b(AccessibilityRecord r2, int r3) {
        if (Build.VERSION.SDK_INT < 15) goto L6;
        a.b(r2, r3);
        return;
    }

    @Deprecated
    public int hashCode() {
        AccessibilityRecord r0 = this.f1446a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    @Deprecated
    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
        AccessibilityRecord r4 = this.f1446a;
        if (r4 != null) goto L16;
        if (r6.f1446a != null) goto L14;
        return true;
    L14:
        return false;
    L16:
        return r4.equals(r6.f1446a);
    }
}

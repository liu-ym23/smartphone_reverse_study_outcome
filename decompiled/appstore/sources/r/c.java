package r;

import android.view.View;
import android.view.accessibility.AccessibilityRecord;
import androidx.annotation.DoNotInline;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    public static class a {
        @DoNotInline
        public static int a(AccessibilityRecord r10) {
            return r10.getMaxScrollX();
        }

        @DoNotInline
        public static int b(AccessibilityRecord r10) {
            return r10.getMaxScrollY();
        }

        @DoNotInline
        public static void c(AccessibilityRecord r10, int r11) {
            r10.setMaxScrollX(r11);
        }

        @DoNotInline
        public static void d(AccessibilityRecord r10, int r11) {
            r10.setMaxScrollY(r11);
        }
    }

    public static class b {
        @DoNotInline
        public static void a(AccessibilityRecord r10, View r11, int r12) {
            r10.setSource(r11, r12);
        }
    }

    public static void a(AccessibilityRecord r10, int r11) {
        a.c(r10, r11);
    }

    public static void b(AccessibilityRecord r10, int r11) {
        a.d(r10, r11);
    }

    public static void c(AccessibilityRecord r10, View r11, int r12) {
        b.a(r10, r11, r12);
    }
}

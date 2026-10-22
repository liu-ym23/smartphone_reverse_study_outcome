package androidx.core.view;

import android.graphics.Rect;
import android.view.Gravity;
import androidx.annotation.DoNotInline;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    public static class a {
        @DoNotInline
        public static void a(int r10, int r11, int r12, Rect r13, int r14, int r15, Rect r16, int r17) {
            Gravity.apply(r10, r11, r12, r13, r14, r15, r16, r17);
        }

        @DoNotInline
        public static void b(int r10, int r11, int r12, Rect r13, Rect r14, int r15) {
            Gravity.apply(r10, r11, r12, r13, r14, r15);
        }

        @DoNotInline
        public static void c(int r10, Rect r11, Rect r12, int r13) {
            Gravity.applyDisplay(r10, r11, r12, r13);
        }
    }

    public static void a(int r10, int r11, int r12, Rect r13, Rect r14, int r15) {
        a.b(r10, r11, r12, r13, r14, r15);
    }

    public static int b(int r10, int r11) {
        return Gravity.getAbsoluteGravity(r10, r11);
    }
}

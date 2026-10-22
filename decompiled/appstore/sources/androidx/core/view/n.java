package androidx.core.view;

import android.content.Context;
import android.view.ViewConfiguration;
import androidx.annotation.DoNotInline;

/* JADX INFO: loaded from: classes.dex */
public abstract class n {

    public static class a {
        @DoNotInline
        public static float a(ViewConfiguration r10) {
            return r10.getScaledHorizontalScrollFactor();
        }

        @DoNotInline
        public static float b(ViewConfiguration r10) {
            return r10.getScaledVerticalScrollFactor();
        }
    }

    public static class b {
        @DoNotInline
        public static int a(ViewConfiguration r10) {
            return r10.getScaledHoverSlop();
        }

        @DoNotInline
        public static boolean b(ViewConfiguration r10) {
            return r10.shouldShowMenuShortcutsWhenKeyboardPresent();
        }
    }

    static {
    }

    public static float a(ViewConfiguration r10, Context r11) {
        return a.a(r10);
    }

    public static float b(ViewConfiguration r10, Context r11) {
        return a.b(r10);
    }

    public static boolean c(ViewConfiguration r10, Context r11) {
        return b.b(r10);
    }
}

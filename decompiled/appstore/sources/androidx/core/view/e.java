package androidx.core.view;

import android.view.ViewGroup;
import androidx.annotation.DoNotInline;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    public static class a {
        @DoNotInline
        public static int a(ViewGroup.MarginLayoutParams r10) {
            return r10.getLayoutDirection();
        }

        @DoNotInline
        public static int b(ViewGroup.MarginLayoutParams r10) {
            return r10.getMarginEnd();
        }

        @DoNotInline
        public static int c(ViewGroup.MarginLayoutParams r10) {
            return r10.getMarginStart();
        }

        @DoNotInline
        public static boolean d(ViewGroup.MarginLayoutParams r10) {
            return r10.isMarginRelative();
        }

        @DoNotInline
        public static void e(ViewGroup.MarginLayoutParams r10, int r11) {
            r10.resolveLayoutDirection(r11);
        }

        @DoNotInline
        public static void f(ViewGroup.MarginLayoutParams r10, int r11) {
            r10.setLayoutDirection(r11);
        }

        @DoNotInline
        public static void g(ViewGroup.MarginLayoutParams r10, int r11) {
            r10.setMarginEnd(r11);
        }

        @DoNotInline
        public static void h(ViewGroup.MarginLayoutParams r10, int r11) {
            r10.setMarginStart(r11);
        }
    }

    public static int a(ViewGroup.MarginLayoutParams r10) {
        return a.b(r10);
    }

    public static int b(ViewGroup.MarginLayoutParams r10) {
        return a.c(r10);
    }

    public static void c(ViewGroup.MarginLayoutParams r10, int r11) {
        a.g(r10, r11);
    }

    public static void d(ViewGroup.MarginLayoutParams r10, int r11) {
        a.h(r10, r11);
    }
}

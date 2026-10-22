package androidx.core.widget;

import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.DoNotInline;

/* JADX INFO: loaded from: classes.dex */
public abstract class j {

    public static class a {
        @DoNotInline
        public static void a(PopupWindow r10, View r11, int r12, int r13, int r14) {
            r10.showAsDropDown(r11, r12, r13, r14);
        }
    }

    public static class b {
        @DoNotInline
        public static boolean a(PopupWindow r10) {
            return r10.getOverlapAnchor();
        }

        @DoNotInline
        public static int b(PopupWindow r10) {
            return r10.getWindowLayoutType();
        }

        @DoNotInline
        public static void c(PopupWindow r10, boolean r11) {
            r10.setOverlapAnchor(r11);
        }

        @DoNotInline
        public static void d(PopupWindow r10, int r11) {
            r10.setWindowLayoutType(r11);
        }
    }

    public static void a(PopupWindow r10, boolean r11) {
        b.c(r10, r11);
    }

    public static void b(PopupWindow r10, int r11) {
        b.d(r10, r11);
    }

    public static void c(PopupWindow r10, View r11, int r12, int r13, int r14) {
        a.a(r10, r11, r12, r13, r14);
    }
}

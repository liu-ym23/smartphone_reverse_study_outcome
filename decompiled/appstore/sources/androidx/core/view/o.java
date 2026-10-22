package androidx.core.view;

import android.view.ViewGroup;
import androidx.annotation.DoNotInline;

/* JADX INFO: loaded from: classes.dex */
public abstract class o {

    public static class a {
        @DoNotInline
        public static int a(ViewGroup r10) {
            return r10.getNestedScrollAxes();
        }

        @DoNotInline
        public static boolean b(ViewGroup r10) {
            return r10.isTransitionGroup();
        }

        @DoNotInline
        public static void c(ViewGroup r10, boolean r11) {
            r10.setTransitionGroup(r11);
        }
    }

    public static boolean a(ViewGroup r10) {
        return a.b(r10);
    }
}

package androidx.core.widget;

import android.widget.ListView;
import androidx.annotation.DoNotInline;

/* JADX INFO: loaded from: classes.dex */
public abstract class i {

    public static class a {
        @DoNotInline
        public static boolean a(ListView r10, int r11) {
            return r10.canScrollList(r11);
        }

        @DoNotInline
        public static void b(ListView r10, int r11) {
            r10.scrollListBy(r11);
        }
    }

    public static boolean a(ListView r10, int r11) {
        return a.a(r10, r11);
    }

    public static void b(ListView r10, int r11) {
        a.b(r10, r11);
    }
}

package androidx.core.util;

import androidx.annotation.DoNotInline;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    public static class a {
        @DoNotInline
        public static boolean a(Object r10, Object r11) {
            return Objects.equals(r10, r11);
        }

        @DoNotInline
        public static int b(Object... r10) {
            return Objects.hash(r10);
        }
    }

    public static boolean a(Object r10, Object r11) {
        return a.a(r10, r11);
    }

    public static int b(Object... r10) {
        return a.b(r10);
    }

    public static Object c(Object r10, String r11) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        throw new NullPointerException(r11);
    }

    public static String d(Object r10, String r11) {
        if (r10 != null) goto L4;
        return r11;
    L4:
        return r10.toString();
    }
}

package androidx.core.util;

import android.os.Build;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: ObjectsCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: compiled from: ObjectsCompat.java */
    static class a {
        static boolean a(Object r0, Object r1) {
            return Objects.equals(r0, r1);
        }

        static int a(Object... r0) {
            return Objects.hash(r0);
        }
    }

    public static boolean a(Object r2, Object r3) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        if (r2 == r3) goto L12;
        if (r2 != null) goto L9;
    L11:
        return false;
    L9:
        if (r2.equals(r3) == false) goto L11;
    L12:
        return true;
    L5:
        return a.a(r2, r3);
    }

    public static int a(Object... r2) {
        if (Build.VERSION.SDK_INT < 19) goto L7;
        return a.a(r2);
    L7:
        return Arrays.hashCode(r2);
    }

    public static <T> T a(T r0) {
        Objects.requireNonNull(r0);
        return r0;
    }

    public static <T> T a(T r0, String r1) {
        Objects.requireNonNull(r0, r1);
        return r0;
    }
}

package androidx.core.util;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class ObjectsCompat {
    private ObjectsCompat() {
    }

    public static int hash(Object... r100) {
        return Objects.hash(r100);
    }

    public static int hashCode(Object r100) {
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public static <T> T requireNonNull(T r100) {
        if (r100 == null) goto L5;
        return r100;
    L5:
        throw null;
    }

    public static boolean equals(Object r100, Object r101) {
        return Objects.equals(r100, r101);
    }

    public static <T> T requireNonNull(T r100, String r101) {
        if (r100 == null) goto L5;
        return r100;
    L5:
        throw new NullPointerException(r101);
    }

    public static String toString(Object r100, String r101) {
        if (r100 != null) goto L4;
        return r101;
    L4:
        return r100.toString();
    }
}

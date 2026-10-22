package androidx.core.util;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class ObjectsCompat {

    static class Api19Impl {
        private Api19Impl() {
        }

        static boolean equals(Object r0, Object r1) {
            return Objects.equals(r0, r1);
        }

        static int hash(Object... r0) {
            return Objects.hash(r0);
        }
    }

    private ObjectsCompat() {
    }

    public static boolean equals(Object r0, Object r1) {
        return Api19Impl.equals(r0, r1);
    }

    public static int hashCode(Object r0) {
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public static int hash(Object... r0) {
        return Api19Impl.hash(r0);
    }

    public static String toString(Object r0, String r1) {
        if (r0 != null) goto L4;
        return r1;
    L4:
        return r0.toString();
    }

    public static <T> T requireNonNull(T r0) {
        r0.getClass();
        return r0;
    }

    public static <T> T requireNonNull(T r0, String r1) {
        if (r0 == null) goto L5;
        return r0;
    L5:
        throw new NullPointerException(r1);
    }
}

package org.tensorflow.lite.support.a.a;

/* JADX INFO: compiled from: SupportPreconditions.java */
/* JADX INFO: loaded from: classes5.dex */
public final class a {
    public static <T> T a(T r0, Object r1) {
        if (r0 == null) goto L5;
        return r0;
    L5:
        throw new NullPointerException(String.valueOf(r1));
    }

    public static void a(boolean r0) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException();
    }

    public static void a(boolean r0, Object r1) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(String.valueOf(r1));
    }
}

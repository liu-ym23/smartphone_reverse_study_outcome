package com.bytedance.platform.godzilla.utils;

/* JADX INFO: loaded from: classes2.dex */
public final class Preconditions {
    private Preconditions() {
    }

    public static void checkArgument(boolean r0, String r1) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(r1);
    }

    public static void checkArgument(boolean r0, String r1, Object... r2) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(String.format(r1, r2));
    }

    public static <T> T checkNotNull(T r0, String r1) {
        if (r0 == null) goto L5;
        return r0;
    L5:
        throw new IllegalArgumentException(r1);
    }

    public static <T> T checkNotNull(T r0, String r1, Object... r2) {
        if (r0 == null) goto L5;
        return r0;
    L5:
        throw new IllegalArgumentException(String.format(r1, r2));
    }

    public static int checkElementIndex(int r0, int r1, String r2) {
        if (r0 < 0) goto L6;
        if (r0 >= r1) goto L6;
        return r0;
    L6:
        throw new IndexOutOfBoundsException(r2);
    }

    public static int checkElementIndex(int r0, int r1, String r2, Object... r3) {
        if (r0 < 0) goto L6;
        if (r0 >= r1) goto L6;
        return r0;
    L6:
        throw new IndexOutOfBoundsException(String.format(r2, r3));
    }

    public static void checkTrue(boolean r0, String r1) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(r1);
    }

    public static void checkTrue(boolean r0, String r1, Object... r2) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(String.format(r1, r2));
    }
}

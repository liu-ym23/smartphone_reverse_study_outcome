package com.danikula.videocache;

/* JADX INFO: loaded from: classes2.dex */
public final class Preconditions {
    public Preconditions() {
    }

    public static void checkAllNotNull(Object... r10) {
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        if (r10[r12] == null) goto L8;
        r12 = r12 + 1;
        goto L3
    L8:
        throw null;
    }

    public static void checkArgument(boolean r10) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException();
    }

    public static <T> T checkNotNull(T r10) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        throw null;
    }

    public static void checkArgument(boolean r10, String r11) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(r11);
    }

    public static <T> T checkNotNull(T r10, String r11) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        throw new NullPointerException(r11);
    }
}

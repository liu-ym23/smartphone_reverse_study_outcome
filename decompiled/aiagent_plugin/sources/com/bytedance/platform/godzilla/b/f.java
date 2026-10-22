package com.bytedance.platform.godzilla.b;

/* JADX INFO: compiled from: Preconditions.java */
/* JADX INFO: loaded from: classes.dex */
public final class f {
    public static <T> T a(T r0, String r1) {
        if (r0 == null) goto L5;
        return r0;
    L5:
        throw new IllegalArgumentException(r1);
    }

    public static void a(boolean r0, String r1) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(r1);
    }
}

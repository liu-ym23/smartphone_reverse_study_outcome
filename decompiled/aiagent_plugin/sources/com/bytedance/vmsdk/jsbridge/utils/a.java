package com.bytedance.vmsdk.jsbridge.utils;

/* JADX INFO: compiled from: Assertions.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public static <T> T a(T r0) {
        if (r0 == null) goto L5;
        return r0;
    L5:
        throw new AssertionError();
    }

    public static void a(boolean r0, String r1) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new AssertionError(r1);
    }
}

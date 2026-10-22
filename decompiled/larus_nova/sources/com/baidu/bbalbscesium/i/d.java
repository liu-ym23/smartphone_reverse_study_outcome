package com.baidu.bbalbscesium.i;

import java.util.Arrays;

/* JADX INFO: loaded from: classes39.dex */
class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f30144a = false;

    public d() {
    }

    public static void a(byte[] r100, byte[] r101, int r102) {
        if (r102 < 0) goto L24;
        if (r100 == null) goto L22;
        if (r100.length == 0) goto L22;
        if (r101 == null) goto L20;
        if (r101.length == 0) goto L20;
        if (r100.length < r101.length) goto L18;
        if (r100.length < (r101.length + r102)) goto L16;
        System.arraycopy(r101, 0, r100, r102, r101.length);
        return;
    L16:
        throw new IllegalArgumentException("start should be less than:" + (r100.length - r101.length));
    L18:
        throw new IllegalArgumentException("dst array length should be longer than:" + r101.length);
    L20:
        throw new IllegalArgumentException("src array should not be null or empty");
    L22:
        throw new IllegalArgumentException("dst array should not be null or empty");
    L24:
        throw new IllegalArgumentException("start should be more than zero!");
    }

    public static byte[] a(byte[] r100, int r101) {
        if (r100 == null) goto L11;
        if (r100.length == 0) goto L11;
        if (r101 < 0) goto L9;
        return Arrays.copyOf(r100, r101);
    L9:
        throw new IllegalArgumentException("length should be more than zero!");
    L11:
        throw new IllegalArgumentException("original array should not be null or empty");
    }
}

package com.bytedance.vmsdk.a.a.b;

/* JADX INFO: compiled from: MaskingHelper.java */
/* JADX INFO: loaded from: classes.dex */
class c {
    public static void a(byte[] r5, byte[] r6, int r7, int r8) {
        int r0 = 0;
    L3:
        int r1 = r8 - 1;
        if (r8 <= 0) goto L6;
        r6[r7] = (byte) (r5[r0 % r5.length] ^ r6[r7]);
        r7 = r7 + 1;
        r8 = r1;
        r0 = r0 + 1;
        goto L3
    }
}

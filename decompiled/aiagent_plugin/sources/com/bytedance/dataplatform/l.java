package com.bytedance.dataplatform;

/* JADX INFO: compiled from: MurmurHash3.java */
/* JADX INFO: loaded from: classes.dex */
public final class l {
    private static int a(int r1) {
        int r2 = (r1 ^ (r1 >>> 16)) * (-2048144789);
        int r3 = (r2 ^ (r2 >>> 13)) * (-1028477387);
        return r3 ^ (r3 >>> 16);
    }

    public static int a(byte[] r2) {
        if (r2 != null) goto L6;
        return 0;
    L6:
        return a(r2, 0, r2.length, 0);
    }

    public static int a(byte[] r4, int r5, int r6, int r7) {
        int r0 = r6 >> 2;
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r7 = a(a(r4, (r2 << 2) + r5), r7);
        r2 = r2 + 1;
        goto L3
    L5:
        int r3 = (r0 << 2) + r5;
        int r8 = (r5 + r6) - r3;
        if (r8 == 1) goto L13;
        if (r8 != 2) goto L9;
    L12:
        r1 = r1 ^ ((r4[r3 + 1] & 255) << 8);
        goto L13
    L9:
        if (r8 != 3) goto L15;
        r1 = 0 ^ ((r4[r3 + 2] & 255) << 16);
    L15:
        return a(r7 ^ r6);
    L13:
        r7 = r7 ^ (Integer.rotateLeft(((r4[r3] & 255) ^ r1) * (-862048943), 15) * 461845907);
        goto L15
    }

    private static int a(byte[] r2, int r3) {
        int r0 = ((r2[r3] & 255) | ((r2[r3 + 1] & 255) << 8)) | ((r2[r3 + 2] & 255) << 16);
        return ((r2[r3 + 3] & 255) << 24) | r0;
    }

    private static int a(int r1, int r2) {
        return (Integer.rotateLeft((Integer.rotateLeft(r1 * (-862048943), 15) * 461845907) ^ r2, 13) * 5) - 430675100;
    }

    public static byte[] a(String r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return r1.getBytes(d.o.d.f38623b);
    }
}

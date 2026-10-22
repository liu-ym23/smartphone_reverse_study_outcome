package com.bytedance.vmsdk.a.a.b;

/* JADX INFO: compiled from: FrameHelper.java */
/* JADX INFO: loaded from: classes.dex */
class b {
    public static a a(String r1) {
        return a((byte) 1, h.a(r1));
    }

    public static a a(int r4, String r5) {
        if (r5 == null) goto L5;
        byte[] r6 = h.a(r5);
        int r1 = r6.length + 2;
    L6:
        byte[] r2 = new byte[r1];
        r2[0] = (byte) ((r4 >> 8) & 255);
        r2[1] = (byte) (r4 & 255);
        if (r6 == null) goto L10;
        System.arraycopy(r6, 0, r2, 2, r6.length);
    L10:
        return a((byte) 8, r2);
    L5:
        r6 = null;
        r1 = 2;
        goto L6
    }

    public static a a(byte[] r1, int r2) {
        return a((byte) 10, r1, r2);
    }

    private static a a(byte r1, byte[] r2) {
        return a(r1, r2, r2.length);
    }

    private static a a(byte r3, byte[] r4, int r5) {
        a r0 = new a();
        r0.f11697a = true;
        r0.f = false;
        r0.f11701e = r3;
        r0.g = r5;
        r0.i = r4;
        return r0;
    }
}

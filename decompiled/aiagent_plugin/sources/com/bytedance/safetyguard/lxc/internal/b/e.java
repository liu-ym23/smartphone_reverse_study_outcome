package com.bytedance.safetyguard.lxc.internal.b;

import java.util.Arrays;

/* JADX INFO: compiled from: IpAddressClassifier.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e {
    public static final /* synthetic */ f a(int r0, int r1, int r2, int r3, int r4) {
        return b(r0, r1, r2, r3, r4);
    }

    public static final /* synthetic */ f a(int r0, int... r1) {
        return b(r0, r1);
    }

    public static final /* synthetic */ byte[] a(int r0, int r1, int r2, int r3) {
        return b(r0, r1, r2, r3);
    }

    public static final /* synthetic */ byte[] a(int... r0) {
        return b(r0);
    }

    private static final byte[] b(int r2, int r3, int r4, int r5) {
        return new byte[]{(byte) r2, (byte) r3, (byte) r4, (byte) r5};
    }

    private static final f b(int r1, int r2, int r3, int r4, int r5) {
        return new f(b(r1, r2, r3, r4), r5);
    }

    private static final f b(int r2, int... r3) {
        return new f(b(Arrays.copyOf(r3, r3.length)), r2);
    }

    private static final byte[] b(int... r10) {
        if (r10.length > 8) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L22;
        byte[] r1 = new byte[16];
        int r4 = r10.length;
        int r5 = 0;
        int r6 = 0;
    L9:
        if (r5 >= r4) goto L20;
        int r7 = r10[r5];
        int r8 = r6 + 1;
        if (r7 >= 0) goto L13;
    L15:
        boolean r9 = false;
    L16:
        if (r9 == false) goto L19;
        int r11 = r6 * 2;
        r1[r11] = (byte) (r7 >>> 8);
        r1[r11 + 1] = (byte) r7;
        r5 = r5 + 1;
        r6 = r8;
        goto L9
    L19:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L13:
        if (r7 >= 65536) goto L15;
        r9 = true;
        goto L16
    L20:
        return r1;
    L22:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r0 = false;
        goto L7
    }
}

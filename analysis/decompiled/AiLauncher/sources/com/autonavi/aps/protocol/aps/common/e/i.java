package com.autonavi.aps.protocol.aps.common.e;

/* loaded from: classes.dex */
public class i {
    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr.length == 0) {
            return bArr;
        }
        int[] iArrA = a(a(bArr, true), a(bArr2, true));
        int length = iArrA.length << 2;
        byte[] bArr3 = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            bArr3[i10] = (byte) ((iArrA[i10 >>> 2] >>> ((i10 & 3) << 3)) & 255);
        }
        for (int i11 = length - 1; i11 > 0; i11--) {
            int i12 = bArr3[i11];
            if (i12 > 0) {
                int i13 = (i11 - i12) + 1;
                byte[] bArr4 = new byte[i13];
                System.arraycopy(bArr3, 0, bArr4, 0, i13);
                return bArr4;
            }
        }
        return bArr3;
    }

    public static int[] a(int[] iArr, int[] iArr2) {
        int length = iArr.length;
        int i10 = length - 1;
        if (i10 >= 1) {
            if (iArr2.length < 4) {
                int[] iArr3 = new int[4];
                System.arraycopy(iArr2, 0, iArr3, 0, iArr2.length);
                iArr2 = iArr3;
            }
            int i11 = iArr[i10];
            int i12 = iArr[0];
            for (int i13 = ((52 / length) + 6) * (-1640531527); i13 != 0; i13 -= -1640531527) {
                int i14 = (i13 >>> 2) & 3;
                int i15 = i10;
                while (i15 > 0) {
                    int i16 = iArr[i15 - 1];
                    i12 = iArr[i15] - (((i12 ^ i13) + (i16 ^ iArr2[(i15 & 3) ^ i14])) ^ (((i16 >>> 5) ^ (i12 << 2)) + ((i12 >>> 3) ^ (i16 << 4))));
                    iArr[i15] = i12;
                    i15--;
                }
                int i17 = iArr[i10];
                i12 = iArr[0] - (((i12 ^ i13) + (iArr2[i14 ^ (i15 & 3)] ^ i17)) ^ (((i17 >>> 5) ^ (i12 << 2)) + ((i12 >>> 3) ^ (i17 << 4))));
                iArr[0] = i12;
            }
        }
        return iArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0029 A[LOOP:0: B:11:0x0027->B:12:0x0029, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0031 A[LOOP:1: B:14:0x002f->B:15:0x0031, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int[] a(byte[] r7, boolean r8) {
        /*
            int r0 = r7.length
            int r0 = r0 % 4
            int r0 = 4 - r0
            if (r8 == 0) goto L16
            int r8 = r7.length
            r8 = r8 & 3
            if (r8 != 0) goto L10
            int r8 = r7.length
            int r8 = r8 >>> 2
            goto L1a
        L10:
            int r8 = r7.length
            int r8 = r8 >>> 2
        L13:
            int r8 = r8 + 1
            goto L1a
        L16:
            int r8 = r7.length
            int r8 = r8 / 4
            goto L13
        L1a:
            int r1 = r0 << 24
            int r2 = r0 << 16
            int r1 = r1 + r2
            int r2 = r0 << 8
            int r1 = r1 + r2
            int r1 = r1 + r0
            int[] r0 = new int[r8]
            r2 = 0
            r3 = r2
        L27:
            if (r3 >= r8) goto L2e
            r0[r3] = r1
            int r3 = r3 + 1
            goto L27
        L2e:
            int r8 = r7.length
        L2f:
            if (r2 >= r8) goto L4c
            int r1 = r2 >>> 2
            r3 = r0[r1]
            r4 = r2 & 3
            int r4 = r4 << 3
            r5 = 255(0xff, float:3.57E-43)
            int r6 = r5 << r4
            int r6 = ~r6
            r3 = r3 & r6
            r0[r1] = r3
            r6 = r7[r2]
            r5 = r5 & r6
            int r4 = r5 << r4
            r3 = r3 | r4
            r0[r1] = r3
            int r2 = r2 + 1
            goto L2f
        L4c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.protocol.aps.common.e.i.a(byte[], boolean):int[]");
    }
}

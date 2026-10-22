package com.google.zxing.pdf417.decoder;

import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.pdf417.PDF417Common;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes3.dex */
final class PDF417CodewordDecoder {
    private static final float[][] RATIOS_TABLE = null;

    static {
        RATIOS_TABLE = (float[][]) Array.newInstance(Float.TYPE, new int[]{PDF417Common.SYMBOL_TABLE.length, 8});
        int r0 = 0;
    L4:
        if (r0 >= PDF417Common.SYMBOL_TABLE.length) goto L13;
        int r1 = PDF417Common.SYMBOL_TABLE[r0];
        int r5 = r1 & 1;
        int r6 = 0;
    L6:
        if (r6 >= 8) goto L12;
        float r7 = 0.0f;
    L8:
        int r8 = r1 & 1;
        if (r8 != r5) goto L11;
        r7 = r7 + 1.0f;
        r1 = r1 >> 1;
        goto L8
    L11:
        RATIOS_TABLE[r0][(8 - r6) - 1] = r7 / 17.0f;
        r6 = r6 + 1;
        r5 = r8;
        goto L6
    L12:
        r0 = r0 + 1;
        goto L4
    }

    private PDF417CodewordDecoder() {
    }

    static int getDecodedValue(int[] r2) {
        int r0 = getDecodedCodewordValue(sampleBitCounts(r2));
        if (r0 == (-1)) goto L6;
        return r0;
    L6:
        return getClosestDecodedValue(r2);
    }

    private static int[] sampleBitCounts(int[] r8) {
        float r0 = MathUtils.sum(r8);
        int[] r1 = new int[8];
        int r2 = 0;
        int r3 = 0;
        int r4 = 0;
    L4:
        if (r2 >= 17) goto L9;
        float r5 = (r0 / 34.0f) + ((r2 * r0) / 17.0f);
        int r6 = r8[r4];
        if ((r3 + r6) > r5) goto L8;
        r3 = r3 + r6;
        r4 = r4 + 1;
    L8:
        r1[r4] = r1[r4] + 1;
        r2 = r2 + 1;
        goto L4
    L9:
        return r1;
    }

    private static int getDecodedCodewordValue(int[] r2) {
        int r3 = getBitValue(r2);
        if (PDF417Common.getCodeword(r3) != (-1)) goto L5;
        return -1;
    L5:
        return r3;
    }

    private static int getBitValue(int[] r7) {
        long r0 = 0;
        int r3 = 0;
    L4:
        if (r3 >= r7.length) goto L15;
        int r4 = 0;
    L7:
        if (r4 >= r7[r3]) goto L13;
        int r5 = 1;
        long r1 = r0 << 1;
        if ((r3 % 2) == 0) goto L12;
        r5 = 0;
    L12:
        r0 = r1 | ((long) r5);
        r4 = r4 + 1;
        goto L7
    L13:
        r3 = r3 + 1;
        goto L4
    L15:
        return (int) r0;
    }

    private static int getClosestDecodedValue(int[] r10) {
        int r0 = MathUtils.sum(r10);
        float[] r2 = new float[8];
        int r4 = 0;
    L3:
        if (r4 >= 8) goto L5;
        r2[r4] = r10[r4] / r0;
        r4 = r4 + 1;
        goto L3
    L5:
        float r11 = Float.MAX_VALUE;
        int r1 = -1;
        int r5 = 0;
    L6:
        float[][] r6 = RATIOS_TABLE;
        if (r5 >= r6.length) goto L17;
        float[] r7 = r6[r5];
        float r8 = 0.0f;
        int r9 = 0;
    L9:
        if (r9 >= 8) goto L14;
        float r12 = r7[r9] - r2[r9];
        r8 = r8 + (r12 * r12);
        if (r8 >= r11) goto L14;
        r9 = r9 + 1;
    L14:
        if (r8 >= r11) goto L16;
        r1 = PDF417Common.SYMBOL_TABLE[r5];
        r11 = r8;
    L16:
        r5 = r5 + 1;
        goto L6
    L17:
        return r1;
    }
}

package com.google.zxing.common;

import com.google.zxing.Binarizer;
import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes.dex */
public final class HybridBinarizer extends GlobalHistogramBinarizer {
    private static final int BLOCK_SIZE = 8;
    private static final int BLOCK_SIZE_MASK = 7;
    private static final int BLOCK_SIZE_POWER = 3;
    private static final int MINIMUM_DIMENSION = 40;
    private static final int MIN_DYNAMIC_RANGE = 24;
    private BitMatrix matrix;

    private static int cap(int r0, int r1, int r2) {
        if (r0 >= r1) goto L4;
        return r1;
    L4:
        if (r0 <= r2) goto L6;
        return r2;
    L6:
        return r0;
    }

    public HybridBinarizer(LuminanceSource r1) {
        super(r1);
    }

    @Override // com.google.zxing.common.GlobalHistogramBinarizer, com.google.zxing.Binarizer
    public BitMatrix getBlackMatrix() throws NotFoundException {
        BitMatrix r0 = this.matrix;
        if (r0 == null) goto L5;
        return r0;
    L5:
        LuminanceSource r1 = getLuminanceSource();
        int r4 = r1.getWidth();
        int r5 = r1.getHeight();
        if (r4 < 40) goto L15;
        if (r5 < 40) goto L15;
        byte[] r2 = r1.getMatrix();
        int r3 = r4 >> 3;
        if ((r4 & 7) == 0) goto L11;
        r3 = r3 + 1;
    L11:
        int r6 = r3;
        int r7 = r5 >> 3;
        if ((r5 & 7) == 0) goto L14;
        r7 = r7 + 1;
    L14:
        int r8 = r7;
        int[][] r9 = calculateBlackPoints(r2, r6, r8, r4, r5);
        BitMatrix r10 = new BitMatrix(r4, r5);
        calculateThresholdForBlock(r2, r6, r8, r4, r5, r9, r10);
        this.matrix = r10;
    L17:
        return this.matrix;
    L15:
        this.matrix = super.getBlackMatrix();
        goto L17
    }

    @Override // com.google.zxing.common.GlobalHistogramBinarizer, com.google.zxing.Binarizer
    public Binarizer createBinarizer(LuminanceSource r1) {
        return new HybridBinarizer(r1);
    }

    private static void calculateThresholdForBlock(byte[] r15, int r16, int r17, int r18, int r19, int[][] r20, BitMatrix r21) {
        int r3 = 0;
    L3:
        if (r3 >= r17) goto L18;
        int r4 = r3 << 3;
        int r5 = r19 - 8;
        if (r4 <= r5) goto L7;
        r4 = r5;
    L7:
        int r6 = 0;
    L8:
        if (r6 >= r16) goto L17;
        int r7 = r6 << 3;
        int r8 = r18 - 8;
        if (r7 > r8) goto L13;
        r8 = r7;
    L13:
        int r9 = cap(r6, 2, r16 - 3);
        int r10 = cap(r3, 2, r17 - 3);
        int r11 = -2;
        int r12 = 0;
    L14:
        if (r11 > 2) goto L16;
        int[] r13 = r20[r10 + r11];
        r12 = r12 + ((((r13[r9 - 2] + r13[r9 - 1]) + r13[r9]) + r13[r9 + 1]) + r13[r9 + 2]);
        r11 = r11 + 1;
        goto L14
    L16:
        thresholdBlock(r15, r8, r4, r12 / 25, r18, r21);
        r6 = r6 + 1;
        goto L8
    L17:
        r3 = r3 + 1;
        goto L3
    }

    private static void thresholdBlock(byte[] r7, int r8, int r9, int r10, int r11, BitMatrix r12) {
        int r0 = (r9 * r11) + r8;
        int r2 = 0;
    L4:
        if (r2 >= 8) goto L12;
        int r4 = 0;
    L6:
        if (r4 >= 8) goto L11;
        if ((r7[r0 + r4] & 255) > r10) goto L10;
        r12.set(r8 + r4, r9 + r2);
    L10:
        r4 = r4 + 1;
        goto L6
    L11:
        r2 = r2 + 1;
        r0 = r0 + r11;
        goto L4
    }

    private static int[][] calculateBlackPoints(byte[] r17, int r18, int r19, int r20, int r21) {
        char r2 = 2;
        boolean r4 = true;
        int r5 = 0;
        int[][] r3 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{r19, r18});
        int r6 = 0;
    L3:
        if (r6 >= r19) goto L42;
        int r7 = r6 << 3;
        int r9 = r21 - 8;
        if (r7 <= r9) goto L7;
        r7 = r9;
    L7:
        int r10 = r5;
    L8:
        if (r10 >= r18) goto L41;
        int r11 = r10 << 3;
        int r12 = r20 - 8;
        if (r11 <= r12) goto L12;
        r11 = r12;
    L12:
        int r13 = (r7 * r20) + r11;
        int r14 = r5;
        int r15 = r14;
        int r16 = r15;
        int r110 = 255;
    L14:
        if (r14 >= 8) goto L31;
        int r8 = 0;
    L16:
        if (r8 >= 8) goto L24;
        int r22 = r17[r13 + r8] & 255;
        r15 = r15 + r22;
        if (r22 >= r110) goto L20;
        r110 = r22;
    L20:
        if (r22 <= r16) goto L22;
        r16 = r22;
    L22:
        r8 = r8 + 1;
        goto L16
    L24:
        if ((r16 - r110) <= 24) goto L30;
    L25:
        r14 = r14 + 1;
        r13 = r13 + r20;
        if (r14 >= 8) goto L30;
        int r23 = 0;
    L28:
        if (r23 >= 8) goto L25;
        r15 = r15 + (r17[r13 + r23] & 255);
        r23 = r23 + 1;
    L30:
        r14 = r14 + 1;
        r13 = r13 + r20;
        r4 = true;
        goto L14
    L31:
        boolean r24 = r4;
        int r25 = r15 >> 6;
        if ((r16 - r110) > 24) goto L39;
        r25 = r110 / 2;
        if (r6 <= 0) goto L39;
        if (r10 <= 0) goto L39;
        int[] r26 = r3[r6 - 1];
        int r111 = r10 - 1;
        char r112 = 2;
        int r27 = ((r26[r10] + (r3[r6][r111] * 2)) + r26[r111]) / 4;
        if (r110 >= r27) goto L40;
        r25 = r27;
    L40:
        r3[r6][r10] = r25;
        r10 = r10 + 1;
        r4 = r24;
        r2 = r112;
        r5 = 0;
    L39:
        r112 = 2;
        goto L40
    L41:
        r6 = r6 + 1;
        r2 = r2;
        r5 = 0;
        goto L3
    L42:
        return r3;
    }
}

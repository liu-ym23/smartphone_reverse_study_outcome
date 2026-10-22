package com.google.zxing.qrcode.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class AlignmentPatternFinder {
    private final int[] crossCheckStateCount;
    private final int height;
    private final BitMatrix image;
    private final float moduleSize;
    private final List<AlignmentPattern> possibleCenters;
    private final ResultPointCallback resultPointCallback;
    private final int startX;
    private final int startY;
    private final int width;

    AlignmentPatternFinder(BitMatrix r2, int r3, int r4, int r5, int r6, float r7, ResultPointCallback r8) {
        this.image = r2;
        this.possibleCenters = new ArrayList(5);
        this.startX = r3;
        this.startY = r4;
        this.width = r5;
        this.height = r6;
        this.moduleSize = r7;
        this.crossCheckStateCount = new int[3];
        this.resultPointCallback = r8;
    }

    AlignmentPattern find() throws NotFoundException {
        int r0 = this.startX;
        int r1 = this.height;
        int r2 = this.width + r0;
        int r3 = this.startY + (r1 / 2);
        int[] r4 = new int[3];
        int r6 = 0;
    L3:
        if (r6 >= r1) goto L38;
        if ((r6 & 1) != 0) goto L7;
        int r7 = (r6 + 1) / 2;
    L8:
        int r8 = r7 + r3;
        r4[0] = 0;
        r4[1] = 0;
        r4[2] = 0;
        int r10 = r0;
    L9:
        if (r10 >= r2) goto L13;
        if (this.image.get(r10, r8) == true) goto L13;
        r10 = r10 + 1;
    L13:
        int r11 = 0;
    L14:
        if (r10 >= r2) goto L32;
        if (this.image.get(r10, r8) == false) goto L27;
        if (r11 != 1) goto L19;
        r4[1] = r4[1] + 1;
    L30:
        r10 = r10 + 1;
        goto L14
    L19:
        if (r11 == 2) goto L21;
        r11 = r11 + 1;
        r4[r11] = r4[r11] + 1;
        goto L30
    L21:
        if (foundPatternCross(r4) == false) goto L25;
        AlignmentPattern r12 = handlePossibleCenter(r4, r8, r10);
        if (r12 == null) goto L25;
        return r12;
    L25:
        r4[0] = r4[2];
        r4[1] = 1;
        r4[2] = 0;
        r11 = 1;
        goto L30
    L27:
        if (r11 != 1) goto L29;
        r11 = r11 + 1;
    L29:
        r4[r11] = r4[r11] + 1;
        goto L30
    L32:
        if (foundPatternCross(r4) == false) goto L36;
        AlignmentPattern r9 = handlePossibleCenter(r4, r8, r2);
        if (r9 == null) goto L36;
        return r9;
    L36:
        r6 = r6 + 1;
        goto L3
    L7:
        r7 = -((r6 + 1) / 2);
        goto L8
    L38:
        if (this.possibleCenters.isEmpty() == true) goto L42;
        return this.possibleCenters.get(0);
    L42:
        throw NotFoundException.getNotFoundInstance();
    }

    private static float centerFromEnd(int[] r1, int r2) {
        return (r2 - r1[2]) - (r1[1] / 2.0f);
    }

    private boolean foundPatternCross(int[] r5) {
        float r4 = this.moduleSize;
        float r0 = r4 / 2.0f;
        int r2 = 0;
    L4:
        if (r2 >= 3) goto L9;
        if (Math.abs(r4 - r5[r2]) >= r0) goto L7;
        r2 = r2 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }

    private float crossCheckVertical(int r10, int r11, int r12, int r13) {
        BitMatrix r0 = this.image;
        int r1 = r0.getHeight();
        int[] r2 = this.crossCheckStateCount;
        r2[0] = 0;
        r2[1] = 0;
        r2[2] = 0;
        int r6 = r10;
    L3:
        if (r6 < 0) goto L10;
        if (r0.get(r11, r6) == false) goto L10;
        int r7 = r2[1];
        if (r7 > r12) goto L10;
        r2[1] = r7 + 1;
        r6 = r6 - 1;
    L10:
        if (r6 >= 0) goto L12;
    L50:
        return Float.NaN;
    L12:
        if (r2[1] > r12) goto L50;
    L14:
        if (r6 < 0) goto L21;
        if (r0.get(r11, r6) == true) goto L21;
        int r8 = r2[0];
        if (r8 > r12) goto L21;
        r2[0] = r8 + 1;
        r6 = r6 - 1;
    L21:
        if (r2[0] <= r12) goto L23;
        return Float.NaN;
    L23:
        int r14 = r10 + 1;
    L24:
        if (r14 >= r1) goto L30;
        if (r0.get(r11, r14) == false) goto L30;
        int r9 = r2[1];
        if (r9 > r12) goto L30;
        r2[1] = r9 + 1;
        r14 = r14 + 1;
    L30:
        if (r14 == r1) goto L50;
        if (r2[1] > r12) goto L50;
    L34:
        if (r14 >= r1) goto L40;
        if (r0.get(r11, r14) == true) goto L40;
        int r15 = r2[2];
        if (r15 > r12) goto L40;
        r2[2] = r15 + 1;
        r14 = r14 + 1;
    L40:
        int r16 = r2[2];
        if (r16 <= r12) goto L44;
        return Float.NaN;
    L44:
        if ((Math.abs(((r2[0] + r2[1]) + r16) - r13) * 5) < (r13 * 2)) goto L47;
        return Float.NaN;
    L47:
        if (foundPatternCross(r2) == false) goto L50;
        return centerFromEnd(r2, r14);
    }

    private AlignmentPattern handlePossibleCenter(int[] r7, int r8, int r9) {
        int r1 = (r7[0] + r7[1]) + r7[2];
        float r10 = centerFromEnd(r7, r9);
        float r11 = crossCheckVertical(r8, (int) r10, r7[1] * 2, r1);
        if (Float.isNaN(r11) == true) goto L19;
        float r12 = ((r7[0] + r7[1]) + r7[2]) / 3.0f;
        Iterator<AlignmentPattern> r0 = this.possibleCenters.iterator();
    L6:
        if (r0.hasNext() == false) goto L11;
        AlignmentPattern r2 = r0.next();
        if (r2.aboutEquals(r12, r11, r10) == false) goto L6;
        return r2.combineEstimate(r11, r10, r12);
    L11:
        AlignmentPattern r3 = new AlignmentPattern(r10, r11, r12);
        this.possibleCenters.add(r3);
        ResultPointCallback r6 = this.resultPointCallback;
        if (r6 == null) goto L20;
        r6.foundPossibleResultPoint(r3);
        return null;
    L20:
        return null;
    L19:
        return null;
    }
}

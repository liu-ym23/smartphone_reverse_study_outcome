package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class ITFReader extends OneDReader {
    private static final int[] DEFAULT_ALLOWED_LENGTHS = null;
    private static final int[] END_PATTERN_REVERSED = null;
    private static final float MAX_AVG_VARIANCE = 0.38f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.78f;
    private static final int N = 1;
    static final int[][] PATTERNS = null;
    private static final int[] START_PATTERN = null;
    private static final int W = 3;
    private int narrowLineWidth;

    public ITFReader() {
        this.narrowLineWidth = -1;
    }

    static {
        DEFAULT_ALLOWED_LENGTHS = new int[]{6, 8, 10, 12, 14};
        START_PATTERN = new int[]{1, 1, 1, 1};
        END_PATTERN_REVERSED = new int[]{1, 1, 3};
        PATTERNS = new int[][]{new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};
    }

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int r10, BitArray r11, Map<DecodeHintType, ?> r12) throws FormatException, NotFoundException {
        int[] r0 = decodeStart(r11);
        int[] r9 = decodeEnd(r11);
        StringBuilder r1 = new StringBuilder(20);
        decodeMiddle(r11, r0[1], r9[0], r1);
        String r13 = r1.toString();
        if (r12 == null) goto L5;
        int[] r14 = (int[]) r12.get(DecodeHintType.ALLOWED_LENGTHS);
    L6:
        if (r14 != null) goto L8;
        r14 = DEFAULT_ALLOWED_LENGTHS;
    L8:
        int r3 = r13.length();
        int r5 = r14.length;
        int r6 = 0;
        int r7 = 0;
    L9:
        if (r6 >= r5) goto L16;
        int r8 = r14[r6];
        if (r3 == r8) goto L12;
        if (r8 <= r7) goto L15;
        r7 = r8;
    L15:
        r6 = r6 + 1;
        goto L9
    L12:
        boolean r15 = true;
    L17:
        if (r15 == true) goto L20;
        if (r3 <= r7) goto L20;
        r15 = true;
    L20:
        if (r15 == false) goto L24;
        float r16 = r10;
        return new Result(r13, null, new ResultPoint[]{new ResultPoint(r0[1], r16), new ResultPoint(r9[0], r16)}, BarcodeFormat.ITF);
    L24:
        throw FormatException.getFormatInstance();
    L16:
        r15 = false;
        goto L17
    L5:
        r14 = null;
        goto L6
    }

    private static void decodeMiddle(BitArray r9, int r10, int r11, StringBuilder r12) throws NotFoundException {
        int[] r1 = new int[10];
        int[] r3 = new int[5];
        int[] r4 = new int[5];
    L3:
        if (r10 >= r11) goto L10;
        recordPattern(r9, r10, r1);
        int r5 = 0;
        int r6 = 0;
    L5:
        if (r6 >= 5) goto L7;
        int r7 = r6 * 2;
        r3[r6] = r1[r7];
        r4[r6] = r1[r7 + 1];
        r6 = r6 + 1;
        goto L5
    L7:
        r12.append((char) (decodeDigit(r3) + 48));
        r12.append((char) (decodeDigit(r4) + 48));
    L8:
        if (r5 >= 10) goto L3;
        r10 = r10 + r1[r5];
        r5 = r5 + 1;
        goto L8
    }

    private int[] decodeStart(BitArray r4) throws NotFoundException {
        int[] r0 = findGuardPattern(r4, skipWhiteSpace(r4), START_PATTERN);
        int r1 = r0[1];
        int r2 = r0[0];
        this.narrowLineWidth = (r1 - r2) / 4;
        validateQuietZone(r4, r2);
        return r0;
    }

    private void validateQuietZone(BitArray r2, int r3) throws NotFoundException {
        int r1 = this.narrowLineWidth * 10;
        if (r1 < r3) goto L6;
        r1 = r3;
    L6:
        int r4 = r3 - 1;
    L7:
        if (r1 <= 0) goto L12;
        if (r4 < 0) goto L12;
        if (r2.get(r4) == true) goto L12;
        r1 = r1 - 1;
        r4 = r4 - 1;
    L12:
        if (r1 != 0) goto L15;
        return;
    L15:
        throw NotFoundException.getNotFoundInstance();
    }

    private static int skipWhiteSpace(BitArray r2) throws NotFoundException {
        int r0 = r2.getSize();
        int r3 = r2.getNextSet(0);
        if (r3 == r0) goto L6;
        return r3;
    L6:
        throw NotFoundException.getNotFoundInstance();
    }

    private int[] decodeEnd(BitArray r6) throws NotFoundException {
        r6.reverse();
        int[] r0 = findGuardPattern(r6, skipWhiteSpace(r6), END_PATTERN_REVERSED);     // Catch: Throwable -> L6
        validateQuietZone(r6, r0[0]);     // Catch: Throwable -> L6
        int r5 = r0[0];     // Catch: Throwable -> L6
        r0[0] = r6.getSize() - r0[1];     // Catch: Throwable -> L6
        r0[1] = r6.getSize() - r5;     // Catch: Throwable -> L6
        r6.reverse();
        return r0;
    L6:
        th = move-exception;
        r6.reverse();
        throw th;
    }

    private static int[] findGuardPattern(BitArray r12, int r13, int[] r14) throws NotFoundException {
        int r0 = r14.length;
        int[] r1 = new int[r0];
        int r2 = r12.getSize();
        int r4 = r13;
        boolean r5 = false;
        int r6 = 0;
    L3:
        if (r13 >= r2) goto L18;
        if ((r12.get(r13) ^ r5) == false) goto L7;
        r1[r6] = r1[r6] + 1;
    L16:
        r13 = r13 + 1;
        goto L3
    L7:
        int r7 = r0 - 1;
        if (r6 == r7) goto L10;
        r6 = r6 + 1;
    L15:
        r1[r6] = 1;
        r5 = !r5;
        goto L16
    L10:
        if (patternMatchVariance(r1, r14, MAX_INDIVIDUAL_VARIANCE) < 0.38f) goto L12;
        r4 = r4 + (r1[0] + r1[1]);
        int r9 = r0 - 2;
        System.arraycopy(r1, 2, r1, 0, r9);
        r1[r9] = 0;
        r1[r7] = 0;
        r6 = r6 - 1;
        goto L15
    L12:
        return new int[]{r4, r13};
    L18:
        throw NotFoundException.getNotFoundInstance();
    }

    private static int decodeDigit(int[] r6) throws NotFoundException {
        int r0 = PATTERNS.length;
        float r1 = 0.38f;
        int r2 = -1;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L8;
        float r4 = patternMatchVariance(r6, PATTERNS[r3], MAX_INDIVIDUAL_VARIANCE);
        if (r4 >= r1) goto L7;
        r2 = r3;
        r1 = r4;
    L7:
        r3 = r3 + 1;
        goto L3
    L8:
        if (r2 < 0) goto L11;
        return r2;
    L11:
        throw NotFoundException.getNotFoundInstance();
    }
}

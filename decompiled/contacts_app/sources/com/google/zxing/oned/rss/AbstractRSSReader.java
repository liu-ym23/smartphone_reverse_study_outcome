package com.google.zxing.oned.rss;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.oned.OneDReader;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractRSSReader extends OneDReader {
    private static final float MAX_AVG_VARIANCE = 0.2f;
    private static final float MAX_FINDER_PATTERN_RATIO = 0.89285713f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.45f;
    private static final float MIN_FINDER_PATTERN_RATIO = 0.7916667f;
    private final int[] dataCharacterCounters;
    private final int[] decodeFinderCounters;
    private final int[] evenCounts;
    private final float[] evenRoundingErrors;
    private final int[] oddCounts;
    private final float[] oddRoundingErrors;

    protected AbstractRSSReader() {
        this.decodeFinderCounters = new int[4];
        int[] r1 = new int[8];
        this.dataCharacterCounters = r1;
        this.oddRoundingErrors = new float[4];
        this.evenRoundingErrors = new float[4];
        this.oddCounts = new int[r1.length / 2];
        this.evenCounts = new int[r1.length / 2];
    }

    protected final int[] getDecodeFinderCounters() {
        return this.decodeFinderCounters;
    }

    protected final int[] getDataCharacterCounters() {
        return this.dataCharacterCounters;
    }

    protected final float[] getOddRoundingErrors() {
        return this.oddRoundingErrors;
    }

    protected final float[] getEvenRoundingErrors() {
        return this.evenRoundingErrors;
    }

    protected final int[] getOddCounts() {
        return this.oddCounts;
    }

    protected final int[] getEvenCounts() {
        return this.evenCounts;
    }

    protected static int parseFinderValue(int[] r3, int[][] r4) throws NotFoundException {
        int r0 = 0;
    L4:
        if (r0 >= r4.length) goto L10;
        if (patternMatchVariance(r3, r4[r0], MAX_INDIVIDUAL_VARIANCE) < 0.2f) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r0;
    L10:
        throw NotFoundException.getNotFoundInstance();
    }

    @Deprecated
    protected static int count(int[] r0) {
        return MathUtils.sum(r0);
    }

    protected static void increment(int[] r6, float[] r7) {
        int r0 = 0;
        float r1 = r7[0];
        int r3 = 1;
    L4:
        if (r3 >= r6.length) goto L9;
        float r4 = r7[r3];
        if (r4 <= r1) goto L8;
        r0 = r3;
        r1 = r4;
    L8:
        r3 = r3 + 1;
        goto L4
    L9:
        r6[r0] = r6[r0] + 1;
    }

    protected static void decrement(int[] r6, float[] r7) {
        int r0 = 0;
        float r1 = r7[0];
        int r3 = 1;
    L4:
        if (r3 >= r6.length) goto L9;
        float r4 = r7[r3];
        if (r4 >= r1) goto L8;
        r0 = r3;
        r1 = r4;
    L8:
        r3 = r3 + 1;
        goto L4
    L9:
        r6[r0] = r6[r0] - 1;
    }

    protected static boolean isFinderPattern(int[] r7) {
        int r1 = r7[0] + r7[1];
        float r2 = r1 / ((r7[2] + r1) + r7[3]);
        if (r2 >= MIN_FINDER_PATTERN_RATIO) goto L5;
    L17:
        return false;
    L5:
        if (r2 > MAX_FINDER_PATTERN_RATIO) goto L17;
        int r3 = r7.length;
        int r4 = Integer.MAX_VALUE;
        int r5 = Integer.MIN_VALUE;
        int r6 = 0;
    L7:
        if (r6 >= r3) goto L15;
        int r8 = r7[r6];
        if (r8 <= r5) goto L11;
        r5 = r8;
    L11:
        if (r8 >= r4) goto L13;
        r4 = r8;
    L13:
        r6 = r6 + 1;
        goto L7
    L15:
        if (r5 >= (r4 * 10)) goto L17;
        return true;
    }
}

package com.ttnet.org.chromium.base.metrics;

import com.bytedance.common.utility.date.DateDef;
import com.ttnet.org.chromium.base.annotations.MainDex;

/* JADX INFO: loaded from: classes4.dex */
@MainDex
public class RecordHistogram {
    private static int clampToInt(long r2) {
        if (r2 <= 2147483647L) goto L7;
        return Integer.MAX_VALUE;
    L7:
        if (r2 >= (-2147483648L)) goto L11;
        return Integer.MIN_VALUE;
    L11:
        return (int) r2;
    }

    public RecordHistogram() {
    }

    public static void recordBooleanHistogram(String r1, boolean r2) {
        UmaRecorderHolder.get().recordBooleanHistogram(r1, r2);
    }

    public static void recordEnumeratedHistogram(String r0, int r1, int r2) {
        recordExactLinearHistogram(r0, r1, r2);
    }

    public static void recordCount1MHistogram(String r6, int r7) {
        UmaRecorderHolder.get().recordExponentialHistogram(r6, r7, 1, 1000000, 50);
    }

    public static void recordCount100Histogram(String r6, int r7) {
        UmaRecorderHolder.get().recordExponentialHistogram(r6, r7, 1, 100, 50);
    }

    public static void recordCount1000Histogram(String r6, int r7) {
        UmaRecorderHolder.get().recordExponentialHistogram(r6, r7, 1, 1000, 50);
    }

    public static void recordCount100000Histogram(String r6, int r7) {
        UmaRecorderHolder.get().recordExponentialHistogram(r6, r7, 1, 100000, 50);
    }

    public static void recordCustomCountHistogram(String r6, int r7, int r8, int r9, int r10) {
        UmaRecorderHolder.get().recordExponentialHistogram(r6, r7, r8, r9, r10);
    }

    public static void recordLinearCountHistogram(String r6, int r7, int r8, int r9, int r10) {
        UmaRecorderHolder.get().recordLinearHistogram(r6, r7, r8, r9, r10);
    }

    public static void recordPercentageHistogram(String r1, int r2) {
        recordExactLinearHistogram(r1, r2, 101);
    }

    public static void recordSparseHistogram(String r1, int r2) {
        UmaRecorderHolder.get().recordSparseHistogram(r1, r2);
    }

    public static void recordTimesHistogram(String r8, long r9) {
        recordCustomTimesHistogramMilliseconds(r8, r9, 1, 10000, 50);
    }

    public static void recordMediumTimesHistogram(String r8, long r9) {
        recordCustomTimesHistogramMilliseconds(r8, r9, 10, 180000, 50);
    }

    public static void recordLongTimesHistogram(String r8, long r9) {
        recordCustomTimesHistogramMilliseconds(r8, r9, 1, DateDef.HOUR, 50);
    }

    public static void recordLongTimesHistogram100(String r8, long r9) {
        recordCustomTimesHistogramMilliseconds(r8, r9, 1, DateDef.HOUR, 100);
    }

    public static void recordCustomTimesHistogram(String r0, long r1, long r3, long r5, int r7) {
        recordCustomTimesHistogramMilliseconds(r0, r1, r3, r5, r7);
    }

    public static void recordMemoryKBHistogram(String r6, int r7) {
        UmaRecorderHolder.get().recordExponentialHistogram(r6, r7, 1000, 500000, 50);
    }

    public static void recordExactLinearHistogram(String r6, int r7, int r8) {
        UmaRecorder r0 = UmaRecorderHolder.get();
        r0.recordLinearHistogram(r6, r7, 1, r8, r8 + 1);
    }

    private static void recordCustomTimesHistogramMilliseconds(String r2, long r3, long r5, long r7, int r9) {
        UmaRecorderHolder.get().recordExponentialHistogram(r2, clampToInt(r3), clampToInt(r5), clampToInt(r7), r9);
    }

    public static int getHistogramValueCountForTesting(String r1, int r2) {
        return UmaRecorderHolder.get().getHistogramValueCountForTesting(r1, r2);
    }

    public static int getHistogramTotalCountForTesting(String r1) {
        return UmaRecorderHolder.get().getHistogramTotalCountForTesting(r1);
    }
}

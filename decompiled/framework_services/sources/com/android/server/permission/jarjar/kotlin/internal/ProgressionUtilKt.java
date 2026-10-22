package com.android.server.permission.jarjar.kotlin.internal;

/* JADX INFO: compiled from: progressionUtil.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ProgressionUtilKt {
    private static final int mod(int a, int b) {
        int mod = a % b;
        if (mod < 0) goto L6;
        return mod;
    L6:
        return mod + b;
    }

    private static final int differenceModulo(int a, int b, int c) {
        return mod(mod(a, c) - mod(b, c), c);
    }

    public static final int getProgressionLastElement(int start, int end, int step) {
        if (step <= 0) goto L6;
        if (start >= end) goto L14;
        return end - differenceModulo(end, start, step);
    L14:
        return end;
    L6:
        if (step >= 0) goto L12;
        if (start <= end) goto L14;
        return differenceModulo(start, end, -step) + end;
    L12:
        throw new IllegalArgumentException("Step is zero.");
    }
}

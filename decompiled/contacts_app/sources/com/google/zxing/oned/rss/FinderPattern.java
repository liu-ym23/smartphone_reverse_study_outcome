package com.google.zxing.oned.rss;

import com.google.zxing.ResultPoint;

/* JADX INFO: loaded from: classes3.dex */
public final class FinderPattern {
    private final ResultPoint[] resultPoints;
    private final int[] startEnd;
    private final int value;

    public FinderPattern(int r1, int[] r2, int r3, int r4, int r5) {
        this.value = r1;
        this.startEnd = r2;
        float r6 = r5;
        this.resultPoints = new ResultPoint[]{new ResultPoint(r3, r6), new ResultPoint(r4, r6)};
    }

    public int getValue() {
        return this.value;
    }

    public int[] getStartEnd() {
        return this.startEnd;
    }

    public ResultPoint[] getResultPoints() {
        return this.resultPoints;
    }

    public boolean equals(Object r3) {
        if ((r3 instanceof FinderPattern) == true) goto L6;
        return false;
    L6:
        if (this.value != ((FinderPattern) r3).value) goto L9;
        return true;
    L9:
        return false;
    }

    public int hashCode() {
        return this.value;
    }
}

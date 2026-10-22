package com.airbnb.lottie.utils;

import x0.l;

/* loaded from: classes.dex */
public class LottieTrace {
    private static final int MAX_DEPTH = 5;
    private final String[] sections = new String[5];
    private final long[] startTimeNs = new long[5];
    private int traceDepth = 0;
    private int depthPastMaxDepth = 0;

    public void beginSection(String str) {
        int i10 = this.traceDepth;
        if (i10 == 5) {
            this.depthPastMaxDepth++;
            return;
        }
        this.sections[i10] = str;
        this.startTimeNs[i10] = System.nanoTime();
        l.a(str);
        this.traceDepth++;
    }

    public float endSection(String str) {
        int i10 = this.depthPastMaxDepth;
        if (i10 > 0) {
            this.depthPastMaxDepth = i10 - 1;
            return 0.0f;
        }
        int i11 = this.traceDepth - 1;
        this.traceDepth = i11;
        if (i11 == -1) {
            throw new IllegalStateException("Can't end trace section. There are none.");
        }
        if (str.equals(this.sections[i11])) {
            l.b();
            return (System.nanoTime() - this.startTimeNs[this.traceDepth]) / 1000000.0f;
        }
        throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + this.sections[this.traceDepth] + ".");
    }
}

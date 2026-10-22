package com.airbnb.lottie.utils;

import androidx.core.os.TraceCompat;
import com.bytedance.librarian.LibrarianImpl;

/* JADX INFO: loaded from: classes.dex */
public class LottieTrace {
    private static final int MAX_DEPTH = 5;
    private int depthPastMaxDepth;
    private final String[] sections;
    private final long[] startTimeNs;
    private int traceDepth;

    public LottieTrace() {
        this.sections = new String[5];
        this.startTimeNs = new long[5];
        this.traceDepth = 0;
        this.depthPastMaxDepth = 0;
    }

    public void beginSection(String r5) {
        int r0 = this.traceDepth;
        if (r0 != 5) goto L6;
        this.depthPastMaxDepth++;
        return;
    L6:
        this.sections[r0] = r5;
        this.startTimeNs[r0] = System.nanoTime();
        TraceCompat.beginSection(r5);
        this.traceDepth++;
    }

    public float endSection(String r4) {
        int r0 = this.depthPastMaxDepth;
        if (r0 <= 0) goto L6;
        this.depthPastMaxDepth = r0 - 1;
        return 0.0f;
    L6:
        int r1 = this.traceDepth - 1;
        this.traceDepth = r1;
        if (r1 == (-1)) goto L15;
        if (r4.equals(this.sections[r1]) == false) goto L13;
        TraceCompat.endSection();
        return (System.nanoTime() - this.startTimeNs[this.traceDepth]) / 1000000.0f;
    L13:
        throw new IllegalStateException("Unbalanced trace call " + r4 + ". Expected " + this.sections[this.traceDepth] + LibrarianImpl.Constants.DOT);
    L15:
        throw new IllegalStateException("Can't end trace section. There are none.");
    }
}

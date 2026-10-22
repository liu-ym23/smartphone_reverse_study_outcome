package org.apache.commons.math.optimization;

import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class SimpleRealPointChecker implements RealConvergenceChecker {
    private static final double DEFAULT_ABSOLUTE_THRESHOLD = 2.2250738585072014E-306d;
    private static final double DEFAULT_RELATIVE_THRESHOLD = 1.1102230246251565E-14d;
    private final double absoluteThreshold;
    private final double relativeThreshold;

    public SimpleRealPointChecker() {
        this.relativeThreshold = DEFAULT_RELATIVE_THRESHOLD;
        this.absoluteThreshold = DEFAULT_ABSOLUTE_THRESHOLD;
    }

    public SimpleRealPointChecker(double relativeThreshold, double absoluteThreshold) {
        this.relativeThreshold = relativeThreshold;
        this.absoluteThreshold = absoluteThreshold;
    }

    @Override // org.apache.commons.math.optimization.RealConvergenceChecker
    public boolean converged(int iteration, RealPointValuePair previous, RealPointValuePair current) {
        double[] p = previous.getPoint();
        double[] c = current.getPoint();
        int i = 0;
    L4:
        if (i >= p.length) goto L12;
        double difference = FastMath.abs(p[i] - c[i]);
        double size = FastMath.max(FastMath.abs(p[i]), FastMath.abs(c[i]));
        if (difference <= (this.relativeThreshold * size)) goto L11;
        if (difference <= this.absoluteThreshold) goto L11;
        return false;
    L11:
        i = i + 1;
        goto L4
    L12:
        return true;
    }
}

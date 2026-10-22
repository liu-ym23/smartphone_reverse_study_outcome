package org.apache.commons.math.optimization;

import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class SimpleScalarValueChecker implements RealConvergenceChecker {
    private static final double DEFAULT_ABSOLUTE_THRESHOLD = 2.2250738585072014E-306d;
    private static final double DEFAULT_RELATIVE_THRESHOLD = 1.1102230246251565E-14d;
    private final double absoluteThreshold;
    private final double relativeThreshold;

    public SimpleScalarValueChecker() {
        this.relativeThreshold = DEFAULT_RELATIVE_THRESHOLD;
        this.absoluteThreshold = DEFAULT_ABSOLUTE_THRESHOLD;
    }

    public SimpleScalarValueChecker(double relativeThreshold, double absoluteThreshold) {
        this.relativeThreshold = relativeThreshold;
        this.absoluteThreshold = absoluteThreshold;
    }

    @Override // org.apache.commons.math.optimization.RealConvergenceChecker
    public boolean converged(int iteration, RealPointValuePair previous, RealPointValuePair current) {
        double p = previous.getValue();
        double c = current.getValue();
        double difference = FastMath.abs(p - c);
        double size = FastMath.max(FastMath.abs(p), FastMath.abs(c));
        if (difference > (this.relativeThreshold * size)) goto L5;
    L8:
        return true;
    L5:
        if (difference <= this.absoluteThreshold) goto L8;
        return false;
    }
}

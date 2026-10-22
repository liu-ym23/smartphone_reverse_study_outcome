package org.apache.commons.math.optimization;

import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class SimpleVectorialValueChecker implements VectorialConvergenceChecker {
    private static final double DEFAULT_ABSOLUTE_THRESHOLD = 2.2250738585072014E-306d;
    private static final double DEFAULT_RELATIVE_THRESHOLD = 1.1102230246251565E-14d;
    private final double absoluteThreshold;
    private final double relativeThreshold;

    public SimpleVectorialValueChecker() {
        this.relativeThreshold = DEFAULT_RELATIVE_THRESHOLD;
        this.absoluteThreshold = DEFAULT_ABSOLUTE_THRESHOLD;
    }

    public SimpleVectorialValueChecker(double relativeThreshold, double absoluteThreshold) {
        this.relativeThreshold = relativeThreshold;
        this.absoluteThreshold = absoluteThreshold;
    }

    @Override // org.apache.commons.math.optimization.VectorialConvergenceChecker
    public boolean converged(int iteration, VectorialPointValuePair previous, VectorialPointValuePair current) {
        double[] p = previous.getValueRef();
        double[] c = current.getValueRef();
        int i = 0;
    L4:
        if (i >= p.length) goto L12;
        double pi = p[i];
        double ci = c[i];
        double difference = FastMath.abs(pi - ci);
        double size = FastMath.max(FastMath.abs(pi), FastMath.abs(ci));
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

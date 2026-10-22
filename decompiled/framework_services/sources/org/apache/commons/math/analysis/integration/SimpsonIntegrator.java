package org.apache.commons.math.analysis.integration;

import org.apache.commons.math.FunctionEvaluationException;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.MaxIterationsExceededException;
import org.apache.commons.math.analysis.UnivariateRealFunction;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class SimpsonIntegrator extends UnivariateRealIntegratorImpl {
    @Deprecated
    public SimpsonIntegrator(UnivariateRealFunction f) {
        super(f, 64);
    }

    public SimpsonIntegrator() {
        super(64);
    }

    @Override // org.apache.commons.math.analysis.integration.UnivariateRealIntegrator
    @Deprecated
    public double integrate(double min, double max) throws MaxIterationsExceededException, FunctionEvaluationException, IllegalArgumentException {
        return integrate(this.f, min, max);
    }

    @Override // org.apache.commons.math.analysis.integration.UnivariateRealIntegrator
    public double integrate(UnivariateRealFunction f, double min, double max) throws MaxIterationsExceededException, FunctionEvaluationException, IllegalArgumentException {
        clearResult();
        verifyInterval(min, max);
        verifyIterationCount();
        TrapezoidIntegrator qtrap = new TrapezoidIntegrator();
        double r8 = 3.0d;
        double r10 = 4.0d;
        if (this.minimalIterationCount != 1) goto L6;
        setResult(((qtrap.stage(f, min, max, 1) * 4.0d) - qtrap.stage(f, min, max, 0)) / 3.0d, 1);
        return this.result;
    L6:
        double olds = 0.0d;
        double oldt = qtrap.stage(f, min, max, 0);
        int i = 1;
    L8:
        if (i > this.maximalIterationCount) goto L19;
        double t = qtrap.stage(f, min, max, i);
        double s = ((t * r10) - oldt) / r8;
        if (i < this.minimalIterationCount) goto L17;
        double delta = FastMath.abs(s - olds);
        double rLimit = (this.relativeAccuracy * (FastMath.abs(olds) + FastMath.abs(s))) * 0.5d;
        if (delta <= rLimit) goto L15;
        if (delta > this.absoluteAccuracy) goto L17;
    L15:
        setResult(s, i);
        return this.result;
    L17:
        olds = s;
        oldt = t;
        i = i + 1;
        r8 = 3.0d;
        r10 = 4.0d;
        goto L8
    L19:
        throw new MaxIterationsExceededException(this.maximalIterationCount);
    }

    @Override // org.apache.commons.math.analysis.integration.UnivariateRealIntegratorImpl
    protected void verifyIterationCount() throws IllegalArgumentException {
        super.verifyIterationCount();
        if (this.maximalIterationCount > 64) goto L6;
        return;
    L6:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.INVALID_ITERATIONS_LIMITS, new Object[]{0, 64});
    }
}

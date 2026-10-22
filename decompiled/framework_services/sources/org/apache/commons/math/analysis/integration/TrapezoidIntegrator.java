package org.apache.commons.math.analysis.integration;

import org.apache.commons.math.FunctionEvaluationException;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.MaxIterationsExceededException;
import org.apache.commons.math.analysis.UnivariateRealFunction;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class TrapezoidIntegrator extends UnivariateRealIntegratorImpl {
    private double s;

    @Deprecated
    public TrapezoidIntegrator(UnivariateRealFunction f) {
        super(f, 64);
    }

    public TrapezoidIntegrator() {
        super(64);
    }

    double stage(UnivariateRealFunction f, double min, double max, int n) throws FunctionEvaluationException {
        if (n != 0) goto L6;
        this.s = ((max - min) * 0.5d) * (f.value(min) + f.value(max));
        return this.s;
    L6:
        long np = 1 << (n - 1);
        double sum = 0.0d;
        double spacing = (max - min) / np;
        double x = min + (spacing * 0.5d);
        long i = 0;
    L8:
        if (i >= np) goto L10;
        sum = sum + f.value(x);
        x = x + spacing;
        i = i + 1;
        goto L8
    L10:
        this.s = (this.s + (sum * spacing)) * 0.5d;
        return this.s;
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
        double oldt = stage(f, min, max, 0);
        double oldt2 = oldt;
        int i = 1;
    L4:
        if (i > this.maximalIterationCount) goto L15;
        double t = stage(f, min, max, i);
        if (i < this.minimalIterationCount) goto L13;
        double delta = FastMath.abs(t - oldt2);
        double rLimit = (this.relativeAccuracy * (FastMath.abs(oldt2) + FastMath.abs(t))) * 0.5d;
        if (delta <= rLimit) goto L11;
        if (delta > this.absoluteAccuracy) goto L13;
    L11:
        setResult(t, i);
        return this.result;
    L13:
        oldt2 = t;
        i = i + 1;
        goto L4
    L15:
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

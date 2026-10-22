package org.apache.commons.math.analysis.integration;

import org.apache.commons.math.FunctionEvaluationException;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.MaxIterationsExceededException;
import org.apache.commons.math.analysis.UnivariateRealFunction;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class RombergIntegrator extends UnivariateRealIntegratorImpl {
    @Deprecated
    public RombergIntegrator(UnivariateRealFunction f) {
        super(f, 32);
    }

    public RombergIntegrator() {
        super(32);
    }

    @Override // org.apache.commons.math.analysis.integration.UnivariateRealIntegrator
    @Deprecated
    public double integrate(double min, double max) throws MaxIterationsExceededException, FunctionEvaluationException, IllegalArgumentException {
        return integrate(this.f, min, max);
    }

    @Override // org.apache.commons.math.analysis.integration.UnivariateRealIntegrator
    public double integrate(UnivariateRealFunction f, double min, double max) throws MaxIterationsExceededException, FunctionEvaluationException, IllegalArgumentException {
        int m = this.maximalIterationCount + 1;
        double[] previousRow = new double[m];
        double[] currentRow = new double[m];
        clearResult();
        verifyInterval(min, max);
        verifyIterationCount();
        TrapezoidIntegrator qtrap = new TrapezoidIntegrator();
        char r12 = 0;
        currentRow[0] = qtrap.stage(f, min, max, 0);
        double s = currentRow[0];
        int i = 1;
    L3:
        double olds = s;
        if (i > this.maximalIterationCount) goto L22;
        double[] tmpRow = previousRow;
        double[] previousRow2 = currentRow;
        currentRow = tmpRow;
        currentRow[r12] = qtrap.stage(f, min, max, i);
        int j = 1;
    L6:
        if (j > i) goto L8;
        double r = (1 << (j * 2)) - 1;
        double tIJm1 = currentRow[j - 1];
        currentRow[j] = ((tIJm1 - previousRow2[j - 1]) / r) + tIJm1;
        j = j + 1;
        goto L6
    L8:
        s = currentRow[i];
        if (i < this.minimalIterationCount) goto L20;
        double delta = FastMath.abs(s - olds);
        double rLimit = (this.relativeAccuracy * (FastMath.abs(olds) + FastMath.abs(s))) * 0.5d;
        if (delta <= rLimit) goto L16;
        int i2 = i;
        if (delta <= this.absoluteAccuracy) goto L17;
        i = i2;
    L17:
        setResult(s, i2);
        return this.result;
    L16:
        i2 = i;
    L20:
        i = i + 1;
        m = m;
        previousRow = previousRow2;
        r12 = 0;
        goto L3
    L22:
        throw new MaxIterationsExceededException(this.maximalIterationCount);
    }

    @Override // org.apache.commons.math.analysis.integration.UnivariateRealIntegratorImpl
    protected void verifyIterationCount() throws IllegalArgumentException {
        super.verifyIterationCount();
        if (this.maximalIterationCount > 32) goto L6;
        return;
    L6:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.INVALID_ITERATIONS_LIMITS, new Object[]{0, 32});
    }
}

package org.apache.commons.math.analysis.integration;

import org.apache.commons.math.ConvergingAlgorithmImpl;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.analysis.UnivariateRealFunction;
import org.apache.commons.math.exception.NullArgumentException;
import org.apache.commons.math.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes3.dex */
public abstract class UnivariateRealIntegratorImpl extends ConvergingAlgorithmImpl implements UnivariateRealIntegrator {
    private static final long serialVersionUID = 6248808456637441533L;
    protected int defaultMinimalIterationCount;

    @Deprecated
    protected UnivariateRealFunction f;
    protected int minimalIterationCount;
    protected double result;
    protected boolean resultComputed;

    @Deprecated
    protected UnivariateRealIntegratorImpl(UnivariateRealFunction f, int defaultMaximalIterationCount) throws IllegalArgumentException {
        super(defaultMaximalIterationCount, 1.0E-15d);
        this.resultComputed = false;
        if (f == null) goto L7;
        this.f = f;
        setRelativeAccuracy(1.0E-6d);
        this.defaultMinimalIterationCount = 3;
        this.minimalIterationCount = this.defaultMinimalIterationCount;
        verifyIterationCount();
        return;
    L7:
        throw new NullArgumentException(LocalizedFormats.FUNCTION);
    }

    protected UnivariateRealIntegratorImpl(int defaultMaximalIterationCount) throws IllegalArgumentException {
        super(defaultMaximalIterationCount, 1.0E-15d);
        this.resultComputed = false;
        setRelativeAccuracy(1.0E-6d);
        this.defaultMinimalIterationCount = 3;
        this.minimalIterationCount = this.defaultMinimalIterationCount;
        verifyIterationCount();
    }

    @Override // org.apache.commons.math.analysis.integration.UnivariateRealIntegrator
    public double getResult() throws IllegalStateException {
        if (this.resultComputed == false) goto L7;
        return this.result;
    L7:
        throw MathRuntimeException.createIllegalStateException(LocalizedFormats.NO_RESULT_AVAILABLE, new Object[0]);
    }

    protected final void setResult(double newResult, int iterationCount) {
        this.result = newResult;
        this.iterationCount = iterationCount;
        this.resultComputed = true;
    }

    protected final void clearResult() {
        this.iterationCount = 0;
        this.resultComputed = false;
    }

    @Override // org.apache.commons.math.analysis.integration.UnivariateRealIntegrator
    public void setMinimalIterationCount(int count) {
        this.minimalIterationCount = count;
    }

    @Override // org.apache.commons.math.analysis.integration.UnivariateRealIntegrator
    public int getMinimalIterationCount() {
        return this.minimalIterationCount;
    }

    @Override // org.apache.commons.math.analysis.integration.UnivariateRealIntegrator
    public void resetMinimalIterationCount() {
        this.minimalIterationCount = this.defaultMinimalIterationCount;
    }

    protected void verifyInterval(double lower, double upper) throws IllegalArgumentException {
        if (lower >= upper) goto L6;
        return;
    L6:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.ENDPOINTS_NOT_AN_INTERVAL, new Object[]{Double.valueOf(lower), Double.valueOf(upper)});
    }

    protected void verifyIterationCount() throws IllegalArgumentException {
        if (this.minimalIterationCount <= 0) goto L8;
        if (this.maximalIterationCount <= this.minimalIterationCount) goto L8;
        return;
    L8:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.INVALID_ITERATIONS_LIMITS, new Object[]{Integer.valueOf(this.minimalIterationCount), Integer.valueOf(this.maximalIterationCount)});
    }
}

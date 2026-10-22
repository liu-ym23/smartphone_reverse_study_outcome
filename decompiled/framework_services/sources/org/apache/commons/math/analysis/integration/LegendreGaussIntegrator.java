package org.apache.commons.math.analysis.integration;

import org.apache.commons.math.ConvergenceException;
import org.apache.commons.math.FunctionEvaluationException;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.MaxIterationsExceededException;
import org.apache.commons.math.analysis.UnivariateRealFunction;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class LegendreGaussIntegrator extends UnivariateRealIntegratorImpl {
    private static final double[] ABSCISSAS_2 = null;
    private static final double[] ABSCISSAS_3 = null;
    private static final double[] ABSCISSAS_4 = null;
    private static final double[] ABSCISSAS_5 = null;
    private static final double[] WEIGHTS_2 = null;
    private static final double[] WEIGHTS_3 = null;
    private static final double[] WEIGHTS_4 = null;
    private static final double[] WEIGHTS_5 = null;
    private final double[] abscissas;
    private final double[] weights;

    static {
        ABSCISSAS_2 = new double[]{(-1.0d) / FastMath.sqrt(3.0d), 1.0d / FastMath.sqrt(3.0d)};
        WEIGHTS_2 = new double[]{1.0d, 1.0d};
        ABSCISSAS_3 = new double[]{-FastMath.sqrt(0.6d), 0.0d, FastMath.sqrt(0.6d)};
        WEIGHTS_3 = new double[]{0.5555555555555556d, 0.8888888888888888d, 0.5555555555555556d};
        ABSCISSAS_4 = new double[]{-FastMath.sqrt(((FastMath.sqrt(30.0d) * 2.0d) + 15.0d) / 35.0d), -FastMath.sqrt((15.0d - (FastMath.sqrt(30.0d) * 2.0d)) / 35.0d), FastMath.sqrt((15.0d - (FastMath.sqrt(30.0d) * 2.0d)) / 35.0d), FastMath.sqrt(((FastMath.sqrt(30.0d) * 2.0d) + 15.0d) / 35.0d)};
        WEIGHTS_4 = new double[]{(90.0d - (FastMath.sqrt(30.0d) * 5.0d)) / 180.0d, ((FastMath.sqrt(30.0d) * 5.0d) + 90.0d) / 180.0d, ((FastMath.sqrt(30.0d) * 5.0d) + 90.0d) / 180.0d, (90.0d - (FastMath.sqrt(30.0d) * 5.0d)) / 180.0d};
        ABSCISSAS_5 = new double[]{-FastMath.sqrt(((FastMath.sqrt(70.0d) * 2.0d) + 35.0d) / 63.0d), -FastMath.sqrt((35.0d - (FastMath.sqrt(70.0d) * 2.0d)) / 63.0d), 0.0d, FastMath.sqrt((35.0d - (FastMath.sqrt(70.0d) * 2.0d)) / 63.0d), FastMath.sqrt(((FastMath.sqrt(70.0d) * 2.0d) + 35.0d) / 63.0d)};
        WEIGHTS_5 = new double[]{(322.0d - (FastMath.sqrt(70.0d) * 13.0d)) / 900.0d, ((FastMath.sqrt(70.0d) * 13.0d) + 322.0d) / 900.0d, 0.5688888888888889d, ((FastMath.sqrt(70.0d) * 13.0d) + 322.0d) / 900.0d, (322.0d - (FastMath.sqrt(70.0d) * 13.0d)) / 900.0d};
    }

    public LegendreGaussIntegrator(int n, int defaultMaximalIterationCount) throws IllegalArgumentException {
        super(defaultMaximalIterationCount);
        switch(n) {
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            default: goto L5;
        };
    L6:
        this.abscissas = ABSCISSAS_5;
        this.weights = WEIGHTS_5;
        return;
    L7:
        this.abscissas = ABSCISSAS_4;
        this.weights = WEIGHTS_4;
        return;
    L8:
        this.abscissas = ABSCISSAS_3;
        this.weights = WEIGHTS_3;
        return;
    L9:
        this.abscissas = ABSCISSAS_2;
        this.weights = WEIGHTS_2;
        return;
    L5:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.N_POINTS_GAUSS_LEGENDRE_INTEGRATOR_NOT_SUPPORTED, new Object[]{Integer.valueOf(n), 2, 5});
    }

    @Override // org.apache.commons.math.analysis.integration.UnivariateRealIntegrator
    @Deprecated
    public double integrate(double min, double max) throws ConvergenceException, FunctionEvaluationException, IllegalArgumentException {
        return integrate(this.f, min, max);
    }

    @Override // org.apache.commons.math.analysis.integration.UnivariateRealIntegrator
    public double integrate(UnivariateRealFunction f, double min, double max) throws ConvergenceException, FunctionEvaluationException, IllegalArgumentException {
        clearResult();
        verifyInterval(min, max);
        verifyIterationCount();
        double oldt = stage(f, min, max, 1);
        double oldt2 = oldt;
        int n = 2;
        int i = 0;
    L3:
        int n2 = this.maximalIterationCount;
        if (i >= n2) goto L13;
        double t = stage(f, min, max, n);
        double delta = FastMath.abs(t - oldt2);
        double limit = FastMath.max(this.absoluteAccuracy, (this.relativeAccuracy * (FastMath.abs(oldt2) + FastMath.abs(t))) * 0.5d);
        if ((i + 1) < this.minimalIterationCount) goto L11;
        if (delta > limit) goto L11;
        setResult(t, i);
        return this.result;
    L11:
        double ratio = FastMath.min(4.0d, FastMath.pow(delta / limit, 0.5d / ((double) this.abscissas.length)));
        n = FastMath.max((int) (((double) n) * ratio), n + 1);
        oldt2 = t;
        i = i + 1;
        goto L3
    L13:
        throw new MaxIterationsExceededException(this.maximalIterationCount);
    }

    private double stage(UnivariateRealFunction f, double min, double max, int n) throws FunctionEvaluationException {
        double step = (max - min) / ((double) n);
        double halfStep = step / 2.0d;
        double midPoint = min + halfStep;
        double sum = 0.0d;
        int i = 0;
    L3:
        if (i >= n) goto L10;
        int j = 0;
    L6:
        if (j >= this.abscissas.length) goto L8;
        sum = sum + (this.weights[j] * f.value((this.abscissas[j] * halfStep) + midPoint));
        j = j + 1;
        LegendreGaussIntegrator this = this;
        goto L6
    L8:
        midPoint = midPoint + step;
        i = i + 1;
        goto L3
    L10:
        return halfStep * sum;
    }
}

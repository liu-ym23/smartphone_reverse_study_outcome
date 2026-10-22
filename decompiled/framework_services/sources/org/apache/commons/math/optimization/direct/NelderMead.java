package org.apache.commons.math.optimization.direct;

import java.util.Comparator;
import org.apache.commons.math.FunctionEvaluationException;
import org.apache.commons.math.optimization.OptimizationException;
import org.apache.commons.math.optimization.RealPointValuePair;

/* JADX INFO: loaded from: classes3.dex */
public class NelderMead extends DirectSearchOptimizer {
    private final double gamma;
    private final double khi;
    private final double rho;
    private final double sigma;

    public NelderMead() {
        this.rho = 1.0d;
        this.khi = 2.0d;
        this.gamma = 0.5d;
        this.sigma = 0.5d;
    }

    public NelderMead(double rho, double khi, double gamma, double sigma) {
        this.rho = rho;
        this.khi = khi;
        this.gamma = gamma;
        this.sigma = sigma;
    }

    @Override // org.apache.commons.math.optimization.direct.DirectSearchOptimizer
    protected void iterateSimplex(Comparator<RealPointValuePair> comparator) throws FunctionEvaluationException, OptimizationException {
        incrementIterationsCounter();
        int n = this.simplex.length - 1;
        RealPointValuePair best = this.simplex[0];
        RealPointValuePair secondBest = this.simplex[n - 1];
        RealPointValuePair worst = this.simplex[n];
        double[] xWorst = worst.getPointRef();
        double[] centroid = new double[n];
        int i = 0;
    L3:
        if (i >= n) goto L8;
        double[] x = this.simplex[i].getPointRef();
        int j = 0;
    L5:
        if (j >= n) goto L7;
        centroid[j] = centroid[j] + x[j];
        j = j + 1;
        goto L5
    L7:
        i = i + 1;
        goto L3
    L8:
        double scaling = 1.0d / ((double) n);
        int j2 = 0;
    L9:
        if (j2 >= n) goto L11;
        centroid[j2] = centroid[j2] * scaling;
        j2 = j2 + 1;
        goto L9
    L11:
        double[] xR = new double[n];
        int j3 = 0;
    L12:
        if (j3 >= n) goto L14;
        xR[j3] = centroid[j3] + (this.rho * (centroid[j3] - xWorst[j3]));
        j3 = j3 + 1;
        secondBest = secondBest;
        goto L12
    L14:
        RealPointValuePair secondBest2 = secondBest;
        RealPointValuePair reflected = new RealPointValuePair(xR, evaluate(xR), false);
        if (comparator.compare(best, reflected) > 0) goto L21;
        if (comparator.compare(reflected, secondBest2) >= 0) goto L21;
        replaceWorstPoint(reflected, comparator);
        return;
    L21:
        if (comparator.compare(reflected, best) >= 0) goto L31;
        double[] xE = new double[n];
        int j4 = 0;
    L23:
        if (j4 >= n) goto L25;
        double[] centroid2 = centroid;
        xE[j4] = centroid[j4] + (this.khi * (xR[j4] - centroid2[j4]));
        j4 = j4 + 1;
        xWorst = xWorst;
        centroid = centroid2;
        goto L23
    L25:
        RealPointValuePair expanded = new RealPointValuePair(xE, evaluate(xE), false);
        if (comparator.compare(expanded, reflected) >= 0) goto L28;
        replaceWorstPoint(expanded, comparator);
    L66:
        return;
    L28:
        replaceWorstPoint(reflected, comparator);
        goto L66
    L31:
        if (comparator.compare(reflected, worst) >= 0) goto L40;
        double[] xC = new double[n];
        int j5 = 0;
    L33:
        if (j5 >= n) goto L35;
        xC[j5] = centroid[j5] + (this.gamma * (xR[j5] - centroid[j5]));
        j5 = j5 + 1;
        goto L33
    L35:
        RealPointValuePair outContracted = new RealPointValuePair(xC, evaluate(xC), false);
        if (comparator.compare(outContracted, reflected) > 0) goto L47;
        replaceWorstPoint(outContracted, comparator);
        return;
    L47:
        double[] xSmallest = this.simplex[0].getPointRef();
        int i2 = 1;
    L49:
        if (i2 >= this.simplex.length) goto L54;
        double[] x2 = this.simplex[i2].getPoint();
        int j6 = 0;
    L51:
        if (j6 >= n) goto L53;
        x2[j6] = xSmallest[j6] + (this.sigma * (x2[j6] - xSmallest[j6]));
        j6 = j6 + 1;
        n = n;
        goto L51
    L53:
        this.simplex[i2] = new RealPointValuePair(x2, Double.NaN, false);
        i2 = i2 + 1;
        n = n;
        goto L49
    L54:
        evaluateSimplex(comparator);
        return;
    L40:
        double[] xC2 = new double[n];
        int j7 = 0;
    L41:
        if (j7 >= n) goto L43;
        xC2[j7] = centroid[j7] - (this.gamma * (centroid[j7] - xWorst[j7]));
        j7 = j7 + 1;
        goto L41
    L43:
        RealPointValuePair inContracted = new RealPointValuePair(xC2, evaluate(xC2), false);
        if (comparator.compare(inContracted, worst) >= 0) goto L47;
        replaceWorstPoint(inContracted, comparator);
    }
}

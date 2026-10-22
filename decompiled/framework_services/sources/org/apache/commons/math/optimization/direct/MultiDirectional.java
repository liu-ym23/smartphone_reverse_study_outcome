package org.apache.commons.math.optimization.direct;

import java.util.Comparator;
import org.apache.commons.math.FunctionEvaluationException;
import org.apache.commons.math.optimization.OptimizationException;
import org.apache.commons.math.optimization.RealConvergenceChecker;
import org.apache.commons.math.optimization.RealPointValuePair;

/* JADX INFO: loaded from: classes3.dex */
public class MultiDirectional extends DirectSearchOptimizer {
    private final double gamma;
    private final double khi;

    public MultiDirectional() {
        this.khi = 2.0d;
        this.gamma = 0.5d;
    }

    public MultiDirectional(double khi, double gamma) {
        this.khi = khi;
        this.gamma = gamma;
    }

    @Override // org.apache.commons.math.optimization.direct.DirectSearchOptimizer
    protected void iterateSimplex(Comparator<RealPointValuePair> comparator) throws FunctionEvaluationException, OptimizationException, IllegalArgumentException {
        RealConvergenceChecker checker = getConvergenceChecker();
    L3:
        incrementIterationsCounter();
        RealPointValuePair[] original = this.simplex;
        RealPointValuePair best = original[0];
        RealPointValuePair reflected = evaluateNewSimplex(original, 1.0d, comparator);
        if (comparator.compare(reflected, best) < 0) goto L5;
        RealPointValuePair contracted = evaluateNewSimplex(original, this.gamma, comparator);
        if (comparator.compare(contracted, best) < 0) goto L11;
        int iter = getIterations();
        boolean converged = true;
        int i = 0;
    L14:
        if (i >= this.simplex.length) goto L17;
        converged = converged & checker.converged(iter, original[i], this.simplex[i]);
        i = i + 1;
        goto L14
    L17:
        if (converged == false) goto L3;
        return;
    L11:
        return;
    L5:
        RealPointValuePair[] reflectedSimplex = this.simplex;
        RealPointValuePair expanded = evaluateNewSimplex(original, this.khi, comparator);
        if (comparator.compare(reflected, expanded) > 0) goto L25;
        this.simplex = reflectedSimplex;
        return;
    }

    private RealPointValuePair evaluateNewSimplex(RealPointValuePair[] original, double coeff, Comparator<RealPointValuePair> comparator) throws FunctionEvaluationException, OptimizationException {
        double[] xSmallest = original[0].getPointRef();
        int n = xSmallest.length;
        this.simplex = new RealPointValuePair[n + 1];
        this.simplex[0] = original[0];
        int i = 1;
    L3:
        if (i > n) goto L8;
        double[] xOriginal = original[i].getPointRef();
        double[] xTransformed = new double[n];
        int j = 0;
    L5:
        if (j >= n) goto L7;
        xTransformed[j] = xSmallest[j] + ((xSmallest[j] - xOriginal[j]) * coeff);
        j = j + 1;
        goto L5
    L7:
        this.simplex[i] = new RealPointValuePair(xTransformed, Double.NaN, false);
        i = i + 1;
        goto L3
    L8:
        evaluateSimplex(comparator);
        return this.simplex[0];
    }
}

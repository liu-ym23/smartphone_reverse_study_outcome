package org.apache.commons.math.optimization.direct;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import org.apache.commons.math.FunctionEvaluationException;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.MaxEvaluationsExceededException;
import org.apache.commons.math.MaxIterationsExceededException;
import org.apache.commons.math.analysis.MultivariateRealFunction;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.optimization.GoalType;
import org.apache.commons.math.optimization.MultivariateRealOptimizer;
import org.apache.commons.math.optimization.OptimizationException;
import org.apache.commons.math.optimization.RealConvergenceChecker;
import org.apache.commons.math.optimization.RealPointValuePair;
import org.apache.commons.math.optimization.SimpleScalarValueChecker;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DirectSearchOptimizer implements MultivariateRealOptimizer {
    private RealConvergenceChecker checker;
    private int evaluations;
    private MultivariateRealFunction f;
    private int iterations;
    private int maxEvaluations;
    private int maxIterations;
    protected RealPointValuePair[] simplex;
    private double[][] startConfiguration;

    protected abstract void iterateSimplex(Comparator<RealPointValuePair> r1) throws FunctionEvaluationException, OptimizationException, IllegalArgumentException;

    protected DirectSearchOptimizer() {
        setConvergenceChecker(new SimpleScalarValueChecker());
        setMaxIterations(Integer.MAX_VALUE);
        setMaxEvaluations(Integer.MAX_VALUE);
    }

    public void setStartConfiguration(double[] steps) throws IllegalArgumentException {
        int n = steps.length;
        this.startConfiguration = (double[][]) Array.newInstance(Double.TYPE, new int[]{n, n});
        int i = 0;
    L3:
        if (i >= n) goto L14;
        double[] vertexI = this.startConfiguration[i];
        int j = 0;
    L6:
        if (j >= (i + 1)) goto L12;
        if (steps[j] == 0.0d) goto L11;
        System.arraycopy(steps, 0, vertexI, 0, j + 1);
        j = j + 1;
        goto L6
    L11:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.EQUAL_VERTICES_IN_SIMPLEX, new Object[]{Integer.valueOf(j), Integer.valueOf(j + 1)});
    L12:
        i = i + 1;
        goto L3
    }

    public void setStartConfiguration(double[][] referenceSimplex) throws IllegalArgumentException {
        int n = referenceSimplex.length - 1;
        if (n < 0) goto L32;
        this.startConfiguration = (double[][]) Array.newInstance(Double.TYPE, new int[]{n, n});
        double[] ref0 = referenceSimplex[0];
        int i = 0;
    L6:
        if (i >= (n + 1)) goto L30;
        double[] refI = referenceSimplex[i];
        if (refI.length != n) goto L28;
        int j = 0;
    L10:
        if (j >= i) goto L22;
        double[] refJ = referenceSimplex[j];
        boolean allEquals = true;
        int k = 0;
    L12:
        if (k >= n) goto L17;
        if (refI[k] != refJ[k]) goto L15;
        k = k + 1;
        goto L12
    L15:
        allEquals = false;
    L17:
        if (allEquals == true) goto L20;
        j = j + 1;
        goto L10
    L20:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.EQUAL_VERTICES_IN_SIMPLEX, new Object[]{Integer.valueOf(i), Integer.valueOf(j)});
    L22:
        if (i <= 0) goto L26;
        double[] confI = this.startConfiguration[i - 1];
        int k2 = 0;
    L24:
        if (k2 >= n) goto L26;
        confI[k2] = refI[k2] - ref0[k2];
        k2 = k2 + 1;
    L26:
        i = i + 1;
        goto L6
    L28:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.DIMENSIONS_MISMATCH_SIMPLE, new Object[]{Integer.valueOf(refI.length), Integer.valueOf(n)});
    L30:
        return;
    L32:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.SIMPLEX_NEED_ONE_POINT, new Object[0]);
    }

    @Override // org.apache.commons.math.optimization.MultivariateRealOptimizer
    public void setMaxIterations(int maxIterations) {
        this.maxIterations = maxIterations;
    }

    @Override // org.apache.commons.math.optimization.MultivariateRealOptimizer
    public int getMaxIterations() {
        return this.maxIterations;
    }

    @Override // org.apache.commons.math.optimization.MultivariateRealOptimizer
    public void setMaxEvaluations(int maxEvaluations) {
        this.maxEvaluations = maxEvaluations;
    }

    @Override // org.apache.commons.math.optimization.MultivariateRealOptimizer
    public int getMaxEvaluations() {
        return this.maxEvaluations;
    }

    @Override // org.apache.commons.math.optimization.MultivariateRealOptimizer
    public int getIterations() {
        return this.iterations;
    }

    @Override // org.apache.commons.math.optimization.MultivariateRealOptimizer
    public int getEvaluations() {
        return this.evaluations;
    }

    @Override // org.apache.commons.math.optimization.MultivariateRealOptimizer
    public void setConvergenceChecker(RealConvergenceChecker convergenceChecker) {
        this.checker = convergenceChecker;
    }

    @Override // org.apache.commons.math.optimization.MultivariateRealOptimizer
    public RealConvergenceChecker getConvergenceChecker() {
        return this.checker;
    }

    @Override // org.apache.commons.math.optimization.MultivariateRealOptimizer
    public RealPointValuePair optimize(MultivariateRealFunction function, final GoalType goalType, double[] startPoint) throws FunctionEvaluationException, OptimizationException, IllegalArgumentException {
        if (this.startConfiguration != null) goto L5;
    L6:
        double[] unit = new double[startPoint.length];
        Arrays.fill(unit, 1.0d);
        setStartConfiguration(unit);
    L7:
        this.f = function;
        Comparator<RealPointValuePair> comparator = new AnonymousClass1(this, goalType);
        this.iterations = 0;
        this.evaluations = 0;
        buildSimplex(startPoint);
        evaluateSimplex(comparator);
        RealPointValuePair[] previous = new RealPointValuePair[this.simplex.length];
    L9:
        if (this.iterations <= 0) goto L18;
        boolean converged = true;
        int i = 0;
    L12:
        if (i >= this.simplex.length) goto L15;
        converged = converged & this.checker.converged(this.iterations, previous[i], this.simplex[i]);
        i = i + 1;
        goto L12
    L15:
        if (converged == false) goto L18;
        return this.simplex[0];
    L18:
        System.arraycopy(this.simplex, 0, previous, 0, this.simplex.length);
        iterateSimplex(comparator);
        goto L9
    L5:
        if (this.startConfiguration.length == startPoint.length) goto L7;
        goto L6
    }

    protected void incrementIterationsCounter() throws OptimizationException {
        int r0 = this.iterations + 1;
        this.iterations = r0;
        if (r0 > this.maxIterations) goto L6;
        return;
    L6:
        throw new OptimizationException(new MaxIterationsExceededException(this.maxIterations));
    }

    protected double evaluate(double[] x) throws FunctionEvaluationException, IllegalArgumentException {
        int r0 = this.evaluations + 1;
        this.evaluations = r0;
        if (r0 > this.maxEvaluations) goto L7;
        return this.f.value(x);
    L7:
        throw new FunctionEvaluationException(new MaxEvaluationsExceededException(this.maxEvaluations), x);
    }

    private void buildSimplex(double[] startPoint) throws IllegalArgumentException {
        int n = startPoint.length;
        if (n != this.startConfiguration.length) goto L13;
        this.simplex = new RealPointValuePair[n + 1];
        this.simplex[0] = new RealPointValuePair(startPoint, Double.NaN);
        int i = 0;
    L5:
        if (i >= n) goto L11;
        double[] confI = this.startConfiguration[i];
        double[] vertexI = new double[n];
        int k = 0;
    L7:
        if (k >= n) goto L9;
        vertexI[k] = startPoint[k] + confI[k];
        k = k + 1;
        goto L7
    L9:
        this.simplex[i + 1] = new RealPointValuePair(vertexI, Double.NaN);
        i = i + 1;
        goto L5
    L11:
        return;
    L13:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.DIMENSIONS_MISMATCH_SIMPLE, new Object[]{Integer.valueOf(n), Integer.valueOf(this.startConfiguration.length)});
    }

    protected void evaluateSimplex(Comparator<RealPointValuePair> comparator) throws FunctionEvaluationException, OptimizationException {
        int i = 0;
    L4:
        if (i >= this.simplex.length) goto L9;
        RealPointValuePair vertex = this.simplex[i];
        double[] point = vertex.getPointRef();
        if (Double.isNaN(vertex.getValue()) == false) goto L8;
        this.simplex[i] = new RealPointValuePair(point, evaluate(point), false);
    L8:
        i = i + 1;
        goto L4
    L9:
        Arrays.sort(this.simplex, comparator);
    }

    protected void replaceWorstPoint(RealPointValuePair pointValuePair, Comparator<RealPointValuePair> comparator) {
        int n = this.simplex.length - 1;
        int i = 0;
    L3:
        if (i >= n) goto L8;
        if (comparator.compare(this.simplex[i], pointValuePair) <= 0) goto L7;
        RealPointValuePair tmp = this.simplex[i];
        this.simplex[i] = pointValuePair;
        pointValuePair = tmp;
    L7:
        i = i + 1;
        goto L3
    L8:
        this.simplex[n] = pointValuePair;
    }
}

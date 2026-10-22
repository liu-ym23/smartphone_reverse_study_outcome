package org.apache.commons.math.optimization;

import org.apache.commons.math.ConvergenceException;
import org.apache.commons.math.FunctionEvaluationException;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.analysis.UnivariateRealFunction;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.random.RandomGenerator;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class MultiStartUnivariateRealOptimizer implements UnivariateRealOptimizer {
    private static final long serialVersionUID = 5983375963110961019L;
    private RandomGenerator generator;
    private int maxEvaluations;
    private int maxIterations;
    private double[] optima;
    private double[] optimaValues;
    private final UnivariateRealOptimizer optimizer;
    private int starts;
    private int totalEvaluations;
    private int totalIterations;

    public MultiStartUnivariateRealOptimizer(UnivariateRealOptimizer optimizer, int starts, RandomGenerator generator) {
        this.optimizer = optimizer;
        this.totalIterations = 0;
        this.starts = starts;
        this.generator = generator;
        this.optima = null;
        setMaximalIterationCount(Integer.MAX_VALUE);
        setMaxEvaluations(Integer.MAX_VALUE);
    }

    @Override // org.apache.commons.math.optimization.UnivariateRealOptimizer
    public double getFunctionValue() {
        return this.optimaValues[0];
    }

    @Override // org.apache.commons.math.optimization.UnivariateRealOptimizer
    public double getResult() {
        return this.optima[0];
    }

    @Override // org.apache.commons.math.ConvergingAlgorithm
    public double getAbsoluteAccuracy() {
        return this.optimizer.getAbsoluteAccuracy();
    }

    @Override // org.apache.commons.math.ConvergingAlgorithm
    public int getIterationCount() {
        return this.totalIterations;
    }

    @Override // org.apache.commons.math.ConvergingAlgorithm
    public int getMaximalIterationCount() {
        return this.maxIterations;
    }

    @Override // org.apache.commons.math.optimization.UnivariateRealOptimizer
    public int getMaxEvaluations() {
        return this.maxEvaluations;
    }

    @Override // org.apache.commons.math.optimization.UnivariateRealOptimizer
    public int getEvaluations() {
        return this.totalEvaluations;
    }

    @Override // org.apache.commons.math.ConvergingAlgorithm
    public double getRelativeAccuracy() {
        return this.optimizer.getRelativeAccuracy();
    }

    @Override // org.apache.commons.math.ConvergingAlgorithm
    public void resetAbsoluteAccuracy() {
        this.optimizer.resetAbsoluteAccuracy();
    }

    @Override // org.apache.commons.math.ConvergingAlgorithm
    public void resetMaximalIterationCount() {
        this.optimizer.resetMaximalIterationCount();
    }

    @Override // org.apache.commons.math.ConvergingAlgorithm
    public void resetRelativeAccuracy() {
        this.optimizer.resetRelativeAccuracy();
    }

    @Override // org.apache.commons.math.ConvergingAlgorithm
    public void setAbsoluteAccuracy(double accuracy) {
        this.optimizer.setAbsoluteAccuracy(accuracy);
    }

    @Override // org.apache.commons.math.ConvergingAlgorithm
    public void setMaximalIterationCount(int count) {
        this.maxIterations = count;
    }

    @Override // org.apache.commons.math.optimization.UnivariateRealOptimizer
    public void setMaxEvaluations(int maxEvaluations) {
        this.maxEvaluations = maxEvaluations;
    }

    @Override // org.apache.commons.math.ConvergingAlgorithm
    public void setRelativeAccuracy(double accuracy) {
        this.optimizer.setRelativeAccuracy(accuracy);
    }

    public double[] getOptima() throws IllegalStateException {
        if (this.optima == null) goto L7;
        return (double[]) this.optima.clone();
    L7:
        throw MathRuntimeException.createIllegalStateException(LocalizedFormats.NO_OPTIMUM_COMPUTED_YET, new Object[0]);
    }

    public double[] getOptimaValues() throws IllegalStateException {
        if (this.optimaValues == null) goto L7;
        return (double[]) this.optimaValues.clone();
    L7:
        throw MathRuntimeException.createIllegalStateException(LocalizedFormats.NO_OPTIMUM_COMPUTED_YET, new Object[0]);
    }

    @Override // org.apache.commons.math.optimization.UnivariateRealOptimizer
    public double optimize(UnivariateRealFunction f, GoalType goalType, double min, double max) throws ConvergenceException, FunctionEvaluationException {
        this.optima = new double[this.starts];
        this.optimaValues = new double[this.starts];
        int i = 0;
        this.totalIterations = 0;
        this.totalEvaluations = 0;
        int i2 = 0;
    L4:
        if (i2 >= this.starts) goto L28;
        this.optimizer.setMaximalIterationCount(this.maxIterations - this.totalIterations);     // Catch: ConvergenceException -> L21 FunctionEvaluationException -> L23
        this.optimizer.setMaxEvaluations(this.maxEvaluations - this.totalEvaluations);     // Catch: ConvergenceException -> L21 FunctionEvaluationException -> L23
        if (i2 != 0) goto L8;
        double r2 = min;
    L9:
        double bound1 = r2;
        if (i2 != 0) goto L12;
        double bound2 = max;
    L74:
        this.optima[i2] = this.optimizer.optimize(f, goalType, FastMath.min(bound1, bound2), FastMath.max(bound1, bound2));     // Catch: ConvergenceException -> L17 FunctionEvaluationException -> L19
        this.optimaValues[i2] = this.optimizer.getFunctionValue();     // Catch: ConvergenceException -> L17 FunctionEvaluationException -> L19
    L27:
        this.totalIterations += this.optimizer.getIterationCount();
        this.totalEvaluations += this.optimizer.getEvaluations();
        i2 = i2 + 1;
        goto L4
    L12:
        bound2 = min + (this.generator.nextDouble() * (max - min));     // Catch: ConvergenceException -> L21 FunctionEvaluationException -> L23
        goto L74
    L8:
        r2 = min + (this.generator.nextDouble() * (max - min));     // Catch: ConvergenceException -> L21 FunctionEvaluationException -> L23
        goto L9
    L25:
        this.optima[i2] = Double.NaN;
        this.optimaValues[i2] = Double.NaN;
    L26:
        this.optima[i2] = Double.NaN;
        this.optimaValues[i2] = Double.NaN;
        goto L27
    L28:
        int lastNaN = this.optima.length;
        int i3 = 0;
    L29:
        if (i3 >= lastNaN) goto L34;
        if (Double.isNaN(this.optima[i3]) == false) goto L33;
        int lastNaN2 = lastNaN - 1;
        this.optima[i3] = this.optima[lastNaN2];
        this.optima[lastNaN2 + 1] = Double.NaN;
        lastNaN = lastNaN2 - 1;
        this.optimaValues[i3] = this.optimaValues[lastNaN];
        this.optimaValues[lastNaN + 1] = Double.NaN;
    L33:
        i3 = i3 + 1;
        goto L29
    L34:
        double r3 = this.optima[0];
        double currY = this.optimaValues[0];
        int j = 1;
    L35:
        if (j >= lastNaN) goto L66;
        double prevY = currY;
        double currX = this.optima[j];
        currY = this.optimaValues[j];
        if (goalType != GoalType.MAXIMIZE) goto L39;
        int r8 = 1;
    L41:
        if (currY >= prevY) goto L43;
        int r13 = 1;
    L45:
        if ((r8 ^ r13) == 0) goto L64;
        int i4 = j - 1;
        double mIX = this.optima[i4];
        double mIY = this.optimaValues[i4];
    L47:
        if (i4 < 0) goto L62;
        i = i;
        if (goalType != GoalType.MAXIMIZE) goto L51;
        int r9 = 1;
    L53:
        if (currY >= mIY) goto L55;
        int r18 = 1;
    L57:
        if ((r9 ^ r18) == 0) goto L63;
        this.optima[i4 + 1] = mIX;
        this.optimaValues[i4 + 1] = mIY;
        i4 = i4 - 1;
        if (i4 != 0) goto L60;
        mIX = Double.NaN;
        mIY = Double.NaN;
        goto L47
    L60:
        mIX = this.optima[i4];
        mIY = this.optimaValues[i4];
    L63:
        this.optima[i4 + 1] = currX;
        this.optimaValues[i4 + 1] = currY;
        double currX2 = this.optima[j];
        currY = this.optimaValues[j];
    L65:
        j = j + 1;
        i = i;
        goto L35
    L55:
        r18 = i;
        goto L57
    L51:
        r9 = i;
        goto L53
    L62:
        i = i;
        goto L63
    L64:
        i = i;
        goto L65
    L43:
        r13 = i;
        goto L45
    L39:
        r8 = i;
        goto L41
    L66:
        int r17 = i;
        if (Double.isNaN(this.optima[r17]) == true) goto L71;
        return this.optima[r17];
    L71:
        throw new OptimizationException(LocalizedFormats.NO_CONVERGENCE_WITH_ANY_START_POINT, new Object[]{Integer.valueOf(this.starts)});
    }

    @Override // org.apache.commons.math.optimization.UnivariateRealOptimizer
    public double optimize(UnivariateRealFunction f, GoalType goalType, double min, double max, double startValue) throws ConvergenceException, FunctionEvaluationException {
        return optimize(f, goalType, min, max);
    }
}

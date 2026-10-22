package org.apache.commons.math.optimization.linear;

import java.util.Collection;
import org.apache.commons.math.MaxIterationsExceededException;
import org.apache.commons.math.optimization.GoalType;
import org.apache.commons.math.optimization.OptimizationException;
import org.apache.commons.math.optimization.RealPointValuePair;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractLinearOptimizer implements LinearOptimizer {
    public static final int DEFAULT_MAX_ITERATIONS = 100;
    protected LinearObjectiveFunction function;
    protected GoalType goal;
    private int iterations;
    protected Collection<LinearConstraint> linearConstraints;
    private int maxIterations;
    protected boolean nonNegative;

    protected abstract RealPointValuePair doOptimize() throws OptimizationException;

    protected AbstractLinearOptimizer() {
        setMaxIterations(100);
    }

    @Override // org.apache.commons.math.optimization.linear.LinearOptimizer
    public void setMaxIterations(int maxIterations) {
        this.maxIterations = maxIterations;
    }

    @Override // org.apache.commons.math.optimization.linear.LinearOptimizer
    public int getMaxIterations() {
        return this.maxIterations;
    }

    @Override // org.apache.commons.math.optimization.linear.LinearOptimizer
    public int getIterations() {
        return this.iterations;
    }

    protected void incrementIterationsCounter() throws OptimizationException {
        int r0 = this.iterations + 1;
        this.iterations = r0;
        if (r0 > this.maxIterations) goto L6;
        return;
    L6:
        throw new OptimizationException(new MaxIterationsExceededException(this.maxIterations));
    }

    @Override // org.apache.commons.math.optimization.linear.LinearOptimizer
    public RealPointValuePair optimize(LinearObjectiveFunction f, Collection<LinearConstraint> constraints, GoalType goalType, boolean restrictToNonNegative) throws OptimizationException {
        this.function = f;
        this.linearConstraints = constraints;
        this.goal = goalType;
        this.nonNegative = restrictToNonNegative;
        this.iterations = 0;
        return doOptimize();
    }
}

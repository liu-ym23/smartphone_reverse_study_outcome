package org.apache.commons.math.optimization.general;

import java.lang.reflect.Array;
import org.apache.commons.math.FunctionEvaluationException;
import org.apache.commons.math.MaxEvaluationsExceededException;
import org.apache.commons.math.MaxIterationsExceededException;
import org.apache.commons.math.analysis.DifferentiableMultivariateVectorialFunction;
import org.apache.commons.math.analysis.MultivariateMatrixFunction;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.linear.InvalidMatrixException;
import org.apache.commons.math.linear.LUDecompositionImpl;
import org.apache.commons.math.linear.MatrixUtils;
import org.apache.commons.math.linear.RealMatrix;
import org.apache.commons.math.optimization.DifferentiableMultivariateVectorialOptimizer;
import org.apache.commons.math.optimization.OptimizationException;
import org.apache.commons.math.optimization.SimpleVectorialValueChecker;
import org.apache.commons.math.optimization.VectorialConvergenceChecker;
import org.apache.commons.math.optimization.VectorialPointValuePair;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractLeastSquaresOptimizer implements DifferentiableMultivariateVectorialOptimizer {
    public static final int DEFAULT_MAX_ITERATIONS = 100;
    protected VectorialConvergenceChecker checker;
    protected int cols;
    protected double cost;
    private DifferentiableMultivariateVectorialFunction function;
    private int iterations;
    private MultivariateMatrixFunction jF;
    protected double[][] jacobian;
    private int jacobianEvaluations;
    private int maxEvaluations;
    private int maxIterations;
    protected double[] objective;
    private int objectiveEvaluations;
    protected double[] point;
    protected double[] residuals;
    protected double[] residualsWeights;
    protected int rows;
    protected double[] targetValues;
    protected double[][] wjacobian;
    protected double[] wresiduals;

    protected abstract VectorialPointValuePair doOptimize() throws FunctionEvaluationException, OptimizationException, IllegalArgumentException;

    protected AbstractLeastSquaresOptimizer() {
        setConvergenceChecker(new SimpleVectorialValueChecker());
        setMaxIterations(100);
        setMaxEvaluations(Integer.MAX_VALUE);
    }

    @Override // org.apache.commons.math.optimization.DifferentiableMultivariateVectorialOptimizer
    public void setMaxIterations(int maxIterations) {
        this.maxIterations = maxIterations;
    }

    @Override // org.apache.commons.math.optimization.DifferentiableMultivariateVectorialOptimizer
    public int getMaxIterations() {
        return this.maxIterations;
    }

    @Override // org.apache.commons.math.optimization.DifferentiableMultivariateVectorialOptimizer
    public int getIterations() {
        return this.iterations;
    }

    @Override // org.apache.commons.math.optimization.DifferentiableMultivariateVectorialOptimizer
    public void setMaxEvaluations(int maxEvaluations) {
        this.maxEvaluations = maxEvaluations;
    }

    @Override // org.apache.commons.math.optimization.DifferentiableMultivariateVectorialOptimizer
    public int getMaxEvaluations() {
        return this.maxEvaluations;
    }

    @Override // org.apache.commons.math.optimization.DifferentiableMultivariateVectorialOptimizer
    public int getEvaluations() {
        return this.objectiveEvaluations;
    }

    @Override // org.apache.commons.math.optimization.DifferentiableMultivariateVectorialOptimizer
    public int getJacobianEvaluations() {
        return this.jacobianEvaluations;
    }

    @Override // org.apache.commons.math.optimization.DifferentiableMultivariateVectorialOptimizer
    public void setConvergenceChecker(VectorialConvergenceChecker convergenceChecker) {
        this.checker = convergenceChecker;
    }

    @Override // org.apache.commons.math.optimization.DifferentiableMultivariateVectorialOptimizer
    public VectorialConvergenceChecker getConvergenceChecker() {
        return this.checker;
    }

    protected void incrementIterationsCounter() throws OptimizationException {
        int r0 = this.iterations + 1;
        this.iterations = r0;
        if (r0 > this.maxIterations) goto L6;
        return;
    L6:
        throw new OptimizationException(new MaxIterationsExceededException(this.maxIterations));
    }

    protected void updateJacobian() throws FunctionEvaluationException {
        this.jacobianEvaluations++;
        this.jacobian = this.jF.value(this.point);
        if (this.jacobian.length != this.rows) goto L15;
        int i = 0;
    L6:
        if (i >= this.rows) goto L13;
        double[] ji = this.jacobian[i];
        double wi = FastMath.sqrt(this.residualsWeights[i]);
        int j = 0;
    L9:
        if (j >= this.cols) goto L11;
        ji[j] = ji[j] * (-1.0d);
        this.wjacobian[i][j] = ji[j] * wi;
        j = j + 1;
        goto L9
    L11:
        i = i + 1;
        goto L6
    L13:
        return;
    L15:
        throw new FunctionEvaluationException(this.point, LocalizedFormats.DIMENSIONS_MISMATCH_SIMPLE, new Object[]{Integer.valueOf(this.jacobian.length), Integer.valueOf(this.rows)});
    }

    protected void updateResidualsAndCost() throws FunctionEvaluationException {
        int r0 = this.objectiveEvaluations + 1;
        this.objectiveEvaluations = r0;
        if (r0 > this.maxEvaluations) goto L15;
        this.objective = this.function.value(this.point);
        if (this.objective.length != this.rows) goto L13;
        this.cost = 0.0d;
        int index = 0;
        int i = 0;
    L8:
        if (i >= this.rows) goto L10;
        double residual = this.targetValues[i] - this.objective[i];
        this.residuals[i] = residual;
        this.wresiduals[i] = FastMath.sqrt(this.residualsWeights[i]) * residual;
        this.cost += (this.residualsWeights[i] * residual) * residual;
        index = index + this.cols;
        i = i + 1;
        goto L8
    L10:
        this.cost = FastMath.sqrt(this.cost);
        return;
    L13:
        throw new FunctionEvaluationException(this.point, LocalizedFormats.DIMENSIONS_MISMATCH_SIMPLE, new Object[]{Integer.valueOf(this.objective.length), Integer.valueOf(this.rows)});
    L15:
        throw new FunctionEvaluationException(new MaxEvaluationsExceededException(this.maxEvaluations), this.point);
    }

    public double getRMS() {
        return FastMath.sqrt(getChiSquare() / ((double) this.rows));
    }

    public double getChiSquare() {
        return this.cost * this.cost;
    }

    public double[][] getCovariances() throws FunctionEvaluationException, OptimizationException {
        updateJacobian();
        double[][] jTj = (double[][]) Array.newInstance(Double.TYPE, new int[]{this.cols, this.cols});
        int i = 0;
    L4:
        if (i >= this.cols) goto L20;
        int j = i;
    L7:
        if (j >= this.cols) goto L13;
        double sum = 0.0d;
        int k = 0;
    L10:
        if (k >= this.rows) goto L12;
        sum = sum + (this.wjacobian[k][i] * this.wjacobian[k][j]);
        k = k + 1;
        goto L10
    L12:
        jTj[i][j] = sum;
        jTj[j][i] = sum;
        j = j + 1;
        goto L7
    L13:
        i = i + 1;
        goto L4
    L20:
        RealMatrix inverse = new LUDecompositionImpl(MatrixUtils.createRealMatrix(jTj)).getSolver().getInverse();     // Catch: InvalidMatrixException -> L17
        return inverse.getData();
    L19:
        throw new OptimizationException(LocalizedFormats.UNABLE_TO_COMPUTE_COVARIANCE_SINGULAR_PROBLEM, new Object[0]);
    }

    public double[] guessParametersErrors() throws FunctionEvaluationException, OptimizationException {
        if (this.rows <= this.cols) goto L11;
        double[] errors = new double[this.cols];
        double c = FastMath.sqrt(getChiSquare() / ((double) (this.rows - this.cols)));
        double[][] covar = getCovariances();
        int i = 0;
    L6:
        if (i >= errors.length) goto L9;
        errors[i] = FastMath.sqrt(covar[i][i]) * c;
        i = i + 1;
        goto L6
    L9:
        return errors;
    L11:
        throw new OptimizationException(LocalizedFormats.NO_DEGREES_OF_FREEDOM, new Object[]{Integer.valueOf(this.rows), Integer.valueOf(this.cols)});
    }

    @Override // org.apache.commons.math.optimization.DifferentiableMultivariateVectorialOptimizer
    public VectorialPointValuePair optimize(DifferentiableMultivariateVectorialFunction f, double[] target, double[] weights, double[] startPoint) throws FunctionEvaluationException, OptimizationException, IllegalArgumentException {
        if (target.length != weights.length) goto L7;
        this.iterations = 0;
        this.objectiveEvaluations = 0;
        this.jacobianEvaluations = 0;
        this.function = f;
        this.jF = f.jacobian();
        this.targetValues = (double[]) target.clone();
        this.residualsWeights = (double[]) weights.clone();
        this.point = (double[]) startPoint.clone();
        this.residuals = new double[target.length];
        this.rows = target.length;
        this.cols = this.point.length;
        this.jacobian = (double[][]) Array.newInstance(Double.TYPE, new int[]{this.rows, this.cols});
        this.wjacobian = (double[][]) Array.newInstance(Double.TYPE, new int[]{this.rows, this.cols});
        this.wresiduals = new double[this.rows];
        this.cost = Double.POSITIVE_INFINITY;
        return doOptimize();
    L7:
        throw new OptimizationException(LocalizedFormats.DIMENSIONS_MISMATCH_SIMPLE, new Object[]{Integer.valueOf(target.length), Integer.valueOf(weights.length)});
    }
}

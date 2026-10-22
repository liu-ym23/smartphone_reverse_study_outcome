package org.apache.commons.math.estimation;

import java.lang.reflect.Array;
import java.util.Arrays;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.linear.InvalidMatrixException;
import org.apache.commons.math.linear.LUDecompositionImpl;
import org.apache.commons.math.linear.MatrixUtils;
import org.apache.commons.math.linear.RealMatrix;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public abstract class AbstractEstimator implements Estimator {
    public static final int DEFAULT_MAX_COST_EVALUATIONS = 100;
    protected int cols;
    protected double cost;
    private int costEvaluations;
    protected double[] jacobian;
    private int jacobianEvaluations;
    private int maxCostEval;
    protected WeightedMeasurement[] measurements;
    protected EstimatedParameter[] parameters;
    protected double[] residuals;
    protected int rows;

    @Override // org.apache.commons.math.estimation.Estimator
    public abstract void estimate(EstimationProblem r1) throws EstimationException;

    protected AbstractEstimator() {
        setMaxCostEval(100);
    }

    public final void setMaxCostEval(int maxCostEval) {
        this.maxCostEval = maxCostEval;
    }

    public final int getCostEvaluations() {
        return this.costEvaluations;
    }

    public final int getJacobianEvaluations() {
        return this.jacobianEvaluations;
    }

    protected void updateJacobian() {
        incrementJacobianEvaluationsCounter();
        Arrays.fill(this.jacobian, 0.0d);
        int index = 0;
        int i = 0;
    L4:
        if (i >= this.rows) goto L11;
        WeightedMeasurement wm = this.measurements[i];
        double factor = -FastMath.sqrt(wm.getWeight());
        int j = 0;
    L7:
        if (j >= this.cols) goto L9;
        this.jacobian[index] = wm.getPartial(this.parameters[j]) * factor;
        j = j + 1;
        index = index + 1;
        goto L7
    L9:
        i = i + 1;
        goto L4
    }

    protected final void incrementJacobianEvaluationsCounter() {
        this.jacobianEvaluations++;
    }

    protected void updateResidualsAndCost() throws EstimationException {
        int r0 = this.costEvaluations + 1;
        this.costEvaluations = r0;
        if (r0 > this.maxCostEval) goto L11;
        this.cost = 0.0d;
        int index = 0;
        int i = 0;
    L6:
        if (i >= this.rows) goto L8;
        WeightedMeasurement wm = this.measurements[i];
        double residual = wm.getResidual();
        this.residuals[i] = FastMath.sqrt(wm.getWeight()) * residual;
        this.cost += (wm.getWeight() * residual) * residual;
        i = i + 1;
        index = index + this.cols;
        goto L6
    L8:
        this.cost = FastMath.sqrt(this.cost);
        return;
    L11:
        throw new EstimationException(LocalizedFormats.MAX_EVALUATIONS_EXCEEDED, new Object[]{Integer.valueOf(this.maxCostEval)});
    }

    @Override // org.apache.commons.math.estimation.Estimator
    public double getRMS(EstimationProblem problem) {
        WeightedMeasurement[] wm = problem.getMeasurements();
        double criterion = 0.0d;
        int i = 0;
    L4:
        if (i >= wm.length) goto L6;
        double residual = wm[i].getResidual();
        criterion = criterion + ((wm[i].getWeight() * residual) * residual);
        i = i + 1;
        goto L4
    L6:
        int i2 = wm.length;
        return FastMath.sqrt(criterion / ((double) i2));
    }

    public double getChiSquare(EstimationProblem problem) {
        WeightedMeasurement[] wm = problem.getMeasurements();
        double chiSquare = 0.0d;
        int i = 0;
    L4:
        if (i >= wm.length) goto L7;
        double residual = wm[i].getResidual();
        chiSquare = chiSquare + ((residual * residual) / wm[i].getWeight());
        i = i + 1;
        goto L4
    L7:
        return chiSquare;
    }

    @Override // org.apache.commons.math.estimation.Estimator
    public double[][] getCovariances(EstimationProblem problem) throws EstimationException {
        updateJacobian();
        int n = problem.getMeasurements().length;
        int m = problem.getUnboundParameters().length;
        int max = m * n;
        double[][] jTj = (double[][]) Array.newInstance(Double.TYPE, new int[]{m, m});
        int i = 0;
    L3:
        if (i >= m) goto L17;
        int j = i;
    L5:
        if (j >= m) goto L10;
        double sum = 0.0d;
        int k = 0;
    L7:
        if (k >= max) goto L9;
        sum = sum + (this.jacobian[k + i] * this.jacobian[k + j]);
        k = k + m;
        goto L7
    L9:
        jTj[i][j] = sum;
        jTj[j][i] = sum;
        j = j + 1;
        goto L5
    L10:
        i = i + 1;
        goto L3
    L17:
        RealMatrix inverse = new LUDecompositionImpl(MatrixUtils.createRealMatrix(jTj)).getSolver().getInverse();     // Catch: InvalidMatrixException -> L14
        return inverse.getData();
    L16:
        throw new EstimationException(LocalizedFormats.UNABLE_TO_COMPUTE_COVARIANCE_SINGULAR_PROBLEM, new Object[0]);
    }

    @Override // org.apache.commons.math.estimation.Estimator
    public double[] guessParametersErrors(EstimationProblem problem) throws EstimationException {
        int m = problem.getMeasurements().length;
        int p = problem.getUnboundParameters().length;
        if (m <= p) goto L11;
        double[] errors = new double[problem.getUnboundParameters().length];
        double c = FastMath.sqrt(getChiSquare(problem) / ((double) (m - p)));
        double[][] covar = getCovariances(problem);
        int i = 0;
    L6:
        if (i >= errors.length) goto L9;
        errors[i] = FastMath.sqrt(covar[i][i]) * c;
        i = i + 1;
        goto L6
    L9:
        return errors;
    L11:
        throw new EstimationException(LocalizedFormats.NO_DEGREES_OF_FREEDOM, new Object[]{Integer.valueOf(m), Integer.valueOf(p)});
    }

    protected void initializeEstimate(EstimationProblem problem) {
        this.costEvaluations = 0;
        this.jacobianEvaluations = 0;
        this.measurements = problem.getMeasurements();
        this.parameters = problem.getUnboundParameters();
        this.rows = this.measurements.length;
        this.cols = this.parameters.length;
        this.jacobian = new double[this.rows * this.cols];
        this.residuals = new double[this.rows];
        this.cost = Double.POSITIVE_INFINITY;
    }
}

package org.apache.commons.math.estimation;

import java.io.Serializable;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.linear.ArrayRealVector;
import org.apache.commons.math.linear.InvalidMatrixException;
import org.apache.commons.math.linear.LUDecompositionImpl;
import org.apache.commons.math.linear.MatrixUtils;
import org.apache.commons.math.linear.RealMatrix;
import org.apache.commons.math.linear.RealVector;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class GaussNewtonEstimator extends AbstractEstimator implements Serializable {
    private static final double DEFAULT_CONVERGENCE = 1.0E-6d;
    private static final double DEFAULT_STEADY_STATE_THRESHOLD = 1.0E-6d;
    private static final long serialVersionUID = 5485001826076289109L;
    private double convergence;
    private double steadyStateThreshold;

    public GaussNewtonEstimator() {
        this.steadyStateThreshold = 1.0E-6d;
        this.convergence = 1.0E-6d;
    }

    public GaussNewtonEstimator(int maxCostEval, double convergence, double steadyStateThreshold) {
        setMaxCostEval(maxCostEval);
        this.steadyStateThreshold = steadyStateThreshold;
        this.convergence = convergence;
    }

    public void setConvergence(double convergence) {
        this.convergence = convergence;
    }

    public void setSteadyStateThreshold(double steadyStateThreshold) {
        this.steadyStateThreshold = steadyStateThreshold;
    }

    @Override // org.apache.commons.math.estimation.AbstractEstimator, org.apache.commons.math.estimation.Estimator
    public void estimate(EstimationProblem problem) throws EstimationException {
        initializeEstimate(problem);
        double[] grad = new double[this.parameters.length];
        ArrayRealVector bDecrement = new ArrayRealVector(this.parameters.length);
        double[] bDecrementData = bDecrement.getDataRef();
        RealMatrix wGradGradT = MatrixUtils.createRealMatrix(this.parameters.length, this.parameters.length);
        double previous = Double.POSITIVE_INFINITY;
    L3:
        incrementJacobianEvaluationsCounter();
        RealVector b = new ArrayRealVector(this.parameters.length);
        RealMatrix a = MatrixUtils.createRealMatrix(this.parameters.length, this.parameters.length);
        RealVector b2 = b;
        int i = 0;
        RealMatrix a2 = a;
    L5:
        if (i >= this.measurements.length) goto L23;
        if (this.measurements[i].isIgnored() == true) goto L21;
        double weight = this.measurements[i].getWeight();
        double residual = this.measurements[i].getResidual();
        int j = 0;
    L10:
        if (j >= this.parameters.length) goto L12;
        grad[j] = this.measurements[i].getPartial(this.parameters[j]);
        bDecrementData[j] = (weight * residual) * grad[j];
        j = j + 1;
        i = i;
        goto L10
    L12:
        int i2 = i;
        int k = 0;
    L14:
        if (k >= this.parameters.length) goto L20;
        double gk = grad[k];
        double[] grad2 = grad;
        int l = 0;
    L16:
        double[] bDecrementData2 = bDecrementData;
        if (l >= this.parameters.length) goto L19;
        double previous2 = previous;
        double previous3 = (weight * gk) * grad2[l];
        wGradGradT.setEntry(k, l, previous3);
        l = l + 1;
        bDecrementData = bDecrementData2;
        previous = previous2;
        goto L16
    L19:
        k = k + 1;
        bDecrementData = bDecrementData2;
        grad = grad2;
        goto L14
    L20:
        double[] grad3 = grad;
        double[] bDecrementData3 = bDecrementData;
        double previous4 = previous;
        a2 = a2.add(wGradGradT);
        b2 = b2.add(bDecrement);
    L22:
        i = i2 + 1;
        bDecrementData = bDecrementData3;
        grad = grad3;
        previous = previous4;
        goto L5
    L21:
        i2 = i;
        grad3 = grad;
        bDecrementData3 = bDecrementData;
        previous4 = previous;
        goto L22
    L23:
        double[] grad4 = grad;
        double[] bDecrementData4 = bDecrementData;
        RealVector dX = new LUDecompositionImpl(a2).getSolver().solve(b2);     // Catch: InvalidMatrixException -> L29
        int i3 = 0;
    L26:
        if (i3 >= this.parameters.length) goto L31;
        this.parameters[i3].setEstimate(this.parameters[i3].getEstimate() + dX.getEntry(i3));     // Catch: InvalidMatrixException -> L29
        i3 = i3 + 1;
        goto L26
    L31:
        previous = this.cost;
        updateResidualsAndCost();
        if (getCostEvaluations() < 2) goto L38;
        if (FastMath.abs(previous - this.cost) <= (this.cost * this.steadyStateThreshold)) goto L37;
        if (FastMath.abs(this.cost) > this.convergence) goto L38;
        return;
    L37:
        return;
    L38:
        bDecrementData = bDecrementData4;
        grad = grad4;
    L40:
        throw new EstimationException(LocalizedFormats.UNABLE_TO_SOLVE_SINGULAR_PROBLEM, new Object[0]);
    }
}

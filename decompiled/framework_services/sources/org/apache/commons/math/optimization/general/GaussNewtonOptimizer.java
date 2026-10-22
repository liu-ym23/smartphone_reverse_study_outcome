package org.apache.commons.math.optimization.general;

import java.lang.reflect.Array;
import org.apache.commons.math.FunctionEvaluationException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.linear.BlockRealMatrix;
import org.apache.commons.math.linear.DecompositionSolver;
import org.apache.commons.math.linear.InvalidMatrixException;
import org.apache.commons.math.linear.LUDecompositionImpl;
import org.apache.commons.math.linear.QRDecompositionImpl;
import org.apache.commons.math.linear.RealMatrix;
import org.apache.commons.math.optimization.OptimizationException;
import org.apache.commons.math.optimization.VectorialPointValuePair;

/* JADX INFO: loaded from: classes3.dex */
public class GaussNewtonOptimizer extends AbstractLeastSquaresOptimizer {
    private final boolean useLU;

    public GaussNewtonOptimizer(boolean useLU) {
        this.useLU = useLU;
    }

    @Override // org.apache.commons.math.optimization.general.AbstractLeastSquaresOptimizer
    public VectorialPointValuePair doOptimize() throws FunctionEvaluationException, OptimizationException, IllegalArgumentException {
        VectorialPointValuePair current = null;
        boolean converged = false;
    L3:
        if (converged == true) goto L40;
        incrementIterationsCounter();
        VectorialPointValuePair previous = current;
        updateResidualsAndCost();
        updateJacobian();
        VectorialPointValuePair current2 = new VectorialPointValuePair(this.point, this.objective);
        double[] b = new double[this.cols];
        double[][] a = (double[][]) Array.newInstance(Double.TYPE, new int[]{this.cols, this.cols});
        int i = 0;
    L6:
        if (i >= this.rows) goto L20;
        double[] grad = this.jacobian[i];
        double weight = this.residualsWeights[i];
        double residual = this.objective[i] - this.targetValues[i];
        double wr = weight * residual;
        int j = 0;
    L9:
        if (j >= this.cols) goto L11;
        b[j] = b[j] + (grad[j] * wr);
        j = j + 1;
        goto L9
    L11:
        int k = 0;
    L13:
        if (k >= this.cols) goto L19;
        double[] ak = a[k];
        double wgk = grad[k] * weight;
        int i2 = i;
        int i3 = 0;
    L15:
        boolean converged2 = converged;
        if (i3 >= this.cols) goto L18;
        ak[i3] = ak[i3] + (grad[i3] * wgk);
        i3 = i3 + 1;
        converged = converged2;
        goto L15
    L18:
        k = k + 1;
        converged = converged2;
        i = i2;
        goto L13
    L19:
        i = i + 1;
        goto L6
    L20:
        boolean converged3 = converged;
        RealMatrix mA = new BlockRealMatrix(a);     // Catch: InvalidMatrixException -> L24
        if (this.useLU == false) goto L26;
        DecompositionSolver solver = new LUDecompositionImpl(mA).getSolver();     // Catch: InvalidMatrixException -> L24
    L27:
        double[] dX = solver.solve(b);     // Catch: InvalidMatrixException -> L24
        int i4 = 0;
    L29:
        if (i4 >= this.cols) goto L33;
        double[] r9 = this.point;     // Catch: InvalidMatrixException -> L24
        r9[i4] = r9[i4] + dX[i4];     // Catch: InvalidMatrixException -> L24
        i4 = i4 + 1;
        goto L29
    L33:
        if (previous == null) goto L35;
        converged = this.checker.converged(getIterations(), previous, current2);
    L36:
        current = current2;
        goto L3
    L35:
        converged = converged3;
        goto L36
    L26:
        solver = new QRDecompositionImpl(mA).getSolver();     // Catch: InvalidMatrixException -> L24
    L38:
        throw new OptimizationException(LocalizedFormats.UNABLE_TO_SOLVE_SINGULAR_PROBLEM, new Object[0]);
    L40:
        return current;
    }
}

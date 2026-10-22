package org.apache.commons.math.optimization;

import org.apache.commons.math.FunctionEvaluationException;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.analysis.MultivariateRealFunction;
import org.apache.commons.math.analysis.MultivariateVectorialFunction;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.linear.RealMatrix;

/* JADX INFO: loaded from: classes3.dex */
public class LeastSquaresConverter implements MultivariateRealFunction {
    private final MultivariateVectorialFunction function;
    private final double[] observations;
    private final RealMatrix scale;
    private final double[] weights;

    public LeastSquaresConverter(MultivariateVectorialFunction function, double[] observations) {
        this.function = function;
        this.observations = (double[]) observations.clone();
        this.weights = null;
        this.scale = null;
    }

    public LeastSquaresConverter(MultivariateVectorialFunction function, double[] observations, double[] weights) throws IllegalArgumentException {
        if (observations.length != weights.length) goto L7;
        this.function = function;
        this.observations = (double[]) observations.clone();
        this.weights = (double[]) weights.clone();
        this.scale = null;
        return;
    L7:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.DIMENSIONS_MISMATCH_SIMPLE, new Object[]{Integer.valueOf(observations.length), Integer.valueOf(weights.length)});
    }

    public LeastSquaresConverter(MultivariateVectorialFunction function, double[] observations, RealMatrix scale) throws IllegalArgumentException {
        if (observations.length != scale.getColumnDimension()) goto L7;
        this.function = function;
        this.observations = (double[]) observations.clone();
        this.weights = null;
        this.scale = scale.copy();
        return;
    L7:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.DIMENSIONS_MISMATCH_SIMPLE, new Object[]{Integer.valueOf(observations.length), Integer.valueOf(scale.getColumnDimension())});
    }

    @Override // org.apache.commons.math.analysis.MultivariateRealFunction
    public double value(double[] point) throws FunctionEvaluationException {
        double[] residuals = this.function.value(point);
        if (residuals.length != this.observations.length) goto L27;
        int i = 0;
    L6:
        if (i >= residuals.length) goto L8;
        residuals[i] = residuals[i] - this.observations[i];
        i = i + 1;
        goto L6
    L8:
        double sumSquares = 0.0d;
        if (this.weights == null) goto L15;
        int i2 = 0;
    L12:
        if (i2 >= residuals.length) goto L25;
        double ri = residuals[i2];
        sumSquares = sumSquares + ((this.weights[i2] * ri) * ri);
        i2 = i2 + 1;
    L25:
        return sumSquares;
    L15:
        int r4 = 0;
        if (this.scale == null) goto L21;
        double[] r3 = this.scale.operate(residuals);
        int r5 = r3.length;
    L19:
        if (r4 >= r5) goto L25;
        double yi = r3[r4];
        sumSquares = sumSquares + (yi * yi);
        r4 = r4 + 1;
        goto L19
    L21:
        int r6 = residuals.length;
    L23:
        if (r4 >= r6) goto L25;
        double ri2 = residuals[r4];
        sumSquares = sumSquares + (ri2 * ri2);
        r4 = r4 + 1;
        goto L23
    L27:
        throw new FunctionEvaluationException(point, LocalizedFormats.DIMENSIONS_MISMATCH_SIMPLE, new Object[]{Integer.valueOf(residuals.length), Integer.valueOf(this.observations.length)});
    }
}

package org.apache.commons.math.stat.regression;

import java.lang.reflect.Array;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.linear.Array2DRowRealMatrix;
import org.apache.commons.math.linear.ArrayRealVector;
import org.apache.commons.math.linear.RealMatrix;
import org.apache.commons.math.linear.RealVector;
import org.apache.commons.math.stat.descriptive.moment.Variance;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractMultipleLinearRegression implements MultipleLinearRegression {
    protected RealMatrix X;
    protected RealVector Y;
    private boolean noIntercept;

    protected abstract RealVector calculateBeta();

    protected abstract RealMatrix calculateBetaVariance();

    public AbstractMultipleLinearRegression() {
        this.noIntercept = false;
    }

    public boolean isNoIntercept() {
        return this.noIntercept;
    }

    public void setNoIntercept(boolean noIntercept) {
        this.noIntercept = noIntercept;
    }

    public void newSampleData(double[] r13, int r14, int r15) {
        if (r13 == null) goto L27;
        if (r13.length != ((r15 + 1) * r14)) goto L25;
        if (r14 <= r15) goto L23;
        double[] r1 = new double[r14];
        if (this.noIntercept == false) goto L10;
        int r2 = r15;
    L11:
        double[][] r3 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r14, r2});
        int r5 = 0;
        int r6 = 0;
    L12:
        if (r6 >= r14) goto L20;
        int r7 = r5 + 1;
        r1[r6] = r13[r5];
        if (this.noIntercept == true) goto L16;
        r3[r6][0] = 1.0d;
    L16:
        int r8 = !this.noIntercept ? 1 : 0;
    L17:
        if (r8 >= r2) goto L19;
        r3[r6][r8] = r13[r7];
        r8 = r8 + 1;
        r7 = r7 + 1;
        goto L17
    L19:
        r6 = r6 + 1;
        r5 = r7;
        goto L12
    L20:
        this.X = new Array2DRowRealMatrix(r3);
        this.Y = new ArrayRealVector(r1);
        return;
    L10:
        r2 = r15 + 1;
        goto L11
    L23:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.NOT_ENOUGH_DATA_FOR_NUMBER_OF_PREDICTORS, new Object[0]);
    L25:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.INVALID_REGRESSION_ARRAY, new Object[]{Integer.valueOf(r13.length), Integer.valueOf(r14), Integer.valueOf(r15)});
    L27:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.NULL_NOT_ALLOWED, new Object[0]);
    }

    protected void newYSampleData(double[] y) {
        if (y == null) goto L11;
        if (y.length == 0) goto L9;
        this.Y = new ArrayRealVector(y);
        return;
    L9:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.NO_DATA, new Object[0]);
    L11:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.NULL_NOT_ALLOWED, new Object[0]);
    }

    protected void newXSampleData(double[][] x) {
        if (x == null) goto L22;
        if (x.length == 0) goto L20;
        if (this.noIntercept == false) goto L9;
        this.X = new Array2DRowRealMatrix(x, true);
        return;
    L9:
        int nVars = x[0].length;
        double[][] xAug = (double[][]) Array.newInstance(Double.TYPE, new int[]{x.length, nVars + 1});
        int i = 0;
    L11:
        if (i >= x.length) goto L17;
        if (x[i].length != nVars) goto L16;
        xAug[i][0] = 1.0d;
        System.arraycopy(x[i], 0, xAug[i], 1, nVars);
        i = i + 1;
        goto L11
    L16:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.DIFFERENT_ROWS_LENGTHS, new Object[]{Integer.valueOf(x[i].length), Integer.valueOf(nVars)});
    L17:
        this.X = new Array2DRowRealMatrix(xAug, false);
        return;
    L20:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.NO_DATA, new Object[0]);
    L22:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.NULL_NOT_ALLOWED, new Object[0]);
    }

    protected void validateSampleData(double[][] x, double[] y) {
        int r0 = 0;
        if (x == null) goto L17;
        if (y == null) goto L17;
        if (x.length != y.length) goto L17;
        if (x.length == 0) goto L16;
        if ((x[0].length + 1) > x.length) goto L14;
        return;
    L14:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.NOT_ENOUGH_DATA_FOR_NUMBER_OF_PREDICTORS, new Object[]{Integer.valueOf(x.length), Integer.valueOf(x[0].length)});
    L16:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.NO_DATA, new Object[0]);
    L17:
        LocalizedFormats r1 = LocalizedFormats.DIMENSIONS_MISMATCH_SIMPLE;
        if (x != null) goto L20;
        int r2 = 0;
    L21:
        Integer r3 = Integer.valueOf(r2);
        if (y == null) goto L26;
        r0 = y.length;
    L26:
        throw MathRuntimeException.createIllegalArgumentException(r1, new Object[]{r3, Integer.valueOf(r0)});
    L20:
        r2 = x.length;
        goto L21
    }

    protected void validateCovarianceData(double[][] x, double[][] covariance) {
        if (x.length != covariance.length) goto L13;
        if (covariance.length > 0) goto L7;
        return;
    L7:
        if (covariance.length != covariance[0].length) goto L10;
        return;
    L10:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.NON_SQUARE_MATRIX, new Object[]{Integer.valueOf(covariance.length), Integer.valueOf(covariance[0].length)});
    L13:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.DIMENSIONS_MISMATCH_SIMPLE, new Object[]{Integer.valueOf(x.length), Integer.valueOf(covariance.length)});
    }

    @Override // org.apache.commons.math.stat.regression.MultipleLinearRegression
    public double[] estimateRegressionParameters() {
        RealVector b = calculateBeta();
        return b.getData();
    }

    @Override // org.apache.commons.math.stat.regression.MultipleLinearRegression
    public double[] estimateResiduals() {
        RealVector b = calculateBeta();
        RealVector e = this.Y.subtract(this.X.operate(b));
        return e.getData();
    }

    @Override // org.apache.commons.math.stat.regression.MultipleLinearRegression
    public double[][] estimateRegressionParametersVariance() {
        return calculateBetaVariance().getData();
    }

    @Override // org.apache.commons.math.stat.regression.MultipleLinearRegression
    public double[] estimateRegressionParametersStandardErrors() {
        double[][] betaVariance = estimateRegressionParametersVariance();
        double sigma = calculateErrorVariance();
        int length = betaVariance[0].length;
        double[] result = new double[length];
        int i = 0;
    L3:
        if (i >= length) goto L6;
        result[i] = FastMath.sqrt(betaVariance[i][i] * sigma);
        i = i + 1;
        goto L3
    L6:
        return result;
    }

    @Override // org.apache.commons.math.stat.regression.MultipleLinearRegression
    public double estimateRegressandVariance() {
        return calculateYVariance();
    }

    public double estimateErrorVariance() {
        return calculateErrorVariance();
    }

    public double estimateRegressionStandardError() {
        return Math.sqrt(estimateErrorVariance());
    }

    protected double calculateYVariance() {
        return new Variance().evaluate(this.Y.getData());
    }

    protected double calculateErrorVariance() {
        RealVector residuals = calculateResiduals();
        return residuals.dotProduct(residuals) / ((double) (this.X.getRowDimension() - this.X.getColumnDimension()));
    }

    protected RealVector calculateResiduals() {
        RealVector b = calculateBeta();
        return this.Y.subtract(this.X.operate(b));
    }
}

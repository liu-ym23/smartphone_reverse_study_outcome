package org.apache.commons.math.stat.correlation;

import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.linear.BlockRealMatrix;
import org.apache.commons.math.linear.RealMatrix;
import org.apache.commons.math.stat.descriptive.moment.Mean;
import org.apache.commons.math.stat.descriptive.moment.Variance;

/* JADX INFO: loaded from: classes3.dex */
public class Covariance {
    private final RealMatrix covarianceMatrix;
    private final int n;

    public Covariance() {
        this.covarianceMatrix = null;
        this.n = 0;
    }

    public Covariance(double[][] data, boolean biasCorrected) {
        this(new BlockRealMatrix(data), biasCorrected);
    }

    public Covariance(double[][] data) {
        this(data, true);
    }

    public Covariance(RealMatrix matrix, boolean biasCorrected) {
        checkSufficientData(matrix);
        this.n = matrix.getRowDimension();
        this.covarianceMatrix = computeCovarianceMatrix(matrix, biasCorrected);
    }

    public Covariance(RealMatrix matrix) {
        this(matrix, true);
    }

    public RealMatrix getCovarianceMatrix() {
        return this.covarianceMatrix;
    }

    public int getN() {
        return this.n;
    }

    protected RealMatrix computeCovarianceMatrix(RealMatrix matrix, boolean biasCorrected) {
        int dimension = matrix.getColumnDimension();
        Variance variance = new Variance(biasCorrected);
        RealMatrix outMatrix = new BlockRealMatrix(dimension, dimension);
        int i = 0;
    L3:
        if (i >= dimension) goto L9;
        int j = 0;
    L5:
        if (j >= i) goto L7;
        double cov = covariance(matrix.getColumn(i), matrix.getColumn(j), biasCorrected);
        outMatrix.setEntry(i, j, cov);
        outMatrix.setEntry(j, i, cov);
        j = j + 1;
        goto L5
    L7:
        outMatrix.setEntry(i, i, variance.evaluate(matrix.getColumn(i)));
        i = i + 1;
        goto L3
    L9:
        return outMatrix;
    }

    protected RealMatrix computeCovarianceMatrix(RealMatrix matrix) {
        return computeCovarianceMatrix(matrix, true);
    }

    protected RealMatrix computeCovarianceMatrix(double[][] data, boolean biasCorrected) {
        return computeCovarianceMatrix(new BlockRealMatrix(data), biasCorrected);
    }

    protected RealMatrix computeCovarianceMatrix(double[][] data) {
        return computeCovarianceMatrix(data, true);
    }

    public double covariance(double[] xArray, double[] yArray, boolean biasCorrected) throws IllegalArgumentException {
        double[] r0 = xArray;
        Mean mean = new Mean();
        double result = 0.0d;
        int length = r0.length;
        if (length != yArray.length) goto L17;
        if (length < 2) goto L15;
        double xMean = mean.evaluate(r0);
        double yMean = mean.evaluate(yArray);
        int i = 0;
    L7:
        if (i >= length) goto L9;
        double xDev = r0[i] - xMean;
        double yDev = yArray[i] - yMean;
        result = result + (((xDev * yDev) - result) / ((double) (i + 1)));
        i = i + 1;
        r0 = xArray;
        mean = mean;
        goto L7
    L9:
        double result2 = result;
        if (biasCorrected == false) goto L13;
        return result2 * (((double) length) / ((double) (length - 1)));
    L13:
        return result2;
    L15:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.INSUFFICIENT_DIMENSION, new Object[]{Integer.valueOf(length), 2});
    L17:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.DIMENSIONS_MISMATCH_SIMPLE, new Object[]{Integer.valueOf(length), Integer.valueOf(yArray.length)});
    }

    public double covariance(double[] xArray, double[] yArray) throws IllegalArgumentException {
        return covariance(xArray, yArray, true);
    }

    private void checkSufficientData(RealMatrix matrix) {
        int nRows = matrix.getRowDimension();
        int nCols = matrix.getColumnDimension();
        if (nRows < 2) goto L7;
        if (nCols < 2) goto L7;
        return;
    L7:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.INSUFFICIENT_ROWS_AND_COLUMNS, new Object[]{Integer.valueOf(nRows), Integer.valueOf(nCols)});
    }
}

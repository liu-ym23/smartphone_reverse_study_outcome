package org.apache.commons.math.stat.correlation;

import java.lang.reflect.Array;
import org.apache.commons.math.MathException;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.distribution.TDistribution;
import org.apache.commons.math.distribution.TDistributionImpl;
import org.apache.commons.math.exception.DimensionMismatchException;
import org.apache.commons.math.exception.NullArgumentException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.linear.BlockRealMatrix;
import org.apache.commons.math.linear.RealMatrix;
import org.apache.commons.math.stat.regression.SimpleRegression;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class PearsonsCorrelation {
    private final RealMatrix correlationMatrix;
    private final int nObs;

    public PearsonsCorrelation() {
        this.correlationMatrix = null;
        this.nObs = 0;
    }

    public PearsonsCorrelation(double[][] data) {
        this(new BlockRealMatrix(data));
    }

    public PearsonsCorrelation(RealMatrix matrix) {
        checkSufficientData(matrix);
        this.nObs = matrix.getRowDimension();
        this.correlationMatrix = computeCorrelationMatrix(matrix);
    }

    public PearsonsCorrelation(Covariance covariance) {
        RealMatrix covarianceMatrix = covariance.getCovarianceMatrix();
        if (covarianceMatrix == null) goto L7;
        this.nObs = covariance.getN();
        this.correlationMatrix = covarianceToCorrelation(covarianceMatrix);
        return;
    L7:
        throw new NullArgumentException(LocalizedFormats.COVARIANCE_MATRIX);
    }

    public PearsonsCorrelation(RealMatrix covarianceMatrix, int numberOfObservations) {
        this.nObs = numberOfObservations;
        this.correlationMatrix = covarianceToCorrelation(covarianceMatrix);
    }

    public RealMatrix getCorrelationMatrix() {
        return this.correlationMatrix;
    }

    public RealMatrix getCorrelationStandardErrors() {
        int nVars = this.correlationMatrix.getColumnDimension();
        double[][] out = (double[][]) Array.newInstance(Double.TYPE, new int[]{nVars, nVars});
        int i = 0;
    L3:
        if (i >= nVars) goto L9;
        int j = 0;
    L5:
        if (j >= nVars) goto L7;
        double r = this.correlationMatrix.getEntry(i, j);
        out[i][j] = FastMath.sqrt((1.0d - (r * r)) / ((double) (this.nObs - 2)));
        j = j + 1;
        goto L5
    L7:
        i = i + 1;
        goto L3
    L9:
        return new BlockRealMatrix(out);
    }

    public RealMatrix getCorrelationPValues() throws MathException {
        TDistribution tDistribution = new TDistributionImpl(this.nObs - 2);
        int nVars = this.correlationMatrix.getColumnDimension();
        double[][] out = (double[][]) Array.newInstance(Double.TYPE, new int[]{nVars, nVars});
        int i = 0;
    L3:
        if (i >= nVars) goto L12;
        int j = 0;
    L5:
        if (j >= nVars) goto L10;
        if (i != j) goto L8;
        out[i][j] = 0.0d;
    L9:
        j = j + 1;
        goto L5
    L8:
        double r = this.correlationMatrix.getEntry(i, j);
        double t = FastMath.abs(FastMath.sqrt(((double) (this.nObs - 2)) / (1.0d - (r * r))) * r);
        out[i][j] = tDistribution.cumulativeProbability(-t) * 2.0d;
        goto L9
    L10:
        i = i + 1;
        goto L3
    L12:
        return new BlockRealMatrix(out);
    }

    public RealMatrix computeCorrelationMatrix(RealMatrix matrix) {
        int nVars = matrix.getColumnDimension();
        RealMatrix outMatrix = new BlockRealMatrix(nVars, nVars);
        int i = 0;
    L3:
        if (i >= nVars) goto L9;
        int j = 0;
    L5:
        if (j >= i) goto L7;
        double corr = correlation(matrix.getColumn(i), matrix.getColumn(j));
        outMatrix.setEntry(i, j, corr);
        outMatrix.setEntry(j, i, corr);
        j = j + 1;
        goto L5
    L7:
        outMatrix.setEntry(i, i, 1.0d);
        i = i + 1;
        goto L3
    L9:
        return outMatrix;
    }

    public RealMatrix computeCorrelationMatrix(double[][] data) {
        return computeCorrelationMatrix(new BlockRealMatrix(data));
    }

    public double correlation(double[] xArray, double[] yArray) throws IllegalArgumentException {
        SimpleRegression regression = new SimpleRegression();
        if (xArray.length != yArray.length) goto L15;
        if (xArray.length < 2) goto L13;
        int i = 0;
    L8:
        if (i >= xArray.length) goto L11;
        regression.addData(xArray[i], yArray[i]);
        i = i + 1;
        goto L8
    L11:
        return regression.getR();
    L13:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.INSUFFICIENT_DIMENSION, new Object[]{Integer.valueOf(xArray.length), 2});
    L15:
        throw new DimensionMismatchException(xArray.length, yArray.length);
    }

    public RealMatrix covarianceToCorrelation(RealMatrix covarianceMatrix) {
        int nVars = covarianceMatrix.getColumnDimension();
        RealMatrix outMatrix = new BlockRealMatrix(nVars, nVars);
        int i = 0;
    L3:
        if (i >= nVars) goto L9;
        double sigma = FastMath.sqrt(covarianceMatrix.getEntry(i, i));
        outMatrix.setEntry(i, i, 1.0d);
        int j = 0;
    L5:
        if (j >= i) goto L7;
        double entry = covarianceMatrix.getEntry(i, j) / (FastMath.sqrt(covarianceMatrix.getEntry(j, j)) * sigma);
        outMatrix.setEntry(i, j, entry);
        outMatrix.setEntry(j, i, entry);
        j = j + 1;
        goto L5
    L7:
        i = i + 1;
        goto L3
    L9:
        return outMatrix;
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

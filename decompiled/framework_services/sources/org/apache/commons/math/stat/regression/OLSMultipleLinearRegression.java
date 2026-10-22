package org.apache.commons.math.stat.regression;

import org.apache.commons.math.linear.Array2DRowRealMatrix;
import org.apache.commons.math.linear.LUDecompositionImpl;
import org.apache.commons.math.linear.QRDecomposition;
import org.apache.commons.math.linear.QRDecompositionImpl;
import org.apache.commons.math.linear.RealMatrix;
import org.apache.commons.math.linear.RealVector;
import org.apache.commons.math.stat.StatUtils;
import org.apache.commons.math.stat.descriptive.moment.SecondMoment;

/* JADX INFO: loaded from: classes3.dex */
public class OLSMultipleLinearRegression extends AbstractMultipleLinearRegression {
    private QRDecomposition qr;

    public OLSMultipleLinearRegression() {
        this.qr = null;
    }

    public void newSampleData(double[] y, double[][] x) {
        validateSampleData(x, y);
        newYSampleData(y);
        newXSampleData(x);
    }

    @Override // org.apache.commons.math.stat.regression.AbstractMultipleLinearRegression
    public void newSampleData(double[] data, int nobs, int nvars) {
        super.newSampleData(data, nobs, nvars);
        this.qr = new QRDecompositionImpl(this.X);
    }

    public RealMatrix calculateHat() {
        RealMatrix Q = this.qr.getQ();
        int p = this.qr.getR().getColumnDimension();
        int n = Q.getColumnDimension();
        Array2DRowRealMatrix augI = new Array2DRowRealMatrix(n, n);
        double[][] augIData = augI.getDataRef();
        int i = 0;
    L3:
        if (i >= n) goto L13;
        int j = 0;
    L5:
        if (j >= n) goto L11;
        if (i != j) goto L9;
        if (i >= p) goto L9;
        augIData[i][j] = 1.0d;
    L10:
        j = j + 1;
    L9:
        augIData[i][j] = 0.0d;
        goto L10
    L11:
        i = i + 1;
        goto L3
    L13:
        return Q.multiply(augI).multiply(Q.transpose());
    }

    public double calculateTotalSumOfSquares() {
        if (isNoIntercept() == false) goto L7;
        return StatUtils.sumSq(this.Y.getData());
    L7:
        return new SecondMoment().evaluate(this.Y.getData());
    }

    public double calculateResidualSumOfSquares() {
        RealVector residuals = calculateResiduals();
        return residuals.dotProduct(residuals);
    }

    public double calculateRSquared() {
        return 1.0d - (calculateResidualSumOfSquares() / calculateTotalSumOfSquares());
    }

    public double calculateAdjustedRSquared() {
        double n = this.X.getRowDimension();
        if (isNoIntercept() == false) goto L7;
        return 1.0d - ((1.0d - calculateRSquared()) * (n / (n - ((double) this.X.getColumnDimension()))));
    L7:
        return 1.0d - ((calculateResidualSumOfSquares() * (n - 1.0d)) / (calculateTotalSumOfSquares() * (n - ((double) this.X.getColumnDimension()))));
    }

    @Override // org.apache.commons.math.stat.regression.AbstractMultipleLinearRegression
    protected void newXSampleData(double[][] x) {
        super.newXSampleData(x);
        this.qr = new QRDecompositionImpl(this.X);
    }

    @Override // org.apache.commons.math.stat.regression.AbstractMultipleLinearRegression
    protected RealVector calculateBeta() {
        return this.qr.getSolver().solve(this.Y);
    }

    @Override // org.apache.commons.math.stat.regression.AbstractMultipleLinearRegression
    protected RealMatrix calculateBetaVariance() {
        int p = this.X.getColumnDimension();
        RealMatrix Raug = this.qr.getR().getSubMatrix(0, p - 1, 0, p - 1);
        RealMatrix Rinv = new LUDecompositionImpl(Raug).getSolver().getInverse();
        return Rinv.multiply(Rinv.transpose());
    }
}

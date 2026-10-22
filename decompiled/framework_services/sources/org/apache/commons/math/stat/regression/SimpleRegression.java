package org.apache.commons.math.stat.regression;

import java.io.Serializable;
import org.apache.commons.math.MathException;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.distribution.TDistribution;
import org.apache.commons.math.distribution.TDistributionImpl;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class SimpleRegression implements Serializable {
    private static final long serialVersionUID = -3004689053607543335L;
    private TDistribution distribution;
    private long n;
    private double sumX;
    private double sumXX;
    private double sumXY;
    private double sumY;
    private double sumYY;
    private double xbar;
    private double ybar;

    public SimpleRegression() {
        this(new TDistributionImpl(1.0d));
    }

    @Deprecated
    public SimpleRegression(TDistribution t) {
        this.sumX = 0.0d;
        this.sumXX = 0.0d;
        this.sumY = 0.0d;
        this.sumYY = 0.0d;
        this.sumXY = 0.0d;
        this.n = 0;
        this.xbar = 0.0d;
        this.ybar = 0.0d;
        setDistribution(t);
    }

    public SimpleRegression(int degrees) {
        this.sumX = 0.0d;
        this.sumXX = 0.0d;
        this.sumY = 0.0d;
        this.sumYY = 0.0d;
        this.sumXY = 0.0d;
        this.n = 0;
        this.xbar = 0.0d;
        this.ybar = 0.0d;
        setDistribution(new TDistributionImpl(degrees));
    }

    public void addData(double x, double y) {
        if (this.n != 0) goto L5;
        this.xbar = x;
        this.ybar = y;
    L6:
        this.sumX += x;
        this.sumY += y;
        this.n++;
        if (this.n <= 2) goto L10;
        this.distribution.setDegreesOfFreedom(this.n - 2);
        return;
    L10:
        return;
    L5:
        double dx = x - this.xbar;
        double dy = y - this.ybar;
        this.sumXX += ((dx * dx) * this.n) / (this.n + 1.0d);
        this.sumYY += ((dy * dy) * this.n) / (this.n + 1.0d);
        this.sumXY += ((dx * dy) * this.n) / (this.n + 1.0d);
        this.xbar += dx / (this.n + 1.0d);
        this.ybar += dy / (this.n + 1.0d);
        goto L6
    }

    public void removeData(double x, double y) {
        if (this.n <= 0) goto L8;
        double dx = x - this.xbar;
        double dy = y - this.ybar;
        this.sumXX -= ((dx * dx) * this.n) / (this.n - 1.0d);
        this.sumYY -= ((dy * dy) * this.n) / (this.n - 1.0d);
        this.sumXY -= ((dx * dy) * this.n) / (this.n - 1.0d);
        this.xbar -= dx / (this.n - 1.0d);
        this.ybar -= dy / (this.n - 1.0d);
        this.sumX -= x;
        this.sumY -= y;
        this.n--;
        if (this.n <= 2) goto L9;
        this.distribution.setDegreesOfFreedom(this.n - 2);
        return;
    L9:
        return;
    }

    public void addData(double[][] data) {
        int i = 0;
    L4:
        if (i >= data.length) goto L7;
        addData(data[i][0], data[i][1]);
        i = i + 1;
        goto L4
    }

    public void removeData(double[][] data) {
        int i = 0;
    L4:
        if (i >= data.length) goto L8;
        if (this.n <= 0) goto L11;
        removeData(data[i][0], data[i][1]);
        i = i + 1;
        goto L4
    L11:
        return;
    }

    public void clear() {
        this.sumX = 0.0d;
        this.sumXX = 0.0d;
        this.sumY = 0.0d;
        this.sumYY = 0.0d;
        this.sumXY = 0.0d;
        this.n = 0;
    }

    public long getN() {
        return this.n;
    }

    public double predict(double x) {
        double b1 = getSlope();
        return getIntercept(b1) + (b1 * x);
    }

    public double getIntercept() {
        return getIntercept(getSlope());
    }

    public double getSlope() {
        if (this.n >= 2) goto L6;
        return Double.NaN;
    L6:
        if (FastMath.abs(this.sumXX) >= 4.9E-323d) goto L9;
        return Double.NaN;
    L9:
        return this.sumXY / this.sumXX;
    }

    public double getSumSquaredErrors() {
        return FastMath.max(0.0d, this.sumYY - ((this.sumXY * this.sumXY) / this.sumXX));
    }

    public double getTotalSumSquares() {
        if (this.n >= 2) goto L7;
        return Double.NaN;
    L7:
        return this.sumYY;
    }

    public double getXSumSquares() {
        if (this.n >= 2) goto L7;
        return Double.NaN;
    L7:
        return this.sumXX;
    }

    public double getSumOfCrossProducts() {
        return this.sumXY;
    }

    public double getRegressionSumSquares() {
        return getRegressionSumSquares(getSlope());
    }

    public double getMeanSquareError() {
        if (this.n >= 3) goto L7;
        return Double.NaN;
    L7:
        return getSumSquaredErrors() / (this.n - 2);
    }

    public double getR() {
        double b1 = getSlope();
        double result = FastMath.sqrt(getRSquare());
        if (b1 < 0.0d) goto L5;
        return result;
    L5:
        return -result;
    }

    public double getRSquare() {
        double ssto = getTotalSumSquares();
        return (ssto - getSumSquaredErrors()) / ssto;
    }

    public double getInterceptStdErr() {
        return FastMath.sqrt(getMeanSquareError() * ((1.0d / this.n) + ((this.xbar * this.xbar) / this.sumXX)));
    }

    public double getSlopeStdErr() {
        return FastMath.sqrt(getMeanSquareError() / this.sumXX);
    }

    public double getSlopeConfidenceInterval() throws MathException {
        return getSlopeConfidenceInterval(0.05d);
    }

    public double getSlopeConfidenceInterval(double alpha) throws MathException {
        if (alpha >= 1.0d) goto L9;
        if (alpha <= 0.0d) goto L9;
        return getSlopeStdErr() * this.distribution.inverseCumulativeProbability(1.0d - (alpha / 2.0d));
    L9:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.OUT_OF_BOUND_SIGNIFICANCE_LEVEL, new Object[]{Double.valueOf(alpha), Double.valueOf(0.0d), Double.valueOf(1.0d)});
    }

    public double getSignificance() throws MathException {
        return (1.0d - this.distribution.cumulativeProbability(FastMath.abs(getSlope()) / getSlopeStdErr())) * 2.0d;
    }

    private double getIntercept(double slope) {
        return (this.sumY - (this.sumX * slope)) / this.n;
    }

    private double getRegressionSumSquares(double slope) {
        return (slope * slope) * this.sumXX;
    }

    @Deprecated
    public void setDistribution(TDistribution value) {
        this.distribution = value;
        if (this.n <= 2) goto L6;
        this.distribution.setDegreesOfFreedom(this.n - 2);
        return;
    }
}

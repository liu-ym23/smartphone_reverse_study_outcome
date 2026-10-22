package org.apache.commons.math.stat.inference;

import org.apache.commons.math.MathException;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.distribution.ChiSquaredDistribution;
import org.apache.commons.math.distribution.ChiSquaredDistributionImpl;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class ChiSquareTestImpl implements UnknownDistributionChiSquareTest {
    private ChiSquaredDistribution distribution;

    public ChiSquareTestImpl() {
        this(new ChiSquaredDistributionImpl(1.0d));
    }

    public ChiSquareTestImpl(ChiSquaredDistribution x) {
        setDistribution(x);
    }

    @Override // org.apache.commons.math.stat.inference.ChiSquareTest
    public double chiSquare(double[] expected, long[] observed) throws IllegalArgumentException {
        if (expected.length < 2) goto L25;
        if (expected.length != observed.length) goto L23;
        checkPositive(expected);
        checkNonNegative(observed);
        double sumExpected = 0.0d;
        double sumObserved = 0.0d;
        int i = 0;
    L8:
        if (i >= observed.length) goto L10;
        sumExpected = sumExpected + expected[i];
        sumObserved = sumObserved + observed[i];
        i = i + 1;
        goto L8
    L10:
        double ratio = 1.0d;
        boolean rescale = false;
        if (FastMath.abs(sumExpected - sumObserved) <= 1.0E-5d) goto L13;
        ratio = sumObserved / sumExpected;
        rescale = true;
    L13:
        double sumSq = 0.0d;
        int i2 = 0;
    L15:
        if (i2 >= observed.length) goto L21;
        if (rescale == false) goto L18;
        double dev = observed[i2] - (expected[i2] * ratio);
        double r15 = dev * dev;
        double r17 = expected[i2] * ratio;
    L19:
        sumSq = sumSq + (r15 / r17);
        i2 = i2 + 1;
        goto L15
    L18:
        double dev2 = observed[i2] - expected[i2];
        r15 = dev2 * dev2;
        r17 = expected[i2];
        goto L19
    L21:
        return sumSq;
    L23:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.DIMENSIONS_MISMATCH_SIMPLE, new Object[]{Integer.valueOf(expected.length), Integer.valueOf(observed.length)});
    L25:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.INSUFFICIENT_DIMENSION, new Object[]{Integer.valueOf(expected.length), 2});
    }

    @Override // org.apache.commons.math.stat.inference.ChiSquareTest
    public double chiSquareTest(double[] expected, long[] observed) throws IllegalArgumentException, MathException {
        this.distribution.setDegreesOfFreedom(((double) expected.length) - 1.0d);
        return 1.0d - this.distribution.cumulativeProbability(chiSquare(expected, observed));
    }

    @Override // org.apache.commons.math.stat.inference.ChiSquareTest
    public boolean chiSquareTest(double[] expected, long[] observed, double alpha) throws IllegalArgumentException, MathException {
        if (alpha <= 0.0d) goto L11;
        if (alpha > 0.5d) goto L11;
        if (chiSquareTest(expected, observed) >= alpha) goto L12;
        return true;
    L12:
        return false;
    L11:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.OUT_OF_BOUND_SIGNIFICANCE_LEVEL, new Object[]{Double.valueOf(alpha), 0, Double.valueOf(0.5d)});
    }

    @Override // org.apache.commons.math.stat.inference.ChiSquareTest
    public double chiSquare(long[][] counts) throws IllegalArgumentException {
        long[][] r0 = counts;
        checkArray(counts);
        int nRows = r0.length;
        int nCols = r0[0].length;
        double[] rowSum = new double[nRows];
        double[] colSum = new double[nCols];
        double total = 0.0d;
        int row = 0;
    L3:
        if (row >= nRows) goto L8;
        int col = 0;
    L5:
        if (col >= nCols) goto L7;
        rowSum[row] = rowSum[row] + r0[row][col];
        colSum[col] = colSum[col] + r0[row][col];
        total = total + r0[row][col];
        col = col + 1;
        goto L5
    L7:
        row = row + 1;
        goto L3
    L8:
        double sumSq = 0.0d;
        int row2 = 0;
    L9:
        if (row2 >= nRows) goto L15;
        int col2 = 0;
    L11:
        if (col2 >= nCols) goto L13;
        double expected = (rowSum[row2] * colSum[col2]) / total;
        sumSq = sumSq + (((r0[row2][col2] - expected) * (r0[row2][col2] - expected)) / expected);
        col2 = col2 + 1;
        r0 = counts;
        nRows = nRows;
        goto L11
    L13:
        row2 = row2 + 1;
        r0 = counts;
        goto L9
    L15:
        return sumSq;
    }

    @Override // org.apache.commons.math.stat.inference.ChiSquareTest
    public double chiSquareTest(long[][] counts) throws IllegalArgumentException, MathException {
        checkArray(counts);
        double df = (((double) counts.length) - 1.0d) * (((double) counts[0].length) - 1.0d);
        this.distribution.setDegreesOfFreedom(df);
        return 1.0d - this.distribution.cumulativeProbability(chiSquare(counts));
    }

    @Override // org.apache.commons.math.stat.inference.ChiSquareTest
    public boolean chiSquareTest(long[][] counts, double alpha) throws IllegalArgumentException, MathException {
        if (alpha <= 0.0d) goto L12;
        if (alpha > 0.5d) goto L12;
        if (chiSquareTest(counts) >= alpha) goto L9;
        return true;
    L9:
        return false;
    L12:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.OUT_OF_BOUND_SIGNIFICANCE_LEVEL, new Object[]{Double.valueOf(alpha), Double.valueOf(0.0d), Double.valueOf(0.5d)});
    }

    @Override // org.apache.commons.math.stat.inference.UnknownDistributionChiSquareTest
    public double chiSquareDataSetsComparison(long[] observed1, long[] observed2) throws IllegalArgumentException {
        if (observed1.length < 2) goto L45;
        if (observed1.length != observed2.length) goto L43;
        checkNonNegative(observed1);
        checkNonNegative(observed2);
        long countSum1 = 0;
        long countSum2 = 0;
        double weight = 0.0d;
        int i = 0;
    L8:
        if (i >= observed1.length) goto L10;
        countSum1 = countSum1 + observed1[i];
        countSum2 = countSum2 + observed2[i];
        i = i + 1;
        goto L8
    L10:
        long r11 = 0;
        boolean unequalCounts = true;
        if (countSum1 == 0) goto L41;
        if (countSum2 == 0) goto L39;
        if (countSum1 != countSum2) goto L18;
        unequalCounts = false;
    L18:
        if (unequalCounts == false) goto L21;
        weight = FastMath.sqrt(countSum1 / countSum2);
    L21:
        double sumSq = 0.0d;
        int i2 = 0;
    L22:
        long r21 = r11;
        if (i2 >= observed1.length) goto L37;
        if (observed1[i2] == r21) goto L27;
    L31:
        double sumSq2 = sumSq;
        double obs1 = observed1[i2];
        double obs2 = observed2[i2];
        if (unequalCounts == false) goto L34;
        double dev = (obs1 / weight) - (obs2 * weight);
    L35:
        i2 = i2 + 1;
        sumSq = sumSq2 + ((dev * dev) / (obs1 + obs2));
        r11 = r21;
        goto L22
    L34:
        dev = obs1 - obs2;
        goto L35
    L27:
        if (observed2[i2] != r21) goto L31;
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.OBSERVED_COUNTS_BOTTH_ZERO_FOR_ENTRY, new Object[]{Integer.valueOf(i2)});
    L37:
        return sumSq;
    L39:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.OBSERVED_COUNTS_ALL_ZERO, new Object[]{2});
    L41:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.OBSERVED_COUNTS_ALL_ZERO, new Object[]{1});
    L43:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.DIMENSIONS_MISMATCH_SIMPLE, new Object[]{Integer.valueOf(observed1.length), Integer.valueOf(observed2.length)});
    L45:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.INSUFFICIENT_DIMENSION, new Object[]{Integer.valueOf(observed1.length), 2});
    }

    @Override // org.apache.commons.math.stat.inference.UnknownDistributionChiSquareTest
    public double chiSquareTestDataSetsComparison(long[] observed1, long[] observed2) throws IllegalArgumentException, MathException {
        this.distribution.setDegreesOfFreedom(((double) observed1.length) - 1.0d);
        return 1.0d - this.distribution.cumulativeProbability(chiSquareDataSetsComparison(observed1, observed2));
    }

    @Override // org.apache.commons.math.stat.inference.UnknownDistributionChiSquareTest
    public boolean chiSquareTestDataSetsComparison(long[] observed1, long[] observed2, double alpha) throws IllegalArgumentException, MathException {
        if (alpha <= 0.0d) goto L12;
        if (alpha > 0.5d) goto L12;
        if (chiSquareTestDataSetsComparison(observed1, observed2) >= alpha) goto L9;
        return true;
    L9:
        return false;
    L12:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.OUT_OF_BOUND_SIGNIFICANCE_LEVEL, new Object[]{Double.valueOf(alpha), Double.valueOf(0.0d), Double.valueOf(0.5d)});
    }

    private void checkArray(long[][] in) throws IllegalArgumentException {
        if (in.length < 2) goto L11;
        if (in[0].length < 2) goto L9;
        checkRectangular(in);
        checkNonNegative(in);
        return;
    L9:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.INSUFFICIENT_DIMENSION, new Object[]{Integer.valueOf(in[0].length), 2});
    L11:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.INSUFFICIENT_DIMENSION, new Object[]{Integer.valueOf(in.length), 2});
    }

    private void checkRectangular(long[][] in) {
        int i = 1;
    L4:
        if (i >= in.length) goto L11;
        if (in[i].length != in[0].length) goto L9;
        i = i + 1;
        goto L4
    L9:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.DIFFERENT_ROWS_LENGTHS, new Object[]{Integer.valueOf(in[i].length), Integer.valueOf(in[0].length)});
    }

    private void checkPositive(double[] in) throws IllegalArgumentException {
        int i = 0;
    L4:
        if (i >= in.length) goto L11;
        if (in[i] <= 0.0d) goto L9;
        i = i + 1;
        goto L4
    L9:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.NOT_POSITIVE_ELEMENT_AT_INDEX, new Object[]{Integer.valueOf(i), Double.valueOf(in[i])});
    }

    private void checkNonNegative(long[] in) throws IllegalArgumentException {
        int i = 0;
    L4:
        if (i >= in.length) goto L11;
        if (in[i] < 0) goto L9;
        i = i + 1;
        goto L4
    L9:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.NEGATIVE_ELEMENT_AT_INDEX, new Object[]{Integer.valueOf(i), Long.valueOf(in[i])});
    }

    private void checkNonNegative(long[][] in) throws IllegalArgumentException {
        int i = 0;
    L4:
        if (i >= in.length) goto L15;
        int j = 0;
    L7:
        if (j >= in[i].length) goto L13;
        if (in[i][j] < 0) goto L12;
        j = j + 1;
        goto L7
    L12:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.NEGATIVE_ELEMENT_AT_2D_INDEX, new Object[]{Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(in[i][j])});
    L13:
        i = i + 1;
        goto L4
    }

    public void setDistribution(ChiSquaredDistribution value) {
        this.distribution = value;
    }
}

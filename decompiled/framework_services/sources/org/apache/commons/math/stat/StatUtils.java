package org.apache.commons.math.stat;

import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math.stat.descriptive.UnivariateStatistic;
import org.apache.commons.math.stat.descriptive.moment.GeometricMean;
import org.apache.commons.math.stat.descriptive.moment.Mean;
import org.apache.commons.math.stat.descriptive.moment.Variance;
import org.apache.commons.math.stat.descriptive.rank.Max;
import org.apache.commons.math.stat.descriptive.rank.Min;
import org.apache.commons.math.stat.descriptive.rank.Percentile;
import org.apache.commons.math.stat.descriptive.summary.Product;
import org.apache.commons.math.stat.descriptive.summary.Sum;
import org.apache.commons.math.stat.descriptive.summary.SumOfLogs;
import org.apache.commons.math.stat.descriptive.summary.SumOfSquares;

/* JADX INFO: loaded from: classes3.dex */
public final class StatUtils {
    private static final GeometricMean GEOMETRIC_MEAN = null;
    private static final UnivariateStatistic MAX = null;
    private static final UnivariateStatistic MEAN = null;
    private static final UnivariateStatistic MIN = null;
    private static final Percentile PERCENTILE = null;
    private static final UnivariateStatistic PRODUCT = null;
    private static final UnivariateStatistic SUM = null;
    private static final UnivariateStatistic SUM_OF_LOGS = null;
    private static final UnivariateStatistic SUM_OF_SQUARES = null;
    private static final Variance VARIANCE = null;

    static {
        SUM = new Sum();
        SUM_OF_SQUARES = new SumOfSquares();
        PRODUCT = new Product();
        SUM_OF_LOGS = new SumOfLogs();
        MIN = new Min();
        MAX = new Max();
        MEAN = new Mean();
        VARIANCE = new Variance();
        PERCENTILE = new Percentile();
        GEOMETRIC_MEAN = new GeometricMean();
    }

    private StatUtils() {
    }

    public static double sum(double[] values) {
        return SUM.evaluate(values);
    }

    public static double sum(double[] values, int begin, int length) {
        return SUM.evaluate(values, begin, length);
    }

    public static double sumSq(double[] values) {
        return SUM_OF_SQUARES.evaluate(values);
    }

    public static double sumSq(double[] values, int begin, int length) {
        return SUM_OF_SQUARES.evaluate(values, begin, length);
    }

    public static double product(double[] values) {
        return PRODUCT.evaluate(values);
    }

    public static double product(double[] values, int begin, int length) {
        return PRODUCT.evaluate(values, begin, length);
    }

    public static double sumLog(double[] values) {
        return SUM_OF_LOGS.evaluate(values);
    }

    public static double sumLog(double[] values, int begin, int length) {
        return SUM_OF_LOGS.evaluate(values, begin, length);
    }

    public static double mean(double[] values) {
        return MEAN.evaluate(values);
    }

    public static double mean(double[] values, int begin, int length) {
        return MEAN.evaluate(values, begin, length);
    }

    public static double geometricMean(double[] values) {
        return GEOMETRIC_MEAN.evaluate(values);
    }

    public static double geometricMean(double[] values, int begin, int length) {
        return GEOMETRIC_MEAN.evaluate(values, begin, length);
    }

    public static double variance(double[] values) {
        return VARIANCE.evaluate(values);
    }

    public static double variance(double[] values, int begin, int length) {
        return VARIANCE.evaluate(values, begin, length);
    }

    public static double variance(double[] values, double mean, int begin, int length) {
        return VARIANCE.evaluate(values, mean, begin, length);
    }

    public static double variance(double[] values, double mean) {
        return VARIANCE.evaluate(values, mean);
    }

    public static double max(double[] values) {
        return MAX.evaluate(values);
    }

    public static double max(double[] values, int begin, int length) {
        return MAX.evaluate(values, begin, length);
    }

    public static double min(double[] values) {
        return MIN.evaluate(values);
    }

    public static double min(double[] values, int begin, int length) {
        return MIN.evaluate(values, begin, length);
    }

    public static double percentile(double[] values, double p) {
        return PERCENTILE.evaluate(values, p);
    }

    public static double percentile(double[] values, int begin, int length, double p) {
        return PERCENTILE.evaluate(values, begin, length, p);
    }

    public static double sumDifference(double[] sample1, double[] sample2) throws IllegalArgumentException {
        int n = sample1.length;
        if (n != sample2.length) goto L14;
        if (n < 1) goto L12;
        double result = 0.0d;
        int i = 0;
    L7:
        if (i >= n) goto L10;
        result = result + (sample1[i] - sample2[i]);
        i = i + 1;
        goto L7
    L10:
        return result;
    L12:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.INSUFFICIENT_DIMENSION, new Object[]{Integer.valueOf(sample2.length), 1});
    L14:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.DIMENSIONS_MISMATCH_SIMPLE, new Object[]{Integer.valueOf(n), Integer.valueOf(sample2.length)});
    }

    public static double meanDifference(double[] sample1, double[] sample2) throws IllegalArgumentException {
        return sumDifference(sample1, sample2) / ((double) sample1.length);
    }

    public static double varianceDifference(double[] sample1, double[] sample2, double meanDifference) throws IllegalArgumentException {
        double sum1 = 0.0d;
        double sum2 = 0.0d;
        int n = sample1.length;
        if (n != sample2.length) goto L14;
        if (n < 2) goto L12;
        int i = 0;
    L7:
        if (i >= n) goto L10;
        double diff = sample1[i] - sample2[i];
        sum1 = sum1 + ((diff - meanDifference) * (diff - meanDifference));
        sum2 = sum2 + (diff - meanDifference);
        i = i + 1;
        goto L7
    L10:
        return (sum1 - ((sum2 * sum2) / ((double) n))) / ((double) (n - 1));
    L12:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.INSUFFICIENT_DIMENSION, new Object[]{Integer.valueOf(n), 2});
    L14:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.DIMENSIONS_MISMATCH_SIMPLE, new Object[]{Integer.valueOf(n), Integer.valueOf(sample2.length)});
    }

    public static double[] normalize(double[] sample) {
        DescriptiveStatistics stats = new DescriptiveStatistics();
        int i = 0;
    L4:
        if (i >= sample.length) goto L6;
        stats.addValue(sample[i]);
        i = i + 1;
        goto L4
    L6:
        double mean = stats.getMean();
        double standardDeviation = stats.getStandardDeviation();
        double[] standardizedSample = new double[sample.length];
        int i2 = 0;
    L8:
        if (i2 >= sample.length) goto L11;
        standardizedSample[i2] = (sample[i2] - mean) / standardDeviation;
        i2 = i2 + 1;
        goto L8
    L11:
        return standardizedSample;
    }
}

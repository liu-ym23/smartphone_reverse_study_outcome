package org.apache.commons.math.analysis.interpolation;

import java.lang.reflect.Array;
import org.apache.commons.math.analysis.TrivariateRealFunction;
import org.apache.commons.math.exception.DimensionMismatchException;
import org.apache.commons.math.exception.NoDataException;
import org.apache.commons.math.exception.OutOfRangeException;
import org.apache.commons.math.util.MathUtils;

/* JADX INFO: loaded from: classes3.dex */
public class TricubicSplineInterpolatingFunction implements TrivariateRealFunction {
    private static final double[][] AINV = null;
    private final TricubicSplineFunction[][][] splines;
    private final double[] xval;
    private final double[] yval;
    private final double[] zval;

    static {
        AINV = new double[][]{new double[]{1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{-3.0d, 3.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -2.0d, -1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{2.0d, -2.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -3.0d, 3.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -2.0d, -1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 2.0d, -2.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{-3.0d, 0.0d, 3.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -2.0d, 0.0d, -1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -3.0d, 0.0d, 3.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -2.0d, 0.0d, -1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{9.0d, -9.0d, -9.0d, 9.0d, 0.0d, 0.0d, 0.0d, 0.0d, 6.0d, 3.0d, -6.0d, -3.0d, 0.0d, 0.0d, 0.0d, 0.0d, 6.0d, -6.0d, 3.0d, -3.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 4.0d, 2.0d, 2.0d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{-6.0d, 6.0d, 6.0d, -6.0d, 0.0d, 0.0d, 0.0d, 0.0d, -3.0d, -3.0d, 3.0d, 3.0d, 0.0d, 0.0d, 0.0d, 0.0d, -4.0d, 4.0d, -2.0d, 2.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -2.0d, -2.0d, -1.0d, -1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{2.0d, 0.0d, -2.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 2.0d, 0.0d, -2.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{-6.0d, 6.0d, 6.0d, -6.0d, 0.0d, 0.0d, 0.0d, 0.0d, -4.0d, -2.0d, 4.0d, 2.0d, 0.0d, 0.0d, 0.0d, 0.0d, -3.0d, 3.0d, -3.0d, 3.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -2.0d, -1.0d, -2.0d, -1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{4.0d, -4.0d, -4.0d, 4.0d, 0.0d, 0.0d, 0.0d, 0.0d, 2.0d, 2.0d, -2.0d, -2.0d, 0.0d, 0.0d, 0.0d, 0.0d, 2.0d, -2.0d, 2.0d, -2.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 1.0d, 1.0d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -3.0d, 3.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -2.0d, -1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 2.0d, -2.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -3.0d, 3.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -2.0d, -1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 2.0d, -2.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -3.0d, 0.0d, 3.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -2.0d, 0.0d, -1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -3.0d, 0.0d, 3.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -2.0d, 0.0d, -1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 9.0d, -9.0d, -9.0d, 9.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 6.0d, 3.0d, -6.0d, -3.0d, 0.0d, 0.0d, 0.0d, 0.0d, 6.0d, -6.0d, 3.0d, -3.0d, 0.0d, 0.0d, 0.0d, 0.0d, 4.0d, 2.0d, 2.0d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -6.0d, 6.0d, 6.0d, -6.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -3.0d, -3.0d, 3.0d, 3.0d, 0.0d, 0.0d, 0.0d, 0.0d, -4.0d, 4.0d, -2.0d, 2.0d, 0.0d, 0.0d, 0.0d, 0.0d, -2.0d, -2.0d, -1.0d, -1.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 2.0d, 0.0d, -2.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 2.0d, 0.0d, -2.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -6.0d, 6.0d, 6.0d, -6.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -4.0d, -2.0d, 4.0d, 2.0d, 0.0d, 0.0d, 0.0d, 0.0d, -3.0d, 3.0d, -3.0d, 3.0d, 0.0d, 0.0d, 0.0d, 0.0d, -2.0d, -1.0d, -2.0d, -1.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 4.0d, -4.0d, -4.0d, 4.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 2.0d, 2.0d, -2.0d, -2.0d, 0.0d, 0.0d, 0.0d, 0.0d, 2.0d, -2.0d, 2.0d, -2.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 1.0d, 1.0d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{-3.0d, 0.0d, 0.0d, 0.0d, 3.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -2.0d, 0.0d, 0.0d, 0.0d, -1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -3.0d, 0.0d, 0.0d, 0.0d, 3.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -2.0d, 0.0d, 0.0d, 0.0d, -1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{9.0d, -9.0d, 0.0d, 0.0d, -9.0d, 9.0d, 0.0d, 0.0d, 6.0d, 3.0d, 0.0d, 0.0d, -6.0d, -3.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 6.0d, -6.0d, 0.0d, 0.0d, 3.0d, -3.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 4.0d, 2.0d, 0.0d, 0.0d, 2.0d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{-6.0d, 6.0d, 0.0d, 0.0d, 6.0d, -6.0d, 0.0d, 0.0d, -3.0d, -3.0d, 0.0d, 0.0d, 3.0d, 3.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -4.0d, 4.0d, 0.0d, 0.0d, -2.0d, 2.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -2.0d, -2.0d, 0.0d, 0.0d, -1.0d, -1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -3.0d, 0.0d, 0.0d, 0.0d, 3.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -2.0d, 0.0d, 0.0d, 0.0d, -1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -3.0d, 0.0d, 0.0d, 0.0d, 3.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -2.0d, 0.0d, 0.0d, 0.0d, -1.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 9.0d, -9.0d, 0.0d, 0.0d, -9.0d, 9.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 6.0d, 3.0d, 0.0d, 0.0d, -6.0d, -3.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 6.0d, -6.0d, 0.0d, 0.0d, 3.0d, -3.0d, 0.0d, 0.0d, 4.0d, 2.0d, 0.0d, 0.0d, 2.0d, 1.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -6.0d, 6.0d, 0.0d, 0.0d, 6.0d, -6.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -3.0d, -3.0d, 0.0d, 0.0d, 3.0d, 3.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -4.0d, 4.0d, 0.0d, 0.0d, -2.0d, 2.0d, 0.0d, 0.0d, -2.0d, -2.0d, 0.0d, 0.0d, -1.0d, -1.0d, 0.0d, 0.0d}, new double[]{9.0d, 0.0d, -9.0d, 0.0d, -9.0d, 0.0d, 9.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 6.0d, 0.0d, 3.0d, 0.0d, -6.0d, 0.0d, -3.0d, 0.0d, 6.0d, 0.0d, -6.0d, 0.0d, 3.0d, 0.0d, -3.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 4.0d, 0.0d, 2.0d, 0.0d, 2.0d, 0.0d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 9.0d, 0.0d, -9.0d, 0.0d, -9.0d, 0.0d, 9.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 6.0d, 0.0d, 3.0d, 0.0d, -6.0d, 0.0d, -3.0d, 0.0d, 6.0d, 0.0d, -6.0d, 0.0d, 3.0d, 0.0d, -3.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 4.0d, 0.0d, 2.0d, 0.0d, 2.0d, 0.0d, 1.0d, 0.0d}, new double[]{-27.0d, 27.0d, 27.0d, -27.0d, 27.0d, -27.0d, -27.0d, 27.0d, -18.0d, -9.0d, 18.0d, 9.0d, 18.0d, 9.0d, -18.0d, -9.0d, -18.0d, 18.0d, -9.0d, 9.0d, 18.0d, -18.0d, 9.0d, -9.0d, -18.0d, 18.0d, 18.0d, -18.0d, -9.0d, 9.0d, 9.0d, -9.0d, -12.0d, -6.0d, -6.0d, -3.0d, 12.0d, 6.0d, 6.0d, 3.0d, -12.0d, -6.0d, 12.0d, 6.0d, -6.0d, -3.0d, 6.0d, 3.0d, -12.0d, 12.0d, -6.0d, 6.0d, -6.0d, 6.0d, -3.0d, 3.0d, -8.0d, -4.0d, -4.0d, -2.0d, -4.0d, -2.0d, -2.0d, -1.0d}, new double[]{18.0d, -18.0d, -18.0d, 18.0d, -18.0d, 18.0d, 18.0d, -18.0d, 9.0d, 9.0d, -9.0d, -9.0d, -9.0d, -9.0d, 9.0d, 9.0d, 12.0d, -12.0d, 6.0d, -6.0d, -12.0d, 12.0d, -6.0d, 6.0d, 12.0d, -12.0d, -12.0d, 12.0d, 6.0d, -6.0d, -6.0d, 6.0d, 6.0d, 6.0d, 3.0d, 3.0d, -6.0d, -6.0d, -3.0d, -3.0d, 6.0d, 6.0d, -6.0d, -6.0d, 3.0d, 3.0d, -3.0d, -3.0d, 8.0d, -8.0d, 4.0d, -4.0d, 4.0d, -4.0d, 2.0d, -2.0d, 4.0d, 4.0d, 2.0d, 2.0d, 2.0d, 2.0d, 1.0d, 1.0d}, new double[]{-6.0d, 0.0d, 6.0d, 0.0d, 6.0d, 0.0d, -6.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -3.0d, 0.0d, -3.0d, 0.0d, 3.0d, 0.0d, 3.0d, 0.0d, -4.0d, 0.0d, 4.0d, 0.0d, -2.0d, 0.0d, 2.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -2.0d, 0.0d, -2.0d, 0.0d, -1.0d, 0.0d, -1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -6.0d, 0.0d, 6.0d, 0.0d, 6.0d, 0.0d, -6.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -3.0d, 0.0d, -3.0d, 0.0d, 3.0d, 0.0d, 3.0d, 0.0d, -4.0d, 0.0d, 4.0d, 0.0d, -2.0d, 0.0d, 2.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -2.0d, 0.0d, -2.0d, 0.0d, -1.0d, 0.0d, -1.0d, 0.0d}, new double[]{18.0d, -18.0d, -18.0d, 18.0d, -18.0d, 18.0d, 18.0d, -18.0d, 12.0d, 6.0d, -12.0d, -6.0d, -12.0d, -6.0d, 12.0d, 6.0d, 9.0d, -9.0d, 9.0d, -9.0d, -9.0d, 9.0d, -9.0d, 9.0d, 12.0d, -12.0d, -12.0d, 12.0d, 6.0d, -6.0d, -6.0d, 6.0d, 6.0d, 3.0d, 6.0d, 3.0d, -6.0d, -3.0d, -6.0d, -3.0d, 8.0d, 4.0d, -8.0d, -4.0d, 4.0d, 2.0d, -4.0d, -2.0d, 6.0d, -6.0d, 6.0d, -6.0d, 3.0d, -3.0d, 3.0d, -3.0d, 4.0d, 2.0d, 4.0d, 2.0d, 2.0d, 1.0d, 2.0d, 1.0d}, new double[]{-12.0d, 12.0d, 12.0d, -12.0d, 12.0d, -12.0d, -12.0d, 12.0d, -6.0d, -6.0d, 6.0d, 6.0d, 6.0d, 6.0d, -6.0d, -6.0d, -6.0d, 6.0d, -6.0d, 6.0d, 6.0d, -6.0d, 6.0d, -6.0d, -8.0d, 8.0d, 8.0d, -8.0d, -4.0d, 4.0d, 4.0d, -4.0d, -3.0d, -3.0d, -3.0d, -3.0d, 3.0d, 3.0d, 3.0d, 3.0d, -4.0d, -4.0d, 4.0d, 4.0d, -2.0d, -2.0d, 2.0d, 2.0d, -4.0d, 4.0d, -4.0d, 4.0d, -2.0d, 2.0d, -2.0d, 2.0d, -2.0d, -2.0d, -2.0d, -2.0d, -1.0d, -1.0d, -1.0d, -1.0d}, new double[]{2.0d, 0.0d, 0.0d, 0.0d, -2.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 2.0d, 0.0d, 0.0d, 0.0d, -2.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{-6.0d, 6.0d, 0.0d, 0.0d, 6.0d, -6.0d, 0.0d, 0.0d, -4.0d, -2.0d, 0.0d, 0.0d, 4.0d, 2.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -3.0d, 3.0d, 0.0d, 0.0d, -3.0d, 3.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -2.0d, -1.0d, 0.0d, 0.0d, -2.0d, -1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{4.0d, -4.0d, 0.0d, 0.0d, -4.0d, 4.0d, 0.0d, 0.0d, 2.0d, 2.0d, 0.0d, 0.0d, -2.0d, -2.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 2.0d, -2.0d, 0.0d, 0.0d, 2.0d, -2.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 1.0d, 0.0d, 0.0d, 1.0d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 2.0d, 0.0d, 0.0d, 0.0d, -2.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 2.0d, 0.0d, 0.0d, 0.0d, -2.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -6.0d, 6.0d, 0.0d, 0.0d, 6.0d, -6.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -4.0d, -2.0d, 0.0d, 0.0d, 4.0d, 2.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -3.0d, 3.0d, 0.0d, 0.0d, -3.0d, 3.0d, 0.0d, 0.0d, -2.0d, -1.0d, 0.0d, 0.0d, -2.0d, -1.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 4.0d, -4.0d, 0.0d, 0.0d, -4.0d, 4.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 2.0d, 2.0d, 0.0d, 0.0d, -2.0d, -2.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 2.0d, -2.0d, 0.0d, 0.0d, 2.0d, -2.0d, 0.0d, 0.0d, 1.0d, 1.0d, 0.0d, 0.0d, 1.0d, 1.0d, 0.0d, 0.0d}, new double[]{-6.0d, 0.0d, 6.0d, 0.0d, 6.0d, 0.0d, -6.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -4.0d, 0.0d, -2.0d, 0.0d, 4.0d, 0.0d, 2.0d, 0.0d, -3.0d, 0.0d, 3.0d, 0.0d, -3.0d, 0.0d, 3.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -2.0d, 0.0d, -1.0d, 0.0d, -2.0d, 0.0d, -1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -6.0d, 0.0d, 6.0d, 0.0d, 6.0d, 0.0d, -6.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -4.0d, 0.0d, -2.0d, 0.0d, 4.0d, 0.0d, 2.0d, 0.0d, -3.0d, 0.0d, 3.0d, 0.0d, -3.0d, 0.0d, 3.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -2.0d, 0.0d, -1.0d, 0.0d, -2.0d, 0.0d, -1.0d, 0.0d}, new double[]{18.0d, -18.0d, -18.0d, 18.0d, -18.0d, 18.0d, 18.0d, -18.0d, 12.0d, 6.0d, -12.0d, -6.0d, -12.0d, -6.0d, 12.0d, 6.0d, 12.0d, -12.0d, 6.0d, -6.0d, -12.0d, 12.0d, -6.0d, 6.0d, 9.0d, -9.0d, -9.0d, 9.0d, 9.0d, -9.0d, -9.0d, 9.0d, 8.0d, 4.0d, 4.0d, 2.0d, -8.0d, -4.0d, -4.0d, -2.0d, 6.0d, 3.0d, -6.0d, -3.0d, 6.0d, 3.0d, -6.0d, -3.0d, 6.0d, -6.0d, 3.0d, -3.0d, 6.0d, -6.0d, 3.0d, -3.0d, 4.0d, 2.0d, 2.0d, 1.0d, 4.0d, 2.0d, 2.0d, 1.0d}, new double[]{-12.0d, 12.0d, 12.0d, -12.0d, 12.0d, -12.0d, -12.0d, 12.0d, -6.0d, -6.0d, 6.0d, 6.0d, 6.0d, 6.0d, -6.0d, -6.0d, -8.0d, 8.0d, -4.0d, 4.0d, 8.0d, -8.0d, 4.0d, -4.0d, -6.0d, 6.0d, 6.0d, -6.0d, -6.0d, 6.0d, 6.0d, -6.0d, -4.0d, -4.0d, -2.0d, -2.0d, 4.0d, 4.0d, 2.0d, 2.0d, -3.0d, -3.0d, 3.0d, 3.0d, -3.0d, -3.0d, 3.0d, 3.0d, -4.0d, 4.0d, -2.0d, 2.0d, -4.0d, 4.0d, -2.0d, 2.0d, -2.0d, -2.0d, -1.0d, -1.0d, -2.0d, -2.0d, -1.0d, -1.0d}, new double[]{4.0d, 0.0d, -4.0d, 0.0d, -4.0d, 0.0d, 4.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 2.0d, 0.0d, 2.0d, 0.0d, -2.0d, 0.0d, -2.0d, 0.0d, 2.0d, 0.0d, -2.0d, 0.0d, 2.0d, 0.0d, -2.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 1.0d, 0.0d, 1.0d, 0.0d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 4.0d, 0.0d, -4.0d, 0.0d, -4.0d, 0.0d, 4.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 2.0d, 0.0d, 2.0d, 0.0d, -2.0d, 0.0d, -2.0d, 0.0d, 2.0d, 0.0d, -2.0d, 0.0d, 2.0d, 0.0d, -2.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 1.0d, 0.0d, 1.0d, 0.0d, 1.0d, 0.0d}, new double[]{-12.0d, 12.0d, 12.0d, -12.0d, 12.0d, -12.0d, -12.0d, 12.0d, -8.0d, -4.0d, 8.0d, 4.0d, 8.0d, 4.0d, -8.0d, -4.0d, -6.0d, 6.0d, -6.0d, 6.0d, 6.0d, -6.0d, 6.0d, -6.0d, -6.0d, 6.0d, 6.0d, -6.0d, -6.0d, 6.0d, 6.0d, -6.0d, -4.0d, -2.0d, -4.0d, -2.0d, 4.0d, 2.0d, 4.0d, 2.0d, -4.0d, -2.0d, 4.0d, 2.0d, -4.0d, -2.0d, 4.0d, 2.0d, -3.0d, 3.0d, -3.0d, 3.0d, -3.0d, 3.0d, -3.0d, 3.0d, -2.0d, -1.0d, -2.0d, -1.0d, -2.0d, -1.0d, -2.0d, -1.0d}, new double[]{8.0d, -8.0d, -8.0d, 8.0d, -8.0d, 8.0d, 8.0d, -8.0d, 4.0d, 4.0d, -4.0d, -4.0d, -4.0d, -4.0d, 4.0d, 4.0d, 4.0d, -4.0d, 4.0d, -4.0d, -4.0d, 4.0d, -4.0d, 4.0d, 4.0d, -4.0d, -4.0d, 4.0d, 4.0d, -4.0d, -4.0d, 4.0d, 2.0d, 2.0d, 2.0d, 2.0d, -2.0d, -2.0d, -2.0d, -2.0d, 2.0d, 2.0d, -2.0d, -2.0d, 2.0d, 2.0d, -2.0d, -2.0d, 2.0d, -2.0d, 2.0d, -2.0d, 2.0d, -2.0d, 2.0d, -2.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d}};
    }

    public TricubicSplineInterpolatingFunction(double[] x, double[] y, double[] z, double[][][] f, double[][][] dFdX, double[][][] dFdY, double[][][] dFdZ, double[][][] d2FdXdY, double[][][] d2FdXdZ, double[][][] d2FdYdZ, double[][][] d3FdXdYdZ) {
        int xLen = x.length;
        int yLen = y.length;
        int zLen = z.length;
        if (xLen == 0) goto L119;
        if (yLen == 0) goto L119;
        if (z.length == 0) goto L119;
        if (f.length == 0) goto L119;
        if (f[0].length == 0) goto L119;
        if (xLen != f.length) goto L117;
        if (xLen != dFdX.length) goto L115;
        if (xLen != dFdY.length) goto L113;
        if (xLen != dFdZ.length) goto L111;
        if (xLen != d2FdXdY.length) goto L109;
        if (xLen != d2FdXdZ.length) goto L107;
        if (xLen != d2FdYdZ.length) goto L105;
        if (xLen != d3FdXdYdZ.length) goto L103;
        MathUtils.checkOrder(x);
        MathUtils.checkOrder(y);
        MathUtils.checkOrder(z);
        this.xval = (double[]) x.clone();
        this.yval = (double[]) y.clone();
        this.zval = (double[]) z.clone();
        int lastI = xLen - 1;
        int lastJ = yLen - 1;
        int lastK = zLen - 1;
        this.splines = (TricubicSplineFunction[][][]) Array.newInstance(TricubicSplineFunction.class, new int[]{lastI, lastJ, lastK});
        int j = 0;
    L28:
        if (j >= lastI) goto L101;
        if (f[j].length != yLen) goto L98;
        if (dFdX[j].length != yLen) goto L96;
        if (dFdY[j].length != yLen) goto L94;
        if (dFdZ[j].length != yLen) goto L92;
        if (d2FdXdY[j].length != yLen) goto L90;
        if (d2FdXdZ[j].length != yLen) goto L88;
        if (d2FdYdZ[j].length != yLen) goto L86;
        if (d3FdXdYdZ[j].length != yLen) goto L84;
        int ip1 = j + 1;
        int i = j;
        int j2 = 0;
    L46:
        if (j2 >= lastJ) goto L83;
        int lastJ2 = lastJ;
        if (f[i][j2].length != zLen) goto L82;
        if (dFdX[i][j2].length != zLen) goto L80;
        if (dFdY[i][j2].length != zLen) goto L78;
        if (dFdZ[i][j2].length != zLen) goto L76;
        if (d2FdXdY[i][j2].length != zLen) goto L74;
        if (d2FdXdZ[i][j2].length != zLen) goto L72;
        if (d2FdYdZ[i][j2].length != zLen) goto L70;
        if (d3FdXdYdZ[i][j2].length != zLen) goto L68;
        int jp1 = j2 + 1;
        int jp2 = 0;
    L64:
        if (jp2 >= lastK) goto L66;
        int kp1 = jp2 + 1;
        int k = jp2;
        double[] beta = {f[i][j2][jp2], f[ip1][j2][jp2], f[i][jp1][jp2], f[ip1][jp1][jp2], f[i][j2][kp1], f[ip1][j2][kp1], f[i][jp1][kp1], f[ip1][jp1][kp1], dFdX[i][j2][jp2], dFdX[ip1][j2][jp2], dFdX[i][jp1][jp2], dFdX[ip1][jp1][jp2], dFdX[i][j2][kp1], dFdX[ip1][j2][kp1], dFdX[i][jp1][kp1], dFdX[ip1][jp1][kp1], dFdY[i][j2][jp2], dFdY[ip1][j2][jp2], dFdY[i][jp1][jp2], dFdY[ip1][jp1][jp2], dFdY[i][j2][kp1], dFdY[ip1][j2][kp1], dFdY[i][jp1][kp1], dFdY[ip1][jp1][kp1], dFdZ[i][j2][jp2], dFdZ[ip1][j2][jp2], dFdZ[i][jp1][jp2], dFdZ[ip1][jp1][jp2], dFdZ[i][j2][kp1], dFdZ[ip1][j2][kp1], dFdZ[i][jp1][kp1], dFdZ[ip1][jp1][kp1], d2FdXdY[i][j2][jp2], d2FdXdY[ip1][j2][jp2], d2FdXdY[i][jp1][jp2], d2FdXdY[ip1][jp1][jp2], d2FdXdY[i][j2][kp1], d2FdXdY[ip1][j2][kp1], d2FdXdY[i][jp1][kp1], d2FdXdY[ip1][jp1][kp1], d2FdXdZ[i][j2][jp2], d2FdXdZ[ip1][j2][jp2], d2FdXdZ[i][jp1][jp2], d2FdXdZ[ip1][jp1][jp2], d2FdXdZ[i][j2][kp1], d2FdXdZ[ip1][j2][kp1], d2FdXdZ[i][jp1][kp1], d2FdXdZ[ip1][jp1][kp1], d2FdYdZ[i][j2][jp2], d2FdYdZ[ip1][j2][jp2], d2FdYdZ[i][jp1][jp2], d2FdYdZ[ip1][jp1][jp2], d2FdYdZ[i][j2][kp1], d2FdYdZ[ip1][j2][kp1], d2FdYdZ[i][jp1][kp1], d2FdYdZ[ip1][jp1][kp1], d3FdXdYdZ[i][j2][jp2], d3FdXdYdZ[ip1][j2][jp2], d3FdXdYdZ[i][jp1][jp2], d3FdXdYdZ[ip1][jp1][jp2], d3FdXdYdZ[i][j2][kp1], d3FdXdYdZ[ip1][j2][kp1], d3FdXdYdZ[i][jp1][kp1], d3FdXdYdZ[ip1][jp1][kp1]};
        int j3 = j2;
        this.splines[i][j3][k] = new TricubicSplineFunction(computeSplineCoefficients(beta));
        jp2 = k + 1;
        j2 = j3;
        lastK = lastK;
        goto L64
    L66:
        j2 = j2 + 1;
        lastJ = lastJ2;
        goto L46
    L68:
        throw new DimensionMismatchException(d3FdXdYdZ[i][j2].length, zLen);
    L70:
        throw new DimensionMismatchException(d2FdYdZ[i][j2].length, zLen);
    L72:
        throw new DimensionMismatchException(d2FdXdZ[i][j2].length, zLen);
    L74:
        throw new DimensionMismatchException(d2FdXdY[i][j2].length, zLen);
    L76:
        throw new DimensionMismatchException(dFdZ[i][j2].length, zLen);
    L78:
        throw new DimensionMismatchException(dFdY[i][j2].length, zLen);
    L80:
        throw new DimensionMismatchException(dFdX[i][j2].length, zLen);
    L82:
        throw new DimensionMismatchException(f[i][j2].length, zLen);
    L83:
        j = i + 1;
        goto L28
    L84:
        int i2 = j;
        throw new DimensionMismatchException(d3FdXdYdZ[i2].length, yLen);
    L86:
        int i3 = j;
        throw new DimensionMismatchException(d2FdYdZ[i3].length, yLen);
    L88:
        int i4 = j;
        throw new DimensionMismatchException(d2FdXdZ[i4].length, yLen);
    L90:
        int i5 = j;
        throw new DimensionMismatchException(d2FdXdY[i5].length, yLen);
    L92:
        int i6 = j;
        throw new DimensionMismatchException(dFdZ[i6].length, yLen);
    L94:
        int i7 = j;
        throw new DimensionMismatchException(dFdY[i7].length, yLen);
    L96:
        int i8 = j;
        throw new DimensionMismatchException(dFdX[i8].length, yLen);
    L98:
        int i9 = j;
        throw new DimensionMismatchException(f[i9].length, yLen);
    L101:
        return;
    L103:
        throw new DimensionMismatchException(xLen, d3FdXdYdZ.length);
    L105:
        throw new DimensionMismatchException(xLen, d2FdYdZ.length);
    L107:
        throw new DimensionMismatchException(xLen, d2FdXdZ.length);
    L109:
        throw new DimensionMismatchException(xLen, d2FdXdY.length);
    L111:
        throw new DimensionMismatchException(xLen, dFdZ.length);
    L113:
        throw new DimensionMismatchException(xLen, dFdY.length);
    L115:
        throw new DimensionMismatchException(xLen, dFdX.length);
    L117:
        throw new DimensionMismatchException(xLen, f.length);
    L119:
        throw new NoDataException();
    }

    @Override // org.apache.commons.math.analysis.TrivariateRealFunction
    public double value(double x, double y, double z) {
        int i = searchIndex(x, this.xval);
        if (i == (-1)) goto L15;
        int j = searchIndex(y, this.yval);
        if (j == (-1)) goto L13;
        int k = searchIndex(z, this.zval);
        if (k == (-1)) goto L11;
        double xN = (x - this.xval[i]) / (this.xval[i + 1] - this.xval[i]);
        double yN = (y - this.yval[j]) / (this.yval[j + 1] - this.yval[j]);
        double zN = (z - this.zval[k]) / (this.zval[k + 1] - this.zval[k]);
        return this.splines[i][j][k].value(xN, yN, zN);
    L11:
        throw new OutOfRangeException(Double.valueOf(z), Double.valueOf(this.zval[0]), Double.valueOf(this.zval[this.zval.length - 1]));
    L13:
        throw new OutOfRangeException(Double.valueOf(y), Double.valueOf(this.yval[0]), Double.valueOf(this.yval[this.yval.length - 1]));
    L15:
        throw new OutOfRangeException(Double.valueOf(x), Double.valueOf(this.xval[0]), Double.valueOf(this.xval[this.xval.length - 1]));
    }

    private int searchIndex(double c, double[] val) {
        if (c >= val[0]) goto L5;
        return -1;
    L5:
        int max = val.length;
        int i = 1;
    L6:
        if (i >= max) goto L13;
        if (c <= val[i]) goto L10;
        i = i + 1;
        goto L6
    L10:
        return i - 1;
    L13:
        return -1;
    }

    private double[] computeSplineCoefficients(double[] beta) {
        double[] a = new double[64];
        int i = 0;
    L3:
        if (i >= 64) goto L9;
        double result = 0.0d;
        double[] row = AINV[i];
        int j = 0;
    L5:
        if (j >= 64) goto L7;
        result = result + (row[j] * beta[j]);
        j = j + 1;
        goto L5
    L7:
        a[i] = result;
        i = i + 1;
        goto L3
    L9:
        return a;
    }
}

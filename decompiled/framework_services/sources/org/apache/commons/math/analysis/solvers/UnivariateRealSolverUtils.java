package org.apache.commons.math.analysis.solvers;

import org.apache.commons.math.ConvergenceException;
import org.apache.commons.math.FunctionEvaluationException;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.analysis.UnivariateRealFunction;
import org.apache.commons.math.exception.NullArgumentException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class UnivariateRealSolverUtils {

    private static class LazyHolder {
        private static final UnivariateRealSolverFactory FACTORY = null;

        private LazyHolder() {
        }

        static /* synthetic */ UnivariateRealSolverFactory access$000() {
            return FACTORY;
        }

        static {
            FACTORY = UnivariateRealSolverFactory.newInstance();
        }
    }

    private UnivariateRealSolverUtils() {
    }

    public static double solve(UnivariateRealFunction f, double x0, double x1) throws ConvergenceException, FunctionEvaluationException {
        setup(f);
        return LazyHolder.access$000().newDefaultSolver().solve(f, x0, x1);
    }

    public static double solve(UnivariateRealFunction f, double x0, double x1, double absoluteAccuracy) throws ConvergenceException, FunctionEvaluationException {
        setup(f);
        UnivariateRealSolver solver = LazyHolder.access$000().newDefaultSolver();
        solver.setAbsoluteAccuracy(absoluteAccuracy);
        return solver.solve(f, x0, x1);
    }

    public static double[] bracket(UnivariateRealFunction function, double initial, double lowerBound, double upperBound) throws ConvergenceException, FunctionEvaluationException {
        return bracket(function, initial, lowerBound, upperBound, Integer.MAX_VALUE);
    }

    public static double[] bracket(UnivariateRealFunction function, double initial, double lowerBound, double upperBound, int maximumIterations) throws ConvergenceException, FunctionEvaluationException {
        if (function == null) goto L30;
        if (maximumIterations <= 0) goto L28;
        if (initial < lowerBound) goto L26;
        if (initial > upperBound) goto L26;
        if (lowerBound >= upperBound) goto L26;
        double a = initial;
        double b = initial;
        int numIterations = 0;
    L12:
        a = FastMath.max(a - 1.0d, lowerBound);
        b = FastMath.min(1.0d + b, upperBound);
        double fa = function.value(a);
        double fb = function.value(b);
        numIterations = numIterations + 1;
        if ((fa * fb) <= 0.0d) goto L20;
        if (numIterations >= maximumIterations) goto L20;
        if (a > lowerBound) goto L12;
        if (b < upperBound) goto L12;
    L20:
        if ((fa * fb) > 0.0d) goto L24;
        return new double[]{a, b};
    L24:
        throw new ConvergenceException(LocalizedFormats.FAILED_BRACKETING, new Object[]{Integer.valueOf(numIterations), Integer.valueOf(maximumIterations), Double.valueOf(initial), Double.valueOf(lowerBound), Double.valueOf(upperBound), Double.valueOf(a), Double.valueOf(b), Double.valueOf(fa), Double.valueOf(fb)});
    L26:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.INVALID_BRACKETING_PARAMETERS, new Object[]{Double.valueOf(lowerBound), Double.valueOf(initial), Double.valueOf(upperBound)});
    L28:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.INVALID_MAX_ITERATIONS, new Object[]{Integer.valueOf(maximumIterations)});
    L30:
        throw new NullArgumentException(LocalizedFormats.FUNCTION);
    }

    public static double midpoint(double a, double b) {
        return (a + b) * 0.5d;
    }

    private static void setup(UnivariateRealFunction f) {
        if (f == null) goto L5;
        return;
    L5:
        throw new NullArgumentException(LocalizedFormats.FUNCTION);
    }
}

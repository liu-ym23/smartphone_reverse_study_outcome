package org.apache.commons.math.analysis.solvers;

import org.apache.commons.math.FunctionEvaluationException;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.MaxIterationsExceededException;
import org.apache.commons.math.analysis.UnivariateRealFunction;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class BrentSolver extends UnivariateRealSolverImpl {
    public static final double DEFAULT_ABSOLUTE_ACCURACY = 1.0E-6d;
    public static final int DEFAULT_MAXIMUM_ITERATIONS = 100;
    private static final long serialVersionUID = 7694577816772532779L;

    @Deprecated
    public BrentSolver(UnivariateRealFunction f) {
        super(f, 100, 1.0E-6d);
    }

    @Deprecated
    public BrentSolver() {
        super(100, 1.0E-6d);
    }

    public BrentSolver(double absoluteAccuracy) {
        super(100, absoluteAccuracy);
    }

    public BrentSolver(int maximumIterations, double absoluteAccuracy) {
        super(maximumIterations, absoluteAccuracy);
    }

    @Override // org.apache.commons.math.analysis.solvers.UnivariateRealSolver
    @Deprecated
    public double solve(double min, double max) throws MaxIterationsExceededException, FunctionEvaluationException {
        return solve(this.f, min, max);
    }

    @Override // org.apache.commons.math.analysis.solvers.UnivariateRealSolver
    @Deprecated
    public double solve(double min, double max, double initial) throws MaxIterationsExceededException, FunctionEvaluationException {
        return solve(this.f, min, max, initial);
    }

    @Override // org.apache.commons.math.analysis.solvers.UnivariateRealSolver
    @Deprecated
    public double solve(UnivariateRealFunction f, double min, double max, double initial) throws MaxIterationsExceededException, FunctionEvaluationException {
        clearResult();
        if (initial < min) goto L29;
        if (initial > max) goto L29;
        double yInitial = f.value(initial);
        if (FastMath.abs(yInitial) > this.functionValueAccuracy) goto L10;
        setResult(initial, 0);
        return this.result;
    L10:
        double yMin = f.value(min);
        if (FastMath.abs(yMin) > this.functionValueAccuracy) goto L15;
        setResult(min, 0);
        return this.result;
    L15:
        if ((yInitial * yMin) < 0.0d) goto L17;
        double yMax = f.value(max);
        if (FastMath.abs(yMax) > this.functionValueAccuracy) goto L23;
        setResult(max, 0);
        return this.result;
    L23:
        if ((yInitial * yMax) >= 0.0d) goto L27;
        return solve(f, initial, yInitial, max, yMax, initial, yInitial);
    L27:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.SAME_SIGN_AT_ENDPOINTS, new Object[]{Double.valueOf(min), Double.valueOf(max), Double.valueOf(yMin), Double.valueOf(yMax)});
    L17:
        return solve(f, min, yMin, initial, yInitial, min, yMin);
    L29:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.INVALID_INTERVAL_INITIAL_VALUE_PARAMETERS, new Object[]{Double.valueOf(min), Double.valueOf(initial), Double.valueOf(max)});
    }

    @Override // org.apache.commons.math.analysis.solvers.UnivariateRealSolverImpl
    public double solve(int maxEval, UnivariateRealFunction f, double min, double max, double initial) throws MaxIterationsExceededException, FunctionEvaluationException {
        setMaximalIterationCount(maxEval);
        return solve(f, min, max, initial);
    }

    @Override // org.apache.commons.math.analysis.solvers.UnivariateRealSolver
    @Deprecated
    public double solve(UnivariateRealFunction f, double min, double max) throws MaxIterationsExceededException, FunctionEvaluationException {
        clearResult();
        verifyInterval(min, max);
        double yMin = f.value(min);
        double yMax = f.value(max);
        double sign = yMin * yMax;
        if (sign <= 0.0d) goto L13;
        if (FastMath.abs(yMin) > this.functionValueAccuracy) goto L8;
        setResult(min, 0);
        return min;
    L8:
        if (FastMath.abs(yMax) > this.functionValueAccuracy) goto L11;
        setResult(max, 0);
        return max;
    L11:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.SAME_SIGN_AT_ENDPOINTS, new Object[]{Double.valueOf(min), Double.valueOf(max), Double.valueOf(yMin), Double.valueOf(yMax)});
    L13:
        if (sign >= 0.0d) goto L16;
        double ret = solve(f, min, yMin, max, yMax, min, yMin);
        return ret;
    L16:
        if (yMin != 0.0d) goto L19;
        return min;
    L19:
        return max;
    }

    @Override // org.apache.commons.math.analysis.solvers.UnivariateRealSolverImpl
    public double solve(int maxEval, UnivariateRealFunction f, double min, double max) throws MaxIterationsExceededException, FunctionEvaluationException {
        setMaximalIterationCount(maxEval);
        return solve(f, min, max);
    }

    private double solve(UnivariateRealFunction f, double x0, double y0, double x1, double y1, double x2, double y2) throws MaxIterationsExceededException, FunctionEvaluationException {
        double delta = x1 - x0;
        double y3 = y1;
        double x3 = x2;
        double y4 = y2;
        double delta2 = delta;
        double oldDelta = delta;
        int i = 0;
        double y5 = y0;
        double x4 = x1;
    L4:
        if (i >= this.maximalIterationCount) goto L60;
        if (FastMath.abs(y4) >= FastMath.abs(y3)) goto L8;
        double x5 = x4;
        x4 = x3;
        x3 = x5;
        y5 = y3;
        y3 = y4;
        y4 = y5;
    L9:
        double y6 = y5;
        if (FastMath.abs(y3) <= this.functionValueAccuracy) goto L11;
        double dx = x3 - x4;
        double r2 = this.relativeAccuracy * FastMath.abs(x4);
        double y7 = y3;
        double y8 = this.absoluteAccuracy;
        double tolerance = FastMath.max(r2, y8);
        if (FastMath.abs(dx) <= tolerance) goto L15;
        if (FastMath.abs(oldDelta) >= tolerance) goto L20;
        double r45 = 0.5d;
    L38:
        delta2 = dx * r45;
        double oldDelta2 = delta2;
    L39:
        double x6 = x4;
        if (FastMath.abs(delta2) <= tolerance) goto L43;
        x4 = x4 + delta2;
    L48:
        double y9 = f.value(x4);
        x0 = x6;
        if (y9 <= 0.0d) goto L51;
        boolean r1 = true;
    L53:
        if (y4 <= 0.0d) goto L55;
        boolean r3 = true;
    L56:
        if (r1 != r3) goto L58;
        double y10 = x4 - x0;
        oldDelta2 = y10;
        delta2 = y10;
        y4 = y7;
        x3 = x0;
    L58:
        i = i + 1;
        oldDelta = oldDelta2;
        y5 = y7;
        y3 = y9;
        goto L4
    L55:
        r3 = false;
        goto L56
    L51:
        r1 = false;
        goto L53
    L43:
        if (dx <= 0.0d) goto L46;
        x4 = x4 + (tolerance * r45);
        goto L48
    L46:
        if (dx > 0.0d) goto L48;
        x4 = x4 - (tolerance * r45);
        goto L48
    L20:
        if (FastMath.abs(y6) > FastMath.abs(y7)) goto L22;
        r45 = 0.5d;
        goto L38
    L22:
        double r4 = y7 / y6;
        if (x5 != x3) goto L25;
        double p1 = 1.0d - r4;
        double p = dx * r4;
        r45 = 0.5d;
    L27:
        if (p <= 0.0d) goto L29;
        p1 = -p1;
    L31:
        if ((2.0d * p) < (((1.5d * dx) * p1) - FastMath.abs(tolerance * p1))) goto L33;
    L36:
        delta2 = dx * r45;
        oldDelta2 = delta2;
        goto L39
    L33:
        if (p >= FastMath.abs((oldDelta * r45) * p1)) goto L36;
        oldDelta2 = delta2;
        delta2 = p / p1;
        goto L39
    L29:
        p = -p;
        goto L31
    L25:
        double p2 = y6 / y4;
        double r5 = y7 / y4;
        p1 = (r4 - 1.0d) * ((p2 - 1.0d) * (r5 - 1.0d));
        p = (((dx * p2) * (p2 - r5)) - ((x4 - x5) * (r5 - 1.0d))) * r4;
        r45 = 0.5d;
        goto L27
    L15:
        setResult(x4, i);
        return this.result;
    L11:
        setResult(x4, i);
        return this.result;
    L8:
        x5 = x0;
        goto L9
    L60:
        throw new MaxIterationsExceededException(this.maximalIterationCount);
    }
}

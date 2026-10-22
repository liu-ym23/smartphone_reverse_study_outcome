package org.apache.commons.math.optimization.direct;

import java.lang.reflect.Array;
import org.apache.commons.math.FunctionEvaluationException;
import org.apache.commons.math.MaxIterationsExceededException;
import org.apache.commons.math.analysis.UnivariateRealFunction;
import org.apache.commons.math.optimization.GoalType;
import org.apache.commons.math.optimization.OptimizationException;
import org.apache.commons.math.optimization.RealPointValuePair;
import org.apache.commons.math.optimization.general.AbstractScalarDifferentiableOptimizer;
import org.apache.commons.math.optimization.univariate.AbstractUnivariateRealOptimizer;
import org.apache.commons.math.optimization.univariate.BracketFinder;
import org.apache.commons.math.optimization.univariate.BrentOptimizer;

/* JADX INFO: loaded from: classes3.dex */
public class PowellOptimizer extends AbstractScalarDifferentiableOptimizer {
    public static final double DEFAULT_LS_ABSOLUTE_TOLERANCE = 1.0E-11d;
    public static final double DEFAULT_LS_RELATIVE_TOLERANCE = 1.0E-7d;
    private final LineSearch line;

    private class LineSearch {
        private final BracketFinder bracket;
        private final AbstractUnivariateRealOptimizer optim;
        private double optimum;
        final /* synthetic */ PowellOptimizer this$0;
        private double valueAtOptimum;

        public LineSearch(PowellOptimizer r3, double relativeTolerance, double absoluteTolerance) {
            this.this$0 = r3;
            this.optim = new BrentOptimizer();
            this.bracket = new BracketFinder();
            this.optimum = Double.NaN;
            this.valueAtOptimum = Double.NaN;
            this.optim.setRelativeAccuracy(relativeTolerance);
            this.optim.setAbsoluteAccuracy(absoluteTolerance);
        }

        public void search(final double[] p, final double[] d) throws OptimizationException, FunctionEvaluationException {
            this.optimum = Double.NaN;
            this.valueAtOptimum = Double.NaN;
            final int n = p.length;     // Catch: MaxIterationsExceededException -> L5
            UnivariateRealFunction f = new AnonymousClass1(this, n, p, d);     // Catch: MaxIterationsExceededException -> L5
            this.bracket.search(f, PowellOptimizer.access$100(this.this$0), 0.0d, 1.0d);     // Catch: MaxIterationsExceededException -> L5
            this.optimum = this.optim.optimize(f, PowellOptimizer.access$200(this.this$0), this.bracket.getLo(), this.bracket.getHi(), this.bracket.getMid());     // Catch: MaxIterationsExceededException -> L5
            this.valueAtOptimum = this.optim.getFunctionValue();     // Catch: MaxIterationsExceededException -> L5
            return;
        L5:
            e = move-exception;
            throw new OptimizationException(e);
        }

        public double getOptimum() {
            return this.optimum;
        }

        public double getValueAtOptimum() {
            return this.valueAtOptimum;
        }
    }

    static /* synthetic */ double access$000(PowellOptimizer x0, double[] x1) throws FunctionEvaluationException {
        return x0.computeObjectiveValue(x1);
    }

    static /* synthetic */ GoalType access$100(PowellOptimizer x0) {
        return x0.goal;
    }

    static /* synthetic */ GoalType access$200(PowellOptimizer x0) {
        return x0.goal;
    }

    public PowellOptimizer() {
        this(1.0E-7d, 1.0E-11d);
    }

    public PowellOptimizer(double lsRelativeTolerance) {
        this(lsRelativeTolerance, 1.0E-11d);
    }

    public PowellOptimizer(double lsRelativeTolerance, double lsAbsoluteTolerance) {
        this.line = new LineSearch(this, lsRelativeTolerance, lsAbsoluteTolerance);
    }

    @Override // org.apache.commons.math.optimization.general.AbstractScalarDifferentiableOptimizer
    protected RealPointValuePair doOptimize() throws FunctionEvaluationException, OptimizationException {
        double[] guess = (double[]) this.point.clone();
        int n = guess.length;
        char r4 = 1;
        char r5 = 0;
        double[][] direc = (double[][]) Array.newInstance(Double.TYPE, new int[]{n, n});
        int i = 0;
    L3:
        if (i >= n) goto L5;
        direc[i][i] = 1.0d;
        i = i + 1;
        goto L3
    L5:
        double[] x = guess;
        double fVal = computeObjectiveValue(x);
        double[] x1 = (double[]) x.clone();
    L6:
        incrementIterationsCounter();
        double fX = fVal;
        double delta = 0.0d;
        int bigInd = 0;
        char r19 = r4;
        int i2 = 0;
    L7:
        if (i2 >= n) goto L12;
        char r20 = r5;
        double[] d = copyOf(direc[i2], n);
        double fX2 = fVal;
        double[] guess2 = guess;
        this.line.search(x, d);
        fVal = this.line.getValueAtOptimum();
        double[][] direc2 = direc;
        int i3 = i2;
        double alphaMin = this.line.getOptimum();
        x = newPointAndDirection(x, d, alphaMin)[r20];
        if ((fX2 - fVal) <= delta) goto L11;
        delta = fX2 - fVal;
        bigInd = i3;
    L11:
        r5 = r20;
        direc = direc2;
        i2 = i3 + 1;
        guess = guess2;
        goto L7
    L12:
        double[] guess3 = guess;
        double[][] direc3 = direc;
        char r21 = r5;
        RealPointValuePair previous = new RealPointValuePair(x1, fX);
        RealPointValuePair current = new RealPointValuePair(x, fVal);
        if (getConvergenceChecker().converged(getIterations(), previous, current) == true) goto L15;
        double[] d2 = new double[n];
        double[] x2 = new double[n];
        int i4 = 0;
    L28:
        if (i4 >= n) goto L30;
        d2[i4] = x[i4] - x1[i4];
        x2[i4] = (x[i4] * 2.0d) - x1[i4];
        i4 = i4 + 1;
        goto L28
    L30:
        x1 = (double[]) x.clone();
        double fX3 = computeObjectiveValue(x2);
        if (fX <= fX3) goto L36;
        double t = ((fX + fX3) - (fVal * 2.0d)) * 2.0d;
        double temp = (fX - fVal) - delta;
        double t2 = t * (temp * temp);
        double temp2 = fX - fX3;
        if ((t2 - ((delta * temp2) * temp2)) >= 0.0d) goto L35;
        this.line.search(x, d2);
        fVal = this.line.getValueAtOptimum();
        int n2 = n;
        double alphaMin2 = this.line.getOptimum();
        double[][] result = newPointAndDirection(x, d2, alphaMin2);
        x = result[r21];
        int lastInd = n2 - 1;
        direc3[bigInd] = direc3[lastInd];
        direc3[lastInd] = result[r19];
    L37:
        r4 = r19;
        r5 = r21;
        guess = guess3;
        direc = direc3;
        n = n2;
        goto L6
    L35:
        n2 = n;
        goto L37
    L36:
        n2 = n;
        goto L37
    L15:
        if (this.goal != GoalType.MINIMIZE) goto L22;
        if (fVal >= fX) goto L20;
        return current;
    L20:
        return previous;
    L22:
        if (fVal <= fX) goto L25;
        return current;
    L25:
        return previous;
    }

    private double[][] newPointAndDirection(double[] p, double[] d, double optimum) {
        int n = p.length;
        double[][] result = (double[][]) Array.newInstance(Double.TYPE, new int[]{2, n});
        double[] nP = result[0];
        double[] nD = result[1];
        int i = 0;
    L3:
        if (i >= n) goto L6;
        nD[i] = d[i] * optimum;
        nP[i] = p[i] + nD[i];
        i = i + 1;
        goto L3
    L6:
        return result;
    }

    private double[] copyOf(double[] source, int newLen) {
        double[] output = new double[newLen];
        System.arraycopy(source, 0, output, 0, Math.min(source.length, newLen));
        return output;
    }
}

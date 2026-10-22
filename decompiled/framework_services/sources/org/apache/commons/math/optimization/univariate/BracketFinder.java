package org.apache.commons.math.optimization.univariate;

import org.apache.commons.math.FunctionEvaluationException;
import org.apache.commons.math.MaxIterationsExceededException;
import org.apache.commons.math.analysis.UnivariateRealFunction;
import org.apache.commons.math.exception.NotStrictlyPositiveException;
import org.apache.commons.math.optimization.GoalType;

/* JADX INFO: loaded from: classes3.dex */
public class BracketFinder {
    private static final double EPS_MIN = 1.0E-21d;
    private static final double GOLD = 1.618034d;
    private int evaluations;
    private double fHi;
    private double fLo;
    private double fMid;
    private final double growLimit;
    private double hi;
    private int iterations;
    private double lo;
    private final int maxIterations;
    private double mid;

    public BracketFinder() {
        this(100.0d, 50);
    }

    public BracketFinder(double growLimit, int maxIterations) {
        if (growLimit <= 0.0d) goto L10;
        if (maxIterations <= 0) goto L8;
        this.growLimit = growLimit;
        this.maxIterations = maxIterations;
        return;
    L8:
        throw new NotStrictlyPositiveException(Integer.valueOf(maxIterations));
    L10:
        throw new NotStrictlyPositiveException(Double.valueOf(growLimit));
    }

    public void search(UnivariateRealFunction func, GoalType goal, double xA, double xB) throws MaxIterationsExceededException, FunctionEvaluationException {
        reset();
        if (goal != GoalType.MINIMIZE) goto L5;
        boolean isMinim = true;
    L6:
        double xA2 = xA;
        double fA = eval(func, xA2);
        double xB2 = xB;
        double fB = eval(func, xB2);
        if (isMinim == false) goto L12;
        if (fA < fB) goto L14;
    L15:
        double tmp = xB2 - xA2;
        double r15 = GOLD;
        double xC = (tmp * GOLD) + xB2;
        double fC = eval(func, xC);
    L16:
        if (isMinim == false) goto L22;
        if (fC >= fB) goto L69;
    L24:
        int r3 = this.iterations + 1;
        this.iterations = r3;
        double r36 = r15;
        if (r3 > this.maxIterations) goto L67;
        double tmp1 = (xB2 - xA2) * (fB - fC);
        double tmp2 = (xB2 - xC) * (fB - fA);
        double val = tmp2 - tmp1;
        if (Math.abs(val) >= EPS_MIN) goto L29;
        double denom = 2.0E-21d;
    L30:
        double r26 = (((xB2 - xC) * tmp2) - ((xB2 - xA2) * tmp1)) / denom;
        boolean isMinim2 = isMinim;
        double w = xB2 - r26;
        double xA3 = xA2;
        double wLim = (this.growLimit * (xC - xB2)) + xB2;
        if (((w - xC) * (xB2 - w)) <= 0.0d) goto L50;
        double fW = eval(func, w);
        if (isMinim2 == false) goto L38;
        if (fW < fC) goto L40;
    L41:
        if (isMinim2 == false) goto L46;
        if (fW > fB) goto L48;
    L49:
        w = xC + ((xC - xB2) * r36);
        double fW2 = eval(func, w);
    L65:
        double xA4 = xB2;
        xB2 = xC;
        xC = w;
        fA = fB;
        fB = fC;
        fC = fW2;
        r15 = r36;
        isMinim = isMinim2;
        xA2 = xA4;
    L48:
        xC = w;
        double xA5 = xA3;
        double w2 = fW;
    L70:
        this.lo = xA5;
        this.mid = xB2;
        this.hi = xC;
        this.fLo = fA;
        this.fMid = fB;
        this.fHi = w2;
        return;
    L46:
        if (fW >= fB) goto L49;
    L40:
        double xA6 = xB2;
        xB2 = w;
        fA = fB;
        fB = fW;
        w2 = fC;
        xA5 = xA6;
        goto L70
    L38:
        if (fW <= fC) goto L41;
    L50:
        double fW3 = w - wLim;
        if ((fW3 * (wLim - xC)) < 0.0d) goto L53;
        w = wLim;
        fW2 = eval(func, w);
        goto L65
    L53:
        double fW4 = w - wLim;
        if ((fW4 * (xC - w)) <= 0.0d) goto L64;
        fW2 = eval(func, w);
        if (isMinim2 == false) goto L61;
        if (fW2 >= fC) goto L65;
    L63:
        xB2 = xC;
        xC = w;
        w = xC + ((xC - xB2) * r36);
        fB = fC;
        fC = fW2;
        fW2 = eval(func, w);
        goto L65
    L61:
        if (fW2 <= fC) goto L65;
    L64:
        double fW5 = xC - xB2;
        w = xC + (fW5 * r36);
        fW2 = eval(func, w);
        goto L65
    L29:
        denom = 2.0d * val;
        goto L30
    L67:
        throw new MaxIterationsExceededException(this.maxIterations);
    L69:
        xA5 = xA2;
        w2 = fC;
        goto L70
    L22:
        if (fC <= fB) goto L69;
    L14:
        xA2 = xB;
        xB2 = xA;
        fA = fB;
        fB = fA;
        goto L15
    L12:
        if (fA <= fB) goto L15;
    L5:
        isMinim = false;
        goto L6
    }

    public int getIterations() {
        return this.iterations;
    }

    public int getEvaluations() {
        return this.evaluations;
    }

    public double getLo() {
        return this.lo;
    }

    public double getFLow() {
        return this.fLo;
    }

    public double getHi() {
        return this.hi;
    }

    public double getFHi() {
        return this.fHi;
    }

    public double getMid() {
        return this.mid;
    }

    public double getFMid() {
        return this.fMid;
    }

    private double eval(UnivariateRealFunction f, double x) throws FunctionEvaluationException {
        this.evaluations++;
        return f.value(x);
    }

    private void reset() {
        this.iterations = 0;
        this.evaluations = 0;
    }
}

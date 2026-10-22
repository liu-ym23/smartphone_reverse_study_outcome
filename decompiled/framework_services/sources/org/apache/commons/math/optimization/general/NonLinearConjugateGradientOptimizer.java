package org.apache.commons.math.optimization.general;

import org.apache.commons.math.ConvergenceException;
import org.apache.commons.math.FunctionEvaluationException;
import org.apache.commons.math.analysis.UnivariateRealFunction;
import org.apache.commons.math.analysis.solvers.BrentSolver;
import org.apache.commons.math.analysis.solvers.UnivariateRealSolver;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.optimization.GoalType;
import org.apache.commons.math.optimization.OptimizationException;
import org.apache.commons.math.optimization.RealPointValuePair;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class NonLinearConjugateGradientOptimizer extends AbstractScalarDifferentiableOptimizer {
    private double initialStep;
    private Preconditioner preconditioner;
    private UnivariateRealSolver solver;
    private final ConjugateGradientFormula updateFormula;

    /* JADX INFO: renamed from: org.apache.commons.math.optimization.general.NonLinearConjugateGradientOptimizer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class IdentityPreconditioner implements Preconditioner {
        private IdentityPreconditioner() {
        }

        /* synthetic */ IdentityPreconditioner(AnonymousClass1 x0) {
            this();
        }

        @Override // org.apache.commons.math.optimization.general.Preconditioner
        public double[] precondition(double[] variables, double[] r) {
            return (double[]) r.clone();
        }
    }

    private class LineSearchFunction implements UnivariateRealFunction {
        private final double[] searchDirection;
        final /* synthetic */ NonLinearConjugateGradientOptimizer this$0;

        public LineSearchFunction(NonLinearConjugateGradientOptimizer r1, double[] searchDirection) {
            this.this$0 = r1;
            this.searchDirection = searchDirection;
        }

        @Override // org.apache.commons.math.analysis.UnivariateRealFunction
        public double value(double x) throws FunctionEvaluationException {
            double[] shiftedPoint = (double[]) this.this$0.point.clone();
            int i = 0;
        L4:
            if (i >= shiftedPoint.length) goto L6;
            shiftedPoint[i] = shiftedPoint[i] + (this.searchDirection[i] * x);
            i = i + 1;
            goto L4
        L6:
            double[] gradient = this.this$0.computeObjectiveGradient(shiftedPoint);
            double dotProduct = 0.0d;
            int i2 = 0;
        L8:
            if (i2 >= gradient.length) goto L11;
            dotProduct = dotProduct + (gradient[i2] * this.searchDirection[i2]);
            i2 = i2 + 1;
            goto L8
        L11:
            return dotProduct;
        }
    }

    public NonLinearConjugateGradientOptimizer(ConjugateGradientFormula updateFormula) {
        this.updateFormula = updateFormula;
        this.preconditioner = null;
        this.solver = null;
        this.initialStep = 1.0d;
    }

    public void setPreconditioner(Preconditioner preconditioner) {
        this.preconditioner = preconditioner;
    }

    public void setLineSearchSolver(UnivariateRealSolver lineSearchSolver) {
        this.solver = lineSearchSolver;
    }

    public void setInitialStep(double initialStep) {
        if (initialStep > 0.0d) goto L5;
        this.initialStep = 1.0d;
        return;
    L5:
        this.initialStep = initialStep;
    }

    @Override // org.apache.commons.math.optimization.general.AbstractScalarDifferentiableOptimizer
    protected RealPointValuePair doOptimize() throws FunctionEvaluationException, OptimizationException, IllegalArgumentException {
    L6:
        ce = move-exception;
        throw new OptimizationException(ce);
    L4:
        if (this.preconditioner != null) goto L9;
        this.preconditioner = new IdentityPreconditioner(null);     // Catch: ConvergenceException -> L6
    L9:
        if (this.solver != null) goto L11;
        this.solver = new BrentSolver();     // Catch: ConvergenceException -> L6
    L11:
        int n = this.point.length;     // Catch: ConvergenceException -> L6
        double[] r = computeObjectiveGradient(this.point);     // Catch: ConvergenceException -> L6
        if (this.goal != GoalType.MINIMIZE) goto L16;
        int i = 0;
    L14:
        if (i >= n) goto L16;
        r[i] = -r[i];     // Catch: ConvergenceException -> L6
        i = i + 1;     // Catch: ConvergenceException -> L6
    L16:
        double[] steepestDescent = this.preconditioner.precondition(this.point, r);     // Catch: ConvergenceException -> L6
        double[] searchDirection = (double[]) steepestDescent.clone();     // Catch: ConvergenceException -> L6
        double delta = 0.0d;
        int i2 = 0;
    L17:
        if (i2 >= n) goto L19;
        delta = delta + (r[i2] * searchDirection[i2]);     // Catch: ConvergenceException -> L6
        i2 = i2 + 1;     // Catch: ConvergenceException -> L6
        goto L17
    L19:
        RealPointValuePair current = null;
        double[] steepestDescent2 = steepestDescent;
        double[] searchDirection2 = searchDirection;
        double delta2 = delta;
    L20:
        double objective = computeObjectiveValue(this.point);     // Catch: ConvergenceException -> L6
        RealPointValuePair previous = current;
        RealPointValuePair current2 = new RealPointValuePair(this.point, objective);     // Catch: ConvergenceException -> L6
        if (previous != null) goto L23;
    L25:
        incrementIterationsCounter();     // Catch: ConvergenceException -> L6
        int r4 = searchDirection2.length;     // Catch: ConvergenceException -> L6
        int r5 = 0;
        double dTd = 0.0d;
    L26:
        if (r5 >= r4) goto L28;
        double di = searchDirection2[r5];     // Catch: ConvergenceException -> L6
        dTd = dTd + (di * di);     // Catch: ConvergenceException -> L6
        r5 = r5 + 1;     // Catch: ConvergenceException -> L6
        goto L26
    L28:
        UnivariateRealFunction lsf = new LineSearchFunction(this, searchDirection2);     // Catch: ConvergenceException -> L6
        double step = this.solver.solve(lsf, 0.0d, findUpperBound(lsf, 0.0d, this.initialStep));     // Catch: ConvergenceException -> L6
        int i3 = 0;
    L30:
        if (i3 >= this.point.length) goto L32;
        double[] r6 = this.point;     // Catch: ConvergenceException -> L6
        r6[i3] = r6[i3] + (searchDirection2[i3] * step);     // Catch: ConvergenceException -> L6
        i3 = i3 + 1;     // Catch: ConvergenceException -> L6
        goto L30
    L32:
        double[] r2 = computeObjectiveGradient(this.point);     // Catch: ConvergenceException -> L6
        if (this.goal != GoalType.MINIMIZE) goto L37;
        int i4 = 0;
    L35:
        if (i4 >= n) goto L37;
        r2[i4] = -r2[i4];     // Catch: ConvergenceException -> L6
        i4 = i4 + 1;     // Catch: ConvergenceException -> L6
    L37:
        double deltaOld = delta2;
        double[] newSteepestDescent = this.preconditioner.precondition(this.point, r2);     // Catch: ConvergenceException -> L6
        delta2 = 0.0d;
        int i5 = 0;
    L38:
        if (i5 >= n) goto L41;
        delta2 = delta2 + (r2[i5] * newSteepestDescent[i5]);     // Catch: ConvergenceException -> L6
        i5 = i5 + 1;     // Catch: ConvergenceException -> L6
        goto L38
    L41:
        if (this.updateFormula != ConjugateGradientFormula.FLETCHER_REEVES) goto L43;
        double deltaMid = delta2 / deltaOld;     // Catch: ConvergenceException -> L6
    L48:
        steepestDescent2 = newSteepestDescent;
        if ((getIterations() % n) == 0) goto L57;
        if (deltaMid < 0.0d) goto L57;
        int i6 = 0;
    L54:
        if (i6 >= n) goto L58;
        searchDirection2[i6] = steepestDescent2[i6] + (searchDirection2[i6] * deltaMid);     // Catch: ConvergenceException -> L6
        i6 = i6 + 1;     // Catch: ConvergenceException -> L6
    L58:
        current = current2;
    L57:
        searchDirection2 = (double[]) steepestDescent2.clone();     // Catch: ConvergenceException -> L6
        goto L58
    L43:
        double deltaMid2 = 0.0d;
        int i7 = 0;
    L45:
        if (i7 >= r2.length) goto L47;
        deltaMid2 = deltaMid2 + (r2[i7] * steepestDescent2[i7]);     // Catch: ConvergenceException -> L6
        i7 = i7 + 1;     // Catch: ConvergenceException -> L6
        goto L45
    L47:
        deltaMid = (delta2 - deltaMid2) / deltaOld;     // Catch: ConvergenceException -> L6
        goto L48
    L23:
        if (this.checker.converged(getIterations(), previous, current2) == false) goto L25;
        return current2;
    }

    private double findUpperBound(UnivariateRealFunction f, double a, double h) throws FunctionEvaluationException, OptimizationException {
        double yA = f.value(a);
        double step = h;
    L4:
        if (step >= Double.MAX_VALUE) goto L10;
        double b = a + step;
        double yB = f.value(b);
        if ((yA * yB) <= 0.0d) goto L7;
        step = step * FastMath.max(2.0d, yA / yB);
        goto L4
    L7:
        return b;
    L10:
        throw new OptimizationException(LocalizedFormats.UNABLE_TO_BRACKET_OPTIMUM_IN_LINE_SEARCH, new Object[0]);
    }
}

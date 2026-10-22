package org.apache.commons.math.ode.nonstiff;

import java.util.Arrays;
import java.util.Iterator;
import org.apache.commons.math.linear.Array2DRowRealMatrix;
import org.apache.commons.math.linear.RealMatrixPreservingVisitor;
import org.apache.commons.math.ode.DerivativeException;
import org.apache.commons.math.ode.FirstOrderDifferentialEquations;
import org.apache.commons.math.ode.IntegratorException;
import org.apache.commons.math.ode.sampling.NordsieckStepInterpolator;
import org.apache.commons.math.ode.sampling.StepHandler;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class AdamsMoultonIntegrator extends AdamsIntegrator {
    private static final String METHOD_NAME = "Adams-Moulton";

    private class Corrector implements RealMatrixPreservingVisitor {
        private final double[] after;
        private final double[] before;
        private final double[] previous;
        private final double[] scaled;
        final /* synthetic */ AdamsMoultonIntegrator this$0;

        public Corrector(AdamsMoultonIntegrator r1, double[] previous, double[] scaled, double[] state) {
            this.this$0 = r1;
            this.previous = previous;
            this.scaled = scaled;
            this.after = state;
            this.before = (double[]) state.clone();
        }

        @Override // org.apache.commons.math.linear.RealMatrixPreservingVisitor
        public void start(int rows, int columns, int startRow, int endRow, int startColumn, int endColumn) {
            Arrays.fill(this.after, 0.0d);
        }

        @Override // org.apache.commons.math.linear.RealMatrixPreservingVisitor
        public void visit(int row, int column, double value) {
            if ((row & 1) != 0) goto L5;
            double[] r0 = this.after;
            r0[column] = r0[column] - value;
            return;
        L5:
            double[] r1 = this.after;
            r1[column] = r1[column] + value;
        }

        @Override // org.apache.commons.math.linear.RealMatrixPreservingVisitor
        public double end() {
            double error = 0.0d;
            int i = 0;
        L4:
            if (i >= this.after.length) goto L14;
            double[] r3 = this.after;
            r3[i] = r3[i] + (this.previous[i] + this.scaled[i]);
            if (i >= this.this$0.mainSetDimension) goto L12;
            double yScale = FastMath.max(FastMath.abs(this.previous[i]), FastMath.abs(this.after[i]));
            if (this.this$0.vecAbsoluteTolerance != null) goto L10;
            double tol = this.this$0.scalAbsoluteTolerance + (this.this$0.scalRelativeTolerance * yScale);
        L11:
            double ratio = (this.after[i] - this.before[i]) / tol;
            error = error + (ratio * ratio);
            goto L12
        L10:
            tol = this.this$0.vecAbsoluteTolerance[i] + (this.this$0.vecRelativeTolerance[i] * yScale);
        L12:
            i = i + 1;
            goto L4
        L14:
            return FastMath.sqrt(error / ((double) this.this$0.mainSetDimension));
        }
    }

    public AdamsMoultonIntegrator(int nSteps, double minStep, double maxStep, double scalAbsoluteTolerance, double scalRelativeTolerance) throws IllegalArgumentException {
        super(METHOD_NAME, nSteps, nSteps + 1, minStep, maxStep, scalAbsoluteTolerance, scalRelativeTolerance);
    }

    public AdamsMoultonIntegrator(int nSteps, double minStep, double maxStep, double[] vecAbsoluteTolerance, double[] vecRelativeTolerance) throws IllegalArgumentException {
        super(METHOD_NAME, nSteps, nSteps + 1, minStep, maxStep, vecAbsoluteTolerance, vecRelativeTolerance);
    }

    @Override // org.apache.commons.math.ode.nonstiff.AdamsIntegrator, org.apache.commons.math.ode.nonstiff.AdaptiveStepsizeIntegrator, org.apache.commons.math.ode.FirstOrderIntegrator
    public double integrate(FirstOrderDifferentialEquations equations, double t0, double[] y0, double t, double[] y) throws DerivativeException, IntegratorException {
        double[] r6 = y0;
        double[] r3 = y;
        int n = r6.length;
        sanityChecks(equations, t0, y0, t, y);
        setEquations(equations);
        resetEvaluations();
        if (t <= t0) goto L5;
        boolean r1 = true;
    L6:
        boolean forward = r1;
        if (r3 == r6) goto L9;
        System.arraycopy(r6, 0, r3, 0, n);
    L9:
        double[] yDot = new double[r6.length];
        double[] yTmp = new double[r6.length];
        double[] predictedScaled = new double[r6.length];
        Array2DRowRealMatrix nordsieckTmp = null;
        NordsieckStepInterpolator interpolator = new NordsieckStepInterpolator();
        interpolator.reinitialize(r3, forward);
        Iterator<StepHandler> r2 = this.stepHandlers.iterator();
    L11:
        if (r2.hasNext() == false) goto L13;
        StepHandler handler = r2.next();
        handler.reset();
        goto L11
    L13:
        setStateInitialized(false);
        start(t0, r3, t);
        interpolator.reinitialize(this.stepStart, this.stepSize, this.scaled, this.nordsieck);
        interpolator.storeTime(this.stepStart);
        double hNew = this.stepSize;
        interpolator.rescale(hNew);
        this.isLastStep = false;
    L14:
        double error = 10.0d;
        double factor = hNew;
    L16:
        if (error < 1.0d) goto L26;
        this.stepSize = factor;
        double stepEnd = this.stepStart + this.stepSize;
        interpolator.setInterpolatedTime(stepEnd);
        double hNew2 = factor;
        System.arraycopy(interpolator.getInterpolatedState(), 0, yTmp, 0, r6.length);
        computeDerivatives(stepEnd, yTmp, yDot);
        int j = 0;
    L19:
        if (j >= r6.length) goto L21;
        predictedScaled[j] = this.stepSize * yDot[j];
        j = j + 1;
        goto L19
    L21:
        nordsieckTmp = updateHighOrderDerivativesPhase1(this.nordsieck);
        updateHighOrderDerivativesPhase2(this.scaled, predictedScaled, nordsieckTmp);
        double error2 = nordsieckTmp.walkInOptimizedOrder(new Corrector(this, r3, predictedScaled, yTmp));
        if (error2 < 1.0d) goto L24;
        double factor2 = computeStepGrowShrinkFactor(error2);
        double hNew3 = filterStep(this.stepSize * factor2, forward, false);
        interpolator.rescale(hNew3);
        factor = hNew3;
    L25:
        error = error2;
        goto L16
    L24:
        factor = hNew2;
        goto L25
    L26:
        double error3 = error;
        double hNew4 = factor;
        double stepEnd2 = this.stepStart + this.stepSize;
        computeDerivatives(stepEnd2, yTmp, yDot);
        double[] correctedScaled = new double[r6.length];
        int j2 = 0;
    L28:
        if (j2 >= r6.length) goto L30;
        correctedScaled[j2] = this.stepSize * yDot[j2];
        j2 = j2 + 1;
        goto L28
    L30:
        updateHighOrderDerivativesPhase2(predictedScaled, correctedScaled, nordsieckTmp);
        System.arraycopy(yTmp, 0, r3, 0, n);
        interpolator.reinitialize(stepEnd2, this.stepSize, correctedScaled, nordsieckTmp);
        interpolator.storeTime(this.stepStart);
        interpolator.shift();
        interpolator.storeTime(stepEnd2);
        double[] r4 = r3;
        int n2 = n;
        double[] yDot2 = yDot;
        this.stepStart = acceptStep(interpolator, r4, yDot2, t);
        this.scaled = correctedScaled;
        this.nordsieck = nordsieckTmp;
        if (this.isLastStep == true) goto L57;
        interpolator.storeTime(this.stepStart);
        if (this.resetOccurred == false) goto L35;
        start(this.stepStart, y, t);
        interpolator.reinitialize(this.stepStart, this.stepSize, this.scaled, this.nordsieck);
    L35:
        double factor3 = computeStepGrowShrinkFactor(error3);
        double scaledH = this.stepSize * factor3;
        double nextT = this.stepStart + scaledH;
        if (forward == false) goto L42;
        if (nextT < t) goto L40;
    L39:
        boolean nextIsLast = true;
    L44:
        double hNew5 = filterStep(scaledH, forward, nextIsLast);
        double factor4 = this.stepStart;
        double filteredNextT = factor4 + hNew5;
        if (forward == false) goto L51;
        if (filteredNextT < t) goto L49;
    L48:
        boolean filteredNextIsLast = true;
    L53:
        if (filteredNextIsLast == false) goto L55;
        hNew = t - this.stepStart;
    L56:
        interpolator.rescale(hNew);
    L59:
        if (this.isLastStep == true) goto L60;
        r6 = y0;
        r3 = y;
        n = n2;
        yDot = yDot2;
        goto L14
    L60:
        double stopTime = this.stepStart;
        this.stepStart = Double.NaN;
        this.stepSize = Double.NaN;
        return stopTime;
    L55:
        hNew = hNew5;
    L49:
        filteredNextIsLast = false;
        goto L53
    L51:
        if (filteredNextT > t) goto L49;
    L40:
        nextIsLast = false;
        goto L44
    L42:
        if (nextT > t) goto L40;
    L57:
        hNew = hNew4;
        goto L59
    L5:
        r1 = false;
        goto L6
    }
}

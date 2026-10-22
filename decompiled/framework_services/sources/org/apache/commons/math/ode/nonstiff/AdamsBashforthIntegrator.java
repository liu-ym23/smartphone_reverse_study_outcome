package org.apache.commons.math.ode.nonstiff;

import java.util.Iterator;
import org.apache.commons.math.linear.Array2DRowRealMatrix;
import org.apache.commons.math.ode.DerivativeException;
import org.apache.commons.math.ode.FirstOrderDifferentialEquations;
import org.apache.commons.math.ode.IntegratorException;
import org.apache.commons.math.ode.sampling.NordsieckStepInterpolator;
import org.apache.commons.math.ode.sampling.StepHandler;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class AdamsBashforthIntegrator extends AdamsIntegrator {
    private static final String METHOD_NAME = "Adams-Bashforth";

    public AdamsBashforthIntegrator(int nSteps, double minStep, double maxStep, double scalAbsoluteTolerance, double scalRelativeTolerance) throws IllegalArgumentException {
        super(METHOD_NAME, nSteps, nSteps, minStep, maxStep, scalAbsoluteTolerance, scalRelativeTolerance);
    }

    public AdamsBashforthIntegrator(int nSteps, double minStep, double maxStep, double[] vecAbsoluteTolerance, double[] vecRelativeTolerance) throws IllegalArgumentException {
        super(METHOD_NAME, nSteps, nSteps, minStep, maxStep, vecAbsoluteTolerance, vecRelativeTolerance);
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
        double[] yDot = new double[n];
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
        int lastRow = this.nordsieck.getRowDimension() - 1;
        double hNew = this.stepSize;
        interpolator.rescale(hNew);
        this.isLastStep = false;
    L14:
        double error = 10.0d;
    L16:
        if (error < 1.0d) goto L29;
        this.stepSize = hNew;
        double error2 = 0.0d;
        int i = 0;
    L19:
        if (i >= this.mainSetDimension) goto L25;
        double yScale = FastMath.abs(r3[i]);
        if (this.vecAbsoluteTolerance != null) goto L23;
        double tol = this.scalAbsoluteTolerance + (this.scalRelativeTolerance * yScale);
    L24:
        double ratio = this.nordsieck.getEntry(lastRow, i) / tol;
        error2 = error2 + (ratio * ratio);
        i = i + 1;
        forward = forward;
        goto L19
    L23:
        tol = this.vecAbsoluteTolerance[i] + (this.vecRelativeTolerance[i] * yScale);
        goto L24
    L25:
        boolean forward2 = forward;
        int i2 = this.mainSetDimension;
        error = FastMath.sqrt(error2 / ((double) i2));
        if (error >= 1.0d) goto L27;
        forward = forward2;
        goto L16
    L27:
        double factor = computeStepGrowShrinkFactor(error);
        hNew = filterStep(this.stepSize * factor, forward2, false);
        interpolator.rescale(hNew);
        forward = forward2;
        lastRow = lastRow;
        goto L16
    L29:
        int lastRow2 = lastRow;
        boolean forward3 = forward;
        double stepEnd = this.stepStart + this.stepSize;
        interpolator.shift();
        interpolator.setInterpolatedTime(stepEnd);
        System.arraycopy(interpolator.getInterpolatedState(), 0, r3, 0, r6.length);
        computeDerivatives(stepEnd, r3, yDot);
        double[] predictedScaled = new double[r6.length];
        int j = 0;
    L31:
        if (j >= r6.length) goto L33;
        predictedScaled[j] = this.stepSize * yDot[j];
        j = j + 1;
        stepEnd = stepEnd;
        goto L31
    L33:
        double stepEnd2 = stepEnd;
        Array2DRowRealMatrix nordsieckTmp = updateHighOrderDerivativesPhase1(this.nordsieck);
        updateHighOrderDerivativesPhase2(this.scaled, predictedScaled, nordsieckTmp);
        double error3 = error;
        interpolator.reinitialize(stepEnd2, this.stepSize, predictedScaled, nordsieckTmp);
        interpolator.storeTime(stepEnd2);
        double[] r4 = r3;
        double hNew2 = hNew;
        int n2 = n;
        double[] yDot2 = yDot;
        this.stepStart = acceptStep(interpolator, r4, yDot2, t);
        this.scaled = predictedScaled;
        this.nordsieck = nordsieckTmp;
        interpolator.reinitialize(stepEnd2, this.stepSize, this.scaled, this.nordsieck);
        if (this.isLastStep == true) goto L60;
        interpolator.storeTime(this.stepStart);
        if (this.resetOccurred == false) goto L38;
        start(this.stepStart, y, t);
        interpolator.reinitialize(this.stepStart, this.stepSize, this.scaled, this.nordsieck);
    L38:
        double factor2 = computeStepGrowShrinkFactor(error3);
        double scaledH = this.stepSize * factor2;
        double nextT = this.stepStart + scaledH;
        if (forward3 == false) goto L45;
        if (nextT < t) goto L43;
    L42:
        boolean nextIsLast = true;
    L47:
        double hNew3 = filterStep(scaledH, forward3, nextIsLast);
        double factor3 = this.stepStart;
        double filteredNextT = factor3 + hNew3;
        if (forward3 == false) goto L54;
        if (filteredNextT < t) goto L52;
    L51:
        boolean filteredNextIsLast = true;
    L56:
        if (filteredNextIsLast == false) goto L58;
        double hNew4 = t - this.stepStart;
    L59:
        interpolator.rescale(hNew4);
        hNew = hNew4;
    L62:
        if (this.isLastStep == true) goto L63;
        r6 = y0;
        r3 = y;
        forward = forward3;
        n = n2;
        lastRow = lastRow2;
        yDot = yDot2;
        goto L14
    L63:
        double stopTime = this.stepStart;
        resetInternalState();
        return stopTime;
    L58:
        hNew4 = hNew3;
    L52:
        filteredNextIsLast = false;
        goto L56
    L54:
        if (filteredNextT > t) goto L52;
    L43:
        nextIsLast = false;
        goto L47
    L45:
        if (nextT > t) goto L43;
    L60:
        hNew = hNew2;
        goto L62
    L5:
        r1 = false;
        goto L6
    }
}

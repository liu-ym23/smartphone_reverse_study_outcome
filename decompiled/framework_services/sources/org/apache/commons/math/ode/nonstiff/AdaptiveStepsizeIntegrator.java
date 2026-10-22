package org.apache.commons.math.ode.nonstiff;

import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.ode.AbstractIntegrator;
import org.apache.commons.math.ode.DerivativeException;
import org.apache.commons.math.ode.ExtendedFirstOrderDifferentialEquations;
import org.apache.commons.math.ode.FirstOrderDifferentialEquations;
import org.apache.commons.math.ode.IntegratorException;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AdaptiveStepsizeIntegrator extends AbstractIntegrator {
    private double initialStep;
    protected int mainSetDimension;
    private final double maxStep;
    private final double minStep;
    protected final double scalAbsoluteTolerance;
    protected final double scalRelativeTolerance;
    protected final double[] vecAbsoluteTolerance;
    protected final double[] vecRelativeTolerance;

    @Override // org.apache.commons.math.ode.FirstOrderIntegrator
    public abstract double integrate(FirstOrderDifferentialEquations r1, double r2, double[] r4, double r5, double[] r7) throws DerivativeException, IntegratorException;

    public AdaptiveStepsizeIntegrator(String name, double minStep, double maxStep, double scalAbsoluteTolerance, double scalRelativeTolerance) {
        super(name);
        this.minStep = FastMath.abs(minStep);
        this.maxStep = FastMath.abs(maxStep);
        this.initialStep = -1.0d;
        this.scalAbsoluteTolerance = scalAbsoluteTolerance;
        this.scalRelativeTolerance = scalRelativeTolerance;
        this.vecAbsoluteTolerance = null;
        this.vecRelativeTolerance = null;
        resetInternalState();
    }

    public AdaptiveStepsizeIntegrator(String name, double minStep, double maxStep, double[] vecAbsoluteTolerance, double[] vecRelativeTolerance) {
        super(name);
        this.minStep = minStep;
        this.maxStep = maxStep;
        this.initialStep = -1.0d;
        this.scalAbsoluteTolerance = 0.0d;
        this.scalRelativeTolerance = 0.0d;
        this.vecAbsoluteTolerance = (double[]) vecAbsoluteTolerance.clone();
        this.vecRelativeTolerance = (double[]) vecRelativeTolerance.clone();
        resetInternalState();
    }

    public void setInitialStepSize(double initialStepSize) {
        if (initialStepSize >= this.minStep) goto L5;
    L8:
        this.initialStep = -1.0d;
        return;
    L5:
        if (initialStepSize > this.maxStep) goto L8;
        this.initialStep = initialStepSize;
    }

    @Override // org.apache.commons.math.ode.AbstractIntegrator
    protected void sanityChecks(FirstOrderDifferentialEquations equations, double t0, double[] y0, double t, double[] y) throws IntegratorException {
        super.sanityChecks(equations, t0, y0, t, y);
        if ((equations instanceof ExtendedFirstOrderDifferentialEquations) == false) goto L5;
        this.mainSetDimension = ((ExtendedFirstOrderDifferentialEquations) equations).getMainSetDimension();
    L7:
        if (this.vecAbsoluteTolerance == null) goto L14;
        if (this.vecAbsoluteTolerance.length == this.mainSetDimension) goto L14;
        throw new IntegratorException(LocalizedFormats.DIMENSIONS_MISMATCH_SIMPLE, new Object[]{Integer.valueOf(this.mainSetDimension), Integer.valueOf(this.vecAbsoluteTolerance.length)});
    L14:
        if (this.vecRelativeTolerance != null) goto L16;
        return;
    L16:
        if (this.vecRelativeTolerance.length != this.mainSetDimension) goto L19;
        return;
    L19:
        throw new IntegratorException(LocalizedFormats.DIMENSIONS_MISMATCH_SIMPLE, new Object[]{Integer.valueOf(this.mainSetDimension), Integer.valueOf(this.vecRelativeTolerance.length)});
    L5:
        this.mainSetDimension = equations.getDimension();
        goto L7
    }

    public double initializeStep(FirstOrderDifferentialEquations equations, boolean forward, int order, double[] scale, double t0, double[] y0, double[] yDot0, double[] y1, double[] yDot1) throws DerivativeException {
        if (this.initialStep <= 0.0d) goto L9;
        double r5 = this.initialStep;
        if (forward == false) goto L8;
        return r5;
    L8:
        return -r5;
    L9:
        double yOnScale2 = 0.0d;
        double yDotOnScale2 = 0.0d;
        int j = 0;
    L11:
        if (j >= scale.length) goto L13;
        double ratio = y0[j] / scale[j];
        yOnScale2 = yOnScale2 + (ratio * ratio);
        double ratio2 = yDot0[j] / scale[j];
        yDotOnScale2 = yDotOnScale2 + (ratio2 * ratio2);
        j = j + 1;
        goto L11
    L13:
        double r14 = 0.01d;
        if (yOnScale2 >= 1.0E-10d) goto L16;
    L19:
        double h = 1.0E-6d;
    L21:
        if (forward == true) goto L23;
        h = -h;
    L23:
        int j2 = 0;
    L24:
        double r16 = r14;
        if (j2 >= y0.length) goto L27;
        y1[j2] = y0[j2] + (yDot0[j2] * h);
        j2 = j2 + 1;
        r14 = r16;
        goto L24
    L27:
        computeDerivatives(t0 + h, y1, yDot1);
        double yDDotOnScale = 0.0d;
        int j3 = 0;
    L29:
        if (j3 >= scale.length) goto L31;
        double ratio3 = (yDot1[j3] - yDot0[j3]) / scale[j3];
        yDDotOnScale = yDDotOnScale + (ratio3 * ratio3);
        j3 = j3 + 1;
        goto L29
    L31:
        double yDDotOnScale2 = FastMath.sqrt(yDDotOnScale) / h;
        double maxInv2 = FastMath.max(FastMath.sqrt(yDotOnScale2), yDDotOnScale2);
        if (maxInv2 >= 1.0E-15d) goto L34;
        double h1 = FastMath.max(1.0E-6d, FastMath.abs(h) * 0.001d);
    L35:
        double h2 = FastMath.min(100.0d * FastMath.abs(h), h1);
        double h3 = FastMath.max(h2, 1.0E-12d * FastMath.abs(t0));
        if (h3 >= getMinStep()) goto L39;
        h3 = getMinStep();
    L39:
        if (h3 <= getMaxStep()) goto L41;
        h3 = getMaxStep();
    L41:
        if (forward == false) goto L43;
        return h3;
    L43:
        return -h3;
    L34:
        h1 = FastMath.pow(r16 / maxInv2, 1.0d / ((double) order));
        goto L35
    L16:
        if (yDotOnScale2 < 1.0E-10d) goto L19;
        h = FastMath.sqrt(yOnScale2 / yDotOnScale2) * 0.01d;
        goto L21
    }

    protected double filterStep(double h, boolean forward, boolean acceptSmall) throws IntegratorException {
        double filteredH = h;
        if (FastMath.abs(h) >= this.minStep) goto L13;
        if (acceptSmall == false) goto L11;
        double r2 = this.minStep;
        if (forward == true) goto L9;
        r2 = -r2;
    L9:
        filteredH = r2;
        goto L13
    L11:
        throw new IntegratorException(LocalizedFormats.MINIMAL_STEPSIZE_REACHED_DURING_INTEGRATION, new Object[]{Double.valueOf(this.minStep), Double.valueOf(FastMath.abs(h))});
    L13:
        if (filteredH <= this.maxStep) goto L16;
        double filteredH2 = this.maxStep;
        return filteredH2;
    L16:
        if (filteredH >= (-this.maxStep)) goto L20;
        double filteredH3 = -this.maxStep;
        return filteredH3;
    L20:
        return filteredH;
    }

    @Override // org.apache.commons.math.ode.AbstractIntegrator, org.apache.commons.math.ode.ODEIntegrator
    public double getCurrentStepStart() {
        return this.stepStart;
    }

    protected void resetInternalState() {
        this.stepStart = Double.NaN;
        this.stepSize = FastMath.sqrt(this.minStep * this.maxStep);
    }

    public double getMinStep() {
        return this.minStep;
    }

    public double getMaxStep() {
        return this.maxStep;
    }
}

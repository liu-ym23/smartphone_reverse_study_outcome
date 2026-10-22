package org.apache.commons.math.ode;

import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.linear.Array2DRowRealMatrix;
import org.apache.commons.math.linear.RealMatrix;
import org.apache.commons.math.ode.nonstiff.AdaptiveStepsizeIntegrator;
import org.apache.commons.math.ode.nonstiff.DormandPrince853Integrator;
import org.apache.commons.math.ode.sampling.StepHandler;
import org.apache.commons.math.ode.sampling.StepInterpolator;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public abstract class MultistepIntegrator extends AdaptiveStepsizeIntegrator {
    private double exp;
    private double maxGrowth;
    private double minReduction;
    private final int nSteps;
    protected Array2DRowRealMatrix nordsieck;
    private double safety;
    protected double[] scaled;
    private FirstOrderIntegrator starter;

    private class CountingDifferentialEquations implements ExtendedFirstOrderDifferentialEquations {
        private final int dimension;
        final /* synthetic */ MultistepIntegrator this$0;

        public CountingDifferentialEquations(MultistepIntegrator r1, int dimension) {
            this.this$0 = r1;
            this.dimension = dimension;
        }

        @Override // org.apache.commons.math.ode.FirstOrderDifferentialEquations
        public void computeDerivatives(double t, double[] y, double[] dot) throws DerivativeException {
            this.this$0.computeDerivatives(t, y, dot);
        }

        @Override // org.apache.commons.math.ode.FirstOrderDifferentialEquations
        public int getDimension() {
            return this.dimension;
        }

        @Override // org.apache.commons.math.ode.ExtendedFirstOrderDifferentialEquations
        public int getMainSetDimension() {
            return MultistepIntegrator.access$100(this.this$0);
        }
    }

    private static class InitializationCompletedMarkerException extends DerivativeException {
        private static final long serialVersionUID = -4105805787353488365L;

        public InitializationCompletedMarkerException() {
            super(null);
        }
    }

    private class NordsieckInitializer implements StepHandler {
        private final int n;
        final /* synthetic */ MultistepIntegrator this$0;

        public NordsieckInitializer(MultistepIntegrator r1, int n) {
            this.this$0 = r1;
            this.n = n;
        }

        @Override // org.apache.commons.math.ode.sampling.StepHandler
        public void handleStep(StepInterpolator interpolator, boolean isLast) throws DerivativeException {
            double prev = interpolator.getPreviousTime();
            double curr = interpolator.getCurrentTime();
            this.this$0.stepStart = prev;
            this.this$0.stepSize = (curr - prev) / ((double) (MultistepIntegrator.access$000(this.this$0) + 1));
            interpolator.setInterpolatedTime(prev);
            this.this$0.scaled = (double[]) interpolator.getInterpolatedDerivatives().clone();
            int j = 0;
        L4:
            if (j >= this.n) goto L6;
            double[] r5 = this.this$0.scaled;
            r5[j] = r5[j] * this.this$0.stepSize;
            j = j + 1;
            goto L4
        L6:
            double[][] multistep = new double[MultistepIntegrator.access$000(this.this$0)][];
            int i = 1;
        L8:
            if (i > MultistepIntegrator.access$000(this.this$0)) goto L14;
            interpolator.setInterpolatedTime((this.this$0.stepSize * ((double) i)) + prev);
            double[] msI = (double[]) interpolator.getInterpolatedDerivatives().clone();
            int j2 = 0;
        L11:
            if (j2 >= this.n) goto L13;
            msI[j2] = msI[j2] * this.this$0.stepSize;
            j2 = j2 + 1;
            goto L11
        L13:
            int j3 = i - 1;
            multistep[j3] = msI;
            i = i + 1;
            goto L8
        L14:
            this.this$0.nordsieck = this.this$0.initializeHighOrderDerivatives(this.this$0.scaled, multistep);
            throw new InitializationCompletedMarkerException();
        }

        @Override // org.apache.commons.math.ode.sampling.StepHandler
        public boolean requiresDenseOutput() {
            return true;
        }

        @Override // org.apache.commons.math.ode.sampling.StepHandler
        public void reset() {
        }
    }

    public interface NordsieckTransformer {
        RealMatrix initializeHighOrderDerivatives(double[] r1, double[][] r2);
    }

    protected abstract Array2DRowRealMatrix initializeHighOrderDerivatives(double[] r1, double[][] r2);

    static /* synthetic */ int access$000(MultistepIntegrator x0) {
        return x0.nSteps;
    }

    static /* synthetic */ int access$100(MultistepIntegrator x0) {
        return x0.mainSetDimension;
    }

    protected MultistepIntegrator(String name, int nSteps, int order, double minStep, double maxStep, double scalAbsoluteTolerance, double scalRelativeTolerance) {
        super(name, minStep, maxStep, scalAbsoluteTolerance, scalRelativeTolerance);
        if (nSteps <= 0) goto L7;
        this.starter = new DormandPrince853Integrator(minStep, maxStep, scalAbsoluteTolerance, scalRelativeTolerance);
        this.nSteps = nSteps;
        this.exp = (-1.0d) / ((double) order);
        setSafety(0.9d);
        setMinReduction(0.2d);
        setMaxGrowth(FastMath.pow(2.0d, -this.exp));
        return;
    L7:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.INTEGRATION_METHOD_NEEDS_AT_LEAST_ONE_PREVIOUS_POINT, new Object[]{name});
    }

    protected MultistepIntegrator(String name, int nSteps, int order, double minStep, double maxStep, double[] vecAbsoluteTolerance, double[] vecRelativeTolerance) {
        super(name, minStep, maxStep, vecAbsoluteTolerance, vecRelativeTolerance);
        this.starter = new DormandPrince853Integrator(minStep, maxStep, vecAbsoluteTolerance, vecRelativeTolerance);
        this.nSteps = nSteps;
        this.exp = (-1.0d) / ((double) order);
        setSafety(0.9d);
        setMinReduction(0.2d);
        setMaxGrowth(FastMath.pow(2.0d, -this.exp));
    }

    public ODEIntegrator getStarterIntegrator() {
        return this.starter;
    }

    public void setStarterIntegrator(FirstOrderIntegrator starterIntegrator) {
        this.starter = starterIntegrator;
    }

    protected void start(double t0, double[] y0, double t) throws DerivativeException, IntegratorException {
        this.starter.clearEventHandlers();
        this.starter.clearStepHandlers();
        this.starter.addStepHandler(new NordsieckInitializer(this, y0.length));
        this.starter.integrate(new CountingDifferentialEquations(this, y0.length), t0, y0, t, new double[y0.length]);     // Catch: DerivativeException -> L5
    L8:
        this.starter.clearStepHandlers();
        return;
    L5:
        mue = move-exception;
        if ((mue instanceof InitializationCompletedMarkerException) == true) goto L8;
        throw mue;
    }

    public double getMinReduction() {
        return this.minReduction;
    }

    public void setMinReduction(double minReduction) {
        this.minReduction = minReduction;
    }

    public double getMaxGrowth() {
        return this.maxGrowth;
    }

    public void setMaxGrowth(double maxGrowth) {
        this.maxGrowth = maxGrowth;
    }

    public double getSafety() {
        return this.safety;
    }

    public void setSafety(double safety) {
        this.safety = safety;
    }

    protected double computeStepGrowShrinkFactor(double error) {
        return FastMath.min(this.maxGrowth, FastMath.max(this.minReduction, this.safety * FastMath.pow(error, this.exp)));
    }
}

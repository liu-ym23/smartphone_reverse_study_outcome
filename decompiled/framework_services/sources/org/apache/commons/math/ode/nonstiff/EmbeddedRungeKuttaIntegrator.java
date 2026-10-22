package org.apache.commons.math.ode.nonstiff;

import java.lang.reflect.Array;
import java.util.Iterator;
import org.apache.commons.math.ode.DerivativeException;
import org.apache.commons.math.ode.FirstOrderDifferentialEquations;
import org.apache.commons.math.ode.IntegratorException;
import org.apache.commons.math.ode.sampling.AbstractStepInterpolator;
import org.apache.commons.math.ode.sampling.DummyStepInterpolator;
import org.apache.commons.math.ode.sampling.StepHandler;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public abstract class EmbeddedRungeKuttaIntegrator extends AdaptiveStepsizeIntegrator {
    private final double[][] a;
    private final double[] b;
    private final double[] c;
    private final double exp;
    private final boolean fsal;
    private double maxGrowth;
    private double minReduction;
    private final RungeKuttaStepInterpolator prototype;
    private double safety;

    protected abstract double estimateError(double[][] r1, double[] r2, double[] r3, double r4);

    public abstract int getOrder();

    protected EmbeddedRungeKuttaIntegrator(String name, boolean fsal, double[] c, double[][] a, double[] b, RungeKuttaStepInterpolator prototype, double minStep, double maxStep, double scalAbsoluteTolerance, double scalRelativeTolerance) {
        super(name, minStep, maxStep, scalAbsoluteTolerance, scalRelativeTolerance);
        this.fsal = fsal;
        this.c = c;
        this.a = a;
        this.b = b;
        this.prototype = prototype;
        this.exp = (-1.0d) / ((double) getOrder());
        setSafety(0.9d);
        setMinReduction(0.2d);
        setMaxGrowth(10.0d);
    }

    protected EmbeddedRungeKuttaIntegrator(String name, boolean fsal, double[] c, double[][] a, double[] b, RungeKuttaStepInterpolator prototype, double minStep, double maxStep, double[] vecAbsoluteTolerance, double[] vecRelativeTolerance) {
        super(name, minStep, maxStep, vecAbsoluteTolerance, vecRelativeTolerance);
        this.fsal = fsal;
        this.c = c;
        this.a = a;
        this.b = b;
        this.prototype = prototype;
        this.exp = (-1.0d) / ((double) getOrder());
        setSafety(0.9d);
        setMinReduction(0.2d);
        setMaxGrowth(10.0d);
    }

    public double getSafety() {
        return this.safety;
    }

    public void setSafety(double safety) {
        this.safety = safety;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math.ode.nonstiff.AdaptiveStepsizeIntegrator, org.apache.commons.math.ode.FirstOrderIntegrator
    public double integrate(FirstOrderDifferentialEquations r33, double r34, double[] r36, double r37, double[] r39) throws DerivativeException, IntegratorException {
        r39 = r39;
        sanityChecks(r33, r34, r36, r37, r39);
        setEquations(r33);
        resetEvaluations();
        int r15 = 0;
        if (r37 <= r34) goto L5;
        boolean r1 = true;
    L6:
        int r3 = this.c.length + 1;
        if (r39 == r36) goto L9;
        System.arraycopy(r36, 0, r39, 0, r36.length);
    L9:
        double[][] r4 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r3, r36.length});
        double[] r9 = new double[r36.length];
        double[] r5 = new double[r36.length];
        if (requiresDenseOutput() == false) goto L12;
        RungeKuttaStepInterpolator r6 = (RungeKuttaStepInterpolator) this.prototype.copy();
        r6.reinitialize(this, r9, r4, r1);
        AbstractStepInterpolator r7 = r6;
    L13:
        r7.storeTime(r34);
        this.stepStart = r34;
        double r8 = 0.0d;
        boolean r10 = true;
        Iterator<StepHandler> r14 = this.stepHandlers.iterator();
    L15:
        if (r14.hasNext() == false) goto L17;
        r14.next().reset();
        goto L15
    L17:
        setStateInitialized(false);
        this.isLastStep = false;
        AbstractStepInterpolator r11 = r7;
    L18:
        r11.shift();
        double r17 = r8;
        double r12 = 10.0d;
        boolean r16 = r10;
    L20:
        if (r12 < 1.0d) goto L63;
        if (r16 == false) goto L23;
    L26:
        r4 = r4;
        int r22 = r15;
        computeDerivatives(this.stepStart, r39, r4[r22]);
    L27:
        if (r16 == false) goto L41;
        double[] r13 = new double[this.mainSetDimension];
        if (this.vecAbsoluteTolerance != null) goto L35;
        int r18 = 0;
    L32:
        if (r18 >= r13.length) goto L34;
        r13[r18] = this.scalAbsoluteTolerance + (this.scalRelativeTolerance * FastMath.abs(r39[r18]));
        r18 = r18 + 1;
        r1 = r1;
        goto L32
    L34:
        boolean r19 = r1;
    L40:
        double[] r110 = r5;
        r11 = r11;
        boolean r2 = r19;
        int r111 = r3;
        r1 = r2;
        r16 = false;
        double r20 = initializeStep(r33, r2, getOrder(), r13, this.stepStart, r39, r4[r22], r9, r4[1]);
    L42:
        this.stepSize = r20;
        int r21 = 1;
    L43:
        if (r21 >= r111) goto L52;
        int r23 = 0;
    L46:
        if (r23 >= r36.length) goto L51;
        double r24 = this.a[r21 - 1][r22] * r4[r22][r23];
        int r25 = 1;
    L48:
        if (r25 >= r21) goto L50;
        r24 = r24 + (this.a[r21 - 1][r25] * r4[r25][r23]);
        r25 = r25 + 1;
        goto L48
    L50:
        r9[r23] = r39[r23] + (this.stepSize * r24);
        r23 = r23 + 1;
        r20 = r20;
        goto L46
    L51:
        computeDerivatives(this.stepStart + (this.c[r21 - 1] * this.stepSize), r9, r4[r21]);
        r21 = r21 + 1;
        r20 = r20;
        goto L43
    L52:
        double r26 = r20;
        int r27 = 0;
    L54:
        if (r27 >= r36.length) goto L59;
        double r28 = this.b[r22] * r4[r22][r27];
        int r29 = 1;
    L56:
        if (r29 >= r111) goto L58;
        r28 = r28 + (this.b[r29] * r4[r29][r27]);
        r29 = r29 + 1;
        goto L56
    L58:
        int r30 = r27;
        r9[r30] = r39[r27] + (this.stepSize * r28);
        r27 = r30 + 1;
        goto L54
    L59:
        r12 = estimateError(r4, r39, r9, this.stepSize);
        if (r12 >= 1.0d) goto L61;
        int r31 = r111;
        r17 = r26;
        r15 = 0;
        r5 = r110;
        r3 = r31;
        goto L20
    L61:
        int r112 = r111;
        r17 = filterStep(this.stepSize * FastMath.min(this.maxGrowth, FastMath.max(this.minReduction, FastMath.pow(r12, this.exp) * this.safety)), r1, r22);
        r16 = r16;
        r15 = 0;
        r5 = r110;
        r3 = r112;
        goto L20
    L35:
        r19 = r1;
        int r32 = 0;
    L37:
        if (r32 >= r13.length) goto L40;
        int r210 = r32;
        r13[r210] = this.vecAbsoluteTolerance[r32] + (this.vecRelativeTolerance[r210] * FastMath.abs(r39[r210]));
        r32 = r210 + 1;
        goto L37
    L41:
        r110 = r5;
        r11 = r11;
        r111 = r3;
        r1 = r1;
        r20 = r17;
        goto L42
    L23:
        if (this.fsal == false) goto L26;
        r4 = r4;
        r22 = r15;
        goto L27
    L63:
        double[][] r211 = r4;
        AbstractStepInterpolator r113 = r11;
        double r212 = r12;
        boolean r35 = r1;
        int r38 = r3;
        double[] r40 = r5;
        r113.storeTime(this.stepStart + this.stepSize);
        System.arraycopy(r9, 0, r39, 0, r36.length);
        System.arraycopy(r211[r38 - 1], 0, r40, 0, r36.length);
        this.stepStart = acceptStep(r113, r39, r40, r37);
        if (this.isLastStep == true) goto L90;
        r113.storeTime(this.stepStart);
        if (this.fsal == false) goto L69;
        System.arraycopy(r40, 0, r211[0], 0, r36.length);
    L69:
        double[] r41 = r40;
        int r114 = r38;
        double r42 = this.stepSize * FastMath.min(this.maxGrowth, FastMath.max(this.minReduction, FastMath.pow(r212, this.exp) * this.safety));
        double r115 = this.stepStart + r42;
        if (r35 == false) goto L76;
        if (r115 < r37) goto L74;
    L73:
        boolean r116 = true;
    L78:
        r17 = filterStep(r42, r35, r116);
        double r43 = this.stepStart + r17;
        if (r35 == false) goto L85;
        if (r43 < r37) goto L83;
    L82:
        boolean r213 = true;
    L87:
        if (r213 == false) goto L92;
        r17 = r37 - this.stepStart;
    L92:
        if (this.isLastStep == true) goto L93;
        r39 = r39;
        r1 = r35;
        r5 = r41;
        r11 = r113;
        r10 = r16;
        r3 = r114;
        r8 = r17;
        r4 = r211;
        r15 = 0;
        goto L18
    L93:
        double r44 = this.stepStart;
        resetInternalState();
        return r44;
    L83:
        r213 = false;
        goto L87
    L85:
        if (r43 > r37) goto L83;
    L74:
        r116 = false;
        goto L78
    L76:
        if (r115 > r37) goto L74;
    L90:
        r41 = r40;
        r114 = r38;
        goto L92
    L12:
        r7 = new DummyStepInterpolator(r9, r4[r3 - 1], r1);
        goto L13
    L5:
        r1 = false;
        goto L6
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
}

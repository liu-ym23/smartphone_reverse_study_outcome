package org.apache.commons.math.ode.nonstiff;

import java.util.Iterator;
import org.apache.commons.math.ode.AbstractIntegrator;
import org.apache.commons.math.ode.DerivativeException;
import org.apache.commons.math.ode.FirstOrderDifferentialEquations;
import org.apache.commons.math.ode.IntegratorException;
import org.apache.commons.math.ode.sampling.AbstractStepInterpolator;
import org.apache.commons.math.ode.sampling.DummyStepInterpolator;
import org.apache.commons.math.ode.sampling.StepHandler;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public abstract class RungeKuttaIntegrator extends AbstractIntegrator {
    private final double[][] a;
    private final double[] b;
    private final double[] c;
    private final RungeKuttaStepInterpolator prototype;
    private final double step;

    protected RungeKuttaIntegrator(String name, double[] c, double[][] a, double[] b, RungeKuttaStepInterpolator prototype, double step) {
        super(name);
        this.c = c;
        this.a = a;
        this.b = b;
        this.prototype = prototype;
        this.step = FastMath.abs(step);
    }

    @Override // org.apache.commons.math.ode.FirstOrderIntegrator
    public double integrate(FirstOrderDifferentialEquations r24, double r25, double[] r27, double r28, double[] r30) throws DerivativeException, IntegratorException {
        double[] r2 = r30;
        sanityChecks(r24, r25, r27, r28, r30);
        setEquations(r24);
        resetEvaluations();
        int r10 = 0;
        if (r28 <= r25) goto L5;
        boolean r1 = true;
    L6:
        boolean r11 = r1;
        int r12 = this.c.length + 1;
        if (r2 == r27) goto L9;
        System.arraycopy(r27, 0, r2, 0, r27.length);
    L9:
        double[][] r13 = new double[r12][];
        int r3 = 0;
    L10:
        if (r3 >= r12) goto L12;
        r13[r3] = new double[r27.length];
        r3 = r3 + 1;
        goto L10
    L12:
        double[] r14 = new double[r27.length];
        double[] r4 = new double[r27.length];
        if (requiresDenseOutput() == false) goto L15;
        RungeKuttaStepInterpolator r5 = (RungeKuttaStepInterpolator) this.prototype.copy();
        r5.reinitialize(this, r14, r13, r11);
        AbstractStepInterpolator r6 = r5;
    L16:
        r6.storeTime(r25);
        this.stepStart = r25;
        double r7 = this.step;
        if (r11 == true) goto L20;
        r7 = -r7;
    L20:
        this.stepSize = r7;
        Iterator<StepHandler> r8 = this.stepHandlers.iterator();
    L22:
        if (r8.hasNext() == false) goto L24;
        r8.next().reset();
        goto L22
    L24:
        setStateInitialized(false);
        this.isLastStep = false;
    L25:
        r6.shift();
        computeDerivatives(this.stepStart, r2, r13[r10]);
        int r9 = 1;
    L26:
        if (r9 >= r12) goto L35;
        int r15 = 0;
    L29:
        if (r15 >= r27.length) goto L34;
        double r16 = this.a[r9 - 1][r10] * r13[r10][r15];
        int r17 = 1;
    L31:
        if (r17 >= r9) goto L33;
        r16 = r16 + (this.a[r9 - 1][r17] * r13[r17][r15]);
        r17 = r17 + 1;
        r10 = r10;
        goto L31
    L33:
        int r20 = r15;
        r14[r20] = r2[r15] + (this.stepSize * r16);
        r15 = r20 + 1;
        r10 = r10;
        r9 = r9;
        goto L29
    L34:
        int r19 = r9;
        computeDerivatives(this.stepStart + (this.c[r19 - 1] * this.stepSize), r14, r13[r19]);
        r9 = r19 + 1;
        r10 = r10;
        goto L26
    L35:
        int r18 = r10;
        int r21 = 0;
    L37:
        if (r21 >= r27.length) goto L42;
        double r22 = this.b[r18] * r13[r18][r21];
        int r23 = 1;
    L39:
        if (r23 >= r12) goto L41;
        r22 = r22 + (this.b[r23] * r13[r23][r21]);
        r23 = r23 + 1;
        goto L39
    L41:
        int r110 = r21;
        r14[r110] = r2[r21] + (this.stepSize * r22);
        r21 = r110 + 1;
        goto L37
    L42:
        r6.storeTime(this.stepStart + this.stepSize);
        System.arraycopy(r14, r18, r2, r18, r27.length);
        System.arraycopy(r13[r12 - 1], r18, r4, r18, r27.length);
        this.stepStart = acceptStep(r6, r2, r4, r28);
        if (this.isLastStep == true) goto L56;
        r6.storeTime(this.stepStart);
        double r26 = this.stepStart + this.stepSize;
        if (r11 == false) goto L51;
        if (r26 < r28) goto L49;
    L48:
        boolean r29 = true;
    L53:
        if (r29 == false) goto L56;
        this.stepSize = r28 - this.stepStart;
    L49:
        r29 = false;
        goto L53
    L51:
        if (r26 > r28) goto L49;
    L56:
        if (this.isLastStep == true) goto L57;
        r2 = r30;
        r10 = 0;
        goto L25
    L57:
        double r31 = this.stepStart;
        this.stepStart = Double.NaN;
        this.stepSize = Double.NaN;
        return r31;
    L15:
        r6 = new DummyStepInterpolator(r14, r13[r12 - 1], r11);
        goto L16
    L5:
        r1 = false;
        goto L6
    }
}

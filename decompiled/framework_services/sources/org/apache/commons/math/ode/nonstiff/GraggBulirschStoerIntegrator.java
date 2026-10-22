package org.apache.commons.math.ode.nonstiff;

import java.util.Iterator;
import org.apache.commons.math.ode.DerivativeException;
import org.apache.commons.math.ode.FirstOrderDifferentialEquations;
import org.apache.commons.math.ode.IntegratorException;
import org.apache.commons.math.ode.events.EventHandler;
import org.apache.commons.math.ode.sampling.AbstractStepInterpolator;
import org.apache.commons.math.ode.sampling.DummyStepInterpolator;
import org.apache.commons.math.ode.sampling.StepHandler;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class GraggBulirschStoerIntegrator extends AdaptiveStepsizeIntegrator {
    private static final String METHOD_NAME = "Gragg-Bulirsch-Stoer";
    private double[][] coeff;
    private int[] costPerStep;
    private double[] costPerTimeUnit;
    private int maxChecks;
    private int maxIter;
    private int maxOrder;
    private int mudif;
    private double[] optimalStep;
    private double orderControl1;
    private double orderControl2;
    private boolean performTest;
    private int[] sequence;
    private double stabilityReduction;
    private double stepControl1;
    private double stepControl2;
    private double stepControl3;
    private double stepControl4;
    private boolean useInterpolationError;

    public GraggBulirschStoerIntegrator(double minStep, double maxStep, double scalAbsoluteTolerance, double scalRelativeTolerance) {
        super(METHOD_NAME, minStep, maxStep, scalAbsoluteTolerance, scalRelativeTolerance);
        setStabilityCheck(true, -1, -1, -1.0d);
        setStepsizeControl(-1.0d, -1.0d, -1.0d, -1.0d);
        setOrderControl(-1, -1.0d, -1.0d);
        setInterpolationControl(true, -1);
    }

    public GraggBulirschStoerIntegrator(double minStep, double maxStep, double[] vecAbsoluteTolerance, double[] vecRelativeTolerance) {
        super(METHOD_NAME, minStep, maxStep, vecAbsoluteTolerance, vecRelativeTolerance);
        setStabilityCheck(true, -1, -1, -1.0d);
        setStepsizeControl(-1.0d, -1.0d, -1.0d, -1.0d);
        setOrderControl(-1, -1.0d, -1.0d);
        setInterpolationControl(true, -1);
    }

    public void setStabilityCheck(boolean performStabilityCheck, int maxNumIter, int maxNumChecks, double stepsizeReductionFactor) {
        this.performTest = performStabilityCheck;
        if (maxNumIter > 0) goto L5;
        int r0 = 2;
    L6:
        this.maxIter = r0;
        if (maxNumChecks > 0) goto L9;
        int r1 = 1;
    L10:
        this.maxChecks = r1;
        if (stepsizeReductionFactor >= 1.0E-4d) goto L13;
    L16:
        this.stabilityReduction = 0.5d;
        return;
    L13:
        if (stepsizeReductionFactor > 0.9999d) goto L16;
        this.stabilityReduction = stepsizeReductionFactor;
        return;
    L9:
        r1 = maxNumChecks;
        goto L10
    L5:
        r0 = maxNumIter;
        goto L6
    }

    public void setStepsizeControl(double control1, double control2, double control3, double control4) {
        if (control1 >= 1.0E-4d) goto L5;
    L8:
        this.stepControl1 = 0.65d;
    L10:
        if (control2 >= 1.0E-4d) goto L12;
    L15:
        this.stepControl2 = 0.94d;
    L17:
        if (control3 >= 1.0E-4d) goto L19;
    L22:
        this.stepControl3 = 0.02d;
    L24:
        if (control4 >= 1.0001d) goto L26;
    L29:
        this.stepControl4 = 4.0d;
        return;
    L26:
        if (control4 > 999.9d) goto L29;
        this.stepControl4 = control4;
        return;
    L19:
        if (control3 > 0.9999d) goto L22;
        this.stepControl3 = control3;
        goto L24
    L12:
        if (control2 > 0.9999d) goto L15;
        this.stepControl2 = control2;
        goto L17
    L5:
        if (control1 > 0.9999d) goto L8;
        this.stepControl1 = control1;
        goto L10
    }

    public void setOrderControl(int maximalOrder, double control1, double control2) {
        if (maximalOrder > 6) goto L5;
    L6:
        this.maxOrder = 18;
    L8:
        if (control1 >= 1.0E-4d) goto L10;
    L13:
        this.orderControl1 = 0.8d;
    L15:
        if (control2 >= 1.0E-4d) goto L17;
    L20:
        this.orderControl2 = 0.9d;
    L21:
        initializeArrays();
        return;
    L17:
        if (control2 > 0.9999d) goto L20;
        this.orderControl2 = control2;
        goto L21
    L10:
        if (control1 > 0.9999d) goto L13;
        this.orderControl1 = control1;
        goto L15
    L5:
        if ((maximalOrder % 2) == 0) goto L8;
        goto L6
    }

    @Override // org.apache.commons.math.ode.AbstractIntegrator, org.apache.commons.math.ode.ODEIntegrator
    public void addStepHandler(StepHandler handler) {
        super.addStepHandler(handler);
        initializeArrays();
    }

    @Override // org.apache.commons.math.ode.AbstractIntegrator, org.apache.commons.math.ode.ODEIntegrator
    public void addEventHandler(EventHandler function, double maxCheckInterval, double convergence, int maxIterationCount) {
        super.addEventHandler(function, maxCheckInterval, convergence, maxIterationCount);
        initializeArrays();
    }

    private void initializeArrays() {
        int size = this.maxOrder / 2;
        if (this.sequence != null) goto L5;
    L6:
        this.sequence = new int[size];
        this.costPerStep = new int[size];
        this.coeff = new double[size][];
        this.costPerTimeUnit = new double[size];
        this.optimalStep = new double[size];
    L8:
        if (requiresDenseOutput() == false) goto L13;
        int k = 0;
    L10:
        if (k >= size) goto L16;
        this.sequence[k] = (k * 4) + 2;
        k = k + 1;
    L16:
        this.costPerStep[0] = this.sequence[0] + 1;
        int k2 = 1;
    L17:
        if (k2 >= size) goto L19;
        this.costPerStep[k2] = this.costPerStep[k2 - 1] + this.sequence[k2];
        k2 = k2 + 1;
        goto L17
    L19:
        int k3 = 0;
    L20:
        if (k3 >= size) goto L30;
        double[][] r2 = this.coeff;
        if (k3 <= 0) goto L24;
        double[] r3 = new double[k3];
    L25:
        r2[k3] = r3;
        int l = 0;
    L26:
        if (l >= k3) goto L28;
        double ratio = ((double) this.sequence[k3]) / ((double) this.sequence[(k3 - l) - 1]);
        this.coeff[k3][l] = 1.0d / ((ratio * ratio) - 1.0d);
        l = l + 1;
        goto L26
    L28:
        k3 = k3 + 1;
        goto L20
    L24:
        r3 = null;
        goto L25
    L30:
        return;
    L13:
        int k4 = 0;
    L14:
        if (k4 >= size) goto L16;
        this.sequence[k4] = (k4 + 1) * 2;
        k4 = k4 + 1;
        goto L14
    L5:
        if (this.sequence.length == size) goto L8;
        goto L6
    }

    public void setInterpolationControl(boolean useInterpolationErrorForControl, int mudifControlParameter) {
        this.useInterpolationError = useInterpolationErrorForControl;
        if (mudifControlParameter > 0) goto L5;
    L8:
        this.mudif = 4;
        return;
    L5:
        if (mudifControlParameter >= 7) goto L8;
        this.mudif = mudifControlParameter;
    }

    private void rescale(double[] y1, double[] y2, double[] scale) {
        if (this.vecAbsoluteTolerance != null) goto L9;
        int i = 0;
    L6:
        if (i >= scale.length) goto L13;
        double yi = FastMath.max(FastMath.abs(y1[i]), FastMath.abs(y2[i]));
        scale[i] = this.scalAbsoluteTolerance + (this.scalRelativeTolerance * yi);
        i = i + 1;
        goto L6
    L13:
        return;
    L9:
        int i2 = 0;
    L11:
        if (i2 >= scale.length) goto L16;
        double yi2 = FastMath.max(FastMath.abs(y1[i2]), FastMath.abs(y2[i2]));
        scale[i2] = this.vecAbsoluteTolerance[i2] + (this.vecRelativeTolerance[i2] * yi2);
        i2 = i2 + 1;
        goto L11
    }

    private boolean tryStep(double r25, double[] r27, double r28, int r30, double[] r31, double[][] r32, double[] r33, double[] r34, double[] r35) throws DerivativeException {
        GraggBulirschStoerIntegrator r0 = this;
        int r2 = r30;
        int r5 = r0.sequence[r2];
        double r6 = r28 / ((double) r5);
        double r8 = 2.0d * r6;
        double r10 = r25 + r6;
        int r12 = 0;
    L3:
        boolean r14 = false;
        if (r12 >= r27.length) goto L6;
        r35[r12] = r27[r12];
        r34[r12] = r27[r12] + (r32[0][r12] * r6);
        r12 = r12 + 1;
        goto L3
    L6:
        boolean r13 = true;
        r0.computeDerivatives(r10, r34, r32[1]);
        int r15 = 1;
    L7:
        if (r15 >= r5) goto L34;
        if ((r15 * 2) != r5) goto L12;
        System.arraycopy(r34, r14 ? 1 : 0, r33, r14 ? 1 : 0, r27.length);
    L12:
        r10 = r10 + r6;
        int r16 = 0;
    L13:
        boolean r17 = r14;
        if (r16 >= r27.length) goto L16;
        double r18 = r34[r16];
        r34[r16] = r35[r16] + (r32[r15][r16] * r8);
        r35[r16] = r18;
        r16 = r16 + 1;
        r14 = r17 ? 1 : 0;
        goto L13
    L16:
        r0.computeDerivatives(r10, r34, r32[r15 + 1]);
        if (r0.performTest == false) goto L33;
        if (r15 > r0.maxChecks) goto L33;
        if (r2 >= r0.maxIter) goto L33;
        double r19 = 0.0d;
        int r1 = 0;
    L24:
        if (r1 >= r31.length) goto L26;
        double r110 = r32[r17 ? 1 : 0][r1] / r31[r1];
        r19 = r19 + (r110 * r110);
        r1 = r1 + 1;
        goto L24
    L26:
        double r111 = 0.0d;
        int r3 = 0;
    L28:
        if (r3 >= r31.length) goto L31;
        double r20 = (r32[r15 + 1][r3] - r32[r17 ? 1 : 0][r3]) / r31[r3];
        r111 = r111 + (r20 * r20);
        r3 = r3 + 1;
        goto L28
    L31:
        if (r111 <= (FastMath.max(1.0E-15d, r19) * 4.0d)) goto L33;
        return r17;
    L33:
        r15 = r15 + 1;
        r0 = this;
        r2 = r30;
        r13 = r13;
        r14 = r17 ? 1 : 0;
        goto L7
    L34:
        boolean r112 = r13;
        int r4 = 0;
    L36:
        if (r4 >= r27.length) goto L39;
        r34[r4] = ((r35[r4] + r34[r4]) + (r32[r5][r4] * r6)) * 0.5d;
        r4 = r4 + 1;
        goto L36
    L39:
        return r112;
    }

    private void extrapolate(int offset, int k, double[][] diag, double[] last) {
        int j = 1;
    L3:
        if (j >= k) goto L9;
        int i = 0;
    L6:
        if (i >= last.length) goto L8;
        diag[(k - j) - 1][i] = diag[k - j][i] + (this.coeff[k + offset][j - 1] * (diag[k - j][i] - diag[(k - j) - 1][i]));
        i = i + 1;
        goto L6
    L8:
        j = j + 1;
        goto L3
    L9:
        int i2 = 0;
    L11:
        if (i2 >= last.length) goto L14;
        last[i2] = diag[0][i2] + (this.coeff[k + offset][k - 1] * (diag[0][i2] - last[i2]));
        i2 = i2 + 1;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math.ode.nonstiff.AdaptiveStepsizeIntegrator, org.apache.commons.math.ode.FirstOrderIntegrator
    public double integrate(FirstOrderDifferentialEquations equations, double t0, double[] y0, double t, double[] y) throws DerivativeException, IntegratorException {
        sanityChecks(equations, t0, y0, t, y);
        setEquations(equations);
        resetEvaluations();
        char r15 = 0;
        int r11 = 1;
        if (t <= t0) goto L5;
        boolean forward = true;
    L6:
        double[] scale = new double[y0.length];
        double[] y1 = new double[y0.length];
        double[] yTmp = new double[y0.length];
        double[] yDot0 = new double[y0.length];
        double[][] diagonal = new double[this.sequence.length - 1][];
        double[][] y1Diag = new double[this.sequence.length - 1][];
        int k = 0;
    L8:
        if (k >= (this.sequence.length - 1)) goto L10;
        diagonal[k] = new double[y0.length];
        y1Diag[k] = new double[y0.length];
        k = k + 1;
        goto L8
    L10:
        double[][][] fk = new double[this.sequence.length][][];
        int k2 = 0;
    L11:
        int r16 = r11;
        if (k2 >= this.sequence.length) goto L18;
        fk[k2] = new double[this.sequence[k2] + 1][];
        fk[k2][r15] = scale;
        int l = 0;
    L15:
        if (l >= this.sequence[k2]) goto L17;
        fk[k2][l + 1] = new double[y0.length];
        l = l + 1;
        diagonal = diagonal;
        goto L15
    L17:
        k2 = k2 + 1;
        r11 = r16;
        r15 = 0;
        goto L11
    L18:
        double[][] diagonal2 = diagonal;
        if (y == y0) goto L21;
        System.arraycopy(y0, 0, y, 0, y0.length);
    L21:
        double[] yDot1 = new double[y0.length];
        boolean denseOutput = requiresDenseOutput();
        if (denseOutput == false) goto L28;
        double[][] yMidDots = new double[(this.sequence.length * 2) + 1][];
        int j = 0;
    L24:
        double[] yDot2 = yDot1;
        if (j >= yMidDots.length) goto L29;
        yMidDots[j] = new double[y0.length];
        j = j + 1;
        yDot1 = yDot2;
    L29:
        double[] scale2 = new double[this.mainSetDimension];
        rescale(y, y, scale2);
        if (this.vecRelativeTolerance != null) goto L32;
        double tol = this.scalRelativeTolerance;
    L33:
        double[][] y1Diag2 = y1Diag;
        double log10R = FastMath.log10(FastMath.max(1.0E-10d, tol));
        int r3 = this.sequence.length - 2;
        double tol2 = FastMath.floor(0.5d - (0.6d * log10R));
        int targetIter = FastMath.max(1, FastMath.min(r3, (int) tol2));
        if (denseOutput == false) goto L36;
        double[] yDot3 = yDot2;
        GraggBulirschStoerStepInterpolator r1 = new GraggBulirschStoerStepInterpolator(y, scale, y1, yDot3, yMidDots, forward);
        double[] yDot4 = y;
        double[] y2 = y1;
        AbstractStepInterpolator interpolator = r1;
        double[] yDot5 = yDot3;
    L37:
        interpolator.storeTime(t0);
        this.stepStart = t0;
        double[] yDot6 = yDot5;
        Iterator<StepHandler> r2 = this.stepHandlers.iterator();
    L39:
        if (r2.hasNext() == false) goto L41;
        StepHandler handler = r2.next();
        handler.reset();
        goto L39
    L41:
        setStateInitialized(false);
        this.costPerTimeUnit[0] = 0.0d;
        this.isLastStep = false;
        boolean newStep = true;
        boolean forward2 = false;
        boolean firstTime = true;
        double maxError = Double.MAX_VALUE;
        int targetIter2 = targetIter;
        boolean previousRejected = false;
        double hNew = 0.0d;
    L42:
        boolean reject = false;
        if (newStep == false) goto L51;
        interpolator.shift();
        if (forward2 == true) goto L47;
        computeDerivatives(this.stepStart, yDot4, scale);
    L47:
        if (firstTime == false) goto L49;
        boolean r17 = true;
        double[] scale3 = scale2;
        boolean forward3 = forward;
        hNew = initializeStep(equations, forward3, (targetIter2 * 2) + 1, scale3, this.stepStart, yDot4, scale, yTmp, yDot0);
        forward = forward3;
    L50:
        newStep = false;
        double hNew2 = hNew;
    L52:
        this.stepSize = hNew2;
        if (forward == false) goto L57;
        double r5 = this.stepStart;
        double hNew3 = hNew2;
        double hNew4 = this.stepSize;
        if ((r5 + hNew4) <= t) goto L58;
    L61:
        this.stepSize = t - this.stepStart;
    L62:
        double nextT = this.stepStart + this.stepSize;
        if (forward == false) goto L69;
        if (nextT < t) goto L67;
    L66:
        boolean r4 = r17;
    L71:
        this.isLastStep = r4;
        int k3 = -1;
        int k4 = targetIter2;
        int targetIter3 = 1;
    L73:
        if (targetIter3 == 0) goto L150;
        k3 = k3 + 1;
        int targetIter4 = k4;
        double r6 = this.stepStart;
        boolean forward4 = forward;
        double[] scale4 = scale3;
        double r7 = this.stepSize;
        double[] yDot7 = scale;
        double[][] r8 = fk[k3];
        if (k3 != 0) goto L77;
        double[] r45 = yMidDots[0];
    L78:
        if (k3 != 0) goto L80;
        double[] r46 = y2;
    L81:
        int targetIter5 = targetIter4;
        diagonal2 = diagonal2;
        scale = yDot7;
        forward = forward4;
        yDot6 = yDot6;
        y2 = y2;
        double[] y3 = yTmp;
        double[] yTmp2 = r45;
        boolean r9 = tryStep(r6, y, r7, k3, scale4, r8, yTmp2, r46, y3);
        scale3 = scale4;
        yTmp = y3;
        if (r9 == false) goto L83;
        if (k3 > 0) goto L86;
        k4 = targetIter5;
        goto L73
    L86:
        extrapolate(0, k3, y1Diag2, y2);
        rescale(y, y2, scale3);
        double error = 0.0d;
        int j2 = 0;
    L88:
        if (j2 >= this.mainSetDimension) goto L90;
        double e = FastMath.abs(y2[j2] - y1Diag2[0][j2]) / scale3[j2];
        error = error + (e * e);
        j2 = j2 + 1;
        goto L88
    L90:
        int j3 = this.mainSetDimension;
        double error2 = FastMath.sqrt(error / ((double) j3));
        if (error2 > 1.0E15d) goto L148;
        if (k3 <= 1) goto L97;
        if (error2 > maxError) goto L148;
    L97:
        maxError = FastMath.max(4.0d * error2, 1.0d);
        double exp = 1.0d / ((double) ((k3 * 2) + 1));
        double r10 = this.stepControl2;
        double error3 = this.stepControl1;
        double fac = r10 / FastMath.pow(error2 / error3, exp);
        double pow = FastMath.pow(this.stepControl3, exp);
        this.optimalStep[k3] = FastMath.abs(filterStep(this.stepSize * FastMath.max(pow / this.stepControl4, FastMath.min(1.0d / pow, fac)), forward, true));
        this.costPerTimeUnit[k3] = ((double) this.costPerStep[k3]) / this.optimalStep[k3];
        switch((k3 - targetIter5)) {
            case -1: goto L130;
            case 0: goto L115;
            case 1: goto L106;
            default: goto L99;
        };
    L99:
        if (firstTime == true) goto L103;
        if (this.isLastStep == true) goto L103;
    L145:
        k4 = targetIter5;
    L103:
        if (error2 > 1.0d) goto L145;
        targetIter3 = 0;
        k4 = targetIter5;
        goto L73
    L106:
        if (error2 <= 1.0d) goto L113;
        reject = true;
        if (targetIter5 > 1) goto L110;
    L112:
        hNew3 = this.optimalStep[targetIter5];
        goto L113
    L110:
        if (this.costPerTimeUnit[targetIter5 - 1] >= (this.orderControl1 * this.costPerTimeUnit[targetIter5])) goto L112;
        targetIter5 = targetIter5 - 1;
    L113:
        targetIter3 = 0;
        k4 = targetIter5;
        goto L73
    L115:
        if (error2 > 1.0d) goto L117;
        targetIter3 = 0;
        k4 = targetIter5;
        goto L73
    L117:
        double ratio = ((double) this.sequence[k3 + 1]) / ((double) this.sequence[0]);
        if (error2 <= (ratio * ratio)) goto L127;
        reject = true;
        targetIter3 = 0;
        if (targetIter5 <= 1) goto L125;
        double r12 = this.costPerTimeUnit[targetIter5 - 1];
        double fac2 = this.orderControl1;
        if (r12 >= (fac2 * this.costPerTimeUnit[targetIter5])) goto L125;
        k4 = targetIter5 - 1;
    L126:
        hNew3 = this.optimalStep[k4];
    L125:
        k4 = targetIter5;
        goto L126
    L127:
        k4 = targetIter5;
        goto L73
    L130:
        if (targetIter5 <= 1) goto L145;
        if (previousRejected == true) goto L145;
        if (error2 > 1.0d) goto L135;
        targetIter3 = 0;
        k4 = targetIter5;
        goto L73
    L135:
        double ratio2 = (((double) this.sequence[targetIter5]) * ((double) this.sequence[targetIter5 + 1])) / ((double) (this.sequence[0] * this.sequence[0]));
        if (error2 <= (ratio2 * ratio2)) goto L143;
        reject = true;
        targetIter3 = 0;
        int targetIter6 = k3;
        if (targetIter6 > 1) goto L140;
    L142:
        hNew3 = this.optimalStep[targetIter6];
        k4 = targetIter6;
        goto L73
    L140:
        if (this.costPerTimeUnit[targetIter6 - 1] >= (this.orderControl1 * this.costPerTimeUnit[targetIter6])) goto L142;
        targetIter6 = targetIter6 - 1;
        goto L142
    L143:
        k4 = targetIter5;
    L148:
        double error4 = this.stepSize;
        hNew3 = FastMath.abs(filterStep(error4 * this.stabilityReduction, forward, false));
        reject = true;
        targetIter3 = 0;
        k4 = targetIter5;
        goto L73
    L83:
        hNew3 = FastMath.abs(filterStep(this.stepSize * this.stabilityReduction, forward, false));
        reject = true;
        targetIter3 = 0;
        k4 = targetIter5;
        goto L73
    L80:
        r46 = y1Diag2[k3 - 1];
        goto L81
    L77:
        r45 = diagonal2[k3 - 1];
        goto L78
    L150:
        int targetIter7 = k4;
        double[] yDot8 = scale;
        double[][] diagonal3 = diagonal2;
        double[] yDot9 = yDot6;
        double[] yDot10 = scale3;
        boolean forward5 = forward;
        double[] yDot11 = y2;
        if (reject == true) goto L153;
        double[] yDot12 = yDot9;
        computeDerivatives(this.stepStart + this.stepSize, yDot11, yDot12);
    L154:
        double hInt = getMaxStep();
        if (denseOutput == false) goto L200;
        if (reject == true) goto L200;
        int j4 = 1;
    L158:
        if (j4 > k3) goto L160;
        extrapolate(0, j4, diagonal3, yMidDots[0]);
        j4 = j4 + 1;
        goto L158
    L160:
        double[][] diagonal4 = diagonal3;
        int j5 = k3 * 2;
        int mu = (j5 - this.mudif) + 3;
        int l2 = 0;
    L161:
        if (l2 >= mu) goto L190;
        int l3 = l2 / 2;
        double hInt2 = hInt;
        boolean forward6 = forward5;
        double[][] y1Diag3 = y1Diag2;
        double factor = FastMath.pow(((double) this.sequence[l3]) * 0.5d, l2);
        int middleIndex = fk[l3].length / 2;
        int i = 0;
    L163:
        double factor2 = factor;
        double[] yTmp3 = yTmp;
        if (i >= y0.length) goto L166;
        yMidDots[l2 + 1][i] = fk[l3][middleIndex + l2][i] * factor2;
        i = i + 1;
        yTmp = yTmp3;
        factor = factor2;
        goto L163
    L166:
        int j6 = 1;
    L168:
        if (j6 > (k3 - l3)) goto L174;
        double[] yDot13 = yDot12;
        double factor3 = FastMath.pow(((double) this.sequence[j6 + l3]) * 0.5d, l2);
        middleIndex = fk[l3 + j6].length / 2;
        int i2 = 0;
    L171:
        if (i2 >= y0.length) goto L173;
        diagonal4[j6 - 1][i2] = fk[l3 + j6][middleIndex + l2][i2] * factor3;
        i2 = i2 + 1;
        goto L171
    L173:
        int i3 = l2 + 1;
        extrapolate(l3, j6, diagonal4, yMidDots[i3]);
        j6 = j6 + 1;
        yDot12 = yDot13;
        goto L168
    L174:
        double[] yDot14 = yDot12;
        int i4 = 0;
    L176:
        if (i4 >= y0.length) goto L178;
        double[] r13 = yMidDots[l2 + 1];
        int i5 = i4;
        r13[i5] = r13[i4] * this.stepSize;
        i4 = i5 + 1;
        goto L176
    L178:
        int i6 = l2 + 1;
        int j7 = i6 / 2;
    L179:
        if (j7 > k3) goto L189;
        int m = fk[j7].length;
    L181:
        m = m - 1;
        if (m < ((l2 + 1) * 2)) goto L188;
        int i7 = 0;
    L185:
        if (i7 >= y0.length) goto L181;
        double[] r14 = fk[j7][m];
        r14[i7] = r14[i7] - fk[j7][m - 2][i7];
        i7 = i7 + 1;
        goto L185
    L188:
        j7 = j7 + 1;
        goto L179
    L189:
        l2 = l2 + 1;
        y1Diag2 = y1Diag3;
        forward5 = forward6;
        yTmp = yTmp3;
        hInt = hInt2;
        yDot12 = yDot14;
        goto L161
    L190:
        double hInt3 = hInt;
        double[] yDot15 = yDot12;
        double[] yTmp4 = yTmp;
        boolean forward7 = forward5;
        double[][] y1Diag4 = y1Diag2;
        int r48 = 2;
        double[] yTmp5 = y0;
        if (mu < 0) goto L199;
        AbstractStepInterpolator interpolator2 = interpolator;
        GraggBulirschStoerStepInterpolator gbsInterpolator = (GraggBulirschStoerStepInterpolator) interpolator2;
        gbsInterpolator.computeCoefficients(mu, this.stepSize);
        if (this.useInterpolationError == false) goto L201;
        double interpError = gbsInterpolator.estimateError(yDot10);
        double hInt4 = FastMath.abs(this.stepSize / FastMath.max(FastMath.pow(interpError, 1.0d / ((double) (mu + 4))), 0.01d));
        if (interpError <= 10.0d) goto L197;
        hNew3 = hInt4;
        reject = true;
        double interpError2 = hInt4;
    L202:
        if (reject == true) goto L238;
        interpolator2.storeTime(this.stepStart + this.stepSize);
        yDot15 = yDot15;
        this.stepStart = acceptStep(interpolator2, yDot11, yDot15, t);
        interpolator2.storeTime(this.stepStart);
        System.arraycopy(yDot11, 0, y, 0, yTmp5.length);
        double[] yDot16 = yDot8;
        System.arraycopy(yDot15, 0, yDot16, 0, yTmp5.length);
        forward2 = true;
        if (k3 != 1) goto L209;
        int optimalIter = 2;
        if (previousRejected == false) goto L208;
        optimalIter = 1;
        AbstractStepInterpolator interpolator3 = interpolator2;
        double[] y4 = yDot11;
    L226:
        if (previousRejected == false) goto L229;
        int targetIter8 = FastMath.min(optimalIter, k3);
        double hNew5 = FastMath.min(FastMath.abs(this.stepSize), this.optimalStep[targetIter8]);
        int targetIter9 = targetIter8;
        boolean forward8 = forward7;
    L237:
        targetIter2 = targetIter9;
        newStep = true;
        double hNew6 = hNew5;
    L239:
        double hNew7 = FastMath.min(hNew6, interpError2);
        if (forward8 == true) goto L242;
        hNew = -hNew7;
    L243:
        firstTime = false;
        if (reject == false) goto L246;
        this.isLastStep = false;
        previousRejected = true;
    L248:
        if (this.isLastStep == true) goto L249;
        boolean r18 = denseOutput;
        diagonal2 = diagonal4;
        denseOutput = r18;
        y2 = y4;
        yDot4 = y;
        scale2 = yDot10;
        scale = yDot16;
        yDot0 = yDot0;
        yTmp = yTmp4;
        yDot6 = yDot15;
        forward = forward8;
        y1Diag2 = y1Diag4;
        interpolator = interpolator3;
        goto L42
    L249:
        double stopTime = this.stepStart;
        resetInternalState();
        return stopTime;
    L246:
        previousRejected = false;
        goto L248
    L242:
        hNew = hNew7;
        goto L243
    L229:
        if (optimalIter > k3) goto L231;
        double hNew8 = this.optimalStep[optimalIter];
        forward8 = forward7;
    L236:
        hNew5 = hNew8;
        targetIter9 = optimalIter;
        goto L237
    L231:
        if (k3 < targetIter7) goto L233;
    L235:
        forward8 = forward7;
        hNew8 = filterStep((((double) this.costPerStep[optimalIter]) * this.optimalStep[k3]) / ((double) this.costPerStep[k3]), forward8, false);
        goto L236
    L233:
        if (this.costPerTimeUnit[k3] >= (this.orderControl2 * this.costPerTimeUnit[k3 - 1])) goto L235;
        forward8 = forward7;
        hNew8 = filterStep((this.optimalStep[k3] * ((double) this.costPerStep[optimalIter + 1])) / ((double) this.costPerStep[k3]), forward8, false);
        goto L236
    L208:
        interpolator3 = interpolator2;
        y4 = yDot11;
        goto L226
    L209:
        if (k3 > targetIter7) goto L216;
        optimalIter = k3;
        interpolator3 = interpolator2;
        y4 = yDot11;
        if (this.costPerTimeUnit[k3 - 1] >= (this.costPerTimeUnit[k3] * this.orderControl1)) goto L214;
        optimalIter = k3 - 1;
        goto L226
    L214:
        if (this.costPerTimeUnit[k3] >= (this.costPerTimeUnit[k3 - 1] * this.orderControl2)) goto L226;
        optimalIter = FastMath.min(k3 + 1, this.sequence.length - 2);
        goto L226
    L216:
        interpolator3 = interpolator2;
        y4 = yDot11;
        int optimalIter2 = k3 - 1;
        if (k3 <= r48) goto L221;
        optimalIter = optimalIter2;
        if (this.costPerTimeUnit[k3 - 2] >= (this.costPerTimeUnit[k3 - 1] * this.orderControl1)) goto L223;
        optimalIter = k3 - 2;
    L223:
        if (this.costPerTimeUnit[k3] >= (this.costPerTimeUnit[optimalIter] * this.orderControl2)) goto L225;
        r48 = 2;
        optimalIter = FastMath.min(k3, this.sequence.length - 2);
        goto L226
    L225:
        r48 = 2;
        goto L226
    L221:
        optimalIter = optimalIter2;
        goto L223
    L238:
        interpolator3 = interpolator2;
        y4 = yDot11;
        forward8 = forward7;
        yDot16 = yDot8;
        targetIter2 = targetIter7;
        hNew6 = hNew3;
        goto L239
    L197:
        interpError2 = hInt4;
    L201:
        interpError2 = hInt3;
        goto L202
    L199:
        interpolator2 = interpolator;
    L200:
        hInt3 = hInt;
        yDot15 = yDot12;
        yTmp4 = yTmp;
        forward7 = forward5;
        diagonal4 = diagonal3;
        interpolator2 = interpolator;
        r48 = 2;
        yTmp5 = y0;
        y1Diag4 = y1Diag2;
        goto L201
    L153:
        yDot12 = yDot9;
    L67:
        r4 = false;
        goto L71
    L69:
        if (nextT > t) goto L67;
    L58:
        if (forward == true) goto L62;
        if ((this.stepStart + this.stepSize) >= t) goto L62;
    L57:
        hNew3 = hNew2;
        goto L58
    L49:
        scale3 = scale2;
        r17 = true;
        goto L50
    L51:
        interpolator = interpolator;
        scale3 = scale2;
        diagonal2 = diagonal2;
        y1Diag2 = y1Diag2;
        r17 = true;
        y2 = y2;
        yDot0 = yDot0;
        denseOutput = denseOutput;
        yDot6 = yDot6;
        hNew2 = hNew;
        goto L52
    L36:
        yDot4 = y;
        yDot5 = yDot2;
        y2 = y1;
        interpolator = new DummyStepInterpolator(yDot4, yDot5, forward);
        goto L37
    L32:
        tol = this.vecRelativeTolerance[0];
        goto L33
    L28:
        yDot2 = yDot1;
        yMidDots = new double[r16][];
        yMidDots[0] = new double[y0.length];
        goto L29
    L5:
        forward = false;
        goto L6
    }
}

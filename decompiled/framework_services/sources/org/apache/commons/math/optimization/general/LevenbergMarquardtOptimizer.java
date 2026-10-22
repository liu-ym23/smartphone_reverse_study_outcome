package org.apache.commons.math.optimization.general;

import java.util.Arrays;
import org.apache.commons.math.FunctionEvaluationException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.optimization.OptimizationException;
import org.apache.commons.math.optimization.VectorialPointValuePair;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class LevenbergMarquardtOptimizer extends AbstractLeastSquaresOptimizer {
    private double[] beta;
    private double costRelativeTolerance;
    private double[] diagR;
    private double initialStepBoundFactor;
    private double[] jacNorm;
    private double[] lmDir;
    private double lmPar;
    private double orthoTolerance;
    private double parRelativeTolerance;
    private int[] permutation;
    private double qrRankingThreshold;
    private int rank;
    private int solvedCols;

    public LevenbergMarquardtOptimizer() {
        setMaxIterations(1000);
        setConvergenceChecker(null);
        setInitialStepBoundFactor(100.0d);
        setCostRelativeTolerance(1.0E-10d);
        setParRelativeTolerance(1.0E-10d);
        setOrthoTolerance(1.0E-10d);
        setQRRankingThreshold(Double.MIN_NORMAL);
    }

    public void setInitialStepBoundFactor(double initialStepBoundFactor) {
        this.initialStepBoundFactor = initialStepBoundFactor;
    }

    public void setCostRelativeTolerance(double costRelativeTolerance) {
        this.costRelativeTolerance = costRelativeTolerance;
    }

    public void setParRelativeTolerance(double parRelativeTolerance) {
        this.parRelativeTolerance = parRelativeTolerance;
    }

    public void setOrthoTolerance(double orthoTolerance) {
        this.orthoTolerance = orthoTolerance;
    }

    public void setQRRankingThreshold(double threshold) {
        this.qrRankingThreshold = threshold;
    }

    @Override // org.apache.commons.math.optimization.general.AbstractLeastSquaresOptimizer
    protected VectorialPointValuePair doOptimize() throws FunctionEvaluationException, OptimizationException, IllegalArgumentException {
        this.solvedCols = Math.min(this.rows, this.cols);
        this.diagR = new double[this.cols];
        this.jacNorm = new double[this.cols];
        this.beta = new double[this.cols];
        this.permutation = new int[this.cols];
        this.lmDir = new double[this.cols];
        double xNorm = 0.0d;
        double[] diag = new double[this.cols];
        double[] oldX = new double[this.cols];
        double[] oldRes = new double[this.rows];
        double[] oldObj = new double[this.rows];
        double[] qtf = new double[this.rows];
        double[] work1 = new double[this.cols];
        double[] work2 = new double[this.cols];
        double[] work3 = new double[this.cols];
        updateResidualsAndCost();
        this.lmPar = 0.0d;
        boolean firstIteration = true;
        VectorialPointValuePair current = new VectorialPointValuePair(this.point, this.objective);
        double delta = 0.0d;
    L3:
        int i = 0;
    L4:
        double delta2 = delta;
        if (i >= this.rows) goto L7;
        qtf[i] = this.wresiduals[i];
        i = i + 1;
        delta = delta2;
        goto L4
    L7:
        incrementIterationsCounter();
        VectorialPointValuePair previous = current;
        updateJacobian();
        qrDecomposition();
        qTy(qtf);
        int k = 0;
    L9:
        if (k >= this.solvedCols) goto L12;
        int pk = this.permutation[k];
        int k2 = k;
        this.wjacobian[k2][pk] = this.diagR[pk];
        k = k2 + 1;
        goto L9
    L12:
        if (firstIteration == false) goto L25;
        double xNorm2 = 0.0d;
        int k3 = 0;
    L15:
        if (k3 >= this.cols) goto L20;
        double dk = this.jacNorm[k3];
        if (dk != 0.0d) goto L19;
        dk = 1.0d;
    L19:
        double xk = this.point[k3] * dk;
        xNorm2 = xNorm2 + (xk * xk);
        diag[k3] = dk;
        k3 = k3 + 1;
        goto L15
    L20:
        xNorm = FastMath.sqrt(xNorm2);
        if (xNorm != 0.0d) goto L23;
        double delta3 = this.initialStepBoundFactor;
    L26:
        double maxCosine = 0.0d;
        double delta4 = delta3;
        double delta5 = this.cost;
        if (delta5 == 0.0d) goto L40;
        int j = 0;
        double maxCosine2 = 0.0d;
    L30:
        if (j >= this.solvedCols) goto L39;
        int pj = this.permutation[j];
        double s = this.jacNorm[pj];
        if (s == 0.0d) goto L37;
        double sum = 0.0d;
        int i2 = 0;
    L34:
        if (i2 > j) goto L36;
        sum = sum + (this.wjacobian[i2][pj] * qtf[i2]);
        i2 = i2 + 1;
        j = j;
        goto L34
    L36:
        int j2 = j;
        maxCosine2 = FastMath.max(maxCosine2, FastMath.abs(sum) / (this.cost * s));
    L38:
        diag = diag;
        j = j2 + 1;
        goto L30
    L37:
        j2 = j;
        goto L38
    L39:
        double[] diag2 = diag;
        maxCosine = maxCosine2;
    L42:
        if (maxCosine <= this.orthoTolerance) goto L43;
        int j3 = 0;
    L47:
        if (j3 >= this.cols) goto L49;
        double[] diag3 = diag2;
        int j4 = j3;
        diag3[j4] = FastMath.max(diag2[j3], this.jacNorm[j4]);
        j3 = j4 + 1;
        diag2 = diag3;
        goto L47
    L49:
        double[] oldX2 = diag2;
        double ratio = 0.0d;
        double delta6 = delta4;
    L51:
        if (ratio >= 1.0E-4d) goto L143;
        int j5 = 0;
    L54:
        if (j5 >= this.solvedCols) goto L56;
        int pj2 = this.permutation[j5];
        oldX[pj2] = this.point[pj2];
        j5 = j5 + 1;
        goto L54
    L56:
        double previousCost = this.cost;
        double[] tmpVec = this.residuals;
        this.residuals = oldRes;
        double[] tmpVec2 = this.objective;
        this.objective = oldObj;
        double[] qtf2 = qtf;
        double[] work4 = work3;
        double[] oldRes2 = work2;
        double[] oldX3 = oldX;
        double[] diag4 = oldX2;
        double[] work5 = work1;
        determineLMParameter(qtf2, delta6, diag4, work5, oldRes2, work4);
        double[] qtf3 = qtf2;
        double lmNorm = 0.0d;
        int j6 = 0;
    L57:
        double[] qtf4 = qtf3;
        if (j6 >= this.solvedCols) goto L60;
        int pj3 = this.permutation[j6];
        this.lmDir[pj3] = -this.lmDir[pj3];
        this.point[pj3] = oldX3[pj3] + this.lmDir[pj3];
        double s2 = diag4[pj3] * this.lmDir[pj3];
        lmNorm = lmNorm + (s2 * s2);
        j6 = j6 + 1;
        qtf3 = qtf4;
        work5 = work5;
        goto L57
    L60:
        double[] work6 = work5;
        double lmNorm2 = FastMath.sqrt(lmNorm);
        if (firstIteration == false) goto L63;
        delta6 = FastMath.min(delta6, lmNorm2);
    L63:
        updateResidualsAndCost();
        double actRed = -1.0d;
        double lmNorm3 = this.cost;
        if ((lmNorm3 * 0.1d) >= previousCost) goto L66;
        double r = this.cost / previousCost;
        actRed = 1.0d - (r * r);
    L66:
        int j7 = 0;
    L68:
        if (j7 >= this.solvedCols) goto L73;
        int pj4 = this.permutation[j7];
        double dirJ = this.lmDir[pj4];
        work6[j7] = 0.0d;
        int i3 = 0;
    L70:
        if (i3 > j7) goto L72;
        work6[i3] = work6[i3] + (this.wjacobian[i3][pj4] * dirJ);
        i3 = i3 + 1;
        j7 = j7;
        goto L70
    L72:
        j7 = j7 + 1;
        goto L68
    L73:
        double coeff1 = 0.0d;
        int j8 = 0;
    L74:
        double coeff2 = coeff1;
        if (j8 >= this.solvedCols) goto L77;
        coeff1 = coeff2 + (work6[j8] * work6[j8]);
        j8 = j8 + 1;
        goto L74
    L77:
        double pc2 = previousCost * previousCost;
        double coeff3 = coeff2 / pc2;
        double coeff4 = ((this.lmPar * lmNorm2) * lmNorm2) / pc2;
        double preRed = coeff3 + (coeff4 * 2.0d);
        double dirDer = -(coeff3 + coeff4);
        if (preRed != 0.0d) goto L80;
        double r46 = 0.0d;
    L81:
        ratio = r46;
        double tmp = 0.5d;
        if (ratio > 0.25d) goto L93;
        if (actRed >= 0.0d) goto L87;
        tmp = (dirDer * 0.5d) / (dirDer + (0.5d * actRed));
    L87:
        if ((this.cost * 0.1d) < previousCost) goto L89;
    L90:
        tmp = 0.1d;
    L91:
        double delta7 = FastMath.min(delta6, 10.0d * lmNorm2) * tmp;
        this.lmPar /= tmp;
        delta6 = delta7;
    L98:
        if (ratio < 1.0E-4d) goto L109;
        firstIteration = false;
        double xNorm3 = 0.0d;
        int k4 = 0;
    L100:
        double delta8 = delta6;
        if (k4 >= this.cols) goto L103;
        int k5 = k4;
        double xK = diag4[k4] * this.point[k5];
        xNorm3 = xNorm3 + (xK * xK);
        k4 = k5 + 1;
        delta6 = delta8;
        goto L100
    L103:
        xNorm = FastMath.sqrt(xNorm3);
        current = new VectorialPointValuePair(this.point, this.objective);
        if (this.checker != null) goto L106;
    L108:
        double[] oldObj2 = tmpVec2;
        double[] oldRes3 = tmpVec;
    L115:
        if (this.checker != null) goto L126;
        if (FastMath.abs(actRed) > this.costRelativeTolerance) goto L123;
        if (preRed > this.costRelativeTolerance) goto L123;
        if (ratio > 2.0d) goto L123;
    L124:
        return current;
    L123:
        if (delta8 <= (this.parRelativeTolerance * xNorm)) goto L124;
    L126:
        if (FastMath.abs(actRed) > 2.2204E-16d) goto L135;
        if (preRed > 2.2204E-16d) goto L135;
        if (ratio > 2.0d) goto L135;
        throw new OptimizationException(LocalizedFormats.TOO_SMALL_COST_RELATIVE_TOLERANCE, new Object[]{Double.valueOf(this.costRelativeTolerance)});
    L135:
        if (delta8 <= (xNorm * 2.2204E-16d)) goto L142;
        if (maxCosine <= 2.2204E-16d) goto L140;
        oldRes = oldRes3;
        oldObj = oldObj2;
        oldX = oldX3;
        delta6 = delta8;
        work2 = oldRes2;
        work3 = work4;
        oldX2 = diag4;
        qtf = qtf4;
        work1 = work6;
        goto L51
    L140:
        throw new OptimizationException(LocalizedFormats.TOO_SMALL_ORTHOGONALITY_TOLERANCE, new Object[]{Double.valueOf(this.orthoTolerance)});
    L142:
        throw new OptimizationException(LocalizedFormats.TOO_SMALL_PARAMETERS_RELATIVE_TOLERANCE, new Object[]{Double.valueOf(this.parRelativeTolerance)});
    L106:
        if (this.checker.converged(getIterations(), previous, current) == false) goto L108;
        return current;
    L109:
        delta8 = delta6;
        this.cost = previousCost;
        int j9 = 0;
    L111:
        if (j9 >= this.solvedCols) goto L113;
        int pj5 = this.permutation[j9];
        this.point[pj5] = oldX3[pj5];
        j9 = j9 + 1;
        goto L111
    L113:
        double[] tmpVec3 = this.residuals;
        this.residuals = tmpVec;
        oldRes3 = tmpVec3;
        double[] tmpVec4 = this.objective;
        this.objective = tmpVec2;
        oldObj2 = tmpVec4;
        goto L115
    L89:
        if (tmp >= 0.1d) goto L91;
    L93:
        if (this.lmPar != 0.0d) goto L95;
    L96:
        double delta9 = lmNorm2 * 2.0d;
        this.lmPar *= 0.5d;
        delta6 = delta9;
        goto L98
    L95:
        if (ratio < 0.75d) goto L98;
    L80:
        r46 = actRed / preRed;
        goto L81
    L143:
        double[] diag5 = oldX2;
        delta = delta6;
        xNorm = xNorm;
        diag = diag5;
        goto L3
    L43:
        updateResidualsAndCost();
        VectorialPointValuePair current2 = new VectorialPointValuePair(this.point, this.objective);
        return current2;
    L40:
        diag2 = diag;
        goto L42
    L23:
        delta3 = this.initialStepBoundFactor * xNorm;
        goto L26
    L25:
        delta3 = delta2;
        goto L26
    }

    private void determineLMParameter(double[] qy, double delta, double[] diag, double[] work1, double[] work2, double[] work3) {
        double[] r1 = qy;
        int j = 0;
    L4:
        if (j >= this.rank) goto L6;
        this.lmDir[this.permutation[j]] = r1[j];
        j = j + 1;
        goto L4
    L6:
        int j2 = this.rank;
    L8:
        if (j2 >= this.cols) goto L10;
        this.lmDir[this.permutation[j2]] = 0.0d;
        j2 = j2 + 1;
        goto L8
    L10:
        int j3 = this.rank;
        int k = j3 - 1;
    L11:
        if (k < 0) goto L16;
        int pk = this.permutation[k];
        double ypk = this.lmDir[pk] / this.diagR[pk];
        int i = 0;
    L13:
        if (i >= k) goto L15;
        double[] r14 = this.lmDir;
        int r15 = this.permutation[i];
        r14[r15] = r14[r15] - (this.wjacobian[i][pk] * ypk);
        i = i + 1;
        goto L13
    L15:
        this.lmDir[pk] = ypk;
        k = k - 1;
        goto L11
    L16:
        double dxNorm = 0.0d;
        int j4 = 0;
    L18:
        if (j4 >= this.solvedCols) goto L20;
        int pj = this.permutation[j4];
        double s = diag[pj] * this.lmDir[pj];
        work1[pj] = s;
        dxNorm = dxNorm + (s * s);
        j4 = j4 + 1;
        goto L18
    L20:
        double dxNorm2 = FastMath.sqrt(dxNorm);
        double fp = dxNorm2 - delta;
        if (fp > (delta * 0.1d)) goto L24;
        this.lmPar = 0.0d;
        return;
    L24:
        double parl = 0.0d;
        if (this.rank != this.solvedCols) goto L38;
        int j5 = 0;
    L28:
        if (j5 >= this.solvedCols) goto L30;
        int pj2 = this.permutation[j5];
        work1[pj2] = work1[pj2] * (diag[pj2] / dxNorm2);
        j5 = j5 + 1;
        goto L28
    L30:
        double sum2 = 0.0d;
        int j6 = 0;
    L31:
        double dxNorm3 = dxNorm2;
        if (j6 >= this.solvedCols) goto L37;
        int pj3 = this.permutation[j6];
        double sum = 0.0d;
        int i2 = 0;
    L34:
        if (i2 >= j6) goto L36;
        int pj4 = pj3;
        sum = sum + (this.wjacobian[i2][pj4] * work1[this.permutation[i2]]);
        i2 = i2 + 1;
        pj3 = pj4;
        goto L34
    L36:
        int pj5 = pj3;
        double s2 = (work1[pj5] - sum) / this.diagR[pj5];
        work1[pj5] = s2;
        sum2 = sum2 + (s2 * s2);
        j6 = j6 + 1;
        dxNorm2 = dxNorm3;
        goto L31
    L37:
        parl = fp / (delta * sum2);
    L39:
        double sum3 = 0.0d;
        int j7 = 0;
    L41:
        if (j7 >= this.solvedCols) goto L46;
        int pj6 = this.permutation[j7];
        double sum4 = 0.0d;
        int i3 = 0;
    L43:
        if (i3 > j7) goto L45;
        sum4 = sum4 + (this.wjacobian[i3][pj6] * r1[i3]);
        i3 = i3 + 1;
        sum3 = sum3;
        goto L43
    L45:
        double sum5 = sum3;
        double sum6 = diag[pj6];
        double sum7 = sum4 / sum6;
        sum3 = sum5 + (sum7 * sum7);
        j7 = j7 + 1;
        goto L41
    L46:
        double gNorm = FastMath.sqrt(sum3);
        double paru = gNorm / delta;
        if (paru != 0.0d) goto L49;
        double r26 = 2.2251E-308d;
        paru = 2.2251E-308d / FastMath.min(delta, 0.1d);
    L50:
        this.lmPar = FastMath.min(paru, FastMath.max(this.lmPar, parl));
        if (this.lmPar != 0.0d) goto L53;
        this.lmPar = gNorm / dxNorm3;
    L53:
        int countdown = 10;
    L54:
        if (countdown < 0) goto L102;
        if (this.lmPar != 0.0d) goto L59;
        this.lmPar = FastMath.max(r26, 0.001d * paru);
    L59:
        double sPar = FastMath.sqrt(this.lmPar);
        int j8 = 0;
    L61:
        if (j8 >= this.solvedCols) goto L63;
        int pj7 = this.permutation[j8];
        work1[pj7] = diag[pj7] * sPar;
        j8 = j8 + 1;
        goto L61
    L63:
        determineLMDirection(r1, work1, work2, work3);
        double dxNorm4 = 0.0d;
        int j9 = 0;
    L64:
        double sPar2 = sPar;
        if (j9 >= this.solvedCols) goto L67;
        int pj8 = this.permutation[j9];
        double s3 = diag[pj8] * this.lmDir[pj8];
        work3[pj8] = s3;
        dxNorm4 = dxNorm4 + (s3 * s3);
        j9 = j9 + 1;
        sPar = sPar2;
        goto L64
    L67:
        double dxNorm5 = FastMath.sqrt(dxNorm4);
        double previousFP = fp;
        fp = dxNorm5 - delta;
        if (FastMath.abs(fp) <= (delta * 0.1d)) goto L100;
        if (parl == 0.0d) goto L72;
    L76:
        int j10 = 0;
    L78:
        if (j10 >= this.solvedCols) goto L80;
        int pj9 = this.permutation[j10];
        work1[pj9] = (work3[pj9] * diag[pj9]) / dxNorm5;
        j10 = j10 + 1;
        goto L78
    L80:
        int j11 = 0;
    L82:
        if (j11 >= this.solvedCols) goto L88;
        int pj10 = this.permutation[j11];
        work1[pj10] = work1[pj10] / work2[j11];
        double tmp = work1[pj10];
        int i4 = j11 + 1;
    L84:
        double previousFP2 = previousFP;
        if (i4 >= this.solvedCols) goto L87;
        int r2 = this.permutation[i4];
        work1[r2] = work1[r2] - (this.wjacobian[i4][pj10] * tmp);
        i4 = i4 + 1;
        previousFP = previousFP2;
        goto L84
    L87:
        j11 = j11 + 1;
        previousFP = previousFP2;
        goto L82
    L88:
        int j12 = 0;
        double sum8 = 0.0d;
    L90:
        if (j12 >= this.solvedCols) goto L92;
        double s4 = work1[this.permutation[j12]];
        sum8 = sum8 + (s4 * s4);
        j12 = j12 + 1;
        goto L90
    L92:
        double correction = fp / (delta * sum8);
        if (fp <= 0.0d) goto L96;
        parl = FastMath.max(parl, this.lmPar);
    L98:
        this.lmPar = FastMath.max(parl, this.lmPar + correction);
        countdown = countdown - 1;
        r1 = qy;
        r26 = 2.2251E-308d;
        goto L54
    L96:
        if (fp >= 0.0d) goto L98;
        paru = FastMath.min(paru, this.lmPar);
        goto L98
    L72:
        if (fp > previousFP) goto L76;
        if (previousFP >= 0.0d) goto L76;
        return;
    L100:
        return;
    L102:
        return;
    L49:
        r26 = 2.2251E-308d;
        goto L50
    L38:
        dxNorm3 = dxNorm2;
        goto L39
    }

    private void determineLMDirection(double[] qy, double[] diag, double[] lmDiag, double[] work) {
        int j = 0;
    L4:
        if (j >= this.solvedCols) goto L10;
        int pj = this.permutation[j];
        int i = j + 1;
    L7:
        if (i >= this.solvedCols) goto L9;
        this.wjacobian[i][pj] = this.wjacobian[j][this.permutation[i]];
        i = i + 1;
        goto L7
    L9:
        this.lmDir[j] = this.diagR[pj];
        work[j] = qy[j];
        j = j + 1;
        goto L4
    L10:
        int j2 = 0;
    L11:
        double r4 = 0.0d;
        if (j2 >= this.solvedCols) goto L33;
        int pj2 = this.permutation[j2];
        double dpj = diag[pj2];
        if (dpj == 0.0d) goto L16;
        Arrays.fill(lmDiag, j2 + 1, lmDiag.length, 0.0d);
    L16:
        lmDiag[j2] = dpj;
        double qtbpj = 0.0d;
        int k = j2;
    L18:
        if (k >= this.solvedCols) goto L32;
        int pk = this.permutation[k];
        if (lmDiag[k] == r4) goto L31;
        double rkk = this.wjacobian[k][pk];
        if (FastMath.abs(rkk) >= FastMath.abs(lmDiag[k])) goto L24;
        double cotan = rkk / lmDiag[k];
        double sin = 1.0d / FastMath.sqrt((cotan * cotan) + 1.0d);
        double cotan2 = cotan * sin;
        double cos = sin;
    L25:
        this.wjacobian[k][pk] = (cotan2 * rkk) + (lmDiag[k] * cos);
        double temp = (work[k] * cotan2) + (cos * qtbpj);
        double qtbpj2 = ((-cos) * work[k]) + (cotan2 * qtbpj);
        work[k] = temp;
        int i2 = k + 1;
    L27:
        if (i2 >= this.solvedCols) goto L29;
        double rik = this.wjacobian[i2][pk];
        double temp2 = (cotan2 * rik) + (lmDiag[i2] * cos);
        double qtbpj3 = qtbpj2;
        double qtbpj4 = -cos;
        lmDiag[i2] = (qtbpj4 * rik) + (lmDiag[i2] * cotan2);
        this.wjacobian[i2][pk] = temp2;
        i2 = i2 + 1;
        qtbpj2 = qtbpj3;
        goto L27
    L29:
        qtbpj = qtbpj2;
        goto L31
    L24:
        double tan = lmDiag[k] / rkk;
        double cos2 = 1.0d / FastMath.sqrt((tan * tan) + 1.0d);
        double r19 = cos2 * tan;
        cotan2 = cos2;
        cos = r19;
    L31:
        k = k + 1;
        lmDiag = lmDiag;
        j2 = j2;
        r4 = r4;
        goto L18
    L32:
        int j3 = j2;
        lmDiag[j3] = this.wjacobian[j3][this.permutation[j3]];
        this.wjacobian[j3][this.permutation[j3]] = this.lmDir[j3];
        j2 = j3 + 1;
        goto L11
    L33:
        int nSing = this.solvedCols;
        int j4 = 0;
    L35:
        if (j4 >= this.solvedCols) goto L46;
        if (lmDiag[j4] != 0.0d) goto L42;
        if (nSing != this.solvedCols) goto L42;
        nSing = j4;
    L42:
        if (nSing >= this.solvedCols) goto L44;
        work[j4] = 0.0d;
    L44:
        j4 = j4 + 1;
        goto L35
    L46:
        if (nSing <= 0) goto L53;
        int j5 = nSing - 1;
    L48:
        if (j5 < 0) goto L53;
        int pj3 = this.permutation[j5];
        double sum = 0.0d;
        int i3 = j5 + 1;
    L50:
        if (i3 >= nSing) goto L52;
        sum = sum + (this.wjacobian[i3][pj3] * work[i3]);
        i3 = i3 + 1;
        goto L50
    L52:
        work[j5] = (work[j5] - sum) / lmDiag[j5];
        j5 = j5 - 1;
    L53:
        int j6 = 0;
    L55:
        if (j6 >= this.lmDir.length) goto L58;
        this.lmDir[this.permutation[j6]] = work[j6];
        j6 = j6 + 1;
        goto L55
    }

    private void qrDecomposition() throws OptimizationException {
        int k = 0;
    L4:
        if (k >= this.cols) goto L10;
        this.permutation[k] = k;
        double norm2 = 0.0d;
        int i = 0;
    L7:
        if (i >= this.wjacobian.length) goto L9;
        double akk = this.wjacobian[i][k];
        norm2 = norm2 + (akk * akk);
        i = i + 1;
        goto L7
    L9:
        this.jacNorm[k] = FastMath.sqrt(norm2);
        k = k + 1;
        goto L4
    L10:
        int k2 = 0;
    L12:
        if (k2 >= this.cols) goto L50;
        int nextColumn = -1;
        double ak2 = Double.NEGATIVE_INFINITY;
        int i2 = k2;
    L15:
        if (i2 >= this.cols) goto L31;
        double norm3 = 0.0d;
        int j = k2;
    L18:
        if (j >= this.wjacobian.length) goto L21;
        double aki = this.wjacobian[j][this.permutation[i2]];
        norm3 = norm3 + (aki * aki);
        j = j + 1;
        goto L18
    L21:
        if (Double.isInfinite(norm3) == true) goto L29;
        if (Double.isNaN(norm3) == true) goto L29;
        if (norm3 <= ak2) goto L27;
        nextColumn = i2;
        ak2 = norm3;
    L27:
        i2 = i2 + 1;
    L29:
        throw new OptimizationException(LocalizedFormats.UNABLE_TO_PERFORM_QR_DECOMPOSITION_ON_JACOBIAN, new Object[]{Integer.valueOf(this.rows), Integer.valueOf(this.cols)});
    L31:
        if (ak2 <= this.qrRankingThreshold) goto L32;
        int pk = this.permutation[nextColumn];
        this.permutation[nextColumn] = this.permutation[k2];
        this.permutation[k2] = pk;
        double akk2 = this.wjacobian[k2][pk];
        if (akk2 <= 0.0d) goto L37;
        double alpha = -FastMath.sqrt(ak2);
    L38:
        double betak = 1.0d / (ak2 - (akk2 * alpha));
        this.beta[pk] = betak;
        this.diagR[pk] = alpha;
        double[] r10 = this.wjacobian[k2];
        r10[pk] = r10[pk] - alpha;
        int dk = (this.cols - 1) - k2;
    L39:
        if (dk <= 0) goto L49;
        double gamma = 0.0d;
        int j2 = k2;
    L41:
        int k3 = k2;
        if (j2 >= this.wjacobian.length) goto L44;
        gamma = gamma + (this.wjacobian[j2][pk] * this.wjacobian[j2][this.permutation[k3 + dk]]);
        j2 = j2 + 1;
        k2 = k3;
        goto L41
    L44:
        double gamma2 = gamma * betak;
        int j3 = k3;
    L46:
        if (j3 >= this.wjacobian.length) goto L48;
        double[] r11 = this.wjacobian[j3];
        int j4 = j3;
        int r1 = this.permutation[k3 + dk];
        r11[r1] = r11[r1] - (this.wjacobian[j4][pk] * gamma2);
        j3 = j4 + 1;
        goto L46
    L48:
        dk = dk - 1;
        k2 = k3;
        goto L39
    L49:
        k2 = k2 + 1;
        goto L12
    L37:
        alpha = FastMath.sqrt(ak2);
        goto L38
    L32:
        this.rank = k2;
        return;
    L50:
        int k4 = this.solvedCols;
        this.rank = k4;
    }

    private void qTy(double[] y) {
        int k = 0;
    L4:
        if (k >= this.cols) goto L15;
        int pk = this.permutation[k];
        double gamma = 0.0d;
        int i = k;
    L7:
        if (i >= this.rows) goto L9;
        gamma = gamma + (this.wjacobian[i][pk] * y[i]);
        i = i + 1;
        goto L7
    L9:
        double gamma2 = gamma * this.beta[pk];
        int i2 = k;
    L11:
        if (i2 >= this.rows) goto L13;
        y[i2] = y[i2] - (this.wjacobian[i2][pk] * gamma2);
        i2 = i2 + 1;
        goto L11
    L13:
        k = k + 1;
        goto L4
    }
}

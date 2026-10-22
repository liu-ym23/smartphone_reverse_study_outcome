package org.apache.commons.math.estimation;

import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class LevenbergMarquardtEstimator extends AbstractEstimator implements Serializable {
    private static final long serialVersionUID = -5705952631533171019L;
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
    private int rank;
    private int solvedCols;

    public LevenbergMarquardtEstimator() {
        setMaxCostEval(1000);
        setInitialStepBoundFactor(100.0d);
        setCostRelativeTolerance(1.0E-10d);
        setParRelativeTolerance(1.0E-10d);
        setOrthoTolerance(1.0E-10d);
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

    @Override // org.apache.commons.math.estimation.AbstractEstimator, org.apache.commons.math.estimation.Estimator
    public void estimate(EstimationProblem problem) throws EstimationException {
        initializeEstimate(problem);
        this.solvedCols = FastMath.min(this.rows, this.cols);
        this.diagR = new double[this.cols];
        this.jacNorm = new double[this.cols];
        this.beta = new double[this.cols];
        this.permutation = new int[this.cols];
        this.lmDir = new double[this.cols];
        double delta = 0.0d;
        double xNorm = 0.0d;
        double[] diag = new double[this.cols];
        double[] oldX = new double[this.cols];
        double[] oldRes = new double[this.rows];
        double[] work3 = new double[this.cols];
        double[] work2 = new double[this.cols];
        double[] work4 = new double[this.cols];
        updateResidualsAndCost();
        double r11 = 0.0d;
        this.lmPar = 0.0d;
        boolean firstIteration = true;
    L3:
        updateJacobian();
        qrDecomposition();
        qTy(this.residuals);
        int k = 0;
    L5:
        if (k >= this.solvedCols) goto L7;
        int pk = this.permutation[k];
        this.jacobian[(this.cols * k) + pk] = this.diagR[pk];
        k = k + 1;
        r11 = r11;
        delta = delta;
        goto L5
    L7:
        double delta2 = delta;
        double r16 = r11;
        if (firstIteration == false) goto L21;
        double xNorm2 = 0.0d;
        int k2 = 0;
    L11:
        if (k2 >= this.cols) goto L16;
        double dk = this.jacNorm[k2];
        if (dk != r16) goto L15;
        dk = 1.0d;
    L15:
        double xk = this.parameters[k2].getEstimate() * dk;
        xNorm2 = xNorm2 + (xk * xk);
        diag[k2] = dk;
        k2 = k2 + 1;
        goto L11
    L16:
        xNorm = FastMath.sqrt(xNorm2);
        if (xNorm != r16) goto L19;
        double delta3 = this.initialStepBoundFactor;
    L22:
        double maxCosine = 0.0d;
        if (this.cost == r16) goto L36;
        int j = 0;
    L26:
        if (j >= this.solvedCols) goto L35;
        int pj = this.permutation[j];
        double delta4 = delta3;
        double s = this.jacNorm[pj];
        if (s == r16) goto L34;
        double sum = 0.0d;
        int index = pj;
        int i = 0;
    L30:
        if (i > j) goto L32;
        sum = sum + (this.jacobian[index] * this.residuals[i]);
        index = index + this.cols;
        i = i + 1;
        goto L30
    L32:
        maxCosine = FastMath.max(maxCosine, FastMath.abs(sum) / (this.cost * s));
    L34:
        j = j + 1;
        delta3 = delta4;
        goto L26
    L35:
        double delta5 = delta3;
    L37:
        double delta6 = this.orthoTolerance;
        if (maxCosine <= delta6) goto L39;
        int j2 = 0;
    L42:
        if (j2 >= this.cols) goto L44;
        int j3 = j2;
        diag[j3] = FastMath.max(diag[j2], this.jacNorm[j3]);
        j2 = j3 + 1;
        goto L42
    L44:
        boolean firstIteration2 = firstIteration;
        double ratio = 0.0d;
        double r47 = delta5;
        double xNorm3 = xNorm;
        double delta7 = r47;
    L46:
        if (ratio >= 1.0E-4d) goto L131;
        int j4 = 0;
    L49:
        if (j4 >= this.solvedCols) goto L51;
        int pj2 = this.permutation[j4];
        oldX[pj2] = this.parameters[pj2].getEstimate();
        j4 = j4 + 1;
        goto L49
    L51:
        double[] oldX2 = oldX;
        double previousCost = this.cost;
        double[] tmpVec = this.residuals;
        this.residuals = oldRes;
        double[] work5 = work2;
        double[] work6 = work4;
        double[] tmpVec2 = diag;
        double[] work1 = work3;
        determineLMParameter(tmpVec, delta7, tmpVec2, work1, work5, work6);
        double lmNorm = 0.0d;
        int j5 = 0;
    L52:
        double[] work7 = work1;
        if (j5 >= this.solvedCols) goto L55;
        int pj3 = this.permutation[j5];
        int j6 = j5;
        this.lmDir[pj3] = -this.lmDir[pj3];
        this.parameters[pj3].setEstimate(oldX2[pj3] + this.lmDir[pj3]);
        double s2 = tmpVec2[pj3] * this.lmDir[pj3];
        lmNorm = lmNorm + (s2 * s2);
        j5 = j6 + 1;
        work1 = work7;
        work5 = work5;
        goto L52
    L55:
        double[] work8 = work5;
        double lmNorm2 = FastMath.sqrt(lmNorm);
        if (firstIteration2 == false) goto L58;
        delta7 = FastMath.min(delta7, lmNorm2);
    L58:
        updateResidualsAndCost();
        double actRed = -1.0d;
        double lmNorm3 = this.cost;
        if ((lmNorm3 * 0.1d) >= previousCost) goto L61;
        double r = this.cost / previousCost;
        actRed = 1.0d - (r * r);
    L61:
        int j7 = 0;
    L63:
        if (j7 >= this.solvedCols) goto L68;
        int pj4 = this.permutation[j7];
        double dirJ = this.lmDir[pj4];
        work7[j7] = r16;
        int index2 = pj4;
        int pj5 = 0;
    L65:
        if (pj5 > j7) goto L67;
        work7[pj5] = work7[pj5] + (this.jacobian[index2] * dirJ);
        index2 = index2 + this.cols;
        pj5 = pj5 + 1;
        j7 = j7;
        goto L65
    L67:
        j7 = j7 + 1;
        goto L63
    L68:
        double coeff1 = 0.0d;
        int j8 = 0;
    L69:
        double coeff2 = coeff1;
        if (j8 >= this.solvedCols) goto L72;
        coeff1 = coeff2 + (work7[j8] * work7[j8]);
        j8 = j8 + 1;
        goto L69
    L72:
        double pc2 = previousCost * previousCost;
        double coeff3 = coeff2 / pc2;
        double coeff4 = ((this.lmPar * lmNorm2) * lmNorm2) / pc2;
        double preRed = coeff3 + (coeff4 * 2.0d);
        double dirDer = -(coeff3 + coeff4);
        if (preRed != r16) goto L75;
        double r43 = r16;
    L76:
        ratio = r43;
        double tmp = 0.5d;
        if (ratio > 0.25d) goto L88;
        if (actRed >= r16) goto L82;
        tmp = (dirDer * 0.5d) / (dirDer + (0.5d * actRed));
    L82:
        if ((this.cost * 0.1d) < previousCost) goto L84;
    L85:
        tmp = 0.1d;
    L86:
        double delta8 = FastMath.min(delta7, 10.0d * lmNorm2) * tmp;
        double delta9 = this.lmPar;
        this.lmPar = delta9 / tmp;
        delta7 = delta8;
    L93:
        if (ratio < 1.0E-4d) goto L99;
        firstIteration2 = false;
        double xNorm4 = 0.0d;
        int k3 = 0;
    L95:
        double delta10 = delta7;
        if (k3 >= this.cols) goto L98;
        double xK = this.parameters[k3].getEstimate() * tmpVec2[k3];
        xNorm4 = xNorm4 + (xK * xK);
        k3 = k3 + 1;
        delta7 = delta10;
        goto L95
    L98:
        xNorm3 = FastMath.sqrt(xNorm4);
        oldRes = tmpVec;
    L105:
        if (FastMath.abs(actRed) > this.costRelativeTolerance) goto L111;
        if (preRed > this.costRelativeTolerance) goto L111;
        if (ratio > 2.0d) goto L111;
        return;
    L111:
        if (delta10 <= (this.parRelativeTolerance * xNorm3)) goto L155;
        if (FastMath.abs(actRed) > 2.2204E-16d) goto L123;
        if (preRed > 2.2204E-16d) goto L123;
        if (ratio > 2.0d) goto L123;
        throw new EstimationException("cost relative tolerance is too small ({0}), no further reduction in the sum of squares is possible", new Object[]{Double.valueOf(this.costRelativeTolerance)});
    L123:
        if (delta10 <= (xNorm3 * 2.2204E-16d)) goto L130;
        if (maxCosine <= 2.2204E-16d) goto L128;
        work4 = work6;
        delta7 = delta10;
        oldX = oldX2;
        diag = tmpVec2;
        work3 = work7;
        work2 = work8;
        goto L46
    L128:
        throw new EstimationException("orthogonality tolerance is too small ({0}), solution is orthogonal to the jacobian", new Object[]{Double.valueOf(this.orthoTolerance)});
    L130:
        throw new EstimationException("parameters relative tolerance is too small ({0}), no further improvement in the approximate solution is possible", new Object[]{Double.valueOf(this.parRelativeTolerance)});
    L155:
        return;
    L99:
        delta10 = delta7;
        this.cost = previousCost;
        int j9 = 0;
    L101:
        if (j9 >= this.solvedCols) goto L103;
        int pj6 = this.permutation[j9];
        this.parameters[pj6].setEstimate(oldX2[pj6]);
        j9 = j9 + 1;
        goto L101
    L103:
        double[] tmpVec3 = this.residuals;
        this.residuals = tmpVec;
        oldRes = tmpVec3;
        goto L105
    L84:
        if (tmp >= 0.1d) goto L86;
    L88:
        if (this.lmPar != r16) goto L90;
    L91:
        double delta11 = lmNorm2 * 2.0d;
        double delta12 = this.lmPar;
        this.lmPar = delta12 * 0.5d;
        delta7 = delta11;
        goto L93
    L90:
        if (ratio < 0.75d) goto L93;
    L75:
        r43 = actRed / preRed;
        goto L76
    L131:
        delta = delta7;
        firstIteration = firstIteration2;
        r11 = r16;
        xNorm = xNorm3;
        work3 = work3;
        goto L3
    L39:
        return;
    L36:
        delta5 = delta3;
        goto L37
    L19:
        delta3 = this.initialStepBoundFactor * xNorm;
        goto L22
    L21:
        delta3 = delta2;
        goto L22
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
        int index = pk;
        int i = 0;
    L13:
        if (i >= k) goto L15;
        double[] r15 = this.lmDir;
        int r9 = this.permutation[i];
        r15[r9] = r15[r9] - (this.jacobian[index] * ypk);
        index = index + this.cols;
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
        int index2 = pj3;
        int pj4 = 0;
    L34:
        if (pj4 >= j6) goto L36;
        int i2 = pj4;
        sum = sum + (this.jacobian[index2] * work1[this.permutation[i2]]);
        index2 = index2 + this.cols;
        pj4 = i2 + 1;
        goto L34
    L36:
        double s2 = (work1[pj3] - sum) / this.diagR[pj3];
        work1[pj3] = s2;
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
        int pj5 = this.permutation[j7];
        double sum4 = 0.0d;
        int index3 = pj5;
        double sum5 = sum3;
        int i3 = 0;
    L43:
        if (i3 > j7) goto L45;
        sum4 = sum4 + (this.jacobian[index3] * r1[i3]);
        index3 = index3 + this.cols;
        i3 = i3 + 1;
        goto L43
    L45:
        double sum6 = sum4 / diag[pj5];
        sum3 = sum5 + (sum6 * sum6);
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
        int pj6 = this.permutation[j8];
        work1[pj6] = diag[pj6] * sPar;
        j8 = j8 + 1;
        goto L61
    L63:
        determineLMDirection(r1, work1, work2, work3);
        double dxNorm4 = 0.0d;
        int j9 = 0;
    L64:
        double sPar2 = sPar;
        if (j9 >= this.solvedCols) goto L67;
        int pj7 = this.permutation[j9];
        double s3 = diag[pj7] * this.lmDir[pj7];
        work3[pj7] = s3;
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
        int pj8 = this.permutation[j10];
        work1[pj8] = (work3[pj8] * diag[pj8]) / dxNorm5;
        j10 = j10 + 1;
        goto L78
    L80:
        int j11 = 0;
    L82:
        if (j11 >= this.solvedCols) goto L88;
        int pj9 = this.permutation[j11];
        work1[pj9] = work1[pj9] / work2[j11];
        double tmp = work1[pj9];
        int i4 = j11 + 1;
    L84:
        double previousFP2 = previousFP;
        if (i4 >= this.solvedCols) goto L87;
        int r2 = this.permutation[i4];
        work1[r2] = work1[r2] - (this.jacobian[(this.cols * i4) + pj9] * tmp);
        i4 = i4 + 1;
        previousFP = previousFP2;
        goto L84
    L87:
        j11 = j11 + 1;
        previousFP = previousFP2;
        goto L82
    L88:
        int j12 = 0;
        double sum7 = 0.0d;
    L90:
        if (j12 >= this.solvedCols) goto L92;
        double s4 = work1[this.permutation[j12]];
        sum7 = sum7 + (s4 * s4);
        j12 = j12 + 1;
        goto L90
    L92:
        double correction = fp / (delta * sum7);
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
        this.jacobian[(this.cols * i) + pj] = this.jacobian[(this.cols * j) + this.permutation[i]];
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
        double rkk = this.jacobian[(this.cols * k) + pk];
        if (FastMath.abs(rkk) >= FastMath.abs(lmDiag[k])) goto L24;
        double cotan = rkk / lmDiag[k];
        double sin = 1.0d / FastMath.sqrt((cotan * cotan) + 1.0d);
        double cotan2 = cotan * sin;
        double cos = sin;
    L25:
        this.jacobian[(this.cols * k) + pk] = (cotan2 * rkk) + (lmDiag[k] * cos);
        double temp = (work[k] * cotan2) + (cos * qtbpj);
        double qtbpj2 = ((-cos) * work[k]) + (cotan2 * qtbpj);
        work[k] = temp;
        int i2 = k + 1;
    L27:
        if (i2 >= this.solvedCols) goto L29;
        double qtbpj3 = qtbpj2;
        double rik = this.jacobian[(this.cols * i2) + pk];
        double temp2 = (cotan2 * rik) + (lmDiag[i2] * cos);
        lmDiag[i2] = ((-cos) * rik) + (lmDiag[i2] * cotan2);
        this.jacobian[(this.cols * i2) + pk] = temp2;
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
        int index = (j3 * this.cols) + this.permutation[j3];
        lmDiag[j3] = this.jacobian[index];
        this.jacobian[index] = this.lmDir[j3];
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
        sum = sum + (this.jacobian[(this.cols * i3) + pj3] * work[i3]);
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

    private void qrDecomposition() throws EstimationException {
        int k = 0;
    L4:
        if (k >= this.cols) goto L10;
        this.permutation[k] = k;
        double norm2 = 0.0d;
        int index = k;
    L7:
        if (index >= this.jacobian.length) goto L9;
        double akk = this.jacobian[index];
        norm2 = norm2 + (akk * akk);
        index = index + this.cols;
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
        int i = k2;
    L15:
        if (i >= this.cols) goto L31;
        double norm3 = 0.0d;
        int iDiag = (this.cols * k2) + this.permutation[i];
        int index2 = iDiag;
    L18:
        if (index2 >= this.jacobian.length) goto L21;
        double aki = this.jacobian[index2];
        norm3 = norm3 + (aki * aki);
        index2 = index2 + this.cols;
        goto L18
    L21:
        if (Double.isInfinite(norm3) == true) goto L29;
        if (Double.isNaN(norm3) == true) goto L29;
        if (norm3 <= ak2) goto L27;
        nextColumn = i;
        ak2 = norm3;
    L27:
        i = i + 1;
    L29:
        throw new EstimationException(LocalizedFormats.UNABLE_TO_PERFORM_QR_DECOMPOSITION_ON_JACOBIAN, new Object[]{Integer.valueOf(this.rows), Integer.valueOf(this.cols)});
    L31:
        if (ak2 == 0.0d) goto L32;
        int pk = this.permutation[nextColumn];
        this.permutation[nextColumn] = this.permutation[k2];
        this.permutation[k2] = pk;
        int kDiag = (this.cols * k2) + pk;
        double akk2 = this.jacobian[kDiag];
        if (akk2 <= 0.0d) goto L37;
        double alpha = -FastMath.sqrt(ak2);
    L38:
        double betak = 1.0d / (ak2 - (akk2 * alpha));
        this.beta[pk] = betak;
        this.diagR[pk] = alpha;
        double[] r11 = this.jacobian;
        r11[kDiag] = r11[kDiag] - alpha;
        int dk = (this.cols - 1) - k2;
    L39:
        if (dk <= 0) goto L49;
        int dkp = this.permutation[k2 + dk] - pk;
        double gamma = 0.0d;
        int k3 = k2;
        int k4 = kDiag;
    L41:
        int nextColumn2 = nextColumn;
        if (k4 >= this.jacobian.length) goto L44;
        gamma = gamma + (this.jacobian[k4] * this.jacobian[k4 + dkp]);
        k4 = k4 + this.cols;
        nextColumn = nextColumn2;
        goto L41
    L44:
        double gamma2 = gamma * betak;
        int index3 = kDiag;
    L46:
        if (index3 >= this.jacobian.length) goto L48;
        double[] r2 = this.jacobian;
        int r19 = index3 + dkp;
        int index4 = index3;
        r2[r19] = r2[r19] - (this.jacobian[index4] * gamma2);
        index3 = index4 + this.cols;
        goto L46
    L48:
        dk = dk - 1;
        k2 = k3;
        nextColumn = nextColumn2;
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
        int k5 = this.solvedCols;
        this.rank = k5;
    }

    private void qTy(double[] y) {
        int k = 0;
    L4:
        if (k >= this.cols) goto L15;
        int pk = this.permutation[k];
        int kDiag = (this.cols * k) + pk;
        double gamma = 0.0d;
        int index = kDiag;
        int i = k;
    L7:
        if (i >= this.rows) goto L9;
        gamma = gamma + (this.jacobian[index] * y[i]);
        index = index + this.cols;
        i = i + 1;
        goto L7
    L9:
        double gamma2 = gamma * this.beta[pk];
        int index2 = kDiag;
        int i2 = k;
    L11:
        if (i2 >= this.rows) goto L13;
        y[i2] = y[i2] - (this.jacobian[index2] * gamma2);
        index2 = index2 + this.cols;
        i2 = i2 + 1;
        goto L11
    L13:
        k = k + 1;
        goto L4
    }
}

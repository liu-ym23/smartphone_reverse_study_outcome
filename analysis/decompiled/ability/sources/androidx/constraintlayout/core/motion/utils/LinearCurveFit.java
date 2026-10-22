package androidx.constraintlayout.core.motion.utils;

/* loaded from: classes2.dex */
public class LinearCurveFit extends CurveFit {
    private static final String TAG = "LinearCurveFit";
    private boolean mExtrapolate = true;
    double[] mSlopeTemp;
    private double[] mT;
    private double mTotalLength;
    private double[][] mY;

    public LinearCurveFit(double[] dArr, double[][] dArr2) {
        this.mTotalLength = Double.NaN;
        int length = dArr2[0].length;
        this.mSlopeTemp = new double[length];
        this.mT = dArr;
        this.mY = dArr2;
        if (length <= 2) {
            return;
        }
        int i = 0;
        double d = 0.0d;
        while (true) {
            double d6 = d;
            if (i >= dArr.length) {
                this.mTotalLength = 0.0d;
                return;
            }
            double d10 = dArr2[i][0];
            if (i > 0) {
                Math.hypot(d10 - d, d10 - d6);
            }
            i++;
            d = d10;
        }
    }

    private double getLength2D(double d) {
        if (Double.isNaN(this.mTotalLength)) {
            return 0.0d;
        }
        double[] dArr = this.mT;
        int length = dArr.length;
        if (d <= dArr[0]) {
            return 0.0d;
        }
        int i = length - 1;
        if (d >= dArr[i]) {
            return this.mTotalLength;
        }
        double dHypot = 0.0d;
        double d6 = 0.0d;
        double d10 = 0.0d;
        int i6 = 0;
        while (i6 < i) {
            double[] dArr2 = this.mY[i6];
            double d11 = dArr2[0];
            double d12 = dArr2[1];
            if (i6 > 0) {
                dHypot += Math.hypot(d11 - d6, d12 - d10);
            }
            double[] dArr3 = this.mT;
            double d13 = dArr3[i6];
            if (d == d13) {
                return dHypot;
            }
            int i10 = i6 + 1;
            double d14 = dArr3[i10];
            if (d < d14) {
                double d15 = (d - d13) / (d14 - d13);
                double[][] dArr4 = this.mY;
                double[] dArr5 = dArr4[i6];
                double d16 = dArr5[0];
                double[] dArr6 = dArr4[i10];
                double d17 = dArr6[0];
                double d18 = 1.0d - d15;
                return Math.hypot(d12 - ((dArr6[1] * d15) + (dArr5[1] * d18)), d11 - ((d17 * d15) + (d16 * d18))) + dHypot;
            }
            i6 = i10;
            d6 = d11;
            d10 = d12;
        }
        return 0.0d;
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double d, double[] dArr) {
        double[] dArr2 = this.mT;
        int length = dArr2.length;
        int i = 0;
        int length2 = this.mY[0].length;
        if (this.mExtrapolate) {
            double d6 = dArr2[0];
            if (d <= d6) {
                getSlope(d6, this.mSlopeTemp);
                for (int i6 = 0; i6 < length2; i6++) {
                    dArr[i6] = ((d - this.mT[0]) * this.mSlopeTemp[i6]) + this.mY[0][i6];
                }
                return;
            }
            int i10 = length - 1;
            double d10 = dArr2[i10];
            if (d >= d10) {
                getSlope(d10, this.mSlopeTemp);
                while (i < length2) {
                    dArr[i] = ((d - this.mT[i10]) * this.mSlopeTemp[i]) + this.mY[i10][i];
                    i++;
                }
                return;
            }
        } else {
            if (d <= dArr2[0]) {
                for (int i11 = 0; i11 < length2; i11++) {
                    dArr[i11] = this.mY[0][i11];
                }
                return;
            }
            int i12 = length - 1;
            if (d >= dArr2[i12]) {
                while (i < length2) {
                    dArr[i] = this.mY[i12][i];
                    i++;
                }
                return;
            }
        }
        int i13 = 0;
        while (i13 < length - 1) {
            if (d == this.mT[i13]) {
                for (int i14 = 0; i14 < length2; i14++) {
                    dArr[i14] = this.mY[i13][i14];
                }
            }
            double[] dArr3 = this.mT;
            int i15 = i13 + 1;
            double d11 = dArr3[i15];
            if (d < d11) {
                double d12 = dArr3[i13];
                double d13 = (d - d12) / (d11 - d12);
                while (i < length2) {
                    double[][] dArr4 = this.mY;
                    dArr[i] = (dArr4[i15][i] * d13) + ((1.0d - d13) * dArr4[i13][i]);
                    i++;
                }
                return;
            }
            i13 = i15;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x000f A[PHI: r4
      0x000f: PHI (r4v5 double) = (r4v0 double), (r4v2 double) binds: [B:3:0x000d, B:6:0x0017] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void getSlope(double r11, double[] r13) {
        /*
            r10 = this;
            double[] r0 = r10.mT
            int r1 = r0.length
            double[][] r2 = r10.mY
            r3 = 0
            r2 = r2[r3]
            int r2 = r2.length
            r4 = r0[r3]
            int r6 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r6 > 0) goto L11
        Lf:
            r11 = r4
            goto L1a
        L11:
            int r4 = r1 + (-1)
            r4 = r0[r4]
            int r0 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r0 < 0) goto L1a
            goto Lf
        L1a:
            r0 = r3
        L1b:
            int r4 = r1 + (-1)
            if (r0 >= r4) goto L41
            double[] r4 = r10.mT
            int r5 = r0 + 1
            r6 = r4[r5]
            int r8 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
            if (r8 > 0) goto L3f
            r11 = r4[r0]
            double r6 = r6 - r11
        L2c:
            if (r3 >= r2) goto L41
            double[][] r11 = r10.mY
            r12 = r11[r0]
            r8 = r12[r3]
            r11 = r11[r5]
            r11 = r11[r3]
            double r11 = r11 - r8
            double r11 = r11 / r6
            r13[r3] = r11
            int r3 = r3 + 1
            goto L2c
        L3f:
            r0 = r5
            goto L1b
        L41:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.utils.LinearCurveFit.getSlope(double, double[]):void");
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.mT;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x000a A[PHI: r3
      0x000a: PHI (r3v4 double) = (r3v0 double), (r3v2 double) binds: [B:3:0x0008, B:6:0x0012] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public double getSlope(double r8, int r10) {
        /*
            r7 = this;
            double[] r0 = r7.mT
            int r1 = r0.length
            r2 = 0
            r3 = r0[r2]
            int r5 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r5 >= 0) goto Lc
        La:
            r8 = r3
            goto L15
        Lc:
            int r3 = r1 + (-1)
            r3 = r0[r3]
            int r0 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r0 < 0) goto L15
            goto La
        L15:
            int r0 = r1 + (-1)
            if (r2 >= r0) goto L35
            double[] r0 = r7.mT
            int r3 = r2 + 1
            r4 = r0[r3]
            int r6 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r6 > 0) goto L33
            r8 = r0[r2]
            double r4 = r4 - r8
            double[][] r7 = r7.mY
            r8 = r7[r2]
            r8 = r8[r10]
            r7 = r7[r3]
            r0 = r7[r10]
            double r0 = r0 - r8
            double r0 = r0 / r4
            return r0
        L33:
            r2 = r3
            goto L15
        L35:
            r7 = 0
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.utils.LinearCurveFit.getSlope(double, int):double");
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double d, float[] fArr) {
        double[] dArr = this.mT;
        int length = dArr.length;
        int i = 0;
        int length2 = this.mY[0].length;
        if (this.mExtrapolate) {
            double d6 = dArr[0];
            if (d <= d6) {
                getSlope(d6, this.mSlopeTemp);
                for (int i6 = 0; i6 < length2; i6++) {
                    fArr[i6] = (float) (((d - this.mT[0]) * this.mSlopeTemp[i6]) + this.mY[0][i6]);
                }
                return;
            }
            int i10 = length - 1;
            double d10 = dArr[i10];
            if (d >= d10) {
                getSlope(d10, this.mSlopeTemp);
                while (i < length2) {
                    fArr[i] = (float) (((d - this.mT[i10]) * this.mSlopeTemp[i]) + this.mY[i10][i]);
                    i++;
                }
                return;
            }
        } else {
            if (d <= dArr[0]) {
                for (int i11 = 0; i11 < length2; i11++) {
                    fArr[i11] = (float) this.mY[0][i11];
                }
                return;
            }
            int i12 = length - 1;
            if (d >= dArr[i12]) {
                while (i < length2) {
                    fArr[i] = (float) this.mY[i12][i];
                    i++;
                }
                return;
            }
        }
        int i13 = 0;
        while (i13 < length - 1) {
            if (d == this.mT[i13]) {
                for (int i14 = 0; i14 < length2; i14++) {
                    fArr[i14] = (float) this.mY[i13][i14];
                }
            }
            double[] dArr2 = this.mT;
            int i15 = i13 + 1;
            double d11 = dArr2[i15];
            if (d < d11) {
                double d12 = dArr2[i13];
                double d13 = (d - d12) / (d11 - d12);
                while (i < length2) {
                    double[][] dArr3 = this.mY;
                    fArr[i] = (float) ((dArr3[i15][i] * d13) + ((1.0d - d13) * dArr3[i13][i]));
                    i++;
                }
                return;
            }
            i13 = i15;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getPos(double d, int i) {
        double[] dArr = this.mT;
        int length = dArr.length;
        int i6 = 0;
        if (this.mExtrapolate) {
            double d6 = dArr[0];
            if (d <= d6) {
                return (getSlope(d6, i) * (d - d6)) + this.mY[0][i];
            }
            int i10 = length - 1;
            double d10 = dArr[i10];
            if (d >= d10) {
                return (getSlope(d10, i) * (d - d10)) + this.mY[i10][i];
            }
        } else {
            if (d <= dArr[0]) {
                return this.mY[0][i];
            }
            int i11 = length - 1;
            if (d >= dArr[i11]) {
                return this.mY[i11][i];
            }
        }
        while (i6 < length - 1) {
            double[] dArr2 = this.mT;
            double d11 = dArr2[i6];
            if (d == d11) {
                return this.mY[i6][i];
            }
            int i12 = i6 + 1;
            double d12 = dArr2[i12];
            if (d < d12) {
                double d13 = (d - d11) / (d12 - d11);
                double[][] dArr3 = this.mY;
                return (dArr3[i12][i] * d13) + ((1.0d - d13) * dArr3[i6][i]);
            }
            i6 = i12;
        }
        return 0.0d;
    }
}

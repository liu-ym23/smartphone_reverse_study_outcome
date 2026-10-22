package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

/* loaded from: classes2.dex */
public class ArcCurveFit extends CurveFit {
    public static final int ARC_ABOVE = 5;
    public static final int ARC_BELOW = 4;
    public static final int ARC_START_FLIP = 3;
    public static final int ARC_START_HORIZONTAL = 2;
    public static final int ARC_START_LINEAR = 0;
    public static final int ARC_START_VERTICAL = 1;
    private static final int DOWN_ARC = 4;
    private static final int START_HORIZONTAL = 2;
    private static final int START_LINEAR = 3;
    private static final int START_VERTICAL = 1;
    private static final int UP_ARC = 5;
    Arc[] mArcs;
    private boolean mExtrapolate = true;
    private final double[] mTime;

    public static class Arc {
        private static final double EPSILON = 0.001d;
        private static final String TAG = "Arc";
        private static double[] sOurPercent = new double[91];
        double mArcDistance;
        double mArcVelocity;
        double mEllipseA;
        double mEllipseB;
        double mEllipseCenterX;
        double mEllipseCenterY;
        boolean mLinear;
        double[] mLut;
        double mOneOverDeltaTime;
        double mTime1;
        double mTime2;
        double mTmpCosAngle;
        double mTmpSinAngle;
        boolean mVertical;
        double mX1;
        double mX2;
        double mY1;
        double mY2;

        public Arc(int i, double d, double d6, double d10, double d11, double d12, double d13) {
            this.mLinear = false;
            double d14 = d12 - d10;
            double d15 = d13 - d11;
            if (i == 1) {
                this.mVertical = true;
            } else if (i == 4) {
                this.mVertical = d15 > 0.0d;
            } else if (i != 5) {
                this.mVertical = false;
            } else {
                this.mVertical = d15 < 0.0d;
            }
            this.mTime1 = d;
            this.mTime2 = d6;
            this.mOneOverDeltaTime = 1.0d / (d6 - d);
            if (3 == i) {
                this.mLinear = true;
            }
            if (!this.mLinear && Math.abs(d14) >= EPSILON && Math.abs(d15) >= EPSILON) {
                this.mLut = new double[101];
                boolean z10 = this.mVertical;
                this.mEllipseA = d14 * (z10 ? -1 : 1);
                this.mEllipseB = d15 * (z10 ? 1 : -1);
                this.mEllipseCenterX = z10 ? d12 : d10;
                this.mEllipseCenterY = z10 ? d11 : d13;
                buildTable(d10, d11, d12, d13);
                this.mArcVelocity = this.mArcDistance * this.mOneOverDeltaTime;
                return;
            }
            this.mLinear = true;
            this.mX1 = d10;
            this.mX2 = d12;
            this.mY1 = d11;
            this.mY2 = d13;
            double dHypot = Math.hypot(d15, d14);
            this.mArcDistance = dHypot;
            this.mArcVelocity = dHypot * this.mOneOverDeltaTime;
            double d16 = this.mTime2;
            double d17 = this.mTime1;
            this.mEllipseCenterX = d14 / (d16 - d17);
            this.mEllipseCenterY = d15 / (d16 - d17);
        }

        private void buildTable(double d, double d6, double d10, double d11) {
            double d12 = d10 - d;
            double d13 = d6 - d11;
            int i = 0;
            double dHypot = 0.0d;
            double d14 = 0.0d;
            double d15 = 0.0d;
            while (true) {
                if (i >= sOurPercent.length) {
                    break;
                }
                int i6 = i;
                double radians = Math.toRadians((i * 90.0d) / (r15.length - 1));
                double dSin = Math.sin(radians) * d12;
                double dCos = Math.cos(radians) * d13;
                if (i6 > 0) {
                    dHypot += Math.hypot(dSin - d14, dCos - d15);
                    sOurPercent[i6] = dHypot;
                }
                i = i6 + 1;
                d14 = dSin;
                d15 = dCos;
            }
            this.mArcDistance = dHypot;
            int i10 = 0;
            while (true) {
                double[] dArr = sOurPercent;
                if (i10 >= dArr.length) {
                    break;
                }
                dArr[i10] = dArr[i10] / dHypot;
                i10++;
            }
            int i11 = 0;
            while (true) {
                if (i11 >= this.mLut.length) {
                    return;
                }
                double length = i11 / (r1.length - 1);
                int iBinarySearch = Arrays.binarySearch(sOurPercent, length);
                if (iBinarySearch >= 0) {
                    this.mLut[i11] = iBinarySearch / (sOurPercent.length - 1);
                } else if (iBinarySearch == -1) {
                    this.mLut[i11] = 0.0d;
                } else {
                    int i12 = -iBinarySearch;
                    int i13 = i12 - 2;
                    double[] dArr2 = sOurPercent;
                    double d16 = dArr2[i13];
                    this.mLut[i11] = (((length - d16) / (dArr2[i12 - 1] - d16)) + i13) / (dArr2.length - 1);
                }
                i11++;
            }
        }

        public double getDX() {
            double d = this.mEllipseA * this.mTmpCosAngle;
            double dHypot = this.mArcVelocity / Math.hypot(d, (-this.mEllipseB) * this.mTmpSinAngle);
            return this.mVertical ? (-d) * dHypot : d * dHypot;
        }

        public double getDY() {
            double d = this.mEllipseA * this.mTmpCosAngle;
            double d6 = (-this.mEllipseB) * this.mTmpSinAngle;
            double dHypot = this.mArcVelocity / Math.hypot(d, d6);
            return this.mVertical ? (-d6) * dHypot : d6 * dHypot;
        }

        public double getLinearDX(double d) {
            return this.mEllipseCenterX;
        }

        public double getLinearDY(double d) {
            return this.mEllipseCenterY;
        }

        public double getLinearX(double d) {
            double d6 = (d - this.mTime1) * this.mOneOverDeltaTime;
            double d10 = this.mX1;
            return ((this.mX2 - d10) * d6) + d10;
        }

        public double getLinearY(double d) {
            double d6 = (d - this.mTime1) * this.mOneOverDeltaTime;
            double d10 = this.mY1;
            return ((this.mY2 - d10) * d6) + d10;
        }

        public double getX() {
            return (this.mEllipseA * this.mTmpSinAngle) + this.mEllipseCenterX;
        }

        public double getY() {
            return (this.mEllipseB * this.mTmpCosAngle) + this.mEllipseCenterY;
        }

        public double lookup(double d) {
            if (d <= 0.0d) {
                return 0.0d;
            }
            if (d >= 1.0d) {
                return 1.0d;
            }
            double[] dArr = this.mLut;
            double length = d * (dArr.length - 1);
            int i = (int) length;
            double d6 = length - i;
            double d10 = dArr[i];
            return ((dArr[i + 1] - d10) * d6) + d10;
        }

        public void setPoint(double d) {
            double dLookup = lookup((this.mVertical ? this.mTime2 - d : d - this.mTime1) * this.mOneOverDeltaTime) * 1.5707963267948966d;
            this.mTmpSinAngle = Math.sin(dLookup);
            this.mTmpCosAngle = Math.cos(dLookup);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ArcCurveFit(int[] r23, double[] r24, double[][] r25) {
        /*
            r22 = this;
            r0 = r22
            r1 = r24
            r0.<init>()
            r2 = 1
            r0.mExtrapolate = r2
            r0.mTime = r1
            int r3 = r1.length
            int r3 = r3 - r2
            androidx.constraintlayout.core.motion.utils.ArcCurveFit$Arc[] r3 = new androidx.constraintlayout.core.motion.utils.ArcCurveFit.Arc[r3]
            r0.mArcs = r3
            r3 = 0
            r5 = r2
            r6 = r5
            r4 = r3
        L16:
            androidx.constraintlayout.core.motion.utils.ArcCurveFit$Arc[] r7 = r0.mArcs
            int r8 = r7.length
            if (r4 >= r8) goto L58
            r8 = r23[r4]
            r9 = 3
            if (r8 == 0) goto L38
            if (r8 == r2) goto L36
            r10 = 2
            if (r8 == r10) goto L34
            if (r8 == r9) goto L2f
            r9 = 4
            if (r8 == r9) goto L38
            r9 = 5
            if (r8 == r9) goto L38
            r9 = r6
            goto L38
        L2f:
            if (r5 != r2) goto L36
            goto L34
        L32:
            r9 = r5
            goto L38
        L34:
            r5 = r10
            goto L32
        L36:
            r5 = r2
            goto L32
        L38:
            androidx.constraintlayout.core.motion.utils.ArcCurveFit$Arc r8 = new androidx.constraintlayout.core.motion.utils.ArcCurveFit$Arc
            r10 = r1[r4]
            int r6 = r4 + 1
            r12 = r1[r6]
            r14 = r25[r4]
            r16 = r14
            r14 = r16[r3]
            r16 = r16[r2]
            r18 = r25[r6]
            r20 = r18
            r18 = r20[r3]
            r20 = r20[r2]
            r8.<init>(r9, r10, r12, r14, r16, r18, r20)
            r7[r4] = r8
            r4 = r6
            r6 = r9
            goto L16
        L58:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.utils.ArcCurveFit.<init>(int[], double[], double[][]):void");
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double d, double[] dArr) {
        if (this.mExtrapolate) {
            Arc[] arcArr = this.mArcs;
            Arc arc = arcArr[0];
            double d6 = arc.mTime1;
            if (d < d6) {
                double d10 = d - d6;
                if (arc.mLinear) {
                    dArr[0] = (this.mArcs[0].getLinearDX(d6) * d10) + arc.getLinearX(d6);
                    dArr[1] = (d10 * this.mArcs[0].getLinearDY(d6)) + this.mArcs[0].getLinearY(d6);
                    return;
                }
                arc.setPoint(d6);
                dArr[0] = (this.mArcs[0].getDX() * d10) + this.mArcs[0].getX();
                dArr[1] = (d10 * this.mArcs[0].getDY()) + this.mArcs[0].getY();
                return;
            }
            if (d > arcArr[arcArr.length - 1].mTime2) {
                double d11 = arcArr[arcArr.length - 1].mTime2;
                double d12 = d - d11;
                int length = arcArr.length - 1;
                Arc arc2 = arcArr[length];
                if (arc2.mLinear) {
                    dArr[0] = (this.mArcs[length].getLinearDX(d11) * d12) + arc2.getLinearX(d11);
                    dArr[1] = (d12 * this.mArcs[length].getLinearDY(d11)) + this.mArcs[length].getLinearY(d11);
                    return;
                }
                arc2.setPoint(d);
                dArr[0] = (this.mArcs[length].getDX() * d12) + this.mArcs[length].getX();
                dArr[1] = (d12 * this.mArcs[length].getDY()) + this.mArcs[length].getY();
                return;
            }
        } else {
            Arc[] arcArr2 = this.mArcs;
            double d13 = arcArr2[0].mTime1;
            if (d < d13) {
                d = d13;
            }
            if (d > arcArr2[arcArr2.length - 1].mTime2) {
                d = arcArr2[arcArr2.length - 1].mTime2;
            }
        }
        int i = 0;
        while (true) {
            Arc[] arcArr3 = this.mArcs;
            if (i >= arcArr3.length) {
                return;
            }
            Arc arc3 = arcArr3[i];
            if (d <= arc3.mTime2) {
                if (arc3.mLinear) {
                    dArr[0] = arc3.getLinearX(d);
                    dArr[1] = this.mArcs[i].getLinearY(d);
                    return;
                } else {
                    arc3.setPoint(d);
                    dArr[0] = this.mArcs[i].getX();
                    dArr[1] = this.mArcs[i].getY();
                    return;
                }
            }
            i++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getSlope(double d, double[] dArr) {
        Arc[] arcArr = this.mArcs;
        double d6 = arcArr[0].mTime1;
        if (d < d6) {
            d = d6;
        } else if (d > arcArr[arcArr.length - 1].mTime2) {
            d = arcArr[arcArr.length - 1].mTime2;
        }
        int i = 0;
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i >= arcArr2.length) {
                return;
            }
            Arc arc = arcArr2[i];
            if (d <= arc.mTime2) {
                if (arc.mLinear) {
                    dArr[0] = arc.getLinearDX(d);
                    dArr[1] = this.mArcs[i].getLinearDY(d);
                    return;
                } else {
                    arc.setPoint(d);
                    dArr[0] = this.mArcs[i].getDX();
                    dArr[1] = this.mArcs[i].getDY();
                    return;
                }
            }
            i++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.mTime;
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getSlope(double d, int i) {
        Arc[] arcArr = this.mArcs;
        int i6 = 0;
        double d6 = arcArr[0].mTime1;
        if (d < d6) {
            d = d6;
        }
        if (d > arcArr[arcArr.length - 1].mTime2) {
            d = arcArr[arcArr.length - 1].mTime2;
        }
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i6 >= arcArr2.length) {
                return Double.NaN;
            }
            Arc arc = arcArr2[i6];
            if (d <= arc.mTime2) {
                if (arc.mLinear) {
                    if (i == 0) {
                        return arc.getLinearDX(d);
                    }
                    return arc.getLinearDY(d);
                }
                arc.setPoint(d);
                if (i == 0) {
                    return this.mArcs[i6].getDX();
                }
                return this.mArcs[i6].getDY();
            }
            i6++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double d, float[] fArr) {
        if (this.mExtrapolate) {
            Arc[] arcArr = this.mArcs;
            Arc arc = arcArr[0];
            double d6 = arc.mTime1;
            if (d < d6) {
                double d10 = d - d6;
                if (arc.mLinear) {
                    fArr[0] = (float) ((this.mArcs[0].getLinearDX(d6) * d10) + arc.getLinearX(d6));
                    fArr[1] = (float) ((d10 * this.mArcs[0].getLinearDY(d6)) + this.mArcs[0].getLinearY(d6));
                    return;
                }
                arc.setPoint(d6);
                fArr[0] = (float) ((this.mArcs[0].getDX() * d10) + this.mArcs[0].getX());
                fArr[1] = (float) ((d10 * this.mArcs[0].getDY()) + this.mArcs[0].getY());
                return;
            }
            if (d > arcArr[arcArr.length - 1].mTime2) {
                double d11 = arcArr[arcArr.length - 1].mTime2;
                double d12 = d - d11;
                int length = arcArr.length - 1;
                Arc arc2 = arcArr[length];
                if (arc2.mLinear) {
                    fArr[0] = (float) ((this.mArcs[length].getLinearDX(d11) * d12) + arc2.getLinearX(d11));
                    fArr[1] = (float) ((d12 * this.mArcs[length].getLinearDY(d11)) + this.mArcs[length].getLinearY(d11));
                    return;
                }
                arc2.setPoint(d);
                fArr[0] = (float) this.mArcs[length].getX();
                fArr[1] = (float) this.mArcs[length].getY();
                return;
            }
        } else {
            Arc[] arcArr2 = this.mArcs;
            double d13 = arcArr2[0].mTime1;
            if (d < d13) {
                d = d13;
            } else if (d > arcArr2[arcArr2.length - 1].mTime2) {
                d = arcArr2[arcArr2.length - 1].mTime2;
            }
        }
        int i = 0;
        while (true) {
            Arc[] arcArr3 = this.mArcs;
            if (i >= arcArr3.length) {
                return;
            }
            Arc arc3 = arcArr3[i];
            if (d <= arc3.mTime2) {
                if (arc3.mLinear) {
                    fArr[0] = (float) arc3.getLinearX(d);
                    fArr[1] = (float) this.mArcs[i].getLinearY(d);
                    return;
                } else {
                    arc3.setPoint(d);
                    fArr[0] = (float) this.mArcs[i].getX();
                    fArr[1] = (float) this.mArcs[i].getY();
                    return;
                }
            }
            i++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getPos(double d, int i) {
        int i6 = 0;
        if (this.mExtrapolate) {
            Arc[] arcArr = this.mArcs;
            Arc arc = arcArr[0];
            double d6 = arc.mTime1;
            if (d < d6) {
                double d10 = d - d6;
                if (arc.mLinear) {
                    if (i == 0) {
                        return (d10 * this.mArcs[0].getLinearDX(d6)) + arc.getLinearX(d6);
                    }
                    return (d10 * this.mArcs[0].getLinearDY(d6)) + arc.getLinearY(d6);
                }
                arc.setPoint(d6);
                if (i == 0) {
                    return (d10 * this.mArcs[0].getDX()) + this.mArcs[0].getX();
                }
                return (d10 * this.mArcs[0].getDY()) + this.mArcs[0].getY();
            }
            if (d > arcArr[arcArr.length - 1].mTime2) {
                double d11 = arcArr[arcArr.length - 1].mTime2;
                double d12 = d - d11;
                int length = arcArr.length - 1;
                if (i == 0) {
                    return (d12 * this.mArcs[length].getLinearDX(d11)) + arcArr[length].getLinearX(d11);
                }
                return (d12 * this.mArcs[length].getLinearDY(d11)) + arcArr[length].getLinearY(d11);
            }
        } else {
            Arc[] arcArr2 = this.mArcs;
            double d13 = arcArr2[0].mTime1;
            if (d < d13) {
                d = d13;
            } else if (d > arcArr2[arcArr2.length - 1].mTime2) {
                d = arcArr2[arcArr2.length - 1].mTime2;
            }
        }
        while (true) {
            Arc[] arcArr3 = this.mArcs;
            if (i6 >= arcArr3.length) {
                return Double.NaN;
            }
            Arc arc2 = arcArr3[i6];
            if (d <= arc2.mTime2) {
                if (arc2.mLinear) {
                    if (i == 0) {
                        return arc2.getLinearX(d);
                    }
                    return arc2.getLinearY(d);
                }
                arc2.setPoint(d);
                if (i == 0) {
                    return this.mArcs[i6].getX();
                }
                return this.mArcs[i6].getY();
            }
            i6++;
        }
    }
}

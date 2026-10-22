package m0;

import java.util.Arrays;

/* renamed from: m0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C4888a extends AbstractC4889b {

    /* renamed from: a, reason: collision with root package name */
    public final double[] f37027a;

    /* renamed from: b, reason: collision with root package name */
    public C0470a[] f37028b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f37029c = true;

    /* renamed from: m0.a$a, reason: collision with other inner class name */
    public static class C0470a {

        /* renamed from: s, reason: collision with root package name */
        public static double[] f37030s = new double[91];

        /* renamed from: a, reason: collision with root package name */
        public double[] f37031a;

        /* renamed from: b, reason: collision with root package name */
        public double f37032b;

        /* renamed from: c, reason: collision with root package name */
        public double f37033c;

        /* renamed from: d, reason: collision with root package name */
        public double f37034d;

        /* renamed from: e, reason: collision with root package name */
        public double f37035e;

        /* renamed from: f, reason: collision with root package name */
        public double f37036f;

        /* renamed from: g, reason: collision with root package name */
        public double f37037g;

        /* renamed from: h, reason: collision with root package name */
        public double f37038h;

        /* renamed from: i, reason: collision with root package name */
        public double f37039i;

        /* renamed from: j, reason: collision with root package name */
        public double f37040j;

        /* renamed from: k, reason: collision with root package name */
        public double f37041k;

        /* renamed from: l, reason: collision with root package name */
        public double f37042l;

        /* renamed from: m, reason: collision with root package name */
        public double f37043m;

        /* renamed from: n, reason: collision with root package name */
        public double f37044n;

        /* renamed from: o, reason: collision with root package name */
        public double f37045o;

        /* renamed from: p, reason: collision with root package name */
        public double f37046p;

        /* renamed from: q, reason: collision with root package name */
        public boolean f37047q;

        /* renamed from: r, reason: collision with root package name */
        public boolean f37048r;

        public C0470a(int i10, double d10, double d11, double d12, double d13, double d14, double d15) {
            this.f37048r = false;
            double d16 = d14 - d12;
            double d17 = d15 - d13;
            if (i10 == 1) {
                this.f37047q = true;
            } else if (i10 == 4) {
                this.f37047q = d17 > 0.0d;
            } else if (i10 != 5) {
                this.f37047q = false;
            } else {
                this.f37047q = d17 < 0.0d;
            }
            this.f37033c = d10;
            this.f37034d = d11;
            this.f37039i = 1.0d / (d11 - d10);
            if (3 == i10) {
                this.f37048r = true;
            }
            if (!this.f37048r && Math.abs(d16) >= 0.001d && Math.abs(d17) >= 0.001d) {
                this.f37031a = new double[101];
                boolean z10 = this.f37047q;
                this.f37040j = d16 * (z10 ? -1 : 1);
                this.f37041k = d17 * (z10 ? 1 : -1);
                this.f37042l = z10 ? d14 : d12;
                this.f37043m = z10 ? d13 : d15;
                a(d12, d13, d14, d15);
                this.f37044n = this.f37032b * this.f37039i;
                return;
            }
            this.f37048r = true;
            this.f37035e = d12;
            this.f37036f = d14;
            this.f37037g = d13;
            this.f37038h = d15;
            double dHypot = Math.hypot(d17, d16);
            this.f37032b = dHypot;
            this.f37044n = dHypot * this.f37039i;
            double d18 = this.f37034d;
            double d19 = this.f37033c;
            this.f37042l = d16 / (d18 - d19);
            this.f37043m = d17 / (d18 - d19);
        }

        public final void a(double d10, double d11, double d12, double d13) {
            double d14 = d12 - d10;
            double d15 = d11 - d13;
            int i10 = 0;
            double dHypot = 0.0d;
            double d16 = 0.0d;
            double d17 = 0.0d;
            while (true) {
                if (i10 >= f37030s.length) {
                    break;
                }
                int i11 = i10;
                double radians = Math.toRadians((i10 * 90.0d) / (r15.length - 1));
                double dSin = Math.sin(radians) * d14;
                double dCos = Math.cos(radians) * d15;
                if (i11 > 0) {
                    dHypot += Math.hypot(dSin - d16, dCos - d17);
                    f37030s[i11] = dHypot;
                }
                i10 = i11 + 1;
                d16 = dSin;
                d17 = dCos;
            }
            this.f37032b = dHypot;
            int i12 = 0;
            while (true) {
                double[] dArr = f37030s;
                if (i12 >= dArr.length) {
                    break;
                }
                dArr[i12] = dArr[i12] / dHypot;
                i12++;
            }
            int i13 = 0;
            while (true) {
                if (i13 >= this.f37031a.length) {
                    return;
                }
                double length = i13 / (r1.length - 1);
                int iBinarySearch = Arrays.binarySearch(f37030s, length);
                if (iBinarySearch >= 0) {
                    this.f37031a[i13] = iBinarySearch / (f37030s.length - 1);
                } else if (iBinarySearch == -1) {
                    this.f37031a[i13] = 0.0d;
                } else {
                    int i14 = -iBinarySearch;
                    int i15 = i14 - 2;
                    double[] dArr2 = f37030s;
                    double d18 = dArr2[i15];
                    this.f37031a[i13] = (i15 + ((length - d18) / (dArr2[i14 - 1] - d18))) / (dArr2.length - 1);
                }
                i13++;
            }
        }

        public double b() {
            double d10 = this.f37040j * this.f37046p;
            double dHypot = this.f37044n / Math.hypot(d10, (-this.f37041k) * this.f37045o);
            return this.f37047q ? (-d10) * dHypot : d10 * dHypot;
        }

        public double c() {
            double d10 = this.f37040j * this.f37046p;
            double d11 = (-this.f37041k) * this.f37045o;
            double dHypot = this.f37044n / Math.hypot(d10, d11);
            return this.f37047q ? (-d11) * dHypot : d11 * dHypot;
        }

        public double d(double d10) {
            return this.f37042l;
        }

        public double e(double d10) {
            return this.f37043m;
        }

        public double f(double d10) {
            double d11 = (d10 - this.f37033c) * this.f37039i;
            double d12 = this.f37035e;
            return d12 + (d11 * (this.f37036f - d12));
        }

        public double g(double d10) {
            double d11 = (d10 - this.f37033c) * this.f37039i;
            double d12 = this.f37037g;
            return d12 + (d11 * (this.f37038h - d12));
        }

        public double h() {
            return this.f37042l + (this.f37040j * this.f37045o);
        }

        public double i() {
            return this.f37043m + (this.f37041k * this.f37046p);
        }

        public double j(double d10) {
            if (d10 <= 0.0d) {
                return 0.0d;
            }
            if (d10 >= 1.0d) {
                return 1.0d;
            }
            double[] dArr = this.f37031a;
            double length = d10 * (dArr.length - 1);
            int i10 = (int) length;
            double d11 = length - i10;
            double d12 = dArr[i10];
            return d12 + (d11 * (dArr[i10 + 1] - d12));
        }

        public void k(double d10) {
            double dJ = j((this.f37047q ? this.f37034d - d10 : d10 - this.f37033c) * this.f37039i) * 1.5707963267948966d;
            this.f37045o = Math.sin(dJ);
            this.f37046p = Math.cos(dJ);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public C4888a(int[] r23, double[] r24, double[][] r25) {
        /*
            r22 = this;
            r0 = r22
            r1 = r24
            r0.<init>()
            r2 = 1
            r0.f37029c = r2
            r0.f37027a = r1
            int r3 = r1.length
            int r3 = r3 - r2
            m0.a$a[] r3 = new m0.C4888a.C0470a[r3]
            r0.f37028b = r3
            r3 = 0
            r5 = r2
            r6 = r5
            r4 = r3
        L16:
            m0.a$a[] r7 = r0.f37028b
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
            m0.a$a r8 = new m0.a$a
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
        throw new UnsupportedOperationException("Method not decompiled: m0.C4888a.<init>(int[], double[], double[][]):void");
    }

    @Override // m0.AbstractC4889b
    public double c(double d10, int i10) {
        double dG;
        double dE;
        double dI;
        double dC;
        double dG2;
        double dE2;
        int i11 = 0;
        if (this.f37029c) {
            C0470a[] c0470aArr = this.f37028b;
            C0470a c0470a = c0470aArr[0];
            double d11 = c0470a.f37033c;
            if (d10 < d11) {
                double d12 = d10 - d11;
                if (c0470a.f37048r) {
                    if (i10 == 0) {
                        dG2 = c0470a.f(d11);
                        dE2 = this.f37028b[0].d(d11);
                    } else {
                        dG2 = c0470a.g(d11);
                        dE2 = this.f37028b[0].e(d11);
                    }
                    return dG2 + (d12 * dE2);
                }
                c0470a.k(d11);
                if (i10 == 0) {
                    dI = this.f37028b[0].h();
                    dC = this.f37028b[0].b();
                } else {
                    dI = this.f37028b[0].i();
                    dC = this.f37028b[0].c();
                }
                return dI + (d12 * dC);
            }
            if (d10 > c0470aArr[c0470aArr.length - 1].f37034d) {
                double d13 = c0470aArr[c0470aArr.length - 1].f37034d;
                double d14 = d10 - d13;
                int length = c0470aArr.length - 1;
                if (i10 == 0) {
                    dG = c0470aArr[length].f(d13);
                    dE = this.f37028b[length].d(d13);
                } else {
                    dG = c0470aArr[length].g(d13);
                    dE = this.f37028b[length].e(d13);
                }
                return dG + (d14 * dE);
            }
        } else {
            C0470a[] c0470aArr2 = this.f37028b;
            double d15 = c0470aArr2[0].f37033c;
            if (d10 < d15) {
                d10 = d15;
            } else if (d10 > c0470aArr2[c0470aArr2.length - 1].f37034d) {
                d10 = c0470aArr2[c0470aArr2.length - 1].f37034d;
            }
        }
        while (true) {
            C0470a[] c0470aArr3 = this.f37028b;
            if (i11 >= c0470aArr3.length) {
                return Double.NaN;
            }
            C0470a c0470a2 = c0470aArr3[i11];
            if (d10 <= c0470a2.f37034d) {
                if (c0470a2.f37048r) {
                    return i10 == 0 ? c0470a2.f(d10) : c0470a2.g(d10);
                }
                c0470a2.k(d10);
                return i10 == 0 ? this.f37028b[i11].h() : this.f37028b[i11].i();
            }
            i11++;
        }
    }

    @Override // m0.AbstractC4889b
    public void d(double d10, double[] dArr) {
        if (this.f37029c) {
            C0470a[] c0470aArr = this.f37028b;
            C0470a c0470a = c0470aArr[0];
            double d11 = c0470a.f37033c;
            if (d10 < d11) {
                double d12 = d10 - d11;
                if (c0470a.f37048r) {
                    dArr[0] = c0470a.f(d11) + (this.f37028b[0].d(d11) * d12);
                    dArr[1] = this.f37028b[0].g(d11) + (d12 * this.f37028b[0].e(d11));
                    return;
                } else {
                    c0470a.k(d11);
                    dArr[0] = this.f37028b[0].h() + (this.f37028b[0].b() * d12);
                    dArr[1] = this.f37028b[0].i() + (d12 * this.f37028b[0].c());
                    return;
                }
            }
            if (d10 > c0470aArr[c0470aArr.length - 1].f37034d) {
                double d13 = c0470aArr[c0470aArr.length - 1].f37034d;
                double d14 = d10 - d13;
                int length = c0470aArr.length - 1;
                C0470a c0470a2 = c0470aArr[length];
                if (c0470a2.f37048r) {
                    dArr[0] = c0470a2.f(d13) + (this.f37028b[length].d(d13) * d14);
                    dArr[1] = this.f37028b[length].g(d13) + (d14 * this.f37028b[length].e(d13));
                    return;
                } else {
                    c0470a2.k(d10);
                    dArr[0] = this.f37028b[length].h() + (this.f37028b[length].b() * d14);
                    dArr[1] = this.f37028b[length].i() + (d14 * this.f37028b[length].c());
                    return;
                }
            }
        } else {
            C0470a[] c0470aArr2 = this.f37028b;
            double d15 = c0470aArr2[0].f37033c;
            if (d10 < d15) {
                d10 = d15;
            }
            if (d10 > c0470aArr2[c0470aArr2.length - 1].f37034d) {
                d10 = c0470aArr2[c0470aArr2.length - 1].f37034d;
            }
        }
        int i10 = 0;
        while (true) {
            C0470a[] c0470aArr3 = this.f37028b;
            if (i10 >= c0470aArr3.length) {
                return;
            }
            C0470a c0470a3 = c0470aArr3[i10];
            if (d10 <= c0470a3.f37034d) {
                if (c0470a3.f37048r) {
                    dArr[0] = c0470a3.f(d10);
                    dArr[1] = this.f37028b[i10].g(d10);
                    return;
                } else {
                    c0470a3.k(d10);
                    dArr[0] = this.f37028b[i10].h();
                    dArr[1] = this.f37028b[i10].i();
                    return;
                }
            }
            i10++;
        }
    }

    @Override // m0.AbstractC4889b
    public void e(double d10, float[] fArr) {
        if (this.f37029c) {
            C0470a[] c0470aArr = this.f37028b;
            C0470a c0470a = c0470aArr[0];
            double d11 = c0470a.f37033c;
            if (d10 < d11) {
                double d12 = d10 - d11;
                if (c0470a.f37048r) {
                    fArr[0] = (float) (c0470a.f(d11) + (this.f37028b[0].d(d11) * d12));
                    fArr[1] = (float) (this.f37028b[0].g(d11) + (d12 * this.f37028b[0].e(d11)));
                    return;
                } else {
                    c0470a.k(d11);
                    fArr[0] = (float) (this.f37028b[0].h() + (this.f37028b[0].b() * d12));
                    fArr[1] = (float) (this.f37028b[0].i() + (d12 * this.f37028b[0].c()));
                    return;
                }
            }
            if (d10 > c0470aArr[c0470aArr.length - 1].f37034d) {
                double d13 = c0470aArr[c0470aArr.length - 1].f37034d;
                double d14 = d10 - d13;
                int length = c0470aArr.length - 1;
                C0470a c0470a2 = c0470aArr[length];
                if (c0470a2.f37048r) {
                    fArr[0] = (float) (c0470a2.f(d13) + (this.f37028b[length].d(d13) * d14));
                    fArr[1] = (float) (this.f37028b[length].g(d13) + (d14 * this.f37028b[length].e(d13)));
                    return;
                } else {
                    c0470a2.k(d10);
                    fArr[0] = (float) this.f37028b[length].h();
                    fArr[1] = (float) this.f37028b[length].i();
                    return;
                }
            }
        } else {
            C0470a[] c0470aArr2 = this.f37028b;
            double d15 = c0470aArr2[0].f37033c;
            if (d10 < d15) {
                d10 = d15;
            } else if (d10 > c0470aArr2[c0470aArr2.length - 1].f37034d) {
                d10 = c0470aArr2[c0470aArr2.length - 1].f37034d;
            }
        }
        int i10 = 0;
        while (true) {
            C0470a[] c0470aArr3 = this.f37028b;
            if (i10 >= c0470aArr3.length) {
                return;
            }
            C0470a c0470a3 = c0470aArr3[i10];
            if (d10 <= c0470a3.f37034d) {
                if (c0470a3.f37048r) {
                    fArr[0] = (float) c0470a3.f(d10);
                    fArr[1] = (float) this.f37028b[i10].g(d10);
                    return;
                } else {
                    c0470a3.k(d10);
                    fArr[0] = (float) this.f37028b[i10].h();
                    fArr[1] = (float) this.f37028b[i10].i();
                    return;
                }
            }
            i10++;
        }
    }

    @Override // m0.AbstractC4889b
    public void f(double d10, double[] dArr) {
        C0470a[] c0470aArr = this.f37028b;
        double d11 = c0470aArr[0].f37033c;
        if (d10 < d11) {
            d10 = d11;
        } else if (d10 > c0470aArr[c0470aArr.length - 1].f37034d) {
            d10 = c0470aArr[c0470aArr.length - 1].f37034d;
        }
        int i10 = 0;
        while (true) {
            C0470a[] c0470aArr2 = this.f37028b;
            if (i10 >= c0470aArr2.length) {
                return;
            }
            C0470a c0470a = c0470aArr2[i10];
            if (d10 <= c0470a.f37034d) {
                if (c0470a.f37048r) {
                    dArr[0] = c0470a.d(d10);
                    dArr[1] = this.f37028b[i10].e(d10);
                    return;
                } else {
                    c0470a.k(d10);
                    dArr[0] = this.f37028b[i10].b();
                    dArr[1] = this.f37028b[i10].c();
                    return;
                }
            }
            i10++;
        }
    }

    @Override // m0.AbstractC4889b
    public double[] g() {
        return this.f37027a;
    }
}

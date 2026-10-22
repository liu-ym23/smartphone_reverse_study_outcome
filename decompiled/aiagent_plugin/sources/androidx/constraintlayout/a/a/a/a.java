package androidx.constraintlayout.a.a.a;

import java.util.Arrays;

/* JADX INFO: compiled from: ArcCurveFit.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    C0011a[] f604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final double[] f605b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f606c;

    /* JADX INFO: renamed from: androidx.constraintlayout.a.a.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ArcCurveFit.java */
    private static class C0011a {
        private static final String TAG = "Arc";
        private static double[] s;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        double[] f607a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        double f608b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        double f609c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        double f610d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        double f611e;
        double f;
        double g;
        double h;
        double i;
        double j;
        double k;
        double l;
        double m;
        double n;
        double o;
        double p;
        boolean q;
        boolean r;

        static {
            s = new double[91];
        }

        C0011a(int r21, double r22, double r24, double r26, double r28, double r30, double r32) {
            boolean r14 = false;
            this.r = false;
            int r15 = 1;
            if (r21 != 1) goto L5;
            r14 = true;
        L5:
            this.q = r14;
            this.f609c = r22;
            this.f610d = r24;
            this.i = 1.0d / (r24 - r22);
            if (3 != r21) goto L8;
            this.r = true;
        L8:
            double r0 = r30 - r26;
            double r2 = r32 - r28;
            if (this.r == false) goto L11;
        L33:
            this.r = true;
            this.f611e = r26;
            this.f = r30;
            this.g = r28;
            this.h = r32;
            double r4 = Math.hypot(r2, r0);
            this.f608b = r4;
            this.n = r4 * this.i;
            double r5 = this.f610d;
            double r6 = this.f609c;
            this.l = r0 / (r5 - r6);
            this.m = r2 / (r5 - r6);
            return;
        L11:
            if (Math.abs(r0) < 0.001d) goto L33;
            if (Math.abs(r2) < 0.001d) goto L33;
            this.f607a = new double[101];
            boolean r7 = this.q;
            if (r7 == false) goto L18;
            int r16 = -1;
        L19:
            this.j = r0 * ((double) r16);
            if (r7 == true) goto L23;
            r15 = -1;
        L23:
            this.k = r2 * ((double) r15);
            if (r7 == false) goto L26;
            double r1 = r30;
        L27:
            this.l = r1;
            if (r7 == false) goto L30;
            double r3 = r28;
        L31:
            this.m = r3;
            a(r26, r28, r30, r32);
            this.n = this.f608b * this.i;
            return;
        L30:
            r3 = r32;
            goto L31
        L26:
            r1 = r26;
            goto L27
        L18:
            r16 = 1;
            goto L19
        }

        void a(double r3) {
            if (this.q == false) goto L5;
            double r0 = this.f610d - r3;
        L6:
            double r1 = f(r0 * this.i) * 1.5707963267948966d;
            this.o = Math.sin(r1);
            this.p = Math.cos(r1);
            return;
        L5:
            r0 = r3 - this.f609c;
            goto L6
        }

        double a() {
            return this.l + (this.j * this.o);
        }

        double b() {
            return this.m + (this.k * this.p);
        }

        double c() {
            double r0 = this.j * this.p;
            double r2 = (-this.k) * this.o;
            double r4 = this.n / Math.hypot(r0, r2);
            if (this.q == false) goto L6;
            r0 = -r0;
        L6:
            return r0 * r4;
        }

        double d() {
            double r0 = this.j * this.p;
            double r2 = (-this.k) * this.o;
            double r4 = this.n / Math.hypot(r0, r2);
            if (this.q == false) goto L6;
            return (-r2) * r4;
        L6:
            return r2 * r4;
        }

        public double b(double r5) {
            double r6 = (r5 - this.f609c) * this.i;
            double r0 = this.f611e;
            return r0 + (r6 * (this.f - r0));
        }

        public double c(double r5) {
            double r6 = (r5 - this.f609c) * this.i;
            double r0 = this.g;
            return r0 + (r6 * (this.h - r0));
        }

        public double d(double r1) {
            return this.l;
        }

        public double e(double r1) {
            return this.m;
        }

        double f(double r8) {
            if (r8 > 0.0d) goto L6;
            return 0.0d;
        L6:
            if (r8 < 1.0d) goto L8;
            return 1.0d;
        L8:
            double[] r7 = this.f607a;
            double r9 = r8 * ((double) (r7.length - 1));
            int r0 = (int) r9;
            return r7[r0] + ((r9 - ((double) r0)) * (r7[r0 + 1] - r7[r0]));
        }

        private void a(double r21, double r23, double r25, double r27) {
            double r1 = r25 - r21;
            double r3 = r23 - r27;
            int r8 = 0;
            double r9 = 0.0d;
            double r11 = 0.0d;
            double r13 = 0.0d;
        L3:
            double[] r15 = s;
            if (r8 >= r15.length) goto L10;
            double r24 = r9;
            double r5 = Math.toRadians((((double) r8) * 90.0d) / ((double) (r15.length - 1)));
            double r10 = Math.sin(r5) * r1;
            double r6 = Math.cos(r5) * r3;
            if (r8 <= 0) goto L8;
            double r12 = r24 + Math.hypot(r10 - r11, r6 - r13);
            s[r8] = r12;
        L9:
            r8 = r8 + 1;
            r13 = r6;
            r9 = r12;
            r11 = r10;
            goto L3
        L8:
            r12 = r24;
            goto L9
        L10:
            double r14 = r9;
            this.f608b = r14;
            int r2 = 0;
        L11:
            double[] r4 = s;
            if (r2 >= r4.length) goto L14;
            r4[r2] = r4[r2] / r14;
            r2 = r2 + 1;
            goto L11
        L14:
            int r7 = 0;
        L15:
            double[] r16 = this.f607a;
            if (r7 >= r16.length) goto L25;
            double r17 = ((double) r7) / ((double) (r16.length - 1));
            int r18 = Arrays.binarySearch(s, r17);
            if (r18 < 0) goto L21;
            this.f607a[r7] = ((double) r18) / ((double) (s.length - 1));
        L24:
            r7 = r7 + 1;
            goto L15
        L21:
            if (r18 != (-1)) goto L23;
            this.f607a[r7] = 0.0d;
            goto L24
        L23:
            int r19 = -r18;
            int r20 = r19 - 2;
            double[] r110 = s;
            this.f607a[r7] = (((double) r20) + ((r17 - r110[r20]) / (r110[r19 - 1] - r110[r20]))) / ((double) (r110.length - 1));
            goto L24
        }
    }

    @Override // androidx.constraintlayout.a.a.a.b
    public void a(double r11, double[] r13) {
        if (this.f606c == false) goto L19;
        if (r11 >= this.f604a[0].f609c) goto L11;
        double r3 = this.f604a[0].f609c;
        double r12 = r11 - this.f604a[0].f609c;
        if (this.f604a[0].r == false) goto L9;
        r13[0] = this.f604a[0].b(r3) + (this.f604a[0].d(r3) * r12);
        r13[1] = this.f604a[0].c(r3) + (r12 * this.f604a[0].e(r3));
        return;
    L9:
        this.f604a[0].a(r3);
        r13[0] = this.f604a[0].a() + (this.f604a[0].c() * r12);
        r13[1] = this.f604a[0].b() + (r12 * this.f604a[0].d());
        return;
    L11:
        C0011a[] r0 = this.f604a;
        if (r11 <= r0[r0.length - 1].f610d) goto L24;
        C0011a[] r1 = this.f604a;
        double r4 = r1[r1.length - 1].f610d;
        double r5 = r11 - r4;
        C0011a[] r2 = this.f604a;
        int r7 = r2.length - 1;
        if (r2[r7].r == false) goto L16;
        r13[0] = this.f604a[r7].b(r4) + (this.f604a[r7].d(r4) * r5);
        r13[1] = this.f604a[r7].c(r4) + (r5 * this.f604a[r7].e(r4));
        return;
    L16:
        this.f604a[r7].a(r11);
        r13[0] = this.f604a[r7].a() + (this.f604a[r7].c() * r5);
        r13[1] = this.f604a[r7].b() + (r5 * this.f604a[r7].d());
        return;
    L24:
        int r6 = 0;
    L25:
        C0011a[] r8 = this.f604a;
        if (r6 >= r8.length) goto L36;
        if (r11 <= r8[r6].f610d) goto L30;
        r6 = r6 + 1;
        goto L25
    L30:
        if (this.f604a[r6].r == false) goto L33;
        r13[0] = this.f604a[r6].b(r11);
        r13[1] = this.f604a[r6].c(r11);
        return;
    L33:
        this.f604a[r6].a(r11);
        r13[0] = this.f604a[r6].a();
        r13[1] = this.f604a[r6].b();
        return;
    L36:
        return;
    L19:
        if (r11 >= this.f604a[0].f609c) goto L21;
        r11 = this.f604a[0].f609c;
    L21:
        C0011a[] r9 = this.f604a;
        if (r11 <= r9[r9.length - 1].f610d) goto L24;
        C0011a[] r14 = this.f604a;
        r11 = r14[r14.length - 1].f610d;
        goto L24
    }

    @Override // androidx.constraintlayout.a.a.a.b
    public void a(double r11, float[] r13) {
        if (this.f606c == false) goto L19;
        if (r11 >= this.f604a[0].f609c) goto L11;
        double r3 = this.f604a[0].f609c;
        double r12 = r11 - this.f604a[0].f609c;
        if (this.f604a[0].r == false) goto L9;
        r13[0] = (float) (this.f604a[0].b(r3) + (this.f604a[0].d(r3) * r12));
        r13[1] = (float) (this.f604a[0].c(r3) + (r12 * this.f604a[0].e(r3)));
        return;
    L9:
        this.f604a[0].a(r3);
        r13[0] = (float) (this.f604a[0].a() + (this.f604a[0].c() * r12));
        r13[1] = (float) (this.f604a[0].b() + (r12 * this.f604a[0].d()));
        return;
    L11:
        C0011a[] r0 = this.f604a;
        if (r11 <= r0[r0.length - 1].f610d) goto L24;
        C0011a[] r1 = this.f604a;
        double r4 = r1[r1.length - 1].f610d;
        double r5 = r11 - r4;
        C0011a[] r2 = this.f604a;
        int r7 = r2.length - 1;
        if (r2[r7].r == false) goto L16;
        r13[0] = (float) (this.f604a[r7].b(r4) + (this.f604a[r7].d(r4) * r5));
        r13[1] = (float) (this.f604a[r7].c(r4) + (r5 * this.f604a[r7].e(r4)));
        return;
    L16:
        this.f604a[r7].a(r11);
        r13[0] = (float) this.f604a[r7].a();
        r13[1] = (float) this.f604a[r7].b();
        return;
    L24:
        int r6 = 0;
    L25:
        C0011a[] r8 = this.f604a;
        if (r6 >= r8.length) goto L36;
        if (r11 <= r8[r6].f610d) goto L30;
        r6 = r6 + 1;
        goto L25
    L30:
        if (this.f604a[r6].r == false) goto L33;
        r13[0] = (float) this.f604a[r6].b(r11);
        r13[1] = (float) this.f604a[r6].c(r11);
        return;
    L33:
        this.f604a[r6].a(r11);
        r13[0] = (float) this.f604a[r6].a();
        r13[1] = (float) this.f604a[r6].b();
        return;
    L36:
        return;
    L19:
        if (r11 >= this.f604a[0].f609c) goto L21;
        r11 = this.f604a[0].f609c;
        goto L24
    L21:
        C0011a[] r9 = this.f604a;
        if (r11 <= r9[r9.length - 1].f610d) goto L24;
        C0011a[] r14 = this.f604a;
        r11 = r14[r14.length - 1].f610d;
        goto L24
    }

    @Override // androidx.constraintlayout.a.a.a.b
    public void b(double r6, double[] r8) {
        if (r6 >= this.f604a[0].f609c) goto L5;
        r6 = this.f604a[0].f609c;
    L8:
        int r0 = 0;
    L9:
        C0011a[] r3 = this.f604a;
        if (r0 >= r3.length) goto L20;
        if (r6 <= r3[r0].f610d) goto L14;
        r0 = r0 + 1;
        goto L9
    L14:
        if (this.f604a[r0].r == false) goto L17;
        r8[0] = this.f604a[r0].d(r6);
        r8[1] = this.f604a[r0].e(r6);
        return;
    L17:
        this.f604a[r0].a(r6);
        r8[0] = this.f604a[r0].c();
        r8[1] = this.f604a[r0].d();
        return;
    L20:
        return;
    L5:
        C0011a[] r1 = this.f604a;
        if (r6 <= r1[r1.length - 1].f610d) goto L8;
        C0011a[] r7 = this.f604a;
        r6 = r7[r7.length - 1].f610d;
        goto L8
    }

    @Override // androidx.constraintlayout.a.a.a.b
    public double a(double r7, int r9) {
        int r1 = 0;
        if (this.f606c == false) goto L26;
        if (r7 >= this.f604a[0].f609c) goto L19;
        double r2 = this.f604a[0].f609c;
        double r8 = r7 - this.f604a[0].f609c;
        if (this.f604a[0].r == false) goto L13;
        if (r9 != 0) goto L12;
        double r4 = this.f604a[0].b(r2);
        double r0 = this.f604a[0].d(r2);
    L11:
        return r4 + (r8 * r0);
    L12:
        r4 = this.f604a[0].c(r2);
        r0 = this.f604a[0].e(r2);
        goto L11
    L13:
        this.f604a[0].a(r2);
        if (r9 != 0) goto L18;
        double r3 = this.f604a[0].a();
        double r5 = this.f604a[0].c();
    L17:
        return r3 + (r8 * r5);
    L18:
        r3 = this.f604a[0].b();
        r5 = this.f604a[0].d();
        goto L17
    L19:
        C0011a[] r6 = this.f604a;
        if (r7 <= r6[r6.length - 1].f610d) goto L31;
        C0011a[] r10 = this.f604a;
        double r11 = r10[r10.length - 1].f610d;
        r8 = r7 - r11;
        C0011a[] r12 = this.f604a;
        int r13 = r12.length - 1;
        if (r9 != 0) goto L24;
        r4 = r12[r13].b(r11);
        r0 = this.f604a[r13].d(r11);
        goto L11
    L24:
        r4 = r12[r13].c(r11);
        r0 = this.f604a[r13].e(r11);
    L31:
        C0011a[] r14 = this.f604a;
        if (r1 >= r14.length) goto L49;
        if (r7 <= r14[r1].f610d) goto L36;
        r1 = r1 + 1;
        goto L31
    L36:
        if (this.f604a[r1].r == false) goto L42;
        if (r9 != 0) goto L41;
        return this.f604a[r1].b(r7);
    L41:
        return this.f604a[r1].c(r7);
    L42:
        this.f604a[r1].a(r7);
        if (r9 != 0) goto L47;
        return this.f604a[r1].a();
    L47:
        return this.f604a[r1].b();
    L49:
        return Double.NaN;
    L26:
        if (r7 >= this.f604a[0].f609c) goto L28;
        r7 = this.f604a[0].f609c;
        goto L31
    L28:
        C0011a[] r15 = this.f604a;
        if (r7 <= r15[r15.length - 1].f610d) goto L31;
        C0011a[] r16 = this.f604a;
        r7 = r16[r16.length - 1].f610d;
        goto L31
    }

    @Override // androidx.constraintlayout.a.a.a.b
    public double b(double r5, int r7) {
        int r1 = 0;
        if (r5 >= this.f604a[0].f609c) goto L5;
        r5 = this.f604a[0].f609c;
    L5:
        C0011a[] r0 = this.f604a;
        if (r5 <= r0[r0.length - 1].f610d) goto L8;
        C0011a[] r6 = this.f604a;
        r5 = r6[r6.length - 1].f610d;
    L8:
        C0011a[] r2 = this.f604a;
        if (r1 >= r2.length) goto L26;
        if (r5 <= r2[r1].f610d) goto L13;
        r1 = r1 + 1;
        goto L8
    L13:
        if (this.f604a[r1].r == false) goto L19;
        if (r7 != 0) goto L18;
        return this.f604a[r1].d(r5);
    L18:
        return this.f604a[r1].e(r5);
    L19:
        this.f604a[r1].a(r5);
        if (r7 != 0) goto L24;
        return this.f604a[r1].c();
    L24:
        return this.f604a[r1].d();
    L26:
        return Double.NaN;
    }

    @Override // androidx.constraintlayout.a.a.a.b
    public double[] a() {
        return this.f605b;
    }

    public a(int[] r25, double[] r26, double[][] r27) {
        this.f606c = true;
        this.f605b = r26;
        this.f604a = new C0011a[r26.length - 1];
        int r5 = 1;
        int r6 = 1;
        int r4 = 0;
    L3:
        C0011a[] r7 = this.f604a;
        if (r4 >= r7.length) goto L17;
        int r8 = r25[r4];
        if (r8 == 0) goto L15;
        if (r8 == 1) goto L13;
        if (r8 == 2) goto L12;
        if (r8 != 3) goto L16;
        if (r5 != 1) goto L13;
    L16:
        int r23 = r4 + 1;
        r7[r4] = new C0011a(r6, r26[r4], r26[r23], r27[r4][0], r27[r4][1], r27[r23][0], r27[r23][1]);
        r4 = r23;
    L12:
        r5 = 2;
    L14:
        r6 = r5;
    L13:
        r5 = 1;
        goto L14
    L15:
        r6 = 3;
        goto L16
    }
}

package com.obric.oui.constraintlayout.a.a.a;

import java.util.Arrays;

/* JADX INFO: compiled from: ArcCurveFit.java */
/* JADX INFO: loaded from: classes4.dex */
public class a extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    C0937a[] f34581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final double[] f34582b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f34583c;

    /* JADX INFO: renamed from: com.obric.oui.constraintlayout.a.a.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ArcCurveFit.java */
    private static class C0937a {
        private static final String TAG = "Arc";
        private static double[] s;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        double[] f34584a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        double f34585b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        double f34586c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        double f34587d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        double f34588e;
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

        C0937a(int r20, double r21, double r23, double r25, double r27, double r29, double r31) {
            this.r = false;
            double r14 = r29 - r25;
            double r10 = r31 - r27;
            int r12 = 1;
            if (r20 != 1) goto L5;
            this.q = true;
        L18:
            this.f34586c = r21;
            this.f34587d = r23;
            this.i = 1.0d / (r23 - r21);
            if (3 != r20) goto L22;
            this.r = true;
        L22:
            if (this.r == false) goto L24;
        L46:
            this.r = true;
            this.f34588e = r25;
            this.f = r29;
            this.g = r27;
            this.h = r31;
            double r0 = Math.hypot(r10, r14);
            this.f34585b = r0;
            this.n = r0 * this.i;
            double r1 = this.f34587d;
            double r4 = this.f34586c;
            this.l = r14 / (r1 - r4);
            this.m = r10 / (r1 - r4);
            return;
        L24:
            if (Math.abs(r14) < 0.001d) goto L46;
            if (Math.abs(r10) < 0.001d) goto L46;
            this.f34584a = new double[101];
            boolean r2 = this.q;
            if (r2 == false) goto L31;
            int r3 = -1;
        L32:
            this.j = r14 * ((double) r3);
            if (r2 == true) goto L36;
            r12 = -1;
        L36:
            this.k = r10 * ((double) r12);
            if (r2 == false) goto L39;
            double r5 = r29;
        L40:
            this.l = r5;
            if (r2 == false) goto L43;
            double r6 = r27;
        L44:
            this.m = r6;
            a(r25, r27, r29, r31);
            this.n = this.f34585b * this.i;
            return;
        L43:
            r6 = r31;
            goto L44
        L39:
            r5 = r25;
            goto L40
        L31:
            r3 = 1;
            goto L32
        L5:
            if (r20 != 4) goto L7;
            boolean r13 = false;
            if (r10 <= 0.0d) goto L16;
            r13 = true;
        L16:
            this.q = r13;
            goto L18
        L7:
            if (r20 == 5) goto L9;
            this.q = false;
            goto L18
        L9:
            boolean r15 = false;
            if (r10 >= 0.0d) goto L12;
            r15 = true;
        L12:
            this.q = r15;
            goto L18
        }

        void a(double r3) {
            if (this.q == false) goto L5;
            double r0 = this.f34587d - r3;
        L6:
            double r1 = f(r0 * this.i) * 1.5707963267948966d;
            this.o = Math.sin(r1);
            this.p = Math.cos(r1);
            return;
        L5:
            r0 = r3 - this.f34586c;
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
            double r6 = (r5 - this.f34586c) * this.i;
            double r0 = this.f34588e;
            return r0 + (r6 * (this.f - r0));
        }

        public double c(double r5) {
            double r6 = (r5 - this.f34586c) * this.i;
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
            double[] r7 = this.f34584a;
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
            this.f34585b = r14;
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
            double[] r16 = this.f34584a;
            if (r7 >= r16.length) goto L25;
            double r17 = ((double) r7) / ((double) (r16.length - 1));
            int r18 = Arrays.binarySearch(s, r17);
            if (r18 < 0) goto L21;
            this.f34584a[r7] = ((double) r18) / ((double) (s.length - 1));
        L24:
            r7 = r7 + 1;
            goto L15
        L21:
            if (r18 != (-1)) goto L23;
            this.f34584a[r7] = 0.0d;
            goto L24
        L23:
            int r19 = -r18;
            int r20 = r19 - 2;
            double[] r110 = s;
            this.f34584a[r7] = (((double) r20) + ((r17 - r110[r20]) / (r110[r19 - 1] - r110[r20]))) / ((double) (r110.length - 1));
            goto L24
        }
    }

    @Override // com.obric.oui.constraintlayout.a.a.a.b
    public void a(double r11, double[] r13) {
        if (this.f34583c == false) goto L19;
        if (r11 >= this.f34581a[0].f34586c) goto L11;
        double r3 = this.f34581a[0].f34586c;
        double r12 = r11 - this.f34581a[0].f34586c;
        if (this.f34581a[0].r == false) goto L9;
        r13[0] = this.f34581a[0].b(r3) + (this.f34581a[0].d(r3) * r12);
        r13[1] = this.f34581a[0].c(r3) + (r12 * this.f34581a[0].e(r3));
        return;
    L9:
        this.f34581a[0].a(r3);
        r13[0] = this.f34581a[0].a() + (this.f34581a[0].c() * r12);
        r13[1] = this.f34581a[0].b() + (r12 * this.f34581a[0].d());
        return;
    L11:
        C0937a[] r0 = this.f34581a;
        if (r11 <= r0[r0.length - 1].f34587d) goto L24;
        C0937a[] r1 = this.f34581a;
        double r4 = r1[r1.length - 1].f34587d;
        double r5 = r11 - r4;
        C0937a[] r2 = this.f34581a;
        int r7 = r2.length - 1;
        if (r2[r7].r == false) goto L16;
        r13[0] = this.f34581a[r7].b(r4) + (this.f34581a[r7].d(r4) * r5);
        r13[1] = this.f34581a[r7].c(r4) + (r5 * this.f34581a[r7].e(r4));
        return;
    L16:
        this.f34581a[r7].a(r11);
        r13[0] = this.f34581a[r7].a() + (this.f34581a[r7].c() * r5);
        r13[1] = this.f34581a[r7].b() + (r5 * this.f34581a[r7].d());
        return;
    L24:
        int r6 = 0;
    L25:
        C0937a[] r8 = this.f34581a;
        if (r6 >= r8.length) goto L36;
        if (r11 <= r8[r6].f34587d) goto L30;
        r6 = r6 + 1;
        goto L25
    L30:
        if (this.f34581a[r6].r == false) goto L33;
        r13[0] = this.f34581a[r6].b(r11);
        r13[1] = this.f34581a[r6].c(r11);
        return;
    L33:
        this.f34581a[r6].a(r11);
        r13[0] = this.f34581a[r6].a();
        r13[1] = this.f34581a[r6].b();
        return;
    L36:
        return;
    L19:
        if (r11 >= this.f34581a[0].f34586c) goto L21;
        r11 = this.f34581a[0].f34586c;
    L21:
        C0937a[] r9 = this.f34581a;
        if (r11 <= r9[r9.length - 1].f34587d) goto L24;
        C0937a[] r14 = this.f34581a;
        r11 = r14[r14.length - 1].f34587d;
        goto L24
    }

    @Override // com.obric.oui.constraintlayout.a.a.a.b
    public void a(double r11, float[] r13) {
        if (this.f34583c == false) goto L19;
        if (r11 >= this.f34581a[0].f34586c) goto L11;
        double r3 = this.f34581a[0].f34586c;
        double r12 = r11 - this.f34581a[0].f34586c;
        if (this.f34581a[0].r == false) goto L9;
        r13[0] = (float) (this.f34581a[0].b(r3) + (this.f34581a[0].d(r3) * r12));
        r13[1] = (float) (this.f34581a[0].c(r3) + (r12 * this.f34581a[0].e(r3)));
        return;
    L9:
        this.f34581a[0].a(r3);
        r13[0] = (float) (this.f34581a[0].a() + (this.f34581a[0].c() * r12));
        r13[1] = (float) (this.f34581a[0].b() + (r12 * this.f34581a[0].d()));
        return;
    L11:
        C0937a[] r0 = this.f34581a;
        if (r11 <= r0[r0.length - 1].f34587d) goto L24;
        C0937a[] r1 = this.f34581a;
        double r4 = r1[r1.length - 1].f34587d;
        double r5 = r11 - r4;
        C0937a[] r2 = this.f34581a;
        int r7 = r2.length - 1;
        if (r2[r7].r == false) goto L16;
        r13[0] = (float) (this.f34581a[r7].b(r4) + (this.f34581a[r7].d(r4) * r5));
        r13[1] = (float) (this.f34581a[r7].c(r4) + (r5 * this.f34581a[r7].e(r4)));
        return;
    L16:
        this.f34581a[r7].a(r11);
        r13[0] = (float) this.f34581a[r7].a();
        r13[1] = (float) this.f34581a[r7].b();
        return;
    L24:
        int r6 = 0;
    L25:
        C0937a[] r8 = this.f34581a;
        if (r6 >= r8.length) goto L36;
        if (r11 <= r8[r6].f34587d) goto L30;
        r6 = r6 + 1;
        goto L25
    L30:
        if (this.f34581a[r6].r == false) goto L33;
        r13[0] = (float) this.f34581a[r6].b(r11);
        r13[1] = (float) this.f34581a[r6].c(r11);
        return;
    L33:
        this.f34581a[r6].a(r11);
        r13[0] = (float) this.f34581a[r6].a();
        r13[1] = (float) this.f34581a[r6].b();
        return;
    L36:
        return;
    L19:
        if (r11 >= this.f34581a[0].f34586c) goto L21;
        r11 = this.f34581a[0].f34586c;
        goto L24
    L21:
        C0937a[] r9 = this.f34581a;
        if (r11 <= r9[r9.length - 1].f34587d) goto L24;
        C0937a[] r14 = this.f34581a;
        r11 = r14[r14.length - 1].f34587d;
        goto L24
    }

    @Override // com.obric.oui.constraintlayout.a.a.a.b
    public void b(double r6, double[] r8) {
        if (r6 >= this.f34581a[0].f34586c) goto L5;
        r6 = this.f34581a[0].f34586c;
    L8:
        int r0 = 0;
    L9:
        C0937a[] r3 = this.f34581a;
        if (r0 >= r3.length) goto L20;
        if (r6 <= r3[r0].f34587d) goto L14;
        r0 = r0 + 1;
        goto L9
    L14:
        if (this.f34581a[r0].r == false) goto L17;
        r8[0] = this.f34581a[r0].d(r6);
        r8[1] = this.f34581a[r0].e(r6);
        return;
    L17:
        this.f34581a[r0].a(r6);
        r8[0] = this.f34581a[r0].c();
        r8[1] = this.f34581a[r0].d();
        return;
    L20:
        return;
    L5:
        C0937a[] r1 = this.f34581a;
        if (r6 <= r1[r1.length - 1].f34587d) goto L8;
        C0937a[] r7 = this.f34581a;
        r6 = r7[r7.length - 1].f34587d;
        goto L8
    }

    @Override // com.obric.oui.constraintlayout.a.a.a.b
    public double a(double r7, int r9) {
        int r1 = 0;
        if (this.f34583c == false) goto L26;
        if (r7 >= this.f34581a[0].f34586c) goto L19;
        double r2 = this.f34581a[0].f34586c;
        double r8 = r7 - this.f34581a[0].f34586c;
        if (this.f34581a[0].r == false) goto L13;
        if (r9 != 0) goto L12;
        double r4 = this.f34581a[0].b(r2);
        double r0 = this.f34581a[0].d(r2);
    L11:
        return r4 + (r8 * r0);
    L12:
        r4 = this.f34581a[0].c(r2);
        r0 = this.f34581a[0].e(r2);
        goto L11
    L13:
        this.f34581a[0].a(r2);
        if (r9 != 0) goto L18;
        double r3 = this.f34581a[0].a();
        double r5 = this.f34581a[0].c();
    L17:
        return r3 + (r8 * r5);
    L18:
        r3 = this.f34581a[0].b();
        r5 = this.f34581a[0].d();
        goto L17
    L19:
        C0937a[] r6 = this.f34581a;
        if (r7 <= r6[r6.length - 1].f34587d) goto L31;
        C0937a[] r10 = this.f34581a;
        double r11 = r10[r10.length - 1].f34587d;
        r8 = r7 - r11;
        C0937a[] r12 = this.f34581a;
        int r13 = r12.length - 1;
        if (r9 != 0) goto L24;
        r4 = r12[r13].b(r11);
        r0 = this.f34581a[r13].d(r11);
        goto L11
    L24:
        r4 = r12[r13].c(r11);
        r0 = this.f34581a[r13].e(r11);
    L31:
        C0937a[] r14 = this.f34581a;
        if (r1 >= r14.length) goto L49;
        if (r7 <= r14[r1].f34587d) goto L36;
        r1 = r1 + 1;
        goto L31
    L36:
        if (this.f34581a[r1].r == false) goto L42;
        if (r9 != 0) goto L41;
        return this.f34581a[r1].b(r7);
    L41:
        return this.f34581a[r1].c(r7);
    L42:
        this.f34581a[r1].a(r7);
        if (r9 != 0) goto L47;
        return this.f34581a[r1].a();
    L47:
        return this.f34581a[r1].b();
    L49:
        return Double.NaN;
    L26:
        if (r7 >= this.f34581a[0].f34586c) goto L28;
        r7 = this.f34581a[0].f34586c;
        goto L31
    L28:
        C0937a[] r15 = this.f34581a;
        if (r7 <= r15[r15.length - 1].f34587d) goto L31;
        C0937a[] r16 = this.f34581a;
        r7 = r16[r16.length - 1].f34587d;
        goto L31
    }

    @Override // com.obric.oui.constraintlayout.a.a.a.b
    public double b(double r5, int r7) {
        int r1 = 0;
        if (r5 >= this.f34581a[0].f34586c) goto L5;
        r5 = this.f34581a[0].f34586c;
    L5:
        C0937a[] r0 = this.f34581a;
        if (r5 <= r0[r0.length - 1].f34587d) goto L8;
        C0937a[] r6 = this.f34581a;
        r5 = r6[r6.length - 1].f34587d;
    L8:
        C0937a[] r2 = this.f34581a;
        if (r1 >= r2.length) goto L26;
        if (r5 <= r2[r1].f34587d) goto L13;
        r1 = r1 + 1;
        goto L8
    L13:
        if (this.f34581a[r1].r == false) goto L19;
        if (r7 != 0) goto L18;
        return this.f34581a[r1].d(r5);
    L18:
        return this.f34581a[r1].e(r5);
    L19:
        this.f34581a[r1].a(r5);
        if (r7 != 0) goto L24;
        return this.f34581a[r1].c();
    L24:
        return this.f34581a[r1].d();
    L26:
        return Double.NaN;
    }

    @Override // com.obric.oui.constraintlayout.a.a.a.b
    public double[] a() {
        return this.f34582b;
    }

    public a(int[] r25, double[] r26, double[][] r27) {
        this.f34583c = true;
        this.f34582b = r26;
        this.f34581a = new C0937a[r26.length - 1];
        int r5 = 1;
        int r6 = 1;
        int r4 = 0;
    L3:
        C0937a[] r7 = this.f34581a;
        if (r4 >= r7.length) goto L21;
        int r8 = r25[r4];
        if (r8 == 0) goto L19;
        if (r8 == 1) goto L17;
        if (r8 == 2) goto L16;
        if (r8 == 3) goto L15;
        if (r8 == 4) goto L14;
        if (r8 != 5) goto L20;
        r6 = 5;
    L20:
        int r23 = r4 + 1;
        r7[r4] = new C0937a(r6, r26[r4], r26[r23], r27[r4][0], r27[r4][1], r27[r23][0], r27[r23][1]);
        r4 = r23;
        goto L3
    L14:
        r6 = 4;
        goto L20
    L15:
        if (r5 != 1) goto L17;
    L16:
        r5 = 2;
    L18:
        r6 = r5;
    L17:
        r5 = 1;
        goto L18
    L19:
        r6 = 3;
        goto L20
    }
}

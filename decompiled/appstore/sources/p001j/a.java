package p001j;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class a extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double[] f20756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public C0273a[] f20757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f20758c;

    /* JADX INFO: renamed from: j.a$a, reason: collision with other inner class name */
    public static class C0273a {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static double[] f20759s;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public double[] f20760a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public double f20761b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public double f20762c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public double f20763d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public double f20764e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public double f20765f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public double f20766g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public double f20767h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public double f20768i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public double f20769j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public double f20770k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public double f20771l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public double f20772m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public double f20773n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public double f20774o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public double f20775p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f20776q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public boolean f20777r;

        static {
            f20759s = new double[91];
        }

        public C0273a(int r21, double r22, double r24, double r26, double r28, double r30, double r32) {
            boolean r14 = false;
            this.f20777r = false;
            int r15 = 1;
            if (r21 != 1) goto L5;
            r14 = true;
        L5:
            this.f20776q = r14;
            this.f20762c = r22;
            this.f20763d = r24;
            this.f20768i = 1.0d / (r24 - r22);
            if (3 != r21) goto L8;
            this.f20777r = true;
        L8:
            double r10 = r30 - r26;
            double r11 = r32 - r28;
            if (this.f20777r == false) goto L11;
        L33:
            this.f20777r = true;
            this.f20764e = r26;
            this.f20765f = r30;
            this.f20766g = r28;
            this.f20767h = r32;
            double r12 = Math.hypot(r11, r10);
            this.f20761b = r12;
            this.f20773n = r12 * this.f20768i;
            double r13 = this.f20763d;
            double r16 = this.f20762c;
            this.f20771l = r10 / (r13 - r16);
            this.f20772m = r11 / (r13 - r16);
            return;
        L11:
            if (Math.abs(r10) < 0.001d) goto L33;
            if (Math.abs(r11) < 0.001d) goto L33;
            this.f20760a = new double[101];
            boolean r17 = this.f20776q;
            if (r17 == false) goto L18;
            int r18 = -1;
        L19:
            this.f20769j = r10 * ((double) r18);
            if (r17 == true) goto L23;
            r15 = -1;
        L23:
            this.f20770k = r11 * ((double) r15);
            if (r17 == false) goto L26;
            double r19 = r30;
        L27:
            this.f20771l = r19;
            if (r17 == false) goto L30;
            double r20 = r28;
        L31:
            this.f20772m = r20;
            a(r26, r28, r30, r32);
            this.f20773n = this.f20761b * this.f20768i;
            return;
        L30:
            r20 = r32;
            goto L31
        L26:
            r19 = r26;
            goto L27
        L18:
            r18 = 1;
            goto L19
        }

        public final void a(double r21, double r23, double r25, double r27) {
            double r10 = r25 - r21;
            double r11 = r23 - r27;
            int r12 = 0;
            double r13 = 0.0d;
            double r14 = 0.0d;
            double r15 = 0.0d;
        L3:
            double[] r16 = f20759s;
            if (r12 >= r16.length) goto L10;
            double r24 = r13;
            double r17 = Math.toRadians((((double) r12) * 90.0d) / ((double) (r16.length - 1)));
            double r18 = Math.sin(r17) * r10;
            double r19 = Math.cos(r17) * r11;
            if (r12 <= 0) goto L8;
            double r110 = Math.hypot(r18 - r14, r19 - r15) + r24;
            f20759s[r12] = r110;
        L9:
            r12 = r12 + 1;
            r15 = r19;
            r13 = r110;
            r14 = r18;
            goto L3
        L8:
            r110 = r24;
            goto L9
        L10:
            double r111 = r13;
            this.f20761b = r111;
            int r20 = 0;
        L11:
            double[] r22 = f20759s;
            if (r20 >= r22.length) goto L14;
            r22[r20] = r22[r20] / r111;
            r20 = r20 + 1;
            goto L11
        L14:
            int r26 = 0;
        L15:
            double[] r28 = this.f20760a;
            if (r26 >= r28.length) goto L25;
            double r29 = ((double) r26) / ((double) (r28.length - 1));
            int r30 = Arrays.binarySearch(f20759s, r29);
            if (r30 < 0) goto L21;
            this.f20760a[r26] = ((double) r30) / ((double) (f20759s.length - 1));
        L24:
            r26 = r26 + 1;
            goto L15
        L21:
            if (r30 != (-1)) goto L23;
            this.f20760a[r26] = 0.0d;
            goto L24
        L23:
            int r31 = -r30;
            int r32 = r31 - 2;
            double[] r112 = f20759s;
            double r113 = r112[r32];
            this.f20760a[r26] = (((double) r32) + ((r29 - r113) / (r112[r31 - 1] - r113))) / ((double) (r112.length - 1));
            goto L24
        }

        public double b() {
            double r10 = this.f20769j * this.f20775p;
            double r11 = (-this.f20770k) * this.f20774o;
            double r12 = this.f20773n / Math.hypot(r10, r11);
            if (this.f20776q == false) goto L6;
            r10 = -r10;
        L6:
            return r10 * r12;
        }

        public double c() {
            double r10 = this.f20769j * this.f20775p;
            double r11 = (-this.f20770k) * this.f20774o;
            double r12 = this.f20773n / Math.hypot(r10, r11);
            if (this.f20776q == false) goto L6;
            return (-r11) * r12;
        L6:
            return r11 * r12;
        }

        public double d(double r10) {
            return this.f20771l;
        }

        public double e(double r10) {
            return this.f20772m;
        }

        public double f(double r10) {
            double r11 = (r10 - this.f20762c) * this.f20768i;
            double r12 = this.f20764e;
            return r12 + (r11 * (this.f20765f - r12));
        }

        public double g(double r10) {
            double r11 = (r10 - this.f20762c) * this.f20768i;
            double r12 = this.f20766g;
            return r12 + (r11 * (this.f20767h - r12));
        }

        public double h() {
            return this.f20771l + (this.f20769j * this.f20774o);
        }

        public double i() {
            return this.f20772m + (this.f20770k * this.f20775p);
        }

        public double j(double r10) {
            if (r10 > 0.0d) goto L6;
            return 0.0d;
        L6:
            if (r10 < 1.0d) goto L8;
            return 1.0d;
        L8:
            double[] r11 = this.f20760a;
            double r12 = r10 * ((double) (r11.length - 1));
            int r13 = (int) r12;
            double r14 = r12 - ((double) r13);
            double r15 = r11[r13];
            return r15 + (r14 * (r11[r13 + 1] - r15));
        }

        public void k(double r10) {
            if (this.f20776q == false) goto L5;
            double r11 = this.f20763d - r10;
        L6:
            double r12 = j(r11 * this.f20768i) * 1.5707963267948966d;
            this.f20774o = Math.sin(r12);
            this.f20775p = Math.cos(r12);
            return;
        L5:
            r11 = r10 - this.f20762c;
            goto L6
        }
    }

    public a(int[] r25, double[] r26, double[][] r27) {
        this.f20758c = true;
        this.f20756a = r26;
        this.f20757b = new C0273a[r26.length - 1];
        int r10 = 1;
        int r11 = 1;
        int r12 = 0;
    L3:
        C0273a[] r13 = this.f20757b;
        if (r12 >= r13.length) goto L19;
        int r14 = r25[r12];
        if (r14 == 0) goto L17;
        if (r14 != 1) goto L9;
    L16:
        r10 = 1;
    L14:
        r11 = r10;
    L18:
        double r15 = r26[r12];
        int r23 = r12 + 1;
        double r16 = r26[r23];
        double[] r17 = r27[r12];
        double r18 = r17[0];
        double r19 = r17[1];
        double[] r20 = r27[r23];
        r13[r12] = new C0273a(r11, r15, r16, r18, r19, r20[0], r20[1]);
        r12 = r23;
        goto L3
    L9:
        if (r14 == 2) goto L15;
        if (r14 != 3) goto L18;
        if (r10 != 1) goto L16;
    L15:
        r10 = 2;
        goto L14
    L17:
        r11 = 3;
        goto L18
    }

    @Override // p001j.b
    public double c(double r10, int r11) {
        int r12 = 0;
        if (this.f20758c == false) goto L27;
        C0273a[] r13 = this.f20757b;
        C0273a r14 = r13[0];
        double r15 = r14.f20762c;
        if (r10 >= r15) goto L20;
        double r16 = r10 - r15;
        if (r14.f20777r == false) goto L13;
        if (r11 != 0) goto L12;
        double r17 = r14.f(r15);
        double r18 = this.f20757b[0].d(r15);
    L11:
        return r17 + (r16 * r18);
    L12:
        r17 = r14.g(r15);
        r18 = this.f20757b[0].e(r15);
        goto L11
    L13:
        r14.k(r15);
        if (r11 != 0) goto L18;
        double r19 = this.f20757b[0].h();
        double r20 = this.f20757b[0].b();
    L17:
        return r19 + (r16 * r20);
    L18:
        r19 = this.f20757b[0].i();
        r20 = this.f20757b[0].c();
        goto L17
    L20:
        if (r10 <= r13[r13.length - 1].f20763d) goto L33;
        double r21 = r13[r13.length - 1].f20763d;
        double r22 = r10 - r21;
        int r23 = r13.length - 1;
        if (r11 != 0) goto L26;
        double r24 = r13[r23].f(r21);
        double r25 = this.f20757b[r23].d(r21);
    L25:
        return r24 + (r22 * r25);
    L26:
        r24 = r13[r23].g(r21);
        r25 = this.f20757b[r23].e(r21);
    L33:
        C0273a[] r26 = this.f20757b;
        if (r12 >= r26.length) goto L51;
        C0273a r27 = r26[r12];
        if (r10 <= r27.f20763d) goto L38;
        r12 = r12 + 1;
        goto L33
    L38:
        if (r27.f20777r == false) goto L44;
        if (r11 != 0) goto L43;
        return r27.f(r10);
    L43:
        return r27.g(r10);
    L44:
        r27.k(r10);
        if (r11 != 0) goto L49;
        return this.f20757b[r12].h();
    L49:
        return this.f20757b[r12].i();
    L51:
        return Double.NaN;
    L27:
        C0273a[] r28 = this.f20757b;
        double r29 = r28[0].f20762c;
        if (r10 >= r29) goto L31;
        r10 = r29;
        goto L33
    L31:
        if (r10 <= r28[r28.length - 1].f20763d) goto L33;
        r10 = r28[r28.length - 1].f20763d;
        goto L33
    }

    @Override // p001j.b
    public void d(double r11, double[] r13) {
        if (this.f20758c == false) goto L18;
        C0273a[] r10 = this.f20757b;
        C0273a r12 = r10[0];
        double r14 = r12.f20762c;
        if (r11 >= r14) goto L12;
        double r15 = r11 - r14;
        if (r12.f20777r == false) goto L9;
        r13[0] = r12.f(r14) + (this.f20757b[0].d(r14) * r15);
        r13[1] = this.f20757b[0].g(r14) + (r15 * this.f20757b[0].e(r14));
        return;
    L9:
        r12.k(r14);
        r13[0] = this.f20757b[0].h() + (this.f20757b[0].b() * r15);
        r13[1] = this.f20757b[0].i() + (r15 * this.f20757b[0].c());
        return;
    L12:
        if (r11 <= r10[r10.length - 1].f20763d) goto L24;
        double r16 = r10[r10.length - 1].f20763d;
        double r17 = r11 - r16;
        int r18 = r10.length - 1;
        C0273a r19 = r10[r18];
        if (r19.f20777r == false) goto L16;
        r13[0] = r19.f(r16) + (this.f20757b[r18].d(r16) * r17);
        r13[1] = this.f20757b[r18].g(r16) + (r17 * this.f20757b[r18].e(r16));
        return;
    L16:
        r19.k(r11);
        r13[0] = this.f20757b[r18].h() + (this.f20757b[r18].b() * r17);
        r13[1] = this.f20757b[r18].i() + (r17 * this.f20757b[r18].c());
        return;
    L24:
        int r20 = 0;
    L25:
        C0273a[] r21 = this.f20757b;
        if (r20 >= r21.length) goto L36;
        C0273a r22 = r21[r20];
        if (r11 <= r22.f20763d) goto L30;
        r20 = r20 + 1;
        goto L25
    L30:
        if (r22.f20777r == false) goto L33;
        r13[0] = r22.f(r11);
        r13[1] = this.f20757b[r20].g(r11);
        return;
    L33:
        r22.k(r11);
        r13[0] = this.f20757b[r20].h();
        r13[1] = this.f20757b[r20].i();
        return;
    L36:
        return;
    L18:
        C0273a[] r23 = this.f20757b;
        double r24 = r23[0].f20762c;
        if (r11 >= r24) goto L22;
        r11 = r24;
    L22:
        if (r11 <= r23[r23.length - 1].f20763d) goto L24;
        r11 = r23[r23.length - 1].f20763d;
        goto L24
    }

    @Override // p001j.b
    public void e(double r11, float[] r13) {
        if (this.f20758c == false) goto L18;
        C0273a[] r10 = this.f20757b;
        C0273a r12 = r10[0];
        double r14 = r12.f20762c;
        if (r11 >= r14) goto L12;
        double r15 = r11 - r14;
        if (r12.f20777r == false) goto L9;
        r13[0] = (float) (r12.f(r14) + (this.f20757b[0].d(r14) * r15));
        r13[1] = (float) (this.f20757b[0].g(r14) + (r15 * this.f20757b[0].e(r14)));
        return;
    L9:
        r12.k(r14);
        r13[0] = (float) (this.f20757b[0].h() + (this.f20757b[0].b() * r15));
        r13[1] = (float) (this.f20757b[0].i() + (r15 * this.f20757b[0].c()));
        return;
    L12:
        if (r11 <= r10[r10.length - 1].f20763d) goto L24;
        double r16 = r10[r10.length - 1].f20763d;
        double r17 = r11 - r16;
        int r18 = r10.length - 1;
        C0273a r19 = r10[r18];
        if (r19.f20777r == false) goto L16;
        r13[0] = (float) (r19.f(r16) + (this.f20757b[r18].d(r16) * r17));
        r13[1] = (float) (this.f20757b[r18].g(r16) + (r17 * this.f20757b[r18].e(r16)));
        return;
    L16:
        r19.k(r11);
        r13[0] = (float) this.f20757b[r18].h();
        r13[1] = (float) this.f20757b[r18].i();
        return;
    L24:
        int r20 = 0;
    L25:
        C0273a[] r21 = this.f20757b;
        if (r20 >= r21.length) goto L36;
        C0273a r22 = r21[r20];
        if (r11 <= r22.f20763d) goto L30;
        r20 = r20 + 1;
        goto L25
    L30:
        if (r22.f20777r == false) goto L33;
        r13[0] = (float) r22.f(r11);
        r13[1] = (float) this.f20757b[r20].g(r11);
        return;
    L33:
        r22.k(r11);
        r13[0] = (float) this.f20757b[r20].h();
        r13[1] = (float) this.f20757b[r20].i();
        return;
    L36:
        return;
    L18:
        C0273a[] r23 = this.f20757b;
        double r24 = r23[0].f20762c;
        if (r11 >= r24) goto L22;
        r11 = r24;
        goto L24
    L22:
        if (r11 <= r23[r23.length - 1].f20763d) goto L24;
        r11 = r23[r23.length - 1].f20763d;
        goto L24
    }

    @Override // p001j.b
    public double f(double r10, int r11) {
        C0273a[] r12 = this.f20757b;
        int r13 = 0;
        double r14 = r12[0].f20762c;
        if (r10 >= r14) goto L6;
        r10 = r14;
    L6:
        if (r10 <= r12[r12.length - 1].f20763d) goto L8;
        r10 = r12[r12.length - 1].f20763d;
    L8:
        C0273a[] r15 = this.f20757b;
        if (r13 >= r15.length) goto L26;
        C0273a r16 = r15[r13];
        if (r10 <= r16.f20763d) goto L13;
        r13 = r13 + 1;
        goto L8
    L13:
        if (r16.f20777r == false) goto L19;
        if (r11 != 0) goto L18;
        return r16.d(r10);
    L18:
        return r16.e(r10);
    L19:
        r16.k(r10);
        if (r11 != 0) goto L24;
        return this.f20757b[r13].b();
    L24:
        return this.f20757b[r13].c();
    L26:
        return Double.NaN;
    }

    @Override // p001j.b
    public void g(double r10, double[] r11) {
        C0273a[] r12 = this.f20757b;
        double r13 = r12[0].f20762c;
        if (r10 >= r13) goto L6;
        r10 = r13;
    L8:
        int r14 = 0;
    L9:
        C0273a[] r15 = this.f20757b;
        if (r14 >= r15.length) goto L20;
        C0273a r16 = r15[r14];
        if (r10 <= r16.f20763d) goto L14;
        r14 = r14 + 1;
        goto L9
    L14:
        if (r16.f20777r == false) goto L17;
        r11[0] = r16.d(r10);
        r11[1] = this.f20757b[r14].e(r10);
        return;
    L17:
        r16.k(r10);
        r11[0] = this.f20757b[r14].b();
        r11[1] = this.f20757b[r14].c();
        return;
    L20:
        return;
    L6:
        if (r10 <= r12[r12.length - 1].f20763d) goto L8;
        r10 = r12[r12.length - 1].f20763d;
        goto L8
    }

    @Override // p001j.b
    public double[] h() {
        return this.f20756a;
    }
}

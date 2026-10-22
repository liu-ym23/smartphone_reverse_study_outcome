package vc;

import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public class a extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double[] f25126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public C0396a[] f25127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f25128c;

    /* JADX INFO: renamed from: vc.a$a, reason: collision with other inner class name */
    public static class C0396a {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static double[] f25129s;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public double[] f25130a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public double f25131b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public double f25132c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public double f25133d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public double f25134e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public double f25135f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public double f25136g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public double f25137h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public double f25138i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public double f25139j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public double f25140k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public double f25141l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public double f25142m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public double f25143n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public double f25144o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public double f25145p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f25146q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public boolean f25147r;

        static {
            f25129s = new double[91];
        }

        public C0396a(int r20, double r21, double r23, double r25, double r27, double r29, double r31) {
            this.f25147r = false;
            double r14 = r29 - r25;
            double r10 = r31 - r27;
            int r12 = 1;
            if (r20 != 1) goto L5;
            this.f25146q = true;
        L18:
            this.f25132c = r21;
            this.f25133d = r23;
            this.f25138i = 1.0d / (r23 - r21);
            if (3 != r20) goto L22;
            this.f25147r = true;
        L22:
            if (this.f25147r == false) goto L24;
        L46:
            this.f25147r = true;
            this.f25134e = r25;
            this.f25135f = r29;
            this.f25136g = r27;
            this.f25137h = r31;
            double r11 = Math.hypot(r10, r14);
            this.f25131b = r11;
            this.f25143n = r11 * this.f25138i;
            double r13 = this.f25133d;
            double r15 = this.f25132c;
            this.f25141l = r14 / (r13 - r15);
            this.f25142m = r10 / (r13 - r15);
            return;
        L24:
            if (Math.abs(r14) < 0.001d) goto L46;
            if (Math.abs(r10) < 0.001d) goto L46;
            this.f25130a = new double[101];
            boolean r16 = this.f25146q;
            if (r16 == false) goto L31;
            int r17 = -1;
        L32:
            this.f25139j = r14 * ((double) r17);
            if (r16 == true) goto L36;
            r12 = -1;
        L36:
            this.f25140k = r10 * ((double) r12);
            if (r16 == false) goto L39;
            double r18 = r29;
        L40:
            this.f25141l = r18;
            if (r16 == false) goto L43;
            double r19 = r27;
        L44:
            this.f25142m = r19;
            a(r25, r27, r29, r31);
            this.f25143n = this.f25131b * this.f25138i;
            return;
        L43:
            r19 = r31;
            goto L44
        L39:
            r18 = r25;
            goto L40
        L31:
            r17 = 1;
            goto L32
        L5:
            if (r20 != 4) goto L7;
            boolean r110 = false;
            if (r10 <= 0.0d) goto L16;
            r110 = true;
        L16:
            this.f25146q = r110;
            goto L18
        L7:
            if (r20 == 5) goto L9;
            this.f25146q = false;
            goto L18
        L9:
            boolean r111 = false;
            if (r10 >= 0.0d) goto L12;
            r111 = true;
        L12:
            this.f25146q = r111;
            goto L18
        }

        public final void a(double r21, double r23, double r25, double r27) {
            double r10 = r25 - r21;
            double r11 = r23 - r27;
            int r12 = 0;
            double r13 = 0.0d;
            double r14 = 0.0d;
            double r15 = 0.0d;
        L3:
            double[] r16 = f25129s;
            if (r12 >= r16.length) goto L10;
            double r24 = r13;
            double r17 = Math.toRadians((((double) r12) * 90.0d) / ((double) (r16.length - 1)));
            double r18 = Math.sin(r17) * r10;
            double r19 = Math.cos(r17) * r11;
            if (r12 <= 0) goto L8;
            double r110 = Math.hypot(r18 - r14, r19 - r15) + r24;
            f25129s[r12] = r110;
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
            this.f25131b = r111;
            int r20 = 0;
        L11:
            double[] r22 = f25129s;
            if (r20 >= r22.length) goto L14;
            r22[r20] = r22[r20] / r111;
            r20 = r20 + 1;
            goto L11
        L14:
            int r26 = 0;
        L15:
            double[] r28 = this.f25130a;
            if (r26 >= r28.length) goto L25;
            double r29 = ((double) r26) / ((double) (r28.length - 1));
            int r30 = Arrays.binarySearch(f25129s, r29);
            if (r30 < 0) goto L21;
            this.f25130a[r26] = ((double) r30) / ((double) (f25129s.length - 1));
        L24:
            r26 = r26 + 1;
            goto L15
        L21:
            if (r30 != (-1)) goto L23;
            this.f25130a[r26] = 0.0d;
            goto L24
        L23:
            int r31 = -r30;
            int r32 = r31 - 2;
            double[] r112 = f25129s;
            double r113 = r112[r32];
            this.f25130a[r26] = (((double) r32) + ((r29 - r113) / (r112[r31 - 1] - r113))) / ((double) (r112.length - 1));
            goto L24
        }

        public double b() {
            double r10 = this.f25139j * this.f25145p;
            double r11 = (-this.f25140k) * this.f25144o;
            double r12 = this.f25143n / Math.hypot(r10, r11);
            if (this.f25146q == false) goto L6;
            r10 = -r10;
        L6:
            return r10 * r12;
        }

        public double c() {
            double r10 = this.f25139j * this.f25145p;
            double r11 = (-this.f25140k) * this.f25144o;
            double r12 = this.f25143n / Math.hypot(r10, r11);
            if (this.f25146q == false) goto L6;
            return (-r11) * r12;
        L6:
            return r11 * r12;
        }

        public double d(double r10) {
            return this.f25141l;
        }

        public double e(double r10) {
            return this.f25142m;
        }

        public double f(double r10) {
            double r11 = (r10 - this.f25132c) * this.f25138i;
            double r12 = this.f25134e;
            return r12 + (r11 * (this.f25135f - r12));
        }

        public double g(double r10) {
            double r11 = (r10 - this.f25132c) * this.f25138i;
            double r12 = this.f25136g;
            return r12 + (r11 * (this.f25137h - r12));
        }

        public double h() {
            return this.f25141l + (this.f25139j * this.f25144o);
        }

        public double i() {
            return this.f25142m + (this.f25140k * this.f25145p);
        }

        public double j(double r10) {
            if (r10 > 0.0d) goto L6;
            return 0.0d;
        L6:
            if (r10 < 1.0d) goto L8;
            return 1.0d;
        L8:
            double[] r11 = this.f25130a;
            double r12 = r10 * ((double) (r11.length - 1));
            int r13 = (int) r12;
            double r14 = r12 - ((double) r13);
            double r15 = r11[r13];
            return r15 + (r14 * (r11[r13 + 1] - r15));
        }

        public void k(double r10) {
            if (this.f25146q == false) goto L5;
            double r11 = this.f25133d - r10;
        L6:
            double r12 = j(r11 * this.f25138i) * 1.5707963267948966d;
            this.f25144o = Math.sin(r12);
            this.f25145p = Math.cos(r12);
            return;
        L5:
            r11 = r10 - this.f25132c;
            goto L6
        }
    }

    public a(int[] r25, double[] r26, double[][] r27) {
        this.f25128c = true;
        this.f25126a = r26;
        this.f25127b = new C0396a[r26.length - 1];
        int r10 = 1;
        int r11 = 1;
        int r12 = 0;
    L3:
        C0396a[] r13 = this.f25127b;
        if (r12 >= r13.length) goto L23;
        int r14 = r25[r12];
        int r15 = 3;
        if (r14 == 0) goto L16;
        if (r14 != 1) goto L9;
    L21:
        r10 = 1;
    L19:
        r11 = r10;
    L22:
        double r16 = r26[r12];
        int r23 = r12 + 1;
        double r17 = r26[r23];
        double[] r18 = r27[r12];
        double r19 = r18[0];
        double r110 = r18[1];
        double[] r20 = r27[r23];
        r13[r12] = new C0396a(r11, r16, r17, r19, r110, r20[0], r20[1]);
        r12 = r23;
        goto L3
    L9:
        if (r14 == 2) goto L20;
        if (r14 == 3) goto L17;
        r15 = 4;
        if (r14 == 4) goto L16;
        r15 = 5;
        if (r14 == 5) goto L16;
    L17:
        if (r10 != 1) goto L21;
    L20:
        r10 = 2;
    L16:
        r11 = r15;
        goto L22
    }

    @Override // vc.b
    public double c(double r10, int r11) {
        int r12 = 0;
        if (this.f25128c == false) goto L27;
        C0396a[] r13 = this.f25127b;
        C0396a r14 = r13[0];
        double r15 = r14.f25132c;
        if (r10 >= r15) goto L20;
        double r16 = r10 - r15;
        if (r14.f25147r == false) goto L13;
        if (r11 != 0) goto L12;
        double r17 = r14.f(r15);
        double r18 = this.f25127b[0].d(r15);
    L11:
        return r17 + (r16 * r18);
    L12:
        r17 = r14.g(r15);
        r18 = this.f25127b[0].e(r15);
        goto L11
    L13:
        r14.k(r15);
        if (r11 != 0) goto L18;
        double r19 = this.f25127b[0].h();
        double r20 = this.f25127b[0].b();
    L17:
        return r19 + (r16 * r20);
    L18:
        r19 = this.f25127b[0].i();
        r20 = this.f25127b[0].c();
        goto L17
    L20:
        if (r10 <= r13[r13.length - 1].f25133d) goto L33;
        double r21 = r13[r13.length - 1].f25133d;
        double r22 = r10 - r21;
        int r23 = r13.length - 1;
        if (r11 != 0) goto L26;
        double r24 = r13[r23].f(r21);
        double r25 = this.f25127b[r23].d(r21);
    L25:
        return r24 + (r22 * r25);
    L26:
        r24 = r13[r23].g(r21);
        r25 = this.f25127b[r23].e(r21);
    L33:
        C0396a[] r26 = this.f25127b;
        if (r12 >= r26.length) goto L51;
        C0396a r27 = r26[r12];
        if (r10 <= r27.f25133d) goto L38;
        r12 = r12 + 1;
        goto L33
    L38:
        if (r27.f25147r == false) goto L44;
        if (r11 != 0) goto L43;
        return r27.f(r10);
    L43:
        return r27.g(r10);
    L44:
        r27.k(r10);
        if (r11 != 0) goto L49;
        return this.f25127b[r12].h();
    L49:
        return this.f25127b[r12].i();
    L51:
        return Double.NaN;
    L27:
        C0396a[] r28 = this.f25127b;
        double r29 = r28[0].f25132c;
        if (r10 >= r29) goto L31;
        r10 = r29;
        goto L33
    L31:
        if (r10 <= r28[r28.length - 1].f25133d) goto L33;
        r10 = r28[r28.length - 1].f25133d;
        goto L33
    }

    @Override // vc.b
    public void d(double r11, double[] r13) {
        if (this.f25128c == false) goto L18;
        C0396a[] r10 = this.f25127b;
        C0396a r12 = r10[0];
        double r14 = r12.f25132c;
        if (r11 >= r14) goto L12;
        double r15 = r11 - r14;
        if (r12.f25147r == false) goto L9;
        r13[0] = r12.f(r14) + (this.f25127b[0].d(r14) * r15);
        r13[1] = this.f25127b[0].g(r14) + (r15 * this.f25127b[0].e(r14));
        return;
    L9:
        r12.k(r14);
        r13[0] = this.f25127b[0].h() + (this.f25127b[0].b() * r15);
        r13[1] = this.f25127b[0].i() + (r15 * this.f25127b[0].c());
        return;
    L12:
        if (r11 <= r10[r10.length - 1].f25133d) goto L24;
        double r16 = r10[r10.length - 1].f25133d;
        double r17 = r11 - r16;
        int r18 = r10.length - 1;
        C0396a r19 = r10[r18];
        if (r19.f25147r == false) goto L16;
        r13[0] = r19.f(r16) + (this.f25127b[r18].d(r16) * r17);
        r13[1] = this.f25127b[r18].g(r16) + (r17 * this.f25127b[r18].e(r16));
        return;
    L16:
        r19.k(r11);
        r13[0] = this.f25127b[r18].h() + (this.f25127b[r18].b() * r17);
        r13[1] = this.f25127b[r18].i() + (r17 * this.f25127b[r18].c());
        return;
    L24:
        int r20 = 0;
    L25:
        C0396a[] r21 = this.f25127b;
        if (r20 >= r21.length) goto L36;
        C0396a r22 = r21[r20];
        if (r11 <= r22.f25133d) goto L30;
        r20 = r20 + 1;
        goto L25
    L30:
        if (r22.f25147r == false) goto L33;
        r13[0] = r22.f(r11);
        r13[1] = this.f25127b[r20].g(r11);
        return;
    L33:
        r22.k(r11);
        r13[0] = this.f25127b[r20].h();
        r13[1] = this.f25127b[r20].i();
        return;
    L36:
        return;
    L18:
        C0396a[] r23 = this.f25127b;
        double r24 = r23[0].f25132c;
        if (r11 >= r24) goto L22;
        r11 = r24;
    L22:
        if (r11 <= r23[r23.length - 1].f25133d) goto L24;
        r11 = r23[r23.length - 1].f25133d;
        goto L24
    }

    @Override // vc.b
    public void e(double r11, float[] r13) {
        if (this.f25128c == false) goto L18;
        C0396a[] r10 = this.f25127b;
        C0396a r12 = r10[0];
        double r14 = r12.f25132c;
        if (r11 >= r14) goto L12;
        double r15 = r11 - r14;
        if (r12.f25147r == false) goto L9;
        r13[0] = (float) (r12.f(r14) + (this.f25127b[0].d(r14) * r15));
        r13[1] = (float) (this.f25127b[0].g(r14) + (r15 * this.f25127b[0].e(r14)));
        return;
    L9:
        r12.k(r14);
        r13[0] = (float) (this.f25127b[0].h() + (this.f25127b[0].b() * r15));
        r13[1] = (float) (this.f25127b[0].i() + (r15 * this.f25127b[0].c()));
        return;
    L12:
        if (r11 <= r10[r10.length - 1].f25133d) goto L24;
        double r16 = r10[r10.length - 1].f25133d;
        double r17 = r11 - r16;
        int r18 = r10.length - 1;
        C0396a r19 = r10[r18];
        if (r19.f25147r == false) goto L16;
        r13[0] = (float) (r19.f(r16) + (this.f25127b[r18].d(r16) * r17));
        r13[1] = (float) (this.f25127b[r18].g(r16) + (r17 * this.f25127b[r18].e(r16)));
        return;
    L16:
        r19.k(r11);
        r13[0] = (float) this.f25127b[r18].h();
        r13[1] = (float) this.f25127b[r18].i();
        return;
    L24:
        int r20 = 0;
    L25:
        C0396a[] r21 = this.f25127b;
        if (r20 >= r21.length) goto L36;
        C0396a r22 = r21[r20];
        if (r11 <= r22.f25133d) goto L30;
        r20 = r20 + 1;
        goto L25
    L30:
        if (r22.f25147r == false) goto L33;
        r13[0] = (float) r22.f(r11);
        r13[1] = (float) this.f25127b[r20].g(r11);
        return;
    L33:
        r22.k(r11);
        r13[0] = (float) this.f25127b[r20].h();
        r13[1] = (float) this.f25127b[r20].i();
        return;
    L36:
        return;
    L18:
        C0396a[] r23 = this.f25127b;
        double r24 = r23[0].f25132c;
        if (r11 >= r24) goto L22;
        r11 = r24;
        goto L24
    L22:
        if (r11 <= r23[r23.length - 1].f25133d) goto L24;
        r11 = r23[r23.length - 1].f25133d;
        goto L24
    }

    @Override // vc.b
    public double f(double r10, int r11) {
        C0396a[] r12 = this.f25127b;
        int r13 = 0;
        double r14 = r12[0].f25132c;
        if (r10 >= r14) goto L6;
        r10 = r14;
    L6:
        if (r10 <= r12[r12.length - 1].f25133d) goto L8;
        r10 = r12[r12.length - 1].f25133d;
    L8:
        C0396a[] r15 = this.f25127b;
        if (r13 >= r15.length) goto L26;
        C0396a r16 = r15[r13];
        if (r10 <= r16.f25133d) goto L13;
        r13 = r13 + 1;
        goto L8
    L13:
        if (r16.f25147r == false) goto L19;
        if (r11 != 0) goto L18;
        return r16.d(r10);
    L18:
        return r16.e(r10);
    L19:
        r16.k(r10);
        if (r11 != 0) goto L24;
        return this.f25127b[r13].b();
    L24:
        return this.f25127b[r13].c();
    L26:
        return Double.NaN;
    }

    @Override // vc.b
    public void g(double r10, double[] r11) {
        C0396a[] r12 = this.f25127b;
        double r13 = r12[0].f25132c;
        if (r10 >= r13) goto L6;
        r10 = r13;
    L8:
        int r14 = 0;
    L9:
        C0396a[] r15 = this.f25127b;
        if (r14 >= r15.length) goto L20;
        C0396a r16 = r15[r14];
        if (r10 <= r16.f25133d) goto L14;
        r14 = r14 + 1;
        goto L9
    L14:
        if (r16.f25147r == false) goto L17;
        r11[0] = r16.d(r10);
        r11[1] = this.f25127b[r14].e(r10);
        return;
    L17:
        r16.k(r10);
        r11[0] = this.f25127b[r14].b();
        r11[1] = this.f25127b[r14].c();
        return;
    L20:
        return;
    L6:
        if (r10 <= r12[r12.length - 1].f25133d) goto L8;
        r10 = r12[r12.length - 1].f25133d;
        goto L8
    }

    @Override // vc.b
    public double[] h() {
        return this.f25126a;
    }
}

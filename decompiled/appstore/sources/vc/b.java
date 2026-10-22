package vc;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b {

    public static class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public double f25148a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public double[] f25149b;

        public a(double r10, double[] r11) {
            this.f25148a = r10;
            this.f25149b = r11;
        }

        @Override // vc.b
        public double c(double r10, int r11) {
            return this.f25149b[r11];
        }

        @Override // vc.b
        public void d(double r10, double[] r11) {
            double[] r12 = this.f25149b;
            System.arraycopy(r12, 0, r11, 0, r12.length);
        }

        @Override // vc.b
        public void e(double r10, float[] r11) {
            int r12 = 0;
        L3:
            double[] r13 = this.f25149b;
            if (r12 >= r13.length) goto L6;
            r11[r12] = (float) r13[r12];
            r12 = r12 + 1;
            goto L3
        }

        @Override // vc.b
        public double f(double r10, int r11) {
            return 0.0d;
        }

        @Override // vc.b
        public void g(double r10, double[] r11) {
            int r12 = 0;
        L4:
            if (r12 >= this.f25149b.length) goto L6;
            r11[r12] = 0.0d;
            r12 = r12 + 1;
            goto L4
        }

        @Override // vc.b
        public double[] h() {
            return new double[]{this.f25148a};
        }
    }

    public b() {
    }

    public static b a(int r10, double[] r11, double[][] r12) {
        if (r11.length != 1) goto L5;
        r10 = 2;
    L5:
        if (r10 == 0) goto L12;
        if (r10 == 2) goto L10;
        return new e(r11, r12);
    L10:
        return new a(r11[0], r12[0]);
    L12:
        return new f(r11, r12);
    }

    public static b b(int[] r10, double[] r11, double[][] r12) {
        return new vc.a(r10, r11, r12);
    }

    public abstract double c(double r10, int r11);

    public abstract void d(double r10, double[] r11);

    public abstract void e(double r10, float[] r11);

    public abstract double f(double r10, int r11);

    public abstract void g(double r10, double[] r11);

    public abstract double[] h();
}

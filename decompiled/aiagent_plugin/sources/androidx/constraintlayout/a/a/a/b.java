package androidx.constraintlayout.a.a.a;

/* JADX INFO: compiled from: CurveFit.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: compiled from: CurveFit.java */
    static class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        double f612a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        double[] f613b;

        @Override // androidx.constraintlayout.a.a.a.b
        public double b(double r1, int r3) {
            return 0.0d;
        }

        a(double r1, double[] r3) {
            this.f612a = r1;
            this.f613b = r3;
        }

        @Override // androidx.constraintlayout.a.a.a.b
        public void a(double r1, double[] r3) {
            double[] r0 = this.f613b;
            System.arraycopy(r0, 0, r3, 0, r0.length);
        }

        @Override // androidx.constraintlayout.a.a.a.b
        public void a(double r3, float[] r5) {
            int r4 = 0;
        L3:
            double[] r6 = this.f613b;
            if (r4 >= r6.length) goto L6;
            r5[r4] = (float) r6[r4];
            r4 = r4 + 1;
            goto L3
        }

        @Override // androidx.constraintlayout.a.a.a.b
        public double a(double r1, int r3) {
            return this.f613b[r3];
        }

        @Override // androidx.constraintlayout.a.a.a.b
        public void b(double r3, double[] r5) {
            int r4 = 0;
        L4:
            if (r4 >= this.f613b.length) goto L6;
            r5[r4] = 0.0d;
            r4 = r4 + 1;
            goto L4
        }

        @Override // androidx.constraintlayout.a.a.a.b
        public double[] a() {
            return new double[]{this.f612a};
        }
    }

    public abstract double a(double r1, int r3);

    public abstract void a(double r1, double[] r3);

    public abstract void a(double r1, float[] r3);

    public abstract double[] a();

    public abstract double b(double r1, int r3);

    public abstract void b(double r1, double[] r3);

    public b() {
    }

    public static b a(int r3, double[] r4, double[][] r5) {
        if (r4.length != 1) goto L5;
        r3 = 2;
    L5:
        if (r3 == 0) goto L12;
        if (r3 == 2) goto L10;
        return new f(r4, r5);
    L10:
        return new a(r4[0], r5[0]);
    L12:
        return new g(r4, r5);
    }

    public static b a(int[] r1, double[] r2, double[][] r3) {
        return new androidx.constraintlayout.a.a.a.a(r1, r2, r3);
    }
}

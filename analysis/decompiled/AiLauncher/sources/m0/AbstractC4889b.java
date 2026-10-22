package m0;

/* renamed from: m0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC4889b {

    /* renamed from: m0.b$a */
    public static class a extends AbstractC4889b {

        /* renamed from: a, reason: collision with root package name */
        public double f37049a;

        /* renamed from: b, reason: collision with root package name */
        public double[] f37050b;

        public a(double d10, double[] dArr) {
            this.f37049a = d10;
            this.f37050b = dArr;
        }

        @Override // m0.AbstractC4889b
        public double c(double d10, int i10) {
            return this.f37050b[i10];
        }

        @Override // m0.AbstractC4889b
        public void d(double d10, double[] dArr) {
            double[] dArr2 = this.f37050b;
            System.arraycopy(dArr2, 0, dArr, 0, dArr2.length);
        }

        @Override // m0.AbstractC4889b
        public void e(double d10, float[] fArr) {
            int i10 = 0;
            while (true) {
                double[] dArr = this.f37050b;
                if (i10 >= dArr.length) {
                    return;
                }
                fArr[i10] = (float) dArr[i10];
                i10++;
            }
        }

        @Override // m0.AbstractC4889b
        public void f(double d10, double[] dArr) {
            for (int i10 = 0; i10 < this.f37050b.length; i10++) {
                dArr[i10] = 0.0d;
            }
        }

        @Override // m0.AbstractC4889b
        public double[] g() {
            return new double[]{this.f37049a};
        }
    }

    public static AbstractC4889b a(int i10, double[] dArr, double[][] dArr2) {
        if (dArr.length == 1) {
            i10 = 2;
        }
        return i10 != 0 ? i10 != 2 ? new f(dArr, dArr2) : new a(dArr[0], dArr2[0]) : new g(dArr, dArr2);
    }

    public static AbstractC4889b b(int[] iArr, double[] dArr, double[][] dArr2) {
        return new C4888a(iArr, dArr, dArr2);
    }

    public abstract double c(double d10, int i10);

    public abstract void d(double d10, double[] dArr);

    public abstract void e(double d10, float[] fArr);

    public abstract void f(double d10, double[] dArr);

    public abstract double[] g();
}

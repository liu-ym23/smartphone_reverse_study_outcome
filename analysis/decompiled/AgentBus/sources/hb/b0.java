package hb;

/* loaded from: classes.dex */
public final class b0 {

    /* renamed from: a, reason: collision with root package name */
    public int f4265a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f4266b = new int[10];

    public final int a() {
        if ((this.f4265a & 128) != 0) {
            return this.f4266b[7];
        }
        return 65535;
    }

    public final void b(b0 b0Var) {
        q7.k.e(b0Var, "other");
        for (int i2 = 0; i2 < 10; i2++) {
            if (((1 << i2) & b0Var.f4265a) != 0) {
                c(i2, b0Var.f4266b[i2]);
            }
        }
    }

    public final void c(int i2, int i10) {
        if (i2 >= 0) {
            int[] iArr = this.f4266b;
            if (i2 >= iArr.length) {
                return;
            }
            this.f4265a = (1 << i2) | this.f4265a;
            iArr[i2] = i10;
        }
    }
}

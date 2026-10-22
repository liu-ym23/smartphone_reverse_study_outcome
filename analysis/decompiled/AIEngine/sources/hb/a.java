package hb;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public double[] f9383a = new double[16];

    /* renamed from: b, reason: collision with root package name */
    public int f9384b = -1;

    /* renamed from: c, reason: collision with root package name */
    public int f9385c = -1;

    public static double b(a aVar) {
        double d8;
        int i10 = aVar.f9385c;
        int i11 = aVar.f9384b;
        int i12 = i10 - i11;
        int i13 = i12 + 1;
        int i14 = 1;
        if (i13 < 1) {
            aVar.getClass();
            throw new IllegalArgumentException("inclusionCount cannot be less than 1.");
        }
        if (i13 > (i10 - i11) + 1) {
            throw new IllegalArgumentException("inclusionCount cannot be greater than the inserted value count.");
        }
        double d10 = 0.0d;
        if (1 <= i13) {
            d8 = 0.0d;
            while (true) {
                d8 += i14;
                if (i14 == i13) {
                    break;
                }
                i14++;
            }
        } else {
            d8 = 0.0d;
        }
        int i15 = aVar.f9385c;
        int i16 = i15 - i12;
        if (i16 <= i15) {
            while (true) {
                d10 += (i13 / d8) * aVar.f9383a[i15];
                i13--;
                if (i15 == i16) {
                    break;
                }
                i15--;
            }
        }
        return d10;
    }

    public final void a(double d8) {
        int i10 = this.f9385c;
        int i11 = this.f9384b;
        if ((i10 - i11) + 1 == 5) {
            this.f9384b = i11 + 1;
        }
        double[] dArr = this.f9383a;
        if (i10 == dArr.length - 1) {
            double[] dArr2 = new double[dArr.length * 2];
            int i12 = this.f9384b;
            int i13 = i10 - i12;
            System.arraycopy(dArr, i12, dArr2, 0, i13 + 1);
            this.f9383a = dArr2;
            this.f9384b = 0;
            this.f9385c = i13;
        }
        int i14 = this.f9385c + 1;
        this.f9385c = i14;
        if (i14 == 0) {
            this.f9384b = 0;
        }
        this.f9383a[i14] = d8;
    }
}

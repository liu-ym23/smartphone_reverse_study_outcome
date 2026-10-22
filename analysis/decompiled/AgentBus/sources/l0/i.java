package l0;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public int f5753a;

    /* renamed from: b, reason: collision with root package name */
    public int f5754b;

    /* renamed from: c, reason: collision with root package name */
    public Object f5755c;

    /* renamed from: d, reason: collision with root package name */
    public Object f5756d;

    /* renamed from: e, reason: collision with root package name */
    public Object f5757e;

    public int a(long j2) {
        int i2 = this.f5753a + 1;
        long[] jArr = (long[]) this.f5755c;
        int length = jArr.length;
        if (i2 > length) {
            int i10 = length * 2;
            long[] jArr2 = new long[i10];
            int[] iArr = new int[i10];
            d7.n.X(jArr, jArr2, 0, 0, jArr.length);
            d7.n.Z((int[]) this.f5756d, iArr, 0, 0, 14);
            this.f5755c = jArr2;
            this.f5756d = iArr;
        }
        int i11 = this.f5753a;
        this.f5753a = i11 + 1;
        int length2 = ((int[]) this.f5757e).length;
        if (this.f5754b >= length2) {
            int i12 = length2 * 2;
            int[] iArr2 = new int[i12];
            int i13 = 0;
            while (i13 < i12) {
                int i14 = i13 + 1;
                iArr2[i13] = i14;
                i13 = i14;
            }
            d7.n.Z((int[]) this.f5757e, iArr2, 0, 0, 14);
            this.f5757e = iArr2;
        }
        int i15 = this.f5754b;
        int[] iArr3 = (int[]) this.f5757e;
        this.f5754b = iArr3[i15];
        long[] jArr3 = (long[]) this.f5755c;
        jArr3[i11] = j2;
        ((int[]) this.f5756d)[i11] = i15;
        iArr3[i15] = i11;
        while (i11 > 0) {
            int i16 = ((i11 + 1) >> 1) - 1;
            if (q7.k.g(jArr3[i16], j2) <= 0) {
                break;
            }
            c(i16, i11);
            i11 = i16;
        }
        return i15;
    }

    public void b(int i2) {
        int i10 = this.f5754b;
        boolean z4 = false;
        if (i2 >= 0 && i2 < i10) {
            z4 = true;
        }
        if (z4) {
            return;
        }
        x1.a.a("lineIndex(" + i2 + ") is out of bounds [0, " + i10 + ')');
    }

    public void c(int i2, int i10) {
        long[] jArr = (long[]) this.f5755c;
        int[] iArr = (int[]) this.f5756d;
        int[] iArr2 = (int[]) this.f5757e;
        long j2 = jArr[i2];
        jArr[i2] = jArr[i10];
        jArr[i10] = j2;
        int i11 = iArr[i2];
        int i12 = iArr[i10];
        iArr[i2] = i12;
        iArr[i10] = i11;
        iArr2[i12] = i2;
        iArr2[i11] = i10;
    }
}

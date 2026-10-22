package p7;

/* loaded from: classes.dex */
public final class e extends d0 {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f4779e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f4780f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ long[] f4781g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int[] f4782h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ f f4783i;

    public e(f fVar, int i8, int i9, long[] jArr, int[] iArr) {
        this.f4779e = i8;
        this.f4780f = i9;
        this.f4781g = jArr;
        this.f4782h = iArr;
        this.f4783i = fVar;
    }

    @Override // p7.d0
    public final int f() {
        return this.f4779e;
    }

    @Override // p7.d0
    public final r k(int i8) {
        int i9 = this.f4780f;
        long[] jArr = new long[i9];
        long[] jArr2 = new long[i9];
        int i10 = 0;
        for (int i11 = 0; i11 < this.f4779e; i11++) {
            long j4 = ((i11 ^ i8) - 1) >> 31;
            for (int i12 = 0; i12 < i9; i12++) {
                long j8 = jArr[i12];
                long[] jArr3 = this.f4781g;
                jArr[i12] = j8 ^ (jArr3[i10 + i12] & j4);
                jArr2[i12] = jArr2[i12] ^ (jArr3[(i10 + i9) + i12] & j4);
            }
            i10 += i9 * 2;
        }
        return r(jArr, jArr2);
    }

    @Override // p7.d0
    public final r l(int i8) {
        int i9 = this.f4780f;
        long[] jArr = new long[i9];
        long[] jArr2 = new long[i9];
        int i10 = i8 * i9 * 2;
        for (int i11 = 0; i11 < i9; i11++) {
            long[] jArr3 = this.f4781g;
            jArr[i11] = jArr3[i10 + i11];
            jArr2[i11] = jArr3[i10 + i9 + i11];
        }
        return r(jArr, jArr2);
    }

    public final p r(long[] jArr, long[] jArr2) {
        f fVar = this.f4783i;
        int i8 = fVar.f4786j;
        v vVar = new v(jArr);
        int[] iArr = this.f4782h;
        return new p(fVar, new k(i8, iArr, vVar), new k(i8, iArr, new v(jArr2)), 0);
    }
}

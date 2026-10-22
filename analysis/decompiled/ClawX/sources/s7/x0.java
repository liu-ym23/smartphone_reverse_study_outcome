package s7;

/* loaded from: classes.dex */
public final class x0 extends p7.d0 {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f5375e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f5376f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ long[] f5377g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ p7.c f5378h;

    public /* synthetic */ x0(p7.c cVar, int i8, long[] jArr, int i9) {
        this.f5375e = i9;
        this.f5376f = i8;
        this.f5377g = jArr;
        this.f5378h = cVar;
    }

    @Override // p7.d0
    public final int f() {
        switch (this.f5375e) {
        }
        return this.f5376f;
    }

    @Override // p7.d0
    public final p7.r k(int i8) {
        switch (this.f5375e) {
            case 0:
                long[] jArr = new long[9];
                long[] jArr2 = new long[9];
                int i9 = 0;
                for (int i10 = 0; i10 < this.f5376f; i10++) {
                    long j4 = ((i10 ^ i8) - 1) >> 31;
                    for (int i11 = 0; i11 < 9; i11++) {
                        long j8 = jArr[i11];
                        long[] jArr3 = this.f5377g;
                        jArr[i11] = j8 ^ (jArr3[i9 + i11] & j4);
                        jArr2[i11] = jArr2[i11] ^ (jArr3[(i9 + 9) + i11] & j4);
                    }
                    i9 += 18;
                }
                return new p7.p((y0) this.f5378h, new w0(jArr), new w0(jArr2), y0.f5380k, 17);
            default:
                long[] jArr4 = new long[9];
                long[] jArr5 = new long[9];
                int i12 = 0;
                for (int i13 = 0; i13 < this.f5376f; i13++) {
                    long j9 = ((i13 ^ i8) - 1) >> 31;
                    for (int i14 = 0; i14 < 9; i14++) {
                        long j10 = jArr4[i14];
                        long[] jArr6 = this.f5377g;
                        jArr4[i14] = j10 ^ (jArr6[i12 + i14] & j9);
                        jArr5[i14] = jArr5[i14] ^ (jArr6[(i12 + 9) + i14] & j9);
                    }
                    i12 += 18;
                }
                return new p7.p((z0) this.f5378h, new w0(jArr4), new w0(jArr5), z0.f5384k, 18);
        }
    }

    @Override // p7.d0
    public final p7.r l(int i8) {
        switch (this.f5375e) {
            case 0:
                long[] jArr = new long[9];
                long[] jArr2 = new long[9];
                int i9 = i8 * 18;
                for (int i10 = 0; i10 < 9; i10++) {
                    long[] jArr3 = this.f5377g;
                    jArr[i10] = jArr3[i9 + i10];
                    jArr2[i10] = jArr3[i9 + 9 + i10];
                }
                return new p7.p((y0) this.f5378h, new w0(jArr), new w0(jArr2), y0.f5380k, 17);
            default:
                long[] jArr4 = new long[9];
                long[] jArr5 = new long[9];
                int i11 = i8 * 18;
                for (int i12 = 0; i12 < 9; i12++) {
                    long[] jArr6 = this.f5377g;
                    jArr4[i12] = jArr6[i11 + i12];
                    jArr5[i12] = jArr6[i11 + 9 + i12];
                }
                return new p7.p((z0) this.f5378h, new w0(jArr4), new w0(jArr5), z0.f5384k, 18);
        }
    }
}

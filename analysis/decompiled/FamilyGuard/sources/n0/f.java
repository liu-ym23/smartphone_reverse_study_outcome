package n0;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    int f18876a;

    /* renamed from: b, reason: collision with root package name */
    int f18877b;

    /* renamed from: c, reason: collision with root package name */
    private int f18878c;

    /* renamed from: d, reason: collision with root package name */
    private int[] f18879d;

    private void a(int i5, int i6, int i7) {
        if (this.f18879d == null) {
            this.f18879d = new int[6];
        }
        int i8 = this.f18878c;
        int[] iArr = this.f18879d;
        if (i8 >= iArr.length) {
            int[] iArr2 = new int[iArr.length + 6];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.f18879d = iArr2;
        }
        int[] iArr3 = this.f18879d;
        int i9 = this.f18878c;
        int i10 = i9 + 1;
        this.f18878c = i10;
        iArr3[i9] = i5;
        this.f18878c = i9 + 2;
        iArr3[i10] = i6 | i7;
    }

    void b(i iVar, C0871a c0871a, int i5, boolean z5) {
        if ((this.f18876a & 2) != 0) {
            if (z5) {
                c0871a.f(this.f18877b - i5);
                return;
            } else {
                c0871a.g(this.f18877b - i5);
                return;
            }
        }
        if (z5) {
            a(i5, c0871a.f18838b, 536870912);
            c0871a.f(-1);
        } else {
            a(i5, c0871a.f18838b, 268435456);
            c0871a.g(-1);
        }
    }

    void c(i iVar, int i5, byte[] bArr) {
        this.f18876a |= 2;
        this.f18877b = i5;
        int i6 = 0;
        while (i6 < this.f18878c) {
            int[] iArr = this.f18879d;
            int i7 = i6 + 1;
            int i8 = iArr[i6];
            i6 += 2;
            int i9 = iArr[i7];
            int i10 = 268435455 & i9;
            int i11 = i5 - i8;
            if ((i9 & (-268435456)) == 268435456) {
                bArr[i10] = (byte) (i11 >>> 8);
                bArr[i10 + 1] = (byte) i11;
            } else {
                bArr[i10] = (byte) (i11 >>> 24);
                bArr[i10 + 1] = (byte) (i11 >>> 16);
                bArr[i10 + 2] = (byte) (i11 >>> 8);
                bArr[i10 + 3] = (byte) i11;
            }
        }
    }
}

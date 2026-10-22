package p7;

import java.math.BigInteger;

/* loaded from: classes.dex */
public final class b extends d0 {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f4765e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f4766f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ byte[] f4767g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ h f4768h;

    public b(h hVar, int i8, int i9, byte[] bArr) {
        this.f4765e = i8;
        this.f4766f = i9;
        this.f4767g = bArr;
        this.f4768h = hVar;
    }

    @Override // p7.d0
    public final int f() {
        return this.f4765e;
    }

    @Override // p7.d0
    public final r k(int i8) {
        int i9 = this.f4766f;
        byte[] bArr = new byte[i9];
        byte[] bArr2 = new byte[i9];
        int i10 = 0;
        for (int i11 = 0; i11 < this.f4765e; i11++) {
            int i12 = ((i11 ^ i8) - 1) >> 31;
            for (int i13 = 0; i13 < i9; i13++) {
                byte b9 = bArr[i13];
                byte[] bArr3 = this.f4767g;
                bArr[i13] = (byte) (b9 ^ (bArr3[i10 + i13] & i12));
                bArr2[i13] = (byte) (bArr2[i13] ^ (bArr3[(i10 + i9) + i13] & i12));
            }
            i10 += i9 * 2;
        }
        BigInteger bigInteger = new BigInteger(1, bArr);
        h hVar = this.f4768h;
        return hVar.e(hVar.j(bigInteger), hVar.j(new BigInteger(1, bArr2)));
    }

    @Override // p7.d0
    public final r l(int i8) {
        int i9 = this.f4766f;
        byte[] bArr = new byte[i9];
        byte[] bArr2 = new byte[i9];
        int i10 = i8 * i9 * 2;
        for (int i11 = 0; i11 < i9; i11++) {
            byte[] bArr3 = this.f4767g;
            bArr[i11] = bArr3[i10 + i11];
            bArr2[i11] = bArr3[i10 + i9 + i11];
        }
        BigInteger bigInteger = new BigInteger(1, bArr);
        h hVar = this.f4768h;
        return hVar.e(hVar.j(bigInteger), hVar.j(new BigInteger(1, bArr2)));
    }
}

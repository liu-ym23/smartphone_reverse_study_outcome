package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.io.IOException;
import java.nio.charset.Charset;

/* loaded from: classes2.dex */
class zzde extends zzdd {

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f20158c;

    public zzde(byte[] bArr) {
        super(null);
        bArr.getClass();
        this.f20158c = bArr;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdd
    public final boolean K(zzdf zzdfVar, int i10, int i11) {
        if (i11 > zzdfVar.f()) {
            throw new IllegalArgumentException("Length too large: " + i11 + f());
        }
        int i12 = i10 + i11;
        if (i12 > zzdfVar.f()) {
            throw new IllegalArgumentException("Ran off end of other: " + i10 + ", " + i11 + ", " + zzdfVar.f());
        }
        if (!(zzdfVar instanceof zzde)) {
            return zzdfVar.n(i10, i12).equals(n(0, i11));
        }
        zzde zzdeVar = (zzde) zzdfVar;
        byte[] bArr = this.f20158c;
        byte[] bArr2 = zzdeVar.f20158c;
        int iL = L() + i11;
        int iL2 = L();
        int iL3 = zzdeVar.L() + i10;
        while (iL2 < iL) {
            if (bArr[iL2] != bArr2[iL3]) {
                return false;
            }
            iL2++;
            iL3++;
        }
        return true;
    }

    public int L() {
        return 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public byte b(int i10) {
        return this.f20158c[i10];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public byte c(int i10) {
        return this.f20158c[i10];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdf) || f() != ((zzdf) obj).f()) {
            return false;
        }
        if (f() == 0) {
            return true;
        }
        if (!(obj instanceof zzde)) {
            return obj.equals(this);
        }
        zzde zzdeVar = (zzde) obj;
        int iY = y();
        int iY2 = zzdeVar.y();
        if (iY == 0 || iY2 == 0 || iY == iY2) {
            return K(zzdeVar, 0, f());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public int f() {
        return this.f20158c.length;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public void i(byte[] bArr, int i10, int i11, int i12) {
        System.arraycopy(this.f20158c, i10, bArr, i11, i12);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final int l(int i10, int i11, int i12) {
        return N0.b(i10, this.f20158c, L() + i11, i12);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final int m(int i10, int i11, int i12) {
        int iL = L() + i11;
        return Y1.f(i10, this.f20158c, iL, i12 + iL);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final zzdf n(int i10, int i11) {
        int iX = zzdf.x(i10, i11, f());
        return iX == 0 ? zzdf.f20159b : new zzda(this.f20158c, L() + i10, iX);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final String t(Charset charset) {
        return new String(this.f20158c, L(), f(), charset);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final void u(C1686a0 c1686a0) throws IOException {
        ((C1731k0) c1686a0).D(this.f20158c, L(), f());
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final boolean v() {
        int iL = L();
        return Y1.g(this.f20158c, iL, f() + iL);
    }
}

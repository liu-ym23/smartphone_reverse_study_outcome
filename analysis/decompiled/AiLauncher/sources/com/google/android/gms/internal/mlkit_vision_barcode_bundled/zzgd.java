package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Iterator;

/* loaded from: classes2.dex */
final class zzgd extends zzdf {

    /* renamed from: h, reason: collision with root package name */
    public static final int[] f20163h = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};

    /* renamed from: c, reason: collision with root package name */
    public final int f20164c;

    /* renamed from: d, reason: collision with root package name */
    public final zzdf f20165d;

    /* renamed from: e, reason: collision with root package name */
    public final zzdf f20166e;

    /* renamed from: f, reason: collision with root package name */
    public final int f20167f;

    /* renamed from: g, reason: collision with root package name */
    public final int f20168g;

    public static int K(int i10) {
        int[] iArr = f20163h;
        int length = iArr.length;
        if (i10 >= 47) {
            return Integer.MAX_VALUE;
        }
        return iArr[i10];
    }

    public static zzdf O(zzdf zzdfVar, zzdf zzdfVar2) {
        if (zzdfVar2.f() == 0) {
            return zzdfVar;
        }
        if (zzdfVar.f() == 0) {
            return zzdfVar2;
        }
        int iF = zzdfVar.f() + zzdfVar2.f();
        if (iF < 128) {
            return P(zzdfVar, zzdfVar2);
        }
        if (zzdfVar instanceof zzgd) {
            zzgd zzgdVar = (zzgd) zzdfVar;
            if (zzgdVar.f20166e.f() + zzdfVar2.f() < 128) {
                return new zzgd(zzgdVar.f20165d, P(zzgdVar.f20166e, zzdfVar2));
            }
            if (zzgdVar.f20165d.j() > zzgdVar.f20166e.j() && zzgdVar.f20168g > zzdfVar2.j()) {
                return new zzgd(zzgdVar.f20165d, new zzgd(zzgdVar.f20166e, zzdfVar2));
            }
        }
        return iF >= K(Math.max(zzdfVar.j(), zzdfVar2.j()) + 1) ? new zzgd(zzdfVar, zzdfVar2) : C1771u1.a(new C1771u1(null), zzdfVar, zzdfVar2);
    }

    public static zzdf P(zzdf zzdfVar, zzdf zzdfVar2) {
        int iF = zzdfVar.f();
        int iF2 = zzdfVar2.f();
        byte[] bArr = new byte[iF + iF2];
        zzdfVar.H(bArr, 0, 0, iF);
        zzdfVar2.H(bArr, 0, iF, iF2);
        return new zzde(bArr);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final byte b(int i10) {
        zzdf.G(i10, this.f20164c);
        return c(i10);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final byte c(int i10) {
        int i11 = this.f20167f;
        return i10 < i11 ? this.f20165d.c(i10) : this.f20166e.c(i10 - i11);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdf)) {
            return false;
        }
        zzdf zzdfVar = (zzdf) obj;
        if (this.f20164c != zzdfVar.f()) {
            return false;
        }
        if (this.f20164c == 0) {
            return true;
        }
        int iY = y();
        int iY2 = zzdfVar.y();
        if (iY != 0 && iY2 != 0 && iY != iY2) {
            return false;
        }
        C1779w1 c1779w1 = null;
        C1783x1 c1783x1 = new C1783x1(this, c1779w1);
        zzdd zzddVarA = c1783x1.next();
        C1783x1 c1783x12 = new C1783x1(zzdfVar, c1779w1);
        zzdd zzddVarA2 = c1783x12.next();
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            int iF = zzddVarA.f() - i10;
            int iF2 = zzddVarA2.f() - i11;
            int iMin = Math.min(iF, iF2);
            if (!(i10 == 0 ? zzddVarA.K(zzddVarA2, i11, iMin) : zzddVarA2.K(zzddVarA, i10, iMin))) {
                return false;
            }
            i12 += iMin;
            int i13 = this.f20164c;
            if (i12 >= i13) {
                if (i12 == i13) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (iMin == iF) {
                zzddVarA = c1783x1.next();
                i10 = 0;
            } else {
                i10 += iMin;
                zzddVarA = zzddVarA;
            }
            if (iMin == iF2) {
                zzddVarA2 = c1783x12.next();
                i11 = 0;
            } else {
                i11 += iMin;
            }
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final int f() {
        return this.f20164c;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final void i(byte[] bArr, int i10, int i11, int i12) {
        int i13 = i10 + i12;
        int i14 = this.f20167f;
        if (i13 <= i14) {
            this.f20165d.i(bArr, i10, i11, i12);
        } else {
            if (i10 >= i14) {
                this.f20166e.i(bArr, i10 - i14, i11, i12);
                return;
            }
            int i15 = i14 - i10;
            this.f20165d.i(bArr, i10, i11, i15);
            this.f20166e.i(bArr, 0, i11 + i15, i12 - i15);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new C1763s1(this);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final int j() {
        return this.f20168g;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final boolean k() {
        return this.f20164c >= K(this.f20168g);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final int l(int i10, int i11, int i12) {
        int i13 = i11 + i12;
        int i14 = this.f20167f;
        if (i13 <= i14) {
            return this.f20165d.l(i10, i11, i12);
        }
        if (i11 >= i14) {
            return this.f20166e.l(i10, i11 - i14, i12);
        }
        int i15 = i14 - i11;
        return this.f20166e.l(this.f20165d.l(i10, i11, i15), 0, i12 - i15);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final int m(int i10, int i11, int i12) {
        int i13 = i11 + i12;
        int i14 = this.f20167f;
        if (i13 <= i14) {
            return this.f20165d.m(i10, i11, i12);
        }
        if (i11 >= i14) {
            return this.f20166e.m(i10, i11 - i14, i12);
        }
        int i15 = i14 - i11;
        return this.f20166e.m(this.f20165d.m(i10, i11, i15), 0, i12 - i15);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final zzdf n(int i10, int i11) {
        int iX = zzdf.x(i10, i11, this.f20164c);
        if (iX == 0) {
            return zzdf.f20159b;
        }
        if (iX == this.f20164c) {
            return this;
        }
        int i12 = this.f20167f;
        if (i11 <= i12) {
            return this.f20165d.n(i10, i11);
        }
        if (i10 >= i12) {
            return this.f20166e.n(i10 - i12, i11 - i12);
        }
        zzdf zzdfVar = this.f20165d;
        return new zzgd(zzdfVar.n(i10, zzdfVar.f()), this.f20166e.n(0, i11 - this.f20167f));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final String t(Charset charset) {
        return new String(J(), charset);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final void u(C1686a0 c1686a0) throws IOException {
        this.f20165d.u(c1686a0);
        this.f20166e.u(c1686a0);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    public final boolean v() {
        zzdf zzdfVar = this.f20165d;
        zzdf zzdfVar2 = this.f20166e;
        return zzdfVar2.m(zzdfVar.m(0, 0, this.f20167f), 0, zzdfVar2.f()) == 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
    /* renamed from: z */
    public final InterfaceC1706e0 iterator() {
        return new C1763s1(this);
    }

    public zzgd(zzdf zzdfVar, zzdf zzdfVar2) {
        this.f20165d = zzdfVar;
        this.f20166e = zzdfVar2;
        int iF = zzdfVar.f();
        this.f20167f = iF;
        this.f20164c = iF + zzdfVar2.f();
        this.f20168g = Math.max(zzdfVar.j(), zzdfVar2.j()) + 1;
    }
}

package L4;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class v extends h {

    /* renamed from: f, reason: collision with root package name */
    private final transient byte[][] f3984f;

    /* renamed from: g, reason: collision with root package name */
    private final transient int[] f3985g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(e eVar, int i5) {
        super(h.f3942d.j());
        j4.k.h(eVar, "buffer");
        c.b(eVar.size(), 0L, i5);
        t tVar = eVar.f3938a;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i7 < i5) {
            if (tVar == null) {
                j4.k.p();
            }
            int i9 = tVar.f3976c;
            int i10 = tVar.f3975b;
            if (i9 == i10) {
                throw new AssertionError("s.limit == s.pos");
            }
            i7 += i9 - i10;
            i8++;
            tVar = tVar.f3979f;
        }
        byte[][] bArr = new byte[i8][];
        this.f3985g = new int[i8 * 2];
        t tVar2 = eVar.f3938a;
        int i11 = 0;
        while (i6 < i5) {
            if (tVar2 == null) {
                j4.k.p();
            }
            bArr[i11] = tVar2.f3974a;
            int i12 = tVar2.f3976c;
            int i13 = tVar2.f3975b;
            i6 += i12 - i13;
            if (i6 > i5) {
                i6 = i5;
            }
            int[] iArr = this.f3985g;
            iArr[i11] = i6;
            iArr[i11 + i8] = i13;
            tVar2.f3977d = true;
            i11++;
            tVar2 = tVar2.f3979f;
        }
        this.f3984f = bArr;
    }

    private final int F(int i5) {
        int iBinarySearch = Arrays.binarySearch(this.f3985g, 0, this.f3984f.length, i5 + 1);
        return iBinarySearch >= 0 ? iBinarySearch : ~iBinarySearch;
    }

    private final h G() {
        return new h(z());
    }

    @Override // L4.h
    public String C() {
        return G().C();
    }

    @Override // L4.h
    public void E(e eVar) {
        j4.k.h(eVar, "buffer");
        int length = this.f3984f.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            int[] iArr = this.f3985g;
            int i7 = iArr[length + i5];
            int i8 = iArr[i5];
            t tVar = new t(this.f3984f[i5], i7, (i7 + i8) - i6, true, false);
            t tVar2 = eVar.f3938a;
            if (tVar2 == null) {
                tVar.f3980g = tVar;
                tVar.f3979f = tVar;
                eVar.f3938a = tVar;
            } else {
                if (tVar2 == null) {
                    j4.k.p();
                }
                t tVar3 = tVar2.f3980g;
                if (tVar3 == null) {
                    j4.k.p();
                }
                tVar3.c(tVar);
            }
            i5++;
            i6 = i8;
        }
        eVar.W(eVar.size() + i6);
    }

    @Override // L4.h
    public String b() {
        return G().b();
    }

    @Override // L4.h
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (hVar.w() == w() && q(0, hVar, 0, w())) {
                return true;
            }
        }
        return false;
    }

    @Override // L4.h
    public int hashCode() {
        int iK = k();
        if (iK != 0) {
            return iK;
        }
        int length = this.f3984f.length;
        int i5 = 0;
        int i6 = 1;
        int i7 = 0;
        while (i5 < length) {
            byte[] bArr = this.f3984f[i5];
            int[] iArr = this.f3985g;
            int i8 = iArr[length + i5];
            int i9 = iArr[i5];
            int i10 = (i9 - i7) + i8;
            while (i8 < i10) {
                i6 = (i6 * 31) + bArr[i8];
                i8++;
            }
            i5++;
            i7 = i9;
        }
        s(i6);
        return i6;
    }

    @Override // L4.h
    public int l() {
        return this.f3985g[this.f3984f.length - 1];
    }

    @Override // L4.h
    public String n() {
        return G().n();
    }

    @Override // L4.h
    public byte o(int i5) {
        c.b(this.f3985g[this.f3984f.length - 1], i5, 1L);
        int iF = F(i5);
        int i6 = iF == 0 ? 0 : this.f3985g[iF - 1];
        int[] iArr = this.f3985g;
        byte[][] bArr = this.f3984f;
        return bArr[iF][(i5 - i6) + iArr[bArr.length + iF]];
    }

    @Override // L4.h
    public boolean q(int i5, h hVar, int i6, int i7) {
        j4.k.h(hVar, "other");
        if (i5 < 0 || i5 > w() - i7) {
            return false;
        }
        int iF = F(i5);
        while (i7 > 0) {
            int i8 = iF == 0 ? 0 : this.f3985g[iF - 1];
            int iMin = Math.min(i7, ((this.f3985g[iF] - i8) + i8) - i5);
            int[] iArr = this.f3985g;
            byte[][] bArr = this.f3984f;
            if (!hVar.r(i6, bArr[iF], (i5 - i8) + iArr[bArr.length + iF], iMin)) {
                return false;
            }
            i5 += iMin;
            i6 += iMin;
            i7 -= iMin;
            iF++;
        }
        return true;
    }

    @Override // L4.h
    public boolean r(int i5, byte[] bArr, int i6, int i7) {
        j4.k.h(bArr, "other");
        if (i5 < 0 || i5 > w() - i7 || i6 < 0 || i6 > bArr.length - i7) {
            return false;
        }
        int iF = F(i5);
        while (i7 > 0) {
            int i8 = iF == 0 ? 0 : this.f3985g[iF - 1];
            int iMin = Math.min(i7, ((this.f3985g[iF] - i8) + i8) - i5);
            int[] iArr = this.f3985g;
            byte[][] bArr2 = this.f3984f;
            if (!c.a(bArr2[iF], (i5 - i8) + iArr[bArr2.length + iF], bArr, i6, iMin)) {
                return false;
            }
            i5 += iMin;
            i6 += iMin;
            i7 -= iMin;
            iF++;
        }
        return true;
    }

    @Override // L4.h
    public String toString() {
        return G().toString();
    }

    @Override // L4.h
    public h u() {
        return G().u();
    }

    @Override // L4.h
    public h v() {
        return G().v();
    }

    @Override // L4.h
    public h y() {
        return G().y();
    }

    @Override // L4.h
    public byte[] z() {
        int[] iArr = this.f3985g;
        byte[][] bArr = this.f3984f;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            int[] iArr2 = this.f3985g;
            int i7 = iArr2[length + i5];
            int i8 = iArr2[i5];
            b.a(this.f3984f[i5], i7, bArr2, i6, i8 - i6);
            i5++;
            i6 = i8;
        }
        return bArr2;
    }
}

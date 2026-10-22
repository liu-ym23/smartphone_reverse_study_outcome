package p7;

import java.math.BigInteger;
import org.bouncycastle.util.Arrays;

/* loaded from: classes.dex */
public final class k extends i {

    /* renamed from: g, reason: collision with root package name */
    public final int f4804g;

    /* renamed from: h, reason: collision with root package name */
    public final int f4805h;

    /* renamed from: i, reason: collision with root package name */
    public final int[] f4806i;

    /* renamed from: j, reason: collision with root package name */
    public final v f4807j;

    public k(int i8, int[] iArr, v vVar) {
        this.f4805h = i8;
        this.f4804g = iArr.length == 1 ? 2 : 3;
        this.f4806i = iArr;
        this.f4807j = vVar;
    }

    @Override // p7.m
    public final m a(m mVar) {
        v vVar = (v) this.f4807j.clone();
        vVar.c(((k) mVar).f4807j);
        return new k(this.f4805h, this.f4806i, vVar);
    }

    @Override // p7.m
    public final m b() {
        v vVar;
        v vVar2 = this.f4807j;
        if (vVar2.f4829a.length == 0) {
            vVar = new v(new long[]{1});
        } else {
            int iMax = Math.max(1, vVar2.k());
            long[] jArr = new long[iMax];
            long[] jArr2 = vVar2.f4829a;
            System.arraycopy(jArr2, 0, jArr, 0, Math.min(jArr2.length, iMax));
            jArr[0] = jArr[0] ^ 1;
            vVar = new v(jArr);
        }
        return new k(this.f4805h, this.f4806i, vVar);
    }

    @Override // p7.m
    public final int c() {
        return this.f4807j.f();
    }

    @Override // p7.m
    public final m d(m mVar) {
        return j(mVar.g());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f4805h == kVar.f4805h && this.f4804g == kVar.f4804g && Arrays.areEqual(this.f4806i, kVar.f4806i) && this.f4807j.equals(kVar.f4807j);
    }

    @Override // p7.m
    public final int f() {
        return this.f4805h;
    }

    @Override // p7.m
    public final m g() {
        int i8;
        v vVar = this.f4807j;
        int iF = vVar.f();
        if (iF == 0) {
            throw new IllegalStateException();
        }
        int i9 = this.f4805h;
        int[] iArr = this.f4806i;
        int i10 = 1;
        if (iF != 1) {
            v vVar2 = (v) vVar.clone();
            int i11 = (i9 + 63) >>> 6;
            v vVar3 = new v(i11);
            long[] jArr = vVar3.f4829a;
            v.h(jArr, i9);
            int length = iArr.length;
            while (true) {
                length--;
                if (length < 0) {
                    break;
                }
                v.h(jArr, iArr[length]);
            }
            int iG = 0;
            v.h(jArr, 0);
            v vVar4 = new v(i11);
            vVar4.f4829a[0] = 1;
            v vVar5 = new v(i11);
            int[] iArr2 = new int[2];
            iArr2[0] = iF;
            iArr2[1] = i9 + 1;
            v[] vVarArr = {vVar2, vVar3};
            int[] iArr3 = new int[2];
            iArr3[0] = 1;
            iArr3[1] = 0;
            v[] vVarArr2 = {vVar4, vVar5};
            int i12 = iArr2[1];
            int i13 = i12 - iArr2[0];
            while (true) {
                if (i13 < 0) {
                    i13 = -i13;
                    iArr2[i10] = i12;
                    iArr3[i10] = iG;
                    i10 = 1 - i10;
                    i12 = iArr2[i10];
                    iG = iArr3[i10];
                }
                i8 = 1 - i10;
                vVarArr[i10].b(vVarArr[i8], iArr2[i8], i13);
                int iG2 = vVarArr[i10].g(i12);
                if (iG2 == 0) {
                    break;
                }
                int i14 = iArr3[i8];
                vVarArr2[i10].b(vVarArr2[i8], i14, i13);
                int i15 = i14 + i13;
                if (i15 > iG) {
                    iG = i15;
                } else if (i15 == iG) {
                    iG = vVarArr2[i10].g(iG);
                }
                i13 += iG2 - i12;
                i12 = iG2;
            }
            vVar = vVarArr2[i8];
        }
        return new k(i9, iArr, vVar);
    }

    @Override // p7.m
    public final boolean h() {
        return this.f4807j.m();
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f4806i) ^ (this.f4807j.hashCode() ^ this.f4805h);
    }

    @Override // p7.m
    public final boolean i() {
        for (long j4 : this.f4807j.f4829a) {
            if (j4 != 0) {
                return false;
            }
        }
        return true;
    }

    @Override // p7.m
    public final m j(m mVar) {
        int i8;
        long[] jArr;
        int i9;
        v vVar = ((k) mVar).f4807j;
        v vVar2 = this.f4807j;
        int iF = vVar2.f();
        int i10 = this.f4805h;
        int[] iArr = this.f4806i;
        if (iF != 0) {
            int iF2 = vVar.f();
            if (iF2 != 0) {
                if (iF > iF2) {
                    vVar2 = vVar;
                    vVar = vVar2;
                    iF2 = iF;
                    iF = iF2;
                }
                int i11 = (iF + 63) >>> 6;
                int i12 = (iF2 + 63) >>> 6;
                int i13 = ((iF + iF2) + 62) >>> 6;
                if (i11 == 1) {
                    long j4 = vVar2.f4829a[0];
                    if (j4 != 1) {
                        long[] jArr2 = new long[i13];
                        v.o(j4, vVar.f4829a, i12, jArr2);
                        vVar2 = new v(jArr2, v.p(jArr2, i13, i10, iArr));
                        vVar = vVar2;
                    }
                    i8 = i10;
                } else {
                    int i14 = (iF2 + 70) >>> 6;
                    int[] iArr2 = new int[16];
                    int i15 = i14 << 4;
                    long[] jArr3 = new long[i15];
                    iArr2[1] = i14;
                    System.arraycopy(vVar.f4829a, 0, jArr3, i14, i12);
                    int i16 = 2;
                    int i17 = i14;
                    while (i16 < 16) {
                        int i18 = i17 + i14;
                        iArr2[i16] = i18;
                        if ((i16 & 1) == 0) {
                            v.q(jArr3, i18 >>> 1, jArr3, i18, i14, 1);
                        } else {
                            int i19 = i18 - i14;
                            for (int i20 = 0; i20 < i14; i20++) {
                                jArr3[i18 + i20] = jArr3[i14 + i20] ^ jArr3[i19 + i20];
                            }
                        }
                        i16++;
                        i17 = i18;
                    }
                    long[] jArr4 = new long[i15];
                    v.q(jArr3, 0, jArr4, 0, i15, 4);
                    long[] jArr5 = vVar2.f4829a;
                    int i21 = i13 << 3;
                    long[] jArr6 = new long[i21];
                    int i22 = 0;
                    while (i22 < i11) {
                        int i23 = i10;
                        int i24 = i22;
                        long j8 = jArr5[i22];
                        while (true) {
                            jArr = jArr5;
                            i9 = i21;
                            int i25 = iArr2[((int) j8) & 15];
                            int i26 = iArr2[((int) (j8 >>> 4)) & 15];
                            for (int i27 = 0; i27 < i14; i27++) {
                                int i28 = i24 + i27;
                                jArr6[i28] = jArr6[i28] ^ (jArr3[i25 + i27] ^ jArr4[i26 + i27]);
                            }
                            j8 >>>= 8;
                            if (j8 == 0) {
                                break;
                            }
                            i24 += i13;
                            i21 = i9;
                            jArr5 = jArr;
                        }
                        i22++;
                        i21 = i9;
                        i10 = i23;
                        jArr5 = jArr;
                    }
                    i8 = i10;
                    while (true) {
                        int i29 = i21 - i13;
                        if (i29 == 0) {
                            break;
                        }
                        v.d(jArr6, i29 - i13, jArr6, i29, i13, 8);
                        i21 = i29;
                    }
                    vVar = new v(jArr6, v.p(jArr6, i13, i8, iArr));
                }
            } else {
                i8 = i10;
            }
        } else {
            vVar = vVar2;
            i8 = i10;
        }
        return new k(i8, iArr, vVar);
    }

    @Override // p7.m
    public final m k(m mVar, m mVar2, m mVar3) {
        return l(mVar, mVar2, mVar3);
    }

    @Override // p7.m
    public final m l(m mVar, m mVar2, m mVar3) {
        v vVar = ((k) mVar).f4807j;
        v vVar2 = ((k) mVar2).f4807j;
        v vVar3 = ((k) mVar3).f4807j;
        v vVar4 = this.f4807j;
        v vVarN = vVar4.n(vVar);
        v vVarN2 = vVar2.n(vVar3);
        if (vVarN == vVar4 || vVarN == vVar) {
            vVarN = (v) vVarN.clone();
        }
        vVarN.c(vVarN2);
        long[] jArr = vVarN.f4829a;
        int length = jArr.length;
        int i8 = this.f4805h;
        int[] iArr = this.f4806i;
        int iP = v.p(jArr, length, i8, iArr);
        if (iP < jArr.length) {
            long[] jArr2 = new long[iP];
            vVarN.f4829a = jArr2;
            System.arraycopy(jArr, 0, jArr2, 0, iP);
        }
        return new k(i8, iArr, vVarN);
    }

    @Override // p7.m
    public final m n() {
        v vVar = this.f4807j;
        long[] jArr = vVar.f4829a;
        int i8 = 0;
        while (true) {
            if (i8 >= jArr.length) {
                break;
            }
            if (jArr[i8] == 0) {
                i8++;
            } else if (!vVar.m()) {
                return q(this.f4805h - 1);
            }
        }
        return this;
    }

    @Override // p7.m
    public final m o() {
        v vVar = this.f4807j;
        int iK = vVar.k();
        int i8 = this.f4805h;
        int[] iArr = this.f4806i;
        if (iK != 0) {
            int i9 = iK << 1;
            long[] jArr = new long[i9];
            int i10 = 0;
            while (i10 < i9) {
                long j4 = vVar.f4829a[i10 >>> 1];
                int i11 = i10 + 1;
                jArr[i10] = v.l((int) j4);
                i10 += 2;
                jArr[i11] = v.l((int) (j4 >>> 32));
            }
            vVar = new v(jArr, v.p(jArr, i9, i8, iArr));
        }
        return new k(i8, iArr, vVar);
    }

    @Override // p7.m
    public final m p(m mVar, m mVar2) {
        v vVar;
        v vVar2 = ((k) mVar).f4807j;
        v vVar3 = ((k) mVar2).f4807j;
        v vVar4 = this.f4807j;
        int iK = vVar4.k();
        if (iK == 0) {
            vVar = vVar4;
        } else {
            int i8 = iK << 1;
            long[] jArr = new long[i8];
            int i9 = 0;
            while (i9 < i8) {
                long j4 = vVar4.f4829a[i9 >>> 1];
                int i10 = i9 + 1;
                jArr[i9] = v.l((int) j4);
                i9 += 2;
                jArr[i10] = v.l((int) (j4 >>> 32));
            }
            vVar = new v(jArr, i8);
        }
        v vVarN = vVar2.n(vVar3);
        if (vVar == vVar4) {
            vVar = (v) vVar.clone();
        }
        vVar.c(vVarN);
        long[] jArr2 = vVar.f4829a;
        int length = jArr2.length;
        int i11 = this.f4805h;
        int[] iArr = this.f4806i;
        int iP = v.p(jArr2, length, i11, iArr);
        if (iP < jArr2.length) {
            long[] jArr3 = new long[iP];
            vVar.f4829a = jArr3;
            System.arraycopy(jArr2, 0, jArr3, 0, iP);
        }
        return new k(i11, iArr, vVar);
    }

    @Override // p7.m
    public final m q(int i8) {
        if (i8 < 1) {
            return this;
        }
        v vVar = this.f4807j;
        int iK = vVar.k();
        int i9 = this.f4805h;
        int[] iArr = this.f4806i;
        if (iK != 0) {
            int i10 = ((i9 + 63) >>> 6) << 1;
            long[] jArr = new long[i10];
            System.arraycopy(vVar.f4829a, 0, jArr, 0, iK);
            while (true) {
                i8--;
                if (i8 < 0) {
                    break;
                }
                int i11 = iK << 1;
                while (true) {
                    iK--;
                    if (iK >= 0) {
                        long j4 = jArr[iK];
                        jArr[i11 - 1] = v.l((int) (j4 >>> 32));
                        i11 -= 2;
                        jArr[i11] = v.l((int) j4);
                    }
                }
                iK = v.p(jArr, i10, i9, iArr);
            }
            vVar = new v(jArr, iK);
        }
        return new k(i9, iArr, vVar);
    }

    @Override // p7.m
    public final boolean s() {
        long[] jArr = this.f4807j.f4829a;
        return jArr.length > 0 && (jArr[0] & 1) != 0;
    }

    @Override // p7.m
    public final BigInteger t() {
        v vVar = this.f4807j;
        int iK = vVar.k();
        if (iK == 0) {
            return a.f4757a;
        }
        int i8 = iK - 1;
        long j4 = vVar.f4829a[i8];
        byte[] bArr = new byte[8];
        int i9 = 0;
        boolean z = false;
        for (int i10 = 7; i10 >= 0; i10--) {
            byte b9 = (byte) (j4 >>> (i10 * 8));
            if (z || b9 != 0) {
                bArr[i9] = b9;
                i9++;
                z = true;
            }
        }
        byte[] bArr2 = new byte[(i8 * 8) + i9];
        for (int i11 = 0; i11 < i9; i11++) {
            bArr2[i11] = bArr[i11];
        }
        for (int i12 = iK - 2; i12 >= 0; i12--) {
            long j8 = vVar.f4829a[i12];
            int i13 = 7;
            while (i13 >= 0) {
                bArr2[i9] = (byte) (j8 >>> (i13 * 8));
                i13--;
                i9++;
            }
        }
        return new BigInteger(1, bArr2);
    }

    @Override // p7.m
    public final m m() {
        return this;
    }
}

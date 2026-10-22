package C3;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f1708a = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    public static int[] a(D3.a aVar, int i10, int i11) {
        int[] iArr = new int[i11];
        int iJ = aVar.j() / i10;
        for (int i12 = 0; i12 < iJ; i12++) {
            int i13 = 0;
            for (int i14 = 0; i14 < i10; i14++) {
                i13 |= aVar.i((i12 * i10) + i14) ? 1 << ((i10 - i14) - 1) : 0;
            }
            iArr[i12] = i13;
        }
        return iArr;
    }

    public static void b(D3.b bVar, int i10, int i11) {
        for (int i12 = 0; i12 < i11; i12 += 2) {
            int i13 = i10 - i12;
            int i14 = i13;
            while (true) {
                int i15 = i10 + i12;
                if (i14 <= i15) {
                    bVar.j(i14, i13);
                    bVar.j(i14, i15);
                    bVar.j(i13, i14);
                    bVar.j(i15, i14);
                    i14++;
                }
            }
        }
        int i16 = i10 - i11;
        bVar.j(i16, i16);
        int i17 = i16 + 1;
        bVar.j(i17, i16);
        bVar.j(i16, i17);
        int i18 = i10 + i11;
        bVar.j(i18, i16);
        bVar.j(i18, i17);
        bVar.j(i18, i18 - 1);
    }

    public static void c(D3.b bVar, boolean z10, int i10, D3.a aVar) {
        int i11 = i10 / 2;
        int i12 = 0;
        if (z10) {
            while (i12 < 7) {
                int i13 = (i11 - 3) + i12;
                if (aVar.i(i12)) {
                    bVar.j(i13, i11 - 5);
                }
                if (aVar.i(i12 + 7)) {
                    bVar.j(i11 + 5, i13);
                }
                if (aVar.i(20 - i12)) {
                    bVar.j(i13, i11 + 5);
                }
                if (aVar.i(27 - i12)) {
                    bVar.j(i11 - 5, i13);
                }
                i12++;
            }
            return;
        }
        while (i12 < 10) {
            int i14 = (i11 - 5) + i12 + (i12 / 5);
            if (aVar.i(i12)) {
                bVar.j(i14, i11 - 7);
            }
            if (aVar.i(i12 + 10)) {
                bVar.j(i11 + 7, i14);
            }
            if (aVar.i(29 - i12)) {
                bVar.j(i14, i11 + 7);
            }
            if (aVar.i(39 - i12)) {
                bVar.j(i11 - 7, i14);
            }
            i12++;
        }
    }

    public static a d(String str, int i10, int i11, Charset charset) {
        return e(str.getBytes(charset != null ? charset : StandardCharsets.ISO_8859_1), i10, i11, charset);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static a e(byte[] bArr, int i10, int i11, Charset charset) {
        D3.a aVarI;
        int i12;
        boolean z10;
        int iAbs;
        int iJ;
        int i13;
        int i14;
        D3.a aVarA = new d(bArr, charset).a();
        int iJ2 = ((aVarA.j() * i10) / 100) + 11;
        int iJ3 = aVarA.j() + iJ2;
        int i15 = 4;
        int i16 = 1;
        if (i11 == 0) {
            D3.a aVarI2 = null;
            int i17 = 0;
            int i18 = 0;
            while (i17 <= 32) {
                boolean z11 = i17 <= 3 ? i16 : 0;
                int i19 = z11 != 0 ? i17 + 1 : i17;
                int iJ4 = j(i19, z11);
                if (iJ3 <= iJ4) {
                    if (aVarI2 == null || i18 != f1708a[i19]) {
                        int i20 = f1708a[i19];
                        i18 = i20;
                        aVarI2 = i(aVarA, i20);
                    }
                    int i21 = iJ4 - (iJ4 % i18);
                    if ((z11 == 0 || aVarI2.j() <= i18 * 64) && aVarI2.j() + iJ2 <= i21) {
                        aVarI = aVarI2;
                        i12 = i18;
                        z10 = z11;
                        iAbs = i19;
                        iJ = iJ4;
                    }
                }
                i17++;
                i16 = i16;
                i15 = 4;
            }
            throw new IllegalArgumentException("Data too large for an Aztec code");
        }
        z10 = i11 < 0;
        iAbs = Math.abs(i11);
        if (iAbs > (z10 ? 4 : 32)) {
            throw new IllegalArgumentException(String.format("Illegal value %s for layers", Integer.valueOf(i11)));
        }
        iJ = j(iAbs, z10);
        i12 = f1708a[iAbs];
        int i22 = iJ - (iJ % i12);
        aVarI = i(aVarA, i12);
        if (aVarI.j() + iJ2 > i22) {
            throw new IllegalArgumentException("Data to large for user specified layer");
        }
        if (z10 && aVarI.j() > i12 * 64) {
            throw new IllegalArgumentException("Data to large for user specified layer");
        }
        D3.a aVarF = f(aVarI, iJ, i12);
        int iJ5 = aVarI.j() / i12;
        D3.a aVarG = g(z10, iAbs, iJ5);
        int i23 = (z10 ? 11 : 14) + (iAbs * 4);
        int[] iArr = new int[i23];
        int i24 = 2;
        if (z10) {
            for (int i25 = 0; i25 < i23; i25++) {
                iArr[i25] = i25;
            }
            i13 = i23;
        } else {
            int i26 = i23 / 2;
            i13 = i23 + 1 + (((i26 - 1) / 15) * 2);
            int i27 = i13 / 2;
            for (int i28 = 0; i28 < i26; i28++) {
                iArr[(i26 - i28) - 1] = (i27 - r15) - 1;
                iArr[i26 + i28] = (i28 / 15) + i28 + i27 + i16;
            }
        }
        D3.b bVar = new D3.b(i13);
        int i29 = 0;
        int i30 = 0;
        while (i29 < iAbs) {
            int i31 = ((iAbs - i29) * i15) + (z10 ? 9 : 12);
            for (int i32 = 0; i32 < i31; i32++) {
                int i33 = i32 * 2;
                int i34 = 0;
                while (i34 < i24) {
                    int i35 = i16;
                    if (aVarF.i(i30 + i33 + i34)) {
                        int i36 = i29 * 2;
                        i14 = i24;
                        bVar.j(iArr[i36 + i34], iArr[i36 + i32]);
                    } else {
                        i14 = i24;
                    }
                    if (aVarF.i((i31 * 2) + i30 + i33 + i34)) {
                        int i37 = i29 * 2;
                        bVar.j(iArr[i37 + i32], iArr[((i23 - 1) - i37) - i34]);
                    }
                    if (aVarF.i((i31 * 4) + i30 + i33 + i34)) {
                        int i38 = (i23 - 1) - (i29 * 2);
                        bVar.j(iArr[i38 - i34], iArr[i38 - i32]);
                    }
                    if (aVarF.i((i31 * 6) + i30 + i33 + i34)) {
                        int i39 = i29 * 2;
                        bVar.j(iArr[((i23 - 1) - i39) - i32], iArr[i39 + i34]);
                    }
                    i34++;
                    i24 = i14;
                    i16 = i35;
                }
            }
            i30 += i31 * 8;
            i29++;
            i15 = 4;
        }
        c(bVar, z10, i13, aVarG);
        if (z10) {
            b(bVar, i13 / 2, 5);
        } else {
            int i40 = i13 / 2;
            b(bVar, i40, 7);
            int i41 = 0;
            int i42 = 0;
            while (i42 < (i23 / 2) - 1) {
                for (int i43 = i40 & 1; i43 < i13; i43 += 2) {
                    int i44 = i40 - i41;
                    bVar.j(i44, i43);
                    int i45 = i40 + i41;
                    bVar.j(i45, i43);
                    bVar.j(i43, i44);
                    bVar.j(i43, i45);
                }
                i42 += 15;
                i41 += 16;
            }
        }
        a aVar = new a();
        aVar.c(z10);
        aVar.f(i13);
        aVar.d(iAbs);
        aVar.b(iJ5);
        aVar.e(bVar);
        return aVar;
    }

    public static D3.a f(D3.a aVar, int i10, int i11) {
        int iJ = aVar.j() / i11;
        E3.c cVar = new E3.c(h(i11));
        int i12 = i10 / i11;
        int[] iArrA = a(aVar, i11, i12);
        cVar.b(iArrA, i12 - iJ);
        D3.a aVar2 = new D3.a();
        aVar2.f(0, i10 % i11);
        for (int i13 : iArrA) {
            aVar2.f(i13, i11);
        }
        return aVar2;
    }

    public static D3.a g(boolean z10, int i10, int i11) {
        D3.a aVar = new D3.a();
        if (z10) {
            aVar.f(i10 - 1, 2);
            aVar.f(i11 - 1, 6);
            return f(aVar, 28, 4);
        }
        aVar.f(i10 - 1, 5);
        aVar.f(i11 - 1, 11);
        return f(aVar, 40, 4);
    }

    public static E3.a h(int i10) {
        if (i10 == 4) {
            return E3.a.f2364k;
        }
        if (i10 == 6) {
            return E3.a.f2363j;
        }
        if (i10 == 8) {
            return E3.a.f2367n;
        }
        if (i10 == 10) {
            return E3.a.f2362i;
        }
        if (i10 == 12) {
            return E3.a.f2361h;
        }
        throw new IllegalArgumentException("Unsupported word size " + i10);
    }

    public static D3.a i(D3.a aVar, int i10) {
        D3.a aVar2 = new D3.a();
        int iJ = aVar.j();
        int i11 = (1 << i10) - 2;
        int i12 = 0;
        while (i12 < iJ) {
            int i13 = 0;
            for (int i14 = 0; i14 < i10; i14++) {
                int i15 = i12 + i14;
                if (i15 >= iJ || aVar.i(i15)) {
                    i13 |= 1 << ((i10 - 1) - i14);
                }
            }
            int i16 = i13 & i11;
            if (i16 == i11) {
                aVar2.f(i16, i10);
            } else if (i16 == 0) {
                aVar2.f(i13 | 1, i10);
            } else {
                aVar2.f(i13, i10);
                i12 += i10;
            }
            i12--;
            i12 += i10;
        }
        return aVar2;
    }

    public static int j(int i10, boolean z10) {
        return ((z10 ? 88 : 112) + (i10 * 16)) * i10;
    }
}

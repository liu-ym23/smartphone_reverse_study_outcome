package p7;

import java.math.BigInteger;

/* loaded from: classes.dex */
public abstract class d0 implements n {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f4776a = {13, 41, 121, 337, 897, 2305};

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f4777b = new byte[0];

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f4778c = new int[0];
    public static final r[] d = new r[0];

    public static r a(h hVar, r rVar) {
        if (hVar.i(rVar.f4817a)) {
            return hVar.g(rVar.g(false));
        }
        throw new IllegalArgumentException("Point must be on the same curve");
    }

    public static void b(r rVar) {
        h hVar = rVar.f4817a;
        if (hVar == null) {
            return;
        }
        BigInteger bigInteger = hVar.d;
        hVar.q(rVar, "bc_wnaf", new c0(Math.min(16, g(bigInteger == null ? hVar.l() + 1 : bigInteger.bitLength(), 16, f4776a) + 3)));
    }

    public static byte[] c(int i8, BigInteger bigInteger) {
        if (i8 == 2) {
            if (bigInteger.signum() != 0) {
                BigInteger bigIntegerAdd = bigInteger.shiftLeft(1).add(bigInteger);
                int iBitLength = bigIntegerAdd.bitLength();
                int i9 = iBitLength - 1;
                byte[] bArr = new byte[i9];
                BigInteger bigIntegerXor = bigIntegerAdd.xor(bigInteger);
                int i10 = 1;
                while (i10 < i9) {
                    if (bigIntegerXor.testBit(i10)) {
                        bArr[i10 - 1] = (byte) (bigInteger.testBit(i10) ? -1 : 1);
                        i10++;
                    }
                    i10++;
                }
                bArr[iBitLength - 2] = 1;
                return bArr;
            }
        } else {
            if (i8 < 2 || i8 > 8) {
                throw new IllegalArgumentException("'width' must be in the range [2, 8]");
            }
            if (bigInteger.signum() != 0) {
                int iBitLength2 = bigInteger.bitLength() + 1;
                byte[] bArr2 = new byte[iBitLength2];
                int i11 = 1 << i8;
                int i12 = i11 - 1;
                int i13 = i11 >>> 1;
                int i14 = 0;
                int i15 = 0;
                boolean z = false;
                while (i14 <= bigInteger.bitLength()) {
                    if (bigInteger.testBit(i14) == z) {
                        i14++;
                    } else {
                        bigInteger = bigInteger.shiftRight(i14);
                        int iIntValue = bigInteger.intValue() & i12;
                        if (z) {
                            iIntValue++;
                        }
                        z = (iIntValue & i13) != 0;
                        if (z) {
                            iIntValue -= i11;
                        }
                        if (i15 > 0) {
                            i14--;
                        }
                        int i16 = i15 + i14;
                        bArr2[i16] = (byte) iIntValue;
                        i15 = i16 + 1;
                        i14 = i8;
                    }
                }
                if (iBitLength2 <= i15) {
                    return bArr2;
                }
                byte[] bArr3 = new byte[i15];
                System.arraycopy(bArr2, 0, bArr3, 0, i15);
                return bArr3;
            }
        }
        return f4777b;
    }

    public static int d(h hVar) {
        BigInteger bigInteger = hVar.d;
        return bigInteger == null ? hVar.l() + 1 : bigInteger.bitLength();
    }

    public static int e(BigInteger bigInteger) {
        if (bigInteger.signum() == 0) {
            return 0;
        }
        return bigInteger.shiftLeft(1).add(bigInteger).xor(bigInteger).bitCount();
    }

    public static int g(int i8, int i9, int[] iArr) {
        int i10 = 0;
        while (i10 < iArr.length && i8 >= iArr[i10]) {
            i10++;
        }
        return Math.max(2, Math.min(i9, i10 + 2));
    }

    public static void h(r rVar) {
        if (!rVar.j(false, false)) {
            throw new IllegalStateException("Invalid result");
        }
    }

    public static r i(r[] rVarArr, r[] rVarArr2, byte[] bArr, r[] rVarArr3, r[] rVarArr4, byte[] bArr2) {
        r rVarA;
        int iMax = Math.max(bArr.length, bArr2.length);
        r rVarM = rVarArr[0].f4817a.m();
        int i8 = iMax - 1;
        int i9 = 0;
        r rVarY = rVarM;
        while (i8 >= 0) {
            byte b9 = i8 < bArr.length ? bArr[i8] : (byte) 0;
            byte b10 = i8 < bArr2.length ? bArr2[i8] : (byte) 0;
            if ((b9 | b10) == 0) {
                i9++;
            } else {
                if (b9 != 0) {
                    rVarA = rVarM.a((b9 < 0 ? rVarArr2 : rVarArr)[Math.abs((int) b9) >>> 1]);
                } else {
                    rVarA = rVarM;
                }
                if (b10 != 0) {
                    rVarA = rVarA.a((b10 < 0 ? rVarArr4 : rVarArr3)[Math.abs((int) b10) >>> 1]);
                }
                if (i9 > 0) {
                    rVarY = rVarY.w(i9);
                    i9 = 0;
                }
                rVarY = rVarY.y(rVarA);
            }
            i8--;
        }
        return i9 > 0 ? rVarY.w(i9) : rVarY;
    }

    public static boolean j(w7.a aVar) {
        return aVar.a() > 1 && aVar.b().equals(a.f4759c) && (aVar instanceof w7.d);
    }

    public static b0 o(int i8, r rVar) {
        h hVar = rVar.f4817a;
        return (b0) hVar.q(rVar, "bc_wnaf", new d8.m(i8, rVar, hVar));
    }

    public static r p(r rVar, BigInteger bigInteger) {
        BigInteger bigIntegerAbs = bigInteger.abs();
        r rVarM = rVar.f4817a.m();
        int iBitLength = bigIntegerAbs.bitLength();
        if (iBitLength > 0) {
            if (bigIntegerAbs.testBit(0)) {
                rVarM = rVar;
            }
            for (int i8 = 1; i8 < iBitLength; i8++) {
                rVar = rVar.x();
                if (bigIntegerAbs.testBit(i8)) {
                    rVarM = rVarM.a(rVar);
                }
            }
        }
        return bigInteger.signum() < 0 ? rVarM.n() : rVarM;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static r q(r rVar, r rVar2, BigInteger bigInteger, BigInteger bigInteger2) {
        r rVarI;
        r rVarA;
        r rVarM;
        int i8;
        int[] iArr = f4776a;
        h hVar = rVar.f4817a;
        if (!hVar.i(rVar2.f4817a)) {
            throw new IllegalArgumentException("Point must be on the same curve");
        }
        r rVarN = hVar.n(rVar2);
        if ((hVar instanceof c) && ((c) hVar).u()) {
            r rVarA2 = rVar.m(bigInteger).a(rVarN.m(bigInteger2));
            h(rVarA2);
            return rVarA2;
        }
        t7.b bVar = hVar.f4802g;
        int i9 = 8;
        boolean z = true;
        boolean z2 = false;
        if (!(bVar instanceof t7.b)) {
            Object[] objArr = bigInteger.signum() < 0;
            Object[] objArr2 = bigInteger2.signum() < 0;
            BigInteger bigIntegerAbs = bigInteger.abs();
            BigInteger bigIntegerAbs2 = bigInteger2.abs();
            int iG = g(bigIntegerAbs.bitLength(), 8, iArr);
            int iG2 = g(bigIntegerAbs2.bitLength(), 8, iArr);
            b0 b0VarO = o(iG, rVar);
            h hVar2 = rVar.f4817a;
            b0 b0VarO2 = o(iG2, rVarN);
            int iD = d(hVar2);
            if (objArr == true || objArr2 == true || bigInteger.bitLength() > iD || bigInteger2.bitLength() > iD || b0VarO.f4769a > 0 || b0VarO2.f4769a > 0) {
                rVarI = i(objArr != false ? b0VarO.d : b0VarO.f4771c, objArr != false ? b0VarO.f4771c : b0VarO.d, c(Math.min(8, b0VarO.f4773f), bigIntegerAbs), objArr2 != false ? b0VarO2.d : b0VarO2.f4771c, objArr2 != false ? b0VarO2.f4771c : b0VarO2.d, c(Math.min(8, b0VarO2.f4773f), bigIntegerAbs2));
            } else {
                int iD2 = d(hVar2);
                if (bigInteger.bitLength() > iD2 || bigInteger2.bitLength() > iD2) {
                    throw new IllegalStateException("fixed-point comb doesn't support scalars larger than the curve order");
                }
                h hVar3 = rVar.f4817a;
                t tVar = (t) hVar3.q(rVar, "bc_fixed_point", new androidx.emoji2.text.p(hVar3, 15, rVar));
                h hVar4 = rVarN.f4817a;
                t tVar2 = (t) hVar4.q(rVarN, "bc_fixed_point", new androidx.emoji2.text.p(hVar4, 15, rVarN));
                d0 d0Var = tVar.f4823b;
                d0 d0Var2 = tVar2.f4823b;
                int i10 = tVar.f4824c;
                if (i10 != tVar2.f4824c) {
                    s sVar = new s(0);
                    rVarA = sVar.m(rVar, bigInteger);
                    rVarM = sVar.m(rVarN, bigInteger2);
                } else {
                    int i11 = ((iD2 + i10) - 1) / i10;
                    r rVarM2 = hVar2.m();
                    int i12 = i10 * i11;
                    int[] iArrO = x.f.O(i12, bigInteger);
                    int[] iArrO2 = x.f.O(i12, bigInteger2);
                    int i13 = i12 - 1;
                    for (int i14 = 0; i14 < i11; i14++) {
                        int i15 = 0;
                        int i16 = 0;
                        for (int i17 = i13 - i14; i17 >= 0; i17 -= i11) {
                            int i18 = i17 >>> 5;
                            int i19 = i17 & 31;
                            int i20 = iArrO[i18] >>> i19;
                            i15 = ((i15 ^ (i20 >>> 1)) << 1) ^ i20;
                            int i21 = iArrO2[i18] >>> i19;
                            i16 = ((i16 ^ (i21 >>> 1)) << 1) ^ i21;
                        }
                        rVarM2 = rVarM2.y(d0Var.l(i15).a(d0Var2.l(i16)));
                    }
                    rVarA = rVarM2.a(tVar.f4822a);
                    rVarM = tVar2.f4822a;
                }
                rVarI = rVarA.a(rVarM);
            }
            h(rVarI);
            return rVarI;
        }
        r[] rVarArr = {rVar, rVarN};
        BigInteger[] bigIntegerArr = {bigInteger, bigInteger2};
        BigInteger bigInteger3 = rVarArr[0].f4817a.d;
        int i22 = 4;
        BigInteger[] bigIntegerArr2 = new BigInteger[4];
        int i23 = 0;
        int i24 = 0;
        while (true) {
            if (i23 >= 2) {
                break;
            }
            BigInteger[] bigIntegerArrA = bVar.a(bigIntegerArr[i23].mod(bigInteger3));
            int i25 = i24 + 1;
            bigIntegerArr2[i24] = bigIntegerArrA[0];
            i24 += 2;
            bigIntegerArr2[i25] = bigIntegerArrA[1];
            i23++;
        }
        boolean[] zArr = new boolean[4];
        b0[] b0VarArr = new b0[4];
        byte[][] bArr = new byte[4][];
        androidx.emoji2.text.m mVar = bVar.f5603b;
        int i26 = 0;
        for (i8 = 2; i26 < i8; i8 = 2) {
            int i27 = i26 << 1;
            int i28 = i27 + 1;
            BigInteger bigInteger4 = bigIntegerArr2[i27];
            zArr[i27] = bigInteger4.signum() < 0 ? z : z2;
            boolean z8 = z;
            BigInteger bigIntegerAbs3 = bigInteger4.abs();
            BigInteger bigInteger5 = bigIntegerArr2[i28];
            zArr[i28] = bigInteger5.signum() < 0 ? z8 : z2;
            boolean z9 = z2;
            BigInteger bigIntegerAbs4 = bigInteger5.abs();
            int iG3 = g(Math.max(bigIntegerAbs3.bitLength(), bigIntegerAbs4.bitLength()), i9, iArr);
            r rVar3 = rVarArr[i26];
            b0 b0VarO3 = o(iG3, rVar3);
            r[] rVarArr2 = rVarArr;
            boolean[] zArr2 = zArr;
            r rVar4 = ((t7.a) rVar3.f4817a.q(rVar3, "bc_endo", new androidx.emoji2.text.p(bVar, 19, rVar3))).f5601b;
            b0 b0Var = (b0) rVar4.f4817a.q(rVar4, "bc_wnaf", new androidx.emoji2.text.p(b0VarO3, 16, mVar));
            int iMin = Math.min(8, b0VarO3.f4773f);
            int iMin2 = Math.min(8, b0Var.f4773f);
            b0VarArr[i27] = b0VarO3;
            b0VarArr[i28] = b0Var;
            bArr[i27] = c(iMin, bigIntegerAbs3);
            bArr[i28] = c(iMin2, bigIntegerAbs4);
            i26++;
            z = z8;
            zArr = zArr2;
            z2 = z9;
            rVarArr = rVarArr2;
            i22 = 4;
            i9 = 8;
        }
        boolean[] zArr3 = zArr;
        boolean z10 = z;
        boolean z11 = z2;
        int i29 = z11 ? 1 : 0;
        int iMax = i29;
        while (i29 < i22) {
            iMax = Math.max(iMax, bArr[i29].length);
            i29++;
            i22 = 4;
        }
        r rVarM3 = b0VarArr[z11 ? 1 : 0].f4771c[z11 ? 1 : 0].f4817a.m();
        int i30 = iMax - 1;
        r rVarW = rVarM3;
        int i31 = z11 ? 1 : 0;
        while (i30 >= 0) {
            r rVarA3 = rVarM3;
            for (int i32 = z11 ? 1 : 0; i32 < 4; i32++) {
                byte[] bArr2 = bArr[i32];
                byte b9 = i30 < bArr2.length ? bArr2[i30] : z11 ? 1 : 0;
                if (b9 != 0) {
                    int iAbs = Math.abs((int) b9);
                    b0 b0Var2 = b0VarArr[i32];
                    rVarA3 = rVarA3.a(((b9 < 0 ? z10 : z11 ? 1 : 0) == zArr3[i32] ? b0Var2.f4771c : b0Var2.d)[iAbs >>> 1]);
                }
            }
            if (rVarA3 == rVarM3) {
                i31++;
            } else {
                if (i31 > 0) {
                    rVarW = rVarW.w(i31);
                    i31 = z11 ? 1 : 0;
                }
                rVarW = rVarW.y(rVarA3);
            }
            i30--;
        }
        if (i31 > 0) {
            rVarW = rVarW.w(i31);
        }
        h(rVarW);
        return rVarW;
    }

    public abstract int f();

    public abstract r k(int i8);

    public abstract r l(int i8);

    public r m(r rVar, BigInteger bigInteger) {
        int iSignum = bigInteger.signum();
        if (iSignum == 0 || rVar.k()) {
            return rVar.f4817a.m();
        }
        r rVarN = n(rVar, bigInteger.abs());
        if (iSignum <= 0) {
            rVarN = rVarN.n();
        }
        h(rVarN);
        return rVarN;
    }

    public abstract r n(r rVar, BigInteger bigInteger);
}

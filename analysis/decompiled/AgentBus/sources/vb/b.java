package vb;

import i5.f;
import n7.m;
import n7.o;
import o4.d0;
import u5.h;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f10611a = {52811034, 25909283, 8072341, 50637101, 13785486, 30858332, 20483199, 20966410, 43936626, 4379245};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f10612b = {40265304, 26843545, 6710886, 53687091, 13421772, 40265318, 26843545, 6710886, 53687091, 13421772};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f10613c = {12052516, 1174424, 4087752, 38672185, 20040971, 21899680, 55468344, 20105554, 66708015, 9981791};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f10614d = {66430571, 45040722, 4842939, 15895846, 18981244, 46308410, 4697481, 8903007, 53646190, 12474675};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f10615e = {56195235, 47411844, 25868126, 40503822, 57364, 58321048, 30416477, 31930572, 57760639, 10749657};

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f10616f = {45281625, 27714825, 18181821, 13898781, 114729, 49533232, 60832955, 30306712, 48412415, 4722099};

    /* renamed from: g, reason: collision with root package name */
    public static final int[] f10617g = {23454386, 55429651, 2809210, 27797563, 229458, 31957600, 54557047, 27058993, 29715967, 9444199};

    /* renamed from: h, reason: collision with root package name */
    public static final Object f10618h = new Object();

    /* renamed from: i, reason: collision with root package name */
    public static h[] f10619i = null;

    /* renamed from: j, reason: collision with root package name */
    public static h[] f10620j = null;

    /* renamed from: k, reason: collision with root package name */
    public static int[] f10621k = null;

    /* renamed from: l, reason: collision with root package name */
    public static final int[] f10622l = {1559614445, 1477600026, -1560830762, 350157278, 0, 0, 0, 268435456};

    public static int a(a aVar) {
        int[] iArr = new int[10];
        int[] iArr2 = new int[10];
        int[] iArr3 = new int[10];
        ub.a.n(aVar.f10609a, iArr2);
        ub.a.n(aVar.f10610b, iArr3);
        ub.a.j(iArr2, iArr3, iArr);
        for (int i2 = 0; i2 < 10; i2++) {
            iArr2[i2] = iArr2[i2] - iArr3[i2];
        }
        ub.a.j(iArr, f10615e, iArr);
        iArr[0] = iArr[0] + 1;
        ub.a.a(iArr, iArr2, iArr);
        ub.a.k(iArr);
        ub.a.k(iArr3);
        int i10 = 0;
        for (int i11 = 0; i11 < 10; i11++) {
            i10 |= iArr[i11];
        }
        int i12 = (((i10 >>> 1) | (i10 & 1)) - 1) >> 31;
        int i13 = 0;
        for (int i14 = 0; i14 < 10; i14++) {
            i13 |= iArr3[i14];
        }
        return (~((((i13 >>> 1) | (i13 & 1)) - 1) >> 31)) & i12;
    }

    public static void b(byte[] bArr, int[] iArr) {
        for (int i2 = 0; i2 < 8; i2++) {
            iArr[i2] = d(i2 * 4, bArr);
        }
    }

    public static int c(int i2, byte[] bArr) {
        return ((bArr[i2 + 2] & 255) << 16) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8);
    }

    public static int d(int i2, byte[] bArr) {
        return (bArr[i2 + 3] << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    public static void e(byte[] bArr, int i2, int i10) {
        bArr[i10] = (byte) i2;
        bArr[i10 + 1] = (byte) (i2 >>> 8);
        bArr[i10 + 2] = (byte) (i2 >>> 16);
        bArr[i10 + 3] = (byte) (i2 >>> 24);
    }

    public static void f(int i2, long j2, byte[] bArr) {
        e(bArr, (int) j2, i2);
        int i10 = (int) (j2 >>> 32);
        bArr[i2 + 4] = (byte) i10;
        bArr[i2 + 5] = (byte) (i10 >>> 8);
        bArr[i2 + 6] = (byte) (i10 >>> 16);
    }

    public static d0 g(byte[] bArr) {
        rb.a aVar = new rb.a();
        byte[] bArr2 = new byte[64];
        aVar.k(bArr, 0, 32);
        aVar.e(0, bArr2);
        byte[] bArr3 = new byte[32];
        n(bArr2, bArr3);
        a3.b bVar = new a3.b();
        p(bArr3, bVar);
        a aVar2 = new a();
        j(bVar, aVar2);
        if (a(aVar2) == 0) {
            throw new IllegalStateException();
        }
        int[] iArr = new int[20];
        ub.a.e(0, 0, aVar2.f10609a, iArr);
        ub.a.e(0, 10, aVar2.f10610b, iArr);
        return new d0(14, iArr);
    }

    public static void h(byte[] bArr, byte[] bArr2, byte b10, byte[] bArr3, int i2, byte[] bArr4) {
        if (b10 != 0) {
            throw new IllegalArgumentException("ctx");
        }
        rb.a aVar = new rb.a();
        byte[] bArr5 = new byte[64];
        aVar.k(bArr, 0, 32);
        aVar.e(0, bArr5);
        byte[] bArr6 = new byte[32];
        n(bArr5, bArr6);
        aVar.k(bArr5, 32, 32);
        aVar.k(bArr3, 0, i2);
        aVar.e(0, bArr5);
        byte[] bArrO = o(bArr5);
        byte[] bArr7 = new byte[32];
        a3.b bVar = new a3.b();
        p(bArrO, bVar);
        a aVar2 = new a();
        j(bVar, aVar2);
        int iA = a(aVar2);
        int[] iArr = aVar2.f10610b;
        ub.a.h(iArr, 0, bArr7, 0);
        ub.a.h(iArr, 5, bArr7, 16);
        bArr7[31] = (byte) (bArr7[31] | ((aVar2.f10609a[0] & 1) << 7));
        if (iA == 0) {
            throw new IllegalStateException();
        }
        aVar.k(bArr7, 0, 32);
        aVar.k(bArr2, 0, 32);
        aVar.k(bArr3, 0, i2);
        aVar.e(0, bArr5);
        byte[] bArrO2 = o(bArr5);
        int[] iArr2 = new int[16];
        b(bArrO, iArr2);
        b(bArrO2, new int[8]);
        b(bArr6, new int[8]);
        long j2 = r0[0] & 4294967295L;
        long j4 = r0[1] & 4294967295L;
        long j10 = r0[2] & 4294967295L;
        long j11 = r0[3] & 4294967295L;
        long j12 = r0[4] & 4294967295L;
        long j13 = r0[5] & 4294967295L;
        long j14 = r0[6] & 4294967295L;
        long j15 = r0[7] & 4294967295L;
        long j16 = 0;
        int i10 = 0;
        while (i10 < 8) {
            long j17 = r5[i10] & 4294967295L;
            long j18 = (j17 * j2) + (iArr2[i10] & 4294967295L);
            long j19 = j13;
            iArr2[i10] = (int) j18;
            int i11 = i10 + 1;
            long j20 = (j17 * j4) + (iArr2[i11] & 4294967295L) + (j18 >>> 32);
            iArr2[i11] = (int) j20;
            long j21 = (j17 * j10) + (iArr2[r30] & 4294967295L) + (j20 >>> 32);
            iArr2[i10 + 2] = (int) j21;
            long j22 = (j17 * j11) + (iArr2[r30] & 4294967295L) + (j21 >>> 32);
            iArr2[i10 + 3] = (int) j22;
            long j23 = (j17 * j12) + (iArr2[r30] & 4294967295L) + (j22 >>> 32);
            iArr2[i10 + 4] = (int) j23;
            long j24 = (j17 * j19) + (iArr2[r30] & 4294967295L) + (j23 >>> 32);
            iArr2[i10 + 5] = (int) j24;
            long j25 = (j17 * j14) + (iArr2[r30] & 4294967295L) + (j24 >>> 32);
            iArr2[i10 + 6] = (int) j25;
            long j26 = (j17 * j15) + (iArr2[r27] & 4294967295L) + (j25 >>> 32);
            iArr2[i10 + 7] = (int) j26;
            long j27 = (j26 >>> 32) + (iArr2[r5] & 4294967295L) + j16;
            iArr2[i10 + 8] = (int) j27;
            j16 = j27 >>> 32;
            j13 = j19;
            i10 = i11;
        }
        byte[] bArr8 = new byte[64];
        for (int i12 = 0; i12 < 16; i12++) {
            e(bArr8, iArr2[i12], i12 * 4);
        }
        byte[] bArrO3 = o(bArr8);
        System.arraycopy(bArr7, 0, bArr4, 0, 32);
        System.arraycopy(bArrO3, 0, bArr4, 32, 32);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void i(i5.f[] r31) {
        /*
            Method dump skipped, instructions count: 554
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: vb.b.i(i5.f[]):void");
    }

    public static void j(a3.b bVar, a aVar) {
        int[] iArr = (int[]) bVar.f164h;
        int[] iArr2 = aVar.f10610b;
        int[] iArr3 = aVar.f10609a;
        int[] iArr4 = new int[10];
        int[] iArr5 = new int[8];
        int i2 = 0;
        ub.a.e(0, 0, iArr, iArr4);
        ub.a.k(iArr4);
        ub.a.g(0, 0, iArr4, iArr5);
        ub.a.g(5, 4, iArr4, iArr5);
        int[] iArr6 = ub.a.f10220a;
        int iNumberOfLeadingZeros = Integer.numberOfLeadingZeros(iArr6[7]);
        int i10 = 256 - iNumberOfLeadingZeros;
        int i11 = 30;
        int i12 = (285 - iNumberOfLeadingZeros) / 30;
        int[] iArr7 = new int[i12];
        int[] iArr8 = new int[i12];
        int[] iArr9 = new int[i12];
        int[] iArr10 = new int[i12];
        int[] iArr11 = new int[i12];
        int i13 = 1;
        iArr8[0] = 1;
        o.j(i10, iArr5, iArr10);
        o.j(i10, iArr6, iArr11);
        System.arraycopy(iArr11, 0, iArr9, 0, i12);
        int iQ = o.q(iArr11[0]);
        int i14 = (int) (((i10 * 150964) + 99243) >>> 16);
        int i15 = 0;
        int i16 = 0;
        while (i15 < i14) {
            int i17 = iArr9[i2];
            int i18 = iArr10[i2];
            int i19 = i16;
            int i20 = i17;
            int i21 = i13;
            int i22 = i14;
            int i23 = i15;
            int i24 = i12;
            int i25 = 1073741824;
            int i26 = i2;
            int i27 = i26;
            int i28 = i27;
            int i29 = 1073741824;
            while (i26 < i11) {
                int i30 = i11;
                int i31 = i19 >> 31;
                int i32 = i26;
                int i33 = -(i18 & 1);
                int i34 = i18 - ((i20 ^ i31) & i33);
                int i35 = i28 - ((i29 ^ i31) & i33);
                int i36 = i25 - ((i27 ^ i31) & i33);
                int i37 = i33 & (~i31);
                i19 = (i19 ^ i37) + 1;
                i20 += i34 & i37;
                i29 += i35 & i37;
                i27 += i37 & i36;
                i18 = i34 >> 1;
                i28 = i35 >> 1;
                i25 = i36 >> 1;
                i26 = i32 + 1;
                i11 = i30;
            }
            int[] iArr12 = {i29, i27, i28, i25};
            int[] iArr13 = iArr10;
            int[] iArr14 = iArr11;
            i12 = i24;
            o.F(i12, iArr7, iArr8, iArr12, iQ, iArr14);
            o.G(i12, iArr9, iArr13, iArr12);
            i15 = i23 + 30;
            iArr10 = iArr13;
            iArr11 = iArr14;
            i16 = i19;
            i13 = i21;
            i14 = i22;
            i2 = 0;
        }
        int i38 = i13;
        int[] iArr15 = iArr10;
        int[] iArr16 = iArr11;
        int i39 = i12 - 1;
        int i40 = iArr9[i39] >> 31;
        int i41 = 0;
        for (int i42 = 0; i42 < i39; i42++) {
            int i43 = ((iArr9[i42] ^ i40) - i40) + i41;
            iArr9[i42] = i43 & 1073741823;
            i41 = i43 >> 30;
        }
        iArr9[i39] = ((iArr9[i39] ^ i40) - i40) + i41;
        int i44 = iArr7[i39] >> 31;
        int i45 = 0;
        for (int i46 = 0; i46 < i39; i46++) {
            int i47 = (((iArr7[i46] + (iArr16[i46] & i44)) ^ i40) - i40) + i45;
            iArr7[i46] = i47 & 1073741823;
            i45 = i47 >> 30;
        }
        int i48 = (((iArr7[i39] + (i44 & iArr16[i39])) ^ i40) - i40) + i45;
        iArr7[i39] = i48;
        int i49 = i48 >> 31;
        int i50 = 0;
        for (int i51 = 0; i51 < i39; i51++) {
            int i52 = iArr7[i51] + (iArr16[i51] & i49) + i50;
            iArr7[i51] = i52 & 1073741823;
            i50 = i52 >> 30;
        }
        iArr7[i39] = iArr7[i39] + (i49 & iArr16[i39]) + i50;
        o.i(i10, iArr7, iArr5);
        o.k(i12, i38, iArr9);
        o.k(i12, 0, iArr15);
        ub.a.f(0, 0, iArr5, iArr2);
        ub.a.f(4, 5, iArr5, iArr2);
        iArr2[9] = iArr2[9] & 16777215;
        ub.a.j(iArr2, (int[]) bVar.f162f, iArr3);
        ub.a.j(iArr2, (int[]) bVar.f163g, iArr2);
        ub.a.k(iArr3);
        ub.a.k(iArr2);
    }

    public static void k(f fVar, f fVar2, f fVar3, a aVar) {
        int[] iArr = (int[]) fVar3.f4653g;
        int[] iArr2 = (int[]) fVar3.f4654h;
        int[] iArr3 = aVar.f10609a;
        int[] iArr4 = aVar.f10610b;
        ub.a.b((int[]) fVar.f4654h, (int[]) fVar.f4653g, iArr2, iArr);
        ub.a.b((int[]) fVar2.f4654h, (int[]) fVar2.f4653g, iArr4, iArr3);
        ub.a.j(iArr, iArr3, iArr);
        ub.a.j(iArr2, iArr4, iArr2);
        ub.a.j((int[]) fVar.f4656j, (int[]) fVar2.f4656j, iArr3);
        ub.a.j(iArr3, f10616f, iArr3);
        int[] iArr5 = (int[]) fVar.f4655i;
        ub.a.a(iArr5, iArr5, iArr4);
        ub.a.j(iArr4, (int[]) fVar2.f4655i, iArr4);
        ub.a.b(iArr2, iArr, iArr2, iArr);
        ub.a.b(iArr4, iArr3, iArr4, iArr3);
        ub.a.j(iArr, iArr2, (int[]) fVar3.f4656j);
        ub.a.j(iArr3, iArr4, (int[]) fVar3.f4655i);
        ub.a.j(iArr, iArr3, iArr);
        ub.a.j(iArr2, iArr4, iArr2);
    }

    public static void l(a3.b bVar, f fVar) {
        ub.a.e(0, 0, (int[]) bVar.f162f, (int[]) fVar.f4653g);
        ub.a.e(0, 0, (int[]) bVar.f163g, (int[]) fVar.f4654h);
        ub.a.e(0, 0, (int[]) bVar.f164h, (int[]) fVar.f4655i);
        ub.a.j((int[]) bVar.f165i, (int[]) bVar.f166j, (int[]) fVar.f4656j);
    }

    public static void m(a3.b bVar) {
        int[] iArr = (int[]) bVar.f162f;
        int[] iArr2 = (int[]) bVar.f163g;
        int[] iArr3 = (int[]) bVar.f164h;
        int[] iArr4 = (int[]) bVar.f165i;
        int[] iArr5 = (int[]) bVar.f166j;
        ub.a.a(iArr, iArr2, iArr4);
        ub.a.n(iArr, iArr);
        ub.a.n(iArr2, iArr2);
        ub.a.n(iArr3, iArr3);
        ub.a.a(iArr3, iArr3, iArr3);
        ub.a.b(iArr, iArr2, iArr5, iArr2);
        ub.a.n(iArr4, iArr4);
        for (int i2 = 0; i2 < 10; i2++) {
            iArr4[i2] = iArr5[i2] - iArr4[i2];
        }
        ub.a.a(iArr3, iArr2, iArr);
        int i10 = iArr[0];
        int i11 = iArr[1];
        int i12 = iArr[2];
        int i13 = iArr[3];
        int i14 = iArr[4];
        int i15 = iArr[5];
        int i16 = iArr[6];
        int i17 = iArr[7];
        int i18 = iArr[8];
        int i19 = i12 + (i11 >> 26);
        int i20 = i14 + (i13 >> 26);
        int i21 = i17 + (i16 >> 26);
        int i22 = iArr[9] + (i18 >> 26);
        int i23 = (i13 & 67108863) + (i19 >> 25);
        int i24 = i15 + (i20 >> 25);
        int i25 = (i18 & 67108863) + (i21 >> 25);
        int i26 = ((i22 >> 25) * 38) + i10;
        int i27 = (i11 & 67108863) + (i26 >> 26);
        int i28 = (i16 & 67108863) + (i24 >> 26);
        iArr[0] = i26 & 67108863;
        iArr[1] = i27 & 67108863;
        iArr[2] = (i19 & 33554431) + (i27 >> 26);
        iArr[3] = i23 & 67108863;
        iArr[4] = (i20 & 33554431) + (i23 >> 26);
        iArr[5] = i24 & 67108863;
        iArr[6] = i28 & 67108863;
        iArr[7] = (i21 & 33554431) + (i28 >> 26);
        iArr[8] = i25 & 67108863;
        iArr[9] = (i22 & 33554431) + (i25 >> 26);
        ub.a.j(iArr, iArr2, iArr3);
        ub.a.j(iArr, iArr4, iArr);
        ub.a.j(iArr2, iArr5, iArr2);
    }

    public static void n(byte[] bArr, byte[] bArr2) {
        System.arraycopy(bArr, 0, bArr2, 0, 32);
        bArr2[0] = (byte) (bArr2[0] & 248);
        byte b10 = (byte) (bArr2[31] & 127);
        bArr2[31] = b10;
        bArr2[31] = (byte) (b10 | 64);
    }

    public static byte[] o(byte[] bArr) {
        long jD = d(49, bArr);
        long j2 = jD & 4294967295L;
        long jD2 = d(56, bArr);
        long j4 = bArr[63] & 255;
        long jC = ((c(60, bArr) << 4) & 4294967295L) + ((jD2 & 4294967295L) >> 28);
        long j10 = jD2 & 268435455;
        long jD3 = ((d(42, bArr) & 4294967295L) - (j4 * (-6428113))) - (jC * 5343);
        long jD4 = ((d(28, bArr) & 4294967295L) - (jC * (-50998291))) - (j10 * 19280294);
        long jC2 = ((((c(32, bArr) << 4) & 4294967295L) - (j4 * (-50998291))) - (jC * 19280294)) - (j10 * 127719000);
        long jD5 = (((d(35, bArr) & 4294967295L) - (j4 * 19280294)) - (jC * 127719000)) - (j10 * (-6428113));
        long jC3 = ((((c(39, bArr) << 4) & 4294967295L) - (j4 * 127719000)) - (jC * (-6428113))) - (j10 * 5343);
        long jC4 = ((c(53, bArr) << 4) & 4294967295L) + (j2 >> 28);
        long j11 = jD & 268435455;
        long j12 = jD5 - (jC4 * 5343);
        long j13 = (jC2 - (jC4 * (-6428113))) - (j11 * 5343);
        long jC5 = (((c(46, bArr) << 4) & 4294967295L) - (j4 * 5343)) + (jD3 >> 28);
        long jD6 = (((d(21, bArr) & 4294967295L) - (jC4 * (-50998291))) - (j11 * 19280294)) - (jC5 * 127719000);
        long jC6 = (((((c(25, bArr) << 4) & 4294967295L) - (j10 * (-50998291))) - (jC4 * 19280294)) - (j11 * 127719000)) - (jC5 * (-6428113));
        long j14 = ((jD4 - (jC4 * 127719000)) - (j11 * (-6428113))) - (jC5 * 5343);
        long j15 = (jD3 & 268435455) + (jC3 >> 28);
        long jD7 = ((d(14, bArr) & 4294967295L) - (jC5 * (-50998291))) - (j15 * 19280294);
        long jC7 = ((((c(18, bArr) << 4) & 4294967295L) - (j11 * (-50998291))) - (jC5 * 19280294)) - (j15 * 127719000);
        long j16 = jC6 - (j15 * 5343);
        long j17 = (jC3 & 268435455) + (j12 >> 28);
        long jC8 = (((c(11, bArr) << 4) & 4294967295L) - (j15 * (-50998291))) - (j17 * 19280294);
        long j18 = (jD6 - (j15 * (-6428113))) - (j17 * 5343);
        long j19 = (j12 & 268435455) + (j13 >> 28);
        long jC9 = ((c(4, bArr) << 4) & 4294967295L) - (j19 * (-50998291));
        long jD8 = ((d(7, bArr) & 4294967295L) - (j17 * (-50998291))) - (j19 * 19280294);
        long j20 = jC8 - (j19 * 127719000);
        long j21 = (jD7 - (j17 * 127719000)) - (j19 * (-6428113));
        long j22 = (jC7 - (j17 * (-6428113))) - (j19 * 5343);
        long j23 = j14 + (j16 >> 28);
        long j24 = j16 & 268435455;
        long j25 = (j13 & 268435455) + (j23 >> 28);
        long j26 = j23 & 268435455;
        long j27 = j26 >>> 27;
        long j28 = j25 + j27;
        long jD9 = (d(0, bArr) & 4294967295L) - (j28 * (-50998291));
        long j29 = jD8 - (j28 * 127719000);
        long j30 = j20 - (j28 * (-6428113));
        long j31 = j21 - (j28 * 5343);
        long j32 = (jC9 - (j28 * 19280294)) + (jD9 >> 28);
        long j33 = jD9 & 268435455;
        long j34 = j29 + (j32 >> 28);
        long j35 = j30 + (j34 >> 28);
        long j36 = j31 + (j35 >> 28);
        long j37 = j22 + (j36 >> 28);
        long j38 = j18 + (j37 >> 28);
        long j39 = j24 + (j38 >> 28);
        long j40 = j26 + (j39 >> 28);
        long j41 = (j40 >> 28) - j27;
        long j42 = j33 + (j41 & (-50998291));
        long j43 = (j32 & 268435455) + (j41 & 19280294) + (j42 >> 28);
        long j44 = (j34 & 268435455) + (j41 & 127719000) + (j43 >> 28);
        long j45 = (j35 & 268435455) + (j41 & (-6428113)) + (j44 >> 28);
        long j46 = (j36 & 268435455) + (j41 & 5343) + (j45 >> 28);
        long j47 = (j37 & 268435455) + (j46 >> 28);
        long j48 = (j38 & 268435455) + (j47 >> 28);
        long j49 = (j39 & 268435455) + (j48 >> 28);
        long j50 = (j40 & 268435455) + (j49 >> 28);
        long j51 = j49 & 268435455;
        byte[] bArr2 = new byte[32];
        f(0, (j42 & 268435455) | ((j43 & 268435455) << 28), bArr2);
        f(7, (j44 & 268435455) | ((j45 & 268435455) << 28), bArr2);
        f(14, ((j47 & 268435455) << 28) | (j46 & 268435455), bArr2);
        f(21, (j51 << 28) | (j48 & 268435455), bArr2);
        e(bArr2, (int) j50, 28);
        return bArr2;
    }

    public static void p(byte[] bArr, a3.b bVar) {
        char c10;
        int i2;
        int i10;
        int i11;
        int i12;
        synchronized (f10618h) {
            try {
                int i13 = 8;
                int i14 = 4;
                int i15 = 0;
                if (f10621k != null) {
                    i11 = 8;
                    c10 = ' ';
                    i10 = 1;
                } else {
                    f[] fVarArr = new f[96];
                    a aVar = new a();
                    aVar.f10609a = new int[10];
                    aVar.f10610b = new int[10];
                    int[] iArr = new int[10];
                    int[] iArr2 = new int[10];
                    int[] iArr3 = f10611a;
                    ub.a.e(0, 0, iArr3, iArr);
                    int[] iArr4 = f10612b;
                    ub.a.e(0, 0, iArr4, iArr2);
                    c10 = ' ';
                    f fVar = new f(23);
                    fVarArr[0] = fVar;
                    ub.a.e(0, 0, iArr, (int[]) fVar.f4653g);
                    ub.a.e(0, 0, iArr2, (int[]) fVar.f4654h);
                    ub.a.l((int[]) fVar.f4655i);
                    ub.a.j(iArr, iArr2, (int[]) fVar.f4656j);
                    f fVar2 = new f(23);
                    f fVar3 = fVarArr[0];
                    k(fVar3, fVar3, fVar2, aVar);
                    int i16 = 1;
                    while (true) {
                        if (i16 >= 16) {
                            break;
                        }
                        f fVar4 = fVarArr[i16 - 1];
                        f fVar5 = new f(23);
                        fVarArr[i16] = fVar5;
                        k(fVar4, fVar2, fVar5, aVar);
                        i16++;
                    }
                    i10 = 1;
                    int[] iArr5 = new int[10];
                    int[] iArr6 = new int[10];
                    ub.a.e(0, 0, f10613c, iArr5);
                    ub.a.e(0, 0, f10614d, iArr6);
                    f fVar6 = new f(23);
                    fVarArr[16] = fVar6;
                    ub.a.e(0, 0, iArr5, (int[]) fVar6.f4653g);
                    ub.a.e(0, 0, iArr6, (int[]) fVar6.f4654h);
                    ub.a.l((int[]) fVar6.f4655i);
                    ub.a.j(iArr5, iArr6, (int[]) fVar6.f4656j);
                    f fVar7 = new f(23);
                    f fVar8 = fVarArr[16];
                    k(fVar8, fVar8, fVar7, aVar);
                    int i17 = 1;
                    for (i2 = 16; i17 < i2; i2 = 16) {
                        f fVar9 = fVarArr[i17 + 15];
                        f fVar10 = new f(23);
                        fVarArr[i2 + i17] = fVar10;
                        k(fVar9, fVar7, fVar10, aVar);
                        i17++;
                    }
                    a3.b bVar2 = new a3.b();
                    ub.a.e(0, 0, iArr3, (int[]) bVar2.f162f);
                    ub.a.e(0, 0, iArr4, (int[]) bVar2.f163g);
                    ub.a.l((int[]) bVar2.f164h);
                    ub.a.e(0, 0, (int[]) bVar2.f162f, (int[]) bVar2.f165i);
                    ub.a.e(0, 0, (int[]) bVar2.f163g, (int[]) bVar2.f166j);
                    f[] fVarArr2 = new f[4];
                    for (int i18 = 0; i18 < 4; i18++) {
                        fVarArr2[i18] = new f(23);
                    }
                    f fVar11 = new f(23);
                    int i19 = 0;
                    int i20 = 32;
                    while (i19 < i13) {
                        int i21 = i20 + 1;
                        f fVar12 = new f(23);
                        fVarArr[i20] = fVar12;
                        for (int i22 = i15; i22 < i14; i22++) {
                            if (i22 == 0) {
                                l(bVar2, fVar12);
                            } else {
                                l(bVar2, fVar11);
                                k(fVar12, fVar11, fVar12, aVar);
                            }
                            m(bVar2);
                            l(bVar2, fVarArr2[i22]);
                            if (i19 + i22 != 10) {
                                for (int i23 = 1; i23 < i13; i23++) {
                                    m(bVar2);
                                }
                            }
                        }
                        int[] iArr7 = (int[]) fVar12.f4653g;
                        for (int i24 = i15; i24 < 10; i24++) {
                            iArr7[i24] = -iArr7[i24];
                        }
                        int[] iArr8 = (int[]) fVar12.f4656j;
                        for (int i25 = i15; i25 < 10; i25++) {
                            iArr8[i25] = -iArr8[i25];
                        }
                        int i26 = i15;
                        i20 = i21;
                        while (i26 < 3) {
                            int i27 = 1 << i26;
                            int i28 = i15;
                            while (i28 < i27) {
                                f fVar13 = new f(23);
                                fVarArr[i20] = fVar13;
                                k(fVarArr[i20 - i27], fVarArr2[i26], fVar13, aVar);
                                i28++;
                                i20++;
                            }
                            i26++;
                            i15 = 0;
                        }
                        i19++;
                        i13 = 8;
                        i14 = 4;
                        i15 = 0;
                    }
                    i(fVarArr);
                    int i29 = 16;
                    f10619i = new h[16];
                    int i30 = 0;
                    while (i30 < i29) {
                        f fVar14 = fVarArr[i30];
                        h[] hVarArr = f10619i;
                        h hVar = new h(2);
                        hVarArr[i30] = hVar;
                        int[] iArr9 = (int[]) fVar14.f4653g;
                        ub.a.j(iArr9, (int[]) fVar14.f4655i, iArr9);
                        int[] iArr10 = (int[]) fVar14.f4654h;
                        ub.a.j(iArr10, (int[]) fVar14.f4655i, iArr10);
                        ub.a.b((int[]) fVar14.f4654h, (int[]) fVar14.f4653g, (int[]) hVar.f10130b, (int[]) hVar.f10129a);
                        ub.a.j((int[]) fVar14.f4653g, (int[]) fVar14.f4654h, (int[]) hVar.f10131c);
                        int[] iArr11 = (int[]) hVar.f10131c;
                        ub.a.j(iArr11, f10617g, iArr11);
                        ub.a.k((int[]) hVar.f10129a);
                        ub.a.k((int[]) hVar.f10130b);
                        ub.a.k((int[]) hVar.f10131c);
                        i30++;
                        i29 = 16;
                    }
                    f10620j = new h[i29];
                    for (int i31 = 0; i31 < i29; i31++) {
                        f fVar15 = fVarArr[i29 + i31];
                        h[] hVarArr2 = f10620j;
                        h hVar2 = new h(2);
                        hVarArr2[i31] = hVar2;
                        int[] iArr12 = (int[]) fVar15.f4653g;
                        ub.a.j(iArr12, (int[]) fVar15.f4655i, iArr12);
                        int[] iArr13 = (int[]) fVar15.f4654h;
                        ub.a.j(iArr13, (int[]) fVar15.f4655i, iArr13);
                        ub.a.b((int[]) fVar15.f4654h, (int[]) fVar15.f4653g, (int[]) hVar2.f10130b, (int[]) hVar2.f10129a);
                        ub.a.j((int[]) fVar15.f4653g, (int[]) fVar15.f4654h, (int[]) hVar2.f10131c);
                        int[] iArr14 = (int[]) hVar2.f10131c;
                        ub.a.j(iArr14, f10617g, iArr14);
                        ub.a.k((int[]) hVar2.f10129a);
                        ub.a.k((int[]) hVar2.f10130b);
                        ub.a.k((int[]) hVar2.f10131c);
                    }
                    f10621k = new int[1920];
                    int[] iArr15 = new int[10];
                    int[] iArr16 = new int[10];
                    int[] iArr17 = new int[10];
                    int i32 = 0;
                    for (int i33 = 32; i33 < 96; i33++) {
                        f fVar16 = fVarArr[i33];
                        int[] iArr18 = (int[]) fVar16.f4653g;
                        ub.a.j(iArr18, (int[]) fVar16.f4655i, iArr18);
                        int[] iArr19 = (int[]) fVar16.f4654h;
                        ub.a.j(iArr19, (int[]) fVar16.f4655i, iArr19);
                        ub.a.b((int[]) fVar16.f4654h, (int[]) fVar16.f4653g, iArr16, iArr15);
                        ub.a.j((int[]) fVar16.f4653g, (int[]) fVar16.f4654h, iArr17);
                        ub.a.j(iArr17, f10617g, iArr17);
                        ub.a.k(iArr15);
                        ub.a.k(iArr16);
                        ub.a.k(iArr17);
                        ub.a.e(0, i32, iArr15, f10621k);
                        ub.a.e(0, i32 + 10, iArr16, f10621k);
                        ub.a.e(0, i32 + 20, iArr17, f10621k);
                        i32 += 30;
                    }
                    i11 = 8;
                }
            } finally {
            }
        }
        int[] iArr20 = new int[i11];
        b(bArr, iArr20);
        int i34 = ~iArr20[0];
        int[] iArr21 = f10622l;
        long j2 = (-(i34 & 1)) & 4294967295L;
        long j4 = 0;
        for (int i35 = 0; i35 < 8; i35++) {
            long j10 = (iArr20[i35] & 4294967295L) + (iArr21[i35] & j2) + j4;
            iArr20[i35] = (int) j10;
            j4 = j10 >>> c10;
        }
        int i36 = i10;
        int i37 = 8;
        while (true) {
            i37--;
            if (i37 < 0) {
                break;
            }
            int i38 = iArr20[i37];
            iArr20[i37] = (i36 << 31) | (i38 >>> 1);
            i36 = i38;
        }
        int i39 = 0;
        while (true) {
            i12 = 7;
            if (i39 >= 8) {
                break;
            }
            iArr20[i39] = m.h(m.h(m.h(m.h(iArr20[i39], 11141290, 7), 52428, 14), 15728880, 4), 65280, 8);
            i39++;
        }
        int[] iArr22 = new int[10];
        int[] iArr23 = new int[10];
        int[] iArr24 = new int[10];
        int[] iArr25 = new int[10];
        int[] iArr26 = (int[]) bVar.f162f;
        for (int i40 = 0; i40 < 10; i40++) {
            iArr26[i40] = 0;
        }
        ub.a.l((int[]) bVar.f163g);
        ub.a.l((int[]) bVar.f164h);
        int[] iArr27 = (int[]) bVar.f165i;
        for (int i41 = 0; i41 < 10; i41++) {
            iArr27[i41] = 0;
        }
        ub.a.l((int[]) bVar.f166j);
        int i42 = 28;
        int i43 = 0;
        while (true) {
            int i44 = i43;
            int i45 = 0;
            while (i45 < 8) {
                int i46 = iArr20[i45] >>> i42;
                int i47 = (i46 >>> 3) & 1;
                int i48 = (i46 ^ (-i47)) & i12;
                int i49 = i45 * 240;
                for (int i50 = 0; i50 < 8; i50++) {
                    int i51 = ((i50 ^ i48) - 1) >> 31;
                    ub.a.c(i51, i49, f10621k, iArr22);
                    ub.a.c(i51, i49 + 10, f10621k, iArr23);
                    ub.a.c(i51, i49 + 20, f10621k, iArr24);
                    i49 += 30;
                }
                int i52 = i44 ^ i47;
                ub.a.d(i52, (int[]) bVar.f162f);
                ub.a.d(i52, (int[]) bVar.f165i);
                int[] iArr28 = (int[]) bVar.f162f;
                int[] iArr29 = (int[]) bVar.f163g;
                int[] iArr30 = (int[]) bVar.f165i;
                int[] iArr31 = (int[]) bVar.f166j;
                ub.a.b(iArr29, iArr28, iArr29, iArr28);
                ub.a.j(iArr28, iArr22, iArr28);
                ub.a.j(iArr29, iArr23, iArr29);
                ub.a.j(iArr30, iArr31, iArr25);
                ub.a.j(iArr25, iArr24, iArr25);
                ub.a.b(iArr29, iArr28, iArr31, iArr30);
                int[] iArr32 = (int[]) bVar.f164h;
                ub.a.b(iArr32, iArr25, iArr29, iArr28);
                ub.a.j(iArr28, iArr29, iArr32);
                ub.a.j(iArr28, iArr30, (int[]) bVar.f162f);
                ub.a.j(iArr29, iArr31, iArr29);
                i45++;
                i44 = i47;
                i12 = 7;
            }
            i42 -= 4;
            if (i42 < 0) {
                ub.a.d(i44, (int[]) bVar.f162f);
                ub.a.d(i44, (int[]) bVar.f165i);
                return;
            } else {
                m(bVar);
                i43 = i44;
                i12 = 7;
            }
        }
    }
}

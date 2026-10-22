package u7;

import a8.b;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import x.f;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f5783a = {-19, -1, -1, -1, -1, -1, -1, Integer.MAX_VALUE};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f5784b = {-32595792, -7943725, 4688975, 3500415, 6194736, 33281959, -12573105, -1002827, 163343, 5703241};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f5785c = {-1, -1, -1, -1, -1, -1, -1, -2, -1, -1, -1, -1, -1, -1};

    public static int A(int[] iArr) {
        int i8 = 0;
        for (int i9 = 0; i9 < 10; i9++) {
            i8 |= iArr[i9];
        }
        return (((i8 >>> 1) | (i8 & 1)) - 1) >> 31;
    }

    public static int B(int[] iArr) {
        int i8 = 0;
        for (int i9 = 0; i9 < 16; i9++) {
            i8 |= iArr[i9];
        }
        return (((i8 >>> 1) | (i8 & 1)) - 1) >> 31;
    }

    public static void C(int i8, int[] iArr, int[] iArr2) {
        int i9 = iArr[0];
        int i10 = iArr[1];
        int i11 = iArr[2];
        int i12 = iArr[3];
        int i13 = iArr[4];
        int i14 = iArr[5];
        int i15 = iArr[6];
        int i16 = iArr[7];
        int i17 = iArr[8];
        int i18 = iArr[9];
        int i19 = iArr[10];
        int i20 = iArr[11];
        int i21 = iArr[12];
        int i22 = iArr[13];
        int i23 = iArr[14];
        int i24 = iArr[15];
        long j4 = i8;
        long j8 = i10 * j4;
        int i25 = ((int) j8) & 268435455;
        long j9 = j8 >>> 28;
        long j10 = i14 * j4;
        int i26 = ((int) j10) & 268435455;
        long j11 = j10 >>> 28;
        long j12 = i18 * j4;
        int i27 = ((int) j12) & 268435455;
        long j13 = j12 >>> 28;
        long j14 = i22 * j4;
        int i28 = ((int) j14) & 268435455;
        long j15 = j14 >>> 28;
        long j16 = (i11 * j4) + j9;
        iArr2[2] = ((int) j16) & 268435455;
        long j17 = j16 >>> 28;
        long j18 = (i15 * j4) + j11;
        iArr2[6] = ((int) j18) & 268435455;
        long j19 = j18 >>> 28;
        long j20 = (i19 * j4) + j13;
        iArr2[10] = ((int) j20) & 268435455;
        long j21 = (i23 * j4) + j15;
        iArr2[14] = ((int) j21) & 268435455;
        long j22 = j21 >>> 28;
        long j23 = (i12 * j4) + j17;
        iArr2[3] = ((int) j23) & 268435455;
        long j24 = (i16 * j4) + j19;
        iArr2[7] = ((int) j24) & 268435455;
        long j25 = (i20 * j4) + (j20 >>> 28);
        iArr2[11] = ((int) j25) & 268435455;
        long j26 = j25 >>> 28;
        long j27 = (i24 * j4) + j22;
        iArr2[15] = ((int) j27) & 268435455;
        long j28 = j27 >>> 28;
        long j29 = (i13 * j4) + (j23 >>> 28);
        iArr2[4] = ((int) j29) & 268435455;
        long j30 = j29 >>> 28;
        long j31 = (i17 * j4) + (j24 >>> 28) + j28;
        iArr2[8] = ((int) j31) & 268435455;
        long j32 = (i21 * j4) + j26;
        iArr2[12] = ((int) j32) & 268435455;
        long j33 = j32 >>> 28;
        long j34 = (i9 * j4) + j28;
        iArr2[0] = ((int) j34) & 268435455;
        iArr2[1] = i25 + ((int) (j34 >>> 28));
        iArr2[5] = i26 + ((int) j30);
        iArr2[9] = i27 + ((int) (j31 >>> 28));
        iArr2[13] = i28 + ((int) j33);
    }

    public static void D(int[] iArr, int[] iArr2) {
        int i8 = iArr[0];
        int i9 = iArr[1];
        int i10 = iArr[2];
        int i11 = iArr[3];
        int i12 = iArr[4];
        int i13 = iArr[5];
        int i14 = iArr[6];
        int i15 = iArr[7];
        int i16 = iArr[8];
        long j4 = 121666;
        long j8 = i10 * j4;
        int i17 = ((int) j8) & 33554431;
        long j9 = j8 >> 25;
        long j10 = i12 * j4;
        int i18 = ((int) j10) & 33554431;
        long j11 = i15 * j4;
        long j12 = iArr[9] * j4;
        int i19 = ((int) j12) & 33554431;
        long j13 = (i8 * j4) + ((j12 >> 25) * 38);
        iArr2[0] = ((int) j13) & 67108863;
        long j14 = (i13 * j4) + (j10 >> 25);
        iArr2[5] = ((int) j14) & 67108863;
        long j15 = (i9 * j4) + (j13 >> 26);
        iArr2[1] = ((int) j15) & 67108863;
        long j16 = (i11 * j4) + j9;
        iArr2[3] = ((int) j16) & 67108863;
        long j17 = (i14 * j4) + (j14 >> 26);
        iArr2[6] = ((int) j17) & 67108863;
        long j18 = (i16 * j4) + (j11 >> 25);
        iArr2[8] = ((int) j18) & 67108863;
        iArr2[2] = ((int) (j15 >> 26)) + i17;
        iArr2[4] = i18 + ((int) (j16 >> 26));
        iArr2[7] = (((int) j11) & 33554431) + ((int) (j17 >> 26));
        iArr2[9] = i19 + ((int) (j18 >> 26));
    }

    public static void E(int[] iArr, int[] iArr2, int[] iArr3) {
        int i8 = iArr[0];
        int i9 = iArr2[0];
        int i10 = iArr[1];
        int i11 = iArr2[1];
        int i12 = iArr[2];
        int i13 = iArr2[2];
        int i14 = iArr[3];
        int i15 = iArr2[3];
        int i16 = iArr[4];
        int i17 = iArr2[4];
        int i18 = iArr[5];
        int i19 = iArr2[5];
        int i20 = iArr[6];
        int i21 = iArr2[6];
        int i22 = iArr[7];
        int i23 = iArr2[7];
        int i24 = iArr[8];
        int i25 = iArr2[8];
        int i26 = iArr[9];
        int i27 = iArr2[9];
        long j4 = i8;
        long j8 = i9;
        long j9 = j4 * j8;
        long j10 = i11;
        long j11 = j4 * j10;
        long j12 = i10;
        long j13 = (j12 * j8) + j11;
        long j14 = i13;
        long j15 = (j12 * j10) + (j4 * j14);
        long j16 = i12;
        long j17 = (j16 * j8) + j15;
        long j18 = ((j16 * j10) + (j12 * j14)) << 1;
        long j19 = i15;
        long j20 = j4 * j19;
        long j21 = i14;
        long jH = b.h(j21, j8, j20, j18);
        long j22 = (j16 * j14) << 1;
        long j23 = i17;
        long j24 = i16;
        long jH2 = b.h(j24, j8, (j21 * j10) + (j12 * j19) + (j4 * j23), j22);
        long j25 = ((j24 * j10) + ((j21 * j14) + ((j16 * j19) + (j12 * j23)))) << 1;
        long j26 = (j21 * j19) + (((j24 * j14) + (j16 * j23)) << 1);
        long j27 = (j24 * j19) + (j21 * j23);
        long j28 = (j24 * j23) << 1;
        long j29 = i18;
        long j30 = i19;
        long j31 = j29 * j30;
        long j32 = i21;
        long j33 = j29 * j32;
        long j34 = i20;
        long j35 = (j34 * j30) + j33;
        long j36 = i23;
        long j37 = (j34 * j32) + (j29 * j36);
        long j38 = i22;
        long j39 = i25;
        long j40 = j29 * j39;
        long j41 = i24;
        long jH3 = b.h(j41, j30, j40, ((j38 * j32) + (j34 * j36)) << 1);
        long j42 = i27;
        long j43 = (j41 * j32) + (j34 * j39) + (j29 * j42);
        long j44 = i26;
        long jH4 = b.h(j44, j30, j43, (j38 * j36) << 1);
        long j45 = j9 - (((j32 * j44) + ((j41 * j36) + ((j38 * j39) + (j34 * j42)))) * 76);
        long j46 = j13 - (((j41 * j39) + (((j36 * j44) + (j38 * j42)) << 1)) * 38);
        long j47 = j17 - (((j44 * j39) + (j41 * j42)) * 38);
        long j48 = jH - ((j42 * j44) * 76);
        long j49 = j25 - j31;
        long j50 = j26 - j35;
        long j51 = j27 - ((j38 * j30) + j37);
        long j52 = j28 - jH3;
        long j53 = i8 + i18;
        long j54 = i9 + i19;
        long j55 = j53 * j54;
        long j56 = i11 + i21;
        long j57 = j53 * j56;
        long j58 = i10 + i20;
        long j59 = (j58 * j54) + j57;
        long j60 = i13 + i23;
        long j61 = i12 + i22;
        long j62 = (j61 * j54) + (j58 * j56) + (j53 * j60);
        long j63 = ((j61 * j56) + (j58 * j60)) << 1;
        long j64 = i15 + i25;
        long j65 = i14 + i24;
        long jH5 = b.h(j65, j54, j53 * j64, j63);
        long j66 = i17 + i27;
        long j67 = i16 + i26;
        long jH6 = b.h(j67, j54, (j65 * j56) + (j58 * j64) + (j53 * j66), (j61 * j60) << 1);
        long j68 = ((j56 * j67) + ((j65 * j60) + ((j61 * j64) + (j58 * j66)))) << 1;
        long j69 = (j65 * j64) + (((j60 * j67) + (j61 * j66)) << 1);
        long j70 = (j67 * j64) + (j65 * j66);
        long j71 = (j66 * j67) << 1;
        long j72 = (jH5 - j48) + j52;
        int i28 = ((int) j72) & 67108863;
        long j73 = ((jH6 - jH2) - jH4) + (j72 >> 26);
        int i29 = ((int) j73) & 33554431;
        long j74 = ((((j73 >> 25) + j68) - j49) * 38) + j45;
        iArr3[0] = ((int) j74) & 67108863;
        long j75 = ((j69 - j50) * 38) + j46 + (j74 >> 26);
        iArr3[1] = ((int) j75) & 67108863;
        long j76 = ((j70 - j51) * 38) + j47 + (j75 >> 26);
        iArr3[2] = ((int) j76) & 33554431;
        long j77 = ((j71 - j52) * 38) + j48 + (j76 >> 25);
        iArr3[3] = ((int) j77) & 67108863;
        long jH7 = b.h(jH4, 38L, jH2, j77 >> 26);
        iArr3[4] = ((int) jH7) & 33554431;
        long j78 = (j55 - j45) + j49 + (jH7 >> 25);
        iArr3[5] = ((int) j78) & 67108863;
        long j79 = (j59 - j46) + j50 + (j78 >> 26);
        iArr3[6] = ((int) j79) & 67108863;
        long j80 = (j62 - j47) + j51 + (j79 >> 26);
        iArr3[7] = ((int) j80) & 33554431;
        long j81 = (j80 >> 25) + i28;
        iArr3[8] = ((int) j81) & 67108863;
        iArr3[9] = i29 + ((int) (j81 >> 26));
    }

    public static void F(int[] iArr, int[] iArr2, int[] iArr3) {
        int i8 = iArr[0];
        int i9 = iArr[1];
        int i10 = iArr[2];
        int i11 = iArr[3];
        int i12 = iArr[4];
        int i13 = iArr[5];
        int i14 = iArr[6];
        int i15 = iArr[7];
        int i16 = iArr[8];
        int i17 = iArr[9];
        int i18 = iArr[10];
        int i19 = iArr[11];
        int i20 = iArr[12];
        int i21 = iArr[13];
        int i22 = iArr[14];
        int i23 = iArr[15];
        int i24 = iArr2[0];
        int i25 = iArr2[1];
        int i26 = iArr2[2];
        int i27 = iArr2[3];
        int i28 = iArr2[4];
        int i29 = iArr2[5];
        int i30 = iArr2[6];
        int i31 = iArr2[7];
        int i32 = iArr2[8];
        int i33 = iArr2[9];
        int i34 = iArr2[10];
        int i35 = iArr2[11];
        int i36 = iArr2[12];
        int i37 = iArr2[13];
        int i38 = iArr2[14];
        int i39 = iArr2[15];
        int i40 = i8 + i16;
        int i41 = i9 + i17;
        int i42 = i10 + i18;
        int i43 = i11 + i19;
        int i44 = i12 + i20;
        int i45 = i13 + i21;
        int i46 = i14 + i22;
        int i47 = i15 + i23;
        int i48 = i24 + i32;
        int i49 = i25 + i33;
        int i50 = i26 + i34;
        int i51 = i27 + i35;
        int i52 = i28 + i36;
        int i53 = i29 + i37;
        int i54 = i30 + i38;
        int i55 = i31 + i39;
        long j4 = i8;
        long j8 = i24;
        long j9 = j4 * j8;
        long j10 = i15;
        long j11 = i25;
        long j12 = j10 * j11;
        long j13 = i14;
        long j14 = i26;
        long j15 = (j13 * j14) + j12;
        long j16 = i13;
        long j17 = i27;
        long j18 = i12;
        long j19 = i28;
        long j20 = i11;
        long j21 = i29;
        long j22 = (j20 * j21) + (j18 * j19) + (j16 * j17) + j15;
        long j23 = i10;
        long j24 = i30;
        long j25 = i9;
        long j26 = i31;
        long j27 = j25 * j26;
        long j28 = i16;
        long j29 = i32;
        long j30 = j28 * j29;
        long j31 = i23;
        long j32 = i33;
        long j33 = j31 * j32;
        long j34 = i22;
        long j35 = i34;
        long j36 = (j34 * j35) + j33;
        long j37 = i21;
        long j38 = i35;
        long j39 = (j37 * j38) + j36;
        long j40 = i20;
        long j41 = i36;
        long j42 = (j40 * j41) + j39;
        long j43 = i19;
        long j44 = i37;
        long j45 = (j43 * j44) + j42;
        long j46 = i18;
        long j47 = i38;
        long j48 = (j46 * j47) + j45;
        long j49 = i17;
        long j50 = i39;
        long j51 = (j49 * j50) + j48;
        long j52 = i40;
        long j53 = i48;
        long j54 = j52 * j53;
        long j55 = i47;
        long j56 = i49;
        long j57 = j55 * j56;
        long j58 = i46;
        long j59 = i50;
        long j60 = (j58 * j59) + j57;
        long j61 = i45;
        long j62 = i51;
        long j63 = (j61 * j62) + j60;
        long j64 = i44;
        long j65 = i52;
        long j66 = (j64 * j65) + j63;
        long j67 = i43;
        long j68 = i53;
        long j69 = (j67 * j68) + j66;
        long j70 = i42;
        long j71 = i54;
        long j72 = (j70 * j71) + j69;
        long j73 = i41;
        long j74 = i55;
        long j75 = (j73 * j74) + j72;
        long j76 = ((j9 + j30) + j75) - (j27 + ((j23 * j24) + j22));
        int i56 = ((int) j76) & 268435455;
        long j77 = ((j51 + j54) - j9) + j75;
        int i57 = ((int) j77) & 268435455;
        long j78 = j77 >>> 28;
        long j79 = (j4 * j11) + (j25 * j8);
        long j80 = (j46 * j50) + (j43 * j47) + (j40 * j44) + (j37 * j41) + (j34 * j38) + (j31 * j35);
        long j81 = (j52 * j56) + (j73 * j53);
        long j82 = (j70 * j74) + (j67 * j71) + (j64 * j68) + (j61 * j65) + (j58 * j62) + (j55 * j59);
        long j83 = (((j79 + ((j28 * j32) + (j49 * j29))) + j82) - ((j23 * j26) + ((j20 * j24) + ((j18 * j21) + ((j16 * j19) + ((j13 * j17) + (j10 * j14))))))) + (j76 >>> 28);
        int i58 = ((int) j83) & 268435455;
        long j84 = j83 >>> 28;
        long j85 = ((j80 + j81) - j79) + j82 + j78;
        int i59 = ((int) j85) & 268435455;
        long j86 = j85 >>> 28;
        long j87 = (j4 * j14) + (j25 * j11) + (j23 * j8);
        long j88 = (j43 * j50) + (j40 * j47) + (j37 * j44) + (j34 * j41) + (j31 * j38);
        long j89 = (j52 * j59) + (j73 * j56) + (j70 * j53);
        long j90 = (j67 * j74) + (j64 * j71) + (j61 * j68) + (j58 * j65) + (j55 * j62);
        long j91 = (((j87 + ((j28 * j35) + ((j49 * j32) + (j46 * j29)))) + j90) - ((j20 * j26) + ((j18 * j24) + ((j16 * j21) + ((j13 * j19) + (j10 * j17)))))) + j84;
        int i60 = ((int) j91) & 268435455;
        long j92 = j91 >>> 28;
        long j93 = ((j88 + j89) - j87) + j90 + j86;
        int i61 = ((int) j93) & 268435455;
        long j94 = j93 >>> 28;
        long j95 = (j4 * j17) + (j25 * j14) + (j23 * j11) + (j20 * j8);
        long j96 = (j40 * j50) + (j37 * j47) + (j34 * j44) + (j31 * j41);
        long j97 = (j52 * j62) + (j73 * j59) + (j70 * j56) + (j67 * j53);
        long j98 = (j64 * j74) + (j61 * j71) + (j58 * j68) + (j55 * j65);
        long j99 = (((j95 + ((j28 * j38) + ((j49 * j35) + ((j46 * j32) + (j43 * j29))))) + j98) - ((j18 * j26) + ((j16 * j24) + ((j13 * j21) + (j10 * j19))))) + j92;
        int i62 = ((int) j99) & 268435455;
        long j100 = j99 >>> 28;
        long j101 = ((j96 + j97) - j95) + j98 + j94;
        int i63 = ((int) j101) & 268435455;
        long j102 = j101 >>> 28;
        long j103 = (j4 * j19) + (j25 * j17) + (j23 * j14) + (j20 * j11) + (j18 * j8);
        long j104 = (j37 * j50) + (j34 * j47) + (j31 * j44);
        long j105 = (j52 * j65) + (j73 * j62) + (j70 * j59) + (j67 * j56) + (j64 * j53);
        long j106 = (j61 * j74) + (j58 * j71) + (j55 * j68);
        long j107 = (((j103 + ((j28 * j41) + ((j49 * j38) + ((j46 * j35) + ((j43 * j32) + (j40 * j29)))))) + j106) - ((j16 * j26) + ((j13 * j24) + (j10 * j21)))) + j100;
        int i64 = ((int) j107) & 268435455;
        long j108 = j107 >>> 28;
        long j109 = ((j104 + j105) - j103) + j106 + j102;
        int i65 = ((int) j109) & 268435455;
        long j110 = j109 >>> 28;
        long j111 = (j4 * j21) + (j25 * j19) + (j23 * j17) + (j20 * j14) + (j18 * j11) + (j16 * j8);
        long j112 = (j34 * j50) + (j31 * j47);
        long j113 = (j52 * j68) + (j73 * j65) + (j70 * j62) + (j67 * j59) + (j64 * j56) + (j61 * j53);
        long j114 = (j58 * j74) + (j55 * j71);
        long j115 = (((j111 + ((j28 * j44) + ((j49 * j41) + ((j46 * j38) + ((j43 * j35) + ((j40 * j32) + (j37 * j29))))))) + j114) - ((j13 * j26) + (j10 * j24))) + j108;
        int i66 = ((int) j115) & 268435455;
        long j116 = j115 >>> 28;
        long j117 = ((j112 + j113) - j111) + j114 + j110;
        int i67 = ((int) j117) & 268435455;
        long j118 = j117 >>> 28;
        long j119 = (j4 * j24) + (j25 * j21) + (j23 * j19) + (j20 * j17) + (j18 * j14) + (j16 * j11) + (j13 * j8);
        long j120 = j31 * j50;
        long j121 = (j52 * j71) + (j73 * j68) + (j70 * j65) + (j67 * j62) + (j64 * j59) + (j61 * j56) + (j58 * j53);
        long j122 = j55 * j74;
        long j123 = (((j119 + ((j28 * j47) + ((j49 * j44) + ((j46 * j41) + ((j43 * j38) + ((j40 * j35) + ((j37 * j32) + (j34 * j29)))))))) + j122) - (j10 * j26)) + j116;
        int i68 = ((int) j123) & 268435455;
        long j124 = j123 >>> 28;
        long j125 = ((j120 + j121) - j119) + j122 + j118;
        long j126 = j20 * j19;
        long j127 = (j4 * j26) + (j25 * j24) + (j23 * j21) + j126 + (j18 * j17) + (j16 * j14) + (j13 * j11) + (j8 * j10);
        long j128 = (j28 * j50) + (j49 * j47) + (j46 * j44) + (j43 * j41) + (j40 * j38) + (j37 * j35) + (j34 * j32) + (j31 * j29) + j127 + j124;
        int i69 = ((int) j128) & 268435455;
        long j129 = (((j52 * j74) + ((j73 * j71) + ((j70 * j68) + ((j67 * j65) + ((j64 * j62) + ((j61 * j59) + ((j58 * j56) + (j55 * j53)))))))) - j127) + (j125 >>> 28);
        long j130 = j129 >>> 28;
        long j131 = (j128 >>> 28) + j130 + i57;
        long j132 = j130 + i56;
        iArr3[0] = ((int) j132) & 268435455;
        iArr3[1] = i58 + ((int) (j132 >>> 28));
        iArr3[2] = i60;
        iArr3[3] = i62;
        iArr3[4] = i64;
        iArr3[5] = i66;
        iArr3[6] = i68;
        iArr3[7] = i69;
        iArr3[8] = ((int) j131) & 268435455;
        iArr3[9] = i59 + ((int) (j131 >>> 28));
        iArr3[10] = i61;
        iArr3[11] = i63;
        iArr3[12] = i65;
        iArr3[13] = i67;
        iArr3[14] = ((int) j125) & 268435455;
        iArr3[15] = ((int) j129) & 268435455;
    }

    public static void G(int[] iArr, int[] iArr2) {
        for (int i8 = 0; i8 < 10; i8++) {
            iArr2[i8] = -iArr[i8];
        }
    }

    public static void H(int[] iArr) {
        int i8 = (iArr[9] >>> 23) & 1;
        J(i8, iArr);
        J(-i8, iArr);
    }

    public static void I(int[] iArr) {
        iArr[0] = 1;
        for (int i8 = 1; i8 < 10; i8++) {
            iArr[i8] = 0;
        }
    }

    public static void J(int i8, int[] iArr) {
        int i9 = iArr[9];
        long j4 = (((i9 >> 24) + i8) * 19) + iArr[0];
        iArr[0] = ((int) j4) & 67108863;
        long j8 = (j4 >> 26) + iArr[1];
        iArr[1] = ((int) j8) & 67108863;
        long j9 = (j8 >> 26) + iArr[2];
        iArr[2] = ((int) j9) & 33554431;
        long j10 = (j9 >> 25) + iArr[3];
        iArr[3] = ((int) j10) & 67108863;
        long j11 = (j10 >> 26) + iArr[4];
        iArr[4] = ((int) j11) & 33554431;
        long j12 = (j11 >> 25) + iArr[5];
        iArr[5] = ((int) j12) & 67108863;
        long j13 = (j12 >> 26) + iArr[6];
        iArr[6] = ((int) j13) & 67108863;
        long j14 = (j13 >> 26) + iArr[7];
        iArr[7] = 33554431 & ((int) j14);
        long j15 = (j14 >> 25) + iArr[8];
        iArr[8] = 67108863 & ((int) j15);
        iArr[9] = (16777215 & i9) + ((int) (j15 >> 26));
    }

    public static void K(int i8, int[] iArr) {
        int i9;
        int i10 = iArr[15];
        int i11 = i10 & 268435455;
        long j4 = (i10 >>> 28) + i8;
        int i12 = 0;
        long j8 = j4;
        while (true) {
            if (i12 >= 8) {
                break;
            }
            long j9 = j8 + (4294967295L & iArr[i12]);
            iArr[i12] = ((int) j9) & 268435455;
            j8 = j9 >> 28;
            i12++;
        }
        long j10 = j8 + j4;
        for (i9 = 8; i9 < 15; i9++) {
            long j11 = j10 + (iArr[i9] & 4294967295L);
            iArr[i9] = ((int) j11) & 268435455;
            j10 = j11 >> 28;
        }
        iArr[15] = i11 + ((int) j10);
    }

    public static void L(int i8, int[] iArr, int[] iArr2) {
        M(iArr, iArr2);
        while (true) {
            i8--;
            if (i8 <= 0) {
                return;
            } else {
                M(iArr2, iArr2);
            }
        }
    }

    public static void M(int[] iArr, int[] iArr2) {
        int i8 = iArr[0];
        int i9 = iArr[1];
        int i10 = iArr[2];
        int i11 = iArr[3];
        int i12 = iArr[4];
        int i13 = iArr[5];
        int i14 = iArr[6];
        int i15 = iArr[7];
        int i16 = iArr[8];
        int i17 = iArr[9];
        long j4 = i8;
        long j8 = j4 * j4;
        long j9 = i9 * 2;
        long j10 = j4 * j9;
        long j11 = i10 * 2;
        long j12 = j4 * j11;
        long j13 = i9;
        long j14 = (j13 * j13) + j12;
        long j15 = i11 * 2;
        long j16 = (j4 * j15) + (j9 * j11);
        long j17 = i12 * 2;
        long j18 = (j13 * j15) + (j4 * j17) + (i10 * j11);
        long j19 = (j11 * j15) + (j9 * j17);
        long j20 = j11 * j17;
        long j21 = i11;
        long j22 = (j21 * j21) + j20;
        long j23 = j21 * j17;
        long j24 = i13;
        long j25 = j24 * j24;
        long j26 = i14 * 2;
        long j27 = j24 * j26;
        long j28 = i15 * 2;
        long j29 = j24 * j28;
        long j30 = i14;
        long j31 = (j30 * j30) + j29;
        long j32 = j26 * j28;
        long j33 = i16 * 2;
        long j34 = i17 * 2;
        long j35 = (j30 * j33) + (j24 * j34) + (i15 * j28);
        long j36 = (j28 * j33) + (j26 * j34);
        long j37 = j28 * j34;
        long j38 = i16;
        long j39 = j8 - (j36 * 38);
        long j40 = j10 - (((j38 * j38) + j37) * 38);
        long j41 = j14 - ((j38 * j34) * 38);
        long j42 = j16 - ((i17 * j34) * 38);
        long j43 = j19 - j25;
        long j44 = j22 - j27;
        long j45 = j23 - j31;
        long j46 = (i12 * j17) - ((j24 * j33) + j32);
        int i18 = i9 + i14;
        int i19 = i10 + i15;
        int i20 = i11 + i16;
        int i21 = i12 + i17;
        long j47 = i8 + i13;
        long j48 = i18 * 2;
        long j49 = j47 * j48;
        long j50 = i19 * 2;
        long j51 = i18;
        long j52 = (j51 * j51) + (j47 * j50);
        long j53 = i20 * 2;
        long j54 = i21 * 2;
        long j55 = i20;
        long j56 = i21 * j54;
        long j57 = (((j47 * j53) + (j48 * j50)) - j42) + j46;
        int i22 = ((int) j57) & 67108863;
        long j58 = ((((j51 * j53) + ((j47 * j54) + (i19 * j50))) - j18) - j35) + (j57 >> 26);
        int i23 = ((int) j58) & 33554431;
        long j59 = ((((j58 >> 25) + ((j53 * j50) + (j48 * j54))) - j43) * 38) + j39;
        iArr2[0] = ((int) j59) & 67108863;
        long j60 = ((((j55 * j55) + (j50 * j54)) - j44) * 38) + j40 + (j59 >> 26);
        iArr2[1] = ((int) j60) & 67108863;
        long j61 = (((j55 * j54) - j45) * 38) + j41 + (j60 >> 26);
        iArr2[2] = ((int) j61) & 33554431;
        long j62 = ((j56 - j46) * 38) + j42 + (j61 >> 25);
        iArr2[3] = ((int) j62) & 67108863;
        long jH = b.h(j35, 38L, j18, j62 >> 26);
        iArr2[4] = ((int) jH) & 33554431;
        long j63 = ((j47 * j47) - j39) + j43 + (jH >> 25);
        iArr2[5] = ((int) j63) & 67108863;
        long j64 = (j49 - j40) + j44 + (j63 >> 26);
        iArr2[6] = ((int) j64) & 67108863;
        long j65 = (j52 - j41) + j45 + (j64 >> 26);
        iArr2[7] = ((int) j65) & 33554431;
        long j66 = (j65 >> 25) + i22;
        iArr2[8] = ((int) j66) & 67108863;
        iArr2[9] = i23 + ((int) (j66 >> 26));
    }

    public static void N(int i8, int[] iArr, int[] iArr2) {
        O(iArr, iArr2);
        while (true) {
            i8--;
            if (i8 <= 0) {
                return;
            } else {
                O(iArr2, iArr2);
            }
        }
    }

    public static void O(int[] iArr, int[] iArr2) {
        int i8 = iArr[0];
        int i9 = iArr[1];
        int i10 = iArr[2];
        int i11 = iArr[3];
        int i12 = iArr[4];
        int i13 = iArr[5];
        int i14 = iArr[6];
        int i15 = iArr[7];
        int i16 = iArr[8];
        int i17 = iArr[9];
        int i18 = iArr[10];
        int i19 = iArr[11];
        int i20 = iArr[12];
        int i21 = iArr[13];
        int i22 = iArr[14];
        int i23 = iArr[15];
        int i24 = i8 * 2;
        int i25 = i9 * 2;
        int i26 = i12 * 2;
        int i27 = i13 * 2;
        int i28 = i14 * 2;
        int i29 = i16 * 2;
        int i30 = i18 * 2;
        int i31 = i19 * 2;
        int i32 = i20 * 2;
        int i33 = i8 + i16;
        int i34 = i9 + i17;
        int i35 = i10 + i18;
        int i36 = i11 + i19;
        int i37 = i12 + i20;
        int i38 = i13 + i21;
        int i39 = i14 + i22;
        int i40 = i33 * 2;
        int i41 = i34 * 2;
        int i42 = i35 * 2;
        int i43 = i36 * 2;
        long j4 = i8;
        long j8 = j4 * j4;
        long j9 = i15;
        long j10 = i25;
        long j11 = j9 * j10;
        long j12 = i14;
        long j13 = i10 * 2;
        long j14 = (j12 * j13) + j11;
        long j15 = i13;
        long j16 = i11 * 2;
        long j17 = (j15 * j16) + j14;
        long j18 = i12;
        long j19 = i16;
        long j20 = j19 * j19;
        long j21 = i23;
        long j22 = i17 * 2;
        long j23 = i22;
        long j24 = i30;
        long j25 = (j23 * j24) + (j21 * j22);
        long j26 = i21;
        long j27 = i31;
        long j28 = i20;
        long j29 = j28 * j28;
        long j30 = i33;
        long j31 = j30 * j30;
        long j32 = i15 + i23;
        long j33 = i41 & 4294967295L;
        long j34 = j32 * j33;
        long j35 = i39;
        long j36 = i42 & 4294967295L;
        long j37 = (j35 * j36) + j34;
        long j38 = i38;
        long j39 = i43 & 4294967295L;
        long j40 = (j38 * j39) + j37;
        long j41 = i37;
        long j42 = (j41 * j41) + j40;
        long j43 = ((j8 + j20) + j42) - ((j18 * j18) + j17);
        int i44 = ((int) j43) & 268435455;
        long j44 = j43 >>> 28;
        long j45 = (((j29 + ((j26 * j27) + j25)) + j31) - j8) + j42;
        int i45 = ((int) j45) & 268435455;
        long j46 = j45 >>> 28;
        long j47 = i9;
        long j48 = i24;
        long j49 = j47 * j48;
        long j50 = i26;
        long j51 = j15 * j50;
        long j52 = i17;
        long j53 = i29;
        long j54 = j52 * j53;
        long j55 = i32;
        long j56 = j26 * j55;
        long j57 = i34;
        long j58 = i40 & 4294967295L;
        long j59 = j57 * j58;
        long j60 = (j35 * j39) + (j32 * j36);
        long j61 = (i37 * 2) & 4294967295L;
        long j62 = (j38 * j61) + j60;
        long j63 = (((j49 + j54) + j62) - (j51 + ((j12 * j16) + (j9 * j13)))) + j44;
        int i46 = ((int) j63) & 268435455;
        long j64 = j63 >>> 28;
        long j65 = (((j56 + ((j23 * j27) + (j21 * j24))) + j59) - j49) + j62 + j46;
        int i47 = ((int) j65) & 268435455;
        long j66 = j65 >>> 28;
        long j67 = i10;
        long j68 = (j47 * j47) + (j67 * j48);
        long j69 = (j12 * j50) + (j9 * j16);
        long j70 = i18;
        long j71 = (j52 * j52) + (j70 * j53);
        long j72 = (j23 * j55) + (j21 * j27);
        long j73 = i35;
        long j74 = (j57 * j57) + (j73 * j58);
        long j75 = (j38 * j38) + (j35 * j61) + (j32 * j39);
        long j76 = (((j68 + j71) + j75) - ((j15 * j15) + j69)) + j64;
        int i48 = ((int) j76) & 268435455;
        long j77 = j76 >>> 28;
        long j78 = ((((j26 * j26) + j72) + j74) - j68) + j75 + j66;
        int i49 = ((int) j78) & 268435455;
        long j79 = j78 >>> 28;
        long j80 = i11;
        long j81 = (j67 * j10) + (j80 * j48);
        long j82 = j9 * j50;
        long j83 = i27;
        long j84 = (j12 * j83) + j82;
        long j85 = i19;
        long j86 = (j70 * j22) + (j85 * j53);
        long j87 = j21 * j55;
        long j88 = i21 * 2;
        long j89 = (j23 * j88) + j87;
        long j90 = i36;
        long j91 = (j73 * j33) + (j90 * j58);
        long j92 = j61 * j32;
        long j93 = (i38 * 2) & 4294967295L;
        long j94 = (j35 * j93) + j92;
        long j95 = (((j81 + j86) + j94) - j84) + j77;
        int i50 = ((int) j95) & 268435455;
        long j96 = j95 >>> 28;
        long j97 = ((j89 + j91) - j81) + j94 + j79;
        int i51 = ((int) j97) & 268435455;
        long j98 = j97 >>> 28;
        long j99 = (j67 * j67) + (j80 * j10) + (j18 * j48);
        long j100 = (j23 * j23) + (j88 * j21);
        long j101 = (j73 * j73) + (j90 * j33) + (j41 * j58);
        long j102 = (j35 * j35) + (j32 * j93);
        long j103 = (((j99 + ((j70 * j70) + ((j85 * j22) + (j28 * j53)))) + j102) - ((j12 * j12) + (j9 * j83))) + j96;
        int i52 = ((int) j103) & 268435455;
        long j104 = j103 >>> 28;
        long j105 = ((j100 + j101) - j99) + j102 + j98;
        int i53 = ((int) j105) & 268435455;
        long j106 = j105 >>> 28;
        long j107 = (j80 * j13) + (j18 * j10) + (j15 * j48);
        long j108 = (j85 * j24) + (j28 * j22) + (j26 * j53);
        long j109 = (j90 * j36) + (j41 * j33) + (j38 * j58);
        long j110 = ((i39 * 2) & 4294967295L) * j32;
        long j111 = (((j107 + j108) + j110) - (i28 * j9)) + j104;
        int i54 = ((int) j111) & 268435455;
        long j112 = j111 >>> 28;
        long j113 = ((((i22 * 2) * j21) + j109) - j107) + j110 + j106;
        int i55 = ((int) j113) & 268435455;
        long j114 = j113 >>> 28;
        long j115 = (j80 * j80) + (j18 * j13) + (j15 * j10) + (j12 * j48);
        long j116 = (j90 * j90) + (j41 * j36) + (j38 * j33) + (j35 * j58);
        long j117 = j32 * j32;
        long j118 = (((j115 + ((j85 * j85) + ((j28 * j24) + ((j26 * j22) + (j23 * j53))))) + j117) - (j9 * j9)) + j112;
        int i56 = ((int) j118) & 268435455;
        long j119 = j118 >>> 28;
        long j120 = (((j21 * j21) + j116) - j115) + j117 + j114;
        long j121 = (j16 * j18) + (j15 * j13) + (j12 * j10) + (j9 * j48);
        long j122 = j26 * j24;
        long j123 = (j28 * j27) + j122 + (j23 * j22) + (j21 * j53);
        long j124 = j123 + j121 + j119;
        int i57 = ((int) j124) & 268435455;
        long j125 = (((j41 * j39) + ((j38 * j36) + ((j35 * j33) + (j32 * j58)))) - j121) + (j120 >>> 28);
        long j126 = j125 >>> 28;
        long j127 = (j124 >>> 28) + j126 + i45;
        long j128 = j126 + i44;
        iArr2[0] = ((int) j128) & 268435455;
        iArr2[1] = i46 + ((int) (j128 >>> 28));
        iArr2[2] = i48;
        iArr2[3] = i50;
        iArr2[4] = i52;
        iArr2[5] = i54;
        iArr2[6] = i56;
        iArr2[7] = i57;
        iArr2[8] = ((int) j127) & 268435455;
        iArr2[9] = i47 + ((int) (j127 >>> 28));
        iArr2[10] = i49;
        iArr2[11] = i51;
        iArr2[12] = i53;
        iArr2[13] = i55;
        iArr2[14] = ((int) j120) & 268435455;
        iArr2[15] = ((int) j125) & 268435455;
    }

    public static void P(int[] iArr, int[] iArr2, int[] iArr3) {
        for (int i8 = 0; i8 < 10; i8++) {
            iArr3[i8] = iArr[i8] - iArr2[i8];
        }
    }

    public static void Q(int[] iArr, int[] iArr2, int[] iArr3) {
        int i8 = iArr[0];
        int i9 = iArr[1];
        int i10 = iArr[2];
        int i11 = iArr[3];
        int i12 = iArr[4];
        int i13 = iArr[5];
        int i14 = iArr[6];
        int i15 = iArr[7];
        int i16 = iArr[8];
        int i17 = iArr[9];
        int i18 = iArr[10];
        int i19 = iArr[11];
        int i20 = iArr[12];
        int i21 = iArr[13];
        int i22 = iArr[14];
        int i23 = iArr[15];
        int i24 = iArr2[0];
        int i25 = iArr2[1];
        int i26 = iArr2[2];
        int i27 = iArr2[3];
        int i28 = iArr2[4];
        int i29 = iArr2[5];
        int i30 = iArr2[6];
        int i31 = iArr2[7];
        int i32 = iArr2[8];
        int i33 = iArr2[9];
        int i34 = iArr2[10];
        int i35 = iArr2[11];
        int i36 = iArr2[12];
        int i37 = iArr2[13];
        int i38 = (i9 + 536870910) - i25;
        int i39 = (i13 + 536870910) - i29;
        int i40 = (i17 + 536870910) - i33;
        int i41 = (i21 + 536870910) - i37;
        int i42 = ((i10 + 536870910) - i26) + (i38 >>> 28);
        int i43 = ((i14 + 536870910) - i30) + (i39 >>> 28);
        int i44 = ((i18 + 536870910) - i34) + (i40 >>> 28);
        int i45 = ((i22 + 536870910) - iArr2[14]) + (i41 >>> 28);
        int i46 = ((i11 + 536870910) - i27) + (i42 >>> 28);
        int i47 = ((i15 + 536870910) - i31) + (i43 >>> 28);
        int i48 = ((i19 + 536870910) - i35) + (i44 >>> 28);
        int i49 = ((i23 + 536870910) - iArr2[15]) + (i45 >>> 28);
        int i50 = i49 >>> 28;
        int i51 = ((i8 + 536870910) - i24) + i50;
        int i52 = ((i12 + 536870910) - i28) + (i46 >>> 28);
        int i53 = ((i16 + 536870908) - i32) + i50 + (i47 >>> 28);
        int i54 = ((i20 + 536870910) - i36) + (i48 >>> 28);
        iArr3[0] = i51 & 268435455;
        iArr3[1] = (i38 & 268435455) + (i51 >>> 28);
        iArr3[2] = i42 & 268435455;
        iArr3[3] = i46 & 268435455;
        iArr3[4] = i52 & 268435455;
        iArr3[5] = (i39 & 268435455) + (i52 >>> 28);
        iArr3[6] = i43 & 268435455;
        iArr3[7] = i47 & 268435455;
        iArr3[8] = i53 & 268435455;
        iArr3[9] = (i40 & 268435455) + (i53 >>> 28);
        iArr3[10] = i44 & 268435455;
        iArr3[11] = i48 & 268435455;
        iArr3[12] = i54 & 268435455;
        iArr3[13] = (i41 & 268435455) + (i54 >>> 28);
        iArr3[14] = i45 & 268435455;
        iArr3[15] = i49 & 268435455;
    }

    public static void a(int[] iArr, int[] iArr2, int[] iArr3) {
        for (int i8 = 0; i8 < 10; i8++) {
            iArr3[i8] = iArr[i8] + iArr2[i8];
        }
    }

    public static void b(int[] iArr, int[] iArr2, int[] iArr3) {
        for (int i8 = 0; i8 < 16; i8++) {
            iArr3[i8] = iArr[i8] + iArr2[i8];
        }
    }

    public static void c(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        for (int i8 = 0; i8 < 10; i8++) {
            int i9 = iArr[i8];
            int i10 = iArr2[i8];
            iArr3[i8] = i9 + i10;
            iArr4[i8] = i9 - i10;
        }
    }

    public static void d(int[] iArr) {
        int i8 = iArr[0];
        int i9 = iArr[1];
        int i10 = iArr[2];
        int i11 = iArr[3];
        int i12 = iArr[4];
        int i13 = iArr[5];
        int i14 = iArr[6];
        int i15 = iArr[7];
        int i16 = iArr[8];
        int i17 = iArr[9];
        int i18 = iArr[10];
        int i19 = iArr[11];
        int i20 = iArr[12];
        int i21 = iArr[13];
        int i22 = i9 + (i8 >>> 28);
        int i23 = i13 + (i12 >>> 28);
        int i24 = i17 + (i16 >>> 28);
        int i25 = i21 + (i20 >>> 28);
        int i26 = i10 + (i22 >>> 28);
        int i27 = i14 + (i23 >>> 28);
        int i28 = i18 + (i24 >>> 28);
        int i29 = iArr[14] + (i25 >>> 28);
        int i30 = i11 + (i26 >>> 28);
        int i31 = i15 + (i27 >>> 28);
        int i32 = i19 + (i28 >>> 28);
        int i33 = iArr[15] + (i29 >>> 28);
        int i34 = i33 >>> 28;
        int i35 = (i8 & 268435455) + i34;
        int i36 = (i12 & 268435455) + (i30 >>> 28);
        int i37 = (i16 & 268435455) + i34 + (i31 >>> 28);
        int i38 = (i20 & 268435455) + (i32 >>> 28);
        iArr[0] = i35 & 268435455;
        iArr[1] = (i22 & 268435455) + (i35 >>> 28);
        iArr[2] = i26 & 268435455;
        iArr[3] = i30 & 268435455;
        iArr[4] = i36 & 268435455;
        iArr[5] = (i23 & 268435455) + (i36 >>> 28);
        iArr[6] = i27 & 268435455;
        iArr[7] = i31 & 268435455;
        iArr[8] = i37 & 268435455;
        iArr[9] = (i24 & 268435455) + (i37 >>> 28);
        iArr[10] = i28 & 268435455;
        iArr[11] = i32 & 268435455;
        iArr[12] = i38 & 268435455;
        iArr[13] = (i25 & 268435455) + (i38 >>> 28);
        iArr[14] = i29 & 268435455;
        iArr[15] = i33 & 268435455;
    }

    public static void e(byte[] bArr) {
        if (bArr.length != 32) {
            throw new IllegalArgumentException("k");
        }
        bArr[0] = (byte) (bArr[0] & 248);
        byte b9 = (byte) (bArr[31] & AbstractJsonLexerKt.TC_INVALID);
        bArr[31] = b9;
        bArr[31] = (byte) (b9 | 64);
    }

    public static void f(byte[] bArr) {
        if (bArr.length != 56) {
            throw new IllegalArgumentException("k");
        }
        bArr[0] = (byte) (bArr[0] & 252);
        bArr[55] = (byte) (bArr[55] | 128);
    }

    public static void g(int i8, int i9, int[] iArr, int[] iArr2) {
        for (int i10 = 0; i10 < 10; i10++) {
            int i11 = iArr2[i10];
            iArr2[i10] = i11 ^ ((iArr[i9 + i10] ^ i11) & i8);
        }
    }

    public static void h(int i8, int i9, int[] iArr, int[] iArr2) {
        for (int i10 = 0; i10 < 16; i10++) {
            int i11 = iArr2[i10];
            iArr2[i10] = i11 ^ ((iArr[i9 + i10] ^ i11) & i8);
        }
    }

    public static void i(int i8, int[] iArr) {
        int i9 = 0 - i8;
        for (int i10 = 0; i10 < 10; i10++) {
            iArr[i10] = (iArr[i10] ^ i9) - i9;
        }
    }

    public static void j(int i8, int i9, int[] iArr, int[] iArr2) {
        for (int i10 = 0; i10 < 10; i10++) {
            iArr2[i9 + i10] = iArr[i8 + i10];
        }
    }

    public static void k(int i8, int i9, int[] iArr, int[] iArr2) {
        for (int i10 = 0; i10 < 16; i10++) {
            iArr2[i9 + i10] = iArr[i8 + i10];
        }
    }

    public static void l(int i8, int[] iArr, int[] iArr2) {
        int i9 = 0 - i8;
        for (int i10 = 0; i10 < 10; i10++) {
            int i11 = iArr[i10];
            int i12 = iArr2[i10];
            int i13 = (i11 ^ i12) & i9;
            iArr[i10] = i11 ^ i13;
            iArr2[i10] = i12 ^ i13;
        }
    }

    public static void m(int i8, int[] iArr, int[] iArr2) {
        int i9 = 0 - i8;
        for (int i10 = 0; i10 < 16; i10++) {
            int i11 = iArr[i10];
            int i12 = iArr2[i10];
            int i13 = (i11 ^ i12) & i9;
            iArr[i10] = i11 ^ i13;
            iArr2[i10] = i12 ^ i13;
        }
    }

    public static void n(int i8, int i9, int[] iArr, int[] iArr2) {
        int i10 = iArr[i8];
        int i11 = iArr[i8 + 1];
        int i12 = iArr[i8 + 2];
        int i13 = iArr[i8 + 3];
        iArr2[i9] = i10 & 67108863;
        iArr2[i9 + 1] = ((i10 >>> 26) | (i11 << 6)) & 67108863;
        iArr2[i9 + 2] = ((i11 >>> 20) | (i12 << 12)) & 33554431;
        iArr2[i9 + 3] = 67108863 & ((i13 << 19) | (i12 >>> 13));
        iArr2[i9 + 4] = i13 >>> 7;
    }

    public static void o(byte[] bArr, int[] iArr, int i8, int i9) {
        int iQ = q(bArr, i8);
        int iQ2 = q(bArr, i8 + 4);
        int iQ3 = q(bArr, i8 + 8);
        int iQ4 = q(bArr, i8 + 12);
        iArr[i9] = iQ & 67108863;
        iArr[i9 + 1] = ((iQ >>> 26) | (iQ2 << 6)) & 67108863;
        iArr[i9 + 2] = ((iQ2 >>> 20) | (iQ3 << 12)) & 33554431;
        iArr[i9 + 3] = 67108863 & ((iQ4 << 19) | (iQ3 >>> 13));
        iArr[i9 + 4] = iQ4 >>> 7;
    }

    public static void p(int i8, int i9, int[] iArr, int[] iArr2) {
        int i10 = iArr[i8];
        int i11 = iArr[i8 + 1];
        int i12 = iArr[i8 + 2];
        int i13 = iArr[i8 + 3];
        int i14 = iArr[i8 + 4];
        int i15 = iArr[i8 + 5];
        int i16 = iArr[i8 + 6];
        iArr2[i9] = i10 & 268435455;
        iArr2[i9 + 1] = ((i10 >>> 28) | (i11 << 4)) & 268435455;
        iArr2[i9 + 2] = ((i11 >>> 24) | (i12 << 8)) & 268435455;
        iArr2[i9 + 3] = ((i12 >>> 20) | (i13 << 12)) & 268435455;
        iArr2[i9 + 4] = ((i13 >>> 16) | (i14 << 16)) & 268435455;
        iArr2[i9 + 5] = ((i14 >>> 12) | (i15 << 20)) & 268435455;
        iArr2[i9 + 6] = 268435455 & ((i15 >>> 8) | (i16 << 24));
        iArr2[i9 + 7] = i16 >>> 4;
    }

    public static int q(byte[] bArr, int i8) {
        return (bArr[i8 + 3] << 24) | (bArr[i8] & 255) | ((bArr[i8 + 1] & 255) << 8) | ((bArr[i8 + 2] & 255) << 16);
    }

    public static void r(byte[] bArr, int[] iArr, int i8, int i9) {
        int i10 = (bArr[i8] & 255) | ((bArr[i8 + 1] & 255) << 8) | ((bArr[i8 + 2] & 255) << 16) | (bArr[i8 + 3] << 24);
        int i11 = ((bArr[i8 + 6] & 255) << 16) | (bArr[i8 + 4] & 255) | ((bArr[i8 + 5] & 255) << 8);
        iArr[i9] = 268435455 & i10;
        iArr[i9 + 1] = (i11 << 4) | (i10 >>> 28);
    }

    public static void s(byte[] bArr, int i8, int[] iArr) {
        x(bArr, iArr, 0, i8);
        x(bArr, iArr, 2, i8 + 7);
        x(bArr, iArr, 4, i8 + 14);
        x(bArr, iArr, 6, i8 + 21);
        x(bArr, iArr, 8, i8 + 28);
        x(bArr, iArr, 10, i8 + 35);
        x(bArr, iArr, 12, i8 + 42);
        x(bArr, iArr, 14, i8 + 49);
    }

    public static void t(int i8, int i9, int[] iArr, int[] iArr2) {
        int i10 = iArr[i8];
        int i11 = iArr[i8 + 1];
        int i12 = iArr[i8 + 2];
        int i13 = iArr[i8 + 3];
        int i14 = iArr[i8 + 4];
        iArr2[i9] = (i11 << 26) | i10;
        iArr2[i9 + 1] = (i11 >>> 6) | (i12 << 20);
        iArr2[i9 + 2] = (i12 >>> 12) | (i13 << 13);
        iArr2[i9 + 3] = (i14 << 7) | (i13 >>> 19);
    }

    public static void u(byte[] bArr, int[] iArr, int i8, int i9) {
        int i10 = iArr[i8];
        int i11 = iArr[i8 + 1];
        int i12 = iArr[i8 + 2];
        int i13 = iArr[i8 + 3];
        int i14 = iArr[i8 + 4];
        w((i11 << 26) | i10, i9, bArr);
        w((i11 >>> 6) | (i12 << 20), i9 + 4, bArr);
        w((i12 >>> 12) | (i13 << 13), i9 + 8, bArr);
        w((i14 << 7) | (i13 >>> 19), i9 + 12, bArr);
    }

    public static void v(int i8, int i9, int[] iArr, int[] iArr2) {
        int i10 = iArr[i8];
        int i11 = iArr[i8 + 1];
        int i12 = iArr[i8 + 2];
        int i13 = iArr[i8 + 3];
        int i14 = iArr[i8 + 4];
        int i15 = iArr[i8 + 5];
        int i16 = iArr[i8 + 6];
        int i17 = iArr[i8 + 7];
        iArr2[i9] = (i11 << 28) | i10;
        iArr2[i9 + 1] = (i11 >>> 4) | (i12 << 24);
        iArr2[i9 + 2] = (i12 >>> 8) | (i13 << 20);
        iArr2[i9 + 3] = (i13 >>> 12) | (i14 << 16);
        iArr2[i9 + 4] = (i14 >>> 16) | (i15 << 12);
        iArr2[i9 + 5] = (i15 >>> 20) | (i16 << 8);
        iArr2[i9 + 6] = (i17 << 4) | (i16 >>> 24);
    }

    public static void w(int i8, int i9, byte[] bArr) {
        bArr[i9] = (byte) i8;
        bArr[i9 + 1] = (byte) (i8 >>> 8);
        bArr[i9 + 2] = (byte) (i8 >>> 16);
        bArr[i9 + 3] = (byte) (i8 >>> 24);
    }

    public static void x(byte[] bArr, int[] iArr, int i8, int i9) {
        int i10 = iArr[i8];
        int i11 = iArr[i8 + 1];
        int i12 = (i11 << 28) | i10;
        bArr[i9] = (byte) i12;
        bArr[i9 + 1] = (byte) (i12 >>> 8);
        bArr[i9 + 2] = (byte) (i12 >>> 16);
        bArr[i9 + 3] = (byte) (i12 >>> 24);
        bArr[i9 + 4] = (byte) (i11 >>> 4);
        bArr[i9 + 5] = (byte) (i11 >>> 12);
        bArr[i9 + 6] = (byte) (i11 >>> 20);
    }

    public static void y(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[10];
        int[] iArr4 = new int[8];
        j(0, 0, iArr, iArr3);
        H(iArr3);
        t(0, 0, iArr3, iArr4);
        t(5, 4, iArr3, iArr4);
        f.p0(f5783a, iArr4, iArr4);
        n(0, 0, iArr4, iArr2);
        n(4, 5, iArr4, iArr2);
        iArr2[9] = iArr2[9] & 16777215;
    }

    public static void z(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[16];
        int[] iArr4 = new int[14];
        k(0, 0, iArr, iArr3);
        K(1, iArr3);
        K(-1, iArr3);
        v(0, 0, iArr3, iArr4);
        v(8, 7, iArr3, iArr4);
        f.p0(f5785c, iArr4, iArr4);
        p(0, 0, iArr4, iArr2);
        p(7, 8, iArr4, iArr2);
    }
}

package org.bouncycastle.crypto.engines;

import m0.f;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.TweakableBlockCipherParameters;
import org.bouncycastle.util.Pack;

/* loaded from: classes.dex */
public class ThreefishEngine implements BlockCipher {
    public static final int BLOCKSIZE_1024 = 1024;
    public static final int BLOCKSIZE_256 = 256;
    public static final int BLOCKSIZE_512 = 512;
    private static final long C_240 = 2004413935125273122L;
    private static final int MAX_ROUNDS = 80;
    private static int[] MOD17 = null;
    private static int[] MOD3 = null;
    private static int[] MOD5 = null;
    private static int[] MOD9 = null;
    private static final int ROUNDS_1024 = 80;
    private static final int ROUNDS_256 = 72;
    private static final int ROUNDS_512 = 72;
    private static final int TWEAK_SIZE_BYTES = 16;
    private static final int TWEAK_SIZE_WORDS = 2;
    private int blocksizeBytes;
    private int blocksizeWords;
    private ThreefishCipher cipher;
    private long[] currentBlock;
    private boolean forEncryption;
    private long[] kw;

    /* renamed from: t, reason: collision with root package name */
    private long[] f4476t;

    public static final class Threefish1024Cipher extends ThreefishCipher {
        private static final int ROTATION_0_0 = 24;
        private static final int ROTATION_0_1 = 13;
        private static final int ROTATION_0_2 = 8;
        private static final int ROTATION_0_3 = 47;
        private static final int ROTATION_0_4 = 8;
        private static final int ROTATION_0_5 = 17;
        private static final int ROTATION_0_6 = 22;
        private static final int ROTATION_0_7 = 37;
        private static final int ROTATION_1_0 = 38;
        private static final int ROTATION_1_1 = 19;
        private static final int ROTATION_1_2 = 10;
        private static final int ROTATION_1_3 = 55;
        private static final int ROTATION_1_4 = 49;
        private static final int ROTATION_1_5 = 18;
        private static final int ROTATION_1_6 = 23;
        private static final int ROTATION_1_7 = 52;
        private static final int ROTATION_2_0 = 33;
        private static final int ROTATION_2_1 = 4;
        private static final int ROTATION_2_2 = 51;
        private static final int ROTATION_2_3 = 13;
        private static final int ROTATION_2_4 = 34;
        private static final int ROTATION_2_5 = 41;
        private static final int ROTATION_2_6 = 59;
        private static final int ROTATION_2_7 = 17;
        private static final int ROTATION_3_0 = 5;
        private static final int ROTATION_3_1 = 20;
        private static final int ROTATION_3_2 = 48;
        private static final int ROTATION_3_3 = 41;
        private static final int ROTATION_3_4 = 47;
        private static final int ROTATION_3_5 = 28;
        private static final int ROTATION_3_6 = 16;
        private static final int ROTATION_3_7 = 25;
        private static final int ROTATION_4_0 = 41;
        private static final int ROTATION_4_1 = 9;
        private static final int ROTATION_4_2 = 37;
        private static final int ROTATION_4_3 = 31;
        private static final int ROTATION_4_4 = 12;
        private static final int ROTATION_4_5 = 47;
        private static final int ROTATION_4_6 = 44;
        private static final int ROTATION_4_7 = 30;
        private static final int ROTATION_5_0 = 16;
        private static final int ROTATION_5_1 = 34;
        private static final int ROTATION_5_2 = 56;
        private static final int ROTATION_5_3 = 51;
        private static final int ROTATION_5_4 = 4;
        private static final int ROTATION_5_5 = 53;
        private static final int ROTATION_5_6 = 42;
        private static final int ROTATION_5_7 = 41;
        private static final int ROTATION_6_0 = 31;
        private static final int ROTATION_6_1 = 44;
        private static final int ROTATION_6_2 = 47;
        private static final int ROTATION_6_3 = 46;
        private static final int ROTATION_6_4 = 19;
        private static final int ROTATION_6_5 = 42;
        private static final int ROTATION_6_6 = 44;
        private static final int ROTATION_6_7 = 25;
        private static final int ROTATION_7_0 = 9;
        private static final int ROTATION_7_1 = 48;
        private static final int ROTATION_7_2 = 35;
        private static final int ROTATION_7_3 = 52;
        private static final int ROTATION_7_4 = 23;
        private static final int ROTATION_7_5 = 31;
        private static final int ROTATION_7_6 = 37;
        private static final int ROTATION_7_7 = 20;

        public Threefish1024Cipher(long[] jArr, long[] jArr2) {
            super(jArr, jArr2);
        }

        @Override // org.bouncycastle.crypto.engines.ThreefishEngine.ThreefishCipher
        public void decryptBlock(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.kw;
            long[] jArr4 = this.f4477t;
            int[] iArr = ThreefishEngine.MOD17;
            int[] iArr2 = ThreefishEngine.MOD3;
            if (jArr3.length != 33) {
                throw new IllegalArgumentException();
            }
            if (jArr4.length != 5) {
                throw new IllegalArgumentException();
            }
            long j4 = jArr[0];
            int i8 = 1;
            long j8 = jArr[1];
            long j9 = jArr[2];
            long j10 = jArr[3];
            long j11 = jArr[4];
            long j12 = jArr[5];
            long j13 = jArr[6];
            long j14 = jArr[7];
            long j15 = jArr[8];
            long j16 = jArr[9];
            long j17 = jArr[10];
            long jXorRotr = jArr[11];
            long j18 = jArr[12];
            long jXorRotr2 = jArr[13];
            long j19 = jArr[14];
            long jXorRotr3 = jArr[15];
            int i9 = 19;
            while (i9 >= i8) {
                int i10 = iArr[i9];
                int i11 = iArr2[i9];
                int i12 = i10 + 1;
                long j20 = j4 - jArr3[i12];
                int i13 = i10 + 2;
                long j21 = j8 - jArr3[i13];
                int i14 = i10 + 3;
                long j22 = j9 - jArr3[i14];
                int i15 = i10 + 4;
                long j23 = j10 - jArr3[i15];
                int i16 = i10 + 5;
                int i17 = i8;
                long j24 = j11 - jArr3[i16];
                int i18 = i10 + 6;
                long j25 = j12 - jArr3[i18];
                int i19 = i10 + 7;
                long[] jArr5 = jArr4;
                long[] jArr6 = jArr3;
                long j26 = j13 - jArr3[i19];
                int i20 = i10 + 8;
                int[] iArr3 = iArr;
                long j27 = j14 - jArr6[i20];
                int i21 = i10 + 9;
                long j28 = j15 - jArr6[i21];
                int i22 = i10 + 10;
                long j29 = j16 - jArr6[i22];
                int i23 = i10 + 11;
                long j30 = j17 - jArr6[i23];
                int i24 = i10 + 12;
                long j31 = jXorRotr - jArr6[i24];
                int i25 = i10 + 13;
                long j32 = j18 - jArr6[i25];
                int i26 = i10 + 14;
                int i27 = i11 + 1;
                long j33 = jXorRotr2 - (jArr6[i26] + jArr5[i27]);
                int i28 = i10 + 15;
                long j34 = j19 - (jArr6[i28] + jArr5[i11 + 2]);
                long j35 = i9;
                long jXorRotr4 = ThreefishEngine.xorRotr(jXorRotr3 - ((jArr6[i10 + 16] + j35) + 1), 9, j20);
                long j36 = j20 - jXorRotr4;
                long jXorRotr5 = ThreefishEngine.xorRotr(j31, 48, j22);
                long j37 = j22 - jXorRotr5;
                long jXorRotr6 = ThreefishEngine.xorRotr(j33, 35, j26);
                long j38 = j26 - jXorRotr6;
                long jXorRotr7 = ThreefishEngine.xorRotr(j29, 52, j24);
                long j39 = j24 - jXorRotr7;
                long jXorRotr8 = ThreefishEngine.xorRotr(j21, 23, j34);
                long j40 = j34 - jXorRotr8;
                long jXorRotr9 = ThreefishEngine.xorRotr(j25, 31, j28);
                long j41 = j28 - jXorRotr9;
                long jXorRotr10 = ThreefishEngine.xorRotr(j23, 37, j30);
                long j42 = j30 - jXorRotr10;
                long jXorRotr11 = ThreefishEngine.xorRotr(j27, 20, j32);
                long j43 = j32 - jXorRotr11;
                long jXorRotr12 = ThreefishEngine.xorRotr(jXorRotr11, 31, j36);
                long j44 = j36 - jXorRotr12;
                long jXorRotr13 = ThreefishEngine.xorRotr(jXorRotr9, 44, j37);
                long j45 = j37 - jXorRotr13;
                long jXorRotr14 = ThreefishEngine.xorRotr(jXorRotr10, 47, j39);
                long j46 = j39 - jXorRotr14;
                long jXorRotr15 = ThreefishEngine.xorRotr(jXorRotr8, ROTATION_6_3, j38);
                long j47 = j38 - jXorRotr15;
                long jXorRotr16 = ThreefishEngine.xorRotr(jXorRotr4, 19, j43);
                long j48 = j43 - jXorRotr16;
                long jXorRotr17 = ThreefishEngine.xorRotr(jXorRotr6, 42, j40);
                long j49 = j40 - jXorRotr17;
                long jXorRotr18 = ThreefishEngine.xorRotr(jXorRotr5, 44, j41);
                long j50 = j41 - jXorRotr18;
                long jXorRotr19 = ThreefishEngine.xorRotr(jXorRotr7, 25, j42);
                long j51 = j42 - jXorRotr19;
                long jXorRotr20 = ThreefishEngine.xorRotr(jXorRotr19, 16, j44);
                long j52 = j44 - jXorRotr20;
                long jXorRotr21 = ThreefishEngine.xorRotr(jXorRotr17, 34, j45);
                long j53 = j45 - jXorRotr21;
                long jXorRotr22 = ThreefishEngine.xorRotr(jXorRotr18, 56, j47);
                long j54 = j47 - jXorRotr22;
                long jXorRotr23 = ThreefishEngine.xorRotr(jXorRotr16, 51, j46);
                long j55 = j46 - jXorRotr23;
                long jXorRotr24 = ThreefishEngine.xorRotr(jXorRotr12, 4, j51);
                long j56 = j51 - jXorRotr24;
                long jXorRotr25 = ThreefishEngine.xorRotr(jXorRotr14, ROTATION_5_5, j48);
                long j57 = j48 - jXorRotr25;
                long jXorRotr26 = ThreefishEngine.xorRotr(jXorRotr13, 42, j49);
                long j58 = j49 - jXorRotr26;
                long jXorRotr27 = ThreefishEngine.xorRotr(jXorRotr15, 41, j50);
                long j59 = j50 - jXorRotr27;
                long jXorRotr28 = ThreefishEngine.xorRotr(jXorRotr27, 41, j52);
                long jXorRotr29 = ThreefishEngine.xorRotr(jXorRotr25, 9, j53);
                long j60 = j53 - jXorRotr29;
                long jXorRotr30 = ThreefishEngine.xorRotr(jXorRotr26, 37, j55);
                long j61 = j55 - jXorRotr30;
                long jXorRotr31 = ThreefishEngine.xorRotr(jXorRotr24, 31, j54);
                long j62 = j54 - jXorRotr31;
                long jXorRotr32 = ThreefishEngine.xorRotr(jXorRotr20, 12, j59);
                long j63 = j59 - jXorRotr32;
                long jXorRotr33 = ThreefishEngine.xorRotr(jXorRotr22, 47, j56);
                long j64 = j56 - jXorRotr33;
                long jXorRotr34 = ThreefishEngine.xorRotr(jXorRotr21, 44, j57);
                long j65 = j57 - jXorRotr34;
                long jXorRotr35 = ThreefishEngine.xorRotr(jXorRotr23, 30, j58);
                long j66 = j58 - jXorRotr35;
                long j67 = (j52 - jXorRotr28) - jArr6[i10];
                long j68 = jXorRotr28 - jArr6[i12];
                long j69 = j60 - jArr6[i13];
                long j70 = jXorRotr29 - jArr6[i14];
                long j71 = j61 - jArr6[i15];
                long j72 = jXorRotr30 - jArr6[i16];
                long j73 = j62 - jArr6[i18];
                long j74 = jXorRotr31 - jArr6[i19];
                long j75 = j63 - jArr6[i20];
                long j76 = jXorRotr32 - jArr6[i21];
                long j77 = j64 - jArr6[i22];
                long j78 = jXorRotr33 - jArr6[i23];
                long j79 = j65 - jArr6[i24];
                long j80 = jXorRotr34 - (jArr6[i25] + jArr5[i11]);
                long j81 = j66 - (jArr6[i26] + jArr5[i27]);
                long jXorRotr36 = ThreefishEngine.xorRotr(jXorRotr35 - (jArr6[i28] + j35), 5, j67);
                long j82 = j67 - jXorRotr36;
                long jXorRotr37 = ThreefishEngine.xorRotr(j78, 20, j69);
                long j83 = j69 - jXorRotr37;
                long jXorRotr38 = ThreefishEngine.xorRotr(j80, 48, j73);
                long j84 = j73 - jXorRotr38;
                long jXorRotr39 = ThreefishEngine.xorRotr(j76, 41, j71);
                long j85 = j71 - jXorRotr39;
                long jXorRotr40 = ThreefishEngine.xorRotr(j68, 47, j81);
                long j86 = j81 - jXorRotr40;
                long jXorRotr41 = ThreefishEngine.xorRotr(j72, 28, j75);
                long j87 = j75 - jXorRotr41;
                long jXorRotr42 = ThreefishEngine.xorRotr(j70, 16, j77);
                long j88 = j77 - jXorRotr42;
                long jXorRotr43 = ThreefishEngine.xorRotr(j74, 25, j79);
                long j89 = j79 - jXorRotr43;
                long jXorRotr44 = ThreefishEngine.xorRotr(jXorRotr43, 33, j82);
                long j90 = j82 - jXorRotr44;
                long jXorRotr45 = ThreefishEngine.xorRotr(jXorRotr41, 4, j83);
                long j91 = j83 - jXorRotr45;
                long jXorRotr46 = ThreefishEngine.xorRotr(jXorRotr42, 51, j85);
                long j92 = j85 - jXorRotr46;
                long jXorRotr47 = ThreefishEngine.xorRotr(jXorRotr40, 13, j84);
                long j93 = j84 - jXorRotr47;
                long jXorRotr48 = ThreefishEngine.xorRotr(jXorRotr36, 34, j89);
                long j94 = j89 - jXorRotr48;
                long jXorRotr49 = ThreefishEngine.xorRotr(jXorRotr38, 41, j86);
                long j95 = j86 - jXorRotr49;
                long jXorRotr50 = ThreefishEngine.xorRotr(jXorRotr37, ROTATION_2_6, j87);
                long j96 = j87 - jXorRotr50;
                long jXorRotr51 = ThreefishEngine.xorRotr(jXorRotr39, 17, j88);
                long j97 = j88 - jXorRotr51;
                long jXorRotr52 = ThreefishEngine.xorRotr(jXorRotr51, ROTATION_1_0, j90);
                long j98 = j90 - jXorRotr52;
                long jXorRotr53 = ThreefishEngine.xorRotr(jXorRotr49, 19, j91);
                long j99 = j91 - jXorRotr53;
                long jXorRotr54 = ThreefishEngine.xorRotr(jXorRotr50, 10, j93);
                long j100 = j93 - jXorRotr54;
                long jXorRotr55 = ThreefishEngine.xorRotr(jXorRotr48, ROTATION_1_3, j92);
                long j101 = j92 - jXorRotr55;
                long jXorRotr56 = ThreefishEngine.xorRotr(jXorRotr44, ROTATION_1_4, j97);
                long j102 = j97 - jXorRotr56;
                long jXorRotr57 = ThreefishEngine.xorRotr(jXorRotr46, 18, j94);
                long j103 = j94 - jXorRotr57;
                long jXorRotr58 = ThreefishEngine.xorRotr(jXorRotr45, 23, j95);
                long j104 = j95 - jXorRotr58;
                long jXorRotr59 = ThreefishEngine.xorRotr(jXorRotr47, 52, j96);
                long j105 = j96 - jXorRotr59;
                long jXorRotr60 = ThreefishEngine.xorRotr(jXorRotr59, 24, j98);
                j4 = j98 - jXorRotr60;
                long jXorRotr61 = ThreefishEngine.xorRotr(jXorRotr57, 13, j99);
                j9 = j99 - jXorRotr61;
                long jXorRotr62 = ThreefishEngine.xorRotr(jXorRotr58, 8, j101);
                long j106 = j101 - jXorRotr62;
                long jXorRotr63 = ThreefishEngine.xorRotr(jXorRotr56, 47, j100);
                long j107 = j100 - jXorRotr63;
                long jXorRotr64 = ThreefishEngine.xorRotr(jXorRotr52, 8, j105);
                jXorRotr = ThreefishEngine.xorRotr(jXorRotr54, 17, j102);
                jXorRotr2 = ThreefishEngine.xorRotr(jXorRotr53, 22, j103);
                long j108 = j103 - jXorRotr2;
                jXorRotr3 = ThreefishEngine.xorRotr(jXorRotr55, 37, j104);
                j19 = j104 - jXorRotr3;
                i9 -= 2;
                j17 = j102 - jXorRotr;
                j12 = jXorRotr62;
                j13 = j107;
                j8 = jXorRotr60;
                j16 = jXorRotr64;
                i8 = i17;
                jArr3 = jArr6;
                jArr4 = jArr5;
                iArr = iArr3;
                iArr2 = iArr2;
                j11 = j106;
                j10 = jXorRotr61;
                j15 = j105 - jXorRotr64;
                j18 = j108;
                j14 = jXorRotr63;
            }
            long[] jArr7 = jArr4;
            long[] jArr8 = jArr3;
            int i29 = i8;
            long j109 = j4 - jArr8[0];
            long j110 = j8 - jArr8[i29];
            long j111 = j9 - jArr8[2];
            long j112 = j10 - jArr8[3];
            long j113 = j11 - jArr8[4];
            long j114 = j12 - jArr8[5];
            long j115 = j13 - jArr8[6];
            long j116 = j14 - jArr8[7];
            long j117 = j15 - jArr8[8];
            long j118 = j16 - jArr8[9];
            long j119 = j17 - jArr8[10];
            long j120 = jXorRotr - jArr8[11];
            long j121 = j18 - jArr8[12];
            long j122 = jXorRotr2 - (jArr8[13] + jArr7[0]);
            long j123 = j19 - (jArr8[14] + jArr7[i29]);
            long j124 = jXorRotr3 - jArr8[15];
            jArr2[0] = j109;
            jArr2[i29] = j110;
            jArr2[2] = j111;
            jArr2[3] = j112;
            jArr2[4] = j113;
            jArr2[5] = j114;
            jArr2[6] = j115;
            jArr2[7] = j116;
            jArr2[8] = j117;
            jArr2[9] = j118;
            jArr2[10] = j119;
            jArr2[11] = j120;
            jArr2[12] = j121;
            jArr2[13] = j122;
            jArr2[14] = j123;
            jArr2[15] = j124;
        }

        @Override // org.bouncycastle.crypto.engines.ThreefishEngine.ThreefishCipher
        public void encryptBlock(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.kw;
            long[] jArr4 = this.f4477t;
            int[] iArr = ThreefishEngine.MOD17;
            int[] iArr2 = ThreefishEngine.MOD3;
            if (jArr3.length != 33) {
                throw new IllegalArgumentException();
            }
            if (jArr4.length != 5) {
                throw new IllegalArgumentException();
            }
            long j4 = jArr[0];
            long j8 = jArr[1];
            long j9 = jArr[2];
            long j10 = jArr[3];
            long j11 = jArr[4];
            long j12 = jArr[5];
            long j13 = jArr[6];
            long j14 = jArr[7];
            long j15 = jArr[8];
            long j16 = jArr[9];
            long j17 = jArr[10];
            long j18 = jArr[11];
            int i8 = 9;
            long j19 = jArr[12];
            int i9 = 12;
            int i10 = 13;
            long j20 = jArr[13];
            long j21 = jArr[14];
            long j22 = jArr[15];
            long j23 = j4 + jArr3[0];
            long j24 = j8 + jArr3[1];
            long j25 = j9 + jArr3[2];
            long j26 = j10 + jArr3[3];
            long j27 = j11 + jArr3[4];
            long j28 = j12 + jArr3[5];
            long j29 = j13 + jArr3[6];
            long j30 = j14 + jArr3[7];
            long j31 = j15 + jArr3[8];
            long j32 = j16 + jArr3[9];
            long j33 = j17 + jArr3[10];
            long j34 = j18 + jArr3[11];
            long j35 = j19 + jArr3[12];
            long j36 = jArr3[13] + jArr4[0] + j20;
            long j37 = jArr3[14] + jArr4[1] + j21;
            long j38 = j30;
            long j39 = j32;
            long j40 = j34;
            long j41 = j22 + jArr3[15];
            long j42 = j36;
            int i11 = 1;
            long j43 = j26;
            long j44 = j28;
            long j45 = j27;
            long j46 = j23;
            while (i11 < 20) {
                int i12 = iArr[i11];
                int i13 = iArr2[i11];
                long j47 = j43;
                long j48 = j46 + j24;
                long jRotlXor = ThreefishEngine.rotlXor(j24, 24, j48);
                long j49 = j25 + j47;
                long jRotlXor2 = ThreefishEngine.rotlXor(j47, i10, j49);
                long j50 = j45 + j44;
                long jRotlXor3 = ThreefishEngine.rotlXor(j44, 8, j50);
                int i14 = i11;
                long j51 = j38;
                long j52 = j29 + j51;
                long jRotlXor4 = ThreefishEngine.rotlXor(j51, 47, j52);
                long j53 = j39;
                long j54 = j31 + j53;
                long[] jArr5 = jArr4;
                long jRotlXor5 = ThreefishEngine.rotlXor(j53, 8, j54);
                long[] jArr6 = jArr3;
                int[] iArr3 = iArr;
                long j55 = j40;
                long j56 = j33 + j55;
                long jRotlXor6 = ThreefishEngine.rotlXor(j55, 17, j56);
                long j57 = j42;
                long j58 = j35 + j57;
                long jRotlXor7 = ThreefishEngine.rotlXor(j57, 22, j58);
                long j59 = j41;
                long j60 = j37 + j59;
                long jRotlXor8 = ThreefishEngine.rotlXor(j59, 37, j60);
                long j61 = j48 + jRotlXor5;
                long jRotlXor9 = ThreefishEngine.rotlXor(jRotlXor5, ROTATION_1_0, j61);
                long j62 = j49 + jRotlXor7;
                long jRotlXor10 = ThreefishEngine.rotlXor(jRotlXor7, 19, j62);
                long j63 = j52 + jRotlXor6;
                long jRotlXor11 = ThreefishEngine.rotlXor(jRotlXor6, 10, j63);
                long j64 = j50 + jRotlXor8;
                long jRotlXor12 = ThreefishEngine.rotlXor(jRotlXor8, ROTATION_1_3, j64);
                long j65 = j56 + jRotlXor4;
                long jRotlXor13 = ThreefishEngine.rotlXor(jRotlXor4, ROTATION_1_4, j65);
                long j66 = j58 + jRotlXor2;
                long jRotlXor14 = ThreefishEngine.rotlXor(jRotlXor2, 18, j66);
                long j67 = j60 + jRotlXor3;
                long jRotlXor15 = ThreefishEngine.rotlXor(jRotlXor3, 23, j67);
                long j68 = j54 + jRotlXor;
                long jRotlXor16 = ThreefishEngine.rotlXor(jRotlXor, 52, j68);
                long j69 = j61 + jRotlXor13;
                long jRotlXor17 = ThreefishEngine.rotlXor(jRotlXor13, 33, j69);
                long j70 = j62 + jRotlXor15;
                long jRotlXor18 = ThreefishEngine.rotlXor(jRotlXor15, 4, j70);
                long j71 = j64 + jRotlXor14;
                long jRotlXor19 = ThreefishEngine.rotlXor(jRotlXor14, 51, j71);
                long j72 = j63 + jRotlXor16;
                long jRotlXor20 = ThreefishEngine.rotlXor(jRotlXor16, 13, j72);
                long j73 = j66 + jRotlXor12;
                long jRotlXor21 = ThreefishEngine.rotlXor(jRotlXor12, 34, j73);
                long j74 = j67 + jRotlXor10;
                long jRotlXor22 = ThreefishEngine.rotlXor(jRotlXor10, 41, j74);
                long j75 = j68 + jRotlXor11;
                long jRotlXor23 = ThreefishEngine.rotlXor(jRotlXor11, ROTATION_2_6, j75);
                long j76 = j65 + jRotlXor9;
                long jRotlXor24 = ThreefishEngine.rotlXor(jRotlXor9, 17, j76);
                long j77 = j69 + jRotlXor21;
                long jRotlXor25 = ThreefishEngine.rotlXor(jRotlXor21, 5, j77);
                long j78 = j70 + jRotlXor23;
                long jRotlXor26 = ThreefishEngine.rotlXor(jRotlXor23, 20, j78);
                long j79 = j72 + jRotlXor22;
                long jRotlXor27 = ThreefishEngine.rotlXor(jRotlXor22, 48, j79);
                long j80 = j71 + jRotlXor24;
                long jRotlXor28 = ThreefishEngine.rotlXor(jRotlXor24, 41, j80);
                long j81 = j74 + jRotlXor20;
                long jRotlXor29 = ThreefishEngine.rotlXor(jRotlXor20, 47, j81);
                long j82 = j75 + jRotlXor18;
                long jRotlXor30 = ThreefishEngine.rotlXor(jRotlXor18, 28, j82);
                long j83 = j76 + jRotlXor19;
                long jRotlXor31 = ThreefishEngine.rotlXor(jRotlXor19, 16, j83);
                long j84 = j73 + jRotlXor17;
                long jRotlXor32 = ThreefishEngine.rotlXor(jRotlXor17, 25, j84);
                long j85 = j77 + jArr6[i12];
                int i15 = i12 + 1;
                long j86 = jRotlXor29 + jArr6[i15];
                int i16 = i12 + 2;
                long j87 = j78 + jArr6[i16];
                int i17 = i12 + 3;
                long j88 = jRotlXor31 + jArr6[i17];
                int i18 = i12 + 4;
                long j89 = j80 + jArr6[i18];
                int i19 = i12 + 5;
                long j90 = jRotlXor30 + jArr6[i19];
                int i20 = i12 + 6;
                long j91 = j79 + jArr6[i20];
                int i21 = i12 + 7;
                long j92 = jRotlXor32 + jArr6[i21];
                int i22 = i12 + 8;
                long j93 = j82 + jArr6[i22];
                int i23 = i12 + 9;
                long j94 = jRotlXor28 + jArr6[i23];
                int i24 = i12 + 10;
                long j95 = j83 + jArr6[i24];
                int i25 = i12 + 11;
                long j96 = jRotlXor26 + jArr6[i25];
                int i26 = i12 + 12;
                long j97 = j84 + jArr6[i26];
                int i27 = i12 + 13;
                long j98 = jArr6[i27] + jArr5[i13] + jRotlXor27;
                int i28 = i12 + 14;
                int i29 = i13 + 1;
                long j99 = jArr6[i28] + jArr5[i29] + j81;
                int i30 = i12 + 15;
                long j100 = i14;
                long j101 = jArr6[i30] + j100 + jRotlXor25;
                long j102 = j85 + j86;
                long jRotlXor33 = ThreefishEngine.rotlXor(j86, 41, j102);
                long j103 = j87 + j88;
                long jRotlXor34 = ThreefishEngine.rotlXor(j88, i8, j103);
                long j104 = j89 + j90;
                long jRotlXor35 = ThreefishEngine.rotlXor(j90, 37, j104);
                long j105 = j91 + j92;
                long jRotlXor36 = ThreefishEngine.rotlXor(j92, 31, j105);
                long j106 = j93 + j94;
                long jRotlXor37 = ThreefishEngine.rotlXor(j94, i9, j106);
                long j107 = j95 + j96;
                long jRotlXor38 = ThreefishEngine.rotlXor(j96, 47, j107);
                long j108 = j97 + j98;
                long jRotlXor39 = ThreefishEngine.rotlXor(j98, 44, j108);
                long j109 = j99 + j101;
                long jRotlXor40 = ThreefishEngine.rotlXor(j101, 30, j109);
                long j110 = j102 + jRotlXor37;
                long jRotlXor41 = ThreefishEngine.rotlXor(jRotlXor37, 16, j110);
                long j111 = j103 + jRotlXor39;
                long jRotlXor42 = ThreefishEngine.rotlXor(jRotlXor39, 34, j111);
                long j112 = j105 + jRotlXor38;
                long jRotlXor43 = ThreefishEngine.rotlXor(jRotlXor38, 56, j112);
                long j113 = j104 + jRotlXor40;
                long jRotlXor44 = ThreefishEngine.rotlXor(jRotlXor40, 51, j113);
                long j114 = j107 + jRotlXor36;
                long jRotlXor45 = ThreefishEngine.rotlXor(jRotlXor36, 4, j114);
                long j115 = j108 + jRotlXor34;
                long jRotlXor46 = ThreefishEngine.rotlXor(jRotlXor34, ROTATION_5_5, j115);
                long j116 = j109 + jRotlXor35;
                long jRotlXor47 = ThreefishEngine.rotlXor(jRotlXor35, 42, j116);
                long j117 = j106 + jRotlXor33;
                long jRotlXor48 = ThreefishEngine.rotlXor(jRotlXor33, 41, j117);
                long j118 = j110 + jRotlXor45;
                long jRotlXor49 = ThreefishEngine.rotlXor(jRotlXor45, 31, j118);
                long j119 = j111 + jRotlXor47;
                long jRotlXor50 = ThreefishEngine.rotlXor(jRotlXor47, 44, j119);
                long j120 = j113 + jRotlXor46;
                long jRotlXor51 = ThreefishEngine.rotlXor(jRotlXor46, 47, j120);
                long j121 = j112 + jRotlXor48;
                long jRotlXor52 = ThreefishEngine.rotlXor(jRotlXor48, ROTATION_6_3, j121);
                long j122 = j115 + jRotlXor44;
                long jRotlXor53 = ThreefishEngine.rotlXor(jRotlXor44, 19, j122);
                long j123 = j116 + jRotlXor42;
                long jRotlXor54 = ThreefishEngine.rotlXor(jRotlXor42, 42, j123);
                long j124 = j117 + jRotlXor43;
                long jRotlXor55 = ThreefishEngine.rotlXor(jRotlXor43, 44, j124);
                long j125 = j114 + jRotlXor41;
                long jRotlXor56 = ThreefishEngine.rotlXor(jRotlXor41, 25, j125);
                long j126 = j118 + jRotlXor53;
                long jRotlXor57 = ThreefishEngine.rotlXor(jRotlXor53, 9, j126);
                long j127 = j119 + jRotlXor55;
                long jRotlXor58 = ThreefishEngine.rotlXor(jRotlXor55, 48, j127);
                long j128 = j121 + jRotlXor54;
                long jRotlXor59 = ThreefishEngine.rotlXor(jRotlXor54, 35, j128);
                long j129 = j120 + jRotlXor56;
                long jRotlXor60 = ThreefishEngine.rotlXor(jRotlXor56, 52, j129);
                long j130 = j123 + jRotlXor52;
                long jRotlXor61 = ThreefishEngine.rotlXor(jRotlXor52, 23, j130);
                long j131 = j124 + jRotlXor50;
                long jRotlXor62 = ThreefishEngine.rotlXor(jRotlXor50, 31, j131);
                long j132 = j125 + jRotlXor51;
                long jRotlXor63 = ThreefishEngine.rotlXor(jRotlXor51, 37, j132);
                long j133 = j122 + jRotlXor49;
                long jRotlXor64 = ThreefishEngine.rotlXor(jRotlXor49, 20, j133);
                long j134 = jArr6[i15] + j126;
                long j135 = jRotlXor61 + jArr6[i16];
                j25 = j127 + jArr6[i17];
                long j136 = jRotlXor63 + jArr6[i18];
                long j137 = j129 + jArr6[i19];
                long j138 = jRotlXor62 + jArr6[i20];
                long j139 = j128 + jArr6[i21];
                long j140 = jRotlXor64 + jArr6[i22];
                long j141 = j131 + jArr6[i23];
                long j142 = jRotlXor60 + jArr6[i24];
                long j143 = j132 + jArr6[i25];
                j40 = jRotlXor58 + jArr6[i26];
                long j144 = j133 + jArr6[i27];
                long j145 = jArr6[i28] + jArr5[i29] + jRotlXor59;
                long j146 = jArr6[i30] + jArr5[i13 + 2] + j130;
                j41 = jArr6[i12 + 16] + j100 + 1 + jRotlXor57;
                i11 = i14 + 2;
                j29 = j139;
                j37 = j146;
                j45 = j137;
                j35 = j144;
                j31 = j141;
                j39 = j142;
                iArr = iArr3;
                iArr2 = iArr2;
                i10 = 13;
                i8 = 9;
                i9 = 12;
                j38 = j140;
                jArr4 = jArr5;
                jArr3 = jArr6;
                j24 = j135;
                j44 = j138;
                j42 = j145;
                j46 = j134;
                j43 = j136;
                j33 = j143;
            }
            jArr2[0] = j46;
            jArr2[1] = j24;
            jArr2[2] = j25;
            jArr2[3] = j43;
            jArr2[4] = j45;
            jArr2[5] = j44;
            jArr2[6] = j29;
            jArr2[7] = j38;
            jArr2[8] = j31;
            jArr2[9] = j39;
            jArr2[10] = j33;
            jArr2[11] = j40;
            jArr2[12] = j35;
            jArr2[13] = j42;
            jArr2[14] = j37;
            jArr2[15] = j41;
        }
    }

    public static final class Threefish256Cipher extends ThreefishCipher {
        private static final int ROTATION_0_0 = 14;
        private static final int ROTATION_0_1 = 16;
        private static final int ROTATION_1_0 = 52;
        private static final int ROTATION_1_1 = 57;
        private static final int ROTATION_2_0 = 23;
        private static final int ROTATION_2_1 = 40;
        private static final int ROTATION_3_0 = 5;
        private static final int ROTATION_3_1 = 37;
        private static final int ROTATION_4_0 = 25;
        private static final int ROTATION_4_1 = 33;
        private static final int ROTATION_5_0 = 46;
        private static final int ROTATION_5_1 = 12;
        private static final int ROTATION_6_0 = 58;
        private static final int ROTATION_6_1 = 22;
        private static final int ROTATION_7_0 = 32;
        private static final int ROTATION_7_1 = 32;

        public Threefish256Cipher(long[] jArr, long[] jArr2) {
            super(jArr, jArr2);
        }

        @Override // org.bouncycastle.crypto.engines.ThreefishEngine.ThreefishCipher
        public void decryptBlock(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.kw;
            long[] jArr4 = this.f4477t;
            int[] iArr = ThreefishEngine.MOD5;
            int[] iArr2 = ThreefishEngine.MOD3;
            if (jArr3.length != 9) {
                throw new IllegalArgumentException();
            }
            if (jArr4.length != 5) {
                throw new IllegalArgumentException();
            }
            long j4 = jArr[0];
            int i8 = 1;
            long j8 = jArr[1];
            char c3 = 2;
            long j9 = jArr[2];
            char c8 = 3;
            long j10 = jArr[3];
            int i9 = 17;
            while (i9 >= i8) {
                int i10 = iArr[i9];
                int i11 = iArr2[i9];
                int i12 = i10 + 1;
                long j11 = j4 - jArr3[i12];
                int i13 = i10 + 2;
                int i14 = i11 + 1;
                long j12 = j8 - (jArr3[i13] + jArr4[i14]);
                int i15 = i10 + 3;
                long j13 = j9 - (jArr3[i15] + jArr4[i11 + 2]);
                char c9 = c8;
                long j14 = i9;
                int i16 = i8;
                long jXorRotr = ThreefishEngine.xorRotr(j10 - ((jArr3[i10 + 4] + j14) + 1), 32, j11);
                long j15 = j11 - jXorRotr;
                long jXorRotr2 = ThreefishEngine.xorRotr(j12, 32, j13);
                long j16 = j13 - jXorRotr2;
                long jXorRotr3 = ThreefishEngine.xorRotr(jXorRotr2, ROTATION_6_0, j15);
                long j17 = j15 - jXorRotr3;
                long jXorRotr4 = ThreefishEngine.xorRotr(jXorRotr, 22, j16);
                long j18 = j16 - jXorRotr4;
                long jXorRotr5 = ThreefishEngine.xorRotr(jXorRotr4, ROTATION_5_0, j17);
                long j19 = j17 - jXorRotr5;
                long jXorRotr6 = ThreefishEngine.xorRotr(jXorRotr3, 12, j18);
                long j20 = j18 - jXorRotr6;
                long jXorRotr7 = ThreefishEngine.xorRotr(jXorRotr6, 25, j19);
                long jXorRotr8 = ThreefishEngine.xorRotr(jXorRotr5, 33, j20);
                long j21 = (j19 - jXorRotr7) - jArr3[i10];
                long j22 = jXorRotr7 - (jArr3[i12] + jArr4[i11]);
                long j23 = (j20 - jXorRotr8) - (jArr3[i13] + jArr4[i14]);
                long jXorRotr9 = ThreefishEngine.xorRotr(jXorRotr8 - (jArr3[i15] + j14), 5, j21);
                long j24 = j21 - jXorRotr9;
                long jXorRotr10 = ThreefishEngine.xorRotr(j22, ROTATION_3_1, j23);
                long j25 = j23 - jXorRotr10;
                long jXorRotr11 = ThreefishEngine.xorRotr(jXorRotr10, 23, j24);
                long j26 = j24 - jXorRotr11;
                long jXorRotr12 = ThreefishEngine.xorRotr(jXorRotr9, 40, j25);
                long j27 = j25 - jXorRotr12;
                long jXorRotr13 = ThreefishEngine.xorRotr(jXorRotr12, ROTATION_1_0, j26);
                long j28 = j26 - jXorRotr13;
                long jXorRotr14 = ThreefishEngine.xorRotr(jXorRotr11, 57, j27);
                long j29 = j27 - jXorRotr14;
                long jXorRotr15 = ThreefishEngine.xorRotr(jXorRotr14, 14, j28);
                long jXorRotr16 = ThreefishEngine.xorRotr(jXorRotr13, 16, j29);
                j9 = j29 - jXorRotr16;
                i9 -= 2;
                i8 = i16;
                j10 = jXorRotr16;
                c3 = c3;
                j4 = j28 - jXorRotr15;
                c8 = c9;
                j8 = jXorRotr15;
            }
            char c10 = c3;
            char c11 = c8;
            int i17 = i8;
            long j30 = j4 - jArr3[0];
            long j31 = j8 - (jArr3[i17] + jArr4[0]);
            long j32 = j9 - (jArr3[c10] + jArr4[i17]);
            long j33 = j10 - jArr3[c11];
            jArr2[0] = j30;
            jArr2[i17] = j31;
            jArr2[c10] = j32;
            jArr2[c11] = j33;
        }

        @Override // org.bouncycastle.crypto.engines.ThreefishEngine.ThreefishCipher
        public void encryptBlock(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.kw;
            long[] jArr4 = this.f4477t;
            int[] iArr = ThreefishEngine.MOD5;
            int[] iArr2 = ThreefishEngine.MOD3;
            if (jArr3.length != 9) {
                throw new IllegalArgumentException();
            }
            int i8 = 5;
            if (jArr4.length != 5) {
                throw new IllegalArgumentException();
            }
            long j4 = jArr[0];
            long j8 = jArr[1];
            char c3 = 2;
            long j9 = jArr[2];
            char c8 = 3;
            long j10 = jArr[3];
            long j11 = j4 + jArr3[0];
            long j12 = jArr3[1] + jArr4[0] + j8;
            long j13 = jArr3[2] + jArr4[1] + j9;
            long j14 = j10 + jArr3[3];
            long j15 = j13;
            long j16 = j12;
            int i9 = 1;
            while (i9 < 18) {
                int i10 = iArr[i9];
                int i11 = iArr2[i9];
                long j17 = j11 + j16;
                char c9 = c3;
                long jRotlXor = ThreefishEngine.rotlXor(j16, 14, j17);
                char c10 = c8;
                long j18 = j15 + j14;
                long jRotlXor2 = ThreefishEngine.rotlXor(j14, 16, j18);
                long j19 = j17 + jRotlXor2;
                long jRotlXor3 = ThreefishEngine.rotlXor(jRotlXor2, ROTATION_1_0, j19);
                long j20 = j18 + jRotlXor;
                long jRotlXor4 = ThreefishEngine.rotlXor(jRotlXor, 57, j20);
                long j21 = j19 + jRotlXor4;
                long jRotlXor5 = ThreefishEngine.rotlXor(jRotlXor4, 23, j21);
                long j22 = j20 + jRotlXor3;
                long jRotlXor6 = ThreefishEngine.rotlXor(jRotlXor3, 40, j22);
                long j23 = j21 + jRotlXor6;
                long jRotlXor7 = ThreefishEngine.rotlXor(jRotlXor6, i8, j23);
                long j24 = j22 + jRotlXor5;
                long jRotlXor8 = ThreefishEngine.rotlXor(jRotlXor5, ROTATION_3_1, j24);
                long j25 = j23 + jArr3[i10];
                int i12 = i10 + 1;
                long j26 = jArr3[i12] + jArr4[i11] + jRotlXor8;
                int i13 = i10 + 2;
                int i14 = i11 + 1;
                long j27 = jArr3[i13] + jArr4[i14] + j24;
                int i15 = i10 + 3;
                long j28 = i9;
                long j29 = jArr3[i15] + j28 + jRotlXor7;
                long[] jArr5 = jArr4;
                long[] jArr6 = jArr3;
                long j30 = j25 + j26;
                long jRotlXor9 = ThreefishEngine.rotlXor(j26, 25, j30);
                long j31 = j27 + j29;
                long jRotlXor10 = ThreefishEngine.rotlXor(j29, 33, j31);
                long j32 = j30 + jRotlXor10;
                long jRotlXor11 = ThreefishEngine.rotlXor(jRotlXor10, ROTATION_5_0, j32);
                long j33 = j31 + jRotlXor9;
                long jRotlXor12 = ThreefishEngine.rotlXor(jRotlXor9, 12, j33);
                long j34 = j32 + jRotlXor12;
                long jRotlXor13 = ThreefishEngine.rotlXor(jRotlXor12, ROTATION_6_0, j34);
                long j35 = j33 + jRotlXor11;
                long jRotlXor14 = ThreefishEngine.rotlXor(jRotlXor11, 22, j35);
                long j36 = j34 + jRotlXor14;
                long jRotlXor15 = ThreefishEngine.rotlXor(jRotlXor14, 32, j36);
                long j37 = j35 + jRotlXor13;
                long jRotlXor16 = ThreefishEngine.rotlXor(jRotlXor13, 32, j37);
                long j38 = j36 + jArr6[i12];
                j16 = jArr6[i13] + jArr5[i14] + jRotlXor16;
                j15 = jArr6[i15] + jArr5[i11 + 2] + j37;
                j14 = jArr6[i10 + 4] + j28 + 1 + jRotlXor15;
                i9 += 2;
                c8 = c10;
                c3 = c9;
                j11 = j38;
                jArr3 = jArr6;
                jArr4 = jArr5;
                i8 = 5;
            }
            jArr2[0] = j11;
            jArr2[1] = j16;
            jArr2[c3] = j15;
            jArr2[c8] = j14;
        }
    }

    public static final class Threefish512Cipher extends ThreefishCipher {
        private static final int ROTATION_0_0 = 46;
        private static final int ROTATION_0_1 = 36;
        private static final int ROTATION_0_2 = 19;
        private static final int ROTATION_0_3 = 37;
        private static final int ROTATION_1_0 = 33;
        private static final int ROTATION_1_1 = 27;
        private static final int ROTATION_1_2 = 14;
        private static final int ROTATION_1_3 = 42;
        private static final int ROTATION_2_0 = 17;
        private static final int ROTATION_2_1 = 49;
        private static final int ROTATION_2_2 = 36;
        private static final int ROTATION_2_3 = 39;
        private static final int ROTATION_3_0 = 44;
        private static final int ROTATION_3_1 = 9;
        private static final int ROTATION_3_2 = 54;
        private static final int ROTATION_3_3 = 56;
        private static final int ROTATION_4_0 = 39;
        private static final int ROTATION_4_1 = 30;
        private static final int ROTATION_4_2 = 34;
        private static final int ROTATION_4_3 = 24;
        private static final int ROTATION_5_0 = 13;
        private static final int ROTATION_5_1 = 50;
        private static final int ROTATION_5_2 = 10;
        private static final int ROTATION_5_3 = 17;
        private static final int ROTATION_6_0 = 25;
        private static final int ROTATION_6_1 = 29;
        private static final int ROTATION_6_2 = 39;
        private static final int ROTATION_6_3 = 43;
        private static final int ROTATION_7_0 = 8;
        private static final int ROTATION_7_1 = 35;
        private static final int ROTATION_7_2 = 56;
        private static final int ROTATION_7_3 = 22;

        public Threefish512Cipher(long[] jArr, long[] jArr2) {
            super(jArr, jArr2);
        }

        @Override // org.bouncycastle.crypto.engines.ThreefishEngine.ThreefishCipher
        public void decryptBlock(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.kw;
            long[] jArr4 = this.f4477t;
            int[] iArr = ThreefishEngine.MOD9;
            int[] iArr2 = ThreefishEngine.MOD3;
            if (jArr3.length != 17) {
                throw new IllegalArgumentException();
            }
            char c3 = 5;
            if (jArr4.length != 5) {
                throw new IllegalArgumentException();
            }
            long j4 = jArr[0];
            int i8 = 1;
            long j8 = jArr[1];
            char c8 = 2;
            long j9 = jArr[2];
            char c9 = 3;
            long jXorRotr = jArr[3];
            long j10 = jArr[4];
            long jXorRotr2 = jArr[5];
            long j11 = jArr[6];
            long jXorRotr3 = jArr[7];
            int i9 = 17;
            while (i9 >= i8) {
                int i10 = iArr[i9];
                int i11 = iArr2[i9];
                int i12 = i10 + 1;
                long j12 = j4 - jArr3[i12];
                int i13 = i10 + 2;
                long j13 = j8 - jArr3[i13];
                int i14 = i10 + 3;
                long j14 = j9 - jArr3[i14];
                int i15 = i10 + 4;
                char c10 = c3;
                long j15 = jXorRotr - jArr3[i15];
                int i16 = i10 + 5;
                char c11 = c8;
                long j16 = j10 - jArr3[i16];
                int i17 = i10 + 6;
                int i18 = i11 + 1;
                int i19 = i8;
                long j17 = jXorRotr2 - (jArr3[i17] + jArr4[i18]);
                int i20 = i10 + 7;
                long[] jArr5 = jArr4;
                long[] jArr6 = jArr3;
                long j18 = j11 - (jArr3[i20] + jArr4[i11 + 2]);
                int[] iArr3 = iArr;
                long j19 = i9;
                long j20 = jXorRotr3 - ((jArr6[i10 + 8] + j19) + 1);
                int i21 = i9;
                long jXorRotr4 = ThreefishEngine.xorRotr(j13, 8, j18);
                long j21 = j18 - jXorRotr4;
                long jXorRotr5 = ThreefishEngine.xorRotr(j20, 35, j12);
                long j22 = j12 - jXorRotr5;
                long jXorRotr6 = ThreefishEngine.xorRotr(j17, 56, j14);
                long j23 = j14 - jXorRotr6;
                long jXorRotr7 = ThreefishEngine.xorRotr(j15, 22, j16);
                long j24 = j16 - jXorRotr7;
                long jXorRotr8 = ThreefishEngine.xorRotr(jXorRotr4, 25, j24);
                long j25 = j24 - jXorRotr8;
                long jXorRotr9 = ThreefishEngine.xorRotr(jXorRotr7, 29, j21);
                long j26 = j21 - jXorRotr9;
                long jXorRotr10 = ThreefishEngine.xorRotr(jXorRotr6, 39, j22);
                long j27 = j22 - jXorRotr10;
                long jXorRotr11 = ThreefishEngine.xorRotr(jXorRotr5, ROTATION_6_3, j23);
                long j28 = j23 - jXorRotr11;
                long jXorRotr12 = ThreefishEngine.xorRotr(jXorRotr8, 13, j28);
                long j29 = j28 - jXorRotr12;
                long jXorRotr13 = ThreefishEngine.xorRotr(jXorRotr11, 50, j25);
                long j30 = j25 - jXorRotr13;
                long jXorRotr14 = ThreefishEngine.xorRotr(jXorRotr10, 10, j26);
                long j31 = j26 - jXorRotr14;
                long jXorRotr15 = ThreefishEngine.xorRotr(jXorRotr9, 17, j27);
                long j32 = j27 - jXorRotr15;
                long jXorRotr16 = ThreefishEngine.xorRotr(jXorRotr12, 39, j32);
                long jXorRotr17 = ThreefishEngine.xorRotr(jXorRotr15, 30, j29);
                long j33 = j29 - jXorRotr17;
                long jXorRotr18 = ThreefishEngine.xorRotr(jXorRotr14, 34, j30);
                long jXorRotr19 = ThreefishEngine.xorRotr(jXorRotr13, 24, j31);
                long j34 = j31 - jXorRotr19;
                long j35 = (j32 - jXorRotr16) - jArr6[i10];
                long j36 = jXorRotr16 - jArr6[i12];
                long j37 = j33 - jArr6[i13];
                long j38 = jXorRotr17 - jArr6[i14];
                long j39 = (j30 - jXorRotr18) - jArr6[i15];
                long j40 = jXorRotr18 - (jArr6[i16] + jArr5[i11]);
                long j41 = j34 - (jArr6[i17] + jArr5[i18]);
                long j42 = jXorRotr19 - (jArr6[i20] + j19);
                long jXorRotr20 = ThreefishEngine.xorRotr(j36, ROTATION_3_0, j41);
                long j43 = j41 - jXorRotr20;
                long jXorRotr21 = ThreefishEngine.xorRotr(j42, 9, j35);
                long j44 = j35 - jXorRotr21;
                long jXorRotr22 = ThreefishEngine.xorRotr(j40, ROTATION_3_2, j37);
                long j45 = j37 - jXorRotr22;
                long jXorRotr23 = ThreefishEngine.xorRotr(j38, 56, j39);
                long j46 = j39 - jXorRotr23;
                long jXorRotr24 = ThreefishEngine.xorRotr(jXorRotr20, 17, j46);
                long j47 = j46 - jXorRotr24;
                long jXorRotr25 = ThreefishEngine.xorRotr(jXorRotr23, ROTATION_2_1, j43);
                long j48 = j43 - jXorRotr25;
                long jXorRotr26 = ThreefishEngine.xorRotr(jXorRotr22, 36, j44);
                long j49 = j44 - jXorRotr26;
                long jXorRotr27 = ThreefishEngine.xorRotr(jXorRotr21, 39, j45);
                long j50 = j45 - jXorRotr27;
                long jXorRotr28 = ThreefishEngine.xorRotr(jXorRotr24, 33, j50);
                long j51 = j50 - jXorRotr28;
                long jXorRotr29 = ThreefishEngine.xorRotr(jXorRotr27, 27, j47);
                long j52 = j47 - jXorRotr29;
                long jXorRotr30 = ThreefishEngine.xorRotr(jXorRotr26, 14, j48);
                long j53 = j48 - jXorRotr30;
                long jXorRotr31 = ThreefishEngine.xorRotr(jXorRotr25, ROTATION_1_3, j49);
                long j54 = j49 - jXorRotr31;
                long jXorRotr32 = ThreefishEngine.xorRotr(jXorRotr28, ROTATION_0_0, j54);
                long j55 = j54 - jXorRotr32;
                jXorRotr = ThreefishEngine.xorRotr(jXorRotr31, 36, j51);
                j9 = j51 - jXorRotr;
                jXorRotr2 = ThreefishEngine.xorRotr(jXorRotr30, 19, j52);
                long j56 = j52 - jXorRotr2;
                jXorRotr3 = ThreefishEngine.xorRotr(jXorRotr29, ROTATION_0_3, j53);
                j11 = j53 - jXorRotr3;
                i9 = i21 - 2;
                j4 = j55;
                j8 = jXorRotr32;
                i8 = i19;
                c3 = c10;
                c8 = c11;
                iArr = iArr3;
                iArr2 = iArr2;
                c9 = c9;
                j10 = j56;
                jArr3 = jArr6;
                jArr4 = jArr5;
            }
            long[] jArr7 = jArr4;
            long[] jArr8 = jArr3;
            char c12 = c3;
            int i22 = i8;
            char c13 = c8;
            char c14 = c9;
            long j57 = j4 - jArr8[0];
            long j58 = j8 - jArr8[i22];
            long j59 = j9 - jArr8[c13];
            long j60 = jXorRotr - jArr8[c14];
            long j61 = j10 - jArr8[4];
            long j62 = jXorRotr2 - (jArr8[c12] + jArr7[0]);
            long j63 = j11 - (jArr8[6] + jArr7[i22]);
            long j64 = jXorRotr3 - jArr8[7];
            jArr2[0] = j57;
            jArr2[i22] = j58;
            jArr2[c13] = j59;
            jArr2[c14] = j60;
            jArr2[4] = j61;
            jArr2[c12] = j62;
            jArr2[6] = j63;
            jArr2[7] = j64;
        }

        @Override // org.bouncycastle.crypto.engines.ThreefishEngine.ThreefishCipher
        public void encryptBlock(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.kw;
            long[] jArr4 = this.f4477t;
            int[] iArr = ThreefishEngine.MOD9;
            int[] iArr2 = ThreefishEngine.MOD3;
            if (jArr3.length != 17) {
                throw new IllegalArgumentException();
            }
            if (jArr4.length != 5) {
                throw new IllegalArgumentException();
            }
            long j4 = jArr[0];
            long j8 = jArr[1];
            long j9 = jArr[2];
            char c3 = 3;
            long j10 = jArr[3];
            long j11 = jArr[4];
            long j12 = jArr[5];
            long j13 = jArr[6];
            long j14 = jArr[7];
            long j15 = j4 + jArr3[0];
            long j16 = j8 + jArr3[1];
            long j17 = j9 + jArr3[2];
            long j18 = j10 + jArr3[3];
            long j19 = j11 + jArr3[4];
            long j20 = jArr3[5] + jArr4[0] + j12;
            long j21 = jArr3[6] + jArr4[1] + j13;
            long j22 = j17;
            long j23 = j14 + jArr3[7];
            int i8 = 1;
            long j24 = j15;
            long j25 = j18;
            long j26 = j20;
            while (i8 < 18) {
                int i9 = iArr[i8];
                int i10 = iArr2[i8];
                long j27 = j25;
                long j28 = j24 + j16;
                long jRotlXor = ThreefishEngine.rotlXor(j16, ROTATION_0_0, j28);
                long[] jArr5 = jArr4;
                long[] jArr6 = jArr3;
                long j29 = j22 + j27;
                int[] iArr3 = iArr;
                long jRotlXor2 = ThreefishEngine.rotlXor(j27, 36, j29);
                long j30 = j19 + j26;
                long jRotlXor3 = ThreefishEngine.rotlXor(j26, 19, j30);
                long j31 = j21 + j23;
                long jRotlXor4 = ThreefishEngine.rotlXor(j23, ROTATION_0_3, j31);
                long j32 = j29 + jRotlXor;
                long jRotlXor5 = ThreefishEngine.rotlXor(jRotlXor, 33, j32);
                long j33 = j30 + jRotlXor4;
                long jRotlXor6 = ThreefishEngine.rotlXor(jRotlXor4, 27, j33);
                long j34 = j31 + jRotlXor3;
                long jRotlXor7 = ThreefishEngine.rotlXor(jRotlXor3, 14, j34);
                long j35 = j28 + jRotlXor2;
                long jRotlXor8 = ThreefishEngine.rotlXor(jRotlXor2, ROTATION_1_3, j35);
                long j36 = j33 + jRotlXor5;
                long jRotlXor9 = ThreefishEngine.rotlXor(jRotlXor5, 17, j36);
                long j37 = j34 + jRotlXor8;
                long jRotlXor10 = ThreefishEngine.rotlXor(jRotlXor8, ROTATION_2_1, j37);
                long j38 = j35 + jRotlXor7;
                long jRotlXor11 = ThreefishEngine.rotlXor(jRotlXor7, 36, j38);
                long j39 = j32 + jRotlXor6;
                long jRotlXor12 = ThreefishEngine.rotlXor(jRotlXor6, 39, j39);
                long j40 = j37 + jRotlXor9;
                long jRotlXor13 = ThreefishEngine.rotlXor(jRotlXor9, ROTATION_3_0, j40);
                long j41 = j38 + jRotlXor12;
                long jRotlXor14 = ThreefishEngine.rotlXor(jRotlXor12, 9, j41);
                long j42 = j39 + jRotlXor11;
                long jRotlXor15 = ThreefishEngine.rotlXor(jRotlXor11, ROTATION_3_2, j42);
                long j43 = j36 + jRotlXor10;
                long jRotlXor16 = ThreefishEngine.rotlXor(jRotlXor10, 56, j43);
                long j44 = j41 + jArr6[i9];
                int i11 = i9 + 1;
                long j45 = jRotlXor13 + jArr6[i11];
                int i12 = i9 + 2;
                long j46 = j42 + jArr6[i12];
                int i13 = i9 + 3;
                long j47 = jRotlXor16 + jArr6[i13];
                int i14 = i9 + 4;
                long j48 = j43 + jArr6[i14];
                int i15 = i9 + 5;
                long j49 = jArr6[i15] + jArr5[i10] + jRotlXor15;
                int i16 = i9 + 6;
                int i17 = i10 + 1;
                long j50 = jArr6[i16] + jArr5[i17] + j40;
                int i18 = i9 + 7;
                long j51 = i8;
                long j52 = jArr6[i18] + j51 + jRotlXor14;
                long j53 = j44 + j45;
                long jRotlXor17 = ThreefishEngine.rotlXor(j45, 39, j53);
                long j54 = j46 + j47;
                long jRotlXor18 = ThreefishEngine.rotlXor(j47, 30, j54);
                long j55 = j48 + j49;
                long jRotlXor19 = ThreefishEngine.rotlXor(j49, 34, j55);
                long j56 = j50 + j52;
                long jRotlXor20 = ThreefishEngine.rotlXor(j52, 24, j56);
                long j57 = j54 + jRotlXor17;
                long jRotlXor21 = ThreefishEngine.rotlXor(jRotlXor17, 13, j57);
                long j58 = j55 + jRotlXor20;
                long jRotlXor22 = ThreefishEngine.rotlXor(jRotlXor20, 50, j58);
                long j59 = j56 + jRotlXor19;
                long jRotlXor23 = ThreefishEngine.rotlXor(jRotlXor19, 10, j59);
                long j60 = j53 + jRotlXor18;
                long jRotlXor24 = ThreefishEngine.rotlXor(jRotlXor18, 17, j60);
                long j61 = j58 + jRotlXor21;
                long jRotlXor25 = ThreefishEngine.rotlXor(jRotlXor21, 25, j61);
                long j62 = j59 + jRotlXor24;
                long jRotlXor26 = ThreefishEngine.rotlXor(jRotlXor24, 29, j62);
                long j63 = j60 + jRotlXor23;
                long jRotlXor27 = ThreefishEngine.rotlXor(jRotlXor23, 39, j63);
                long j64 = j57 + jRotlXor22;
                long jRotlXor28 = ThreefishEngine.rotlXor(jRotlXor22, ROTATION_6_3, j64);
                long j65 = j62 + jRotlXor25;
                long jRotlXor29 = ThreefishEngine.rotlXor(jRotlXor25, 8, j65);
                long j66 = j63 + jRotlXor28;
                long jRotlXor30 = ThreefishEngine.rotlXor(jRotlXor28, 35, j66);
                long j67 = j64 + jRotlXor27;
                long jRotlXor31 = ThreefishEngine.rotlXor(jRotlXor27, 56, j67);
                long j68 = j61 + jRotlXor26;
                long jRotlXor32 = ThreefishEngine.rotlXor(jRotlXor26, 22, j68);
                long j69 = j66 + jArr6[i11];
                long j70 = jRotlXor29 + jArr6[i12];
                long j71 = j67 + jArr6[i13];
                long j72 = jRotlXor32 + jArr6[i14];
                j19 = j68 + jArr6[i15];
                long j73 = jArr6[i16] + jArr5[i17] + jRotlXor31;
                j21 = jArr6[i18] + jArr5[i10 + 2] + j65;
                i8 += 2;
                j22 = j71;
                j24 = j69;
                j16 = j70;
                c3 = c3;
                j26 = j73;
                j23 = jRotlXor30 + jArr6[i9 + 8] + j51 + 1;
                jArr3 = jArr6;
                jArr4 = jArr5;
                j25 = j72;
                iArr = iArr3;
                iArr2 = iArr2;
            }
            jArr2[0] = j24;
            jArr2[1] = j16;
            jArr2[2] = j22;
            jArr2[c3] = j25;
            jArr2[4] = j19;
            jArr2[5] = j26;
            jArr2[6] = j21;
            jArr2[7] = j23;
        }
    }

    public static abstract class ThreefishCipher {
        protected final long[] kw;

        /* renamed from: t, reason: collision with root package name */
        protected final long[] f4477t;

        public ThreefishCipher(long[] jArr, long[] jArr2) {
            this.kw = jArr;
            this.f4477t = jArr2;
        }

        public abstract void decryptBlock(long[] jArr, long[] jArr2);

        public abstract void encryptBlock(long[] jArr, long[] jArr2);
    }

    static {
        int[] iArr = new int[80];
        MOD9 = iArr;
        MOD17 = new int[iArr.length];
        MOD5 = new int[iArr.length];
        MOD3 = new int[iArr.length];
        int i8 = 0;
        while (true) {
            int[] iArr2 = MOD9;
            if (i8 >= iArr2.length) {
                return;
            }
            MOD17[i8] = i8 % 17;
            iArr2[i8] = i8 % 9;
            MOD5[i8] = i8 % 5;
            MOD3[i8] = i8 % 3;
            i8++;
        }
    }

    public ThreefishEngine(int i8) {
        ThreefishCipher threefish256Cipher;
        long[] jArr = new long[5];
        this.f4476t = jArr;
        int i9 = i8 / 8;
        this.blocksizeBytes = i9;
        int i10 = i9 / 8;
        this.blocksizeWords = i10;
        this.currentBlock = new long[i10];
        long[] jArr2 = new long[(i10 * 2) + 1];
        this.kw = jArr2;
        if (i8 == 256) {
            threefish256Cipher = new Threefish256Cipher(jArr2, jArr);
        } else if (i8 == 512) {
            threefish256Cipher = new Threefish512Cipher(jArr2, jArr);
        } else {
            if (i8 != 1024) {
                throw new IllegalArgumentException("Invalid blocksize - Threefish is defined with block size of 256, 512, or 1024 bits");
            }
            threefish256Cipher = new Threefish1024Cipher(jArr2, jArr);
        }
        this.cipher = threefish256Cipher;
    }

    public static long bytesToWord(byte[] bArr, int i8) {
        return Pack.littleEndianToLong(bArr, i8);
    }

    public static long rotlXor(long j4, int i8, long j8) {
        return ((j4 >>> (-i8)) | (j4 << i8)) ^ j8;
    }

    private void setKey(long[] jArr) {
        if (jArr.length != this.blocksizeWords) {
            throw new IllegalArgumentException(f.e(new StringBuilder("Threefish key must be same size as block ("), this.blocksizeWords, " words)"));
        }
        long j4 = C_240;
        int i8 = 0;
        while (true) {
            int i9 = this.blocksizeWords;
            if (i8 >= i9) {
                long[] jArr2 = this.kw;
                jArr2[i9] = j4;
                System.arraycopy(jArr2, 0, jArr2, i9 + 1, i9);
                return;
            } else {
                long[] jArr3 = this.kw;
                long j8 = jArr[i8];
                jArr3[i8] = j8;
                j4 ^= j8;
                i8++;
            }
        }
    }

    private void setTweak(long[] jArr) {
        if (jArr.length != 2) {
            throw new IllegalArgumentException("Tweak must be 2 words.");
        }
        long[] jArr2 = this.f4476t;
        long j4 = jArr[0];
        jArr2[0] = j4;
        long j8 = jArr[1];
        jArr2[1] = j8;
        jArr2[2] = j4 ^ j8;
        jArr2[3] = j4;
        jArr2[4] = j8;
    }

    public static void wordToBytes(long j4, byte[] bArr, int i8) {
        Pack.longToLittleEndian(j4, bArr, i8);
    }

    public static long xorRotr(long j4, int i8, long j8) {
        long j9 = j4 ^ j8;
        return (j9 << (-i8)) | (j9 >>> i8);
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "Threefish-" + (this.blocksizeBytes * 8);
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return this.blocksizeBytes;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        byte[] key;
        byte[] tweak;
        long[] jArr;
        long[] jArr2 = null;
        if (cipherParameters instanceof TweakableBlockCipherParameters) {
            TweakableBlockCipherParameters tweakableBlockCipherParameters = (TweakableBlockCipherParameters) cipherParameters;
            key = tweakableBlockCipherParameters.getKey().getKey();
            tweak = tweakableBlockCipherParameters.getTweak();
        } else {
            if (!(cipherParameters instanceof KeyParameter)) {
                throw new IllegalArgumentException(f.h(cipherParameters, "Invalid parameter passed to Threefish init - "));
            }
            key = ((KeyParameter) cipherParameters).getKey();
            tweak = null;
        }
        if (key == null) {
            jArr = null;
        } else {
            if (key.length != this.blocksizeBytes) {
                throw new IllegalArgumentException(f.e(new StringBuilder("Threefish key must be same size as block ("), this.blocksizeBytes, " bytes)"));
            }
            jArr = new long[this.blocksizeWords];
            Pack.littleEndianToLong(key, 0, jArr);
        }
        if (tweak != null) {
            if (tweak.length != 16) {
                throw new IllegalArgumentException("Threefish tweak must be 16 bytes");
            }
            jArr2 = new long[2];
            Pack.littleEndianToLong(tweak, 0, jArr2);
        }
        init(z, jArr, jArr2);
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties(getAlgorithmName(), 256, cipherParameters, Utils.getPurpose(z)));
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i8, byte[] bArr2, int i9) {
        int i10 = this.blocksizeBytes;
        if (i8 + i10 > bArr.length) {
            throw new DataLengthException("Input buffer too short");
        }
        if (i10 + i9 > bArr2.length) {
            throw new OutputLengthException("Output buffer too short");
        }
        Pack.littleEndianToLong(bArr, i8, this.currentBlock);
        long[] jArr = this.currentBlock;
        processBlock(jArr, jArr);
        Pack.longToLittleEndian(this.currentBlock, bArr2, i9);
        return this.blocksizeBytes;
    }

    public int processBlock(long[] jArr, long[] jArr2) {
        long[] jArr3 = this.kw;
        int i8 = this.blocksizeWords;
        if (jArr3[i8] == 0) {
            throw new IllegalStateException("Threefish engine not initialised");
        }
        if (jArr.length != i8) {
            throw new DataLengthException("Input buffer too short");
        }
        if (jArr2.length != i8) {
            throw new OutputLengthException("Output buffer too short");
        }
        if (this.forEncryption) {
            this.cipher.encryptBlock(jArr, jArr2);
        } else {
            this.cipher.decryptBlock(jArr, jArr2);
        }
        return this.blocksizeWords;
    }

    public void init(boolean z, long[] jArr, long[] jArr2) {
        this.forEncryption = z;
        if (jArr != null) {
            setKey(jArr);
        }
        if (jArr2 != null) {
            setTweak(jArr2);
        }
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
    }
}

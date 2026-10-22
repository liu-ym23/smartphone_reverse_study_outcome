package org.bouncycastle.crypto.digests;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.bouncycastle.crypto.CryptoServiceProperties;
import org.bouncycastle.crypto.CryptoServicePurpose;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;

/* loaded from: classes.dex */
public class DSTU7564Digest implements ExtendedDigest, Memoable {
    private static final int NB_1024 = 16;
    private static final int NB_512 = 8;
    private static final int NR_1024 = 14;
    private static final int NR_512 = 10;
    private static final byte[] S0 = {-88, 67, 95, 6, 107, 117, 108, 89, 113, -33, -121, -107, 23, -16, -40, 9, 109, -13, 29, -53, -55, 77, 44, -81, 121, -32, -105, -3, 111, 75, 69, 57, 62, -35, -93, 79, -76, -74, -102, 14, 31, -65, 21, -31, 73, -46, -109, -58, -110, 114, -98, 97, -47, 99, -6, -18, -12, 25, -43, -83, 88, -92, -69, -95, -36, -14, -125, 55, 66, -28, 122, 50, -100, -52, -85, 74, -113, 110, 4, 39, 46, -25, -30, 90, -106, 22, 35, 43, -62, 101, 102, 15, PSSSigner.TRAILER_IMPLICIT, -87, 71, 65, 52, 72, -4, -73, 106, -120, -91, 83, -122, -7, 91, -37, 56, 123, -61, 30, 34, 51, 36, 40, 54, -57, -78, 59, -114, 119, -70, -11, 20, -97, 8, 85, -101, 76, -2, 96, 92, -38, 24, 70, -51, 125, 33, -80, 63, 27, -119, -1, -21, -124, 105, 58, -99, -41, -45, 112, 103, 64, -75, -34, 93, 48, -111, -79, 120, 17, 1, -27, 0, 104, -104, -96, -59, 2, -90, 116, 45, 11, -94, 118, -77, -66, -50, -67, -82, -23, -118, 49, 28, -20, -15, -103, -108, -86, -10, 38, 47, -17, -24, -116, 53, 3, -44, AbstractJsonLexerKt.TC_INVALID, -5, 5, -63, 94, -112, 32, 61, -126, -9, -22, 10, 13, 126, -8, 80, 26, -60, 7, 87, -72, 60, 98, -29, -56, -84, 82, 100, 16, -48, -39, 19, 12, 18, 41, 81, -71, -49, -42, 115, -115, -127, 84, -64, -19, 78, 68, -89, 42, -123, 37, -26, -54, 124, -117, 86, -128};
    private static final byte[] S1 = {-50, -69, -21, -110, -22, -53, 19, -63, -23, 58, -42, -78, -46, -112, 23, -8, 66, 21, 86, -76, 101, 28, -120, 67, -59, 92, 54, -70, -11, 87, 103, -115, 49, -10, 100, 88, -98, -12, 34, -86, 117, 15, 2, -79, -33, 109, 115, 77, 124, 38, 46, -9, 8, 93, 68, 62, -97, 20, -56, -82, 84, 16, -40, PSSSigner.TRAILER_IMPLICIT, 26, 107, 105, -13, -67, 51, -85, -6, -47, -101, 104, 78, 22, -107, -111, -18, 76, 99, -114, 91, -52, 60, 25, -95, -127, 73, 123, -39, 111, 55, 96, -54, -25, 43, 72, -3, -106, 69, -4, 65, 18, 13, 121, -27, -119, -116, -29, 32, 48, -36, -73, 108, 74, -75, 63, -105, -44, 98, 45, 6, -92, -91, -125, 95, 42, -38, -55, 0, 126, -94, 85, -65, 17, -43, -100, -49, 14, 10, 61, 81, 125, -109, 27, -2, -60, 71, 9, -122, 11, -113, -99, 106, 7, -71, -80, -104, 24, 50, 113, 75, -17, 59, 112, -96, -28, 64, -1, -61, -87, -26, 120, -7, -117, 70, -128, 30, 56, -31, -72, -88, -32, 12, 35, 118, 29, 37, 36, 5, -15, 110, -108, 40, -102, -124, -24, -93, 79, 119, -45, -123, -30, 82, -14, -126, 80, 122, 47, 116, 83, -77, 97, -81, 57, 53, -34, -51, 31, -103, -84, -83, 114, 44, -35, -48, -121, -66, 94, -90, -20, 4, -58, 3, 52, -5, -37, 89, -74, -62, 1, -16, 90, -19, -89, 102, 33, AbstractJsonLexerKt.TC_INVALID, -118, 39, -57, -64, 41, -41};
    private static final byte[] S2 = {-109, -39, -102, -75, -104, 34, 69, -4, -70, 106, -33, 2, -97, -36, 81, 89, 74, 23, 43, -62, -108, -12, -69, -93, 98, -28, 113, -44, -51, 112, 22, -31, 73, 60, -64, -40, 92, -101, -83, -123, 83, -95, 122, -56, 45, -32, -47, 114, -90, 44, -60, -29, 118, 120, -73, -76, 9, 59, 14, 65, 76, -34, -78, -112, 37, -91, -41, 3, 17, 0, -61, 46, -110, -17, 78, 18, -99, 125, -53, 53, 16, -43, 79, -98, 77, -87, 85, -58, -48, 123, 24, -105, -45, 54, -26, 72, 86, -127, -113, 119, -52, -100, -71, -30, -84, -72, 47, 21, -92, 124, -38, 56, 30, 11, 5, -42, 20, 110, 108, 126, 102, -3, -79, -27, 96, -81, 94, 51, -121, -55, -16, 93, 109, 63, -120, -115, -57, -9, 29, -23, -20, -19, -128, 41, 39, -49, -103, -88, 80, 15, 55, 36, 40, 48, -107, -46, 62, 91, 64, -125, -77, 105, 87, 31, 7, 28, -118, PSSSigner.TRAILER_IMPLICIT, 32, -21, -50, -114, -85, -18, 49, -94, 115, -7, -54, 58, 26, -5, 13, -63, -2, -6, -14, 111, -67, -106, -35, 67, 82, -74, 8, -13, -82, -66, 25, -119, 50, 38, -80, -22, 75, 100, -124, -126, 107, -11, 121, -65, 1, 95, 117, 99, 27, 35, 61, 104, 42, 101, -24, -111, -10, -1, 19, 88, -15, 71, 10, AbstractJsonLexerKt.TC_INVALID, -59, -89, -25, 97, 90, 6, 70, 68, 66, 4, -96, -37, 57, -122, 84, -86, -116, 52, 33, -117, -8, 12, 116, 103};
    private static final byte[] S3 = {104, -115, -54, 77, 115, 75, 78, 42, -44, 82, 38, -77, 84, 30, 25, 31, 34, 3, 70, 61, 45, 74, 83, -125, 19, -118, -73, -43, 37, 121, -11, -67, 88, 47, 13, 2, -19, 81, -98, 17, -14, 62, 85, 94, -47, 22, 60, 102, 112, 93, -13, 69, 64, -52, -24, -108, 86, 8, -50, 26, 58, -46, -31, -33, -75, 56, 110, 14, -27, -12, -7, -122, -23, 79, -42, -123, 35, -49, 50, -103, 49, 20, -82, -18, -56, 72, -45, 48, -95, -110, 65, -79, 24, -60, 44, 113, 114, 68, 21, -3, 55, -66, 95, -86, -101, -120, -40, -85, -119, -100, -6, 96, -22, PSSSigner.TRAILER_IMPLICIT, 98, 12, 36, -90, -88, -20, 103, 32, -37, 124, 40, -35, -84, 91, 52, 126, 16, -15, 123, -113, 99, -96, 5, -102, 67, 119, 33, -65, 39, 9, -61, -97, -74, -41, 41, -62, -21, -64, -92, -117, -116, 29, -5, -1, -63, -78, -105, 46, -8, 101, -10, 117, 7, 4, 73, 51, -28, -39, -71, -48, 66, -57, 108, -112, 0, -114, 111, 80, 1, -59, -38, 71, 63, -51, 105, -94, -30, 122, -89, -58, -109, 15, 10, 6, -26, 43, -106, -93, 28, -81, 106, 18, -124, 57, -25, -80, -126, -9, -2, -99, -121, 92, -127, 53, -34, -76, -91, -4, -128, -17, -53, -69, 107, 118, -70, 90, 125, 120, 11, -107, -29, -83, 116, -104, 59, 54, 100, 109, -36, -16, 89, -87, 76, 23, AbstractJsonLexerKt.TC_INVALID, -111, -72, -55, 87, 27, -32, 97};
    private int blockSize;
    private byte[] buf;
    private int bufOff;
    private int columns;
    private int hashSize;
    private long inputBlocks;
    private final CryptoServicePurpose purpose;
    private int rounds;
    private long[] state;
    private long[] tempState1;
    private long[] tempState2;

    public DSTU7564Digest(int i8) {
        this(i8, CryptoServicePurpose.ANY);
    }

    private void P(long[] jArr) {
        for (int i8 = 0; i8 < this.rounds; i8++) {
            long j4 = i8;
            for (int i9 = 0; i9 < this.columns; i9++) {
                jArr[i9] = jArr[i9] ^ j4;
                j4 += 16;
            }
            shiftRows(jArr);
            subBytes(jArr);
            mixColumns(jArr);
        }
    }

    private void Q(long[] jArr) {
        for (int i8 = 0; i8 < this.rounds; i8++) {
            long j4 = ((((this.columns - 1) << 4) ^ i8) << 56) | 67818912035696883L;
            for (int i9 = 0; i9 < this.columns; i9++) {
                jArr[i9] = jArr[i9] + j4;
                j4 -= 1152921504606846976L;
            }
            shiftRows(jArr);
            subBytes(jArr);
            mixColumns(jArr);
        }
    }

    private void copyIn(DSTU7564Digest dSTU7564Digest) {
        this.hashSize = dSTU7564Digest.hashSize;
        this.blockSize = dSTU7564Digest.blockSize;
        this.rounds = dSTU7564Digest.rounds;
        int i8 = this.columns;
        if (i8 <= 0 || i8 != dSTU7564Digest.columns) {
            this.columns = dSTU7564Digest.columns;
            this.state = Arrays.clone(dSTU7564Digest.state);
            int i9 = this.columns;
            this.tempState1 = new long[i9];
            this.tempState2 = new long[i9];
            this.buf = Arrays.clone(dSTU7564Digest.buf);
        } else {
            System.arraycopy(dSTU7564Digest.state, 0, this.state, 0, i8);
            System.arraycopy(dSTU7564Digest.buf, 0, this.buf, 0, this.blockSize);
        }
        this.inputBlocks = dSTU7564Digest.inputBlocks;
        this.bufOff = dSTU7564Digest.bufOff;
    }

    private static long mixColumn(long j4) {
        long j8 = ((9187201950435737471L & j4) << 1) ^ (((j4 & (-9187201950435737472L)) >>> 7) * 29);
        long jRotate = rotate(8, j4) ^ j4;
        long jRotate2 = (jRotate ^ rotate(16, jRotate)) ^ rotate(48, j4);
        long j9 = (j4 ^ jRotate2) ^ j8;
        return ((rotate(32, (((j9 & 4629771061636907072L) >>> 6) * 29) ^ (((((-9187201950435737472L) & j9) >>> 6) * 29) ^ ((4557430888798830399L & j9) << 2))) ^ jRotate2) ^ rotate(40, j8)) ^ rotate(48, j8);
    }

    private void mixColumns(long[] jArr) {
        for (int i8 = 0; i8 < this.columns; i8++) {
            jArr[i8] = mixColumn(jArr[i8]);
        }
    }

    private void processBlock(byte[] bArr, int i8) {
        for (int i9 = 0; i9 < this.columns; i9++) {
            long jLittleEndianToLong = Pack.littleEndianToLong(bArr, i8);
            i8 += 8;
            this.tempState1[i9] = this.state[i9] ^ jLittleEndianToLong;
            this.tempState2[i9] = jLittleEndianToLong;
        }
        P(this.tempState1);
        Q(this.tempState2);
        for (int i10 = 0; i10 < this.columns; i10++) {
            long[] jArr = this.state;
            jArr[i10] = jArr[i10] ^ (this.tempState1[i10] ^ this.tempState2[i10]);
        }
    }

    private static long rotate(int i8, long j4) {
        return (j4 << (-i8)) | (j4 >>> i8);
    }

    private void shiftRows(long[] jArr) {
        int i8 = this.columns;
        if (i8 == 8) {
            long j4 = jArr[0];
            long j8 = jArr[1];
            long j9 = jArr[2];
            long j10 = jArr[3];
            long j11 = jArr[4];
            long j12 = jArr[5];
            long j13 = jArr[6];
            long j14 = jArr[7];
            long j15 = (j4 ^ j11) & (-4294967296L);
            long j16 = j4 ^ j15;
            long j17 = j11 ^ j15;
            long j18 = (j8 ^ j12) & 72057594021150720L;
            long j19 = j8 ^ j18;
            long j20 = j12 ^ j18;
            long j21 = (j9 ^ j13) & 281474976645120L;
            long j22 = j9 ^ j21;
            long j23 = j13 ^ j21;
            long j24 = (j10 ^ j14) & 1099511627520L;
            long j25 = j10 ^ j24;
            long j26 = j14 ^ j24;
            long j27 = (j16 ^ j22) & (-281470681808896L);
            long j28 = j16 ^ j27;
            long j29 = j22 ^ j27;
            long j30 = (j19 ^ j25) & 72056494543077120L;
            long j31 = j19 ^ j30;
            long j32 = j25 ^ j30;
            long j33 = (j17 ^ j23) & (-281470681808896L);
            long j34 = j17 ^ j33;
            long j35 = j23 ^ j33;
            long j36 = (j20 ^ j26) & 72056494543077120L;
            long j37 = j20 ^ j36;
            long j38 = j26 ^ j36;
            long j39 = (j28 ^ j31) & (-71777214294589696L);
            long j40 = j28 ^ j39;
            long j41 = j31 ^ j39;
            long j42 = (j29 ^ j32) & (-71777214294589696L);
            long j43 = j29 ^ j42;
            long j44 = j32 ^ j42;
            long j45 = (j34 ^ j37) & (-71777214294589696L);
            long j46 = (j35 ^ j38) & (-71777214294589696L);
            jArr[0] = j40;
            jArr[1] = j41;
            jArr[2] = j43;
            jArr[3] = j44;
            jArr[4] = j34 ^ j45;
            jArr[5] = j37 ^ j45;
            jArr[6] = j35 ^ j46;
            jArr[7] = j38 ^ j46;
            return;
        }
        if (i8 != 16) {
            throw new IllegalStateException("unsupported state size: only 512/1024 are allowed");
        }
        long j47 = jArr[0];
        long j48 = jArr[1];
        long j49 = jArr[2];
        long j50 = jArr[3];
        long j51 = jArr[4];
        long j52 = jArr[5];
        long j53 = jArr[6];
        long j54 = jArr[7];
        long j55 = jArr[8];
        long j56 = jArr[9];
        long j57 = jArr[10];
        long j58 = jArr[11];
        long j59 = jArr[12];
        long j60 = jArr[13];
        long j61 = jArr[14];
        long j62 = jArr[15];
        long j63 = (j47 ^ j55) & (-72057594037927936L);
        long j64 = j47 ^ j63;
        long j65 = j55 ^ j63;
        long j66 = (j48 ^ j56) & (-72057594037927936L);
        long j67 = j48 ^ j66;
        long j68 = j56 ^ j66;
        long j69 = (j49 ^ j57) & (-281474976710656L);
        long j70 = j49 ^ j69;
        long j71 = j57 ^ j69;
        long j72 = (j50 ^ j58) & (-1099511627776L);
        long j73 = j50 ^ j72;
        long j74 = j58 ^ j72;
        long j75 = (j51 ^ j59) & (-4294967296L);
        long j76 = j51 ^ j75;
        long j77 = j59 ^ j75;
        long j78 = (j52 ^ j60) & 72057594021150720L;
        long j79 = j52 ^ j78;
        long j80 = j60 ^ j78;
        long j81 = (j53 ^ j61) & 72057594037862400L;
        long j82 = j53 ^ j81;
        long j83 = j61 ^ j81;
        long j84 = (j54 ^ j62) & 72057594037927680L;
        long j85 = j54 ^ j84;
        long j86 = j62 ^ j84;
        long j87 = (j64 ^ j76) & 72057589742960640L;
        long j88 = j64 ^ j87;
        long j89 = j76 ^ j87;
        long j90 = (j67 ^ j79) & (-16777216);
        long j91 = j67 ^ j90;
        long j92 = j79 ^ j90;
        long j93 = (j70 ^ j82) & (-71776119061282816L);
        long j94 = j70 ^ j93;
        long j95 = j82 ^ j93;
        long j96 = (j73 ^ j85) & (-72056494526300416L);
        long j97 = j73 ^ j96;
        long j98 = j85 ^ j96;
        long j99 = (j65 ^ j77) & 72057589742960640L;
        long j100 = j65 ^ j99;
        long j101 = j77 ^ j99;
        long j102 = (j68 ^ j80) & (-16777216);
        long j103 = j68 ^ j102;
        long j104 = j80 ^ j102;
        long j105 = (j71 ^ j83) & (-71776119061282816L);
        long j106 = j71 ^ j105;
        long j107 = j83 ^ j105;
        long j108 = (j74 ^ j86) & (-72056494526300416L);
        long j109 = j74 ^ j108;
        long j110 = j86 ^ j108;
        long j111 = (j88 ^ j94) & (-281470681808896L);
        long j112 = j88 ^ j111;
        long j113 = j94 ^ j111;
        long j114 = (j91 ^ j97) & 72056494543077120L;
        long j115 = j91 ^ j114;
        long j116 = j97 ^ j114;
        long j117 = (j89 ^ j95) & (-281470681808896L);
        long j118 = j89 ^ j117;
        long j119 = j95 ^ j117;
        long j120 = (j92 ^ j98) & 72056494543077120L;
        long j121 = j92 ^ j120;
        long j122 = j98 ^ j120;
        long j123 = (j100 ^ j106) & (-281470681808896L);
        long j124 = j100 ^ j123;
        long j125 = j106 ^ j123;
        long j126 = (j103 ^ j109) & 72056494543077120L;
        long j127 = j103 ^ j126;
        long j128 = j109 ^ j126;
        long j129 = (j101 ^ j107) & (-281470681808896L);
        long j130 = j101 ^ j129;
        long j131 = j107 ^ j129;
        long j132 = (j104 ^ j110) & 72056494543077120L;
        long j133 = j104 ^ j132;
        long j134 = j110 ^ j132;
        long j135 = (j112 ^ j115) & (-71777214294589696L);
        long j136 = j112 ^ j135;
        long j137 = j115 ^ j135;
        long j138 = (j113 ^ j116) & (-71777214294589696L);
        long j139 = j113 ^ j138;
        long j140 = j116 ^ j138;
        long j141 = (j118 ^ j121) & (-71777214294589696L);
        long j142 = j118 ^ j141;
        long j143 = j121 ^ j141;
        long j144 = (j119 ^ j122) & (-71777214294589696L);
        long j145 = j119 ^ j144;
        long j146 = j122 ^ j144;
        long j147 = (j124 ^ j127) & (-71777214294589696L);
        long j148 = j124 ^ j147;
        long j149 = j127 ^ j147;
        long j150 = (j125 ^ j128) & (-71777214294589696L);
        long j151 = j125 ^ j150;
        long j152 = j128 ^ j150;
        long j153 = (j130 ^ j133) & (-71777214294589696L);
        long j154 = (j131 ^ j134) & (-71777214294589696L);
        jArr[0] = j136;
        jArr[1] = j137;
        jArr[2] = j139;
        jArr[3] = j140;
        jArr[4] = j142;
        jArr[5] = j143;
        jArr[6] = j145;
        jArr[7] = j146;
        jArr[8] = j148;
        jArr[9] = j149;
        jArr[10] = j151;
        jArr[11] = j152;
        jArr[12] = j130 ^ j153;
        jArr[13] = j133 ^ j153;
        jArr[14] = j131 ^ j154;
        jArr[15] = j134 ^ j154;
    }

    private void subBytes(long[] jArr) {
        for (int i8 = 0; i8 < this.columns; i8++) {
            long j4 = jArr[i8];
            int i9 = (int) j4;
            int i10 = (int) (j4 >>> 32);
            byte[] bArr = S0;
            byte b9 = bArr[i9 & 255];
            byte[] bArr2 = S1;
            byte b10 = bArr2[(i9 >>> 8) & 255];
            byte[] bArr3 = S2;
            byte b11 = bArr3[(i9 >>> 16) & 255];
            int i11 = (S3[i9 >>> 24] << 24) | (b9 & 255) | ((b10 & 255) << 8) | ((b11 & 255) << 16);
            byte b12 = bArr[i10 & 255];
            byte b13 = bArr2[(i10 >>> 8) & 255];
            byte b14 = bArr3[(i10 >>> 16) & 255];
            jArr[i8] = (i11 & 4294967295L) | (((r10[i10 >>> 24] << 24) | (((b12 & 255) | ((b13 & 255) << 8)) | ((b14 & 255) << 16))) << 32);
        }
    }

    @Override // org.bouncycastle.util.Memoable
    public Memoable copy() {
        return new DSTU7564Digest(this);
    }

    public CryptoServiceProperties cryptoServiceProperties() {
        return Utils.getDefaultProperties(this, 256, this.purpose);
    }

    @Override // org.bouncycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i8) {
        int i9;
        int i10;
        int i11 = this.bufOff;
        byte[] bArr2 = this.buf;
        int i12 = i11 + 1;
        this.bufOff = i12;
        bArr2[i11] = -128;
        int i13 = this.blockSize - 12;
        int i14 = 0;
        if (i12 > i13) {
            while (true) {
                int i15 = this.bufOff;
                if (i15 >= this.blockSize) {
                    break;
                }
                byte[] bArr3 = this.buf;
                this.bufOff = i15 + 1;
                bArr3[i15] = 0;
            }
            this.bufOff = 0;
            processBlock(this.buf, 0);
        }
        while (true) {
            i9 = this.bufOff;
            if (i9 >= i13) {
                break;
            }
            byte[] bArr4 = this.buf;
            this.bufOff = i9 + 1;
            bArr4[i9] = 0;
        }
        long j4 = (((this.inputBlocks & 4294967295L) * this.blockSize) + i11) << 3;
        Pack.intToLittleEndian((int) j4, this.buf, i9);
        int i16 = this.bufOff + 4;
        this.bufOff = i16;
        Pack.longToLittleEndian((j4 >>> 32) + (((this.inputBlocks >>> 32) * this.blockSize) << 3), this.buf, i16);
        processBlock(this.buf, 0);
        System.arraycopy(this.state, 0, this.tempState1, 0, this.columns);
        P(this.tempState1);
        while (true) {
            i10 = this.columns;
            if (i14 >= i10) {
                break;
            }
            long[] jArr = this.state;
            jArr[i14] = jArr[i14] ^ this.tempState1[i14];
            i14++;
        }
        for (int i17 = i10 - (this.hashSize >>> 3); i17 < this.columns; i17++) {
            Pack.longToLittleEndian(this.state[i17], bArr, i8);
            i8 += 8;
        }
        reset();
        return this.hashSize;
    }

    @Override // org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return "DSTU7564";
    }

    @Override // org.bouncycastle.crypto.ExtendedDigest
    public int getByteLength() {
        return this.blockSize;
    }

    @Override // org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return this.hashSize;
    }

    @Override // org.bouncycastle.crypto.Digest
    public void reset() {
        Arrays.fill(this.state, 0L);
        this.state[0] = this.blockSize;
        this.inputBlocks = 0L;
        this.bufOff = 0;
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte b9) {
        byte[] bArr = this.buf;
        int i8 = this.bufOff;
        int i9 = i8 + 1;
        this.bufOff = i9;
        bArr[i8] = b9;
        if (i9 == this.blockSize) {
            processBlock(bArr, 0);
            this.bufOff = 0;
            this.inputBlocks++;
        }
    }

    public DSTU7564Digest(int i8, CryptoServicePurpose cryptoServicePurpose) {
        int i9;
        this.purpose = cryptoServicePurpose;
        if (i8 != 256 && i8 != 384 && i8 != 512) {
            throw new IllegalArgumentException("Hash size is not recommended. Use 256/384/512 instead");
        }
        this.hashSize = i8 >>> 3;
        if (i8 > 256) {
            this.columns = 16;
            i9 = 14;
        } else {
            this.columns = 8;
            i9 = 10;
        }
        this.rounds = i9;
        int i10 = this.columns;
        int i11 = i10 << 3;
        this.blockSize = i11;
        long[] jArr = new long[i10];
        this.state = jArr;
        jArr[0] = i11;
        this.tempState1 = new long[i10];
        this.tempState2 = new long[i10];
        this.buf = new byte[i11];
        CryptoServicesRegistrar.checkConstraints(cryptoServiceProperties());
    }

    @Override // org.bouncycastle.util.Memoable
    public void reset(Memoable memoable) {
        copyIn((DSTU7564Digest) memoable);
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte[] bArr, int i8, int i9) {
        while (this.bufOff != 0 && i9 > 0) {
            update(bArr[i8]);
            i9--;
            i8++;
        }
        if (i9 > 0) {
            while (i9 >= this.blockSize) {
                processBlock(bArr, i8);
                int i10 = this.blockSize;
                i8 += i10;
                i9 -= i10;
                this.inputBlocks++;
            }
            while (i9 > 0) {
                update(bArr[i8]);
                i9--;
                i8++;
            }
        }
    }

    public DSTU7564Digest(DSTU7564Digest dSTU7564Digest) {
        this.purpose = dSTU7564Digest.purpose;
        copyIn(dSTU7564Digest);
        CryptoServicesRegistrar.checkConstraints(cryptoServiceProperties());
    }
}

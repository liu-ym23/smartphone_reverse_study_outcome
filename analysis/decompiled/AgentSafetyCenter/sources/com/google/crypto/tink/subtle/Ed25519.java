package com.google.crypto.tink.subtle;

import b8.z;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;
import od.f;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
final class Ed25519 {
    public static final int PUBLIC_KEY_LEN = 32;
    public static final int SECRET_KEY_LEN = 32;
    public static final int SIGNATURE_LEN = 64;
    private static final CachedXYT CACHED_NEUTRAL = new CachedXYT(new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    private static final PartialXYZT NEUTRAL = new PartialXYZT(new XYZ(new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}), new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    static final byte[] GROUP_ORDER = {-19, -45, -11, 92, 26, 99, 18, 88, -42, -100, -9, -94, -34, -7, -34, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16};

    private Ed25519() {
    }

    private static void add(PartialXYZT partialXYZT, XYZT xyzt, CachedXYT cachedXYT) {
        long[] jArr = new long[10];
        long[] jArr2 = partialXYZT.xyz.f2480x;
        XYZ xyz = xyzt.xyz;
        Field25519.sum(jArr2, xyz.f2481y, xyz.f2480x);
        long[] jArr3 = partialXYZT.xyz.f2481y;
        XYZ xyz2 = xyzt.xyz;
        Field25519.sub(jArr3, xyz2.f2481y, xyz2.f2480x);
        long[] jArr4 = partialXYZT.xyz.f2481y;
        Field25519.mult(jArr4, jArr4, cachedXYT.yMinusX);
        XYZ xyz3 = partialXYZT.xyz;
        Field25519.mult(xyz3.f2482z, xyz3.f2480x, cachedXYT.yPlusX);
        Field25519.mult(partialXYZT.f2479t, xyzt.f2483t, cachedXYT.t2d);
        cachedXYT.multByZ(partialXYZT.xyz.f2480x, xyzt.xyz.f2482z);
        long[] jArr5 = partialXYZT.xyz.f2480x;
        Field25519.sum(jArr, jArr5, jArr5);
        XYZ xyz4 = partialXYZT.xyz;
        Field25519.sub(xyz4.f2480x, xyz4.f2482z, xyz4.f2481y);
        XYZ xyz5 = partialXYZT.xyz;
        long[] jArr6 = xyz5.f2481y;
        Field25519.sum(jArr6, xyz5.f2482z, jArr6);
        Field25519.sum(partialXYZT.xyz.f2482z, jArr, partialXYZT.f2479t);
        long[] jArr7 = partialXYZT.f2479t;
        Field25519.sub(jArr7, jArr, jArr7);
    }

    private static XYZ doubleScalarMultVarTime(byte[] bArr, XYZT xyzt, byte[] bArr2) {
        CachedXYZT[] cachedXYZTArr = new CachedXYZT[8];
        cachedXYZTArr[0] = new CachedXYZT(xyzt);
        PartialXYZT partialXYZT = new PartialXYZT();
        doubleXYZT(partialXYZT, xyzt);
        XYZT xyzt2 = new XYZT(partialXYZT);
        for (int i = 1; i < 8; i++) {
            add(partialXYZT, xyzt2, cachedXYZTArr[i - 1]);
            cachedXYZTArr[i] = new CachedXYZT(new XYZT(partialXYZT));
        }
        byte[] bArrSlide = slide(bArr);
        byte[] bArrSlide2 = slide(bArr2);
        PartialXYZT partialXYZT2 = new PartialXYZT(NEUTRAL);
        XYZT xyzt3 = new XYZT();
        int i3 = 255;
        while (i3 >= 0 && bArrSlide[i3] == 0 && bArrSlide2[i3] == 0) {
            i3--;
        }
        while (i3 >= 0) {
            doubleXYZ(partialXYZT2, new XYZ(partialXYZT2));
            byte b10 = bArrSlide[i3];
            if (b10 > 0) {
                add(partialXYZT2, XYZT.fromPartialXYZT(xyzt3, partialXYZT2), cachedXYZTArr[bArrSlide[i3] / 2]);
            } else if (b10 < 0) {
                sub(partialXYZT2, XYZT.fromPartialXYZT(xyzt3, partialXYZT2), cachedXYZTArr[(-bArrSlide[i3]) / 2]);
            }
            byte b11 = bArrSlide2[i3];
            if (b11 > 0) {
                add(partialXYZT2, XYZT.fromPartialXYZT(xyzt3, partialXYZT2), Ed25519Constants.B2[bArrSlide2[i3] / 2]);
            } else if (b11 < 0) {
                sub(partialXYZT2, XYZT.fromPartialXYZT(xyzt3, partialXYZT2), Ed25519Constants.B2[(-bArrSlide2[i3]) / 2]);
            }
            i3--;
        }
        return new XYZ(partialXYZT2);
    }

    private static void doubleXYZ(PartialXYZT partialXYZT, XYZ xyz) {
        long[] jArr = new long[10];
        Field25519.square(partialXYZT.xyz.f2480x, xyz.f2480x);
        Field25519.square(partialXYZT.xyz.f2482z, xyz.f2481y);
        Field25519.square(partialXYZT.f2479t, xyz.f2482z);
        long[] jArr2 = partialXYZT.f2479t;
        Field25519.sum(jArr2, jArr2, jArr2);
        Field25519.sum(partialXYZT.xyz.f2481y, xyz.f2480x, xyz.f2481y);
        Field25519.square(jArr, partialXYZT.xyz.f2481y);
        XYZ xyz2 = partialXYZT.xyz;
        Field25519.sum(xyz2.f2481y, xyz2.f2482z, xyz2.f2480x);
        XYZ xyz3 = partialXYZT.xyz;
        long[] jArr3 = xyz3.f2482z;
        Field25519.sub(jArr3, jArr3, xyz3.f2480x);
        XYZ xyz4 = partialXYZT.xyz;
        Field25519.sub(xyz4.f2480x, jArr, xyz4.f2481y);
        long[] jArr4 = partialXYZT.f2479t;
        Field25519.sub(jArr4, jArr4, partialXYZT.xyz.f2482z);
    }

    private static void doubleXYZT(PartialXYZT partialXYZT, XYZT xyzt) {
        doubleXYZ(partialXYZT, xyzt.xyz);
    }

    private static int eq(int i, int i3) {
        int i10 = (~(i ^ i3)) & 255;
        int i11 = i10 & (i10 << 4);
        int i12 = i11 & (i11 << 2);
        return ((i12 & (i12 << 1)) >> 7) & 1;
    }

    public static byte[] getHashedScalar(byte[] bArr) {
        MessageDigest engineFactory = EngineFactory.MESSAGE_DIGEST.getInstance("SHA-512");
        engineFactory.update(bArr, 0, 32);
        byte[] bArrDigest = engineFactory.digest();
        bArrDigest[0] = (byte) (bArrDigest[0] & 248);
        byte b10 = (byte) (bArrDigest[31] & 127);
        bArrDigest[31] = b10;
        bArrDigest[31] = (byte) (b10 | 64);
        return bArrDigest;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getLsb(long[] jArr) {
        return Field25519.contract(jArr)[0] & 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isNonZeroVarTime(long[] jArr) {
        long[] jArr2 = new long[jArr.length + 1];
        System.arraycopy(jArr, 0, jArr2, 0, jArr.length);
        Field25519.reduceCoefficients(jArr2);
        for (byte b10 : Field25519.contract(jArr2)) {
            if (b10 != 0) {
                return true;
            }
        }
        return false;
    }

    private static boolean isSmallerThanGroupOrder(byte[] bArr) {
        for (int i = 31; i >= 0; i--) {
            int i3 = bArr[i] & 255;
            int i10 = GROUP_ORDER[i] & 255;
            if (i3 != i10) {
                return i3 < i10;
            }
        }
        return false;
    }

    private static long load3(byte[] bArr, int i) {
        return ((bArr[i + 2] & 255) << 16) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8);
    }

    private static long load4(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | load3(bArr, i);
    }

    private static void mulAdd(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        long jLoad3 = load3(bArr2, 0) & 2097151;
        long jLoad4 = (load4(bArr2, 2) >> 5) & 2097151;
        long jLoad32 = (load3(bArr2, 5) >> 2) & 2097151;
        long jLoad42 = (load4(bArr2, 7) >> 7) & 2097151;
        long jLoad43 = (load4(bArr2, 10) >> 4) & 2097151;
        long jLoad33 = (load3(bArr2, 13) >> 1) & 2097151;
        long jLoad44 = (load4(bArr2, 15) >> 6) & 2097151;
        long jLoad34 = (load3(bArr2, 18) >> 3) & 2097151;
        long jLoad35 = load3(bArr2, 21) & 2097151;
        long jLoad45 = (load4(bArr2, 23) >> 5) & 2097151;
        long jLoad36 = (load3(bArr2, 26) >> 2) & 2097151;
        long jLoad46 = load4(bArr2, 28) >> 7;
        long jLoad37 = load3(bArr3, 0) & 2097151;
        long jLoad47 = (load4(bArr3, 2) >> 5) & 2097151;
        long jLoad38 = (load3(bArr3, 5) >> 2) & 2097151;
        long jLoad48 = (load4(bArr3, 7) >> 7) & 2097151;
        long jLoad49 = (load4(bArr3, 10) >> 4) & 2097151;
        long jLoad39 = (load3(bArr3, 13) >> 1) & 2097151;
        long jLoad410 = (load4(bArr3, 15) >> 6) & 2097151;
        long jLoad310 = (load3(bArr3, 18) >> 3) & 2097151;
        long jLoad311 = load3(bArr3, 21) & 2097151;
        long jLoad411 = (load4(bArr3, 23) >> 5) & 2097151;
        long jLoad312 = (load3(bArr3, 26) >> 2) & 2097151;
        long jLoad412 = load4(bArr3, 28) >> 7;
        long jLoad313 = load3(bArr4, 0) & 2097151;
        long jLoad413 = (load4(bArr4, 2) >> 5) & 2097151;
        long jLoad314 = (load3(bArr4, 5) >> 2) & 2097151;
        long jLoad414 = (load4(bArr4, 7) >> 7) & 2097151;
        long jLoad415 = (load4(bArr4, 10) >> 4) & 2097151;
        long jLoad315 = (load3(bArr4, 13) >> 1) & 2097151;
        long jLoad416 = (load4(bArr4, 15) >> 6) & 2097151;
        long jLoad316 = (load3(bArr4, 18) >> 3) & 2097151;
        long jLoad317 = load3(bArr4, 21) & 2097151;
        long j10 = (jLoad3 * jLoad37) + jLoad313;
        long j11 = (jLoad4 * jLoad37) + (jLoad3 * jLoad47) + jLoad413;
        long j12 = (jLoad32 * jLoad37) + (jLoad4 * jLoad47) + (jLoad3 * jLoad38) + jLoad314;
        long j13 = (jLoad42 * jLoad37) + (jLoad32 * jLoad47) + (jLoad4 * jLoad38) + (jLoad3 * jLoad48) + jLoad414;
        long j14 = (jLoad43 * jLoad37) + (jLoad42 * jLoad47) + (jLoad32 * jLoad38) + (jLoad4 * jLoad48) + (jLoad3 * jLoad49) + jLoad415;
        long j15 = (jLoad33 * jLoad37) + (jLoad43 * jLoad47) + (jLoad42 * jLoad38) + (jLoad32 * jLoad48) + (jLoad4 * jLoad49) + (jLoad3 * jLoad39) + jLoad315;
        long j16 = (jLoad44 * jLoad37) + (jLoad33 * jLoad47) + (jLoad43 * jLoad38) + (jLoad42 * jLoad48) + (jLoad32 * jLoad49) + (jLoad4 * jLoad39) + (jLoad3 * jLoad410) + jLoad416;
        long j17 = (jLoad34 * jLoad37) + (jLoad44 * jLoad47) + (jLoad33 * jLoad38) + (jLoad43 * jLoad48) + (jLoad42 * jLoad49) + (jLoad32 * jLoad39) + (jLoad4 * jLoad410) + (jLoad3 * jLoad310) + jLoad316;
        long j18 = (jLoad35 * jLoad37) + (jLoad34 * jLoad47) + (jLoad44 * jLoad38) + (jLoad33 * jLoad48) + (jLoad43 * jLoad49) + (jLoad42 * jLoad39) + (jLoad32 * jLoad410) + (jLoad4 * jLoad310) + (jLoad3 * jLoad311) + jLoad317;
        long jLoad417 = (jLoad45 * jLoad37) + (jLoad35 * jLoad47) + (jLoad34 * jLoad38) + (jLoad44 * jLoad48) + (jLoad33 * jLoad49) + (jLoad43 * jLoad39) + (jLoad42 * jLoad410) + (jLoad32 * jLoad310) + (jLoad4 * jLoad311) + (jLoad3 * jLoad411) + ((load4(bArr4, 23) >> 5) & 2097151);
        long jLoad318 = (jLoad36 * jLoad37) + (jLoad45 * jLoad47) + (jLoad35 * jLoad38) + (jLoad34 * jLoad48) + (jLoad44 * jLoad49) + (jLoad33 * jLoad39) + (jLoad43 * jLoad410) + (jLoad42 * jLoad310) + (jLoad32 * jLoad311) + (jLoad4 * jLoad411) + (jLoad3 * jLoad312) + ((load3(bArr4, 26) >> 2) & 2097151);
        long j19 = jLoad37 * jLoad46;
        long jLoad418 = j19 + (jLoad36 * jLoad47) + (jLoad45 * jLoad38) + (jLoad35 * jLoad48) + (jLoad34 * jLoad49) + (jLoad44 * jLoad39) + (jLoad33 * jLoad410) + (jLoad43 * jLoad310) + (jLoad42 * jLoad311) + (jLoad32 * jLoad411) + (jLoad4 * jLoad312) + (jLoad3 * jLoad412) + (load4(bArr4, 28) >> 7);
        long j20 = (jLoad47 * jLoad46) + (jLoad36 * jLoad38) + (jLoad45 * jLoad48) + (jLoad35 * jLoad49) + (jLoad34 * jLoad39) + (jLoad44 * jLoad410) + (jLoad33 * jLoad310) + (jLoad43 * jLoad311) + (jLoad42 * jLoad411) + (jLoad32 * jLoad312) + (jLoad4 * jLoad412);
        long j21 = jLoad38 * jLoad46;
        long j22 = j21 + (jLoad36 * jLoad48) + (jLoad45 * jLoad49) + (jLoad35 * jLoad39) + (jLoad34 * jLoad410) + (jLoad44 * jLoad310) + (jLoad33 * jLoad311) + (jLoad43 * jLoad411) + (jLoad42 * jLoad312) + (jLoad32 * jLoad412);
        long j23 = jLoad48 * jLoad46;
        long j24 = j23 + (jLoad36 * jLoad49) + (jLoad45 * jLoad39) + (jLoad35 * jLoad410) + (jLoad34 * jLoad310) + (jLoad44 * jLoad311) + (jLoad33 * jLoad411) + (jLoad43 * jLoad312) + (jLoad42 * jLoad412);
        long j25 = jLoad49 * jLoad46;
        long j26 = j25 + (jLoad36 * jLoad39) + (jLoad45 * jLoad410) + (jLoad35 * jLoad310) + (jLoad34 * jLoad311) + (jLoad44 * jLoad411) + (jLoad33 * jLoad312) + (jLoad43 * jLoad412);
        long j27 = jLoad39 * jLoad46;
        long j28 = j27 + (jLoad36 * jLoad410) + (jLoad45 * jLoad310) + (jLoad35 * jLoad311) + (jLoad34 * jLoad411) + (jLoad44 * jLoad312) + (jLoad33 * jLoad412);
        long j29 = jLoad410 * jLoad46;
        long j30 = j29 + (jLoad36 * jLoad310) + (jLoad45 * jLoad311) + (jLoad35 * jLoad411) + (jLoad34 * jLoad312) + (jLoad44 * jLoad412);
        long j31 = jLoad310 * jLoad46;
        long j32 = j31 + (jLoad36 * jLoad311) + (jLoad45 * jLoad411) + (jLoad35 * jLoad312) + (jLoad34 * jLoad412);
        long j33 = jLoad311 * jLoad46;
        long j34 = j33 + (jLoad36 * jLoad411) + (jLoad45 * jLoad312) + (jLoad35 * jLoad412);
        long j35 = (jLoad411 * jLoad46) + (jLoad36 * jLoad312) + (jLoad45 * jLoad412);
        long j36 = jLoad312 * jLoad46;
        long j37 = jLoad46 * jLoad412;
        long j38 = (j10 + 1048576) >> 21;
        long j39 = j11 + j38;
        long j40 = j10 - (j38 << 21);
        long j41 = (j12 + 1048576) >> 21;
        long j42 = j13 + j41;
        long j43 = j12 - (j41 << 21);
        long j44 = (j14 + 1048576) >> 21;
        long j45 = j15 + j44;
        long j46 = j14 - (j44 << 21);
        long j47 = (j16 + 1048576) >> 21;
        long j48 = j17 + j47;
        long j49 = j16 - (j47 << 21);
        long j50 = (j18 + 1048576) >> 21;
        long j51 = jLoad417 + j50;
        long j52 = j18 - (j50 << 21);
        long j53 = (jLoad318 + 1048576) >> 21;
        long j54 = jLoad418 + j53;
        long j55 = jLoad318 - (j53 << 21);
        long j56 = (j20 + 1048576) >> 21;
        long j57 = j22 + j56;
        long j58 = j20 - (j56 << 21);
        long j59 = (j24 + 1048576) >> 21;
        long j60 = j26 + j59;
        long j61 = j24 - (j59 << 21);
        long j62 = (j28 + 1048576) >> 21;
        long j63 = j30 + j62;
        long j64 = j28 - (j62 << 21);
        long j65 = (j32 + 1048576) >> 21;
        long j66 = j34 + j65;
        long j67 = j32 - (j65 << 21);
        long j68 = (j35 + 1048576) >> 21;
        long j69 = j36 + (jLoad36 * jLoad412) + j68;
        long j70 = j35 - (j68 << 21);
        long j71 = (j37 + 1048576) >> 21;
        long j72 = (j39 + 1048576) >> 21;
        long j73 = j43 + j72;
        long j74 = j39 - (j72 << 21);
        long j75 = (j42 + 1048576) >> 21;
        long j76 = j46 + j75;
        long j77 = j42 - (j75 << 21);
        long j78 = (j45 + 1048576) >> 21;
        long j79 = j49 + j78;
        long j80 = j45 - (j78 << 21);
        long j81 = (j48 + 1048576) >> 21;
        long j82 = j52 + j81;
        long j83 = j48 - (j81 << 21);
        long j84 = (j51 + 1048576) >> 21;
        long j85 = j55 + j84;
        long j86 = j51 - (j84 << 21);
        long j87 = (j54 + 1048576) >> 21;
        long j88 = j58 + j87;
        long j89 = j54 - (j87 << 21);
        long j90 = (j57 + 1048576) >> 21;
        long j91 = j61 + j90;
        long j92 = j57 - (j90 << 21);
        long j93 = (j60 + 1048576) >> 21;
        long j94 = j64 + j93;
        long j95 = j60 - (j93 << 21);
        long j96 = (j63 + 1048576) >> 21;
        long j97 = j67 + j96;
        long j98 = j63 - (j96 << 21);
        long j99 = (j66 + 1048576) >> 21;
        long j100 = j70 + j99;
        long j101 = j66 - (j99 << 21);
        long j102 = (j69 + 1048576) >> 21;
        long j103 = (j37 - (j71 << 21)) + j102;
        long j104 = j69 - (j102 << 21);
        long j105 = (j71 * 666643) + j89;
        long j106 = (j71 * 470296) + j88;
        long j107 = (j71 * 654183) + j92;
        long j108 = j91 - (j71 * 997805);
        long j109 = (j71 * 136657) + j95;
        long j110 = j94 - (j71 * 683901);
        long j111 = (j103 * 470296) + j105;
        long j112 = (j103 * 654183) + j106;
        long j113 = j109 - (j103 * 683901);
        long j114 = (j104 * 470296) + (j103 * 666643) + j85;
        long j115 = (j104 * 654183) + j111;
        long j116 = (j104 * 136657) + (j107 - (j103 * 997805));
        long j117 = ((j103 * 136657) + j108) - (j104 * 683901);
        long j118 = (j100 * 654183) + j114;
        long j119 = (j101 * 654183) + (j100 * 470296) + (j104 * 666643) + j86;
        long j120 = (j101 * 136657) + (j115 - (j100 * 997805));
        long j121 = ((j100 * 136657) + (j112 - (j104 * 997805))) - (j101 * 683901);
        long j122 = (j97 * 666643) + j79;
        long j123 = (j97 * 654183) + (j101 * 470296) + (j100 * 666643) + j82;
        long j124 = (j97 * 136657) + (j118 - (j101 * 997805));
        long j125 = (j122 + 1048576) >> 21;
        long j126 = (j97 * 470296) + (j101 * 666643) + j83 + j125;
        long j127 = j122 - (j125 << 21);
        long j128 = (j123 + 1048576) >> 21;
        long j129 = (j119 - (j97 * 997805)) + j128;
        long j130 = j123 - (j128 << 21);
        long j131 = (j124 + 1048576) >> 21;
        long j132 = (j120 - (j97 * 683901)) + j131;
        long j133 = j124 - (j131 << 21);
        long j134 = (j121 + 1048576) >> 21;
        long j135 = (j116 - (j100 * 683901)) + j134;
        long j136 = j121 - (j134 << 21);
        long j137 = (j117 + 1048576) >> 21;
        long j138 = j113 + j137;
        long j139 = j117 - (j137 << 21);
        long j140 = (j110 + 1048576) >> 21;
        long j141 = j98 + j140;
        long j142 = j110 - (j140 << 21);
        long j143 = (j126 + 1048576) >> 21;
        long j144 = j130 + j143;
        long j145 = j126 - (j143 << 21);
        long j146 = (j129 + 1048576) >> 21;
        long j147 = j133 + j146;
        long j148 = j129 - (j146 << 21);
        long j149 = (j132 + 1048576) >> 21;
        long j150 = j136 + j149;
        long j151 = j132 - (j149 << 21);
        long j152 = (j135 + 1048576) >> 21;
        long j153 = j139 + j152;
        long j154 = j135 - (j152 << 21);
        long j155 = (j138 + 1048576) >> 21;
        long j156 = j142 + j155;
        long j157 = j138 - (j155 << 21);
        long j158 = (j141 * 470296) + j127;
        long j159 = (j141 * 654183) + j145;
        long j160 = j144 - (j141 * 997805);
        long j161 = (j141 * 136657) + j148;
        long j162 = j147 - (j141 * 683901);
        long j163 = (j156 * 470296) + (j141 * 666643) + j80;
        long j164 = (j156 * 654183) + j158;
        long j165 = j159 - (j156 * 997805);
        long j166 = (j156 * 136657) + j160;
        long j167 = j161 - (j156 * 683901);
        long j168 = (j157 * 470296) + (j156 * 666643) + j76;
        long j169 = (j157 * 654183) + j163;
        long j170 = j164 - (j157 * 997805);
        long j171 = (j157 * 136657) + j165;
        long j172 = j166 - (j157 * 683901);
        long j173 = (j153 * 654183) + j168;
        long j174 = (j153 * 136657) + j170;
        long j175 = j171 - (j153 * 683901);
        long j176 = (j154 * 470296) + (j153 * 666643) + j73;
        long j177 = (j154 * 654183) + (j153 * 470296) + (j157 * 666643) + j77;
        long j178 = j173 - (j154 * 997805);
        long j179 = (j154 * 136657) + (j169 - (j153 * 997805));
        long j180 = j174 - (j154 * 683901);
        long j181 = (j150 * 666643) + j40;
        long j182 = (j150 * 654183) + j176;
        long j183 = (j150 * 136657) + j178;
        long j184 = (j181 + 1048576) >> 21;
        long j185 = (j150 * 470296) + (j154 * 666643) + j74 + j184;
        long j186 = j181 - (j184 << 21);
        long j187 = (j182 + 1048576) >> 21;
        long j188 = (j177 - (j150 * 997805)) + j187;
        long j189 = j182 - (j187 << 21);
        long j190 = (j183 + 1048576) >> 21;
        long j191 = (j179 - (j150 * 683901)) + j190;
        long j192 = j183 - (j190 << 21);
        long j193 = (j180 + 1048576) >> 21;
        long j194 = j175 + j193;
        long j195 = j180 - (j193 << 21);
        long j196 = (j172 + 1048576) >> 21;
        long j197 = j167 + j196;
        long j198 = j172 - (j196 << 21);
        long j199 = (j162 + 1048576) >> 21;
        long j200 = j151 + j199;
        long j201 = j162 - (j199 << 21);
        long j202 = (j185 + 1048576) >> 21;
        long j203 = j189 + j202;
        long j204 = j185 - (j202 << 21);
        long j205 = (j188 + 1048576) >> 21;
        long j206 = j192 + j205;
        long j207 = j188 - (j205 << 21);
        long j208 = (j191 + 1048576) >> 21;
        long j209 = j195 + j208;
        long j210 = j191 - (j208 << 21);
        long j211 = (j194 + 1048576) >> 21;
        long j212 = j198 + j211;
        long j213 = j194 - (j211 << 21);
        long j214 = (j197 + 1048576) >> 21;
        long j215 = j201 + j214;
        long j216 = j197 - (j214 << 21);
        long j217 = (j200 + 1048576) >> 21;
        long j218 = j200 - (j217 << 21);
        long j219 = (j217 * 666643) + j186;
        long j220 = (j217 * 470296) + j204;
        long j221 = (j217 * 654183) + j203;
        long j222 = j207 - (j217 * 997805);
        long j223 = (j217 * 136657) + j206;
        long j224 = j210 - (j217 * 683901);
        long j225 = j219 >> 21;
        long j226 = j220 + j225;
        long j227 = j219 - (j225 << 21);
        long j228 = j226 >> 21;
        long j229 = j221 + j228;
        long j230 = j226 - (j228 << 21);
        long j231 = j229 >> 21;
        long j232 = j222 + j231;
        long j233 = j229 - (j231 << 21);
        long j234 = j232 >> 21;
        long j235 = j223 + j234;
        long j236 = j232 - (j234 << 21);
        long j237 = j235 >> 21;
        long j238 = j224 + j237;
        long j239 = j235 - (j237 << 21);
        long j240 = j238 >> 21;
        long j241 = j209 + j240;
        long j242 = j238 - (j240 << 21);
        long j243 = j241 >> 21;
        long j244 = j213 + j243;
        long j245 = j241 - (j243 << 21);
        long j246 = j244 >> 21;
        long j247 = j212 + j246;
        long j248 = j244 - (j246 << 21);
        long j249 = j247 >> 21;
        long j250 = j216 + j249;
        long j251 = j247 - (j249 << 21);
        long j252 = j250 >> 21;
        long j253 = j215 + j252;
        long j254 = j250 - (j252 << 21);
        long j255 = j253 >> 21;
        long j256 = j218 + j255;
        long j257 = j253 - (j255 << 21);
        long j258 = j256 >> 21;
        long j259 = j256 - (j258 << 21);
        long j260 = (666643 * j258) + j227;
        long j261 = (470296 * j258) + j230;
        long j262 = (654183 * j258) + j233;
        long j263 = j236 - (997805 * j258);
        long j264 = (136657 * j258) + j239;
        long j265 = j242 - (j258 * 683901);
        long j266 = j260 >> 21;
        long j267 = j261 + j266;
        long j268 = j260 - (j266 << 21);
        long j269 = j267 >> 21;
        long j270 = j262 + j269;
        long j271 = j267 - (j269 << 21);
        long j272 = j270 >> 21;
        long j273 = j263 + j272;
        long j274 = j270 - (j272 << 21);
        long j275 = j273 >> 21;
        long j276 = j264 + j275;
        long j277 = j273 - (j275 << 21);
        long j278 = j276 >> 21;
        long j279 = j265 + j278;
        long j280 = j276 - (j278 << 21);
        long j281 = j279 >> 21;
        long j282 = j245 + j281;
        long j283 = j279 - (j281 << 21);
        long j284 = j282 >> 21;
        long j285 = j248 + j284;
        long j286 = j282 - (j284 << 21);
        long j287 = j285 >> 21;
        long j288 = j251 + j287;
        long j289 = j285 - (j287 << 21);
        long j290 = j288 >> 21;
        long j291 = j254 + j290;
        long j292 = j291 >> 21;
        long j293 = j257 + j292;
        long j294 = j291 - (j292 << 21);
        long j295 = j293 >> 21;
        long j296 = j259 + j295;
        long j297 = j293 - (j295 << 21);
        bArr[0] = (byte) j268;
        bArr[1] = (byte) (j268 >> 8);
        bArr[2] = (byte) ((j268 >> 16) | (j271 << 5));
        bArr[3] = (byte) (j271 >> 3);
        bArr[4] = (byte) (j271 >> 11);
        bArr[5] = (byte) ((j271 >> 19) | (j274 << 2));
        bArr[6] = (byte) (j274 >> 6);
        bArr[7] = (byte) ((j274 >> 14) | (j277 << 7));
        bArr[8] = (byte) (j277 >> 1);
        bArr[9] = (byte) (j277 >> 9);
        bArr[10] = (byte) ((j277 >> 17) | (j280 << 4));
        bArr[11] = (byte) (j280 >> 4);
        bArr[12] = (byte) (j280 >> 12);
        bArr[13] = (byte) ((j280 >> 20) | (j283 << 1));
        bArr[14] = (byte) (j283 >> 7);
        bArr[15] = (byte) ((j283 >> 15) | (j286 << 6));
        bArr[16] = (byte) (j286 >> 2);
        bArr[17] = (byte) (j286 >> 10);
        bArr[18] = (byte) ((j286 >> 18) | (j289 << 3));
        bArr[19] = (byte) (j289 >> 5);
        bArr[20] = (byte) (j289 >> 13);
        bArr[21] = (byte) (j288 - (j290 << 21));
        bArr[22] = (byte) (r0 >> 8);
        bArr[23] = (byte) ((r0 >> 16) | (j294 << 5));
        bArr[24] = (byte) (j294 >> 3);
        bArr[25] = (byte) (j294 >> 11);
        bArr[26] = (byte) ((j294 >> 19) | (j297 << 2));
        bArr[27] = (byte) (j297 >> 6);
        bArr[28] = (byte) ((j297 >> 14) | (j296 << 7));
        bArr[29] = (byte) (j296 >> 1);
        bArr[30] = (byte) (j296 >> 9);
        bArr[31] = (byte) (j296 >> 17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void neg(long[] jArr, long[] jArr2) {
        for (int i = 0; i < jArr2.length; i++) {
            jArr[i] = -jArr2[i];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void pow2252m3(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[10];
        long[] jArr4 = new long[10];
        long[] jArr5 = new long[10];
        Field25519.square(jArr3, jArr2);
        Field25519.square(jArr4, jArr3);
        Field25519.square(jArr4, jArr4);
        Field25519.mult(jArr4, jArr2, jArr4);
        Field25519.mult(jArr3, jArr3, jArr4);
        Field25519.square(jArr3, jArr3);
        Field25519.mult(jArr3, jArr4, jArr3);
        Field25519.square(jArr4, jArr3);
        for (int i = 1; i < 5; i++) {
            Field25519.square(jArr4, jArr4);
        }
        Field25519.mult(jArr3, jArr4, jArr3);
        Field25519.square(jArr4, jArr3);
        for (int i3 = 1; i3 < 10; i3++) {
            Field25519.square(jArr4, jArr4);
        }
        Field25519.mult(jArr4, jArr4, jArr3);
        Field25519.square(jArr5, jArr4);
        for (int i10 = 1; i10 < 20; i10++) {
            Field25519.square(jArr5, jArr5);
        }
        Field25519.mult(jArr4, jArr5, jArr4);
        Field25519.square(jArr4, jArr4);
        for (int i11 = 1; i11 < 10; i11++) {
            Field25519.square(jArr4, jArr4);
        }
        Field25519.mult(jArr3, jArr4, jArr3);
        Field25519.square(jArr4, jArr3);
        for (int i12 = 1; i12 < 50; i12++) {
            Field25519.square(jArr4, jArr4);
        }
        Field25519.mult(jArr4, jArr4, jArr3);
        Field25519.square(jArr5, jArr4);
        for (int i13 = 1; i13 < 100; i13++) {
            Field25519.square(jArr5, jArr5);
        }
        Field25519.mult(jArr4, jArr5, jArr4);
        Field25519.square(jArr4, jArr4);
        for (int i14 = 1; i14 < 50; i14++) {
            Field25519.square(jArr4, jArr4);
        }
        Field25519.mult(jArr3, jArr4, jArr3);
        Field25519.square(jArr3, jArr3);
        Field25519.square(jArr3, jArr3);
        Field25519.mult(jArr, jArr3, jArr2);
    }

    private static void reduce(byte[] bArr) {
        long jLoad3 = load3(bArr, 0) & 2097151;
        long jLoad4 = (load4(bArr, 2) >> 5) & 2097151;
        long jLoad32 = (load3(bArr, 5) >> 2) & 2097151;
        long jLoad42 = (load4(bArr, 7) >> 7) & 2097151;
        long jLoad43 = (load4(bArr, 10) >> 4) & 2097151;
        long jLoad33 = (load3(bArr, 13) >> 1) & 2097151;
        long jLoad44 = (load4(bArr, 15) >> 6) & 2097151;
        long jLoad34 = (load3(bArr, 18) >> 3) & 2097151;
        long jLoad35 = load3(bArr, 21) & 2097151;
        long jLoad45 = (load4(bArr, 23) >> 5) & 2097151;
        long jLoad36 = (load3(bArr, 26) >> 2) & 2097151;
        long jLoad46 = (load4(bArr, 28) >> 7) & 2097151;
        long jLoad47 = (load4(bArr, 31) >> 4) & 2097151;
        long jLoad37 = (load3(bArr, 34) >> 1) & 2097151;
        long jLoad48 = (load4(bArr, 36) >> 6) & 2097151;
        long jLoad38 = (load3(bArr, 39) >> 3) & 2097151;
        long jLoad39 = load3(bArr, 42) & 2097151;
        long jLoad49 = (load4(bArr, 44) >> 5) & 2097151;
        long jLoad310 = (load3(bArr, 47) >> 2) & 2097151;
        long jLoad410 = (load4(bArr, 49) >> 7) & 2097151;
        long jLoad411 = (load4(bArr, 52) >> 4) & 2097151;
        long jLoad311 = (load3(bArr, 55) >> 1) & 2097151;
        long jLoad412 = (load4(bArr, 57) >> 6) & 2097151;
        long jLoad413 = load4(bArr, 60) >> 3;
        long j10 = (jLoad413 * 666643) + jLoad46;
        long j11 = (jLoad413 * 470296) + jLoad47;
        long j12 = (jLoad413 * 654183) + jLoad37;
        long j13 = jLoad48 - (jLoad413 * 997805);
        long j14 = (jLoad413 * 136657) + jLoad38;
        long j15 = jLoad39 - (jLoad413 * 683901);
        long j16 = (jLoad412 * 666643) + jLoad36;
        long j17 = (jLoad412 * 470296) + j10;
        long j18 = (jLoad412 * 654183) + j11;
        long j19 = j12 - (jLoad412 * 997805);
        long j20 = (jLoad412 * 136657) + j13;
        long j21 = j14 - (jLoad412 * 683901);
        long j22 = (jLoad311 * 666643) + jLoad45;
        long j23 = (jLoad311 * 470296) + j16;
        long j24 = (jLoad311 * 654183) + j17;
        long j25 = j18 - (jLoad311 * 997805);
        long j26 = (jLoad311 * 136657) + j19;
        long j27 = j20 - (jLoad311 * 683901);
        long j28 = (jLoad411 * 666643) + jLoad35;
        long j29 = (jLoad411 * 470296) + j22;
        long j30 = (jLoad411 * 654183) + j23;
        long j31 = j24 - (jLoad411 * 997805);
        long j32 = (jLoad411 * 136657) + j25;
        long j33 = j26 - (jLoad411 * 683901);
        long j34 = (jLoad410 * 666643) + jLoad34;
        long j35 = (jLoad410 * 470296) + j28;
        long j36 = (jLoad410 * 654183) + j29;
        long j37 = j30 - (jLoad410 * 997805);
        long j38 = (jLoad410 * 136657) + j31;
        long j39 = j32 - (jLoad410 * 683901);
        long j40 = (jLoad310 * 666643) + jLoad44;
        long j41 = (jLoad310 * 470296) + j34;
        long j42 = (jLoad310 * 654183) + j35;
        long j43 = j36 - (jLoad310 * 997805);
        long j44 = (jLoad310 * 136657) + j37;
        long j45 = j38 - (jLoad310 * 683901);
        long j46 = (j40 + 1048576) >> 21;
        long j47 = j41 + j46;
        long j48 = j40 - (j46 << 21);
        long j49 = (j42 + 1048576) >> 21;
        long j50 = j43 + j49;
        long j51 = j42 - (j49 << 21);
        long j52 = (j44 + 1048576) >> 21;
        long j53 = j45 + j52;
        long j54 = j44 - (j52 << 21);
        long j55 = (j39 + 1048576) >> 21;
        long j56 = j33 + j55;
        long j57 = j39 - (j55 << 21);
        long j58 = (j27 + 1048576) >> 21;
        long j59 = j21 + j58;
        long j60 = j27 - (j58 << 21);
        long j61 = (j15 + 1048576) >> 21;
        long j62 = jLoad49 + j61;
        long j63 = j15 - (j61 << 21);
        long j64 = (j47 + 1048576) >> 21;
        long j65 = j51 + j64;
        long j66 = j47 - (j64 << 21);
        long j67 = (j50 + 1048576) >> 21;
        long j68 = j54 + j67;
        long j69 = j50 - (j67 << 21);
        long j70 = (j53 + 1048576) >> 21;
        long j71 = j57 + j70;
        long j72 = j53 - (j70 << 21);
        long j73 = (j56 + 1048576) >> 21;
        long j74 = j60 + j73;
        long j75 = j56 - (j73 << 21);
        long j76 = (j59 + 1048576) >> 21;
        long j77 = j63 + j76;
        long j78 = j59 - (j76 << 21);
        long j79 = (j62 * 666643) + jLoad33;
        long j80 = (j62 * 470296) + j48;
        long j81 = (j62 * 654183) + j66;
        long j82 = j65 - (j62 * 997805);
        long j83 = (j62 * 136657) + j69;
        long j84 = j68 - (j62 * 683901);
        long j85 = (j77 * 666643) + jLoad43;
        long j86 = (j77 * 470296) + j79;
        long j87 = (j77 * 654183) + j80;
        long j88 = j81 - (j77 * 997805);
        long j89 = (j77 * 136657) + j82;
        long j90 = j83 - (j77 * 683901);
        long j91 = (j78 * 666643) + jLoad42;
        long j92 = (j78 * 470296) + j85;
        long j93 = (j78 * 654183) + j86;
        long j94 = (j78 * 136657) + j88;
        long j95 = j89 - (j78 * 683901);
        long j96 = (j74 * 666643) + jLoad32;
        long j97 = (j74 * 470296) + j91;
        long j98 = (j74 * 654183) + j92;
        long j99 = (j74 * 136657) + (j87 - (j78 * 997805));
        long j100 = (j75 * 666643) + jLoad4;
        long j101 = (j75 * 470296) + j96;
        long j102 = (j75 * 654183) + j97;
        long j103 = j98 - (j75 * 997805);
        long j104 = (j75 * 136657) + (j93 - (j74 * 997805));
        long j105 = j99 - (j75 * 683901);
        long j106 = (j71 * 666643) + jLoad3;
        long j107 = (j71 * 470296) + j100;
        long j108 = (j71 * 654183) + j101;
        long j109 = j102 - (j71 * 997805);
        long j110 = (j71 * 136657) + j103;
        long j111 = j104 - (j71 * 683901);
        long j112 = (j106 + 1048576) >> 21;
        long j113 = j107 + j112;
        long j114 = j106 - (j112 << 21);
        long j115 = (j108 + 1048576) >> 21;
        long j116 = j109 + j115;
        long j117 = j108 - (j115 << 21);
        long j118 = (j110 + 1048576) >> 21;
        long j119 = j111 + j118;
        long j120 = j110 - (j118 << 21);
        long j121 = (j105 + 1048576) >> 21;
        long j122 = (j94 - (j74 * 683901)) + j121;
        long j123 = j105 - (j121 << 21);
        long j124 = (j95 + 1048576) >> 21;
        long j125 = j90 + j124;
        long j126 = j95 - (j124 << 21);
        long j127 = (j84 + 1048576) >> 21;
        long j128 = j72 + j127;
        long j129 = j84 - (j127 << 21);
        long j130 = (j113 + 1048576) >> 21;
        long j131 = j117 + j130;
        long j132 = j113 - (j130 << 21);
        long j133 = (j116 + 1048576) >> 21;
        long j134 = j120 + j133;
        long j135 = j116 - (j133 << 21);
        long j136 = (j119 + 1048576) >> 21;
        long j137 = j123 + j136;
        long j138 = j119 - (j136 << 21);
        long j139 = (j122 + 1048576) >> 21;
        long j140 = j126 + j139;
        long j141 = j122 - (j139 << 21);
        long j142 = (j125 + 1048576) >> 21;
        long j143 = j129 + j142;
        long j144 = j125 - (j142 << 21);
        long j145 = (j128 + 1048576) >> 21;
        long j146 = (j145 * 666643) + j114;
        long j147 = (j145 * 136657) + j134;
        long j148 = j146 >> 21;
        long j149 = (j145 * 470296) + j132 + j148;
        long j150 = j146 - (j148 << 21);
        long j151 = j149 >> 21;
        long j152 = (j145 * 654183) + j131 + j151;
        long j153 = j149 - (j151 << 21);
        long j154 = j152 >> 21;
        long j155 = (j135 - (j145 * 997805)) + j154;
        long j156 = j152 - (j154 << 21);
        long j157 = j155 >> 21;
        long j158 = j147 + j157;
        long j159 = j155 - (j157 << 21);
        long j160 = j158 >> 21;
        long j161 = (j138 - (j145 * 683901)) + j160;
        long j162 = j158 - (j160 << 21);
        long j163 = j161 >> 21;
        long j164 = j137 + j163;
        long j165 = j161 - (j163 << 21);
        long j166 = j164 >> 21;
        long j167 = j141 + j166;
        long j168 = j164 - (j166 << 21);
        long j169 = j167 >> 21;
        long j170 = j140 + j169;
        long j171 = j167 - (j169 << 21);
        long j172 = j170 >> 21;
        long j173 = j144 + j172;
        long j174 = j170 - (j172 << 21);
        long j175 = j173 >> 21;
        long j176 = j143 + j175;
        long j177 = j173 - (j175 << 21);
        long j178 = j176 >> 21;
        long j179 = (j128 - (j145 << 21)) + j178;
        long j180 = j176 - (j178 << 21);
        long j181 = j179 >> 21;
        long j182 = j179 - (j181 << 21);
        long j183 = (666643 * j181) + j150;
        long j184 = (654183 * j181) + j156;
        long j185 = j159 - (997805 * j181);
        long j186 = (136657 * j181) + j162;
        long j187 = j165 - (j181 * 683901);
        long j188 = j183 >> 21;
        long j189 = (470296 * j181) + j153 + j188;
        long j190 = j189 >> 21;
        long j191 = j184 + j190;
        long j192 = j189 - (j190 << 21);
        long j193 = j191 >> 21;
        long j194 = j185 + j193;
        long j195 = j191 - (j193 << 21);
        long j196 = j194 >> 21;
        long j197 = j186 + j196;
        long j198 = j194 - (j196 << 21);
        long j199 = j197 >> 21;
        long j200 = j187 + j199;
        long j201 = j197 - (j199 << 21);
        long j202 = j200 >> 21;
        long j203 = j168 + j202;
        long j204 = j200 - (j202 << 21);
        long j205 = j203 >> 21;
        long j206 = j171 + j205;
        long j207 = j203 - (j205 << 21);
        long j208 = j206 >> 21;
        long j209 = j174 + j208;
        long j210 = j206 - (j208 << 21);
        long j211 = j209 >> 21;
        long j212 = j177 + j211;
        long j213 = j212 >> 21;
        long j214 = j180 + j213;
        long j215 = j212 - (j213 << 21);
        long j216 = j214 >> 21;
        long j217 = j182 + j216;
        long j218 = j214 - (j216 << 21);
        bArr[0] = (byte) (j183 - (j188 << 21));
        bArr[1] = (byte) (r1 >> 8);
        bArr[2] = (byte) ((r1 >> 16) | (j192 << 5));
        bArr[3] = (byte) (j192 >> 3);
        bArr[4] = (byte) (j192 >> 11);
        bArr[5] = (byte) ((j192 >> 19) | (j195 << 2));
        bArr[6] = (byte) (j195 >> 6);
        bArr[7] = (byte) ((j195 >> 14) | (j198 << 7));
        bArr[8] = (byte) (j198 >> 1);
        bArr[9] = (byte) (j198 >> 9);
        bArr[10] = (byte) ((j198 >> 17) | (j201 << 4));
        bArr[11] = (byte) (j201 >> 4);
        bArr[12] = (byte) (j201 >> 12);
        bArr[13] = (byte) ((j201 >> 20) | (j204 << 1));
        bArr[14] = (byte) (j204 >> 7);
        bArr[15] = (byte) ((j204 >> 15) | (j207 << 6));
        bArr[16] = (byte) (j207 >> 2);
        bArr[17] = (byte) (j207 >> 10);
        bArr[18] = (byte) ((j207 >> 18) | (j210 << 3));
        bArr[19] = (byte) (j210 >> 5);
        bArr[20] = (byte) (j210 >> 13);
        bArr[21] = (byte) (j209 - (j211 << 21));
        bArr[22] = (byte) (r6 >> 8);
        bArr[23] = (byte) ((r6 >> 16) | (j215 << 5));
        bArr[24] = (byte) (j215 >> 3);
        bArr[25] = (byte) (j215 >> 11);
        bArr[26] = (byte) ((j215 >> 19) | (j218 << 2));
        bArr[27] = (byte) (j218 >> 6);
        bArr[28] = (byte) ((j218 >> 14) | (j217 << 7));
        bArr[29] = (byte) (j217 >> 1);
        bArr[30] = (byte) (j217 >> 9);
        bArr[31] = (byte) (j217 >> 17);
    }

    private static XYZ scalarMultWithBase(byte[] bArr) {
        int i;
        byte[] bArr2 = new byte[64];
        int i3 = 0;
        while (true) {
            if (i3 >= 32) {
                break;
            }
            int i10 = i3 * 2;
            bArr2[i10] = (byte) (bArr[i3] & 15);
            bArr2[i10 + 1] = (byte) (((bArr[i3] & 255) >> 4) & 15);
            i3++;
        }
        int i11 = 0;
        int i12 = 0;
        while (i11 < 63) {
            byte b10 = (byte) (bArr2[i11] + i12);
            bArr2[i11] = b10;
            int i13 = (b10 + 8) >> 4;
            bArr2[i11] = (byte) (b10 - (i13 << 4));
            i11++;
            i12 = i13;
        }
        bArr2[63] = (byte) (bArr2[63] + i12);
        PartialXYZT partialXYZT = new PartialXYZT(NEUTRAL);
        XYZT xyzt = new XYZT();
        for (i = 1; i < 64; i += 2) {
            CachedXYT cachedXYT = new CachedXYT(CACHED_NEUTRAL);
            select(cachedXYT, i / 2, bArr2[i]);
            add(partialXYZT, XYZT.fromPartialXYZT(xyzt, partialXYZT), cachedXYT);
        }
        XYZ xyz = new XYZ();
        doubleXYZ(partialXYZT, XYZ.fromPartialXYZT(xyz, partialXYZT));
        doubleXYZ(partialXYZT, XYZ.fromPartialXYZT(xyz, partialXYZT));
        doubleXYZ(partialXYZT, XYZ.fromPartialXYZT(xyz, partialXYZT));
        doubleXYZ(partialXYZT, XYZ.fromPartialXYZT(xyz, partialXYZT));
        for (int i14 = 0; i14 < 64; i14 += 2) {
            CachedXYT cachedXYT2 = new CachedXYT(CACHED_NEUTRAL);
            select(cachedXYT2, i14 / 2, bArr2[i14]);
            add(partialXYZT, XYZT.fromPartialXYZT(xyzt, partialXYZT), cachedXYT2);
        }
        XYZ xyz2 = new XYZ(partialXYZT);
        if (xyz2.isOnCurve()) {
            return xyz2;
        }
        f.e("arithmetic error in scalar multiplication");
        return null;
    }

    public static byte[] scalarMultWithBaseToBytes(byte[] bArr) {
        return scalarMultWithBase(bArr).toBytes();
    }

    private static void select(CachedXYT cachedXYT, int i, byte b10) {
        int i3 = (b10 & 255) >> 7;
        int i10 = b10 - (((-i3) & b10) << 1);
        CachedXYT[][] cachedXYTArr = Ed25519Constants.B_TABLE;
        cachedXYT.copyConditional(cachedXYTArr[i][0], eq(i10, 1));
        cachedXYT.copyConditional(cachedXYTArr[i][1], eq(i10, 2));
        cachedXYT.copyConditional(cachedXYTArr[i][2], eq(i10, 3));
        cachedXYT.copyConditional(cachedXYTArr[i][3], eq(i10, 4));
        cachedXYT.copyConditional(cachedXYTArr[i][4], eq(i10, 5));
        cachedXYT.copyConditional(cachedXYTArr[i][5], eq(i10, 6));
        cachedXYT.copyConditional(cachedXYTArr[i][6], eq(i10, 7));
        cachedXYT.copyConditional(cachedXYTArr[i][7], eq(i10, 8));
        long[] jArrCopyOf = Arrays.copyOf(cachedXYT.yMinusX, 10);
        long[] jArrCopyOf2 = Arrays.copyOf(cachedXYT.yPlusX, 10);
        long[] jArrCopyOf3 = Arrays.copyOf(cachedXYT.t2d, 10);
        neg(jArrCopyOf3, jArrCopyOf3);
        cachedXYT.copyConditional(new CachedXYT(jArrCopyOf, jArrCopyOf2, jArrCopyOf3), i3);
    }

    public static byte[] sign(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, bArr.length);
        MessageDigest engineFactory = EngineFactory.MESSAGE_DIGEST.getInstance("SHA-512");
        engineFactory.update(bArr3, 32, 32);
        engineFactory.update(bArrCopyOfRange);
        byte[] bArrDigest = engineFactory.digest();
        reduce(bArrDigest);
        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(scalarMultWithBase(bArrDigest).toBytes(), 0, 32);
        engineFactory.reset();
        engineFactory.update(bArrCopyOfRange2);
        engineFactory.update(bArr2);
        engineFactory.update(bArrCopyOfRange);
        byte[] bArrDigest2 = engineFactory.digest();
        reduce(bArrDigest2);
        byte[] bArr4 = new byte[32];
        mulAdd(bArr4, bArrDigest2, bArr3, bArrDigest);
        return Bytes.concat(bArrCopyOfRange2, bArr4);
    }

    private static byte[] slide(byte[] bArr) {
        int i;
        byte[] bArr2 = new byte[ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH];
        for (int i3 = 0; i3 < 256; i3++) {
            bArr2[i3] = (byte) (1 & ((bArr[i3 >> 3] & 255) >> (i3 & 7)));
        }
        for (int i10 = 0; i10 < 256; i10++) {
            if (bArr2[i10] != 0) {
                for (int i11 = 1; i11 <= 6 && (i = i10 + i11) < 256; i11++) {
                    byte b10 = bArr2[i];
                    if (b10 != 0) {
                        byte b11 = bArr2[i10];
                        if ((b10 << i11) + b11 <= 15) {
                            bArr2[i10] = (byte) (b11 + (b10 << i11));
                            bArr2[i] = 0;
                        } else if (b11 - (b10 << i11) >= -15) {
                            bArr2[i10] = (byte) (b11 - (b10 << i11));
                            while (true) {
                                if (i >= 256) {
                                    break;
                                }
                                if (bArr2[i] == 0) {
                                    bArr2[i] = 1;
                                    break;
                                }
                                bArr2[i] = 0;
                                i++;
                            }
                        }
                    }
                }
            }
        }
        return bArr2;
    }

    private static void sub(PartialXYZT partialXYZT, XYZT xyzt, CachedXYT cachedXYT) {
        long[] jArr = new long[10];
        long[] jArr2 = partialXYZT.xyz.f2480x;
        XYZ xyz = xyzt.xyz;
        Field25519.sum(jArr2, xyz.f2481y, xyz.f2480x);
        long[] jArr3 = partialXYZT.xyz.f2481y;
        XYZ xyz2 = xyzt.xyz;
        Field25519.sub(jArr3, xyz2.f2481y, xyz2.f2480x);
        long[] jArr4 = partialXYZT.xyz.f2481y;
        Field25519.mult(jArr4, jArr4, cachedXYT.yPlusX);
        XYZ xyz3 = partialXYZT.xyz;
        Field25519.mult(xyz3.f2482z, xyz3.f2480x, cachedXYT.yMinusX);
        Field25519.mult(partialXYZT.f2479t, xyzt.f2483t, cachedXYT.t2d);
        cachedXYT.multByZ(partialXYZT.xyz.f2480x, xyzt.xyz.f2482z);
        long[] jArr5 = partialXYZT.xyz.f2480x;
        Field25519.sum(jArr, jArr5, jArr5);
        XYZ xyz4 = partialXYZT.xyz;
        Field25519.sub(xyz4.f2480x, xyz4.f2482z, xyz4.f2481y);
        XYZ xyz5 = partialXYZT.xyz;
        long[] jArr6 = xyz5.f2481y;
        Field25519.sum(jArr6, xyz5.f2482z, jArr6);
        Field25519.sub(partialXYZT.xyz.f2482z, jArr, partialXYZT.f2479t);
        long[] jArr7 = partialXYZT.f2479t;
        Field25519.sum(jArr7, jArr, jArr7);
    }

    public static boolean verify(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr2.length != 64) {
            return false;
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr2, 32, 64);
        if (!isSmallerThanGroupOrder(bArrCopyOfRange)) {
            return false;
        }
        MessageDigest engineFactory = EngineFactory.MESSAGE_DIGEST.getInstance("SHA-512");
        engineFactory.update(bArr2, 0, 32);
        engineFactory.update(bArr3);
        engineFactory.update(bArr);
        byte[] bArrDigest = engineFactory.digest();
        reduce(bArrDigest);
        byte[] bytes = doubleScalarMultVarTime(bArrDigest, XYZT.fromBytesNegateVarTime(bArr3), bArrCopyOfRange).toBytes();
        for (int i = 0; i < 32; i++) {
            if (bytes[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class XYZT {

        /* renamed from: t, reason: collision with root package name */
        final long[] f2483t;
        final XYZ xyz;

        public XYZT() {
            this(new XYZ(), new long[10]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static XYZT fromBytesNegateVarTime(byte[] bArr) throws GeneralSecurityException {
            long[] jArr = new long[10];
            long[] jArrExpand = Field25519.expand(bArr);
            long[] jArr2 = new long[10];
            jArr2[0] = 1;
            long[] jArr3 = new long[10];
            long[] jArr4 = new long[10];
            long[] jArr5 = new long[10];
            long[] jArr6 = new long[10];
            long[] jArr7 = new long[10];
            Field25519.square(jArr4, jArrExpand);
            Field25519.mult(jArr5, jArr4, Ed25519Constants.D);
            Field25519.sub(jArr4, jArr4, jArr2);
            Field25519.sum(jArr5, jArr5, jArr2);
            long[] jArr8 = new long[10];
            Field25519.square(jArr8, jArr5);
            Field25519.mult(jArr8, jArr8, jArr5);
            Field25519.square(jArr, jArr8);
            Field25519.mult(jArr, jArr, jArr5);
            Field25519.mult(jArr, jArr, jArr4);
            Ed25519.pow2252m3(jArr, jArr);
            Field25519.mult(jArr, jArr, jArr8);
            Field25519.mult(jArr, jArr, jArr4);
            Field25519.square(jArr6, jArr);
            Field25519.mult(jArr6, jArr6, jArr5);
            Field25519.sub(jArr7, jArr6, jArr4);
            if (Ed25519.isNonZeroVarTime(jArr7)) {
                Field25519.sum(jArr7, jArr6, jArr4);
                if (Ed25519.isNonZeroVarTime(jArr7)) {
                    z.l("Cannot convert given bytes to extended projective coordinates. No square root exists for modulo 2^255-19");
                    return null;
                }
                Field25519.mult(jArr, jArr, Ed25519Constants.SQRTM1);
            }
            if (!Ed25519.isNonZeroVarTime(jArr) && ((bArr[31] & 255) >> 7) != 0) {
                z.l("Cannot convert given bytes to extended projective coordinates. Computed x is zero and encoded x's least significant bit is not zero");
                return null;
            }
            if (Ed25519.getLsb(jArr) == ((bArr[31] & 255) >> 7)) {
                Ed25519.neg(jArr, jArr);
            }
            Field25519.mult(jArr3, jArr, jArrExpand);
            return new XYZT(new XYZ(jArr, jArrExpand, jArr2), jArr3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static XYZT fromPartialXYZT(XYZT xyzt, PartialXYZT partialXYZT) {
            Field25519.mult(xyzt.xyz.f2480x, partialXYZT.xyz.f2480x, partialXYZT.f2479t);
            long[] jArr = xyzt.xyz.f2481y;
            XYZ xyz = partialXYZT.xyz;
            Field25519.mult(jArr, xyz.f2481y, xyz.f2482z);
            Field25519.mult(xyzt.xyz.f2482z, partialXYZT.xyz.f2482z, partialXYZT.f2479t);
            long[] jArr2 = xyzt.f2483t;
            XYZ xyz2 = partialXYZT.xyz;
            Field25519.mult(jArr2, xyz2.f2480x, xyz2.f2481y);
            return xyzt;
        }

        public XYZT(XYZ xyz, long[] jArr) {
            this.xyz = xyz;
            this.f2483t = jArr;
        }

        public XYZT(PartialXYZT partialXYZT) {
            this();
            fromPartialXYZT(this, partialXYZT);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class PartialXYZT {

        /* renamed from: t, reason: collision with root package name */
        final long[] f2479t;
        final XYZ xyz;

        public PartialXYZT(PartialXYZT partialXYZT) {
            this.xyz = new XYZ(partialXYZT.xyz);
            this.f2479t = Arrays.copyOf(partialXYZT.f2479t, 10);
        }

        public PartialXYZT(XYZ xyz, long[] jArr) {
            this.xyz = xyz;
            this.f2479t = jArr;
        }

        public PartialXYZT() {
            this(new XYZ(), new long[10]);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class CachedXYT {
        final long[] t2d;
        final long[] yMinusX;
        final long[] yPlusX;

        public CachedXYT(CachedXYT cachedXYT) {
            this.yPlusX = Arrays.copyOf(cachedXYT.yPlusX, 10);
            this.yMinusX = Arrays.copyOf(cachedXYT.yMinusX, 10);
            this.t2d = Arrays.copyOf(cachedXYT.t2d, 10);
        }

        public void copyConditional(CachedXYT cachedXYT, int i) {
            Curve25519.copyConditional(this.yPlusX, cachedXYT.yPlusX, i);
            Curve25519.copyConditional(this.yMinusX, cachedXYT.yMinusX, i);
            Curve25519.copyConditional(this.t2d, cachedXYT.t2d, i);
        }

        public void multByZ(long[] jArr, long[] jArr2) {
            System.arraycopy(jArr2, 0, jArr, 0, 10);
        }

        public CachedXYT(long[] jArr, long[] jArr2, long[] jArr3) {
            this.yPlusX = jArr;
            this.yMinusX = jArr2;
            this.t2d = jArr3;
        }

        public CachedXYT() {
            this(new long[10], new long[10], new long[10]);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class XYZ {

        /* renamed from: x, reason: collision with root package name */
        final long[] f2480x;

        /* renamed from: y, reason: collision with root package name */
        final long[] f2481y;

        /* renamed from: z, reason: collision with root package name */
        final long[] f2482z;

        public XYZ(XYZ xyz) {
            this.f2480x = Arrays.copyOf(xyz.f2480x, 10);
            this.f2481y = Arrays.copyOf(xyz.f2481y, 10);
            this.f2482z = Arrays.copyOf(xyz.f2482z, 10);
        }

        public static XYZ fromPartialXYZT(XYZ xyz, PartialXYZT partialXYZT) {
            Field25519.mult(xyz.f2480x, partialXYZT.xyz.f2480x, partialXYZT.f2479t);
            long[] jArr = xyz.f2481y;
            XYZ xyz2 = partialXYZT.xyz;
            Field25519.mult(jArr, xyz2.f2481y, xyz2.f2482z);
            Field25519.mult(xyz.f2482z, partialXYZT.xyz.f2482z, partialXYZT.f2479t);
            return xyz;
        }

        public boolean isOnCurve() {
            long[] jArr = new long[10];
            Field25519.square(jArr, this.f2480x);
            long[] jArr2 = new long[10];
            Field25519.square(jArr2, this.f2481y);
            long[] jArr3 = new long[10];
            Field25519.square(jArr3, this.f2482z);
            long[] jArr4 = new long[10];
            Field25519.square(jArr4, jArr3);
            long[] jArr5 = new long[10];
            Field25519.sub(jArr5, jArr2, jArr);
            Field25519.mult(jArr5, jArr5, jArr3);
            long[] jArr6 = new long[10];
            Field25519.mult(jArr6, jArr, jArr2);
            Field25519.mult(jArr6, jArr6, Ed25519Constants.D);
            Field25519.sum(jArr6, jArr4);
            Field25519.reduce(jArr6, jArr6);
            return Bytes.equal(Field25519.contract(jArr5), Field25519.contract(jArr6));
        }

        public byte[] toBytes() {
            long[] jArr = new long[10];
            long[] jArr2 = new long[10];
            long[] jArr3 = new long[10];
            Field25519.inverse(jArr, this.f2482z);
            Field25519.mult(jArr2, this.f2480x, jArr);
            Field25519.mult(jArr3, this.f2481y, jArr);
            byte[] bArrContract = Field25519.contract(jArr3);
            bArrContract[31] = (byte) (bArrContract[31] ^ (Ed25519.getLsb(jArr2) << 7));
            return bArrContract;
        }

        public XYZ(long[] jArr, long[] jArr2, long[] jArr3) {
            this.f2480x = jArr;
            this.f2481y = jArr2;
            this.f2482z = jArr3;
        }

        public XYZ() {
            this(new long[10], new long[10], new long[10]);
        }

        public XYZ(PartialXYZT partialXYZT) {
            this();
            fromPartialXYZT(this, partialXYZT);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class CachedXYZT extends CachedXYT {

        /* renamed from: z, reason: collision with root package name */
        private final long[] f2478z;

        public CachedXYZT(XYZT xyzt) {
            this();
            long[] jArr = this.yPlusX;
            XYZ xyz = xyzt.xyz;
            Field25519.sum(jArr, xyz.f2481y, xyz.f2480x);
            long[] jArr2 = this.yMinusX;
            XYZ xyz2 = xyzt.xyz;
            Field25519.sub(jArr2, xyz2.f2481y, xyz2.f2480x);
            System.arraycopy(xyzt.xyz.f2482z, 0, this.f2478z, 0, 10);
            Field25519.mult(this.t2d, xyzt.f2483t, Ed25519Constants.D2);
        }

        @Override // com.google.crypto.tink.subtle.Ed25519.CachedXYT
        public void multByZ(long[] jArr, long[] jArr2) {
            Field25519.mult(jArr, jArr2, this.f2478z);
        }

        public CachedXYZT() {
            this(new long[10], new long[10], new long[10], new long[10]);
        }

        public CachedXYZT(long[] jArr, long[] jArr2, long[] jArr3, long[] jArr4) {
            super(jArr, jArr2, jArr4);
            this.f2478z = jArr3;
        }
    }
}

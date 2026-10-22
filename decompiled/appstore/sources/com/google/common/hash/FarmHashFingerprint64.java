package com.google.common.hash;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.primitives.UnsignedBytes;
import com.ttnet.org.chromium.net.PrivateKeyType;

/* JADX INFO: loaded from: classes3.dex */
final class FarmHashFingerprint64 extends AbstractNonStreamingHashFunction {
    static final HashFunction FARMHASH_FINGERPRINT_64 = null;
    private static final long K0 = -4348849565147123417L;
    private static final long K1 = -5435081209227447693L;
    private static final long K2 = -7286425919675154353L;

    static {
        FARMHASH_FINGERPRINT_64 = new FarmHashFingerprint64();
    }

    public FarmHashFingerprint64() {
    }

    @VisibleForTesting
    public static long fingerprint(byte[] r10, int r11, int r12) {
        if (r12 > 32) goto L11;
        if (r12 > 16) goto L9;
        return hashLength0to16(r10, r11, r12);
    L9:
        return hashLength17to32(r10, r11, r12);
    L11:
        if (r12 > 64) goto L15;
        return hashLength33To64(r10, r11, r12);
    L15:
        return hashLength65Plus(r10, r11, r12);
    }

    private static long hashLength0to16(byte[] r12, int r13, int r14) {
        if (r14 < 8) goto L7;
        long r10 = ((long) (r14 * 2)) + K2;
        long r11 = LittleEndianByteArray.load64(r12, r13) + K2;
        long r15 = LittleEndianByteArray.load64(r12, (r13 + r14) - 8);
        return hashLength16((Long.rotateRight(r15, 37) * r10) + r11, (Long.rotateRight(r11, 25) + r15) * r10, r10);
    L7:
        if (r14 >= 4) goto L9;
        if (r14 <= 0) goto L13;
        byte r16 = r12[r13];
        byte r17 = r12[(r14 >> 1) + r13];
        int r18 = r12[r13 + (r14 - 1)];
        return shiftMix((((long) ((r16 & UnsignedBytes.MAX_VALUE) + ((r17 & UnsignedBytes.MAX_VALUE) << 8))) * K2) ^ (((long) (r14 + ((r18 & PrivateKeyType.INVALID) << 2))) * K0)) * K2;
    L13:
        return K2;
    L9:
        return hashLength16(((long) r14) + ((((long) LittleEndianByteArray.load32(r12, r13)) & 4294967295L) << 3), ((long) LittleEndianByteArray.load32(r12, (r13 + r14) - 4)) & 4294967295L, ((long) (r14 * 2)) + K2);
    }

    private static long hashLength16(long r10, long r11, long r12) {
        long r13 = (r10 ^ r11) * r12;
        long r14 = ((r13 ^ (r13 >>> 47)) ^ r11) * r12;
        return (r14 ^ (r14 >>> 47)) * r12;
    }

    private static long hashLength17to32(byte[] r17, int r18, int r19) {
        long r10 = ((long) (r19 * 2)) + K2;
        long r11 = LittleEndianByteArray.load64(r17, r18) * K1;
        long r12 = LittleEndianByteArray.load64(r17, r18 + 8);
        int r13 = r18 + r19;
        long r14 = LittleEndianByteArray.load64(r17, r13 - 8) * r10;
        return hashLength16((LittleEndianByteArray.load64(r17, r13 - 16) * K2) + (Long.rotateRight(r11 + r12, 43) + Long.rotateRight(r14, 30)), (r11 + Long.rotateRight(r12 + K2, 18)) + r14, r10);
    }

    private static long hashLength33To64(byte[] r20, int r21, int r22) {
        long r10 = ((long) (r22 * 2)) + K2;
        long r11 = LittleEndianByteArray.load64(r20, r21) * K2;
        long r12 = LittleEndianByteArray.load64(r20, r21 + 8);
        int r13 = r21 + r22;
        long r14 = LittleEndianByteArray.load64(r20, r13 - 8) * r10;
        long r15 = (Long.rotateRight(r11 + r12, 43) + Long.rotateRight(r14, 30)) + (LittleEndianByteArray.load64(r20, r13 - 16) * K2);
        long r16 = hashLength16(r15, r14 + (Long.rotateRight(r12 + K2, 18) + r11), r10);
        long r17 = LittleEndianByteArray.load64(r20, r21 + 16) * r10;
        long r18 = LittleEndianByteArray.load64(r20, r21 + 24);
        long r19 = (r15 + LittleEndianByteArray.load64(r20, r13 - 32)) * r10;
        return hashLength16(((r16 + LittleEndianByteArray.load64(r20, r13 - 24)) * r10) + (Long.rotateRight(r17 + r18, 43) + Long.rotateRight(r19, 30)), (r17 + Long.rotateRight(r18 + r11, 18)) + r19, r10);
    }

    private static long hashLength65Plus(byte[] r25, int r26, int r27) {
        long r10 = shiftMix(-7956866745689871395L) * K2;
        long[] r11 = new long[2];
        long[] r12 = new long[2];
        long r13 = 95310865018149119L + LittleEndianByteArray.load64(r25, r26);
        int r14 = r27 - 1;
        int r15 = r26 + ((r14 / 64) * 64);
        int r16 = r14 & 63;
        int r17 = r15 + r16;
        int r18 = r17 - 63;
        long r19 = 2480279821605975764L;
        int r110 = r26;
    L3:
        long r20 = Long.rotateRight(((r13 + r19) + r11[0]) + LittleEndianByteArray.load64(r25, r110 + 8), 37) * K1;
        long r21 = Long.rotateRight((r19 + r11[1]) + LittleEndianByteArray.load64(r25, r110 + 48), 42) * K1;
        long r111 = r20 ^ r12[1];
        long r22 = r21 + (r11[0] + LittleEndianByteArray.load64(r25, r110 + 40));
        long r23 = Long.rotateRight(r10 + r12[0], 33) * K1;
        weakHashLength32WithSeeds(r25, r110, r11[1] * K1, r111 + r12[0], r11);
        weakHashLength32WithSeeds(r25, r110 + 32, r23 + r12[1], r22 + LittleEndianByteArray.load64(r25, r110 + 16), r12);
        r110 = r110 + 64;
        if (r110 == r15) goto L5;
        r10 = r111;
        r19 = r22;
        r13 = r23;
        goto L3
    L5:
        long r112 = ((r111 & 255) << 1) + K1;
        long r24 = r12[0] + ((long) r16);
        r12[0] = r24;
        long r28 = r11[0] + r24;
        r11[0] = r28;
        r12[0] = r12[0] + r28;
        long r29 = Long.rotateRight(((r23 + r22) + r11[0]) + LittleEndianByteArray.load64(r25, r17 - 55), 37) * r112;
        long r30 = Long.rotateRight((r22 + r11[1]) + LittleEndianByteArray.load64(r25, r17 - 15), 42) * r112;
        long r210 = r29 ^ (r12[1] * 9);
        long r113 = r30 + ((r11[0] * 9) + LittleEndianByteArray.load64(r25, r17 - 23));
        long r114 = Long.rotateRight(r111 + r12[0], 33) * r112;
        weakHashLength32WithSeeds(r25, r18, r11[1] * r112, r210 + r12[0], r11);
        weakHashLength32WithSeeds(r25, r17 - 31, r114 + r12[1], LittleEndianByteArray.load64(r25, r17 - 47) + r113, r12);
        return hashLength16((hashLength16(r11[0], r12[0], r112) + (shiftMix(r113) * K0)) + r210, hashLength16(r11[1], r12[1], r112) + r114, r112);
    }

    private static long shiftMix(long r10) {
        return r10 ^ (r10 >>> 47);
    }

    private static void weakHashLength32WithSeeds(byte[] r10, int r11, long r12, long r13, long[] r14) {
        long r15 = LittleEndianByteArray.load64(r10, r11);
        long r16 = LittleEndianByteArray.load64(r10, r11 + 8);
        long r17 = LittleEndianByteArray.load64(r10, r11 + 16);
        long r18 = LittleEndianByteArray.load64(r10, r11 + 24);
        long r19 = r12 + r15;
        long r20 = (r16 + r19) + r17;
        long r110 = Long.rotateRight((r13 + r19) + r18, 21) + Long.rotateRight(r20, 44);
        r14[0] = r20 + r18;
        r14[1] = r110 + r19;
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 64;
    }

    @Override // com.google.common.hash.AbstractNonStreamingHashFunction, com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashBytes(byte[] r10, int r11, int r12) {
        Preconditions.checkPositionIndexes(r11, r11 + r12, r10.length);
        return HashCode.fromLong(fingerprint(r10, r11, r12));
    }

    public String toString() {
        return "Hashing.farmHashFingerprint64()";
    }
}

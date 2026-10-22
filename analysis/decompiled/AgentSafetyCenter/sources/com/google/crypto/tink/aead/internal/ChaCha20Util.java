package com.google.crypto.tink.aead.internal;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
final class ChaCha20Util {
    static final int BLOCK_SIZE_IN_BYTES = 64;
    static final int BLOCK_SIZE_IN_INTS = 16;
    static final int KEY_SIZE_IN_BYTES = 32;
    static final int KEY_SIZE_IN_INTS = 8;
    private static final int[] SIGMA = toIntArray(new byte[]{101, 120, 112, 97, 110, 100, 32, 51, 50, 45, 98, 121, 116, 101, 32, 107});

    private ChaCha20Util() {
    }

    public static void quarterRound(int[] iArr, int i, int i3, int i10, int i11) {
        int i12 = iArr[i] + iArr[i3];
        iArr[i] = i12;
        int iRotateLeft = rotateLeft(i12 ^ iArr[i11], 16);
        iArr[i11] = iRotateLeft;
        int i13 = iArr[i10] + iRotateLeft;
        iArr[i10] = i13;
        int iRotateLeft2 = rotateLeft(iArr[i3] ^ i13, 12);
        iArr[i3] = iRotateLeft2;
        int i14 = iArr[i] + iRotateLeft2;
        iArr[i] = i14;
        int iRotateLeft3 = rotateLeft(iArr[i11] ^ i14, 8);
        iArr[i11] = iRotateLeft3;
        int i15 = iArr[i10] + iRotateLeft3;
        iArr[i10] = i15;
        iArr[i3] = rotateLeft(iArr[i3] ^ i15, 7);
    }

    private static int rotateLeft(int i, int i3) {
        return (i >>> (-i3)) | (i << i3);
    }

    public static void setSigmaAndKey(int[] iArr, int[] iArr2) {
        int[] iArr3 = SIGMA;
        System.arraycopy(iArr3, 0, iArr, 0, iArr3.length);
        System.arraycopy(iArr2, 0, iArr, iArr3.length, 8);
    }

    public static void shuffleState(int[] iArr) {
        for (int i = 0; i < 10; i++) {
            quarterRound(iArr, 0, 4, 8, 12);
            quarterRound(iArr, 1, 5, 9, 13);
            quarterRound(iArr, 2, 6, 10, 14);
            quarterRound(iArr, 3, 7, 11, 15);
            quarterRound(iArr, 0, 5, 10, 15);
            quarterRound(iArr, 1, 6, 11, 12);
            quarterRound(iArr, 2, 7, 8, 13);
            quarterRound(iArr, 3, 4, 9, 14);
        }
    }

    public static int[] toIntArray(byte[] bArr) {
        IntBuffer intBufferAsIntBuffer = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] iArr = new int[intBufferAsIntBuffer.remaining()];
        intBufferAsIntBuffer.get(iArr);
        return iArr;
    }
}

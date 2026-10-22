package org.tukaani.xz.common;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class ByteArrayView {
    public static final int ALIGN_INT = 0;
    public static final int ALIGN_LONG = 0;
    public static final int ALIGN_SHORT = 0;

    private ByteArrayView() {
    }

    public static int getIntBE(byte[] bArr, int i8) {
        return (bArr[i8 + 3] & 255) | (bArr[i8] << 24) | ((bArr[i8 + 1] & 255) << 16) | ((bArr[i8 + 2] & 255) << 8);
    }

    public static int getIntLE(byte[] bArr, int i8) {
        return (bArr[i8 + 3] << 24) | (bArr[i8] & 255) | ((bArr[i8 + 1] & 255) << 8) | ((bArr[i8 + 2] & 255) << 16);
    }

    public static long getLongBE(byte[] bArr, int i8) {
        return (bArr[i8 + 7] & 255) | (bArr[i8] << 56) | ((bArr[i8 + 1] & 255) << 48) | ((bArr[i8 + 2] & 255) << 40) | ((bArr[i8 + 3] & 255) << 32) | ((bArr[i8 + 4] & 255) << 24) | ((bArr[i8 + 5] & 255) << 16) | ((bArr[i8 + 6] & 255) << 8);
    }

    public static long getLongLE(byte[] bArr, int i8) {
        return (bArr[i8 + 7] << 56) | (bArr[i8] & 255) | ((bArr[i8 + 1] & 255) << 8) | ((bArr[i8 + 2] & 255) << 16) | ((bArr[i8 + 3] & 255) << 24) | ((bArr[i8 + 4] & 255) << 32) | ((bArr[i8 + 5] & 255) << 40) | ((bArr[i8 + 6] & 255) << 48);
    }

    public static short getShortBE(byte[] bArr, int i8) {
        return (short) ((bArr[i8 + 1] & 255) | (bArr[i8] << 8));
    }

    public static short getShortLE(byte[] bArr, int i8) {
        return (short) ((bArr[i8 + 1] << 8) | (bArr[i8] & 255));
    }

    public static void setIntBE(byte[] bArr, int i8, int i9) {
        bArr[i8] = (byte) (i9 >>> 24);
        bArr[i8 + 1] = (byte) (i9 >>> 16);
        bArr[i8 + 2] = (byte) (i9 >>> 8);
        bArr[i8 + 3] = (byte) i9;
    }

    public static void setIntLE(byte[] bArr, int i8, int i9) {
        bArr[i8] = (byte) i9;
        bArr[i8 + 1] = (byte) (i9 >>> 8);
        bArr[i8 + 2] = (byte) (i9 >>> 16);
        bArr[i8 + 3] = (byte) (i9 >>> 24);
    }

    public static void setLongBE(byte[] bArr, int i8, long j4) {
        bArr[i8] = (byte) (j4 >>> 56);
        bArr[i8 + 1] = (byte) (j4 >>> 48);
        bArr[i8 + 2] = (byte) (j4 >>> 40);
        bArr[i8 + 3] = (byte) (j4 >>> 32);
        bArr[i8 + 4] = (byte) (j4 >>> 24);
        bArr[i8 + 5] = (byte) (j4 >>> 16);
        bArr[i8 + 6] = (byte) (j4 >>> 8);
        bArr[i8 + 7] = (byte) j4;
    }

    public static void setLongLE(byte[] bArr, int i8, long j4) {
        bArr[i8] = (byte) j4;
        bArr[i8 + 1] = (byte) (j4 >>> 8);
        bArr[i8 + 2] = (byte) (j4 >>> 16);
        bArr[i8 + 3] = (byte) (j4 >>> 24);
        bArr[i8 + 4] = (byte) (j4 >>> 32);
        bArr[i8 + 5] = (byte) (j4 >>> 40);
        bArr[i8 + 6] = (byte) (j4 >>> 48);
        bArr[i8 + 7] = (byte) (j4 >>> 56);
    }

    public static void setShortBE(byte[] bArr, int i8, short s8) {
        bArr[i8] = (byte) (s8 >>> 8);
        bArr[i8 + 1] = (byte) s8;
    }

    public static void setShortLE(byte[] bArr, int i8, short s8) {
        bArr[i8] = (byte) s8;
        bArr[i8 + 1] = (byte) (s8 >>> 8);
    }
}

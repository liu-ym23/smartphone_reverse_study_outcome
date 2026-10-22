package L4;

/* loaded from: classes.dex */
public final class c {
    public static final boolean a(byte[] bArr, int i5, byte[] bArr2, int i6, int i7) {
        j4.k.h(bArr, "a");
        j4.k.h(bArr2, "b");
        for (int i8 = 0; i8 < i7; i8++) {
            if (bArr[i8 + i5] != bArr2[i8 + i6]) {
                return false;
            }
        }
        return true;
    }

    public static final void b(long j5, long j6, long j7) {
        if ((j6 | j7) < 0 || j6 > j5 || j5 - j6 < j7) {
            throw new ArrayIndexOutOfBoundsException("size=" + j5 + " offset=" + j6 + " byteCount=" + j7);
        }
    }

    public static final int c(int i5) {
        return ((i5 & 255) << 24) | (((-16777216) & i5) >>> 24) | ((16711680 & i5) >>> 8) | ((65280 & i5) << 8);
    }

    public static final short d(short s5) {
        return (short) (((s5 & 255) << 8) | ((65280 & s5) >>> 8));
    }
}

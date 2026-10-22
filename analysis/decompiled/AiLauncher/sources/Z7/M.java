package Z7;

import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public final class M {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f7334a;

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f7335b;

    static {
        byte[] bArr = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};
        byte[] bArr2 = new byte[256];
        byte[] bArr3 = new byte[256];
        for (int i10 = 0; i10 < 256; i10++) {
            bArr2[i10] = bArr[i10 >>> 4];
            bArr3[i10] = bArr[i10 & 15];
        }
        f7334a = bArr2;
        f7335b = bArr3;
    }

    public static boolean a(int i10, int i11) {
        return i10 == i11;
    }

    public static boolean b(long j10, long j11) {
        return j10 == j11;
    }

    public static boolean c(Object obj, Object obj2) {
        return obj.equals(obj2);
    }

    public static boolean d(boolean z10, boolean z11) {
        return z10 == z11;
    }

    public static byte[] e(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        byte[] bArr = new byte[iPosition];
        System.arraycopy(byteBuffer.array(), 0, bArr, 0, iPosition);
        return bArr;
    }
}

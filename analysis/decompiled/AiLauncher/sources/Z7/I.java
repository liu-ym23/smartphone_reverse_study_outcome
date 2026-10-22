package Z7;

/* loaded from: classes4.dex */
public final class I {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f7324a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f7325b = new byte[0];

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        char[] cArr = new char[bArr.length * 2];
        for (int i10 = 0; i10 < bArr.length; i10++) {
            byte b10 = bArr[i10];
            int i11 = i10 * 2;
            char[] cArr2 = f7324a;
            cArr[i11 + 1] = cArr2[b10 & 15];
            cArr[i11] = cArr2[((byte) (b10 >>> 4)) & 15];
        }
        return new String(cArr);
    }
}

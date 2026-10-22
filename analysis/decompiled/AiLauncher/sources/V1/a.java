package V1;

/* loaded from: classes.dex */
public class a {
    public static String a(byte[] bArr, String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (int i10 = 0; i10 < bArr.length; i10++) {
            String hexString = Integer.toHexString(bArr[i10] & 255);
            if (str != null && str.length() > 0) {
                sb2.append(str);
            }
            if (hexString.length() < 2) {
                sb2.append("0");
            }
            sb2.append(hexString);
            if (str2 != null && str2.length() > 0 && i10 < bArr.length - 1) {
                sb2.append(str2);
            }
        }
        return sb2.toString();
    }

    public static byte[] b(long j10, int i10, boolean z10) {
        if (i10 < 0 || i10 > 8) {
            throw new IllegalArgumentException("width 应该在 0-8 之间");
        }
        byte[] bArr = new byte[i10];
        int i11 = 0;
        if (z10) {
            while (i11 < i10) {
                bArr[i11] = (byte) ((j10 >> (((i10 - i11) - 1) * 8)) & 255);
                i11++;
            }
        } else {
            while (i11 < i10) {
                bArr[i11] = (byte) ((j10 >> (i11 * 8)) & 255);
                i11++;
            }
        }
        return bArr;
    }
}

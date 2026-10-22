package W5;

import com.fasterxml.jackson.core.JsonPointer;

/* loaded from: classes3.dex */
public final class a {
    public static final char[] d = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', JsonPointer.SEPARATOR};
    public static final char e = (char) Integer.parseInt("00000011", 2);
    public static final char f = (char) Integer.parseInt("00001111", 2);
    public static final char g = (char) Integer.parseInt("00111111", 2);

    /* renamed from: a, reason: collision with root package name */
    public char[] f1489a;
    public char[] b;
    public int c;

    public final String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder(((bArr.length + 2) / 3) * 4);
        int length = bArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            int i6 = i + 1;
            int i10 = bArr[i] & 255;
            char c = e;
            if (i6 == length) {
                sb.append(this.b[i10 >>> 2]);
                sb.append(this.b[(i10 & c) << 4]);
                sb.append("==");
                break;
            }
            int i11 = i + 2;
            int i12 = bArr[i6] & 255;
            char c2 = f;
            if (i11 == length) {
                sb.append(this.b[i10 >>> 2]);
                sb.append(this.b[((i10 & c) << 4) | (i12 >>> 4)]);
                sb.append(this.b[(i12 & c2) << 2]);
                sb.append("=");
                break;
            }
            i += 3;
            int i13 = bArr[i11] & 255;
            sb.append(this.b[i10 >>> 2]);
            sb.append(this.b[((i10 & c) << 4) | (i12 >>> 4)]);
            sb.append(this.b[((i12 & c2) << 2) | (i13 >>> 6)]);
            sb.append(this.b[g & i13]);
        }
        return sb.toString();
    }
}

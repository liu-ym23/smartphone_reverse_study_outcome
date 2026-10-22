package T2;

import com.stepos.alphame.utils.Consts;
import kotlin.UByte;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    public static final char[] f1855d = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    /* renamed from: e, reason: collision with root package name */
    public static final char f1856e = (char) Integer.parseInt("00000011", 2);

    /* renamed from: f, reason: collision with root package name */
    public static final char f1857f = (char) Integer.parseInt("00001111", 2);

    /* renamed from: g, reason: collision with root package name */
    public static final char f1858g = (char) Integer.parseInt("00111111", 2);

    /* renamed from: a, reason: collision with root package name */
    public char[] f1859a;

    /* renamed from: b, reason: collision with root package name */
    public char[] f1860b;

    /* renamed from: c, reason: collision with root package name */
    public int f1861c;

    public final String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder(((bArr.length + 2) / 3) * 4);
        int length = bArr.length;
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                break;
            }
            int i5 = i4 + 1;
            int i6 = bArr[i4] & UByte.MAX_VALUE;
            char c4 = f1856e;
            if (i5 == length) {
                sb.append(this.f1860b[i6 >>> 2]);
                sb.append(this.f1860b[(i6 & c4) << 4]);
                sb.append("==");
                break;
            }
            int i7 = i4 + 2;
            int i8 = bArr[i5] & UByte.MAX_VALUE;
            char c5 = f1857f;
            if (i7 == length) {
                sb.append(this.f1860b[i6 >>> 2]);
                sb.append(this.f1860b[((i6 & c4) << 4) | (i8 >>> 4)]);
                sb.append(this.f1860b[(i8 & c5) << 2]);
                sb.append(Consts.SPLITTER_EQUAL);
                break;
            }
            i4 += 3;
            int i9 = bArr[i7] & UByte.MAX_VALUE;
            sb.append(this.f1860b[i6 >>> 2]);
            sb.append(this.f1860b[((i6 & c4) << 4) | (i8 >>> 4)]);
            sb.append(this.f1860b[((i8 & c5) << 2) | (i9 >>> 6)]);
            sb.append(this.f1860b[f1858g & i9]);
        }
        return sb.toString();
    }
}

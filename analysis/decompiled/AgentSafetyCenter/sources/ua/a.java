package ua;

import com.fasterxml.jackson.core.JsonPointer;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    public static final char[] f14275d = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', JsonPointer.SEPARATOR};

    /* renamed from: e, reason: collision with root package name */
    public static final char f14276e = (char) Integer.parseInt("00000011", 2);

    /* renamed from: f, reason: collision with root package name */
    public static final char f14277f = (char) Integer.parseInt("00001111", 2);

    /* renamed from: g, reason: collision with root package name */
    public static final char f14278g = (char) Integer.parseInt("00111111", 2);

    /* renamed from: a, reason: collision with root package name */
    public char[] f14279a;

    /* renamed from: b, reason: collision with root package name */
    public char[] f14280b;

    /* renamed from: c, reason: collision with root package name */
    public int f14281c;

    public final String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder(((bArr.length + 2) / 3) * 4);
        int length = bArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            int i3 = i + 1;
            int i10 = bArr[i] & 255;
            char c9 = f14276e;
            if (i3 == length) {
                sb2.append(this.f14280b[i10 >>> 2]);
                sb2.append(this.f14280b[(i10 & c9) << 4]);
                sb2.append("==");
                break;
            }
            int i11 = i + 2;
            int i12 = bArr[i3] & 255;
            char c10 = f14277f;
            if (i11 == length) {
                sb2.append(this.f14280b[i10 >>> 2]);
                sb2.append(this.f14280b[((i10 & c9) << 4) | (i12 >>> 4)]);
                sb2.append(this.f14280b[(i12 & c10) << 2]);
                sb2.append("=");
                break;
            }
            i += 3;
            int i13 = bArr[i11] & 255;
            sb2.append(this.f14280b[i10 >>> 2]);
            sb2.append(this.f14280b[((i10 & c9) << 4) | (i12 >>> 4)]);
            sb2.append(this.f14280b[((i12 & c10) << 2) | (i13 >>> 6)]);
            sb2.append(this.f14280b[f14278g & i13]);
        }
        return sb2.toString();
    }
}

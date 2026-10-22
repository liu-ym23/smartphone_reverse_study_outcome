package ta;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    public static final char[] f12937d = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    /* renamed from: e, reason: collision with root package name */
    public static final char f12938e = (char) Integer.parseInt("00000011", 2);

    /* renamed from: f, reason: collision with root package name */
    public static final char f12939f = (char) Integer.parseInt("00001111", 2);

    /* renamed from: g, reason: collision with root package name */
    public static final char f12940g = (char) Integer.parseInt("00111111", 2);

    /* renamed from: a, reason: collision with root package name */
    public char[] f12941a;

    /* renamed from: b, reason: collision with root package name */
    public char[] f12942b;

    /* renamed from: c, reason: collision with root package name */
    public int f12943c;

    public final String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder(((bArr.length + 2) / 3) * 4);
        int length = bArr.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                break;
            }
            int i11 = i10 + 1;
            int i12 = bArr[i10] & 255;
            char c9 = f12938e;
            if (i11 == length) {
                sb2.append(this.f12942b[i12 >>> 2]);
                sb2.append(this.f12942b[(i12 & c9) << 4]);
                sb2.append("==");
                break;
            }
            int i13 = i10 + 2;
            int i14 = bArr[i11] & 255;
            char c10 = f12939f;
            if (i13 == length) {
                sb2.append(this.f12942b[i12 >>> 2]);
                sb2.append(this.f12942b[((i12 & c9) << 4) | (i14 >>> 4)]);
                sb2.append(this.f12942b[(i14 & c10) << 2]);
                sb2.append("=");
                break;
            }
            i10 += 3;
            int i15 = bArr[i13] & 255;
            sb2.append(this.f12942b[i12 >>> 2]);
            sb2.append(this.f12942b[((i12 & c9) << 4) | (i14 >>> 4)]);
            sb2.append(this.f12942b[((i14 & c10) << 2) | (i15 >>> 6)]);
            sb2.append(this.f12942b[f12940g & i15]);
        }
        return sb2.toString();
    }
}

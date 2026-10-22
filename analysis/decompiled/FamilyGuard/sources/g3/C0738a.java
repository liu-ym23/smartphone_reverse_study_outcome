package g3;

/* renamed from: g3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0738a {

    /* renamed from: e, reason: collision with root package name */
    private static final char[] f17552e = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    /* renamed from: f, reason: collision with root package name */
    private static final char f17553f = (char) Integer.parseInt("00000011", 2);

    /* renamed from: g, reason: collision with root package name */
    private static final char f17554g = (char) Integer.parseInt("00001111", 2);

    /* renamed from: h, reason: collision with root package name */
    private static final char f17555h = (char) Integer.parseInt("00111111", 2);

    /* renamed from: a, reason: collision with root package name */
    private String f17556a;

    /* renamed from: b, reason: collision with root package name */
    private char[] f17557b;

    /* renamed from: c, reason: collision with root package name */
    private char[] f17558c;

    /* renamed from: d, reason: collision with root package name */
    private int f17559d = 0;

    public C0738a(String str) {
        this.f17556a = str;
        b();
    }

    private void b() {
        this.f17557b = new char[f17552e.length];
        int i5 = 0;
        this.f17559d = this.f17556a.charAt(0) % '\r';
        while (true) {
            char[] cArr = f17552e;
            if (i5 >= cArr.length) {
                this.f17558c = this.f17557b;
                return;
            } else {
                this.f17557b[i5] = cArr[(this.f17559d + i5) % cArr.length];
                i5++;
            }
        }
    }

    public String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder(((bArr.length + 2) / 3) * 4);
        int length = bArr.length;
        int i5 = 0;
        while (true) {
            if (i5 >= length) {
                break;
            }
            int i6 = i5 + 1;
            int i7 = bArr[i5] & 255;
            if (i6 == length) {
                sb.append(this.f17558c[i7 >>> 2]);
                sb.append(this.f17558c[(f17553f & i7) << 4]);
                sb.append("==");
                break;
            }
            int i8 = i5 + 2;
            int i9 = bArr[i6] & 255;
            if (i8 == length) {
                sb.append(this.f17558c[i7 >>> 2]);
                sb.append(this.f17558c[((f17553f & i7) << 4) | (i9 >>> 4)]);
                sb.append(this.f17558c[(f17554g & i9) << 2]);
                sb.append("=");
                break;
            }
            i5 += 3;
            int i10 = bArr[i8] & 255;
            sb.append(this.f17558c[i7 >>> 2]);
            sb.append(this.f17558c[((i7 & f17553f) << 4) | (i9 >>> 4)]);
            sb.append(this.f17558c[((i9 & f17554g) << 2) | (i10 >>> 6)]);
            sb.append(this.f17558c[f17555h & i10]);
        }
        return sb.toString();
    }
}

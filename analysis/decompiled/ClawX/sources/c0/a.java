package c0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: e, reason: collision with root package name */
    public static final byte[] f1034e = new byte[1792];

    /* renamed from: a, reason: collision with root package name */
    public final CharSequence f1035a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1036b;

    /* renamed from: c, reason: collision with root package name */
    public int f1037c;
    public char d;

    static {
        for (int i8 = 0; i8 < 1792; i8++) {
            f1034e[i8] = Character.getDirectionality(i8);
        }
    }

    public a(CharSequence charSequence) {
        this.f1035a = charSequence;
        this.f1036b = charSequence.length();
    }

    public final byte a() {
        int i8 = this.f1037c - 1;
        CharSequence charSequence = this.f1035a;
        char cCharAt = charSequence.charAt(i8);
        this.d = cCharAt;
        if (Character.isLowSurrogate(cCharAt)) {
            int iCodePointBefore = Character.codePointBefore(charSequence, this.f1037c);
            this.f1037c -= Character.charCount(iCodePointBefore);
            return Character.getDirectionality(iCodePointBefore);
        }
        this.f1037c--;
        char c3 = this.d;
        return c3 < 1792 ? f1034e[c3] : Character.getDirectionality(c3);
    }
}

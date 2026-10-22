package I;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: e, reason: collision with root package name */
    public static final byte[] f807e = new byte[1792];

    /* renamed from: a, reason: collision with root package name */
    public final CharSequence f808a;

    /* renamed from: b, reason: collision with root package name */
    public final int f809b;

    /* renamed from: c, reason: collision with root package name */
    public int f810c;

    /* renamed from: d, reason: collision with root package name */
    public char f811d;

    static {
        for (int i4 = 0; i4 < 1792; i4++) {
            f807e[i4] = Character.getDirectionality(i4);
        }
    }

    public a(CharSequence charSequence) {
        this.f808a = charSequence;
        this.f809b = charSequence.length();
    }

    public final byte a() {
        int i4 = this.f810c - 1;
        CharSequence charSequence = this.f808a;
        char cCharAt = charSequence.charAt(i4);
        this.f811d = cCharAt;
        if (Character.isLowSurrogate(cCharAt)) {
            int iCodePointBefore = Character.codePointBefore(charSequence, this.f810c);
            this.f810c -= Character.charCount(iCodePointBefore);
            return Character.getDirectionality(iCodePointBefore);
        }
        this.f810c--;
        char c4 = this.f811d;
        return c4 < 1792 ? f807e[c4] : Character.getDirectionality(c4);
    }
}

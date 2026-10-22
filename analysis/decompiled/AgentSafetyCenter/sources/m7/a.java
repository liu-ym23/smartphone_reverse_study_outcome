package m7;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    public static final a f8242d = new a("", "", false);

    /* renamed from: a, reason: collision with root package name */
    public final String f8243a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8244b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f8245c;

    static {
        new a("\n", "  ", true);
    }

    public a(String str, String str2, boolean z10) {
        if (!str.matches("[\r\n]*")) {
            g5.f.s("Only combinations of \\n and \\r are allowed in newline.");
            throw null;
        }
        if (!str2.matches("[ \t]*")) {
            g5.f.s("Only combinations of spaces and tabs are allowed in indent.");
            throw null;
        }
        this.f8243a = str;
        this.f8244b = str2;
        this.f8245c = z10;
    }
}

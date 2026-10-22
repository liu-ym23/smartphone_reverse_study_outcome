package d5;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: d, reason: collision with root package name */
    public static final c f8347d = new c("", "", false);

    /* renamed from: a, reason: collision with root package name */
    public final String f8348a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8349b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f8350c;

    static {
        new c("\n", "  ", true);
    }

    public c(String str, String str2, boolean z) {
        if (!str.matches("[\r\n]*")) {
            throw new IllegalArgumentException("Only combinations of \\n and \\r are allowed in newline.");
        }
        if (!str2.matches("[ \t]*")) {
            throw new IllegalArgumentException("Only combinations of spaces and tabs are allowed in indent.");
        }
        this.f8348a = str;
        this.f8349b = str2;
        this.f8350c = z;
    }
}

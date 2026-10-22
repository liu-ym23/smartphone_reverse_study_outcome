package ab;

/* loaded from: classes.dex */
public enum u {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");


    /* renamed from: f, reason: collision with root package name */
    public final String f655f;

    u(String str) {
        this.f655f = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f655f;
    }
}

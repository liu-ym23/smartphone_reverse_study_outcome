package h3;

/* loaded from: classes2.dex */
public enum T {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");


    /* renamed from: a, reason: collision with root package name */
    public final String f12820a;

    T(String str) {
        this.f12820a = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f12820a;
    }
}

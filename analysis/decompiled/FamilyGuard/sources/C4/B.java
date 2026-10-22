package C4;

import java.io.IOException;

/* loaded from: classes.dex */
public enum B {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");


    /* renamed from: a, reason: collision with root package name */
    private final String f670a;

    B(String str) {
        this.f670a = str;
    }

    public static B b(String str) throws IOException {
        B b6 = HTTP_1_0;
        if (str.equals(b6.f670a)) {
            return b6;
        }
        B b7 = HTTP_1_1;
        if (str.equals(b7.f670a)) {
            return b7;
        }
        B b8 = H2_PRIOR_KNOWLEDGE;
        if (str.equals(b8.f670a)) {
            return b8;
        }
        B b9 = HTTP_2;
        if (str.equals(b9.f670a)) {
            return b9;
        }
        B b10 = SPDY_3;
        if (str.equals(b10.f670a)) {
            return b10;
        }
        B b11 = QUIC;
        if (str.equals(b11.f670a)) {
            return b11;
        }
        throw new IOException("Unexpected protocol: " + str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f670a;
    }
}

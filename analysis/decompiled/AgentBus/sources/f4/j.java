package f4;

/* loaded from: classes.dex */
public final class j extends com.google.crypto.tink.shaded.protobuf.v {
    public static final int AES_CTR_KEY_FORMAT_FIELD_NUMBER = 1;
    private static final j DEFAULT_INSTANCE;
    public static final int HMAC_KEY_FORMAT_FIELD_NUMBER = 2;
    private static volatile com.google.crypto.tink.shaded.protobuf.v0 PARSER;
    private t aesCtrKeyFormat_;
    private e1 hmacKeyFormat_;

    static {
        j jVar = new j();
        DEFAULT_INSTANCE = jVar;
        com.google.crypto.tink.shaded.protobuf.v.s(j.class, jVar);
    }

    public static j A(com.google.crypto.tink.shaded.protobuf.h hVar, com.google.crypto.tink.shaded.protobuf.n nVar) {
        return (j) com.google.crypto.tink.shaded.protobuf.v.q(DEFAULT_INSTANCE, hVar, nVar);
    }

    public static void v(j jVar, t tVar) {
        jVar.getClass();
        jVar.aesCtrKeyFormat_ = tVar;
    }

    public static void w(j jVar, e1 e1Var) {
        jVar.getClass();
        jVar.hmacKeyFormat_ = e1Var;
    }

    public static i z() {
        return (i) DEFAULT_INSTANCE.g();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.v
    public final Object h(int i2) {
        com.google.crypto.tink.shaded.protobuf.v0 uVar;
        switch (n.f.d(i2)) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new com.google.crypto.tink.shaded.protobuf.z0(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"aesCtrKeyFormat_", "hmacKeyFormat_"});
            case 3:
                return new j();
            case 4:
                return new i(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                com.google.crypto.tink.shaded.protobuf.v0 v0Var = PARSER;
                if (v0Var != null) {
                    return v0Var;
                }
                synchronized (j.class) {
                    try {
                        uVar = PARSER;
                        if (uVar == null) {
                            uVar = new com.google.crypto.tink.shaded.protobuf.u();
                            PARSER = uVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return uVar;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final t x() {
        t tVar = this.aesCtrKeyFormat_;
        return tVar == null ? t.x() : tVar;
    }

    public final e1 y() {
        e1 e1Var = this.hmacKeyFormat_;
        return e1Var == null ? e1.x() : e1Var;
    }
}

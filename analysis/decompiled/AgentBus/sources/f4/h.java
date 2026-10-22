package f4;

/* loaded from: classes.dex */
public final class h extends com.google.crypto.tink.shaded.protobuf.v {
    public static final int AES_CTR_KEY_FIELD_NUMBER = 2;
    private static final h DEFAULT_INSTANCE;
    public static final int HMAC_KEY_FIELD_NUMBER = 3;
    private static volatile com.google.crypto.tink.shaded.protobuf.v0 PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private r aesCtrKey_;
    private c1 hmacKey_;
    private int version_;

    static {
        h hVar = new h();
        DEFAULT_INSTANCE = hVar;
        com.google.crypto.tink.shaded.protobuf.v.s(h.class, hVar);
    }

    public static g B() {
        return (g) DEFAULT_INSTANCE.g();
    }

    public static h C(com.google.crypto.tink.shaded.protobuf.h hVar, com.google.crypto.tink.shaded.protobuf.n nVar) {
        return (h) com.google.crypto.tink.shaded.protobuf.v.q(DEFAULT_INSTANCE, hVar, nVar);
    }

    public static void v(h hVar) {
        hVar.version_ = 0;
    }

    public static void w(h hVar, r rVar) {
        hVar.getClass();
        rVar.getClass();
        hVar.aesCtrKey_ = rVar;
    }

    public static void x(h hVar, c1 c1Var) {
        hVar.getClass();
        c1Var.getClass();
        hVar.hmacKey_ = c1Var;
    }

    public final int A() {
        return this.version_;
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
                return new com.google.crypto.tink.shaded.protobuf.z0(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\t", new Object[]{"version_", "aesCtrKey_", "hmacKey_"});
            case 3:
                return new h();
            case 4:
                return new g(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                com.google.crypto.tink.shaded.protobuf.v0 v0Var = PARSER;
                if (v0Var != null) {
                    return v0Var;
                }
                synchronized (h.class) {
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

    public final r y() {
        r rVar = this.aesCtrKey_;
        return rVar == null ? r.y() : rVar;
    }

    public final c1 z() {
        c1 c1Var = this.hmacKey_;
        return c1Var == null ? c1.y() : c1Var;
    }
}

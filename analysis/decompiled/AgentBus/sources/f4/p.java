package f4;

/* loaded from: classes.dex */
public final class p extends com.google.crypto.tink.shaded.protobuf.v {
    public static final int CIPHERTEXT_SEGMENT_SIZE_FIELD_NUMBER = 1;
    private static final p DEFAULT_INSTANCE;
    public static final int DERIVED_KEY_SIZE_FIELD_NUMBER = 2;
    public static final int HKDF_HASH_TYPE_FIELD_NUMBER = 3;
    public static final int HMAC_PARAMS_FIELD_NUMBER = 4;
    private static volatile com.google.crypto.tink.shaded.protobuf.v0 PARSER;
    private int ciphertextSegmentSize_;
    private int derivedKeySize_;
    private int hkdfHashType_;
    private g1 hmacParams_;

    static {
        p pVar = new p();
        DEFAULT_INSTANCE = pVar;
        com.google.crypto.tink.shaded.protobuf.v.s(p.class, pVar);
    }

    public static p A() {
        return DEFAULT_INSTANCE;
    }

    public static o E() {
        return (o) DEFAULT_INSTANCE.g();
    }

    public static void v(p pVar, int i2) {
        pVar.ciphertextSegmentSize_ = i2;
    }

    public static void w(p pVar, int i2) {
        pVar.derivedKeySize_ = i2;
    }

    public static void x(p pVar) {
        pVar.getClass();
        pVar.hkdfHashType_ = a1.SHA256.b();
    }

    public static void y(p pVar, g1 g1Var) {
        pVar.getClass();
        pVar.hmacParams_ = g1Var;
    }

    public final int B() {
        return this.derivedKeySize_;
    }

    public final a1 C() {
        a1 a1VarA = a1.a(this.hkdfHashType_);
        return a1VarA == null ? a1.UNRECOGNIZED : a1VarA;
    }

    public final g1 D() {
        g1 g1Var = this.hmacParams_;
        return g1Var == null ? g1.x() : g1Var;
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
                return new com.google.crypto.tink.shaded.protobuf.z0(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002\u000b\u0003\f\u0004\t", new Object[]{"ciphertextSegmentSize_", "derivedKeySize_", "hkdfHashType_", "hmacParams_"});
            case 3:
                return new p();
            case 4:
                return new o(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                com.google.crypto.tink.shaded.protobuf.v0 v0Var = PARSER;
                if (v0Var != null) {
                    return v0Var;
                }
                synchronized (p.class) {
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

    public final int z() {
        return this.ciphertextSegmentSize_;
    }
}

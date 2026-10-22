package f4;

/* loaded from: classes.dex */
public final class h0 extends com.google.crypto.tink.shaded.protobuf.v {
    public static final int CIPHERTEXT_SEGMENT_SIZE_FIELD_NUMBER = 1;
    private static final h0 DEFAULT_INSTANCE;
    public static final int DERIVED_KEY_SIZE_FIELD_NUMBER = 2;
    public static final int HKDF_HASH_TYPE_FIELD_NUMBER = 3;
    private static volatile com.google.crypto.tink.shaded.protobuf.v0 PARSER;
    private int ciphertextSegmentSize_;
    private int derivedKeySize_;
    private int hkdfHashType_;

    static {
        h0 h0Var = new h0();
        DEFAULT_INSTANCE = h0Var;
        com.google.crypto.tink.shaded.protobuf.v.s(h0.class, h0Var);
    }

    public static g0 C() {
        return (g0) DEFAULT_INSTANCE.g();
    }

    public static void v(h0 h0Var, int i2) {
        h0Var.ciphertextSegmentSize_ = i2;
    }

    public static void w(h0 h0Var, int i2) {
        h0Var.derivedKeySize_ = i2;
    }

    public static void x(h0 h0Var) {
        h0Var.getClass();
        h0Var.hkdfHashType_ = a1.SHA256.b();
    }

    public static h0 z() {
        return DEFAULT_INSTANCE;
    }

    public final int A() {
        return this.derivedKeySize_;
    }

    public final a1 B() {
        a1 a1VarA = a1.a(this.hkdfHashType_);
        return a1VarA == null ? a1.UNRECOGNIZED : a1VarA;
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
                return new com.google.crypto.tink.shaded.protobuf.z0(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\u000b\u0003\f", new Object[]{"ciphertextSegmentSize_", "derivedKeySize_", "hkdfHashType_"});
            case 3:
                return new h0();
            case 4:
                return new g0(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                com.google.crypto.tink.shaded.protobuf.v0 v0Var = PARSER;
                if (v0Var != null) {
                    return v0Var;
                }
                synchronized (h0.class) {
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

    public final int y() {
        return this.ciphertextSegmentSize_;
    }
}

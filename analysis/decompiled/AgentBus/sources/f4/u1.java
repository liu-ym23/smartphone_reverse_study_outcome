package f4;

/* loaded from: classes.dex */
public final class u1 extends com.google.crypto.tink.shaded.protobuf.v {
    private static final u1 DEFAULT_INSTANCE;
    public static final int KEY_ID_FIELD_NUMBER = 3;
    public static final int OUTPUT_PREFIX_TYPE_FIELD_NUMBER = 4;
    private static volatile com.google.crypto.tink.shaded.protobuf.v0 PARSER = null;
    public static final int STATUS_FIELD_NUMBER = 2;
    public static final int TYPE_URL_FIELD_NUMBER = 1;
    private int keyId_;
    private int outputPrefixType_;
    private int status_;
    private String typeUrl_ = "";

    static {
        u1 u1Var = new u1();
        DEFAULT_INSTANCE = u1Var;
        com.google.crypto.tink.shaded.protobuf.v.s(u1.class, u1Var);
    }

    public static t1 A() {
        return (t1) DEFAULT_INSTANCE.g();
    }

    public static void v(u1 u1Var, String str) {
        u1Var.getClass();
        str.getClass();
        u1Var.typeUrl_ = str;
    }

    public static void w(u1 u1Var, c2 c2Var) {
        u1Var.getClass();
        u1Var.outputPrefixType_ = c2Var.b();
    }

    public static void x(u1 u1Var, k1 k1Var) {
        u1Var.getClass();
        u1Var.status_ = k1Var.a();
    }

    public static void y(u1 u1Var, int i2) {
        u1Var.keyId_ = i2;
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
                return new com.google.crypto.tink.shaded.protobuf.z0(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"typeUrl_", "status_", "keyId_", "outputPrefixType_"});
            case 3:
                return new u1();
            case 4:
                return new t1(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                com.google.crypto.tink.shaded.protobuf.v0 v0Var = PARSER;
                if (v0Var != null) {
                    return v0Var;
                }
                synchronized (u1.class) {
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
        return this.keyId_;
    }
}

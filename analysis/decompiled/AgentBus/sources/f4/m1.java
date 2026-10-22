package f4;

/* loaded from: classes.dex */
public final class m1 extends com.google.crypto.tink.shaded.protobuf.v {
    private static final m1 DEFAULT_INSTANCE;
    public static final int OUTPUT_PREFIX_TYPE_FIELD_NUMBER = 3;
    private static volatile com.google.crypto.tink.shaded.protobuf.v0 PARSER = null;
    public static final int TYPE_URL_FIELD_NUMBER = 1;
    public static final int VALUE_FIELD_NUMBER = 2;
    private int outputPrefixType_;
    private String typeUrl_ = "";
    private com.google.crypto.tink.shaded.protobuf.h value_ = com.google.crypto.tink.shaded.protobuf.h.f2209g;

    static {
        m1 m1Var = new m1();
        DEFAULT_INSTANCE = m1Var;
        com.google.crypto.tink.shaded.protobuf.v.s(m1.class, m1Var);
    }

    public static l1 C() {
        return (l1) DEFAULT_INSTANCE.g();
    }

    public static void v(m1 m1Var, String str) {
        m1Var.getClass();
        str.getClass();
        m1Var.typeUrl_ = str;
    }

    public static void w(m1 m1Var, com.google.crypto.tink.shaded.protobuf.g gVar) {
        m1Var.getClass();
        m1Var.value_ = gVar;
    }

    public static void x(m1 m1Var, c2 c2Var) {
        m1Var.getClass();
        m1Var.outputPrefixType_ = c2Var.b();
    }

    public static m1 y() {
        return DEFAULT_INSTANCE;
    }

    public final String A() {
        return this.typeUrl_;
    }

    public final com.google.crypto.tink.shaded.protobuf.h B() {
        return this.value_;
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
                return new com.google.crypto.tink.shaded.protobuf.z0(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"typeUrl_", "value_", "outputPrefixType_"});
            case 3:
                return new m1();
            case 4:
                return new l1(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                com.google.crypto.tink.shaded.protobuf.v0 v0Var = PARSER;
                if (v0Var != null) {
                    return v0Var;
                }
                synchronized (m1.class) {
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

    public final c2 z() {
        c2 c2VarA = c2.a(this.outputPrefixType_);
        return c2VarA == null ? c2.UNRECOGNIZED : c2VarA;
    }
}

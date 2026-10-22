package f4;

/* loaded from: classes.dex */
public final class q1 extends com.google.crypto.tink.shaded.protobuf.v {
    private static final q1 DEFAULT_INSTANCE;
    public static final int KEY_DATA_FIELD_NUMBER = 1;
    public static final int KEY_ID_FIELD_NUMBER = 3;
    public static final int OUTPUT_PREFIX_TYPE_FIELD_NUMBER = 4;
    private static volatile com.google.crypto.tink.shaded.protobuf.v0 PARSER = null;
    public static final int STATUS_FIELD_NUMBER = 2;
    private j1 keyData_;
    private int keyId_;
    private int outputPrefixType_;
    private int status_;

    static {
        q1 q1Var = new q1();
        DEFAULT_INSTANCE = q1Var;
        com.google.crypto.tink.shaded.protobuf.v.s(q1.class, q1Var);
    }

    public static p1 E() {
        return (p1) DEFAULT_INSTANCE.g();
    }

    public static void v(q1 q1Var, j1 j1Var) {
        q1Var.getClass();
        q1Var.keyData_ = j1Var;
    }

    public static void w(q1 q1Var, c2 c2Var) {
        q1Var.getClass();
        q1Var.outputPrefixType_ = c2Var.b();
    }

    public static void x(q1 q1Var) {
        q1Var.getClass();
        q1Var.status_ = k1.ENABLED.a();
    }

    public static void y(q1 q1Var, int i2) {
        q1Var.keyId_ = i2;
    }

    public final int A() {
        return this.keyId_;
    }

    public final c2 B() {
        c2 c2VarA = c2.a(this.outputPrefixType_);
        return c2VarA == null ? c2.UNRECOGNIZED : c2VarA;
    }

    public final k1 C() {
        int i2 = this.status_;
        k1 k1Var = i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? null : k1.DESTROYED : k1.DISABLED : k1.ENABLED : k1.UNKNOWN_STATUS;
        return k1Var == null ? k1.UNRECOGNIZED : k1Var;
    }

    public final boolean D() {
        return this.keyData_ != null;
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
                return new com.google.crypto.tink.shaded.protobuf.z0(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0002\f\u0003\u000b\u0004\f", new Object[]{"keyData_", "status_", "keyId_", "outputPrefixType_"});
            case 3:
                return new q1();
            case 4:
                return new p1(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                com.google.crypto.tink.shaded.protobuf.v0 v0Var = PARSER;
                if (v0Var != null) {
                    return v0Var;
                }
                synchronized (q1.class) {
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

    public final j1 z() {
        j1 j1Var = this.keyData_;
        return j1Var == null ? j1.y() : j1Var;
    }
}

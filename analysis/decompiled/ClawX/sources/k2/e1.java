package k2;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e1 extends com.google.crypto.tink.shaded.protobuf.w {
    private static final e1 DEFAULT_INSTANCE;
    public static final int KEY_DATA_FIELD_NUMBER = 1;
    public static final int KEY_ID_FIELD_NUMBER = 3;
    public static final int OUTPUT_PREFIX_TYPE_FIELD_NUMBER = 4;
    private static volatile com.google.crypto.tink.shaded.protobuf.w0 PARSER = null;
    public static final int STATUS_FIELD_NUMBER = 2;
    private x0 keyData_;
    private int keyId_;
    private int outputPrefixType_;
    private int status_;

    static {
        e1 e1Var = new e1();
        DEFAULT_INSTANCE = e1Var;
        com.google.crypto.tink.shaded.protobuf.w.t(e1.class, e1Var);
    }

    public static d1 F() {
        return (d1) DEFAULT_INSTANCE.h();
    }

    public static void w(e1 e1Var, x0 x0Var) {
        e1Var.getClass();
        e1Var.keyData_ = x0Var;
    }

    public static void x(e1 e1Var, q1 q1Var) {
        e1Var.getClass();
        e1Var.outputPrefixType_ = q1Var.b();
    }

    public static void y(e1 e1Var) {
        e1Var.getClass();
        e1Var.status_ = y0.ENABLED.a();
    }

    public static void z(e1 e1Var, int i8) {
        e1Var.keyId_ = i8;
    }

    public final x0 A() {
        x0 x0Var = this.keyData_;
        return x0Var == null ? x0.z() : x0Var;
    }

    public final int B() {
        return this.keyId_;
    }

    public final q1 C() {
        q1 q1VarA = q1.a(this.outputPrefixType_);
        return q1VarA == null ? q1.UNRECOGNIZED : q1VarA;
    }

    public final y0 D() {
        int i8 = this.status_;
        y0 y0Var = i8 != 0 ? i8 != 1 ? i8 != 2 ? i8 != 3 ? null : y0.DESTROYED : y0.DISABLED : y0.ENABLED : y0.UNKNOWN_STATUS;
        return y0Var == null ? y0.UNRECOGNIZED : y0Var;
    }

    public final boolean E() {
        return this.keyData_ != null;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.w
    public final Object i(int i8) {
        com.google.crypto.tink.shaded.protobuf.w0 vVar;
        switch (m.f.a(i8)) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new com.google.crypto.tink.shaded.protobuf.a1(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0002\f\u0003\u000b\u0004\f", new Object[]{"keyData_", "status_", "keyId_", "outputPrefixType_"});
            case 3:
                return new e1();
            case 4:
                return new d1(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                com.google.crypto.tink.shaded.protobuf.w0 w0Var = PARSER;
                if (w0Var != null) {
                    return w0Var;
                }
                synchronized (e1.class) {
                    try {
                        vVar = PARSER;
                        if (vVar == null) {
                            vVar = new com.google.crypto.tink.shaded.protobuf.v();
                            PARSER = vVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return vVar;
            default:
                throw new UnsupportedOperationException();
        }
    }
}

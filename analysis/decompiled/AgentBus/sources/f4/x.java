package f4;

/* loaded from: classes.dex */
public final class x extends com.google.crypto.tink.shaded.protobuf.v {
    private static final x DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 3;
    public static final int PARAMS_FIELD_NUMBER = 2;
    private static volatile com.google.crypto.tink.shaded.protobuf.v0 PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private com.google.crypto.tink.shaded.protobuf.h keyValue_ = com.google.crypto.tink.shaded.protobuf.h.f2209g;
    private b0 params_;
    private int version_;

    static {
        x xVar = new x();
        DEFAULT_INSTANCE = xVar;
        com.google.crypto.tink.shaded.protobuf.v.s(x.class, xVar);
    }

    public static w B() {
        return (w) DEFAULT_INSTANCE.g();
    }

    public static x C(com.google.crypto.tink.shaded.protobuf.h hVar, com.google.crypto.tink.shaded.protobuf.n nVar) {
        return (x) com.google.crypto.tink.shaded.protobuf.v.q(DEFAULT_INSTANCE, hVar, nVar);
    }

    public static void v(x xVar) {
        xVar.version_ = 0;
    }

    public static void w(x xVar, b0 b0Var) {
        xVar.getClass();
        b0Var.getClass();
        xVar.params_ = b0Var;
    }

    public static void x(x xVar, com.google.crypto.tink.shaded.protobuf.g gVar) {
        xVar.getClass();
        xVar.keyValue_ = gVar;
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
                return new com.google.crypto.tink.shaded.protobuf.z0(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"version_", "params_", "keyValue_"});
            case 3:
                return new x();
            case 4:
                return new w(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                com.google.crypto.tink.shaded.protobuf.v0 v0Var = PARSER;
                if (v0Var != null) {
                    return v0Var;
                }
                synchronized (x.class) {
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

    public final com.google.crypto.tink.shaded.protobuf.h y() {
        return this.keyValue_;
    }

    public final b0 z() {
        b0 b0Var = this.params_;
        return b0Var == null ? b0.w() : b0Var;
    }
}

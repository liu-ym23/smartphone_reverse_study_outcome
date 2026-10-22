package f4;

/* loaded from: classes.dex */
public final class a2 extends com.google.crypto.tink.shaded.protobuf.v {
    private static final a2 DEFAULT_INSTANCE;
    public static final int PARAMS_FIELD_NUMBER = 2;
    private static volatile com.google.crypto.tink.shaded.protobuf.v0 PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private b2 params_;
    private int version_;

    static {
        a2 a2Var = new a2();
        DEFAULT_INSTANCE = a2Var;
        com.google.crypto.tink.shaded.protobuf.v.s(a2.class, a2Var);
    }

    public static a2 A(com.google.crypto.tink.shaded.protobuf.h hVar, com.google.crypto.tink.shaded.protobuf.n nVar) {
        return (a2) com.google.crypto.tink.shaded.protobuf.v.q(DEFAULT_INSTANCE, hVar, nVar);
    }

    public static void v(a2 a2Var) {
        a2Var.version_ = 0;
    }

    public static void w(a2 a2Var, b2 b2Var) {
        a2Var.getClass();
        b2Var.getClass();
        a2Var.params_ = b2Var;
    }

    public static z1 z() {
        return (z1) DEFAULT_INSTANCE.g();
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
                return new com.google.crypto.tink.shaded.protobuf.z0(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"version_", "params_"});
            case 3:
                return new a2();
            case 4:
                return new z1(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                com.google.crypto.tink.shaded.protobuf.v0 v0Var = PARSER;
                if (v0Var != null) {
                    return v0Var;
                }
                synchronized (a2.class) {
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

    public final b2 x() {
        b2 b2Var = this.params_;
        return b2Var == null ? b2.v() : b2Var;
    }

    public final int y() {
        return this.version_;
    }
}

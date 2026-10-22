package f4;

/* loaded from: classes.dex */
public final class c1 extends com.google.crypto.tink.shaded.protobuf.v {
    private static final c1 DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 3;
    public static final int PARAMS_FIELD_NUMBER = 2;
    private static volatile com.google.crypto.tink.shaded.protobuf.v0 PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private com.google.crypto.tink.shaded.protobuf.h keyValue_ = com.google.crypto.tink.shaded.protobuf.h.f2209g;
    private g1 params_;
    private int version_;

    static {
        c1 c1Var = new c1();
        DEFAULT_INSTANCE = c1Var;
        com.google.crypto.tink.shaded.protobuf.v.s(c1.class, c1Var);
    }

    public static b1 C() {
        return (b1) DEFAULT_INSTANCE.g();
    }

    public static c1 D(com.google.crypto.tink.shaded.protobuf.h hVar, com.google.crypto.tink.shaded.protobuf.n nVar) {
        return (c1) com.google.crypto.tink.shaded.protobuf.v.q(DEFAULT_INSTANCE, hVar, nVar);
    }

    public static void v(c1 c1Var) {
        c1Var.version_ = 0;
    }

    public static void w(c1 c1Var, g1 g1Var) {
        c1Var.getClass();
        g1Var.getClass();
        c1Var.params_ = g1Var;
    }

    public static void x(c1 c1Var, com.google.crypto.tink.shaded.protobuf.g gVar) {
        c1Var.getClass();
        c1Var.keyValue_ = gVar;
    }

    public static c1 y() {
        return DEFAULT_INSTANCE;
    }

    public final g1 A() {
        g1 g1Var = this.params_;
        return g1Var == null ? g1.x() : g1Var;
    }

    public final int B() {
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
                return new c1();
            case 4:
                return new b1(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                com.google.crypto.tink.shaded.protobuf.v0 v0Var = PARSER;
                if (v0Var != null) {
                    return v0Var;
                }
                synchronized (c1.class) {
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

    public final com.google.crypto.tink.shaded.protobuf.h z() {
        return this.keyValue_;
    }
}

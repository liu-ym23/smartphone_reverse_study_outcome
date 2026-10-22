package f4;

/* loaded from: classes.dex */
public final class x1 extends com.google.crypto.tink.shaded.protobuf.v {
    private static final x1 DEFAULT_INSTANCE;
    public static final int PARAMS_FIELD_NUMBER = 2;
    private static volatile com.google.crypto.tink.shaded.protobuf.v0 PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private y1 params_;
    private int version_;

    static {
        x1 x1Var = new x1();
        DEFAULT_INSTANCE = x1Var;
        com.google.crypto.tink.shaded.protobuf.v.s(x1.class, x1Var);
    }

    public static x1 A(com.google.crypto.tink.shaded.protobuf.h hVar, com.google.crypto.tink.shaded.protobuf.n nVar) {
        return (x1) com.google.crypto.tink.shaded.protobuf.v.q(DEFAULT_INSTANCE, hVar, nVar);
    }

    public static void v(x1 x1Var) {
        x1Var.version_ = 0;
    }

    public static void w(x1 x1Var, y1 y1Var) {
        x1Var.getClass();
        y1Var.getClass();
        x1Var.params_ = y1Var;
    }

    public static w1 z() {
        return (w1) DEFAULT_INSTANCE.g();
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
                return new x1();
            case 4:
                return new w1(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                com.google.crypto.tink.shaded.protobuf.v0 v0Var = PARSER;
                if (v0Var != null) {
                    return v0Var;
                }
                synchronized (x1.class) {
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

    public final y1 x() {
        y1 y1Var = this.params_;
        return y1Var == null ? y1.v() : y1Var;
    }

    public final int y() {
        return this.version_;
    }
}

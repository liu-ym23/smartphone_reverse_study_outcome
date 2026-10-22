package f4;

/* loaded from: classes.dex */
public final class b2 extends com.google.crypto.tink.shaded.protobuf.v {
    private static final b2 DEFAULT_INSTANCE;
    public static final int DEK_TEMPLATE_FIELD_NUMBER = 2;
    public static final int KEK_URI_FIELD_NUMBER = 1;
    private static volatile com.google.crypto.tink.shaded.protobuf.v0 PARSER;
    private m1 dekTemplate_;
    private String kekUri_ = "";

    static {
        b2 b2Var = new b2();
        DEFAULT_INSTANCE = b2Var;
        com.google.crypto.tink.shaded.protobuf.v.s(b2.class, b2Var);
    }

    public static b2 v() {
        return DEFAULT_INSTANCE;
    }

    public static b2 z(com.google.crypto.tink.shaded.protobuf.h hVar, com.google.crypto.tink.shaded.protobuf.n nVar) {
        return (b2) com.google.crypto.tink.shaded.protobuf.v.q(DEFAULT_INSTANCE, hVar, nVar);
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
                return new com.google.crypto.tink.shaded.protobuf.z0(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\t", new Object[]{"kekUri_", "dekTemplate_"});
            case 3:
                return new b2();
            case 4:
                return new w0(DEFAULT_INSTANCE, 3);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                com.google.crypto.tink.shaded.protobuf.v0 v0Var = PARSER;
                if (v0Var != null) {
                    return v0Var;
                }
                synchronized (b2.class) {
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

    public final m1 w() {
        m1 m1Var = this.dekTemplate_;
        return m1Var == null ? m1.y() : m1Var;
    }

    public final String x() {
        return this.kekUri_;
    }

    public final boolean y() {
        return this.dekTemplate_ != null;
    }
}

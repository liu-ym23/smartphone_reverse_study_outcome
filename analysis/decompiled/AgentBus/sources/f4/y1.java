package f4;

/* loaded from: classes.dex */
public final class y1 extends com.google.crypto.tink.shaded.protobuf.v {
    private static final y1 DEFAULT_INSTANCE;
    public static final int KEY_URI_FIELD_NUMBER = 1;
    private static volatile com.google.crypto.tink.shaded.protobuf.v0 PARSER;
    private String keyUri_ = "";

    static {
        y1 y1Var = new y1();
        DEFAULT_INSTANCE = y1Var;
        com.google.crypto.tink.shaded.protobuf.v.s(y1.class, y1Var);
    }

    public static y1 v() {
        return DEFAULT_INSTANCE;
    }

    public static y1 x(com.google.crypto.tink.shaded.protobuf.h hVar, com.google.crypto.tink.shaded.protobuf.n nVar) {
        return (y1) com.google.crypto.tink.shaded.protobuf.v.q(DEFAULT_INSTANCE, hVar, nVar);
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
                return new com.google.crypto.tink.shaded.protobuf.z0(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"keyUri_"});
            case 3:
                return new y1();
            case 4:
                return new w0(DEFAULT_INSTANCE, 2);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                com.google.crypto.tink.shaded.protobuf.v0 v0Var = PARSER;
                if (v0Var != null) {
                    return v0Var;
                }
                synchronized (y1.class) {
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

    public final String w() {
        return this.keyUri_;
    }
}

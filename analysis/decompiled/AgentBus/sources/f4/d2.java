package f4;

/* loaded from: classes.dex */
public final class d2 extends com.google.crypto.tink.shaded.protobuf.v {
    public static final int CONFIG_NAME_FIELD_NUMBER = 1;
    private static final d2 DEFAULT_INSTANCE;
    public static final int ENTRY_FIELD_NUMBER = 2;
    private static volatile com.google.crypto.tink.shaded.protobuf.v0 PARSER;
    private String configName_ = "";
    private com.google.crypto.tink.shaded.protobuf.y entry_ = com.google.crypto.tink.shaded.protobuf.y0.f2293i;

    static {
        d2 d2Var = new d2();
        DEFAULT_INSTANCE = d2Var;
        com.google.crypto.tink.shaded.protobuf.v.s(d2.class, d2Var);
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
                return new com.google.crypto.tink.shaded.protobuf.z0(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"configName_", "entry_", n1.class});
            case 3:
                return new d2();
            case 4:
                return new w0(DEFAULT_INSTANCE, 4);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                com.google.crypto.tink.shaded.protobuf.v0 v0Var = PARSER;
                if (v0Var != null) {
                    return v0Var;
                }
                synchronized (d2.class) {
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
}

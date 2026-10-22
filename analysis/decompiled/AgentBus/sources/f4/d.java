package f4;

/* loaded from: classes.dex */
public final class d extends com.google.crypto.tink.shaded.protobuf.v {
    private static final d DEFAULT_INSTANCE;
    public static final int KEY_SIZE_FIELD_NUMBER = 1;
    public static final int PARAMS_FIELD_NUMBER = 2;
    private static volatile com.google.crypto.tink.shaded.protobuf.v0 PARSER;
    private int keySize_;
    private f params_;

    static {
        d dVar = new d();
        DEFAULT_INSTANCE = dVar;
        com.google.crypto.tink.shaded.protobuf.v.s(d.class, dVar);
    }

    public static d A(com.google.crypto.tink.shaded.protobuf.h hVar, com.google.crypto.tink.shaded.protobuf.n nVar) {
        return (d) com.google.crypto.tink.shaded.protobuf.v.q(DEFAULT_INSTANCE, hVar, nVar);
    }

    public static void v(d dVar) {
        dVar.keySize_ = 32;
    }

    public static void w(d dVar, f fVar) {
        dVar.getClass();
        dVar.params_ = fVar;
    }

    public static c z() {
        return (c) DEFAULT_INSTANCE.g();
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
                return new com.google.crypto.tink.shaded.protobuf.z0(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"keySize_", "params_"});
            case 3:
                return new d();
            case 4:
                return new c(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                com.google.crypto.tink.shaded.protobuf.v0 v0Var = PARSER;
                if (v0Var != null) {
                    return v0Var;
                }
                synchronized (d.class) {
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

    public final int x() {
        return this.keySize_;
    }

    public final f y() {
        f fVar = this.params_;
        return fVar == null ? f.w() : fVar;
    }
}

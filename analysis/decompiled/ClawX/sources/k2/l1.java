package k2;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class l1 extends com.google.crypto.tink.shaded.protobuf.w {
    private static final l1 DEFAULT_INSTANCE;
    public static final int PARAMS_FIELD_NUMBER = 2;
    private static volatile com.google.crypto.tink.shaded.protobuf.w0 PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private m1 params_;
    private int version_;

    static {
        l1 l1Var = new l1();
        DEFAULT_INSTANCE = l1Var;
        com.google.crypto.tink.shaded.protobuf.w.t(l1.class, l1Var);
    }

    public static k1 A() {
        return (k1) DEFAULT_INSTANCE.h();
    }

    public static l1 B(com.google.crypto.tink.shaded.protobuf.i iVar, com.google.crypto.tink.shaded.protobuf.o oVar) {
        return (l1) com.google.crypto.tink.shaded.protobuf.w.r(DEFAULT_INSTANCE, iVar, oVar);
    }

    public static void w(l1 l1Var) {
        l1Var.version_ = 0;
    }

    public static void x(l1 l1Var, m1 m1Var) {
        l1Var.getClass();
        m1Var.getClass();
        l1Var.params_ = m1Var;
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
                return new com.google.crypto.tink.shaded.protobuf.a1(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"version_", "params_"});
            case 3:
                return new l1();
            case 4:
                return new k1(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                com.google.crypto.tink.shaded.protobuf.w0 w0Var = PARSER;
                if (w0Var != null) {
                    return w0Var;
                }
                synchronized (l1.class) {
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

    public final m1 y() {
        m1 m1Var = this.params_;
        return m1Var == null ? m1.w() : m1Var;
    }

    public final int z() {
        return this.version_;
    }
}

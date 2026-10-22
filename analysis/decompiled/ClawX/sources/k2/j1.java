package k2;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class j1 extends com.google.crypto.tink.shaded.protobuf.w {
    private static final j1 DEFAULT_INSTANCE;
    public static final int KEY_INFO_FIELD_NUMBER = 2;
    private static volatile com.google.crypto.tink.shaded.protobuf.w0 PARSER = null;
    public static final int PRIMARY_KEY_ID_FIELD_NUMBER = 1;
    private com.google.crypto.tink.shaded.protobuf.z keyInfo_ = com.google.crypto.tink.shaded.protobuf.z0.d;
    private int primaryKeyId_;

    static {
        j1 j1Var = new j1();
        DEFAULT_INSTANCE = j1Var;
        com.google.crypto.tink.shaded.protobuf.w.t(j1.class, j1Var);
    }

    public static void w(j1 j1Var, int i8) {
        j1Var.primaryKeyId_ = i8;
    }

    public static void x(j1 j1Var, i1 i1Var) {
        j1Var.getClass();
        com.google.crypto.tink.shaded.protobuf.z zVar = j1Var.keyInfo_;
        if (!((com.google.crypto.tink.shaded.protobuf.b) zVar).f1433a) {
            int size = zVar.size();
            j1Var.keyInfo_ = zVar.a(size == 0 ? 10 : size * 2);
        }
        j1Var.keyInfo_.add(i1Var);
    }

    public static g1 z() {
        return (g1) DEFAULT_INSTANCE.h();
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
                return new com.google.crypto.tink.shaded.protobuf.a1(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"primaryKeyId_", "keyInfo_", i1.class});
            case 3:
                return new j1();
            case 4:
                return new g1(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                com.google.crypto.tink.shaded.protobuf.w0 w0Var = PARSER;
                if (w0Var != null) {
                    return w0Var;
                }
                synchronized (j1.class) {
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

    public final i1 y() {
        return (i1) this.keyInfo_.get(0);
    }
}

package k2;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class j extends com.google.crypto.tink.shaded.protobuf.w {
    public static final int AES_CTR_KEY_FORMAT_FIELD_NUMBER = 1;
    private static final j DEFAULT_INSTANCE;
    public static final int HMAC_KEY_FORMAT_FIELD_NUMBER = 2;
    private static volatile com.google.crypto.tink.shaded.protobuf.w0 PARSER;
    private n aesCtrKeyFormat_;
    private s0 hmacKeyFormat_;

    static {
        j jVar = new j();
        DEFAULT_INSTANCE = jVar;
        com.google.crypto.tink.shaded.protobuf.w.t(j.class, jVar);
    }

    public static i A() {
        return (i) DEFAULT_INSTANCE.h();
    }

    public static j B(com.google.crypto.tink.shaded.protobuf.i iVar, com.google.crypto.tink.shaded.protobuf.o oVar) {
        return (j) com.google.crypto.tink.shaded.protobuf.w.r(DEFAULT_INSTANCE, iVar, oVar);
    }

    public static void w(j jVar, n nVar) {
        jVar.getClass();
        jVar.aesCtrKeyFormat_ = nVar;
    }

    public static void x(j jVar, s0 s0Var) {
        jVar.getClass();
        jVar.hmacKeyFormat_ = s0Var;
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
                return new com.google.crypto.tink.shaded.protobuf.a1(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"aesCtrKeyFormat_", "hmacKeyFormat_"});
            case 3:
                return new j();
            case 4:
                return new i(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                com.google.crypto.tink.shaded.protobuf.w0 w0Var = PARSER;
                if (w0Var != null) {
                    return w0Var;
                }
                synchronized (j.class) {
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

    public final n y() {
        n nVar = this.aesCtrKeyFormat_;
        return nVar == null ? n.y() : nVar;
    }

    public final s0 z() {
        s0 s0Var = this.hmacKeyFormat_;
        return s0Var == null ? s0.y() : s0Var;
    }
}

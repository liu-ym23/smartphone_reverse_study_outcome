package k2;

import com.stepos.stepclaw.SecurePrefs;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class i1 extends com.google.crypto.tink.shaded.protobuf.w {
    private static final i1 DEFAULT_INSTANCE;
    public static final int KEY_ID_FIELD_NUMBER = 3;
    public static final int OUTPUT_PREFIX_TYPE_FIELD_NUMBER = 4;
    private static volatile com.google.crypto.tink.shaded.protobuf.w0 PARSER = null;
    public static final int STATUS_FIELD_NUMBER = 2;
    public static final int TYPE_URL_FIELD_NUMBER = 1;
    private int keyId_;
    private int outputPrefixType_;
    private int status_;
    private String typeUrl_ = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;

    static {
        i1 i1Var = new i1();
        DEFAULT_INSTANCE = i1Var;
        com.google.crypto.tink.shaded.protobuf.w.t(i1.class, i1Var);
    }

    public static h1 B() {
        return (h1) DEFAULT_INSTANCE.h();
    }

    public static void w(i1 i1Var, String str) {
        i1Var.getClass();
        str.getClass();
        i1Var.typeUrl_ = str;
    }

    public static void x(i1 i1Var, q1 q1Var) {
        i1Var.getClass();
        i1Var.outputPrefixType_ = q1Var.b();
    }

    public static void y(i1 i1Var, y0 y0Var) {
        i1Var.getClass();
        i1Var.status_ = y0Var.a();
    }

    public static void z(i1 i1Var, int i8) {
        i1Var.keyId_ = i8;
    }

    public final int A() {
        return this.keyId_;
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
                return new com.google.crypto.tink.shaded.protobuf.a1(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"typeUrl_", "status_", "keyId_", "outputPrefixType_"});
            case 3:
                return new i1();
            case 4:
                return new h1(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                com.google.crypto.tink.shaded.protobuf.w0 w0Var = PARSER;
                if (w0Var != null) {
                    return w0Var;
                }
                synchronized (i1.class) {
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
}

package k2;

import com.stepos.stepclaw.SecurePrefs;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a1 extends com.google.crypto.tink.shaded.protobuf.w {
    private static final a1 DEFAULT_INSTANCE;
    public static final int OUTPUT_PREFIX_TYPE_FIELD_NUMBER = 3;
    private static volatile com.google.crypto.tink.shaded.protobuf.w0 PARSER = null;
    public static final int TYPE_URL_FIELD_NUMBER = 1;
    public static final int VALUE_FIELD_NUMBER = 2;
    private int outputPrefixType_;
    private String typeUrl_ = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
    private com.google.crypto.tink.shaded.protobuf.i value_ = com.google.crypto.tink.shaded.protobuf.i.f1465b;

    static {
        a1 a1Var = new a1();
        DEFAULT_INSTANCE = a1Var;
        com.google.crypto.tink.shaded.protobuf.w.t(a1.class, a1Var);
    }

    public static z0 D() {
        return (z0) DEFAULT_INSTANCE.h();
    }

    public static void w(a1 a1Var, String str) {
        a1Var.getClass();
        str.getClass();
        a1Var.typeUrl_ = str;
    }

    public static void x(a1 a1Var, com.google.crypto.tink.shaded.protobuf.h hVar) {
        a1Var.getClass();
        a1Var.value_ = hVar;
    }

    public static void y(a1 a1Var, q1 q1Var) {
        a1Var.getClass();
        a1Var.outputPrefixType_ = q1Var.b();
    }

    public static a1 z() {
        return DEFAULT_INSTANCE;
    }

    public final q1 A() {
        q1 q1VarA = q1.a(this.outputPrefixType_);
        return q1VarA == null ? q1.UNRECOGNIZED : q1VarA;
    }

    public final String B() {
        return this.typeUrl_;
    }

    public final com.google.crypto.tink.shaded.protobuf.i C() {
        return this.value_;
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
                return new com.google.crypto.tink.shaded.protobuf.a1(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"typeUrl_", "value_", "outputPrefixType_"});
            case 3:
                return new a1();
            case 4:
                return new z0(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                com.google.crypto.tink.shaded.protobuf.w0 w0Var = PARSER;
                if (w0Var != null) {
                    return w0Var;
                }
                synchronized (a1.class) {
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

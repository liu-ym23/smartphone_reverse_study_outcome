package k2;

import com.stepos.stepclaw.SecurePrefs;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class x0 extends com.google.crypto.tink.shaded.protobuf.w {
    private static final x0 DEFAULT_INSTANCE;
    public static final int KEY_MATERIAL_TYPE_FIELD_NUMBER = 3;
    private static volatile com.google.crypto.tink.shaded.protobuf.w0 PARSER = null;
    public static final int TYPE_URL_FIELD_NUMBER = 1;
    public static final int VALUE_FIELD_NUMBER = 2;
    private int keyMaterialType_;
    private String typeUrl_ = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
    private com.google.crypto.tink.shaded.protobuf.i value_ = com.google.crypto.tink.shaded.protobuf.i.f1465b;

    static {
        x0 x0Var = new x0();
        DEFAULT_INSTANCE = x0Var;
        com.google.crypto.tink.shaded.protobuf.w.t(x0.class, x0Var);
    }

    public static v0 D() {
        return (v0) DEFAULT_INSTANCE.h();
    }

    public static void w(x0 x0Var, String str) {
        x0Var.getClass();
        str.getClass();
        x0Var.typeUrl_ = str;
    }

    public static void x(x0 x0Var, com.google.crypto.tink.shaded.protobuf.h hVar) {
        x0Var.getClass();
        x0Var.value_ = hVar;
    }

    public static void y(x0 x0Var, w0 w0Var) {
        x0Var.getClass();
        if (w0Var != w0.UNRECOGNIZED) {
            x0Var.keyMaterialType_ = w0Var.f3570a;
        } else {
            w0Var.getClass();
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    public static x0 z() {
        return DEFAULT_INSTANCE;
    }

    public final w0 A() {
        int i8 = this.keyMaterialType_;
        w0 w0Var = i8 != 0 ? i8 != 1 ? i8 != 2 ? i8 != 3 ? i8 != 4 ? null : w0.REMOTE : w0.ASYMMETRIC_PUBLIC : w0.ASYMMETRIC_PRIVATE : w0.SYMMETRIC : w0.UNKNOWN_KEYMATERIAL;
        return w0Var == null ? w0.UNRECOGNIZED : w0Var;
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
                return new com.google.crypto.tink.shaded.protobuf.a1(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"typeUrl_", "value_", "keyMaterialType_"});
            case 3:
                return new x0();
            case 4:
                return new v0(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                com.google.crypto.tink.shaded.protobuf.w0 w0Var = PARSER;
                if (w0Var != null) {
                    return w0Var;
                }
                synchronized (x0.class) {
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

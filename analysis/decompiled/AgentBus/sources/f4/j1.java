package f4;

/* loaded from: classes.dex */
public final class j1 extends com.google.crypto.tink.shaded.protobuf.v {
    private static final j1 DEFAULT_INSTANCE;
    public static final int KEY_MATERIAL_TYPE_FIELD_NUMBER = 3;
    private static volatile com.google.crypto.tink.shaded.protobuf.v0 PARSER = null;
    public static final int TYPE_URL_FIELD_NUMBER = 1;
    public static final int VALUE_FIELD_NUMBER = 2;
    private int keyMaterialType_;
    private String typeUrl_ = "";
    private com.google.crypto.tink.shaded.protobuf.h value_ = com.google.crypto.tink.shaded.protobuf.h.f2209g;

    static {
        j1 j1Var = new j1();
        DEFAULT_INSTANCE = j1Var;
        com.google.crypto.tink.shaded.protobuf.v.s(j1.class, j1Var);
    }

    public static h1 C() {
        return (h1) DEFAULT_INSTANCE.g();
    }

    public static void v(j1 j1Var, String str) {
        j1Var.getClass();
        str.getClass();
        j1Var.typeUrl_ = str;
    }

    public static void w(j1 j1Var, com.google.crypto.tink.shaded.protobuf.g gVar) {
        j1Var.getClass();
        j1Var.value_ = gVar;
    }

    public static void x(j1 j1Var, i1 i1Var) {
        j1Var.getClass();
        if (i1Var != i1.UNRECOGNIZED) {
            j1Var.keyMaterialType_ = i1Var.f3426f;
        } else {
            i1Var.getClass();
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    public static j1 y() {
        return DEFAULT_INSTANCE;
    }

    public final String A() {
        return this.typeUrl_;
    }

    public final com.google.crypto.tink.shaded.protobuf.h B() {
        return this.value_;
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
                return new com.google.crypto.tink.shaded.protobuf.z0(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"typeUrl_", "value_", "keyMaterialType_"});
            case 3:
                return new j1();
            case 4:
                return new h1(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                com.google.crypto.tink.shaded.protobuf.v0 v0Var = PARSER;
                if (v0Var != null) {
                    return v0Var;
                }
                synchronized (j1.class) {
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

    public final i1 z() {
        int i2 = this.keyMaterialType_;
        i1 i1Var = i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? null : i1.REMOTE : i1.ASYMMETRIC_PUBLIC : i1.ASYMMETRIC_PRIVATE : i1.SYMMETRIC : i1.UNKNOWN_KEYMATERIAL;
        return i1Var == null ? i1.UNRECOGNIZED : i1Var;
    }
}

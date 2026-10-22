package f4;

/* loaded from: classes.dex */
public final class v1 extends com.google.crypto.tink.shaded.protobuf.v {
    private static final v1 DEFAULT_INSTANCE;
    public static final int KEY_INFO_FIELD_NUMBER = 2;
    private static volatile com.google.crypto.tink.shaded.protobuf.v0 PARSER = null;
    public static final int PRIMARY_KEY_ID_FIELD_NUMBER = 1;
    private com.google.crypto.tink.shaded.protobuf.y keyInfo_ = com.google.crypto.tink.shaded.protobuf.y0.f2293i;
    private int primaryKeyId_;

    static {
        v1 v1Var = new v1();
        DEFAULT_INSTANCE = v1Var;
        com.google.crypto.tink.shaded.protobuf.v.s(v1.class, v1Var);
    }

    public static void v(v1 v1Var, int i2) {
        v1Var.primaryKeyId_ = i2;
    }

    public static void w(v1 v1Var, u1 u1Var) {
        v1Var.getClass();
        com.google.crypto.tink.shaded.protobuf.y yVar = v1Var.keyInfo_;
        if (!((com.google.crypto.tink.shaded.protobuf.b) yVar).f2176f) {
            int size = yVar.size();
            v1Var.keyInfo_ = yVar.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
        }
        v1Var.keyInfo_.add(u1Var);
    }

    public static s1 y() {
        return (s1) DEFAULT_INSTANCE.g();
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
                return new com.google.crypto.tink.shaded.protobuf.z0(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"primaryKeyId_", "keyInfo_", u1.class});
            case 3:
                return new v1();
            case 4:
                return new s1(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                com.google.crypto.tink.shaded.protobuf.v0 v0Var = PARSER;
                if (v0Var != null) {
                    return v0Var;
                }
                synchronized (v1.class) {
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

    public final u1 x() {
        return (u1) this.keyInfo_.get(0);
    }
}

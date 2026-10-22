package f4;

import java.io.ByteArrayInputStream;

/* loaded from: classes.dex */
public final class z0 extends com.google.crypto.tink.shaded.protobuf.v {
    private static final z0 DEFAULT_INSTANCE;
    public static final int ENCRYPTED_KEYSET_FIELD_NUMBER = 2;
    public static final int KEYSET_INFO_FIELD_NUMBER = 3;
    private static volatile com.google.crypto.tink.shaded.protobuf.v0 PARSER;
    private com.google.crypto.tink.shaded.protobuf.h encryptedKeyset_ = com.google.crypto.tink.shaded.protobuf.h.f2209g;
    private v1 keysetInfo_;

    static {
        z0 z0Var = new z0();
        DEFAULT_INSTANCE = z0Var;
        com.google.crypto.tink.shaded.protobuf.v.s(z0.class, z0Var);
    }

    public static void v(z0 z0Var, com.google.crypto.tink.shaded.protobuf.g gVar) {
        z0Var.getClass();
        z0Var.encryptedKeyset_ = gVar;
    }

    public static void w(z0 z0Var, v1 v1Var) {
        z0Var.getClass();
        z0Var.keysetInfo_ = v1Var;
    }

    public static y0 y() {
        return (y0) DEFAULT_INSTANCE.g();
    }

    public static z0 z(ByteArrayInputStream byteArrayInputStream, com.google.crypto.tink.shaded.protobuf.n nVar) throws com.google.crypto.tink.shaded.protobuf.b0 {
        com.google.crypto.tink.shaded.protobuf.v vVarR = com.google.crypto.tink.shaded.protobuf.v.r(DEFAULT_INSTANCE, new com.google.crypto.tink.shaded.protobuf.j(byteArrayInputStream), nVar);
        com.google.crypto.tink.shaded.protobuf.v.f(vVarR);
        return (z0) vVarR;
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
                return new com.google.crypto.tink.shaded.protobuf.z0(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\n\u0003\t", new Object[]{"encryptedKeyset_", "keysetInfo_"});
            case 3:
                return new z0();
            case 4:
                return new y0(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                com.google.crypto.tink.shaded.protobuf.v0 v0Var = PARSER;
                if (v0Var != null) {
                    return v0Var;
                }
                synchronized (z0.class) {
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

    public final com.google.crypto.tink.shaded.protobuf.h x() {
        return this.encryptedKeyset_;
    }
}

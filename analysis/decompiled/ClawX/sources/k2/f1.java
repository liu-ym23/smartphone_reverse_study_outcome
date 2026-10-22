package k2;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class f1 extends com.google.crypto.tink.shaded.protobuf.w {
    private static final f1 DEFAULT_INSTANCE;
    public static final int KEY_FIELD_NUMBER = 2;
    private static volatile com.google.crypto.tink.shaded.protobuf.w0 PARSER = null;
    public static final int PRIMARY_KEY_ID_FIELD_NUMBER = 1;
    private com.google.crypto.tink.shaded.protobuf.z key_ = com.google.crypto.tink.shaded.protobuf.z0.d;
    private int primaryKeyId_;

    static {
        f1 f1Var = new f1();
        DEFAULT_INSTANCE = f1Var;
        com.google.crypto.tink.shaded.protobuf.w.t(f1.class, f1Var);
    }

    public static c1 C() {
        return (c1) DEFAULT_INSTANCE.h();
    }

    public static f1 D(ByteArrayInputStream byteArrayInputStream, com.google.crypto.tink.shaded.protobuf.o oVar) throws com.google.crypto.tink.shaded.protobuf.c0 {
        com.google.crypto.tink.shaded.protobuf.w wVarS = com.google.crypto.tink.shaded.protobuf.w.s(DEFAULT_INSTANCE, new com.google.crypto.tink.shaded.protobuf.k(byteArrayInputStream), oVar);
        com.google.crypto.tink.shaded.protobuf.w.g(wVarS);
        return (f1) wVarS;
    }

    public static f1 E(byte[] bArr, com.google.crypto.tink.shaded.protobuf.o oVar) {
        f1 f1Var = DEFAULT_INSTANCE;
        int length = bArr.length;
        com.google.crypto.tink.shaded.protobuf.w wVarQ = f1Var.q();
        try {
            com.google.crypto.tink.shaded.protobuf.y0 y0Var = com.google.crypto.tink.shaded.protobuf.y0.f1540c;
            y0Var.getClass();
            com.google.crypto.tink.shaded.protobuf.b1 b1VarA = y0Var.a(wVarQ.getClass());
            com.google.crypto.tink.shaded.protobuf.d dVar = new com.google.crypto.tink.shaded.protobuf.d(0);
            oVar.getClass();
            b1VarA.f(wVarQ, bArr, 0, length, dVar);
            b1VarA.b(wVarQ);
            com.google.crypto.tink.shaded.protobuf.w.g(wVarQ);
            return (f1) wVarQ;
        } catch (com.google.crypto.tink.shaded.protobuf.c0 e9) {
            if (e9.f1436a) {
                throw new com.google.crypto.tink.shaded.protobuf.c0(e9.getMessage(), e9);
            }
            throw e9;
        } catch (com.google.crypto.tink.shaded.protobuf.d1 e10) {
            throw new com.google.crypto.tink.shaded.protobuf.c0(e10.getMessage());
        } catch (IOException e11) {
            if (e11.getCause() instanceof com.google.crypto.tink.shaded.protobuf.c0) {
                throw ((com.google.crypto.tink.shaded.protobuf.c0) e11.getCause());
            }
            throw new com.google.crypto.tink.shaded.protobuf.c0(e11.getMessage(), e11);
        } catch (IndexOutOfBoundsException unused) {
            throw com.google.crypto.tink.shaded.protobuf.c0.g();
        }
    }

    public static void w(f1 f1Var, int i8) {
        f1Var.primaryKeyId_ = i8;
    }

    public static void x(f1 f1Var, e1 e1Var) {
        f1Var.getClass();
        com.google.crypto.tink.shaded.protobuf.z zVar = f1Var.key_;
        if (!((com.google.crypto.tink.shaded.protobuf.b) zVar).f1433a) {
            int size = zVar.size();
            f1Var.key_ = zVar.a(size == 0 ? 10 : size * 2);
        }
        f1Var.key_.add(e1Var);
    }

    public final List A() {
        return this.key_;
    }

    public final int B() {
        return this.primaryKeyId_;
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
                return new com.google.crypto.tink.shaded.protobuf.a1(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"primaryKeyId_", "key_", e1.class});
            case 3:
                return new f1();
            case 4:
                return new c1(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                com.google.crypto.tink.shaded.protobuf.w0 w0Var = PARSER;
                if (w0Var != null) {
                    return w0Var;
                }
                synchronized (f1.class) {
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

    public final e1 y(int i8) {
        return (e1) this.key_.get(i8);
    }

    public final int z() {
        return this.key_.size();
    }
}

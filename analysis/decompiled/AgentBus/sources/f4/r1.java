package f4;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

/* loaded from: classes.dex */
public final class r1 extends com.google.crypto.tink.shaded.protobuf.v {
    private static final r1 DEFAULT_INSTANCE;
    public static final int KEY_FIELD_NUMBER = 2;
    private static volatile com.google.crypto.tink.shaded.protobuf.v0 PARSER = null;
    public static final int PRIMARY_KEY_ID_FIELD_NUMBER = 1;
    private com.google.crypto.tink.shaded.protobuf.y key_ = com.google.crypto.tink.shaded.protobuf.y0.f2293i;
    private int primaryKeyId_;

    static {
        r1 r1Var = new r1();
        DEFAULT_INSTANCE = r1Var;
        com.google.crypto.tink.shaded.protobuf.v.s(r1.class, r1Var);
    }

    public static o1 B() {
        return (o1) DEFAULT_INSTANCE.g();
    }

    public static r1 C(ByteArrayInputStream byteArrayInputStream, com.google.crypto.tink.shaded.protobuf.n nVar) throws com.google.crypto.tink.shaded.protobuf.b0 {
        com.google.crypto.tink.shaded.protobuf.v vVarR = com.google.crypto.tink.shaded.protobuf.v.r(DEFAULT_INSTANCE, new com.google.crypto.tink.shaded.protobuf.j(byteArrayInputStream), nVar);
        com.google.crypto.tink.shaded.protobuf.v.f(vVarR);
        return (r1) vVarR;
    }

    public static r1 D(byte[] bArr, com.google.crypto.tink.shaded.protobuf.n nVar) {
        r1 r1Var = DEFAULT_INSTANCE;
        int length = bArr.length;
        com.google.crypto.tink.shaded.protobuf.v vVarP = r1Var.p();
        try {
            com.google.crypto.tink.shaded.protobuf.x0 x0Var = com.google.crypto.tink.shaded.protobuf.x0.f2290c;
            x0Var.getClass();
            com.google.crypto.tink.shaded.protobuf.a1 a1VarA = x0Var.a(vVarP.getClass());
            a7.e eVar = new a7.e(1);
            nVar.getClass();
            a1VarA.f(vVarP, bArr, 0, length, eVar);
            a1VarA.b(vVarP);
            com.google.crypto.tink.shaded.protobuf.v.f(vVarP);
            return (r1) vVarP;
        } catch (com.google.crypto.tink.shaded.protobuf.b0 e10) {
            if (e10.f2177f) {
                throw new com.google.crypto.tink.shaded.protobuf.b0(e10.getMessage(), e10);
            }
            throw e10;
        } catch (com.google.crypto.tink.shaded.protobuf.c1 e11) {
            throw new com.google.crypto.tink.shaded.protobuf.b0(e11.getMessage());
        } catch (IOException e12) {
            if (e12.getCause() instanceof com.google.crypto.tink.shaded.protobuf.b0) {
                throw ((com.google.crypto.tink.shaded.protobuf.b0) e12.getCause());
            }
            throw new com.google.crypto.tink.shaded.protobuf.b0(e12.getMessage(), e12);
        } catch (IndexOutOfBoundsException unused) {
            throw com.google.crypto.tink.shaded.protobuf.b0.g();
        }
    }

    public static void v(r1 r1Var, int i2) {
        r1Var.primaryKeyId_ = i2;
    }

    public static void w(r1 r1Var, q1 q1Var) {
        r1Var.getClass();
        com.google.crypto.tink.shaded.protobuf.y yVar = r1Var.key_;
        if (!((com.google.crypto.tink.shaded.protobuf.b) yVar).f2176f) {
            int size = yVar.size();
            r1Var.key_ = yVar.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
        }
        r1Var.key_.add(q1Var);
    }

    public final int A() {
        return this.primaryKeyId_;
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
                return new com.google.crypto.tink.shaded.protobuf.z0(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"primaryKeyId_", "key_", q1.class});
            case 3:
                return new r1();
            case 4:
                return new o1(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                com.google.crypto.tink.shaded.protobuf.v0 v0Var = PARSER;
                if (v0Var != null) {
                    return v0Var;
                }
                synchronized (r1.class) {
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

    public final q1 x(int i2) {
        return (q1) this.key_.get(i2);
    }

    public final int y() {
        return this.key_.size();
    }

    public final List z() {
        return this.key_;
    }
}

package b4;

import f4.a1;
import f4.c1;
import f4.d1;
import f4.e1;
import f4.f1;
import f4.g1;
import f4.i1;
import h4.z;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class e extends a4.e {

    /* renamed from: f, reason: collision with root package name */
    public static final a4.m f1490f = new a4.m(a.class, new b(0));

    /* renamed from: g, reason: collision with root package name */
    public static final a4.m f1491g = new a4.m(l.class, new b(2));

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f1492e = 1;

    public /* synthetic */ e(Class cls, c[] cVarArr) {
        super(cls, cVarArr);
    }

    public static a4.c l(int i2, int i10, a1 a1Var, int i11) {
        d1 d1VarA = e1.A();
        f1 f1VarA = g1.A();
        f1VarA.d();
        g1.v((g1) f1VarA.f2287g, a1Var);
        f1VarA.d();
        g1.w((g1) f1VarA.f2287g, i10);
        g1 g1Var = (g1) f1VarA.a();
        d1VarA.d();
        e1.v((e1) d1VarA.f2287g, g1Var);
        d1VarA.d();
        e1.w((e1) d1VarA.f2287g, i2);
        return new a4.c((e1) d1VarA.a(), i11);
    }

    public static void m(f4.f fVar) {
        if (fVar.x() < 10) {
            throw new GeneralSecurityException("tag size too short");
        }
        if (fVar.x() > 16) {
            throw new GeneralSecurityException("tag size too long");
        }
    }

    public static void n(g1 g1Var) {
        if (g1Var.z() < 10) {
            throw new GeneralSecurityException("tag size too small");
        }
        int iOrdinal = g1Var.y().ordinal();
        if (iOrdinal == 1) {
            if (g1Var.z() > 20) {
                throw new GeneralSecurityException("tag size too big");
            }
            return;
        }
        if (iOrdinal == 2) {
            if (g1Var.z() > 48) {
                throw new GeneralSecurityException("tag size too big");
            }
            return;
        }
        if (iOrdinal == 3) {
            if (g1Var.z() > 32) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else if (iOrdinal == 4) {
            if (g1Var.z() > 64) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else {
            if (iOrdinal != 5) {
                throw new GeneralSecurityException("unknown hash type");
            }
            if (g1Var.z() > 28) {
                throw new GeneralSecurityException("tag size too big");
            }
        }
    }

    @Override // a4.e
    public int d() {
        switch (this.f1492e) {
            case 1:
                return 2;
            default:
                return super.d();
        }
    }

    @Override // a4.e
    public final String e() {
        switch (this.f1492e) {
            case 0:
                return "type.googleapis.com/google.crypto.tink.AesCmacKey";
            default:
                return "type.googleapis.com/google.crypto.tink.HmacKey";
        }
    }

    @Override // a4.e
    public final a4.d g() {
        switch (this.f1492e) {
            case 0:
                return new d(f4.d.class);
            default:
                return new d(this);
        }
    }

    @Override // a4.e
    public final i1 h() {
        switch (this.f1492e) {
        }
        return i1.SYMMETRIC;
    }

    @Override // a4.e
    public final com.google.crypto.tink.shaded.protobuf.a i(com.google.crypto.tink.shaded.protobuf.h hVar) {
        switch (this.f1492e) {
            case 0:
                return f4.b.C(hVar, com.google.crypto.tink.shaded.protobuf.n.a());
            default:
                return c1.D(hVar, com.google.crypto.tink.shaded.protobuf.n.a());
        }
    }

    @Override // a4.e
    public final void k(com.google.crypto.tink.shaded.protobuf.a aVar) throws GeneralSecurityException {
        switch (this.f1492e) {
            case 0:
                f4.b bVar = (f4.b) aVar;
                z.c(bVar.A());
                if (bVar.y().size() != 32) {
                    throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
                }
                m(bVar.z());
                return;
            default:
                c1 c1Var = (c1) aVar;
                z.c(c1Var.B());
                if (c1Var.z().size() < 16) {
                    throw new GeneralSecurityException("key too short");
                }
                n(c1Var.A());
                return;
        }
    }

    public e() {
        super(c1.class, new c[]{new c(t3.j.class, 1)});
    }
}

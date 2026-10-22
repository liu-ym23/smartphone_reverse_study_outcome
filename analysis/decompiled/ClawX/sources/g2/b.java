package g2;

import java.security.GeneralSecurityException;
import k2.o0;
import k2.q0;
import k2.r0;
import k2.s0;
import k2.t0;
import k2.u0;
import k2.w0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b extends f2.e {

    /* renamed from: e, reason: collision with root package name */
    public static final f2.m f2914e = new f2.m(a.class, new a1.n(8));

    /* renamed from: f, reason: collision with root package name */
    public static final f2.m f2915f = new f2.m(i.class, new a1.n(10));
    public final /* synthetic */ int d = 1;

    public /* synthetic */ b(Class cls, d2.a[] aVarArr) {
        super(cls, aVarArr);
    }

    public static f2.c h(int i8, int i9, o0 o0Var, int i10) {
        r0 r0VarB = s0.B();
        t0 t0VarB = u0.B();
        t0VarB.e();
        u0.w((u0) t0VarB.f1537b, o0Var);
        t0VarB.e();
        u0.x((u0) t0VarB.f1537b, i9);
        u0 u0Var = (u0) t0VarB.b();
        r0VarB.e();
        s0.w((s0) r0VarB.f1537b, u0Var);
        r0VarB.e();
        s0.x((s0) r0VarB.f1537b, i8);
        return new f2.c((s0) r0VarB.b(), i10);
    }

    public static void i(k2.f fVar) {
        if (fVar.y() < 10) {
            throw new GeneralSecurityException("tag size too short");
        }
        if (fVar.y() > 16) {
            throw new GeneralSecurityException("tag size too long");
        }
    }

    public static void j(u0 u0Var) {
        if (u0Var.A() < 10) {
            throw new GeneralSecurityException("tag size too small");
        }
        int iOrdinal = u0Var.z().ordinal();
        if (iOrdinal == 1) {
            if (u0Var.A() > 20) {
                throw new GeneralSecurityException("tag size too big");
            }
            return;
        }
        if (iOrdinal == 2) {
            if (u0Var.A() > 48) {
                throw new GeneralSecurityException("tag size too big");
            }
            return;
        }
        if (iOrdinal == 3) {
            if (u0Var.A() > 32) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else if (iOrdinal == 4) {
            if (u0Var.A() > 64) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else {
            if (iOrdinal != 5) {
                throw new GeneralSecurityException("unknown hash type");
            }
            if (u0Var.A() > 28) {
                throw new GeneralSecurityException("tag size too big");
            }
        }
    }

    @Override // f2.e
    public int a() {
        switch (this.d) {
            case 1:
                return 2;
            default:
                return super.a();
        }
    }

    @Override // f2.e
    public final String b() {
        switch (this.d) {
            case 0:
                return "type.googleapis.com/google.crypto.tink.AesCmacKey";
            default:
                return "type.googleapis.com/google.crypto.tink.HmacKey";
        }
    }

    @Override // f2.e
    public final f2.d d() {
        switch (this.d) {
            case 0:
                return new d2.b(k2.d.class);
            default:
                return new d2.b(this);
        }
    }

    @Override // f2.e
    public final w0 e() {
        switch (this.d) {
        }
        return w0.SYMMETRIC;
    }

    @Override // f2.e
    public final com.google.crypto.tink.shaded.protobuf.a f(com.google.crypto.tink.shaded.protobuf.i iVar) {
        switch (this.d) {
            case 0:
                return k2.b.D(iVar, com.google.crypto.tink.shaded.protobuf.o.a());
            default:
                return q0.E(iVar, com.google.crypto.tink.shaded.protobuf.o.a());
        }
    }

    @Override // f2.e
    public final void g(com.google.crypto.tink.shaded.protobuf.a aVar) throws GeneralSecurityException {
        switch (this.d) {
            case 0:
                k2.b bVar = (k2.b) aVar;
                l2.o.c(bVar.B());
                if (bVar.z().size() != 32) {
                    throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
                }
                i(bVar.A());
                return;
            default:
                q0 q0Var = (q0) aVar;
                l2.o.c(q0Var.C());
                if (q0Var.A().size() < 16) {
                    throw new GeneralSecurityException("key too short");
                }
                j(q0Var.B());
                return;
        }
    }

    public b() {
        super(q0.class, new d2.a(y1.j.class, 2));
    }
}

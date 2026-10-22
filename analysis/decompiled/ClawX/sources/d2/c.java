package d2;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.util.Collections;
import java.util.HashMap;
import k2.b0;
import k2.c0;
import k2.d0;
import k2.f0;
import k2.h;
import k2.i;
import k2.j;
import k2.j0;
import k2.l;
import k2.l1;
import k2.m;
import k2.n;
import k2.o;
import k2.o0;
import k2.o1;
import k2.p;
import k2.q0;
import k2.r;
import k2.r0;
import k2.s;
import k2.s0;
import k2.t;
import k2.t0;
import k2.t1;
import k2.u;
import k2.u0;
import k2.v;
import k2.w0;
import k2.x;
import k2.y;
import k2.z;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c extends f2.e {
    public final /* synthetic */ int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(Class cls, a[] aVarArr, int i8) {
        super(cls, aVarArr);
        this.d = i8;
    }

    public static f2.c h(int i8, int i9) {
        s sVarA = t.A();
        sVarA.e();
        t.x((t) sVarA.f1537b, i8);
        u uVarZ = v.z();
        uVarZ.e();
        v.w((v) uVarZ.f1537b);
        v vVar = (v) uVarZ.b();
        sVarA.e();
        t.w((t) sVarA.f1537b, vVar);
        return new f2.c((t) sVarA.b(), i9);
    }

    public static f2.c i(int i8, int i9, int i10) {
        m mVarB = n.B();
        o oVarZ = p.z();
        oVarZ.e();
        p.w((p) oVarZ.f1537b);
        p pVar = (p) oVarZ.b();
        mVarB.e();
        n.w((n) mVarB.f1537b, pVar);
        mVarB.e();
        n.x((n) mVarB.f1537b, i8);
        n nVar = (n) mVarB.b();
        r0 r0VarB = s0.B();
        t0 t0VarB = u0.B();
        t0VarB.e();
        u0.w((u0) t0VarB.f1537b, o0.SHA256);
        t0VarB.e();
        u0.x((u0) t0VarB.f1537b, i9);
        u0 u0Var = (u0) t0VarB.b();
        r0VarB.e();
        s0.w((s0) r0VarB.f1537b, u0Var);
        r0VarB.e();
        s0.x((s0) r0VarB.f1537b, 32);
        s0 s0Var = (s0) r0VarB.b();
        i iVarA = j.A();
        iVarA.e();
        j.w((j) iVarA.f1537b, nVar);
        iVarA.e();
        j.x((j) iVarA.f1537b, s0Var);
        return new f2.c((j) iVarA.b(), i10);
    }

    public static f2.c j(int i8, int i9) {
        y yVarY = z.y();
        yVarY.e();
        z.w((z) yVarY.f1537b, i8);
        return new f2.c((z) yVarY.b(), i9);
    }

    public static f2.c k(int i8, int i9) {
        c0 c0VarY = d0.y();
        c0VarY.e();
        d0.w((d0) c0VarY.f1537b, i8);
        return new f2.c((d0) c0VarY.b(), i9);
    }

    @Override // f2.e
    public int a() {
        switch (this.d) {
            case 1:
                return 2;
            case 2:
            default:
                return super.a();
            case 3:
                return 2;
        }
    }

    @Override // f2.e
    public final String b() {
        switch (this.d) {
            case 0:
                return "type.googleapis.com/google.crypto.tink.AesSivKey";
            case 1:
                return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
            case 2:
                return "type.googleapis.com/google.crypto.tink.AesEaxKey";
            case 3:
                return "type.googleapis.com/google.crypto.tink.AesGcmKey";
            case 4:
                return "type.googleapis.com/google.crypto.tink.AesGcmSivKey";
            case 5:
                return "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key";
            case 6:
                return "type.googleapis.com/google.crypto.tink.KmsAeadKey";
            case 7:
                return "type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey";
            default:
                return "type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key";
        }
    }

    @Override // f2.e
    public final f2.d d() {
        switch (this.d) {
            case 0:
                return new b(this);
            case 1:
                return new b(this, (byte) 0);
            case 2:
                return new b(this, (char) 0);
            case 3:
                return new b(this, 0);
            case 4:
                return new b(this, (short) 0);
            case 5:
                return new b(this, (byte) 0, false);
            case 6:
                return new b(this, (byte) 0, (byte) 0);
            case 7:
                return new b(this, (byte) 0, (char) 0);
            default:
                return new b(this, (byte) 0, 0);
        }
    }

    @Override // f2.e
    public final w0 e() {
        switch (this.d) {
            case 0:
                return w0.SYMMETRIC;
            case 1:
                return w0.SYMMETRIC;
            case 2:
                return w0.SYMMETRIC;
            case 3:
                return w0.SYMMETRIC;
            case 4:
                return w0.SYMMETRIC;
            case 5:
                return w0.SYMMETRIC;
            case 6:
                return w0.REMOTE;
            case 7:
                return w0.REMOTE;
            default:
                return w0.SYMMETRIC;
        }
    }

    @Override // f2.e
    public final com.google.crypto.tink.shaded.protobuf.a f(com.google.crypto.tink.shaded.protobuf.i iVar) {
        switch (this.d) {
            case 0:
                return f0.B(iVar, com.google.crypto.tink.shaded.protobuf.o.a());
            case 1:
                return h.D(iVar, com.google.crypto.tink.shaded.protobuf.o.a());
            case 2:
                return r.D(iVar, com.google.crypto.tink.shaded.protobuf.o.a());
            case 3:
                return x.B(iVar, com.google.crypto.tink.shaded.protobuf.o.a());
            case 4:
                return b0.B(iVar, com.google.crypto.tink.shaded.protobuf.o.a());
            case 5:
                return j0.B(iVar, com.google.crypto.tink.shaded.protobuf.o.a());
            case 6:
                return l1.B(iVar, com.google.crypto.tink.shaded.protobuf.o.a());
            case 7:
                return o1.B(iVar, com.google.crypto.tink.shaded.protobuf.o.a());
            default:
                return t1.B(iVar, com.google.crypto.tink.shaded.protobuf.o.a());
        }
    }

    @Override // f2.e
    public final void g(com.google.crypto.tink.shaded.protobuf.a aVar) throws GeneralSecurityException {
        switch (this.d) {
            case 0:
                f0 f0Var = (f0) aVar;
                l2.o.c(f0Var.z());
                if (f0Var.y().size() == 64) {
                    return;
                }
                throw new InvalidKeyException("invalid key size: " + f0Var.y().size() + ". Valid keys must have 64 bytes.");
            case 1:
                h hVar = (h) aVar;
                l2.o.c(hVar.B());
                a[] aVarArr = {new a(l2.j.class, 4)};
                HashMap map = new HashMap();
                a aVar2 = aVarArr[0];
                Class cls = aVar2.f1783a;
                if (map.containsKey(cls)) {
                    throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive " + cls.getCanonicalName());
                }
                map.put(cls, aVar2);
                Class cls2 = aVarArr[0].f1783a;
                Collections.unmodifiableMap(map);
                l lVarZ = hVar.z();
                l2.o.c(lVarZ.C());
                l2.o.a(lVarZ.A().size());
                p pVarB = lVarZ.B();
                if (pVarB.y() < 12 || pVarB.y() > 16) {
                    throw new GeneralSecurityException("invalid IV size");
                }
                a[] aVarArr2 = {new a(y1.j.class, 2)};
                HashMap map2 = new HashMap();
                a aVar3 = aVarArr2[0];
                Class cls3 = aVar3.f1783a;
                if (map2.containsKey(cls3)) {
                    throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive " + cls3.getCanonicalName());
                }
                map2.put(cls3, aVar3);
                Class cls4 = aVarArr2[0].f1783a;
                Collections.unmodifiableMap(map2);
                q0 q0VarA = hVar.A();
                l2.o.c(q0VarA.C());
                if (q0VarA.A().size() < 16) {
                    throw new GeneralSecurityException("key too short");
                }
                g2.b.j(q0VarA.B());
                return;
            case 2:
                r rVar = (r) aVar;
                l2.o.c(rVar.B());
                l2.o.a(rVar.z().size());
                if (rVar.A().y() != 12 && rVar.A().y() != 16) {
                    throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
                }
                return;
            case 3:
                x xVar = (x) aVar;
                l2.o.c(xVar.z());
                l2.o.a(xVar.y().size());
                return;
            case 4:
                b0 b0Var = (b0) aVar;
                l2.o.c(b0Var.z());
                l2.o.a(b0Var.y().size());
                return;
            case 5:
                j0 j0Var = (j0) aVar;
                l2.o.c(j0Var.z());
                if (j0Var.y().size() != 32) {
                    throw new GeneralSecurityException("invalid ChaCha20Poly1305Key: incorrect key length");
                }
                return;
            case 6:
                l2.o.c(((l1) aVar).z());
                return;
            case 7:
                l2.o.c(((o1) aVar).z());
                return;
            default:
                t1 t1Var = (t1) aVar;
                l2.o.c(t1Var.z());
                if (t1Var.y().size() != 32) {
                    throw new GeneralSecurityException("invalid XChaCha20Poly1305Key: incorrect key length");
                }
                return;
        }
    }
}

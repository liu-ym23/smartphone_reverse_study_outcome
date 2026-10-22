package g4;

import com.google.crypto.tink.shaded.protobuf.h;
import f4.a0;
import f4.a1;
import f4.a2;
import f4.b0;
import f4.c1;
import f4.d0;
import f4.d1;
import f4.e0;
import f4.e1;
import f4.f0;
import f4.f1;
import f4.f2;
import f4.g0;
import f4.g1;
import f4.h0;
import f4.i;
import f4.i1;
import f4.j;
import f4.j0;
import f4.k0;
import f4.l;
import f4.l0;
import f4.m;
import f4.n;
import f4.n0;
import f4.o;
import f4.o0;
import f4.p;
import f4.p0;
import f4.r;
import f4.r0;
import f4.s;
import f4.t;
import f4.u;
import f4.v;
import f4.v0;
import f4.x;
import f4.x1;
import f4.y;
import f4.z;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.util.Collections;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class a extends a4.e {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f3838e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(Class cls, b4.c[] cVarArr, int i2) {
        super(cls, cVarArr);
        this.f3838e = i2;
    }

    public static a4.c l(int i2, int i10) {
        y yVarZ = z.z();
        yVarZ.d();
        z.w((z) yVarZ.f2287g, i2);
        a0 a0VarY = b0.y();
        a0VarY.d();
        b0.v((b0) a0VarY.f2287g);
        b0 b0Var = (b0) a0VarY.a();
        yVarZ.d();
        z.v((z) yVarZ.f2287g, b0Var);
        return new a4.c((z) yVarZ.a(), i10);
    }

    public static a4.c m(int i2, int i10, int i11) {
        s sVarA = t.A();
        u uVarY = v.y();
        uVarY.d();
        v.v((v) uVarY.f2287g);
        v vVar = (v) uVarY.a();
        sVarA.d();
        t.v((t) sVarA.f2287g, vVar);
        sVarA.d();
        t.w((t) sVarA.f2287g, i2);
        t tVar = (t) sVarA.a();
        d1 d1VarA = e1.A();
        f1 f1VarA = g1.A();
        f1VarA.d();
        g1.v((g1) f1VarA.f2287g, a1.SHA256);
        f1VarA.d();
        g1.w((g1) f1VarA.f2287g, i10);
        g1 g1Var = (g1) f1VarA.a();
        d1VarA.d();
        e1.v((e1) d1VarA.f2287g, g1Var);
        d1VarA.d();
        e1.w((e1) d1VarA.f2287g, 32);
        e1 e1Var = (e1) d1VarA.a();
        i iVarZ = j.z();
        iVarZ.d();
        j.v((j) iVarZ.f2287g, tVar);
        iVarZ.d();
        j.w((j) iVarZ.f2287g, e1Var);
        return new a4.c((j) iVarZ.a(), i11);
    }

    public static a4.c n(int i2, int i10) {
        k0 k0VarX = l0.x();
        k0VarX.d();
        l0.v((l0) k0VarX.f2287g, i2);
        return new a4.c((l0) k0VarX.a(), i10);
    }

    public static a4.c o(int i2, int i10) {
        o0 o0VarX = p0.x();
        o0VarX.d();
        p0.v((p0) o0VarX.f2287g, i2);
        return new a4.c((p0) o0VarX.a(), i10);
    }

    public static n p(int i2, int i10, int i11) {
        f1 f1VarA = g1.A();
        f1VarA.d();
        g1.v((g1) f1VarA.f2287g, a1.SHA256);
        f1VarA.d();
        g1.w((g1) f1VarA.f2287g, 32);
        g1 g1Var = (g1) f1VarA.a();
        o oVarE = p.E();
        oVarE.d();
        p.v((p) oVarE.f2287g, i11);
        oVarE.d();
        p.w((p) oVarE.f2287g, i10);
        oVarE.d();
        p.x((p) oVarE.f2287g);
        oVarE.d();
        p.y((p) oVarE.f2287g, g1Var);
        p pVar = (p) oVarE.a();
        m mVarZ = n.z();
        mVarZ.d();
        n.v((n) mVarZ.f2287g, pVar);
        mVarZ.d();
        n.w((n) mVarZ.f2287g, i2);
        return (n) mVarZ.a();
    }

    public static f0 q(int i2, int i10, int i11) {
        g0 g0VarC = h0.C();
        g0VarC.d();
        h0.v((h0) g0VarC.f2287g, i11);
        g0VarC.d();
        h0.w((h0) g0VarC.f2287g, i10);
        g0VarC.d();
        h0.x((h0) g0VarC.f2287g);
        h0 h0Var = (h0) g0VarC.a();
        e0 e0VarZ = f0.z();
        e0VarZ.d();
        f0.w((f0) e0VarZ.f2287g, i2);
        e0VarZ.d();
        f0.v((f0) e0VarZ.f2287g, h0Var);
        return (f0) e0VarZ.a();
    }

    public static void r(p pVar) throws GeneralSecurityException {
        h4.z.a(pVar.B());
        if (pVar.C() != a1.SHA1 && pVar.C() != a1.SHA256 && pVar.C() != a1.SHA512) {
            throw new GeneralSecurityException("Invalid HKDF hash type: " + pVar.C().b());
        }
        if (pVar.D().y() == a1.UNKNOWN_HASH) {
            throw new GeneralSecurityException("unknown HMAC hash type");
        }
        g1 g1VarD = pVar.D();
        if (g1VarD.z() < 10) {
            throw new GeneralSecurityException("tag size too small");
        }
        int iOrdinal = g1VarD.y().ordinal();
        if (iOrdinal != 1) {
            if (iOrdinal != 3) {
                if (iOrdinal != 4) {
                    throw new GeneralSecurityException("unknown hash type");
                }
                if (g1VarD.z() > 64) {
                    throw new GeneralSecurityException("tag size too big");
                }
            } else if (g1VarD.z() > 32) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else if (g1VarD.z() > 20) {
            throw new GeneralSecurityException("tag size too big");
        }
        if (pVar.z() < pVar.D().z() + pVar.B() + 9) {
            throw new GeneralSecurityException("ciphertext_segment_size must be at least (derived_key_size + tag_size + NONCE_PREFIX_IN_BYTES + 2)");
        }
    }

    public static void s(h0 h0Var) throws GeneralSecurityException {
        h4.z.a(h0Var.A());
        if (h0Var.B() == a1.UNKNOWN_HASH) {
            throw new GeneralSecurityException("unknown HKDF hash type");
        }
        if (h0Var.y() < h0Var.A() + 25) {
            throw new GeneralSecurityException("ciphertext_segment_size must be at least (derived_key_size + NONCE_PREFIX_IN_BYTES + TAG_SIZE_IN_BYTES + 2)");
        }
    }

    @Override // a4.e
    public int d() {
        switch (this.f3838e) {
            case 2:
                return 2;
            case 3:
            default:
                return super.d();
            case 4:
                return 2;
        }
    }

    @Override // a4.e
    public final String e() {
        switch (this.f3838e) {
            case 0:
                return "type.googleapis.com/google.crypto.tink.AesCtrHmacStreamingKey";
            case 1:
                return "type.googleapis.com/google.crypto.tink.AesGcmHkdfStreamingKey";
            case 2:
                return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
            case 3:
                return "type.googleapis.com/google.crypto.tink.AesEaxKey";
            case 4:
                return "type.googleapis.com/google.crypto.tink.AesGcmKey";
            case 5:
                return "type.googleapis.com/google.crypto.tink.AesGcmSivKey";
            case 6:
                return "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key";
            case 7:
                return "type.googleapis.com/google.crypto.tink.KmsAeadKey";
            case 8:
                return "type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey";
            case 9:
                return "type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key";
            default:
                return "type.googleapis.com/google.crypto.tink.AesSivKey";
        }
    }

    @Override // a4.e
    public final a4.d g() {
        switch (this.f3838e) {
            case 0:
                return new b4.d(this);
            case 1:
                return new b4.d(this, (byte) 0);
            case 2:
                return new b4.d(this, (char) 0);
            case 3:
                return new b4.d(this, 0);
            case 4:
                return new b4.d(this, (short) 0);
            case 5:
                return new b4.d(this, (byte) 0, false);
            case 6:
                return new b4.d(this, (byte) 0, (byte) 0);
            case 7:
                return new b4.d(this, (byte) 0, (char) 0);
            case 8:
                return new b4.d(this, (byte) 0, 0);
            case 9:
                return new b4.d(this, (byte) 0, (short) 0);
            default:
                return new b4.d(this, (char) 0, false);
        }
    }

    @Override // a4.e
    public final i1 h() {
        switch (this.f3838e) {
        }
        return i1.SYMMETRIC;
    }

    @Override // a4.e
    public final com.google.crypto.tink.shaded.protobuf.a i(h hVar) {
        switch (this.f3838e) {
            case 0:
                return l.C(hVar, com.google.crypto.tink.shaded.protobuf.n.a());
            case 1:
                return d0.C(hVar, com.google.crypto.tink.shaded.protobuf.n.a());
            case 2:
                return f4.h.C(hVar, com.google.crypto.tink.shaded.protobuf.n.a());
            case 3:
                return x.C(hVar, com.google.crypto.tink.shaded.protobuf.n.a());
            case 4:
                return j0.A(hVar, com.google.crypto.tink.shaded.protobuf.n.a());
            case 5:
                return n0.A(hVar, com.google.crypto.tink.shaded.protobuf.n.a());
            case 6:
                return v0.A(hVar, com.google.crypto.tink.shaded.protobuf.n.a());
            case 7:
                return x1.A(hVar, com.google.crypto.tink.shaded.protobuf.n.a());
            case 8:
                return a2.A(hVar, com.google.crypto.tink.shaded.protobuf.n.a());
            case 9:
                return f2.A(hVar, com.google.crypto.tink.shaded.protobuf.n.a());
            default:
                return r0.A(hVar, com.google.crypto.tink.shaded.protobuf.n.a());
        }
    }

    @Override // a4.e
    public final void k(com.google.crypto.tink.shaded.protobuf.a aVar) throws GeneralSecurityException {
        switch (this.f3838e) {
            case 0:
                l lVar = (l) aVar;
                h4.z.c(lVar.A());
                if (lVar.y().size() < 16) {
                    throw new GeneralSecurityException("key_value must have at least 16 bytes");
                }
                if (lVar.y().size() < lVar.z().B()) {
                    throw new GeneralSecurityException("key_value must have at least as many bits as derived keys");
                }
                r(lVar.z());
                return;
            case 1:
                d0 d0Var = (d0) aVar;
                h4.z.c(d0Var.A());
                s(d0Var.z());
                return;
            case 2:
                f4.h hVar = (f4.h) aVar;
                h4.z.c(hVar.A());
                b4.c[] cVarArr = {new b4.c(h4.p.class, 5)};
                HashMap map = new HashMap();
                b4.c cVar = cVarArr[0];
                Class cls = cVar.f1487a;
                if (map.containsKey(cls)) {
                    throw new IllegalArgumentException(m.x.j(cls, new StringBuilder("KeyTypeManager constructed with duplicate factories for primitive ")));
                }
                map.put(cls, cVar);
                Class cls2 = cVarArr[0].f1487a;
                Collections.unmodifiableMap(map);
                r rVarY = hVar.y();
                h4.z.c(rVarY.B());
                h4.z.a(rVarY.z().size());
                v vVarA = rVarY.A();
                if (vVarA.x() < 12 || vVarA.x() > 16) {
                    throw new GeneralSecurityException("invalid IV size");
                }
                b4.c[] cVarArr2 = {new b4.c(t3.j.class, 1)};
                HashMap map2 = new HashMap();
                b4.c cVar2 = cVarArr2[0];
                Class cls3 = cVar2.f1487a;
                if (map2.containsKey(cls3)) {
                    throw new IllegalArgumentException(m.x.j(cls3, new StringBuilder("KeyTypeManager constructed with duplicate factories for primitive ")));
                }
                map2.put(cls3, cVar2);
                Class cls4 = cVarArr2[0].f1487a;
                Collections.unmodifiableMap(map2);
                c1 c1VarZ = hVar.z();
                h4.z.c(c1VarZ.B());
                if (c1VarZ.z().size() < 16) {
                    throw new GeneralSecurityException("key too short");
                }
                b4.e.n(c1VarZ.A());
                return;
            case 3:
                x xVar = (x) aVar;
                h4.z.c(xVar.A());
                h4.z.a(xVar.y().size());
                if (xVar.z().x() != 12 && xVar.z().x() != 16) {
                    throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
                }
                return;
            case 4:
                j0 j0Var = (j0) aVar;
                h4.z.c(j0Var.y());
                h4.z.a(j0Var.x().size());
                return;
            case 5:
                n0 n0Var = (n0) aVar;
                h4.z.c(n0Var.y());
                h4.z.a(n0Var.x().size());
                return;
            case 6:
                v0 v0Var = (v0) aVar;
                h4.z.c(v0Var.y());
                if (v0Var.x().size() != 32) {
                    throw new GeneralSecurityException("invalid ChaCha20Poly1305Key: incorrect key length");
                }
                return;
            case 7:
                h4.z.c(((x1) aVar).y());
                return;
            case 8:
                h4.z.c(((a2) aVar).y());
                return;
            case 9:
                f2 f2Var = (f2) aVar;
                h4.z.c(f2Var.y());
                if (f2Var.x().size() != 32) {
                    throw new GeneralSecurityException("invalid XChaCha20Poly1305Key: incorrect key length");
                }
                return;
            default:
                r0 r0Var = (r0) aVar;
                h4.z.c(r0Var.y());
                if (r0Var.x().size() == 64) {
                    return;
                }
                throw new InvalidKeyException("invalid key size: " + r0Var.x().size() + ". Valid keys must have 64 bytes.");
        }
    }
}

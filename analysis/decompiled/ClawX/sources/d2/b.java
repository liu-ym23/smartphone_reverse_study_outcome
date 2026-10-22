package d2;

import com.google.crypto.tink.shaded.protobuf.h;
import com.google.crypto.tink.shaded.protobuf.i;
import com.google.crypto.tink.shaded.protobuf.o;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import k2.a0;
import k2.b0;
import k2.d0;
import k2.e0;
import k2.f0;
import k2.g;
import k2.g0;
import k2.h0;
import k2.i0;
import k2.j;
import k2.j0;
import k2.k;
import k2.k1;
import k2.l;
import k2.l0;
import k2.l1;
import k2.m1;
import k2.n1;
import k2.o0;
import k2.o1;
import k2.p;
import k2.p0;
import k2.p1;
import k2.q;
import k2.q0;
import k2.r;
import k2.s0;
import k2.s1;
import k2.t;
import k2.t1;
import k2.u0;
import k2.u1;
import k2.v;
import k2.w;
import k2.x;
import k2.z;
import l2.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b extends f2.d {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f1785b = 0;

    public /* synthetic */ b(Class cls) {
        super(cls);
    }

    @Override // f2.d
    public final com.google.crypto.tink.shaded.protobuf.a d(com.google.crypto.tink.shaded.protobuf.a aVar) {
        switch (this.f1785b) {
            case 0:
                e0 e0VarA = f0.A();
                byte[] bArrA = n.a(((h0) aVar).x());
                h hVarH = i.h(0, bArrA.length, bArrA);
                e0VarA.e();
                f0.x((f0) e0VarA.f1537b, hVarH);
                e0VarA.e();
                f0.w((f0) e0VarA.f1537b);
                return (f0) e0VarA.b();
            case 1:
                k2.d dVar = (k2.d) aVar;
                k2.a aVarC = k2.b.C();
                aVarC.e();
                k2.b.w((k2.b) aVarC.f1537b);
                byte[] bArrA2 = n.a(dVar.y());
                h hVarH2 = i.h(0, bArrA2.length, bArrA2);
                aVarC.e();
                k2.b.x((k2.b) aVarC.f1537b, hVarH2);
                k2.f fVarZ = dVar.z();
                aVarC.e();
                k2.b.y((k2.b) aVarC.f1537b, fVarZ);
                return (k2.b) aVarC.b();
            case 2:
                s0 s0Var = (s0) aVar;
                p0 p0VarD = q0.D();
                p0VarD.e();
                q0.w((q0) p0VarD.f1537b);
                u0 u0VarA = s0Var.A();
                p0VarD.e();
                q0.x((q0) p0VarD.f1537b, u0VarA);
                byte[] bArrA3 = n.a(s0Var.z());
                h hVarH3 = i.h(0, bArrA3.length, bArrA3);
                p0VarD.e();
                q0.y((q0) p0VarD.f1537b, hVarH3);
                return (q0) p0VarD.b();
            case 3:
                j jVar = (j) aVar;
                a[] aVarArr = {new a(l2.j.class, 4)};
                HashMap map = new HashMap();
                for (a aVar2 : aVarArr) {
                    Class cls = aVar2.f1783a;
                    if (map.containsKey(cls)) {
                        throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive " + cls.getCanonicalName());
                    }
                    map.put(cls, aVar2);
                }
                if (aVarArr.length > 0) {
                    Class cls2 = aVarArr[0].f1783a;
                }
                Collections.unmodifiableMap(map);
                k2.n nVarY = jVar.y();
                k kVarD = l.D();
                p pVarA = nVarY.A();
                kVarD.e();
                l.x((l) kVarD.f1537b, pVarA);
                byte[] bArrA4 = n.a(nVarY.z());
                h hVarH4 = i.h(0, bArrA4.length, bArrA4);
                kVarD.e();
                l.y((l) kVarD.f1537b, hVarH4);
                kVarD.e();
                l.w((l) kVarD.f1537b);
                l lVar = (l) kVarD.b();
                a[] aVarArr2 = {new a(y1.j.class, 2)};
                HashMap map2 = new HashMap();
                for (a aVar3 : aVarArr2) {
                    Class cls3 = aVar3.f1783a;
                    if (map2.containsKey(cls3)) {
                        throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive " + cls3.getCanonicalName());
                    }
                    map2.put(cls3, aVar3);
                }
                if (aVarArr2.length > 0) {
                    Class cls4 = aVarArr2[0].f1783a;
                }
                Collections.unmodifiableMap(map2);
                s0 s0VarZ = jVar.z();
                p0 p0VarD2 = q0.D();
                p0VarD2.e();
                q0.w((q0) p0VarD2.f1537b);
                u0 u0VarA2 = s0VarZ.A();
                p0VarD2.e();
                q0.x((q0) p0VarD2.f1537b, u0VarA2);
                byte[] bArrA5 = n.a(s0VarZ.z());
                h hVarH5 = i.h(0, bArrA5.length, bArrA5);
                p0VarD2.e();
                q0.y((q0) p0VarD2.f1537b, hVarH5);
                q0 q0Var = (q0) p0VarD2.b();
                g gVarC = k2.h.C();
                gVarC.e();
                k2.h.x((k2.h) gVarC.f1537b, lVar);
                gVarC.e();
                k2.h.y((k2.h) gVarC.f1537b, q0Var);
                gVarC.e();
                k2.h.w((k2.h) gVarC.f1537b);
                return (k2.h) gVarC.b();
            case 4:
                t tVar = (t) aVar;
                q qVarC = r.C();
                byte[] bArrA6 = n.a(tVar.y());
                h hVarH6 = i.h(0, bArrA6.length, bArrA6);
                qVarC.e();
                r.y((r) qVarC.f1537b, hVarH6);
                v vVarZ = tVar.z();
                qVarC.e();
                r.x((r) qVarC.f1537b, vVarZ);
                qVarC.e();
                r.w((r) qVarC.f1537b);
                return (r) qVarC.b();
            case 5:
                w wVarA = x.A();
                byte[] bArrA7 = n.a(((z) aVar).x());
                h hVarH7 = i.h(0, bArrA7.length, bArrA7);
                wVarA.e();
                x.x((x) wVarA.f1537b, hVarH7);
                wVarA.e();
                x.w((x) wVarA.f1537b);
                return (x) wVarA.b();
            case 6:
                a0 a0VarA = b0.A();
                byte[] bArrA8 = n.a(((d0) aVar).x());
                h hVarH8 = i.h(0, bArrA8.length, bArrA8);
                a0VarA.e();
                b0.x((b0) a0VarA.f1537b, hVarH8);
                a0VarA.e();
                b0.w((b0) a0VarA.f1537b);
                return (b0) a0VarA.b();
            case 7:
                i0 i0VarA = j0.A();
                i0VarA.e();
                j0.w((j0) i0VarA.f1537b);
                byte[] bArrA9 = n.a(32);
                h hVarH9 = i.h(0, bArrA9.length, bArrA9);
                i0VarA.e();
                j0.x((j0) i0VarA.f1537b, hVarH9);
                return (j0) i0VarA.b();
            case 8:
                k1 k1VarA = l1.A();
                k1VarA.e();
                l1.x((l1) k1VarA.f1537b, (m1) aVar);
                k1VarA.e();
                l1.w((l1) k1VarA.f1537b);
                return (l1) k1VarA.b();
            case 9:
                n1 n1VarA = o1.A();
                n1VarA.e();
                o1.x((o1) n1VarA.f1537b, (p1) aVar);
                n1VarA.e();
                o1.w((o1) n1VarA.f1537b);
                return (o1) n1VarA.b();
            default:
                s1 s1VarA = t1.A();
                s1VarA.e();
                t1.w((t1) s1VarA.f1537b);
                byte[] bArrA10 = n.a(32);
                h hVarH10 = i.h(0, bArrA10.length, bArrA10);
                s1VarA.e();
                t1.x((t1) s1VarA.f1537b, hVarH10);
                return (t1) s1VarA.b();
        }
    }

    @Override // f2.d
    public Map h() {
        switch (this.f1785b) {
            case 0:
                HashMap map = new HashMap();
                g0 g0VarY = h0.y();
                g0VarY.e();
                h0.w((h0) g0VarY.f1537b);
                map.put("AES256_SIV", new f2.c((h0) g0VarY.b(), 1));
                g0 g0VarY2 = h0.y();
                g0VarY2.e();
                h0.w((h0) g0VarY2.f1537b);
                map.put("AES256_SIV_RAW", new f2.c((h0) g0VarY2.b(), 3));
                return Collections.unmodifiableMap(map);
            case 1:
                HashMap map2 = new HashMap();
                k2.c cVarA = k2.d.A();
                cVarA.e();
                k2.d.w((k2.d) cVarA.f1537b);
                k2.e eVarZ = k2.f.z();
                eVarZ.e();
                k2.f.w((k2.f) eVarZ.f1537b);
                k2.f fVar = (k2.f) eVarZ.b();
                cVarA.e();
                k2.d.x((k2.d) cVarA.f1537b, fVar);
                map2.put("AES_CMAC", new f2.c((k2.d) cVarA.b(), 1));
                k2.c cVarA2 = k2.d.A();
                cVarA2.e();
                k2.d.w((k2.d) cVarA2.f1537b);
                k2.e eVarZ2 = k2.f.z();
                eVarZ2.e();
                k2.f.w((k2.f) eVarZ2.f1537b);
                k2.f fVar2 = (k2.f) eVarZ2.b();
                cVarA2.e();
                k2.d.x((k2.d) cVarA2.f1537b, fVar2);
                map2.put("AES256_CMAC", new f2.c((k2.d) cVarA2.b(), 1));
                k2.c cVarA3 = k2.d.A();
                cVarA3.e();
                k2.d.w((k2.d) cVarA3.f1537b);
                k2.e eVarZ3 = k2.f.z();
                eVarZ3.e();
                k2.f.w((k2.f) eVarZ3.f1537b);
                k2.f fVar3 = (k2.f) eVarZ3.b();
                cVarA3.e();
                k2.d.x((k2.d) cVarA3.f1537b, fVar3);
                map2.put("AES256_CMAC_RAW", new f2.c((k2.d) cVarA3.b(), 3));
                return Collections.unmodifiableMap(map2);
            case 2:
                HashMap map3 = new HashMap();
                o0 o0Var = o0.SHA256;
                map3.put("HMAC_SHA256_128BITTAG", g2.b.h(32, 16, o0Var, 1));
                map3.put("HMAC_SHA256_128BITTAG_RAW", g2.b.h(32, 16, o0Var, 3));
                map3.put("HMAC_SHA256_256BITTAG", g2.b.h(32, 32, o0Var, 1));
                map3.put("HMAC_SHA256_256BITTAG_RAW", g2.b.h(32, 32, o0Var, 3));
                o0 o0Var2 = o0.SHA512;
                map3.put("HMAC_SHA512_128BITTAG", g2.b.h(64, 16, o0Var2, 1));
                map3.put("HMAC_SHA512_128BITTAG_RAW", g2.b.h(64, 16, o0Var2, 3));
                map3.put("HMAC_SHA512_256BITTAG", g2.b.h(64, 32, o0Var2, 1));
                map3.put("HMAC_SHA512_256BITTAG_RAW", g2.b.h(64, 32, o0Var2, 3));
                map3.put("HMAC_SHA512_512BITTAG", g2.b.h(64, 64, o0Var2, 1));
                map3.put("HMAC_SHA512_512BITTAG_RAW", g2.b.h(64, 64, o0Var2, 3));
                return Collections.unmodifiableMap(map3);
            case 3:
                HashMap map4 = new HashMap();
                map4.put("AES128_CTR_HMAC_SHA256", c.i(16, 16, 1));
                map4.put("AES128_CTR_HMAC_SHA256_RAW", c.i(16, 16, 3));
                map4.put("AES256_CTR_HMAC_SHA256", c.i(32, 32, 1));
                map4.put("AES256_CTR_HMAC_SHA256_RAW", c.i(32, 32, 3));
                return Collections.unmodifiableMap(map4);
            case 4:
                HashMap map5 = new HashMap();
                map5.put("AES128_EAX", c.h(16, 1));
                map5.put("AES128_EAX_RAW", c.h(16, 3));
                map5.put("AES256_EAX", c.h(32, 1));
                map5.put("AES256_EAX_RAW", c.h(32, 3));
                return Collections.unmodifiableMap(map5);
            case 5:
                HashMap map6 = new HashMap();
                map6.put("AES128_GCM", c.j(16, 1));
                map6.put("AES128_GCM_RAW", c.j(16, 3));
                map6.put("AES256_GCM", c.j(32, 1));
                map6.put("AES256_GCM_RAW", c.j(32, 3));
                return Collections.unmodifiableMap(map6);
            case 6:
                HashMap map7 = new HashMap();
                map7.put("AES128_GCM_SIV", c.k(16, 1));
                map7.put("AES128_GCM_SIV_RAW", c.k(16, 3));
                map7.put("AES256_GCM_SIV", c.k(32, 1));
                map7.put("AES256_GCM_SIV_RAW", c.k(32, 3));
                return Collections.unmodifiableMap(map7);
            case 7:
                HashMap map8 = new HashMap();
                map8.put("CHACHA20_POLY1305", new f2.c(l0.w(), 1));
                map8.put("CHACHA20_POLY1305_RAW", new f2.c(l0.w(), 3));
                return Collections.unmodifiableMap(map8);
            case 8:
            case 9:
            default:
                return super.h();
            case 10:
                HashMap map9 = new HashMap();
                map9.put("XCHACHA20_POLY1305", new f2.c(u1.w(), 1));
                map9.put("XCHACHA20_POLY1305_RAW", new f2.c(u1.w(), 3));
                return Collections.unmodifiableMap(map9);
        }
    }

    @Override // f2.d
    public final com.google.crypto.tink.shaded.protobuf.a i(i iVar) {
        switch (this.f1785b) {
            case 0:
                return h0.z(iVar, o.a());
            case 1:
                return k2.d.B(iVar, o.a());
            case 2:
                return s0.C(iVar, o.a());
            case 3:
                return j.B(iVar, o.a());
            case 4:
                return t.B(iVar, o.a());
            case 5:
                return z.z(iVar, o.a());
            case 6:
                return d0.z(iVar, o.a());
            case 7:
                return l0.x(iVar, o.a());
            case 8:
                return m1.y(iVar, o.a());
            case 9:
                return p1.A(iVar, o.a());
            default:
                return u1.x(iVar, o.a());
        }
    }

    @Override // f2.d
    public final void k(com.google.crypto.tink.shaded.protobuf.a aVar) throws GeneralSecurityException {
        switch (this.f1785b) {
            case 0:
                h0 h0Var = (h0) aVar;
                if (h0Var.x() == 64) {
                    return;
                }
                throw new InvalidAlgorithmParameterException("invalid key size: " + h0Var.x() + ". Valid keys must have 64 bytes.");
            case 1:
                k2.d dVar = (k2.d) aVar;
                g2.b.i(dVar.z());
                if (dVar.y() != 32) {
                    throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
                }
                return;
            case 2:
                s0 s0Var = (s0) aVar;
                if (s0Var.z() < 16) {
                    throw new GeneralSecurityException("key too short");
                }
                g2.b.j(s0Var.A());
                return;
            case 3:
                j jVar = (j) aVar;
                a[] aVarArr = {new a(l2.j.class, 4)};
                HashMap map = new HashMap();
                for (a aVar2 : aVarArr) {
                    Class cls = aVar2.f1783a;
                    if (map.containsKey(cls)) {
                        throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive " + cls.getCanonicalName());
                    }
                    map.put(cls, aVar2);
                }
                if (aVarArr.length > 0) {
                    Class cls2 = aVarArr[0].f1783a;
                }
                Collections.unmodifiableMap(map);
                k2.n nVarY = jVar.y();
                l2.o.a(nVarY.z());
                p pVarA = nVarY.A();
                if (pVarA.y() < 12 || pVarA.y() > 16) {
                    throw new GeneralSecurityException("invalid IV size");
                }
                a[] aVarArr2 = {new a(y1.j.class, 2)};
                HashMap map2 = new HashMap();
                for (a aVar3 : aVarArr2) {
                    Class cls3 = aVar3.f1783a;
                    if (map2.containsKey(cls3)) {
                        throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive " + cls3.getCanonicalName());
                    }
                    map2.put(cls3, aVar3);
                }
                if (aVarArr2.length > 0) {
                    Class cls4 = aVarArr2[0].f1783a;
                }
                Collections.unmodifiableMap(map2);
                s0 s0VarZ = jVar.z();
                if (s0VarZ.z() < 16) {
                    throw new GeneralSecurityException("key too short");
                }
                g2.b.j(s0VarZ.A());
                l2.o.a(jVar.y().z());
                return;
            case 4:
                t tVar = (t) aVar;
                l2.o.a(tVar.y());
                if (tVar.z().y() != 12 && tVar.z().y() != 16) {
                    throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
                }
                return;
            case 5:
                l2.o.a(((z) aVar).x());
                return;
            case 6:
                l2.o.a(((d0) aVar).x());
                return;
            case 7:
                return;
            case 8:
                return;
            case 9:
                p1 p1Var = (p1) aVar;
                if (p1Var.y().isEmpty() || !p1Var.z()) {
                    throw new GeneralSecurityException("invalid key format: missing KEK URI or DEK template");
                }
                return;
            default:
                return;
        }
    }

    public b(c cVar, byte b9, byte b10) {
        super(m1.class);
    }

    public b(c cVar, byte b9, char c3) {
        super(p1.class);
    }

    public b(c cVar, int i8) {
        super(z.class);
    }

    public b(c cVar, byte b9, boolean z) {
        super(l0.class);
    }

    public b(c cVar, char c3) {
        super(t.class);
    }

    public b(c cVar, short s8) {
        super(d0.class);
    }

    public b(c cVar, byte b9, int i8) {
        super(u1.class);
    }

    public b(c cVar) {
        super(h0.class);
    }

    public b(c cVar, byte b9) {
        super(j.class);
    }

    public b(g2.b bVar) {
        super(s0.class);
    }
}

package b4;

import f4.a1;
import f4.a2;
import f4.b0;
import f4.b1;
import f4.b2;
import f4.c0;
import f4.c1;
import f4.d0;
import f4.e1;
import f4.e2;
import f4.f0;
import f4.f2;
import f4.g1;
import f4.g2;
import f4.h0;
import f4.i0;
import f4.j0;
import f4.l0;
import f4.m0;
import f4.n0;
import f4.p0;
import f4.q0;
import f4.r0;
import f4.s0;
import f4.t;
import f4.t0;
import f4.u0;
import f4.v;
import f4.v0;
import f4.w;
import f4.w1;
import f4.x0;
import f4.x1;
import f4.y1;
import f4.z;
import f4.z1;
import h4.u;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import m.x;

/* loaded from: classes.dex */
public final class d extends a4.d {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f1489g = 1;

    public /* synthetic */ d(Class cls) {
        super(cls);
    }

    @Override // a4.d
    public final com.google.crypto.tink.shaded.protobuf.a C0(com.google.crypto.tink.shaded.protobuf.h hVar) {
        switch (this.f1489g) {
            case 0:
                return f4.d.A(hVar, com.google.crypto.tink.shaded.protobuf.n.a());
            case 1:
                return e1.B(hVar, com.google.crypto.tink.shaded.protobuf.n.a());
            case 2:
                return f4.n.A(hVar, com.google.crypto.tink.shaded.protobuf.n.a());
            case 3:
                return f0.A(hVar, com.google.crypto.tink.shaded.protobuf.n.a());
            case 4:
                return f4.j.A(hVar, com.google.crypto.tink.shaded.protobuf.n.a());
            case 5:
                return z.A(hVar, com.google.crypto.tink.shaded.protobuf.n.a());
            case 6:
                return l0.y(hVar, com.google.crypto.tink.shaded.protobuf.n.a());
            case 7:
                return p0.y(hVar, com.google.crypto.tink.shaded.protobuf.n.a());
            case 8:
                return x0.w(hVar, com.google.crypto.tink.shaded.protobuf.n.a());
            case 9:
                return y1.x(hVar, com.google.crypto.tink.shaded.protobuf.n.a());
            case 10:
                return b2.z(hVar, com.google.crypto.tink.shaded.protobuf.n.a());
            case 11:
                return g2.w(hVar, com.google.crypto.tink.shaded.protobuf.n.a());
            default:
                return t0.y(hVar, com.google.crypto.tink.shaded.protobuf.n.a());
        }
    }

    @Override // a4.d
    public final void D0(com.google.crypto.tink.shaded.protobuf.a aVar) throws GeneralSecurityException {
        switch (this.f1489g) {
            case 0:
                f4.d dVar = (f4.d) aVar;
                e.m(dVar.y());
                if (dVar.x() != 32) {
                    throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
                }
                return;
            case 1:
                e1 e1Var = (e1) aVar;
                if (e1Var.y() < 16) {
                    throw new GeneralSecurityException("key too short");
                }
                e.n(e1Var.z());
                return;
            case 2:
                f4.n nVar = (f4.n) aVar;
                if (nVar.x() < 16) {
                    throw new GeneralSecurityException("key_size must be at least 16 bytes");
                }
                g4.a.r(nVar.y());
                return;
            case 3:
                f0 f0Var = (f0) aVar;
                if (f0Var.x() < 16) {
                    throw new GeneralSecurityException("key_size must be at least 16 bytes");
                }
                g4.a.s(f0Var.y());
                return;
            case 4:
                f4.j jVar = (f4.j) aVar;
                c[] cVarArr = {new c(h4.p.class, 5)};
                HashMap map = new HashMap();
                for (c cVar : cVarArr) {
                    Class cls = cVar.f1487a;
                    if (map.containsKey(cls)) {
                        throw new IllegalArgumentException(x.j(cls, new StringBuilder("KeyTypeManager constructed with duplicate factories for primitive ")));
                    }
                    map.put(cls, cVar);
                }
                if (cVarArr.length > 0) {
                    Class cls2 = cVarArr[0].f1487a;
                }
                Collections.unmodifiableMap(map);
                t tVarX = jVar.x();
                h4.z.a(tVarX.y());
                v vVarZ = tVarX.z();
                if (vVarZ.x() < 12 || vVarZ.x() > 16) {
                    throw new GeneralSecurityException("invalid IV size");
                }
                c[] cVarArr2 = {new c(t3.j.class, 1)};
                HashMap map2 = new HashMap();
                for (c cVar2 : cVarArr2) {
                    Class cls3 = cVar2.f1487a;
                    if (map2.containsKey(cls3)) {
                        throw new IllegalArgumentException(x.j(cls3, new StringBuilder("KeyTypeManager constructed with duplicate factories for primitive ")));
                    }
                    map2.put(cls3, cVar2);
                }
                if (cVarArr2.length > 0) {
                    Class cls4 = cVarArr2[0].f1487a;
                }
                Collections.unmodifiableMap(map2);
                e1 e1VarY = jVar.y();
                if (e1VarY.y() < 16) {
                    throw new GeneralSecurityException("key too short");
                }
                e.n(e1VarY.z());
                h4.z.a(jVar.x().y());
                return;
            case 5:
                z zVar = (z) aVar;
                h4.z.a(zVar.x());
                if (zVar.y().x() != 12 && zVar.y().x() != 16) {
                    throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
                }
                return;
            case 6:
                h4.z.a(((l0) aVar).w());
                return;
            case 7:
                h4.z.a(((p0) aVar).w());
                return;
            case 8:
                return;
            case 9:
                return;
            case 10:
                b2 b2Var = (b2) aVar;
                if (b2Var.x().isEmpty() || !b2Var.y()) {
                    throw new GeneralSecurityException("invalid key format: missing KEK URI or DEK template");
                }
                return;
            case 11:
                return;
            default:
                t0 t0Var = (t0) aVar;
                if (t0Var.w() == 64) {
                    return;
                }
                throw new InvalidAlgorithmParameterException("invalid key size: " + t0Var.w() + ". Valid keys must have 64 bytes.");
        }
    }

    @Override // a4.d
    public final com.google.crypto.tink.shaded.protobuf.a j0(com.google.crypto.tink.shaded.protobuf.a aVar) {
        switch (this.f1489g) {
            case 0:
                f4.d dVar = (f4.d) aVar;
                f4.a aVarB = f4.b.B();
                aVarB.d();
                f4.b.v((f4.b) aVarB.f2287g);
                byte[] bArrA = u.a(dVar.x());
                com.google.crypto.tink.shaded.protobuf.g gVarH = com.google.crypto.tink.shaded.protobuf.h.h(bArrA, 0, bArrA.length);
                aVarB.d();
                f4.b.w((f4.b) aVarB.f2287g, gVarH);
                f4.f fVarY = dVar.y();
                aVarB.d();
                f4.b.x((f4.b) aVarB.f2287g, fVarY);
                return (f4.b) aVarB.a();
            case 1:
                e1 e1Var = (e1) aVar;
                b1 b1VarC = c1.C();
                b1VarC.d();
                c1.v((c1) b1VarC.f2287g);
                g1 g1VarZ = e1Var.z();
                b1VarC.d();
                c1.w((c1) b1VarC.f2287g, g1VarZ);
                byte[] bArrA2 = u.a(e1Var.y());
                com.google.crypto.tink.shaded.protobuf.g gVarH2 = com.google.crypto.tink.shaded.protobuf.h.h(bArrA2, 0, bArrA2.length);
                b1VarC.d();
                c1.x((c1) b1VarC.f2287g, gVarH2);
                return (c1) b1VarC.a();
            case 2:
                f4.n nVar = (f4.n) aVar;
                f4.k kVarB = f4.l.B();
                byte[] bArrA3 = u.a(nVar.x());
                com.google.crypto.tink.shaded.protobuf.g gVarH3 = com.google.crypto.tink.shaded.protobuf.h.h(bArrA3, 0, bArrA3.length);
                kVarB.d();
                f4.l.x((f4.l) kVarB.f2287g, gVarH3);
                f4.p pVarY = nVar.y();
                kVarB.d();
                f4.l.w((f4.l) kVarB.f2287g, pVarY);
                kVarB.d();
                f4.l.v((f4.l) kVarB.f2287g);
                return (f4.l) kVarB.a();
            case 3:
                f0 f0Var = (f0) aVar;
                c0 c0VarB = d0.B();
                byte[] bArrA4 = u.a(f0Var.x());
                com.google.crypto.tink.shaded.protobuf.g gVarH4 = com.google.crypto.tink.shaded.protobuf.h.h(bArrA4, 0, bArrA4.length);
                c0VarB.d();
                d0.x((d0) c0VarB.f2287g, gVarH4);
                h0 h0VarY = f0Var.y();
                c0VarB.d();
                d0.w((d0) c0VarB.f2287g, h0VarY);
                c0VarB.d();
                d0.v((d0) c0VarB.f2287g);
                return (d0) c0VarB.a();
            case 4:
                f4.j jVar = (f4.j) aVar;
                c[] cVarArr = {new c(h4.p.class, 5)};
                HashMap map = new HashMap();
                for (c cVar : cVarArr) {
                    Class cls = cVar.f1487a;
                    if (map.containsKey(cls)) {
                        throw new IllegalArgumentException(x.j(cls, new StringBuilder("KeyTypeManager constructed with duplicate factories for primitive ")));
                    }
                    map.put(cls, cVar);
                }
                if (cVarArr.length > 0) {
                    Class cls2 = cVarArr[0].f1487a;
                }
                Collections.unmodifiableMap(map);
                t tVarX = jVar.x();
                f4.q qVarC = f4.r.C();
                v vVarZ = tVarX.z();
                qVarC.d();
                f4.r.w((f4.r) qVarC.f2287g, vVarZ);
                byte[] bArrA5 = u.a(tVarX.y());
                com.google.crypto.tink.shaded.protobuf.g gVarH5 = com.google.crypto.tink.shaded.protobuf.h.h(bArrA5, 0, bArrA5.length);
                qVarC.d();
                f4.r.x((f4.r) qVarC.f2287g, gVarH5);
                qVarC.d();
                f4.r.v((f4.r) qVarC.f2287g);
                f4.r rVar = (f4.r) qVarC.a();
                c[] cVarArr2 = {new c(t3.j.class, 1)};
                HashMap map2 = new HashMap();
                for (c cVar2 : cVarArr2) {
                    Class cls3 = cVar2.f1487a;
                    if (map2.containsKey(cls3)) {
                        throw new IllegalArgumentException(x.j(cls3, new StringBuilder("KeyTypeManager constructed with duplicate factories for primitive ")));
                    }
                    map2.put(cls3, cVar2);
                }
                if (cVarArr2.length > 0) {
                    Class cls4 = cVarArr2[0].f1487a;
                }
                Collections.unmodifiableMap(map2);
                e1 e1VarY = jVar.y();
                b1 b1VarC2 = c1.C();
                b1VarC2.d();
                c1.v((c1) b1VarC2.f2287g);
                g1 g1VarZ2 = e1VarY.z();
                b1VarC2.d();
                c1.w((c1) b1VarC2.f2287g, g1VarZ2);
                byte[] bArrA6 = u.a(e1VarY.y());
                com.google.crypto.tink.shaded.protobuf.g gVarH6 = com.google.crypto.tink.shaded.protobuf.h.h(bArrA6, 0, bArrA6.length);
                b1VarC2.d();
                c1.x((c1) b1VarC2.f2287g, gVarH6);
                c1 c1Var = (c1) b1VarC2.a();
                f4.g gVarB = f4.h.B();
                gVarB.d();
                f4.h.w((f4.h) gVarB.f2287g, rVar);
                gVarB.d();
                f4.h.x((f4.h) gVarB.f2287g, c1Var);
                gVarB.d();
                f4.h.v((f4.h) gVarB.f2287g);
                return (f4.h) gVarB.a();
            case 5:
                z zVar = (z) aVar;
                w wVarB = f4.x.B();
                byte[] bArrA7 = u.a(zVar.x());
                com.google.crypto.tink.shaded.protobuf.g gVarH7 = com.google.crypto.tink.shaded.protobuf.h.h(bArrA7, 0, bArrA7.length);
                wVarB.d();
                f4.x.x((f4.x) wVarB.f2287g, gVarH7);
                b0 b0VarY = zVar.y();
                wVarB.d();
                f4.x.w((f4.x) wVarB.f2287g, b0VarY);
                wVarB.d();
                f4.x.v((f4.x) wVarB.f2287g);
                return (f4.x) wVarB.a();
            case 6:
                i0 i0VarZ = j0.z();
                byte[] bArrA8 = u.a(((l0) aVar).w());
                com.google.crypto.tink.shaded.protobuf.g gVarH8 = com.google.crypto.tink.shaded.protobuf.h.h(bArrA8, 0, bArrA8.length);
                i0VarZ.d();
                j0.w((j0) i0VarZ.f2287g, gVarH8);
                i0VarZ.d();
                j0.v((j0) i0VarZ.f2287g);
                return (j0) i0VarZ.a();
            case 7:
                m0 m0VarZ = n0.z();
                byte[] bArrA9 = u.a(((p0) aVar).w());
                com.google.crypto.tink.shaded.protobuf.g gVarH9 = com.google.crypto.tink.shaded.protobuf.h.h(bArrA9, 0, bArrA9.length);
                m0VarZ.d();
                n0.w((n0) m0VarZ.f2287g, gVarH9);
                m0VarZ.d();
                n0.v((n0) m0VarZ.f2287g);
                return (n0) m0VarZ.a();
            case 8:
                u0 u0VarZ = v0.z();
                u0VarZ.d();
                v0.v((v0) u0VarZ.f2287g);
                byte[] bArrA10 = u.a(32);
                com.google.crypto.tink.shaded.protobuf.g gVarH10 = com.google.crypto.tink.shaded.protobuf.h.h(bArrA10, 0, bArrA10.length);
                u0VarZ.d();
                v0.w((v0) u0VarZ.f2287g, gVarH10);
                return (v0) u0VarZ.a();
            case 9:
                w1 w1VarZ = x1.z();
                w1VarZ.d();
                x1.w((x1) w1VarZ.f2287g, (y1) aVar);
                w1VarZ.d();
                x1.v((x1) w1VarZ.f2287g);
                return (x1) w1VarZ.a();
            case 10:
                z1 z1VarZ = a2.z();
                z1VarZ.d();
                a2.w((a2) z1VarZ.f2287g, (b2) aVar);
                z1VarZ.d();
                a2.v((a2) z1VarZ.f2287g);
                return (a2) z1VarZ.a();
            case 11:
                e2 e2VarZ = f2.z();
                e2VarZ.d();
                f2.v((f2) e2VarZ.f2287g);
                byte[] bArrA11 = u.a(32);
                com.google.crypto.tink.shaded.protobuf.g gVarH11 = com.google.crypto.tink.shaded.protobuf.h.h(bArrA11, 0, bArrA11.length);
                e2VarZ.d();
                f2.w((f2) e2VarZ.f2287g, gVarH11);
                return (f2) e2VarZ.a();
            default:
                q0 q0VarZ = r0.z();
                byte[] bArrA12 = u.a(((t0) aVar).w());
                com.google.crypto.tink.shaded.protobuf.g gVarH12 = com.google.crypto.tink.shaded.protobuf.h.h(bArrA12, 0, bArrA12.length);
                q0VarZ.d();
                r0.w((r0) q0VarZ.f2287g, gVarH12);
                q0VarZ.d();
                r0.v((r0) q0VarZ.f2287g);
                return (r0) q0VarZ.a();
        }
    }

    @Override // a4.d
    public Map u0() {
        switch (this.f1489g) {
            case 0:
                HashMap map = new HashMap();
                f4.c cVarZ = f4.d.z();
                cVarZ.d();
                f4.d.v((f4.d) cVarZ.f2287g);
                f4.e eVarY = f4.f.y();
                eVarY.d();
                f4.f.v((f4.f) eVarY.f2287g);
                f4.f fVar = (f4.f) eVarY.a();
                cVarZ.d();
                f4.d.w((f4.d) cVarZ.f2287g, fVar);
                map.put("AES_CMAC", new a4.c((f4.d) cVarZ.a(), 1));
                f4.c cVarZ2 = f4.d.z();
                cVarZ2.d();
                f4.d.v((f4.d) cVarZ2.f2287g);
                f4.e eVarY2 = f4.f.y();
                eVarY2.d();
                f4.f.v((f4.f) eVarY2.f2287g);
                f4.f fVar2 = (f4.f) eVarY2.a();
                cVarZ2.d();
                f4.d.w((f4.d) cVarZ2.f2287g, fVar2);
                map.put("AES256_CMAC", new a4.c((f4.d) cVarZ2.a(), 1));
                f4.c cVarZ3 = f4.d.z();
                cVarZ3.d();
                f4.d.v((f4.d) cVarZ3.f2287g);
                f4.e eVarY3 = f4.f.y();
                eVarY3.d();
                f4.f.v((f4.f) eVarY3.f2287g);
                f4.f fVar3 = (f4.f) eVarY3.a();
                cVarZ3.d();
                f4.d.w((f4.d) cVarZ3.f2287g, fVar3);
                map.put("AES256_CMAC_RAW", new a4.c((f4.d) cVarZ3.a(), 3));
                return Collections.unmodifiableMap(map);
            case 1:
                HashMap map2 = new HashMap();
                a1 a1Var = a1.SHA256;
                map2.put("HMAC_SHA256_128BITTAG", e.l(32, 16, a1Var, 1));
                map2.put("HMAC_SHA256_128BITTAG_RAW", e.l(32, 16, a1Var, 3));
                map2.put("HMAC_SHA256_256BITTAG", e.l(32, 32, a1Var, 1));
                map2.put("HMAC_SHA256_256BITTAG_RAW", e.l(32, 32, a1Var, 3));
                a1 a1Var2 = a1.SHA512;
                map2.put("HMAC_SHA512_128BITTAG", e.l(64, 16, a1Var2, 1));
                map2.put("HMAC_SHA512_128BITTAG_RAW", e.l(64, 16, a1Var2, 3));
                map2.put("HMAC_SHA512_256BITTAG", e.l(64, 32, a1Var2, 1));
                map2.put("HMAC_SHA512_256BITTAG_RAW", e.l(64, 32, a1Var2, 3));
                map2.put("HMAC_SHA512_512BITTAG", e.l(64, 64, a1Var2, 1));
                map2.put("HMAC_SHA512_512BITTAG_RAW", e.l(64, 64, a1Var2, 3));
                return Collections.unmodifiableMap(map2);
            case 2:
                HashMap map3 = new HashMap();
                map3.put("AES128_CTR_HMAC_SHA256_4KB", new a4.c(g4.a.p(16, 16, 4096), 3));
                map3.put("AES128_CTR_HMAC_SHA256_1MB", new a4.c(g4.a.p(16, 16, 1048576), 3));
                map3.put("AES256_CTR_HMAC_SHA256_4KB", new a4.c(g4.a.p(32, 32, 4096), 3));
                map3.put("AES256_CTR_HMAC_SHA256_1MB", new a4.c(g4.a.p(32, 32, 1048576), 3));
                return Collections.unmodifiableMap(map3);
            case 3:
                HashMap map4 = new HashMap();
                map4.put("AES128_GCM_HKDF_4KB", new a4.c(g4.a.q(16, 16, 4096), 3));
                map4.put("AES128_GCM_HKDF_1MB", new a4.c(g4.a.q(16, 16, 1048576), 3));
                map4.put("AES256_GCM_HKDF_4KB", new a4.c(g4.a.q(32, 32, 4096), 3));
                map4.put("AES256_GCM_HKDF_1MB", new a4.c(g4.a.q(32, 32, 1048576), 3));
                return Collections.unmodifiableMap(map4);
            case 4:
                HashMap map5 = new HashMap();
                map5.put("AES128_CTR_HMAC_SHA256", g4.a.m(16, 16, 1));
                map5.put("AES128_CTR_HMAC_SHA256_RAW", g4.a.m(16, 16, 3));
                map5.put("AES256_CTR_HMAC_SHA256", g4.a.m(32, 32, 1));
                map5.put("AES256_CTR_HMAC_SHA256_RAW", g4.a.m(32, 32, 3));
                return Collections.unmodifiableMap(map5);
            case 5:
                HashMap map6 = new HashMap();
                map6.put("AES128_EAX", g4.a.l(16, 1));
                map6.put("AES128_EAX_RAW", g4.a.l(16, 3));
                map6.put("AES256_EAX", g4.a.l(32, 1));
                map6.put("AES256_EAX_RAW", g4.a.l(32, 3));
                return Collections.unmodifiableMap(map6);
            case 6:
                HashMap map7 = new HashMap();
                map7.put("AES128_GCM", g4.a.n(16, 1));
                map7.put("AES128_GCM_RAW", g4.a.n(16, 3));
                map7.put("AES256_GCM", g4.a.n(32, 1));
                map7.put("AES256_GCM_RAW", g4.a.n(32, 3));
                return Collections.unmodifiableMap(map7);
            case 7:
                HashMap map8 = new HashMap();
                map8.put("AES128_GCM_SIV", g4.a.o(16, 1));
                map8.put("AES128_GCM_SIV_RAW", g4.a.o(16, 3));
                map8.put("AES256_GCM_SIV", g4.a.o(32, 1));
                map8.put("AES256_GCM_SIV_RAW", g4.a.o(32, 3));
                return Collections.unmodifiableMap(map8);
            case 8:
                HashMap map9 = new HashMap();
                map9.put("CHACHA20_POLY1305", new a4.c(x0.v(), 1));
                map9.put("CHACHA20_POLY1305_RAW", new a4.c(x0.v(), 3));
                return Collections.unmodifiableMap(map9);
            case 9:
            case 10:
            default:
                return super.u0();
            case 11:
                HashMap map10 = new HashMap();
                map10.put("XCHACHA20_POLY1305", new a4.c(g2.v(), 1));
                map10.put("XCHACHA20_POLY1305_RAW", new a4.c(g2.v(), 3));
                return Collections.unmodifiableMap(map10);
            case 12:
                HashMap map11 = new HashMap();
                s0 s0VarX = t0.x();
                s0VarX.d();
                t0.v((t0) s0VarX.f2287g);
                map11.put("AES256_SIV", new a4.c((t0) s0VarX.a(), 1));
                s0 s0VarX2 = t0.x();
                s0VarX2.d();
                t0.v((t0) s0VarX2.f2287g);
                map11.put("AES256_SIV_RAW", new a4.c((t0) s0VarX2.a(), 3));
                return Collections.unmodifiableMap(map11);
        }
    }

    public d(g4.a aVar, byte b10, char c10) {
        super(y1.class);
    }

    public d(g4.a aVar, byte b10, int i2) {
        super(b2.class);
    }

    public d(g4.a aVar, short s10) {
        super(l0.class);
    }

    public d(g4.a aVar, byte b10, byte b11) {
        super(x0.class);
    }

    public d(g4.a aVar, byte b10, boolean z4) {
        super(p0.class);
    }

    public d(g4.a aVar, int i2) {
        super(z.class);
    }

    public d(g4.a aVar, byte b10, short s10) {
        super(g2.class);
    }

    public d(g4.a aVar, char c10, boolean z4) {
        super(t0.class);
    }

    public d(g4.a aVar, byte b10) {
        super(f0.class);
    }

    public d(g4.a aVar, char c10) {
        super(f4.j.class);
    }

    public d(g4.a aVar) {
        super(f4.n.class);
    }

    public d(e eVar) {
        super(e1.class);
    }
}

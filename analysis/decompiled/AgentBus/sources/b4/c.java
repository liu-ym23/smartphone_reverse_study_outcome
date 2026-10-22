package b4;

import f4.a1;
import f4.a2;
import f4.c1;
import f4.d0;
import f4.f2;
import f4.j0;
import f4.n0;
import f4.r0;
import f4.v0;
import f4.x1;
import h4.t;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.spec.SecretKeySpec;
import m.x;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final Class f1487a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f1488b;

    public c(Class cls, int i2) {
        this.f1488b = i2;
        this.f1487a = cls;
    }

    public final Object a(com.google.crypto.tink.shaded.protobuf.a aVar) throws GeneralSecurityException {
        switch (this.f1488b) {
            case 0:
                f4.b bVar = (f4.b) aVar;
                return new t(new i5.l(bVar.y().j()), bVar.z().x());
            case 1:
                c1 c1Var = (c1) aVar;
                a1 a1VarY = c1Var.A().y();
                SecretKeySpec secretKeySpec = new SecretKeySpec(c1Var.z().j(), "HMAC");
                int iZ = c1Var.A().z();
                int iOrdinal = a1VarY.ordinal();
                if (iOrdinal == 1) {
                    return new t(new h4.s("HMACSHA1", secretKeySpec), iZ);
                }
                if (iOrdinal == 2) {
                    return new t(new h4.s("HMACSHA384", secretKeySpec), iZ);
                }
                if (iOrdinal == 3) {
                    return new t(new h4.s("HMACSHA256", secretKeySpec), iZ);
                }
                if (iOrdinal == 4) {
                    return new t(new h4.s("HMACSHA512", secretKeySpec), iZ);
                }
                if (iOrdinal == 5) {
                    return new t(new h4.s("HMACSHA224", secretKeySpec), iZ);
                }
                throw new GeneralSecurityException("unknown hash");
            case 2:
                f4.l lVar = (f4.l) aVar;
                return new h4.b(lVar.y().j(), ib.k.T(lVar.z().C()), lVar.z().B(), ib.k.T(lVar.z().D().y()), lVar.z().D().z(), lVar.z().z());
            case 3:
                d0 d0Var = (d0) aVar;
                return new h4.f(d0Var.z().A(), d0Var.z().y(), ib.k.T(d0Var.z().B()), d0Var.y().j());
            case 4:
                f4.h hVar = (f4.h) aVar;
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
                Map mapUnmodifiableMap = Collections.unmodifiableMap(map);
                f4.r rVarY = hVar.y();
                c cVar2 = (c) mapUnmodifiableMap.get(h4.p.class);
                if (cVar2 == null) {
                    throw new IllegalArgumentException("Requested primitive class " + h4.p.class.getCanonicalName() + " not supported.");
                }
                h4.p pVar = (h4.p) cVar2.a(rVarY);
                c[] cVarArr2 = {new c(t3.j.class, 1)};
                HashMap map2 = new HashMap();
                for (c cVar3 : cVarArr2) {
                    Class cls3 = cVar3.f1487a;
                    if (map2.containsKey(cls3)) {
                        throw new IllegalArgumentException(x.j(cls3, new StringBuilder("KeyTypeManager constructed with duplicate factories for primitive ")));
                    }
                    map2.put(cls3, cVar3);
                }
                if (cVarArr2.length > 0) {
                    Class cls4 = cVarArr2[0].f1487a;
                }
                Map mapUnmodifiableMap2 = Collections.unmodifiableMap(map2);
                c1 c1VarZ = hVar.z();
                c cVar4 = (c) mapUnmodifiableMap2.get(t3.j.class);
                if (cVar4 != null) {
                    return new h4.k(pVar, (t3.j) cVar4.a(c1VarZ), hVar.z().A().z());
                }
                throw new IllegalArgumentException("Requested primitive class " + t3.j.class.getCanonicalName() + " not supported.");
            case 5:
                f4.r rVar = (f4.r) aVar;
                return new h4.c(rVar.A().x(), rVar.z().j());
            case 6:
                f4.x xVar = (f4.x) aVar;
                return new h4.d(xVar.z().x(), xVar.y().j());
            case 7:
                return new h4.g(0, ((j0) aVar).x().j());
            case 8:
                return new w3.a(((n0) aVar).x().j());
            case 9:
                return new h4.g(1, ((v0) aVar).x().j());
            case 10:
                String strW = ((x1) aVar).x().w();
                return t3.i.a(strW).c(strW);
            case 11:
                a2 a2Var = (a2) aVar;
                String strX = a2Var.x().x();
                return new u3.r(a2Var.x().w(), t3.i.a(strX).c(strX));
            case 12:
                return new h4.g(2, ((f2) aVar).x().j());
            default:
                return new h4.h(((r0) aVar).x().j());
        }
    }
}

package d2;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.spec.SecretKeySpec;
import k2.b0;
import k2.f0;
import k2.h;
import k2.j0;
import k2.l1;
import k2.o0;
import k2.o1;
import k2.q0;
import k2.r;
import k2.t1;
import k2.x;
import l2.g;
import l2.j;
import l2.l;
import l2.m;
import y1.i;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Class f1783a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f1784b;

    public a(Class cls, int i8) {
        this.f1784b = i8;
        this.f1783a = cls;
    }

    public final Object a(com.google.crypto.tink.shaded.protobuf.a aVar) throws GeneralSecurityException {
        switch (this.f1784b) {
            case 0:
                return new l2.d(((f0) aVar).y().j());
            case 1:
                k2.b bVar = (k2.b) aVar;
                return new m(new a4.d(bVar.z().j()), bVar.A().y());
            case 2:
                q0 q0Var = (q0) aVar;
                o0 o0VarZ = q0Var.B().z();
                SecretKeySpec secretKeySpec = new SecretKeySpec(q0Var.A().j(), "HMAC");
                int iA = q0Var.B().A();
                int iOrdinal = o0VarZ.ordinal();
                if (iOrdinal == 1) {
                    return new m(new l("HMACSHA1", secretKeySpec), iA);
                }
                if (iOrdinal == 2) {
                    return new m(new l("HMACSHA384", secretKeySpec), iA);
                }
                if (iOrdinal == 3) {
                    return new m(new l("HMACSHA256", secretKeySpec), iA);
                }
                if (iOrdinal == 4) {
                    return new m(new l("HMACSHA512", secretKeySpec), iA);
                }
                if (iOrdinal == 5) {
                    return new m(new l("HMACSHA224", secretKeySpec), iA);
                }
                throw new GeneralSecurityException("unknown hash");
            case 3:
                h hVar = (h) aVar;
                a[] aVarArr = {new a(j.class, 4)};
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
                Map mapUnmodifiableMap = Collections.unmodifiableMap(map);
                k2.l lVarZ = hVar.z();
                a aVar3 = (a) mapUnmodifiableMap.get(j.class);
                if (aVar3 == null) {
                    throw new IllegalArgumentException("Requested primitive class " + j.class.getCanonicalName() + " not supported.");
                }
                j jVar = (j) aVar3.a(lVarZ);
                a[] aVarArr2 = {new a(y1.j.class, 2)};
                HashMap map2 = new HashMap();
                for (a aVar4 : aVarArr2) {
                    Class cls3 = aVar4.f1783a;
                    if (map2.containsKey(cls3)) {
                        throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive " + cls3.getCanonicalName());
                    }
                    map2.put(cls3, aVar4);
                }
                if (aVarArr2.length > 0) {
                    Class cls4 = aVarArr2[0].f1783a;
                }
                Map mapUnmodifiableMap2 = Collections.unmodifiableMap(map2);
                q0 q0VarA = hVar.A();
                a aVar5 = (a) mapUnmodifiableMap2.get(y1.j.class);
                if (aVar5 != null) {
                    return new g(jVar, (y1.j) aVar5.a(q0VarA), hVar.A().B().A());
                }
                throw new IllegalArgumentException("Requested primitive class " + y1.j.class.getCanonicalName() + " not supported.");
            case 4:
                k2.l lVar = (k2.l) aVar;
                return new l2.a(lVar.A().j(), lVar.B().y());
            case 5:
                r rVar = (r) aVar;
                return new l2.b(rVar.z().j(), rVar.A().y());
            case 6:
                return new l2.c(((x) aVar).y().j(), 0);
            case 7:
                return new b2.a(((b0) aVar).y().j());
            case 8:
                return new l2.c(((j0) aVar).y().j(), 1);
            case 9:
                String strX = ((l1) aVar).y().x();
                return i.a(strX).c(strX);
            case 10:
                o1 o1Var = (o1) aVar;
                String strY = o1Var.y().y();
                return new z1.r(o1Var.y().x(), i.a(strY).c(strY));
            default:
                return new l2.c(((t1) aVar).y().j(), 2);
        }
    }
}

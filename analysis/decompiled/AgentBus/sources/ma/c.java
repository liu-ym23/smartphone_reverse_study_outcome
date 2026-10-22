package ma;

import f8.x;
import q7.z;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final g7.d[] f6480a = new g7.d[0];

    /* renamed from: b, reason: collision with root package name */
    public static final x f6481b = new x("NULL", 3);

    public static final Object a(g7.l lVar, Object obj, Object obj2, p7.n nVar, g7.d dVar) {
        Object objInvoke;
        Object objN = na.b.n(lVar, obj2);
        try {
            v vVar = new v(dVar, lVar);
            if (nVar == null) {
                objInvoke = ib.k.X(nVar, obj, vVar);
            } else {
                z.c(2, nVar);
                objInvoke = nVar.invoke(obj, vVar);
            }
            na.b.g(lVar, objN);
            if (objInvoke == h7.a.f4212f) {
                q7.k.e(dVar, "frame");
            }
            return objInvoke;
        } catch (Throwable th) {
            na.b.g(lVar, objN);
            throw th;
        }
    }
}

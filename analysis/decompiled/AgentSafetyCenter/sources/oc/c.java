package oc;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final nb.c[] f9366a = new nb.c[0];

    /* renamed from: b, reason: collision with root package name */
    public static final pc.t f9367b = new pc.t("NULL");

    /* renamed from: c, reason: collision with root package name */
    public static final pc.t f9368c = new pc.t("UNINITIALIZED");

    public static /* synthetic */ nc.g a(r rVar, nb.g gVar, int i, mc.a aVar, int i3) {
        if ((i3 & 1) != 0) {
            gVar = nb.h.f8811c;
        }
        if ((i3 & 2) != 0) {
            i = -3;
        }
        if ((i3 & 4) != 0) {
            aVar = mc.a.f8550c;
        }
        return rVar.a(gVar, i, aVar);
    }

    public static final Object b(nb.g gVar, Object obj, Object obj2, xb.p pVar, nb.c cVar) {
        Object objInvoke;
        Object objL = pc.a.l(gVar, obj2);
        try {
            y yVar = new y();
            yVar.f9410c = cVar;
            yVar.f9411f = gVar;
            VarHandle.storeStoreFence();
            if (pVar == null) {
                objInvoke = td.h.Q(pVar, obj, yVar);
            } else {
                yb.x.c(2, pVar);
                objInvoke = pVar.invoke(obj, yVar);
            }
            pc.a.g(gVar, objL);
            if (objInvoke == ob.a.f9351c) {
                cVar.getClass();
            }
            return objInvoke;
        } catch (Throwable th) {
            pc.a.g(gVar, objL);
            throw th;
        }
    }
}

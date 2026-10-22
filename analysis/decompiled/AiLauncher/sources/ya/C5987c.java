package ya;

/* renamed from: ya.c, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5987c {

    /* renamed from: a, reason: collision with root package name */
    public static final C5987c f44067a = new C5987c();

    public final boolean a(Ca.q qVar, Ca.h hVar, Ca.h hVar2) {
        if (qVar.k0(hVar) != qVar.k0(hVar2) || qVar.N(hVar) != qVar.N(hVar2) || qVar.z(hVar) != qVar.z(hVar2) || !qVar.y(qVar.e(hVar), qVar.e(hVar2))) {
            return false;
        }
        if (qVar.A0(hVar, hVar2)) {
            return true;
        }
        int iK0 = qVar.k0(hVar);
        for (int i10 = 0; i10 < iK0; i10++) {
            Ca.k kVarX0 = qVar.x0(hVar, i10);
            Ca.k kVarX02 = qVar.x0(hVar2, i10);
            if (qVar.h(kVarX0) != qVar.h(kVarX02)) {
                return false;
            }
            if (!qVar.h(kVarX0)) {
                if (qVar.D0(kVarX0) != qVar.D0(kVarX02)) {
                    return false;
                }
                Ca.g gVarL0 = qVar.L0(kVarX0);
                kotlin.jvm.internal.p.f(gVarL0);
                Ca.g gVarL02 = qVar.L0(kVarX02);
                kotlin.jvm.internal.p.f(gVarL02);
                if (!c(qVar, gVarL0, gVarL02)) {
                    return false;
                }
            }
        }
        return true;
    }

    public final boolean b(Ca.q context, Ca.g a10, Ca.g b10) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(a10, "a");
        kotlin.jvm.internal.p.i(b10, "b");
        return c(context, a10, b10);
    }

    public final boolean c(Ca.q qVar, Ca.g gVar, Ca.g gVar2) {
        if (gVar == gVar2) {
            return true;
        }
        Ca.h hVarF = qVar.f(gVar);
        Ca.h hVarF2 = qVar.f(gVar2);
        if (hVarF != null && hVarF2 != null) {
            return a(qVar, hVarF, hVarF2);
        }
        Ca.e eVarX = qVar.X(gVar);
        Ca.e eVarX2 = qVar.X(gVar2);
        return eVarX != null && eVarX2 != null && a(qVar, qVar.d(eVarX), qVar.d(eVarX2)) && a(qVar, qVar.i(eVarX), qVar.i(eVarX2));
    }
}

package F9;

import C9.o;
import E9.InterfaceC0819y;
import Z8.C1173v;
import kotlin.Pair;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import ma.C4921a;
import ma.C4922b;
import ma.x;
import ya.AbstractC5990d0;
import ya.S;

/* loaded from: classes5.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final ga.e f2604a;

    /* renamed from: b, reason: collision with root package name */
    public static final ga.e f2605b;

    /* renamed from: c, reason: collision with root package name */
    public static final ga.e f2606c;

    /* renamed from: d, reason: collision with root package name */
    public static final ga.e f2607d;

    /* renamed from: e, reason: collision with root package name */
    public static final ga.e f2608e;

    static {
        ga.e eVarJ = ga.e.j("message");
        p.h(eVarJ, "identifier(...)");
        f2604a = eVarJ;
        ga.e eVarJ2 = ga.e.j("replaceWith");
        p.h(eVarJ2, "identifier(...)");
        f2605b = eVarJ2;
        ga.e eVarJ3 = ga.e.j("level");
        p.h(eVarJ3, "identifier(...)");
        f2606c = eVarJ3;
        ga.e eVarJ4 = ga.e.j("expression");
        p.h(eVarJ4, "identifier(...)");
        f2607d = eVarJ4;
        ga.e eVarJ5 = ga.e.j("imports");
        p.h(eVarJ5, "identifier(...)");
        f2608e = eVarJ5;
    }

    public static final c b(C9.j jVar, String message, String replaceWith, String level, boolean z10) {
        p.i(jVar, "<this>");
        p.i(message, "message");
        p.i(replaceWith, "replaceWith");
        p.i(level, "level");
        k kVar = new k(jVar, o.a.f1848B, kotlin.collections.a.m(Y8.j.a(f2607d, new x(replaceWith)), Y8.j.a(f2608e, new C4922b(C1173v.m(), new e(jVar)))), false, 8, null);
        ga.c cVar = o.a.f1942y;
        Pair pairA = Y8.j.a(f2604a, new x(message));
        Pair pairA2 = Y8.j.a(f2605b, new C4921a(kVar));
        ga.e eVar = f2606c;
        ga.b bVarC = ga.b.f32721d.c(o.a.f1846A);
        ga.e eVarJ = ga.e.j(level);
        p.h(eVarJ, "identifier(...)");
        return new k(jVar, cVar, kotlin.collections.a.m(pairA, pairA2, Y8.j.a(eVar, new ma.k(bVarC, eVarJ))), z10);
    }

    public static /* synthetic */ c c(C9.j jVar, String str, String str2, String str3, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = "";
        }
        if ((i10 & 4) != 0) {
            str3 = "WARNING";
        }
        if ((i10 & 8) != 0) {
            z10 = false;
        }
        return b(jVar, str, str2, str3, z10);
    }

    public static final S d(C9.j jVar, InterfaceC0819y module) {
        p.i(module, "module");
        AbstractC5990d0 abstractC5990d0M = module.g().m(Variance.INVARIANT, jVar.X());
        p.h(abstractC5990d0M, "getArrayType(...)");
        return abstractC5990d0M;
    }
}

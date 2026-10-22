package l9;

import c8.h;
import e8.n;
import e9.e;
import e9.f;
import ea.k;
import f8.e0;
import f8.g;
import f8.j;
import f8.k0;
import f8.l0;
import f8.z;
import i8.c0;
import i8.g0;
import i8.r0;
import q7.v;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f5893a = 0;

    static {
        f.e("value");
    }

    public static final boolean a(r0 r0Var) {
        Boolean boolG = k.g(a.a.S(r0Var), a.f5889g, b.f5891n);
        q7.k.d(boolG, "ifAny(\n        listOf(th…eclaresDefaultValue\n    )");
        return boolG.booleanValue();
    }

    public static f8.c b(f8.c cVar, p7.k kVar) {
        q7.k.e(cVar, "<this>");
        return (f8.c) k.e(a.a.S(cVar), new a(1), new n(new v(), kVar));
    }

    public static final e9.c c(f8.k kVar) {
        q7.k.e(kVar, "<this>");
        e eVarH = h(kVar);
        if (!eVarH.d()) {
            eVarH = null;
        }
        if (eVarH != null) {
            return eVarH.g();
        }
        return null;
    }

    public static final f8.e d(g8.c cVar) {
        q7.k.e(cVar, "<this>");
        g gVarC = cVar.getType().E0().c();
        if (gVarC instanceof f8.e) {
            return (f8.e) gVarC;
        }
        return null;
    }

    public static final h e(j jVar) {
        q7.k.e(jVar, "<this>");
        return j(jVar).n();
    }

    public static final e9.b f(g gVar) {
        j jVarP;
        e9.b bVarF;
        if (gVar == null || (jVarP = gVar.p()) == null) {
            return null;
        }
        if (jVarP instanceof e0) {
            return new e9.b(((c0) ((e0) jVarP)).f4758j, gVar.getName());
        }
        if (!(jVarP instanceof f8.h) || (bVarF = f((g) jVarP)) == null) {
            return null;
        }
        return bVarF.d(gVar.getName());
    }

    public static final e9.c g(j jVar) {
        q7.k.e(jVar, "<this>");
        e9.c cVarH = h9.f.h(jVar);
        return cVarH != null ? cVarH : h9.f.g(jVar.p()).b(jVar.getName()).g();
    }

    public static final e h(j jVar) {
        q7.k.e(jVar, "<this>");
        e eVarG = h9.f.g(jVar);
        q7.k.d(eVarG, "getFqName(this)");
        return eVarG;
    }

    public static final void i(z zVar) {
        q7.k.e(zVar, "<this>");
        if (zVar.s0(w9.h.f10934a) != null) {
            throw new ClassCastException();
        }
    }

    public static final z j(j jVar) {
        q7.k.e(jVar, "<this>");
        z zVarD = h9.f.d(jVar);
        q7.k.d(zVarD, "getContainingModule(this)");
        return zVarD;
    }

    public static final f8.c k(f8.c cVar) {
        q7.k.e(cVar, "<this>");
        if (!(cVar instanceof k0)) {
            return cVar;
        }
        l0 l0VarG0 = ((g0) ((k0) cVar)).G0();
        q7.k.d(l0VarG0, "correspondingProperty");
        return l0VarG0;
    }
}

package h9;

import f8.a0;
import f8.l0;
import f8.r0;
import f8.t0;
import f8.u;
import i8.j0;
import v9.v;
import v9.z;

/* loaded from: classes.dex */
public abstract class h {
    static {
        e9.b.j(new e9.c("kotlin.jvm.JvmInline"));
    }

    public static final boolean a(f8.c cVar) {
        q7.k.e(cVar, "<this>");
        if (!(cVar instanceof j0)) {
            return false;
        }
        l0 l0VarG0 = ((j0) cVar).G0();
        q7.k.d(l0VarG0, "correspondingProperty");
        return d(l0VarG0);
    }

    public static final boolean b(f8.j jVar) {
        q7.k.e(jVar, "<this>");
        return (jVar instanceof f8.e) && (((f8.e) jVar).i0() instanceof u);
    }

    public static final boolean c(v vVar) {
        q7.k.e(vVar, "<this>");
        f8.g gVarC = vVar.E0().c();
        if (gVarC != null) {
            return b(gVarC);
        }
        return false;
    }

    public static final boolean d(t0 t0Var) {
        if (t0Var.I() != null) {
            return false;
        }
        f8.j jVarP = t0Var.p();
        e9.f fVar = null;
        f8.e eVar = jVarP instanceof f8.e ? (f8.e) jVarP : null;
        if (eVar != null) {
            int i2 = l9.d.f5893a;
            r0 r0VarI0 = eVar.i0();
            u uVar = r0VarI0 instanceof u ? (u) r0VarI0 : null;
            if (uVar != null) {
                fVar = uVar.f3513a;
            }
        }
        return q7.k.a(fVar, t0Var.getName());
    }

    public static final boolean e(f8.j jVar) {
        if (b(jVar)) {
            return true;
        }
        return (jVar instanceof f8.e) && (((f8.e) jVar).i0() instanceof a0);
    }

    public static final z f(v vVar) {
        q7.k.e(vVar, "<this>");
        f8.g gVarC = vVar.E0().c();
        f8.e eVar = gVarC instanceof f8.e ? (f8.e) gVarC : null;
        if (eVar != null) {
            int i2 = l9.d.f5893a;
            r0 r0VarI0 = eVar.i0();
            u uVar = r0VarI0 instanceof u ? (u) r0VarI0 : null;
            if (uVar != null) {
                return (z) uVar.f3514b;
            }
        }
        return null;
    }
}

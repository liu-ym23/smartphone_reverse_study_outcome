package s4;

import Z3.i;
import a4.C0428b;

/* loaded from: classes.dex */
public final class S {
    public static final Object a(long j5, Z3.e<? super V3.v> eVar) {
        if (j5 <= 0) {
            return V3.v.f5542a;
        }
        C1082l c1082l = new C1082l(C0428b.c(eVar), 1);
        c1082l.D();
        if (j5 < Long.MAX_VALUE) {
            b(c1082l.getContext()).r(j5, c1082l);
        }
        Object objX = c1082l.x();
        if (objX == C0428b.e()) {
            kotlin.coroutines.jvm.internal.h.c(eVar);
        }
        return objX == C0428b.e() ? objX : V3.v.f5542a;
    }

    public static final Q b(Z3.i iVar) {
        i.b bVarA = iVar.a(Z3.f.f6654N);
        Q q5 = bVarA instanceof Q ? (Q) bVarA : null;
        return q5 == null ? O.a() : q5;
    }
}

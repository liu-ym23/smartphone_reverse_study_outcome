package androidx.compose.foundation;

import android.content.Context;
import b0.k;
import b0.p;
import d2.l;
import j1.q0;
import o.g;
import o.r0;
import o.s0;
import o.t0;
import o.u;
import o.y0;
import p.e0;
import p7.o;
import q.i;
import q7.m;

/* loaded from: classes.dex */
public final class d extends m implements o {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ y0 f721g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(y0 y0Var) {
        super(3);
        this.f721g = y0Var;
    }

    @Override // p7.o
    public final Object j(Object obj, Object obj2, Object obj3) {
        t0 t0Var;
        p pVar = (p) obj2;
        ((Number) obj3).intValue();
        pVar.S(1478351300);
        y0 y0Var = this.f721g;
        ScrollSemanticsElement scrollSemanticsElement = new ScrollSemanticsElement(y0Var);
        i iVar = y0Var.f7161h;
        Context context = (Context) pVar.j(q0.f5300b);
        r0 r0Var = (r0) pVar.j(s0.f7127a);
        if (r0Var != null) {
            pVar.S(1586021609);
            boolean zF = pVar.f(context) | pVar.f(r0Var);
            Object objJ = pVar.J();
            if (zF || objJ == k.f1229a) {
                objJ = new g(context, r0Var);
                pVar.b0(objJ);
            }
            t0Var = (g) objJ;
            pVar.q(false);
        } else {
            pVar.S(1586120933);
            pVar.q(false);
            t0Var = o.q0.f7117g;
        }
        t0 t0Var2 = t0Var;
        n0.m mVarC = scrollSemanticsElement.c(u.f7130b).c(t0Var2.c());
        l lVar = l.f2793f;
        n0.m mVarC2 = androidx.compose.foundation.gestures.a.b(mVarC, y0Var, e0.f8081f, t0Var2, true, iVar).c(new ScrollingLayoutElement(y0Var));
        pVar.q(false);
        return mVarC2;
    }
}

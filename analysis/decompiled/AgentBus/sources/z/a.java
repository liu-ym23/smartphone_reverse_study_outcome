package z;

import b0.p;
import b0.w1;
import b0.x1;
import b0.z1;
import j0.d;
import s1.h0;
import s1.r;
import s1.s;
import u0.m;
import y.f;
import y.k0;
import y.l;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final s f11750a = new s(new r());

    public static final void a(long j2, h0 h0Var, d dVar, p pVar, int i2) {
        pVar.T(-716124955);
        if ((((pVar.e(j2) ? 4 : 2) | i2 | (pVar.f(h0Var) ? 32 : 16)) & 147) == 146 && pVar.z()) {
            pVar.O();
        } else {
            w1 w1Var = k0.f11486a;
            h0 h0Var2 = (h0) pVar.j(w1Var);
            h0Var2.getClass();
            if (h0Var != null && !h0Var.equals(h0.f9271d)) {
                h0Var2 = new h0(h0Var2.f9272a.c(h0Var.f9272a), h0Var2.f9273b.a(h0Var.f9273b));
            }
            b0.b.b(new x1[]{l.f11487a.a(new m(j2)), w1Var.a(h0Var2)}, dVar, pVar, 56);
        }
        z1 z1VarS = pVar.s();
        if (z1VarS != null) {
            z1VarS.f1444d = new f(j2, h0Var, dVar, i2);
        }
    }
}

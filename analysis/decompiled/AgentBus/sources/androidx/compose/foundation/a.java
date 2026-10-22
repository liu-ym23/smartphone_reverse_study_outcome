package androidx.compose.foundation;

import n0.h;
import n0.m;
import o.g0;
import o.m0;
import o.p;
import q.i;
import u0.c0;

/* loaded from: classes.dex */
public abstract class a {
    public static final m a(m mVar, long j2, c0 c0Var) {
        return mVar.c(new BackgroundElement(j2, c0Var));
    }

    public static final m b(m mVar, i iVar, g0 g0Var, boolean z4, p7.a aVar) {
        return mVar.c(g0Var instanceof m0 ? new ClickableElement(iVar, (m0) g0Var, z4, aVar) : g0Var == null ? new ClickableElement(iVar, null, z4, aVar) : iVar != null ? c.a(g0Var, iVar).c(new ClickableElement(iVar, null, z4, aVar)) : new h(new b(g0Var, z4, aVar)));
    }

    public static m c(m mVar, boolean z4, p7.a aVar, int i2) {
        if ((i2 & 1) != 0) {
            z4 = true;
        }
        return mVar.c(new h(new p(z4, aVar)));
    }
}

package s1;

import java.lang.invoke.VarHandle;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class y extends u1.d0 {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ b0 f11329a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ xb.p f11330b;

    @Override // s1.f0
    public final g0 c(h0 h0Var, List list, long j10) {
        xb.p pVar = this.f11330b;
        b0 b0Var = this.f11329a;
        w wVar = b0Var.f11209l;
        wVar.f11318c = h0Var.getLayoutDirection();
        wVar.f11319f = h0Var.a();
        wVar.f11320g = h0Var.T();
        if (h0Var.V() || b0Var.f11203c.f13794k == null) {
            b0Var.f11206h = 0;
            g0 g0Var = (g0) pVar.invoke(wVar, o2.a.a(j10));
            int i = b0Var.f11206h;
            x xVar = new x(1);
            xVar.f11324c = b0Var;
            xVar.f11325d = i;
            xVar.f11326e = g0Var;
            xVar.f11323b = g0Var;
            VarHandle.storeStoreFence();
            return xVar;
        }
        b0Var.i = 0;
        g0 g0Var2 = (g0) pVar.invoke(b0Var.f11210m, o2.a.a(j10));
        int i3 = b0Var.i;
        x xVar2 = new x(0);
        xVar2.f11324c = b0Var;
        xVar2.f11325d = i3;
        xVar2.f11326e = g0Var2;
        xVar2.f11323b = g0Var2;
        VarHandle.storeStoreFence();
        return xVar2;
    }
}

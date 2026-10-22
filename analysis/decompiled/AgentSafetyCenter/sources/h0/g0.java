package h0;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g0 extends yb.l implements xb.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4974c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ h0 f4975f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g0(h0 h0Var, int i) {
        super(0);
        this.f4974c = i;
        this.f4975f = h0Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // xb.a
    public final Object invoke() {
        g0.b bVar;
        int i = this.f4974c;
        h0 h0Var = this.f4975f;
        switch (i) {
            case 0:
                return b1.f4921a;
            default:
                a1 a1Var = (a1) u1.f.h(h0Var, c1.f4929b);
                g0.q qVar = h0Var.f4996y;
                if (a1Var == null) {
                    if (qVar != null) {
                        h0Var.C0(qVar);
                    }
                } else if (qVar == null) {
                    a2.i iVar = new a2.i(9);
                    iVar.f49f = h0Var;
                    VarHandle.storeStoreFence();
                    g0 g0Var = new g0(h0Var, 0);
                    v.k kVar = h0Var.f4992u;
                    boolean z10 = h0Var.f4993v;
                    float f5 = h0Var.f4994w;
                    s.h1 h1Var = g0.p.f4177a;
                    if (g0.u.f4190a) {
                        g0.c cVar = new g0.c(kVar, z10, f5, iVar, g0Var);
                        cVar.C = new p.f0();
                        VarHandle.storeStoreFence();
                        bVar = cVar;
                    } else {
                        bVar = new g0.b(kVar, z10, f5, iVar, g0Var);
                    }
                    h0Var.B0(bVar);
                    h0Var.f4996y = bVar;
                }
                return jb.v.f6774a;
        }
    }
}

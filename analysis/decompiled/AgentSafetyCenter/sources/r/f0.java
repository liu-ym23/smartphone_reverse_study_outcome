package r;

import s.z0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f0 extends yb.l implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10277c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ g0 f10278f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f0(g0 g0Var, int i) {
        super(1);
        this.f10277c = i;
        this.f10278f = g0Var;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        switch (this.f10277c) {
            case 0:
                z0 z0Var = (z0) obj;
                w wVar = w.f10348c;
                w wVar2 = w.f10349f;
                boolean zA = z0Var.a(wVar, wVar2);
                s.o0 o0Var = null;
                g0 g0Var = this.f10278f;
                if (zA) {
                    q0 q0Var = g0Var.f10287w.f10297a;
                } else if (z0Var.a(wVar2, w.f10350g)) {
                    q0 q0Var2 = g0Var.f10288x.f10306a;
                } else {
                    o0Var = c0.f10257d;
                }
                return o0Var == null ? c0.f10257d : o0Var;
            default:
                z0 z0Var2 = (z0) obj;
                w wVar3 = w.f10348c;
                w wVar4 = w.f10349f;
                boolean zA2 = z0Var2.a(wVar3, wVar4);
                g0 g0Var2 = this.f10278f;
                if (zA2) {
                    o0 o0Var2 = g0Var2.f10287w.f10297a.f10338b;
                    return o0Var2 != null ? o0Var2.f10326b : c0.f10256c;
                }
                if (!z0Var2.a(wVar4, w.f10350g)) {
                    return c0.f10256c;
                }
                o0 o0Var3 = g0Var2.f10288x.f10306a.f10338b;
                return o0Var3 != null ? o0Var3.f10326b : c0.f10256c;
        }
    }
}

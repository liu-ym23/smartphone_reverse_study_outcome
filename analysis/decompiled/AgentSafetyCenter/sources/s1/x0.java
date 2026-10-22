package s1;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class x0 extends yb.l implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f11327c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ y0 f11328f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ x0(y0 y0Var, int i) {
        super(2);
        this.f11327c = i;
        this.f11328f = y0Var;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        int i = this.f11327c;
        jb.v vVar = jb.v.f6774a;
        y0 y0Var = this.f11328f;
        switch (i) {
            case 0:
                y0Var.a().f11204f = (k0.v) obj2;
                break;
            case 1:
                b0 b0VarA = y0Var.a();
                y yVar = new y();
                yVar.f11329a = b0VarA;
                yVar.f11330b = (xb.p) obj2;
                VarHandle.storeStoreFence();
                ((u1.g0) obj).c0(yVar);
                break;
            default:
                u1.g0 g0Var = (u1.g0) obj;
                a1 a1Var = y0Var.f11331a;
                b0 b0Var = g0Var.J;
                if (b0Var == null) {
                    b0Var = new b0();
                    b0Var.f11203c = g0Var;
                    b0Var.f11205g = a1Var;
                    long[] jArr = p.n0.f9597a;
                    b0Var.f11207j = new p.f0();
                    b0Var.f11208k = new p.f0();
                    w wVar = new w();
                    wVar.f11321h = b0Var;
                    wVar.f11318c = o2.l.f9124f;
                    VarHandle.storeStoreFence();
                    b0Var.f11209l = wVar;
                    t tVar = new t();
                    tVar.f11297f = b0Var;
                    tVar.f11296c = wVar;
                    VarHandle.storeStoreFence();
                    b0Var.f11210m = tVar;
                    b0Var.f11211n = new p.f0();
                    int i3 = p.m0.f9592a;
                    p.c0 c0Var = new p.c0(6);
                    p.r0 r0Var = new p.r0(1);
                    r0Var.f9622f = c0Var;
                    VarHandle.storeStoreFence();
                    b0Var.f11212o = r0Var;
                    b0Var.f11213p = new p.f0();
                    b0Var.f11214q = new m0.e(new Object[16]);
                    VarHandle.storeStoreFence();
                    g0Var.J = b0Var;
                }
                y0Var.f11332b = b0Var;
                y0Var.a().d();
                b0 b0VarA2 = y0Var.a();
                if (b0VarA2.f11205g != a1Var) {
                    b0VarA2.f11205g = a1Var;
                    b0VarA2.e(false);
                    u1.g0.V(b0VarA2.f11203c, false, 7);
                    break;
                }
                break;
        }
        return vVar;
    }
}

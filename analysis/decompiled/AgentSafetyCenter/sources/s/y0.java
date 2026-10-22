package s;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class y0 {

    /* renamed from: a, reason: collision with root package name */
    public n6.a f11166a;

    /* renamed from: b, reason: collision with root package name */
    public k0.k1 f11167b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ e1 f11168c;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v13, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r4v21, types: [xb.l, yb.l] */
    /* JADX WARN: Type inference failed for: r4v3, types: [xb.l, yb.l] */
    /* JADX WARN: Type inference failed for: r5v8, types: [xb.l, yb.l] */
    public final x0 a(xb.l lVar, xb.l lVar2) {
        e1 e1Var = this.f11168c;
        k0.k1 k1Var = this.f11167b;
        x0 x0Var = (x0) k1Var.getValue();
        if (x0Var == null) {
            Object objInvoke = lVar2.invoke(e1Var.c());
            n6.a aVar = this.f11166a;
            n nVar = (n) ((yb.l) aVar.f8776c).invoke(lVar2.invoke(e1Var.c()));
            nVar.d();
            n6.a aVar2 = this.f11166a;
            b1 b1Var = new b1();
            b1Var.f10956q = e1Var;
            b1Var.f10945c = aVar2;
            k0.k1 k1VarV = k0.z.v(objInvoke);
            b1Var.f10946f = k1VarV;
            Object objInvoke2 = null;
            b1Var.f10947g = k0.z.v(d.m(7, null));
            b1Var.f10948h = k0.z.v(new w0(b1Var.c(), aVar2, objInvoke, k1VarV.getValue(), nVar));
            b1Var.i = k0.z.v(Boolean.TRUE);
            b1Var.f10949j = new k0.g1(-1.0f);
            b1Var.f10951l = k0.z.v(objInvoke);
            b1Var.f10952m = nVar;
            b1Var.f10953n = new k0.i1(b1Var.a().b());
            Float f5 = (Float) p1.f11096a.get(aVar2);
            if (f5 != null) {
                float fFloatValue = f5.floatValue();
                n nVar2 = (n) ((yb.l) aVar2.f8776c).invoke(objInvoke);
                int iB = nVar2.b();
                for (int i = 0; i < iB; i++) {
                    nVar2.e(fFloatValue, i);
                }
                objInvoke2 = ((yb.l) b1Var.f10945c.f8777f).invoke(nVar2);
            }
            b1Var.f10955p = d.m(3, objInvoke2);
            VarHandle.storeStoreFence();
            x0Var = new x0();
            x0Var.f11165h = this;
            x0Var.f11162c = b1Var;
            x0Var.f11163f = lVar;
            x0Var.f11164g = (yb.l) lVar2;
            VarHandle.storeStoreFence();
            k1Var.setValue(x0Var);
            e1Var.i.add(b1Var);
        }
        x0Var.f11164g = (yb.l) lVar2;
        x0Var.f11163f = lVar;
        x0Var.a(e1Var.f());
        return x0Var;
    }
}

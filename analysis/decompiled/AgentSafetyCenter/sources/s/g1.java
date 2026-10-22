package s;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class g1 {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f11015a = 0;

    static {
        h5.t.G(jb.e.f6757f, f1.f11004c);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [xb.l, yb.l] */
    /* JADX WARN: Type inference failed for: r6v4, types: [xb.l, yb.l] */
    public static final y0 a(e1 e1Var, n6.a aVar, String str, k0.s sVar, int i, int i3) {
        x0 x0Var;
        boolean zF = sVar.f(e1Var);
        Object objM = sVar.M();
        Object obj = k0.m.f6974a;
        Object obj2 = objM;
        if (zF || objM == obj) {
            y0 y0Var = new y0();
            y0Var.f11168c = e1Var;
            y0Var.f11166a = aVar;
            y0Var.f11167b = k0.z.v(null);
            VarHandle.storeStoreFence();
            sVar.i0(y0Var);
            obj2 = y0Var;
        }
        y0 y0Var2 = (y0) obj2;
        boolean zF2 = sVar.f(e1Var) | sVar.h(y0Var2);
        Object objM2 = sVar.M();
        if (zF2 || objM2 == obj) {
            objM2 = new b0.n(17, e1Var, y0Var2);
            sVar.i0(objM2);
        }
        k0.z.d(y0Var2, (xb.l) objM2, sVar);
        if (e1Var.g() && (x0Var = (x0) y0Var2.f11167b.getValue()) != null) {
            e1 e1Var2 = y0Var2.f11168c;
            x0Var.f11162c.f(x0Var.f11164g.invoke(e1Var2.f().b()), x0Var.f11164g.invoke(e1Var2.f().c()), (x) x0Var.f11163f.invoke(e1Var2.f()));
        }
        return y0Var2;
    }

    public static final e1 b(Object obj, String str, k0.s sVar, int i) {
        Object objM = sVar.M();
        k0.y0 y0Var = k0.m.f6974a;
        if (objM == y0Var) {
            objM = new e1(new p5.u(obj), null, str);
            sVar.i0(objM);
        }
        e1 e1Var = (e1) objM;
        e1Var.a(obj, sVar, (i & 8) | 48 | (i & 14));
        Object objM2 = sVar.M();
        if (objM2 == y0Var) {
            objM2 = new a2.m(e1Var, 13);
            sVar.i0(objM2);
        }
        k0.z.d(e1Var, (xb.l) objM2, sVar);
        return e1Var;
    }
}

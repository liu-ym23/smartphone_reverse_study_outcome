package k0;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class s1 {

    /* renamed from: a, reason: collision with root package name */
    public x0 f7061a;

    public s1(xb.a aVar) {
        x0 x0Var = new x0();
        x0Var.f7107a = h5.t.H(aVar);
        VarHandle.storeStoreFence();
        this.f7061a = x0Var;
    }

    public abstract t1 a(Object obj);

    public u2 b() {
        return this.f7061a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final u2 c(t1 t1Var, u2 u2Var) {
        m0 m0Var = null;
        if (u2Var instanceof m0) {
            if (t1Var.f7073b) {
                m0Var = (m0) u2Var;
                m0Var.f6975a.setValue(t1Var.c());
            }
        } else if (u2Var instanceof t2) {
            if ((t1Var.f7072a || t1Var.f7077f != null) && !t1Var.f7073b) {
                t2 t2Var = (t2) u2Var;
                if (yb.k.a(t1Var.c(), t2Var.f7078a)) {
                    m0Var = t2Var;
                }
            }
        } else if (u2Var instanceof f0) {
            t1Var.getClass();
        }
        if (m0Var != null) {
            return m0Var;
        }
        if (!t1Var.f7073b) {
            return new t2(t1Var.c());
        }
        Object obj = t1Var.f7077f;
        y0 y0Var = (y0) t1Var.f7076e;
        if (y0Var == null) {
            y0Var = y0.f7139j;
        }
        k1 k1Var = new k1(obj, y0Var);
        m0 m0Var2 = new m0();
        m0Var2.f6975a = k1Var;
        VarHandle.storeStoreFence();
        return m0Var2;
    }
}

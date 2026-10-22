package b0;

/* loaded from: classes.dex */
public abstract class w1 {

    /* renamed from: a, reason: collision with root package name */
    public final z0 f1391a;

    public w1(p7.a aVar) {
        this.f1391a = new z0(aVar);
    }

    public abstract x1 a(Object obj);

    public e3 b() {
        return this.f1391a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final e3 c(x1 x1Var, e3 e3Var) {
        m0 m0Var = null;
        if (e3Var instanceof m0) {
            if (x1Var.f1421d) {
                m0Var = (m0) e3Var;
                m0Var.f1240a.setValue(x1Var.a());
            }
        } else if (e3Var instanceof d3) {
            if ((x1Var.f1419b || x1Var.f1422e != null) && !x1Var.f1421d) {
                d3 d3Var = (d3) e3Var;
                if (q7.k.a(x1Var.a(), d3Var.f1130a)) {
                    m0Var = d3Var;
                }
            }
        } else if (e3Var instanceof f0) {
            x1Var.getClass();
        }
        if (m0Var != null) {
            return m0Var;
        }
        if (!x1Var.f1421d) {
            return new d3(x1Var.a());
        }
        Object obj = x1Var.f1422e;
        x2 x2Var = x1Var.f1420c;
        if (x2Var == null) {
            x2Var = b1.f1111k;
        }
        return new m0(new o1(obj, x2Var));
    }
}

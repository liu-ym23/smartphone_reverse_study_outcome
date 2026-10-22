package j1;

import b0.s2;
import com.stepos.agentbus.R;

/* loaded from: classes.dex */
public final class n2 implements b0.t, androidx.lifecycle.t {

    /* renamed from: f, reason: collision with root package name */
    public final y f5283f;

    /* renamed from: g, reason: collision with root package name */
    public final b0.x f5284g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f5285h;

    /* renamed from: i, reason: collision with root package name */
    public androidx.lifecycle.x f5286i;

    /* renamed from: j, reason: collision with root package name */
    public p7.n f5287j = e1.f5131a;

    public n2(y yVar, b0.x xVar) {
        this.f5283f = yVar;
        this.f5284g = xVar;
    }

    @Override // androidx.lifecycle.t
    public final void b(androidx.lifecycle.v vVar, androidx.lifecycle.p pVar) {
        if (pVar == androidx.lifecycle.p.ON_DESTROY) {
            c();
        } else {
            if (pVar != androidx.lifecycle.p.ON_CREATE || this.f5285h) {
                return;
            }
            f(this.f5287j);
        }
    }

    public final void c() {
        if (!this.f5285h) {
            this.f5285h = true;
            this.f5283f.getView().setTag(R.id.wrapped_composition_tag, null);
            androidx.lifecycle.x xVar = this.f5286i;
            if (xVar != null) {
                xVar.f(this);
            }
        }
        b0.x xVar2 = this.f5284g;
        synchronized (xVar2.f1396i) {
            try {
                if (xVar2.f1412y.E) {
                    b0.u1.b("Composition is disposed while composing. If dispose is triggered by a call in @Composable function, consider wrapping it with SideEffect block.");
                }
                if (xVar2.f1413z != 3) {
                    xVar2.f1413z = 3;
                    j0.d dVar = b0.i.f1185b;
                    xVar2.f1412y.getClass();
                    boolean z4 = xVar2.f1398k.f1307g > 0;
                    if (z4 || !xVar2.f1397j.f5475f.g()) {
                        i1.a1 a1Var = xVar2.f1411x;
                        try {
                            a1Var.i(xVar2.f1397j, xVar2.f1412y.y());
                            if (z4) {
                                s2 s2VarH = xVar2.f1398k.h();
                                try {
                                    b0.s.f(s2VarH, xVar2.f1411x);
                                    s2VarH.e(true);
                                    xVar2.f1394g.t();
                                    xVar2.f1394g.H();
                                    a1Var.f();
                                } catch (Throwable th) {
                                    s2VarH.e(false);
                                    throw th;
                                }
                            }
                            a1Var.e();
                            a1Var.b();
                        } catch (Throwable th2) {
                            a1Var.b();
                            throw th2;
                        }
                    }
                    xVar2.f1412y.n();
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        b0.j2 j2Var = (b0.j2) xVar2.f1393f;
        synchronized (j2Var.f1207b) {
            if (j2Var.f1210e.remove(xVar2)) {
                j2Var.f1211f = null;
            }
            j2Var.f1213h.i(xVar2);
            j2Var.f1214i.remove(xVar2);
        }
    }

    public final void f(p7.n nVar) {
        this.f5283f.setOnViewTreeOwnersAvailable(new g1.y(7, this, nVar));
    }
}

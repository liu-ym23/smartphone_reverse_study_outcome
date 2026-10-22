package r;

import android.view.View;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class s0 extends q7.m implements p7.o {
    @Override // p7.o
    public final Object j(Object obj, Object obj2, Object obj3) {
        p0 p0Var;
        b0.p pVar = (b0.p) obj2;
        ((Number) obj3).intValue();
        pVar.S(359872873);
        WeakHashMap weakHashMap = p0.f8908u;
        View view = (View) pVar.j(j1.q0.f5303e);
        WeakHashMap weakHashMap2 = p0.f8908u;
        synchronized (weakHashMap2) {
            try {
                Object p0Var2 = weakHashMap2.get(view);
                if (p0Var2 == null) {
                    p0Var2 = new p0(view);
                    weakHashMap2.put(view, p0Var2);
                }
                p0Var = (p0) p0Var2;
            } catch (Throwable th) {
                throw th;
            }
        }
        boolean zH = pVar.h(p0Var) | pVar.h(view);
        Object objJ = pVar.J();
        if (zH || objJ == b0.k.f1229a) {
            objJ = new g1.y(19, p0Var, view);
            pVar.b0(objJ);
        }
        b0.b.d(p0Var, (p7.k) objJ, pVar);
        boolean zF = pVar.f(p0Var);
        Object objJ2 = pVar.J();
        if (zF || objJ2 == b0.k.f1229a) {
            objJ2 = new y(p0Var.f8915g);
            pVar.b0(objJ2);
        }
        y yVar = (y) objJ2;
        pVar.q(false);
        return yVar;
    }
}

package j0;

import b0.p;
import b0.x;
import b0.z1;
import java.util.ArrayList;
import p7.n;
import q7.z;

/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public static final StackTraceElement[] f5084a = new StackTraceElement[0];

    /* renamed from: b, reason: collision with root package name */
    public static final j f5085b = new j(0, new long[0], new Object[0]);

    public static final int a(int i2, int i10) {
        return i2 << (((i10 % 10) * 3) + 1);
    }

    public static final long b() {
        return Thread.currentThread().getId();
    }

    public static final void c(p pVar, n nVar) {
        q7.k.c(nVar, "null cannot be cast to non-null type kotlin.Function2<androidx.compose.runtime.Composer, kotlin.Int, kotlin.Unit>");
        z.c(2, nVar);
        nVar.invoke(pVar, 1);
    }

    public static final d d(int i2, c7.c cVar, p pVar) {
        Object objJ = pVar.J();
        if (objJ == b0.k.f1229a) {
            objJ = new d(i2, true, cVar);
            pVar.b0(objJ);
        }
        d dVar = (d) objJ;
        if (!dVar.f5073h.equals(cVar)) {
            dVar.f5073h = cVar;
            if (dVar.f5072g) {
                z1 z1Var = dVar.f5074i;
                if (z1Var != null) {
                    x xVar = z1Var.f1441a;
                    if (xVar != null) {
                        xVar.n(z1Var, null);
                    }
                    dVar.f5074i = null;
                }
                ArrayList arrayList = dVar.f5075j;
                if (arrayList != null) {
                    int size = arrayList.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        z1 z1Var2 = (z1) arrayList.get(i10);
                        x xVar2 = z1Var2.f1441a;
                        if (xVar2 != null) {
                            xVar2.n(z1Var2, null);
                        }
                    }
                    arrayList.clear();
                }
            }
        }
        return dVar;
    }

    public static final boolean e(z1 z1Var, z1 z1Var2) {
        if (z1Var == null) {
            return true;
        }
        if (z1Var instanceof z1) {
            return !z1Var.b() || z1Var.equals(z1Var2) || q7.k.a(z1Var.f1443c, z1Var2.f1443c);
        }
        return false;
    }
}

package s0;

import java.util.ArrayList;
import k0.m;
import k0.s;
import k0.v1;
import k0.y;
import xb.p;
import yb.x;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static final StackTraceElement[] f11182a = new StackTraceElement[0];

    /* renamed from: b, reason: collision with root package name */
    public static final j f11183b = new j(0, new long[0], new Object[0]);

    public static final int a(int i, int i3) {
        return i << (((i3 % 10) * 3) + 1);
    }

    public static final long b() {
        return Thread.currentThread().getId();
    }

    public static final void c(s sVar, p pVar) {
        pVar.getClass();
        x.c(2, pVar);
        pVar.invoke(sVar, 1);
    }

    public static final c d(int i, jb.b bVar, s sVar) {
        Object objM = sVar.M();
        if (objM == m.f6974a) {
            objM = new c(i, true, bVar);
            sVar.i0(objM);
        }
        c cVar = (c) objM;
        if (!yb.k.a(cVar.f11173g, bVar)) {
            boolean z10 = cVar.f11173g == null;
            cVar.f11173g = bVar;
            if (!z10 && cVar.f11172f) {
                v1 v1Var = cVar.f11174h;
                if (v1Var != null) {
                    y yVar = v1Var.f7088a;
                    if (yVar != null) {
                        yVar.r(v1Var, null);
                    }
                    cVar.f11174h = null;
                }
                ArrayList arrayList = cVar.i;
                if (arrayList != null) {
                    int size = arrayList.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        v1 v1Var2 = (v1) arrayList.get(i3);
                        y yVar2 = v1Var2.f7088a;
                        if (yVar2 != null) {
                            yVar2.r(v1Var2, null);
                        }
                    }
                    arrayList.clear();
                }
            }
        }
        return cVar;
    }

    public static final boolean e(v1 v1Var, v1 v1Var2) {
        return v1Var == null || !v1Var.a() || v1Var.equals(v1Var2) || yb.k.a(v1Var.f7090c, v1Var2.f7090c);
    }
}

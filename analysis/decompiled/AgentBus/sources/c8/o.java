package c8;

import f8.t;
import i8.b0;
import i8.p0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class o {

    /* renamed from: a, reason: collision with root package name */
    public static final b0 f2072a;

    static {
        x9.i iVar = x9.i.f11323a;
        e8.k kVar = new e8.k(x9.i.f11324b, n.f2060e, 1);
        e9.f fVarF = n.f2061f.f();
        u9.b bVar = u9.k.f10207e;
        b0 b0Var = new b0(kVar, fVarF, bVar);
        b0Var.f4752m = 4;
        f8.n nVar = f8.o.f3492e;
        if (nVar == null) {
            b0.j0(9);
            throw null;
        }
        b0Var.f4753n = nVar;
        List listS = a.a.S(p0.J0(b0Var, 2, e9.f.e("T"), 0, bVar));
        if (b0Var.f4755p != null) {
            throw new IllegalStateException("Type parameters are already set for " + b0Var.getName());
        }
        ArrayList arrayList = new ArrayList(listS);
        b0Var.f4755p = arrayList;
        b0Var.f4754o = new v9.i(b0Var, arrayList, b0Var.f4756q, b0Var.f4757r);
        Set set = Collections.EMPTY_SET;
        if (set == null) {
            b0.j0(13);
            throw null;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((i8.i) ((t) it.next())).f4875l = b0Var.k();
        }
        f2072a = b0Var;
    }
}

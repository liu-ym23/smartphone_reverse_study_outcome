package e8;

import d7.b0;
import f8.e0;
import f8.h0;
import i8.a0;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class p implements h0 {

    /* renamed from: a, reason: collision with root package name */
    public final u9.k f3172a;

    /* renamed from: b, reason: collision with root package name */
    public final a0 f3173b;

    /* renamed from: c, reason: collision with root package name */
    public r9.i f3174c;

    /* renamed from: d, reason: collision with root package name */
    public final b0.e f3175d;

    public p(u9.k kVar, k8.b bVar, a0 a0Var) {
        this.f3172a = kVar;
        this.f3173b = a0Var;
        this.f3175d = kVar.c(new r8.c(2, this));
    }

    @Override // f8.h0
    public final boolean a(e9.c cVar) {
        q7.k.e(cVar, "fqName");
        b0.e eVar = this.f3175d;
        Object obj = ((ConcurrentHashMap) eVar.f1133h).get(cVar);
        return ((obj == null || obj == u9.j.f10203g) ? c(cVar) : (e0) eVar.invoke(cVar)) == null;
    }

    @Override // f8.h0
    public final void b(e9.c cVar, ArrayList arrayList) {
        q7.k.e(cVar, "fqName");
        ea.k.a(arrayList, this.f3175d.invoke(cVar));
    }

    public final s9.c c(e9.c cVar) {
        InputStream inputStreamJ;
        q7.k.e(cVar, "fqName");
        if (cVar.h(c8.n.f2065j)) {
            s9.a.f9622m.getClass();
            inputStreamJ = s9.d.j(s9.a.a(cVar));
        } else {
            inputStreamJ = null;
        }
        if (inputStreamJ != null) {
            return n7.b.f(cVar, this.f3172a, this.f3173b, inputStreamJ);
        }
        return null;
    }

    @Override // f8.h0
    public final Collection j(e9.c cVar, p7.k kVar) {
        q7.k.e(cVar, "fqName");
        q7.k.e(kVar, "nameFilter");
        return b0.f2947f;
    }
}

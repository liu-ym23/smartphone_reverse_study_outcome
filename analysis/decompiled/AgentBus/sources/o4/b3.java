package o4;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public final class b3 implements d5.e {

    /* renamed from: a, reason: collision with root package name */
    public final String f7284a;

    /* renamed from: b, reason: collision with root package name */
    public final d5.t f7285b;

    /* renamed from: c, reason: collision with root package name */
    public final t1 f7286c;

    /* renamed from: d, reason: collision with root package name */
    public final c5.c f7287d;

    /* renamed from: e, reason: collision with root package name */
    public final e2 f7288e;

    /* renamed from: f, reason: collision with root package name */
    public final k5.t f7289f;

    /* renamed from: g, reason: collision with root package name */
    public final k5.q f7290g;

    /* renamed from: h, reason: collision with root package name */
    public final String f7291h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f7292i;

    /* renamed from: j, reason: collision with root package name */
    public final d5.m f7293j;

    /* renamed from: k, reason: collision with root package name */
    public final String f7294k;

    /* renamed from: l, reason: collision with root package name */
    public final na.d f7295l;

    /* renamed from: m, reason: collision with root package name */
    public final la.f0 f7296m;

    /* renamed from: n, reason: collision with root package name */
    public final la.j0 f7297n;

    /* renamed from: o, reason: collision with root package name */
    public final la.e0 f7298o;

    /* renamed from: p, reason: collision with root package name */
    public ia.w1 f7299p;

    /* renamed from: q, reason: collision with root package name */
    public t2 f7300q;

    public b3(String str, d5.t tVar, t1 t1Var, c5.c cVar, u uVar, k5.t tVar2, k5.q qVar, k5.a aVar) {
        q7.k.e(tVar, "deployment");
        f1 f1Var = t1Var.f7596x;
        f1 f1Var2 = t1Var.f7597y;
        q7.k.e(cVar, "codec");
        q7.k.e(tVar2, "logger");
        q7.k.e(qVar, "internalBus");
        q7.k.e(aVar, "dispatchers");
        this.f7284a = str;
        this.f7285b = tVar;
        this.f7286c = t1Var;
        this.f7287d = cVar;
        this.f7288e = uVar;
        this.f7289f = tVar2;
        this.f7290g = qVar;
        this.f7291h = "operator";
        this.f7292i = true;
        this.f7293j = d5.m.GATEWAY;
        this.f7294k = "openclaw";
        ia.x1 x1VarC = ia.d0.c();
        this.f7295l = ia.d0.b(ia.f1.plus(x1VarC, aVar.f5616a));
        na.d dVarB = ia.d0.b(ia.f1.plus(x1VarC, ia.n0.f4983b));
        nb.f fVar = new nb.f(2, "operator".equals("node") ? f1Var2.f7345b : f1Var.f7345b, this);
        d5.n nVar = d5.n.f2894c;
        h4.s sVarG = la.k0.g(fVar, 1);
        la.u0 u0VarC = la.k0.c(nVar);
        g7.l lVar = (g7.l) sVarG.f4157i;
        la.j jVar = (la.j) sVarG.f4155g;
        la.i iVar = la.n0.f5967a;
        ia.d0.r(dVarB, lVar, iVar.equals(iVar) ? ia.c0.f4926f : ia.c0.f4929i, new la.a0(iVar, jVar, u0VarC, nVar, (g7.d) null));
        this.f7296m = new la.f0(u0VarC);
        la.u0 u0Var = f1Var.f7345b;
        la.u0 u0Var2 = f1Var2.f7345b;
        la.j0 j0VarB = la.k0.b(0, 256, 5);
        this.f7297n = j0VarB;
        this.f7298o = new la.e0(j0VarB);
    }

    @Override // d5.e
    public final la.j a() {
        return this.f7298o;
    }

    @Override // d5.e
    public final Object b(i7.c cVar) {
        t2 t2Var = this.f7300q;
        if (t2Var != null) {
            t2.f7599m.remove(t2Var);
            t2Var.f7602a.f7620g = null;
            ia.w1 w1Var = t2Var.f7611j;
            if (w1Var != null) {
                ia.f1.cancel$default((ia.g1) w1Var, (CancellationException) null, 1, (Object) null);
            }
            t2Var.f7611j = null;
            ConcurrentHashMap concurrentHashMap = t2Var.f7612k;
            Collection collectionValues = concurrentHashMap.values();
            q7.k.d(collectionValues, "<get-values>(...)");
            Iterator it = collectionValues.iterator();
            while (it.hasNext()) {
                ia.f1.cancel$default((ia.g1) it.next(), (CancellationException) null, 1, (Object) null);
            }
            concurrentHashMap.clear();
            ConcurrentHashMap concurrentHashMap2 = t2Var.f7613l;
            Collection collectionValues2 = concurrentHashMap2.values();
            q7.k.d(collectionValues2, "<get-values>(...)");
            Iterator it2 = collectionValues2.iterator();
            while (it2.hasNext()) {
                ia.f1.cancel$default((ia.g1) it2.next(), (CancellationException) null, 1, (Object) null);
            }
            concurrentHashMap2.clear();
        }
        this.f7300q = null;
        ia.w1 w1Var2 = this.f7299p;
        if (w1Var2 != null) {
            ia.f1.cancel$default((ia.g1) w1Var2, (CancellationException) null, 1, (Object) null);
        }
        this.f7299p = null;
        ia.d0.e(this.f7295l, null);
        return c7.r.f1986a;
    }

    @Override // d5.e
    public final d5.t c() {
        return this.f7285b;
    }

    @Override // d5.e
    public final boolean d() {
        return this.f7292i;
    }

    @Override // d5.e
    public final String e() {
        return d5.d.getClientId(this);
    }

    @Override // d5.e
    public final d5.m f() {
        return this.f7293j;
    }

    @Override // d5.e
    public final String g() {
        return this.f7294k;
    }

    @Override // d5.e
    public final String getId() {
        return this.f7284a;
    }

    @Override // d5.e
    public final la.s0 h() {
        return this.f7296m;
    }

    @Override // d5.e
    public final Object i(c5.b bVar, i7.c cVar) {
        t2 t2Var;
        if (q7.k.a(bVar.d(), "chat.send") && (t2Var = this.f7300q) != null) {
            CopyOnWriteArrayList copyOnWriteArrayList = t2.f7599m;
            t2Var.l(bVar, true);
        }
        la.f0 f0Var = this.f7296m;
        boolean z4 = f0Var.f5918f.getValue() instanceof d5.q;
        c7.r rVar = c7.r.f1986a;
        if (z4) {
            Object objJ = j(bVar, cVar);
            return objJ == h7.a.f4212f ? objJ : rVar;
        }
        String strT = q7.w.f8821a.b(f0Var.f5918f.getValue().getClass()).t();
        String strD = bVar.d();
        if (strD == null) {
            strD = bVar.a();
        }
        k5.s.warn$default(this.f7289f, "OpenClawConn", m.x.l(this.f7284a, " send while not ONLINE (state=", strT, "); dropping ", strD), null, 4, null);
        return rVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(c5.b r13, g7.d r14) {
        /*
            Method dump skipped, instructions count: 338
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.b3.j(c5.b, g7.d):java.lang.Object");
    }
}

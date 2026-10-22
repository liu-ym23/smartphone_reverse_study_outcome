package u5;

import ia.d0;
import ia.f1;
import java.util.concurrent.atomic.AtomicBoolean;
import ka.y;
import la.e0;
import la.f0;
import la.j0;
import la.k0;
import la.s0;
import la.u0;

/* loaded from: classes.dex */
public final class t implements d5.e {

    /* renamed from: a, reason: collision with root package name */
    public final String f10178a;

    /* renamed from: b, reason: collision with root package name */
    public final d5.m f10179b;

    /* renamed from: c, reason: collision with root package name */
    public final String f10180c;

    /* renamed from: d, reason: collision with root package name */
    public final v4.k f10181d;

    /* renamed from: e, reason: collision with root package name */
    public final k5.t f10182e;

    /* renamed from: f, reason: collision with root package name */
    public final na.d f10183f;

    /* renamed from: g, reason: collision with root package name */
    public final u0 f10184g;

    /* renamed from: h, reason: collision with root package name */
    public final j0 f10185h;

    /* renamed from: i, reason: collision with root package name */
    public final j0 f10186i;

    /* renamed from: j, reason: collision with root package name */
    public final ka.g f10187j;

    /* renamed from: k, reason: collision with root package name */
    public final AtomicBoolean f10188k;

    /* renamed from: l, reason: collision with root package name */
    public final f0 f10189l;

    /* renamed from: m, reason: collision with root package name */
    public final e0 f10190m;

    /* renamed from: n, reason: collision with root package name */
    public final e0 f10191n;

    public t(String str, d5.m mVar, String str2, v4.k kVar, k5.a aVar, k5.t tVar) {
        q7.k.e(str, "id");
        q7.k.e(mVar, "role");
        q7.k.e(aVar, "dispatchers");
        q7.k.e(tVar, "logger");
        this.f10178a = str;
        this.f10179b = mVar;
        this.f10180c = str2;
        this.f10181d = kVar;
        this.f10182e = tVar;
        this.f10183f = d0.b(f1.plus(d0.c(), aVar.f5616a));
        new c5.d();
        u0 u0VarC = k0.c(d5.q.f2898a);
        this.f10184g = u0VarC;
        j0 j0VarB = k0.b(0, 64, 5);
        this.f10185h = j0VarB;
        j0 j0VarB2 = k0.b(0, 64, 5);
        this.f10186i = j0VarB2;
        this.f10187j = a.a.b(Integer.MAX_VALUE, 6, null);
        this.f10188k = new AtomicBoolean(false);
        this.f10189l = new f0(u0VarC);
        this.f10190m = new e0(j0VarB);
        this.f10191n = new e0(j0VarB2);
    }

    @Override // d5.e
    public final la.j a() {
        return this.f10190m;
    }

    @Override // d5.e
    public final Object b(i7.c cVar) {
        boolean zCompareAndSet = this.f10188k.compareAndSet(false, true);
        c7.r rVar = c7.r.f1986a;
        if (!zCompareAndSet) {
            return rVar;
        }
        u0 u0Var = this.f10184g;
        u0Var.getClass();
        u0Var.g(null, d5.o.f2895a);
        y.close$default(this.f10187j, null, 1, null);
        d0.e(this.f10183f, null);
        v4.k kVar = this.f10181d;
        d5.l lVar = kVar.f10441k;
        String str = this.f10178a;
        lVar.g(this, str);
        if (this.f10179b == d5.m.NODE) {
            kVar.f10443l.v(str);
        }
        kVar.f10433g.C(new k5.i(str, k5.j.ONLINE, k5.j.DOWN));
        return rVar;
    }

    @Override // d5.e
    public final d5.t c() {
        return d5.d.getDeployment(this);
    }

    @Override // d5.e
    public final boolean d() {
        return d5.d.getAcceptsBusinessRpc(this);
    }

    @Override // d5.e
    public final String e() {
        return this.f10180c;
    }

    @Override // d5.e
    public final d5.m f() {
        return this.f10179b;
    }

    @Override // d5.e
    public final String g() {
        return null;
    }

    @Override // d5.e
    public final String getId() {
        return this.f10178a;
    }

    @Override // d5.e
    public final s0 h() {
        return this.f10189l;
    }

    @Override // d5.e
    public final Object i(c5.b bVar, i7.c cVar) throws Throwable {
        if (!this.f10188k.get()) {
            if (this.f10179b == d5.m.NODE && q7.k.a(bVar.a(), "node.invoke.request")) {
                Object objL = this.f10187j.l(cVar, bVar);
                if (objL == h7.a.f4212f) {
                    return objL;
                }
            } else {
                Object objEmit = this.f10186i.emit(bVar, cVar);
                if (objEmit == h7.a.f4212f) {
                    return objEmit;
                }
            }
        }
        return c7.r.f1986a;
    }

    public final void j() {
        this.f10181d.f10441k.f(this);
        StringBuilder sbP = a1.a.p("REST session attached: ", this.f10178a, " (clientId=", this.f10180c, ", role=");
        sbP.append(this.f10179b);
        sbP.append(")");
        k5.s.info$default(this.f10182e, "RestSession", sbP.toString(), null, 4, null);
    }
}

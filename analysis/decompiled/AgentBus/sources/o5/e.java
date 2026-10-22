package o5;

import b0.z2;
import d5.l;
import d5.m;
import d7.e0;
import ia.d0;
import ia.f1;
import ia.g1;
import ia.w1;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import k5.q;
import k5.s;
import k5.t;
import la.f0;
import la.k0;
import la.u0;
import n7.o;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final l f7742a;

    /* renamed from: b, reason: collision with root package name */
    public final q f7743b;

    /* renamed from: c, reason: collision with root package name */
    public final long f7744c;

    /* renamed from: d, reason: collision with root package name */
    public final t f7745d;

    /* renamed from: e, reason: collision with root package name */
    public final u0 f7746e;

    /* renamed from: f, reason: collision with root package name */
    public final u0 f7747f;

    /* renamed from: g, reason: collision with root package name */
    public final u0 f7748g;

    /* renamed from: h, reason: collision with root package name */
    public final f0 f7749h;

    /* renamed from: i, reason: collision with root package name */
    public final na.d f7750i;

    /* renamed from: j, reason: collision with root package name */
    public w1 f7751j;

    /* renamed from: k, reason: collision with root package name */
    public f f7752k;

    /* renamed from: l, reason: collision with root package name */
    public final Object f7753l;

    public e(l lVar, a7.d dVar, long j2, k5.a aVar, k5.g gVar, u0 u0Var, u0 u0Var2) {
        q7.k.e(lVar, "pool");
        q7.k.e(dVar, "internalBus");
        q7.k.e(aVar, "dispatchers");
        q7.k.e(gVar, "logger");
        this.f7742a = lVar;
        this.f7743b = dVar;
        this.f7744c = j2;
        this.f7745d = gVar;
        this.f7746e = u0Var;
        this.f7747f = u0Var2;
        i iVar = new i("controller not started", System.currentTimeMillis(), j.Auto);
        u0 u0VarC = k0.c(new f(iVar, iVar, iVar, iVar, iVar, iVar, new a(false, false, false)));
        this.f7748g = u0VarC;
        this.f7749h = new f0(u0VarC);
        this.f7750i = d0.b(f1.plus(d0.c(), aVar.f5617b));
        this.f7753l = new Object();
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static o5.f a(boolean r10, boolean r11, boolean r12, o5.k r13, boolean r14) {
        /*
            long r0 = java.lang.System.currentTimeMillis()
            o5.g r3 = new o5.g
            r2 = 0
            r3.<init>(r2)
            if (r14 == 0) goto L13
            o5.g r14 = new o5.g
            r14.<init>(r2)
        L11:
            r4 = r14
            goto L1d
        L13:
            o5.i r14 = new o5.i
            java.lang.String r4 = "no cloud gateway online"
            o5.j r5 = o5.j.Auto
            r14.<init>(r4, r0, r5)
            goto L11
        L1d:
            if (r10 == 0) goto L28
            if (r11 == 0) goto L28
            o5.g r10 = new o5.g
            r10.<init>(r2)
        L26:
            r5 = r10
            goto L4c
        L28:
            if (r10 != 0) goto L36
            if (r11 != 0) goto L36
            o5.i r10 = new o5.i
            java.lang.String r11 = "no gateway and no node online"
            o5.j r14 = o5.j.Auto
            r10.<init>(r11, r0, r14)
            goto L26
        L36:
            if (r10 != 0) goto L42
            o5.i r10 = new o5.i
            java.lang.String r11 = "no gateway online"
            o5.j r14 = o5.j.Auto
            r10.<init>(r11, r0, r14)
            goto L26
        L42:
            o5.i r10 = new o5.i
            java.lang.String r11 = "no node online"
            o5.j r14 = o5.j.Auto
            r10.<init>(r11, r0, r14)
            goto L26
        L4c:
            if (r12 == 0) goto L55
            o5.g r10 = new o5.g
            r10.<init>(r2)
        L53:
            r6 = r10
            goto L5f
        L55:
            o5.i r10 = new o5.i
            java.lang.String r11 = "no channel online"
            o5.j r12 = o5.j.Auto
            r10.<init>(r11, r0, r12)
            goto L53
        L5f:
            if (r13 != 0) goto L69
            o5.g r10 = new o5.g
            r10.<init>(r2)
            r7 = r10
        L67:
            r10 = r2
            goto L9b
        L69:
            java.lang.String r10 = r13.f7767b
            boolean r11 = r13.f7766a
            if (r11 == 0) goto L84
            if (r10 == 0) goto L7b
            boolean r11 = ga.k.t0(r10)
            if (r11 != 0) goto L78
            goto L79
        L78:
            r10 = r2
        L79:
            if (r10 != 0) goto L7d
        L7b:
            java.lang.String r10 = "reconnect"
        L7d:
            o5.g r11 = new o5.g
            r11.<init>(r10)
            r7 = r11
            goto L67
        L84:
            if (r10 == 0) goto L90
            boolean r11 = ga.k.t0(r10)
            if (r11 != 0) goto L8d
            goto L8e
        L8d:
            r10 = r2
        L8e:
            if (r10 != 0) goto L92
        L90:
            java.lang.String r10 = "cloud claw offline"
        L92:
            o5.j r11 = o5.j.Auto
            o5.i r12 = new o5.i
            r12.<init>(r10, r0, r11)
            r7 = r12
            goto L67
        L9b:
            o5.f r2 = new o5.f
            o5.g r8 = new o5.g
            r8.<init>(r10)
            o5.a r9 = new o5.a
            r10 = 0
            r9.<init>(r10, r10, r10)
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: o5.e.a(boolean, boolean, boolean, o5.k, boolean):o5.f");
    }

    public final void b() {
        synchronized (this.f7753l) {
            c();
        }
    }

    public final void c() {
        boolean z4;
        w1 w1Var;
        List<d5.e> list = (List) this.f7742a.f2891e.f5918f.getValue();
        boolean zD = d(d5.t.CLOUD);
        g7.d dVar = null;
        boolean zD2 = d(null);
        boolean z10 = false;
        if (list == null || !list.isEmpty()) {
            for (d5.e eVar : list) {
                if (eVar.f() == m.NODE && (eVar.h().getValue() instanceof d5.q)) {
                    z4 = true;
                    break;
                }
            }
            z4 = false;
        } else {
            z4 = false;
        }
        if (list == null || !list.isEmpty()) {
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                d5.e eVar2 = (d5.e) it.next();
                if (eVar2.f() == m.CHANNEL && (eVar2.h().getValue() instanceof d5.q)) {
                    z10 = true;
                    break;
                }
            }
        }
        f fVarD = a(zD2, z4, z10, (k) this.f7746e.getValue(), zD).d(true, (a) this.f7747f.getValue());
        o oVar = fVarD.f7754a;
        f fVar = (f) this.f7748g.getValue();
        if (fVarD.c(fVar)) {
            return;
        }
        if (!fVarD.b(fVar) || (!(fVar.f7755b instanceof i) && !(fVar.f7756c instanceof i) && !(fVar.f7757d instanceof i) && !(fVar.f7758e instanceof i) && !(fVar.f7759f instanceof i))) {
            w1 w1Var2 = this.f7751j;
            if (w1Var2 != null) {
                f1.cancel$default((g1) w1Var2, (CancellationException) null, 1, (Object) null);
            }
            this.f7752k = null;
            f(fVarD);
            return;
        }
        if (!fVar.f7754a.equals(oVar)) {
            f(f.a(fVar, oVar, null, null, 126));
        }
        f fVar2 = this.f7752k;
        if (fVar2 == null || !fVarD.c(fVar2) || (w1Var = this.f7751j) == null || !w1Var.b()) {
            w1 w1Var3 = this.f7751j;
            if (w1Var3 != null) {
                f1.cancel$default((g1) w1Var3, (CancellationException) null, 1, (Object) null);
            }
            this.f7752k = fVarD;
            this.f7751j = d0.s(this.f7750i, null, null, new a5.b(this, fVarD, dVar, 29), 3);
        }
    }

    public final boolean d(d5.t tVar) {
        Iterable<d5.e> iterable = (Iterable) this.f7742a.f2891e.f5918f.getValue();
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        for (d5.e eVar : iterable) {
            if (eVar.f() == m.GATEWAY && (eVar.h().getValue() instanceof d5.q) && (tVar == null || eVar.c() == tVar)) {
                return true;
            }
        }
        return false;
    }

    public final c5.b e(f fVar) {
        c7.j jVar = new c7.j("version", 2);
        c7.j jVar2 = new c7.j("since", Long.valueOf(System.currentTimeMillis()));
        e7.g gVar = new e7.g();
        gVar.put("service", fVar.f7754a.D());
        gVar.put("chat", fVar.f7755b.D());
        gVar.put("tools", fVar.f7756c.D());
        gVar.put("channel", fVar.f7757d.D());
        gVar.put("upstream", fVar.f7758e.D());
        o oVar = fVar.f7759f;
        a aVar = fVar.f7760g;
        gVar.put("bff", e0.W(oVar.D(), e0.U(new c7.j("wsConnected", Boolean.valueOf(aVar.f7729b)), new c7.j("authed", Boolean.valueOf(aVar.f7730c)))));
        return s9.d.p("stepclaw.status.change", e0.U(jVar, jVar2, new c7.j("resources", gVar.c())));
    }

    public final void f(f fVar) {
        u0 u0Var = this.f7748g;
        f fVar2 = (f) u0Var.getValue();
        u0Var.getClass();
        u0Var.g(null, fVar);
        s.info$default(this.f7745d, "DegradationController", "health " + fVar2 + " → " + fVar, null, 4, null);
        d0.s(this.f7750i, null, null, new z2(this, e(fVar), null, 7), 3);
    }
}

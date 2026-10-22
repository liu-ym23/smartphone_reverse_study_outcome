package i5;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import g5.u;
import h5.d;
import h5.f;
import java.lang.invoke.VarHandle;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import kc.x0;
import l5.g;
import l5.k;
import p5.e;
import p5.i;
import p5.j;
import p5.p;
import td.h;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c implements f, g, h5.a {

    /* renamed from: s, reason: collision with root package name */
    public static final String f5784s = u.f("GreedyScheduler");

    /* renamed from: c, reason: collision with root package name */
    public Context f5785c;

    /* renamed from: f, reason: collision with root package name */
    public HashMap f5786f;

    /* renamed from: g, reason: collision with root package name */
    public a f5787g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f5788h;
    public Object i;

    /* renamed from: j, reason: collision with root package name */
    public p5.c f5789j;

    /* renamed from: k, reason: collision with root package name */
    public d f5790k;

    /* renamed from: l, reason: collision with root package name */
    public e f5791l;

    /* renamed from: m, reason: collision with root package name */
    public g5.a f5792m;

    /* renamed from: n, reason: collision with root package name */
    public HashMap f5793n;

    /* renamed from: o, reason: collision with root package name */
    public Boolean f5794o;

    /* renamed from: p, reason: collision with root package name */
    public ne.b f5795p;

    /* renamed from: q, reason: collision with root package name */
    public i f5796q;

    /* renamed from: r, reason: collision with root package name */
    public i f5797r;

    @Override // l5.g
    public final void a(p pVar, l5.c cVar) {
        e eVar = this.f5791l;
        i iVar = this.f5797r;
        p5.c cVar2 = this.f5789j;
        j jVarR = h.r(pVar);
        boolean z10 = cVar instanceof l5.a;
        String str = f5784s;
        if (z10) {
            if (cVar2.h(jVarR)) {
                return;
            }
            u.d().a(str, "Constraints met: Scheduling work ID " + jVarR);
            h5.j jVarR2 = cVar2.r(jVarR);
            iVar.D(jVarR2);
            eVar.getClass();
            eVar.x(jVarR2, null);
            return;
        }
        u.d().a(str, "Constraints not met: Cancelling work ID " + jVarR);
        h5.j jVarO = cVar2.o(jVarR);
        if (jVarO != null) {
            iVar.l(jVarO);
            int i = ((l5.b) cVar).f7735a;
            eVar.getClass();
            eVar.y(jVarO, i);
        }
    }

    @Override // h5.f
    public final boolean b() {
        return false;
    }

    @Override // h5.f
    public final void c(String str) {
        Runnable runnable;
        if (this.f5794o == null) {
            this.f5794o = Boolean.valueOf(q5.f.a(this.f5785c, this.f5792m));
        }
        boolean zBooleanValue = this.f5794o.booleanValue();
        String str2 = f5784s;
        if (!zBooleanValue) {
            u.d().e(str2, "Ignoring schedule request in non-main process");
            return;
        }
        if (!this.f5788h) {
            this.f5790k.a(this);
            this.f5788h = true;
        }
        u.d().a(str2, "Cancelling work ID " + str);
        a aVar = this.f5787g;
        if (aVar != null && (runnable = (Runnable) aVar.f5781d.remove(str)) != null) {
            ((Handler) aVar.f5779b.f49f).removeCallbacks(runnable);
        }
        for (h5.j jVar : this.f5789j.q(str)) {
            this.f5797r.l(jVar);
            e eVar = this.f5791l;
            eVar.getClass();
            eVar.y(jVar, -512);
        }
    }

    @Override // h5.f
    public final void d(p... pVarArr) {
        long jMax;
        if (this.f5794o == null) {
            this.f5794o = Boolean.valueOf(q5.f.a(this.f5785c, this.f5792m));
        }
        if (!this.f5794o.booleanValue()) {
            u.d().e(f5784s, "Ignoring schedule request in a secondary process");
            return;
        }
        if (!this.f5788h) {
            this.f5790k.a(this);
            this.f5788h = true;
        }
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (p pVar : pVarArr) {
            if (!this.f5789j.h(h.r(pVar))) {
                synchronized (this.i) {
                    try {
                        j jVarR = h.r(pVar);
                        b bVar = (b) this.f5793n.get(jVarR);
                        if (bVar == null) {
                            int i = pVar.f9773k;
                            this.f5792m.f4271d.getClass();
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            bVar = new b();
                            bVar.f5782a = i;
                            bVar.f5783b = jCurrentTimeMillis;
                            VarHandle.storeStoreFence();
                            this.f5793n.put(jVarR, bVar);
                        }
                        jMax = (Math.max((pVar.f9773k - bVar.f5782a) - 5, 0) * 30000) + bVar.f5783b;
                    } finally {
                    }
                }
                long jMax2 = Math.max(pVar.a(), jMax);
                this.f5792m.f4271d.getClass();
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (pVar.f9765b == 1) {
                    if (jCurrentTimeMillis2 < jMax2) {
                        a aVar = this.f5787g;
                        if (aVar != null) {
                            a2.i iVar = aVar.f5779b;
                            HashMap map = aVar.f5781d;
                            Runnable runnable = (Runnable) map.remove(pVar.f9764a);
                            if (runnable != null) {
                                ((Handler) iVar.f49f).removeCallbacks(runnable);
                            }
                            com.stepos.statsrpk.service.d dVar = new com.stepos.statsrpk.service.d(2);
                            dVar.f2886g = aVar;
                            dVar.f2885f = pVar;
                            VarHandle.storeStoreFence();
                            map.put(pVar.f9764a, dVar);
                            aVar.f5780c.getClass();
                            ((Handler) iVar.f49f).postDelayed(dVar, jMax2 - System.currentTimeMillis());
                        }
                    } else if (pVar.b()) {
                        g5.d dVar2 = pVar.f9772j;
                        if (dVar2.f4290d) {
                            u.d().a(f5784s, "Ignoring " + pVar + ". Requires device idle.");
                        } else if (dVar2.i.isEmpty()) {
                            hashSet.add(pVar);
                            hashSet2.add(pVar.f9764a);
                        } else {
                            u.d().a(f5784s, "Ignoring " + pVar + ". Requires ContentUri triggers.");
                        }
                    } else if (!this.f5789j.h(h.r(pVar))) {
                        u.d().a(f5784s, "Starting work for " + pVar.f9764a);
                        p5.c cVar = this.f5789j;
                        cVar.getClass();
                        h5.j jVarR2 = cVar.r(h.r(pVar));
                        this.f5797r.D(jVarR2);
                        e eVar = this.f5791l;
                        eVar.getClass();
                        eVar.x(jVarR2, null);
                    }
                }
            }
        }
        synchronized (this.i) {
            try {
                if (!hashSet.isEmpty()) {
                    u.d().a(f5784s, "Starting tracking for " + TextUtils.join(",", hashSet2));
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        p pVar2 = (p) it.next();
                        j jVarR3 = h.r(pVar2);
                        if (!this.f5786f.containsKey(jVarR3)) {
                            this.f5786f.put(jVarR3, k.a(this.f5795p, pVar2, (kc.p) this.f5796q.f9731f, this));
                        }
                    }
                }
            } finally {
            }
        }
    }

    @Override // h5.a
    public final void e(j jVar, boolean z10) {
        x0 x0Var;
        h5.j jVarO = this.f5789j.o(jVar);
        if (jVarO != null) {
            this.f5797r.l(jVarO);
        }
        synchronized (this.i) {
            x0Var = (x0) this.f5786f.remove(jVar);
        }
        if (x0Var != null) {
            u.d().a(f5784s, "Stopping tracking for " + jVar);
            x0Var.e(null);
        }
        if (z10) {
            return;
        }
        synchronized (this.i) {
            this.f5793n.remove(jVar);
        }
    }
}

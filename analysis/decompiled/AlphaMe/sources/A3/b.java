package A3;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public final class b extends t3.e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f76a;

    /* renamed from: b, reason: collision with root package name */
    public final B3.l f77b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f78c;

    /* renamed from: d, reason: collision with root package name */
    public final t3.h f79d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f80e;

    public b(a aVar) {
        c cVar;
        c cVar2;
        this.f76a = 0;
        this.f77b = new B3.l(1);
        this.f78c = aVar;
        this.f80e = new AtomicBoolean();
        B3.l lVar = aVar.f73d;
        if (lVar.a()) {
            cVar2 = d.f83c;
        } else {
            while (true) {
                ConcurrentLinkedQueue concurrentLinkedQueue = aVar.f72c;
                if (concurrentLinkedQueue.isEmpty()) {
                    cVar = new c(aVar.f70a);
                    lVar.b(cVar);
                    break;
                } else {
                    cVar = (c) concurrentLinkedQueue.poll();
                    if (cVar != null) {
                        break;
                    }
                }
            }
            cVar2 = cVar;
        }
        this.f79d = cVar2;
    }

    @Override // t3.h
    public final boolean a() {
        switch (this.f76a) {
            case 0:
                return this.f77b.a();
            default:
                return ((B3.l) this.f79d).a();
        }
    }

    @Override // t3.e
    public final t3.h b(x3.a aVar) {
        switch (this.f76a) {
            case 0:
                return d(aVar, 0L, null);
            default:
                if (a()) {
                    return G3.f.f653a;
                }
                g gVar = (g) this.f80e;
                e eVar = new e(this, aVar, 0);
                B3.l lVar = (B3.l) this.f78c;
                gVar.getClass();
                p pVar = new p(E3.c.d(eVar), lVar, 0);
                lVar.b(pVar);
                pVar.b(gVar.f118a.submit(pVar));
                return pVar;
        }
    }

    @Override // t3.h
    public final void c() {
        int i4 = this.f76a;
        t3.h hVar = this.f79d;
        switch (i4) {
            case 0:
                if (((AtomicBoolean) this.f80e).compareAndSet(false, true)) {
                    a aVar = (a) this.f78c;
                    c cVar = (c) hVar;
                    aVar.getClass();
                    cVar.f81i = System.nanoTime() + aVar.f71b;
                    aVar.f72c.offer(cVar);
                }
                this.f77b.c();
                break;
            default:
                ((B3.l) hVar).c();
                break;
        }
    }

    @Override // t3.e
    public final t3.h d(x3.a aVar, long j4, TimeUnit timeUnit) {
        G3.e eVar = G3.f.f653a;
        int i4 = this.f76a;
        B3.l lVar = this.f77b;
        switch (i4) {
            case 0:
                if (lVar.a()) {
                    return eVar;
                }
                p pVarG = ((c) this.f79d).g(new y3.f(this, aVar, 2), j4, timeUnit);
                lVar.b(pVarG);
                pVarG.f125a.b(new o(pVarG, lVar, 1));
                return pVarG;
            default:
                if (a()) {
                    return eVar;
                }
                g gVar = (g) this.f80e;
                e eVar2 = new e(this, aVar, 1);
                gVar.getClass();
                p pVar = new p(E3.c.d(eVar2), lVar);
                lVar.b(pVar);
                ScheduledExecutorService scheduledExecutorService = gVar.f118a;
                pVar.b(j4 <= 0 ? scheduledExecutorService.submit(pVar) : scheduledExecutorService.schedule(pVar, j4, timeUnit));
                return pVar;
        }
    }

    public b(g gVar) {
        this.f76a = 1;
        B3.l lVar = new B3.l(0);
        this.f78c = lVar;
        B3.l lVar2 = new B3.l(1);
        this.f77b = lVar2;
        this.f79d = new B3.l(new t3.h[]{lVar, lVar2});
        this.f80e = gVar;
    }
}

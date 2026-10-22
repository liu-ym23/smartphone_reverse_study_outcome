package A3;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class j extends t3.e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f100a;

    /* renamed from: c, reason: collision with root package name */
    public final ConcurrentLinkedQueue f102c = new ConcurrentLinkedQueue();

    /* renamed from: d, reason: collision with root package name */
    public final AtomicInteger f103d = new AtomicInteger();

    /* renamed from: b, reason: collision with root package name */
    public final B3.l f101b = new B3.l(1);

    /* renamed from: e, reason: collision with root package name */
    public final ScheduledExecutorService f104e = k.b();

    public j(Executor executor) {
        this.f100a = executor;
    }

    @Override // t3.h
    public final boolean a() {
        return this.f101b.a();
    }

    @Override // t3.e
    public final t3.h b(x3.a aVar) {
        B3.l lVar = this.f101b;
        if (lVar.a()) {
            return G3.f.f653a;
        }
        p pVar = new p(aVar, lVar);
        lVar.b(pVar);
        this.f102c.offer(pVar);
        AtomicInteger atomicInteger = this.f103d;
        if (atomicInteger.getAndIncrement() == 0) {
            try {
                this.f100a.execute(this);
            } catch (RejectedExecutionException e4) {
                lVar.d(pVar);
                atomicInteger.decrementAndGet();
                E3.c.a(e4);
                throw e4;
            }
        }
        return pVar;
    }

    @Override // t3.h
    public final void c() {
        this.f101b.c();
        this.f102c.clear();
    }

    @Override // t3.e
    public final t3.h d(x3.a aVar, long j4, TimeUnit timeUnit) {
        if (j4 <= 0) {
            return b(aVar);
        }
        B3.l lVar = this.f101b;
        if (lVar.a()) {
            return G3.f.f653a;
        }
        G3.d dVar = new G3.d();
        G3.d dVar2 = new G3.d();
        dVar2.b(dVar);
        lVar.b(dVar2);
        G3.b bVar = new G3.b(new y3.f(this, dVar2, 3));
        p pVar = new p(new i(this, dVar2, aVar, bVar));
        dVar.b(pVar);
        try {
            pVar.b(this.f104e.schedule(pVar, j4, timeUnit));
            return bVar;
        } catch (RejectedExecutionException e4) {
            E3.c.a(e4);
            throw e4;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        do {
            B3.l lVar = this.f101b;
            boolean zA = lVar.a();
            ConcurrentLinkedQueue concurrentLinkedQueue = this.f102c;
            if (zA) {
                concurrentLinkedQueue.clear();
                return;
            }
            p pVar = (p) concurrentLinkedQueue.poll();
            if (pVar == null) {
                return;
            }
            if (!pVar.f125a.a()) {
                if (lVar.a()) {
                    concurrentLinkedQueue.clear();
                    return;
                }
                pVar.run();
            }
        } while (this.f103d.decrementAndGet() != 0);
    }
}

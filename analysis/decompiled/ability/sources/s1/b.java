package s1;

import H4.o;
import cc.dd.ee.kk.ff.c;
import h2.RunnableC1484b;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class b {
    public static final HashMap d = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public ScheduledThreadPoolExecutor f5978a;
    public ConcurrentHashMap b;
    public ConcurrentHashMap c;

    public static synchronized b a(c cVar) {
        b bVar;
        HashMap map = d;
        bVar = (b) map.get(cVar);
        if (bVar == null) {
            String strName = cVar.name();
            bVar = new b();
            bVar.b = new ConcurrentHashMap();
            bVar.c = new ConcurrentHashMap();
            bVar.f5978a = new ScheduledThreadPoolExecutor(1, new E1.b(strName, 1));
            map.put(cVar, bVar);
        }
        return bVar;
    }

    public final void b(AbstractRunnableC1911a abstractRunnableC1911a) {
        try {
            Runnable runnable = (Runnable) this.c.remove(abstractRunnableC1911a);
            if (runnable != null) {
                this.f5978a.remove(runnable);
            }
            ScheduledFuture scheduledFuture = (ScheduledFuture) this.b.remove(abstractRunnableC1911a);
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
        } catch (Throwable th) {
            o.g("APM-AsyncTask", "removeTask failed", th);
        }
    }

    public final void c(AbstractRunnableC1911a abstractRunnableC1911a) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.f5978a;
        if (abstractRunnableC1911a == null) {
            return;
        }
        try {
            RunnableC1484b runnableC1484b = new RunnableC1484b();
            runnableC1484b.b = abstractRunnableC1911a;
            ScheduledFuture<?> scheduledFutureScheduleWithFixedDelay = abstractRunnableC1911a.b ? scheduledThreadPoolExecutor.scheduleWithFixedDelay(runnableC1484b, abstractRunnableC1911a.f5977a, abstractRunnableC1911a.c, TimeUnit.MILLISECONDS) : scheduledThreadPoolExecutor.schedule(runnableC1484b, abstractRunnableC1911a.f5977a, TimeUnit.MILLISECONDS);
            this.c.put(abstractRunnableC1911a, runnableC1484b);
            this.b.put(abstractRunnableC1911a, scheduledFutureScheduleWithFixedDelay);
        } catch (Throwable th) {
            o.g("APM-AsyncTask", "sendTask failed.", th);
        }
    }
}

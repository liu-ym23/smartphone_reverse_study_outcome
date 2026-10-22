package com.amap.api.col.jmsl;

import com.amap.api.col.jmsl.AbstractRunnableC1545d2;
import com.autonavi.aps.amapapi.config.Const;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/* renamed from: com.amap.api.col.jmsl.m2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1581m2 {

    /* renamed from: a, reason: collision with root package name */
    public ThreadPoolExecutor f16747a;

    /* renamed from: b, reason: collision with root package name */
    public String f16748b = "";

    /* renamed from: c, reason: collision with root package name */
    public ConcurrentHashMap<AbstractRunnableC1545d2, Future<?>> f16749c = new ConcurrentHashMap<>();

    /* renamed from: d, reason: collision with root package name */
    public AbstractRunnableC1545d2.a f16750d = new a();

    /* renamed from: com.amap.api.col.jmsl.m2$a */
    public class a implements AbstractRunnableC1545d2.a {
        public a() {
        }

        public final void a(AbstractRunnableC1545d2 abstractRunnableC1545d2) {
            if (!(abstractRunnableC1545d2 instanceof b)) {
                r.i("AMapThreadPool", "[" + AbstractC1581m2.this.f16748b + "] Task started executing | task=" + abstractRunnableC1545d2.getClass().getSimpleName(), false);
                return;
            }
            b bVar = (b) abstractRunnableC1545d2;
            bVar.b();
            r.i("AMapThreadPool", "[" + AbstractC1581m2.this.f16748b + "] Task started executing | task=" + bVar.f(), false);
        }

        public final void b(AbstractRunnableC1545d2 abstractRunnableC1545d2) {
            String simpleName;
            if (abstractRunnableC1545d2 instanceof b) {
                b bVar = (b) abstractRunnableC1545d2;
                long jC = bVar.c();
                simpleName = bVar.f();
                r.i("AMapThreadPool", "[" + AbstractC1581m2.this.f16748b + "] Task finished | task=" + simpleName + " | waitTime=" + (bVar.e() - bVar.d()) + "ms | executeTime=" + jC + Const.SP_KEY_GSM_UPLOAD_MXSIZE, false);
            } else {
                simpleName = abstractRunnableC1545d2.getClass().getSimpleName();
                r.i("AMapThreadPool", "[" + AbstractC1581m2.this.f16748b + "] Task finished | task=" + simpleName, false);
            }
            AbstractC1581m2.this.b(abstractRunnableC1545d2, false);
            AbstractC1581m2.this.d("Task completed (" + simpleName + ")");
        }

        public final void c(AbstractRunnableC1545d2 abstractRunnableC1545d2) {
            String strF = abstractRunnableC1545d2 instanceof b ? ((b) abstractRunnableC1545d2).f() : abstractRunnableC1545d2.getClass().getSimpleName();
            r.i("AMapThreadPool", "[" + AbstractC1581m2.this.f16748b + "] Task cancelled | task=" + strF, false);
            AbstractC1581m2.this.b(abstractRunnableC1545d2, true);
            AbstractC1581m2.this.d("Task cancelled (" + strF + ")");
        }
    }

    /* renamed from: com.amap.api.col.jmsl.m2$b */
    public static class b extends AbstractRunnableC1545d2 {

        /* renamed from: d, reason: collision with root package name */
        public final AbstractRunnableC1545d2 f16752d;

        /* renamed from: e, reason: collision with root package name */
        public long f16753e;

        /* renamed from: f, reason: collision with root package name */
        public long f16754f;

        /* renamed from: g, reason: collision with root package name */
        public long f16755g;

        public b(AbstractRunnableC1545d2 abstractRunnableC1545d2) {
            this.f16752d = abstractRunnableC1545d2;
        }

        public final void a() {
            this.f16753e = System.currentTimeMillis();
        }

        public final void b() {
            this.f16754f = System.currentTimeMillis();
        }

        public final long c() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.f16755g = jCurrentTimeMillis;
            return jCurrentTimeMillis - this.f16754f;
        }

        public final long d() {
            return this.f16753e;
        }

        public final long e() {
            return this.f16754f;
        }

        public final boolean equals(Object obj) {
            return obj instanceof b ? this.f16752d.equals(((b) obj).f16752d) : this.f16752d.equals(obj);
        }

        public final String f() {
            return this.f16752d.getClass().getSimpleName();
        }

        public final int hashCode() {
            return this.f16752d.hashCode();
        }

        @Override // com.amap.api.col.jmsl.AbstractRunnableC1545d2
        public final void runTask() {
            this.f16752d.runTask();
        }

        public final String toString() {
            return this.f16752d.toString();
        }
    }

    public Executor a() {
        return this.f16747a;
    }

    public final synchronized void b(AbstractRunnableC1545d2 abstractRunnableC1545d2, boolean z10) {
        try {
            Future<?> futureRemove = this.f16749c.remove(abstractRunnableC1545d2);
            if (z10 && futureRemove != null) {
                futureRemove.cancel(true);
            }
        } catch (Throwable th) {
            C1541c2.b(th, "TPool", "removeQueue");
            th.printStackTrace();
        }
    }

    public final void d(String str) {
        if (this.f16747a != null) {
            r.i("AMapThreadPool", "[" + this.f16748b + "] " + str + " | pool=" + this.f16747a.getPoolSize() + "/" + this.f16747a.getCorePoolSize() + "/" + this.f16747a.getMaximumPoolSize() + " | active=" + this.f16747a.getActiveCount() + " | queue=" + this.f16747a.getQueue().size() + " | pending=" + this.f16749c.size() + " | completed=" + this.f16747a.getCompletedTaskCount(), false);
        }
    }

    public final synchronized boolean e(AbstractRunnableC1545d2 abstractRunnableC1545d2) {
        boolean zContainsKey;
        try {
            zContainsKey = this.f16749c.containsKey(abstractRunnableC1545d2);
        } catch (Throwable th) {
            C1541c2.b(th, "TPool", "contain");
            th.printStackTrace();
            zContainsKey = false;
        }
        return zContainsKey;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void f(com.amap.api.col.jmsl.AbstractRunnableC1545d2 r7) {
        /*
            Method dump skipped, instructions count: 389
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.jmsl.AbstractC1581m2.f(com.amap.api.col.jmsl.d2):void");
    }
}

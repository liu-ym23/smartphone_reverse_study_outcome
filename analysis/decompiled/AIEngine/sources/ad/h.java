package ad;

import java.util.ArrayDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.connection.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: b, reason: collision with root package name */
    public ThreadPoolExecutor f91b;

    /* renamed from: a, reason: collision with root package name */
    public int f90a = 5;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayDeque<d.a> f92c = new ArrayDeque<>();

    /* renamed from: d, reason: collision with root package name */
    public final ArrayDeque<d.a> f93d = new ArrayDeque<>();

    /* renamed from: e, reason: collision with root package name */
    public final ArrayDeque<okhttp3.internal.connection.d> f94e = new ArrayDeque<>();

    public final synchronized ExecutorService a() {
        ThreadPoolExecutor threadPoolExecutor;
        try {
            if (this.f91b == null) {
                TimeUnit timeUnit = TimeUnit.SECONDS;
                SynchronousQueue synchronousQueue = new SynchronousQueue();
                String name = bd.l.f3239c + " Dispatcher";
                kotlin.jvm.internal.g.f(name, "name");
                this.f91b = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, timeUnit, synchronousQueue, new bd.k(name, false));
            }
            threadPoolExecutor = this.f91b;
            kotlin.jvm.internal.g.c(threadPoolExecutor);
        } catch (Throwable th) {
            throw th;
        }
        return threadPoolExecutor;
    }

    public final void b(ArrayDeque arrayDeque, Object obj) {
        synchronized (this) {
            if (!arrayDeque.remove(obj)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            lb.n nVar = lb.n.f10413a;
        }
        d();
    }

    public final void c(d.a aVar) {
        aVar.f11057b.decrementAndGet();
        b(this.f93d, aVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d() {
        /*
            Method dump skipped, instructions count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ad.h.d():void");
    }
}

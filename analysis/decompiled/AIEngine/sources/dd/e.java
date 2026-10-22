package dd;

import bd.k;
import bd.l;
import com.stepos.common.picker.g;
import java.util.ArrayList;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;
import lb.n;
import okhttp3.f;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: k, reason: collision with root package name */
    public static final Logger f8478k;

    /* renamed from: l, reason: collision with root package name */
    public static final e f8479l;

    /* renamed from: a, reason: collision with root package name */
    public final a f8480a;

    /* renamed from: b, reason: collision with root package name */
    public final Logger f8481b;

    /* renamed from: c, reason: collision with root package name */
    public final ReentrantLock f8482c;

    /* renamed from: d, reason: collision with root package name */
    public final Condition f8483d;

    /* renamed from: e, reason: collision with root package name */
    public int f8484e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f8485f;

    /* renamed from: g, reason: collision with root package name */
    public long f8486g;
    public final ArrayList h;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f8487i;

    /* renamed from: j, reason: collision with root package name */
    public final g f8488j;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final ThreadPoolExecutor f8489a;

        public a(k kVar) {
            this.f8489a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), kVar);
        }

        public final void a(e taskRunner) {
            kotlin.jvm.internal.g.f(taskRunner, "taskRunner");
            taskRunner.f8483d.signal();
        }

        public final void b(e taskRunner, g runnable) {
            kotlin.jvm.internal.g.f(taskRunner, "taskRunner");
            kotlin.jvm.internal.g.f(runnable, "runnable");
            this.f8489a.execute(runnable);
        }
    }

    static {
        Logger logger = Logger.getLogger(e.class.getName());
        kotlin.jvm.internal.g.e(logger, "getLogger(...)");
        f8478k = logger;
        String name = l.f3239c + " TaskRunner";
        kotlin.jvm.internal.g.f(name, "name");
        f8479l = new e(new a(new k(name, true)));
    }

    public e(a aVar) {
        Logger logger = f8478k;
        kotlin.jvm.internal.g.f(logger, "logger");
        this.f8480a = aVar;
        this.f8481b = logger;
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f8482c = reentrantLock;
        Condition conditionNewCondition = reentrantLock.newCondition();
        kotlin.jvm.internal.g.e(conditionNewCondition, "newCondition(...)");
        this.f8483d = conditionNewCondition;
        this.f8484e = 10000;
        this.h = new ArrayList();
        this.f8487i = new ArrayList();
        this.f8488j = new g(this, 1);
    }

    public static final void a(e eVar, dd.a aVar) {
        ReentrantLock reentrantLock = eVar.f8482c;
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        threadCurrentThread.setName(aVar.f8466a);
        try {
            long jA = aVar.a();
            reentrantLock.lock();
            try {
                eVar.b(aVar, jA);
                n nVar = n.f10413a;
                reentrantLock.unlock();
                threadCurrentThread.setName(name);
            } finally {
            }
        } catch (Throwable th) {
            reentrantLock.lock();
            try {
                eVar.b(aVar, -1L);
                n nVar2 = n.f10413a;
                reentrantLock.unlock();
                threadCurrentThread.setName(name);
                throw th;
            } finally {
            }
        }
    }

    public final void b(dd.a aVar, long j10) {
        f fVar = l.f3237a;
        d dVar = aVar.f8468c;
        kotlin.jvm.internal.g.c(dVar);
        if (dVar.f8475d != aVar) {
            throw new IllegalStateException("Check failed.");
        }
        boolean z = dVar.f8477f;
        dVar.f8477f = false;
        dVar.f8475d = null;
        this.h.remove(dVar);
        if (j10 != -1 && !z && !dVar.f8474c) {
            dVar.e(aVar, j10, true);
        }
        if (dVar.f8476e.isEmpty()) {
            return;
        }
        this.f8487i.add(dVar);
    }

    public final dd.a c() {
        long j10;
        dd.a aVar;
        boolean z;
        f fVar = l.f3237a;
        while (true) {
            ArrayList arrayList = this.f8487i;
            if (arrayList.isEmpty()) {
                return null;
            }
            long jNanoTime = System.nanoTime();
            int size = arrayList.size();
            long jMin = Long.MAX_VALUE;
            int i10 = 0;
            dd.a aVar2 = null;
            while (true) {
                if (i10 >= size) {
                    j10 = jNanoTime;
                    aVar = null;
                    z = false;
                    break;
                }
                Object obj = arrayList.get(i10);
                i10++;
                dd.a aVar3 = (dd.a) ((d) obj).f8476e.get(0);
                j10 = jNanoTime;
                aVar = null;
                long jMax = Math.max(0L, aVar3.f8469d - j10);
                if (jMax > 0) {
                    jMin = Math.min(jMax, jMin);
                } else {
                    if (aVar2 != null) {
                        z = true;
                        break;
                    }
                    aVar2 = aVar3;
                }
                jNanoTime = j10;
            }
            ArrayList arrayList2 = this.h;
            a aVar4 = this.f8480a;
            if (aVar2 != null) {
                f fVar2 = l.f3237a;
                aVar2.f8469d = -1L;
                d dVar = aVar2.f8468c;
                kotlin.jvm.internal.g.c(dVar);
                dVar.f8476e.remove(aVar2);
                arrayList.remove(dVar);
                dVar.f8475d = aVar2;
                arrayList2.add(dVar);
                if (z || (!this.f8485f && !arrayList.isEmpty())) {
                    aVar4.b(this, this.f8488j);
                }
                return aVar2;
            }
            if (this.f8485f) {
                if (jMin >= this.f8486g - j10) {
                    return aVar;
                }
                aVar4.a(this);
                return aVar;
            }
            this.f8485f = true;
            this.f8486g = j10 + jMin;
            try {
                try {
                    f fVar3 = l.f3237a;
                    if (jMin > 0) {
                        this.f8483d.awaitNanos(jMin);
                    }
                } catch (InterruptedException unused) {
                    f fVar4 = l.f3237a;
                    for (int size2 = arrayList2.size() - 1; -1 < size2; size2--) {
                        ((d) arrayList2.get(size2)).b();
                    }
                    for (int size3 = arrayList.size() - 1; -1 < size3; size3--) {
                        d dVar2 = (d) arrayList.get(size3);
                        dVar2.b();
                        if (dVar2.f8476e.isEmpty()) {
                            arrayList.remove(size3);
                        }
                    }
                }
            } finally {
                this.f8485f = false;
            }
        }
    }

    public final void d(d taskQueue) {
        kotlin.jvm.internal.g.f(taskQueue, "taskQueue");
        f fVar = l.f3237a;
        if (taskQueue.f8475d == null) {
            boolean zIsEmpty = taskQueue.f8476e.isEmpty();
            ArrayList arrayList = this.f8487i;
            if (zIsEmpty) {
                arrayList.remove(taskQueue);
            } else {
                kotlin.jvm.internal.g.f(arrayList, "<this>");
                if (!arrayList.contains(taskQueue)) {
                    arrayList.add(taskQueue);
                }
            }
        }
        boolean z = this.f8485f;
        a aVar = this.f8480a;
        if (z) {
            aVar.a(this);
        } else {
            aVar.b(this, this.f8488j);
        }
    }

    public final d e() {
        ReentrantLock reentrantLock = this.f8482c;
        reentrantLock.lock();
        try {
            int i10 = this.f8484e;
            this.f8484e = i10 + 1;
            reentrantLock.unlock();
            return new d(this, ai.onnxruntime.providers.a.a(i10, "Q"));
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}

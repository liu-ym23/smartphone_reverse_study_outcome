package xb;

import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import ub.n;
import ub.q;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0003\u001e'\"B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001d\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010*R\u0016\u0010-\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010,R\u0016\u0010.\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010(R\u0016\u0010/\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010(R\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020\b008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u00101R\u001a\u00103\u001a\b\u0012\u0004\u0012\u00020\b008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u00101R\u0014\u00106\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u00105¨\u00067"}, d2 = {"Lxb/d;", "", "Lxb/d$a;", "backend", "Ljava/util/logging/Logger;", "logger", "<init>", "(Lxb/d$a;Ljava/util/logging/Logger;)V", "Lxb/c;", "taskQueue", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lxb/c;)V", "Lxb/a;", "e", "()Lxb/a;", "k", "()Lxb/c;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()V", "task", "f", "(Lxb/a;)V", "", "delayNanos", "", "completedNormally", Const.INTENT_KEY_UMID, "(Lxb/a;JZ)V", "l", Const.INTENT_KEY_APIKEY, "Lxb/d$a;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Lxb/d$a;", Const.INTENT_KEY_PKGNAME, "Ljava/util/logging/Logger;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Ljava/util/logging/Logger;", "", "c", "I", "nextQueueName", "Z", "coordinatorWaiting", "J", "coordinatorWakeUpAt", "executeCallCount", "runCallCount", "", "Ljava/util/List;", "busyQueues", "readyQueues", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "runnable", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: xb.d, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5873d {

    /* renamed from: l, reason: collision with root package name */
    public static final Logger f43621l;

    /* renamed from: m, reason: collision with root package name */
    public static final C5873d f43622m;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final a backend;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Logger logger;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public int nextQueueName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public boolean coordinatorWaiting;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public long coordinatorWakeUpAt;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public int executeCallCount;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public int runCallCount;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final List<C5872c> busyQueues;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final List<C5872c> readyQueues;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final Runnable runnable;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\"\u0004\b\u0000\u0010\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0016À\u0006\u0001"}, d2 = {"Lxb/d$a;", "", "", "e", "()J", "Lxb/d;", "taskRunner", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lxb/d;)V", "nanos", Const.INTENT_KEY_UMID, "(Lxb/d;J)V", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/concurrent/BlockingQueue;", "queue", Const.INTENT_KEY_APIKEY, "(Ljava/util/concurrent/BlockingQueue;)Ljava/util/concurrent/BlockingQueue;", "Ljava/lang/Runnable;", "runnable", "c", "(Lxb/d;Ljava/lang/Runnable;)V", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: xb.d$a */
    public interface a {
        <T> BlockingQueue<T> a(BlockingQueue<T> queue);

        void b(C5873d taskRunner);

        void c(C5873d taskRunner, Runnable runnable);

        void d(C5873d taskRunner, long nanos);

        long e();
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012\"\u0004\b\u0000\u0010\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001e\u001a\u00020\u001a8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lxb/d$c;", "Lxb/d$a;", "Ljava/util/concurrent/ThreadFactory;", "threadFactory", "<init>", "(Ljava/util/concurrent/ThreadFactory;)V", "", "e", "()J", "Lxb/d;", "taskRunner", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lxb/d;)V", "nanos", Const.INTENT_KEY_UMID, "(Lxb/d;J)V", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/concurrent/BlockingQueue;", "queue", Const.INTENT_KEY_APIKEY, "(Ljava/util/concurrent/BlockingQueue;)Ljava/util/concurrent/BlockingQueue;", "Ljava/lang/Runnable;", "runnable", "c", "(Lxb/d;Ljava/lang/Runnable;)V", "Ljava/util/concurrent/ThreadPoolExecutor;", "Ljava/util/concurrent/ThreadPoolExecutor;", "getExecutor", "()Ljava/util/concurrent/ThreadPoolExecutor;", "executor", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: xb.d$c */
    public static final class c implements a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final ThreadPoolExecutor executor;

        public c(ThreadFactory threadFactory) {
            p.i(threadFactory, "threadFactory");
            this.executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory);
        }

        @Override // xb.C5873d.a
        public <T> BlockingQueue<T> a(BlockingQueue<T> queue) {
            p.i(queue, "queue");
            return queue;
        }

        @Override // xb.C5873d.a
        public void b(C5873d taskRunner) {
            p.i(taskRunner, "taskRunner");
            taskRunner.notify();
        }

        @Override // xb.C5873d.a
        public void c(C5873d taskRunner, Runnable runnable) {
            p.i(taskRunner, "taskRunner");
            p.i(runnable, "runnable");
            this.executor.execute(runnable);
        }

        @Override // xb.C5873d.a
        public void d(C5873d taskRunner, long nanos) throws InterruptedException {
            p.i(taskRunner, "taskRunner");
            if (q.f42674b && !Thread.holdsLock(taskRunner)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + taskRunner);
            }
            if (nanos > 0) {
                long j10 = nanos / 1000000;
                long j11 = nanos - (1000000 * j10);
                if (j10 > 0 || nanos > 0) {
                    taskRunner.wait(j10, (int) j11);
                }
            }
        }

        @Override // xb.C5873d.a
        public long e() {
            return System.nanoTime();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"xb/d$d", "Ljava/lang/Runnable;", "LY8/t;", "run", "()V", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: xb.d$d, reason: collision with other inner class name */
    public static final class RunnableC0551d implements Runnable {
        public RunnableC0551d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC5870a abstractC5870aE;
            long jE;
            AbstractC5870a abstractC5870aE2;
            C5873d c5873d = C5873d.this;
            synchronized (c5873d) {
                c5873d.runCallCount++;
                abstractC5870aE = c5873d.e();
            }
            if (abstractC5870aE == null) {
                return;
            }
            Thread threadCurrentThread = Thread.currentThread();
            String name = threadCurrentThread.getName();
            while (true) {
                try {
                    threadCurrentThread.setName(abstractC5870aE.getName());
                    Logger logger = C5873d.this.getLogger();
                    C5872c queue = abstractC5870aE.getQueue();
                    p.f(queue);
                    boolean zIsLoggable = logger.isLoggable(Level.FINE);
                    if (zIsLoggable) {
                        jE = queue.getTaskRunner().getBackend().e();
                        C5871b.c(logger, abstractC5870aE, queue, "starting");
                    } else {
                        jE = -1;
                    }
                    try {
                        long jF = abstractC5870aE.f();
                        if (zIsLoggable) {
                            C5871b.c(logger, abstractC5870aE, queue, "finished run in " + C5871b.b(queue.getTaskRunner().getBackend().e() - jE));
                        }
                        C5873d c5873d2 = C5873d.this;
                        synchronized (c5873d2) {
                            c5873d2.d(abstractC5870aE, jF, true);
                            abstractC5870aE2 = c5873d2.e();
                        }
                        if (abstractC5870aE2 == null) {
                            return;
                        } else {
                            abstractC5870aE = abstractC5870aE2;
                        }
                    } catch (Throwable th) {
                        if (zIsLoggable) {
                            C5871b.c(logger, abstractC5870aE, queue, "failed a run in " + C5871b.b(queue.getTaskRunner().getBackend().e() - jE));
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    try {
                        C5873d c5873d3 = C5873d.this;
                        synchronized (c5873d3) {
                            c5873d3.d(abstractC5870aE, -1L, false);
                            t tVar = t.f7040a;
                            if (!(th2 instanceof InterruptedException)) {
                                throw th2;
                            }
                            Thread.currentThread().interrupt();
                            return;
                        }
                    } finally {
                        threadCurrentThread.setName(name);
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Logger logger = Logger.getLogger(C5873d.class.getName());
        p.h(logger, "getLogger(...)");
        f43621l = logger;
        f43622m = new C5873d(new c(q.q(q.f42675c + " TaskRunner", true)), 0 == true ? 1 : 0, 2, 0 == true ? 1 : 0);
    }

    public C5873d(a backend, Logger logger) {
        p.i(backend, "backend");
        p.i(logger, "logger");
        this.backend = backend;
        this.logger = logger;
        this.nextQueueName = 10000;
        this.busyQueues = new ArrayList();
        this.readyQueues = new ArrayList();
        this.runnable = new RunnableC0551d();
    }

    public final void d(AbstractC5870a task, long delayNanos, boolean completedNormally) {
        if (q.f42674b && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        C5872c queue = task.getQueue();
        p.f(queue);
        if (queue.getActiveTask() != task) {
            throw new IllegalStateException("Check failed.");
        }
        boolean zF = queue.getCancelActiveTask();
        queue.p(false);
        queue.o(null);
        this.busyQueues.remove(queue);
        if (delayNanos != -1 && !zF && !queue.getShutdown()) {
            queue.n(task, delayNanos, true);
        }
        if (queue.g().isEmpty()) {
            return;
        }
        this.readyQueues.add(queue);
        if (completedNormally) {
            return;
        }
        l();
    }

    public final AbstractC5870a e() {
        boolean z10;
        if (q.f42674b && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        while (!this.readyQueues.isEmpty()) {
            long jE = this.backend.e();
            Iterator<C5872c> it = this.readyQueues.iterator();
            long jMin = Long.MAX_VALUE;
            AbstractC5870a abstractC5870a = null;
            while (true) {
                if (!it.hasNext()) {
                    z10 = false;
                    break;
                }
                AbstractC5870a abstractC5870a2 = it.next().g().get(0);
                long jMax = Math.max(0L, abstractC5870a2.getNextExecuteNanoTime() - jE);
                if (jMax > 0) {
                    jMin = Math.min(jMax, jMin);
                } else {
                    if (abstractC5870a != null) {
                        z10 = true;
                        break;
                    }
                    abstractC5870a = abstractC5870a2;
                }
            }
            if (abstractC5870a != null) {
                f(abstractC5870a);
                if (z10 || (!this.coordinatorWaiting && !this.readyQueues.isEmpty())) {
                    l();
                }
                return abstractC5870a;
            }
            if (this.coordinatorWaiting) {
                if (jMin < this.coordinatorWakeUpAt - jE) {
                    this.backend.b(this);
                }
                return null;
            }
            this.coordinatorWaiting = true;
            this.coordinatorWakeUpAt = jE + jMin;
            try {
                try {
                    this.backend.d(this, jMin);
                } catch (InterruptedException unused) {
                    g();
                }
            } finally {
                this.coordinatorWaiting = false;
            }
        }
        return null;
    }

    public final void f(AbstractC5870a task) {
        if (q.f42674b && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        task.g(-1L);
        C5872c queue = task.getQueue();
        p.f(queue);
        queue.g().remove(task);
        this.readyQueues.remove(queue);
        queue.o(task);
        this.busyQueues.add(queue);
    }

    public final void g() {
        if (q.f42674b && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        int size = this.busyQueues.size();
        while (true) {
            size--;
            if (-1 >= size) {
                break;
            } else {
                this.busyQueues.get(size).b();
            }
        }
        for (int size2 = this.readyQueues.size() - 1; -1 < size2; size2--) {
            C5872c c5872c = this.readyQueues.get(size2);
            c5872c.b();
            if (c5872c.g().isEmpty()) {
                this.readyQueues.remove(size2);
            }
        }
    }

    /* renamed from: h, reason: from getter */
    public final a getBackend() {
        return this.backend;
    }

    /* renamed from: i, reason: from getter */
    public final Logger getLogger() {
        return this.logger;
    }

    public final void j(C5872c taskQueue) {
        p.i(taskQueue, "taskQueue");
        if (q.f42674b && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        if (taskQueue.getActiveTask() == null) {
            if (taskQueue.g().isEmpty()) {
                this.readyQueues.remove(taskQueue);
            } else {
                n.a(this.readyQueues, taskQueue);
            }
        }
        if (this.coordinatorWaiting) {
            this.backend.b(this);
        } else {
            l();
        }
    }

    public final C5872c k() {
        int i10;
        synchronized (this) {
            i10 = this.nextQueueName;
            this.nextQueueName = i10 + 1;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append('Q');
        sb2.append(i10);
        return new C5872c(this, sb2.toString());
    }

    public final void l() {
        if (!q.f42674b || Thread.holdsLock(this)) {
            int i10 = this.executeCallCount;
            if (i10 > this.runCallCount) {
                return;
            }
            this.executeCallCount = i10 + 1;
            this.backend.c(this, this.runnable);
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
    }

    public /* synthetic */ C5873d(a aVar, Logger logger, int i10, i iVar) {
        this(aVar, (i10 & 2) != 0 ? f43621l : logger);
    }
}

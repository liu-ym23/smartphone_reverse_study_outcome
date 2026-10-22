package xb;

import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import ub.q;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0010!\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\n2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u000f¢\u0006\u0004\b\u0011\u0010\u0012J7\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\u00132\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000f¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u0018\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0013H\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\f¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\f¢\u0006\u0004\b\u001c\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u0013H\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001f\u0010 R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001a\u0010!\u001a\u0004\b\"\u0010#R\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001d\u0010$\u001a\u0004\b%\u0010 R\"\u0010*\u001a\u00020\u00138\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010&\u001a\u0004\b'\u0010\u001e\"\u0004\b(\u0010)R$\u00101\u001a\u0004\u0018\u00010\b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R \u00106\u001a\b\u0012\u0004\u0012\u00020\b028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b-\u00103\u001a\u0004\b4\u00105R\"\u00109\u001a\u00020\u00138\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b7\u0010&\u001a\u0004\b7\u0010\u001e\"\u0004\b8\u0010)¨\u0006:"}, d2 = {"Lxb/c;", "", "Lxb/d;", "taskRunner", "", "name", "<init>", "(Lxb/d;Ljava/lang/String;)V", "Lxb/a;", "task", "", "delayNanos", "LY8/t;", "l", "(Lxb/a;J)V", "Lkotlin/Function0;", "block", "k", "(Ljava/lang/String;JLp9/a;)V", "", "cancelable", "c", "(Ljava/lang/String;JZLp9/a;)V", "recurrence", "n", "(Lxb/a;JZ)Z", Const.INTENT_KEY_APIKEY, "()V", "q", Const.INTENT_KEY_PKGNAME, "()Z", "toString", "()Ljava/lang/String;", "Lxb/d;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Lxb/d;", "Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "setShutdown$okhttp", "(Z)V", "shutdown", Const.INTENT_KEY_UMID, "Lxb/a;", "e", "()Lxb/a;", "o", "(Lxb/a;)V", "activeTask", "", "Ljava/util/List;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Ljava/util/List;", "futureTasks", "f", "p", "cancelActiveTask", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: xb.c, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5872c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final C5873d taskRunner;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final String name;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public boolean shutdown;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public AbstractC5870a activeTask;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final List<AbstractC5870a> futureTasks;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public boolean cancelActiveTask;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"xb/c$a", "Lxb/a;", "", "f", "()J", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: xb.c$a */
    public static final class a extends AbstractC5870a {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ InterfaceC5063a<t> f43618e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, boolean z10, InterfaceC5063a<t> interfaceC5063a) {
            super(str, z10);
            this.f43618e = interfaceC5063a;
        }

        @Override // xb.AbstractC5870a
        public long f() {
            this.f43618e.invoke();
            return -1L;
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"xb/c$b", "Lxb/a;", "", "f", "()J", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: xb.c$b */
    public static final class b extends AbstractC5870a {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ InterfaceC5063a<Long> f43619e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, InterfaceC5063a<Long> interfaceC5063a) {
            super(str, false, 2, null);
            this.f43619e = interfaceC5063a;
        }

        @Override // xb.AbstractC5870a
        public long f() {
            return this.f43619e.invoke().longValue();
        }
    }

    public C5872c(C5873d taskRunner, String name) {
        p.i(taskRunner, "taskRunner");
        p.i(name, "name");
        this.taskRunner = taskRunner;
        this.name = name;
        this.futureTasks = new ArrayList();
    }

    public static /* synthetic */ void d(C5872c c5872c, String str, long j10, boolean z10, InterfaceC5063a interfaceC5063a, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        long j11 = j10;
        if ((i10 & 4) != 0) {
            z10 = true;
        }
        c5872c.c(str, j11, z10, interfaceC5063a);
    }

    public static /* synthetic */ void m(C5872c c5872c, AbstractC5870a abstractC5870a, long j10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        c5872c.l(abstractC5870a, j10);
    }

    public final void a() {
        C5873d c5873d = this.taskRunner;
        if (q.f42674b && Thread.holdsLock(c5873d)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + c5873d);
        }
        synchronized (this.taskRunner) {
            try {
                if (b()) {
                    this.taskRunner.j(this);
                }
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean b() {
        AbstractC5870a abstractC5870a = this.activeTask;
        if (abstractC5870a != null) {
            p.f(abstractC5870a);
            if (abstractC5870a.getCancelable()) {
                this.cancelActiveTask = true;
            }
        }
        boolean z10 = false;
        for (int size = this.futureTasks.size() - 1; -1 < size; size--) {
            if (this.futureTasks.get(size).getCancelable()) {
                Logger logger = this.taskRunner.getLogger();
                AbstractC5870a abstractC5870a2 = this.futureTasks.get(size);
                if (logger.isLoggable(Level.FINE)) {
                    C5871b.c(logger, abstractC5870a2, this, "canceled");
                }
                this.futureTasks.remove(size);
                z10 = true;
            }
        }
        return z10;
    }

    public final void c(String name, long delayNanos, boolean cancelable, InterfaceC5063a<t> block) {
        p.i(name, "name");
        p.i(block, "block");
        l(new a(name, cancelable, block), delayNanos);
    }

    /* renamed from: e, reason: from getter */
    public final AbstractC5870a getActiveTask() {
        return this.activeTask;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getCancelActiveTask() {
        return this.cancelActiveTask;
    }

    public final List<AbstractC5870a> g() {
        return this.futureTasks;
    }

    /* renamed from: h, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: i, reason: from getter */
    public final boolean getShutdown() {
        return this.shutdown;
    }

    /* renamed from: j, reason: from getter */
    public final C5873d getTaskRunner() {
        return this.taskRunner;
    }

    public final void k(String name, long delayNanos, InterfaceC5063a<Long> block) {
        p.i(name, "name");
        p.i(block, "block");
        l(new b(name, block), delayNanos);
    }

    public final void l(AbstractC5870a task, long delayNanos) {
        p.i(task, "task");
        synchronized (this.taskRunner) {
            if (!this.shutdown) {
                if (n(task, delayNanos, false)) {
                    this.taskRunner.j(this);
                }
                t tVar = t.f7040a;
            } else if (task.getCancelable()) {
                Logger logger = this.taskRunner.getLogger();
                if (logger.isLoggable(Level.FINE)) {
                    C5871b.c(logger, task, this, "schedule canceled (queue is shutdown)");
                }
            } else {
                Logger logger2 = this.taskRunner.getLogger();
                if (logger2.isLoggable(Level.FINE)) {
                    C5871b.c(logger2, task, this, "schedule failed (queue is shutdown)");
                }
                throw new RejectedExecutionException();
            }
        }
    }

    public final boolean n(AbstractC5870a task, long delayNanos, boolean recurrence) {
        String str;
        p.i(task, "task");
        task.e(this);
        long jE = this.taskRunner.getBackend().e();
        long j10 = jE + delayNanos;
        int iIndexOf = this.futureTasks.indexOf(task);
        if (iIndexOf != -1) {
            if (task.getNextExecuteNanoTime() <= j10) {
                Logger logger = this.taskRunner.getLogger();
                if (logger.isLoggable(Level.FINE)) {
                    C5871b.c(logger, task, this, "already scheduled");
                }
                return false;
            }
            this.futureTasks.remove(iIndexOf);
        }
        task.g(j10);
        Logger logger2 = this.taskRunner.getLogger();
        if (logger2.isLoggable(Level.FINE)) {
            if (recurrence) {
                str = "run again after " + C5871b.b(j10 - jE);
            } else {
                str = "scheduled after " + C5871b.b(j10 - jE);
            }
            C5871b.c(logger2, task, this, str);
        }
        Iterator<AbstractC5870a> it = this.futureTasks.iterator();
        int size = 0;
        while (true) {
            if (!it.hasNext()) {
                size = -1;
                break;
            }
            if (it.next().getNextExecuteNanoTime() - jE > delayNanos) {
                break;
            }
            size++;
        }
        if (size == -1) {
            size = this.futureTasks.size();
        }
        this.futureTasks.add(size, task);
        return size == 0;
    }

    public final void o(AbstractC5870a abstractC5870a) {
        this.activeTask = abstractC5870a;
    }

    public final void p(boolean z10) {
        this.cancelActiveTask = z10;
    }

    public final void q() {
        C5873d c5873d = this.taskRunner;
        if (q.f42674b && Thread.holdsLock(c5873d)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + c5873d);
        }
        synchronized (this.taskRunner) {
            try {
                this.shutdown = true;
                if (b()) {
                    this.taskRunner.j(this);
                }
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String toString() {
        return this.name;
    }
}

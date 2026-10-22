package D0;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import s.AbstractC0831a;
import t0.J;

/* loaded from: classes.dex */
public abstract class h implements D1.a {

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f386d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* renamed from: e, reason: collision with root package name */
    public static final Logger f387e = Logger.getLogger(h.class.getName());

    /* renamed from: f, reason: collision with root package name */
    public static final J f388f;

    /* renamed from: g, reason: collision with root package name */
    public static final Object f389g;

    /* renamed from: a, reason: collision with root package name */
    public volatile Object f390a;

    /* renamed from: b, reason: collision with root package name */
    public volatile c f391b;

    /* renamed from: c, reason: collision with root package name */
    public volatile g f392c;

    static {
        J fVar;
        try {
            fVar = new d(AtomicReferenceFieldUpdater.newUpdater(g.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(g.class, g.class, "b"), AtomicReferenceFieldUpdater.newUpdater(h.class, g.class, "c"), AtomicReferenceFieldUpdater.newUpdater(h.class, c.class, "b"), AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "a"));
            th = null;
        } catch (Throwable th) {
            th = th;
            fVar = new f();
        }
        f388f = fVar;
        if (th != null) {
            f387e.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f389g = new Object();
    }

    public static void c(h hVar) {
        c cVar;
        c cVar2;
        c cVar3 = null;
        while (true) {
            g gVar = hVar.f392c;
            if (f388f.i(hVar, gVar, g.f383c)) {
                while (gVar != null) {
                    Thread thread = gVar.f384a;
                    if (thread != null) {
                        gVar.f384a = null;
                        LockSupport.unpark(thread);
                    }
                    gVar = gVar.f385b;
                }
                do {
                    cVar = hVar.f391b;
                } while (!f388f.g(hVar, cVar, c.f372d));
                while (true) {
                    cVar2 = cVar3;
                    cVar3 = cVar;
                    if (cVar3 == null) {
                        break;
                    }
                    cVar = cVar3.f375c;
                    cVar3.f375c = cVar2;
                }
                while (cVar2 != null) {
                    cVar3 = cVar2.f375c;
                    Runnable runnable = cVar2.f373a;
                    if (runnable instanceof e) {
                        e eVar = (e) runnable;
                        hVar = eVar.f381a;
                        if (hVar.f390a == eVar) {
                            if (f388f.h(hVar, eVar, f(eVar.f382b))) {
                                break;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        d(runnable, cVar2.f374b);
                    }
                    cVar2 = cVar3;
                }
                return;
            }
        }
    }

    public static void d(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e4) {
            f387e.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e4);
        }
    }

    public static Object e(Object obj) throws ExecutionException {
        if (obj instanceof a) {
            Throwable th = ((a) obj).f369b;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        }
        if (obj instanceof b) {
            throw new ExecutionException(((b) obj).f371a);
        }
        if (obj == f389g) {
            return null;
        }
        return obj;
    }

    public static Object f(D1.a aVar) {
        if (aVar instanceof h) {
            Object obj = ((h) aVar).f390a;
            if (!(obj instanceof a)) {
                return obj;
            }
            a aVar2 = (a) obj;
            return aVar2.f368a ? aVar2.f369b != null ? new a(aVar2.f369b, false) : a.f367d : obj;
        }
        boolean zIsCancelled = aVar.isCancelled();
        if ((!f386d) && zIsCancelled) {
            return a.f367d;
        }
        try {
            Object objG = g(aVar);
            return objG == null ? f389g : objG;
        } catch (CancellationException e4) {
            if (zIsCancelled) {
                return new a(e4, false);
            }
            return new b(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + aVar, e4));
        } catch (ExecutionException e5) {
            return new b(e5.getCause());
        } catch (Throwable th) {
            return new b(th);
        }
    }

    public static Object g(Future future) {
        Object obj;
        boolean z4 = false;
        while (true) {
            try {
                obj = future.get();
                break;
            } catch (InterruptedException unused) {
                z4 = true;
            } catch (Throwable th) {
                if (z4) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z4) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    @Override // D1.a
    public final void a(Runnable runnable, Executor executor) {
        executor.getClass();
        c cVar = this.f391b;
        c cVar2 = c.f372d;
        if (cVar != cVar2) {
            c cVar3 = new c(runnable, executor);
            do {
                cVar3.f375c = cVar;
                if (f388f.g(this, cVar, cVar3)) {
                    return;
                } else {
                    cVar = this.f391b;
                }
            } while (cVar != cVar2);
        }
        d(runnable, executor);
    }

    public final void b(StringBuilder sb) {
        try {
            Object objG = g(this);
            sb.append("SUCCESS, result=[");
            sb.append(objG == this ? "this future" : String.valueOf(objG));
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e4) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e4.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e5) {
            sb.append("FAILURE, cause=[");
            sb.append(e5.getCause());
            sb.append("]");
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z4) {
        Object obj = this.f390a;
        if (!(obj == null) && !(obj instanceof e)) {
            return false;
        }
        a aVar = f386d ? new a(new CancellationException("Future.cancel() was called."), z4) : z4 ? a.f366c : a.f367d;
        boolean z5 = false;
        while (true) {
            if (f388f.h(this, obj, aVar)) {
                c(this);
                if (!(obj instanceof e)) {
                    return true;
                }
                D1.a aVar2 = ((e) obj).f382b;
                if (!(aVar2 instanceof h)) {
                    aVar2.cancel(z4);
                    return true;
                }
                this = (h) aVar2;
                obj = this.f390a;
                if (!(obj == null) && !(obj instanceof e)) {
                    return true;
                }
                z5 = true;
            } else {
                obj = this.f390a;
                if (!(obj instanceof e)) {
                    return z5;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b5  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x00a8 -> B:36:0x0074). Please report as a decompilation issue!!! */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object get(long r20, java.util.concurrent.TimeUnit r22) throws java.lang.InterruptedException, java.util.concurrent.TimeoutException {
        /*
            Method dump skipped, instructions count: 357
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: D0.h.get(long, java.util.concurrent.TimeUnit):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String h() {
        Object obj = this.f390a;
        if (obj instanceof e) {
            StringBuilder sb = new StringBuilder("setFuture=[");
            D1.a aVar = ((e) obj).f382b;
            return B0.g.r(sb, aVar == this ? "this future" : String.valueOf(aVar), "]");
        }
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public final void i(g gVar) {
        gVar.f384a = null;
        while (true) {
            g gVar2 = this.f392c;
            if (gVar2 == g.f383c) {
                return;
            }
            g gVar3 = null;
            while (gVar2 != null) {
                g gVar4 = gVar2.f385b;
                if (gVar2.f384a != null) {
                    gVar3 = gVar2;
                } else if (gVar3 != null) {
                    gVar3.f385b = gVar4;
                    if (gVar3.f384a == null) {
                        break;
                    }
                } else if (!f388f.i(this, gVar2, gVar4)) {
                    break;
                }
                gVar2 = gVar4;
            }
            return;
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f390a instanceof a;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return (!(r2 instanceof e)) & (this.f390a != null);
    }

    public final String toString() {
        String strH;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (this.f390a instanceof a) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            b(sb);
        } else {
            try {
                strH = h();
            } catch (RuntimeException e4) {
                strH = "Exception thrown from implementation: " + e4.getClass();
            }
            if (strH != null && !strH.isEmpty()) {
                AbstractC0831a.h(sb, "PENDING, info=[", strH, "]");
            } else if (isDone()) {
                b(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f390a;
            if ((obj2 != null) & (!(obj2 instanceof e))) {
                return e(obj2);
            }
            g gVar = this.f392c;
            g gVar2 = g.f383c;
            if (gVar != gVar2) {
                g gVar3 = new g();
                do {
                    J j4 = f388f;
                    j4.F(gVar3, gVar);
                    if (j4.i(this, gVar, gVar3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f390a;
                            } else {
                                i(gVar3);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof e))));
                        return e(obj);
                    }
                    gVar = this.f392c;
                } while (gVar != gVar2);
            }
            return e(this.f390a);
        }
        throw new InterruptedException();
    }
}

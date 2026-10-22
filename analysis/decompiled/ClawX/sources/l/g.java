package l;

import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import k4.v;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class g implements Future {
    public static final boolean d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* renamed from: e, reason: collision with root package name */
    public static final Logger f3720e = Logger.getLogger(g.class.getName());

    /* renamed from: f, reason: collision with root package name */
    public static final v f3721f;

    /* renamed from: g, reason: collision with root package name */
    public static final Object f3722g;

    /* renamed from: a, reason: collision with root package name */
    public volatile Object f3723a;

    /* renamed from: b, reason: collision with root package name */
    public volatile c f3724b;

    /* renamed from: c, reason: collision with root package name */
    public volatile f f3725c;

    static {
        v eVar;
        try {
            eVar = new d(AtomicReferenceFieldUpdater.newUpdater(f.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(f.class, f.class, "b"), AtomicReferenceFieldUpdater.newUpdater(g.class, f.class, "c"), AtomicReferenceFieldUpdater.newUpdater(g.class, c.class, "b"), AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "a"));
            th = null;
        } catch (Throwable th) {
            th = th;
            eVar = new e();
        }
        f3721f = eVar;
        if (th != null) {
            f3720e.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f3722g = new Object();
    }

    public static void b(g gVar) {
        f fVar;
        c cVar;
        do {
            fVar = gVar.f3725c;
        } while (!f3721f.j(gVar, fVar, f.f3717c));
        while (fVar != null) {
            Thread thread = fVar.f3718a;
            if (thread != null) {
                fVar.f3718a = null;
                LockSupport.unpark(thread);
            }
            fVar = fVar.f3719b;
        }
        do {
            cVar = gVar.f3724b;
        } while (!f3721f.h(gVar, cVar));
        c cVar2 = null;
        while (cVar != null) {
            c cVar3 = cVar.f3712a;
            cVar.f3712a = cVar2;
            cVar2 = cVar;
            cVar = cVar3;
        }
        while (cVar2 != null) {
            cVar2 = cVar2.f3712a;
            try {
                throw null;
            } catch (RuntimeException e9) {
                f3720e.log(Level.SEVERE, "RuntimeException while executing runnable null with executor null", (Throwable) e9);
            }
        }
    }

    public static Object c(Object obj) throws ExecutionException {
        if (obj instanceof a) {
            Throwable th = ((a) obj).f3710a;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        }
        if (obj instanceof b) {
            throw new ExecutionException((Throwable) null);
        }
        if (obj == f3722g) {
            return null;
        }
        return obj;
    }

    public static Object d(g gVar) {
        Object obj;
        boolean z = false;
        while (true) {
            try {
                obj = gVar.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    public final void a(StringBuilder sb) {
        try {
            Object objD = d(this);
            sb.append("SUCCESS, result=[");
            sb.append(objD == this ? "this future" : String.valueOf(objD));
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e9) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e9.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e10) {
            sb.append("FAILURE, cause=[");
            sb.append(e10.getCause());
            sb.append("]");
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        Object obj = this.f3723a;
        if (obj != null) {
            return false;
        }
        if (!f3721f.i(this, obj, d ? new a(new CancellationException("Future.cancel() was called."), z) : z ? a.f3708b : a.f3709c)) {
            return false;
        }
        b(this);
        return true;
    }

    public final void e(f fVar) {
        fVar.f3718a = null;
        while (true) {
            f fVar2 = this.f3725c;
            if (fVar2 == f.f3717c) {
                return;
            }
            f fVar3 = null;
            while (fVar2 != null) {
                f fVar4 = fVar2.f3719b;
                if (fVar2.f3718a != null) {
                    fVar3 = fVar2;
                } else if (fVar3 != null) {
                    fVar3.f3719b = fVar4;
                    if (fVar3.f3718a == null) {
                        break;
                    }
                } else if (!f3721f.j(this, fVar2, fVar4)) {
                    break;
                }
                fVar2 = fVar4;
            }
            return;
        }
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j4, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        f fVar = f.f3717c;
        long nanos = timeUnit.toNanos(j4);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f3723a;
        if (obj != null) {
            return c(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            f fVar2 = this.f3725c;
            if (fVar2 != fVar) {
                f fVar3 = new f();
                do {
                    v vVar = f3721f;
                    vVar.d0(fVar3, fVar2);
                    if (vVar.j(this, fVar2, fVar3)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                e(fVar3);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f3723a;
                            if (obj2 != null) {
                                return c(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        e(fVar3);
                    } else {
                        fVar2 = this.f3725c;
                    }
                } while (fVar2 != fVar);
            }
            return c(this.f3723a);
        }
        while (nanos > 0) {
            Object obj3 = this.f3723a;
            if (obj3 != null) {
                return c(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = jNanoTime - System.nanoTime();
        }
        String string = toString();
        String string2 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = string2.toLowerCase(locale);
        String strN = "Waited " + j4 + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String strN2 = a8.b.n(strN, " (plus ");
            long j8 = -nanos;
            long jConvert = timeUnit.convert(j8, TimeUnit.NANOSECONDS);
            long nanos2 = j8 - timeUnit.toNanos(jConvert);
            boolean z = jConvert == 0 || nanos2 > 1000;
            if (jConvert > 0) {
                String strN3 = strN2 + jConvert + " " + lowerCase;
                if (z) {
                    strN3 = a8.b.n(strN3, ",");
                }
                strN2 = a8.b.n(strN3, " ");
            }
            if (z) {
                strN2 = strN2 + nanos2 + " nanoseconds ";
            }
            strN = a8.b.n(strN2, "delay)");
        }
        if (isDone()) {
            throw new TimeoutException(a8.b.n(strN, " but future completed as timeout expired"));
        }
        throw new TimeoutException(a8.b.o(strN, " for ", string));
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f3723a instanceof a;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f3723a != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (this.f3723a instanceof a) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            a(sb);
        } else {
            try {
                if (this instanceof ScheduledFuture) {
                    str = "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
                } else {
                    str = null;
                }
            } catch (RuntimeException e9) {
                str = "Exception thrown from implementation: " + e9.getClass();
            }
            if (str != null && !str.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(str);
                sb.append("]");
            } else if (isDone()) {
                a(sb);
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
        f fVar = f.f3717c;
        if (!Thread.interrupted()) {
            Object obj2 = this.f3723a;
            if (obj2 != null) {
                return c(obj2);
            }
            f fVar2 = this.f3725c;
            if (fVar2 != fVar) {
                f fVar3 = new f();
                do {
                    v vVar = f3721f;
                    vVar.d0(fVar3, fVar2);
                    if (vVar.j(this, fVar2, fVar3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f3723a;
                            } else {
                                e(fVar3);
                                throw new InterruptedException();
                            }
                        } while (obj == null);
                        return c(obj);
                    }
                    fVar2 = this.f3725c;
                } while (fVar2 != fVar);
            }
            return c(this.f3723a);
        }
        throw new InterruptedException();
    }
}

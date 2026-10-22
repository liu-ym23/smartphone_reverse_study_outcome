package g2;

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

/* loaded from: classes.dex */
public abstract class g implements Future {

    /* renamed from: i, reason: collision with root package name */
    public static final boolean f3789i = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* renamed from: j, reason: collision with root package name */
    public static final Logger f3790j = Logger.getLogger(g.class.getName());

    /* renamed from: k, reason: collision with root package name */
    public static final ib.c f3791k;

    /* renamed from: l, reason: collision with root package name */
    public static final Object f3792l;

    /* renamed from: f, reason: collision with root package name */
    public volatile Object f3793f;

    /* renamed from: g, reason: collision with root package name */
    public volatile c f3794g;

    /* renamed from: h, reason: collision with root package name */
    public volatile f f3795h;

    static {
        ib.c eVar;
        try {
            eVar = new d(AtomicReferenceFieldUpdater.newUpdater(f.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(f.class, f.class, "b"), AtomicReferenceFieldUpdater.newUpdater(g.class, f.class, "h"), AtomicReferenceFieldUpdater.newUpdater(g.class, c.class, "g"), AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "f"));
            th = null;
        } catch (Throwable th) {
            th = th;
            eVar = new e();
        }
        f3791k = eVar;
        if (th != null) {
            f3790j.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f3792l = new Object();
    }

    public static void b(g gVar) {
        f fVar;
        c cVar;
        do {
            fVar = gVar.f3795h;
        } while (!f3791k.m(gVar, fVar, f.f3786c));
        while (fVar != null) {
            Thread thread = fVar.f3787a;
            if (thread != null) {
                fVar.f3787a = null;
                LockSupport.unpark(thread);
            }
            fVar = fVar.f3788b;
        }
        do {
            cVar = gVar.f3794g;
        } while (!f3791k.k(gVar, cVar));
        c cVar2 = null;
        while (cVar != null) {
            c cVar3 = cVar.f3780a;
            cVar.f3780a = cVar2;
            cVar2 = cVar;
            cVar = cVar3;
        }
        while (cVar2 != null) {
            cVar2 = cVar2.f3780a;
            try {
                throw null;
            } catch (RuntimeException e10) {
                f3790j.log(Level.SEVERE, "RuntimeException while executing runnable null with executor null", (Throwable) e10);
            }
        }
    }

    public static Object c(Object obj) throws ExecutionException {
        if (obj instanceof a) {
            Throwable th = ((a) obj).f3778a;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        }
        if (obj instanceof b) {
            throw new ExecutionException((Throwable) null);
        }
        if (obj == f3792l) {
            return null;
        }
        return obj;
    }

    public static Object d(g gVar) {
        Object obj;
        boolean z4 = false;
        while (true) {
            try {
                obj = gVar.get();
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

    public final void a(StringBuilder sb2) {
        try {
            Object objD = d(this);
            sb2.append("SUCCESS, result=[");
            sb2.append(objD == this ? "this future" : String.valueOf(objD));
            sb2.append("]");
        } catch (CancellationException unused) {
            sb2.append("CANCELLED");
        } catch (RuntimeException e10) {
            sb2.append("UNKNOWN, cause=[");
            sb2.append(e10.getClass());
            sb2.append(" thrown from get()]");
        } catch (ExecutionException e11) {
            sb2.append("FAILURE, cause=[");
            sb2.append(e11.getCause());
            sb2.append("]");
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z4) {
        Object obj = this.f3793f;
        if (obj != null) {
            return false;
        }
        if (!f3791k.l(this, obj, f3789i ? new a(new CancellationException("Future.cancel() was called."), z4) : z4 ? a.f3776b : a.f3777c)) {
            return false;
        }
        b(this);
        return true;
    }

    public final void e(f fVar) {
        fVar.f3787a = null;
        while (true) {
            f fVar2 = this.f3795h;
            if (fVar2 == f.f3786c) {
                return;
            }
            f fVar3 = null;
            while (fVar2 != null) {
                f fVar4 = fVar2.f3788b;
                if (fVar2.f3787a != null) {
                    fVar3 = fVar2;
                } else if (fVar3 != null) {
                    fVar3.f3788b = fVar4;
                    if (fVar3.f3787a == null) {
                        break;
                    }
                } else if (!f3791k.m(this, fVar2, fVar4)) {
                    break;
                }
                fVar2 = fVar4;
            }
            return;
        }
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j2, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        f fVar = f.f3786c;
        long nanos = timeUnit.toNanos(j2);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f3793f;
        if (obj != null) {
            return c(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            f fVar2 = this.f3795h;
            if (fVar2 != fVar) {
                f fVar3 = new f();
                do {
                    ib.c cVar = f3791k;
                    cVar.H(fVar3, fVar2);
                    if (cVar.m(this, fVar2, fVar3)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                e(fVar3);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f3793f;
                            if (obj2 != null) {
                                return c(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        e(fVar3);
                    } else {
                        fVar2 = this.f3795h;
                    }
                } while (fVar2 != fVar);
            }
            return c(this.f3793f);
        }
        while (nanos > 0) {
            Object obj3 = this.f3793f;
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
        String strI = "Waited " + j2 + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String strI2 = a1.a.i(strI, " (plus ");
            long j4 = -nanos;
            long jConvert = timeUnit.convert(j4, TimeUnit.NANOSECONDS);
            long nanos2 = j4 - timeUnit.toNanos(jConvert);
            boolean z4 = jConvert == 0 || nanos2 > 1000;
            if (jConvert > 0) {
                String strI3 = strI2 + jConvert + " " + lowerCase;
                if (z4) {
                    strI3 = a1.a.i(strI3, ",");
                }
                strI2 = a1.a.i(strI3, " ");
            }
            if (z4) {
                strI2 = strI2 + nanos2 + " nanoseconds ";
            }
            strI = a1.a.i(strI2, "delay)");
        }
        if (isDone()) {
            throw new TimeoutException(a1.a.i(strI, " but future completed as timeout expired"));
        }
        throw new TimeoutException(a1.a.x(strI, " for ", string));
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f3793f instanceof a;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f3793f != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append("[status=");
        if (this.f3793f instanceof a) {
            sb2.append("CANCELLED");
        } else if (isDone()) {
            a(sb2);
        } else {
            try {
                if (this instanceof ScheduledFuture) {
                    str = "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
                } else {
                    str = null;
                }
            } catch (RuntimeException e10) {
                str = "Exception thrown from implementation: " + e10.getClass();
            }
            if (str != null && !str.isEmpty()) {
                sb2.append("PENDING, info=[");
                sb2.append(str);
                sb2.append("]");
            } else if (isDone()) {
                a(sb2);
            } else {
                sb2.append("PENDING");
            }
        }
        sb2.append("]");
        return sb2.toString();
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException {
        Object obj;
        f fVar = f.f3786c;
        if (!Thread.interrupted()) {
            Object obj2 = this.f3793f;
            if (obj2 != null) {
                return c(obj2);
            }
            f fVar2 = this.f3795h;
            if (fVar2 != fVar) {
                f fVar3 = new f();
                do {
                    ib.c cVar = f3791k;
                    cVar.H(fVar3, fVar2);
                    if (cVar.m(this, fVar2, fVar3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f3793f;
                            } else {
                                e(fVar3);
                                throw new InterruptedException();
                            }
                        } while (obj == null);
                        return c(obj);
                    }
                    fVar2 = this.f3795h;
                } while (fVar2 != fVar);
            }
            return c(this.f3793f);
        }
        throw new InterruptedException();
    }
}

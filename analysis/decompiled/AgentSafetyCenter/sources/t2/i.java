package t2;

import java.lang.invoke.VarHandle;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class i implements l7.a {

    /* renamed from: h, reason: collision with root package name */
    public static final boolean f13153h = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    public static final Logger i = Logger.getLogger(i.class.getName());

    /* renamed from: j, reason: collision with root package name */
    public static final a f13154j;

    /* renamed from: k, reason: collision with root package name */
    public static final Object f13155k;

    /* renamed from: c, reason: collision with root package name */
    public volatile Object f13156c;

    /* renamed from: f, reason: collision with root package name */
    public volatile e f13157f;

    /* renamed from: g, reason: collision with root package name */
    public volatile h f13158g;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        g gVar;
        try {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdaterNewUpdater = AtomicReferenceFieldUpdater.newUpdater(h.class, Thread.class, "a");
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdaterNewUpdater2 = AtomicReferenceFieldUpdater.newUpdater(h.class, h.class, "b");
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdaterNewUpdater3 = AtomicReferenceFieldUpdater.newUpdater(i.class, h.class, "g");
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdaterNewUpdater4 = AtomicReferenceFieldUpdater.newUpdater(i.class, e.class, "f");
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdaterNewUpdater5 = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "c");
            f fVar = new f();
            fVar.f13145a = atomicReferenceFieldUpdaterNewUpdater;
            fVar.f13146b = atomicReferenceFieldUpdaterNewUpdater2;
            fVar.f13147c = atomicReferenceFieldUpdaterNewUpdater3;
            fVar.f13148d = atomicReferenceFieldUpdaterNewUpdater4;
            fVar.f13149e = atomicReferenceFieldUpdaterNewUpdater5;
            VarHandle.storeStoreFence();
            th = null;
            gVar = fVar;
        } catch (Throwable th) {
            th = th;
            gVar = new g();
        }
        f13154j = gVar;
        if (th != null) {
            i.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f13155k = new Object();
    }

    public static void c(i iVar) {
        h hVar;
        e eVar;
        e eVar2;
        e eVar3;
        do {
            hVar = iVar.f13158g;
        } while (!f13154j.g(iVar, hVar, h.f13150c));
        while (true) {
            eVar = null;
            if (hVar == null) {
                break;
            }
            Thread thread = hVar.f13151a;
            if (thread != null) {
                hVar.f13151a = null;
                LockSupport.unpark(thread);
            }
            hVar = hVar.f13152b;
        }
        do {
            eVar2 = iVar.f13157f;
        } while (!f13154j.e(iVar, eVar2, e.f13141d));
        while (true) {
            eVar3 = eVar;
            eVar = eVar2;
            if (eVar == null) {
                break;
            }
            eVar2 = eVar.f13144c;
            eVar.f13144c = eVar3;
        }
        while (eVar3 != null) {
            e eVar4 = eVar3.f13144c;
            d(eVar3.f13142a, eVar3.f13143b);
            eVar3 = eVar4;
        }
    }

    public static void d(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e10) {
            i.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e10);
        }
    }

    public static Object e(Object obj) throws ExecutionException {
        if (obj instanceof b) {
            Throwable th = ((b) obj).f13138a;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        }
        if (obj instanceof d) {
            throw new ExecutionException(((d) obj).f13140a);
        }
        if (obj == f13155k) {
            return null;
        }
        return obj;
    }

    public static Object f(i iVar) {
        Object obj;
        boolean z10 = false;
        while (true) {
            try {
                obj = iVar.get();
                break;
            } catch (InterruptedException unused) {
                z10 = true;
            } catch (Throwable th) {
                if (z10) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    public final void a(StringBuilder sb2) {
        try {
            Object objF = f(this);
            sb2.append("SUCCESS, result=[");
            sb2.append(objF == this ? "this future" : String.valueOf(objF));
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

    public final void b(Runnable runnable, Executor executor) {
        executor.getClass();
        e eVar = this.f13157f;
        e eVar2 = e.f13141d;
        if (eVar != eVar2) {
            e eVar3 = new e(runnable, executor);
            do {
                eVar3.f13144c = eVar;
                if (f13154j.e(this, eVar, eVar3)) {
                    return;
                } else {
                    eVar = this.f13157f;
                }
            } while (eVar != eVar2);
        }
        d(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z10) {
        Object obj = this.f13156c;
        if (obj != null) {
            return false;
        }
        if (!f13154j.f(this, obj, f13153h ? new b(new CancellationException("Future.cancel() was called."), z10) : z10 ? b.f13136b : b.f13137c)) {
            return false;
        }
        c(this);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String g() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j10, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        h hVar = h.f13150c;
        long nanos = timeUnit.toNanos(j10);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f13156c;
        if (obj != null) {
            return e(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            h hVar2 = this.f13158g;
            if (hVar2 != hVar) {
                h hVar3 = new h();
                do {
                    a aVar = f13154j;
                    aVar.m(hVar3, hVar2);
                    if (aVar.g(this, hVar2, hVar3)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                h(hVar3);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f13156c;
                            if (obj2 != null) {
                                return e(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        h(hVar3);
                    } else {
                        hVar2 = this.f13158g;
                    }
                } while (hVar2 != hVar);
            }
            return e(this.f13156c);
        }
        while (nanos > 0) {
            Object obj3 = this.f13156c;
            if (obj3 != null) {
                return e(obj3);
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
        String strConcat = "Waited " + j10 + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String strConcat2 = strConcat.concat(" (plus ");
            long j11 = -nanos;
            long jConvert = timeUnit.convert(j11, TimeUnit.NANOSECONDS);
            long nanos2 = j11 - timeUnit.toNanos(jConvert);
            boolean z10 = jConvert == 0 || nanos2 > 1000;
            if (jConvert > 0) {
                String strConcat3 = strConcat2 + jConvert + " " + lowerCase;
                if (z10) {
                    strConcat3 = strConcat3.concat(",");
                }
                strConcat2 = strConcat3.concat(" ");
            }
            if (z10) {
                strConcat2 = strConcat2 + nanos2 + " nanoseconds ";
            }
            strConcat = strConcat2.concat("delay)");
        }
        if (isDone()) {
            throw new TimeoutException(strConcat.concat(" but future completed as timeout expired"));
        }
        throw new TimeoutException(k0.a.o(strConcat, " for ", string));
    }

    public final void h(h hVar) {
        hVar.f13151a = null;
        while (true) {
            h hVar2 = this.f13158g;
            if (hVar2 == h.f13150c) {
                return;
            }
            h hVar3 = null;
            while (hVar2 != null) {
                h hVar4 = hVar2.f13152b;
                if (hVar2.f13151a != null) {
                    hVar3 = hVar2;
                } else if (hVar3 != null) {
                    hVar3.f13152b = hVar4;
                    if (hVar3.f13151a == null) {
                        break;
                    }
                } else if (!f13154j.g(this, hVar2, hVar4)) {
                    break;
                }
                hVar2 = hVar4;
            }
            return;
        }
    }

    public boolean i(Throwable th) {
        if (!f13154j.f(this, null, new d(th))) {
            return false;
        }
        c(this);
        return true;
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f13156c instanceof b;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f13156c != null;
    }

    public final String toString() {
        String strG;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append("[status=");
        if (this.f13156c instanceof b) {
            sb2.append("CANCELLED");
        } else if (isDone()) {
            a(sb2);
        } else {
            try {
                strG = g();
            } catch (RuntimeException e10) {
                strG = "Exception thrown from implementation: " + e10.getClass();
            }
            if (strG != null && !strG.isEmpty()) {
                sb2.append("PENDING, info=[");
                sb2.append(strG);
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
        h hVar = h.f13150c;
        if (!Thread.interrupted()) {
            Object obj2 = this.f13156c;
            if (obj2 != null) {
                return e(obj2);
            }
            h hVar2 = this.f13158g;
            if (hVar2 != hVar) {
                h hVar3 = new h();
                do {
                    a aVar = f13154j;
                    aVar.m(hVar3, hVar2);
                    if (aVar.g(this, hVar2, hVar3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f13156c;
                            } else {
                                h(hVar3);
                                throw new InterruptedException();
                            }
                        } while (obj == null);
                        return e(obj);
                    }
                    hVar2 = this.f13158g;
                } while (hVar2 != hVar);
            }
            return e(this.f13156c);
        }
        throw new InterruptedException();
    }
}

package androidx.concurrent.futures;

import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class AbstractResolvableFuture<V> implements c5.a<V> {

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f1000d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* renamed from: e, reason: collision with root package name */
    public static final Logger f1001e = Logger.getLogger(AbstractResolvableFuture.class.getName());
    public static final a h;

    /* renamed from: j, reason: collision with root package name */
    public static final Object f1002j;

    /* renamed from: a, reason: collision with root package name */
    public volatile Object f1003a;

    /* renamed from: b, reason: collision with root package name */
    public volatile c f1004b;

    /* renamed from: c, reason: collision with root package name */
    public volatile g f1005c;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Failure {

        /* renamed from: a, reason: collision with root package name */
        public final Throwable f1006a;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        /* renamed from: androidx.concurrent.futures.AbstractResolvableFuture$Failure$1, reason: invalid class name */
        public class AnonymousClass1 extends Throwable {
            @Override // java.lang.Throwable
            public final synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        static {
            new Failure(new AnonymousClass1("Failure occurred while trying to finish a future."));
        }

        public Failure(Throwable th) {
            boolean z = AbstractResolvableFuture.f1000d;
            th.getClass();
            this.f1006a = th;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class a {
        public abstract boolean a(AbstractResolvableFuture<?> abstractResolvableFuture, c cVar, c cVar2);

        public abstract boolean b(AbstractResolvableFuture<?> abstractResolvableFuture, Object obj, Object obj2);

        public abstract boolean c(AbstractResolvableFuture<?> abstractResolvableFuture, g gVar, g gVar2);

        public abstract void d(g gVar, g gVar2);

        public abstract void e(g gVar, Thread thread);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b {

        /* renamed from: b, reason: collision with root package name */
        public static final b f1007b;

        /* renamed from: c, reason: collision with root package name */
        public static final b f1008c;

        /* renamed from: a, reason: collision with root package name */
        public final Throwable f1009a;

        static {
            if (AbstractResolvableFuture.f1000d) {
                f1008c = null;
                f1007b = null;
            } else {
                f1008c = new b(false, null);
                f1007b = new b(true, null);
            }
        }

        public b(boolean z, Throwable th) {
            this.f1009a = th;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class c {

        /* renamed from: d, reason: collision with root package name */
        public static final c f1010d = new c(null, null);

        /* renamed from: a, reason: collision with root package name */
        public final Runnable f1011a;

        /* renamed from: b, reason: collision with root package name */
        public final Executor f1012b;

        /* renamed from: c, reason: collision with root package name */
        public c f1013c;

        public c(Runnable runnable, Executor executor) {
            this.f1011a = runnable;
            this.f1012b = executor;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class d extends a {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<g, Thread> f1014a;

        /* renamed from: b, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<g, g> f1015b;

        /* renamed from: c, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<AbstractResolvableFuture, g> f1016c;

        /* renamed from: d, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<AbstractResolvableFuture, c> f1017d;

        /* renamed from: e, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<AbstractResolvableFuture, Object> f1018e;

        public d(AtomicReferenceFieldUpdater<g, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<g, g> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractResolvableFuture, g> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractResolvableFuture, c> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<AbstractResolvableFuture, Object> atomicReferenceFieldUpdater5) {
            this.f1014a = atomicReferenceFieldUpdater;
            this.f1015b = atomicReferenceFieldUpdater2;
            this.f1016c = atomicReferenceFieldUpdater3;
            this.f1017d = atomicReferenceFieldUpdater4;
            this.f1018e = atomicReferenceFieldUpdater5;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.a
        public final boolean a(AbstractResolvableFuture<?> abstractResolvableFuture, c cVar, c cVar2) {
            AtomicReferenceFieldUpdater<AbstractResolvableFuture, c> atomicReferenceFieldUpdater;
            do {
                atomicReferenceFieldUpdater = this.f1017d;
                if (atomicReferenceFieldUpdater.compareAndSet(abstractResolvableFuture, cVar, cVar2)) {
                    return true;
                }
            } while (atomicReferenceFieldUpdater.get(abstractResolvableFuture) == cVar);
            return false;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.a
        public final boolean b(AbstractResolvableFuture<?> abstractResolvableFuture, Object obj, Object obj2) {
            AtomicReferenceFieldUpdater<AbstractResolvableFuture, Object> atomicReferenceFieldUpdater;
            do {
                atomicReferenceFieldUpdater = this.f1018e;
                if (atomicReferenceFieldUpdater.compareAndSet(abstractResolvableFuture, obj, obj2)) {
                    return true;
                }
            } while (atomicReferenceFieldUpdater.get(abstractResolvableFuture) == obj);
            return false;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.a
        public final boolean c(AbstractResolvableFuture<?> abstractResolvableFuture, g gVar, g gVar2) {
            AtomicReferenceFieldUpdater<AbstractResolvableFuture, g> atomicReferenceFieldUpdater;
            do {
                atomicReferenceFieldUpdater = this.f1016c;
                if (atomicReferenceFieldUpdater.compareAndSet(abstractResolvableFuture, gVar, gVar2)) {
                    return true;
                }
            } while (atomicReferenceFieldUpdater.get(abstractResolvableFuture) == gVar);
            return false;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.a
        public final void d(g gVar, g gVar2) {
            this.f1015b.lazySet(gVar, gVar2);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.a
        public final void e(g gVar, Thread thread) {
            this.f1014a.lazySet(gVar, thread);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class e<V> implements Runnable {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class f extends a {
        @Override // androidx.concurrent.futures.AbstractResolvableFuture.a
        public final boolean a(AbstractResolvableFuture<?> abstractResolvableFuture, c cVar, c cVar2) {
            synchronized (abstractResolvableFuture) {
                try {
                    if (abstractResolvableFuture.f1004b != cVar) {
                        return false;
                    }
                    abstractResolvableFuture.f1004b = cVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.a
        public final boolean b(AbstractResolvableFuture<?> abstractResolvableFuture, Object obj, Object obj2) {
            synchronized (abstractResolvableFuture) {
                try {
                    if (abstractResolvableFuture.f1003a != obj) {
                        return false;
                    }
                    abstractResolvableFuture.f1003a = obj2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.a
        public final boolean c(AbstractResolvableFuture<?> abstractResolvableFuture, g gVar, g gVar2) {
            synchronized (abstractResolvableFuture) {
                try {
                    if (abstractResolvableFuture.f1005c != gVar) {
                        return false;
                    }
                    abstractResolvableFuture.f1005c = gVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.a
        public final void d(g gVar, g gVar2) {
            gVar.f1021b = gVar2;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.a
        public final void e(g gVar, Thread thread) {
            gVar.f1020a = thread;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class g {

        /* renamed from: c, reason: collision with root package name */
        public static final g f1019c = new g();

        /* renamed from: a, reason: collision with root package name */
        public volatile Thread f1020a;

        /* renamed from: b, reason: collision with root package name */
        public volatile g f1021b;

        public g() {
            AbstractResolvableFuture.h.e(this, Thread.currentThread());
        }
    }

    static {
        a fVar;
        try {
            fVar = new d(AtomicReferenceFieldUpdater.newUpdater(g.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(g.class, g.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, g.class, "c"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, c.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, Object.class, "a"));
            th = null;
        } catch (Throwable th) {
            th = th;
            fVar = new f();
        }
        h = fVar;
        if (th != null) {
            f1001e.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f1002j = new Object();
    }

    public static void c(AbstractResolvableFuture<?> abstractResolvableFuture) {
        g gVar;
        c cVar;
        do {
            gVar = abstractResolvableFuture.f1005c;
        } while (!h.c(abstractResolvableFuture, gVar, g.f1019c));
        while (gVar != null) {
            Thread thread = gVar.f1020a;
            if (thread != null) {
                gVar.f1020a = null;
                LockSupport.unpark(thread);
            }
            gVar = gVar.f1021b;
        }
        do {
            cVar = abstractResolvableFuture.f1004b;
        } while (!h.a(abstractResolvableFuture, cVar, c.f1010d));
        c cVar2 = null;
        while (cVar != null) {
            c cVar3 = cVar.f1013c;
            cVar.f1013c = cVar2;
            cVar2 = cVar;
            cVar = cVar3;
        }
        while (cVar2 != null) {
            c cVar4 = cVar2.f1013c;
            Runnable runnable = cVar2.f1011a;
            if (runnable instanceof e) {
                throw null;
            }
            d(runnable, cVar2.f1012b);
            cVar2 = cVar4;
        }
    }

    public static void d(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e10) {
            f1001e.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e10);
        }
    }

    public static Object e(Object obj) throws ExecutionException {
        if (obj instanceof b) {
            Throwable th = ((b) obj).f1009a;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        }
        if (obj instanceof Failure) {
            throw new ExecutionException(((Failure) obj).f1006a);
        }
        if (obj == f1002j) {
            return null;
        }
        return obj;
    }

    public static <V> V f(Future<V> future) {
        V v3;
        boolean z = false;
        while (true) {
            try {
                v3 = future.get();
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
        return v3;
    }

    @Override // c5.a
    public final void a(Runnable runnable, Executor executor) {
        executor.getClass();
        c cVar = this.f1004b;
        c cVar2 = c.f1010d;
        if (cVar != cVar2) {
            c cVar3 = new c(runnable, executor);
            do {
                cVar3.f1013c = cVar;
                if (h.a(this, cVar, cVar3)) {
                    return;
                } else {
                    cVar = this.f1004b;
                }
            } while (cVar != cVar2);
        }
        d(runnable, executor);
    }

    public final void b(StringBuilder sb2) {
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

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        Object obj = this.f1003a;
        if ((obj == null) | (obj instanceof e)) {
            b bVar = f1000d ? new b(z, new CancellationException("Future.cancel() was called.")) : z ? b.f1007b : b.f1008c;
            while (!h.b(this, obj, bVar)) {
                obj = this.f1003a;
                if (!(obj instanceof e)) {
                }
            }
            c(this);
            if (obj instanceof e) {
                throw null;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String g() {
        if (this.f1003a instanceof e) {
            return a0.a.k("setFuture=[", "null", "]");
        }
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    @Override // java.util.concurrent.Future
    public final V get(long j10, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        boolean z;
        g gVar = g.f1019c;
        long nanos = timeUnit.toNanos(j10);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f1003a;
        if ((obj != null) && (!(obj instanceof e))) {
            return (V) e(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            g gVar2 = this.f1005c;
            if (gVar2 != gVar) {
                g gVar3 = new g();
                z = true;
                do {
                    a aVar = h;
                    aVar.d(gVar3, gVar2);
                    if (aVar.c(this, gVar2, gVar3)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                h(gVar3);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f1003a;
                            if ((obj2 != null) && (!(obj2 instanceof e))) {
                                return (V) e(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        h(gVar3);
                    } else {
                        gVar2 = this.f1005c;
                    }
                } while (gVar2 != gVar);
            }
            return (V) e(this.f1003a);
        }
        z = true;
        while (nanos > 0) {
            Object obj3 = this.f1003a;
            if ((obj3 != null ? z : false) && (!(obj3 instanceof e))) {
                return (V) e(obj3);
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
        StringBuilder sbQ = ai.onnxruntime.a.q(j10, "Waited ", " ");
        sbQ.append(timeUnit.toString().toLowerCase(locale));
        String string3 = sbQ.toString();
        if (nanos + 1000 < 0) {
            String strJ = a0.a.j(string3, " (plus ");
            long j11 = -nanos;
            long jConvert = timeUnit.convert(j11, TimeUnit.NANOSECONDS);
            long nanos2 = j11 - timeUnit.toNanos(jConvert);
            boolean z3 = (jConvert == 0 || nanos2 > 1000) ? z : false;
            if (jConvert > 0) {
                String strJ2 = strJ + jConvert + " " + lowerCase;
                if (z3) {
                    strJ2 = a0.a.j(strJ2, ",");
                }
                strJ = a0.a.j(strJ2, " ");
            }
            if (z3) {
                strJ = strJ + nanos2 + " nanoseconds ";
            }
            string3 = a0.a.j(strJ, "delay)");
        }
        if (isDone()) {
            throw new TimeoutException(a0.a.j(string3, " but future completed as timeout expired"));
        }
        throw new TimeoutException(com.stepos.core.ota.d.i(string3, " for ", string));
    }

    public final void h(g gVar) {
        gVar.f1020a = null;
        while (true) {
            g gVar2 = this.f1005c;
            if (gVar2 == g.f1019c) {
                return;
            }
            g gVar3 = null;
            while (gVar2 != null) {
                g gVar4 = gVar2.f1021b;
                if (gVar2.f1020a != null) {
                    gVar3 = gVar2;
                } else if (gVar3 != null) {
                    gVar3.f1021b = gVar4;
                    if (gVar3.f1020a == null) {
                        break;
                    }
                } else if (!h.c(this, gVar2, gVar4)) {
                    break;
                }
                gVar2 = gVar4;
            }
            return;
        }
    }

    public boolean i(Throwable th) {
        if (!h.b(this, null, new Failure(th))) {
            return false;
        }
        c(this);
        return true;
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f1003a instanceof b;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return (!(r2 instanceof e)) & (this.f1003a != null);
    }

    public final String toString() {
        String strG;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append("[status=");
        if (this.f1003a instanceof b) {
            sb2.append("CANCELLED");
        } else if (isDone()) {
            b(sb2);
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
                b(sb2);
            } else {
                sb2.append("PENDING");
            }
        }
        sb2.append("]");
        return sb2.toString();
    }

    @Override // java.util.concurrent.Future
    public final V get() throws InterruptedException {
        Object obj;
        g gVar = g.f1019c;
        if (!Thread.interrupted()) {
            Object obj2 = this.f1003a;
            if ((obj2 != null) & (!(obj2 instanceof e))) {
                return (V) e(obj2);
            }
            g gVar2 = this.f1005c;
            if (gVar2 != gVar) {
                g gVar3 = new g();
                do {
                    a aVar = h;
                    aVar.d(gVar3, gVar2);
                    if (aVar.c(this, gVar2, gVar3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f1003a;
                            } else {
                                h(gVar3);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof e))));
                        return (V) e(obj);
                    }
                    gVar2 = this.f1005c;
                } while (gVar2 != gVar);
            }
            return (V) e(this.f1003a);
        }
        throw new InterruptedException();
    }
}

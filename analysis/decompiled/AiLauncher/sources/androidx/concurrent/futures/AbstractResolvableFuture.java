package androidx.concurrent.futures;

import com.autonavi.aps.amapapi.config.Const;
import g3.InterfaceFutureC4095a;
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

/* loaded from: classes.dex */
public abstract class AbstractResolvableFuture<V> implements InterfaceFutureC4095a<V> {

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f11802d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* renamed from: e, reason: collision with root package name */
    public static final Logger f11803e = Logger.getLogger(AbstractResolvableFuture.class.getName());

    /* renamed from: f, reason: collision with root package name */
    public static final b f11804f;

    /* renamed from: g, reason: collision with root package name */
    public static final Object f11805g;

    /* renamed from: a, reason: collision with root package name */
    public volatile Object f11806a;

    /* renamed from: b, reason: collision with root package name */
    public volatile d f11807b;

    /* renamed from: c, reason: collision with root package name */
    public volatile h f11808c;

    public static final class Failure {

        /* renamed from: b, reason: collision with root package name */
        public static final Failure f11809b = new Failure(new Throwable("Failure occurred while trying to finish a future.") { // from class: androidx.concurrent.futures.AbstractResolvableFuture.Failure.1
            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });

        /* renamed from: a, reason: collision with root package name */
        public final Throwable f11810a;

        public Failure(Throwable th) {
            this.f11810a = (Throwable) AbstractResolvableFuture.e(th);
        }
    }

    public static abstract class b {
        public b() {
        }

        public abstract boolean a(AbstractResolvableFuture<?> abstractResolvableFuture, d dVar, d dVar2);

        public abstract boolean b(AbstractResolvableFuture<?> abstractResolvableFuture, Object obj, Object obj2);

        public abstract boolean c(AbstractResolvableFuture<?> abstractResolvableFuture, h hVar, h hVar2);

        public abstract void d(h hVar, h hVar2);

        public abstract void e(h hVar, Thread thread);
    }

    public static final class c {

        /* renamed from: c, reason: collision with root package name */
        public static final c f11811c;

        /* renamed from: d, reason: collision with root package name */
        public static final c f11812d;

        /* renamed from: a, reason: collision with root package name */
        public final boolean f11813a;

        /* renamed from: b, reason: collision with root package name */
        public final Throwable f11814b;

        static {
            if (AbstractResolvableFuture.f11802d) {
                f11812d = null;
                f11811c = null;
            } else {
                f11812d = new c(false, null);
                f11811c = new c(true, null);
            }
        }

        public c(boolean z10, Throwable th) {
            this.f11813a = z10;
            this.f11814b = th;
        }
    }

    public static final class d {

        /* renamed from: d, reason: collision with root package name */
        public static final d f11815d = new d(null, null);

        /* renamed from: a, reason: collision with root package name */
        public final Runnable f11816a;

        /* renamed from: b, reason: collision with root package name */
        public final Executor f11817b;

        /* renamed from: c, reason: collision with root package name */
        public d f11818c;

        public d(Runnable runnable, Executor executor) {
            this.f11816a = runnable;
            this.f11817b = executor;
        }
    }

    public static final class e extends b {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<h, Thread> f11819a;

        /* renamed from: b, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<h, h> f11820b;

        /* renamed from: c, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<AbstractResolvableFuture, h> f11821c;

        /* renamed from: d, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<AbstractResolvableFuture, d> f11822d;

        /* renamed from: e, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<AbstractResolvableFuture, Object> f11823e;

        public e(AtomicReferenceFieldUpdater<h, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<h, h> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractResolvableFuture, h> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractResolvableFuture, d> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<AbstractResolvableFuture, Object> atomicReferenceFieldUpdater5) {
            super();
            this.f11819a = atomicReferenceFieldUpdater;
            this.f11820b = atomicReferenceFieldUpdater2;
            this.f11821c = atomicReferenceFieldUpdater3;
            this.f11822d = atomicReferenceFieldUpdater4;
            this.f11823e = atomicReferenceFieldUpdater5;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public boolean a(AbstractResolvableFuture<?> abstractResolvableFuture, d dVar, d dVar2) {
            return this.f11822d.compareAndSet(abstractResolvableFuture, dVar, dVar2);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public boolean b(AbstractResolvableFuture<?> abstractResolvableFuture, Object obj, Object obj2) {
            return this.f11823e.compareAndSet(abstractResolvableFuture, obj, obj2);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public boolean c(AbstractResolvableFuture<?> abstractResolvableFuture, h hVar, h hVar2) {
            return this.f11821c.compareAndSet(abstractResolvableFuture, hVar, hVar2);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public void d(h hVar, h hVar2) {
            this.f11820b.lazySet(hVar, hVar2);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public void e(h hVar, Thread thread) {
            this.f11819a.lazySet(hVar, thread);
        }
    }

    public static final class f<V> implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final AbstractResolvableFuture<V> f11824a;

        /* renamed from: b, reason: collision with root package name */
        public final InterfaceFutureC4095a<? extends V> f11825b;

        @Override // java.lang.Runnable
        public void run() {
            if (this.f11824a.f11806a != this) {
                return;
            }
            if (AbstractResolvableFuture.f11804f.b(this.f11824a, this, AbstractResolvableFuture.j(this.f11825b))) {
                AbstractResolvableFuture.g(this.f11824a);
            }
        }
    }

    public static final class g extends b {
        public g() {
            super();
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public boolean a(AbstractResolvableFuture<?> abstractResolvableFuture, d dVar, d dVar2) {
            synchronized (abstractResolvableFuture) {
                try {
                    if (abstractResolvableFuture.f11807b != dVar) {
                        return false;
                    }
                    abstractResolvableFuture.f11807b = dVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public boolean b(AbstractResolvableFuture<?> abstractResolvableFuture, Object obj, Object obj2) {
            synchronized (abstractResolvableFuture) {
                try {
                    if (abstractResolvableFuture.f11806a != obj) {
                        return false;
                    }
                    abstractResolvableFuture.f11806a = obj2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public boolean c(AbstractResolvableFuture<?> abstractResolvableFuture, h hVar, h hVar2) {
            synchronized (abstractResolvableFuture) {
                try {
                    if (abstractResolvableFuture.f11808c != hVar) {
                        return false;
                    }
                    abstractResolvableFuture.f11808c = hVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public void d(h hVar, h hVar2) {
            hVar.f11828b = hVar2;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public void e(h hVar, Thread thread) {
            hVar.f11827a = thread;
        }
    }

    public static final class h {

        /* renamed from: c, reason: collision with root package name */
        public static final h f11826c = new h(false);

        /* renamed from: a, reason: collision with root package name */
        public volatile Thread f11827a;

        /* renamed from: b, reason: collision with root package name */
        public volatile h f11828b;

        public h(boolean z10) {
        }

        public void a(h hVar) {
            AbstractResolvableFuture.f11804f.d(this, hVar);
        }

        public void b() {
            Thread thread = this.f11827a;
            if (thread != null) {
                this.f11827a = null;
                LockSupport.unpark(thread);
            }
        }

        public h() {
            AbstractResolvableFuture.f11804f.e(this, Thread.currentThread());
        }
    }

    static {
        b gVar;
        try {
            gVar = new e(AtomicReferenceFieldUpdater.newUpdater(h.class, Thread.class, Const.INTENT_KEY_APIKEY), AtomicReferenceFieldUpdater.newUpdater(h.class, h.class, Const.INTENT_KEY_PKGNAME), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, h.class, "c"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, d.class, Const.INTENT_KEY_PKGNAME), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, Object.class, Const.INTENT_KEY_APIKEY));
            th = null;
        } catch (Throwable th) {
            th = th;
            gVar = new g();
        }
        f11804f = gVar;
        if (th != null) {
            f11803e.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f11805g = new Object();
    }

    public static CancellationException d(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    public static <T> T e(T t10) {
        t10.getClass();
        return t10;
    }

    public static void g(AbstractResolvableFuture<?> abstractResolvableFuture) {
        d dVar = null;
        while (true) {
            abstractResolvableFuture.n();
            abstractResolvableFuture.c();
            d dVarF = abstractResolvableFuture.f(dVar);
            while (dVarF != null) {
                dVar = dVarF.f11818c;
                Runnable runnable = dVarF.f11816a;
                if (runnable instanceof f) {
                    f fVar = (f) runnable;
                    abstractResolvableFuture = fVar.f11824a;
                    if (abstractResolvableFuture.f11806a == fVar) {
                        if (f11804f.b(abstractResolvableFuture, fVar, j(fVar.f11825b))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    h(runnable, dVarF.f11817b);
                }
                dVarF = dVar;
            }
            return;
        }
    }

    public static void h(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e10) {
            f11803e.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e10);
        }
    }

    public static Object j(InterfaceFutureC4095a<?> interfaceFutureC4095a) {
        if (interfaceFutureC4095a instanceof AbstractResolvableFuture) {
            Object obj = ((AbstractResolvableFuture) interfaceFutureC4095a).f11806a;
            if (!(obj instanceof c)) {
                return obj;
            }
            c cVar = (c) obj;
            return cVar.f11813a ? cVar.f11814b != null ? new c(false, cVar.f11814b) : c.f11812d : obj;
        }
        boolean zIsCancelled = interfaceFutureC4095a.isCancelled();
        if ((!f11802d) && zIsCancelled) {
            return c.f11812d;
        }
        try {
            Object objK = k(interfaceFutureC4095a);
            return objK == null ? f11805g : objK;
        } catch (CancellationException e10) {
            if (zIsCancelled) {
                return new c(false, e10);
            }
            return new Failure(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + interfaceFutureC4095a, e10));
        } catch (ExecutionException e11) {
            return new Failure(e11.getCause());
        } catch (Throwable th) {
            return new Failure(th);
        }
    }

    public static <V> V k(Future<V> future) throws ExecutionException {
        V v10;
        boolean z10 = false;
        while (true) {
            try {
                v10 = future.get();
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
        return v10;
    }

    @Override // g3.InterfaceFutureC4095a
    public final void a(Runnable runnable, Executor executor) {
        e(runnable);
        e(executor);
        d dVar = this.f11807b;
        if (dVar != d.f11815d) {
            d dVar2 = new d(runnable, executor);
            do {
                dVar2.f11818c = dVar;
                if (f11804f.a(this, dVar, dVar2)) {
                    return;
                } else {
                    dVar = this.f11807b;
                }
            } while (dVar != d.f11815d);
        }
        h(runnable, executor);
    }

    public final void b(StringBuilder sb2) {
        try {
            Object objK = k(this);
            sb2.append("SUCCESS, result=[");
            sb2.append(r(objK));
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

    public void c() {
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z10) {
        Object obj = this.f11806a;
        if (!(obj == null) && !(obj instanceof f)) {
            return false;
        }
        c cVar = f11802d ? new c(z10, new CancellationException("Future.cancel() was called.")) : z10 ? c.f11811c : c.f11812d;
        boolean z11 = false;
        while (true) {
            if (f11804f.b(this, obj, cVar)) {
                if (z10) {
                    this.l();
                }
                g(this);
                if (!(obj instanceof f)) {
                    break;
                }
                InterfaceFutureC4095a<? extends V> interfaceFutureC4095a = ((f) obj).f11825b;
                if (!(interfaceFutureC4095a instanceof AbstractResolvableFuture)) {
                    interfaceFutureC4095a.cancel(z10);
                    break;
                }
                this = (AbstractResolvableFuture) interfaceFutureC4095a;
                obj = this.f11806a;
                if (!(obj == null) && !(obj instanceof f)) {
                    break;
                }
                z11 = true;
            } else {
                obj = this.f11806a;
                if (!(obj instanceof f)) {
                    return z11;
                }
            }
        }
        return true;
    }

    public final d f(d dVar) {
        d dVar2;
        do {
            dVar2 = this.f11807b;
        } while (!f11804f.a(this, dVar2, d.f11815d));
        while (true) {
            d dVar3 = dVar;
            dVar = dVar2;
            if (dVar == null) {
                return dVar3;
            }
            dVar2 = dVar.f11818c;
            dVar.f11818c = dVar3;
        }
    }

    @Override // java.util.concurrent.Future
    public final V get(long j10, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j10);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f11806a;
        if ((obj != null) && (!(obj instanceof f))) {
            return i(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            h hVar = this.f11808c;
            if (hVar != h.f11826c) {
                h hVar2 = new h();
                do {
                    hVar2.a(hVar);
                    if (f11804f.c(this, hVar, hVar2)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                o(hVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f11806a;
                            if ((obj2 != null) && (!(obj2 instanceof f))) {
                                return i(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        o(hVar2);
                    } else {
                        hVar = this.f11808c;
                    }
                } while (hVar != h.f11826c);
            }
            return i(this.f11806a);
        }
        while (nanos > 0) {
            Object obj3 = this.f11806a;
            if ((obj3 != null) && (!(obj3 instanceof f))) {
                return i(obj3);
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
        String str = "Waited " + j10 + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String str2 = str + " (plus ";
            long j11 = -nanos;
            long jConvert = timeUnit.convert(j11, TimeUnit.NANOSECONDS);
            long nanos2 = j11 - timeUnit.toNanos(jConvert);
            boolean z10 = jConvert == 0 || nanos2 > 1000;
            if (jConvert > 0) {
                String str3 = str2 + jConvert + " " + lowerCase;
                if (z10) {
                    str3 = str3 + Const.STR_MART_COMMA;
                }
                str2 = str3 + " ";
            }
            if (z10) {
                str2 = str2 + nanos2 + " nanoseconds ";
            }
            str = str2 + "delay)";
        }
        if (isDone()) {
            throw new TimeoutException(str + " but future completed as timeout expired");
        }
        throw new TimeoutException(str + " for " + string);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final V i(Object obj) throws ExecutionException {
        if (obj instanceof c) {
            throw d("Task was cancelled.", ((c) obj).f11814b);
        }
        if (obj instanceof Failure) {
            throw new ExecutionException(((Failure) obj).f11810a);
        }
        if (obj == f11805g) {
            return null;
        }
        return obj;
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f11806a instanceof c;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return (!(r2 instanceof f)) & (this.f11806a != null);
    }

    public void l() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String m() {
        Object obj = this.f11806a;
        if (obj instanceof f) {
            return "setFuture=[" + r(((f) obj).f11825b) + "]";
        }
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public final void n() {
        h hVar;
        do {
            hVar = this.f11808c;
        } while (!f11804f.c(this, hVar, h.f11826c));
        while (hVar != null) {
            hVar.b();
            hVar = hVar.f11828b;
        }
    }

    public final void o(h hVar) {
        hVar.f11827a = null;
        while (true) {
            h hVar2 = this.f11808c;
            if (hVar2 == h.f11826c) {
                return;
            }
            h hVar3 = null;
            while (hVar2 != null) {
                h hVar4 = hVar2.f11828b;
                if (hVar2.f11827a != null) {
                    hVar3 = hVar2;
                } else if (hVar3 != null) {
                    hVar3.f11828b = hVar4;
                    if (hVar3.f11827a == null) {
                        break;
                    }
                } else if (!f11804f.c(this, hVar2, hVar4)) {
                    break;
                }
                hVar2 = hVar4;
            }
            return;
        }
    }

    public boolean p(V v10) {
        if (v10 == null) {
            v10 = (V) f11805g;
        }
        if (!f11804f.b(this, null, v10)) {
            return false;
        }
        g(this);
        return true;
    }

    public boolean q(Throwable th) {
        if (!f11804f.b(this, null, new Failure((Throwable) e(th)))) {
            return false;
        }
        g(this);
        return true;
    }

    public final String r(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    public String toString() {
        String strM;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append("[status=");
        if (isCancelled()) {
            sb2.append("CANCELLED");
        } else if (isDone()) {
            b(sb2);
        } else {
            try {
                strM = m();
            } catch (RuntimeException e10) {
                strM = "Exception thrown from implementation: " + e10.getClass();
            }
            if (strM != null && !strM.isEmpty()) {
                sb2.append("PENDING, info=[");
                sb2.append(strM);
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
    public final V get() throws ExecutionException, InterruptedException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f11806a;
            if ((obj2 != null) & (!(obj2 instanceof f))) {
                return i(obj2);
            }
            h hVar = this.f11808c;
            if (hVar != h.f11826c) {
                h hVar2 = new h();
                do {
                    hVar2.a(hVar);
                    if (f11804f.c(this, hVar, hVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f11806a;
                            } else {
                                o(hVar2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof f))));
                        return i(obj);
                    }
                    hVar = this.f11808c;
                } while (hVar != h.f11826c);
            }
            return i(this.f11806a);
        }
        throw new InterruptedException();
    }
}

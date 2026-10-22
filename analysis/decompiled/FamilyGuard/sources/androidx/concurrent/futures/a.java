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
import z1.InterfaceFutureC1343a;

/* loaded from: classes.dex */
public abstract class a<V> implements InterfaceFutureC1343a<V> {

    /* renamed from: d, reason: collision with root package name */
    static final boolean f8624d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* renamed from: e, reason: collision with root package name */
    private static final Logger f8625e = Logger.getLogger(a.class.getName());

    /* renamed from: f, reason: collision with root package name */
    static final b f8626f;

    /* renamed from: g, reason: collision with root package name */
    private static final Object f8627g;

    /* renamed from: a, reason: collision with root package name */
    volatile Object f8628a;

    /* renamed from: b, reason: collision with root package name */
    volatile e f8629b;

    /* renamed from: c, reason: collision with root package name */
    volatile i f8630c;

    private static abstract class b {
        private b() {
        }

        abstract boolean a(a<?> aVar, e eVar, e eVar2);

        abstract boolean b(a<?> aVar, Object obj, Object obj2);

        abstract boolean c(a<?> aVar, i iVar, i iVar2);

        abstract void d(i iVar, i iVar2);

        abstract void e(i iVar, Thread thread);
    }

    private static final class c {

        /* renamed from: c, reason: collision with root package name */
        static final c f8631c;

        /* renamed from: d, reason: collision with root package name */
        static final c f8632d;

        /* renamed from: a, reason: collision with root package name */
        final boolean f8633a;

        /* renamed from: b, reason: collision with root package name */
        final Throwable f8634b;

        static {
            if (a.f8624d) {
                f8632d = null;
                f8631c = null;
            } else {
                f8632d = new c(false, null);
                f8631c = new c(true, null);
            }
        }

        c(boolean z5, Throwable th) {
            this.f8633a = z5;
            this.f8634b = th;
        }
    }

    private static final class d {

        /* renamed from: b, reason: collision with root package name */
        static final d f8635b = new d(new C0110a("Failure occurred while trying to finish a future."));

        /* renamed from: a, reason: collision with root package name */
        final Throwable f8636a;

        /* renamed from: androidx.concurrent.futures.a$d$a, reason: collision with other inner class name */
        class C0110a extends Throwable {
            C0110a(String str) {
                super(str);
            }

            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        d(Throwable th) {
            this.f8636a = (Throwable) a.d(th);
        }
    }

    private static final class e {

        /* renamed from: d, reason: collision with root package name */
        static final e f8637d = new e(null, null);

        /* renamed from: a, reason: collision with root package name */
        final Runnable f8638a;

        /* renamed from: b, reason: collision with root package name */
        final Executor f8639b;

        /* renamed from: c, reason: collision with root package name */
        e f8640c;

        e(Runnable runnable, Executor executor) {
            this.f8638a = runnable;
            this.f8639b = executor;
        }
    }

    private static final class f extends b {

        /* renamed from: a, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<i, Thread> f8641a;

        /* renamed from: b, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<i, i> f8642b;

        /* renamed from: c, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<a, i> f8643c;

        /* renamed from: d, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<a, e> f8644d;

        /* renamed from: e, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<a, Object> f8645e;

        f(AtomicReferenceFieldUpdater<i, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<i, i> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<a, i> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<a, e> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<a, Object> atomicReferenceFieldUpdater5) {
            super();
            this.f8641a = atomicReferenceFieldUpdater;
            this.f8642b = atomicReferenceFieldUpdater2;
            this.f8643c = atomicReferenceFieldUpdater3;
            this.f8644d = atomicReferenceFieldUpdater4;
            this.f8645e = atomicReferenceFieldUpdater5;
        }

        @Override // androidx.concurrent.futures.a.b
        boolean a(a<?> aVar, e eVar, e eVar2) {
            return this.f8644d.compareAndSet(aVar, eVar, eVar2);
        }

        @Override // androidx.concurrent.futures.a.b
        boolean b(a<?> aVar, Object obj, Object obj2) {
            return this.f8645e.compareAndSet(aVar, obj, obj2);
        }

        @Override // androidx.concurrent.futures.a.b
        boolean c(a<?> aVar, i iVar, i iVar2) {
            return this.f8643c.compareAndSet(aVar, iVar, iVar2);
        }

        @Override // androidx.concurrent.futures.a.b
        void d(i iVar, i iVar2) {
            this.f8642b.lazySet(iVar, iVar2);
        }

        @Override // androidx.concurrent.futures.a.b
        void e(i iVar, Thread thread) {
            this.f8641a.lazySet(iVar, thread);
        }
    }

    private static final class g<V> implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final a<V> f8646a;

        /* renamed from: b, reason: collision with root package name */
        final InterfaceFutureC1343a<? extends V> f8647b;

        @Override // java.lang.Runnable
        public void run() {
            if (this.f8646a.f8628a != this) {
                return;
            }
            if (a.f8626f.b(this.f8646a, this, a.i(this.f8647b))) {
                a.f(this.f8646a);
            }
        }
    }

    private static final class h extends b {
        h() {
            super();
        }

        @Override // androidx.concurrent.futures.a.b
        boolean a(a<?> aVar, e eVar, e eVar2) {
            synchronized (aVar) {
                try {
                    if (aVar.f8629b != eVar) {
                        return false;
                    }
                    aVar.f8629b = eVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.concurrent.futures.a.b
        boolean b(a<?> aVar, Object obj, Object obj2) {
            synchronized (aVar) {
                try {
                    if (aVar.f8628a != obj) {
                        return false;
                    }
                    aVar.f8628a = obj2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.concurrent.futures.a.b
        boolean c(a<?> aVar, i iVar, i iVar2) {
            synchronized (aVar) {
                try {
                    if (aVar.f8630c != iVar) {
                        return false;
                    }
                    aVar.f8630c = iVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.concurrent.futures.a.b
        void d(i iVar, i iVar2) {
            iVar.f8650b = iVar2;
        }

        @Override // androidx.concurrent.futures.a.b
        void e(i iVar, Thread thread) {
            iVar.f8649a = thread;
        }
    }

    private static final class i {

        /* renamed from: c, reason: collision with root package name */
        static final i f8648c = new i(false);

        /* renamed from: a, reason: collision with root package name */
        volatile Thread f8649a;

        /* renamed from: b, reason: collision with root package name */
        volatile i f8650b;

        i(boolean z5) {
        }

        void a(i iVar) {
            a.f8626f.d(this, iVar);
        }

        void b() {
            Thread thread = this.f8649a;
            if (thread != null) {
                this.f8649a = null;
                LockSupport.unpark(thread);
            }
        }

        i() {
            a.f8626f.e(this, Thread.currentThread());
        }
    }

    static {
        b hVar;
        try {
            hVar = new f(AtomicReferenceFieldUpdater.newUpdater(i.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(i.class, i.class, "b"), AtomicReferenceFieldUpdater.newUpdater(a.class, i.class, "c"), AtomicReferenceFieldUpdater.newUpdater(a.class, e.class, "b"), AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "a"));
            th = null;
        } catch (Throwable th) {
            th = th;
            hVar = new h();
        }
        f8626f = hVar;
        if (th != null) {
            f8625e.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f8627g = new Object();
    }

    protected a() {
    }

    private void a(StringBuilder sb) {
        try {
            Object objJ = j(this);
            sb.append("SUCCESS, result=[");
            sb.append(p(objJ));
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e6) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e6.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e7) {
            sb.append("FAILURE, cause=[");
            sb.append(e7.getCause());
            sb.append("]");
        }
    }

    private static CancellationException c(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    static <T> T d(T t5) {
        t5.getClass();
        return t5;
    }

    private e e(e eVar) {
        e eVar2;
        do {
            eVar2 = this.f8629b;
        } while (!f8626f.a(this, eVar2, e.f8637d));
        while (true) {
            e eVar3 = eVar;
            eVar = eVar2;
            if (eVar == null) {
                return eVar3;
            }
            eVar2 = eVar.f8640c;
            eVar.f8640c = eVar3;
        }
    }

    static void f(a<?> aVar) {
        e eVar = null;
        while (true) {
            aVar.m();
            aVar.b();
            e eVarE = aVar.e(eVar);
            while (eVarE != null) {
                eVar = eVarE.f8640c;
                Runnable runnable = eVarE.f8638a;
                if (runnable instanceof g) {
                    g gVar = (g) runnable;
                    aVar = gVar.f8646a;
                    if (aVar.f8628a == gVar) {
                        if (f8626f.b(aVar, gVar, i(gVar.f8647b))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    g(runnable, eVarE.f8639b);
                }
                eVarE = eVar;
            }
            return;
        }
    }

    private static void g(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e6) {
            f8625e.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e6);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private V h(Object obj) throws ExecutionException {
        if (obj instanceof c) {
            throw c("Task was cancelled.", ((c) obj).f8634b);
        }
        if (obj instanceof d) {
            throw new ExecutionException(((d) obj).f8636a);
        }
        if (obj == f8627g) {
            return null;
        }
        return obj;
    }

    static Object i(InterfaceFutureC1343a<?> interfaceFutureC1343a) {
        if (interfaceFutureC1343a instanceof a) {
            Object obj = ((a) interfaceFutureC1343a).f8628a;
            if (!(obj instanceof c)) {
                return obj;
            }
            c cVar = (c) obj;
            return cVar.f8633a ? cVar.f8634b != null ? new c(false, cVar.f8634b) : c.f8632d : obj;
        }
        boolean zIsCancelled = interfaceFutureC1343a.isCancelled();
        if ((!f8624d) && zIsCancelled) {
            return c.f8632d;
        }
        try {
            Object objJ = j(interfaceFutureC1343a);
            return objJ == null ? f8627g : objJ;
        } catch (CancellationException e6) {
            if (zIsCancelled) {
                return new c(false, e6);
            }
            return new d(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + interfaceFutureC1343a, e6));
        } catch (ExecutionException e7) {
            return new d(e7.getCause());
        } catch (Throwable th) {
            return new d(th);
        }
    }

    static <V> V j(Future<V> future) {
        V v5;
        boolean z5 = false;
        while (true) {
            try {
                v5 = future.get();
                break;
            } catch (InterruptedException unused) {
                z5 = true;
            } catch (Throwable th) {
                if (z5) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z5) {
            Thread.currentThread().interrupt();
        }
        return v5;
    }

    private void m() {
        i iVar;
        do {
            iVar = this.f8630c;
        } while (!f8626f.c(this, iVar, i.f8648c));
        while (iVar != null) {
            iVar.b();
            iVar = iVar.f8650b;
        }
    }

    private void n(i iVar) {
        iVar.f8649a = null;
        while (true) {
            i iVar2 = this.f8630c;
            if (iVar2 == i.f8648c) {
                return;
            }
            i iVar3 = null;
            while (iVar2 != null) {
                i iVar4 = iVar2.f8650b;
                if (iVar2.f8649a != null) {
                    iVar3 = iVar2;
                } else if (iVar3 != null) {
                    iVar3.f8650b = iVar4;
                    if (iVar3.f8649a == null) {
                        break;
                    }
                } else if (!f8626f.c(this, iVar2, iVar4)) {
                    break;
                }
                iVar2 = iVar4;
            }
            return;
        }
    }

    private String p(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    protected void b() {
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z5) {
        Object obj = this.f8628a;
        if (!(obj == null) && !(obj instanceof g)) {
            return false;
        }
        c cVar = f8624d ? new c(z5, new CancellationException("Future.cancel() was called.")) : z5 ? c.f8631c : c.f8632d;
        boolean z6 = false;
        while (true) {
            if (f8626f.b(this, obj, cVar)) {
                if (z5) {
                    this.k();
                }
                f(this);
                if (!(obj instanceof g)) {
                    break;
                }
                InterfaceFutureC1343a<? extends V> interfaceFutureC1343a = ((g) obj).f8647b;
                if (!(interfaceFutureC1343a instanceof a)) {
                    interfaceFutureC1343a.cancel(z5);
                    break;
                }
                this = (a) interfaceFutureC1343a;
                obj = this.f8628a;
                if (!(obj == null) && !(obj instanceof g)) {
                    break;
                }
                z6 = true;
            } else {
                obj = this.f8628a;
                if (!(obj instanceof g)) {
                    return z6;
                }
            }
        }
        return true;
    }

    @Override // java.util.concurrent.Future
    public final V get(long j5, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j5);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f8628a;
        if ((obj != null) && (!(obj instanceof g))) {
            return h(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            i iVar = this.f8630c;
            if (iVar != i.f8648c) {
                i iVar2 = new i();
                do {
                    iVar2.a(iVar);
                    if (f8626f.c(this, iVar, iVar2)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                n(iVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f8628a;
                            if ((obj2 != null) && (!(obj2 instanceof g))) {
                                return h(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        n(iVar2);
                    } else {
                        iVar = this.f8630c;
                    }
                } while (iVar != i.f8648c);
            }
            return h(this.f8628a);
        }
        while (nanos > 0) {
            Object obj3 = this.f8628a;
            if ((obj3 != null) && (!(obj3 instanceof g))) {
                return h(obj3);
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
        String str = "Waited " + j5 + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String str2 = str + " (plus ";
            long j6 = -nanos;
            long jConvert = timeUnit.convert(j6, TimeUnit.NANOSECONDS);
            long nanos2 = j6 - timeUnit.toNanos(jConvert);
            boolean z5 = jConvert == 0 || nanos2 > 1000;
            if (jConvert > 0) {
                String str3 = str2 + jConvert + " " + lowerCase;
                if (z5) {
                    str3 = str3 + ",";
                }
                str2 = str3 + " ";
            }
            if (z5) {
                str2 = str2 + nanos2 + " nanoseconds ";
            }
            str = str2 + "delay)";
        }
        if (isDone()) {
            throw new TimeoutException(str + " but future completed as timeout expired");
        }
        throw new TimeoutException(str + " for " + string);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f8628a instanceof c;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return (!(r2 instanceof g)) & (this.f8628a != null);
    }

    protected void k() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected String l() {
        Object obj = this.f8628a;
        if (obj instanceof g) {
            return "setFuture=[" + p(((g) obj).f8647b) + "]";
        }
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    protected boolean o(V v5) {
        if (v5 == null) {
            v5 = (V) f8627g;
        }
        if (!f8626f.b(this, null, v5)) {
            return false;
        }
        f(this);
        return true;
    }

    public String toString() {
        String strL;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            a(sb);
        } else {
            try {
                strL = l();
            } catch (RuntimeException e6) {
                strL = "Exception thrown from implementation: " + e6.getClass();
            }
            if (strL != null && !strL.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(strL);
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
    public final V get() throws InterruptedException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f8628a;
            if ((obj2 != null) & (!(obj2 instanceof g))) {
                return h(obj2);
            }
            i iVar = this.f8630c;
            if (iVar != i.f8648c) {
                i iVar2 = new i();
                do {
                    iVar2.a(iVar);
                    if (f8626f.c(this, iVar, iVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f8628a;
                            } else {
                                n(iVar2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof g))));
                        return h(obj);
                    }
                    iVar = this.f8630c;
                } while (iVar != i.f8648c);
            }
            return h(this.f8628a);
        }
        throw new InterruptedException();
    }
}

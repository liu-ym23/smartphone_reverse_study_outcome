package C0;

import C0.p;
import android.os.Process;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import z0.InterfaceC1340f;

/* loaded from: classes.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f292a;

    /* renamed from: b, reason: collision with root package name */
    private final Executor f293b;

    /* renamed from: c, reason: collision with root package name */
    final Map<InterfaceC1340f, c> f294c;

    /* renamed from: d, reason: collision with root package name */
    private final ReferenceQueue<p<?>> f295d;

    /* renamed from: e, reason: collision with root package name */
    private p.a f296e;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f297f;

    /* renamed from: C0.a$a, reason: collision with other inner class name */
    class ThreadFactoryC0009a implements ThreadFactory {

        /* renamed from: C0.a$a$a, reason: collision with other inner class name */
        class RunnableC0010a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Runnable f298a;

            RunnableC0010a(Runnable runnable) {
                this.f298a = runnable;
            }

            @Override // java.lang.Runnable
            public void run() throws SecurityException, IllegalArgumentException {
                Process.setThreadPriority(10);
                this.f298a.run();
            }
        }

        ThreadFactoryC0009a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(new RunnableC0010a(runnable), "glide-active-resources");
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.b();
        }
    }

    static final class c extends WeakReference<p<?>> {

        /* renamed from: a, reason: collision with root package name */
        final InterfaceC1340f f301a;

        /* renamed from: b, reason: collision with root package name */
        final boolean f302b;

        /* renamed from: c, reason: collision with root package name */
        v<?> f303c;

        c(InterfaceC1340f interfaceC1340f, p<?> pVar, ReferenceQueue<? super p<?>> referenceQueue, boolean z5) {
            super(pVar, referenceQueue);
            this.f301a = (InterfaceC1340f) X0.j.d(interfaceC1340f);
            this.f303c = (pVar.f() && z5) ? (v) X0.j.d(pVar.e()) : null;
            this.f302b = pVar.f();
        }

        void a() {
            this.f303c = null;
            clear();
        }
    }

    a(boolean z5) {
        this(z5, Executors.newSingleThreadExecutor(new ThreadFactoryC0009a()));
    }

    synchronized void a(InterfaceC1340f interfaceC1340f, p<?> pVar) {
        c cVarPut = this.f294c.put(interfaceC1340f, new c(interfaceC1340f, pVar, this.f295d, this.f292a));
        if (cVarPut != null) {
            cVarPut.a();
        }
    }

    void b() {
        while (!this.f297f) {
            try {
                c((c) this.f295d.remove());
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    void c(c cVar) {
        v<?> vVar;
        synchronized (this.f296e) {
            synchronized (this) {
                this.f294c.remove(cVar.f301a);
                if (cVar.f302b && (vVar = cVar.f303c) != null) {
                    p<?> pVar = new p<>(vVar, true, false);
                    pVar.h(cVar.f301a, this.f296e);
                    this.f296e.c(cVar.f301a, pVar);
                }
            }
        }
    }

    synchronized void d(InterfaceC1340f interfaceC1340f) {
        c cVarRemove = this.f294c.remove(interfaceC1340f);
        if (cVarRemove != null) {
            cVarRemove.a();
        }
    }

    synchronized p<?> e(InterfaceC1340f interfaceC1340f) {
        c cVar = this.f294c.get(interfaceC1340f);
        if (cVar == null) {
            return null;
        }
        p<?> pVar = cVar.get();
        if (pVar == null) {
            c(cVar);
        }
        return pVar;
    }

    void f(p.a aVar) {
        synchronized (aVar) {
            synchronized (this) {
                this.f296e = aVar;
            }
        }
    }

    a(boolean z5, Executor executor) {
        this.f294c = new HashMap();
        this.f295d = new ReferenceQueue<>();
        this.f292a = z5;
        this.f293b = executor;
        executor.execute(new b());
    }
}

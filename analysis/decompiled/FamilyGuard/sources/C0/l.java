package C0;

import C0.h;
import Y0.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import z0.EnumC1335a;
import z0.InterfaceC1340f;

/* loaded from: classes.dex */
class l<R> implements h.b<R>, a.f {

    /* renamed from: x, reason: collision with root package name */
    private static final c f424x = new c();

    /* renamed from: a, reason: collision with root package name */
    final e f425a;

    /* renamed from: b, reason: collision with root package name */
    private final Y0.c f426b;

    /* renamed from: c, reason: collision with root package name */
    private final D.e<l<?>> f427c;

    /* renamed from: d, reason: collision with root package name */
    private final c f428d;

    /* renamed from: e, reason: collision with root package name */
    private final m f429e;

    /* renamed from: f, reason: collision with root package name */
    private final F0.a f430f;

    /* renamed from: g, reason: collision with root package name */
    private final F0.a f431g;

    /* renamed from: h, reason: collision with root package name */
    private final F0.a f432h;

    /* renamed from: i, reason: collision with root package name */
    private final F0.a f433i;

    /* renamed from: j, reason: collision with root package name */
    private final AtomicInteger f434j;

    /* renamed from: k, reason: collision with root package name */
    private InterfaceC1340f f435k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f436l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f437m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f438n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f439o;

    /* renamed from: p, reason: collision with root package name */
    private v<?> f440p;

    /* renamed from: q, reason: collision with root package name */
    EnumC1335a f441q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f442r;

    /* renamed from: s, reason: collision with root package name */
    q f443s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f444t;

    /* renamed from: u, reason: collision with root package name */
    p<?> f445u;

    /* renamed from: v, reason: collision with root package name */
    private h<R> f446v;

    /* renamed from: w, reason: collision with root package name */
    private volatile boolean f447w;

    private class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final T0.i f448a;

        a(T0.i iVar) {
            this.f448a = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (l.this) {
                try {
                    if (l.this.f425a.c(this.f448a)) {
                        l.this.e(this.f448a);
                    }
                    l.this.i();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final T0.i f450a;

        b(T0.i iVar) {
            this.f450a = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (l.this) {
                try {
                    if (l.this.f425a.c(this.f450a)) {
                        l.this.f445u.a();
                        l.this.f(this.f450a);
                        l.this.r(this.f450a);
                    }
                    l.this.i();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    static class c {
        c() {
        }

        public <R> p<R> a(v<R> vVar, boolean z5) {
            return new p<>(vVar, z5, true);
        }
    }

    static final class d {

        /* renamed from: a, reason: collision with root package name */
        final T0.i f452a;

        /* renamed from: b, reason: collision with root package name */
        final Executor f453b;

        d(T0.i iVar, Executor executor) {
            this.f452a = iVar;
            this.f453b = executor;
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return this.f452a.equals(((d) obj).f452a);
            }
            return false;
        }

        public int hashCode() {
            return this.f452a.hashCode();
        }
    }

    static final class e implements Iterable<d> {

        /* renamed from: a, reason: collision with root package name */
        private final List<d> f454a;

        e() {
            this(new ArrayList(2));
        }

        private static d h(T0.i iVar) {
            return new d(iVar, X0.e.a());
        }

        void a(T0.i iVar, Executor executor) {
            this.f454a.add(new d(iVar, executor));
        }

        boolean c(T0.i iVar) {
            return this.f454a.contains(h(iVar));
        }

        void clear() {
            this.f454a.clear();
        }

        e f() {
            return new e(new ArrayList(this.f454a));
        }

        void i(T0.i iVar) {
            this.f454a.remove(h(iVar));
        }

        boolean isEmpty() {
            return this.f454a.isEmpty();
        }

        @Override // java.lang.Iterable
        public Iterator<d> iterator() {
            return this.f454a.iterator();
        }

        int size() {
            return this.f454a.size();
        }

        e(List<d> list) {
            this.f454a = list;
        }
    }

    l(F0.a aVar, F0.a aVar2, F0.a aVar3, F0.a aVar4, m mVar, D.e<l<?>> eVar) {
        this(aVar, aVar2, aVar3, aVar4, mVar, eVar, f424x);
    }

    private F0.a j() {
        return this.f437m ? this.f432h : this.f438n ? this.f433i : this.f431g;
    }

    private boolean m() {
        return this.f444t || this.f442r || this.f447w;
    }

    private synchronized void q() {
        if (this.f435k == null) {
            throw new IllegalArgumentException();
        }
        this.f425a.clear();
        this.f435k = null;
        this.f445u = null;
        this.f440p = null;
        this.f444t = false;
        this.f447w = false;
        this.f442r = false;
        this.f446v.z(false);
        this.f446v = null;
        this.f443s = null;
        this.f441q = null;
        this.f427c.a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // C0.h.b
    public void a(v<R> vVar, EnumC1335a enumC1335a) {
        synchronized (this) {
            this.f440p = vVar;
            this.f441q = enumC1335a;
        }
        o();
    }

    synchronized void b(T0.i iVar, Executor executor) {
        try {
            this.f426b.c();
            this.f425a.a(iVar, executor);
            if (this.f442r) {
                k(1);
                executor.execute(new b(iVar));
            } else if (this.f444t) {
                k(1);
                executor.execute(new a(iVar));
            } else {
                X0.j.a(!this.f447w, "Cannot add callbacks to a cancelled EngineJob");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // C0.h.b
    public void c(q qVar) {
        synchronized (this) {
            this.f443s = qVar;
        }
        n();
    }

    @Override // C0.h.b
    public void d(h<?> hVar) {
        j().execute(hVar);
    }

    synchronized void e(T0.i iVar) {
        try {
            iVar.c(this.f443s);
        } finally {
        }
    }

    synchronized void f(T0.i iVar) {
        try {
            iVar.a(this.f445u, this.f441q);
        } finally {
        }
    }

    @Override // Y0.a.f
    public Y0.c g() {
        return this.f426b;
    }

    void h() {
        if (m()) {
            return;
        }
        this.f447w = true;
        this.f446v.h();
        this.f429e.d(this, this.f435k);
    }

    synchronized void i() {
        try {
            this.f426b.c();
            X0.j.a(m(), "Not yet complete!");
            int iDecrementAndGet = this.f434j.decrementAndGet();
            X0.j.a(iDecrementAndGet >= 0, "Can't decrement below 0");
            if (iDecrementAndGet == 0) {
                p<?> pVar = this.f445u;
                if (pVar != null) {
                    pVar.g();
                }
                q();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    synchronized void k(int i5) {
        p<?> pVar;
        X0.j.a(m(), "Not yet complete!");
        if (this.f434j.getAndAdd(i5) == 0 && (pVar = this.f445u) != null) {
            pVar.a();
        }
    }

    synchronized l<R> l(InterfaceC1340f interfaceC1340f, boolean z5, boolean z6, boolean z7, boolean z8) {
        this.f435k = interfaceC1340f;
        this.f436l = z5;
        this.f437m = z6;
        this.f438n = z7;
        this.f439o = z8;
        return this;
    }

    void n() {
        synchronized (this) {
            try {
                this.f426b.c();
                if (this.f447w) {
                    q();
                    return;
                }
                if (this.f425a.isEmpty()) {
                    throw new IllegalStateException("Received an exception without any callbacks to notify");
                }
                if (this.f444t) {
                    throw new IllegalStateException("Already failed once");
                }
                this.f444t = true;
                InterfaceC1340f interfaceC1340f = this.f435k;
                e eVarF = this.f425a.f();
                k(eVarF.size() + 1);
                this.f429e.a(this, interfaceC1340f, null);
                Iterator<d> it = eVarF.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    next.f453b.execute(new a(next.f452a));
                }
                i();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void o() {
        synchronized (this) {
            try {
                this.f426b.c();
                if (this.f447w) {
                    this.f440p.b();
                    q();
                    return;
                }
                if (this.f425a.isEmpty()) {
                    throw new IllegalStateException("Received a resource without any callbacks to notify");
                }
                if (this.f442r) {
                    throw new IllegalStateException("Already have resource");
                }
                this.f445u = this.f428d.a(this.f440p, this.f436l);
                this.f442r = true;
                e eVarF = this.f425a.f();
                k(eVarF.size() + 1);
                this.f429e.a(this, this.f435k, this.f445u);
                Iterator<d> it = eVarF.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    next.f453b.execute(new b(next.f452a));
                }
                i();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    boolean p() {
        return this.f439o;
    }

    synchronized void r(T0.i iVar) {
        try {
            this.f426b.c();
            this.f425a.i(iVar);
            if (this.f425a.isEmpty()) {
                h();
                if (this.f442r || this.f444t) {
                    if (this.f434j.get() == 0) {
                        q();
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void s(h<R> hVar) {
        try {
            this.f446v = hVar;
            (hVar.I() ? this.f430f : j()).execute(hVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    l(F0.a aVar, F0.a aVar2, F0.a aVar3, F0.a aVar4, m mVar, D.e<l<?>> eVar, c cVar) {
        this.f425a = new e();
        this.f426b = Y0.c.a();
        this.f434j = new AtomicInteger();
        this.f430f = aVar;
        this.f431g = aVar2;
        this.f432h = aVar3;
        this.f433i = aVar4;
        this.f429e = mVar;
        this.f427c = eVar;
        this.f428d = cVar;
    }
}

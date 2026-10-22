package okhttp3.internal.connection;

import ad.n;
import bd.l;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mb.q;
import okhttp3.Response;
import okhttp3.internal.connection.e;
import okhttp3.internal.connection.h;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d implements ad.b, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public final n f11040a;

    /* renamed from: b, reason: collision with root package name */
    public final okhttp3.h f11041b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f11042c;

    /* renamed from: d, reason: collision with root package name */
    public final e f11043d;

    /* renamed from: e, reason: collision with root package name */
    public final ad.i f11044e;
    public final c h;

    /* renamed from: j, reason: collision with root package name */
    public final AtomicBoolean f11045j;

    /* renamed from: k, reason: collision with root package name */
    public Object f11046k;

    /* renamed from: l, reason: collision with root package name */
    public ed.e f11047l;

    /* renamed from: m, reason: collision with root package name */
    public ed.g f11048m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f11049n;

    /* renamed from: o, reason: collision with root package name */
    public ed.d f11050o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f11051p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f11052q;
    public boolean r;

    /* renamed from: s, reason: collision with root package name */
    public volatile boolean f11053s;

    /* renamed from: t, reason: collision with root package name */
    public volatile ed.d f11054t;

    /* renamed from: u, reason: collision with root package name */
    public final CopyOnWriteArrayList<h.b> f11055u;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final ad.c f11056a;

        /* renamed from: b, reason: collision with root package name */
        public volatile AtomicInteger f11057b = new AtomicInteger(0);

        public a(ad.c cVar) {
            this.f11056a = cVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ad.c cVar = this.f11056a;
            StringBuilder sb2 = new StringBuilder("OkHttp ");
            d dVar = d.this;
            n nVar = dVar.f11040a;
            sb2.append(dVar.f11041b.f10992a.h());
            String string = sb2.toString();
            Thread threadCurrentThread = Thread.currentThread();
            String name = threadCurrentThread.getName();
            threadCurrentThread.setName(string);
            try {
                dVar.h.i();
                boolean z = false;
                try {
                    try {
                        try {
                            cVar.onResponse(dVar, dVar.f());
                        } catch (IOException e10) {
                            e = e10;
                            z = true;
                            if (z) {
                                kd.h.Companion.getClass();
                                kd.h.platform.log("Callback failure for " + d.b(dVar), 4, e);
                            } else {
                                cVar.onFailure(dVar, e);
                            }
                            nVar.f117a.c(this);
                        } catch (Throwable th) {
                            th = th;
                            z = true;
                            dVar.cancel();
                            if (!z) {
                                IOException iOException = new IOException("canceled due to " + th);
                                jd.b.c(iOException, th);
                                cVar.onFailure(dVar, iOException);
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        nVar.f117a.c(this);
                        throw th2;
                    }
                } catch (IOException e11) {
                    e = e11;
                } catch (Throwable th3) {
                    th = th3;
                }
                nVar.f117a.c(this);
            } finally {
                threadCurrentThread.setName(name);
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b extends WeakReference<d> {

        /* renamed from: a, reason: collision with root package name */
        public final Object f11059a;

        public b(d dVar, Object obj) {
            super(dVar);
            this.f11059a = obj;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class c extends sd.b {
        public c() {
        }

        @Override // sd.b
        public final void k() {
            d.this.cancel();
        }
    }

    public d(n nVar, okhttp3.h originalRequest, boolean z) {
        kotlin.jvm.internal.g.f(originalRequest, "originalRequest");
        this.f11040a = nVar;
        this.f11041b = originalRequest;
        this.f11042c = z;
        this.f11043d = nVar.E.f10963a;
        this.f11044e = nVar.f120d.b(this);
        c cVar = new c();
        cVar.g(nVar.f136v, TimeUnit.MILLISECONDS);
        this.h = cVar;
        this.f11045j = new AtomicBoolean();
        this.r = true;
        this.f11055u = new CopyOnWriteArrayList<>();
    }

    public static final String b(d dVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(dVar.f11053s ? "canceled " : "");
        sb2.append(dVar.f11042c ? "web socket" : "call");
        sb2.append(" to ");
        sb2.append(dVar.f11041b.f10992a.h());
        return sb2.toString();
    }

    @Override // ad.b
    public final void Q(ad.c cVar) {
        a next;
        if (!this.f11045j.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed");
        }
        kd.h.Companion.getClass();
        this.f11046k = kd.h.platform.getStackTraceForCloseable("response.body().close()");
        this.f11044e.callStart(this);
        ad.h hVar = this.f11040a.f117a;
        a aVar = new a(cVar);
        hVar.getClass();
        synchronized (hVar) {
            hVar.f92c.add(aVar);
            if (!this.f11042c) {
                String str = this.f11041b.f10992a.f10980d;
                Iterator<a> it = hVar.f93d.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        Iterator<a> it2 = hVar.f92c.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                next = null;
                                break;
                            } else {
                                next = it2.next();
                                if (kotlin.jvm.internal.g.b(d.this.f11041b.f10992a.f10980d, str)) {
                                    break;
                                }
                            }
                        }
                    } else {
                        next = it.next();
                        if (kotlin.jvm.internal.g.b(d.this.f11041b.f10992a.f10980d, str)) {
                            break;
                        }
                    }
                }
                if (next != null) {
                    aVar.f11057b = next.f11057b;
                }
            }
            lb.n nVar = lb.n.f10413a;
        }
        hVar.d();
    }

    @Override // ad.b
    public final okhttp3.h a() {
        return this.f11041b;
    }

    public final <E extends IOException> E c(E e10) {
        E interruptedIOException;
        Socket socketI;
        okhttp3.f fVar = l.f3237a;
        ed.g gVar = this.f11048m;
        if (gVar != null) {
            synchronized (gVar) {
                socketI = i();
            }
            if (this.f11048m == null) {
                if (socketI != null) {
                    l.c(socketI);
                }
                this.f11044e.connectionReleased(this, gVar);
                gVar.f8658l.getClass();
                if (socketI != null) {
                    gVar.f8658l.getClass();
                }
            } else if (socketI != null) {
                throw new IllegalStateException("Check failed.");
            }
        }
        if (!this.f11049n && this.h.j()) {
            interruptedIOException = new InterruptedIOException("timeout");
            if (e10 != null) {
                interruptedIOException.initCause(e10);
            }
        } else {
            interruptedIOException = e10;
        }
        if (e10 == null) {
            this.f11044e.callEnd(this);
            return interruptedIOException;
        }
        ad.i iVar = this.f11044e;
        kotlin.jvm.internal.g.c(interruptedIOException);
        iVar.callFailed(this, interruptedIOException);
        return interruptedIOException;
    }

    @Override // ad.b
    public final void cancel() {
        if (this.f11053s) {
            return;
        }
        this.f11053s = true;
        ed.d dVar = this.f11054t;
        if (dVar != null) {
            dVar.f8636d.cancel();
        }
        Iterator<h.b> it = this.f11055u.iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
        this.f11044e.canceled(this);
    }

    public final Object clone() {
        return new d(this.f11040a, this.f11041b, this.f11042c);
    }

    public final Response d() {
        if (!this.f11045j.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed");
        }
        this.h.i();
        kd.h.Companion.getClass();
        this.f11046k = kd.h.platform.getStackTraceForCloseable("response.body().close()");
        this.f11044e.callStart(this);
        try {
            ad.h hVar = this.f11040a.f117a;
            synchronized (hVar) {
                hVar.f94e.add(this);
            }
            return f();
        } finally {
            ad.h hVar2 = this.f11040a.f117a;
            hVar2.b(hVar2.f94e, this);
        }
    }

    public final void e(boolean z) {
        ed.d dVar;
        synchronized (this) {
            if (!this.r) {
                throw new IllegalStateException("released");
            }
            lb.n nVar = lb.n.f10413a;
        }
        if (z && (dVar = this.f11054t) != null) {
            dVar.f8636d.cancel();
            dVar.f8633a.g(dVar, true, true, null);
        }
        this.f11050o = null;
    }

    public final Response f() {
        ArrayList arrayList = new ArrayList();
        q.g0(arrayList, this.f11040a.f118b);
        arrayList.add(new fd.h(this.f11040a));
        arrayList.add(new fd.a(this.f11040a.f125j));
        arrayList.add(new cd.a());
        arrayList.add(ed.b.f8632a);
        if (!this.f11042c) {
            q.g0(arrayList, this.f11040a.f119c);
        }
        arrayList.add(new fd.b(this.f11042c));
        okhttp3.h hVar = this.f11041b;
        n nVar = this.f11040a;
        try {
            try {
                Response responseB = new fd.f(this, arrayList, 0, null, hVar, nVar.f137w, nVar.f138x, nVar.f139y).b(this.f11041b);
                if (this.f11053s) {
                    bd.i.b(responseB);
                    throw new IOException("Canceled");
                }
                h(null);
                return responseB;
            } catch (IOException e10) {
                IOException iOExceptionH = h(e10);
                kotlin.jvm.internal.g.d(iOExceptionH, "null cannot be cast to non-null type kotlin.Throwable");
                throw iOExceptionH;
            }
        } catch (Throwable th) {
            if (0 == 0) {
                h(null);
            }
            throw th;
        }
    }

    public final <E extends IOException> E g(ed.d exchange, boolean z, boolean z3, E e10) {
        boolean z10;
        boolean z11;
        kotlin.jvm.internal.g.f(exchange, "exchange");
        if (exchange.equals(this.f11054t)) {
            synchronized (this) {
                z10 = false;
                if (z) {
                    try {
                        if (!this.f11051p) {
                            if (z3 || !this.f11052q) {
                                z11 = false;
                            }
                            lb.n nVar = lb.n.f10413a;
                        }
                        if (z) {
                            this.f11051p = false;
                        }
                        if (z3) {
                            this.f11052q = false;
                        }
                        boolean z12 = this.f11051p;
                        boolean z13 = (z12 || this.f11052q) ? false : true;
                        if (!z12 && !this.f11052q && !this.r) {
                            z10 = true;
                        }
                        z11 = z10;
                        z10 = z13;
                        lb.n nVar2 = lb.n.f10413a;
                    } catch (Throwable th) {
                        throw th;
                    }
                } else {
                    if (z3) {
                    }
                    z11 = false;
                    lb.n nVar22 = lb.n.f10413a;
                }
            }
            if (z10) {
                this.f11054t = null;
                ed.g gVar = this.f11048m;
                if (gVar != null) {
                    synchronized (gVar) {
                        gVar.f8663q++;
                    }
                }
            }
            if (z11) {
                return (E) c(e10);
            }
        }
        return e10;
    }

    public final IOException h(IOException iOException) {
        boolean z;
        synchronized (this) {
            try {
                z = false;
                if (this.r) {
                    this.r = false;
                    if (!this.f11051p && !this.f11052q) {
                        z = true;
                    }
                }
                lb.n nVar = lb.n.f10413a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z ? c(iOException) : iOException;
    }

    public final Socket i() {
        ed.g gVar = this.f11048m;
        kotlin.jvm.internal.g.c(gVar);
        okhttp3.f fVar = l.f3237a;
        ArrayList arrayList = gVar.f8665t;
        int size = arrayList.size();
        int i10 = 0;
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                i10 = -1;
                break;
            }
            Object obj = arrayList.get(i11);
            i11++;
            if (kotlin.jvm.internal.g.b(((Reference) obj).get(), this)) {
                break;
            }
            i10++;
        }
        if (i10 == -1) {
            throw new IllegalStateException("Check failed.");
        }
        arrayList.remove(i10);
        this.f11048m = null;
        if (!arrayList.isEmpty()) {
            return null;
        }
        gVar.f8666u = System.nanoTime();
        e eVar = this.f11043d;
        ConcurrentLinkedQueue<ed.g> concurrentLinkedQueue = eVar.h;
        okhttp3.f fVar2 = l.f3237a;
        if (!gVar.f8660n && eVar.f11061a != 0) {
            eVar.f11066f.d(eVar.f11067g, 0L);
            return null;
        }
        gVar.f8660n = true;
        concurrentLinkedQueue.remove(gVar);
        if (concurrentLinkedQueue.isEmpty()) {
            eVar.f11066f.a();
        }
        okhttp3.a address = gVar.f8651d.f176a;
        kotlin.jvm.internal.g.f(address, "address");
        e.a aVar = eVar.f11065e.get(address);
        if (aVar != null) {
            eVar.b(aVar);
            throw null;
        }
        Socket socket = gVar.f8653f;
        kotlin.jvm.internal.g.c(socket);
        return socket;
    }

    @Override // ad.b
    public final boolean isCanceled() {
        return this.f11053s;
    }
}

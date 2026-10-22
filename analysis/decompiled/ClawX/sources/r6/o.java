package r6;

import com.stepos.stepclaw.SecurePrefs;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class o implements n6.d, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public final n6.q f5157a;

    /* renamed from: b, reason: collision with root package name */
    public final n6.s f5158b;

    /* renamed from: c, reason: collision with root package name */
    public final q f5159c;
    public final n d;

    /* renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f5160e;

    /* renamed from: f, reason: collision with root package name */
    public Object f5161f;

    /* renamed from: g, reason: collision with root package name */
    public h f5162g;

    /* renamed from: h, reason: collision with root package name */
    public p f5163h;

    /* renamed from: j, reason: collision with root package name */
    public boolean f5164j;

    /* renamed from: k, reason: collision with root package name */
    public g f5165k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f5166l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f5167m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f5168n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f5169o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f5170p;

    /* renamed from: q, reason: collision with root package name */
    public volatile boolean f5171q;

    /* renamed from: r, reason: collision with root package name */
    public volatile g f5172r;

    /* renamed from: s, reason: collision with root package name */
    public final CopyOnWriteArrayList f5173s;

    public o(n6.q qVar, n6.s sVar) {
        this.f5157a = qVar;
        this.f5158b = sVar;
        this.f5159c = (q) qVar.D.f621a;
        qVar.d.getClass();
        n nVar = new n(this);
        nVar.g(0, TimeUnit.MILLISECONDS);
        this.d = nVar;
        this.f5160e = new AtomicBoolean();
        this.f5170p = true;
        this.f5173s = new CopyOnWriteArrayList();
        new AtomicReference(sVar.d);
    }

    public static final String a(o oVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(oVar.f5171q ? "canceled " : SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);
        sb.append("web socket");
        sb.append(" to ");
        sb.append(oVar.f5158b.f4128a.f());
        return sb.toString();
    }

    public final void b(p connection) {
        kotlin.jvm.internal.p.e(connection, "connection");
        TimeZone timeZone = o6.f.f4330a;
        if (this.f5163h != null) {
            throw new IllegalStateException("Check failed.");
        }
        this.f5163h = connection;
        connection.f5188q.add(new m(this, this.f5161f));
    }

    public final IOException c(IOException iOException) throws IOException {
        IOException interruptedIOException;
        Socket socketI;
        TimeZone timeZone = o6.f.f4330a;
        p pVar = this.f5163h;
        if (pVar != null) {
            synchronized (pVar) {
                socketI = i();
            }
            if (this.f5163h == null) {
                if (socketI != null) {
                    o6.f.c(socketI);
                }
            } else if (socketI != null) {
                throw new IllegalStateException("Check failed.");
            }
        }
        if (!this.f5164j && this.d.j()) {
            interruptedIOException = new InterruptedIOException("timeout");
            if (iOException != null) {
                interruptedIOException.initCause(iOException);
            }
        } else {
            interruptedIOException = iOException;
        }
        if (iOException != null) {
            kotlin.jvm.internal.p.b(interruptedIOException);
        }
        return interruptedIOException;
    }

    public final Object clone() {
        return new o(this.f5157a, this.f5158b);
    }

    public final void d() {
        if (this.f5171q) {
            return;
        }
        this.f5171q = true;
        g gVar = this.f5172r;
        if (gVar != null) {
            gVar.f5143c.cancel();
        }
        Iterator it = this.f5173s.iterator();
        kotlin.jvm.internal.p.d(it, "iterator(...)");
        while (it.hasNext()) {
            ((u) it.next()).cancel();
        }
    }

    public final void e(boolean z) {
        g gVar;
        synchronized (this) {
            if (!this.f5170p) {
                throw new IllegalStateException("released");
            }
        }
        if (z && (gVar = this.f5172r) != null) {
            gVar.f5143c.cancel();
            gVar.f5141a.g(gVar, true, true, true, true, null);
        }
        this.f5165k = null;
    }

    public final n6.u f() {
        ArrayList arrayList = new ArrayList();
        c5.m.p0(arrayList, this.f5157a.f4097b);
        arrayList.add(new s6.a(this.f5157a));
        arrayList.add(new s6.a(this.f5157a.f4104j));
        arrayList.add(new p6.a());
        arrayList.add(a.f5105a);
        arrayList.add(s6.c.f5243a);
        n6.s sVar = this.f5158b;
        n6.q qVar = this.f5157a;
        s6.h hVar = new s6.h(this, arrayList, 0, null, sVar, qVar.f4116v, qVar.f4117w, qVar.f4118x);
        boolean z = false;
        try {
            try {
                n6.u uVarB = hVar.b(sVar);
                if (this.f5171q) {
                    o6.d.a(uVarB);
                    throw new IOException("Canceled");
                }
                h(null);
                return uVarB;
            } catch (IOException e9) {
                z = true;
                IOException iOExceptionH = h(e9);
                kotlin.jvm.internal.p.c(iOExceptionH, "null cannot be cast to non-null type kotlin.Throwable");
                throw iOExceptionH;
            }
        } catch (Throwable th) {
            if (!z) {
                h(null);
            }
            throw th;
        }
    }

    public final IOException g(g exchange, boolean z, boolean z2, boolean z8, boolean z9, IOException iOException) {
        boolean z10;
        boolean z11;
        kotlin.jvm.internal.p.e(exchange, "exchange");
        if (exchange.equals(this.f5172r)) {
            synchronized (this) {
                z10 = false;
                if (z) {
                    try {
                        if (!this.f5166l) {
                            if ((z2 || !this.f5167m) && ((!z9 || !this.f5168n) && (!z8 || !this.f5169o))) {
                            }
                        }
                        if (z) {
                            this.f5166l = false;
                        }
                        if (z2) {
                            this.f5167m = false;
                        }
                        if (z9) {
                            this.f5168n = false;
                        }
                        if (z8) {
                            this.f5169o = false;
                        }
                        boolean z12 = (this.f5166l || this.f5167m || this.f5168n || this.f5169o) ? false : true;
                        if (z12) {
                            if (!this.f5170p) {
                                z10 = true;
                            }
                        }
                        boolean z13 = z10;
                        z10 = z12;
                        z11 = z13;
                    } catch (Throwable th) {
                        throw th;
                    }
                } else {
                    z11 = z2 ? false : false;
                }
            }
            if (z10) {
                this.f5172r = null;
                p pVar = this.f5163h;
                if (pVar != null) {
                    synchronized (pVar) {
                        pVar.f5185n++;
                    }
                }
            }
            if (z11) {
                return c(iOException);
            }
        }
        return iOException;
    }

    public final IOException h(IOException iOException) {
        boolean z;
        synchronized (this) {
            z = false;
            if (this.f5170p) {
                this.f5170p = false;
                if (!this.f5166l && !this.f5167m && !this.f5168n) {
                    if (!this.f5169o) {
                        z = true;
                    }
                }
            }
        }
        return z ? c(iOException) : iOException;
    }

    public final Socket i() {
        p pVar = this.f5163h;
        kotlin.jvm.internal.p.b(pVar);
        TimeZone timeZone = o6.f.f4330a;
        ArrayList arrayList = pVar.f5188q;
        int size = arrayList.size();
        int i8 = 0;
        int i9 = 0;
        while (true) {
            if (i9 >= size) {
                i8 = -1;
                break;
            }
            Object obj = arrayList.get(i9);
            i9++;
            if (kotlin.jvm.internal.p.a(((Reference) obj).get(), this)) {
                break;
            }
            i8++;
        }
        if (i8 == -1) {
            throw new IllegalStateException("Check failed.");
        }
        arrayList.remove(i8);
        this.f5163h = null;
        if (!arrayList.isEmpty()) {
            return null;
        }
        pVar.f5189r = System.nanoTime();
        q qVar = this.f5159c;
        ConcurrentLinkedQueue concurrentLinkedQueue = qVar.d;
        TimeZone timeZone2 = o6.f.f4330a;
        if (!pVar.f5182k) {
            qVar.f5191b.c(qVar.f5192c, 0L);
            return null;
        }
        pVar.f5182k = true;
        concurrentLinkedQueue.remove(pVar);
        if (concurrentLinkedQueue.isEmpty()) {
            q6.c cVar = qVar.f5191b;
            synchronized (cVar.f4873a) {
                if (cVar.a()) {
                    cVar.f4873a.c(cVar);
                }
            }
        }
        return pVar.f5176e;
    }
}

package eb;

import ab.t;
import ab.w;
import ab.z;
import d7.x;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;

/* loaded from: classes.dex */
public final class i implements Cloneable {

    /* renamed from: f, reason: collision with root package name */
    public final t f3272f;

    /* renamed from: g, reason: collision with root package name */
    public final w f3273g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f3274h;

    /* renamed from: i, reason: collision with root package name */
    public final n f3275i;

    /* renamed from: j, reason: collision with root package name */
    public final h f3276j;

    /* renamed from: k, reason: collision with root package name */
    public final AtomicBoolean f3277k;

    /* renamed from: l, reason: collision with root package name */
    public Throwable f3278l;

    /* renamed from: m, reason: collision with root package name */
    public e f3279m;

    /* renamed from: n, reason: collision with root package name */
    public m f3280n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f3281o;

    /* renamed from: p, reason: collision with root package name */
    public c1.o f3282p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f3283q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f3284r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f3285s;

    /* renamed from: t, reason: collision with root package name */
    public volatile boolean f3286t;

    /* renamed from: u, reason: collision with root package name */
    public volatile c1.o f3287u;

    /* renamed from: v, reason: collision with root package name */
    public volatile m f3288v;

    public i(t tVar, w wVar, boolean z4) {
        q7.k.e(wVar, "originalRequest");
        this.f3272f = tVar;
        this.f3273g = wVar;
        this.f3274h = z4;
        this.f3275i = (n) tVar.f628g.f411g;
        tVar.f631j.getClass();
        h hVar = new h(this);
        hVar.g(0, TimeUnit.MILLISECONDS);
        this.f3276j = hVar;
        this.f3277k = new AtomicBoolean();
        this.f3285s = true;
    }

    public static final String a(i iVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(iVar.f3286t ? "canceled " : "");
        sb2.append(iVar.f3274h ? "web socket" : "call");
        sb2.append(" to ");
        sb2.append(iVar.f3273g.f661a.f());
        return sb2.toString();
    }

    public final void b(m mVar) {
        byte[] bArr = bb.b.f1659a;
        if (this.f3280n != null) {
            throw new IllegalStateException("Check failed.");
        }
        this.f3280n = mVar;
        mVar.f3310p.add(new g(this, this.f3278l));
    }

    public final IOException c(IOException iOException) throws IOException {
        IOException interruptedIOException;
        Socket socketL;
        byte[] bArr = bb.b.f1659a;
        m mVar = this.f3280n;
        if (mVar != null) {
            synchronized (mVar) {
                socketL = l();
            }
            if (this.f3280n == null) {
                if (socketL != null) {
                    bb.b.e(socketL);
                }
            } else if (socketL != null) {
                throw new IllegalStateException("Check failed.");
            }
        }
        if (!this.f3281o && this.f3276j.j()) {
            interruptedIOException = new InterruptedIOException("timeout");
            if (iOException != null) {
                interruptedIOException.initCause(iOException);
            }
        } else {
            interruptedIOException = iOException;
        }
        if (iOException != null) {
            q7.k.b(interruptedIOException);
        }
        return interruptedIOException;
    }

    public final Object clone() {
        return new i(this.f3272f, this.f3273g, this.f3274h);
    }

    public final void d() {
        ib.m mVar = ib.m.f5049a;
        ib.m.f5049a.getClass();
        this.f3278l = ib.m.f5050b.isLoggable(Level.FINE) ? new Throwable("response.body().close()") : null;
    }

    public final void e() throws IOException {
        Socket socket;
        if (this.f3286t) {
            return;
        }
        this.f3286t = true;
        c1.o oVar = this.f3287u;
        if (oVar != null) {
            ((fb.e) oVar.f1836d).cancel();
        }
        m mVar = this.f3288v;
        if (mVar == null || (socket = mVar.f3297c) == null) {
            return;
        }
        bb.b.e(socket);
    }

    public final void f(ab.d dVar) {
        f fVar;
        if (!this.f3277k.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed");
        }
        d();
        i5.f fVar2 = this.f3272f.f627f;
        f fVar3 = new f(this, dVar);
        fVar2.getClass();
        synchronized (fVar2) {
            ((ArrayDeque) fVar2.f4654h).add(fVar3);
            if (!this.f3274h) {
                String str = this.f3273g.f661a.f591d;
                Iterator it = ((ArrayDeque) fVar2.f4655i).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        Iterator it2 = ((ArrayDeque) fVar2.f4654h).iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                fVar = null;
                                break;
                            } else {
                                fVar = (f) it2.next();
                                if (q7.k.a(fVar.f3269h.f3273g.f661a.f591d, str)) {
                                    break;
                                }
                            }
                        }
                    } else {
                        fVar = (f) it.next();
                        if (q7.k.a(fVar.f3269h.f3273g.f661a.f591d, str)) {
                            break;
                        }
                    }
                }
                if (fVar != null) {
                    fVar3.f3268g = fVar.f3268g;
                }
            }
        }
        fVar2.M();
    }

    public final z g() {
        if (!this.f3277k.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed");
        }
        this.f3276j.i();
        d();
        try {
            i5.f fVar = this.f3272f.f627f;
            synchronized (fVar) {
                ((ArrayDeque) fVar.f4656j).add(this);
            }
            return i();
        } finally {
            i5.f fVar2 = this.f3272f.f627f;
            fVar2.G((ArrayDeque) fVar2.f4656j, this);
        }
    }

    public final void h(boolean z4) {
        c1.o oVar;
        synchronized (this) {
            if (!this.f3285s) {
                throw new IllegalStateException("released");
            }
        }
        if (z4 && (oVar = this.f3287u) != null) {
            ((fb.e) oVar.f1836d).cancel();
            ((i) oVar.f1834b).j(oVar, true, true, null);
        }
        this.f3282p = null;
    }

    public final z i() {
        ArrayList arrayList = new ArrayList();
        x.D0(arrayList, this.f3272f.f629h);
        arrayList.add(new fb.a(this.f3272f));
        arrayList.add(new fb.a(this.f3272f.f636o));
        arrayList.add(new cb.b());
        arrayList.add(a.f3242a);
        if (!this.f3274h) {
            x.D0(arrayList, this.f3272f.f630i);
        }
        arrayList.add(new fb.b(this.f3274h));
        w wVar = this.f3273g;
        t tVar = this.f3272f;
        try {
            try {
                z zVarB = new fb.g(this, arrayList, 0, null, wVar, tVar.A, tVar.B, tVar.C).b(this.f3273g);
                if (this.f3286t) {
                    bb.b.d(zVarB);
                    throw new IOException("Canceled");
                }
                k(null);
                return zVarB;
            } catch (IOException e10) {
                IOException iOExceptionK = k(e10);
                q7.k.c(iOExceptionK, "null cannot be cast to non-null type kotlin.Throwable");
                throw iOExceptionK;
            }
        } catch (Throwable th) {
            if (0 == 0) {
                k(null);
            }
            throw th;
        }
    }

    public final IOException j(c1.o oVar, boolean z4, boolean z10, IOException iOException) {
        boolean z11;
        boolean z12;
        q7.k.e(oVar, "exchange");
        if (oVar.equals(this.f3287u)) {
            synchronized (this) {
                z11 = false;
                if (z4) {
                    try {
                        if (!this.f3283q) {
                            if (z10 || !this.f3284r) {
                                z12 = false;
                            }
                        }
                        if (z4) {
                            this.f3283q = false;
                        }
                        if (z10) {
                            this.f3284r = false;
                        }
                        boolean z13 = this.f3283q;
                        boolean z14 = (z13 || this.f3284r) ? false : true;
                        if (!z13 && !this.f3284r) {
                            if (!this.f3285s) {
                                z11 = true;
                            }
                        }
                        z12 = z11;
                        z11 = z14;
                    } catch (Throwable th) {
                        throw th;
                    }
                } else {
                    if (z10) {
                    }
                    z12 = false;
                }
            }
            if (z11) {
                this.f3287u = null;
                m mVar = this.f3280n;
                if (mVar != null) {
                    synchronized (mVar) {
                        mVar.f3307m++;
                    }
                }
            }
            if (z12) {
                return c(iOException);
            }
        }
        return iOException;
    }

    public final IOException k(IOException iOException) {
        boolean z4;
        synchronized (this) {
            z4 = false;
            if (this.f3285s) {
                this.f3285s = false;
                if (!this.f3283q) {
                    if (!this.f3284r) {
                        z4 = true;
                    }
                }
            }
        }
        return z4 ? c(iOException) : iOException;
    }

    public final Socket l() {
        m mVar = this.f3280n;
        q7.k.b(mVar);
        byte[] bArr = bb.b.f1659a;
        ArrayList arrayList = mVar.f3310p;
        Iterator it = arrayList.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            }
            if (q7.k.a(((Reference) it.next()).get(), this)) {
                break;
            }
            i2++;
        }
        if (i2 == -1) {
            throw new IllegalStateException("Check failed.");
        }
        arrayList.remove(i2);
        this.f3280n = null;
        if (!arrayList.isEmpty()) {
            return null;
        }
        mVar.f3311q = System.nanoTime();
        n nVar = this.f3275i;
        ConcurrentLinkedQueue concurrentLinkedQueue = nVar.f3315d;
        db.c cVar = nVar.f3313b;
        byte[] bArr2 = bb.b.f1659a;
        if (!mVar.f3304j) {
            cVar.c(nVar.f3314c, 0L);
            return null;
        }
        mVar.f3304j = true;
        concurrentLinkedQueue.remove(mVar);
        if (concurrentLinkedQueue.isEmpty()) {
            cVar.a();
        }
        Socket socket = mVar.f3298d;
        q7.k.b(socket);
        return socket;
    }
}

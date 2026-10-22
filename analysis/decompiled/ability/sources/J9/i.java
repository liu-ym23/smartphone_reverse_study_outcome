package J9;

import D7.A;
import F9.C0238p;
import F9.F;
import F9.G;
import F9.InterfaceC0229g;
import F9.M;
import F9.t;
import N9.m;
import com.stepos.taskrobot.llmapi.stepfun.InjectExperienceResult;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public final class i implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public final F f897a;
    public final G b;
    public final k c;
    public final t d;
    public final h e;
    public final AtomicBoolean f;
    public Object g;
    public e h;
    public okhttp3.internal.connection.a i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f898j;
    public G6.c k;
    public boolean l;
    public boolean m;
    public boolean n;
    public volatile boolean o;
    public volatile G6.c p;

    /* renamed from: q, reason: collision with root package name */
    public volatile okhttp3.internal.connection.a f899q;

    public i(F f, G g) {
        this.f897a = f;
        this.b = g;
        this.c = f.b.f648a;
        this.d = f.e.i(this);
        h hVar = new h(this);
        long j5 = f.f623w;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        hVar.g(j5);
        this.e = hVar;
        this.f = new AtomicBoolean();
        this.n = true;
    }

    public final void a(okhttp3.internal.connection.a aVar) {
        byte[] bArr = G9.b.f704a;
        if (this.i != null) {
            throw new IllegalStateException("Check failed.");
        }
        this.i = aVar;
        aVar.p.add(new g(this, this.g));
    }

    public final IOException b(IOException iOException) throws IOException {
        IOException interruptedIOException;
        Socket socketK;
        byte[] bArr = G9.b.f704a;
        okhttp3.internal.connection.a aVar = this.i;
        if (aVar != null) {
            synchronized (aVar) {
                socketK = k();
            }
            if (this.i == null) {
                if (socketK != null) {
                    G9.b.d(socketK);
                }
                this.d.k(this, aVar);
            } else if (socketK != null) {
                throw new IllegalStateException("Check failed.");
            }
        }
        if (!this.f898j && this.e.i()) {
            interruptedIOException = new InterruptedIOException(InjectExperienceResult.REASON_TIMEOUT);
            if (iOException != null) {
                interruptedIOException.initCause(iOException);
            }
        } else {
            interruptedIOException = iOException;
        }
        if (iOException == null) {
            this.d.c(this);
            return interruptedIOException;
        }
        t tVar = this.d;
        kotlin.jvm.internal.k.c(interruptedIOException);
        tVar.d(this, interruptedIOException);
        return interruptedIOException;
    }

    public final void c(InterfaceC0229g interfaceC0229g) {
        f fVar;
        if (!this.f.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed");
        }
        m.Companion.getClass();
        this.g = m.platform.getStackTraceForCloseable("response.body().close()");
        this.d.e(this);
        C0238p c0238p = this.f897a.f616a;
        f fVar2 = new f(this, interfaceC0229g);
        c0238p.getClass();
        synchronized (c0238p) {
            c0238p.d.add(fVar2);
            String str = this.b.f626a.d;
            Iterator it = c0238p.e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    Iterator it2 = c0238p.d.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            fVar = null;
                            break;
                        } else {
                            fVar = (f) it2.next();
                            if (kotlin.jvm.internal.k.b(fVar.c.b.f626a.d, str)) {
                                break;
                            }
                        }
                    }
                } else {
                    fVar = (f) it.next();
                    if (kotlin.jvm.internal.k.b(fVar.c.b.f626a.d, str)) {
                        break;
                    }
                }
            }
            if (fVar != null) {
                fVar2.b = fVar.b;
            }
        }
        c0238p.e();
    }

    public final void cancel() {
        Socket socket;
        if (this.o) {
            return;
        }
        this.o = true;
        G6.c cVar = this.p;
        if (cVar != null) {
            ((K9.e) cVar.f).cancel();
        }
        okhttp3.internal.connection.a aVar = this.f899q;
        if (aVar != null && (socket = aVar.c) != null) {
            G9.b.d(socket);
        }
        this.d.f(this);
    }

    public final Object clone() {
        return new i(this.f897a, this.b);
    }

    public final M d() {
        if (!this.f.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed");
        }
        this.e.h();
        m.Companion.getClass();
        this.g = m.platform.getStackTraceForCloseable("response.body().close()");
        this.d.e(this);
        try {
            C0238p c0238p = this.f897a.f616a;
            synchronized (c0238p) {
                c0238p.f.add(this);
            }
            return f();
        } finally {
            C0238p c0238p2 = this.f897a.f616a;
            c0238p2.c(c0238p2.f, this);
        }
    }

    public final void e(boolean z10) {
        G6.c cVar;
        synchronized (this) {
            if (!this.n) {
                throw new IllegalStateException("released");
            }
        }
        if (z10 && (cVar = this.p) != null) {
            ((K9.e) cVar.f).cancel();
            ((i) cVar.c).h(cVar, true, true, null);
        }
        this.k = null;
    }

    public final M f() {
        ArrayList arrayList = new ArrayList();
        A.e0(this.f897a.c, arrayList);
        arrayList.add(new K9.a(this.f897a, 1));
        arrayList.add(new K9.a(this.f897a.f617j));
        arrayList.add(new H9.b());
        arrayList.add(a.f890a);
        A.e0(this.f897a.d, arrayList);
        arrayList.add(new K9.b(0));
        G g = this.b;
        F f = this.f897a;
        K9.g gVar = new K9.g(this, arrayList, 0, null, g, f.f624x, f.y, f.f625z);
        boolean z10 = false;
        try {
            try {
                M mB = gVar.b(g);
                if (this.o) {
                    G9.b.c(mB);
                    throw new IOException("Canceled");
                }
                j(null);
                return mB;
            } catch (IOException e) {
                z10 = true;
                IOException iOExceptionJ = j(e);
                kotlin.jvm.internal.k.d(iOExceptionJ, "null cannot be cast to non-null type kotlin.Throwable");
                throw iOExceptionJ;
            }
        } catch (Throwable th) {
            if (!z10) {
                j(null);
            }
            throw th;
        }
    }

    public final IOException h(G6.c exchange, boolean z10, boolean z11, IOException iOException) {
        boolean z12;
        boolean z13;
        kotlin.jvm.internal.k.f(exchange, "exchange");
        if (exchange.equals(this.p)) {
            synchronized (this) {
                z12 = false;
                if (z10) {
                    try {
                        if (!this.l) {
                            if (z11 || !this.m) {
                                z13 = false;
                            }
                        }
                        if (z10) {
                            this.l = false;
                        }
                        if (z11) {
                            this.m = false;
                        }
                        boolean z14 = this.l;
                        boolean z15 = (z14 || this.m) ? false : true;
                        if (!z14 && !this.m) {
                            if (!this.n) {
                                z12 = true;
                            }
                        }
                        z13 = z12;
                        z12 = z15;
                    } catch (Throwable th) {
                        throw th;
                    }
                } else {
                    if (z11) {
                    }
                    z13 = false;
                }
            }
            if (z12) {
                this.p = null;
                okhttp3.internal.connection.a aVar = this.i;
                if (aVar != null) {
                    synchronized (aVar) {
                        aVar.m++;
                    }
                }
            }
            if (z13) {
                return b(iOException);
            }
        }
        return iOException;
    }

    public final IOException j(IOException iOException) {
        boolean z10;
        synchronized (this) {
            z10 = false;
            if (this.n) {
                this.n = false;
                if (!this.l) {
                    if (!this.m) {
                        z10 = true;
                    }
                }
            }
        }
        return z10 ? b(iOException) : iOException;
    }

    public final Socket k() {
        okhttp3.internal.connection.a aVar = this.i;
        kotlin.jvm.internal.k.c(aVar);
        byte[] bArr = G9.b.f704a;
        ArrayList arrayList = aVar.p;
        Iterator it = arrayList.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (kotlin.jvm.internal.k.b(((Reference) it.next()).get(), this)) {
                break;
            }
            i++;
        }
        if (i == -1) {
            throw new IllegalStateException("Check failed.");
        }
        arrayList.remove(i);
        this.i = null;
        if (!arrayList.isEmpty()) {
            return null;
        }
        aVar.f5472q = System.nanoTime();
        k kVar = this.c;
        ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) kVar.f;
        I9.c cVar = (I9.c) kVar.d;
        byte[] bArr2 = G9.b.f704a;
        if (!aVar.f5471j && kVar.b != 0) {
            cVar.c((I9.b) kVar.e, 0L);
            return null;
        }
        aVar.f5471j = true;
        concurrentLinkedQueue.remove(aVar);
        if (concurrentLinkedQueue.isEmpty()) {
            cVar.a();
        }
        Socket socket = aVar.d;
        kotlin.jvm.internal.k.c(socket);
        return socket;
    }
}

package c6;

import android.net.Credentials;
import android.net.LocalSocket;
import android.util.Log;
import androidx.lifecycle.a0;
import b0.g2;
import c7.r;
import ia.d0;
import ia.f1;
import ia.s;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import k5.t;
import ka.y;
import la.e0;
import la.j0;
import la.k0;
import m.x;

/* loaded from: classes.dex */
public final class c implements l {

    /* renamed from: r, reason: collision with root package name */
    public static final AtomicInteger f1907r = new AtomicInteger(0);

    /* renamed from: a, reason: collision with root package name */
    public final LocalSocket f1908a;

    /* renamed from: b, reason: collision with root package name */
    public final t f1909b;

    /* renamed from: c, reason: collision with root package name */
    public final String f1910c;

    /* renamed from: d, reason: collision with root package name */
    public final int f1911d;

    /* renamed from: e, reason: collision with root package name */
    public final String f1912e;

    /* renamed from: f, reason: collision with root package name */
    public final na.d f1913f;

    /* renamed from: g, reason: collision with root package name */
    public final ka.g f1914g;

    /* renamed from: h, reason: collision with root package name */
    public final j0 f1915h;

    /* renamed from: i, reason: collision with root package name */
    public final s f1916i;

    /* renamed from: j, reason: collision with root package name */
    public final AtomicBoolean f1917j;

    /* renamed from: k, reason: collision with root package name */
    public final ra.d f1918k;

    /* renamed from: l, reason: collision with root package name */
    public final la.d f1919l;

    /* renamed from: m, reason: collision with root package name */
    public final e0 f1920m;

    /* renamed from: n, reason: collision with root package name */
    public final DataOutputStream f1921n;

    /* renamed from: o, reason: collision with root package name */
    public final DataInputStream f1922o;

    /* renamed from: p, reason: collision with root package name */
    public final AtomicReference f1923p;

    /* renamed from: q, reason: collision with root package name */
    public final ExecutorService f1924q;

    public c(LocalSocket localSocket, k5.a aVar, t tVar) throws IOException {
        Object objN;
        q7.k.e(aVar, "dispatchers");
        q7.k.e(tVar, "logger");
        this.f1908a = localSocket;
        this.f1909b = tVar;
        this.f1910c = n.f.c(f1907r.incrementAndGet(), "ls-");
        m mVar = m.LS;
        try {
            objN = localSocket.getPeerCredentials();
        } catch (Throwable th) {
            objN = w7.e0.n(th);
        }
        Credentials credentials = (Credentials) (objN instanceof c7.l ? null : objN);
        int uid = credentials != null ? credentials.getUid() : -1;
        this.f1911d = uid;
        this.f1912e = x.k("uid=", uid, credentials != null ? credentials.getPid() : -1, ",pid=");
        na.d dVarB = d0.b(f1.plus(d0.c(), aVar.f5616a));
        this.f1913f = dVarB;
        ka.g gVarB = a.a.b(-2, 6, null);
        this.f1914g = gVarB;
        j0 j0VarB = k0.b(1, 0, 6);
        this.f1915h = j0VarB;
        this.f1916i = d0.a();
        this.f1917j = new AtomicBoolean(false);
        this.f1918k = new ra.d();
        this.f1919l = new la.d(gVarB);
        this.f1920m = new e0(j0VarB);
        this.f1921n = new DataOutputStream(this.f1908a.getOutputStream());
        this.f1922o = new DataInputStream(this.f1908a.getInputStream());
        this.f1923p = new AtomicReference();
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new b(0, this));
        this.f1924q = executorServiceNewSingleThreadExecutor;
        Log.d("LocalSocketChannel", "[" + this.f1910c + "] init: socket.connected=" + this.f1908a.isConnected() + ", socket.outputStream=" + this.f1908a.getOutputStream() + ", socket.inputStream=" + this.f1908a.getInputStream());
        Log.d("LocalSocketChannel", "[" + this.f1910c + "] init: creating read loop, scope.active=" + d0.q(dVarB) + ", scope.coroutineContext=" + dVarB.f6896f);
        String str = this.f1910c;
        String name = Thread.currentThread().getName();
        boolean zIsDaemon = Thread.currentThread().isDaemon();
        StringBuilder sbP = a1.a.p("[", str, "] init: current Thread=", name, ", daemon=");
        sbP.append(zIsDaemon);
        Log.d("LocalSocketChannel", sbP.toString());
        Log.d("LocalSocketChannel", "[" + this.f1910c + "] init: starting read loop on dedicated thread (not coroutine)");
        executorServiceNewSingleThreadExecutor.submit(new a0(3, this));
        Log.d("LocalSocketChannel", "[" + this.f1910c + "] init: read loop submitted to executor");
    }

    @Override // c6.l
    public final la.j a() {
        return this.f1919l;
    }

    @Override // c6.l
    public final Object b(String str, i7.c cVar) throws Throwable {
        Object objB = d0.B(this.f1913f.f6896f, new g2(this, str, null, 1), cVar);
        return objB == h7.a.f4212f ? objB : r.f1986a;
    }

    @Override // c6.l
    public final String c() {
        return this.f1912e;
    }

    @Override // c6.l
    public final e0 d() {
        return this.f1920m;
    }

    @Override // c6.l
    public final r e(a aVar) {
        f(aVar);
        return r.f1986a;
    }

    public final void f(a aVar) {
        if (this.f1917j.compareAndSet(false, true)) {
            try {
                this.f1908a.close();
            } catch (Throwable th) {
                w7.e0.n(th);
            }
            try {
                y.close$default(this.f1914g, null, 1, null);
            } catch (Throwable th2) {
                w7.e0.n(th2);
            }
            this.f1915h.M(aVar);
            this.f1916i.X(aVar);
            d0.e(this.f1913f, null);
            try {
                this.f1924q.shutdownNow();
            } catch (Throwable th3) {
                w7.e0.n(th3);
            }
            if (aVar.f1904c != null) {
                ((k5.g) this.f1909b).c("LSChan", a1.a.x(this.f1910c, " closed: ", aVar.f1903b), aVar.f1904c);
            }
        }
    }

    @Override // c6.l
    public final String getId() {
        return this.f1910c;
    }
}

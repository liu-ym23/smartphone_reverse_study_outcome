package L4;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class d extends z {

    /* renamed from: i, reason: collision with root package name */
    private static final long f3925i;

    /* renamed from: j, reason: collision with root package name */
    private static final long f3926j;

    /* renamed from: k, reason: collision with root package name */
    private static d f3927k;

    /* renamed from: l, reason: collision with root package name */
    public static final a f3928l = new a(null);

    /* renamed from: f, reason: collision with root package name */
    private boolean f3929f;

    /* renamed from: g, reason: collision with root package name */
    private d f3930g;

    /* renamed from: h, reason: collision with root package name */
    private long f3931h;

    public static final class a {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean d(d dVar) {
            synchronized (d.class) {
                for (d dVar2 = d.f3927k; dVar2 != null; dVar2 = dVar2.f3930g) {
                    if (dVar2.f3930g == dVar) {
                        dVar2.f3930g = dVar.f3930g;
                        dVar.f3930g = null;
                        return false;
                    }
                }
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void e(d dVar, long j5, boolean z5) {
            synchronized (d.class) {
                try {
                    if (d.f3927k == null) {
                        d.f3927k = new d();
                        new b().start();
                    }
                    long jNanoTime = System.nanoTime();
                    if (j5 != 0 && z5) {
                        dVar.f3931h = Math.min(j5, dVar.c() - jNanoTime) + jNanoTime;
                    } else if (j5 != 0) {
                        dVar.f3931h = j5 + jNanoTime;
                    } else {
                        if (!z5) {
                            throw new AssertionError();
                        }
                        dVar.f3931h = dVar.c();
                    }
                    long jV = dVar.v(jNanoTime);
                    d dVar2 = d.f3927k;
                    if (dVar2 == null) {
                        j4.k.p();
                    }
                    while (dVar2.f3930g != null) {
                        d dVar3 = dVar2.f3930g;
                        if (dVar3 == null) {
                            j4.k.p();
                        }
                        if (jV < dVar3.v(jNanoTime)) {
                            break;
                        }
                        dVar2 = dVar2.f3930g;
                        if (dVar2 == null) {
                            j4.k.p();
                        }
                    }
                    dVar.f3930g = dVar2.f3930g;
                    dVar2.f3930g = dVar;
                    if (dVar2 == d.f3927k) {
                        d.class.notify();
                    }
                    V3.v vVar = V3.v.f5542a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final d c() throws InterruptedException {
            d dVar = d.f3927k;
            if (dVar == null) {
                j4.k.p();
            }
            d dVar2 = dVar.f3930g;
            if (dVar2 == null) {
                long jNanoTime = System.nanoTime();
                d.class.wait(d.f3925i);
                d dVar3 = d.f3927k;
                if (dVar3 == null) {
                    j4.k.p();
                }
                if (dVar3.f3930g != null || System.nanoTime() - jNanoTime < d.f3926j) {
                    return null;
                }
                return d.f3927k;
            }
            long jV = dVar2.v(System.nanoTime());
            if (jV > 0) {
                long j5 = jV / 1000000;
                d.class.wait(j5, (int) (jV - (1000000 * j5)));
                return null;
            }
            d dVar4 = d.f3927k;
            if (dVar4 == null) {
                j4.k.p();
            }
            dVar4.f3930g = dVar2.f3930g;
            dVar2.f3930g = null;
            return dVar2;
        }

        public /* synthetic */ a(j4.g gVar) {
            this();
        }
    }

    private static final class b extends Thread {
        public b() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            d dVarC;
            while (true) {
                try {
                    synchronized (d.class) {
                        dVarC = d.f3928l.c();
                        if (dVarC == d.f3927k) {
                            d.f3927k = null;
                            return;
                        }
                        V3.v vVar = V3.v.f5542a;
                    }
                    if (dVarC != null) {
                        dVarC.y();
                    }
                } catch (InterruptedException unused) {
                    continue;
                }
            }
        }
    }

    public static final class c implements w {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ w f3933b;

        c(w wVar) {
            this.f3933b = wVar;
        }

        @Override // L4.w
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public d b() {
            return d.this;
        }

        @Override // L4.w, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            d.this.q();
            try {
                try {
                    this.f3933b.close();
                    d.this.t(true);
                } catch (IOException e6) {
                    throw d.this.s(e6);
                }
            } catch (Throwable th) {
                d.this.t(false);
                throw th;
            }
        }

        @Override // L4.w, java.io.Flushable
        public void flush() throws IOException {
            d.this.q();
            try {
                try {
                    this.f3933b.flush();
                    d.this.t(true);
                } catch (IOException e6) {
                    throw d.this.s(e6);
                }
            } catch (Throwable th) {
                d.this.t(false);
                throw th;
            }
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.f3933b + ')';
        }

        @Override // L4.w
        public void y0(e eVar, long j5) throws IOException {
            j4.k.h(eVar, "source");
            L4.c.b(eVar.size(), 0L, j5);
            while (true) {
                long j6 = 0;
                if (j5 <= 0) {
                    return;
                }
                t tVar = eVar.f3938a;
                if (tVar == null) {
                    j4.k.p();
                }
                while (true) {
                    if (j6 >= 65536) {
                        break;
                    }
                    j6 += tVar.f3976c - tVar.f3975b;
                    if (j6 >= j5) {
                        j6 = j5;
                        break;
                    } else {
                        tVar = tVar.f3979f;
                        if (tVar == null) {
                            j4.k.p();
                        }
                    }
                }
                d.this.q();
                try {
                    try {
                        this.f3933b.y0(eVar, j6);
                        j5 -= j6;
                        d.this.t(true);
                    } catch (IOException e6) {
                        throw d.this.s(e6);
                    }
                } catch (Throwable th) {
                    d.this.t(false);
                    throw th;
                }
            }
        }
    }

    /* renamed from: L4.d$d, reason: collision with other inner class name */
    public static final class C0058d implements y {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ y f3935b;

        C0058d(y yVar) {
            this.f3935b = yVar;
        }

        @Override // L4.y
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public d b() {
            return d.this;
        }

        @Override // L4.y, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            try {
                try {
                    this.f3935b.close();
                    d.this.t(true);
                } catch (IOException e6) {
                    throw d.this.s(e6);
                }
            } catch (Throwable th) {
                d.this.t(false);
                throw th;
            }
        }

        @Override // L4.y
        public long e(e eVar, long j5) throws IOException {
            j4.k.h(eVar, "sink");
            d.this.q();
            try {
                try {
                    long jE = this.f3935b.e(eVar, j5);
                    d.this.t(true);
                    return jE;
                } catch (IOException e6) {
                    throw d.this.s(e6);
                }
            } catch (Throwable th) {
                d.this.t(false);
                throw th;
            }
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.f3935b + ')';
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        f3925i = millis;
        f3926j = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long v(long j5) {
        return this.f3931h - j5;
    }

    public final void q() {
        if (this.f3929f) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long jH = h();
        boolean zE = e();
        if (jH != 0 || zE) {
            this.f3929f = true;
            f3928l.e(this, jH, zE);
        }
    }

    public final boolean r() {
        if (!this.f3929f) {
            return false;
        }
        this.f3929f = false;
        return f3928l.d(this);
    }

    public final IOException s(IOException iOException) {
        j4.k.h(iOException, "cause");
        return !r() ? iOException : u(iOException);
    }

    public final void t(boolean z5) throws IOException {
        if (r() && z5) {
            throw u(null);
        }
    }

    protected IOException u(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final w w(w wVar) {
        j4.k.h(wVar, "sink");
        return new c(wVar);
    }

    public final y x(y yVar) {
        j4.k.h(yVar, "source");
        return new C0058d(yVar);
    }

    protected void y() {
    }
}

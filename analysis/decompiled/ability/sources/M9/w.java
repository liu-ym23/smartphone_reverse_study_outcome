package M9;

import java.io.IOException;
import java.util.ArrayDeque;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;

/* loaded from: classes4.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public final int f998a;
    public final o b;
    public long c;
    public long d;
    public long e;
    public long f;
    public final ArrayDeque g;
    public boolean h;
    public final u i;

    /* renamed from: j, reason: collision with root package name */
    public final t f999j;
    public final v k;
    public final v l;
    public ErrorCode m;
    public IOException n;

    public w(int i, o connection, boolean z10, boolean z11, F9.w wVar) {
        kotlin.jvm.internal.k.f(connection, "connection");
        this.f998a = i;
        this.b = connection;
        this.f = connection.f986q.a();
        ArrayDeque arrayDeque = new ArrayDeque();
        this.g = arrayDeque;
        this.i = new u(this, connection.p.a(), z11);
        this.f999j = new t(this, z10);
        this.k = new v(this);
        this.l = new v(this);
        if (wVar == null) {
            if (!g()) {
                throw new IllegalStateException("remotely-initiated streams should have headers");
            }
        } else {
            if (g()) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
            }
            arrayDeque.add(wVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            r2 = this;
            byte[] r0 = G9.b.f704a
            monitor-enter(r2)
            M9.u r0 = r2.i     // Catch: java.lang.Throwable -> L18
            boolean r1 = r0.b     // Catch: java.lang.Throwable -> L18
            if (r1 != 0) goto L1c
            boolean r0 = r0.e     // Catch: java.lang.Throwable -> L18
            if (r0 == 0) goto L1c
            M9.t r0 = r2.f999j     // Catch: java.lang.Throwable -> L18
            boolean r1 = r0.f996a     // Catch: java.lang.Throwable -> L18
            if (r1 != 0) goto L1a
            boolean r0 = r0.c     // Catch: java.lang.Throwable -> L18
            if (r0 == 0) goto L1c
            goto L1a
        L18:
            r0 = move-exception
            goto L35
        L1a:
            r0 = 1
            goto L1d
        L1c:
            r0 = 0
        L1d:
            boolean r1 = r2.h()     // Catch: java.lang.Throwable -> L18
            monitor-exit(r2)
            if (r0 == 0) goto L2b
            okhttp3.internal.http2.ErrorCode r0 = okhttp3.internal.http2.ErrorCode.CANCEL
            r1 = 0
            r2.c(r0, r1)
            return
        L2b:
            if (r1 != 0) goto L34
            M9.o r0 = r2.b
            int r2 = r2.f998a
            r0.g(r2)
        L34:
            return
        L35:
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: M9.w.a():void");
    }

    public final void b() throws IOException {
        t tVar = this.f999j;
        if (tVar.c) {
            throw new IOException("stream closed");
        }
        if (tVar.f996a) {
            throw new IOException("stream finished");
        }
        if (this.m != null) {
            IOException iOException = this.n;
            if (iOException != null) {
                throw iOException;
            }
            ErrorCode errorCode = this.m;
            kotlin.jvm.internal.k.c(errorCode);
            throw new StreamResetException(errorCode);
        }
    }

    public final void c(ErrorCode errorCode, IOException iOException) {
        if (d(errorCode, iOException)) {
            this.b.f991w.l(this.f998a, errorCode);
        }
    }

    public final boolean d(ErrorCode errorCode, IOException iOException) {
        byte[] bArr = G9.b.f704a;
        synchronized (this) {
            if (this.m != null) {
                return false;
            }
            this.m = errorCode;
            this.n = iOException;
            notifyAll();
            if (this.i.b) {
                if (this.f999j.f996a) {
                    return false;
                }
            }
            this.b.g(this.f998a);
            return true;
        }
    }

    public final void e(ErrorCode errorCode) {
        if (d(errorCode, null)) {
            this.b.n(this.f998a, errorCode);
        }
    }

    public final t f() {
        synchronized (this) {
            if (!this.h && !g()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.f999j;
    }

    public final boolean g() {
        boolean z10 = (this.f998a & 1) == 1;
        this.b.getClass();
        return true == z10;
    }

    public final synchronized boolean h() {
        try {
            if (this.m != null) {
                return false;
            }
            u uVar = this.i;
            if (uVar.b || uVar.e) {
                t tVar = this.f999j;
                if (tVar.f996a || tVar.c) {
                    if (this.h) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void i(F9.w headers, boolean z10) {
        boolean zH;
        kotlin.jvm.internal.k.f(headers, "headers");
        byte[] bArr = G9.b.f704a;
        synchronized (this) {
            try {
                if (this.h && z10) {
                    this.i.getClass();
                } else {
                    this.h = true;
                    this.g.add(headers);
                }
                if (z10) {
                    this.i.b = true;
                }
                zH = h();
                notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zH) {
            return;
        }
        this.b.g(this.f998a);
    }

    public final synchronized void j(ErrorCode errorCode) {
        if (this.m == null) {
            this.m = errorCode;
            notifyAll();
        }
    }
}

package M9;

import java.io.IOException;
import java.io.InterruptedIOException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;

/* loaded from: classes4.dex */
public final class u implements V9.w {

    /* renamed from: a, reason: collision with root package name */
    public final long f997a;
    public boolean b;
    public final V9.g c = new V9.g();
    public final V9.g d = new V9.g();
    public boolean e;
    public final /* synthetic */ w f;

    public u(w wVar, long j5, boolean z10) {
        this.f = wVar;
        this.f997a = j5;
        this.b = z10;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        long j5;
        w wVar = this.f;
        synchronized (wVar) {
            this.e = true;
            V9.g gVar = this.d;
            j5 = gVar.b;
            gVar.b();
            wVar.notifyAll();
        }
        if (j5 > 0) {
            w wVar2 = this.f;
            byte[] bArr = G9.b.f704a;
            wVar2.b.k(j5);
        }
        this.f.a();
    }

    @Override // V9.w
    public final long e(V9.g sink, long j5) throws Throwable {
        ErrorCode errorCode;
        Throwable streamResetException;
        boolean z10;
        long jE;
        kotlin.jvm.internal.k.f(sink, "sink");
        do {
            w wVar = this.f;
            synchronized (wVar) {
                wVar.k.h();
                try {
                    synchronized (wVar) {
                        errorCode = wVar.m;
                    }
                } finally {
                    wVar.k.k();
                }
            }
            if (errorCode != null && !this.b) {
                streamResetException = wVar.n;
                if (streamResetException == null) {
                    synchronized (wVar) {
                        ErrorCode errorCode2 = wVar.m;
                        kotlin.jvm.internal.k.c(errorCode2);
                        streamResetException = new StreamResetException(errorCode2);
                    }
                }
            }
            streamResetException = null;
            if (this.e) {
                throw new IOException("stream closed");
            }
            V9.g gVar = this.d;
            long j6 = gVar.b;
            z10 = false;
            if (j6 > 0) {
                jE = gVar.e(sink, Math.min(8192L, j6));
                long j10 = wVar.c + jE;
                wVar.c = j10;
                long j11 = j10 - wVar.d;
                if (streamResetException == null && j11 >= wVar.b.p.a() / 2) {
                    wVar.b.r(wVar.f998a, j11);
                    wVar.d = wVar.c;
                }
            } else {
                if (!this.b && streamResetException == null) {
                    try {
                        wVar.wait();
                        z10 = true;
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                }
                jE = -1;
            }
        } while (z10);
        if (jE != -1) {
            return jE;
        }
        if (streamResetException == null) {
            return -1L;
        }
        throw streamResetException;
    }

    @Override // V9.w
    public final V9.y timeout() {
        return this.f.k;
    }
}

package M9;

import java.io.InterruptedIOException;
import okhttp3.internal.http2.ErrorCode;

/* loaded from: classes4.dex */
public final class t implements V9.u {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f996a;
    public final V9.g b = new V9.g();
    public boolean c;
    public final /* synthetic */ w d;

    public t(w wVar, boolean z10) {
        this.d = wVar;
        this.f996a = z10;
    }

    /* JADX WARN: Finally extract failed */
    public final void b(boolean z10) {
        long jMin;
        boolean z11;
        w wVar = this.d;
        synchronized (wVar) {
            wVar.l.h();
            while (wVar.e >= wVar.f && !this.f996a && !this.c) {
                try {
                    synchronized (wVar) {
                        ErrorCode errorCode = wVar.m;
                        if (errorCode != null) {
                            break;
                        }
                        try {
                            wVar.wait();
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                            throw new InterruptedIOException();
                        }
                    }
                } catch (Throwable th) {
                    wVar.l.k();
                    throw th;
                }
            }
            wVar.l.k();
            wVar.b();
            jMin = Math.min(wVar.f - wVar.e, this.b.b);
            wVar.e += jMin;
            z11 = z10 && jMin == this.b.b;
        }
        this.d.l.h();
        try {
            w wVar2 = this.d;
            wVar2.b.l(wVar2.f998a, z11, this.b, jMin);
        } finally {
            this.d.l.k();
        }
    }

    @Override // V9.u, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        boolean z10;
        w wVar = this.d;
        byte[] bArr = G9.b.f704a;
        synchronized (wVar) {
            if (this.c) {
                return;
            }
            synchronized (wVar) {
                z10 = wVar.m == null;
            }
            w wVar2 = this.d;
            if (!wVar2.f999j.f996a) {
                if (this.b.b > 0) {
                    while (this.b.b > 0) {
                        b(true);
                    }
                } else if (z10) {
                    wVar2.b.l(wVar2.f998a, true, null, 0L);
                }
            }
            synchronized (this.d) {
                this.c = true;
            }
            this.d.b.flush();
            this.d.a();
        }
    }

    @Override // V9.u, java.io.Flushable
    public final void flush() {
        w wVar = this.d;
        byte[] bArr = G9.b.f704a;
        synchronized (wVar) {
            wVar.b();
        }
        while (this.b.b > 0) {
            b(false);
            this.d.b.flush();
        }
    }

    @Override // V9.u
    public final V9.y timeout() {
        return this.d.l;
    }

    @Override // V9.u
    public final void write(V9.g source, long j5) {
        kotlin.jvm.internal.k.f(source, "source");
        byte[] bArr = G9.b.f704a;
        V9.g gVar = this.b;
        gVar.write(source, j5);
        while (gVar.b >= 16384) {
            b(false);
        }
    }
}

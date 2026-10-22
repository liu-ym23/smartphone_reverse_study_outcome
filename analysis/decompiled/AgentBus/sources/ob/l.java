package ob;

import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public final class l implements i0 {

    /* renamed from: f, reason: collision with root package name */
    public final u f8001f;

    /* renamed from: g, reason: collision with root package name */
    public long f8002g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f8003h;

    public l(u uVar) {
        q7.k.e(uVar, "fileHandle");
        this.f8001f = uVar;
        this.f8002g = 0L;
    }

    @Override // ob.i0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        u uVar = this.f8001f;
        if (this.f8003h) {
            return;
        }
        this.f8003h = true;
        ReentrantLock reentrantLock = uVar.f8037i;
        reentrantLock.lock();
        try {
            int i2 = uVar.f8036h - 1;
            uVar.f8036h = i2;
            if (i2 == 0) {
                if (uVar.f8035g) {
                    synchronized (uVar) {
                        uVar.f8038j.close();
                    }
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // ob.i0, java.io.Flushable
    public final void flush() {
        if (this.f8003h) {
            throw new IllegalStateException("closed");
        }
        u uVar = this.f8001f;
        synchronized (uVar) {
            uVar.f8038j.getFD().sync();
        }
    }

    @Override // ob.i0
    public final m0 timeout() {
        return m0.f8007d;
    }

    @Override // ob.i0
    public final void write(h hVar, long j2) {
        q7.k.e(hVar, "source");
        if (this.f8003h) {
            throw new IllegalStateException("closed");
        }
        u uVar = this.f8001f;
        long j4 = this.f8002g;
        uVar.getClass();
        b.e(hVar.f7993g, 0L, j2);
        long j10 = j4 + j2;
        while (j4 < j10) {
            f0 f0Var = hVar.f7992f;
            q7.k.b(f0Var);
            int iMin = (int) Math.min(j10 - j4, f0Var.f7977c - f0Var.f7976b);
            byte[] bArr = f0Var.f7975a;
            int i2 = f0Var.f7976b;
            synchronized (uVar) {
                q7.k.e(bArr, "array");
                uVar.f8038j.seek(j4);
                uVar.f8038j.write(bArr, i2, iMin);
            }
            int i10 = f0Var.f7976b + iMin;
            f0Var.f7976b = i10;
            long j11 = iMin;
            j4 += j11;
            hVar.f7993g -= j11;
            if (i10 == f0Var.f7977c) {
                hVar.f7992f = f0Var.a();
                g0.a(f0Var);
            }
        }
        this.f8002g += j2;
    }
}

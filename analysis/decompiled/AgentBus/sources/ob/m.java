package ob;

import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public final class m implements k0 {

    /* renamed from: f, reason: collision with root package name */
    public final u f8004f;

    /* renamed from: g, reason: collision with root package name */
    public long f8005g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f8006h;

    public m(u uVar, long j2) {
        this.f8004f = uVar;
        this.f8005g = j2;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        u uVar = this.f8004f;
        if (this.f8006h) {
            return;
        }
        this.f8006h = true;
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

    @Override // ob.k0
    public final long read(h hVar, long j2) {
        long j4;
        long j10;
        int i2;
        q7.k.e(hVar, "sink");
        if (this.f8006h) {
            throw new IllegalStateException("closed");
        }
        u uVar = this.f8004f;
        long j11 = this.f8005g;
        if (j2 < 0) {
            throw new IllegalArgumentException(a1.a.h("byteCount < 0: ", j2).toString());
        }
        long j12 = j2 + j11;
        long j13 = j11;
        while (true) {
            if (j13 >= j12) {
                j4 = -1;
                break;
            }
            f0 f0VarE = hVar.E(1);
            byte[] bArr = f0VarE.f7975a;
            int i10 = f0VarE.f7977c;
            j4 = -1;
            int iMin = (int) Math.min(j12 - j13, 8192 - i10);
            synchronized (uVar) {
                q7.k.e(bArr, "array");
                uVar.f8038j.seek(j13);
                i2 = 0;
                while (true) {
                    if (i2 >= iMin) {
                        break;
                    }
                    int i11 = uVar.f8038j.read(bArr, i10, iMin - i2);
                    if (i11 != -1) {
                        i2 += i11;
                    } else if (i2 == 0) {
                        i2 = -1;
                    }
                }
            }
            if (i2 == -1) {
                if (f0VarE.f7976b == f0VarE.f7977c) {
                    hVar.f7992f = f0VarE.a();
                    g0.a(f0VarE);
                }
                if (j11 == j13) {
                    j10 = -1;
                }
            } else {
                f0VarE.f7977c += i2;
                long j14 = i2;
                j13 += j14;
                hVar.f7993g += j14;
            }
        }
        j10 = j13 - j11;
        if (j10 != j4) {
            this.f8005g += j10;
        }
        return j10;
    }

    @Override // ob.k0
    public final m0 timeout() {
        return m0.f8007d;
    }
}

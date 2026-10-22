package od;

import java.util.concurrent.locks.ReentrantLock;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m implements i0 {

    /* renamed from: c, reason: collision with root package name */
    public u f9467c;

    /* renamed from: f, reason: collision with root package name */
    public long f9468f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f9469g;

    @Override // od.i0
    public final k0 b() {
        return k0.f9455d;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        u uVar = this.f9467c;
        if (this.f9469g) {
            return;
        }
        this.f9469g = true;
        ReentrantLock reentrantLock = uVar.f9492g;
        reentrantLock.lock();
        try {
            int i = uVar.f9491f - 1;
            uVar.f9491f = i;
            if (i == 0) {
                if (uVar.f9490c) {
                    synchronized (uVar) {
                        uVar.f9493h.close();
                    }
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // od.i0
    public final long l(i iVar, long j10) {
        long j11;
        long j12;
        int i;
        iVar.getClass();
        if (this.f9469g) {
            f.e("closed");
            return 0L;
        }
        u uVar = this.f9467c;
        long j13 = this.f9468f;
        if (j10 < 0) {
            f.c(k0.a.m("byteCount < 0: ", j10));
            return 0L;
        }
        long j14 = j10 + j13;
        long j15 = j13;
        while (true) {
            if (j15 >= j14) {
                j11 = -1;
                break;
            }
            d0 d0VarY = iVar.Y(1);
            byte[] bArr = d0VarY.f9437a;
            int i3 = d0VarY.f9439c;
            j11 = -1;
            int iMin = (int) Math.min(j14 - j15, 8192 - i3);
            synchronized (uVar) {
                bArr.getClass();
                uVar.f9493h.seek(j15);
                i = 0;
                while (true) {
                    if (i >= iMin) {
                        break;
                    }
                    int i10 = uVar.f9493h.read(bArr, i3, iMin - i);
                    if (i10 != -1) {
                        i += i10;
                    } else if (i == 0) {
                        i = -1;
                    }
                }
            }
            if (i == -1) {
                if (d0VarY.f9438b == d0VarY.f9439c) {
                    iVar.f9453c = d0VarY.a();
                    e0.a(d0VarY);
                }
                if (j13 == j15) {
                    j12 = -1;
                }
            } else {
                d0VarY.f9439c += i;
                long j16 = i;
                j15 += j16;
                iVar.f9454f += j16;
            }
        }
        j12 = j15 - j13;
        if (j12 != j11) {
            this.f9468f += j12;
        }
        return j12;
    }
}

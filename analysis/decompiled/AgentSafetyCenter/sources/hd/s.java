package hd;

import java.io.InterruptedIOException;
import od.g0;
import od.k0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class s implements g0 {

    /* renamed from: c, reason: collision with root package name */
    public boolean f5556c;

    /* renamed from: f, reason: collision with root package name */
    public od.i f5557f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f5558g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ v f5559h;

    @Override // od.g0
    public final k0 b() {
        return this.f5559h.f5576l;
    }

    @Override // od.g0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        boolean z10;
        v vVar = this.f5559h;
        byte[] bArr = bd.b.f2074a;
        synchronized (vVar) {
            if (this.f5558g) {
                return;
            }
            synchronized (vVar) {
                z10 = vVar.f5577m == 0;
            }
            v vVar2 = this.f5559h;
            if (!vVar2.f5574j.f5556c) {
                if (this.f5557f.f9454f > 0) {
                    while (this.f5557f.f9454f > 0) {
                        d(true);
                    }
                } else if (z10) {
                    vVar2.f5567b.o(vVar2.f5566a, true, null, 0L);
                }
            }
            synchronized (this.f5559h) {
                this.f5558g = true;
            }
            this.f5559h.f5567b.flush();
            this.f5559h.a();
        }
    }

    /* JADX WARN: Finally extract failed */
    public final void d(boolean z10) {
        long jMin;
        boolean z11;
        v vVar = this.f5559h;
        synchronized (vVar) {
            vVar.f5576l.h();
            while (vVar.f5570e >= vVar.f5571f && !this.f5556c && !this.f5558g) {
                try {
                    synchronized (vVar) {
                        int i = vVar.f5577m;
                        if (i != 0) {
                            break;
                        }
                        try {
                            vVar.wait();
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                            throw new InterruptedIOException();
                        }
                    }
                } catch (Throwable th) {
                    vVar.f5576l.k();
                    throw th;
                }
            }
            vVar.f5576l.k();
            vVar.b();
            jMin = Math.min(vVar.f5571f - vVar.f5570e, this.f5557f.f9454f);
            vVar.f5570e += jMin;
            z11 = z10 && jMin == this.f5557f.f9454f;
        }
        this.f5559h.f5576l.h();
        try {
            v vVar2 = this.f5559h;
            vVar2.f5567b.o(vVar2.f5566a, z11, this.f5557f, jMin);
        } finally {
            this.f5559h.f5576l.k();
        }
    }

    @Override // od.g0
    public final void f(od.i iVar, long j10) {
        od.i iVar2 = this.f5557f;
        iVar.getClass();
        byte[] bArr = bd.b.f2074a;
        iVar2.f(iVar, j10);
        while (iVar2.f9454f >= 16384) {
            d(false);
        }
    }

    @Override // od.g0, java.io.Flushable
    public final void flush() {
        v vVar = this.f5559h;
        byte[] bArr = bd.b.f2074a;
        synchronized (vVar) {
            vVar.b();
        }
        while (this.f5557f.f9454f > 0) {
            d(false);
            this.f5559h.f5567b.flush();
        }
    }
}

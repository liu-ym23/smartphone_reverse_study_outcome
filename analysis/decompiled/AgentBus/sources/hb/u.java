package hb;

import java.io.InterruptedIOException;
import ob.i0;
import ob.m0;

/* loaded from: classes.dex */
public final class u implements i0 {

    /* renamed from: f, reason: collision with root package name */
    public final boolean f4353f;

    /* renamed from: g, reason: collision with root package name */
    public final ob.h f4354g = new ob.h();

    /* renamed from: h, reason: collision with root package name */
    public boolean f4355h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ x f4356i;

    public u(x xVar, boolean z4) {
        this.f4356i = xVar;
        this.f4353f = z4;
    }

    /* JADX WARN: Finally extract failed */
    public final void a(boolean z4) {
        long jMin;
        boolean z10;
        x xVar = this.f4356i;
        synchronized (xVar) {
            xVar.f4375l.i();
            while (xVar.f4368e >= xVar.f4369f && !this.f4353f && !this.f4355h) {
                try {
                    synchronized (xVar) {
                        int i2 = xVar.f4376m;
                        if (i2 != 0) {
                            break;
                        }
                        try {
                            xVar.wait();
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                            throw new InterruptedIOException();
                        }
                    }
                } catch (Throwable th) {
                    xVar.f4375l.l();
                    throw th;
                }
            }
            xVar.f4375l.l();
            xVar.b();
            jMin = Math.min(xVar.f4369f - xVar.f4368e, this.f4354g.f7993g);
            xVar.f4368e += jMin;
            z10 = z4 && jMin == this.f4354g.f7993g;
        }
        this.f4356i.f4375l.i();
        try {
            x xVar2 = this.f4356i;
            xVar2.f4365b.i(xVar2.f4364a, z10, this.f4354g, jMin);
        } finally {
            this.f4356i.f4375l.l();
        }
    }

    @Override // ob.i0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        boolean z4;
        x xVar = this.f4356i;
        byte[] bArr = bb.b.f1659a;
        synchronized (xVar) {
            if (this.f4355h) {
                return;
            }
            synchronized (xVar) {
                z4 = xVar.f4376m == 0;
            }
            x xVar2 = this.f4356i;
            if (!xVar2.f4373j.f4353f) {
                if (this.f4354g.f7993g > 0) {
                    while (this.f4354g.f7993g > 0) {
                        a(true);
                    }
                } else if (z4) {
                    xVar2.f4365b.i(xVar2.f4364a, true, null, 0L);
                }
            }
            synchronized (this.f4356i) {
                this.f4355h = true;
            }
            this.f4356i.f4365b.flush();
            this.f4356i.a();
        }
    }

    @Override // ob.i0, java.io.Flushable
    public final void flush() {
        x xVar = this.f4356i;
        byte[] bArr = bb.b.f1659a;
        synchronized (xVar) {
            xVar.b();
        }
        while (this.f4354g.f7993g > 0) {
            a(false);
            this.f4356i.f4365b.flush();
        }
    }

    @Override // ob.i0
    public final m0 timeout() {
        return this.f4356i.f4375l;
    }

    @Override // ob.i0
    public final void write(ob.h hVar, long j2) {
        q7.k.e(hVar, "source");
        byte[] bArr = bb.b.f1659a;
        ob.h hVar2 = this.f4354g;
        hVar2.write(hVar, j2);
        while (hVar2.f7993g >= 16384) {
            a(false);
        }
    }
}

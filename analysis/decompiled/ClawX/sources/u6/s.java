package u6;

import java.io.InterruptedIOException;
import java.util.TimeZone;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class s implements c7.t {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f5751a;

    /* renamed from: b, reason: collision with root package name */
    public final c7.f f5752b = new c7.f();

    /* renamed from: c, reason: collision with root package name */
    public boolean f5753c;
    public final /* synthetic */ v d;

    public s(v vVar, boolean z) {
        this.d = vVar;
        this.f5751a = z;
    }

    /* JADX WARN: Finally extract failed */
    public final void a(boolean z) {
        long jMin;
        boolean z2;
        v vVar = this.d;
        synchronized (vVar) {
            vVar.f5769k.i();
            while (vVar.d >= vVar.f5763e && !this.f5751a && !this.f5753c && vVar.h() == null) {
                try {
                    try {
                        vVar.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                } catch (Throwable th) {
                    vVar.f5769k.m();
                    throw th;
                }
            }
            vVar.f5769k.m();
            vVar.b();
            jMin = Math.min(vVar.f5763e - vVar.d, this.f5752b.f1164b);
            vVar.d += jMin;
            z2 = z && jMin == this.f5752b.f1164b;
        }
        this.d.f5769k.i();
        try {
            v vVar2 = this.d;
            vVar2.f5761b.l(vVar2.f5760a, z2, this.f5752b, jMin);
        } finally {
            this.d.f5769k.m();
        }
    }

    @Override // c7.t, java.lang.AutoCloseable, java.nio.channels.Channel
    public final void close() {
        v vVar = this.d;
        TimeZone timeZone = o6.f.f4330a;
        synchronized (vVar) {
            if (this.f5753c) {
                return;
            }
            boolean z = vVar.h() == null;
            v vVar2 = this.d;
            if (!vVar2.f5767i.f5751a) {
                if (this.f5752b.f1164b > 0) {
                    while (this.f5752b.f1164b > 0) {
                        a(true);
                    }
                } else if (z) {
                    vVar2.f5761b.l(vVar2.f5760a, true, null, 0L);
                }
            }
            v vVar3 = this.d;
            synchronized (vVar3) {
                this.f5753c = true;
                vVar3.notifyAll();
            }
            this.d.f5761b.flush();
            this.d.a();
        }
    }

    @Override // c7.t
    public final c7.x d() {
        return this.d.f5769k;
    }

    @Override // c7.t, java.io.Flushable
    public final void flush() {
        v vVar = this.d;
        TimeZone timeZone = o6.f.f4330a;
        synchronized (vVar) {
            vVar.b();
        }
        while (this.f5752b.f1164b > 0) {
            a(false);
            this.d.f5761b.flush();
        }
    }

    @Override // c7.t
    public final void x(long j4, c7.f fVar) {
        TimeZone timeZone = o6.f.f4330a;
        c7.f fVar2 = this.f5752b;
        fVar2.x(j4, fVar);
        while (fVar2.f1164b >= 16384) {
            a(false);
        }
    }
}

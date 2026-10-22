package gb;

import ob.i;
import ob.i0;
import ob.m0;
import ob.r;
import q7.k;

/* loaded from: classes.dex */
public final class c implements i0 {

    /* renamed from: f, reason: collision with root package name */
    public final r f4037f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f4038g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ h f4039h;

    public c(h hVar) {
        this.f4039h = hVar;
        this.f4037f = new r(((i) hVar.f4056f).timeout());
    }

    @Override // ob.i0, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        if (this.f4038g) {
            return;
        }
        this.f4038g = true;
        ((i) this.f4039h.f4056f).M("0\r\n\r\n");
        r rVar = this.f4037f;
        m0 m0Var = rVar.f8024e;
        rVar.f8024e = m0.f8007d;
        m0Var.a();
        m0Var.b();
        this.f4039h.f4052b = 3;
    }

    @Override // ob.i0, java.io.Flushable
    public final synchronized void flush() {
        if (this.f4038g) {
            return;
        }
        ((i) this.f4039h.f4056f).flush();
    }

    @Override // ob.i0
    public final m0 timeout() {
        return this.f4037f;
    }

    @Override // ob.i0
    public final void write(ob.h hVar, long j2) {
        i iVar = (i) this.f4039h.f4056f;
        k.e(hVar, "source");
        if (this.f4038g) {
            throw new IllegalStateException("closed");
        }
        if (j2 == 0) {
            return;
        }
        iVar.h(j2);
        iVar.M("\r\n");
        iVar.write(hVar, j2);
        iVar.M("\r\n");
    }
}

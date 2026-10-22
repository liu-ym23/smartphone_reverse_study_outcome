package L9;

import V9.h;
import V9.l;
import V9.u;
import V9.y;
import kotlin.jvm.internal.k;

/* loaded from: classes4.dex */
public final class f implements u {

    /* renamed from: a, reason: collision with root package name */
    public final l f947a;
    public boolean b;
    public final /* synthetic */ A8.a c;

    public f(A8.a aVar) {
        this.c = aVar;
        this.f947a = new l(((h) aVar.f).timeout());
    }

    @Override // V9.u, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.b) {
            return;
        }
        this.b = true;
        l lVar = this.f947a;
        y yVar = lVar.e;
        lVar.e = y.d;
        yVar.a();
        yVar.b();
        this.c.b = 3;
    }

    @Override // V9.u, java.io.Flushable
    public final void flush() {
        if (this.b) {
            return;
        }
        ((h) this.c.f).flush();
    }

    @Override // V9.u
    public final y timeout() {
        return this.f947a;
    }

    @Override // V9.u
    public final void write(V9.g source, long j5) {
        k.f(source, "source");
        if (this.b) {
            throw new IllegalStateException("closed");
        }
        long j6 = source.b;
        byte[] bArr = G9.b.f704a;
        if (j5 < 0 || 0 > j6 || j6 < j5) {
            throw new ArrayIndexOutOfBoundsException();
        }
        ((h) this.c.f).write(source, j5);
    }
}

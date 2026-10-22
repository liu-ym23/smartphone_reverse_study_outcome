package L9;

import V9.h;
import V9.l;
import V9.u;
import V9.y;
import kotlin.jvm.internal.k;
import org.json.HTTP;

/* loaded from: classes4.dex */
public final class c implements u {

    /* renamed from: a, reason: collision with root package name */
    public final l f946a;
    public boolean b;
    public final /* synthetic */ A8.a c;

    public c(A8.a aVar) {
        this.c = aVar;
        this.f946a = new l(((h) aVar.f).timeout());
    }

    @Override // V9.u, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        if (this.b) {
            return;
        }
        this.b = true;
        ((h) this.c.f).m("0\r\n\r\n");
        l lVar = this.f946a;
        y yVar = lVar.e;
        lVar.e = y.d;
        yVar.a();
        yVar.b();
        this.c.b = 3;
    }

    @Override // V9.u, java.io.Flushable
    public final synchronized void flush() {
        if (this.b) {
            return;
        }
        ((h) this.c.f).flush();
    }

    @Override // V9.u
    public final y timeout() {
        return this.f946a;
    }

    @Override // V9.u
    public final void write(V9.g source, long j5) {
        h hVar = (h) this.c.f;
        k.f(source, "source");
        if (this.b) {
            throw new IllegalStateException("closed");
        }
        if (j5 == 0) {
            return;
        }
        hVar.y(j5);
        hVar.m(HTTP.CRLF);
        hVar.write(source, j5);
        hVar.m(HTTP.CRLF);
    }
}

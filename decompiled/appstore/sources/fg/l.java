package fg;

import java.io.OutputStream;
import okio.Buffer;
import okio.Sink;
import okio.Timeout;

/* JADX INFO: loaded from: classes4.dex */
public final class l implements Sink {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OutputStream f19699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Timeout f19700b;

    public l(OutputStream r10, Timeout r11) {
        kotlin.jvm.internal.q.h(r10, "out");
        kotlin.jvm.internal.q.h(r11, "timeout");
        this.f19699a = r10;
        this.f19700b = r11;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f19699a.close();
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() {
        this.f19699a.flush();
    }

    @Override // okio.Sink
    public Timeout timeout() {
        return this.f19700b;
    }

    public String toString() {
        return "sink(" + this.f19699a + ')';
    }

    @Override // okio.Sink
    public void write(Buffer r10, long r11) {
        kotlin.jvm.internal.q.h(r10, "source");
        c.b(r10.size(), 0, r11);
    L4:
        if (r11 <= 0) goto L11;
        this.f19700b.throwIfReached();
        p r12 = r10.f23020a;
        if (r12 != null) goto L8;
        kotlin.jvm.internal.q.s();
    L8:
        int r13 = (int) Math.min(r11, r12.f19718c - r12.f19717b);
        this.f19699a.write(r12.f19716a, r12.f19717b, r13);
        r12.f19717b += r13;
        long r14 = r13;
        r11 = r11 - r14;
        r10.m(r10.size() - r14);
        if (r12.f19717b != r12.f19718c) goto L4;
        r10.f23020a = r12.b();
        q.a(r12);
        goto L4
    }
}

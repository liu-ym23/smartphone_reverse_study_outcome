package fg;

import java.io.IOException;
import java.io.InputStream;
import okio.Buffer;
import okio.Source;
import okio.Timeout;

/* JADX INFO: loaded from: classes4.dex */
public final class i implements Source {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f19697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Timeout f19698b;

    public i(InputStream r10, Timeout r11) {
        kotlin.jvm.internal.q.h(r10, "input");
        kotlin.jvm.internal.q.h(r11, "timeout");
        this.f19697a = r10;
        this.f19698b = r11;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f19697a.close();
    }

    @Override // okio.Source
    public long read(Buffer r10, long r11) {
        kotlin.jvm.internal.q.h(r10, "sink");
        if (r11 != 0) goto L5;
        return 0;
    L5:
        if (r11 < 0) goto L19;
        this.f19698b.throwIfReached();     // Catch: AssertionError -> L12
        p r12 = r10.p(1);     // Catch: AssertionError -> L12
        int r13 = this.f19697a.read(r12.f19716a, r12.f19718c, (int) Math.min(r11, 8192 - r12.f19718c));     // Catch: AssertionError -> L12
        if (r13 != (-1)) goto L10;
        return -1;
    L10:
        r12.f19718c += r13;     // Catch: AssertionError -> L12
        long r14 = r13;
        r10.m(r10.size() + r14);     // Catch: AssertionError -> L12
        return r14;
    L12:
        e = move-exception;
        if (j.e(e) == true) goto L16;
        throw e;
    L16:
        throw new IOException(e);
    L19:
        throw new IllegalArgumentException(("byteCount < 0: " + r11).toString());
    }

    @Override // okio.Source
    public Timeout timeout() {
        return this.f19698b;
    }

    public String toString() {
        return "source(" + this.f19697a + ')';
    }
}

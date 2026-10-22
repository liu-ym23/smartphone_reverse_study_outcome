package fg;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import okio.Buffer;
import okio.BufferedSource;
import okio.Source;
import okio.Timeout;

/* JADX INFO: loaded from: classes4.dex */
public final class h implements Source {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f19693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f19694b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BufferedSource f19695c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Inflater f19696d;

    public h(BufferedSource r10, Inflater r11) {
        kotlin.jvm.internal.q.h(r10, "source");
        kotlin.jvm.internal.q.h(r11, "inflater");
        this.f19695c = r10;
        this.f19696d = r11;
    }

    public final boolean a() {
        if (this.f19696d.needsInput() == true) goto L5;
        return false;
    L5:
        b();
        if (this.f19696d.getRemaining() != 0) goto L17;
        if (this.f19695c.exhausted() == false) goto L11;
        return true;
    L11:
        p r10 = this.f19695c.getBuffer().f23020a;
        if (r10 != null) goto L14;
        kotlin.jvm.internal.q.s();
    L14:
        int r11 = r10.f19718c;
        int r12 = r10.f19717b;
        int r13 = r11 - r12;
        this.f19693a = r13;
        this.f19696d.setInput(r10.f19716a, r12, r13);
        return false;
    L17:
        throw new IllegalStateException("?");
    }

    public final void b() {
        int r10 = this.f19693a;
        if (r10 != 0) goto L5;
        return;
    L5:
        int r11 = r10 - this.f19696d.getRemaining();
        this.f19693a -= r11;
        this.f19695c.skip(r11);
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f19694b == false) goto L5;
        return;
    L5:
        this.f19696d.end();
        this.f19694b = true;
        this.f19695c.close();
    }

    @Override // okio.Source
    public long read(Buffer r10, long r11) {
        kotlin.jvm.internal.q.h(r10, "sink");
        if (r11 < 0) goto L34;
        if (this.f19694b == true) goto L32;
        if (r11 != 0) goto L8;
        return 0;
    L8:
        boolean r12 = a();
        p r13 = r10.p(1);     // Catch: DataFormatException -> L13
        int r14 = this.f19696d.inflate(r13.f19716a, r13.f19718c, (int) Math.min(r11, 8192 - r13.f19718c));     // Catch: DataFormatException -> L13
        if (r14 > 0) goto L11;
        if (this.f19696d.finished() == true) goto L24;
        if (this.f19696d.needsDictionary() == true) goto L24;
        if (r12 == false) goto L8;
        throw new EOFException("source exhausted prematurely");     // Catch: DataFormatException -> L13
    L24:
        b();     // Catch: DataFormatException -> L13
        if (r13.f19717b != r13.f19718c) goto L40;
        r10.f23020a = r13.b();     // Catch: DataFormatException -> L13
        q.a(r13);     // Catch: DataFormatException -> L13
        return -1;
    L40:
        return -1;
    L11:
        r13.f19718c += r14;     // Catch: DataFormatException -> L13
        long r15 = r14;
        r10.m(r10.size() + r15);     // Catch: DataFormatException -> L13
        return r15;
    L13:
        e = move-exception;
        throw new IOException(e);
    L32:
        throw new IllegalStateException("closed");
    L34:
        throw new IllegalArgumentException(("byteCount < 0: " + r11).toString());
    }

    @Override // okio.Source
    public Timeout timeout() {
        return this.f19695c.timeout();
    }
}

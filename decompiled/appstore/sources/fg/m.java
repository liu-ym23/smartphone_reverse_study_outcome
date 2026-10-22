package fg;

import okio.Buffer;
import okio.BufferedSource;
import okio.Source;
import okio.Timeout;

/* JADX INFO: loaded from: classes4.dex */
public final class m implements Source {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Buffer f19701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p f19702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f19703c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f19704d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f19705e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final BufferedSource f19706f;

    public m(BufferedSource r10) {
        kotlin.jvm.internal.q.h(r10, "upstream");
        this.f19706f = r10;
        Buffer r11 = r10.getBuffer();
        this.f19701a = r11;
        p r12 = r11.f23020a;
        this.f19702b = r12;
        if (r12 == null) goto L5;
        int r13 = r12.f19717b;
    L6:
        this.f19703c = r13;
        return;
    L5:
        r13 = -1;
        goto L6
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f19704d = true;
    }

    @Override // okio.Source
    public long read(Buffer r10, long r11) {
        kotlin.jvm.internal.q.h(r10, "sink");
        if (this.f19704d == true) goto L31;
        p r12 = this.f19702b;
        if (r12 == null) goto L16;
        p r13 = this.f19701a.f23020a;
        if (r12 != r13) goto L15;
        int r14 = this.f19703c;
        if (r13 != null) goto L12;
        kotlin.jvm.internal.q.s();
    L12:
        if (r14 == r13.f19717b) goto L16;
    L15:
        throw new IllegalStateException("Peek source is invalid because upstream source was used");
    L16:
        this.f19706f.request(this.f19705e + r11);
        if (this.f19702b != null) goto L24;
        p r15 = this.f19701a.f23020a;
        if (r15 == null) goto L24;
        this.f19702b = r15;
        if (r15 != null) goto L23;
        kotlin.jvm.internal.q.s();
    L23:
        this.f19703c = r15.f19717b;
    L24:
        long r16 = Math.min(r11, this.f19701a.size() - this.f19705e);
        if (r16 > 0) goto L28;
        return -1;
    L28:
        this.f19701a.d(r10, this.f19705e, r16);
        this.f19705e += r16;
        return r16;
    L31:
        throw new IllegalStateException("closed");
    }

    @Override // okio.Source
    public Timeout timeout() {
        return this.f19706f.timeout();
    }
}

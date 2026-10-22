package fg;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import okio.Buffer;
import okio.Source;
import okio.Timeout;

/* JADX INFO: loaded from: classes4.dex */
public final class g implements Source {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte f19688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f19689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Inflater f19690c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f19691d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CRC32 f19692e;

    public g(Source r10) {
        kotlin.jvm.internal.q.h(r10, "source");
        o r11 = new o(r10);
        this.f19689b = r11;
        Inflater r12 = new Inflater(true);
        this.f19690c = r12;
        this.f19691d = new h(r11, r12);
        this.f19692e = new CRC32();
    }

    public final void a(String r10, int r11, int r12) {
        if (r12 != r11) goto L4;
        return;
    L4:
        String r13 = String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{r10, Integer.valueOf(r12), Integer.valueOf(r11)}, 3));
        kotlin.jvm.internal.q.c(r13, "java.lang.String.format(this, *args)");
        throw new IOException(r13);
    }

    public final void b() {
        this.f19689b.require(10);
        byte r10 = this.f19689b.f19711a.g(3);
        if (((r10 >> 1) & 1) != 1) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L8;
        d(this.f19689b.f19711a, 0, 10);
    L8:
        a("ID1ID2", 8075, this.f19689b.readShort());
        this.f19689b.skip(8);
        if (((r10 >> 2) & 1) != 1) goto L18;
        this.f19689b.require(2);
        if (r11 == false) goto L13;
        d(this.f19689b.f19711a, 0, 2);
    L13:
        long r12 = this.f19689b.f19711a.readShortLe();
        this.f19689b.require(r12);
        if (r11 == false) goto L16;
        d(this.f19689b.f19711a, 0, r12);
    L16:
        this.f19689b.skip(r12);
    L18:
        if (((r10 >> 3) & 1) != 1) goto L27;
        long r15 = this.f19689b.indexOf((byte) 0);
        if (r15 == (-1)) goto L25;
        if (r11 == false) goto L23;
        d(this.f19689b.f19711a, 0, r15 + 1);
    L23:
        this.f19689b.skip(r15 + 1);
        goto L27
    L25:
        throw new EOFException();
    L27:
        if (((r10 >> 4) & 1) != 1) goto L35;
        long r13 = this.f19689b.indexOf((byte) 0);
        if (r13 == (-1)) goto L34;
        if (r11 == false) goto L32;
        d(this.f19689b.f19711a, 0, r13 + 1);
    L32:
        this.f19689b.skip(r13 + 1);
        goto L35
    L34:
        throw new EOFException();
    L35:
        if (r11 == false) goto L38;
        a("FHCRC", this.f19689b.readShortLe(), (short) this.f19692e.getValue());
        this.f19692e.reset();
        return;
    L38:
        return;
    L5:
        r11 = false;
        goto L6
    }

    public final void c() {
        a("CRC", this.f19689b.readIntLe(), (int) this.f19692e.getValue());
        a("ISIZE", this.f19689b.readIntLe(), (int) this.f19690c.getBytesWritten());
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f19691d.close();
    }

    public final void d(Buffer r10, long r11, long r12) {
        p r13 = r10.f23020a;
        if (r13 != null) goto L5;
        kotlin.jvm.internal.q.s();
    L5:
        int r14 = r13.f19718c;
        int r15 = r13.f19717b;
        if (r11 < (r14 - r15)) goto L11;
        r11 = r11 - ((long) (r14 - r15));
        r13 = r13.f19721f;
        if (r13 != null) goto L5;
        kotlin.jvm.internal.q.s();
    L11:
        if (r12 <= 0) goto L16;
        int r16 = (int) (((long) r13.f19717b) + r11);
        int r17 = (int) Math.min(r13.f19718c - r16, r12);
        this.f19692e.update(r13.f19716a, r16, r17);
        r12 = r12 - ((long) r17);
        r13 = r13.f19721f;
        if (r13 != null) goto L15;
        kotlin.jvm.internal.q.s();
    L15:
        r11 = 0;
        goto L11
    }

    @Override // okio.Source
    public long read(Buffer r12, long r13) {
        kotlin.jvm.internal.q.h(r12, "sink");
        if (r13 < 0) goto L25;
        if (r13 != 0) goto L7;
        return 0;
    L7:
        if (this.f19688a != 0) goto L10;
        b();
        this.f19688a = 1;
    L10:
        if (this.f19688a != 1) goto L17;
        long r10 = r12.size();
        long r14 = this.f19691d.read(r12, r13);
        if (r14 == (-1)) goto L15;
        d(r12, r10, r14);
        return r14;
    L15:
        this.f19688a = 2;
    L17:
        if (this.f19688a != 2) goto L23;
        c();
        this.f19688a = 3;
        if (this.f19689b.exhausted() == true) goto L23;
        throw new IOException("gzip finished without exhausting source");
    L23:
        return -1;
    L25:
        throw new IllegalArgumentException(("byteCount < 0: " + r13).toString());
    }

    @Override // okio.Source
    public Timeout timeout() {
        return this.f19689b.timeout();
    }
}

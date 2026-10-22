package okio;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
final class PeekSource implements Source {
    private final Buffer buffer;
    private boolean closed;
    private int expectedPos;
    private Segment expectedSegment;
    private long pos;
    private final BufferedSource upstream;

    PeekSource(BufferedSource r1) {
        this.upstream = r1;
        Buffer r2 = r1.buffer();
        this.buffer = r2;
        Segment r3 = r2.head;
        this.expectedSegment = r3;
        if (r3 == null) goto L5;
        int r4 = r3.pos;
    L6:
        this.expectedPos = r4;
        return;
    L5:
        r4 = -1;
        goto L6
    }

    @Override // okio.Source
    public long read(Buffer r9, long r10) throws IOException {
        if (r10 < 0) goto L31;
        if (this.closed == true) goto L29;
        Segment r3 = this.expectedSegment;
        if (r3 != null) goto L9;
    L15:
        if (r10 != 0) goto L18;
        return 0;
    L18:
        if (this.upstream.request(this.pos + 1) == true) goto L22;
        return -1;
    L22:
        if (this.expectedSegment == null) goto L24;
    L26:
        long r11 = Math.min(r10, this.buffer.size - this.pos);
        this.buffer.copyTo(r9, this.pos, r11);
        this.pos += r11;
        return r11;
    L24:
        if (this.buffer.head == null) goto L26;
        this.expectedSegment = this.buffer.head;
        this.expectedPos = this.buffer.head.pos;
        goto L26
    L9:
        if (r3 != this.buffer.head) goto L14;
        if (this.expectedPos == this.buffer.head.pos) goto L15;
    L14:
        throw new IllegalStateException("Peek source is invalid because upstream source was used");
    L29:
        throw new IllegalStateException("closed");
    L31:
        throw new IllegalArgumentException("byteCount < 0: " + r10);
    }

    @Override // okio.Source
    public Timeout timeout() {
        return this.upstream.timeout();
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.closed = true;
    }
}

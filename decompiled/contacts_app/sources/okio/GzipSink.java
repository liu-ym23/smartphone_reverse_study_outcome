package okio;

import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;

/* JADX INFO: loaded from: classes5.dex */
public final class GzipSink implements Sink {
    private boolean closed;
    private final CRC32 crc;
    private final Deflater deflater;
    private final DeflaterSink deflaterSink;
    private final BufferedSink sink;

    public GzipSink(Sink r4) {
        this.crc = new CRC32();
        if (r4 == null) goto L7;
        Deflater r0 = new Deflater(-1, true);
        this.deflater = r0;
        BufferedSink r5 = Okio.buffer(r4);
        this.sink = r5;
        this.deflaterSink = new DeflaterSink(r5, r0);
        writeHeader();
        return;
    L7:
        throw new IllegalArgumentException("sink == null");
    }

    @Override // okio.Sink
    public void write(Buffer r3, long r4) throws IOException {
        if (r4 < 0) goto L9;
        if (r4 != 0) goto L6;
        return;
    L6:
        updateCrc(r3, r4);
        this.deflaterSink.write(r3, r4);
        return;
    L9:
        throw new IllegalArgumentException("byteCount < 0: " + r4);
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        this.deflaterSink.flush();
    }

    @Override // okio.Sink
    public Timeout timeout() {
        return this.sink.timeout();
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed == false) goto L26;
        return;
    L26:
        this.deflaterSink.finishDeflate();     // Catch: Throwable -> L7
        writeFooter();     // Catch: Throwable -> L7
        th = null;
    L24:
        this.deflater.end();     // Catch: Throwable -> L10
    L22:
        this.sink.close();     // Catch: Throwable -> L15
    L18:
        this.closed = true;
        if (th == null) goto L28;
        Util.sneakyRethrow(th);
        return;
    L28:
        return;
    L15:
        th = move-exception;
        if (th != null) goto L18;
        th = th;
    L10:
        th = move-exception;
        if (th != null) goto L22;
        th = th;
    L7:
        th = th;
        goto L24
    }

    public final Deflater deflater() {
        return this.deflater;
    }

    private void writeHeader() {
        Buffer r1 = this.sink.buffer();
        r1.writeShort(8075);
        r1.writeByte(8);
        r1.writeByte(0);
        r1.writeInt(0);
        r1.writeByte(0);
        r1.writeByte(0);
    }

    private void writeFooter() throws IOException {
        this.sink.writeIntLe((int) this.crc.getValue());
        this.sink.writeIntLe((int) this.deflater.getBytesRead());
    }

    private void updateCrc(Buffer r5, long r6) {
        Segment r7 = r5.head;
    L4:
        if (r6 <= 0) goto L6;
        int r0 = (int) Math.min(r6, r7.limit - r7.pos);
        this.crc.update(r7.data, r7.pos, r0);
        r6 = r6 - ((long) r0);
        r7 = r7.next;
        goto L4
    }
}

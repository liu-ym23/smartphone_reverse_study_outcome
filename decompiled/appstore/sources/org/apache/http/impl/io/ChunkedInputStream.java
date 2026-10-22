package org.apache.http.impl.io;

import java.io.IOException;
import java.io.InputStream;
import org.apache.http.ConnectionClosedException;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.MalformedChunkCodingException;
import org.apache.http.TruncatedChunkException;
import org.apache.http.config.MessageConstraints;
import org.apache.http.io.BufferInfo;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes4.dex */
public class ChunkedInputStream extends InputStream {
    private static final int BUFFER_SIZE = 2048;
    private static final int CHUNK_CRLF = 3;
    private static final int CHUNK_DATA = 2;
    private static final int CHUNK_INVALID = Integer.MAX_VALUE;
    private static final int CHUNK_LEN = 1;
    private final CharArrayBuffer buffer;
    private long chunkSize;
    private boolean closed;
    private final MessageConstraints constraints;
    private boolean eof;
    private Header[] footers;
    private final SessionInputBuffer in;
    private long pos;
    private int state;

    public ChunkedInputStream(SessionInputBuffer r10, MessageConstraints r11) {
        this.eof = false;
        this.closed = false;
        this.footers = new Header[0];
        this.in = (SessionInputBuffer) Args.notNull(r10, "Session input buffer");
        this.pos = 0;
        this.buffer = new CharArrayBuffer(16);
        if (r11 != null) goto L6;
        r11 = MessageConstraints.DEFAULT;
    L6:
        this.constraints = r11;
        this.state = 1;
    }

    private long getChunkSize() throws IOException {
        int r10 = this.state;
        if (r10 != 1) goto L5;
    L17:
        this.buffer.clear();
        if (this.in.readLine(this.buffer) == (-1)) goto L28;
        int r11 = this.buffer.indexOf(59);
        if (r11 >= 0) goto L22;
        r11 = this.buffer.length();
    L22:
        String r12 = this.buffer.substringTrimmed(0, r11);
        return Long.parseLong(r12, 16);
    L26:
        throw new MalformedChunkCodingException("Bad chunk header: " + r12);
    L28:
        throw new ConnectionClosedException("Premature end of chunk coded message body: closing chunk expected");
    L5:
        if (r10 != 3) goto L16;
        this.buffer.clear();
        if (this.in.readLine(this.buffer) == (-1)) goto L14;
        if (this.buffer.isEmpty() == false) goto L12;
        this.state = 1;
        goto L17
    L12:
        throw new MalformedChunkCodingException("Unexpected content at the end of chunk");
    L14:
        throw new MalformedChunkCodingException("CRLF expected at end of chunk");
    L16:
        throw new IllegalStateException("Inconsistent codec state");
    }

    private void nextChunk() throws IOException {
        if (this.state == Integer.MAX_VALUE) goto L17;
        long r10 = getChunkSize();     // Catch: MalformedChunkCodingException -> L9
        this.chunkSize = r10;     // Catch: MalformedChunkCodingException -> L9
        if (r10 < 0) goto L13;
        this.state = 2;     // Catch: MalformedChunkCodingException -> L9
        this.pos = 0;     // Catch: MalformedChunkCodingException -> L9
        if (r10 != 0) goto L11;
        this.eof = true;     // Catch: MalformedChunkCodingException -> L9
        parseTrailerHeaders();     // Catch: MalformedChunkCodingException -> L9
        return;
    L11:
        return;
    L13:
        throw new MalformedChunkCodingException("Negative chunk size");     // Catch: MalformedChunkCodingException -> L9
    L9:
        e = move-exception;
        this.state = Integer.MAX_VALUE;
        throw e;
    L17:
        throw new MalformedChunkCodingException("Corrupt data stream");
    }

    private void parseTrailerHeaders() throws IOException {
        this.footers = AbstractMessageParser.parseHeaders(this.in, this.constraints.getMaxHeaderCount(), this.constraints.getMaxLineLength(), null);     // Catch: HttpException -> L4
        return;
    L4:
        e = move-exception;
        MalformedChunkCodingException r10 = new MalformedChunkCodingException("Invalid footer: " + e.getMessage());
        r10.initCause(e);
        throw r10;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        SessionInputBuffer r10 = this.in;
        if ((r10 instanceof BufferInfo) == true) goto L5;
        return 0;
    L5:
        return (int) Math.min(((BufferInfo) r10).length(), this.chunkSize - this.pos);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed == false) goto L19;
        return;
    L19:
    L13:
        th = move-exception;
        this.eof = true;
        this.closed = true;
        throw th;
    L6:
        if (this.eof == false) goto L8;
    L15:
        this.eof = true;
        this.closed = true;
        return;
    L8:
        if (this.state == Integer.MAX_VALUE) goto L15;
        byte[] r10 = new byte[2048];     // Catch: Throwable -> L13
    L10:
        if (read(r10) < 0) goto L15;
        goto L15
    }

    public Header[] getFooters() {
        return (Header[]) this.footers.clone();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.closed == true) goto L19;
        if (this.eof == false) goto L8;
        return -1;
    L8:
        if (this.state == 2) goto L12;
        nextChunk();
        if (this.eof == false) goto L12;
        return -1;
    L12:
        int r10 = this.in.read();
        if (r10 == (-1)) goto L17;
        long r11 = this.pos + 1;
        this.pos = r11;
        if (r11 < this.chunkSize) goto L17;
        this.state = 3;
    L17:
        return r10;
    L19:
        throw new IOException("Attempted read from closed stream.");
    }

    public ChunkedInputStream(SessionInputBuffer r10) {
        this(r10, null);
    }

    @Override // java.io.InputStream
    public int read(byte[] r10, int r11, int r12) throws IOException {
        if (this.closed == true) goto L21;
        if (this.eof == false) goto L8;
        return -1;
    L8:
        if (this.state == 2) goto L12;
        nextChunk();
        if (this.eof == false) goto L12;
        return -1;
    L12:
        int r13 = this.in.read(r10, r11, (int) Math.min(r12, this.chunkSize - this.pos));
        if (r13 == (-1)) goto L18;
        long r14 = this.pos + ((long) r13);
        this.pos = r14;
        if (r14 < this.chunkSize) goto L17;
        this.state = 3;
    L17:
        return r13;
    L18:
        this.eof = true;
        throw new TruncatedChunkException("Truncated chunk (expected size: %,d; actual size: %,d)", new Object[]{Long.valueOf(this.chunkSize), Long.valueOf(this.pos)});
    L21:
        throw new IOException("Attempted read from closed stream.");
    }

    @Override // java.io.InputStream
    public int read(byte[] r10) throws IOException {
        return read(r10, 0, r10.length);
    }
}

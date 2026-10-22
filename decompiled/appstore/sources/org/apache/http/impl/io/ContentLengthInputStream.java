package org.apache.http.impl.io;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.ConnectionClosedException;
import org.apache.http.io.BufferInfo;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
public class ContentLengthInputStream extends InputStream {
    private static final int BUFFER_SIZE = 2048;
    private boolean closed;
    private final long contentLength;
    private SessionInputBuffer in;
    private long pos;

    public ContentLengthInputStream(SessionInputBuffer r10, long r11) {
        this.pos = 0;
        this.closed = false;
        this.in = null;
        this.in = (SessionInputBuffer) Args.notNull(r10, "Session input buffer");
        this.contentLength = Args.notNegative(r11, "Content length");
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        SessionInputBuffer r10 = this.in;
        if ((r10 instanceof BufferInfo) == true) goto L5;
        return 0;
    L5:
        return Math.min(((BufferInfo) r10).length(), (int) (this.contentLength - this.pos));
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed == false) goto L17;
        return;
    L17:
    L11:
        th = move-exception;
        this.closed = true;
        throw th;
    L6:
        if (this.pos >= this.contentLength) goto L13;
        byte[] r10 = new byte[2048];     // Catch: Throwable -> L11
    L8:
        if (read(r10) >= 0) goto L8;
    L13:
        this.closed = true;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.closed == true) goto L17;
        if (this.pos < this.contentLength) goto L7;
        return -1;
    L7:
        int r10 = this.in.read();
        if (r10 == (-1)) goto L10;
        this.pos++;
    L15:
        return r10;
    L10:
        if (this.pos >= this.contentLength) goto L15;
        throw new ConnectionClosedException("Premature end of Content-Length delimited message body (expected: %,d; received: %,d)", new Object[]{Long.valueOf(this.contentLength), Long.valueOf(this.pos)});
    L17:
        throw new IOException("Attempted read from closed stream.");
    }

    @Override // java.io.InputStream
    public long skip(long r10) throws IOException {
        if (r10 > 0) goto L5;
        return 0;
    L5:
        byte[] r11 = new byte[2048];
        long r12 = Math.min(r10, this.contentLength - this.pos);
        long r13 = 0;
    L7:
        if (r12 <= 0) goto L12;
        int r14 = read(r11, 0, (int) Math.min(PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH, r12));
        if (r14 == (-1)) goto L12;
        long r15 = r14;
        r13 = r13 + r15;
        r12 = r12 - r15;
    L12:
        return r13;
    }

    @Override // java.io.InputStream
    public int read(byte[] r10, int r11, int r12) throws IOException {
        if (this.closed == true) goto L21;
        long r13 = this.pos;
        long r14 = this.contentLength;
        if (r13 < r14) goto L8;
        return -1;
    L8:
        if ((((long) r12) + r13) <= r14) goto L10;
        r12 = (int) (r14 - r13);
    L10:
        int r15 = this.in.read(r10, r11, r12);
        if (r15 == (-1)) goto L13;
    L17:
        if (r15 <= 0) goto L19;
        this.pos += (long) r15;
    L19:
        return r15;
    L13:
        if (this.pos >= this.contentLength) goto L17;
        throw new ConnectionClosedException("Premature end of Content-Length delimited message body (expected: %,d; received: %,d)", new Object[]{Long.valueOf(this.contentLength), Long.valueOf(this.pos)});
    L21:
        throw new IOException("Attempted read from closed stream.");
    }

    @Override // java.io.InputStream
    public int read(byte[] r10) throws IOException {
        return read(r10, 0, r10.length);
    }
}

package com.bumptech.glide.load.resource.bitmap;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.google.common.primitives.UnsignedBytes;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class RecyclableBufferedInputStream extends FilterInputStream {
    private volatile byte[] buf;
    private final ArrayPool byteArrayPool;
    private int count;
    private int marklimit;
    private int markpos;
    private int pos;

    public static class InvalidMarkException extends IOException {
        private static final long serialVersionUID = -4338378848813561757L;

        public InvalidMarkException(String r10) {
            super(r10);
        }
    }

    public RecyclableBufferedInputStream(@NonNull InputStream r10, @NonNull ArrayPool r11) {
        this(r10, r11, 65536);
    }

    private int fillbuf(InputStream r10, byte[] r11) throws IOException {
        int r12 = this.markpos;
        if (r12 == (-1)) goto L25;
        int r13 = this.pos - r12;
        int r14 = this.marklimit;
        if (r13 >= r14) goto L25;
        if (r12 == 0) goto L9;
    L17:
        if (r12 <= 0) goto L19;
        System.arraycopy(r11, r12, r11, 0, r11.length - r12);
    L19:
        int r15 = this.pos - this.markpos;
        this.pos = r15;
        this.markpos = 0;
        this.count = 0;
        int r16 = r10.read(r11, r15, r11.length - r15);
        int r17 = this.pos;
        if (r16 <= 0) goto L23;
        r17 = r17 + r16;
    L23:
        this.count = r17;
        return r16;
    L9:
        if (r14 <= r11.length) goto L17;
        if (this.count != r11.length) goto L17;
        int r18 = r11.length * 2;
        if (r18 > r14) goto L16;
        r14 = r18;
    L16:
        byte[] r19 = (byte[]) this.byteArrayPool.get(r14, byte[].class);
        System.arraycopy(r11, 0, r19, 0, r11.length);
        this.buf = r19;
        this.byteArrayPool.put(r11);
        r11 = r19;
    L25:
        int r20 = r10.read(r11);
        if (r20 <= 0) goto L28;
        this.markpos = -1;
        this.pos = 0;
        this.count = r20;
    L28:
        return r20;
    }

    private static IOException streamClosed() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        monitor-enter(this);
        InputStream r10 = ((FilterInputStream) this).in;     // Catch: Throwable -> L10
        if (this.buf == null) goto L13;
        if (r10 == null) goto L13;
        int r11 = (this.count - this.pos) + r10.available();
        monitor-exit(this);
        return r11;
    L13:
        throw streamClosed();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.buf == null) goto L5;
        this.byteArrayPool.put(this.buf);
        this.buf = null;
    L5:
        InputStream r10 = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (r10 == null) goto L9;
        r10.close();
        return;
    }

    public synchronized void fixMarkLimit() {
        monitor-enter(this);
        this.marklimit = this.buf.length;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int r10) {
        monitor-enter(this);
        this.marklimit = Math.max(this.marklimit, r10);     // Catch: Throwable -> L6
        this.markpos = this.pos;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        monitor-enter(this);
        byte[] r10 = this.buf;     // Catch: Throwable -> L12
        InputStream r11 = ((FilterInputStream) this).in;     // Catch: Throwable -> L12
        if (r10 == null) goto L30;
        if (r11 == null) goto L30;
        if (this.pos < this.count) goto L15;
        if (fillbuf(r11, r10) != (-1)) goto L15;
        monitor-exit(this);
        return -1;
    L15:
        if (r10 == this.buf) goto L21;
        r10 = this.buf;     // Catch: Throwable -> L12
        if (r10 != null) goto L21;
        throw streamClosed();     // Catch: Throwable -> L12
    L21:
        int r12 = this.count;     // Catch: Throwable -> L12
        int r13 = this.pos;     // Catch: Throwable -> L12
        if ((r12 - r13) <= 0) goto L27;
        this.pos = r13 + 1;     // Catch: Throwable -> L12
        int r14 = r10[r13] & UnsignedBytes.MAX_VALUE;
        monitor-exit(this);
        return r14;
    L27:
        monitor-exit(this);
        return -1;
    L30:
        throw streamClosed();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public synchronized void release() {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.buf == null) goto L9;
        this.byteArrayPool.put(this.buf);     // Catch: Throwable -> L7
        this.buf = null;     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.buf == null) goto L15;
        int r10 = this.markpos;     // Catch: Throwable -> L10
        if ((-1) == r10) goto L13;
        this.pos = r10;     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L13:
        throw new InvalidMarkException("Mark has been invalidated, pos: " + this.pos + " markLimit: " + this.marklimit);     // Catch: Throwable -> L10
    L15:
        throw new IOException("Stream is closed");     // Catch: Throwable -> L10
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long r10) throws IOException {
        monitor-enter(this);
        if (r10 >= 1) goto L48;
        monitor-exit(this);
        return 0;
    L48:
        byte[] r11 = this.buf;     // Catch: Throwable -> L17
        if (r11 == null) goto L45;
        InputStream r12 = ((FilterInputStream) this).in;     // Catch: Throwable -> L17
        if (r12 == null) goto L43;
        int r13 = this.count;     // Catch: Throwable -> L17
        int r14 = this.pos;     // Catch: Throwable -> L17
        if ((r13 - r14) < r10) goto L19;
        this.pos = (int) (((long) r14) + r10);     // Catch: Throwable -> L17
        monitor-exit(this);
        return r10;
    L19:
        long r15 = ((long) r13) - ((long) r14);
        this.pos = r13;     // Catch: Throwable -> L17
        if (this.markpos == (-1)) goto L39;
        if (r10 > this.marklimit) goto L39;
        if (fillbuf(r12, r11) != (-1)) goto L28;
        monitor-exit(this);
        return r15;
    L28:
        int r16 = this.count;     // Catch: Throwable -> L17
        int r17 = this.pos;     // Catch: Throwable -> L17
        if ((r16 - r17) < (r10 - r15)) goto L33;
        this.pos = (int) ((((long) r17) + r10) - r15);     // Catch: Throwable -> L17
        monitor-exit(this);
        return r10;
    L33:
        long r18 = (r15 + ((long) r16)) - ((long) r17);
        this.pos = r16;     // Catch: Throwable -> L17
        monitor-exit(this);
        return r18;
    L39:
        long r19 = r15 + r12.skip(r10 - r15);
        monitor-exit(this);
        return r19;
    L43:
        throw streamClosed();     // Catch: Throwable -> L17
    L45:
        throw streamClosed();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    @VisibleForTesting
    public RecyclableBufferedInputStream(@NonNull InputStream r10, @NonNull ArrayPool r11, int r12) {
        super(r10);
        this.markpos = -1;
        this.byteArrayPool = r11;
        this.buf = (byte[]) r11.get(r12, byte[].class);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(@NonNull byte[] r10, int r11, int r12) throws IOException {
        monitor-enter(this);
        byte[] r13 = this.buf;     // Catch: Throwable -> L23
        if (r13 == null) goto L71;
        if (r12 != 0) goto L9;
        monitor-exit(this);
        return 0;
    L9:
        InputStream r14 = ((FilterInputStream) this).in;     // Catch: Throwable -> L23
        if (r14 == null) goto L69;
        int r15 = this.pos;     // Catch: Throwable -> L23
        int r16 = this.count;     // Catch: Throwable -> L23
        if (r15 < r16) goto L14;
        int r17 = r12;
    L28:
        int r18 = -1;
        if (this.markpos != (-1)) goto L40;
        if (r17 < r13.length) goto L40;
        int r19 = r14.read(r10, r11, r17);     // Catch: Throwable -> L23
        if (r19 == (-1)) goto L34;
    L58:
        r17 = r17 - r19;
        if (r17 == 0) goto L60;
        if (r14.available() == 0) goto L64;
        r11 = r11 + r19;
        goto L28
    L64:
        int r20 = r12 - r17;
        monitor-exit(this);
        return r20;
    L60:
        monitor-exit(this);
        return r12;
    L34:
        if (r17 == r12) goto L37;
        r18 = r12 - r17;
    L37:
        monitor-exit(this);
        return r18;
    L40:
        if (fillbuf(r14, r13) == (-1)) goto L41;
        if (r13 == this.buf) goto L53;
        r13 = this.buf;     // Catch: Throwable -> L23
        if (r13 != null) goto L53;
        throw streamClosed();     // Catch: Throwable -> L23
    L53:
        int r21 = this.count;     // Catch: Throwable -> L23
        int r22 = this.pos;     // Catch: Throwable -> L23
        if ((r21 - r22) < r17) goto L56;
        r19 = r17;
    L57:
        System.arraycopy(r13, r22, r10, r11, r19);     // Catch: Throwable -> L23
        this.pos += r19;     // Catch: Throwable -> L23
        goto L58
    L56:
        r19 = r21 - r22;     // Catch: Throwable -> L23
        goto L57
    L41:
        if (r17 == r12) goto L44;
        r18 = r12 - r17;
    L44:
        monitor-exit(this);
        return r18;
    L14:
        if ((r16 - r15) < r12) goto L16;
        int r23 = r12;
    L17:
        System.arraycopy(r13, r15, r10, r11, r23);     // Catch: Throwable -> L23
        this.pos += r23;     // Catch: Throwable -> L23
        if (r23 != r12) goto L20;
    L25:
        monitor-exit(this);
        return r23;
    L20:
        if (r14.available() == 0) goto L25;
        r11 = r11 + r23;
        r17 = r12 - r23;
        goto L28
    L16:
        r23 = r16 - r15;     // Catch: Throwable -> L23
        goto L17
    L69:
        throw streamClosed();     // Catch: Throwable -> L23
    L71:
        throw streamClosed();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }
}

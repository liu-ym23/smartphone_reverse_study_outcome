package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.UByte;

/* JADX INFO: loaded from: classes39.dex */
public class RecyclableBufferedInputStream extends FilterInputStream {
    private volatile byte[] buf;
    private final ArrayPool byteArrayPool;
    private int count;
    private int marklimit;
    private int markpos;
    private int pos;

    public static class InvalidMarkException extends IOException {
        private static final long serialVersionUID = -4338378848813561757L;

        public InvalidMarkException(String r100) {
            super(r100);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        monitor-enter(this);
        InputStream r100 = ((FilterInputStream) this).in;     // Catch: Throwable -> L12
        if (this.buf == null) goto L11;
        if (r100 == null) goto L11;
        int r101 = (this.count - this.pos) + r100.available();
        monitor-exit(this);
        return r101;
    L11:
        throw streamClosed();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
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
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        monitor-enter(this);
        byte[] r100 = this.buf;     // Catch: Throwable -> L29
        InputStream r101 = ((FilterInputStream) this).in;     // Catch: Throwable -> L29
        if (r100 == null) goto L28;
        if (r101 == null) goto L28;
        if (this.pos < this.count) goto L13;
        if (fillbuf(r101, r100) != (-1)) goto L13;
        monitor-exit(this);
        return -1;
    L13:
        if (r100 == this.buf) goto L19;
        r100 = this.buf;     // Catch: Throwable -> L29
        if (r100 != null) goto L19;
        throw streamClosed();     // Catch: Throwable -> L29
    L19:
        int r102 = this.count;     // Catch: Throwable -> L29
        int r103 = this.pos;     // Catch: Throwable -> L29
        if ((r102 - r103) <= 0) goto L25;
        this.pos = r103 + 1;     // Catch: Throwable -> L29
        int r104 = r100[r103] & UByte.MAX_VALUE;
        monitor-exit(this);
        return r104;
    L25:
        monitor-exit(this);
        return -1;
    L28:
        throw streamClosed();     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        throw th;
    }

    public synchronized void release() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.buf == null) goto L6;
        this.byteArrayPool.put(this.buf);     // Catch: Throwable -> L8
        this.buf = null;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    private static IOException streamClosed() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.buf == null) goto L5;
        this.byteArrayPool.put(this.buf);
        this.buf = null;
    L5:
        InputStream r100 = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (r100 == null) goto L9;
        r100.close();
        return;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.buf == null) goto L14;
        int r100 = this.markpos;     // Catch: Throwable -> L15
        if ((-1) == r100) goto L12;
        this.pos = r100;     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L12:
        throw new InvalidMarkException("Mark has been invalidated, pos: " + this.pos + " markLimit: " + this.marklimit);     // Catch: Throwable -> L15
    L14:
        throw new IOException("Stream is closed");     // Catch: Throwable -> L15
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int r100) {
        monitor-enter(this);
        this.marklimit = Math.max(this.marklimit, r100);     // Catch: Throwable -> L6
        this.markpos = this.pos;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long r110) throws IOException {
        monitor-enter(this);
        if (r110 >= 1) goto L47;
        monitor-exit(this);
        return 0;
    L47:
        byte[] r100 = this.buf;     // Catch: Throwable -> L44
        if (r100 == null) goto L43;
        InputStream r101 = ((FilterInputStream) this).in;     // Catch: Throwable -> L44
        if (r101 == null) goto L41;
        int r102 = this.count;     // Catch: Throwable -> L44
        int r103 = this.pos;     // Catch: Throwable -> L44
        if ((r102 - r103) < r110) goto L17;
        this.pos = (int) (((long) r103) + r110);     // Catch: Throwable -> L44
        monitor-exit(this);
        return r110;
    L17:
        long r104 = ((long) r102) - ((long) r103);
        this.pos = r102;     // Catch: Throwable -> L44
        if (this.markpos == (-1)) goto L37;
        if (r110 > this.marklimit) goto L37;
        if (fillbuf(r101, r100) != (-1)) goto L26;
        monitor-exit(this);
        return r104;
    L26:
        int r105 = this.count;     // Catch: Throwable -> L44
        int r106 = this.pos;     // Catch: Throwable -> L44
        if ((r105 - r106) < (r110 - r104)) goto L31;
        this.pos = (int) ((((long) r106) + r110) - r104);     // Catch: Throwable -> L44
        monitor-exit(this);
        return r110;
    L31:
        long r107 = (r104 + ((long) r105)) - ((long) r106);
        this.pos = r105;     // Catch: Throwable -> L44
        monitor-exit(this);
        return r107;
    L37:
        long r108 = r104 + r101.skip(r110 - r104);
        monitor-exit(this);
        return r108;
    L41:
        throw streamClosed();     // Catch: Throwable -> L44
    L43:
        throw streamClosed();     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        throw th;
    }

    public RecyclableBufferedInputStream(InputStream r100, ArrayPool r101) {
        this(r100, r101, 65536);
    }

    private int fillbuf(InputStream r100, byte[] r101) throws IOException {
        int r102 = this.markpos;
        if (r102 == (-1)) goto L25;
        int r103 = this.pos - r102;
        int r104 = this.marklimit;
        if (r103 >= r104) goto L25;
        if (r102 == 0) goto L9;
    L17:
        if (r102 <= 0) goto L19;
        System.arraycopy(r101, r102, r101, 0, r101.length - r102);
    L19:
        int r105 = this.pos - this.markpos;
        this.pos = r105;
        this.markpos = 0;
        this.count = 0;
        int r106 = r100.read(r101, r105, r101.length - r105);
        int r107 = this.pos;
        if (r106 <= 0) goto L23;
        r107 = r107 + r106;
    L23:
        this.count = r107;
        return r106;
    L9:
        if (r104 <= r101.length) goto L17;
        if (this.count != r101.length) goto L17;
        int r108 = r101.length * 2;
        if (r108 > r104) goto L16;
        r104 = r108;
    L16:
        byte[] r109 = (byte[]) this.byteArrayPool.get(r104, byte[].class);
        System.arraycopy(r101, 0, r109, 0, r101.length);
        this.buf = r109;
        this.byteArrayPool.put(r101);
        r101 = r109;
    L25:
        int r110 = r100.read(r101);
        if (r110 <= 0) goto L28;
        this.markpos = -1;
        this.pos = 0;
        this.count = r110;
    L28:
        return r110;
    }

    public RecyclableBufferedInputStream(InputStream r100, ArrayPool r101, int r102) {
        super(r100);
        this.markpos = -1;
        this.byteArrayPool = r101;
        this.buf = (byte[]) r101.get(r102, byte[].class);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] r100, int r101, int r102) throws IOException {
        monitor-enter(this);
        byte[] r103 = this.buf;     // Catch: Throwable -> L70
        if (r103 == null) goto L69;
        if (r102 != 0) goto L9;
        monitor-exit(this);
        return 0;
    L9:
        InputStream r104 = ((FilterInputStream) this).in;     // Catch: Throwable -> L70
        if (r104 == null) goto L67;
        int r105 = this.pos;     // Catch: Throwable -> L70
        int r106 = this.count;     // Catch: Throwable -> L70
        if (r105 < r106) goto L14;
        int r107 = r102;
    L26:
        int r108 = -1;
        if (this.markpos != (-1)) goto L38;
        if (r107 < r103.length) goto L38;
        int r109 = r104.read(r100, r101, r107);     // Catch: Throwable -> L70
        if (r109 == (-1)) goto L32;
    L56:
        r107 = r107 - r109;
        if (r107 == 0) goto L58;
        if (r104.available() == 0) goto L62;
        r101 = r101 + r109;
        goto L26
    L62:
        int r110 = r102 - r107;
        monitor-exit(this);
        return r110;
    L58:
        monitor-exit(this);
        return r102;
    L32:
        if (r107 == r102) goto L35;
        r108 = r102 - r107;
    L35:
        monitor-exit(this);
        return r108;
    L38:
        if (fillbuf(r104, r103) == (-1)) goto L39;
        if (r103 == this.buf) goto L51;
        r103 = this.buf;     // Catch: Throwable -> L70
        if (r103 != null) goto L51;
        throw streamClosed();     // Catch: Throwable -> L70
    L51:
        int r111 = this.count;     // Catch: Throwable -> L70
        int r112 = this.pos;     // Catch: Throwable -> L70
        if ((r111 - r112) < r107) goto L54;
        r109 = r107;
    L55:
        System.arraycopy(r103, r112, r100, r101, r109);     // Catch: Throwable -> L70
        this.pos += r109;     // Catch: Throwable -> L70
        goto L56
    L54:
        r109 = r111 - r112;     // Catch: Throwable -> L70
        goto L55
    L39:
        if (r107 == r102) goto L42;
        r108 = r102 - r107;
    L42:
        monitor-exit(this);
        return r108;
    L14:
        if ((r106 - r105) < r102) goto L16;
        int r113 = r102;
    L17:
        System.arraycopy(r103, r105, r100, r101, r113);     // Catch: Throwable -> L70
        this.pos += r113;     // Catch: Throwable -> L70
        if (r113 != r102) goto L20;
    L23:
        monitor-exit(this);
        return r113;
    L20:
        if (r104.available() == 0) goto L23;
        r101 = r101 + r113;
        r107 = r102 - r113;
        goto L26
    L16:
        r113 = r106 - r105;     // Catch: Throwable -> L70
        goto L17
    L67:
        throw streamClosed();     // Catch: Throwable -> L70
    L69:
        throw streamClosed();     // Catch: Throwable -> L70
    L70:
        th = move-exception;
        throw th;
    }
}

package com.bumptech.glide.disklrucache;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
class StrictLineReader implements Closeable {
    private static final byte CR = 13;
    private static final byte LF = 10;
    private byte[] buf;
    private final Charset charset;
    private int end;
    private final InputStream in;
    private int pos;

    public StrictLineReader(InputStream r10, Charset r11) {
        this(r10, 8192, r11);
    }

    public static /* synthetic */ Charset access$000(StrictLineReader r10) {
        return r10.charset;
    }

    private void fillBuf() throws IOException {
        InputStream r10 = this.in;
        byte[] r11 = this.buf;
        int r12 = r10.read(r11, 0, r11.length);
        if (r12 == (-1)) goto L7;
        this.pos = 0;
        this.end = r12;
        return;
    L7:
        throw new EOFException();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream r10 = this.in;
        monitor-enter(r10);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.buf == null) goto L9;
        this.buf = null;     // Catch: Throwable -> L7
        this.in.close();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r10);     // Catch: Throwable -> L7
    }

    public boolean hasUnterminatedLine() {
        if (this.end != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public String readLine() throws IOException {
        InputStream r10 = this.in;
        monitor-enter(r10);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.buf == null) goto L40;
        if (this.pos < this.end) goto L11;
        fillBuf();     // Catch: Throwable -> L9
    L11:
        int r11 = this.pos;     // Catch: Throwable -> L9
    L13:
        if (r11 == this.end) goto L26;
        byte[] r12 = this.buf;     // Catch: Throwable -> L9
        if (r12[r11] == 10) goto L17;
        r11 = r11 + 1;     // Catch: Throwable -> L9
        goto L13
    L17:
        if (r11 == this.pos) goto L21;
        int r13 = r11 - 1;     // Catch: Throwable -> L9
        if (r12[r13] != 13) goto L21;
    L22:
        byte[] r14 = this.buf;     // Catch: Throwable -> L9
        int r15 = this.pos;     // Catch: Throwable -> L9
        String r16 = new String(r14, r15, r13 - r15, this.charset.name());     // Catch: Throwable -> L9
        this.pos = r11 + 1;     // Catch: Throwable -> L9
        monitor-exit(r10);     // Catch: Throwable -> L9
        return r16;
    L21:
        r13 = r11;
        goto L22
    L26:
        final int r17 = (this.end - this.pos) + 80;     // Catch: Throwable -> L9
        ByteArrayOutputStream r18 = new AnonymousClass1(this, r17);     // Catch: Throwable -> L9
    L27:
        byte[] r19 = this.buf;     // Catch: Throwable -> L9
        int r20 = this.pos;     // Catch: Throwable -> L9
        r18.write(r19, r20, this.end - r20);     // Catch: Throwable -> L9
        this.end = -1;     // Catch: Throwable -> L9
        fillBuf();     // Catch: Throwable -> L9
        int r21 = this.pos;     // Catch: Throwable -> L9
    L29:
        if (r21 == this.end) goto L27;
        byte[] r22 = this.buf;     // Catch: Throwable -> L9
        if (r22[r21] == 10) goto L32;
        r21 = r21 + 1;     // Catch: Throwable -> L9
        goto L29
    L32:
        int r23 = this.pos;     // Catch: Throwable -> L9
        if (r21 == r23) goto L35;
        r18.write(r22, r23, r21 - r23);     // Catch: Throwable -> L9
    L35:
        this.pos = r21 + 1;     // Catch: Throwable -> L9
        String r24 = r18.toString();     // Catch: Throwable -> L9
        monitor-exit(r10);     // Catch: Throwable -> L9
        return r24;
    L40:
        throw new IOException("LineReader is closed");     // Catch: Throwable -> L9
    }

    public StrictLineReader(InputStream r10, int r11, Charset r12) {
        if (r10 == null) goto L15;
        if (r12 == null) goto L15;
        if (r11 < 0) goto L13;
        if (r12.equals(Util.US_ASCII) == false) goto L11;
        this.in = r10;
        this.charset = r12;
        this.buf = new byte[r11];
        return;
    L11:
        throw new IllegalArgumentException("Unsupported encoding");
    L13:
        throw new IllegalArgumentException("capacity <= 0");
    L15:
        throw null;
    }
}

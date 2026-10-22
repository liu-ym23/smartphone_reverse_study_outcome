package com.bytedance.apm.agent.instrumentation.io;

import com.bytedance.apm.agent.logging.AgentLog;
import com.bytedance.apm.agent.logging.AgentLogManager;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes14.dex */
public abstract class CInputStreamPParent extends InputStream implements StreamCompleteListenerSource {
    protected static final int DEFAULT_LIMIT_OF_RESPONSE_BODY_BYTES = 2048;
    protected static final AgentLog sLog = null;
    protected final ByteBuffer buf;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected long f190312c;

    /* JADX INFO: renamed from: cac, reason: collision with root package name */
    protected boolean f190313cac;
    protected final StreamCompleteListenerManager callback;
    protected final InputStream impl;

    private boolean isBufferEmpty() {
        return !this.buf.hasRemaining();
    }

    private void notifyComplete() {
        if (this.callback.isComplete() == true) goto L6;
        StreamCompleteEvent r100 = new StreamCompleteEvent(this, this.f190312c);
        this.callback.notifyStreamComplete(r100);
        return;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
    L9:
        e = move-exception;
        notifyError(e);
        throw e;
    L3:
        if (this.f190313cac == false) goto L5;
        int r100 = this.buf.remaining();     // Catch: IOException -> L9
    L6:
        return r100 + this.impl.available();
    L5:
        r100 = 0;
        goto L6
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream r100 = this.impl;     // Catch: IOException -> L7
        if (r100 == null) goto L5;
        r100.close();     // Catch: IOException -> L7
    L5:
        notifyComplete();     // Catch: IOException -> L7
        return;
    L7:
        e = move-exception;
        notifyError(e);
        throw e;
    }

    public void fillBuffer() {
        ByteBuffer r100 = this.buf;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.hasArray() == false) goto L28;
        ByteBuffer r101 = this.buf;
        monitor-enter(r101);
        int r102 = this.impl.read(this.buf.array(), 0, this.buf.capacity());     // Catch: Throwable -> L11 IOException -> L13
    L15:
        if (r102 > 0) goto L18;
        this.buf.limit(0);     // Catch: Throwable -> L11
    L20:
        monitor-exit(r101);     // Catch: Throwable -> L11
        return;
    L18:
        if (r102 >= this.buf.capacity()) goto L20;
        this.buf.limit(r102);     // Catch: Throwable -> L11
        goto L20
    L11:
        th = move-exception;
        throw th;
    L13:
        e = move-exception;
        sLog.error(e.toString());     // Catch: Throwable -> L11
        r102 = 0;
        goto L15
    }

    public String getBufferAsString() {
        ByteBuffer r100 = this.buf;
        if (r100 == null) goto L15;
        monitor-enter(r100);
        byte[] r101 = new byte[this.buf.limit()];     // Catch: Throwable -> L12
        int r102 = 0;
    L7:
        if (r102 >= this.buf.limit()) goto L9;
        r101[r102] = this.buf.get(r102);     // Catch: Throwable -> L12
        r102 = r102 + 1;     // Catch: Throwable -> L12
        goto L7
    L9:
        String r103 = new String(r101);     // Catch: Throwable -> L12
        monitor-exit(r100);     // Catch: Throwable -> L12
        return r103;
    L12:
        th = move-exception;
        throw th;
    L15:
        return "";
    }

    static {
        sLog = AgentLogManager.getAgentLog();
    }

    private int readBuffer() {
        if (isBufferEmpty() == false) goto L6;
        return -1;
    L6:
        return this.buf.get();
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        if (markSupported() == true) goto L10;
        return;
    L10:
        this.impl.reset();     // Catch: IOException -> L7
        return;
    L7:
        e = move-exception;
        notifyError(e);
        throw e;
    }

    public CInputStreamPParent(InputStream r100) {
        this(r100, false);
    }

    private boolean isBufferLargerThan(long r100) {
        if (this.buf.remaining() < r100) goto L5;
        return true;
    L5:
        return false;
    }

    private void notifyError(Exception r100) {
        if (this.callback.isComplete() == true) goto L6;
        StreamCompleteEvent r101 = new StreamCompleteEvent(this, this.f190312c, r100);
        this.callback.notifyStreamError(r101);
        return;
    }

    private int readBuffer(byte[] r100) {
        return readBuffer(r100, 0, r100.length);
    }

    @Override // java.io.InputStream
    public void mark(int r100) {
        if (markSupported() == true) goto L5;
        return;
    L5:
        this.impl.mark(r100);
    }

    @Override // com.bytedance.apm.agent.instrumentation.io.StreamCompleteListenerSource
    public void removeStreamCompleteListener(StreamCompleteListener r100) {
        this.callback.removeStreamCompleteListener(r100);
    }

    @Override // java.io.InputStream
    public long skip(long r100) throws IOException {
        if (this.f190313cac == false) goto L26;
        ByteBuffer r101 = this.buf;
        monitor-enter(r101);
    L18:
        th = move-exception;
        throw th;
    L7:
        if (isBufferLargerThan(r100) == false) goto L11;
        this.buf.position((int) r100);     // Catch: Throwable -> L18
        this.f190312c += r100;     // Catch: Throwable -> L18
        monitor-exit(r101);     // Catch: Throwable -> L18
        return r100;
    L11:
        r100 = r100 - ((long) this.buf.remaining());     // Catch: Throwable -> L18
        if (r100 <= 0) goto L17;
        ByteBuffer r102 = this.buf;     // Catch: Throwable -> L18
        r102.position(r102.remaining());     // Catch: Throwable -> L18
        monitor-exit(r101);     // Catch: Throwable -> L18
        goto L26
    L17:
        throw new IOException("Failed to partial read from buffer (skip)");     // Catch: Throwable -> L18
    L26:
        long r103 = this.impl.skip(r100);     // Catch: IOException -> L23
        this.f190312c += r103;     // Catch: IOException -> L23
        return r103;
    L23:
        e = move-exception;
        notifyError(e);
        throw e;
    }

    public CInputStreamPParent(InputStream r100, boolean r101) {
        this.f190312c = 0;
        this.callback = new StreamCompleteListenerManager();
        this.impl = r100;
        this.f190313cac = r101;
        if (r101 == true) goto L5;
        ByteBuffer r102 = null;
    L6:
        this.buf = r102;
        fillBuffer();
        return;
    L5:
        r102 = ByteBuffer.allocate(2048);
        goto L6
    }

    private int readBuffer(byte[] r100, int r101, int r102) {
        if (isBufferEmpty() == false) goto L6;
        return -1;
    L6:
        int r103 = this.buf.remaining();
        this.buf.get(r100, r101, r102);
        return r103 - this.buf.remaining();
    }

    @Override // java.io.InputStream
    public int read(byte[] r100, int r101, int r110) throws IOException {
        int r102 = 0;
        if (this.f190313cac == false) goto L29;
        ByteBuffer r103 = this.buf;
        monitor-enter(r103);
    L26:
        th = move-exception;
        throw th;
    L8:
        if (isBufferLargerThan(r110) == false) goto L16;
        int r104 = readBuffer(r100, r101, r110);     // Catch: Throwable -> L26
        if (r104 < 0) goto L15;
        this.f190312c += (long) r104;     // Catch: Throwable -> L26
        monitor-exit(r103);     // Catch: Throwable -> L26
        return r104;
    L15:
        throw new IOException("Failed to readBuffer()");     // Catch: Throwable -> L26
    L16:
        int r105 = this.buf.remaining();     // Catch: Throwable -> L26
        if (r105 <= 0) goto L23;
        int r106 = readBuffer(r100, r101, r105);     // Catch: Throwable -> L26
        if (r106 < 0) goto L22;
        r110 = r110 - r106;     // Catch: Throwable -> L26
        this.f190312c += (long) r106;     // Catch: Throwable -> L26
    L24:
        monitor-exit(r103);     // Catch: Throwable -> L26
    L44:
        InputStream r107 = this.impl;     // Catch: IOException -> L41
        if (r107 == null) goto L34;
        r102 = r107.read(r100, r101 + r106, r110);     // Catch: IOException -> L41
    L34:
        if (r102 < 0) goto L37;
        this.f190312c += (long) r102;     // Catch: IOException -> L41
        return r102 + r106;
    L37:
        if (r106 > 0) goto L40;
        notifyComplete();     // Catch: IOException -> L41
        return r102;
    L40:
        return r106;
    L41:
        e = move-exception;
        notifyError(e);
        throw e;
    L22:
        throw new IOException("Failed to partial read from buffer");     // Catch: Throwable -> L26
    L23:
        r106 = 0;
        goto L24
    L29:
        r106 = 0;
        goto L44
    }
}

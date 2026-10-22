package com.bytedance.apm.agent.instrumentation.io;

import com.bytedance.apm.agent.logging.AgentLog;
import com.bytedance.apm.agent.logging.AgentLogManager;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public abstract class CInputStreamPParent extends InputStream implements StreamCompleteListenerSource {
    protected static final int DEFAULT_LIMIT_OF_RESPONSE_BODY_BYTES = 2048;
    protected static final AgentLog sLog = null;
    protected final ByteBuffer buf;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected long f6351c;
    protected boolean cac;
    protected final StreamCompleteListenerManager callback;
    protected final InputStream impl;

    static {
        sLog = AgentLogManager.getAgentLog();
    }

    public CInputStreamPParent(InputStream r10) {
        this(r10, false);
    }

    private boolean isBufferEmpty() {
        return !this.buf.hasRemaining();
    }

    private boolean isBufferLargerThan(long r10) {
        if (this.buf.remaining() < r10) goto L5;
        return true;
    L5:
        return false;
    }

    private void notifyComplete() {
        if (this.callback.isComplete() == true) goto L6;
        StreamCompleteEvent r10 = new StreamCompleteEvent(this, this.f6351c);
        this.callback.notifyStreamComplete(r10);
        return;
    }

    private void notifyError(Exception r10) {
        if (this.callback.isComplete() == true) goto L6;
        StreamCompleteEvent r11 = new StreamCompleteEvent(this, this.f6351c, r10);
        this.callback.notifyStreamError(r11);
        return;
    }

    private int readBuffer() {
        if (isBufferEmpty() == false) goto L6;
        return -1;
    L6:
        return this.buf.get();
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
    L5:
        e = move-exception;
        notifyError(e);
        throw e;
    L3:
        if (this.cac == false) goto L7;
        int r10 = this.buf.remaining();     // Catch: IOException -> L5
    L8:
        return r10 + this.impl.available();
    L7:
        r10 = 0;
        goto L8
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream r10 = this.impl;     // Catch: IOException -> L5
        if (r10 == null) goto L7;
        r10.close();     // Catch: IOException -> L5
    L7:
        notifyComplete();     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        notifyError(e);
        throw e;
    }

    public void fillBuffer() {
        ByteBuffer r10 = this.buf;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.hasArray() == false) goto L28;
        ByteBuffer r11 = this.buf;
        monitor-enter(r11);
        int r12 = this.impl.read(this.buf.array(), 0, this.buf.capacity());     // Catch: Throwable -> L11 IOException -> L13
    L15:
        if (r12 > 0) goto L18;
        this.buf.limit(0);     // Catch: Throwable -> L11
    L20:
        monitor-exit(r11);     // Catch: Throwable -> L11
        return;
    L18:
        if (r12 >= this.buf.capacity()) goto L20;
        this.buf.limit(r12);     // Catch: Throwable -> L11
        goto L20
    L11:
        th = move-exception;
        throw th;
    L13:
        e = move-exception;
        sLog.error(e.toString());     // Catch: Throwable -> L11
        r12 = 0;
        goto L15
    }

    public String getBufferAsString() {
        ByteBuffer r10 = this.buf;
        if (r10 == null) goto L16;
        monitor-enter(r10);
        byte[] r11 = new byte[this.buf.limit()];     // Catch: Throwable -> L9
        int r12 = 0;
    L7:
        if (r12 >= this.buf.limit()) goto L11;
        r11[r12] = this.buf.get(r12);     // Catch: Throwable -> L9
        r12 = r12 + 1;     // Catch: Throwable -> L9
        goto L7
    L11:
        String r13 = new String(r11);     // Catch: Throwable -> L9
        monitor-exit(r10);     // Catch: Throwable -> L9
        return r13;
    L9:
        th = move-exception;
        throw th;
    L16:
        return "";
    }

    @Override // java.io.InputStream
    public void mark(int r10) {
        if (markSupported() == true) goto L5;
        return;
    L5:
        this.impl.mark(r10);
    }

    @Override // java.io.InputStream
    public int read(byte[] r10, int r11, int r12) throws IOException {
        int r13 = 0;
        if (this.cac == false) goto L30;
        ByteBuffer r14 = this.buf;
        monitor-enter(r14);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (isBufferLargerThan(r12) == false) goto L18;
        int r15 = readBuffer(r10, r11, r12);     // Catch: Throwable -> L14
        if (r15 < 0) goto L17;
        this.f6351c += (long) r15;     // Catch: Throwable -> L14
        monitor-exit(r14);     // Catch: Throwable -> L14
        return r15;
    L17:
        throw new IOException("Failed to readBuffer()");     // Catch: Throwable -> L14
    L18:
        int r16 = this.buf.remaining();     // Catch: Throwable -> L14
        if (r16 <= 0) goto L25;
        int r17 = readBuffer(r10, r11, r16);     // Catch: Throwable -> L14
        if (r17 < 0) goto L24;
        r12 = r12 - r17;     // Catch: Throwable -> L14
        this.f6351c += (long) r17;     // Catch: Throwable -> L14
    L26:
        monitor-exit(r14);     // Catch: Throwable -> L14
    L46:
        InputStream r18 = this.impl;     // Catch: IOException -> L38
        if (r18 == null) goto L35;
        r13 = r18.read(r10, r11 + r17, r12);     // Catch: IOException -> L38
    L35:
        if (r13 < 0) goto L40;
        this.f6351c += (long) r13;     // Catch: IOException -> L38
        return r13 + r17;
    L40:
        if (r17 > 0) goto L43;
        notifyComplete();     // Catch: IOException -> L38
        return r13;
    L43:
        return r17;
    L38:
        e = move-exception;
        notifyError(e);
        throw e;
    L24:
        throw new IOException("Failed to partial read from buffer");     // Catch: Throwable -> L14
    L25:
        r17 = 0;
        goto L26
    L30:
        r17 = 0;
        goto L46
    }

    @Override // com.bytedance.apm.agent.instrumentation.io.StreamCompleteListenerSource
    public void removeStreamCompleteListener(StreamCompleteListener r10) {
        this.callback.removeStreamCompleteListener(r10);
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

    @Override // java.io.InputStream
    public long skip(long r10) throws IOException {
        if (this.cac == false) goto L28;
        ByteBuffer r11 = this.buf;
        monitor-enter(r11);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (isBufferLargerThan(r10) == false) goto L13;
        this.buf.position((int) r10);     // Catch: Throwable -> L11
        this.f6351c += r10;     // Catch: Throwable -> L11
        monitor-exit(r11);     // Catch: Throwable -> L11
        return r10;
    L13:
        r10 = r10 - ((long) this.buf.remaining());     // Catch: Throwable -> L11
        if (r10 <= 0) goto L19;
        ByteBuffer r12 = this.buf;     // Catch: Throwable -> L11
        r12.position(r12.remaining());     // Catch: Throwable -> L11
        monitor-exit(r11);     // Catch: Throwable -> L11
        goto L28
    L19:
        throw new IOException("Failed to partial read from buffer (skip)");     // Catch: Throwable -> L11
    L28:
        long r13 = this.impl.skip(r10);     // Catch: IOException -> L24
        this.f6351c += r13;     // Catch: IOException -> L24
        return r13;
    L24:
        e = move-exception;
        notifyError(e);
        throw e;
    }

    public CInputStreamPParent(InputStream r10, boolean r11) {
        this.f6351c = 0;
        this.callback = new StreamCompleteListenerManager();
        this.impl = r10;
        this.cac = r11;
        if (r11 == true) goto L5;
        ByteBuffer r12 = null;
    L6:
        this.buf = r12;
        fillBuffer();
        return;
    L5:
        r12 = ByteBuffer.allocate(2048);
        goto L6
    }

    private int readBuffer(byte[] r10) {
        return readBuffer(r10, 0, r10.length);
    }

    private int readBuffer(byte[] r10, int r11, int r12) {
        if (isBufferEmpty() == false) goto L6;
        return -1;
    L6:
        int r13 = this.buf.remaining();
        this.buf.get(r10, r11, r12);
        return r13 - this.buf.remaining();
    }
}

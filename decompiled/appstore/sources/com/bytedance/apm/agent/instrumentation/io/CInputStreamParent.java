package com.bytedance.apm.agent.instrumentation.io;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import s3.a;
import w0.c;

/* JADX INFO: loaded from: classes.dex */
public abstract class CInputStreamParent extends CInputStreamPParent {
    public CInputStreamParent(InputStream r10) {
        this(r10, false);
    }

    private boolean isEmpty() {
        return !this.buf.hasRemaining();
    }

    @Override // com.bytedance.apm.agent.instrumentation.io.StreamCompleteListenerSource
    public void addStreamCompleteListener(StreamCompleteListener r10) {
        this.callback.addStreamCompleteListener(r10);
    }

    public boolean bufLT(long r10) {
        if (this.buf.remaining() < r10) goto L5;
        return true;
    L5:
        return false;
    }

    public void callComplete() {
        if (this.callback.isComplete() == true) goto L6;
        StreamCompleteEvent r10 = new StreamCompleteEvent(this, this.f6351c);
        this.callback.notifyStreamComplete(r10);
        return;
    }

    public void callError(Exception r10) {
        if (this.callback.isComplete() == true) goto L6;
        StreamCompleteEvent r11 = new StreamCompleteEvent(this, this.f6351c, r10);
        this.callback.notifyStreamError(r11);
        return;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.impl.markSupported();
    }

    public int rb() {
        if (isEmpty() == false) goto L6;
        return -1;
    L6:
        return this.buf.get();
    }

    @Override // java.io.InputStream
    public int read(byte[] r10) throws IOException {
        int r11 = r10.length;
        int r12 = 0;
        if (this.cac == false) goto L44;
        ByteBuffer r13 = this.buf;
        monitor-enter(r13);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (bufLT(r11) == false) goto L18;
        int r14 = rb(r10);     // Catch: Throwable -> L14
        if (r14 < 0) goto L17;
        this.f6351c += (long) r14;     // Catch: Throwable -> L14
        monitor-exit(r13);     // Catch: Throwable -> L14
        return r14;
    L17:
        throw new IOException("CountingInputStream wrong");     // Catch: Throwable -> L14
    L18:
        int r15 = this.buf.remaining();     // Catch: Throwable -> L14
        if (r15 <= 0) goto L25;
        r12 = rb(r10, 0, r15);     // Catch: Throwable -> L14
        if (r12 < 0) goto L24;
        r11 = r11 - r12;     // Catch: Throwable -> L14
        this.f6351c += (long) r12;     // Catch: Throwable -> L14
        goto L25
    L24:
        throw new IOException("CountingInputStream wrong2");     // Catch: Throwable -> L14
    L25:
        monitor-exit(r13);     // Catch: Throwable -> L14
    L44:
        int r16 = this.impl.read(r10, r12, r11);     // Catch: IOException -> L33
        if (r16 < 0) goto L35;
        this.f6351c += (long) r16;     // Catch: IOException -> L33
        return r16 + r12;
    L35:
        if (r12 > 0) goto L38;
        callComplete();     // Catch: IOException -> L33
        return r16;
    L38:
        return r12;
    L33:
        e = move-exception;
        CInputStreamPParent.sLog.error(e.toString());
        if (c.B() == false) goto L42;
        a.d("APM-Counting", "notify system err: " + e);
        e.printStackTrace();
    L42:
        callError(e);
        throw e;
    }

    public void setBufferingEnabled(boolean r10) {
        this.cac = r10;
    }

    public CInputStreamParent(InputStream r10, boolean r11) {
        super(r10, r11);
    }

    private int rb(byte[] r10) {
        return rb(r10, 0, r10.length);
    }

    private int rb(byte[] r10, int r11, int r12) {
        if (isEmpty() == false) goto L6;
        return -1;
    L6:
        int r13 = this.buf.remaining();
        this.buf.get(r10, r11, r12);
        return r13 - this.buf.remaining();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.cac == false) goto L28;
        ByteBuffer r10 = this.buf;
        monitor-enter(r10);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (bufLT(1) == false) goto L15;
        int r11 = rb();     // Catch: Throwable -> L11
        if (r11 < 0) goto L13;
        this.f6351c++;     // Catch: Throwable -> L11
    L13:
        monitor-exit(r10);     // Catch: Throwable -> L11
        return r11;
    L15:
        monitor-exit(r10);     // Catch: Throwable -> L11
    L28:
        int r12 = this.impl.read();     // Catch: IOException -> L22
        if (r12 < 0) goto L24;
        this.f6351c++;     // Catch: IOException -> L22
    L25:
        return r12;
    L24:
        callComplete();     // Catch: IOException -> L22
    L22:
        e = move-exception;
        callError(e);
        throw e;
    }
}

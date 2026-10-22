package com.bytedance.apm.agent.instrumentation.io;

import av3.b;
import com.bytedance.apm.d;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes14.dex */
public abstract class CInputStreamParent extends CInputStreamPParent {
    private boolean isEmpty() {
        return !this.buf.hasRemaining();
    }

    public void callComplete() {
        if (this.callback.isComplete() == true) goto L6;
        StreamCompleteEvent r100 = new StreamCompleteEvent(this, this.f190312c);
        this.callback.notifyStreamComplete(r100);
        return;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.impl.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.f190313cac == false) goto L26;
        ByteBuffer r100 = this.buf;
        monitor-enter(r100);
    L15:
        th = move-exception;
        throw th;
    L7:
        if (bufLT(1) == false) goto L13;
        int r101 = rb();     // Catch: Throwable -> L15
        if (r101 < 0) goto L11;
        this.f190312c++;     // Catch: Throwable -> L15
    L11:
        monitor-exit(r100);     // Catch: Throwable -> L15
        return r101;
    L13:
        monitor-exit(r100);     // Catch: Throwable -> L15
    L26:
        int r102 = this.impl.read();     // Catch: IOException -> L23
        if (r102 < 0) goto L21;
        this.f190312c++;     // Catch: IOException -> L23
    L22:
        return r102;
    L21:
        callComplete();     // Catch: IOException -> L23
    L23:
        e = move-exception;
        callError(e);
        throw e;
    }

    public int rb() {
        if (isEmpty() == false) goto L6;
        return -1;
    L6:
        return this.buf.get();
    }

    public CInputStreamParent(InputStream r100) {
        this(r100, false);
    }

    private int rb(byte[] r100) {
        return rb(r100, 0, r100.length);
    }

    @Override // com.bytedance.apm.agent.instrumentation.io.StreamCompleteListenerSource
    public void addStreamCompleteListener(StreamCompleteListener r100) {
        this.callback.addStreamCompleteListener(r100);
    }

    public boolean bufLT(long r100) {
        if (this.buf.remaining() < r100) goto L5;
        return true;
    L5:
        return false;
    }

    public void callError(Exception r100) {
        if (this.callback.isComplete() == true) goto L6;
        StreamCompleteEvent r101 = new StreamCompleteEvent(this, this.f190312c, r100);
        this.callback.notifyStreamError(r101);
        return;
    }

    @Override // java.io.InputStream
    public int read(byte[] r100) throws IOException {
        int r101 = r100.length;
        int r102 = 0;
        if (this.f190313cac == false) goto L43;
        ByteBuffer r103 = this.buf;
        monitor-enter(r103);
    L25:
        th = move-exception;
        throw th;
    L8:
        if (bufLT(r101) == false) goto L16;
        int r104 = rb(r100);     // Catch: Throwable -> L25
        if (r104 < 0) goto L15;
        this.f190312c += (long) r104;     // Catch: Throwable -> L25
        monitor-exit(r103);     // Catch: Throwable -> L25
        return r104;
    L15:
        throw new IOException("CountingInputStream wrong");     // Catch: Throwable -> L25
    L16:
        int r105 = this.buf.remaining();     // Catch: Throwable -> L25
        if (r105 <= 0) goto L23;
        r102 = rb(r100, 0, r105);     // Catch: Throwable -> L25
        if (r102 < 0) goto L22;
        r101 = r101 - r102;     // Catch: Throwable -> L25
        this.f190312c += (long) r102;     // Catch: Throwable -> L25
        goto L23
    L22:
        throw new IOException("CountingInputStream wrong2");     // Catch: Throwable -> L25
    L23:
        monitor-exit(r103);     // Catch: Throwable -> L25
    L43:
        int r106 = this.impl.read(r100, r102, r101);     // Catch: IOException -> L36
        if (r106 < 0) goto L32;
        this.f190312c += (long) r106;     // Catch: IOException -> L36
        return r106 + r102;
    L32:
        if (r102 > 0) goto L35;
        callComplete();     // Catch: IOException -> L36
        return r106;
    L35:
        return r102;
    L36:
        e = move-exception;
        CInputStreamPParent.sLog.error(e.toString());
        if (d.j() == false) goto L40;
        b.d("APM-Counting", "notify system err: " + e);
        e.printStackTrace();
    L40:
        callError(e);
        throw e;
    }

    public void setBufferingEnabled(boolean r100) {
        this.f190313cac = r100;
    }

    public CInputStreamParent(InputStream r100, boolean r101) {
        super(r100, r101);
    }

    private int rb(byte[] r100, int r101, int r102) {
        if (isEmpty() == false) goto L6;
        return -1;
    L6:
        int r103 = this.buf.remaining();
        this.buf.get(r100, r101, r102);
        return r103 - this.buf.remaining();
    }
}

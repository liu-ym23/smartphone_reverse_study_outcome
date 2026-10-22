package com.slardaros.client.monitor.io;

import com.obric.olog.OLog;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes4.dex */
public abstract class CInputStreamParent extends CInputStreamPParent {
    public static final String TAG = "CInputStreamParent";

    private boolean isEmpty() {
        return !this.buf.hasRemaining();
    }

    protected void callError(Exception r4) {
        if (this.callback.isComplete() == true) goto L6;
        StreamCompleteEvent r0 = new StreamCompleteEvent(this, this.c, r4);
        this.callback.notifyStreamError(r0);
        return;
    }

    @Override // java.io.InputStream
    public int read(byte[] r8) throws IOException {
        int r0 = r8.length;
        int r2 = 0;
        if (this.cac == false) goto L40;
        ByteBuffer r1 = this.buf;
        monitor-enter(r1);
    L25:
        th = move-exception;
        throw th;
    L8:
        if (bufLT(r0) == false) goto L16;
        int r9 = rb(r8);     // Catch: Throwable -> L25
        if (r9 < 0) goto L15;
        this.c += (long) r9;     // Catch: Throwable -> L25
        monitor-exit(r1);     // Catch: Throwable -> L25
        return r9;
    L15:
        throw new IOException("CountingInputStream wrong");     // Catch: Throwable -> L25
    L16:
        int r3 = this.buf.remaining();     // Catch: Throwable -> L25
        if (r3 <= 0) goto L23;
        r2 = rb(r8, 0, r3);     // Catch: Throwable -> L25
        if (r2 < 0) goto L22;
        r0 = r0 - r2;     // Catch: Throwable -> L25
        this.c += (long) r2;     // Catch: Throwable -> L25
        goto L23
    L22:
        throw new IOException("CountingInputStream wrong2");     // Catch: Throwable -> L25
    L23:
        monitor-exit(r1);     // Catch: Throwable -> L25
    L40:
        int r10 = this.impl.read(r8, r2, r0);     // Catch: IOException -> L36
        if (r10 < 0) goto L32;
        this.c += (long) r10;     // Catch: IOException -> L36
        return r10 + r2;
    L32:
        if (r2 > 0) goto L35;
        callComplete();     // Catch: IOException -> L36
        return r10;
    L35:
        return r2;
    L36:
        e = move-exception;
        OLog.e(TAG, e.toString());
        callError(e);
        throw e;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.impl.markSupported();
    }

    public CInputStreamParent(InputStream r2) {
        this(r2, false);
    }

    protected void callComplete() {
        if (this.callback.isComplete() == true) goto L6;
        StreamCompleteEvent r0 = new StreamCompleteEvent(this, this.c);
        this.callback.notifyStreamComplete(r0);
        return;
    }

    protected int rb() {
        if (isEmpty() == false) goto L6;
        return -1;
    L6:
        return this.buf.get();
    }

    private int rb(byte[] r3) {
        return rb(r3, 0, r3.length);
    }

    private int rb(byte[] r3, int r4, int r5) {
        if (isEmpty() == false) goto L6;
        return -1;
    L6:
        int r0 = this.buf.remaining();
        this.buf.get(r3, r4, r5);
        return r0 - this.buf.remaining();
    }

    protected boolean bufLT(long r3) {
        if (this.buf.remaining() < r3) goto L5;
        return true;
    L5:
        return false;
    }

    public CInputStreamParent(InputStream r1, boolean r2) {
        super(r1, r2);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.cac == false) goto L26;
        ByteBuffer r0 = this.buf;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L7:
        if (bufLT(1) == false) goto L13;
        int r3 = rb();     // Catch: Throwable -> L15
        if (r3 < 0) goto L11;
        this.c++;     // Catch: Throwable -> L15
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return r3;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L15
    L26:
        int r1 = this.impl.read();     // Catch: IOException -> L23
        if (r1 < 0) goto L21;
        this.c++;     // Catch: IOException -> L23
    L22:
        return r1;
    L21:
        callComplete();     // Catch: IOException -> L23
    L23:
        e = move-exception;
        callError(e);
        throw e;
    }

    public void setBufferingEnabled(boolean r1) {
        this.cac = r1;
    }

    @Override // com.slardaros.client.monitor.io.StreamCompleteListenerSource
    public void addStreamCompleteListener(StreamCompleteListener r1) {
        this.callback.addStreamCompleteListener(r1);
    }
}

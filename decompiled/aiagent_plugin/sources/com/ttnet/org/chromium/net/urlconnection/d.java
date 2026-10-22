package com.ttnet.org.chromium.net.urlconnection;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: CronetInputStream.java */
/* JADX INFO: loaded from: classes4.dex */
class d extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final CronetHttpURLConnection f38283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected IOException f38284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f38285c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ByteBuffer f38286d;

    public d(CronetHttpURLConnection r1) {
        this.f38283a = r1;
    }

    @Override // java.io.InputStream
    public int read() {
        a();
        if (b() == true) goto L5;
        return -1;
    L5:
        return this.f38286d.get() & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] r3, int r4, int r5) {
        if (r4 < 0) goto L16;
        if (r5 < 0) goto L16;
        if ((r4 + r5) > r3.length) goto L16;
        if (r5 != 0) goto L9;
        return 0;
    L9:
        a();
        if (b() == false) goto L13;
        int r6 = Math.min(this.f38286d.limit() - this.f38286d.position(), r5);
        this.f38286d.get(r3, r4, r6);
        return r6;
    L13:
        return -1;
    L16:
        throw new IndexOutOfBoundsException();
    }

    @Override // java.io.InputStream
    public int available() {
        if (this.f38285c == false) goto L9;
        IOException r2 = this.f38284b;
        if (r2 != null) goto L7;
        return 0;
    L7:
        throw r2;
    L9:
        if (b() == true) goto L11;
        return 0;
    L11:
        return this.f38286d.remaining();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        CronetHttpURLConnection r0 = this.f38283a;
        if (r0 == null) goto L5;
        r0.disconnect();
    L5:
        super.close();
    }

    void a(IOException r1) {
        this.f38284b = r1;
        this.f38285c = true;
        this.f38286d = null;
    }

    private void a() {
        if (this.f38285c == false) goto L9;
        IOException r3 = this.f38284b;
        if (r3 != null) goto L7;
        return;
    L7:
        throw r3;
    L9:
        if (b() == false) goto L11;
        return;
    L11:
        if (this.f38286d != null) goto L16;
        int r0 = 32768;
        if (this.f38283a.a() < 8192) goto L15;
        r0 = this.f38283a.a();
    L15:
        this.f38286d = ByteBuffer.allocateDirect(r0);
    L16:
        this.f38286d.clear();
        this.f38283a.a(this.f38286d);
        IOException r1 = this.f38284b;
        if (r1 != null) goto L21;
        ByteBuffer r4 = this.f38286d;
        if (r4 == null) goto L23;
        r4.flip();
        return;
    L23:
        return;
    L21:
        throw r1;
    }

    private boolean b() {
        ByteBuffer r0 = this.f38286d;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.hasRemaining() == false) goto L7;
        return true;
    }
}

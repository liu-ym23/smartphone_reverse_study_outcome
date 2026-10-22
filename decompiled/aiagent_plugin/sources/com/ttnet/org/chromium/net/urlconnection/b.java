package com.ttnet.org.chromium.net.urlconnection;

import com.ttnet.org.chromium.net.ag;
import com.ttnet.org.chromium.net.ah;
import java.net.HttpRetryException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: compiled from: CronetChunkedOutputStream.java */
/* JADX INFO: loaded from: classes4.dex */
final class b extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CronetHttpURLConnection f38271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f38272b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ByteBuffer f38273c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ag f38274d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f38275e;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.net.urlconnection.b$1, reason: invalid class name */
    /* JADX INFO: compiled from: CronetChunkedOutputStream.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: compiled from: CronetChunkedOutputStream.java */
    private class a extends ag {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f38276a;

        @Override // com.ttnet.org.chromium.net.ag
        public long a() {
            return -1;
        }

        private a(b r1) {
            this.f38276a = r1;
        }

        /* synthetic */ a(b r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.ttnet.org.chromium.net.ag
        public void a(ah r5, ByteBuffer r6) {
            if (r6.remaining() < b.a(this.f38276a).remaining()) goto L7;
            r6.put(b.a(this.f38276a));
            b.a(this.f38276a).clear();
            r5.a(b.b(this.f38276a));
            if (b.b(this.f38276a) == true) goto L9;
            b.c(this.f38276a).c();
            return;
        L9:
            return;
        L7:
            int r0 = b.a(this.f38276a).limit();
            b.a(this.f38276a).limit(b.a(this.f38276a).position() + r6.remaining());
            r6.put(b.a(this.f38276a));
            b.a(this.f38276a).limit(r0);
            r5.a(false);
        }

        @Override // com.ttnet.org.chromium.net.ag
        public void a(ah r3) {
            r3.a(new HttpRetryException("Cannot retry streamed Http body", -1));
        }
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.f
    void a() {
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.f
    void b() {
    }

    static /* synthetic */ ByteBuffer a(b r0) {
        return r0.f38273c;
    }

    static /* synthetic */ boolean b(b r0) {
        return r0.f38275e;
    }

    static /* synthetic */ g c(b r0) {
        return r0.f38272b;
    }

    b(CronetHttpURLConnection r3, int r4, g r5) {
        this.f38274d = new a(this, null);
        Objects.requireNonNull(r3);
        if (r4 <= 0) goto L7;
        this.f38273c = ByteBuffer.allocate(r4);
        this.f38271a = r3;
        this.f38272b = r5;
        return;
    L7:
        throw new IllegalArgumentException("chunkLength should be greater than 0");
    }

    @Override // java.io.OutputStream
    public void write(int r1) {
        f();
        this.f38273c.put((byte) r1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] r5, int r6, int r7) {
        d();
        if ((r5.length - r6) < r7) goto L11;
        if (r6 < 0) goto L11;
        if (r7 < 0) goto L11;
        int r0 = r7;
    L7:
        if (r0 <= 0) goto L9;
        int r1 = Math.min(r0, this.f38273c.remaining());
        this.f38273c.put(r5, (r6 + r7) - r0, r1);
        r0 = r0 - r1;
        f();
        goto L7
    L9:
        return;
    L11:
        throw new IndexOutOfBoundsException();
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.f, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        if (this.f38275e == true) goto L6;
        this.f38275e = true;
        this.f38273c.flip();
        return;
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.f
    ag c() {
        return this.f38274d;
    }

    private void f() {
        if (this.f38273c.hasRemaining() == true) goto L6;
        g();
        return;
    }

    private void a(int r4) {
        this.f38272b.a(r4);     // Catch: Exception -> L4 SocketTimeoutException -> L8
    L17:
        return;
    L8:
        CronetHttpURLConnection r0 = this.f38271a;
        if (r0 == null) goto L16;
        r0.b();
        this.f38272b.b();
        this.f38272b.a(r4 / 2);
        return;
    L16:
        return;
    L4:
        e = move-exception;
        CronetHttpURLConnection r1 = this.f38271a;
        if (r1 == null) goto L14;
        r1.a("Unexpected request usage, caught in CronetChunkedOutputStream", e);
        this.f38272b.b();
        this.f38272b.a(r4 / 2);
        return;
    }

    private void g() {
        d();
        this.f38273c.flip();
        a(this.f38271a.getReadTimeout());
        e();
    }
}

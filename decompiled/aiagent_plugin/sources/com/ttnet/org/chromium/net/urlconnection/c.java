package com.ttnet.org.chromium.net.urlconnection;

import com.ttnet.org.chromium.net.ag;
import com.ttnet.org.chromium.net.ah;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: compiled from: CronetFixedModeOutputStream.java */
/* JADX INFO: loaded from: classes4.dex */
final class c extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f38277a = 16384;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CronetHttpURLConnection f38278b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final g f38279c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f38280d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ByteBuffer f38281e;
    private final ag f;
    private long g;
    private boolean h;
    private boolean i;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.net.urlconnection.c$1, reason: invalid class name */
    /* JADX INFO: compiled from: CronetFixedModeOutputStream.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: compiled from: CronetFixedModeOutputStream.java */
    private class a extends ag {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f38282a;

        private a(c r1) {
            this.f38282a = r1;
        }

        /* synthetic */ a(c r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.ttnet.org.chromium.net.ag
        public long a() {
            return c.a(this.f38282a);
        }

        @Override // com.ttnet.org.chromium.net.ag
        public void a(ah r6, ByteBuffer r7) {
            if (r7.remaining() < c.b(this.f38282a).remaining()) goto L7;
            r7.put(c.b(this.f38282a));
            c.b(this.f38282a).clear();
            r6.a(false);
            if (c.c(this.f38282a) == true) goto L9;
            c.d(this.f38282a).c();
            return;
        L9:
            return;
        L7:
            int r0 = c.b(this.f38282a).limit();
            c.b(this.f38282a).limit(c.b(this.f38282a).position() + r7.remaining());
            r7.put(c.b(this.f38282a));
            c.b(this.f38282a).limit(r0);
            r6.a(false);
        }

        @Override // com.ttnet.org.chromium.net.ag
        public void a(ah r3) {
            if (c.e(this.f38282a) == false) goto L5;
            c.a(this.f38282a, true);
            c.b(this.f38282a).rewind();
            r3.a();
            return;
        L5:
            r3.a(new HttpRetryException("Cannot retry streamed Http body", -1));
        }
    }

    static {
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.f
    void a() {
    }

    static /* synthetic */ long a(c r2) {
        return r2.f38280d;
    }

    static /* synthetic */ boolean a(c r0, boolean r1) {
        r0.i = r1;
        return r1;
    }

    static /* synthetic */ ByteBuffer b(c r0) {
        return r0.f38281e;
    }

    static /* synthetic */ boolean c(c r0) {
        return r0.i;
    }

    static /* synthetic */ g d(c r0) {
        return r0.f38279c;
    }

    static /* synthetic */ boolean e(c r0) {
        return r0.h;
    }

    c(CronetHttpURLConnection r5, long r6, int r8, g r9) {
        this.f = new a(this, null);
        Objects.requireNonNull(r5);
        if (r6 < 0) goto L7;
        this.f38280d = r6;
        this.f38281e = ByteBuffer.allocate((int) Math.min(r6, Math.max(f38277a, r8)));
        this.f38278b = r5;
        this.f38279c = r9;
        this.g = 0;
        this.h = true;
        this.i = false;
        return;
    L7:
        throw new IllegalArgumentException("Content length must be larger than 0 for non-chunked upload.");
    }

    @Override // java.io.OutputStream
    public void write(int r5) {
        d();
        b(1);
        f();
        this.f38281e.put((byte) r5);
        this.g++;
        g();
    }

    @Override // java.io.OutputStream
    public void write(byte[] r5, int r6, int r7) {
        d();
        if ((r5.length - r6) < r7) goto L12;
        if (r6 < 0) goto L12;
        if (r7 < 0) goto L12;
        b(r7);
        int r0 = r7;
    L7:
        if (r0 <= 0) goto L9;
        f();
        int r1 = Math.min(r0, this.f38281e.remaining());
        this.f38281e.put(r5, (r6 + r7) - r0, r1);
        r0 = r0 - r1;
        goto L7
    L9:
        this.g += (long) r7;
        g();
        return;
    L12:
        throw new IndexOutOfBoundsException();
    }

    private void f() {
        if (this.f38281e.hasRemaining() == true) goto L6;
        this.h = false;
        h();
        return;
    }

    private void g() {
        if (this.g != this.f38280d) goto L6;
        h();
        return;
    }

    private void h() {
        d();
        this.f38281e.flip();
        a(this.f38278b.getReadTimeout());
        e();
    }

    private void a(int r4) {
        this.f38279c.a(r4);     // Catch: Exception -> L4 SocketTimeoutException -> L8
    L17:
        return;
    L8:
        CronetHttpURLConnection r0 = this.f38278b;
        if (r0 == null) goto L16;
        r0.b();
        this.f38279c.b();
        this.f38279c.a(r4 / 2);
        return;
    L16:
        return;
    L4:
        e = move-exception;
        CronetHttpURLConnection r1 = this.f38278b;
        if (r1 == null) goto L14;
        r1.a("Unexpected request usage, caught in CronetFixedModeOutputStream", e);
        this.f38279c.b();
        this.f38279c.a(r4 / 2);
        return;
    }

    private void b(int r7) {
        if ((this.g + ((long) r7)) > this.f38280d) goto L6;
        return;
    L6:
        throw new ProtocolException("expected " + (this.f38280d - this.g) + " bytes but received " + r7);
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.f
    void b() {
        if (this.g < this.f38280d) goto L6;
        return;
    L6:
        throw new ProtocolException("Content received is less than Content-Length.");
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.f
    ag c() {
        return this.f;
    }
}

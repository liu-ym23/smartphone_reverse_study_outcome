package com.ttnet.org.chromium.net.urlconnection;

import com.ttnet.org.chromium.net.ag;
import com.ttnet.org.chromium.net.ah;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: compiled from: CronetBufferedOutputStream.java */
/* JADX INFO: loaded from: classes4.dex */
final class a extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f38265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CronetHttpURLConnection f38266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ag f38267c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ByteBuffer f38268d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f38269e;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.net.urlconnection.a$1, reason: invalid class name */
    /* JADX INFO: compiled from: CronetBufferedOutputStream.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: renamed from: com.ttnet.org.chromium.net.urlconnection.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CronetBufferedOutputStream.java */
    private class C1029a extends ag {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f38270a;

        private C1029a(a r1) {
            this.f38270a = r1;
        }

        /* synthetic */ C1029a(a r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.ttnet.org.chromium.net.ag
        public long a() {
            if (a.a(this.f38270a) != (-1)) goto L11;
            boolean r0 = a.b(this.f38270a);
            ByteBuffer r2 = a.c(this.f38270a);
            if (r0 == false) goto L7;
            int r3 = r2.limit();
        L9:
            return r3;
        L7:
            r3 = r2.position();
            goto L9
        L11:
            return a.a(this.f38270a);
        }

        @Override // com.ttnet.org.chromium.net.ag
        public void a(ah r4, ByteBuffer r5) {
            int r0 = r5.remaining();
            if (r0 >= a.c(this.f38270a).remaining()) goto L5;
            r5.put(a.c(this.f38270a).array(), a.c(this.f38270a).position(), r0);
            a.c(this.f38270a).position(a.c(this.f38270a).position() + r0);
        L6:
            r4.a(false);
            return;
        L5:
            r5.put(a.c(this.f38270a));
            goto L6
        }

        @Override // com.ttnet.org.chromium.net.ag
        public void a(ah r2) {
            a.c(this.f38270a).position(0);
            r2.a();
        }
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.f
    void b() {
    }

    static /* synthetic */ int a(a r0) {
        return r0.f38265a;
    }

    static /* synthetic */ boolean b(a r0) {
        return r0.f38269e;
    }

    static /* synthetic */ ByteBuffer c(a r0) {
        return r0.f38268d;
    }

    a(CronetHttpURLConnection r3, long r4) {
        this.f38267c = new C1029a(this, null);
        Objects.requireNonNull(r3, "Argument connection cannot be null.");
        if (r4 > 2147483647L) goto L11;
        if (r4 < 0) goto L9;
        this.f38266b = r3;
        int r5 = (int) r4;
        this.f38265a = r5;
        this.f38268d = ByteBuffer.allocate(r5);
        return;
    L9:
        throw new IllegalArgumentException("Content length < 0.");
    L11:
        throw new IllegalArgumentException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2GB.");
    }

    a(CronetHttpURLConnection r3) {
        this.f38267c = new C1029a(this, null);
        Objects.requireNonNull(r3);
        this.f38266b = r3;
        this.f38265a = -1;
        this.f38268d = ByteBuffer.allocate(16384);
    }

    @Override // java.io.OutputStream
    public void write(int r2) {
        d();
        a(1);
        this.f38268d.put((byte) r2);
    }

    @Override // java.io.OutputStream
    public void write(byte[] r1, int r2, int r3) {
        d();
        a(r3);
        this.f38268d.put(r1, r2, r3);
    }

    private void a(int r4) {
        if (this.f38265a == (-1)) goto L10;
        if ((this.f38268d.position() + r4) <= this.f38265a) goto L10;
        throw new ProtocolException("exceeded content-length limit of " + this.f38265a + " bytes");
    L10:
        if (this.f38269e == true) goto L20;
        if (this.f38265a == (-1)) goto L15;
        return;
    L15:
        if ((this.f38268d.limit() - this.f38268d.position()) <= r4) goto L17;
        return;
    L17:
        ByteBuffer r5 = ByteBuffer.allocate(Math.max(this.f38268d.capacity() * 2, this.f38268d.capacity() + r4));
        this.f38268d.flip();
        r5.put(this.f38268d);
        this.f38268d = r5;
        return;
    L20:
        throw new IllegalStateException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for writing after connect");
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.f
    void a() {
        this.f38269e = true;
        if (this.f38268d.position() < this.f38265a) goto L7;
        this.f38268d.flip();
        return;
    L7:
        throw new ProtocolException("Content received is less than Content-Length");
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.f
    ag c() {
        return this.f38267c;
    }
}

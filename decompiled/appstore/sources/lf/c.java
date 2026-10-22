package lf;

import com.ttnet.org.chromium.net.urlconnection.CronetHttpURLConnection;
import com.ttnet.org.chromium.net.y;
import com.ttnet.org.chromium.net.z;
import java.io.IOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes4.dex */
public final class c extends e {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static int f21970l = 16384;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CronetHttpURLConnection f21971d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f f21972e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f21973f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ByteBuffer f21974g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final y f21975h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f21976i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f21977j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f21978k;

    public static /* synthetic */ class a {
    }

    public class b extends y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f21979a;

        public b(c r10) {
            this.f21979a = r10;
        }

        @Override // com.ttnet.org.chromium.net.y
        public long a() {
            return c.g(this.f21979a);
        }

        @Override // com.ttnet.org.chromium.net.y
        public void b(z r10, ByteBuffer r11) {
            if (r11.remaining() < c.h(this.f21979a).remaining()) goto L7;
            r11.put(c.h(this.f21979a));
            c.h(this.f21979a).clear();
            r10.a(false);
            if (c.i(this.f21979a) == true) goto L9;
            c.k(this.f21979a).c();
            return;
        L9:
            return;
        L7:
            int r12 = c.h(this.f21979a).limit();
            c.h(this.f21979a).limit(c.h(this.f21979a).position() + r11.remaining());
            r11.put(c.h(this.f21979a));
            c.h(this.f21979a).limit(r12);
            r10.a(false);
        }

        @Override // com.ttnet.org.chromium.net.y
        public void c(z r10) {
            if (c.l(this.f21979a) == false) goto L5;
            c.j(this.f21979a, true);
            c.h(this.f21979a).rewind();
            r10.c();
            return;
        L5:
            r10.b(new HttpRetryException("Cannot retry streamed Http body", -1));
        }

        public /* synthetic */ b(c r10, a r11) {
            this(r10);
        }
    }

    static {
    }

    public c(CronetHttpURLConnection r10, long r11, f r12) {
        this.f21975h = new b(this, null);
        if (r10 != null) goto L5;
        throw null;
    L5:
        if (r11 < 0) goto L9;
        this.f21973f = r11;
        this.f21974g = ByteBuffer.allocate((int) Math.min(r11, f21970l));
        this.f21971d = r10;
        this.f21972e = r12;
        this.f21976i = 0;
        this.f21977j = true;
        this.f21978k = false;
        return;
    L9:
        throw new IllegalArgumentException("Content length must be larger than 0 for non-chunked upload.");
    }

    public static /* synthetic */ long g(c r10) {
        return r10.f21973f;
    }

    public static /* synthetic */ ByteBuffer h(c r10) {
        return r10.f21974g;
    }

    public static /* synthetic */ boolean i(c r10) {
        return r10.f21978k;
    }

    public static /* synthetic */ boolean j(c r10, boolean r11) {
        r10.f21978k = r11;
        return r11;
    }

    public static /* synthetic */ f k(c r10) {
        return r10.f21972e;
    }

    public static /* synthetic */ boolean l(c r10) {
        return r10.f21977j;
    }

    private void n(int r10) {
        this.f21972e.b(r10);     // Catch: Exception -> L4 SocketTimeoutException -> L8
    L17:
        return;
    L8:
        CronetHttpURLConnection r11 = this.f21971d;
        if (r11 == null) goto L16;
        r11.N();
        this.f21972e.d();
        this.f21972e.b(r10 / 2);
        return;
    L16:
        return;
    L4:
        e = move-exception;
        CronetHttpURLConnection r12 = this.f21971d;
        if (r12 == null) goto L14;
        r12.setException(new IOException("Unexpected request usage, caught in CronetFixedModeOutputStream, caused by " + e));
        this.f21972e.d();
        this.f21972e.b(r10 / 2);
        return;
    }

    private void o() {
        if (this.f21974g.hasRemaining() == true) goto L6;
        this.f21977j = false;
        p();
        return;
    }

    private void p() {
        b();
        this.f21974g.flip();
        n(this.f21971d.getReadTimeout());
        a();
    }

    @Override // lf.e
    public void c() {
        if (this.f21976i < this.f21973f) goto L6;
        return;
    L6:
        throw new ProtocolException("Content received is less than Content-Length.");
    }

    @Override // lf.e
    public y d() {
        return this.f21975h;
    }

    @Override // lf.e
    public void e() {
    }

    public final void m(int r10) {
        if ((this.f21976i + ((long) r10)) > this.f21973f) goto L6;
        return;
    L6:
        throw new ProtocolException("expected " + (this.f21973f - this.f21976i) + " bytes but received " + r10);
    }

    public final void q() {
        if (this.f21976i != this.f21973f) goto L6;
        p();
        return;
    }

    @Override // java.io.OutputStream
    public void write(int r10) {
        b();
        m(1);
        o();
        this.f21974g.put((byte) r10);
        this.f21976i++;
        q();
    }

    @Override // java.io.OutputStream
    public void write(byte[] r10, int r11, int r12) {
        b();
        if ((r10.length - r11) < r12) goto L12;
        if (r11 < 0) goto L12;
        if (r12 < 0) goto L12;
        m(r12);
        int r13 = r12;
    L7:
        if (r13 <= 0) goto L9;
        o();
        int r14 = Math.min(r13, this.f21974g.remaining());
        this.f21974g.put(r10, (r11 + r12) - r13, r14);
        r13 = r13 - r14;
        goto L7
    L9:
        this.f21976i += (long) r12;
        q();
        return;
    L12:
        throw new IndexOutOfBoundsException();
    }
}

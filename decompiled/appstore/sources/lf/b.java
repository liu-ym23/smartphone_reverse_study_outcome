package lf;

import com.ttnet.org.chromium.net.urlconnection.CronetHttpURLConnection;
import com.ttnet.org.chromium.net.y;
import com.ttnet.org.chromium.net.z;
import java.io.IOException;
import java.net.HttpRetryException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes4.dex */
public final class b extends e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CronetHttpURLConnection f21964d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f f21965e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ByteBuffer f21966f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final y f21967g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f21968h;

    public static /* synthetic */ class a {
    }

    /* JADX INFO: renamed from: lf.b$b, reason: collision with other inner class name */
    public class C0307b extends y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f21969a;

        public C0307b(b r10) {
            this.f21969a = r10;
        }

        @Override // com.ttnet.org.chromium.net.y
        public long a() {
            return -1;
        }

        @Override // com.ttnet.org.chromium.net.y
        public void b(z r10, ByteBuffer r11) {
            if (r11.remaining() < b.g(this.f21969a).remaining()) goto L7;
            r11.put(b.g(this.f21969a));
            b.g(this.f21969a).clear();
            r10.a(b.h(this.f21969a));
            if (b.h(this.f21969a) == true) goto L9;
            b.i(this.f21969a).c();
            return;
        L9:
            return;
        L7:
            int r12 = b.g(this.f21969a).limit();
            b.g(this.f21969a).limit(b.g(this.f21969a).position() + r11.remaining());
            r11.put(b.g(this.f21969a));
            b.g(this.f21969a).limit(r12);
            r10.a(false);
        }

        @Override // com.ttnet.org.chromium.net.y
        public void c(z r10) {
            r10.b(new HttpRetryException("Cannot retry streamed Http body", -1));
        }

        public /* synthetic */ C0307b(b r10, a r11) {
            this(r10);
        }
    }

    public b(CronetHttpURLConnection r10, int r11, f r12) {
        this.f21967g = new C0307b(this, null);
        if (r10 == null) goto L9;
        if (r11 <= 0) goto L8;
        this.f21966f = ByteBuffer.allocate(r11);
        this.f21964d = r10;
        this.f21965e = r12;
        return;
    L8:
        throw new IllegalArgumentException("chunkLength should be greater than 0");
    L9:
        throw null;
    }

    public static /* synthetic */ ByteBuffer g(b r10) {
        return r10.f21966f;
    }

    public static /* synthetic */ boolean h(b r10) {
        return r10.f21968h;
    }

    public static /* synthetic */ f i(b r10) {
        return r10.f21965e;
    }

    @Override // lf.e
    public void c() {
    }

    @Override // lf.e, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        if (this.f21968h == true) goto L6;
        this.f21968h = true;
        this.f21966f.flip();
        return;
    }

    @Override // lf.e
    public y d() {
        return this.f21967g;
    }

    @Override // lf.e
    public void e() {
    }

    public final void j(int r10) {
        this.f21965e.b(r10);     // Catch: Exception -> L4 SocketTimeoutException -> L8
    L17:
        return;
    L8:
        CronetHttpURLConnection r11 = this.f21964d;
        if (r11 == null) goto L16;
        r11.N();
        this.f21965e.d();
        this.f21965e.b(r10 / 2);
        return;
    L16:
        return;
    L4:
        e = move-exception;
        CronetHttpURLConnection r12 = this.f21964d;
        if (r12 == null) goto L14;
        r12.setException(new IOException("Unexpected request usage, caught in CronetChunkedOutputStream, caused by " + e));
        this.f21965e.d();
        this.f21965e.b(r10 / 2);
        return;
    }

    public final void k() {
        if (this.f21966f.hasRemaining() == true) goto L6;
        l();
        return;
    }

    public final void l() {
        b();
        this.f21966f.flip();
        j(this.f21964d.getReadTimeout());
        a();
    }

    @Override // java.io.OutputStream
    public void write(int r10) {
        k();
        this.f21966f.put((byte) r10);
    }

    @Override // java.io.OutputStream
    public void write(byte[] r10, int r11, int r12) {
        b();
        if ((r10.length - r11) < r12) goto L11;
        if (r11 < 0) goto L11;
        if (r12 < 0) goto L11;
        int r13 = r12;
    L7:
        if (r13 <= 0) goto L9;
        int r14 = Math.min(r13, this.f21966f.remaining());
        this.f21966f.put(r10, (r11 + r12) - r13, r14);
        r13 = r13 - r14;
        k();
        goto L7
    L9:
        return;
    L11:
        throw new IndexOutOfBoundsException();
    }
}

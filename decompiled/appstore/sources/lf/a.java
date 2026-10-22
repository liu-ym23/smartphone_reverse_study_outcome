package lf;

import com.ttnet.org.chromium.net.urlconnection.CronetHttpURLConnection;
import com.ttnet.org.chromium.net.y;
import com.ttnet.org.chromium.net.z;
import java.net.ProtocolException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes4.dex */
public final class a extends e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f21958d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CronetHttpURLConnection f21959e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final y f21960f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ByteBuffer f21961g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f21962h;

    /* JADX INFO: renamed from: lf.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0306a {
    }

    public class b extends y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f21963a;

        public b(a r10) {
            this.f21963a = r10;
        }

        @Override // com.ttnet.org.chromium.net.y
        public long a() {
            if (a.g(this.f21963a) != (-1)) goto L11;
            boolean r10 = a.h(this.f21963a);
            ByteBuffer r11 = a.i(this.f21963a);
            if (r10 == false) goto L8;
            int r12 = r11.limit();
        L9:
            return r12;
        L8:
            r12 = r11.position();
            goto L9
        L11:
            return a.g(this.f21963a);
        }

        @Override // com.ttnet.org.chromium.net.y
        public void b(z r10, ByteBuffer r11) {
            int r12 = r11.remaining();
            if (r12 >= a.i(this.f21963a).remaining()) goto L5;
            r11.put(a.i(this.f21963a).array(), a.i(this.f21963a).position(), r12);
            a.i(this.f21963a).position(a.i(this.f21963a).position() + r12);
        L6:
            r10.a(false);
            return;
        L5:
            r11.put(a.i(this.f21963a));
            goto L6
        }

        @Override // com.ttnet.org.chromium.net.y
        public void c(z r10) {
            a.i(this.f21963a).position(0);
            r10.c();
        }

        public /* synthetic */ b(a r10, C0306a r11) {
            this(r10);
        }
    }

    public a(CronetHttpURLConnection r10, long r11) {
        this.f21960f = new b(this, null);
        if (r10 == null) goto L15;
        if (r11 > 2147483647L) goto L13;
        if (r11 < 0) goto L11;
        this.f21959e = r10;
        int r12 = (int) r11;
        this.f21958d = r12;
        this.f21961g = ByteBuffer.allocate(r12);
        return;
    L11:
        throw new IllegalArgumentException("Content length < 0.");
    L13:
        throw new IllegalArgumentException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2GB.");
    L15:
        throw new NullPointerException("Argument connection cannot be null.");
    }

    public static /* synthetic */ int g(a r10) {
        return r10.f21958d;
    }

    public static /* synthetic */ boolean h(a r10) {
        return r10.f21962h;
    }

    public static /* synthetic */ ByteBuffer i(a r10) {
        return r10.f21961g;
    }

    @Override // lf.e
    public void c() {
    }

    @Override // lf.e
    public y d() {
        return this.f21960f;
    }

    @Override // lf.e
    public void e() {
        this.f21962h = true;
        if (this.f21961g.position() < this.f21958d) goto L7;
        this.f21961g.flip();
        return;
    L7:
        throw new ProtocolException("Content received is less than Content-Length");
    }

    public final void j(int r10) {
        if (this.f21958d == (-1)) goto L10;
        if ((this.f21961g.position() + r10) <= this.f21958d) goto L10;
        throw new ProtocolException("exceeded content-length limit of " + this.f21958d + " bytes");
    L10:
        if (this.f21962h == true) goto L20;
        if (this.f21958d == (-1)) goto L15;
        return;
    L15:
        if ((this.f21961g.limit() - this.f21961g.position()) <= r10) goto L17;
        return;
    L17:
        ByteBuffer r11 = ByteBuffer.allocate(Math.max(this.f21961g.capacity() * 2, this.f21961g.capacity() + r10));
        this.f21961g.flip();
        r11.put(this.f21961g);
        this.f21961g = r11;
        return;
    L20:
        throw new IllegalStateException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for writing after connect");
    }

    @Override // java.io.OutputStream
    public void write(int r10) {
        b();
        j(1);
        this.f21961g.put((byte) r10);
    }

    @Override // java.io.OutputStream
    public void write(byte[] r10, int r11, int r12) {
        b();
        j(r12);
        this.f21961g.put(r10, r11, r12);
    }

    public a(CronetHttpURLConnection r10) {
        this.f21960f = new b(this, null);
        if (r10 == null) goto L6;
        this.f21959e = r10;
        this.f21958d = -1;
        this.f21961g = ByteBuffer.allocate(16384);
        return;
    L6:
        throw null;
    }
}

package lf;

import com.google.common.primitives.UnsignedBytes;
import com.obric.capabilitykit.common.UiType;
import com.ttnet.org.chromium.net.urlconnection.CronetHttpURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes4.dex */
public class d extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CronetHttpURLConnection f21980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f21981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ByteBuffer f21982c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public IOException f21983d;

    public d(CronetHttpURLConnection r10) {
        this.f21980a = r10;
    }

    public final void a() {
        if (this.f21981b == false) goto L9;
        IOException r10 = this.f21983d;
        if (r10 != null) goto L7;
        return;
    L7:
        throw r10;
    L9:
        if (b() == false) goto L11;
        return;
    L11:
        if (this.f21982c != null) goto L16;
        int r11 = this.f21980a.G();
        int r12 = UiType.FLAG_SETTINGS_CARD;
        if (r11 <= 32768) goto L15;
        r12 = this.f21980a.G();
    L15:
        this.f21982c = ByteBuffer.allocateDirect(r12);
    L16:
        this.f21982c.clear();
        this.f21980a.H(this.f21982c);
        IOException r13 = this.f21983d;
        if (r13 != null) goto L21;
        ByteBuffer r14 = this.f21982c;
        if (r14 == null) goto L23;
        r14.flip();
        return;
    L23:
        return;
    L21:
        throw r13;
    }

    public final boolean b() {
        ByteBuffer r10 = this.f21982c;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.hasRemaining() == false) goto L7;
        return true;
    }

    public void c(IOException r10) {
        this.f21983d = r10;
        this.f21981b = true;
        this.f21982c = null;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        CronetHttpURLConnection r10 = this.f21980a;
        if (r10 == null) goto L5;
        r10.disconnect();
    L5:
        super.close();
    }

    @Override // java.io.InputStream
    public int read() {
        a();
        if (b() == true) goto L5;
        return -1;
    L5:
        return this.f21982c.get() & UnsignedBytes.MAX_VALUE;
    }

    @Override // java.io.InputStream
    public int read(byte[] r10, int r11, int r12) {
        if (r11 < 0) goto L16;
        if (r12 < 0) goto L16;
        if ((r11 + r12) > r10.length) goto L16;
        if (r12 != 0) goto L9;
        return 0;
    L9:
        a();
        if (b() == false) goto L13;
        int r13 = Math.min(this.f21982c.limit() - this.f21982c.position(), r12);
        this.f21982c.get(r10, r11, r13);
        return r13;
    L13:
        return -1;
    L16:
        throw new IndexOutOfBoundsException();
    }
}

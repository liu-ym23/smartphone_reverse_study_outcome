package e;

import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: RealBufferedSink.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class t implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f38747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f38748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f38749c;

    /* JADX INFO: compiled from: RealBufferedSink.kt */
    public static final class a extends OutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ t f38750a;

        a(t r1) {
            this.f38750a = r1;
        }

        @Override // java.io.OutputStream
        public void write(int r2) {
            if (this.f38750a.f38749c == true) goto L7;
            this.f38750a.f38748b.b((byte) r2);
            this.f38750a.B();
            return;
        L7:
            throw new IOException("closed");
        }

        @Override // java.io.OutputStream
        public void write(byte[] r2, int r3, int r4) {
            d.h.b.o.e(r2, "data");
            if (this.f38750a.f38749c == true) goto L7;
            this.f38750a.f38748b.b(r2, r3, r4);
            this.f38750a.B();
            return;
        L7:
            throw new IOException("closed");
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
            if (this.f38750a.f38749c == true) goto L6;
            this.f38750a.flush();
            return;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f38750a.close();
        }

        public String toString() {
            return this.f38750a + ".outputStream()";
        }
    }

    public t(y r3) {
        y r4 = (y) ZeusTransformUtils.wrapperContextForParams(r3, y.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "sink");
        this.f38747a = r4;
        this.f38748b = new e();
    }

    @Override // e.f, e.g
    public e d() {
        return this.f38748b;
    }

    @Override // e.f
    public e c() {
        return this.f38748b;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer r2) {
        d.h.b.o.e(r2, DBHelper.BATTERY_COL_SOURCE);
        if ((!this.f38749c) == false) goto L7;
        int r3 = this.f38748b.write(r2);
        B();
        return r3;
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // e.f
    public OutputStream e() {
        return (OutputStream) ZeusTransformUtils.preCheckCast(new a(this), OutputStream.class, "com.obric.aiagent.plugin");
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f38749c;
    }

    @Override // e.y
    public void a_(e r2, long r3) {
        d.h.b.o.e(r2, DBHelper.BATTERY_COL_SOURCE);
        if ((!this.f38749c) == false) goto L7;
        this.f38748b.a_(r2, r3);
        B();
        return;
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // e.f
    public f c(h r2) {
        d.h.b.o.e(r2, "byteString");
        if ((!this.f38749c) == false) goto L7;
        this.f38748b.a(r2);
        return B();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // e.f
    public f b(String r2) {
        d.h.b.o.e(r2, WsChannelMultiProcessSharedProvider.STRING_TYPE);
        if ((!this.f38749c) == false) goto L7;
        this.f38748b.a(r2);
        return B();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // e.f
    public f c(byte[] r2) {
        d.h.b.o.e(r2, DBHelper.BATTERY_COL_SOURCE);
        if ((!this.f38749c) == false) goto L7;
        this.f38748b.b(r2);
        return B();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // e.f
    public f c(byte[] r2, int r3, int r4) {
        d.h.b.o.e(r2, DBHelper.BATTERY_COL_SOURCE);
        if ((!this.f38749c) == false) goto L7;
        this.f38748b.b(r2, r3, r4);
        return B();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // e.f
    public f h(int r2) {
        if ((!this.f38749c) == false) goto L7;
        this.f38748b.b(r2);
        return B();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // e.f
    public f i(int r2) {
        if ((!this.f38749c) == false) goto L7;
        this.f38748b.c(r2);
        return B();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // e.f
    public f j(int r2) {
        if ((!this.f38749c) == false) goto L7;
        this.f38748b.d(r2);
        return B();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // e.f
    public f k(int r2) {
        if ((!this.f38749c) == false) goto L7;
        this.f38748b.e(r2);
        return B();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // e.f
    public f m(long r2) {
        if ((!this.f38749c) == false) goto L7;
        this.f38748b.j(r2);
        return B();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // e.f
    public f n(long r2) {
        if ((!this.f38749c) == false) goto L7;
        this.f38748b.k(r2);
        return B();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // e.f
    public f o(long r2) {
        if ((!this.f38749c) == false) goto L7;
        this.f38748b.l(r2);
        return B();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // e.f
    public f B() {
        if ((!this.f38749c) == false) goto L10;
        long r0 = this.f38748b.j();
        if (r0 <= 0) goto L8;
        this.f38747a.a_(this.f38748b, r0);
    L8:
        return (f) ZeusTransformUtils.preCheckCast(this, f.class, "com.obric.aiagent.plugin");
    L10:
        throw new IllegalStateException("closed".toString());
    }

    @Override // e.f
    public f C() {
        if ((!this.f38749c) == false) goto L10;
        long r0 = this.f38748b.b();
        if (r0 <= 0) goto L8;
        this.f38747a.a_(this.f38748b, r0);
    L8:
        return (f) ZeusTransformUtils.preCheckCast(this, f.class, "com.obric.aiagent.plugin");
    L10:
        throw new IllegalStateException("closed".toString());
    }

    @Override // e.f, e.y, java.io.Flushable
    public void flush() {
        if ((!this.f38749c) == false) goto L10;
        if (this.f38748b.b() <= 0) goto L7;
        y r0 = this.f38747a;
        e r1 = this.f38748b;
        r0.a_(r1, r1.b());
    L7:
        this.f38747a.flush();
        return;
    L10:
        throw new IllegalStateException("closed".toString());
    }

    @Override // e.y, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f38749c == true) goto L19;
        Throwable th = null;
    L9:
        th = th;
    L20:
        this.f38747a.close();     // Catch: Throwable -> L12
    L15:
        this.f38749c = true;
        if (th == null) goto L24;
        throw th;
    L24:
        return;
    L12:
        th = move-exception;
        if (th != null) goto L15;
        th = th;
        goto L15
    L6:
        if (this.f38748b.b() <= 0) goto L20;
        y r1 = this.f38747a;     // Catch: Throwable -> L9
        e r2 = this.f38748b;     // Catch: Throwable -> L9
        r1.a_(r2, r2.b());     // Catch: Throwable -> L9
        goto L20
    }

    @Override // e.y
    public ab a() {
        return this.f38747a.a();
    }

    public String toString() {
        return "buffer(" + this.f38747a + ')';
    }
}

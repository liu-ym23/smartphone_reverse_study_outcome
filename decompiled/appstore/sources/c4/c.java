package c4;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.util.Random;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.Sink;
import okio.Timeout;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f6041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Random f6042b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BufferedSink f6043c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Buffer f6044d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f6045e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Buffer f6046f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f6047g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f6048h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final byte[] f6049i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Buffer.UnsafeCursor f6050j;

    public final class a implements Sink {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6051a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f6052b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f6053c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f6054d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ c f6055e;

        public a(c r10) {
            this.f6055e = r10;
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f6054d == true) goto L7;
            c r10 = this.f6055e;
            r10.d(this.f6051a, r10.f6046f.size(), this.f6053c, true);
            this.f6054d = true;
            this.f6055e.f6048h = false;
            return;
        L7:
            throw new IOException("closed");
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() {
            if (this.f6054d == true) goto L7;
            c r10 = this.f6055e;
            r10.d(this.f6051a, r10.f6046f.size(), this.f6053c, false);
            this.f6053c = false;
            return;
        L7:
            throw new IOException("closed");
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return this.f6055e.f6043c.timeout();
        }

        @Override // okio.Sink
        public void write(Buffer r10, long r11) {
            if (this.f6054d == true) goto L18;
            this.f6055e.f6046f.write(r10, r11);
            if (this.f6053c == true) goto L7;
        L11:
            boolean r12 = false;
        L12:
            long r13 = this.f6055e.f6046f.c();
            if (r13 <= 0) goto L19;
            if (r12 == true) goto L20;
            this.f6055e.d(this.f6051a, r13, this.f6053c, false);
            this.f6053c = false;
            return;
        L20:
            return;
        L19:
            return;
        L7:
            if (this.f6052b == (-1)) goto L11;
            if (this.f6055e.f6046f.size() <= (this.f6052b - PlaybackStateCompat.ACTION_PLAY_FROM_URI)) goto L11;
            r12 = true;
            goto L12
        L18:
            throw new IOException("closed");
        }
    }

    public c(boolean r10, BufferedSink r11, Random r12) {
        this.f6046f = new Buffer();
        this.f6047g = new a(this);
        if (r11 == null) goto L17;
        if (r12 == null) goto L15;
        this.f6041a = r10;
        this.f6043c = r11;
        this.f6044d = r11.buffer();
        this.f6042b = r12;
        Buffer.UnsafeCursor r13 = null;
        if (r10 == false) goto L8;
        byte[] r14 = new byte[4];
    L9:
        this.f6049i = r14;
        if (r10 == false) goto L12;
        r13 = new Buffer.UnsafeCursor();
    L12:
        this.f6050j = r13;
        return;
    L8:
        r14 = null;
        goto L9
    L15:
        throw new NullPointerException("random == null");
    L17:
        throw new NullPointerException("sink == null");
    }

    public Sink a(int r10, long r11) {
        if (this.f6048h == true) goto L7;
        this.f6048h = true;
        a r12 = this.f6047g;
        r12.f6051a = r10;
        r12.f6052b = r11;
        r12.f6053c = true;
        r12.f6054d = false;
        return r12;
    L7:
        throw new IllegalStateException("Another message writer is active. Did you call close()?");
    }

    public void b(int r10, ByteString r11) {
        ByteString r12 = ByteString.EMPTY;
        if (r10 != 0) goto L5;
        if (r11 != null) goto L5;
    L18:
        c(8, r12);     // Catch: Throwable -> L15
        this.f6045e = true;
        return;
    L15:
        th = move-exception;
        this.f6045e = true;
        throw th;
    L5:
        if (r10 == 0) goto L7;
        b.c(r10);
    L7:
        Buffer r13 = new Buffer();
        r13.A(r10);
        if (r11 == null) goto L10;
        r13.q(r11);
    L10:
        r12 = r13.readByteString();
        goto L18
    }

    public final void c(int r10, ByteString r11) {
        if (this.f6045e == true) goto L17;
        int r12 = r11.size();
        if (r12 > 125) goto L15;
        this.f6044d.t(r10 | 128);
        if (this.f6041a == false) goto L11;
        this.f6044d.t(r12 | 128);
        this.f6042b.nextBytes(this.f6049i);
        this.f6044d.r(this.f6049i);
        if (r12 <= 0) goto L12;
        long r13 = this.f6044d.size();
        this.f6044d.q(r11);
        this.f6044d.i(this.f6050j);
        this.f6050j.b(r13);
        b.b(this.f6050j, this.f6049i);
        this.f6050j.close();
    L12:
        this.f6043c.flush();
        return;
    L11:
        this.f6044d.t(r12);
        this.f6044d.q(r11);
        goto L12
    L15:
        throw new IllegalArgumentException("Payload size must be less than or equal to 125");
    L17:
        throw new IOException("closed");
    }

    public void d(int r10, long r11, boolean r12, boolean r13) {
        if (this.f6045e == true) goto L29;
        int r14 = 0;
        if (r12 == true) goto L8;
        r10 = 0;
    L8:
        if (r13 == false) goto L10;
        r10 = r10 | 128;
    L10:
        this.f6044d.t(r10);
        if (this.f6041a == false) goto L14;
        r14 = 128;
    L14:
        if (r11 > 125) goto L17;
        this.f6044d.t(((int) r11) | r14);
    L21:
        if (this.f6041a == false) goto L25;
        this.f6042b.nextBytes(this.f6049i);
        this.f6044d.r(this.f6049i);
        if (r11 <= 0) goto L26;
        long r15 = this.f6044d.size();
        this.f6044d.write(this.f6046f, r11);
        this.f6044d.i(this.f6050j);
        this.f6050j.b(r15);
        b.b(this.f6050j, this.f6049i);
        this.f6050j.close();
    L26:
        this.f6043c.emit();
        return;
    L25:
        this.f6044d.write(this.f6046f, r11);
        goto L26
    L17:
        if (r11 > 65535) goto L19;
        this.f6044d.t(r14 | 126);
        this.f6044d.A((int) r11);
        goto L21
    L19:
        this.f6044d.t(r14 | 127);
        this.f6044d.y(r11);
        goto L21
    L29:
        throw new IOException("closed");
    }

    public void e(ByteString r10) {
        c(9, r10);
    }

    public void f(ByteString r10) {
        c(10, r10);
    }
}

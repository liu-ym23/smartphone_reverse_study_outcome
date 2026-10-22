package e;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bytedance.apm.battery.dao.DBHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: RealBufferedSource.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class u implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final aa f38751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f38752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f38753c;

    /* JADX INFO: compiled from: RealBufferedSource.kt */
    public static final class a extends InputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ u f38754a;

        a(u r1) {
            this.f38754a = r1;
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.f38754a.f38753c == true) goto L13;
            if (this.f38754a.f38752b.b() != 0) goto L11;
            if (this.f38754a.f38751a.a(this.f38754a.f38752b, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != (-1)) goto L11;
            return -1;
        L11:
            return this.f38754a.f38752b.k() & 255;
        L13:
            throw new IOException("closed");
        }

        @Override // java.io.InputStream
        public int read(byte[] r8, int r9, int r10) {
            d.h.b.o.e(r8, "data");
            if (this.f38754a.f38753c == true) goto L13;
            b.a(r8.length, r9, r10);
            if (this.f38754a.f38752b.b() != 0) goto L11;
            if (this.f38754a.f38751a.a(this.f38754a.f38752b, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != (-1)) goto L11;
            return -1;
        L11:
            return this.f38754a.f38752b.a(r8, r9, r10);
        L13:
            throw new IOException("closed");
        }

        @Override // java.io.InputStream
        public int available() {
            if (this.f38754a.f38753c == true) goto L7;
            return (int) Math.min(this.f38754a.f38752b.b(), Integer.MAX_VALUE);
        L7:
            throw new IOException("closed");
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f38754a.close();
        }

        public String toString() {
            return this.f38754a + ".inputStream()";
        }
    }

    public u(aa r3) {
        aa r4 = (aa) ZeusTransformUtils.wrapperContextForParams(r3, aa.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, DBHelper.BATTERY_COL_SOURCE);
        this.f38751a = r4;
        this.f38752b = new e();
    }

    @Override // e.g
    public e d() {
        return this.f38752b;
    }

    @Override // e.g
    public String v() {
        return f(Long.MAX_VALUE);
    }

    public long a(byte r7) {
        return a(r7, 0, Long.MAX_VALUE);
    }

    @Override // e.g
    public InputStream i() {
        return (InputStream) ZeusTransformUtils.preCheckCast(new a(this), InputStream.class, "com.obric.aiagent.plugin");
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f38753c;
    }

    @Override // e.aa
    public long a(e r7, long r8) {
        d.h.b.o.e(r7, "sink");
        if (r8 < 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L19;
        if ((!this.f38753c) == false) goto L17;
        if (this.f38752b.b() != 0) goto L15;
        if (this.f38751a.a(this.f38752b, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != (-1)) goto L15;
        return -1;
    L15:
        return this.f38752b.a(r7, Math.min(r8, this.f38752b.b()));
    L17:
        throw new IllegalStateException("closed".toString());
    L19:
        throw new IllegalArgumentException(("byteCount < 0: " + r8).toString());
    L5:
        r2 = false;
        goto L6
    }

    @Override // e.g
    public boolean h() {
        if ((!this.f38753c) == false) goto L12;
        if (this.f38752b.h() == true) goto L7;
    L9:
        return false;
    L7:
        if (this.f38751a.a(this.f38752b, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != (-1)) goto L9;
        return true;
    L12:
        throw new IllegalStateException("closed".toString());
    }

    @Override // e.g
    public void b(long r1) {
        if (a(r1) == false) goto L6;
        return;
    L6:
        throw new EOFException();
    }

    public boolean a(long r8) {
        if (r8 < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L19;
        if ((!this.f38753c) == false) goto L17;
    L10:
        if (this.f38752b.b() >= r8) goto L15;
        if (this.f38751a.a(this.f38752b, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != (-1)) goto L10;
        return false;
    L15:
        return true;
    L17:
        throw new IllegalStateException("closed".toString());
    L19:
        throw new IllegalArgumentException(("byteCount < 0: " + r8).toString());
    L5:
        r0 = false;
        goto L6
    }

    @Override // e.g
    public byte k() {
        b(1);
        return this.f38752b.k();
    }

    @Override // e.g
    public h d(long r1) {
        b(r1);
        return this.f38752b.d(r1);
    }

    @Override // e.g
    public int a(r r9) {
        d.h.b.o.e(r9, "options");
        if ((!this.f38753c) == false) goto L14;
    L4:
        int r0 = e.a.a.a(this.f38752b, r9, true);
        if (r0 != (-2)) goto L6;
        if (this.f38751a.a(this.f38752b, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != (-1)) goto L4;
    L18:
        return -1;
    L6:
        if (r0 == (-1)) goto L18;
        this.f38752b.h(r9.b()[r0].k());
        return r0;
    L14:
        throw new IllegalStateException("closed".toString());
    }

    @Override // e.g
    public byte[] g(long r1) {
        b(r1);
        return this.f38752b.g(r1);
    }

    @Override // e.g
    public void a(byte[] r7) {
        d.h.b.o.e(r7, "sink");
        b(r7.length);     // Catch: EOFException -> L6
        this.f38752b.a(r7);
        return;
    L6:
        e = move-exception;
        int r1 = 0;
    L9:
        if (this.f38752b.b() <= 0) goto L15;
        e r2 = this.f38752b;
        int r3 = r2.a(r7, r1, (int) r2.b());
        if (r3 == (-1)) goto L14;
        r1 = r1 + r3;
        goto L9
    L14:
        throw new AssertionError();
    L15:
        throw e;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer r5) {
        d.h.b.o.e(r5, "sink");
        if (this.f38752b.b() != 0) goto L9;
        if (this.f38751a.a(this.f38752b, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != (-1)) goto L9;
        return -1;
    L9:
        return this.f38752b.read(r5);
    }

    @Override // e.g
    public void b(e r2, long r3) {
        d.h.b.o.e(r2, "sink");
        b(r3);     // Catch: EOFException -> L6
        this.f38752b.b(r2, r3);
        return;
    L6:
        e = move-exception;
        r2.a((aa) ZeusTransformUtils.preCheckCast(this.f38752b, aa.class, "com.obric.aiagent.plugin"));
        throw e;
    }

    @Override // e.g
    public String e(long r1) {
        b(r1);
        return this.f38752b.e(r1);
    }

    @Override // e.g
    public String a(Charset r3) {
        d.h.b.o.e(r3, "charset");
        this.f38752b.a(this.f38751a);
        return this.f38752b.a(r3);
    }

    @Override // e.g
    public String f(long r14) {
        if (r14 < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L29;
        if (r14 != Long.MAX_VALUE) goto L10;
        long r5 = Long.MAX_VALUE;
    L11:
        long r7 = a((byte) 10, 0, r5);
        if (r7 == (-1)) goto L15;
        return e.a.a.a(this.f38752b, r7);
    L15:
        if (r5 < Long.MAX_VALUE) goto L17;
    L26:
        e r6 = new e();
        e r1 = this.f38752b;
        r1.a(r6, 0, Math.min(32, r1.b()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f38752b.b(), r14) + " content=" + r6.t().i() + 8230);
    L17:
        if (a(r5) == false) goto L26;
        if (this.f38752b.c(r5 - 1) != 13) goto L26;
        if (a(1 + r5) == false) goto L26;
        if (this.f38752b.c(r5) != 10) goto L26;
        return e.a.a.a(this.f38752b, r5);
    L10:
        r5 = r14 + 1;
        goto L11
    L29:
        throw new IllegalArgumentException(("limit < 0: " + r14).toString());
    L5:
        r0 = false;
        goto L6
    }

    @Override // e.g
    public short l() {
        b(2);
        return this.f38752b.l();
    }

    public short b() {
        b(2);
        return this.f38752b.o();
    }

    @Override // e.g
    public int m() {
        b(4);
        return this.f38752b.m();
    }

    @Override // e.g
    public int p() {
        b(4);
        return this.f38752b.p();
    }

    @Override // e.g
    public long n() {
        b(8);
        return this.f38752b.n();
    }

    @Override // e.g
    public long q() {
        b(8);
        return this.f38752b.q();
    }

    @Override // e.g
    public long r() {
        b(1);
        long r4 = 0;
    L3:
        long r6 = r4 + 1;
        if (a(r6) == false) goto L20;
        byte r8 = this.f38752b.c(r4);
        if (r8 < 48) goto L10;
        if (r8 > 57) goto L10;
    L14:
        r4 = r6;
    L10:
        if (r4 != 0) goto L15;
        if (r8 == 45) goto L14;
    L15:
        if (r4 != 0) goto L20;
        StringBuilder r0 = new StringBuilder().append("Expected a digit or '-' but was 0x");
        String r1 = Integer.toString(r8, d.o.a.a(d.o.a.a(16)));
        d.h.b.o.c(r1, "toString(this, checkRadix(radix))");
        throw new NumberFormatException(r0.append(r1).toString());
    L20:
        return this.f38752b.r();
    }

    @Override // e.g
    public long s() {
        b(1);
        int r0 = 0;
    L3:
        int r1 = r0 + 1;
        if (a(r1) == false) goto L24;
        byte r2 = this.f38752b.c(r0);
        if (r2 < 48) goto L10;
        if (r2 > 57) goto L10;
    L18:
        r0 = r1;
    L10:
        if (r2 < 97) goto L14;
        if (r2 <= 102) goto L18;
    L14:
        if (r2 < 65) goto L19;
        if (r2 <= 70) goto L18;
    L19:
        if (r0 != 0) goto L24;
        StringBuilder r3 = new StringBuilder().append("Expected leading [0-9a-fA-F] character but was 0x");
        String r4 = Integer.toString(r2, d.o.a.a(d.o.a.a(16)));
        d.h.b.o.c(r4, "toString(this, checkRadix(radix))");
        throw new NumberFormatException(r3.append(r4).toString());
    L24:
        return this.f38752b.s();
    }

    @Override // e.g
    public void h(long r5) {
        if ((!this.f38753c) == false) goto L16;
    L5:
        if (r5 <= 0) goto L14;
        if (this.f38752b.b() != 0) goto L13;
        if (this.f38751a.a(this.f38752b, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != (-1)) goto L13;
        throw new EOFException();
    L13:
        long r0 = Math.min(r5, this.f38752b.b());
        this.f38752b.h(r0);
        r5 = r5 - r0;
        goto L5
    L14:
        return;
    L16:
        throw new IllegalStateException("closed".toString());
    }

    public long a(byte r11, long r12, long r14) {
        boolean r1 = true;
        if ((!this.f38753c) == false) goto L26;
        if (0 <= r12) goto L7;
    L9:
        r1 = false;
    L10:
        if (r1 == false) goto L24;
    L12:
        if (r12 >= r14) goto L33;
        long r0 = this.f38752b.a(r11, r12, r14);
        if (r0 != (-1)) goto L22;
        long r2 = this.f38752b.b();
        if (r2 >= r14) goto L31;
        if (this.f38751a.a(this.f38752b, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == (-1)) goto L32;
        r12 = Math.max(r12, r2);
        goto L12
    L32:
        return -1;
    L31:
        return -1;
    L22:
        return r0;
    L33:
        return -1;
    L24:
        throw new IllegalArgumentException(("fromIndex=" + r12 + " toIndex=" + r14).toString());
    L7:
        if (r12 > r14) goto L9;
    L26:
        throw new IllegalStateException("closed".toString());
    }

    @Override // e.aa, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f38753c == true) goto L6;
        this.f38753c = true;
        this.f38751a.close();
        this.f38752b.x();
        return;
    }

    @Override // e.aa
    public ab a() {
        return this.f38751a.a();
    }

    public String toString() {
        return "buffer(" + this.f38751a + ')';
    }
}

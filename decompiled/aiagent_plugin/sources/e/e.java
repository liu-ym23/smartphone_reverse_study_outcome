package e;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: Buffer.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class e implements f, g, Cloneable, ByteChannel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public v f38713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f38714b;

    /* JADX INFO: compiled from: Buffer.kt */
    public static final class a implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e f38715a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f38716b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f38717c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public byte[] f38718d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f38719e;
        public int f;
        private v g;

        public a() {
            this.f38717c = -1;
            this.f38719e = -1;
            this.f = -1;
        }

        public final v a() {
            return this.g;
        }

        public final void a(v r1) {
            this.g = r1;
        }

        public final int b() {
            long r0 = this.f38717c;
            e r2 = this.f38715a;
            d.h.b.o.a(r2);
            if (r0 == r2.b()) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == false) goto L14;
            long r3 = this.f38717c;
            if (r3 != (-1)) goto L10;
            long r4 = 0;
        L12:
            return a(r4);
        L10:
            r4 = r3 + ((long) (this.f - this.f38719e));
            goto L12
        L14:
            throw new IllegalStateException("no more bytes".toString());
        L5:
            r1 = false;
            goto L6
        }

        public final int a(long r12) {
            e r0 = this.f38715a;
            if (r0 == null) goto L42;
            if (r12 < (-1)) goto L40;
            if (r12 > r0.b()) goto L40;
            if (r12 != (-1)) goto L11;
        L37:
            a(null);
            this.f38717c = r12;
            this.f38718d = null;
            this.f38719e = -1;
            this.f = -1;
            return -1;
        L11:
            if (r12 == r0.b()) goto L37;
            long r1 = 0;
            long r3 = r0.b();
            v r5 = r0.f38713a;
            v r6 = r0.f38713a;
            if (a() == null) goto L20;
            long r7 = this.f38717c;
            int r9 = this.f38719e;
            v r10 = a();
            d.h.b.o.a(r10);
            long r8 = r7 - ((long) (r9 - r10.f38757c));
            if (r8 <= r12) goto L18;
            r6 = a();
            r3 = r8;
            goto L20
        L18:
            r5 = a();
            r1 = r8;
        L20:
            if ((r3 - r12) <= (r12 - r1)) goto L25;
        L21:
            d.h.b.o.a(r5);
            if (r12 < (((long) (r5.f38758d - r5.f38757c)) + r1)) goto L29;
            r1 = r1 + ((long) (r5.f38758d - r5.f38757c));
            r5 = r5.g;
        L29:
            if (this.f38716b == false) goto L36;
            d.h.b.o.a(r5);
            if (r5.f38759e == false) goto L36;
            v r4 = r5.b();
            if (r0.f38713a != r5) goto L35;
            r0.f38713a = r4;
        L35:
            r5 = r5.a(r4);
            v r2 = r5.h;
            d.h.b.o.a(r2);
            r2.c();
        L36:
            a(r5);
            this.f38717c = r12;
            d.h.b.o.a(r5);
            this.f38718d = r5.f38756b;
            this.f38719e = r5.f38757c + ((int) (r12 - r1));
            int r13 = r5.f38758d;
            this.f = r13;
            return r13 - this.f38719e;
        L25:
            if (r3 <= r12) goto L27;
            d.h.b.o.a(r6);
            r6 = r6.h;
            d.h.b.o.a(r6);
            r3 = r3 - ((long) (r6.f38758d - r6.f38757c));
            goto L25
        L27:
            r1 = r3;
            r5 = r6;
        L40:
            throw new ArrayIndexOutOfBoundsException("offset=" + r12 + " > size=" + r0.b());
        L42:
            throw new IllegalStateException("not attached to a buffer".toString());
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f38715a == null) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L10;
            this.f38715a = null;
            a(null);
            this.f38717c = -1;
            this.f38718d = null;
            this.f38719e = -1;
            this.f = -1;
            return;
        L10:
            throw new IllegalStateException("not attached to a buffer".toString());
        L5:
            r0 = false;
            goto L6
        }
    }

    /* JADX INFO: compiled from: Buffer.kt */
    public static final class b extends InputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f38720a;

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        b(e r1) {
            this.f38720a = r1;
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.f38720a.b() > 0) goto L7;
            return -1;
        L7:
            return this.f38720a.k() & 255;
        }

        @Override // java.io.InputStream
        public int read(byte[] r2, int r3, int r4) {
            d.h.b.o.e(r2, "sink");
            return this.f38720a.a(r2, r3, r4);
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) Math.min(this.f38720a.b(), Integer.MAX_VALUE);
        }

        public String toString() {
            return this.f38720a + ".inputStream()";
        }
    }

    /* JADX INFO: compiled from: Buffer.kt */
    public static final class c extends OutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f38721a;

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
        }

        c(e r1) {
            this.f38721a = r1;
        }

        @Override // java.io.OutputStream
        public void write(int r1) {
            this.f38721a.b(r1);
        }

        @Override // java.io.OutputStream
        public void write(byte[] r2, int r3, int r4) {
            d.h.b.o.e(r2, "data");
            this.f38721a.b(r2, r3, r4);
        }

        public String toString() {
            return this.f38721a + ".outputStream()";
        }
    }

    @Override // e.f
    public e c() {
        return this;
    }

    @Override // e.y, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // e.f, e.g
    public e d() {
        return this;
    }

    public e f() {
        return this;
    }

    @Override // e.f, e.y, java.io.Flushable
    public void flush() {
    }

    public e g() {
        return this;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public e() {
    }

    @Override // e.f
    public /* synthetic */ f B() {
        return (f) ZeusTransformUtils.preCheckCast(f(), f.class, "com.obric.aiagent.plugin");
    }

    @Override // e.f
    public /* synthetic */ f C() {
        return (f) ZeusTransformUtils.preCheckCast(g(), f.class, "com.obric.aiagent.plugin");
    }

    @Override // e.f
    public /* synthetic */ f b(String r2) {
        return (f) ZeusTransformUtils.preCheckCast(a(r2), f.class, "com.obric.aiagent.plugin");
    }

    @Override // e.f
    public /* synthetic */ f c(h r2) {
        return (f) ZeusTransformUtils.preCheckCast(a(r2), f.class, "com.obric.aiagent.plugin");
    }

    @Override // e.f
    public /* synthetic */ f c(byte[] r2) {
        return (f) ZeusTransformUtils.preCheckCast(b(r2), f.class, "com.obric.aiagent.plugin");
    }

    @Override // e.f
    public /* synthetic */ f c(byte[] r1, int r2, int r3) {
        return (f) ZeusTransformUtils.preCheckCast(b(r1, r2, r3), f.class, "com.obric.aiagent.plugin");
    }

    public /* synthetic */ Object clone() {
        return z();
    }

    @Override // e.f
    public /* synthetic */ f h(int r2) {
        return (f) ZeusTransformUtils.preCheckCast(b(r2), f.class, "com.obric.aiagent.plugin");
    }

    @Override // e.f
    public /* synthetic */ f i(int r2) {
        return (f) ZeusTransformUtils.preCheckCast(c(r2), f.class, "com.obric.aiagent.plugin");
    }

    @Override // e.f
    public /* synthetic */ f j(int r2) {
        return (f) ZeusTransformUtils.preCheckCast(d(r2), f.class, "com.obric.aiagent.plugin");
    }

    @Override // e.f
    public /* synthetic */ f k(int r2) {
        return (f) ZeusTransformUtils.preCheckCast(e(r2), f.class, "com.obric.aiagent.plugin");
    }

    @Override // e.f
    public /* synthetic */ f m(long r1) {
        return (f) ZeusTransformUtils.preCheckCast(j(r1), f.class, "com.obric.aiagent.plugin");
    }

    @Override // e.f
    public /* synthetic */ f n(long r1) {
        return (f) ZeusTransformUtils.preCheckCast(k(r1), f.class, "com.obric.aiagent.plugin");
    }

    @Override // e.f
    public /* synthetic */ f o(long r1) {
        return (f) ZeusTransformUtils.preCheckCast(l(r1), f.class, "com.obric.aiagent.plugin");
    }

    public final long b() {
        return this.f38714b;
    }

    public final void a(long r1) {
        this.f38714b = r1;
    }

    @Override // e.f
    public OutputStream e() {
        return (OutputStream) ZeusTransformUtils.preCheckCast(new c(this), OutputStream.class, "com.obric.aiagent.plugin");
    }

    @Override // e.g
    public boolean h() {
        if (this.f38714b != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // e.g
    public void b(long r3) {
        if (this.f38714b < r3) goto L6;
        return;
    L6:
        throw new EOFException();
    }

    @Override // e.g
    public InputStream i() {
        return (InputStream) ZeusTransformUtils.preCheckCast(new b(this), InputStream.class, "com.obric.aiagent.plugin");
    }

    public short o() {
        return e.b.a(l());
    }

    @Override // e.g
    public int p() {
        return e.b.a(m());
    }

    @Override // e.g
    public long q() {
        return e.b.a(n());
    }

    public String u() {
        return a(this.f38714b, d.o.d.f38623b);
    }

    @Override // e.g
    public String e(long r2) {
        return a(r2, d.o.d.f38623b);
    }

    @Override // e.g
    public String a(Charset r3) {
        d.h.b.o.e(r3, "charset");
        return a(this.f38714b, r3);
    }

    public String a(long r6, Charset r8) {
        d.h.b.o.e(r8, "charset");
        if (r6 >= 0) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L25;
        if (this.f38714b < r6) goto L23;
        if (r6 != 0) goto L14;
        return "";
    L14:
        v r0 = this.f38713a;
        d.h.b.o.a(r0);
        if ((((long) r0.f38757c) + r6) > r0.f38758d) goto L17;
        int r4 = (int) r6;
        String r2 = new String(r0.f38756b, r0.f38757c, r4, r8);
        r0.f38757c += r4;
        this.f38714b -= r6;
        if (r0.f38757c != r0.f38758d) goto L21;
        this.f38713a = r0.c();
        w.a(r0);
    L21:
        return r2;
    L17:
        return new String(g(r6), r8);
    L23:
        throw new EOFException();
    L25:
        throw new IllegalArgumentException(("byteCount: " + r6).toString());
    L5:
        if (r6 > 2147483647L) goto L7;
        r1 = true;
        goto L8
    }

    @Override // e.g
    public String v() {
        return f(Long.MAX_VALUE);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer r7) {
        d.h.b.o.e(r7, "sink");
        v r0 = this.f38713a;
        if (r0 != null) goto L6;
        return -1;
    L6:
        int r1 = Math.min(r7.remaining(), r0.f38758d - r0.f38757c);
        r7.put(r0.f38756b, r0.f38757c, r1);
        r0.f38757c += r1;
        this.f38714b -= (long) r1;
        if (r0.f38757c != r0.f38758d) goto L9;
        this.f38713a = r0.c();
        w.a(r0);
    L9:
        return r1;
    }

    public e a(String r3) {
        d.h.b.o.e(r3, WsChannelMultiProcessSharedProvider.STRING_TYPE);
        return a(r3, 0, r3.length());
    }

    public e a(String r4, int r5, int r6, Charset r7) {
        d.h.b.o.e(r4, WsChannelMultiProcessSharedProvider.STRING_TYPE);
        d.h.b.o.e(r7, "charset");
        boolean r0 = true;
        if (r5 < 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L27;
        if (r6 < r5) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L25;
        if (r6 <= r4.length()) goto L15;
        r0 = false;
    L15:
        if (r0 == false) goto L23;
        if (d.h.b.o.a(r7, d.o.d.f38623b) == true) goto L19;
        String r8 = r4.substring(r5, r6);
        d.h.b.o.c(r8, "this as java.lang.String…ing(startIndex, endIndex)");
        byte[] r9 = r8.getBytes(r7);
        d.h.b.o.c(r9, "this as java.lang.String).getBytes(charset)");
        return b(r9, 0, r9.length);
    L19:
        return a(r4, r5, r6);
    L23:
        throw new IllegalArgumentException(("endIndex > string.length: " + r6 + " > " + r4.length()).toString());
    L25:
        throw new IllegalArgumentException(("endIndex < beginIndex: " + r6 + " < " + r5).toString());
    L9:
        r3 = false;
        goto L10
    L27:
        throw new IllegalArgumentException(("beginIndex < 0: " + r5).toString());
    L5:
        r2 = false;
        goto L6
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer r7) {
        d.h.b.o.e(r7, DBHelper.BATTERY_COL_SOURCE);
        int r0 = r7.remaining();
        int r1 = r0;
    L3:
        if (r1 <= 0) goto L5;
        v r2 = f(1);
        int r3 = Math.min(r1, 8192 - r2.f38758d);
        r7.get(r2.f38756b, r2.f38758d, r3);
        r1 = r1 - r3;
        r2.f38758d += r3;
        goto L3
    L5:
        this.f38714b += (long) r0;
        return r0;
    }

    public e e(int r1) {
        return d(e.b.a(r1));
    }

    public e j(long r1) {
        return i(e.b.a(r1));
    }

    public long b(h r3) {
        d.h.b.o.e(r3, "targetBytes");
        return a(r3, 0);
    }

    @Override // e.y
    public ab a() {
        return ab.f38700d;
    }

    public String toString() {
        return A().toString();
    }

    public e z() {
        return y();
    }

    public final a a(a r2) {
        d.h.b.o.e(r2, "unsafeCursor");
        return e.a.a.a(this, r2);
    }

    public final e a(e r8, long r9, long r11) {
        d.h.b.o.e(r8, "out");
        e.b.a(b(), r9, r11);
        if (r11 == 0) goto L16;
        r8.a(r8.b() + r11);
        v r2 = this.f38713a;
    L6:
        d.h.b.o.a(r2);
        if (r9 < (r2.f38758d - r2.f38757c)) goto L10;
        r9 = r9 - ((long) (r2.f38758d - r2.f38757c));
        r2 = r2.g;
    L10:
        if (r11 <= 0) goto L16;
        d.h.b.o.a(r2);
        v r3 = r2.a();
        r3.f38757c += (int) r9;
        r3.f38758d = Math.min(r3.f38757c + ((int) r11), r3.f38758d);
        v r10 = r8.f38713a;
        if (r10 != null) goto L14;
        r3.h = r3;
        r3.g = r3.h;
        r8.f38713a = r3.g;
    L15:
        r11 = r11 - ((long) (r3.f38758d - r3.f38757c));
        r2 = r2.g;
        r9 = 0;
        goto L10
    L14:
        d.h.b.o.a(r10);
        v r12 = r10.h;
        d.h.b.o.a(r12);
        r12.a(r3);
    L16:
        return this;
    }

    public final long j() {
        long r0 = b();
        if (r0 == 0) goto L12;
        v r5 = this.f38713a;
        d.h.b.o.a(r5);
        v r6 = r5.h;
        d.h.b.o.a(r6);
        if (r6.f38758d >= 8192) goto L11;
        if (r6.f == false) goto L11;
        r0 = r0 - ((long) (r6.f38758d - r6.f38757c));
    L11:
        return r0;
    L12:
        return 0;
    }

    @Override // e.g
    public byte k() {
        if (b() == 0) goto L10;
        v r0 = this.f38713a;
        d.h.b.o.a(r0);
        int r1 = r0.f38757c;
        int r2 = r0.f38758d;
        int r4 = r1 + 1;
        byte r3 = r0.f38756b[r1];
        a(b() - 1);
        if (r4 != r2) goto L7;
        this.f38713a = r0.c();
        w.a(r0);
    L8:
        return r3;
    L7:
        r0.f38757c = r4;
        goto L8
    L10:
        throw new EOFException();
    }

    public final byte c(long r7) {
        e.b.a(b(), r7, 1);
        v r0 = this.f38713a;
        if (r0 != null) goto L6;
        v r6 = null;
        d.h.b.o.a(null);
        return r6.f38756b[(int) ((((long) r6.f38757c) + r7) - (-1))];
    L6:
        if ((b() - r7) >= r7) goto L12;
        long r1 = b();
    L9:
        if (r1 <= r7) goto L11;
        r0 = r0.h;
        d.h.b.o.a(r0);
        r1 = r1 - ((long) (r0.f38758d - r0.f38757c));
        goto L9
    L11:
        d.h.b.o.a(r0);
        return r0.f38756b[(int) ((((long) r0.f38757c) + r7) - r1)];
    L12:
        long r2 = 0;
    L13:
        long r3 = ((long) (r0.f38758d - r0.f38757c)) + r2;
        if (r3 > r7) goto L16;
        r0 = r0.g;
        d.h.b.o.a(r0);
        r2 = r3;
        goto L13
    L16:
        d.h.b.o.a(r0);
        return r0.f38756b[(int) ((((long) r0.f38757c) + r7) - r2)];
    }

    @Override // e.g
    public short l() {
        if (b() < 2) goto L14;
        v r0 = this.f38713a;
        d.h.b.o.a(r0);
        int r1 = r0.f38757c;
        int r4 = r0.f38758d;
        if ((r4 - r1) >= 2) goto L7;
        int r2 = (k() & 255) << 8;
        return (short) ((k() & 255) | r2);
    L7:
        byte[] r5 = r0.f38756b;
        int r6 = r1 + 1;
        int r7 = r6 + 1;
        int r3 = ((r5[r1] & 255) << 8) | (r5[r6] & 255);
        a(b() - 2);
        if (r7 != r4) goto L10;
        this.f38713a = r0.c();
        w.a(r0);
    L12:
        return (short) r3;
    L10:
        r0.f38757c = r7;
        goto L12
    L14:
        throw new EOFException();
    }

    @Override // e.g
    public int m() {
        if (b() < 4) goto L14;
        v r0 = this.f38713a;
        d.h.b.o.a(r0);
        int r1 = r0.f38757c;
        int r4 = r0.f38758d;
        if ((r4 - r1) < 4) goto L15;
        byte[] r5 = r0.f38756b;
        int r6 = r1 + 1;
        int r7 = r6 + 1;
        int r2 = ((r5[r1] & 255) << 24) | ((r5[r6] & 255) << 16);
        int r8 = r7 + 1;
        int r3 = r2 | ((r5[r7] & 255) << 8);
        int r9 = r8 + 1;
        int r10 = r3 | (r5[r8] & 255);
        a(b() - 4);
        if (r9 != r4) goto L10;
        this.f38713a = r0.c();
        w.a(r0);
    L12:
        return r10;
    L10:
        r0.f38757c = r9;
        goto L12
    L15:
        return (k() & 255) | ((((k() & 255) << 24) | ((k() & 255) << 16)) | ((k() & 255) << 8));
    L14:
        throw new EOFException();
    }

    @Override // e.g
    public long n() {
        if (b() < 8) goto L14;
        v r0 = this.f38713a;
        d.h.b.o.a(r0);
        int r1 = r0.f38757c;
        int r4 = r0.f38758d;
        if ((r4 - r1) < 8) goto L15;
        byte[] r5 = r0.f38756b;
        int r7 = r1 + 1;
        long r8 = (((long) r5[r1]) & 255) << 56;
        int r2 = r7 + 1;
        int r9 = r2 + 1;
        long r10 = (r8 | ((((long) r5[r7]) & 255) << 48)) | ((((long) r5[r2]) & 255) << 40);
        int r3 = r9 + 1;
        int r11 = r3 + 1;
        long r6 = (r10 | ((((long) r5[r9]) & 255) << 32)) | ((((long) r5[r3]) & 255) << 24);
        int r12 = r11 + 1;
        long r13 = r6 | ((((long) r5[r11]) & 255) << 16);
        int r14 = r12 + 1;
        long r15 = r13 | ((((long) r5[r12]) & 255) << 8);
        int r16 = r14 + 1;
        long r17 = r15 | (((long) r5[r14]) & 255);
        a(b() - 8);
        if (r16 != r4) goto L10;
        this.f38713a = r0.c();
        w.a(r0);
    L12:
        return r17;
    L10:
        r0.f38757c = r16;
        goto L12
    L15:
        return ((((long) m()) & 4294967295L) << 32) | (4294967295L & ((long) m()));
    L14:
        throw new EOFException();
    }

    @Override // e.g
    public long r() {
        if (b() == 0) goto L56;
        long r1 = -7;
        int r5 = 0;
        long r8 = 0;
        boolean r6 = false;
        boolean r7 = false;
    L5:
        v r10 = this.f38713a;
        d.h.b.o.a(r10);
        byte[] r11 = r10.f38756b;
        int r12 = r10.f38757c;
        int r13 = r10.f38758d;
    L6:
        if (r12 >= r13) goto L29;
        byte r15 = r11[r12];
        if (r15 < 48) goto L24;
        if (r15 > 57) goto L24;
        int r14 = 48 - r15;
        if (r8 < (-922337203685477580L)) goto L18;
        if (r8 == (-922337203685477580L)) goto L15;
    L17:
        r8 = (r8 * 10) + ((long) r14);
    L27:
        r12 = r12 + 1;
        r5 = r5 + 1;
        goto L6
    L15:
        if (r14 >= r1) goto L17;
    L18:
        e r0 = new e().k(r8).b(r15);
        if (r6 == true) goto L22;
        r0.k();
    L22:
        throw new NumberFormatException("Number too large: " + r0.u());
    L24:
        if (r15 != 45) goto L28;
        if (r5 != 0) goto L28;
        r1 = r1 - 1;
        r6 = true;
    L28:
        r7 = true;
    L29:
        if (r12 != r13) goto L31;
        this.f38713a = r10.c();
        w.a(r10);
    L32:
        if (r7 == true) goto L37;
        if (this.f38713a != null) goto L5;
    L37:
        a(b() - ((long) r5));
        if (r6 == false) goto L40;
        int r16 = 2;
    L41:
        if (r5 < r16) goto L43;
        if (r6 == false) goto L54;
        return r8;
    L54:
        return -r8;
    L43:
        if (b() == 0) goto L50;
        if (r6 == false) goto L46;
        String r2 = "Expected a digit";
    L48:
        throw new NumberFormatException(r2 + " but was 0x" + e.b.a(c(0)));
    L46:
        r2 = "Expected a digit or '-'";
        goto L48
    L50:
        throw new EOFException();
    L40:
        r16 = 1;
        goto L41
    L31:
        r10.f38757c = r12;
        goto L32
    L56:
        throw new EOFException();
    }

    @Override // e.g
    public long s() {
        if (b() == 0) goto L41;
        int r0 = 0;
        boolean r1 = false;
        long r4 = 0;
    L5:
        v r6 = this.f38713a;
        d.h.b.o.a(r6);
        byte[] r7 = r6.f38756b;
        int r8 = r6.f38757c;
        int r9 = r6.f38758d;
    L6:
        if (r8 >= r9) goto L32;
        byte r10 = r7[r8];
        if (r10 < 48) goto L13;
        if (r10 > 57) goto L13;
        int r11 = r10 - 48;
    L24:
        if (((-1152921504606846976L) & r4) != 0) goto L27;
        r4 = (r4 << 4) | ((long) r11);
        r8 = r8 + 1;
        r0 = r0 + 1;
        goto L6
    L27:
        throw new NumberFormatException("Number too large: " + new e().l(r4).b(r10).u());
    L13:
        if (r10 < 97) goto L19;
        if (r10 > 102) goto L19;
        int r12 = r10 - 97;
    L17:
        r11 = r12 + 10;
    L19:
        if (r10 < 65) goto L28;
        if (r10 > 70) goto L28;
        r12 = r10 - 65;
    L28:
        if (r0 == 0) goto L31;
        r1 = true;
        goto L32
    L31:
        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + e.b.a(r10));
    L32:
        if (r8 != r9) goto L34;
        this.f38713a = r6.c();
        w.a(r6);
    L35:
        if (r1 == true) goto L38;
        if (this.f38713a != null) goto L5;
    L38:
        a(b() - ((long) r0));
        return r4;
    L34:
        r6.f38757c = r8;
        goto L35
    L41:
        throw new EOFException();
    }

    public h t() {
        return d(b());
    }

    @Override // e.g
    public h d(long r3) {
        if (r3 >= 0) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L19;
        if (b() < r3) goto L17;
        if (r3 < PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) goto L15;
        h r1 = g((int) r3);
        h(r3);
        return r1;
    L15:
        return new h(g(r3));
    L17:
        throw new EOFException();
    L19:
        throw new IllegalArgumentException(("byteCount: " + r3).toString());
    L5:
        if (r3 > 2147483647L) goto L7;
        r0 = true;
        goto L8
    }

    @Override // e.g
    public int a(r r4) {
        d.h.b.o.e(r4, "options");
        int r0 = e.a.a.a(this, r4, false, 2, null);
        if (r0 == (-1)) goto L7;
        h(r4.b()[r0].k());
        return r0;
    L7:
        return -1;
    }

    @Override // e.g
    public void b(e r3, long r4) {
        d.h.b.o.e(r3, "sink");
        if (b() < r4) goto L6;
        r3.a_(this, r4);
        return;
    L6:
        r3.a_(this, b());
        throw new EOFException();
    }

    @Override // e.g
    public String f(long r12) {
        if (r12 < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L25;
        long r1 = Long.MAX_VALUE;
        if (r12 == Long.MAX_VALUE) goto L11;
        r1 = r12 + 1;
    L11:
        long r5 = a((byte) 10, 0, r1);
        if (r5 == (-1)) goto L15;
        return e.a.a.a(this, r5);
    L15:
        if (r1 < b()) goto L17;
    L22:
        e r6 = new e();
        a(r6, 0, Math.min(32, b()));
        throw new EOFException("\\n not found: limit=" + Math.min(b(), r12) + " content=" + r6.t().i() + 8230);
    L17:
        if (c(r1 - 1) != 13) goto L22;
        if (c(r1) != 10) goto L22;
        return e.a.a.a(this, r1);
    L25:
        throw new IllegalArgumentException(("limit < 0: " + r12).toString());
    L5:
        r0 = false;
        goto L6
    }

    public byte[] w() {
        return g(b());
    }

    @Override // e.g
    public byte[] g(long r3) {
        if (r3 >= 0) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L16;
        if (b() < r3) goto L14;
        byte[] r4 = new byte[(int) r3];
        a(r4);
        return r4;
    L14:
        throw new EOFException();
    L16:
        throw new IllegalArgumentException(("byteCount: " + r3).toString());
    L5:
        if (r3 > 2147483647L) goto L7;
        r0 = true;
        goto L8
    }

    @Override // e.g
    public void a(byte[] r4) {
        d.h.b.o.e(r4, "sink");
        int r0 = 0;
    L4:
        if (r0 >= r4.length) goto L10;
        int r1 = a(r4, r0, r4.length - r0);
        if (r1 == (-1)) goto L9;
        r0 = r0 + r1;
        goto L4
    L9:
        throw new EOFException();
    }

    public int a(byte[] r8, int r9, int r10) {
        d.h.b.o.e(r8, "sink");
        e.b.a(r8.length, r9, r10);
        v r0 = this.f38713a;
        if (r0 != null) goto L5;
        return -1;
    L5:
        int r11 = Math.min(r10, r0.f38758d - r0.f38757c);
        d.a.i.a(r0.f38756b, r8, r9, r0.f38757c, r0.f38757c + r11);
        r0.f38757c += r11;
        a(b() - ((long) r11));
        if (r0.f38757c != r0.f38758d) goto L9;
        this.f38713a = r0.c();
        w.a(r0);
    L9:
        return r11;
    }

    public final void x() {
        h(b());
    }

    @Override // e.g
    public void h(long r7) {
    L3:
        if (r7 <= 0) goto L11;
        v r0 = this.f38713a;
        if (r0 == null) goto L10;
        int r1 = (int) Math.min(r7, r0.f38758d - r0.f38757c);
        long r4 = r1;
        a(b() - r4);
        r7 = r7 - r4;
        r0.f38757c += r1;
        if (r0.f38757c != r0.f38758d) goto L3;
        this.f38713a = r0.c();
        w.a(r0);
        goto L3
    L10:
        throw new EOFException();
    }

    public e a(h r3) {
        d.h.b.o.e(r3, "byteString");
        r3.a(this, 0, r3.k());
        return this;
    }

    public e a(String r13, int r14, int r15) {
        d.h.b.o.e(r13, WsChannelMultiProcessSharedProvider.STRING_TYPE);
        if (r14 < 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L58;
        if (r15 < r14) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L56;
        if (r15 > r13.length()) goto L14;
        boolean r4 = true;
    L15:
        if (r4 == false) goto L54;
    L16:
        if (r14 >= r15) goto L52;
        char r5 = r13.charAt(r14);
        if (r5 < 128) goto L19;
        if (r5 < 2048) goto L28;
        if (r5 < 55296) goto L51;
        if (r5 > 57343) goto L51;
        int r6 = r14 + 1;
        if (r6 >= r15) goto L38;
        char r8 = r13.charAt(r6);
    L40:
        if (r5 > 56319) goto L50;
        if (56320 <= r8) goto L44;
    L46:
        boolean r9 = false;
    L47:
        if (r9 == false) goto L50;
        int r7 = (((r5 & 1023) << 10) | (r8 & 1023)) + 65536;
        v r10 = f(4);
        r10.f38756b[r10.f38758d] = (byte) ((r7 >> 18) | 240);
        r10.f38756b[r10.f38758d + 1] = (byte) (((r7 >> 12) & 63) | 128);
        r10.f38756b[r10.f38758d + 2] = (byte) (((r7 >> 6) & 63) | 128);
        r10.f38756b[r10.f38758d + 3] = (byte) ((r7 & 63) | 128);
        r10.f38758d += 4;
        a(b() + 4);
        r14 = r14 + 2;
        goto L16
    L44:
        if (r8 >= 57344) goto L46;
        r9 = true;
    L50:
        b(63);
        r14 = r6;
        goto L16
    L38:
        r8 = 0;
    L51:
        v r11 = f(3);
        r11.f38756b[r11.f38758d] = (byte) ((r5 >> '\f') | 224);
        r11.f38756b[r11.f38758d + 1] = (byte) ((63 & (r5 >> 6)) | 128);
        r11.f38756b[r11.f38758d + 2] = (byte) ((r5 & '?') | 128);
        r11.f38758d += 3;
        a(b() + 3);
    L29:
        r14 = r14 + 1;
        goto L16
    L28:
        v r12 = f(2);
        r12.f38756b[r12.f38758d] = (byte) ((r5 >> 6) | 192);
        r12.f38756b[r12.f38758d + 1] = (byte) ((r5 & '?') | 128);
        r12.f38758d += 2;
        a(b() + 2);
        goto L29
    L19:
        v r16 = f(1);
        byte[] r17 = r16.f38756b;
        int r18 = r16.f38758d - r14;
        int r19 = Math.min(r15, 8192 - r18);
        int r20 = r14 + 1;
        r17[r14 + r18] = (byte) r5;
    L20:
        r14 = r20;
        if (r14 >= r19) goto L25;
        char r21 = r13.charAt(r14);
        if (r21 >= 128) goto L25;
        r20 = r14 + 1;
        r17[r14 + r18] = (byte) r21;
    L25:
        int r22 = (r18 + r14) - r16.f38758d;
        r16.f38758d += r22;
        a(b() + ((long) r22));
        goto L16
    L52:
        return this;
    L54:
        throw new IllegalArgumentException(("endIndex > string.length: " + r15 + " > " + r13.length()).toString());
    L14:
        r4 = false;
        goto L15
    L56:
        throw new IllegalArgumentException(("endIndex < beginIndex: " + r15 + " < " + r14).toString());
    L9:
        r3 = false;
        goto L10
    L58:
        throw new IllegalArgumentException(("beginIndex < 0: " + r14).toString());
    L5:
        r2 = false;
        goto L6
    }

    public e a(int r11) {
        if (r11 >= 128) goto L6;
        b(r11);
    L21:
        return this;
    L6:
        if (r11 >= 2048) goto L8;
        v r1 = f(2);
        r1.f38756b[r1.f38758d] = (byte) ((r11 >> 6) | 192);
        r1.f38756b[r1.f38758d + 1] = (byte) ((r11 & 63) | 128);
        r1.f38758d += 2;
        a(b() + 2);
        goto L21
    L8:
        boolean r5 = false;
        if (55296 <= r11) goto L11;
    L13:
        if (r5 == false) goto L16;
        b(63);
        goto L21
    L16:
        if (r11 >= 65536) goto L19;
        v r2 = f(3);
        r2.f38756b[r2.f38758d] = (byte) ((r11 >> 12) | 224);
        r2.f38756b[r2.f38758d + 1] = (byte) (((r11 >> 6) & 63) | 128);
        r2.f38756b[r2.f38758d + 2] = (byte) ((r11 & 63) | 128);
        r2.f38758d += 3;
        a(b() + 3);
        goto L21
    L19:
        if (r11 > 1114111) goto L23;
        v r6 = f(4);
        r6.f38756b[r6.f38758d] = (byte) ((r11 >> 18) | 240);
        r6.f38756b[r6.f38758d + 1] = (byte) (((r11 >> 12) & 63) | 128);
        r6.f38756b[r6.f38758d + 2] = (byte) (((r11 >> 6) & 63) | 128);
        r6.f38756b[r6.f38758d + 3] = (byte) ((r11 & 63) | 128);
        r6.f38758d += 4;
        a(b() + 4);
        goto L21
    L23:
        throw new IllegalArgumentException("Unexpected code point: 0x" + e.b.b(r11));
    L11:
        if (r11 >= 57344) goto L13;
        r5 = true;
        goto L13
    }

    public e b(byte[] r3) {
        d.h.b.o.e(r3, DBHelper.BATTERY_COL_SOURCE);
        return b(r3, 0, r3.length);
    }

    public e b(byte[] r10, int r11, int r12) {
        d.h.b.o.e(r10, DBHelper.BATTERY_COL_SOURCE);
        long r7 = r12;
        e.b.a(r10.length, r11, r7);
        int r13 = r12 + r11;
    L3:
        if (r11 >= r13) goto L5;
        v r0 = f(1);
        int r1 = Math.min(r13 - r11, 8192 - r0.f38758d);
        int r4 = r11 + r1;
        d.a.i.a(r10, r0.f38756b, r0.f38758d, r11, r4);
        r0.f38758d += r1;
        r11 = r4;
        goto L3
    L5:
        a(b() + r7);
        return this;
    }

    public long a(aa r7) {
        aa r8 = (aa) ZeusTransformUtils.wrapperContextForParams(r7, aa.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r8, DBHelper.BATTERY_COL_SOURCE);
        long r0 = 0;
    L3:
        long r2 = r8.a(this, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
        if (r2 == (-1)) goto L6;
        r0 = r0 + r2;
        goto L3
    L6:
        return r0;
    }

    public e b(int r5) {
        v r0 = f(1);
        byte[] r1 = r0.f38756b;
        int r2 = r0.f38758d;
        r0.f38758d = r2 + 1;
        r1[r2] = (byte) r5;
        a(b() + 1);
        return this;
    }

    public e c(int r6) {
        v r0 = f(2);
        byte[] r1 = r0.f38756b;
        int r2 = r0.f38758d;
        int r3 = r2 + 1;
        r1[r2] = (byte) ((r6 >>> 8) & 255);
        r1[r3] = (byte) (r6 & 255);
        r0.f38758d = r3 + 1;
        a(b() + 2);
        return this;
    }

    public e d(int r6) {
        v r0 = f(4);
        byte[] r1 = r0.f38756b;
        int r2 = r0.f38758d;
        int r3 = r2 + 1;
        r1[r2] = (byte) ((r6 >>> 24) & 255);
        int r4 = r3 + 1;
        r1[r3] = (byte) ((r6 >>> 16) & 255);
        int r5 = r4 + 1;
        r1[r4] = (byte) ((r6 >>> 8) & 255);
        r1[r5] = (byte) (r6 & 255);
        r0.f38758d = r5 + 1;
        a(b() + 4);
        return this;
    }

    public e i(long r10) {
        v r1 = f(8);
        byte[] r2 = r1.f38756b;
        int r3 = r1.f38758d;
        int r4 = r3 + 1;
        r2[r3] = (byte) ((r10 >>> 56) & 255);
        int r5 = r4 + 1;
        r2[r4] = (byte) ((r10 >>> 48) & 255);
        int r6 = r5 + 1;
        r2[r5] = (byte) ((r10 >>> 40) & 255);
        int r7 = r6 + 1;
        r2[r6] = (byte) ((r10 >>> 32) & 255);
        int r8 = r7 + 1;
        r2[r7] = (byte) ((r10 >>> 24) & 255);
        int r9 = r8 + 1;
        r2[r8] = (byte) ((r10 >>> 16) & 255);
        int r11 = r9 + 1;
        r2[r9] = (byte) ((r10 >>> 8) & 255);
        r2[r11] = (byte) (r10 & 255);
        r1.f38758d = r11 + 1;
        a(b() + 8);
        return this;
    }

    public e k(long r13) {
        if (r13 == 0) goto L77;
        boolean r3 = false;
        int r4 = 1;
        if (r13 >= 0) goto L12;
        r13 = -r13;
        if (r13 < 0) goto L78;
        r3 = true;
        goto L12
    L78:
        return a("-9223372036854775808");
    L12:
        if (r13 >= 100000000) goto L36;
        if (r13 >= 10000) goto L26;
        if (r13 >= 100) goto L22;
        if (r13 < 10) goto L66;
        r4 = 2;
    L66:
        if (r3 == false) goto L68;
        r4 = r4 + 1;
    L68:
        v r2 = f(r4);
        byte[] r6 = r2.f38756b;
        int r7 = r2.f38758d + r4;
    L70:
        if (r13 == 0) goto L72;
        long r8 = 10;
        r7 = r7 - 1;
        r6[r7] = e.a.a.a()[(int) (r13 % r8)];
        r13 = r13 / r8;
        goto L70
    L72:
        if (r3 == false) goto L74;
        r6[r7 - 1] = 45;
    L74:
        r2.f38758d += r4;
        a(b() + ((long) r4));
        return this;
    L22:
        if (r13 >= 1000) goto L24;
        r4 = 3;
        goto L66
    L24:
        r4 = 4;
        goto L66
    L26:
        if (r13 >= 1000000) goto L32;
        if (r13 >= 100000) goto L30;
        r4 = 5;
        goto L66
    L30:
        r4 = 6;
        goto L66
    L32:
        if (r13 >= 10000000) goto L34;
        r4 = 7;
        goto L66
    L34:
        r4 = 8;
        goto L66
    L36:
        if (r13 >= 1000000000000L) goto L48;
        if (r13 >= 10000000000L) goto L44;
        if (r13 >= 1000000000) goto L42;
        r4 = 9;
        goto L66
    L42:
        r4 = 10;
        goto L66
    L44:
        if (r13 >= 100000000000L) goto L46;
        r4 = 11;
        goto L66
    L46:
        r4 = 12;
        goto L66
    L48:
        if (r13 >= 1000000000000000L) goto L57;
        if (r13 >= 10000000000000L) goto L53;
        r4 = 13;
        goto L66
    L53:
        if (r13 >= 100000000000000L) goto L55;
        r4 = 14;
        goto L66
    L55:
        r4 = 15;
        goto L66
    L57:
        if (r13 >= 100000000000000000L) goto L63;
        if (r13 >= 10000000000000000L) goto L61;
        r4 = 16;
        goto L66
    L61:
        r4 = 17;
        goto L66
    L63:
        if (r13 >= 1000000000000000000L) goto L65;
        r4 = 18;
        goto L66
    L65:
        r4 = 19;
        goto L66
    L77:
        return b(48);
    }

    public e l(long r13) {
        if (r13 == 0) goto L11;
        long r1 = (r13 >>> 1) | r13;
        long r2 = r1 | (r1 >>> 2);
        long r3 = r2 | (r2 >>> 4);
        long r4 = r3 | (r3 >>> 8);
        long r5 = r4 | (r4 >>> 16);
        long r6 = r5 | (r5 >>> 32);
        long r7 = r6 - ((r6 >>> 1) & 6148914691236517205L);
        long r8 = ((r7 >>> 2) & 3689348814741910323L) + (r7 & 3689348814741910323L);
        long r9 = ((r8 >>> 4) + r8) & 1085102592571150095L;
        long r10 = r9 + (r9 >>> 8);
        long r11 = r10 + (r10 >>> 16);
        int r12 = (int) ((((r11 & 63) + ((r11 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        v r14 = f(r12);
        byte[] r15 = r14.f38756b;
        int r16 = (r14.f38758d + r12) - 1;
        int r0 = r14.f38758d;
    L6:
        if (r16 < r0) goto L8;
        r15[r16] = e.a.a.a()[(int) (15 & r13)];
        r13 = r13 >>> 4;
        r16 = r16 - 1;
        goto L6
    L8:
        r14.f38758d += r12;
        a(b() + ((long) r12));
        return this;
    L11:
        return b(48);
    }

    public final v f(int r3) {
        boolean r1 = true;
        if (r3 < 1) goto L6;
        if (r3 > 8192) goto L6;
    L7:
        if (r1 == false) goto L19;
        v r2 = this.f38713a;
        if (r2 != null) goto L11;
        v r4 = w.a();
        this.f38713a = r4;
        r4.h = r4;
        r4.g = r4;
        return r4;
    L11:
        d.h.b.o.a(r2);
        v r5 = r2.h;
        d.h.b.o.a(r5);
        if ((r5.f38758d + r3) <= 8192) goto L14;
    L15:
        r5 = r5.a(w.a());
    L17:
        return r5;
    L14:
        if (r5.f == true) goto L17;
    L19:
        throw new IllegalArgumentException("unexpected capacity".toString());
    L6:
        r1 = false;
        goto L7
    }

    @Override // e.y
    public void a_(e r9, long r10) {
        d.h.b.o.e(r9, DBHelper.BATTERY_COL_SOURCE);
        if (r9 == this) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L34;
        e.b.a(r9.b(), 0, r10);
    L9:
        if (r10 <= 0) goto L39;
        v r2 = r9.f38713a;
        d.h.b.o.a(r2);
        int r3 = r2.f38758d;
        v r4 = r9.f38713a;
        d.h.b.o.a(r4);
        if (r10 >= (r3 - r4.f38757c)) goto L27;
        v r5 = this.f38713a;
        if (r5 == null) goto L15;
        d.h.b.o.a(r5);
        v r6 = r5.h;
    L16:
        if (r6 != null) goto L18;
    L26:
        v r7 = r9.f38713a;
        d.h.b.o.a(r7);
        r9.f38713a = r7.a((int) r10);
        goto L27
    L18:
        if (r6.f == false) goto L26;
        long r8 = ((long) r6.f38758d) + r10;
        if (r6.f38759e == false) goto L22;
        int r11 = 0;
    L24:
        if ((r8 - ((long) r11)) > PlaybackStateCompat.ACTION_PLAY_FROM_URI) goto L26;
        v r0 = r9.f38713a;
        d.h.b.o.a(r0);
        r0.a(r6, (int) r10);
        r9.a(r9.b() - r10);
        a(b() + r10);
        return;
    L22:
        r11 = r6.f38757c;
        goto L24
    L15:
        r6 = null;
    L27:
        v r12 = r9.f38713a;
        d.h.b.o.a(r12);
        long r13 = r12.f38758d - r12.f38757c;
        r9.f38713a = r12.c();
        v r14 = this.f38713a;
        if (r14 != null) goto L30;
        this.f38713a = r12;
        r12.h = r12;
        r12.g = r12.h;
    L31:
        r9.a(r9.b() - r13);
        a(b() + r13);
        r10 = r10 - r13;
        goto L9
    L30:
        d.h.b.o.a(r14);
        v r15 = r14.h;
        d.h.b.o.a(r15);
        r15.a(r12).d();
        goto L31
    L39:
        return;
    L34:
        throw new IllegalArgumentException("source == this".toString());
    L5:
        r1 = false;
        goto L6
    }

    @Override // e.aa
    public long a(e r5, long r6) {
        d.h.b.o.e(r5, "sink");
        if (r6 < 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L16;
        if (b() != 0) goto L11;
        return -1;
    L11:
        if (r6 <= b()) goto L13;
        r6 = b();
    L13:
        r5.a_(this, r6);
        return r6;
    L16:
        throw new IllegalArgumentException(("byteCount < 0: " + r6).toString());
    L5:
        r2 = false;
        goto L6
    }

    public long a(byte r10, long r11, long r13) {
        long r0 = 0;
        boolean r3 = false;
        if (0 <= r11) goto L5;
    L7:
        if (r3 == false) goto L50;
        if (r13 <= b()) goto L12;
        r13 = b();
    L12:
        if (r11 == r13) goto L59;
        v r2 = this.f38713a;
        if (r2 != null) goto L18;
        return -1;
    L18:
        if ((b() - r11) >= r11) goto L34;
        r0 = b();
    L21:
        if (r0 <= r11) goto L23;
        r2 = r2.h;
        d.h.b.o.a(r2);
        r0 = r0 - ((long) (r2.f38758d - r2.f38757c));
        goto L21
    L23:
        if (r2 != null) goto L26;
        return -1;
    L26:
        if (r0 >= r13) goto L63;
        byte[] r9 = r2.f38756b;
        int r5 = (int) Math.min(r2.f38758d, (((long) r2.f38757c) + r13) - r0);
        int r12 = (int) ((((long) r2.f38757c) + r11) - r0);
    L28:
        if (r12 >= r5) goto L33;
        if (r9[r12] == r10) goto L48;
        r12 = r12 + 1;
    L48:
        return ((long) (r12 - r2.f38757c)) + r0;
    L33:
        r0 = r0 + ((long) (r2.f38758d - r2.f38757c));
        r2 = r2.g;
        d.h.b.o.a(r2);
        r11 = r0;
        goto L26
    L63:
        return -1;
    L34:
        long r6 = ((long) (r2.f38758d - r2.f38757c)) + r0;
        if (r6 > r11) goto L37;
        r2 = r2.g;
        d.h.b.o.a(r2);
        r0 = r6;
        goto L34
    L37:
        if (r2 != null) goto L40;
        return -1;
    L40:
        if (r0 >= r13) goto L64;
        byte[] r14 = r2.f38756b;
        int r7 = (int) Math.min(r2.f38758d, (((long) r2.f38757c) + r13) - r0);
        r12 = (int) ((((long) r2.f38757c) + r11) - r0);
    L42:
        if (r12 >= r7) goto L47;
        if (r14[r12] == r10) goto L48;
        r12 = r12 + 1;
        goto L42
    L47:
        r0 = r0 + ((long) (r2.f38758d - r2.f38757c));
        r2 = r2.g;
        d.h.b.o.a(r2);
        r11 = r0;
        goto L40
    L64:
        return -1;
    L59:
        return -1;
    L50:
        throw new IllegalArgumentException(("size=" + b() + " fromIndex=" + r11 + " toIndex=" + r13).toString());
    L5:
        if (r11 > r13) goto L7;
        r3 = true;
        goto L7
    }

    public long a(h r12, long r13) {
        d.h.b.o.e(r12, "targetBytes");
        long r0 = 0;
        if (r13 < 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L79;
        v r3 = this.f38713a;
        if (r3 != null) goto L11;
        return -1;
    L11:
        if ((b() - r13) >= r13) goto L44;
        r0 = b();
    L14:
        if (r0 <= r13) goto L16;
        r3 = r3.h;
        d.h.b.o.a(r3);
        r0 = r0 - ((long) (r3.f38758d - r3.f38757c));
        goto L14
    L16:
        if (r3 != null) goto L19;
        return -1;
    L19:
        if (r12.k() != 2) goto L31;
        byte r4 = r12.c(0);
        byte r14 = r12.c(1);
    L22:
        if (r0 >= b()) goto L101;
        byte[] r5 = r3.f38756b;
        int r15 = (int) ((((long) r3.f38757c) + r13) - r0);
        int r16 = r3.f38758d;
    L24:
        if (r15 >= r16) goto L30;
        byte r7 = r5[r15];
        if (r7 == r4) goto L61;
        if (r7 == r14) goto L61;
        r15 = r15 + 1;
    L61:
        int r11 = r3.f38757c;
    L77:
        return ((long) (r15 - r11)) + r0;
    L30:
        r0 = r0 + ((long) (r3.f38758d - r3.f38757c));
        r3 = r3.g;
        d.h.b.o.a(r3);
        r13 = r0;
        goto L22
    L101:
        return -1;
    L31:
        byte[] r17 = r12.n();
    L33:
        if (r0 >= b()) goto L102;
        byte[] r6 = r3.f38756b;
        r15 = (int) ((((long) r3.f38757c) + r13) - r0);
        int r18 = r3.f38758d;
    L35:
        if (r15 >= r18) goto L43;
        byte r8 = r6[r15];
        int r9 = r17.length;
        int r10 = 0;
    L37:
        if (r10 >= r9) goto L42;
        if (r8 == r17[r10]) goto L73;
        r10 = r10 + 1;
    L73:
        r11 = r3.f38757c;
        goto L77
    L42:
        r15 = r15 + 1;
        goto L35
    L43:
        r0 = r0 + ((long) (r3.f38758d - r3.f38757c));
        r3 = r3.g;
        d.h.b.o.a(r3);
        r13 = r0;
        goto L33
    L102:
        return -1;
    L44:
        long r19 = ((long) (r3.f38758d - r3.f38757c)) + r0;
        if (r19 > r13) goto L47;
        r3 = r3.g;
        d.h.b.o.a(r3);
        r0 = r19;
        goto L44
    L47:
        if (r3 != null) goto L50;
        return -1;
    L50:
        if (r12.k() != 2) goto L64;
        byte r20 = r12.c(0);
        byte r110 = r12.c(1);
    L53:
        if (r0 >= b()) goto L103;
        byte[] r21 = r3.f38756b;
        r15 = (int) ((((long) r3.f38757c) + r13) - r0);
        int r111 = r3.f38758d;
    L55:
        if (r15 >= r111) goto L63;
        byte r22 = r21[r15];
        if (r22 == r20) goto L61;
        if (r22 == r110) goto L61;
        r15 = r15 + 1;
        goto L55
    L63:
        r0 = r0 + ((long) (r3.f38758d - r3.f38757c));
        r3 = r3.g;
        d.h.b.o.a(r3);
        r13 = r0;
        goto L53
    L103:
        return -1;
    L64:
        byte[] r112 = r12.n();
    L66:
        if (r0 >= b()) goto L104;
        byte[] r23 = r3.f38756b;
        r15 = (int) ((((long) r3.f38757c) + r13) - r0);
        int r113 = r3.f38758d;
    L68:
        if (r15 >= r113) goto L76;
        byte r24 = r23[r15];
        int r25 = r112.length;
        int r26 = 0;
    L70:
        if (r26 >= r25) goto L75;
        if (r24 == r112[r26]) goto L73;
        r26 = r26 + 1;
        goto L70
    L75:
        r15 = r15 + 1;
        goto L68
    L76:
        r0 = r0 + ((long) (r3.f38758d - r3.f38757c));
        r3 = r3.g;
        d.h.b.o.a(r3);
        r13 = r0;
        goto L66
    L104:
        return -1;
    L79:
        throw new IllegalArgumentException(("fromIndex < 0: " + r13).toString());
    L5:
        r2 = false;
        goto L6
    }

    public boolean equals(Object r20) {
        if (this != r20) goto L6;
    L31:
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r20, e.class) == true) goto L9;
        return false;
    L9:
        if (b() == ((e) ZeusTransformUtils.preCheckCast(r20, e.class, "com.obric.aiagent.plugin")).b()) goto L12;
        return false;
    L12:
        if (b() == 0) goto L31;
        v r5 = this.f38713a;
        d.h.b.o.a(r5);
        v r1 = ((e) ZeusTransformUtils.preCheckCast(r20, e.class, "com.obric.aiagent.plugin")).f38713a;
        d.h.b.o.a(r1);
        int r2 = r5.f38757c;
        int r6 = r1.f38757c;
        long r10 = 0;
    L16:
        if (r10 >= b()) goto L31;
        long r12 = Math.min(r5.f38758d - r2, r1.f38758d - r6);
        long r14 = 0;
    L19:
        if (r14 >= r12) goto L25;
        int r16 = r2 + 1;
        int r17 = r6 + 1;
        if (r5.f38756b[r2] != r1.f38756b[r6]) goto L39;
        r14 = r14 + 1;
        r2 = r16;
        r6 = r17;
        goto L19
    L39:
        return false;
    L25:
        if (r2 != r5.f38758d) goto L28;
        v r3 = r5.g;
        d.h.b.o.a(r3);
        r5 = r3;
        r2 = r3.f38757c;
    L28:
        if (r6 != r1.f38758d) goto L30;
        r1 = r1.g;
        d.h.b.o.a(r1);
        r6 = r1.f38757c;
    L30:
        r10 = r10 + r12;
        goto L16
    }

    public int hashCode() {
        v r0 = this.f38713a;
        if (r0 != null) goto L5;
        return 0;
    L5:
        int r1 = 1;
    L6:
        int r2 = r0.f38757c;
        int r3 = r0.f38758d;
    L7:
        if (r2 >= r3) goto L9;
        r1 = (r1 * 31) + r0.f38756b[r2];
        r2 = r2 + 1;
        goto L7
    L9:
        r0 = r0.g;
        d.h.b.o.a(r0);
        if (r0 != this.f38713a) goto L6;
        return r1;
    }

    public final e y() {
        e r0 = new e();
        if (b() == 0) goto L9;
        v r1 = this.f38713a;
        d.h.b.o.a(r1);
        v r2 = r1.a();
        r0.f38713a = r2;
        r2.h = r2;
        r2.g = r2.h;
        v r3 = r1.g;
    L6:
        if (r3 == r1) goto L8;
        v r4 = r2.h;
        d.h.b.o.a(r4);
        d.h.b.o.a(r3);
        r4.a(r3.a());
        r3 = r3.g;
        goto L6
    L8:
        r0.a(b());
    L9:
        return r0;
    }

    public final h A() {
        if (b() > 2147483647L) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        return g((int) b());
    L10:
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + b()).toString());
    L5:
        r0 = false;
        goto L6
    }

    public final h g(int r8) {
        if (r8 == 0) goto L20;
        e.b.a(b(), 0, r8);
        v r0 = this.f38713a;
        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
    L5:
        if (r2 >= r8) goto L11;
        d.h.b.o.a(r0);
        if (r0.f38758d == r0.f38757c) goto L10;
        r2 = r2 + (r0.f38758d - r0.f38757c);
        r3 = r3 + 1;
        r0 = r0.g;
        goto L5
    L10:
        throw new AssertionError("s.limit == s.pos");
    L11:
        byte[][] r4 = new byte[r3][];
        int[] r5 = new int[r3 * 2];
        v r7 = this.f38713a;
        int r6 = 0;
    L13:
        if (r1 >= r8) goto L16;
        d.h.b.o.a(r7);
        r4[r6] = r7.f38756b;
        r1 = r1 + (r7.f38758d - r7.f38757c);
        r5[r6] = Math.min(r1, r8);
        r5[((Object[]) ZeusTransformUtils.preCheckCast(r4, Object[].class, "com.obric.aiagent.plugin")).length + r6] = r7.f38757c;
        r7.f38759e = true;
        r6 = r6 + 1;
        r7 = r7.g;
        goto L13
    L16:
        return (h) ZeusTransformUtils.preCheckCast(new x(r4, r5), h.class, "com.obric.aiagent.plugin");
    L20:
        return h.f38723b;
    }
}

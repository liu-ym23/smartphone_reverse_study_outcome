package okio;

import com.bytedance.apm.battery.config.BatteryFactorConfig;
import com.bytedance.sysoptimizer.StackLeakChecker;
import com.bytedanceos.common.model.database.columns.DownloadInfoColumns;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import com.ttnet.org.chromium.net.PrivateKeyType;
import fg.j;
import fg.k;
import fg.m;
import fg.p;
import java.io.Closeable;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.util.Arrays;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.x;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes4.dex */
public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f23018c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f23019d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p f23020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f23021b;

    public static final class UnsafeCursor implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Buffer f23022a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f23023b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public p f23024c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f23025d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public byte[] f23026e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f23027f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f23028g;

        public UnsafeCursor() {
            this.f23025d = -1;
            this.f23027f = -1;
            this.f23028g = -1;
        }

        public final int a() {
            long r10 = this.f23025d;
            Buffer r11 = this.f23022a;
            if (r11 != null) goto L6;
            q.s();
        L6:
            if (r10 == r11.size()) goto L14;
            long r12 = this.f23025d;
            if (r12 != (-1)) goto L11;
            long r13 = 0;
        L12:
            return b(r13);
        L11:
            r13 = r12 + ((long) (this.f23028g - this.f23027f));
            goto L12
        L14:
            throw new IllegalStateException("no more bytes");
        }

        public final int b(long r12) {
            Buffer r10 = this.f23022a;
            if (r10 == null) goto L62;
            if (r12 >= (-1)) goto L7;
        L59:
            x r11 = x.f21192a;
            String r13 = String.format("offset=%s > size=%s", Arrays.copyOf(new Object[]{Long.valueOf(r12), Long.valueOf(r10.size())}, 2));
            q.c(r13, "java.lang.String.format(format, *args)");
            throw new ArrayIndexOutOfBoundsException(r13);
        L7:
            if (r12 > r10.size()) goto L59;
            if (r12 != (-1)) goto L11;
        L57:
            this.f23024c = null;
            this.f23025d = r12;
            this.f23026e = null;
            this.f23027f = -1;
            this.f23028g = -1;
            return -1;
        L11:
            if (r12 == r10.size()) goto L57;
            long r14 = r10.size();
            p r15 = r10.f23020a;
            p r16 = this.f23024c;
            long r17 = 0;
            if (r16 == null) goto L22;
            long r18 = this.f23025d;
            int r19 = this.f23027f;
            if (r16 != null) goto L18;
            q.s();
        L18:
            long r20 = r18 - ((long) (r19 - r16.f19717b));
            if (r20 <= r12) goto L21;
            p r21 = r15;
            r15 = this.f23024c;
            r14 = r20;
        L24:
            if ((r14 - r12) <= (r12 - r17)) goto L31;
        L25:
            if (r21 != null) goto L27;
            q.s();
        L27:
            int r22 = r21.f19718c;
            int r23 = r21.f19717b;
            if (r12 < (((long) (r22 - r23)) + r17)) goto L40;
            r17 = r17 + ((long) (r22 - r23));
            r21 = r21.f19721f;
        L40:
            if (this.f23023b == false) goto L52;
            if (r21 != null) goto L44;
            q.s();
        L44:
            if (r21.f19719d == false) goto L52;
            p r24 = r21.f();
            if (r10.f23020a != r21) goto L48;
            r10.f23020a = r24;
        L48:
            r21 = r21.c(r24);
            p r25 = r21.f19722g;
            if (r25 != null) goto L51;
            q.s();
        L51:
            r25.b();
        L52:
            this.f23024c = r21;
            this.f23025d = r12;
            if (r21 != null) goto L55;
            q.s();
        L55:
            this.f23026e = r21.f19716a;
            int r26 = r21.f19717b + ((int) (r12 - r17));
            this.f23027f = r26;
            int r110 = r21.f19718c;
            this.f23028g = r110;
            return r110 - r26;
        L31:
            if (r14 <= r12) goto L38;
            if (r15 != null) goto L34;
            q.s();
        L34:
            r15 = r15.f19722g;
            if (r15 != null) goto L37;
            q.s();
        L37:
            r14 = r14 - ((long) (r15.f19718c - r15.f19717b));
            goto L31
        L38:
            r17 = r14;
            r21 = r15;
            goto L40
        L21:
            r21 = this.f23024c;
            r17 = r20;
            goto L24
        L22:
            r21 = r15;
            goto L24
        L62:
            throw new IllegalStateException("not attached to a buffer");
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f23022a == null) goto L7;
            this.f23022a = null;
            this.f23024c = null;
            this.f23025d = -1;
            this.f23026e = null;
            this.f23027f = -1;
            this.f23028g = -1;
            return;
        L7:
            throw new IllegalStateException("not attached to a buffer");
        }
    }

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    public static final class b extends InputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Buffer f23029a;

        public b(Buffer r10) {
            this.f23029a = r10;
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) Math.min(this.f23029a.size(), Channel.UNLIMITED);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.f23029a.size() > 0) goto L7;
            return -1;
        L7:
            return this.f23029a.readByte() & UnsignedBytes.MAX_VALUE;
        }

        public String toString() {
            return this.f23029a + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] r10, int r11, int r12) {
            q.h(r10, "sink");
            return this.f23029a.read(r10, r11, r12);
        }
    }

    public static final class c extends OutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Buffer f23030a;

        public c(Buffer r10) {
            this.f23030a = r10;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
        }

        public String toString() {
            return this.f23030a + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int r10) {
            this.f23030a.t(r10);
        }

        @Override // java.io.OutputStream
        public void write(byte[] r10, int r11, int r12) {
            q.h(r10, "data");
            this.f23030a.s(r10, r11, r12);
        }
    }

    static {
        f23019d = new a(null);
        byte[] r10 = "0123456789abcdef".getBytes(kotlin.text.c.f21252b);
        q.c(r10, "(this as java.lang.String).getBytes(charset)");
        f23018c = r10;
    }

    public Buffer() {
    }

    public static /* bridge */ /* synthetic */ int l(Buffer r10, k r11, boolean r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = false;
    L6:
        return r10.k(r11, r12);
    }

    public Buffer A(int r10) {
        p r11 = p(2);
        byte[] r12 = r11.f19716a;
        int r13 = r11.f19718c;
        r12[r13] = (byte) ((r10 >>> 8) & PrivateKeyType.INVALID);
        r12[r13 + 1] = (byte) (r10 & PrivateKeyType.INVALID);
        r11.f19718c = r13 + 2;
        this.f23021b += 2;
        return this;
    }

    public Buffer B(int r10) {
        return A(fg.c.e((short) r10));
    }

    public Buffer C(String r10, int r11, int r12, Charset r13) {
        q.h(r10, "string");
        q.h(r13, "charset");
        if (r11 < 0) goto L22;
        if (r12 < r11) goto L20;
        if (r12 > r10.length()) goto L18;
        if (q.b(r13, kotlin.text.c.f21252b) == true) goto L10;
        String r14 = r10.substring(r11, r12);
        q.c(r14, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        if (r14 == null) goto L16;
        byte[] r15 = r14.getBytes(r13);
        q.c(r15, "(this as java.lang.String).getBytes(charset)");
        return s(r15, 0, r15.length);
    L16:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L10:
        return F(r10, r11, r12);
    L18:
        throw new IllegalArgumentException(("endIndex > string.length: " + r12 + " > " + r10.length()).toString());
    L20:
        throw new IllegalArgumentException(("endIndex < beginIndex: " + r12 + " < " + r11).toString());
    L22:
        throw new IllegalArgumentException(("beginIndex < 0: " + r11).toString());
    }

    public Buffer D(String r10, Charset r11) {
        q.h(r10, "string");
        q.h(r11, "charset");
        return C(r10, 0, r10.length(), r11);
    }

    public Buffer E(String r10) {
        q.h(r10, "string");
        return F(r10, 0, r10.length());
    }

    public Buffer F(String r10, int r11, int r12) {
        q.h(r10, "string");
        if (r11 < 0) goto L45;
        if (r12 < r11) goto L43;
        if (r12 > r10.length()) goto L41;
    L7:
        if (r11 >= r12) goto L39;
        char r13 = r10.charAt(r11);
        if (r13 < 128) goto L10;
        if (r13 < 2048) goto L19;
        if (r13 < 55296) goto L38;
        if (r13 > 57343) goto L38;
        int r14 = r11 + 1;
        if (r14 >= r12) goto L29;
        char r15 = r10.charAt(r14);
    L31:
        if (r13 > 56319) goto L37;
        if (56320 > r15) goto L37;
        if (57343 < r15) goto L37;
        int r16 = (((r13 & 1023) << 10) | (r15 & 1023)) + 65536;
        p r17 = p(4);
        byte[] r18 = r17.f19716a;
        int r19 = r17.f19718c;
        r18[r19] = (byte) ((r16 >> 18) | 240);
        r18[r19 + 1] = (byte) (((r16 >> 12) & 63) | 128);
        r18[r19 + 2] = (byte) (((r16 >> 6) & 63) | 128);
        r18[r19 + 3] = (byte) ((r16 & 63) | 128);
        r17.f19718c = r19 + 4;
        this.f23021b += 4;
        r11 = r11 + 2;
    L37:
        t(63);
        r11 = r14;
        goto L7
    L29:
        r15 = 0;
    L38:
        p r20 = p(3);
        byte[] r21 = r20.f19716a;
        int r22 = r20.f19718c;
        r21[r22] = (byte) ((r13 >> '\f') | 224);
        r21[r22 + 1] = (byte) ((63 & (r13 >> 6)) | 128);
        r21[r22 + 2] = (byte) ((r13 & '?') | 128);
        r20.f19718c = r22 + 3;
        this.f23021b += 3;
    L20:
        r11 = r11 + 1;
        goto L7
    L19:
        p r23 = p(2);
        byte[] r24 = r23.f19716a;
        int r25 = r23.f19718c;
        r24[r25] = (byte) ((r13 >> 6) | 192);
        r24[r25 + 1] = (byte) ((r13 & '?') | 128);
        r23.f19718c = r25 + 2;
        this.f23021b += 2;
        goto L20
    L10:
        p r26 = p(1);
        byte[] r27 = r26.f19716a;
        int r28 = r26.f19718c - r11;
        int r29 = Math.min(r12, 8192 - r28);
        int r30 = r11 + 1;
        r27[r11 + r28] = (byte) r13;
    L11:
        if (r30 >= r29) goto L16;
        char r110 = r10.charAt(r30);
        if (r110 >= 128) goto L16;
        r27[r30 + r28] = (byte) r110;
        r30 = r30 + 1;
    L16:
        int r111 = r26.f19718c;
        int r31 = (r28 + r30) - r111;
        r26.f19718c = r111 + r31;
        this.f23021b += (long) r31;
        r11 = r30;
        goto L7
    L39:
        return this;
    L41:
        throw new IllegalArgumentException(("endIndex > string.length: " + r12 + " > " + r10.length()).toString());
    L43:
        throw new IllegalArgumentException(("endIndex < beginIndex: " + r12 + " < " + r11).toString());
    L45:
        throw new IllegalArgumentException(("beginIndex < 0: " + r11).toString());
    }

    public Buffer G(int r10) {
        if (r10 >= 128) goto L6;
        t(r10);
    L20:
        return this;
    L6:
        if (r10 >= 2048) goto L9;
        p r11 = p(2);
        byte[] r12 = r11.f19716a;
        int r13 = r11.f19718c;
        r12[r13] = (byte) ((r10 >> 6) | 192);
        r12[r13 + 1] = (byte) ((r10 & 63) | 128);
        r11.f19718c = r13 + 2;
        this.f23021b += 2;
        goto L20
    L9:
        if (55296 > r10) goto L15;
        if (57343 < r10) goto L15;
        t(63);
    L15:
        if (r10 >= 65536) goto L18;
        p r14 = p(3);
        byte[] r15 = r14.f19716a;
        int r16 = r14.f19718c;
        r15[r16] = (byte) ((r10 >> 12) | 224);
        r15[r16 + 1] = (byte) (((r10 >> 6) & 63) | 128);
        r15[r16 + 2] = (byte) ((r10 & 63) | 128);
        r14.f19718c = r16 + 3;
        this.f23021b += 3;
        goto L20
    L18:
        if (r10 > 1114111) goto L22;
        p r17 = p(4);
        byte[] r18 = r17.f19716a;
        int r19 = r17.f19718c;
        r18[r19] = (byte) ((r10 >> 18) | 240);
        r18[r19 + 1] = (byte) (((r10 >> 12) & 63) | 128);
        r18[r19 + 2] = (byte) (((r10 >> 6) & 63) | 128);
        r18[r19 + 3] = (byte) ((r10 & 63) | 128);
        r17.f19718c = r19 + 4;
        this.f23021b += 4;
        goto L20
    L22:
        throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(r10));
    }

    public final void a() {
        skip(this.f23021b);
    }

    public Buffer b() {
        Buffer r10 = new Buffer();
        if (this.f23021b != 0) goto L5;
        return r10;
    L5:
        p r11 = this.f23020a;
        if (r11 != null) goto L8;
        q.s();
    L8:
        p r12 = r11.d();
        r10.f23020a = r12;
        if (r12 != null) goto L11;
        q.s();
    L11:
        p r13 = r10.f23020a;
        r12.f19722g = r13;
        if (r13 != null) goto L14;
        q.s();
    L14:
        p r14 = r10.f23020a;
        if (r14 != null) goto L17;
        q.s();
    L17:
        r13.f19721f = r14.f19722g;
        p r15 = this.f23020a;
        if (r15 != null) goto L20;
        q.s();
    L20:
        p r16 = r15.f19721f;
    L22:
        if (r16 == this.f23020a) goto L32;
        p r17 = r10.f23020a;
        if (r17 != null) goto L26;
        q.s();
    L26:
        p r18 = r17.f19722g;
        if (r18 != null) goto L29;
        q.s();
    L29:
        if (r16 != null) goto L31;
        q.s();
    L31:
        r18.c(r16.d());
        r16 = r16.f19721f;
        goto L22
    L32:
        r10.f23021b = this.f23021b;
        return r10;
    }

    @Override // okio.BufferedSource
    public Buffer buffer() {
        return this;
    }

    public final long c() {
        long r10 = this.f23021b;
        if (r10 != 0) goto L5;
        return 0;
    L5:
        p r11 = this.f23020a;
        if (r11 != null) goto L8;
        q.s();
    L8:
        p r12 = r11.f19722g;
        if (r12 != null) goto L11;
        q.s();
    L11:
        int r13 = r12.f19718c;
        if (r13 < 8192) goto L14;
        return r10;
    L14:
        if (r12.f19720e == true) goto L16;
        return r10;
    L16:
        return r10 - ((long) (r13 - r12.f19717b));
    }

    public /* bridge */ /* synthetic */ Object clone() {
        return b();
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public final Buffer d(Buffer r10, long r11, long r12) {
        q.h(r10, "out");
        fg.c.b(this.f23021b, r11, r12);
        if (r12 != 0) goto L5;
        return this;
    L5:
        r10.f23021b += r12;
        p r13 = this.f23020a;
    L6:
        if (r13 != null) goto L8;
        q.s();
    L8:
        int r14 = r13.f19718c;
        int r15 = r13.f19717b;
        if (r11 < (r14 - r15)) goto L12;
        r11 = r11 - ((long) (r14 - r15));
        r13 = r13.f19721f;
    L12:
        if (r12 <= 0) goto L25;
        if (r13 != null) goto L15;
        q.s();
    L15:
        p r16 = r13.d();
        int r17 = r16.f19717b + ((int) r11);
        r16.f19717b = r17;
        r16.f19718c = Math.min(r17 + ((int) r12), r16.f19718c);
        p r18 = r10.f23020a;
        if (r18 != null) goto L18;
        r16.f19722g = r16;
        r16.f19721f = r16;
        r10.f23020a = r16;
    L24:
        r12 = r12 - ((long) (r16.f19718c - r16.f19717b));
        r13 = r13.f19721f;
        r11 = 0;
        goto L12
    L18:
        if (r18 != null) goto L20;
        q.s();
    L20:
        p r19 = r18.f19722g;
        if (r19 != null) goto L23;
        q.s();
    L23:
        r19.c(r16);
        goto L24
    L25:
        return this;
    }

    public Buffer e() {
        return this;
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink emit() {
        return e();
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink emitCompleteSegments() {
        return f();
    }

    public boolean equals(Object r19) {
        if (this != r19) goto L6;
        return true;
    L6:
        if ((r19 instanceof Buffer) == true) goto L8;
        return false;
    L8:
        long r10 = this.f23021b;
        Buffer r11 = (Buffer) r19;
        if (r10 == r11.f23021b) goto L12;
        return false;
    L12:
        if (r10 != 0) goto L14;
        return true;
    L14:
        p r12 = this.f23020a;
        if (r12 != null) goto L17;
        q.s();
    L17:
        p r13 = r11.f23020a;
        if (r13 != null) goto L20;
        q.s();
    L20:
        int r14 = r12.f19717b;
        int r15 = r13.f19717b;
        long r16 = 0;
    L22:
        if (r16 >= this.f23021b) goto L43;
        long r17 = Math.min(r12.f19718c - r14, r13.f19718c - r15);
        long r18 = 0;
    L25:
        if (r18 >= r17) goto L31;
        int r110 = r14 + 1;
        int r111 = r15 + 1;
        if (r12.f19716a[r14] != r13.f19716a[r15]) goto L28;
        r18 = r18 + 1;
        r14 = r110;
        r15 = r111;
        goto L25
    L28:
        return false;
    L31:
        if (r14 != r12.f19718c) goto L37;
        r12 = r12.f19721f;
        if (r12 != null) goto L35;
        q.s();
    L35:
        r14 = r12.f19717b;
    L37:
        if (r15 != r13.f19718c) goto L42;
        r13 = r13.f19721f;
        if (r13 != null) goto L41;
        q.s();
    L41:
        r15 = r13.f19717b;
    L42:
        r16 = r16 + r17;
        goto L22
    L43:
        return true;
    }

    @Override // okio.BufferedSource
    public boolean exhausted() {
        if (this.f23021b != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public Buffer f() {
        return this;
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() {
    }

    public final byte g(long r10) {
        fg.c.b(this.f23021b, r10, 1);
        p r11 = this.f23020a;
        if (r11 != null) goto L5;
        q.s();
        throw null;
    L5:
        if ((size() - r10) >= r10) goto L15;
        long r12 = size();
    L8:
        if (r12 <= r10) goto L14;
        r11 = r11.f19722g;
        if (r11 != null) goto L12;
        q.s();
    L12:
        r12 = r12 - ((long) (r11.f19718c - r11.f19717b));
        goto L8
    L14:
        return r11.f19716a[(int) ((((long) r11.f19717b) + r10) - r12)];
    L15:
        long r13 = 0;
    L16:
        int r14 = r11.f19718c;
        int r15 = r11.f19717b;
        long r16 = ((long) (r14 - r15)) + r13;
        if (r16 > r10) goto L19;
        r11 = r11.f19721f;
        if (r11 != null) goto L23;
        q.s();
    L23:
        r13 = r16;
        goto L16
    L19:
        return r11.f19716a[(int) ((((long) r15) + r10) - r13)];
    }

    @Override // okio.BufferedSource
    public Buffer getBuffer() {
        return this;
    }

    public final boolean h(p r10, int r11, byte[] r12, int r13, int r14) {
        int r15 = r10.f19718c;
        byte[] r16 = r10.f19716a;
    L3:
        if (r13 >= r14) goto L14;
        if (r11 != r15) goto L10;
        p r17 = r10.f19721f;
        if (r17 != null) goto L8;
        q.s();
    L8:
        byte[] r18 = r17.f19716a;
        r11 = r17.f19717b;
        r10 = r17;
        r15 = r17.f19718c;
        r16 = r18;
    L10:
        if (r16[r11] != r12[r13]) goto L11;
        r11 = r11 + 1;
        r13 = r13 + 1;
        goto L3
    L11:
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        p r10 = this.f23020a;
        if (r10 == null) goto L14;
        int r11 = 1;
    L5:
        int r12 = r10.f19717b;
        int r13 = r10.f19718c;
    L6:
        if (r12 >= r13) goto L8;
        r11 = (r11 * 31) + r10.f19716a[r12];
        r12 = r12 + 1;
        goto L6
    L8:
        r10 = r10.f19721f;
        if (r10 != null) goto L12;
        q.s();
    L12:
        if (r10 != this.f23020a) goto L5;
        return r11;
    L14:
        return 0;
    }

    public final UnsafeCursor i(UnsafeCursor r10) {
        q.h(r10, "unsafeCursor");
        if (r10.f23022a != null) goto L7;
        r10.f23022a = this;
        r10.f23023b = true;
        return r10;
    L7:
        throw new IllegalStateException("already attached to a buffer");
    }

    @Override // okio.BufferedSource
    public long indexOf(byte r10) {
        return indexOf(r10, 0, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString r10) {
        q.h(r10, "targetBytes");
        return indexOfElement(r10, 0);
    }

    @Override // okio.BufferedSource
    public InputStream inputStream() {
        return new b(this);
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public final String j(long r10) {
        if (r10 <= 0) goto L7;
        long r11 = r10 - 1;
        if (g(r11) != ((byte) 13)) goto L7;
        String r12 = readUtf8(r11);
        skip(2);
        return r12;
    L7:
        String r13 = readUtf8(r10);
        skip(1);
        return r13;
    }

    public final int k(k r10, boolean r11) {
        q.h(r10, "options");
        if (this.f23020a != null) goto L9;
        if (r11 == false) goto L6;
        return -2;
    L6:
        return -1;
    L9:
        throw null;
    }

    public final void m(long r10) {
        this.f23021b = r10;
    }

    public final ByteString n() {
        long r10 = this.f23021b;
        if (r10 > Channel.UNLIMITED) goto L7;
        return o((int) r10);
    L7:
        throw new IllegalStateException(("size > Integer.MAX_VALUE: " + this.f23021b).toString());
    }

    public final ByteString o(int r10) {
        if (r10 != 0) goto L5;
        return ByteString.EMPTY;
    L5:
        return SegmentedByteString.Companion.a(this, r10);
    }

    @Override // okio.BufferedSink
    public OutputStream outputStream() {
        return new c(this);
    }

    public final p p(int r10) {
        if (r10 < 1) goto L22;
        if (r10 > 8192) goto L22;
        p r11 = this.f23020a;
        if (r11 != null) goto L10;
        p r12 = fg.q.b();
        this.f23020a = r12;
        r12.f19722g = r12;
        r12.f19721f = r12;
        return r12;
    L10:
        if (r11 != null) goto L12;
        q.s();
    L12:
        p r13 = r11.f19722g;
        if (r13 != null) goto L16;
        q.s();
    L16:
        if ((r13.f19718c + r10) > 8192) goto L20;
        if (r13.f19720e == false) goto L20;
        return r13;
    L20:
        return r13.c(fg.q.b());
    L22:
        throw new IllegalArgumentException("unexpected capacity");
    }

    @Override // okio.BufferedSource
    public BufferedSource peek() {
        return j.d(new m(this));
    }

    public Buffer q(ByteString r10) {
        q.h(r10, "byteString");
        r10.write$jvm(this);
        return this;
    }

    public Buffer r(byte[] r10) {
        q.h(r10, "source");
        return s(r10, 0, r10.length);
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long r10, ByteString r11) {
        q.h(r11, DownloadInfoColumns.COLUMN_BYTES);
        return rangeEquals(r10, r11, 0, r11.size());
    }

    @Override // okio.BufferedSource
    public int read(byte[] r10) {
        q.h(r10, "sink");
        return read(r10, 0, r10.length);
    }

    @Override // okio.BufferedSource
    public long readAll(Sink r10) {
        q.h(r10, "sink");
        long r11 = this.f23021b;
        if (r11 <= 0) goto L5;
        r10.write(this, r11);
    L5:
        return r11;
    }

    @Override // okio.BufferedSource
    public byte readByte() {
        if (this.f23021b == 0) goto L13;
        p r10 = this.f23020a;
        if (r10 != null) goto L7;
        q.s();
    L7:
        int r11 = r10.f19717b;
        int r12 = r10.f19718c;
        int r13 = r11 + 1;
        byte r14 = r10.f19716a[r11];
        this.f23021b--;
        if (r13 != r12) goto L10;
        this.f23020a = r10.b();
        fg.q.a(r10);
    L11:
        return r14;
    L10:
        r10.f19717b = r13;
        goto L11
    L13:
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray() {
        return readByteArray(this.f23021b);
    }

    @Override // okio.BufferedSource
    public ByteString readByteString() {
        return new ByteString(readByteArray());
    }

    @Override // okio.BufferedSource
    public long readDecimalLong() {
        if (this.f23021b == 0) goto L47;
        int r10 = 0;
        boolean r11 = false;
        long r12 = -7;
        long r13 = 0;
        boolean r14 = false;
    L5:
        p r15 = this.f23020a;
        if (r15 != null) goto L8;
        q.s();
    L8:
        byte[] r16 = r15.f19716a;
        int r17 = r15.f19717b;
        int r18 = r15.f19718c;
    L9:
        if (r17 >= r18) goto L35;
        byte r19 = r16[r17];
        byte r110 = (byte) 48;
        if (r19 < r110) goto L27;
        if (r19 > ((byte) 57)) goto L27;
        int r111 = r110 - r19;
        if (r13 < (-922337203685477580L)) goto L21;
        if (r13 == (-922337203685477580L)) goto L18;
    L20:
        r13 = (r13 * 10) + ((long) r111);
    L30:
        r17 = r17 + 1;
        r10 = r10 + 1;
        goto L9
    L18:
        if (r111 >= r12) goto L20;
    L21:
        Buffer r112 = new Buffer().u(r13).t(r19);
        if (r11 == true) goto L25;
        r112.readByte();
    L25:
        throw new NumberFormatException("Number too large: " + r112.readUtf8());
    L27:
        if (r19 != ((byte) 45)) goto L31;
        if (r10 != 0) goto L31;
        r12 = r12 - 1;
        r11 = true;
    L31:
        if (r10 == 0) goto L34;
        r14 = true;
        goto L35
    L34:
        throw new NumberFormatException("Expected leading [0-9] or '-' character but was 0x" + Integer.toHexString(r19));
    L35:
        if (r17 != r18) goto L37;
        this.f23020a = r15.b();
        fg.q.a(r15);
    L38:
        if (r14 == true) goto L41;
        if (this.f23020a != null) goto L5;
    L41:
        this.f23021b -= (long) r10;
        if (r11 == false) goto L45;
        return r13;
    L45:
        return -r13;
    L37:
        r15.f19717b = r17;
        goto L38
    L47:
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public void readFully(Buffer r10, long r11) {
        q.h(r10, "sink");
        long r12 = this.f23021b;
        if (r12 < r11) goto L6;
        r10.write(this, r11);
        return;
    L6:
        r10.write(this, r12);
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public long readHexadecimalUnsignedLong() {
        if (this.f23021b == 0) goto L43;
        int r10 = 0;
        boolean r11 = false;
        long r12 = 0;
    L5:
        p r13 = this.f23020a;
        if (r13 != null) goto L8;
        q.s();
    L8:
        byte[] r14 = r13.f19716a;
        int r15 = r13.f19717b;
        int r16 = r13.f19718c;
    L9:
        if (r15 >= r16) goto L34;
        byte r17 = r14[r15];
        byte r18 = (byte) 48;
        if (r17 >= r18) goto L13;
    L15:
        byte r19 = (byte) 97;
        if (r17 >= r19) goto L18;
    L20:
        r19 = (byte) 65;
        if (r17 < r19) goto L30;
        if (r17 > ((byte) 70)) goto L30;
    L19:
        int r110 = (r17 - r19) + 10;
    L26:
        if (((-1152921504606846976L) & r12) != 0) goto L29;
        r12 = (r12 << 4) | ((long) r110);
        r15 = r15 + 1;
        r10 = r10 + 1;
        goto L9
    L29:
        throw new NumberFormatException("Number too large: " + new Buffer().v(r12).t(r17).readUtf8());
    L30:
        if (r10 == 0) goto L33;
        r11 = true;
        goto L34
    L33:
        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toHexString(r17));
    L18:
        if (r17 > ((byte) 102)) goto L20;
    L13:
        if (r17 > ((byte) 57)) goto L15;
        r110 = r17 - r18;
    L34:
        if (r15 != r16) goto L36;
        this.f23020a = r13.b();
        fg.q.a(r13);
    L37:
        if (r11 == true) goto L40;
        if (this.f23020a != null) goto L5;
    L40:
        this.f23021b -= (long) r10;
        return r12;
    L36:
        r13.f19717b = r15;
        goto L37
    L43:
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public int readInt() {
        if (this.f23021b < 4) goto L17;
        p r10 = this.f23020a;
        if (r10 != null) goto L7;
        q.s();
    L7:
        int r11 = r10.f19717b;
        int r12 = r10.f19718c;
        if ((r12 - r11) < 4) goto L10;
        byte[] r13 = r10.f19716a;
        int r14 = ((r13[r11 + 1] & UnsignedBytes.MAX_VALUE) << 16) | ((r13[r11] & UnsignedBytes.MAX_VALUE) << 24);
        int r15 = r11 + 3;
        int r16 = r14 | ((r13[r11 + 2] & UnsignedBytes.MAX_VALUE) << 8);
        int r17 = r11 + 4;
        int r18 = (r13[r15] & UnsignedBytes.MAX_VALUE) | r16;
        this.f23021b -= 4;
        if (r17 != r12) goto L14;
        this.f23020a = r10.b();
        fg.q.a(r10);
    L15:
        return r18;
    L14:
        r10.f19717b = r17;
        goto L15
    L10:
        return (readByte() & UnsignedBytes.MAX_VALUE) | ((((readByte() & UnsignedBytes.MAX_VALUE) << 24) | ((readByte() & UnsignedBytes.MAX_VALUE) << 16)) | ((readByte() & UnsignedBytes.MAX_VALUE) << 8));
    L17:
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public int readIntLe() {
        return fg.c.c(readInt());
    }

    @Override // okio.BufferedSource
    public long readLong() {
        if (this.f23021b < 8) goto L17;
        p r10 = this.f23020a;
        if (r10 != null) goto L7;
        q.s();
    L7:
        int r11 = r10.f19717b;
        int r12 = r10.f19718c;
        if ((r12 - r11) < 8) goto L10;
        byte[] r13 = r10.f19716a;
        int r14 = r11 + 7;
        long r15 = (((((((((long) r13[r11]) & 255) << 56) | ((((long) r13[r11 + 1]) & 255) << 48)) | ((((long) r13[r11 + 2]) & 255) << 40)) | ((((long) r13[r11 + 3]) & 255) << 32)) | ((((long) r13[r11 + 4]) & 255) << 24)) | ((((long) r13[r11 + 5]) & 255) << 16)) | ((((long) r13[r11 + 6]) & 255) << 8);
        int r16 = r11 + 8;
        long r17 = r15 | (((long) r13[r14]) & 255);
        this.f23021b -= 8;
        if (r16 != r12) goto L14;
        this.f23020a = r10.b();
        fg.q.a(r10);
    L15:
        return r17;
    L14:
        r10.f19717b = r16;
        goto L15
    L10:
        return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
    L17:
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public long readLongLe() {
        return fg.c.d(readLong());
    }

    @Override // okio.BufferedSource
    public short readShort() {
        if (this.f23021b < 2) goto L18;
        p r10 = this.f23020a;
        if (r10 != null) goto L7;
        q.s();
    L7:
        int r11 = r10.f19717b;
        int r12 = r10.f19718c;
        if ((r12 - r11) < 2) goto L10;
        byte[] r13 = r10.f19716a;
        int r14 = r11 + 1;
        int r15 = (r13[r11] & UnsignedBytes.MAX_VALUE) << 8;
        int r16 = r11 + 2;
        int r17 = (r13[r14] & UnsignedBytes.MAX_VALUE) | r15;
        this.f23021b -= 2;
        if (r16 != r12) goto L14;
        this.f23020a = r10.b();
        fg.q.a(r10);
    L16:
        return (short) r17;
    L14:
        r10.f19717b = r16;
        goto L16
    L10:
        return (short) ((readByte() & UnsignedBytes.MAX_VALUE) | ((readByte() & UnsignedBytes.MAX_VALUE) << 8));
    L18:
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public short readShortLe() {
        return fg.c.e(readShort());
    }

    @Override // okio.BufferedSource
    public String readString(Charset r10) {
        q.h(r10, "charset");
        return readString(this.f23021b, r10);
    }

    @Override // okio.BufferedSource
    public String readUtf8() {
        return readString(this.f23021b, kotlin.text.c.f21252b);
    }

    @Override // okio.BufferedSource
    public int readUtf8CodePoint() {
        if (this.f23021b == 0) goto L42;
        byte r10 = g(0);
        int r11 = 1;
        if ((r10 & UnsignedBytes.MAX_POWER_OF_TWO) != 0) goto L8;
        int r12 = r10 & Ascii.DEL;
        int r13 = 0;
        int r14 = 1;
    L16:
        long r15 = r14;
        if (this.f23021b < r15) goto L38;
    L18:
        if (r11 >= r14) goto L24;
        long r16 = r11;
        byte r17 = g(r16);
        if ((r17 & 192) != 128) goto L22;
        r12 = (r12 << 6) | (r17 & 63);
        r11 = r11 + 1;
        goto L18
    L22:
        skip(r16);
        return 65533;
    L24:
        skip(r15);
        if (r12 <= 1114111) goto L28;
        return 65533;
    L28:
        if (55296 <= r12) goto L31;
    L33:
        if (r12 >= r13) goto L36;
        return 65533;
    L36:
        return r12;
    L31:
        if (57343 < r12) goto L33;
        return 65533;
    L38:
        throw new EOFException("size < " + r14 + ": " + this.f23021b + " (to read code point prefixed 0x" + Integer.toHexString(r10) + ")");
    L8:
        if ((r10 & 224) != 192) goto L11;
        r12 = r10 & Ascii.US;
        r14 = 2;
        r13 = 128;
        goto L16
    L11:
        if ((r10 & 240) != 224) goto L14;
        r12 = r10 & Ascii.SI;
        r14 = 3;
        r13 = 2048;
        goto L16
    L14:
        if ((r10 & 248) != 240) goto L39;
        r12 = r10 & 7;
        r14 = 4;
        r13 = 65536;
        goto L16
    L39:
        skip(1);
        return 65533;
    L42:
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public String readUtf8Line() {
        long r10 = indexOf((byte) 10);
        if (r10 != (-1)) goto L10;
        long r11 = this.f23021b;
        if (r11 != 0) goto L11;
        return null;
    L11:
        return readUtf8(r11);
    L10:
        return j(r10);
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict() {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public boolean request(long r10) {
        if (this.f23021b < r10) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // okio.BufferedSource
    public void require(long r10) {
        if (this.f23021b < r10) goto L6;
        return;
    L6:
        throw new EOFException();
    }

    public Buffer s(byte[] r10, int r11, int r12) {
        q.h(r10, "source");
        long r13 = r12;
        fg.c.b(r10.length, r11, r13);
        int r14 = r12 + r11;
    L3:
        if (r11 >= r14) goto L5;
        p r15 = p(1);
        int r16 = Math.min(r14 - r11, 8192 - r15.f19718c);
        System.arraycopy(r10, r11, r15.f19716a, r15.f19718c, r16);
        r11 = r11 + r16;
        r15.f19718c += r16;
        goto L3
    L5:
        this.f23021b += r13;
        return this;
    }

    @Override // okio.BufferedSource
    public int select(k r10) {
        q.h(r10, "options");
        if (l(this, r10, false, 2, null) != (-1)) goto L5;
        return -1;
    L5:
        throw null;
    }

    public final long size() {
        return this.f23021b;
    }

    @Override // okio.BufferedSource
    public void skip(long r10) {
    L3:
        if (r10 <= 0) goto L11;
        p r11 = this.f23020a;
        if (r11 == null) goto L10;
        int r12 = (int) Math.min(r10, r11.f19718c - r11.f19717b);
        long r13 = r12;
        this.f23021b -= r13;
        r10 = r10 - r13;
        int r14 = r11.f19717b + r12;
        r11.f19717b = r14;
        if (r14 != r11.f19718c) goto L3;
        this.f23020a = r11.b();
        fg.q.a(r11);
        goto L3
    L10:
        throw new EOFException();
    }

    public Buffer t(int r10) {
        p r11 = p(1);
        byte[] r12 = r11.f19716a;
        int r13 = r11.f19718c;
        r11.f19718c = r13 + 1;
        r12[r13] = (byte) r10;
        this.f23021b++;
        return this;
    }

    @Override // okio.Source
    public Timeout timeout() {
        return Timeout.NONE;
    }

    public String toString() {
        return n().toString();
    }

    public Buffer u(long r13) {
        if (r13 == 0) goto L5;
        int r10 = 1;
        if (r13 >= 0) goto L13;
        r13 = -r13;
        if (r13 < 0) goto L11;
        boolean r11 = true;
    L15:
        if (r13 >= 100000000) goto L39;
        if (r13 >= 10000) goto L29;
        if (r13 >= 100) goto L25;
        if (r13 < 10) goto L69;
        r10 = 2;
    L69:
        if (r11 == false) goto L71;
        r10 = r10 + 1;
    L71:
        p r12 = p(r10);
        byte[] r14 = r12.f19716a;
        int r15 = r12.f19718c + r10;
    L73:
        if (r13 == 0) goto L75;
        long r16 = 10;
        r15 = r15 - 1;
        r14[r15] = f23018c[(int) (r13 % r16)];
        r13 = r13 / r16;
        goto L73
    L75:
        if (r11 == false) goto L77;
        r14[r15 - 1] = (byte) 45;
    L77:
        r12.f19718c += r10;
        this.f23021b += (long) r10;
        return this;
    L25:
        if (r13 >= 1000) goto L27;
        r10 = 3;
        goto L69
    L27:
        r10 = 4;
        goto L69
    L29:
        if (r13 >= BatteryFactorConfig.WIFI_BPS) goto L35;
        if (r13 >= 100000) goto L33;
        r10 = 5;
        goto L69
    L33:
        r10 = 6;
        goto L69
    L35:
        if (r13 >= StackLeakChecker.CHECK_INTERVAL_10_SEC) goto L37;
        r10 = 7;
        goto L69
    L37:
        r10 = 8;
        goto L69
    L39:
        if (r13 >= 1000000000000L) goto L51;
        if (r13 >= 10000000000L) goto L47;
        if (r13 >= 1000000000) goto L45;
        r10 = 9;
        goto L69
    L45:
        r10 = 10;
        goto L69
    L47:
        if (r13 >= 100000000000L) goto L49;
        r10 = 11;
        goto L69
    L49:
        r10 = 12;
        goto L69
    L51:
        if (r13 >= 1000000000000000L) goto L60;
        if (r13 >= 10000000000000L) goto L56;
        r10 = 13;
        goto L69
    L56:
        if (r13 >= 100000000000000L) goto L58;
        r10 = 14;
        goto L69
    L58:
        r10 = 15;
        goto L69
    L60:
        if (r13 >= 100000000000000000L) goto L66;
        if (r13 >= 10000000000000000L) goto L64;
        r10 = 16;
        goto L69
    L64:
        r10 = 17;
        goto L69
    L66:
        if (r13 >= 1000000000000000000L) goto L68;
        r10 = 18;
        goto L69
    L68:
        r10 = 19;
        goto L69
    L11:
        return E("-9223372036854775808");
    L13:
        r11 = false;
        goto L15
    L5:
        return t(48);
    }

    public Buffer v(long r10) {
        if (r10 == 0) goto L5;
        int r11 = (Long.numberOfTrailingZeros(Long.highestOneBit(r10)) / 4) + 1;
        p r12 = p(r11);
        byte[] r13 = r12.f19716a;
        int r14 = r12.f19718c;
        int r15 = (r14 + r11) - 1;
    L7:
        if (r15 < r14) goto L9;
        r13[r15] = f23018c[(int) (15 & r10)];
        r10 = r10 >>> 4;
        r15 = r15 - 1;
        goto L7
    L9:
        r12.f19718c += r11;
        this.f23021b += (long) r11;
        return this;
    L5:
        return t(48);
    }

    public Buffer w(int r10) {
        p r11 = p(4);
        byte[] r12 = r11.f19716a;
        int r13 = r11.f19718c;
        r12[r13] = (byte) ((r10 >>> 24) & PrivateKeyType.INVALID);
        r12[r13 + 1] = (byte) ((r10 >>> 16) & PrivateKeyType.INVALID);
        r12[r13 + 2] = (byte) ((r10 >>> 8) & PrivateKeyType.INVALID);
        r12[r13 + 3] = (byte) (r10 & PrivateKeyType.INVALID);
        r11.f19718c = r13 + 4;
        this.f23021b += 4;
        return this;
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink write(ByteString r10) {
        return q(r10);
    }

    @Override // okio.BufferedSink
    public long writeAll(Source r10) {
        q.h(r10, "source");
        long r11 = 0;
    L3:
        long r12 = r10.read(this, 8192);
        if (r12 == (-1)) goto L5;
        r11 = r11 + r12;
        goto L3
    L5:
        return r11;
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeByte(int r10) {
        return t(r10);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeDecimalLong(long r10) {
        return u(r10);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeHexadecimalUnsignedLong(long r10) {
        return v(r10);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeInt(int r10) {
        return w(r10);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeIntLe(int r10) {
        return x(r10);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeLong(long r10) {
        return y(r10);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeLongLe(long r10) {
        return z(r10);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeShort(int r10) {
        return A(r10);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeShortLe(int r10) {
        return B(r10);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeString(String r10, int r11, int r12, Charset r13) {
        return C(r10, r11, r12, r13);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeUtf8(String r10) {
        return E(r10);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeUtf8CodePoint(int r10) {
        return G(r10);
    }

    public Buffer x(int r10) {
        return w(fg.c.c(r10));
    }

    public Buffer y(long r12) {
        p r10 = p(8);
        byte[] r11 = r10.f19716a;
        int r13 = r10.f19718c;
        r11[r13] = (byte) ((r12 >>> 56) & 255);
        r11[r13 + 1] = (byte) ((r12 >>> 48) & 255);
        r11[r13 + 2] = (byte) ((r12 >>> 40) & 255);
        r11[r13 + 3] = (byte) ((r12 >>> 32) & 255);
        r11[r13 + 4] = (byte) ((r12 >>> 24) & 255);
        r11[r13 + 5] = (byte) ((r12 >>> 16) & 255);
        r11[r13 + 6] = (byte) ((r12 >>> 8) & 255);
        r11[r13 + 7] = (byte) (r12 & 255);
        r10.f19718c = r13 + 8;
        this.f23021b += 8;
        return this;
    }

    public Buffer z(long r10) {
        return y(fg.c.d(r10));
    }

    @Override // okio.BufferedSource
    public long indexOf(byte r10, long r11) {
        return indexOf(r10, r11, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString r12, long r13) {
        q.h(r12, "targetBytes");
        long r10 = 0;
        if (r13 < 0) goto L92;
        p r11 = this.f23020a;
        if (r11 != null) goto L7;
        return -1;
    L7:
        if ((size() - r13) >= r13) goto L51;
        r10 = size();
    L10:
        if (r10 <= r13) goto L16;
        r11 = r11.f19722g;
        if (r11 != null) goto L14;
        q.s();
    L14:
        r10 = r10 - ((long) (r11.f19718c - r11.f19717b));
        goto L10
    L16:
        if (r12.size() != 2) goto L34;
        byte r14 = r12.getByte(0);
        byte r15 = r12.getByte(1);
    L19:
        if (r10 >= this.f23021b) goto L50;
        byte[] r16 = r11.f19716a;
        int r17 = (int) ((((long) r11.f19717b) + r13) - r10);
        int r18 = r11.f19718c;
    L21:
        if (r17 >= r18) goto L30;
        byte r19 = r16[r17];
        if (r19 == r14) goto L27;
        if (r19 == r15) goto L27;
        r17 = r17 + 1;
    L27:
        int r110 = r11.f19717b;
    L29:
        return ((long) (r17 - r110)) + r10;
    L30:
        r10 = r10 + ((long) (r11.f19718c - r11.f19717b));
        r11 = r11.f19721f;
        if (r11 != null) goto L33;
        q.s();
    L33:
        r13 = r10;
    L50:
        return -1;
    L34:
        byte[] r111 = r12.internalArray$jvm();
    L36:
        if (r10 >= this.f23021b) goto L50;
        byte[] r20 = r11.f19716a;
        r17 = (int) ((((long) r11.f19717b) + r13) - r10);
        int r112 = r11.f19718c;
    L38:
        if (r17 >= r112) goto L46;
        byte r21 = r20[r17];
        int r22 = r111.length;
        int r23 = 0;
    L40:
        if (r23 >= r22) goto L45;
        if (r21 == r111[r23]) goto L43;
        r23 = r23 + 1;
    L43:
        r110 = r11.f19717b;
        goto L29
    L45:
        r17 = r17 + 1;
        goto L38
    L46:
        r10 = r10 + ((long) (r11.f19718c - r11.f19717b));
        r11 = r11.f19721f;
        if (r11 != null) goto L49;
        q.s();
    L49:
        r13 = r10;
    L51:
        long r24 = ((long) (r11.f19718c - r11.f19717b)) + r10;
        if (r24 > r13) goto L54;
        r11 = r11.f19721f;
        if (r11 != null) goto L89;
        q.s();
    L89:
        r10 = r24;
        goto L51
    L54:
        if (r12.size() != 2) goto L69;
        byte r25 = r12.getByte(0);
        byte r113 = r12.getByte(1);
    L57:
        if (r10 >= this.f23021b) goto L85;
        byte[] r26 = r11.f19716a;
        r17 = (int) ((((long) r11.f19717b) + r13) - r10);
        int r114 = r11.f19718c;
    L59:
        if (r17 >= r114) goto L65;
        byte r27 = r26[r17];
        if (r27 == r25) goto L27;
        if (r27 == r113) goto L27;
        r17 = r17 + 1;
        goto L59
    L65:
        r10 = r10 + ((long) (r11.f19718c - r11.f19717b));
        r11 = r11.f19721f;
        if (r11 != null) goto L68;
        q.s();
    L68:
        r13 = r10;
    L85:
        return -1;
    L69:
        byte[] r115 = r12.internalArray$jvm();
    L71:
        if (r10 >= this.f23021b) goto L85;
        byte[] r28 = r11.f19716a;
        r17 = (int) ((((long) r11.f19717b) + r13) - r10);
        int r116 = r11.f19718c;
    L73:
        if (r17 >= r116) goto L81;
        byte r29 = r28[r17];
        int r30 = r115.length;
        int r31 = 0;
    L75:
        if (r31 >= r30) goto L80;
        if (r29 == r115[r31]) goto L43;
        r31 = r31 + 1;
        goto L75
    L80:
        r17 = r17 + 1;
        goto L73
    L81:
        r10 = r10 + ((long) (r11.f19718c - r11.f19717b));
        r11 = r11.f19721f;
        if (r11 != null) goto L84;
        q.s();
    L84:
        r13 = r10;
        goto L71
    L92:
        throw new IllegalArgumentException(("fromIndex < 0: " + r13).toString());
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long r10, ByteString r11, int r12, int r13) {
        q.h(r11, DownloadInfoColumns.COLUMN_BYTES);
        if (r10 < 0) goto L19;
        if (r12 < 0) goto L19;
        if (r13 < 0) goto L19;
        if ((this.f23021b - r10) < r13) goto L19;
        if ((r11.size() - r12) < r13) goto L19;
        int r14 = 0;
    L12:
        if (r14 >= r13) goto L17;
        if (g(((long) r14) + r10) != r11.getByte(r12 + r14)) goto L15;
        r14 = r14 + 1;
        goto L12
    L15:
        return false;
    L17:
        return true;
    L19:
        return false;
    }

    @Override // okio.BufferedSource
    public int read(byte[] r10, int r11, int r12) {
        q.h(r10, "sink");
        fg.c.b(r10.length, r11, r12);
        p r13 = this.f23020a;
        if (r13 == null) goto L8;
        int r14 = Math.min(r12, r13.f19718c - r13.f19717b);
        System.arraycopy(r13.f19716a, r13.f19717b, r10, r11, r14);
        int r15 = r13.f19717b + r14;
        r13.f19717b = r15;
        this.f23021b -= (long) r14;
        if (r15 != r13.f19718c) goto L7;
        this.f23020a = r13.b();
        fg.q.a(r13);
    L7:
        return r14;
    L8:
        return -1;
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray(long r10) {
        if (r10 < 0) goto L13;
        if (r10 > Channel.UNLIMITED) goto L13;
        if (this.f23021b < r10) goto L11;
        byte[] r11 = new byte[(int) r10];
        readFully(r11);
        return r11;
    L11:
        throw new EOFException();
    L13:
        throw new IllegalArgumentException(("byteCount: " + r10).toString());
    }

    @Override // okio.BufferedSource
    public ByteString readByteString(long r10) {
        return new ByteString(readByteArray(r10));
    }

    @Override // okio.BufferedSource
    public String readString(long r10, Charset r11) {
        q.h(r11, "charset");
        if (r10 < 0) goto L25;
        if (r10 > Channel.UNLIMITED) goto L25;
        if (this.f23021b < r10) goto L23;
        if (r10 != 0) goto L11;
        return "";
    L11:
        p r12 = this.f23020a;
        if (r12 != null) goto L14;
        q.s();
    L14:
        int r13 = r12.f19717b;
        if ((((long) r13) + r10) > r12.f19718c) goto L17;
        int r14 = (int) r10;
        String r15 = new String(r12.f19716a, r13, r14, r11);
        int r16 = r12.f19717b + r14;
        r12.f19717b = r16;
        this.f23021b -= r10;
        if (r16 != r12.f19718c) goto L21;
        this.f23020a = r12.b();
        fg.q.a(r12);
    L21:
        return r15;
    L17:
        return new String(readByteArray(r10), r11);
    L23:
        throw new EOFException();
    L25:
        throw new IllegalArgumentException(("byteCount: " + r10).toString());
    }

    @Override // okio.BufferedSource
    public String readUtf8(long r10) {
        return readString(r10, kotlin.text.c.f21252b);
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict(long r12) {
        if (r12 < 0) goto L23;
        long r10 = Long.MAX_VALUE;
        if (r12 == Long.MAX_VALUE) goto L8;
        r10 = r12 + 1;
    L8:
        byte r11 = (byte) 10;
        long r13 = indexOf(r11, 0, r10);
        if (r13 == (-1)) goto L13;
        return j(r13);
    L13:
        if (r10 < this.f23021b) goto L15;
    L20:
        Buffer r14 = new Buffer();
        d(r14, 0, Math.min(32, this.f23021b));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f23021b, r12) + " content=" + r14.readByteString().hex() + 8230);
    L15:
        if (g(r10 - 1) != ((byte) 13)) goto L20;
        if (g(r10) != r11) goto L20;
        return j(r10);
    L23:
        throw new IllegalArgumentException(("limit < 0: " + r12).toString());
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink write(byte[] r10) {
        return r(r10);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeString(String r10, Charset r11) {
        return D(r10, r11);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeUtf8(String r10, int r11, int r12) {
        return F(r10, r11, r12);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte r10, long r11, long r13) {
        long r12 = 0;
        if (0 > r11) goto L58;
        if (r13 < r11) goto L58;
        long r14 = this.f23021b;
        if (r13 <= r14) goto L10;
        r13 = r14;
    L10:
        if (r11 != r13) goto L12;
        return -1;
    L12:
        p r15 = this.f23020a;
        if (r15 != null) goto L15;
        return -1;
    L15:
        if ((size() - r11) >= r11) goto L37;
        r12 = size();
    L18:
        if (r12 <= r11) goto L24;
        r15 = r15.f19722g;
        if (r15 != null) goto L22;
        q.s();
    L22:
        r12 = r12 - ((long) (r15.f19718c - r15.f19717b));
    L24:
        if (r12 >= r13) goto L36;
        byte[] r16 = r15.f19716a;
        int r17 = (int) Math.min(r15.f19718c, (((long) r15.f19717b) + r13) - r12);
        int r18 = (int) ((((long) r15.f19717b) + r11) - r12);
    L26:
        if (r18 >= r17) goto L32;
        if (r16[r18] == r10) goto L30;
        r18 = r18 + 1;
    L30:
        return ((long) (r18 - r15.f19717b)) + r12;
    L32:
        r12 = r12 + ((long) (r15.f19718c - r15.f19717b));
        r15 = r15.f19721f;
        if (r15 != null) goto L35;
        q.s();
    L35:
        r11 = r12;
        goto L24
    L36:
        return -1;
    L37:
        long r19 = ((long) (r15.f19718c - r15.f19717b)) + r12;
        if (r19 > r11) goto L40;
        r15 = r15.f19721f;
        if (r15 != null) goto L55;
        q.s();
    L55:
        r12 = r19;
    L40:
        if (r12 >= r13) goto L51;
        byte[] r20 = r15.f19716a;
        int r21 = (int) Math.min(r15.f19718c, (((long) r15.f19717b) + r13) - r12);
        r18 = (int) ((((long) r15.f19717b) + r11) - r12);
    L42:
        if (r18 >= r21) goto L47;
        if (r20[r18] == r10) goto L30;
        r18 = r18 + 1;
        goto L42
    L47:
        r12 = r12 + ((long) (r15.f19718c - r15.f19717b));
        r15 = r15.f19721f;
        if (r15 != null) goto L50;
        q.s();
    L50:
        r11 = r12;
        goto L40
    L51:
        return -1;
    L58:
        throw new IllegalArgumentException(("size=" + this.f23021b + " fromIndex=" + r11 + " toIndex=" + r13).toString());
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink write(byte[] r10, int r11, int r12) {
        return s(r10, r11, r12);
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer r10) {
        q.h(r10, "source");
        int r11 = r10.remaining();
        int r12 = r11;
    L3:
        if (r12 <= 0) goto L5;
        p r13 = p(1);
        int r14 = Math.min(r12, 8192 - r13.f19718c);
        r10.get(r13.f19716a, r13.f19718c, r14);
        r12 = r12 - r14;
        r13.f19718c += r14;
        goto L3
    L5:
        this.f23021b += (long) r11;
        return r11;
    }

    @Override // okio.BufferedSource
    public void readFully(byte[] r10) {
        q.h(r10, "sink");
        int r11 = 0;
    L4:
        if (r11 >= r10.length) goto L10;
        int r12 = read(r10, r11, r10.length - r11);
        if (r12 == (-1)) goto L9;
        r11 = r11 + r12;
        goto L4
    L9:
        throw new EOFException();
    }

    @Override // okio.BufferedSink
    public BufferedSink write(Source r10, long r11) {
        q.h(r10, "source");
    L4:
        if (r11 <= 0) goto L10;
        long r12 = r10.read(this, r11);
        if (r12 == (-1)) goto L9;
        r11 = r11 - r12;
        goto L4
    L9:
        throw new EOFException();
    L10:
        return this;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer r10) {
        q.h(r10, "sink");
        p r11 = this.f23020a;
        if (r11 == null) goto L8;
        int r12 = Math.min(r10.remaining(), r11.f19718c - r11.f19717b);
        r10.put(r11.f19716a, r11.f19717b, r12);
        int r13 = r11.f19717b + r12;
        r11.f19717b = r13;
        this.f23021b -= (long) r12;
        if (r13 != r11.f19718c) goto L7;
        this.f23020a = r11.b();
        fg.q.a(r11);
    L7:
        return r12;
    L8:
        return -1;
    }

    @Override // okio.Sink
    public void write(Buffer r10, long r11) {
        q.h(r10, "source");
        if (r10 == this) goto L54;
        fg.c.b(r10.f23021b, 0, r11);
    L6:
        if (r11 <= 0) goto L52;
        p r12 = r10.f23020a;
        if (r12 != null) goto L10;
        q.s();
    L10:
        int r13 = r12.f19718c;
        p r14 = r10.f23020a;
        if (r14 != null) goto L14;
        q.s();
    L14:
        if (r11 >= (r13 - r14.f19717b)) goto L39;
        p r15 = this.f23020a;
        if (r15 == null) goto L20;
        if (r15 != null) goto L19;
        q.s();
    L19:
        p r16 = r15.f19722g;
    L21:
        if (r16 != null) goto L23;
    L35:
        p r17 = r10.f23020a;
        if (r17 != null) goto L38;
        q.s();
    L38:
        r10.f23020a = r17.e((int) r11);
        goto L39
    L23:
        if (r16.f19720e == false) goto L35;
        long r18 = ((long) r16.f19718c) + r11;
        if (r16.f19719d == false) goto L27;
        int r19 = 0;
    L29:
        if ((r18 - ((long) r19)) > 8192) goto L35;
        p r20 = r10.f23020a;
        if (r20 != null) goto L33;
        q.s();
    L33:
        r20.g(r16, (int) r11);
        r10.f23021b -= r11;
        this.f23021b += r11;
        return;
    L27:
        r19 = r16.f19717b;
        goto L29
    L20:
        r16 = null;
    L39:
        p r21 = r10.f23020a;
        if (r21 != null) goto L42;
        q.s();
    L42:
        long r22 = r21.f19718c - r21.f19717b;
        r10.f23020a = r21.b();
        p r23 = this.f23020a;
        if (r23 != null) goto L45;
        this.f23020a = r21;
        r21.f19722g = r21;
        r21.f19721f = r21;
    L51:
        r10.f23021b -= r22;
        this.f23021b += r22;
        r11 = r11 - r22;
        goto L6
    L45:
        if (r23 != null) goto L47;
        q.s();
    L47:
        p r24 = r23.f19722g;
        if (r24 != null) goto L50;
        q.s();
    L50:
        r24.c(r21).a();
        goto L51
    L52:
        return;
    L54:
        throw new IllegalArgumentException("source == this");
    }

    @Override // okio.Source
    public long read(Buffer r10, long r11) {
        q.h(r10, "sink");
        if (r11 < 0) goto L14;
        long r12 = this.f23021b;
        if (r12 != 0) goto L9;
        return -1;
    L9:
        if (r11 <= r12) goto L11;
        r11 = r12;
    L11:
        r10.write(this, r11);
        return r11;
    L14:
        throw new IllegalArgumentException(("byteCount < 0: " + r11).toString());
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString r10) {
        q.h(r10, DownloadInfoColumns.COLUMN_BYTES);
        return indexOf(r10, 0);
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString r19, long r20) {
        Buffer r10 = this;
        long r11 = r20;
        q.h(r19, DownloadInfoColumns.COLUMN_BYTES);
        if (r19.size() <= 0) goto L65;
        long r12 = 0;
        if (r11 < 0) goto L63;
        p r13 = r10.f23020a;
        if (r13 != null) goto L9;
        return -1;
    L9:
        if ((size() - r11) >= r11) goto L35;
        long r14 = size();
    L12:
        if (r14 <= r11) goto L17;
        r13 = r13.f19722g;
        if (r13 != null) goto L16;
        q.s();
    L16:
        r14 = r14 - ((long) (r13.f19718c - r13.f19717b));
        goto L12
    L17:
        byte[] r15 = r19.internalArray$jvm();
        byte r16 = r15[0];
        int r17 = r19.size();
        long r18 = (r10.f23021b - ((long) r17)) + 1;
        p r21 = r13;
        long r110 = r14;
    L19:
        if (r110 >= r18) goto L33;
        byte[] r22 = r21.f19716a;
        long r111 = r18;
        int r112 = (int) Math.min(r21.f19718c, (((long) r21.f19717b) + r18) - r110);
        int r113 = (int) ((((long) r21.f19717b) + r11) - r110);
    L21:
        if (r113 >= r112) goto L29;
        if (r22[r113] != r16) goto L28;
        if (h(r21, r113 + 1, r15, 1, r17) == false) goto L28;
        return ((long) (r113 - r21.f19717b)) + r110;
    L28:
        r113 = r113 + 1;
        goto L21
    L29:
        r110 = r110 + ((long) (r21.f19718c - r21.f19717b));
        r21 = r21.f19721f;
        if (r21 != null) goto L32;
        q.s();
    L32:
        r11 = r110;
        r18 = r111;
        goto L19
    L33:
        return -1;
    L35:
        long r23 = ((long) (r13.f19718c - r13.f19717b)) + r12;
        if (r23 > r11) goto L37;
        r13 = r13.f19721f;
        if (r13 != null) goto L59;
        q.s();
    L59:
        r10 = this;
        r12 = r23;
        goto L35
    L37:
        byte[] r24 = r19.internalArray$jvm();
        byte r25 = r24[0];
        int r26 = r19.size();
        long r114 = (r10.f23021b - ((long) r26)) + 1;
        p r115 = r13;
        long r116 = r12;
    L39:
        if (r116 >= r114) goto L54;
        byte[] r117 = r115.f19716a;
        int r27 = (int) Math.min(r115.f19718c, (((long) r115.f19717b) + r114) - r116);
        int r28 = (int) ((((long) r115.f19717b) + r11) - r116);
    L41:
        if (r28 >= r27) goto L50;
        if (r117[r28] != r25) goto L48;
        int r118 = r28;
        if (h(r115, r28 + 1, r24, 1, r26) == false) goto L49;
        return ((long) (r118 - r115.f19717b)) + r116;
    L49:
        r28 = r118 + 1;
        goto L41
    L48:
        r118 = r28;
        goto L49
    L50:
        r116 = r116 + ((long) (r115.f19718c - r115.f19717b));
        r115 = r115.f19721f;
        if (r115 != null) goto L53;
        q.s();
    L53:
        r11 = r116;
        goto L39
    L54:
        return -1;
    L63:
        throw new IllegalArgumentException(("fromIndex < 0: " + r11).toString());
    L65:
        throw new IllegalArgumentException("bytes is empty");
    }
}

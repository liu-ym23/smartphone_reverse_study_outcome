package okhttp3.internal.g;

import androidx.core.internal.view.SupportMenu;
import com.bytedance.apm.battery.dao.DBHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import e.aa;
import e.ab;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: Http2Reader.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class h implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f40043a = null;
    private static final Logger f = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e.g f40044b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f40045c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b f40046d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d.a f40047e;

    /* JADX INFO: compiled from: Http2Reader.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final Logger a() {
            return h.a();
        }

        public final int a(int r2, int r3, int r4) {
            if ((r3 & 8) == 0) goto L5;
            r2 = r2 - 1;
        L5:
            if (r4 > r2) goto L9;
            return r2 - r4;
        L9:
            throw new IOException("PROTOCOL_ERROR padding " + r4 + " > remaining length " + r2);
        }
    }

    /* JADX INFO: compiled from: Http2Reader.kt */
    public static final class b implements aa {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final e.g f40048a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f40049b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f40050c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f40051d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f40052e;
        private int f;

        @Override // e.aa, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        public b(e.g r3) {
            e.g r4 = (e.g) ZeusTransformUtils.wrapperContextForParams(r3, e.g.class, "com.obric.aiagent.plugin");
            o.e(r4, DBHelper.BATTERY_COL_SOURCE);
            this.f40048a = r4;
        }

        public final void a(int r1) {
            this.f40049b = r1;
        }

        public final void b(int r1) {
            this.f40050c = r1;
        }

        public final void c(int r1) {
            this.f40051d = r1;
        }

        public final int b() {
            return this.f40052e;
        }

        public final void d(int r1) {
            this.f40052e = r1;
        }

        public final void e(int r1) {
            this.f = r1;
        }

        @Override // e.aa
        public long a(e.e r7, long r8) {
            o.e(r7, "sink");
        L3:
            int r0 = this.f40052e;
            if (r0 != 0) goto L9;
            this.f40048a.h(this.f);
            this.f = 0;
            if ((this.f40050c & 4) != 0) goto L7;
            c();
            goto L3
        L7:
            return -1;
        L9:
            long r9 = this.f40048a.a(r7, Math.min(r8, r0));
            if (r9 != (-1)) goto L12;
            return -1;
        L12:
            this.f40052e -= (int) r9;
            return r9;
        }

        @Override // e.aa
        public ab a() {
            return this.f40048a.a();
        }

        private final void c() {
            int r0 = this.f40051d;
            int r1 = okhttp3.internal.c.a(this.f40048a);
            this.f40052e = r1;
            this.f40049b = r1;
            int r2 = okhttp3.internal.c.a(this.f40048a.k(), 255);
            this.f40050c = okhttp3.internal.c.a(this.f40048a.k(), 255);
            if (h.f40043a.a().isLoggable(Level.FINE) == false) goto L5;
            h.f40043a.a().fine(e.f39986a.a(true, this.f40051d, this.f40049b, r2, this.f40050c));
        L5:
            int r3 = this.f40048a.m() & Integer.MAX_VALUE;
            this.f40051d = r3;
            if (r2 != 9) goto L12;
            if (r3 != r0) goto L10;
            return;
        L10:
            throw new IOException("TYPE_CONTINUATION streamId changed");
        L12:
            throw new IOException(r2 + " != TYPE_CONTINUATION");
        }
    }

    /* JADX INFO: compiled from: Http2Reader.kt */
    public interface c {
        void a(int r1, int r2, int r3, boolean r4);

        void a(int r1, int r2, List<okhttp3.internal.g.c> r3);

        void a(int r1, long r2);

        void a(int r1, okhttp3.internal.g.b r2);

        void a(int r1, okhttp3.internal.g.b r2, e.h r3);

        void a(boolean r1, int r2, int r3);

        void a(boolean r1, int r2, int r3, List<okhttp3.internal.g.c> r4);

        void a(boolean r1, int r2, e.g r3, int r4);

        void a(boolean r1, m r2);

        void b();
    }

    public h(e.g r9, boolean r10) {
        e.g r11 = (e.g) ZeusTransformUtils.wrapperContextForParams(r9, e.g.class, "com.obric.aiagent.plugin");
        o.e(r11, DBHelper.BATTERY_COL_SOURCE);
        this.f40044b = r11;
        this.f40045c = r10;
        b r12 = new b(r11);
        this.f40046d = r12;
        this.f40047e = new d.a((aa) ZeusTransformUtils.preCheckCast(r12, aa.class, "com.obric.aiagent.plugin"), 4096, 0, 4, null);
    }

    public static final /* synthetic */ Logger a() {
        return f;
    }

    public final void a(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
        o.e(r4, "handler");
        if (this.f40045c == true) goto L5;
        e.h r2 = this.f40044b.d(e.f39987b.k());
        Logger r5 = f;
        if (r5.isLoggable(Level.FINE) == false) goto L13;
        r5.fine(okhttp3.internal.c.a("<< CONNECTION " + r2.i(), new Object[0]));
    L13:
        if (o.a(e.f39987b, r2) == false) goto L16;
        return;
    L16:
        throw new IOException("Expected a connection header but was " + r2.d());
    L5:
        if (a(true, r4) == false) goto L8;
        return;
    L8:
        throw new IOException("Required SETTINGS preface not received");
    }

    public final boolean a(boolean r12, c r13) {
        c r14 = (c) ZeusTransformUtils.wrapperContextForParams(r13, c.class, "com.obric.aiagent.plugin");
        o.e(r14, "handler");
        this.f40044b.b(9);     // Catch: EOFException -> L30
        int r0 = okhttp3.internal.c.a(this.f40044b);
        if (r0 > 16384) goto L29;
        int r7 = okhttp3.internal.c.a(this.f40044b.k(), 255);
        int r8 = okhttp3.internal.c.a(this.f40044b.k(), 255);
        int r9 = this.f40044b.m() & Integer.MAX_VALUE;
        Logger r10 = f;
        if (r10.isLoggable(Level.FINE) == false) goto L9;
        r10.fine(e.f39986a.a(true, r9, r0, r7, r8));
    L9:
        if (r12 == true) goto L11;
    L15:
        switch(r7) {
            case 0: goto L25;
            case 1: goto L24;
            case 2: goto L23;
            case 3: goto L22;
            case 4: goto L21;
            case 5: goto L20;
            case 6: goto L19;
            case 7: goto L18;
            case 8: goto L17;
            default: goto L16;
        };
    L16:
        this.f40044b.h(r0);
        return true;
    L17:
        i(r14, r0, r8, r9);
        return true;
    L18:
        h(r14, r0, r8, r9);
        return true;
    L19:
        g(r14, r0, r8, r9);
        return true;
    L20:
        f(r14, r0, r8, r9);
        return true;
    L21:
        e(r14, r0, r8, r9);
        return true;
    L22:
        d(r14, r0, r8, r9);
        return true;
    L23:
        c(r14, r0, r8, r9);
        return true;
    L24:
        a(r14, r0, r8, r9);
        return true;
    L25:
        b(r14, r0, r8, r9);
        return true;
    L11:
        if (r7 == 4) goto L15;
        throw new IOException("Expected a SETTINGS frame but was " + e.f39986a.a(r7));
    L29:
        throw new IOException("FRAME_SIZE_ERROR: " + r0);
    L30:
        return false;
    }

    private final void a(c r4, int r5, int r6, int r7) {
        c r8 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.aiagent.plugin");
        if (r7 == 0) goto L17;
        int r1 = 0;
        if ((r6 & 1) == 0) goto L7;
        boolean r0 = true;
    L9:
        if ((r6 & 8) == 0) goto L12;
        r1 = okhttp3.internal.c.a(this.f40044b.k(), 255);
    L12:
        if ((r6 & 32) == 0) goto L14;
        a(r8, r7);
        r5 = r5 - 5;
    L14:
        r8.a(r0, r7, -1, a(f40043a.a(r5, r6, r1), r1, r6, r7));
        return;
    L7:
        r0 = false;
        goto L9
    L17:
        throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
    }

    private final List<okhttp3.internal.g.c> a(int r2, int r3, int r4, int r5) {
        this.f40046d.d(r2);
        b r6 = this.f40046d;
        r6.a(r6.b());
        this.f40046d.e(r3);
        this.f40046d.b(r4);
        this.f40046d.c(r5);
        this.f40047e.b();
        return this.f40047e.a();
    }

    private final void b(c r5, int r6, int r7, int r8) {
        c r9 = (c) ZeusTransformUtils.wrapperContextForParams(r5, c.class, "com.obric.aiagent.plugin");
        if (r8 == 0) goto L21;
        int r1 = 0;
        boolean r2 = true;
        if ((r7 & 1) == 0) goto L7;
        boolean r0 = true;
    L9:
        if ((r7 & 32) != 0) goto L12;
        r2 = false;
    L12:
        if (r2 == true) goto L19;
        if ((r7 & 8) == 0) goto L16;
        r1 = okhttp3.internal.c.a(this.f40044b.k(), 255);
    L16:
        r9.a(r0, r8, this.f40044b, f40043a.a(r6, r7, r1));
        this.f40044b.h(r1);
        return;
    L19:
        throw new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
    L7:
        r0 = false;
        goto L9
    L21:
        throw new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
    }

    private final void c(c r2, int r3, int r4, int r5) {
        c r6 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.aiagent.plugin");
        if (r3 != 5) goto L10;
        if (r5 == 0) goto L8;
        a(r6, r5);
        return;
    L8:
        throw new IOException("TYPE_PRIORITY streamId == 0");
    L10:
        throw new IOException("TYPE_PRIORITY length: " + r3 + " != 5");
    }

    private final void a(c r5, int r6) {
        c r7 = (c) ZeusTransformUtils.wrapperContextForParams(r5, c.class, "com.obric.aiagent.plugin");
        int r0 = this.f40044b.m();
        if ((Integer.MIN_VALUE & r0) == 0) goto L5;
        boolean r1 = true;
    L6:
        r7.a(r6, r0 & Integer.MAX_VALUE, okhttp3.internal.c.a(this.f40044b.k(), 255) + 1, r1);
        return;
    L5:
        r1 = false;
        goto L6
    }

    private final void d(c r2, int r3, int r4, int r5) {
        c r6 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.aiagent.plugin");
        if (r3 != 4) goto L14;
        if (r5 == 0) goto L12;
        int r1 = this.f40044b.m();
        okhttp3.internal.g.b r7 = okhttp3.internal.g.b.f39963a.a(r1);
        if (r7 == null) goto L10;
        r6.a(r5, r7);
        return;
    L10:
        throw new IOException("TYPE_RST_STREAM unexpected error code: " + r1);
    L12:
        throw new IOException("TYPE_RST_STREAM streamId == 0");
    L14:
        throw new IOException("TYPE_RST_STREAM length: " + r3 + " != 4");
    }

    private final void e(c r8, int r9, int r10, int r11) {
        c r12 = (c) ZeusTransformUtils.wrapperContextForParams(r8, c.class, "com.obric.aiagent.plugin");
        if (r11 != 0) goto L52;
        if ((r10 & 1) == 0) goto L12;
        if (r9 != 0) goto L10;
        r12.b();
        return;
    L10:
        throw new IOException("FRAME_SIZE_ERROR ack frame should be empty!");
    L12:
        if ((r9 % 6) != 0) goto L50;
        m r13 = new m();
        d.l.h r14 = d.l.n.a((d.l.h) ZeusTransformUtils.preCheckCast(d.l.n.b(0, r9), d.l.h.class, "com.obric.aiagent.plugin"), 6);
        int r1 = r14.a();
        int r2 = r14.b();
        int r15 = r14.c();
        if (r15 <= 0) goto L16;
        if (r1 > r2) goto L16;
    L18:
        int r3 = okhttp3.internal.c.a(this.f40044b.l(), SupportMenu.USER_MASK);
        int r4 = this.f40044b.m();
        if (r3 != 2) goto L21;
        if (r4 == 0) goto L44;
        if (r4 == 1) goto L44;
        throw new IOException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
    L44:
        r13.a(r3, r4);
        if (r1 == r2) goto L47;
        r1 = r1 + r15;
    L47:
        r12.a(false, r13);
        return;
    L21:
        if (r3 == 3) goto L38;
        if (r3 != 4) goto L24;
        r3 = 7;
        if (r4 >= 0) goto L44;
        throw new IOException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
    L24:
        if (r3 != 5) goto L44;
        if (r4 < 16384) goto L32;
        if (r4 <= 16777215) goto L44;
    L32:
        throw new IOException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: " + r4);
    L38:
        r3 = 4;
    L16:
        if (r15 >= 0) goto L47;
        if (r2 > r1) goto L47;
    L50:
        throw new IOException("TYPE_SETTINGS length % 6 != 0: " + r9);
    L52:
        throw new IOException("TYPE_SETTINGS streamId != 0");
    }

    private final void f(c r4, int r5, int r6, int r7) {
        c r8 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.aiagent.plugin");
        if (r7 == 0) goto L11;
        if ((r6 & 8) == 0) goto L7;
        int r0 = okhttp3.internal.c.a(this.f40044b.k(), 255);
    L8:
        r8.a(r7, this.f40044b.m() & Integer.MAX_VALUE, a(f40043a.a(r5 - 4, r6, r0), r0, r6, r7));
        return;
    L7:
        r0 = 0;
        goto L8
    L11:
        throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
    }

    private final void g(c r3, int r4, int r5, int r6) {
        c r7 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
        if (r4 != 8) goto L14;
        if (r6 != 0) goto L12;
        int r8 = this.f40044b.m();
        int r2 = this.f40044b.m();
        boolean r9 = true;
        if ((r5 & 1) != 0) goto L9;
        r9 = false;
    L9:
        r7.a(r9, r8, r2);
        return;
    L12:
        throw new IOException("TYPE_PING streamId != 0");
    L14:
        throw new IOException("TYPE_PING length != 8: " + r4);
    }

    private final void h(c r3, int r4, int r5, int r6) {
        c r7 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
        if (r4 < 8) goto L17;
        if (r6 != 0) goto L15;
        int r8 = this.f40044b.m();
        int r0 = this.f40044b.m();
        int r9 = r4 - 8;
        okhttp3.internal.g.b r10 = okhttp3.internal.g.b.f39963a.a(r0);
        if (r10 == null) goto L13;
        e.h r1 = e.h.f38723b;
        if (r9 <= 0) goto L10;
        r1 = this.f40044b.d(r9);
    L10:
        r7.a(r8, r10, r1);
        return;
    L13:
        throw new IOException("TYPE_GOAWAY unexpected error code: " + r0);
    L15:
        throw new IOException("TYPE_GOAWAY streamId != 0");
    L17:
        throw new IOException("TYPE_GOAWAY length < 8: " + r4);
    }

    private final void i(c r3, int r4, int r5, int r6) {
        c r7 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
        if (r4 != 4) goto L11;
        long r8 = okhttp3.internal.c.a(this.f40044b.m(), 2147483647L);
        if (r8 == 0) goto L9;
        r7.a(r6, r8);
        return;
    L9:
        throw new IOException("windowSizeIncrement was 0");
    L11:
        throw new IOException("TYPE_WINDOW_UPDATE length !=4: " + r4);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f40044b.close();
    }

    static {
        f40043a = new a(null);
        Logger r0 = Logger.getLogger(e.class.getName());
        o.c(r0, "getLogger(Http2::class.java.name)");
        f = r0;
    }
}

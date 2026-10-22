package okhttp3.internal.g;

import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.common.wschannel.WsConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;
import e.aa;
import e.ab;
import e.y;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Collection;
import okhttp3.u;

/* JADX INFO: compiled from: Http2Stream.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f40053a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f40054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f f40055c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f40056d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f40057e;
    private long f;
    private long g;
    private final ArrayDeque<u> h;
    private boolean i;
    private final c j;
    private final b k;
    private final d l;
    private final d m;
    private okhttp3.internal.g.b n;
    private IOException o;

    /* JADX INFO: compiled from: Http2Stream.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: Http2Stream.kt */
    public final class b implements y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f40058a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f40059b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final e.e f40060c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private u f40061d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f40062e;

        public b(i r1, boolean r2) {
            this.f40058a = r1;
            this.f40059b = r2;
            this.f40060c = new e.e();
        }

        public final boolean b() {
            return this.f40059b;
        }

        public final boolean c() {
            return this.f40062e;
        }

        @Override // e.y
        public void a_(e.e r3, long r4) {
            o.e(r3, DBHelper.BATTERY_COL_SOURCE);
            i r0 = this.f40058a;
            if (okhttp3.internal.c.f == true) goto L5;
        L9:
            this.f40060c.a_(r3, r4);
        L11:
            if (this.f40060c.b() < 16384) goto L13;
            a(false);
            goto L11
        L13:
            return;
        L5:
            if (Thread.holdsLock(r0) == false) goto L9;
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + r0);
        }

        private final void a(boolean r12) {
            i r0 = this.f40058a;
            monitor-enter(r0);
            r0.j().c();     // Catch: Throwable -> L33
        L39:
        L30:
            th = move-exception;
            r0.j().b();     // Catch: Throwable -> L33
            throw th;     // Catch: Throwable -> L33
        L6:
            if (r0.e() < r0.f()) goto L15;
            if (this.f40059b == true) goto L15;
            if (this.f40062e == true) goto L15;
            if (r0.k() != null) goto L15;
            r0.u();     // Catch: Throwable -> L30
        L15:
            r0.j().b();     // Catch: Throwable -> L33
            r0.t();     // Catch: Throwable -> L33
            long r9 = Math.min(r0.f() - r0.e(), this.f40060c.b());     // Catch: Throwable -> L33
            r0.c(r0.e() + r9);     // Catch: Throwable -> L33
            if (r12 == true) goto L18;
        L20:
            boolean r13 = false;
        L21:
            boolean r7 = r13;
            x r14 = x.f38692a;     // Catch: Throwable -> L33
            monitor-exit(r0);
            this.f40058a.j().c();
            this.f40058a.b().a(this.f40058a.a(), r7, this.f40060c, r9);     // Catch: Throwable -> L27
            this.f40058a.j().b();
            return;
        L27:
            th = move-exception;
            this.f40058a.j().b();
            throw th;
        L18:
            if (r9 != this.f40060c.b()) goto L20;
            r13 = true;
        L33:
            th = move-exception;
            throw th;
        }

        @Override // e.y, java.io.Flushable
        public void flush() {
            i r0 = this.f40058a;
            if (okhttp3.internal.c.f == true) goto L5;
        L9:
            i r1 = this.f40058a;
            monitor-enter(r1);
            r1.t();     // Catch: Throwable -> L17
            x r2 = x.f38692a;     // Catch: Throwable -> L17
            monitor-exit(r1);
        L14:
            if (this.f40060c.b() <= 0) goto L16;
            a(false);
            this.f40058a.b().k();
            goto L14
        L16:
            return;
        L17:
            th = move-exception;
            throw th;
        L5:
            if (Thread.holdsLock(r0) == false) goto L9;
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + r0);
        }

        @Override // e.y
        public ab a() {
            return (ab) ZeusTransformUtils.preCheckCast(this.f40058a.j(), ab.class, "com.obric.aiagent.plugin");
        }

        @Override // e.y, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            i r0 = this.f40058a;
            if (okhttp3.internal.c.f == true) goto L5;
        L9:
            i r1 = this.f40058a;
            monitor-enter(r1);
        L51:
            th = move-exception;
            throw th;
        L12:
            if (this.f40062e == false) goto L16;
            monitor-exit(r1);
            return;
        L16:
            if (r1.k() != null) goto L18;
            boolean r2 = true;
        L19:
            x r4 = x.f38692a;     // Catch: Throwable -> L51
            monitor-exit(r1);
            if (this.f40058a.h().f40059b == false) goto L24;
        L42:
            i r3 = this.f40058a;
            monitor-enter(r3);
            this.f40062e = true;     // Catch: Throwable -> L48
            x r5 = x.f38692a;     // Catch: Throwable -> L48
            monitor-exit(r3);
            this.f40058a.b().k();
            this.f40058a.s();
            return;
        L48:
            th = move-exception;
            throw th;
        L24:
            if (this.f40060c.b() <= 0) goto L26;
            boolean r6 = true;
        L28:
            if (this.f40061d == null) goto L30;
            boolean r7 = true;
        L31:
            if (r7 == true) goto L33;
            if (r6 == true) goto L38;
            if (r2 == false) goto L42;
            this.f40058a.b().a(this.f40058a.a(), true, null, 0);
        L38:
            if (this.f40060c.b() <= 0) goto L42;
            a(true);
        L33:
            if (this.f40060c.b() <= 0) goto L35;
            a(false);
            goto L33
        L35:
            f r8 = this.f40058a.b();
            int r9 = this.f40058a.a();
            u r10 = this.f40061d;
            o.a(r10);
            r8.a(r9, r2, okhttp3.internal.c.a(r10));
            goto L42
        L30:
            r7 = false;
            goto L31
        L26:
            r6 = false;
            goto L28
        L18:
            r2 = false;
            goto L19
        L5:
            if (Thread.holdsLock(r0) == false) goto L9;
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + r0);
        }
    }

    /* JADX INFO: compiled from: Http2Stream.kt */
    public final class c implements aa {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f40063a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f40064b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f40065c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final e.e f40066d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final e.e f40067e;
        private u f;
        private boolean g;

        public c(i r1, long r2, boolean r4) {
            this.f40063a = r1;
            this.f40064b = r2;
            this.f40065c = r4;
            this.f40066d = new e.e();
            this.f40067e = new e.e();
        }

        public final void a(boolean r1) {
            this.f40065c = r1;
        }

        public final boolean b() {
            return this.f40065c;
        }

        public final void a(u r1) {
            this.f = r1;
        }

        public final boolean c() {
            return this.g;
        }

        @Override // e.aa
        public long a(e.e r18, long r19) {
            o.e(r18, "sink");
            long r4 = 0;
            if (r19 < 0) goto L5;
            boolean r6 = true;
        L6:
            if (r6 == false) goto L53;
        L7:
            IOException r7 = null;
            i r9 = this.f40063a;
            monitor-enter(r9);
            r9.i().c();     // Catch: Throwable -> L49
        L46:
            th = move-exception;
            r9.i().b();     // Catch: Throwable -> L49
            throw th;     // Catch: Throwable -> L49
        L11:
            if (r9.k() == null) goto L18;
            if (this.f40065c == true) goto L18;
            r7 = r9.l();     // Catch: Throwable -> L46
            if (r7 != null) goto L18;
            okhttp3.internal.g.b r10 = r9.k();     // Catch: Throwable -> L46
            o.a(r10);     // Catch: Throwable -> L46
            r7 = (IOException) ZeusTransformUtils.preCheckCast(new n(r10), IOException.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L46
        L18:
            if (this.g == true) goto L45;
            if (this.f40067e.b() <= r4) goto L27;
            e.e r11 = this.f40067e;     // Catch: Throwable -> L46
            long r13 = r11.a(r18, Math.min(r19, r11.b()));     // Catch: Throwable -> L46
            r9.a(r9.c() + r13);     // Catch: Throwable -> L46
            long r5 = r9.c() - r9.d();     // Catch: Throwable -> L46
            if (r7 == null) goto L24;
        L32:
            boolean r8 = false;
        L33:
            r9.i().b();     // Catch: Throwable -> L49
            x r12 = x.f38692a;     // Catch: Throwable -> L49
            monitor-exit(r9);
            if (r8 == false) goto L38;
            r4 = 0;
            goto L7
        L38:
            if (r13 == (-1)) goto L40;
            return r13;
        L40:
            if (r7 != null) goto L43;
            return -1;
        L43:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(r7, Throwable.class, "com.obric.aiagent.plugin"));
        L24:
            if (r5 < (r9.b().g().b() / 2)) goto L32;
            r9.b().a(r9.a(), r5);     // Catch: Throwable -> L46
            r9.b(r9.c());     // Catch: Throwable -> L46
            goto L32
        L27:
            if (this.f40065c == true) goto L31;
            if (r7 != null) goto L31;
            r9.u();     // Catch: Throwable -> L46
            r13 = -1;
            r8 = true;
        L31:
            r13 = -1;
            goto L32
        L45:
            throw new IOException("stream closed");     // Catch: Throwable -> L46
        L49:
            th = move-exception;
            throw th;
        L53:
            throw new IllegalArgumentException(("byteCount < 0: " + r19).toString());
        L5:
            r6 = false;
            goto L6
        }

        private final void a(long r3) {
            i r0 = this.f40063a;
            if (okhttp3.internal.c.f == true) goto L5;
        L9:
            this.f40063a.b().a(r3);
            return;
        L5:
            if (Thread.holdsLock(r0) == false) goto L9;
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + r0);
        }

        public final void a(e.g r12, long r13) {
            e.g r14 = (e.g) ZeusTransformUtils.wrapperContextForParams(r12, e.g.class, "com.obric.aiagent.plugin");
            o.e(r14, DBHelper.BATTERY_COL_SOURCE);
            i r0 = this.f40063a;
            if (okhttp3.internal.c.f == true) goto L5;
        L9:
            long r1 = r13;
        L11:
            if (r1 <= 0) goto L51;
            i r4 = this.f40063a;
            monitor-enter(r4);
            boolean r5 = this.f40065c;     // Catch: Throwable -> L48
            boolean r7 = true;
            if ((this.f40067e.b() + r1) <= this.f40064b) goto L17;
            boolean r6 = true;
        L18:
            x r9 = x.f38692a;     // Catch: Throwable -> L48
            monitor-exit(r4);
            if (r6 == true) goto L21;
            if (r5 == true) goto L24;
            long r8 = r14.a(this.f40066d, r1);
            if (r8 == (-1)) goto L47;
            r1 = r1 - r8;
            i r10 = this.f40063a;
            monitor-enter(r10);
            if (this.g == false) goto L34;
            this.f40066d.x();     // Catch: Throwable -> L43
        L40:
            x r2 = x.f38692a;     // Catch: Throwable -> L43
            monitor-exit(r10);
            goto L11
        L34:
            if (this.f40067e.b() == 0) goto L37;
            r7 = false;
        L37:
            this.f40067e.a((aa) ZeusTransformUtils.preCheckCast(this.f40066d, aa.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L43
            if (r7 == false) goto L40;
            o.a(r10, "null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L43
            ZeusTransformUtils.preCheckCast(r10, Object.class, "com.obric.aiagent.plugin").notifyAll();     // Catch: Throwable -> L43
        L43:
            th = move-exception;
            throw th;
        L47:
            throw new EOFException();
        L24:
            r14.h(r1);
            return;
        L21:
            r14.h(r1);
            this.f40063a.a(okhttp3.internal.g.b.f39967e);
            return;
        L17:
            r6 = false;
        L48:
            th = move-exception;
            throw th;
        L51:
            a(r13);
            return;
        L5:
            if (Thread.holdsLock(r0) == false) goto L9;
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + r0);
        }

        @Override // e.aa
        public ab a() {
            return (ab) ZeusTransformUtils.preCheckCast(this.f40063a.i(), ab.class, "com.obric.aiagent.plugin");
        }

        @Override // e.aa, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            i r0 = this.f40063a;
            monitor-enter(r0);
            this.g = true;     // Catch: Throwable -> L12
            long r1 = this.f40067e.b();     // Catch: Throwable -> L12
            this.f40067e.x();     // Catch: Throwable -> L12
            o.a(r0, "null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L12
            ZeusTransformUtils.preCheckCast(r0, Object.class, "com.obric.aiagent.plugin").notifyAll();     // Catch: Throwable -> L12
            x r3 = x.f38692a;     // Catch: Throwable -> L12
            monitor-exit(r0);
            if (r1 <= 0) goto L10;
            a(r1);
        L10:
            this.f40063a.s();
            return;
        L12:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: compiled from: Http2Stream.kt */
    public final class d extends e.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f40068a;

        public d(i r1) {
            this.f40068a = r1;
        }

        @Override // e.c
        public void a() {
            this.f40068a.a(okhttp3.internal.g.b.j);
            this.f40068a.b().l();
        }

        @Override // e.c
        public IOException a(IOException r3) {
            SocketTimeoutException r2 = new SocketTimeoutException("timeout");
            if (r3 == null) goto L6;
            r2.initCause((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin"));
        L6:
            return (IOException) ZeusTransformUtils.preCheckCast(r2, IOException.class, "com.obric.aiagent.plugin");
        }

        public final void b() {
            if (t_() == true) goto L6;
            return;
        L6:
            throw a(null);
        }
    }

    static {
        f40053a = new a(null);
    }

    public i(int r4, f r5, boolean r6, boolean r7, u r8) {
        o.e(r5, WsConstants.KEY_CONNECTION);
        this.f40054b = r4;
        this.f40055c = r5;
        this.g = r5.h().b();
        ArrayDeque<u> r9 = new ArrayDeque();
        this.h = r9;
        this.j = new c(this, r5.g().b(), r7);
        this.k = new b(this, r6);
        this.l = new d(this);
        this.m = new d(this);
        if (r8 == null) goto L10;
        if ((!n()) == false) goto L8;
        ((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.aiagent.plugin")).add(r8);
        return;
    L8:
        throw new IllegalStateException("locally-initiated streams shouldn't have headers yet".toString());
    L10:
        if (n() == false) goto L13;
        return;
    L13:
        throw new IllegalStateException("remotely-initiated streams should have headers".toString());
    }

    public final int a() {
        return this.f40054b;
    }

    public final f b() {
        return this.f40055c;
    }

    public final long c() {
        return this.f40056d;
    }

    public final void a(long r1) {
        this.f40056d = r1;
    }

    public final long d() {
        return this.f40057e;
    }

    public final void b(long r1) {
        this.f40057e = r1;
    }

    public final long e() {
        return this.f;
    }

    public final void c(long r1) {
        this.f = r1;
    }

    public final long f() {
        return this.g;
    }

    public final c g() {
        return this.j;
    }

    public final b h() {
        return this.k;
    }

    public final d i() {
        return this.l;
    }

    public final d j() {
        return this.m;
    }

    public final synchronized okhttp3.internal.g.b k() {
        monitor-enter(this);
        okhttp3.internal.g.b r0 = this.n;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final IOException l() {
        return this.o;
    }

    public final synchronized boolean m() {
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L5:
        if (this.n == null) goto L9;
        monitor-exit(this);
        return false;
    L9:
        if (this.j.b() == true) goto L13;
        if (this.j.c() == true) goto L13;
    L21:
        monitor-exit(this);
        return true;
    L13:
        if (this.k.b() == false) goto L15;
    L16:
        if (this.i == false) goto L21;
        monitor-exit(this);
        return false;
    L15:
        if (this.k.c() == false) goto L21;
        goto L16
    }

    public final boolean n() {
        if ((this.f40054b & 1) != 1) goto L5;
        boolean r0 = true;
    L7:
        if (this.f40055c.a() != r0) goto L10;
        return true;
    L10:
        return false;
    L5:
        r0 = false;
        goto L7
    }

    public final synchronized u o() {
        monitor-enter(this);
        this.l.c();     // Catch: Throwable -> L24
    L28:
    L21:
        th = move-exception;
        this.l.b();     // Catch: Throwable -> L24
        throw th;     // Catch: Throwable -> L24
    L5:
        if (this.h.isEmpty() == false) goto L10;
        if (this.n != null) goto L10;
        u();     // Catch: Throwable -> L21
    L10:
        this.l.b();     // Catch: Throwable -> L24
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.h, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L15;
        u r0 = this.h.removeFirst();     // Catch: Throwable -> L24
        o.c(r0, "headersQueue.removeFirst()");     // Catch: Throwable -> L24
        u r1 = (u) ZeusTransformUtils.preCheckCast(r0, u.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L24
        monitor-exit(this);
        return r1;
    L15:
        IOException r2 = this.o;     // Catch: Throwable -> L24
        if (r2 == null) goto L19;
        Object r3 = ZeusTransformUtils.preCheckCast(r2, Throwable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L24
    L20:
        throw ((Throwable) r3);     // Catch: Throwable -> L24
    L19:
        okhttp3.internal.g.b r4 = this.n;     // Catch: Throwable -> L24
        o.a(r4);     // Catch: Throwable -> L24
        r3 = ZeusTransformUtils.preCheckCast(new n(r4), Throwable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    public final ab p() {
        return (ab) ZeusTransformUtils.preCheckCast(this.l, ab.class, "com.obric.aiagent.plugin");
    }

    public final ab q() {
        return (ab) ZeusTransformUtils.preCheckCast(this.m, ab.class, "com.obric.aiagent.plugin");
    }

    public final y r() {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.i == false) goto L6;
    L9:
        boolean r0 = true;
    L10:
        if (r0 == false) goto L16;
        x r1 = x.f38692a;     // Catch: Throwable -> L17
        monitor-exit(this);
        return (y) ZeusTransformUtils.preCheckCast(this.k, y.class, "com.obric.aiagent.plugin");
    L16:
        throw new IllegalStateException("reply before requesting the sink".toString());     // Catch: Throwable -> L17
    L6:
        if (n() == true) goto L9;
        r0 = false;
        goto L10
    }

    public final void a(okhttp3.internal.g.b r2, IOException r3) {
        o.e(r2, "rstStatusCode");
        if (b(r2, r3) == true) goto L5;
        return;
    L5:
        this.f40055c.b(this.f40054b, r2);
    }

    public final void a(okhttp3.internal.g.b r2) {
        o.e(r2, "errorCode");
        if (b(r2, null) == true) goto L5;
        return;
    L5:
        this.f40055c.a(this.f40054b, r2);
    }

    public final synchronized void b(okhttp3.internal.g.b r2) {
        monitor-enter(this);
        o.e(r2, "errorCode");     // Catch: Throwable -> L8
        if (this.n != null) goto L6;
        this.n = r2;     // Catch: Throwable -> L8
        o.a(this, "null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L8
        ZeusTransformUtils.preCheckCast(this, Object.class, "com.obric.aiagent.plugin").notifyAll();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void d(long r3) {
        this.g += r3;
        if (r3 <= 0) goto L6;
        o.a(this, "null cannot be cast to non-null type java.lang.Object");
        ZeusTransformUtils.preCheckCast(this, Object.class, "com.obric.aiagent.plugin").notifyAll();
        return;
    }

    public final void t() {
        if (this.k.c() == true) goto L18;
        if (this.k.b() == true) goto L16;
        if (this.n == null) goto L14;
        Object r0 = this.o;
        if (r0 != null) goto L13;
        okhttp3.internal.g.b r2 = this.n;
        o.a(r2);
        r0 = new n(r2);
    L13:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(r0, Throwable.class, "com.obric.aiagent.plugin"));
    L14:
        return;
    L16:
        throw new IOException("stream finished");
    L18:
        throw new IOException("stream closed");
    }

    private final boolean b(okhttp3.internal.g.b r3, IOException r4) {
        if (okhttp3.internal.c.f == true) goto L5;
    L9:
        monitor-enter(this);
    L25:
        th = move-exception;
        throw th;
    L12:
        if (this.n == null) goto L15;
        monitor-exit(this);
        return false;
    L15:
        this.n = r3;     // Catch: Throwable -> L25
        this.o = r4;     // Catch: Throwable -> L25
        o.a(this, "null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L25
        ZeusTransformUtils.preCheckCast(this, Object.class, "com.obric.aiagent.plugin").notifyAll();     // Catch: Throwable -> L25
        if (this.j.b() == true) goto L18;
    L21:
        x r5 = x.f38692a;     // Catch: Throwable -> L25
        monitor-exit(this);
        this.f40055c.c(this.f40054b);
        return true;
    L18:
        if (this.k.b() == false) goto L21;
        monitor-exit(this);
        return false;
    L5:
        if (Thread.holdsLock(this) == false) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    public final void a(e.g r3, int r4) {
        e.g r5 = (e.g) ZeusTransformUtils.wrapperContextForParams(r3, e.g.class, "com.obric.aiagent.plugin");
        o.e(r5, DBHelper.BATTERY_COL_SOURCE);
        if (okhttp3.internal.c.f == true) goto L5;
    L9:
        this.j.a(r5, r4);
        return;
    L5:
        if (Thread.holdsLock(this) == false) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    public final void a(u r5, boolean r6) {
        o.e(r5, "headers");
        if (okhttp3.internal.c.f == true) goto L5;
    L9:
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L11:
        if (this.i == false) goto L15;
        if (r6 == false) goto L15;
        this.j.a(r5);     // Catch: Throwable -> L23
    L16:
        if (r6 == false) goto L18;
        this.j.a(true);     // Catch: Throwable -> L23
    L18:
        boolean r7 = m();     // Catch: Throwable -> L23
        o.a(this, "null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L23
        ZeusTransformUtils.preCheckCast(this, Object.class, "com.obric.aiagent.plugin").notifyAll();     // Catch: Throwable -> L23
        x r8 = x.f38692a;     // Catch: Throwable -> L23
        monitor-exit(this);
        if (r7 == true) goto L28;
        this.f40055c.c(this.f40054b);
        return;
    L28:
        return;
    L15:
        this.i = true;     // Catch: Throwable -> L23
        ((Collection) ZeusTransformUtils.preCheckCast(this.h, Collection.class, "com.obric.aiagent.plugin")).add(r5);     // Catch: Throwable -> L23
        goto L16
    L5:
        if (Thread.holdsLock(this) == false) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    public final void s() {
        if (okhttp3.internal.c.f == true) goto L5;
    L9:
        monitor-enter(this);
    L27:
        th = move-exception;
        throw th;
    L11:
        if (this.j.b() == false) goto L13;
    L19:
        boolean r0 = false;
    L20:
        boolean r1 = m();     // Catch: Throwable -> L27
        x r2 = x.f38692a;     // Catch: Throwable -> L27
        monitor-exit(this);
        if (r0 == false) goto L24;
        a(okhttp3.internal.g.b.j, null);
        return;
    L24:
        if (r1 == true) goto L33;
        this.f40055c.c(this.f40054b);
        return;
    L33:
        return;
    L13:
        if (this.j.c() == false) goto L19;
        if (this.k.b() == false) goto L17;
    L18:
        r0 = true;
        goto L20
    L17:
        if (this.k.c() == false) goto L19;
    L5:
        if (Thread.holdsLock(this) == false) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    public final void u() {
        o.a(this, "null cannot be cast to non-null type java.lang.Object");     // Catch: InterruptedException -> L4
        ZeusTransformUtils.preCheckCast(this, Object.class, "com.obric.aiagent.plugin").wait();     // Catch: InterruptedException -> L4
        return;
    L4:
        Thread.currentThread().interrupt();
        throw new InterruptedIOException();
    }
}

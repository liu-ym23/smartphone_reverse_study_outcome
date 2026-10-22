package okhttp3.internal.d;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;
import java.lang.ref.Reference;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import okhttp3.af;

/* JADX INFO: compiled from: RealConnectionPool.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f39898a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f39899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f39900c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final okhttp3.internal.c.c f39901d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final b f39902e;
    private final ConcurrentLinkedQueue<f> f;

    /* JADX INFO: compiled from: RealConnectionPool.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: RealConnectionPool.kt */
    public static final class b extends okhttp3.internal.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f39903a;

        b(g r3, String r4) {
            this.f39903a = r3;
            super(r4, false, 2, null);
        }

        @Override // okhttp3.internal.c.a
        public long a() {
            return this.f39903a.a(System.nanoTime());
        }
    }

    static {
        f39898a = new a(null);
    }

    public g(okhttp3.internal.c.d r3, int r4, long r5, TimeUnit r7) {
        o.e(r3, "taskRunner");
        o.e(r7, "timeUnit");
        this.f39899b = r4;
        this.f39900c = r7.toNanos(r5);
        this.f39901d = r3.c();
        this.f39902e = new b(this, okhttp3.internal.c.g + " ConnectionPool");
        this.f = new ConcurrentLinkedQueue();
        if (r5 <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException(("keepAliveDuration <= 0: " + r5).toString());
    L5:
        r2 = false;
        goto L6
    }

    public final boolean a(okhttp3.a r4, e r5, List<af> r6, boolean r7) {
        List<af> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        o.e(r4, SensitiveType.ADDRESS);
        o.e(r5, "call");
        Iterator<f> r3 = this.f.iterator();
    L4:
        if (r3.hasNext() == false) goto L22;
        f r0 = (f) ZeusTransformUtils.preCheckCast(r3.next(), f.class, "com.obric.aiagent.plugin");
        o.c(r0, WsConstants.KEY_CONNECTION);
        monitor-enter(r0);
        if (r7 == false) goto L11;
    L19:
        th = move-exception;
        throw th;
    L9:
        if (r0.g() == true) goto L11;
    L16:
        x r1 = x.f38692a;     // Catch: Throwable -> L19
        monitor-exit(r0);
    L11:
        if (r0.a(r4, r8) == false) goto L16;
        r5.b(r0);     // Catch: Throwable -> L19
        monitor-exit(r0);
        return true;
    L22:
        return false;
    }

    public final long a(long r11) {
        Iterator<f> r0 = this.f.iterator();
        int r1 = 0;
        long r4 = Long.MIN_VALUE;
        f r3 = null;
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L19;
        f r6 = (f) ZeusTransformUtils.preCheckCast(r0.next(), f.class, "com.obric.aiagent.plugin");
        o.c(r6, WsConstants.KEY_CONNECTION);
        monitor-enter(r6);
        if (a(r6, r11) <= 0) goto L10;
        Integer.valueOf(r2);     // Catch: Throwable -> L16
        r2 = r2 + 1;     // Catch: Throwable -> L16
    L14:
        monitor-exit(r6);
        goto L4
    L10:
        r1 = r1 + 1;     // Catch: Throwable -> L16
        long r7 = r11 - r6.f();     // Catch: Throwable -> L16
        if (r7 <= r4) goto L13;
        r3 = r6;
        r4 = r7;
    L13:
        x r8 = x.f38692a;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    L19:
        long r9 = this.f39900c;
        if (r4 < r9) goto L22;
    L31:
        o.a(r3);
        monitor-enter(r3);
    L49:
        th = move-exception;
        throw th;
    L35:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r3.e(), Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L40;
        monitor-exit(r3);
        return 0;
    L40:
        if ((r3.f() + r4) == r11) goto L43;
        monitor-exit(r3);
        return 0;
    L43:
        r3.a(true);     // Catch: Throwable -> L49
        this.f.remove(r3);     // Catch: Throwable -> L49
        monitor-exit(r3);
        okhttp3.internal.c.a(r3.b());
        if (this.f.isEmpty() == false) goto L48;
        this.f39901d.g();
    L48:
        return 0;
    L22:
        if (r1 > this.f39899b) goto L31;
        if (r1 > 0) goto L26;
        if (r2 <= 0) goto L29;
        return r9;
    L29:
        return -1;
    L26:
        return r9 - r4;
    }

    public final void a(f r8) {
        o.e(r8, WsConstants.KEY_CONNECTION);
        if (okhttp3.internal.c.f == true) goto L5;
    L9:
        this.f.add(r8);
        okhttp3.internal.c.c.a(this.f39901d, (okhttp3.internal.c.a) ZeusTransformUtils.preCheckCast(this.f39902e, okhttp3.internal.c.a.class, "com.obric.aiagent.plugin"), 0, 2, null);
        return;
    L5:
        if (Thread.holdsLock(r8) == true) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + r8);
    }

    public final boolean b(f r9) {
        o.e(r9, WsConstants.KEY_CONNECTION);
        if (okhttp3.internal.c.f == false) goto L10;
        if (Thread.holdsLock(r9) == true) goto L10;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + r9);
    L10:
        if (r9.c() == false) goto L12;
    L15:
        r9.a(true);
        this.f.remove(r9);
        if (this.f.isEmpty() == false) goto L20;
        this.f39901d.g();
        return true;
    L20:
        return true;
    L12:
        if (this.f39899b == 0) goto L15;
        okhttp3.internal.c.c.a(this.f39901d, (okhttp3.internal.c.a) ZeusTransformUtils.preCheckCast(this.f39902e, okhttp3.internal.c.a.class, "com.obric.aiagent.plugin"), 0, 2, null);
        return false;
    }

    private final int a(f r7, long r8) {
        if (okhttp3.internal.c.f == true) goto L5;
    L9:
        List<Reference<e>> r0 = r7.e();
        int r2 = 0;
    L11:
        if (r2 >= r0.size()) goto L20;
        Reference r3 = (Reference) ZeusTransformUtils.preCheckCast(r0.get(r2), Reference.class, "com.obric.aiagent.plugin");
        if (r3.get() != null) goto L14;
        o.a(r3, "null cannot be cast to non-null type okhttp3.internal.connection.RealCall.CallReference");
        e.b r4 = (e.b) ZeusTransformUtils.preCheckCast(r3, e.b.class, "com.obric.aiagent.plugin");
        okhttp3.internal.i.h.f40147b.a().a("A connection to " + r7.a().a().i() + " was leaked. Did you forget to close a response body?", r4.a());
        r0.remove(r2);
        r7.a(true);
        if (r0.isEmpty() == false) goto L11;
        r7.a(r8 - this.f39900c);
        return 0;
    L14:
        r2 = r2 + 1;
        goto L11
    L20:
        return r0.size();
    L5:
        if (Thread.holdsLock(r7) == true) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + r7);
    }
}

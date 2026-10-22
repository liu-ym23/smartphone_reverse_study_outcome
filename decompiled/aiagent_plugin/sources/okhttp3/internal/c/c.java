package okhttp3.internal.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;

/* JADX INFO: compiled from: TaskQueue.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f39842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f39843b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f39844c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private okhttp3.internal.c.a f39845d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<okhttp3.internal.c.a> f39846e;
    private boolean f;

    /* JADX INFO: compiled from: TaskQueue.kt */
    public static final class a extends okhttp3.internal.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.a.a<x> f39847a;

        public a(String r3, boolean r4, d.h.a.a<x> r5) {
            this.f39847a = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
            super(r3, r4);
        }

        @Override // okhttp3.internal.c.a
        public long a() {
            this.f39847a.invoke();
            return -1;
        }
    }

    public c(d r2, String r3) {
        o.e(r2, "taskRunner");
        o.e(r3, "name");
        this.f39842a = r2;
        this.f39843b = r3;
        this.f39846e = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
    }

    public final d a() {
        return this.f39842a;
    }

    public final String b() {
        return this.f39843b;
    }

    public final boolean c() {
        return this.f39844c;
    }

    public final void a(okhttp3.internal.c.a r1) {
        this.f39845d = r1;
    }

    public final okhttp3.internal.c.a d() {
        return this.f39845d;
    }

    public final List<okhttp3.internal.c.a> e() {
        return this.f39846e;
    }

    public final void a(boolean r1) {
        this.f = r1;
    }

    public final boolean f() {
        return this.f;
    }

    public static /* synthetic */ void a(c r0, okhttp3.internal.c.a r1, long r2, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L5;
        r2 = 0;
    L5:
        r0.a(r1, r2);
    }

    public final void a(okhttp3.internal.c.a r3, long r4) {
        o.e(r3, "task");
        d r0 = this.f39842a;
        monitor-enter(r0);
    L24:
        th = move-exception;
        throw th;
    L5:
        if (this.f39844c == false) goto L19;
        if (r3.c() == false) goto L14;
        if (d.f39848a.a().isLoggable(Level.FINE) == false) goto L11;
        b.a(r3, this, "schedule canceled (queue is shutdown)");     // Catch: Throwable -> L24
    L11:
        monitor-exit(r0);
        return;
    L14:
        if (d.f39848a.a().isLoggable(Level.FINE) == false) goto L17;
        b.a(r3, this, "schedule failed (queue is shutdown)");     // Catch: Throwable -> L24
    L17:
        throw new RejectedExecutionException();     // Catch: Throwable -> L24
    L19:
        if (a(r3, r4, false) == false) goto L21;
        this.f39842a.a(this);     // Catch: Throwable -> L24
    L21:
        x r2 = x.f38692a;     // Catch: Throwable -> L24
        monitor-exit(r0);
    }

    public final boolean a(okhttp3.internal.c.a r10, long r11, boolean r13) {
        o.e(r10, "task");
        r10.a(this);
        long r0 = this.f39842a.a().a();
        long r2 = r0 + r11;
        int r4 = this.f39846e.indexOf(r10);
        if (r4 != (-1)) goto L5;
    L11:
        r10.a(r2);
        if (d.f39848a.a().isLoggable(Level.FINE) == false) goto L17;
        if (r13 == false) goto L15;
        String r14 = "run again after " + b.a(r2 - r0);
    L16:
        b.a(r10, this, r14);
        goto L17
    L15:
        r14 = "scheduled after " + b.a(r2 - r0);
    L17:
        Iterator<okhttp3.internal.c.a> r15 = this.f39846e.iterator();
        int r3 = 0;
    L19:
        if (r15.hasNext() == false) goto L27;
        if ((((okhttp3.internal.c.a) ZeusTransformUtils.preCheckCast(r15.next(), okhttp3.internal.c.a.class, "com.obric.aiagent.plugin")).e() - r0) <= r11) goto L23;
        boolean r5 = true;
    L24:
        if (r5 == true) goto L28;
        r3 = r3 + 1;
    L28:
        if (r3 != (-1)) goto L30;
        r3 = this.f39846e.size();
    L30:
        this.f39846e.add(r3, r10);
        if (r3 == 0) goto L33;
        return false;
    L33:
        return true;
    L23:
        r5 = false;
        goto L24
    L27:
        r3 = -1;
        goto L28
    L5:
        if (r10.e() <= r2) goto L7;
        this.f39846e.remove(r4);
        goto L11
    L7:
        if (d.f39848a.a().isLoggable(Level.FINE) == false) goto L9;
        b.a(r10, this, "already scheduled");
    L9:
        return false;
    }

    public final boolean i() {
        okhttp3.internal.c.a r0 = this.f39845d;
        if (r0 == null) goto L7;
        o.a(r0);
        if (r0.c() == false) goto L7;
        this.f = true;
    L7:
        boolean r1 = false;
        int r2 = this.f39846e.size() - 1;
    L9:
        if ((-1) >= r2) goto L17;
        if (((okhttp3.internal.c.a) ZeusTransformUtils.preCheckCast(this.f39846e.get(r2), okhttp3.internal.c.a.class, "com.obric.aiagent.plugin")).c() == false) goto L16;
        okhttp3.internal.c.a r3 = (okhttp3.internal.c.a) ZeusTransformUtils.preCheckCast(this.f39846e.get(r2), okhttp3.internal.c.a.class, "com.obric.aiagent.plugin");
        if (d.f39848a.a().isLoggable(Level.FINE) == false) goto L15;
        b.a(r3, this, "canceled");
    L15:
        this.f39846e.remove(r2);
        r1 = true;
    L16:
        r2 = r2 - 1;
        goto L9
    L17:
        return r1;
    }

    public String toString() {
        return this.f39843b;
    }

    public final void g() {
        if (okhttp3.internal.c.f == true) goto L5;
    L9:
        d r0 = this.f39842a;
        monitor-enter(r0);
    L17:
        th = move-exception;
        throw th;
    L12:
        if (i() == false) goto L14;
        this.f39842a.a(this);     // Catch: Throwable -> L17
    L14:
        x r3 = x.f38692a;     // Catch: Throwable -> L17
        monitor-exit(r0);
        return;
    L5:
        if (Thread.holdsLock(this) == false) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    public final void h() {
        if (okhttp3.internal.c.f == true) goto L5;
    L9:
        d r0 = this.f39842a;
        monitor-enter(r0);
        this.f39844c = true;     // Catch: Throwable -> L18
        if (i() == false) goto L15;
        this.f39842a.a(this);     // Catch: Throwable -> L18
    L15:
        x r3 = x.f38692a;     // Catch: Throwable -> L18
        monitor-exit(r0);
        return;
    L18:
        th = move-exception;
        throw th;
    L5:
        if (Thread.holdsLock(this) == false) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }
}

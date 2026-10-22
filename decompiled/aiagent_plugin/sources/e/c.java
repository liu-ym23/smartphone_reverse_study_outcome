package e;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bytedance.apm.battery.dao.DBHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: AsyncTimeout.kt */
/* JADX INFO: loaded from: classes4.dex */
public class c extends ab {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f38706b = null;
    private static final ReentrantLock g = null;
    private static final Condition h = null;
    private static final long i = 0;
    private static final long j = 0;
    private static c k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f38707a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private c f38708e;
    private long f;

    /* JADX INFO: compiled from: AsyncTimeout.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public static final /* synthetic */ void a(a r0, c r1, long r2, boolean r4) {
            r0.a(r1, r2, r4);
        }

        public static final /* synthetic */ boolean a(a r0, c r1) {
            return r0.a(r1);
        }

        public final ReentrantLock a() {
            return c.f();
        }

        public final Condition b() {
            return c.g();
        }

        private final void a(c r5, long r6, boolean r8) {
            Lock r4 = (Lock) ZeusTransformUtils.preCheckCast(c.f38706b.a(), Lock.class, "com.obric.aiagent.plugin");
            r4.lock();
        L33:
            th = move-exception;
            r4.unlock();
            throw th;
        L4:
            if ((!c.c(r5)) == false) goto L32;
            c.a(r5, true);     // Catch: Throwable -> L33
            if (c.e() != null) goto L8;
            a r0 = c.f38706b;     // Catch: Throwable -> L33
            c.a(new c());     // Catch: Throwable -> L33
            new b().start();     // Catch: Throwable -> L33
        L8:
            long r1 = System.nanoTime();     // Catch: Throwable -> L33
            if (r6 == 0) goto L12;
            if (r8 == false) goto L12;
            c.b(r5, Math.min(r6, r5.d() - r1) + r1);     // Catch: Throwable -> L33
        L16:
            long r7 = c.a(r5, r1);     // Catch: Throwable -> L33
            c r9 = c.e();     // Catch: Throwable -> L33
            d.h.b.o.a(r9);     // Catch: Throwable -> L33
        L18:
            if (c.b(r9) == null) goto L23;
            c r2 = c.b(r9);     // Catch: Throwable -> L33
            d.h.b.o.a(r2);     // Catch: Throwable -> L33
            if (r7 < c.a(r2, r1)) goto L23;
            r9 = c.b(r9);     // Catch: Throwable -> L33
            d.h.b.o.a(r9);     // Catch: Throwable -> L33
        L23:
            c.a(r5, c.b(r9));     // Catch: Throwable -> L33
            c.a(r9, r5);     // Catch: Throwable -> L33
            if (r9 != c.e()) goto L26;
            c.f38706b.b().signal();     // Catch: Throwable -> L33
        L26:
            d.x r10 = d.x.f38692a;     // Catch: Throwable -> L33
            r4.unlock();
            return;
        L12:
            if (r6 == 0) goto L14;
            c.b(r5, r6 + r1);     // Catch: Throwable -> L33
            goto L16
        L14:
            if (r8 == false) goto L30;
            c.b(r5, r5.d());     // Catch: Throwable -> L33
            goto L16
        L30:
            throw new AssertionError();     // Catch: Throwable -> L33
        L32:
            throw new IllegalStateException("Unbalanced enter/exit".toString());     // Catch: Throwable -> L33
        }

        private final boolean a(c r4) {
            Lock r3 = (Lock) ZeusTransformUtils.preCheckCast(c.f38706b.a(), Lock.class, "com.obric.aiagent.plugin");
            r3.lock();
        L19:
            th = move-exception;
            r3.unlock();
            throw th;
        L5:
            if (c.c(r4) == true) goto L8;
            r3.unlock();
            return false;
        L8:
            c.a(r4, false);     // Catch: Throwable -> L19
            c r0 = c.e();     // Catch: Throwable -> L19
        L9:
            if (r0 == null) goto L17;
            if (c.b(r0) == r4) goto L12;
            r0 = c.b(r0);     // Catch: Throwable -> L19
            goto L9
        L12:
            c.a(r0, c.b(r4));     // Catch: Throwable -> L19
            c.a(r4, null);     // Catch: Throwable -> L19
            r3.unlock();
            return false;
        L17:
            r3.unlock();
            return true;
        }

        public final c c() {
            c r0 = c.e();
            d.h.b.o.a(r0);
            c r1 = c.b(r0);
            if (r1 != null) goto L10;
            long r2 = System.nanoTime();
            b().await(c.h(), TimeUnit.MILLISECONDS);
            c r6 = c.e();
            d.h.b.o.a(r6);
            if (c.b(r6) == null) goto L7;
            return null;
        L7:
            if ((System.nanoTime() - r2) >= c.i()) goto L9;
            return null;
        L9:
            return c.e();
        L10:
            long r3 = c.a(r1, System.nanoTime());
            if (r3 <= 0) goto L14;
            b().await(r3, TimeUnit.NANOSECONDS);
            return null;
        L14:
            c r7 = c.e();
            d.h.b.o.a(r7);
            c.a(r7, c.b(r1));
            c.a(r1, null);
            return r1;
        }
    }

    /* JADX INFO: compiled from: AsyncTimeout.kt */
    private static final class b extends Thread {
        public b() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
        L18:
            Lock r2 = (Lock) ZeusTransformUtils.preCheckCast(c.f38706b.a(), Lock.class, "com.obric.aiagent.plugin");     // Catch: InterruptedException -> L15
            r2.lock();     // Catch: InterruptedException -> L15
            c r0 = c.f38706b.c();     // Catch: Throwable -> L12
            if (r0 != c.e()) goto L8;
            a r1 = c.f38706b;     // Catch: Throwable -> L12
            c.a(null);     // Catch: Throwable -> L12
            goto L18
        L6:
            r2.unlock();     // Catch: InterruptedException -> L15
            return;
        L8:
            d.x r3 = d.x.f38692a;     // Catch: Throwable -> L12
            r2.unlock();     // Catch: InterruptedException -> L15
            if (r0 == null) goto L18;
            r0.a();     // Catch: InterruptedException -> L15
        L12:
            th = move-exception;
            r2.unlock();     // Catch: InterruptedException -> L15
            throw th;     // Catch: InterruptedException -> L15
        }
    }

    /* JADX INFO: renamed from: e.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AsyncTimeout.kt */
    public static final class C1043c implements y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f38709a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ y f38710b;

        C1043c(c r3, y r4) {
            y r5 = (y) ZeusTransformUtils.wrapperContextForParams(r4, y.class, "com.obric.aiagent.plugin");
            this.f38709a = r3;
            this.f38710b = r5;
        }

        @Override // e.y
        public /* synthetic */ ab a() {
            return (ab) ZeusTransformUtils.preCheckCast(b(), ab.class, "com.obric.aiagent.plugin");
        }

        @Override // e.y
        public void a_(e r8, long r9) {
            d.h.b.o.e(r8, DBHelper.BATTERY_COL_SOURCE);
            e.b.a(r8.b(), 0, r9);
        L3:
            long r0 = 0;
            if (r9 <= 0) goto L31;
            v r2 = r8.f38713a;
            d.h.b.o.a(r2);
        L7:
            if (r0 >= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) goto L12;
            r0 = r0 + ((long) (r2.f38758d - r2.f38757c));
            if (r0 >= r9) goto L10;
            r2 = r2.g;
            d.h.b.o.a(r2);
            goto L7
        L10:
            r0 = r9;
        L12:
            c r3 = this.f38709a;
            y r4 = this.f38710b;
            r3.c();
            r4.a_(r8, r0);     // Catch: Throwable -> L19 IOException -> L21
            d.x r5 = d.x.f38692a;     // Catch: Throwable -> L19 IOException -> L21
        L15:
            if (r3.t_() == true) goto L18;
            r9 = r9 - r0;
            goto L3
        L18:
            throw r3.b(null);
        L21:
            e = move-exception;
            if (r3.t_() == true) goto L27;
            Object r7 = ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        L28:
            throw ((Throwable) r7);     // Catch: Throwable -> L19
        L27:
            r7 = ZeusTransformUtils.preCheckCast(r3.b(e), Throwable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            r3.t_();
            throw th;
        }

        @Override // e.y, java.io.Flushable
        public void flush() {
            c r0 = this.f38709a;
            y r3 = this.f38710b;
            r0.c();
            r3.flush();     // Catch: Throwable -> L9 IOException -> L11
            d.x r4 = d.x.f38692a;     // Catch: Throwable -> L9 IOException -> L11
        L5:
            if (r0.t_() == true) goto L8;
            return;
        L8:
            throw r0.b(null);
        L9:
            th = move-exception;
            r0.t_();
            throw th;
        L11:
            e = move-exception;
            if (r0.t_() == true) goto L17;
            Object r5 = ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        L18:
            throw ((Throwable) r5);     // Catch: Throwable -> L9
        L17:
            r5 = ZeusTransformUtils.preCheckCast(r0.b(e), Throwable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
            goto L18
        }

        @Override // e.y, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            c r0 = this.f38709a;
            y r3 = this.f38710b;
            r0.c();
            r3.close();     // Catch: Throwable -> L9 IOException -> L11
            d.x r4 = d.x.f38692a;     // Catch: Throwable -> L9 IOException -> L11
        L5:
            if (r0.t_() == true) goto L8;
            return;
        L8:
            throw r0.b(null);
        L9:
            th = move-exception;
            r0.t_();
            throw th;
        L11:
            e = move-exception;
            if (r0.t_() == true) goto L17;
            Object r5 = ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        L18:
            throw ((Throwable) r5);     // Catch: Throwable -> L9
        L17:
            r5 = ZeusTransformUtils.preCheckCast(r0.b(e), Throwable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
            goto L18
        }

        public c b() {
            return this.f38709a;
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.f38710b + ')';
        }
    }

    /* JADX INFO: compiled from: AsyncTimeout.kt */
    public static final class d implements aa {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f38711a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ aa f38712b;

        d(c r3, aa r4) {
            aa r5 = (aa) ZeusTransformUtils.wrapperContextForParams(r4, aa.class, "com.obric.aiagent.plugin");
            this.f38711a = r3;
            this.f38712b = r5;
        }

        @Override // e.aa
        public /* synthetic */ ab a() {
            return (ab) ZeusTransformUtils.preCheckCast(b(), ab.class, "com.obric.aiagent.plugin");
        }

        @Override // e.aa
        public long a(e r2, long r3) {
            d.h.b.o.e(r2, "sink");
            c r0 = this.f38711a;
            aa r1 = this.f38712b;
            r0.c();
            long r4 = r1.a(r2, r3);     // Catch: Throwable -> L9 IOException -> L11
        L5:
            if (r0.t_() == true) goto L8;
            return r4;
        L8:
            throw r0.b(null);
        L11:
            e = move-exception;
            if (r0.t_() == true) goto L17;
            Object r5 = ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        L18:
            throw ((Throwable) r5);     // Catch: Throwable -> L9
        L17:
            r5 = ZeusTransformUtils.preCheckCast(r0.b(e), Throwable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            r0.t_();
            throw th;
        }

        @Override // e.aa, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            c r0 = this.f38711a;
            aa r3 = this.f38712b;
            r0.c();
            r3.close();     // Catch: Throwable -> L9 IOException -> L11
            d.x r4 = d.x.f38692a;     // Catch: Throwable -> L9 IOException -> L11
        L5:
            if (r0.t_() == true) goto L8;
            return;
        L8:
            throw r0.b(null);
        L9:
            th = move-exception;
            r0.t_();
            throw th;
        L11:
            e = move-exception;
            if (r0.t_() == true) goto L17;
            Object r5 = ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        L18:
            throw ((Throwable) r5);     // Catch: Throwable -> L9
        L17:
            r5 = ZeusTransformUtils.preCheckCast(r0.b(e), Throwable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
            goto L18
        }

        public c b() {
            return this.f38711a;
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.f38712b + ')';
        }
    }

    public void a() {
    }

    public c() {
    }

    public static final /* synthetic */ long a(c r0, long r1) {
        return r0.b(r1);
    }

    public static final /* synthetic */ void a(c r0) {
        k = r0;
    }

    public static final /* synthetic */ void a(c r0, c r1) {
        r0.f38708e = r1;
    }

    public static final /* synthetic */ void a(c r0, boolean r1) {
        r0.f38707a = r1;
    }

    public static final /* synthetic */ c b(c r0) {
        return r0.f38708e;
    }

    public static final /* synthetic */ void b(c r0, long r1) {
        r0.f = r1;
    }

    public static final /* synthetic */ boolean c(c r0) {
        return r0.f38707a;
    }

    public static final /* synthetic */ c e() {
        return k;
    }

    public static final /* synthetic */ ReentrantLock f() {
        return g;
    }

    public static final /* synthetic */ Condition g() {
        return h;
    }

    public static final /* synthetic */ long h() {
        return i;
    }

    public static final /* synthetic */ long i() {
        return j;
    }

    public final void c() {
        long r0 = y_();
        boolean r2 = u_();
        if (r0 != 0) goto L6;
        if (r2 == true) goto L6;
        return;
    L6:
        a.a(f38706b, this, r0, r2);
    }

    public final boolean t_() {
        return a.a(f38706b, this);
    }

    private final long b(long r3) {
        return this.f - r3;
    }

    public final y a(y r3) {
        y r4 = (y) ZeusTransformUtils.wrapperContextForParams(r3, y.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "sink");
        return (y) ZeusTransformUtils.preCheckCast(new C1043c(this, r4), y.class, "com.obric.aiagent.plugin");
    }

    public final aa a(aa r3) {
        aa r4 = (aa) ZeusTransformUtils.wrapperContextForParams(r3, aa.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, DBHelper.BATTERY_COL_SOURCE);
        return (aa) ZeusTransformUtils.preCheckCast(new d(this, r4), aa.class, "com.obric.aiagent.plugin");
    }

    public final IOException b(IOException r1) {
        return a(r1);
    }

    public IOException a(IOException r3) {
        InterruptedIOException r2 = new InterruptedIOException("timeout");
        if (r3 == null) goto L6;
        r2.initCause((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin"));
    L6:
        return (IOException) ZeusTransformUtils.preCheckCast(r2, IOException.class, "com.obric.aiagent.plugin");
    }

    static {
        f38706b = new a(null);
        ReentrantLock r0 = new ReentrantLock();
        g = r0;
        Condition r1 = r0.newCondition();
        d.h.b.o.c(r1, "newCondition(...)");
        h = r1;
        long r2 = TimeUnit.SECONDS.toMillis(60);
        i = r2;
        j = TimeUnit.MILLISECONDS.toNanos(r2);
    }
}

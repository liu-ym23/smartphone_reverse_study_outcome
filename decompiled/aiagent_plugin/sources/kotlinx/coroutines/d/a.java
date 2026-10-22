package kotlinx.coroutines.d;

import android.support.v4.media.session.PlaybackStateCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.h.b.z;
import d.x;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.internal.ag;
import kotlinx.coroutines.internal.al;

/* JADX INFO: compiled from: CoroutineScheduler.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a implements Closeable, Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1056a f39218a = null;
    public static final al i = null;
    private static final /* synthetic */ AtomicLongFieldUpdater j = null;
    private static final /* synthetic */ AtomicLongFieldUpdater k = null;
    private static final /* synthetic */ AtomicIntegerFieldUpdater l = null;
    private volatile /* synthetic */ int _isTerminated$volatile;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f39219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f39220c;
    private volatile /* synthetic */ long controlState$volatile;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f39221d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f39222e;
    public final kotlinx.coroutines.d.d f;
    public final kotlinx.coroutines.d.d g;
    public final ag<c> h;
    private volatile /* synthetic */ long parkedWorkersStack$volatile;

    /* JADX INFO: renamed from: kotlinx.coroutines.d.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CoroutineScheduler.kt */
    public static final class C1056a {
        public /* synthetic */ C1056a(d.h.b.h r1) {
            this();
        }

        private C1056a() {
        }
    }

    /* JADX INFO: compiled from: CoroutineScheduler.kt */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f39223a = null;

        static {
            int[] r0 = new int[d.values().length];
            r0[d.f39231c.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[d.f39230b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[d.f39229a.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[d.f39232d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[d.f39233e.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f39223a = r0;
        }
    }

    /* JADX INFO: compiled from: CoroutineScheduler.kt */
    public final class c extends Thread {
        private static final /* synthetic */ AtomicIntegerFieldUpdater i = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final n f39224a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public d f39225b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f39226c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f39227d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final z.f<h> f39228e;
        private long f;
        private long g;
        private int h;
        private volatile int indexInArray;
        private volatile Object nextParkedWorker;
        private volatile /* synthetic */ int workerCtl$volatile;

        static {
            i = AtomicIntegerFieldUpdater.newUpdater(c.class, "workerCtl$volatile");
        }

        public static final /* synthetic */ AtomicIntegerFieldUpdater c() {
            return i;
        }

        private c(a r3) {
            this.f39227d = r3;
            setDaemon(true);
            setContextClassLoader(r3.getClass().getClassLoader());
            this.f39224a = new n();
            this.f39228e = new z.f();
            this.f39225b = d.f39232d;
            this.nextParkedWorker = a.i;
            c r4 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.aiagent.plugin");
            int r5 = (int) System.nanoTime();
            if (r5 != 0) goto L6;
            r5 = 42;
        L6:
            this.h = r5;
        }

        public static final /* synthetic */ a a(c r0) {
            return r0.f39227d;
        }

        public final int a() {
            return this.indexInArray;
        }

        public final void a(int r3) {
            StringBuilder r0 = new StringBuilder().append(this.f39227d.f39222e).append("-worker-");
            if (r3 != 0) goto L5;
            String r1 = "TERMINATED";
        L6:
            setName(r0.append(r1).toString());
            this.indexInArray = r3;
            return;
        L5:
            r1 = String.valueOf(r3);
            goto L6
        }

        public c(a r1, int r2) {
            this(r1);
            a(r2);
        }

        public final void a(Object r1) {
            this.nextParkedWorker = r1;
        }

        public final Object b() {
            return this.nextParkedWorker;
        }

        private final boolean d() {
            if (this.f39225b == d.f39229a) goto L14;
            a r0 = this.f39227d;
            AtomicLongFieldUpdater r1 = a.c();
        L6:
            long r6 = r1.get(r0);
            if (((int) ((9223367638808264704L & r6) >> 42)) == 0) goto L8;
            if (a.c().compareAndSet(r0, r6, r6 - 4398046511104L) == false) goto L6;
            boolean r2 = true;
        L12:
            if (r2 == false) goto L18;
            this.f39225b = d.f39229a;
            goto L14
        L18:
            return false;
        L8:
            r2 = false;
        L14:
            return true;
        }

        public final boolean a(d r7) {
            d r0 = this.f39225b;
            if (r0 != d.f39229a) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == false) goto L8;
            a r2 = this.f39227d;
            a.c().addAndGet(r2, 4398046511104L);
        L8:
            if (r0 == r7) goto L10;
            this.f39225b = r7;
        L10:
            return r1;
        L5:
            r1 = false;
            goto L6
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            e();
        }

        private final void e() {
        L3:
            boolean r1 = false;
        L5:
            if (this.f39227d.a() == true) goto L17;
            if (this.f39225b == d.f39233e) goto L17;
            h r2 = a(this.f39226c);
            if (r2 != null) goto L10;
            this.f39226c = false;
            if (this.g != 0) goto L13;
            f();
            goto L5
        L13:
            if (r1 == true) goto L15;
            r1 = true;
            goto L5
        L15:
            a(d.f39231c);
            Thread.interrupted();
            LockSupport.parkNanos(this.g);
            this.g = 0;
            goto L3
        L10:
            this.g = 0;
            a(r2);
        L17:
            a(d.f39233e);
        }

        private final void f() {
            if (g() == true) goto L6;
            this.f39227d.a(this);
            return;
        L6:
            c().set(this, -1);
        L8:
            if (g() == false) goto L17;
            if (c().get(this) != (-1)) goto L22;
            if (this.f39227d.a() == true) goto L23;
            if (this.f39225b == d.f39233e) goto L24;
            a(d.f39231c);
            Thread.interrupted();
            h();
            goto L8
        L24:
            return;
        L23:
            return;
        L22:
            return;
        }

        private final boolean g() {
            if (this.nextParkedWorker == a.i) goto L5;
            return true;
        L5:
            return false;
        }

        private final void c(int r1) {
            if (r1 != 0) goto L5;
            return;
        L5:
            if (a(d.f39230b) == false) goto L8;
            this.f39227d.b();
            return;
        }

        private final void d(int r4) {
            if (r4 != 0) goto L4;
            return;
        L4:
            a r5 = this.f39227d;
            a.c().addAndGet(r5, -2097152);
            d r6 = this.f39225b;
            if (r6 != d.f39233e) goto L7;
            return;
        L7:
            if (aq.a() == true) goto L9;
        L16:
            this.f39225b = d.f39232d;
            return;
        L9:
            if (r6 != d.f39230b) goto L11;
            boolean r7 = true;
        L12:
            if (r7 == true) goto L16;
            throw new AssertionError();
        L11:
            r7 = false;
            goto L12
        }

        public final int b(int r3) {
            int r0 = this.h;
            int r1 = r0 ^ (r0 << 13);
            int r2 = r1 ^ (r1 >> 17);
            int r4 = r2 ^ (r2 << 5);
            this.h = r4;
            int r5 = r3 - 1;
            if ((r5 & r3) != 0) goto L7;
            return r5 & r4;
        L7:
            return (Integer.MAX_VALUE & r4) % r3;
        }

        private final void h() {
            if (this.f != 0) goto L5;
            this.f = System.nanoTime() + this.f39227d.f39221d;
        L5:
            LockSupport.parkNanos(this.f39227d.f39221d);
            if ((System.nanoTime() - this.f) < 0) goto L9;
            this.f = 0;
            i();
            return;
        }

        private final void i() {
            ag<c> r0 = this.f39227d.h;
            a r1 = this.f39227d;
            monitor-enter(r0);
        L23:
            th = move-exception;
            throw th;
        L5:
            if (r1.a() == false) goto L9;
            monitor-exit(r0);
            return;
        L9:
            if (((int) (a.c().get(r1) & 2097151)) > r1.f39219b) goto L13;
            monitor-exit(r0);
            return;
        L13:
            if (c().compareAndSet(this, -1, 1) == true) goto L16;
            monitor-exit(r0);
            return;
        L16:
            int r2 = this.indexInArray;     // Catch: Throwable -> L23
            a(0);     // Catch: Throwable -> L23
            r1.a(this, r2, 0);     // Catch: Throwable -> L23
            int r3 = (int) (a.c().getAndDecrement(r1) & 2097151);     // Catch: Throwable -> L23
            if (r3 == r2) goto L19;
            c r4 = r1.h.a(r3);     // Catch: Throwable -> L23
            o.a(r4);     // Catch: Throwable -> L23
            c r5 = (c) ZeusTransformUtils.preCheckCast(r4, c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L23
            r1.h.a(r2, r5);     // Catch: Throwable -> L23
            r5.a(r2);     // Catch: Throwable -> L23
            r1.a(r5, r3, r2);     // Catch: Throwable -> L23
        L19:
            r1.h.a(r3, null);     // Catch: Throwable -> L23
            x r6 = x.f38692a;     // Catch: Throwable -> L23
            monitor-exit(r0);
            this.f39225b = d.f39233e;
        }

        private final void e(int r3) {
            this.f = 0;
            if (this.f39225b == d.f39231c) goto L5;
            return;
        L5:
            if (aq.a() == false) goto L14;
            boolean r0 = true;
            if (r3 == 1) goto L10;
            r0 = false;
        L10:
            if (r0 == true) goto L14;
            throw new AssertionError();
        L14:
            this.f39225b = d.f39230b;
        }

        public final h a(boolean r2) {
            if (d() == false) goto L7;
            return b(r2);
        L7:
            return j();
        }

        private final h j() {
            h r0 = this.f39224a.c();
            if (r0 != null) goto L8;
            h r1 = (h) ZeusTransformUtils.preCheckCast(this.f39227d.g.c(), h.class, "com.obric.aiagent.plugin");
            if (r1 == null) goto L7;
            return r1;
        L7:
            return f(1);
        L8:
            return r0;
        }

        private final h b(boolean r2) {
            if (r2 == true) goto L4;
            h r3 = k();
            if (r3 == null) goto L22;
            return r3;
        L22:
            return f(3);
        L4:
            if (b(this.f39227d.f39219b * 2) != 0) goto L6;
            boolean r4 = true;
        L7:
            if (r4 == false) goto L11;
            h r0 = k();
            if (r0 == null) goto L11;
            return r0;
        L11:
            h r1 = this.f39224a.b();
            if (r1 == null) goto L14;
            return r1;
        L14:
            if (r4 == true) goto L22;
            h r5 = k();
            if (r5 == null) goto L22;
            return r5;
        L6:
            r4 = false;
            goto L7
        }

        private final h k() {
            if (b(2) != 0) goto L9;
            h r0 = (h) ZeusTransformUtils.preCheckCast(this.f39227d.f.c(), h.class, "com.obric.aiagent.plugin");
            if (r0 == null) goto L8;
            return r0;
        L8:
            return (h) ZeusTransformUtils.preCheckCast(this.f39227d.g.c(), h.class, "com.obric.aiagent.plugin");
        L9:
            h r1 = (h) ZeusTransformUtils.preCheckCast(this.f39227d.g.c(), h.class, "com.obric.aiagent.plugin");
            if (r1 == null) goto L13;
            return r1;
        L13:
            return (h) ZeusTransformUtils.preCheckCast(this.f39227d.f.c(), h.class, "com.obric.aiagent.plugin");
        }

        private final h f(int r19) {
            int r1 = (int) (a.c().get(this.f39227d) & 2097151);
            if (r1 >= 2) goto L5;
            return null;
        L5:
            int r3 = b(r1);
            a r4 = this.f39227d;
            int r5 = 0;
            long r8 = Long.MAX_VALUE;
        L7:
            if (r5 >= r1) goto L24;
            r3 = r3 + 1;
            if (r3 <= r1) goto L11;
            r3 = 1;
        L11:
            c r12 = (c) ZeusTransformUtils.preCheckCast(r4.h.a(r3), c.class, "com.obric.aiagent.plugin");
            if (r12 == null) goto L22;
            if (r12 == this) goto L22;
            long r13 = r12.f39224a.a(r19, this.f39228e);
            if (r13 == (-1)) goto L16;
            if (r13 <= 0) goto L22;
            r8 = Math.min(r8, r13);
            goto L22
        L16:
            h r2 = (h) ZeusTransformUtils.preCheckCast(this.f39228e.f38504a, h.class, "com.obric.aiagent.plugin");
            this.f39228e.f38504a = null;
            return r2;
        L22:
            r5 = r5 + 1;
            goto L7
        L24:
            if (r8 != Long.MAX_VALUE) goto L27;
            r8 = 0;
        L27:
            this.g = r8;
            return null;
        }

        private final void a(h r3) {
            int r0 = r3.g.a();
            e(r0);
            c(r0);
            this.f39227d.a(r3);
            d(r0);
        }
    }

    /* JADX INFO: compiled from: CoroutineScheduler.kt */
    public static final enum d extends Enum<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f39229a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f39230b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final d f39231c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final d f39232d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final d f39233e = null;
        private static final /* synthetic */ d[] f = null;
        private static final /* synthetic */ d.d.a g = null;

        private static final /* synthetic */ d[] a() {
            return new d[]{f39229a, f39230b, f39231c, f39232d, f39233e};
        }

        public static d valueOf(String r2) {
            return (d) ZeusTransformUtils.preCheckCast(Enum.valueOf(d.class, r2), d.class, "com.obric.aiagent.plugin");
        }

        public static d[] values() {
            return (d[]) ZeusTransformUtils.preCheckCast(f.clone(), d[].class, "com.obric.aiagent.plugin");
        }

        private d(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f39229a = new d("CPU_ACQUIRED", 0);
            f39230b = new d("BLOCKING", 1);
            f39231c = new d("PARKING", 2);
            f39232d = new d("DORMANT", 3);
            f39233e = new d("TERMINATED", 4);
            d[] r0 = a();
            f = r0;
            g = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }
    }

    private static final /* synthetic */ AtomicLongFieldUpdater h() {
        return j;
    }

    private static final /* synthetic */ AtomicLongFieldUpdater i() {
        return k;
    }

    private static final /* synthetic */ AtomicIntegerFieldUpdater j() {
        return l;
    }

    public a(int r4, int r5, long r6, String r8) {
        this.f39219b = r4;
        this.f39220c = r5;
        this.f39221d = r6;
        this.f39222e = r8;
        boolean r0 = true;
        if (r4 < 1) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L31;
        if (r5 < r4) goto L9;
        boolean r2 = true;
    L11:
        if (r2 == false) goto L29;
        if (r5 > 2097150) goto L15;
        boolean r3 = true;
    L16:
        if (r3 == false) goto L27;
        if (r6 > 0) goto L21;
        r0 = false;
    L21:
        if (r0 == false) goto L25;
        this.f = new kotlinx.coroutines.d.d();
        this.g = new kotlinx.coroutines.d.d();
        this.h = new ag((r4 + 1) * 2);
        this.controlState$volatile = ((long) r4) << 42;
        this._isTerminated$volatile = 0;
        return;
    L25:
        throw new IllegalArgumentException(("Idle worker keep alive time " + r6 + " must be positive").toString());
    L27:
        throw new IllegalArgumentException(("Max pool size " + r5 + " should not exceed maximal supported number of threads 2097150").toString());
    L15:
        r3 = false;
        goto L16
    L29:
        throw new IllegalArgumentException(("Max pool size " + r5 + " should be greater than or equals to core pool size " + r4).toString());
    L9:
        r2 = false;
        goto L11
    L31:
        throw new IllegalArgumentException(("Core pool size " + r4 + " should be at least 1").toString());
    L5:
        r1 = false;
        goto L6
    }

    public static final /* synthetic */ AtomicLongFieldUpdater c() {
        return i();
    }

    public final void a(c r10, int r11, int r12) {
        AtomicLongFieldUpdater r0 = h();
    L3:
        long r3 = r0.get(this);
        int r1 = (int) (2097151 & r3);
        long r5 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + r3) & (-2097152);
        if (r1 != r11) goto L8;
        if (r12 != 0) goto L7;
        r1 = b(r10);
        goto L8
    L7:
        r1 = r12;
    L8:
        if (r1 < 0) goto L3;
        if (h().compareAndSet(this, r3, r5 | ((long) r1)) == false) goto L3;
    }

    public final boolean a(c r11) {
        if (r11.b() == i) goto L5;
        return false;
    L5:
        AtomicLongFieldUpdater r0 = h();
    L6:
        long r5 = r0.get(this);
        int r1 = (int) (2097151 & r5);
        long r3 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + r5) & (-2097152);
        int r7 = r11.a();
        if (aq.a() == false) goto L15;
        if (r7 == 0) goto L10;
        boolean r8 = true;
    L11:
        if (r8 == true) goto L15;
        throw new AssertionError();
    L10:
        r8 = false;
    L15:
        r11.a(this.h.a(r1));
        if (h().compareAndSet(this, r5, ((long) r7) | r3) == false) goto L6;
        return true;
    }

    private final c d() {
        AtomicLongFieldUpdater r0 = h();
    L3:
        long r3 = r0.get(this);
        ag<c> r2 = this.h;
        c r7 = (c) ZeusTransformUtils.preCheckCast(r2.a((int) (2097151 & r3)), c.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L5;
        long r1 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + r3) & (-2097152);
        int r5 = b(r7);
        if (r5 < 0) goto L3;
        if (h().compareAndSet(this, r3, ((long) r5) | r1) == false) goto L3;
        r7.a(i);
        return r7;
    L5:
        return null;
    }

    private final int b(c r2) {
        Object r1 = r2.b();
    L4:
        if (r1 == i) goto L5;
        if (r1 == null) goto L8;
        c r3 = (c) ZeusTransformUtils.preCheckCast(r1, c.class, "com.obric.aiagent.plugin");
        int r4 = r3.a();
        if (r4 != 0) goto L12;
        r1 = r3.b();
        goto L4
    L12:
        return r4;
    L8:
        return 0;
    L5:
        return -1;
    }

    public final boolean a() {
        if (j().get(this) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    static {
        f39218a = new C1056a(null);
        j = AtomicLongFieldUpdater.newUpdater(a.class, "parkedWorkersStack$volatile");
        k = AtomicLongFieldUpdater.newUpdater(a.class, "controlState$volatile");
        l = AtomicIntegerFieldUpdater.newUpdater(a.class, "_isTerminated$volatile");
        i = new al("NOT_IN_STACK");
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r7) {
        a(this, (Runnable) ZeusTransformUtils.wrapperContextForParams(r7, Runnable.class, "com.obric.aiagent.plugin"), null, false, 6, null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a(10000);
    }

    public final void a(long r9) {
        boolean r1 = false;
        if (j().compareAndSet(this, 0, 1) == true) goto L5;
        return;
    L5:
        c r0 = g();
        ag<c> r3 = this.h;
        monitor-enter(r3);
        int r4 = (int) (c().get(this) & 2097151);
        monitor-exit(r3);
        if (1 > r4) goto L30;
        int r5 = 1;
    L12:
        c r6 = this.h.a(r5);
        o.a(r6);
        c r7 = (c) ZeusTransformUtils.preCheckCast(r6, c.class, "com.obric.aiagent.plugin");
        if (r7 != r0) goto L15;
    L28:
        if (r5 == r4) goto L30;
        r5 = r5 + 1;
    L15:
        if (r7.getState() == Thread.State.TERMINATED) goto L18;
        LockSupport.unpark((Thread) ZeusTransformUtils.preCheckCast(r7, Thread.class, "com.obric.aiagent.plugin"));
        r7.join(r9);
        goto L15
    L18:
        if (aq.a() == true) goto L20;
    L27:
        r7.f39224a.a(this.g);
        goto L28
    L20:
        if (r7.f39225b != d.f39233e) goto L22;
        boolean r8 = true;
    L23:
        if (r8 == true) goto L27;
        throw new AssertionError();
    L22:
        r8 = false;
    L30:
        this.g.b();
        this.f.b();
    L31:
        if (r0 == null) goto L34;
        h r10 = r0.a(true);
        if (r10 == null) goto L34;
    L51:
        a(r10);
    L34:
        r10 = (h) ZeusTransformUtils.preCheckCast(this.f.c(), h.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L51;
        r10 = (h) ZeusTransformUtils.preCheckCast(this.g.c(), h.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L51;
        if (r0 == null) goto L41;
        r0.a(d.f39233e);
    L41:
        if (aq.a() == true) goto L43;
    L49:
        h().set(this, 0);
        i().set(this, 0);
        return;
    L43:
        if (((int) ((i().get(this) & 9223367638808264704L) >> 42)) != this.f39219b) goto L45;
        r1 = true;
    L45:
        if (r1 == true) goto L49;
        throw new AssertionError();
    L52:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void a(a r1, Runnable r2, i r3, boolean r4, int r5, Object r6) {
        Runnable r7 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin");
        i r8 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = l.g;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = false;
    L8:
        r1.a(r7, r8, r4);
    }

    public final void a(Runnable r6, i r7, boolean r8) {
        Runnable r9 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r6, Runnable.class, "com.obric.aiagent.plugin");
        i r10 = (i) ZeusTransformUtils.wrapperContextForParams(r7, i.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.b r0 = kotlinx.coroutines.c.a();
        if (r0 == null) goto L5;
        r0.b();
    L5:
        h r11 = a(r9, r10);
        boolean r1 = false;
        if (r11.g.a() != 1) goto L8;
        boolean r12 = true;
    L9:
        if (r12 == false) goto L11;
        long r2 = i().addAndGet(this, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE);
    L12:
        c r4 = g();
        h r13 = a(r4, r11, r8);
        if (r13 != null) goto L15;
    L19:
        if (r8 == false) goto L22;
        if (r4 == null) goto L22;
        r1 = true;
    L22:
        if (r12 == false) goto L24;
        a(r2, r1);
        return;
    L24:
        if (r1 == false) goto L26;
        return;
    L26:
        b();
        return;
    L15:
        if (b(r13) == true) goto L19;
        throw new RejectedExecutionException(this.f39222e + " was terminated");
    L11:
        r2 = 0;
        goto L12
    L8:
        r12 = false;
        goto L9
    }

    public final h a(Runnable r4, i r5) {
        Runnable r3 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.aiagent.plugin");
        i r6 = (i) ZeusTransformUtils.wrapperContextForParams(r5, i.class, "com.obric.aiagent.plugin");
        long r1 = l.f.a();
        if (ZeusTransformUtils.instanceOf(r3, h.class) == false) goto L7;
        ((h) ZeusTransformUtils.preCheckCast(r3, h.class, "com.obric.aiagent.plugin")).f = r1;
        ((h) ZeusTransformUtils.preCheckCast(r3, h.class, "com.obric.aiagent.plugin")).g = r6;
        return (h) ZeusTransformUtils.preCheckCast(r3, h.class, "com.obric.aiagent.plugin");
    L7:
        return (h) ZeusTransformUtils.preCheckCast(new k(r3, r1, r6), h.class, "com.obric.aiagent.plugin");
    }

    private final void a(long r1, boolean r3) {
        if (r3 == false) goto L5;
        return;
    L5:
        if (e() == false) goto L8;
        return;
    L8:
        if (b(r1) == false) goto L10;
        return;
    L10:
        e();
    }

    public final void b() {
        if (e() == false) goto L6;
        return;
    L6:
        if (a(this, 0, 1, null) == false) goto L8;
        return;
    L8:
        e();
    }

    static /* synthetic */ boolean a(a r0, long r1, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = i().get(r0);
    L6:
        return r0.b(r1);
    }

    private final boolean b(long r4) {
        if (d.l.n.c(((int) (2097151 & r4)) - ((int) ((r4 & 4398044413952L) >> 21)), 0) >= this.f39219b) goto L11;
        int r5 = f();
        if (r5 == 1) goto L7;
    L9:
        if (r5 <= 0) goto L11;
        return true;
    L7:
        if (this.f39219b <= 1) goto L9;
        f();
    L11:
        return false;
    }

    private final boolean e() {
    L2:
        c r0 = d();
        if (r0 == null) goto L4;
        if (c.c().compareAndSet(r0, -1, 0) == false) goto L2;
        LockSupport.unpark((Thread) ZeusTransformUtils.preCheckCast(r0, Thread.class, "com.obric.aiagent.plugin"));
        return true;
    L4:
        return false;
    }

    private final int f() {
        ag<c> r0 = this.h;
        monitor-enter(r0);
    L37:
        th = move-exception;
        throw th;
    L5:
        if (a() == true) goto L7;
        long r1 = i().get(this);     // Catch: Throwable -> L37
        int r5 = (int) (r1 & 2097151);     // Catch: Throwable -> L37
        boolean r2 = false;
        int r3 = d.l.n.c(r5 - ((int) ((r1 & 4398044413952L) >> 21)), 0);     // Catch: Throwable -> L37
        if (r3 < this.f39219b) goto L14;
        monitor-exit(r0);
        return 0;
    L14:
        if (r5 < this.f39220c) goto L17;
        monitor-exit(r0);
        return 0;
    L17:
        int r6 = ((int) (c().get(this) & 2097151)) + 1;     // Catch: Throwable -> L37
        if (r6 > 0) goto L20;
    L22:
        boolean r7 = false;
    L23:
        if (r7 == false) goto L36;
        c r8 = new c(this, r6);     // Catch: Throwable -> L37
        this.h.a(r6, r8);     // Catch: Throwable -> L37
        if (r6 != ((int) (2097151 & i().incrementAndGet(this)))) goto L28;
        r2 = true;
    L28:
        if (r2 == false) goto L34;
        int r4 = r3 + 1;
        monitor-exit(r0);
        r8.start();
        return r4;
    L34:
        throw new IllegalArgumentException("Failed requirement.".toString());     // Catch: Throwable -> L37
    L36:
        throw new IllegalArgumentException("Failed requirement.".toString());     // Catch: Throwable -> L37
    L20:
        if (this.h.a(r6) != null) goto L22;
        r7 = true;
        goto L23
    L7:
        monitor-exit(r0);
        return -1;
    }

    private final h a(c r2, h r3, boolean r4) {
        if (r2 != null) goto L5;
        return r3;
    L5:
        if (r2.f39225b != d.f39233e) goto L8;
        return r3;
    L8:
        if (r3.g.a() == 0) goto L10;
    L12:
        r2.f39226c = true;
        return r2.f39224a.a(r3, r4);
    L10:
        if (r2.f39225b != d.f39230b) goto L12;
        return r3;
    }

    private final c g() {
        Thread r0 = Thread.currentThread();
        if (ZeusTransformUtils.instanceOf(r0, c.class) == false) goto L5;
        c r1 = (c) ZeusTransformUtils.preCheckCast(r0, c.class, "com.obric.aiagent.plugin");
    L6:
        if (r1 != null) goto L8;
        return null;
    L8:
        if (o.a(c.a(r1), this) == true) goto L10;
        return null;
    L10:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public String toString() {
        ArrayList r0 = new ArrayList();
        int r1 = this.h.a();
        int r2 = 0;
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
        int r7 = 0;
        int r8 = 1;
    L3:
        if (r8 >= r1) goto L26;
        c r9 = (c) ZeusTransformUtils.preCheckCast(this.h.a(r8), c.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L25;
        int r10 = r9.f39224a.a();
        int r11 = b.f39223a[r9.f39225b.ordinal()];
        if (r11 != 1) goto L10;
        r5 = r5 + 1;
        goto L25
    L10:
        if (r11 != 2) goto L12;
        r4 = r4 + 1;
        ((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin")).add(new StringBuilder().append(r10).append('b').toString());
        goto L25
    L12:
        if (r11 != 3) goto L14;
        r2 = r2 + 1;
        ((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin")).add(new StringBuilder().append(r10).append('c').toString());
        goto L25
    L14:
        if (r11 != 4) goto L16;
        r6 = r6 + 1;
        if (r10 <= 0) goto L25;
        ((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin")).add(new StringBuilder().append(r10).append('d').toString());
        goto L25
    L16:
        if (r11 != 5) goto L25;
        r7 = r7 + 1;
    L25:
        r8 = r8 + 1;
        goto L3
    L26:
        long r12 = i().get(this);
        StringBuilder r3 = new StringBuilder();
        r3.append(this.f39222e).append('@').append(ar.a(this)).append("[Pool Size {core = ").append(this.f39219b).append(", max = ").append(this.f39220c).append("}, Worker States {CPU = ").append(r2).append(", blocking = ").append(r4).append(", parked = ").append(r5).append(", dormant = ").append(r6).append(", terminated = ").append(r7).append("}, running workers queues = ").append(r0).append(", global CPU queue size = ").append(this.f.a()).append(", global blocking queue size = ").append(this.g.a());
        r3.append(", Control State {created workers= ").append((int) (2097151 & r12)).append(", blocking tasks = ").append((int) ((4398044413952L & r12) >> 21)).append(", CPUs acquired = ").append(this.f39219b - ((int) ((9223367638808264704L & r12) >> 42))).append("}]");
        return r3.toString();
    }

    public final void a(h r2) {
        r2.run();     // Catch: Throwable -> L6
        kotlinx.coroutines.b r1 = kotlinx.coroutines.c.a();
        if (r1 == null) goto L11;
    L5:
        r1.c();
        return;
    L11:
        return;
    L6:
        th = move-exception;
        Thread r3 = Thread.currentThread();     // Catch: Throwable -> L12
        r3.getUncaughtExceptionHandler().uncaughtException(r3, th);     // Catch: Throwable -> L12
        r1 = kotlinx.coroutines.c.a();
        if (r1 != null) goto L5;
        return;
    L12:
        th = move-exception;
        kotlinx.coroutines.b r4 = kotlinx.coroutines.c.a();
        if (r4 == null) goto L16;
        r4.c();
    L16:
        throw th;
    }

    private final boolean b(h r3) {
        boolean r1 = true;
        if (r3.g.a() == 1) goto L6;
        r1 = false;
    L6:
        if (r1 == false) goto L9;
        return this.g.a(r3);
    L9:
        return this.f.a(r3);
    }
}

package kotlinx.coroutines.f;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.h;
import d.h.a.m;
import d.h.b.l;
import d.h.b.o;
import d.h.b.p;
import d.x;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.dk;
import kotlinx.coroutines.e.j;
import kotlinx.coroutines.internal.ai;
import kotlinx.coroutines.internal.aj;
import kotlinx.coroutines.n;
import kotlinx.coroutines.q;

/* JADX INFO: compiled from: Semaphore.kt */
/* JADX INFO: loaded from: classes4.dex */
public class e implements d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f39334c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f39335d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f39336e = null;
    private static final /* synthetic */ AtomicLongFieldUpdater f = null;
    private static final /* synthetic */ AtomicIntegerFieldUpdater g = null;
    private volatile /* synthetic */ int _availablePermits$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f39337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.h.a.b<Throwable, x> f39338b;
    private volatile /* synthetic */ long deqIdx$volatile;
    private volatile /* synthetic */ long enqIdx$volatile;
    private volatile /* synthetic */ Object head$volatile;
    private volatile /* synthetic */ Object tail$volatile;

    /* JADX INFO: compiled from: Semaphore.kt */
    /* synthetic */ class a extends l implements m<Long, g, g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f39339a = null;

        static {
            f39339a = new a();
        }

        a() {
            super(2, f.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);
        }

        public final g a(long r1, g r3) {
            return f.a(r1, r3);
        }

        @Override // d.h.a.m
        public /* synthetic */ g invoke(Long r5, g r6) {
            return a(((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.aiagent.plugin")).longValue(), (g) ZeusTransformUtils.preCheckCast(r6, g.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: Semaphore.kt */
    static final class b extends p implements d.h.a.b<Throwable, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f39340a;

        b(e r1) {
            this.f39340a = r1;
            super(1);
        }

        public final void a(Throwable r1) {
            this.f39340a.c();
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(Throwable r3) {
            a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }
    }

    /* JADX INFO: compiled from: Semaphore.kt */
    /* synthetic */ class c extends l implements m<Long, g, g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f39341a = null;

        static {
            f39341a = new c();
        }

        c() {
            super(2, f.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);
        }

        public final g a(long r1, g r3) {
            return f.a(r1, r3);
        }

        @Override // d.h.a.m
        public /* synthetic */ g invoke(Long r5, g r6) {
            return a(((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.aiagent.plugin")).longValue(), (g) ZeusTransformUtils.preCheckCast(r6, g.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f39334c = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "head$volatile");
        f39335d = AtomicLongFieldUpdater.newUpdater(e.class, "deqIdx$volatile");
        f39336e = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "tail$volatile");
        f = AtomicLongFieldUpdater.newUpdater(e.class, "enqIdx$volatile");
        g = AtomicIntegerFieldUpdater.newUpdater(e.class, "_availablePermits$volatile");
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater g() {
        return f39334c;
    }

    private static final /* synthetic */ AtomicLongFieldUpdater h() {
        return f39335d;
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater i() {
        return f39336e;
    }

    private static final /* synthetic */ AtomicLongFieldUpdater j() {
        return f;
    }

    private static final /* synthetic */ AtomicIntegerFieldUpdater k() {
        return g;
    }

    @Override // kotlinx.coroutines.f.d
    public Object a(d.c.d<? super x> r3) {
        return a(this, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public e(int r6, int r7) {
        this.f39337a = r6;
        boolean r0 = true;
        if (r6 <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L17;
        if (r7 < 0) goto L10;
        if (r7 > r6) goto L10;
    L11:
        if (r0 == false) goto L15;
        g r1 = new g(0, null, 2);
        this.head$volatile = r1;
        this.tail$volatile = r1;
        this._availablePermits$volatile = r6 - r7;
        this.f39338b = (d.h.a.b) ZeusTransformUtils.preCheckCast(new b(this), d.h.a.b.class, "com.obric.aiagent.plugin");
        return;
    L15:
        throw new IllegalArgumentException(("The number of acquired permits should be in 0.." + r6).toString());
    L10:
        r0 = false;
        goto L11
    L17:
        throw new IllegalArgumentException(("Semaphore should have at least 1 permit, but had " + r6).toString());
    L5:
        r2 = false;
        goto L6
    }

    public static final /* synthetic */ boolean a(e r2, dk r3) {
        return r2.a((dk) ZeusTransformUtils.wrapperContextForParams(r3, dk.class, "com.obric.aiagent.plugin"));
    }

    public int d() {
        return Math.max(k().get(this), 0);
    }

    public boolean e() {
    L2:
        int r0 = k().get(this);
        if (r0 > this.f39337a) goto L4;
        if (r0 <= 0) goto L6;
        if (k().compareAndSet(this, r0, r0 - 1) == false) goto L2;
        return true;
    L6:
        return false;
    L4:
        b();
        goto L2
    }

    static /* synthetic */ Object a(e r2, d.c.d<? super x> r3) {
        d.c.d<? super x> r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        if (r2.a() > 0) goto L5;
        Object r5 = r2.b(r4);
        if (r5 != d.c.a.b.a()) goto L10;
        return r5;
    L10:
        return x.f38692a;
    L5:
        return x.f38692a;
    }

    private final int a() {
    L2:
        int r0 = k().getAndDecrement(this);
        if (r0 > this.f39337a) goto L2;
        return r0;
    }

    @Override // kotlinx.coroutines.f.d
    public void c() {
    L2:
        int r0 = k().getAndIncrement(this);
        if (r0 >= this.f39337a) goto L9;
        if (r0 >= 0) goto L5;
        if (f() == false) goto L2;
        return;
    L5:
        return;
    L9:
        b();
        throw new IllegalStateException(("The number of released permits cannot be greater than " + this.f39337a).toString());
    }

    private final void b() {
    L2:
        int r0 = k().get(this);
        if (r0 <= this.f39337a) goto L6;
        if (k().compareAndSet(this, r0, this.f39337a) == false) goto L2;
        return;
    }

    private final boolean a(dk r19) {
        dk r1 = (dk) ZeusTransformUtils.wrapperContextForParams(r19, dk.class, "com.obric.aiagent.plugin");
        g r3 = (g) ZeusTransformUtils.preCheckCast(i().get(this), g.class, "com.obric.aiagent.plugin");
        long r4 = j().getAndIncrement(this);
        d.m.e r6 = (d.m.e) ZeusTransformUtils.preCheckCast(a.f39339a, d.m.e.class, "com.obric.aiagent.plugin");
        AtomicReferenceFieldUpdater r7 = i();
        long r8 = r4 / ((long) f.a());
    L3:
        Object r10 = kotlinx.coroutines.internal.e.a((ai) ZeusTransformUtils.preCheckCast(r3, ai.class, "com.obric.aiagent.plugin"), r8, (m) ZeusTransformUtils.preCheckCast(r6, m.class, "com.obric.aiagent.plugin"));
        if (aj.a(r10) == true) goto L24;
        ai r11 = aj.b(r10);
    L6:
        ai r14 = (ai) ZeusTransformUtils.preCheckCast(r7.get(this), ai.class, "com.obric.aiagent.plugin");
        long r16 = r8;
        if (r14.f39364a >= r11.f39364a) goto L8;
        if (r11.j() == false) goto L11;
        if (r7.compareAndSet(this, r14, r11) == true) goto L15;
        if (r11.k() == false) goto L23;
        r11.i();
    L23:
        r8 = r16;
        goto L6
    L15:
        if (r14.k() == false) goto L8;
        r14.i();
        goto L8
    L11:
        boolean r9 = false;
    L17:
        if (r9 == true) goto L24;
        r8 = r16;
    L8:
        r9 = true;
    L24:
        g r5 = (g) ZeusTransformUtils.preCheckCast(aj.b(r10), g.class, "com.obric.aiagent.plugin");
        int r12 = (int) (r4 % ((long) f.a()));
        if (r5.a().compareAndSet(r12, null, r1) == false) goto L29;
        r1.a((ai) ZeusTransformUtils.preCheckCast(r5, ai.class, "com.obric.aiagent.plugin"), r12);
        return true;
    L29:
        if (r5.a().compareAndSet(r12, f.b(), f.c()) == false) goto L41;
        if (ZeusTransformUtils.instanceOf(r1, n.class) == false) goto L35;
        o.a(r1, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
        n r13 = (n) ZeusTransformUtils.preCheckCast(r1, n.class, "com.obric.aiagent.plugin");
        ((n) ZeusTransformUtils.preCheckCast(r1, n.class, "com.obric.aiagent.plugin")).a(x.f38692a, this.f39338b);
        return true;
    L35:
        if (ZeusTransformUtils.instanceOf(r1, j.class) == false) goto L39;
        ((j) ZeusTransformUtils.preCheckCast(r1, j.class, "com.obric.aiagent.plugin")).a(x.f38692a);
        return true;
    L39:
        throw new IllegalStateException(("unexpected: " + r1).toString());
    L41:
        if (aq.a() == true) goto L43;
        return false;
    L43:
        if (r5.a().get(r12) != f.e()) goto L45;
        boolean r15 = true;
    L46:
        if (r15 == false) goto L49;
        return false;
    L49:
        throw new AssertionError();
    L45:
        r15 = false;
        goto L46
    }

    private final boolean f() {
        g r1 = (g) ZeusTransformUtils.preCheckCast(g().get(this), g.class, "com.obric.aiagent.plugin");
        long r4 = h().getAndIncrement(this);
        long r6 = r4 / ((long) f.a());
        d.m.e r2 = (d.m.e) ZeusTransformUtils.preCheckCast(c.f39341a, d.m.e.class, "com.obric.aiagent.plugin");
        AtomicReferenceFieldUpdater r8 = g();
    L3:
        Object r9 = kotlinx.coroutines.internal.e.a((ai) ZeusTransformUtils.preCheckCast(r1, ai.class, "com.obric.aiagent.plugin"), r6, (m) ZeusTransformUtils.preCheckCast(r2, m.class, "com.obric.aiagent.plugin"));
        if (aj.a(r9) == true) goto L22;
        ai r10 = aj.b(r9);
    L6:
        ai r13 = (ai) ZeusTransformUtils.preCheckCast(r8.get(this), ai.class, "com.obric.aiagent.plugin");
        if (r13.f39364a >= r10.f39364a) goto L8;
        if (r10.j() == false) goto L11;
        if (r8.compareAndSet(this, r13, r10) == true) goto L15;
        if (r10.k() == false) goto L6;
        r10.i();
        goto L6
    L15:
        if (r13.k() == false) goto L8;
        r13.i();
        goto L8
    L11:
        boolean r11 = false;
    L17:
        if (r11 == false) goto L3;
    L8:
        r11 = true;
    L22:
        g r3 = (g) ZeusTransformUtils.preCheckCast(aj.b(r9), g.class, "com.obric.aiagent.plugin");
        r3.f();
        if (r3.f39364a <= r6) goto L26;
        return false;
    L26:
        int r5 = (int) (r4 % ((long) f.a()));
        Object r7 = r3.a().getAndSet(r5, f.b());
        if (r7 != null) goto L38;
        int r0 = f.d();
        int r12 = 0;
    L29:
        if (r12 >= r0) goto L36;
        if (r3.a().get(r5) == f.c()) goto L32;
        r12 = r12 + 1;
        goto L29
    L32:
        return true;
    L36:
        return !r3.a().compareAndSet(r5, f.b(), f.e());
    L38:
        if (r7 != f.f()) goto L42;
        return false;
    L42:
        return a(r7);
    }

    private final boolean a(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, n.class) == false) goto L9;
        o.a(r5, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
        n r0 = (n) ZeusTransformUtils.preCheckCast(r5, n.class, "com.obric.aiagent.plugin");
        Object r4 = ((n) ZeusTransformUtils.preCheckCast(r5, n.class, "com.obric.aiagent.plugin")).a(x.f38692a, null, this.f39338b);
        if (r4 == null) goto L7;
        ((n) ZeusTransformUtils.preCheckCast(r5, n.class, "com.obric.aiagent.plugin")).a(r4);
        return true;
    L7:
        return false;
    L9:
        if (ZeusTransformUtils.instanceOf(r5, j.class) == false) goto L13;
        return ((j) ZeusTransformUtils.preCheckCast(r5, j.class, "com.obric.aiagent.plugin")).a(this, x.f38692a);
    L13:
        throw new IllegalStateException(("unexpected: " + r5).toString());
    }

    private final Object b(d.c.d<? super x> r4) {
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.o r0 = q.a(d.c.a.b.a(r5));
    L14:
        th = move-exception;
        r0.i();
        throw th;
    L4:
        if (a(this, (dk) ZeusTransformUtils.preCheckCast(r0, dk.class, "com.obric.aiagent.plugin")) == true) goto L6;
        a((n) ZeusTransformUtils.preCheckCast(r0, n.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L14
    L6:
        Object r3 = r0.h();
        if (r3 != d.c.a.b.a()) goto L10;
        h.c(r5);
    L10:
        if (r3 != d.c.a.b.a()) goto L13;
        return r3;
    L13:
        return x.f38692a;
    }

    public final void a(n<? super x> r3) {
        n r4 = (n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.aiagent.plugin");
    L4:
        if (a() > 0) goto L5;
        o.a(r4, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
        if (a((dk) ZeusTransformUtils.preCheckCast(r4, dk.class, "com.obric.aiagent.plugin")) == false) goto L4;
        return;
    L5:
        r4.a(x.f38692a, this.f39338b);
    }
}

package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: EventLoop.common.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class bk extends bl implements aw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f39155a = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f39156d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f39157e = null;
    private volatile /* synthetic */ Object _delayed$volatile;
    private volatile /* synthetic */ int _isCompleted$volatile;
    private volatile /* synthetic */ Object _queue$volatile;

    /* JADX INFO: compiled from: EventLoop.common.kt */
    private final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ bk f39158a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final n<d.x> f39159c;

        public a(bk r3, long r4, n<? super d.x> r6) {
            n<d.x> r7 = (n) ZeusTransformUtils.wrapperContextForParams(r6, n.class, "com.obric.aiagent.plugin");
            this.f39158a = r3;
            super(r4);
            this.f39159c = r7;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f39159c.a((ai) ZeusTransformUtils.preCheckCast(this.f39158a, ai.class, "com.obric.aiagent.plugin"), d.x.f38692a);
        }

        @Override // kotlinx.coroutines.bk.c
        public String toString() {
            return super.toString() + this.f39159c;
        }
    }

    /* JADX INFO: compiled from: EventLoop.common.kt */
    private static final class b extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Runnable f39160a;

        public b(long r3, Runnable r5) {
            Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r5, Runnable.class, "com.obric.aiagent.plugin");
            super(r3);
            this.f39160a = r6;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f39160a.run();
        }

        @Override // kotlinx.coroutines.bk.c
        public String toString() {
            return super.toString() + this.f39160a;
        }
    }

    /* JADX INFO: compiled from: EventLoop.common.kt */
    public static abstract class c implements Comparable<c>, Runnable, bf, kotlinx.coroutines.internal.as {
        private volatile Object _heap;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f39161a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f39162b;

        @Override // java.lang.Comparable
        public /* synthetic */ int compareTo(c r3) {
            return a((c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.aiagent.plugin"));
        }

        public c(long r1) {
            this.f39162b = r1;
            this.f39161a = -1;
        }

        @Override // kotlinx.coroutines.internal.as
        public kotlinx.coroutines.internal.ar<?> a() {
            Object r2 = this._heap;
            if (ZeusTransformUtils.instanceOf(r2, kotlinx.coroutines.internal.ar.class) == true) goto L7;
            return null;
        L7:
            return (kotlinx.coroutines.internal.ar) ZeusTransformUtils.preCheckCast(r2, kotlinx.coroutines.internal.ar.class, "com.obric.aiagent.plugin");
        }

        @Override // kotlinx.coroutines.internal.as
        public void a(kotlinx.coroutines.internal.ar<?> r3) {
            if (this._heap == bn.b()) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L10;
            this._heap = r3;
            return;
        L10:
            throw new IllegalArgumentException("Failed requirement.".toString());
        L5:
            r0 = false;
            goto L6
        }

        @Override // kotlinx.coroutines.internal.as
        public void a(int r1) {
            this.f39161a = r1;
        }

        @Override // kotlinx.coroutines.internal.as
        public int b() {
            return this.f39161a;
        }

        public int a(c r3) {
            long r0 = this.f39162b - r3.f39162b;
            if (r0 <= 0) goto L5;
            return 1;
        L5:
            if (r0 >= 0) goto L7;
            return -1;
        L7:
            return 0;
        }

        public final boolean a(long r3) {
            if ((r3 - this.f39162b) < 0) goto L5;
            return true;
        L5:
            return false;
        }

        public String toString() {
            return "Delayed[nanos=" + this.f39162b + ']';
        }

        public final int a(long r9, d r11, bk r12) {
            monitor-enter(this);
        L37:
            th = move-exception;
            throw th;
        L4:
            if (this._heap == bn.b()) goto L6;
            kotlinx.coroutines.internal.ar r0 = (kotlinx.coroutines.internal.ar) ZeusTransformUtils.preCheckCast(r11, kotlinx.coroutines.internal.ar.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37
            monitor-enter(r0);     // Catch: Throwable -> L37
            c r1 = (c) ZeusTransformUtils.preCheckCast(r0.e(), c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L34
            if (bk.a(r12) == false) goto L17;
            monitor-exit(r0);     // Catch: Throwable -> L37
            monitor-exit(this);
            return 1;
        L17:
            if (r1 != null) goto L19;
            r11.f39163a = r9;     // Catch: Throwable -> L34
        L27:
            if ((this.f39162b - r11.f39163a) >= 0) goto L29;
            this.f39162b = r11.f39163a;     // Catch: Throwable -> L34
        L29:
            r0.b((kotlinx.coroutines.internal.as) ZeusTransformUtils.preCheckCast(this, kotlinx.coroutines.internal.as.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L34
            monitor-exit(r0);     // Catch: Throwable -> L37
            monitor-exit(this);
            return 0;
        L19:
            long r4 = r1.f39162b;     // Catch: Throwable -> L34
            if ((r4 - r9) >= 0) goto L24;
            r9 = r4;
        L24:
            if ((r9 - r11.f39163a) <= 0) goto L27;
            r11.f39163a = r9;     // Catch: Throwable -> L34
        L34:
            th = move-exception;
            throw th;     // Catch: Throwable -> L37
        L6:
            monitor-exit(this);
            return 2;
        }

        @Override // kotlinx.coroutines.bf
        public final void dispose() {
            monitor-enter(this);
            Object r0 = this._heap;     // Catch: Throwable -> L16
            if (r0 != bn.b()) goto L8;
            monitor-exit(this);
            return;
        L8:
            if (ZeusTransformUtils.instanceOf(r0, d.class) == false) goto L10;
            d r1 = (d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        L11:
            if (r1 == null) goto L13;
            r1.a((kotlinx.coroutines.internal.as) ZeusTransformUtils.preCheckCast(this, kotlinx.coroutines.internal.as.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L16
        L13:
            this._heap = bn.b();     // Catch: Throwable -> L16
            d.x r2 = d.x.f38692a;     // Catch: Throwable -> L16
            monitor-exit(this);
            return;
        L10:
            r1 = null;
        L16:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: compiled from: EventLoop.common.kt */
    public static final class d extends kotlinx.coroutines.internal.ar<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f39163a;

        public d(long r1) {
            this.f39163a = r1;
        }
    }

    static {
        f39155a = AtomicReferenceFieldUpdater.newUpdater(bk.class, Object.class, "_queue$volatile");
        f39156d = AtomicReferenceFieldUpdater.newUpdater(bk.class, Object.class, "_delayed$volatile");
        f39157e = AtomicIntegerFieldUpdater.newUpdater(bk.class, "_isCompleted$volatile");
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater p() {
        return f39155a;
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater q() {
        return f39156d;
    }

    private static final /* synthetic */ AtomicIntegerFieldUpdater r() {
        return f39157e;
    }

    public bk() {
        this._isCompleted$volatile = 0;
    }

    public static final /* synthetic */ boolean a(bk r0) {
        return r0.l();
    }

    public bf a(long r3, Runnable r5, d.c.g r6) {
        return aw.a.a(this, r3, (Runnable) ZeusTransformUtils.wrapperContextForParams(r5, Runnable.class, "com.obric.aiagent.plugin"), (d.c.g) ZeusTransformUtils.wrapperContextForParams(r6, d.c.g.class, "com.obric.aiagent.plugin"));
    }

    private final boolean l() {
        if (r().get(this) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private final void c(boolean r2) {
        r().set(this, r2 ? 1 : 0);
    }

    @Override // kotlinx.coroutines.bj
    public boolean d() {
        if (i() == true) goto L5;
        return false;
    L5:
        d r0 = (d) ZeusTransformUtils.preCheckCast(q().get(this), d.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L8;
    L10:
        Object r4 = p().get(this);
        if (r4 != null) goto L14;
    L19:
        return true;
    L14:
        if (ZeusTransformUtils.instanceOf(r4, kotlinx.coroutines.internal.z.class) == false) goto L17;
        return ((kotlinx.coroutines.internal.z) ZeusTransformUtils.preCheckCast(r4, kotlinx.coroutines.internal.z.class, "com.obric.aiagent.plugin")).a();
    L17:
        if (r4 == bn.a()) goto L19;
        return false;
    L8:
        if (r0.b() == true) goto L10;
        return false;
    }

    @Override // kotlinx.coroutines.bj
    public long e() {
        if (super.e() != 0) goto L5;
        return 0;
    L5:
        Object r0 = p().get(this);
        if (r0 != null) goto L8;
    L16:
        d r7 = (d) ZeusTransformUtils.preCheckCast(q().get(this), d.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L27;
        c r8 = (c) ZeusTransformUtils.preCheckCast(r7.c(), c.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L27;
        long r1 = r8.f39162b;
        kotlinx.coroutines.b r9 = kotlinx.coroutines.c.a();
        if (r9 == null) goto L24;
        long r4 = r9.a();
    L26:
        return d.l.n.a(r1 - r4, 0);
    L24:
        r4 = System.nanoTime();
    L27:
        return Long.MAX_VALUE;
    L8:
        if (ZeusTransformUtils.instanceOf(r0, kotlinx.coroutines.internal.z.class) == false) goto L13;
        if (((kotlinx.coroutines.internal.z) ZeusTransformUtils.preCheckCast(r0, kotlinx.coroutines.internal.z.class, "com.obric.aiagent.plugin")).a() == true) goto L16;
        return 0;
    L13:
        if (r0 != bn.a()) goto L15;
        return Long.MAX_VALUE;
    L15:
        return 0;
    }

    @Override // kotlinx.coroutines.bj
    public void b() {
        cz.f39215a.c();
        c(true);
        n();
    L4:
        if (c() <= 0) goto L4;
        o();
    }

    @Override // kotlinx.coroutines.aw
    public void a(long r5, n<? super d.x> r7) {
        n r8 = (n) ZeusTransformUtils.wrapperContextForParams(r7, n.class, "com.obric.aiagent.plugin");
        long r6 = bn.a(r5);
        if (r6 >= 4611686018427387903L) goto L10;
        kotlinx.coroutines.b r0 = kotlinx.coroutines.c.a();
        if (r0 == null) goto L7;
        long r2 = r0.a();
    L8:
        a r1 = new a(this, r6 + r2, r8);
        b(r2, (c) ZeusTransformUtils.preCheckCast(r1, c.class, "com.obric.aiagent.plugin"));
        q.a(r8, (bf) ZeusTransformUtils.preCheckCast(r1, bf.class, "com.obric.aiagent.plugin"));
        return;
    L7:
        r2 = System.nanoTime();
        goto L8
    }

    public final bf a(long r5, Runnable r7) {
        Runnable r8 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r7, Runnable.class, "com.obric.aiagent.plugin");
        long r6 = bn.a(r5);
        if (r6 >= 4611686018427387903L) goto L10;
        kotlinx.coroutines.b r0 = kotlinx.coroutines.c.a();
        if (r0 == null) goto L7;
        long r2 = r0.a();
    L8:
        b r1 = new b(r6 + r2, r8);
        b(r2, (c) ZeusTransformUtils.preCheckCast(r1, c.class, "com.obric.aiagent.plugin"));
        return (bf) ZeusTransformUtils.preCheckCast(r1, bf.class, "com.obric.aiagent.plugin");
    L7:
        r2 = System.nanoTime();
        goto L8
    L10:
        return (bf) ZeusTransformUtils.preCheckCast(cp.f39210a, bf.class, "com.obric.aiagent.plugin");
    }

    @Override // kotlinx.coroutines.bj
    public long c() {
        if (f() == false) goto L5;
        return 0;
    L5:
        d r0 = (d) ZeusTransformUtils.preCheckCast(q().get(this), d.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L8;
    L34:
        Runnable r1 = m();
        if (r1 == null) goto L39;
        r1.run();
        return 0;
    L39:
        return e();
    L8:
        if (r0.b() == true) goto L34;
        kotlinx.coroutines.b r3 = kotlinx.coroutines.c.a();
        if (r3 == null) goto L12;
        long r4 = r3.a();
    L13:
        kotlinx.coroutines.internal.ar r5 = (kotlinx.coroutines.internal.ar) ZeusTransformUtils.preCheckCast(r0, kotlinx.coroutines.internal.ar.class, "com.obric.aiagent.plugin");
        monitor-enter(r5);
        kotlinx.coroutines.internal.as r6 = r5.e();     // Catch: Throwable -> L31
        kotlinx.coroutines.internal.as r7 = null;
        if (r6 != null) goto L20;
        monitor-exit(r5);
    L29:
        if (((c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.aiagent.plugin")) != null) goto L13;
    L20:
        c r8 = (c) ZeusTransformUtils.preCheckCast(r6, c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L31
        if (r8.a(r4) == false) goto L23;
        boolean r9 = b((Runnable) ZeusTransformUtils.preCheckCast(r8, Runnable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L31
    L24:
        if (r9 == true) goto L26;
    L27:
        monitor-exit(r5);
        goto L29
    L26:
        r7 = r5.a(0);     // Catch: Throwable -> L31
        goto L27
    L23:
        r9 = false;
    L31:
        th = move-exception;
        throw th;
    L12:
        r4 = System.nanoTime();
        goto L13
    }

    @Override // kotlinx.coroutines.ai
    public final void a(d.c.g r3, Runnable r4) {
        d.c.g r5 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin");
        a((Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.aiagent.plugin"));
    }

    public void a(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        if (b(r4) == false) goto L5;
        k();
        return;
    L5:
        as.f38861a.a(r4);
    }

    private final boolean b(Runnable r7) {
        Runnable r8 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r7, Runnable.class, "com.obric.aiagent.plugin");
        AtomicReferenceFieldUpdater r0 = p();
    L3:
        Object r2 = r0.get(this);
        if (l() == true) goto L5;
        if (r2 == null) goto L9;
        if (ZeusTransformUtils.instanceOf(r2, kotlinx.coroutines.internal.z.class) == true) goto L13;
        if (r2 == bn.a()) goto L24;
        kotlinx.coroutines.internal.z r4 = new kotlinx.coroutines.internal.z(8, true);
        d.h.b.o.a(r2, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
        r4.a((Runnable) ZeusTransformUtils.preCheckCast(r2, Runnable.class, "com.obric.aiagent.plugin"));
        r4.a(r8);
        if (p().compareAndSet(this, r2, r4) == false) goto L3;
        return true;
    L24:
        return false;
    L13:
        d.h.b.o.a(r2, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
        int r5 = ((kotlinx.coroutines.internal.z) ZeusTransformUtils.preCheckCast(r2, kotlinx.coroutines.internal.z.class, "com.obric.aiagent.plugin")).a(r8);
        if (r5 == 0) goto L21;
        if (r5 != 1) goto L17;
        p().compareAndSet(this, r2, ((kotlinx.coroutines.internal.z) ZeusTransformUtils.preCheckCast(r2, kotlinx.coroutines.internal.z.class, "com.obric.aiagent.plugin")).e());
        goto L3
    L17:
        if (r5 != 2) goto L3;
        return false;
    L21:
        return true;
    L9:
        if (p().compareAndSet(this, null, r8) == false) goto L3;
        return true;
    L5:
        return false;
    }

    private final Runnable m() {
        AtomicReferenceFieldUpdater r0 = p();
    L3:
        Object r1 = r0.get(this);
        if (r1 == null) goto L5;
        if (ZeusTransformUtils.instanceOf(r1, kotlinx.coroutines.internal.z.class) == true) goto L8;
        if (r1 == bn.a()) goto L15;
        if (p().compareAndSet(this, r1, null) == false) goto L3;
        d.h.b.o.a(r1, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
        return (Runnable) ZeusTransformUtils.preCheckCast(r1, Runnable.class, "com.obric.aiagent.plugin");
    L15:
        return null;
    L8:
        d.h.b.o.a(r1, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
        Object r2 = ((kotlinx.coroutines.internal.z) ZeusTransformUtils.preCheckCast(r1, kotlinx.coroutines.internal.z.class, "com.obric.aiagent.plugin")).d();
        if (r2 != kotlinx.coroutines.internal.z.f39428b) goto L11;
        p().compareAndSet(this, r1, ((kotlinx.coroutines.internal.z) ZeusTransformUtils.preCheckCast(r1, kotlinx.coroutines.internal.z.class, "com.obric.aiagent.plugin")).e());
        goto L3
    L11:
        return (Runnable) ZeusTransformUtils.preCheckCast(r2, Runnable.class, "com.obric.aiagent.plugin");
    L5:
        return null;
    }

    private final void n() {
        if (aq.a() == true) goto L5;
    L9:
        AtomicReferenceFieldUpdater r0 = p();
    L10:
        Object r1 = r0.get(this);
        if (r1 == null) goto L13;
        if (ZeusTransformUtils.instanceOf(r1, kotlinx.coroutines.internal.z.class) == true) goto L17;
        if (r1 == bn.a()) goto L21;
        kotlinx.coroutines.internal.z r2 = new kotlinx.coroutines.internal.z(8, true);
        d.h.b.o.a(r1, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
        r2.a((Runnable) ZeusTransformUtils.preCheckCast(r1, Runnable.class, "com.obric.aiagent.plugin"));
        if (p().compareAndSet(this, r1, r2) == false) goto L10;
        return;
    L21:
        return;
    L17:
        ((kotlinx.coroutines.internal.z) ZeusTransformUtils.preCheckCast(r1, kotlinx.coroutines.internal.z.class, "com.obric.aiagent.plugin")).c();
        return;
    L13:
        if (p().compareAndSet(this, null, bn.a()) == false) goto L10;
        return;
    L5:
        if (l() == true) goto L9;
        throw new AssertionError();
    }

    public final void b(long r3, c r5) {
        int r0 = c(r3, r5);
        if (r0 == 0) goto L13;
        if (r0 != 1) goto L7;
        a(r3, r5);
        return;
    L7:
        if (r0 != 2) goto L10;
        return;
    L10:
        throw new IllegalStateException("unexpected result".toString());
    L13:
        if (a(r5) == false) goto L17;
        k();
        return;
    }

    private final boolean a(c r3) {
        d r2 = (d) ZeusTransformUtils.preCheckCast(q().get(this), d.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L5;
        c r4 = (c) ZeusTransformUtils.preCheckCast(r2.c(), c.class, "com.obric.aiagent.plugin");
    L6:
        if (r4 != r3) goto L8;
        return true;
    L8:
        return false;
    L5:
        r4 = null;
        goto L6
    }

    private final int c(long r6, c r8) {
        if (l() == false) goto L6;
        return 1;
    L6:
        d r0 = (d) ZeusTransformUtils.preCheckCast(q().get(this), d.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L10;
        bk r1 = (bk) ZeusTransformUtils.preCheckCast(this, bk.class, "com.obric.aiagent.plugin");
        q().compareAndSet(r1, null, new d(r6));
        Object r2 = q().get(r1);
        d.h.b.o.a(r2);
        r0 = (d) ZeusTransformUtils.preCheckCast(r2, d.class, "com.obric.aiagent.plugin");
    L10:
        return r8.a(r6, r0, this);
    }

    public final void j() {
        p().set(this, null);
        q().set(this, null);
    }

    private final void o() {
        kotlinx.coroutines.b r0 = kotlinx.coroutines.c.a();
        if (r0 == null) goto L5;
        long r1 = r0.a();
    L6:
        d r2 = (d) ZeusTransformUtils.preCheckCast(q().get(this), d.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L12;
        c r3 = (c) ZeusTransformUtils.preCheckCast(r2.d(), c.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L16;
        a(r1, r3);
        goto L6
    L16:
        return;
    L12:
        return;
    L5:
        r1 = System.nanoTime();
        goto L6
    }
}

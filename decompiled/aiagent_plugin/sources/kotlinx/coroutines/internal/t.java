package kotlinx.coroutines.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlinx.coroutines.aw;
import kotlinx.coroutines.bf;

/* JADX INFO: compiled from: LimitedDispatcher.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class t extends kotlinx.coroutines.ai implements aw {
    private static final /* synthetic */ AtomicIntegerFieldUpdater h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlinx.coroutines.ai f39415a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f39416d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final /* synthetic */ aw f39417e;
    private final y<Runnable> f;
    private final Object g;
    private volatile /* synthetic */ int runningWorkers$volatile;

    /* JADX INFO: compiled from: LimitedDispatcher.kt */
    private final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ t f39418a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Runnable f39419b;

        public a(t r3, Runnable r4) {
            Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.aiagent.plugin");
            this.f39418a = r3;
            this.f39419b = r5;
        }

        @Override // java.lang.Runnable
        public void run() {
            int r1 = 0;
        L16:
            this.f39419b.run();     // Catch: Throwable -> L5
        L7:
            Runnable r2 = t.a(this.f39418a);
            if (r2 == null) goto L9;
            this.f39419b = r2;
            r1 = r1 + 1;
            if (r1 < 16) goto L16;
            if (t.b(this.f39418a).a((d.c.g) ZeusTransformUtils.preCheckCast(this.f39418a, d.c.g.class, "com.obric.aiagent.plugin")) == false) goto L16;
            t.b(this.f39418a).a((d.c.g) ZeusTransformUtils.preCheckCast(this.f39418a, d.c.g.class, "com.obric.aiagent.plugin"), (Runnable) ZeusTransformUtils.preCheckCast(this, Runnable.class, "com.obric.aiagent.plugin"));
            return;
        L9:
            return;
        L5:
            th = move-exception;
            kotlinx.coroutines.aj.a((d.c.g) ZeusTransformUtils.preCheckCast(d.c.h.f38423a, d.c.g.class, "com.obric.aiagent.plugin"), th);
            goto L7
        }
    }

    static {
        h = AtomicIntegerFieldUpdater.newUpdater(t.class, "runningWorkers$volatile");
    }

    private static final /* synthetic */ AtomicIntegerFieldUpdater c() {
        return h;
    }

    @Override // kotlinx.coroutines.aw
    public bf a(long r3, Runnable r5, d.c.g r6) {
        Runnable r7 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r5, Runnable.class, "com.obric.aiagent.plugin");
        d.c.g r8 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r6, d.c.g.class, "com.obric.aiagent.plugin");
        return this.f39417e.a(r3, r7, r8);
    }

    @Override // kotlinx.coroutines.aw
    public void a(long r3, kotlinx.coroutines.n<? super d.x> r5) {
        kotlinx.coroutines.n<? super d.x> r6 = (kotlinx.coroutines.n) ZeusTransformUtils.wrapperContextForParams(r5, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");
        this.f39417e.a(r3, r6);
    }

    public static final /* synthetic */ Runnable a(t r0) {
        return r0.b();
    }

    public static final /* synthetic */ kotlinx.coroutines.ai b(t r0) {
        return r0.f39415a;
    }

    public t(kotlinx.coroutines.ai r2, int r3) {
        this.f39415a = r2;
        this.f39416d = r3;
        if (ZeusTransformUtils.instanceOf(r2, aw.class) == false) goto L5;
        aw r4 = (aw) ZeusTransformUtils.preCheckCast(r2, aw.class, "com.obric.aiagent.plugin");
    L6:
        if (r4 != null) goto L8;
        r4 = kotlinx.coroutines.at.a();
    L8:
        this.f39417e = r4;
        this.f = new y(false);
        this.g = new Object();
        return;
    L5:
        r4 = null;
        goto L6
    }

    @Override // kotlinx.coroutines.ai
    public kotlinx.coroutines.ai a(int r2) {
        u.a(r2);
        if (r2 < this.f39416d) goto L7;
        return (kotlinx.coroutines.ai) ZeusTransformUtils.preCheckCast(this, kotlinx.coroutines.ai.class, "com.obric.aiagent.plugin");
    L7:
        return super.a(r2);
    }

    private final boolean a() {
        Object r0 = this.g;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (c().get(this) >= this.f39416d) goto L7;
        c().incrementAndGet(this);     // Catch: Throwable -> L13
        monitor-exit(r0);
        return true;
    L7:
        monitor-exit(r0);
        return false;
    }

    private final Runnable b() {
    L2:
        Runnable r0 = (Runnable) ZeusTransformUtils.preCheckCast(this.f.c(), Runnable.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L17;
        Object r1 = this.g;
        monitor-enter(r1);
        c().decrementAndGet(this);     // Catch: Throwable -> L14
        if (this.f.a() == 0) goto L9;
        c().incrementAndGet(this);     // Catch: Throwable -> L14
        monitor-exit(r1);
        goto L2
    L9:
        monitor-exit(r1);
        return null;
    L14:
        th = move-exception;
        throw th;
    L17:
        return r0;
    }

    @Override // kotlinx.coroutines.ai
    public void a(d.c.g r3, Runnable r4) {
        d.c.g r5 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin");
        Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.aiagent.plugin");
        this.f.a(r6);
        if (c().get(this) < this.f39416d) goto L5;
        return;
    L5:
        if (a() == false) goto L12;
        Runnable r7 = b();
        if (r7 == null) goto L13;
        a r8 = new a(this, r7);
        this.f39415a.a((d.c.g) ZeusTransformUtils.preCheckCast(this, d.c.g.class, "com.obric.aiagent.plugin"), (Runnable) ZeusTransformUtils.preCheckCast(r8, Runnable.class, "com.obric.aiagent.plugin"));
        return;
    L13:
        return;
    }

    @Override // kotlinx.coroutines.ai
    public void b(d.c.g r3, Runnable r4) {
        d.c.g r5 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin");
        Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.aiagent.plugin");
        this.f.a(r6);
        if (c().get(this) < this.f39416d) goto L5;
        return;
    L5:
        if (a() == false) goto L12;
        Runnable r7 = b();
        if (r7 == null) goto L13;
        a r8 = new a(this, r7);
        this.f39415a.b((d.c.g) ZeusTransformUtils.preCheckCast(this, d.c.g.class, "com.obric.aiagent.plugin"), (Runnable) ZeusTransformUtils.preCheckCast(r8, Runnable.class, "com.obric.aiagent.plugin"));
        return;
    L13:
        return;
    }
}

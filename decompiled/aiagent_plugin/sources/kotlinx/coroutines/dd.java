package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: Interruptible.kt */
/* JADX INFO: loaded from: classes4.dex */
final class dd implements bw {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f39253d = null;
    private volatile /* synthetic */ int _state$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ca f39254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Thread f39255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private bf f39256c;

    static {
        f39253d = AtomicIntegerFieldUpdater.newUpdater(dd.class, "_state$volatile");
    }

    private static final /* synthetic */ AtomicIntegerFieldUpdater c() {
        return f39253d;
    }

    public dd(ca r3) {
        this.f39254a = (ca) ZeusTransformUtils.wrapperContextForParams(r3, ca.class, "com.obric.aiagent.plugin");
        this.f39255b = Thread.currentThread();
    }

    public final void a() {
        this.f39256c = ce.a(this.f39254a, true, true, (bw) ZeusTransformUtils.preCheckCast(this, bw.class, "com.obric.aiagent.plugin"));
        AtomicIntegerFieldUpdater r0 = c();
    L3:
        int r1 = r0.get(this);
        if (r1 != 0) goto L6;
        if (c().compareAndSet(this, r1, 0) == false) goto L3;
        return;
    L6:
        if (r1 != 2) goto L8;
        return;
    L8:
        if (r1 == 3) goto L19;
        a(r1);
        throw new d.d();
    }

    public final void b() {
        AtomicIntegerFieldUpdater r0 = c();
    L3:
        int r1 = r0.get(this);
        if (r1 != 0) goto L6;
        if (c().compareAndSet(this, r1, 1) == false) goto L3;
        bf r4 = this.f39256c;
        if (r4 == null) goto L26;
        r4.dispose();
        return;
    L26:
        return;
    L6:
        if (r1 == 2) goto L3;
        if (r1 != 3) goto L11;
        Thread.interrupted();
        return;
    L11:
        a(r1);
        throw new d.d();
    }

    @Override // kotlinx.coroutines.bw
    public void a(Throwable r5) {
        AtomicIntegerFieldUpdater r6 = c();
    L3:
        int r0 = r6.get(this);
        if (r0 != 0) goto L6;
        if (c().compareAndSet(this, r0, 2) == false) goto L3;
        this.f39255b.interrupt();
        c().set(this, 3);
        return;
    L6:
        if (r0 == 1) goto L12;
        if (r0 == 2) goto L20;
        if (r0 == 3) goto L21;
        a(r0);
        throw new d.d();
    L21:
        return;
    L20:
        return;
    }

    private final Void a(int r3) {
        throw new IllegalStateException(("Illegal state " + r3).toString());
    }
}

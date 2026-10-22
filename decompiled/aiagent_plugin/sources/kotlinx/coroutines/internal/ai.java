package kotlinx.coroutines.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlinx.coroutines.cq;
import kotlinx.coroutines.internal.ai;

/* JADX INFO: compiled from: ConcurrentLinkedList.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ai<S extends ai<S>> extends f<S> implements cq {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f39363b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f39364a;
    private volatile /* synthetic */ int cleanedAndPointers$volatile;

    static {
        f39363b = AtomicIntegerFieldUpdater.newUpdater(ai.class, "cleanedAndPointers$volatile");
    }

    private static final /* synthetic */ AtomicIntegerFieldUpdater a() {
        return f39363b;
    }

    public abstract void a(int r1, Throwable r2, d.c.g r3);

    public abstract int b();

    public ai(long r3, S r5, int r6) {
        super((f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin"));
        this.f39364a = r3;
        this.cleanedAndPointers$volatile = r6 << 16;
    }

    @Override // kotlinx.coroutines.internal.f
    public boolean h() {
        if (a().get(this) == b()) goto L5;
    L7:
        return false;
    L5:
        if (d() == true) goto L7;
        return true;
    }

    public final boolean k() {
        if (a().addAndGet(this, -65536) == b()) goto L5;
    L7:
        return false;
    L5:
        if (d() == true) goto L7;
        return true;
    }

    public final void l() {
        if (a().incrementAndGet(this) != b()) goto L6;
        i();
        return;
    }

    public final boolean j() {
        AtomicIntegerFieldUpdater r0 = a();
    L3:
        int r1 = r0.get(this);
        if (r1 == b()) goto L6;
    L9:
        boolean r2 = true;
    L10:
        if (r2 == false) goto L19;
        if (r0.compareAndSet(this, r1, 65536 + r1) == false) goto L3;
        return true;
    L19:
        return false;
    L6:
        if (d() == true) goto L9;
        r2 = false;
        goto L10
    }
}

package kotlinx.coroutines.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: LockFreeTaskQueue.kt */
/* JADX INFO: loaded from: classes4.dex */
public class y<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f39426a = null;
    private volatile /* synthetic */ Object _cur$volatile;

    static {
        f39426a = AtomicReferenceFieldUpdater.newUpdater(y.class, Object.class, "_cur$volatile");
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater d() {
        return f39426a;
    }

    public y(boolean r3) {
        this._cur$volatile = new z(8, r3);
    }

    public final int a() {
        return ((z) ZeusTransformUtils.preCheckCast(d().get(this), z.class, "com.obric.aiagent.plugin")).b();
    }

    public final void b() {
        AtomicReferenceFieldUpdater r0 = d();
    L3:
        z r1 = (z) ZeusTransformUtils.preCheckCast(r0.get(this), z.class, "com.obric.aiagent.plugin");
        if (r1.c() == true) goto L5;
        d().compareAndSet(this, r1, r1.e());
        goto L3
    }

    public final boolean a(E r5) {
        AtomicReferenceFieldUpdater r0 = d();
    L3:
        z r1 = (z) ZeusTransformUtils.preCheckCast(r0.get(this), z.class, "com.obric.aiagent.plugin");
        int r2 = r1.a(r5);
        if (r2 == 0) goto L12;
        if (r2 != 1) goto L7;
        d().compareAndSet(this, r1, r1.e());
        goto L3
    L7:
        if (r2 != 2) goto L3;
        return false;
    L12:
        return true;
    }

    public final E c() {
        AtomicReferenceFieldUpdater r0 = d();
    L3:
        z r1 = (z) ZeusTransformUtils.preCheckCast(r0.get(this), z.class, "com.obric.aiagent.plugin");
        E r2 = (E) r1.d();
        if (r2 != z.f39428b) goto L5;
        d().compareAndSet(this, r1, r1.e());
        goto L3
    L5:
        return r2;
    }
}

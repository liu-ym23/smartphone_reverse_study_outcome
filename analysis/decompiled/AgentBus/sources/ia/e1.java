package ia;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes.dex */
public final class e1 extends k1 {

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f4951k = AtomicIntegerFieldUpdater.newUpdater(e1.class, "_invoked$volatile");
    private volatile /* synthetic */ int _invoked$volatile;

    /* renamed from: j, reason: collision with root package name */
    public final p7.k f4952j;

    public e1(p7.k kVar) {
        this.f4952j = kVar;
    }

    @Override // ia.k1
    public final boolean k() {
        return true;
    }

    @Override // ia.k1
    public final void l(Throwable th) {
        if (f4951k.compareAndSet(this, 0, 1)) {
            this.f4952j.invoke(th);
        }
    }
}

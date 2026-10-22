package m9;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes4.dex */
public final class a0 extends e0 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater f = AtomicIntegerFieldUpdater.newUpdater(a0.class, "_invoked$volatile");
    private volatile /* synthetic */ int _invoked$volatile = 0;
    public final S7.k e;

    public a0(S7.k kVar) {
        this.e = kVar;
    }

    @Override // m9.e0
    public final boolean i() {
        return true;
    }

    @Override // m9.e0
    public final void j(Throwable th) {
        if (f.compareAndSet(this, 0, 1)) {
            this.e.invoke(th);
        }
    }
}

package kc;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class v0 extends a1 {

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f7488j = AtomicIntegerFieldUpdater.newUpdater(v0.class, "_invoked$volatile");
    private volatile /* synthetic */ int _invoked$volatile = 0;
    public final androidx.room.d i;

    public v0(androidx.room.d dVar) {
        this.i = dVar;
    }

    @Override // kc.a1
    public final boolean k() {
        return true;
    }

    @Override // kc.a1
    public final void l(Throwable th) {
        if (f7488j.compareAndSet(this, 0, 1)) {
            this.i.invoke(th);
        }
    }
}

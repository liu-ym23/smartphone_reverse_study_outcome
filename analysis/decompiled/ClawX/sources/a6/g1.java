package a6;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class g1 extends l1 {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f165f = AtomicIntegerFieldUpdater.newUpdater(g1.class, "_invoked$volatile");
    private volatile /* synthetic */ int _invoked$volatile;

    /* renamed from: e, reason: collision with root package name */
    public final p5.l f166e;

    public g1(p5.l lVar) {
        this.f166e = lVar;
    }

    @Override // a6.l1
    public final boolean k() {
        return true;
    }

    @Override // a6.l1
    public final void l(Throwable th) {
        if (f165f.compareAndSet(this, 0, 1)) {
            this.f166e.invoke(th);
        }
    }
}

package a6;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class p0 extends f6.p {

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f205e = AtomicIntegerFieldUpdater.newUpdater(p0.class, "_decision$volatile");
    private volatile /* synthetic */ int _decision$volatile;

    @Override // f6.p, a6.p1
    public final void q(Object obj) throws o0 {
        r(obj);
    }

    @Override // f6.p, a6.p1
    public final void r(Object obj) throws o0 {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        do {
            atomicIntegerFieldUpdater = f205e;
            int i8 = atomicIntegerFieldUpdater.get(this);
            if (i8 != 0) {
                if (i8 != 1) {
                    throw new IllegalStateException("Already resumed");
                }
                f6.a.h(b8.h.u(this.d), i0.s(obj));
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, 0, 2));
    }
}

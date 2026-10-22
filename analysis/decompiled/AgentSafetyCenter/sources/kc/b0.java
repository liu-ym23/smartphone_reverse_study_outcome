package kc;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b0 extends pc.q {
    public static final /* synthetic */ AtomicIntegerFieldUpdater i = AtomicIntegerFieldUpdater.newUpdater(b0.class, "_decision$volatile");
    private volatile /* synthetic */ int _decision$volatile;

    @Override // pc.q, kc.e1
    public final void p(Object obj) {
        q(obj);
    }

    @Override // pc.q, kc.e1
    public final void q(Object obj) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        do {
            atomicIntegerFieldUpdater = i;
            int i3 = atomicIntegerFieldUpdater.get(this);
            if (i3 != 0) {
                if (i3 != 1) {
                    od.f.e("Already resumed");
                    return;
                } else {
                    pc.a.h(w.w(obj), td.h.y(this.f9980h));
                    return;
                }
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, 0, 2));
    }
}

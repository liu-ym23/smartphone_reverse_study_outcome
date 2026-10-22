package pc;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f9969a = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "_cur$volatile");
    private volatile /* synthetic */ Object _cur$volatile = new m(8, false);

    public final boolean a(Runnable runnable) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f9969a;
            m mVar = (m) atomicReferenceFieldUpdater.get(this);
            int iA = mVar.a(runnable);
            if (iA == 0) {
                return true;
            }
            if (iA == 1) {
                atomicReferenceFieldUpdater.compareAndSet(this, mVar, mVar.c());
            } else if (iA == 2) {
                return false;
            }
        }
    }

    public final int b() {
        m mVar = (m) f9969a.get(this);
        mVar.getClass();
        long j10 = m.f9972f.get(mVar);
        return 1073741823 & (((int) ((j10 & 1152921503533105152L) >> 30)) - ((int) (1073741823 & j10)));
    }

    public final Object c() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f9969a;
            m mVar = (m) atomicReferenceFieldUpdater.get(this);
            Object objD = mVar.d();
            if (objD != m.f9973g) {
                return objD;
            }
            atomicReferenceFieldUpdater.compareAndSet(this, mVar, mVar.c());
        }
    }
}

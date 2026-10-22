package s9;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes4.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f6000a = AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "_cur$volatile");
    private volatile /* synthetic */ Object _cur$volatile = new j(8, false);

    public final boolean a(Runnable runnable) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6000a;
            j jVar = (j) atomicReferenceFieldUpdater.get(this);
            int iA = jVar.a(runnable);
            if (iA == 0) {
                return true;
            }
            if (iA == 1) {
                atomicReferenceFieldUpdater.compareAndSet(this, jVar, jVar.c());
            } else if (iA == 2) {
                return false;
            }
        }
    }

    public final int b() {
        j jVar = (j) f6000a.get(this);
        jVar.getClass();
        long j5 = j.f.get(jVar);
        return 1073741823 & (((int) ((j5 & 1152921503533105152L) >> 30)) - ((int) (1073741823 & j5)));
    }

    public final Object c() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6000a;
            j jVar = (j) atomicReferenceFieldUpdater.get(this);
            Object objD = jVar.d();
            if (objD != j.g) {
                return objD;
            }
            atomicReferenceFieldUpdater.compareAndSet(this, jVar, jVar.c());
        }
    }
}

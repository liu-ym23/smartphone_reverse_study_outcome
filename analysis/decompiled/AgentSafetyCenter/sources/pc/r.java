package pc;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kc.j1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class r extends b implements j1 {

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f9981d = AtomicIntegerFieldUpdater.newUpdater(r.class, "cleanedAndPointers$volatile");

    /* renamed from: c, reason: collision with root package name */
    public final long f9982c;
    private volatile /* synthetic */ int cleanedAndPointers$volatile;

    public r(long j10, r rVar, int i) {
        super(rVar);
        this.f9982c = j10;
        this.cleanedAndPointers$volatile = i << 16;
    }

    @Override // pc.b
    public final boolean c() {
        return f9981d.get(this) == f() && b() != null;
    }

    public final boolean e() {
        return f9981d.addAndGet(this, -65536) == f() && b() != null;
    }

    public abstract int f();

    public abstract void g(int i, nb.g gVar);

    public final void h() {
        if (f9981d.incrementAndGet(this) == f()) {
            d();
        }
    }

    public final boolean i() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i;
        do {
            atomicIntegerFieldUpdater = f9981d;
            i = atomicIntegerFieldUpdater.get(this);
            if (i == f() && b() != null) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, 65536 + i));
        return true;
    }
}

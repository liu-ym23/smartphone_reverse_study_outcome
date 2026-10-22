package z4;

import j4.v;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f24128b = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "lastScheduledTask$volatile");

    /* renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f24129c = AtomicIntegerFieldUpdater.newUpdater(n.class, "producerIndex$volatile");

    /* renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f24130d = AtomicIntegerFieldUpdater.newUpdater(n.class, "consumerIndex$volatile");

    /* renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f24131e = AtomicIntegerFieldUpdater.newUpdater(n.class, "blockingTasksInBuffer$volatile");

    /* renamed from: a, reason: collision with root package name */
    private final AtomicReferenceArray<h> f24132a = new AtomicReferenceArray<>(128);
    private volatile /* synthetic */ int blockingTasksInBuffer$volatile;
    private volatile /* synthetic */ int consumerIndex$volatile;
    private volatile /* synthetic */ Object lastScheduledTask$volatile;
    private volatile /* synthetic */ int producerIndex$volatile;

    private final h b(h hVar) {
        if (e() == 127) {
            return hVar;
        }
        if (hVar.f24116b.b() == 1) {
            f24131e.incrementAndGet(this);
        }
        int i5 = f24129c.get(this) & 127;
        while (this.f24132a.get(i5) != null) {
            Thread.yield();
        }
        this.f24132a.lazySet(i5, hVar);
        f24129c.incrementAndGet(this);
        return null;
    }

    private final void c(h hVar) {
        if (hVar == null || hVar.f24116b.b() != 1) {
            return;
        }
        f24131e.decrementAndGet(this);
    }

    private final int e() {
        return f24129c.get(this) - f24130d.get(this);
    }

    private final h m() {
        h andSet;
        while (true) {
            int i5 = f24130d.get(this);
            if (i5 - f24129c.get(this) == 0) {
                return null;
            }
            int i6 = i5 & 127;
            if (f24130d.compareAndSet(this, i5, i5 + 1) && (andSet = this.f24132a.getAndSet(i6, null)) != null) {
                c(andSet);
                return andSet;
            }
        }
    }

    private final boolean n(C1352d c1352d) {
        h hVarM = m();
        if (hVarM == null) {
            return false;
        }
        c1352d.a(hVarM);
        return true;
    }

    private final h o(boolean z5) {
        h hVar;
        do {
            hVar = (h) f24128b.get(this);
            if (hVar != null) {
                if ((hVar.f24116b.b() == 1) == z5) {
                }
            }
            int i5 = f24130d.get(this);
            int i6 = f24129c.get(this);
            while (i5 != i6) {
                if (z5 && f24131e.get(this) == 0) {
                    return null;
                }
                i6--;
                h hVarQ = q(i6, z5);
                if (hVarQ != null) {
                    return hVarQ;
                }
            }
            return null;
        } while (!f24128b.compareAndSet(this, hVar, null));
        return hVar;
    }

    private final h p(int i5) {
        int i6 = f24130d.get(this);
        int i7 = f24129c.get(this);
        boolean z5 = i5 == 1;
        while (i6 != i7) {
            if (z5 && f24131e.get(this) == 0) {
                return null;
            }
            int i8 = i6 + 1;
            h hVarQ = q(i6, z5);
            if (hVarQ != null) {
                return hVarQ;
            }
            i6 = i8;
        }
        return null;
    }

    private final h q(int i5, boolean z5) {
        int i6 = i5 & 127;
        h hVar = this.f24132a.get(i6);
        if (hVar != null) {
            if ((hVar.f24116b.b() == 1) == z5 && this.f24132a.compareAndSet(i6, hVar, null)) {
                if (z5) {
                    f24131e.decrementAndGet(this);
                }
                return hVar;
            }
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object, z4.h] */
    private final long s(int i5, v<h> vVar) {
        ?? r02;
        do {
            r02 = (h) f24128b.get(this);
            if (r02 == 0) {
                return -2L;
            }
            if (((r02.f24116b.b() != 1 ? 2 : 1) & i5) == 0) {
                return -2L;
            }
            long jA = l.f24124f.a() - r02.f24115a;
            long j5 = l.f24120b;
            if (jA < j5) {
                return j5 - jA;
            }
        } while (!f24128b.compareAndSet(this, r02, null));
        vVar.f17836a = r02;
        return -1L;
    }

    public final h a(h hVar, boolean z5) {
        if (z5) {
            return b(hVar);
        }
        h hVar2 = (h) f24128b.getAndSet(this, hVar);
        if (hVar2 == null) {
            return null;
        }
        return b(hVar2);
    }

    public final int i() {
        Object obj = f24128b.get(this);
        int iE = e();
        return obj != null ? iE + 1 : iE;
    }

    public final void j(C1352d c1352d) {
        h hVar = (h) f24128b.getAndSet(this, null);
        if (hVar != null) {
            c1352d.a(hVar);
        }
        while (n(c1352d)) {
        }
    }

    public final h k() {
        h hVar = (h) f24128b.getAndSet(this, null);
        return hVar == null ? m() : hVar;
    }

    public final h l() {
        return o(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long r(int i5, v<h> vVar) {
        T tM = i5 == 3 ? m() : p(i5);
        if (tM == 0) {
            return s(i5, vVar);
        }
        vVar.f17836a = tM;
        return -1L;
    }
}

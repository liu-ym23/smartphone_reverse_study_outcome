package ra;

import c7.r;
import f8.x;
import ia.g2;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import na.s;

/* loaded from: classes.dex */
public class i {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f9121c = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "head$volatile");

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f9122d = AtomicLongFieldUpdater.newUpdater(i.class, "deqIdx$volatile");

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f9123e = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "tail$volatile");

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f9124f = AtomicLongFieldUpdater.newUpdater(i.class, "enqIdx$volatile");

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f9125g = AtomicIntegerFieldUpdater.newUpdater(i.class, "_availablePermits$volatile");
    private volatile /* synthetic */ int _availablePermits$volatile;

    /* renamed from: a, reason: collision with root package name */
    public final int f9126a;

    /* renamed from: b, reason: collision with root package name */
    public final ia.l f9127b;
    private volatile /* synthetic */ long deqIdx$volatile;
    private volatile /* synthetic */ long enqIdx$volatile;
    private volatile /* synthetic */ Object head$volatile;
    private volatile /* synthetic */ Object tail$volatile;

    public i(int i2) {
        this.f9126a = i2;
        if (i2 <= 0) {
            throw new IllegalArgumentException(n.f.c(i2, "Semaphore should have at least 1 permit, but had ").toString());
        }
        if (i2 < 0) {
            throw new IllegalArgumentException(n.f.c(i2, "The number of acquired permits should be in 0..").toString());
        }
        l lVar = new l(0L, null, 2);
        this.head$volatile = lVar;
        this.tail$volatile = lVar;
        this._availablePermits$volatile = i2;
        this.f9127b = new ia.l(1, this);
    }

    public final boolean a(g2 g2Var) {
        Object objB;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f9123e;
        l lVar = (l) atomicReferenceFieldUpdater.get(this);
        long andIncrement = f9124f.getAndIncrement(this);
        g gVar = g.f9119n;
        long j2 = andIncrement / k.f9133f;
        loop0: while (true) {
            objB = na.b.b(lVar, j2, gVar);
            if (!na.b.e(objB)) {
                s sVarC = na.b.c(objB);
                while (true) {
                    s sVar = (s) atomicReferenceFieldUpdater.get(this);
                    if (sVar.f6927c >= sVarC.f6927c) {
                        break loop0;
                    }
                    if (!sVarC.j()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, sVar, sVarC)) {
                        if (atomicReferenceFieldUpdater.get(this) != sVar) {
                            if (sVarC.f()) {
                                sVarC.e();
                            }
                        }
                    }
                    if (sVar.f()) {
                        sVar.e();
                    }
                }
            } else {
                break;
            }
        }
        l lVar2 = (l) na.b.c(objB);
        AtomicReferenceArray atomicReferenceArray = lVar2.f9134e;
        int i2 = (int) (andIncrement % k.f9133f);
        while (!atomicReferenceArray.compareAndSet(i2, null, g2Var)) {
            if (atomicReferenceArray.get(i2) != null) {
                x xVar = k.f9129b;
                x xVar2 = k.f9130c;
                while (!atomicReferenceArray.compareAndSet(i2, xVar, xVar2)) {
                    if (atomicReferenceArray.get(i2) != xVar) {
                        return false;
                    }
                }
                ((ia.k) g2Var).m(r.f1986a, this.f9127b);
                return true;
            }
        }
        g2Var.b(lVar2, i2);
        return true;
    }

    public final void b() {
        int i2;
        Object objB;
        boolean z4;
        do {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f9125g;
            int andIncrement = atomicIntegerFieldUpdater.getAndIncrement(this);
            int i10 = this.f9126a;
            if (andIncrement >= i10) {
                do {
                    i2 = atomicIntegerFieldUpdater.get(this);
                    if (i2 <= i10) {
                        break;
                    }
                } while (!atomicIntegerFieldUpdater.compareAndSet(this, i2, i10));
                throw new IllegalStateException(("The number of released permits cannot be greater than " + i10).toString());
            }
            if (andIncrement >= 0) {
                return;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f9121c;
            l lVar = (l) atomicReferenceFieldUpdater.get(this);
            long andIncrement2 = f9122d.getAndIncrement(this);
            long j2 = andIncrement2 / k.f9133f;
            h hVar = h.f9120n;
            while (true) {
                objB = na.b.b(lVar, j2, hVar);
                if (na.b.e(objB)) {
                    break;
                }
                s sVarC = na.b.c(objB);
                while (true) {
                    s sVar = (s) atomicReferenceFieldUpdater.get(this);
                    if (sVar.f6927c >= sVarC.f6927c) {
                        break;
                    }
                    if (!sVarC.j()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, sVar, sVarC)) {
                        if (atomicReferenceFieldUpdater.get(this) != sVar) {
                            if (sVarC.f()) {
                                sVarC.e();
                            }
                        }
                    }
                    if (sVar.f()) {
                        sVar.e();
                    }
                }
            }
            l lVar2 = (l) na.b.c(objB);
            AtomicReferenceArray atomicReferenceArray = lVar2.f9134e;
            lVar2.b();
            z4 = false;
            if (lVar2.f6927c <= j2) {
                int i11 = (int) (andIncrement2 % k.f9133f);
                Object andSet = atomicReferenceArray.getAndSet(i11, k.f9129b);
                if (andSet == null) {
                    int i12 = k.f9128a;
                    for (int i13 = 0; i13 < i12; i13++) {
                        if (atomicReferenceArray.get(i11) == k.f9130c) {
                            z4 = true;
                            break;
                        }
                    }
                    x xVar = k.f9129b;
                    x xVar2 = k.f9131d;
                    while (true) {
                        if (!atomicReferenceArray.compareAndSet(i11, xVar, xVar2)) {
                            if (atomicReferenceArray.get(i11) != xVar) {
                                break;
                            }
                        } else {
                            z4 = true;
                            break;
                        }
                    }
                    z4 = !z4;
                } else if (andSet != k.f9132e) {
                    if (!(andSet instanceof ia.k)) {
                        throw new IllegalStateException(("unexpected: " + andSet).toString());
                    }
                    ia.k kVar = (ia.k) andSet;
                    x xVarH = kVar.h(r.f1986a, this.f9127b);
                    if (xVarH != null) {
                        kVar.x(xVarH);
                        z4 = true;
                        break;
                        break;
                    }
                }
            }
        } while (!z4);
    }
}

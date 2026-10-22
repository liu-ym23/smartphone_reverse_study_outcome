package i6;

import a6.g2;
import a6.l;
import androidx.emoji2.text.r;
import b5.a0;
import f6.q;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class h {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f3158c = AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "head$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater d = AtomicLongFieldUpdater.newUpdater(h.class, "deqIdx$volatile");

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f3159e = AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "tail$volatile");

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f3160f = AtomicLongFieldUpdater.newUpdater(h.class, "enqIdx$volatile");

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f3161g = AtomicIntegerFieldUpdater.newUpdater(h.class, "_availablePermits$volatile");
    private volatile /* synthetic */ int _availablePermits$volatile;

    /* renamed from: a, reason: collision with root package name */
    public final int f3162a;

    /* renamed from: b, reason: collision with root package name */
    public final l f3163b;
    private volatile /* synthetic */ long deqIdx$volatile;
    private volatile /* synthetic */ long enqIdx$volatile;
    private volatile /* synthetic */ Object head$volatile;
    private volatile /* synthetic */ Object tail$volatile;

    public h(int i8) {
        this.f3162a = i8;
        if (i8 <= 0) {
            throw new IllegalArgumentException(a8.b.j(i8, "Semaphore should have at least 1 permit, but had ").toString());
        }
        if (i8 < 0) {
            throw new IllegalArgumentException(a8.b.j(i8, "The number of acquired permits should be in 0..").toString());
        }
        k kVar = new k(0L, null, 2);
        this.head$volatile = kVar;
        this.tail$volatile = kVar;
        this._availablePermits$volatile = i8;
        this.f3163b = new l(3, this);
    }

    public final boolean a(g2 g2Var) {
        Object objB;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3159e;
        k kVar = (k) atomicReferenceFieldUpdater.get(this);
        long andIncrement = f3160f.getAndIncrement(this);
        f fVar = f.f3156a;
        long j4 = andIncrement / j.f3168f;
        loop0: while (true) {
            objB = f6.a.b(kVar, j4, fVar);
            if (!f6.a.e(objB)) {
                q qVarC = f6.a.c(objB);
                while (true) {
                    q qVar = (q) atomicReferenceFieldUpdater.get(this);
                    if (qVar.f2659c >= qVarC.f2659c) {
                        break loop0;
                    }
                    if (!qVarC.j()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, qVar, qVarC)) {
                        if (atomicReferenceFieldUpdater.get(this) != qVar) {
                            if (qVarC.f()) {
                                qVarC.e();
                            }
                        }
                    }
                    if (qVar.f()) {
                        qVar.e();
                    }
                }
            } else {
                break;
            }
        }
        k kVar2 = (k) f6.a.c(objB);
        AtomicReferenceArray atomicReferenceArray = kVar2.f3169e;
        int i8 = (int) (andIncrement % j.f3168f);
        while (!atomicReferenceArray.compareAndSet(i8, null, g2Var)) {
            if (atomicReferenceArray.get(i8) != null) {
                r rVar = j.f3165b;
                r rVar2 = j.f3166c;
                while (!atomicReferenceArray.compareAndSet(i8, rVar, rVar2)) {
                    if (atomicReferenceArray.get(i8) != rVar) {
                        return false;
                    }
                }
                ((a6.k) g2Var).h(a0.f883a, this.f3163b);
                return true;
            }
        }
        g2Var.b(kVar2, i8);
        return true;
    }

    public final void b() {
        int i8;
        Object objB;
        boolean z;
        do {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f3161g;
            int andIncrement = atomicIntegerFieldUpdater.getAndIncrement(this);
            int i9 = this.f3162a;
            if (andIncrement >= i9) {
                do {
                    i8 = atomicIntegerFieldUpdater.get(this);
                    if (i8 <= i9) {
                        break;
                    }
                } while (!atomicIntegerFieldUpdater.compareAndSet(this, i8, i9));
                throw new IllegalStateException(("The number of released permits cannot be greater than " + i9).toString());
            }
            if (andIncrement >= 0) {
                return;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3158c;
            k kVar = (k) atomicReferenceFieldUpdater.get(this);
            long andIncrement2 = d.getAndIncrement(this);
            long j4 = andIncrement2 / j.f3168f;
            g gVar = g.f3157a;
            while (true) {
                objB = f6.a.b(kVar, j4, gVar);
                if (f6.a.e(objB)) {
                    break;
                }
                q qVarC = f6.a.c(objB);
                while (true) {
                    q qVar = (q) atomicReferenceFieldUpdater.get(this);
                    if (qVar.f2659c >= qVarC.f2659c) {
                        break;
                    }
                    if (!qVarC.j()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, qVar, qVarC)) {
                        if (atomicReferenceFieldUpdater.get(this) != qVar) {
                            if (qVarC.f()) {
                                qVarC.e();
                            }
                        }
                    }
                    if (qVar.f()) {
                        qVar.e();
                    }
                }
            }
            k kVar2 = (k) f6.a.c(objB);
            AtomicReferenceArray atomicReferenceArray = kVar2.f3169e;
            kVar2.b();
            z = false;
            if (kVar2.f2659c <= j4) {
                int i10 = (int) (andIncrement2 % j.f3168f);
                Object andSet = atomicReferenceArray.getAndSet(i10, j.f3165b);
                if (andSet == null) {
                    int i11 = j.f3164a;
                    for (int i12 = 0; i12 < i11; i12++) {
                        if (atomicReferenceArray.get(i10) == j.f3166c) {
                            z = true;
                            break;
                        }
                    }
                    r rVar = j.f3165b;
                    r rVar2 = j.d;
                    while (true) {
                        if (!atomicReferenceArray.compareAndSet(i10, rVar, rVar2)) {
                            if (atomicReferenceArray.get(i10) != rVar) {
                                break;
                            }
                        } else {
                            z = true;
                            break;
                        }
                    }
                    z = !z;
                } else if (andSet != j.f3167e) {
                    if (!(andSet instanceof a6.k)) {
                        throw new IllegalStateException(("unexpected: " + andSet).toString());
                    }
                    a6.k kVar3 = (a6.k) andSet;
                    r rVarP = kVar3.p(a0.f883a, this.f3163b);
                    if (rVarP != null) {
                        kVar3.m(rVarP);
                        z = true;
                        break;
                        break;
                    }
                }
            }
        } while (!z);
    }
}

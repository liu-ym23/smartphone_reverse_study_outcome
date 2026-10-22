package sc;

import e9.e0;
import java.lang.invoke.VarHandle;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import jb.v;
import kc.t1;
import pc.r;
import pc.t;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class g {

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f12179g = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "head$volatile");

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f12180h = AtomicLongFieldUpdater.newUpdater(g.class, "deqIdx$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater i = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "tail$volatile");

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f12181j = AtomicLongFieldUpdater.newUpdater(g.class, "enqIdx$volatile");

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f12182k = AtomicIntegerFieldUpdater.newUpdater(g.class, "_availablePermits$volatile");
    private volatile /* synthetic */ int _availablePermits$volatile;

    /* renamed from: c, reason: collision with root package name */
    public final int f12183c;
    private volatile /* synthetic */ long deqIdx$volatile;
    private volatile /* synthetic */ long enqIdx$volatile;

    /* renamed from: f, reason: collision with root package name */
    public final e0 f12184f;
    private volatile /* synthetic */ Object head$volatile;
    private volatile /* synthetic */ Object tail$volatile;

    public g(int i3) {
        this.f12183c = i3;
        if (i3 <= 0) {
            od.f.c(k0.a.j(i3, "Semaphore should have at least 1 permit, but had "));
            throw null;
        }
        if (i3 < 0) {
            od.f.c(k0.a.j(i3, "The number of acquired permits should be in 0.."));
            throw null;
        }
        j jVar = new j(0L, null, 2);
        this.head$volatile = jVar;
        this.tail$volatile = jVar;
        this._availablePermits$volatile = i3;
        e0 e0Var = new e0(4);
        e0Var.f3643f = this;
        VarHandle.storeStoreFence();
        this.f12184f = e0Var;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0025, code lost:
    
        r5.l(r3, r4.f12184f);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(pb.c r5) {
        /*
            r4 = this;
        L0:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = sc.g.f12182k
            int r1 = r0.getAndDecrement(r4)
            int r2 = r4.f12183c
            if (r1 > r2) goto L0
            jb.v r3 = jb.v.f6774a
            if (r1 <= 0) goto Lf
            goto L3e
        Lf:
            nb.c r5 = td.h.y(r5)
            kc.g r5 = kc.w.o(r5)
            boolean r1 = r4.b(r5)     // Catch: java.lang.Throwable -> L3f
            if (r1 != 0) goto L31
        L1d:
            int r1 = r0.getAndDecrement(r4)     // Catch: java.lang.Throwable -> L3f
            if (r1 > r2) goto L1d
            if (r1 <= 0) goto L2b
            e9.e0 r4 = r4.f12184f     // Catch: java.lang.Throwable -> L3f
            r5.l(r3, r4)     // Catch: java.lang.Throwable -> L3f
            goto L31
        L2b:
            boolean r1 = r4.b(r5)     // Catch: java.lang.Throwable -> L3f
            if (r1 == 0) goto L1d
        L31:
            java.lang.Object r4 = r5.r()
            ob.a r5 = ob.a.f9351c
            if (r4 != r5) goto L3a
            goto L3b
        L3a:
            r4 = r3
        L3b:
            if (r4 != r5) goto L3e
            return r4
        L3e:
            return r3
        L3f:
            r4 = move-exception
            r5.z()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: sc.g.a(pb.c):java.lang.Object");
    }

    public final boolean b(t1 t1Var) {
        Object objB;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = i;
        j jVar = (j) atomicReferenceFieldUpdater.get(this);
        long andIncrement = f12181j.getAndIncrement(this);
        e eVar = e.f12177m;
        long j10 = andIncrement / i.f12190f;
        loop0: while (true) {
            objB = pc.a.b(jVar, j10, eVar);
            if (!pc.a.e(objB)) {
                r rVarC = pc.a.c(objB);
                while (true) {
                    r rVar = (r) atomicReferenceFieldUpdater.get(this);
                    if (rVar.f9982c >= rVarC.f9982c) {
                        break loop0;
                    }
                    if (!rVarC.i()) {
                        break;
                    }
                    if (atomicReferenceFieldUpdater.compareAndSet(this, rVar, rVarC)) {
                        if (rVar.e()) {
                            rVar.d();
                        }
                    } else if (rVarC.e()) {
                        rVarC.d();
                    }
                }
            } else {
                break;
            }
        }
        j jVar2 = (j) pc.a.c(objB);
        AtomicReferenceArray atomicReferenceArray = jVar2.f12191e;
        int i3 = (int) (andIncrement % i.f12190f);
        if (atomicReferenceArray.compareAndSet(i3, null, t1Var)) {
            t1Var.a(jVar2, i3);
            return true;
        }
        if (!atomicReferenceArray.compareAndSet(i3, i.f12186b, i.f12187c)) {
            return false;
        }
        ((kc.f) t1Var).l(v.f6774a, this.f12184f);
        return true;
    }

    public final void c() {
        int i3;
        Object objB;
        int i10;
        do {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f12182k;
            int andIncrement = atomicIntegerFieldUpdater.getAndIncrement(this);
            int i11 = this.f12183c;
            if (andIncrement >= i11) {
                do {
                    i3 = atomicIntegerFieldUpdater.get(this);
                    if (i3 <= i11) {
                        break;
                    }
                } while (!atomicIntegerFieldUpdater.compareAndSet(this, i3, i11));
                throw new IllegalStateException(("The number of released permits cannot be greater than " + i11).toString());
            }
            if (andIncrement >= 0) {
                return;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f12179g;
            j jVar = (j) atomicReferenceFieldUpdater.get(this);
            long andIncrement2 = f12180h.getAndIncrement(this);
            long j10 = andIncrement2 / i.f12190f;
            f fVar = f.f12178m;
            while (true) {
                objB = pc.a.b(jVar, j10, fVar);
                if (!pc.a.e(objB)) {
                    r rVarC = pc.a.c(objB);
                    while (true) {
                        r rVar = (r) atomicReferenceFieldUpdater.get(this);
                        if (rVar.f9982c >= rVarC.f9982c) {
                            break;
                        }
                        if (!rVarC.i()) {
                            break;
                        }
                        if (atomicReferenceFieldUpdater.compareAndSet(this, rVar, rVarC)) {
                            if (rVar.e()) {
                                rVar.d();
                            }
                        } else if (rVarC.e()) {
                            rVarC.d();
                        }
                    }
                } else {
                    break;
                }
            }
            j jVar2 = (j) pc.a.c(objB);
            AtomicReferenceArray atomicReferenceArray = jVar2.f12191e;
            jVar2.a();
            i10 = 0;
            if (jVar2.f9982c <= j10) {
                int i12 = (int) (andIncrement2 % i.f12190f);
                Object andSet = atomicReferenceArray.getAndSet(i12, i.f12186b);
                if (andSet == null) {
                    int i13 = i.f12185a;
                    while (i10 < i13) {
                        if (atomicReferenceArray.get(i12) == i.f12187c) {
                            i10 = 1;
                            break;
                        }
                        i10++;
                    }
                    i10 = !atomicReferenceArray.compareAndSet(i12, i.f12186b, i.f12188d) ? 1 : 0;
                } else if (andSet != i.f12189e) {
                    if (!(andSet instanceof kc.f)) {
                        g5.f.n(andSet, "unexpected: ");
                        return;
                    }
                    kc.f fVar2 = (kc.f) andSet;
                    t tVarK = fVar2.k(v.f6774a, this.f12184f);
                    if (tVarK != null) {
                        fVar2.m(tVarK);
                        i10 = 1;
                        break;
                        break;
                    }
                }
            }
        } while (i10 == 0);
    }
}

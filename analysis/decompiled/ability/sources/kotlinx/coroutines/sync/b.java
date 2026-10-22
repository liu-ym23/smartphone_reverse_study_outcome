package kotlinx.coroutines.sync;

import C7.r;
import Ca.C0203b;
import a5.d;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import m9.InterfaceC1717j;
import m9.y0;
import s9.AbstractC1921a;
import s9.p;
import v9.InterfaceC2075d;
import w9.g;
import w9.h;

/* loaded from: classes4.dex */
public class b {
    public static final /* synthetic */ AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "head$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater d = AtomicLongFieldUpdater.newUpdater(b.class, "deqIdx$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "tail$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater f = AtomicLongFieldUpdater.newUpdater(b.class, "enqIdx$volatile");
    public static final /* synthetic */ AtomicIntegerFieldUpdater g = AtomicIntegerFieldUpdater.newUpdater(b.class, "_availablePermits$volatile");
    private volatile /* synthetic */ int _availablePermits$volatile;

    /* renamed from: a, reason: collision with root package name */
    public final int f5261a;
    public final C0203b b;
    private volatile /* synthetic */ long deqIdx$volatile;
    private volatile /* synthetic */ long enqIdx$volatile;
    private volatile /* synthetic */ Object head$volatile;
    private volatile /* synthetic */ Object tail$volatile;

    public b(int i) {
        this.f5261a = i;
        if (i <= 0) {
            throw new IllegalArgumentException(B7.a.h(i, "Semaphore should have at least 1 permit, but had ").toString());
        }
        if (i < 0) {
            throw new IllegalArgumentException(B7.a.h(i, "The number of acquired permits should be in 0..").toString());
        }
        h hVar = new h(0L, null, 2);
        this.head$volatile = hVar;
        this.tail$volatile = hVar;
        this._availablePermits$volatile = i;
        this.b = new C0203b(this, 4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0025, code lost:
    
        r5.d(r3, r4.b);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(kotlin.coroutines.jvm.internal.ContinuationImpl r5) {
        /*
            r4 = this;
        L0:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = kotlinx.coroutines.sync.b.g
            int r1 = r0.getAndDecrement(r4)
            int r2 = r4.f5261a
            if (r1 > r2) goto L0
            C7.r r3 = C7.r.f317a
            if (r1 <= 0) goto Lf
            goto L3e
        Lf:
            H7.c r5 = U7.a.I(r5)
            m9.k r5 = m9.AbstractC1683A.j(r5)
            boolean r1 = r4.b(r5)     // Catch: java.lang.Throwable -> L3f
            if (r1 != 0) goto L31
        L1d:
            int r1 = r0.getAndDecrement(r4)     // Catch: java.lang.Throwable -> L3f
            if (r1 > r2) goto L1d
            if (r1 <= 0) goto L2b
            Ca.b r4 = r4.b     // Catch: java.lang.Throwable -> L3f
            r5.d(r3, r4)     // Catch: java.lang.Throwable -> L3f
            goto L31
        L2b:
            boolean r1 = r4.b(r5)     // Catch: java.lang.Throwable -> L3f
            if (r1 == 0) goto L1d
        L31:
            java.lang.Object r4 = r5.x()
            kotlin.coroutines.intrinsics.CoroutineSingletons r5 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
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
            r5.E()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.b.a(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final boolean b(y0 y0Var) {
        Object objB;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = e;
        h hVar = (h) atomicReferenceFieldUpdater.get(this);
        long andIncrement = f.getAndIncrement(this);
        SemaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1 semaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1 = SemaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1.f5259a;
        long j5 = andIncrement / g.f;
        loop0: while (true) {
            objB = AbstractC1921a.b(hVar, j5, semaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1);
            if (!AbstractC1921a.e(objB)) {
                p pVarC = AbstractC1921a.c(objB);
                while (true) {
                    p pVar = (p) atomicReferenceFieldUpdater.get(this);
                    if (pVar.c >= pVarC.c) {
                        break loop0;
                    }
                    if (!pVarC.j()) {
                        break;
                    }
                    if (atomicReferenceFieldUpdater.compareAndSet(this, pVar, pVarC)) {
                        if (pVar.f()) {
                            pVar.e();
                        }
                    } else if (pVarC.f()) {
                        pVarC.e();
                    }
                }
            } else {
                break;
            }
        }
        h hVar2 = (h) AbstractC1921a.c(objB);
        AtomicReferenceArray atomicReferenceArray = hVar2.e;
        int i = (int) (andIncrement % g.f);
        if (atomicReferenceArray.compareAndSet(i, null, y0Var)) {
            y0Var.c(hVar2, i);
            return true;
        }
        if (!atomicReferenceArray.compareAndSet(i, g.b, g.c)) {
            return false;
        }
        boolean z10 = y0Var instanceof InterfaceC1717j;
        r rVar = r.f317a;
        if (z10) {
            ((InterfaceC1717j) y0Var).d(rVar, this.b);
            return true;
        }
        if (y0Var instanceof InterfaceC2075d) {
            ((InterfaceC2075d) y0Var).f(rVar);
            return true;
        }
        throw new IllegalStateException(("unexpected: " + y0Var).toString());
    }

    public final void c() {
        int i;
        Object objB;
        boolean zG;
        do {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = g;
            int andIncrement = atomicIntegerFieldUpdater.getAndIncrement(this);
            int i6 = this.f5261a;
            if (andIncrement >= i6) {
                do {
                    i = atomicIntegerFieldUpdater.get(this);
                    if (i <= i6) {
                        break;
                    }
                } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, i6));
                throw new IllegalStateException(("The number of released permits cannot be greater than " + i6).toString());
            }
            if (andIncrement >= 0) {
                return;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = c;
            h hVar = (h) atomicReferenceFieldUpdater.get(this);
            long andIncrement2 = d.getAndIncrement(this);
            long j5 = andIncrement2 / g.f;
            SemaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1 semaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1 = SemaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1.f5260a;
            while (true) {
                objB = AbstractC1921a.b(hVar, j5, semaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1);
                if (AbstractC1921a.e(objB)) {
                    break;
                }
                p pVarC = AbstractC1921a.c(objB);
                while (true) {
                    p pVar = (p) atomicReferenceFieldUpdater.get(this);
                    if (pVar.c >= pVarC.c) {
                        break;
                    }
                    if (!pVarC.j()) {
                        break;
                    }
                    if (atomicReferenceFieldUpdater.compareAndSet(this, pVar, pVarC)) {
                        if (pVar.f()) {
                            pVar.e();
                        }
                    } else if (pVarC.f()) {
                        pVarC.e();
                    }
                }
            }
            h hVar2 = (h) AbstractC1921a.c(objB);
            AtomicReferenceArray atomicReferenceArray = hVar2.e;
            hVar2.a();
            zG = false;
            zG = false;
            zG = false;
            if (hVar2.c <= j5) {
                int i10 = (int) (andIncrement2 % g.f);
                Object andSet = atomicReferenceArray.getAndSet(i10, g.b);
                if (andSet == null) {
                    int i11 = g.f6856a;
                    for (int i12 = 0; i12 < i11; i12++) {
                        if (atomicReferenceArray.get(i10) == g.c) {
                            zG = true;
                            break;
                        }
                    }
                    zG = !atomicReferenceArray.compareAndSet(i10, g.b, g.d);
                } else if (andSet != g.e) {
                    boolean z10 = andSet instanceof InterfaceC1717j;
                    r rVar = r.f317a;
                    if (z10) {
                        InterfaceC1717j interfaceC1717j = (InterfaceC1717j) andSet;
                        d dVarH = interfaceC1717j.h(rVar, this.b);
                        if (dVarH != null) {
                            interfaceC1717j.v(dVarH);
                            zG = true;
                            break;
                            break;
                        }
                    } else {
                        if (!(andSet instanceof InterfaceC2075d)) {
                            throw new IllegalStateException(androidx.compose.foundation.b.r(andSet, "unexpected: "));
                        }
                        zG = ((InterfaceC2075d) andSet).g(this, rVar);
                    }
                }
            }
        } while (!zG);
    }

    public final boolean d() {
        int i;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = g;
            int i6 = atomicIntegerFieldUpdater.get(this);
            int i10 = this.f5261a;
            if (i6 > i10) {
                do {
                    i = atomicIntegerFieldUpdater.get(this);
                    if (i > i10) {
                    }
                } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, i10));
            } else {
                if (i6 <= 0) {
                    return false;
                }
                if (atomicIntegerFieldUpdater.compareAndSet(this, i6, i6 - 1)) {
                    return true;
                }
            }
        }
    }
}

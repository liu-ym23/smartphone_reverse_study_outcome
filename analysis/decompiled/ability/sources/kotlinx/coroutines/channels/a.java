package kotlinx.coroutines.channels;

import C7.r;
import H7.c;
import a5.d;
import androidx.collection.SieveCacheKt;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import kotlinx.coroutines.selects.TrySelectDetailedResult;
import m9.AbstractC1683A;
import m9.C1718k;
import m9.InterfaceC1717j;
import m9.y0;
import o9.AbstractC1777c;
import o9.C1776b;
import o9.C1780f;
import o9.C1781g;
import o9.C1782h;
import o9.C1783i;
import o9.C1787m;
import o9.InterfaceC1779e;
import s9.AbstractC1921a;
import s9.p;
import s9.q;
import v9.InterfaceC2075d;

/* loaded from: classes4.dex */
public class a implements InterfaceC1779e {
    public static final /* synthetic */ AtomicLongFieldUpdater b = AtomicLongFieldUpdater.newUpdater(a.class, "sendersAndCloseStatus$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater c = AtomicLongFieldUpdater.newUpdater(a.class, "receivers$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater d = AtomicLongFieldUpdater.newUpdater(a.class, "bufferEnd$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater e = AtomicLongFieldUpdater.newUpdater(a.class, "completedExpandBuffersAndPauseFlag$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater f = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "sendSegment$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater g = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "receiveSegment$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater h = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "bufferEndSegment$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater i = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "_closeCause$volatile");

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f5193j = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "closeHandler$volatile");
    private volatile /* synthetic */ Object _closeCause$volatile;

    /* renamed from: a, reason: collision with root package name */
    public final int f5194a;
    private volatile /* synthetic */ long bufferEnd$volatile;
    private volatile /* synthetic */ Object bufferEndSegment$volatile;
    private volatile /* synthetic */ Object closeHandler$volatile;
    private volatile /* synthetic */ long completedExpandBuffersAndPauseFlag$volatile;
    private volatile /* synthetic */ Object receiveSegment$volatile;
    private volatile /* synthetic */ long receivers$volatile;
    private volatile /* synthetic */ Object sendSegment$volatile;
    private volatile /* synthetic */ long sendersAndCloseStatus$volatile;

    public a(int i6) {
        this.f5194a = i6;
        if (i6 < 0) {
            throw new IllegalArgumentException(androidx.appfunctions.metadata.a.i(i6, "Invalid channel capacity: ", ", should be >=0").toString());
        }
        C1783i c1783i = AbstractC1777c.f5449a;
        this.bufferEnd$volatile = i6 != 0 ? i6 != Integer.MAX_VALUE ? i6 : Long.MAX_VALUE : 0L;
        this.completedExpandBuffersAndPauseFlag$volatile = d.get(this);
        C1783i c1783i2 = new C1783i(0L, null, this, 3);
        this.sendSegment$volatile = c1783i2;
        this.receiveSegment$volatile = c1783i2;
        if (B()) {
            c1783i2 = AbstractC1777c.f5449a;
            k.d(c1783i2, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
        }
        this.bufferEndSegment$volatile = c1783i2;
        this._closeCause$volatile = AbstractC1777c.f5453s;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object E(kotlinx.coroutines.channels.a r13, kotlin.coroutines.jvm.internal.ContinuationImpl r14) {
        /*
            boolean r0 = r14 instanceof kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1
            if (r0 == 0) goto L14
            r0 = r14
            kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1 r0 = (kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.c = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1 r0 = new kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1
            r0.<init>(r13, r14)
            goto L12
        L1a:
            java.lang.Object r14 = r6.f5189a
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r6.c
            r2 = 1
            if (r1 == 0) goto L35
            if (r1 != r2) goto L2d
            kotlin.b.b(r14)
            o9.h r14 = (o9.C1782h) r14
            java.lang.Object r13 = r14.f5457a
            return r13
        L2d:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L35:
            kotlin.b.b(r14)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r14 = kotlinx.coroutines.channels.a.g
            java.lang.Object r14 = r14.get(r13)
            o9.i r14 = (o9.C1783i) r14
        L40:
            boolean r1 = r13.y()
            if (r1 == 0) goto L50
            java.lang.Throwable r13 = r13.l()
            o9.f r14 = new o9.f
            r14.<init>(r13)
            return r14
        L50:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = kotlinx.coroutines.channels.a.c
            long r4 = r1.getAndIncrement(r13)
            int r1 = o9.AbstractC1777c.b
            long r7 = (long) r1
            long r9 = r4 / r7
            long r7 = r4 % r7
            int r3 = (int) r7
            long r7 = r14.c
            int r1 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r1 == 0) goto L6d
            o9.i r1 = r13.k(r9, r14)
            if (r1 != 0) goto L6b
            goto L40
        L6b:
            r8 = r1
            goto L6e
        L6d:
            r8 = r14
        L6e:
            r12 = 0
            r7 = r13
            r9 = r3
            r10 = r4
            java.lang.Object r13 = r7.J(r8, r9, r10, r12)
            r1 = r7
            a5.d r14 = o9.AbstractC1777c.m
            if (r13 == r14) goto La0
            a5.d r14 = o9.AbstractC1777c.o
            if (r13 != r14) goto L8d
            long r13 = r1.v()
            int r13 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r13 >= 0) goto L8a
            r8.a()
        L8a:
            r13 = r1
            r14 = r8
            goto L40
        L8d:
            a5.d r14 = o9.AbstractC1777c.n
            if (r13 != r14) goto L9c
            r6.c = r2
            r2 = r8
            java.lang.Object r13 = r1.F(r2, r3, r4, r6)
            if (r13 != r0) goto L9b
            return r0
        L9b:
            return r13
        L9c:
            r8.a()
            return r13
        La0:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "unexpected"
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.a.E(kotlinx.coroutines.channels.a, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public static final C1783i b(a aVar, long j5, C1783i c1783i) {
        Object objB;
        a aVar2;
        C1783i c1783i2 = AbstractC1777c.f5449a;
        BufferedChannelKt$createSegmentFunction$1 bufferedChannelKt$createSegmentFunction$1 = BufferedChannelKt$createSegmentFunction$1.f5191a;
        loop0: while (true) {
            objB = AbstractC1921a.b(c1783i, j5, bufferedChannelKt$createSegmentFunction$1);
            if (!AbstractC1921a.e(objB)) {
                p pVarC = AbstractC1921a.c(objB);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f;
                    p pVar = (p) atomicReferenceFieldUpdater.get(aVar);
                    if (pVar.c >= pVarC.c) {
                        break loop0;
                    }
                    if (!pVarC.j()) {
                        break;
                    }
                    if (atomicReferenceFieldUpdater.compareAndSet(aVar, pVar, pVarC)) {
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
        boolean zE = AbstractC1921a.e(objB);
        AtomicLongFieldUpdater atomicLongFieldUpdater = c;
        if (zE) {
            aVar.z();
            if (c1783i.c * AbstractC1777c.b < atomicLongFieldUpdater.get(aVar)) {
                c1783i.a();
                return null;
            }
        } else {
            C1783i c1783i3 = (C1783i) AbstractC1921a.c(objB);
            long j6 = c1783i3.c;
            if (j6 <= j5) {
                return c1783i3;
            }
            long j10 = AbstractC1777c.b * j6;
            while (true) {
                long j11 = b.get(aVar);
                long j12 = 1152921504606846975L & j11;
                if (j12 >= j10) {
                    aVar2 = aVar;
                    break;
                }
                aVar2 = aVar;
                if (b.compareAndSet(aVar2, j11, (((int) (j11 >> 60)) << 60) + j12)) {
                    break;
                }
                aVar = aVar2;
            }
            if (j6 * AbstractC1777c.b < atomicLongFieldUpdater.get(aVar2)) {
                c1783i3.a();
            }
        }
        return null;
    }

    public static final void c(a aVar, Object obj, C1718k c1718k) {
        c1718k.resumeWith(kotlin.b.a(aVar.r()));
    }

    public static final void d(a aVar, InterfaceC2075d interfaceC2075d) {
        C1783i c1783i;
        a aVar2;
        InterfaceC2075d interfaceC2075d2;
        int i6;
        aVar.getClass();
        C1783i c1783i2 = (C1783i) g.get(aVar);
        while (!aVar.y()) {
            long andIncrement = c.getAndIncrement(aVar);
            long j5 = AbstractC1777c.b;
            long j6 = andIncrement / j5;
            int i10 = (int) (andIncrement % j5);
            if (c1783i2.c != j6) {
                C1783i c1783iK = aVar.k(j6, c1783i2);
                if (c1783iK == null) {
                    continue;
                } else {
                    c1783i = c1783iK;
                    interfaceC2075d2 = interfaceC2075d;
                    i6 = i10;
                    aVar2 = aVar;
                }
            } else {
                c1783i = c1783i2;
                aVar2 = aVar;
                interfaceC2075d2 = interfaceC2075d;
                i6 = i10;
            }
            Object objJ = aVar2.J(c1783i, i6, andIncrement, interfaceC2075d2);
            c1783i2 = c1783i;
            if (objJ == AbstractC1777c.m) {
                InterfaceC2075d interfaceC2075d3 = interfaceC2075d2 != null ? interfaceC2075d2 : null;
                if (interfaceC2075d3 != null) {
                    interfaceC2075d3.c(c1783i2, i6);
                    return;
                }
                return;
            }
            if (objJ != AbstractC1777c.o) {
                if (objJ == AbstractC1777c.n) {
                    throw new IllegalStateException("unexpected");
                }
                c1783i2.a();
                interfaceC2075d2.f(objJ);
                return;
            }
            if (andIncrement < aVar2.v()) {
                c1783i2.a();
            }
            aVar = aVar2;
            interfaceC2075d = interfaceC2075d2;
        }
        interfaceC2075d.f(AbstractC1777c.l);
    }

    public static final int e(a aVar, C1783i c1783i, int i6, Object obj, long j5, Object obj2, boolean z10) {
        c1783i.n(i6, obj);
        if (z10) {
            return aVar.K(c1783i, i6, obj, j5, obj2, z10);
        }
        Object objL = c1783i.l(i6);
        if (objL == null) {
            if (aVar.f(j5)) {
                if (c1783i.k(i6, null, AbstractC1777c.d)) {
                    return 1;
                }
            } else {
                if (obj2 == null) {
                    return 3;
                }
                if (c1783i.k(i6, null, obj2)) {
                    return 2;
                }
            }
        } else if (objL instanceof y0) {
            c1783i.n(i6, null);
            if (aVar.H(objL, obj)) {
                c1783i.o(i6, AbstractC1777c.i);
                return 0;
            }
            d dVar = AbstractC1777c.k;
            if (c1783i.f.getAndSet((i6 * 2) + 1, dVar) == dVar) {
                return 5;
            }
            c1783i.m(i6, true);
            return 5;
        }
        return aVar.K(c1783i, i6, obj, j5, obj2, z10);
    }

    public static void w(a aVar) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = e;
        if ((atomicLongFieldUpdater.addAndGet(aVar, 1L) & SieveCacheKt.NodeVisitedBit) != 0) {
            while ((atomicLongFieldUpdater.get(aVar) & SieveCacheKt.NodeVisitedBit) != 0) {
            }
        }
    }

    public boolean A() {
        return false;
    }

    public final boolean B() {
        long j5 = d.get(this);
        return j5 == 0 || j5 == Long.MAX_VALUE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0011, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void C(long r5, o9.C1783i r7) {
        /*
            r4 = this;
        L0:
            long r0 = r7.c
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 >= 0) goto L11
            s9.b r0 = r7.c()
            o9.i r0 = (o9.C1783i) r0
            if (r0 != 0) goto Lf
            goto L11
        Lf:
            r7 = r0
            goto L0
        L11:
            boolean r5 = r7.d()
            if (r5 == 0) goto L22
            s9.b r5 = r7.c()
            o9.i r5 = (o9.C1783i) r5
            if (r5 != 0) goto L20
            goto L22
        L20:
            r7 = r5
            goto L11
        L22:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = kotlinx.coroutines.channels.a.h
            java.lang.Object r6 = r5.get(r4)
            s9.p r6 = (s9.p) r6
            long r0 = r6.c
            long r2 = r7.c
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 < 0) goto L33
            goto L49
        L33:
            boolean r0 = r7.j()
            if (r0 != 0) goto L3a
            goto L11
        L3a:
            boolean r5 = r5.compareAndSet(r4, r6, r7)
            if (r5 == 0) goto L4a
            boolean r4 = r6.f()
            if (r4 == 0) goto L49
            r6.e()
        L49:
            return
        L4a:
            boolean r5 = r7.f()
            if (r5 == 0) goto L22
            r7.e()
            goto L22
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.a.C(long, o9.i):void");
    }

    public final Object D(c cVar, Object obj) {
        C1718k c1718k = new C1718k(1, U7.a.I(cVar));
        c1718k.y();
        c1718k.resumeWith(kotlin.b.a(r()));
        Object objX = c1718k.x();
        return objX == CoroutineSingletons.f4909a ? objX : r.f317a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object F(o9.C1783i r9, int r10, long r11, kotlin.coroutines.jvm.internal.ContinuationImpl r13) {
        /*
            Method dump skipped, instructions count: 249
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.a.F(o9.i, int, long, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final void G(y0 y0Var, boolean z10) {
        if (y0Var instanceof InterfaceC1717j) {
            ((c) y0Var).resumeWith(kotlin.b.a(z10 ? n() : r()));
            return;
        }
        if (y0Var instanceof C1787m) {
            ((C1787m) y0Var).f5458a.resumeWith(new C1782h(new C1780f(l())));
            return;
        }
        if (!(y0Var instanceof C1776b)) {
            if (y0Var instanceof InterfaceC2075d) {
                ((InterfaceC2075d) y0Var).g(this, AbstractC1777c.l);
                return;
            } else {
                throw new IllegalStateException(("Unexpected waiter: " + y0Var).toString());
            }
        }
        C1776b c1776b = (C1776b) y0Var;
        C1718k c1718k = c1776b.b;
        k.c(c1718k);
        c1776b.b = null;
        c1776b.f5448a = AbstractC1777c.l;
        Throwable thL = c1776b.c.l();
        if (thL == null) {
            c1718k.resumeWith(Boolean.FALSE);
        } else {
            c1718k.resumeWith(kotlin.b.a(thL));
        }
    }

    public final boolean H(Object obj, Object obj2) {
        if (obj instanceof InterfaceC2075d) {
            return ((InterfaceC2075d) obj).g(this, obj2);
        }
        if (obj instanceof C1787m) {
            k.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
            return AbstractC1777c.a(((C1787m) obj).f5458a, new C1782h(obj2), null);
        }
        if (!(obj instanceof C1776b)) {
            if (!(obj instanceof InterfaceC1717j)) {
                throw new IllegalStateException(androidx.compose.foundation.b.r(obj, "Unexpected receiver type: "));
            }
            k.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
            return AbstractC1777c.a((InterfaceC1717j) obj, obj2, null);
        }
        k.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
        C1776b c1776b = (C1776b) obj;
        C1718k c1718k = c1776b.b;
        k.c(c1718k);
        c1776b.b = null;
        c1776b.f5448a = obj2;
        return AbstractC1777c.a(c1718k, Boolean.TRUE, null);
    }

    public final boolean I(Object obj, C1783i c1783i, int i6) {
        TrySelectDetailedResult trySelectDetailedResult;
        boolean z10 = obj instanceof InterfaceC1717j;
        r rVar = r.f317a;
        if (z10) {
            k.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            return AbstractC1777c.a((InterfaceC1717j) obj, rVar, null);
        }
        if (!(obj instanceof InterfaceC2075d)) {
            throw new IllegalStateException(androidx.compose.foundation.b.r(obj, "Unexpected waiter: "));
        }
        k.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
        int iK = ((kotlinx.coroutines.selects.b) obj).k(this, rVar);
        if (iK == 0) {
            trySelectDetailedResult = TrySelectDetailedResult.f5255a;
        } else if (iK == 1) {
            trySelectDetailedResult = TrySelectDetailedResult.b;
        } else if (iK == 2) {
            trySelectDetailedResult = TrySelectDetailedResult.c;
        } else {
            if (iK != 3) {
                throw new IllegalStateException(("Unexpected internal result: " + iK).toString());
            }
            trySelectDetailedResult = TrySelectDetailedResult.d;
        }
        if (trySelectDetailedResult == TrySelectDetailedResult.b) {
            c1783i.n(i6, null);
        }
        return trySelectDetailedResult == TrySelectDetailedResult.f5255a;
    }

    public final Object J(C1783i c1783i, int i6, long j5, Object obj) {
        Object objL = c1783i.l(i6);
        AtomicReferenceArray atomicReferenceArray = c1783i.f;
        AtomicLongFieldUpdater atomicLongFieldUpdater = b;
        if (objL == null) {
            if (j5 >= (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    return AbstractC1777c.n;
                }
                if (c1783i.k(i6, objL, obj)) {
                    j();
                    return AbstractC1777c.m;
                }
            }
        } else if (objL == AbstractC1777c.d && c1783i.k(i6, objL, AbstractC1777c.i)) {
            j();
            Object obj2 = atomicReferenceArray.get(i6 * 2);
            c1783i.n(i6, null);
            return obj2;
        }
        while (true) {
            Object objL2 = c1783i.l(i6);
            if (objL2 == null || objL2 == AbstractC1777c.e) {
                if (j5 < (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                    if (c1783i.k(i6, objL2, AbstractC1777c.h)) {
                        j();
                        return AbstractC1777c.o;
                    }
                } else {
                    if (obj == null) {
                        return AbstractC1777c.n;
                    }
                    if (c1783i.k(i6, objL2, obj)) {
                        j();
                        return AbstractC1777c.m;
                    }
                }
            } else {
                if (objL2 != AbstractC1777c.d) {
                    d dVar = AbstractC1777c.f5450j;
                    if (objL2 != dVar && objL2 != AbstractC1777c.h) {
                        if (objL2 == AbstractC1777c.l) {
                            j();
                            return AbstractC1777c.o;
                        }
                        if (objL2 != AbstractC1777c.g && c1783i.k(i6, objL2, AbstractC1777c.f)) {
                            boolean z10 = objL2 instanceof o9.p;
                            if (z10) {
                                objL2 = ((o9.p) objL2).f5459a;
                            }
                            if (I(objL2, c1783i, i6)) {
                                c1783i.o(i6, AbstractC1777c.i);
                                j();
                                Object obj3 = atomicReferenceArray.get(i6 * 2);
                                c1783i.n(i6, null);
                                return obj3;
                            }
                            c1783i.o(i6, dVar);
                            c1783i.i();
                            if (z10) {
                                j();
                            }
                            return AbstractC1777c.o;
                        }
                    }
                    return AbstractC1777c.o;
                }
                if (c1783i.k(i6, objL2, AbstractC1777c.i)) {
                    j();
                    Object obj4 = atomicReferenceArray.get(i6 * 2);
                    c1783i.n(i6, null);
                    return obj4;
                }
            }
        }
    }

    public final int K(C1783i c1783i, int i6, Object obj, long j5, Object obj2, boolean z10) {
        while (true) {
            Object objL = c1783i.l(i6);
            if (objL == null) {
                if (!f(j5) || z10) {
                    if (z10) {
                        if (c1783i.k(i6, null, AbstractC1777c.f5450j)) {
                            c1783i.i();
                            return 4;
                        }
                    } else {
                        if (obj2 == null) {
                            return 3;
                        }
                        if (c1783i.k(i6, null, obj2)) {
                            return 2;
                        }
                    }
                } else if (c1783i.k(i6, null, AbstractC1777c.d)) {
                    break;
                }
            } else {
                if (objL != AbstractC1777c.e) {
                    d dVar = AbstractC1777c.k;
                    if (objL == dVar) {
                        c1783i.n(i6, null);
                        return 5;
                    }
                    if (objL == AbstractC1777c.h) {
                        c1783i.n(i6, null);
                        return 5;
                    }
                    if (objL == AbstractC1777c.l) {
                        c1783i.n(i6, null);
                        z();
                        return 4;
                    }
                    c1783i.n(i6, null);
                    if (objL instanceof o9.p) {
                        objL = ((o9.p) objL).f5459a;
                    }
                    if (H(objL, obj)) {
                        c1783i.o(i6, AbstractC1777c.i);
                        return 0;
                    }
                    if (c1783i.f.getAndSet((i6 * 2) + 1, dVar) != dVar) {
                        c1783i.m(i6, true);
                    }
                    return 5;
                }
                if (c1783i.k(i6, objL, AbstractC1777c.d)) {
                    break;
                }
            }
        }
        return 1;
    }

    public final void L(long j5) {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        a aVar = this;
        if (aVar.B()) {
            return;
        }
        while (true) {
            atomicLongFieldUpdater = d;
            if (atomicLongFieldUpdater.get(aVar) > j5) {
                break;
            } else {
                aVar = this;
            }
        }
        int i6 = AbstractC1777c.c;
        int i10 = 0;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater2 = e;
            if (i10 < i6) {
                long j6 = atomicLongFieldUpdater.get(aVar);
                if (j6 == (4611686018427387903L & atomicLongFieldUpdater2.get(aVar)) && j6 == atomicLongFieldUpdater.get(aVar)) {
                    return;
                } else {
                    i10++;
                }
            } else {
                while (true) {
                    long j10 = atomicLongFieldUpdater2.get(aVar);
                    if (atomicLongFieldUpdater2.compareAndSet(aVar, j10, (j10 & 4611686018427387903L) + SieveCacheKt.NodeVisitedBit)) {
                        break;
                    } else {
                        aVar = this;
                    }
                }
                while (true) {
                    long j11 = atomicLongFieldUpdater.get(aVar);
                    long j12 = atomicLongFieldUpdater2.get(aVar);
                    long j13 = j12 & 4611686018427387903L;
                    boolean z10 = (j12 & SieveCacheKt.NodeVisitedBit) != 0;
                    if (j11 == j13 && j11 == atomicLongFieldUpdater.get(aVar)) {
                        break;
                    }
                    if (z10) {
                        aVar = this;
                    } else {
                        aVar = this;
                        atomicLongFieldUpdater2.compareAndSet(aVar, j12, SieveCacheKt.NodeVisitedBit + j13);
                    }
                }
                while (true) {
                    long j14 = atomicLongFieldUpdater2.get(aVar);
                    if (atomicLongFieldUpdater2.compareAndSet(aVar, j14, j14 & 4611686018427387903L)) {
                        return;
                    } else {
                        aVar = this;
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00be A[SYNTHETIC] */
    @Override // o9.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(java.lang.Object r16) {
        /*
            r15 = this;
            java.util.concurrent.atomic.AtomicLongFieldUpdater r8 = kotlinx.coroutines.channels.a.b
            long r1 = r8.get(r15)
            r9 = 0
            boolean r3 = r15.x(r1, r9)
            r10 = 1
            r11 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            if (r3 == 0) goto L15
            r1 = r9
            goto L1b
        L15:
            long r1 = r1 & r11
            boolean r1 = r15.f(r1)
            r1 = r1 ^ r10
        L1b:
            o9.g r13 = o9.C1782h.b
            if (r1 == 0) goto L20
            return r13
        L20:
            a5.d r6 = o9.AbstractC1777c.f5450j
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = kotlinx.coroutines.channels.a.f
            java.lang.Object r1 = r1.get(r15)
            o9.i r1 = (o9.C1783i) r1
        L2a:
            long r2 = r8.getAndIncrement(r15)
            long r4 = r2 & r11
            boolean r7 = r15.x(r2, r9)
            int r14 = o9.AbstractC1777c.b
            long r2 = (long) r14
            long r11 = r4 / r2
            long r2 = r4 % r2
            int r2 = (int) r2
            long r9 = r1.c
            int r3 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r3 == 0) goto L5d
            o9.i r3 = b(r15, r11, r1)
            if (r3 != 0) goto L5c
            if (r7 == 0) goto L54
            java.lang.Throwable r0 = r15.r()
            o9.f r1 = new o9.f
            r1.<init>(r0)
            return r1
        L54:
            r9 = 0
            r10 = 1
        L56:
            r11 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            goto L2a
        L5c:
            r1 = r3
        L5d:
            r0 = r15
            r3 = r16
            int r9 = e(r0, r1, r2, r3, r4, r6, r7)
            C7.r r3 = C7.r.f317a
            if (r9 == 0) goto Lbe
            r10 = 1
            if (r9 == r10) goto Lbd
            r3 = 2
            if (r9 == r3) goto L9c
            r2 = 3
            if (r9 == r2) goto L94
            r2 = 4
            if (r9 == r2) goto L7d
            r2 = 5
            if (r9 == r2) goto L78
            goto L7b
        L78:
            r1.a()
        L7b:
            r9 = 0
            goto L56
        L7d:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = kotlinx.coroutines.channels.a.c
            long r2 = r2.get(r15)
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 >= 0) goto L8a
            r1.a()
        L8a:
            java.lang.Throwable r0 = r15.r()
            o9.f r1 = new o9.f
            r1.<init>(r0)
            return r1
        L94:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "unexpected"
            r0.<init>(r1)
            throw r0
        L9c:
            if (r7 == 0) goto Lab
            r1.i()
            java.lang.Throwable r0 = r15.r()
            o9.f r1 = new o9.f
            r1.<init>(r0)
            return r1
        Lab:
            boolean r0 = r6 instanceof m9.y0
            if (r0 == 0) goto Lb2
            m9.y0 r6 = (m9.y0) r6
            goto Lb3
        Lb2:
            r6 = 0
        Lb3:
            if (r6 == 0) goto Lb9
            int r2 = r2 + r14
            r6.c(r1, r2)
        Lb9:
            r1.i()
            return r13
        Lbd:
            return r3
        Lbe:
            r1.a()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.a.a(java.lang.Object):java.lang.Object");
    }

    @Override // o9.n
    public final void cancel(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new CancellationException("Channel was cancelled");
        }
        g(cancellationException, true);
    }

    public final boolean f(long j5) {
        return j5 < d.get(this) || j5 < c.get(this) + ((long) this.f5194a);
    }

    public final boolean g(Throwable th, boolean z10) {
        a aVar;
        long j5;
        long j6;
        long j10;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Object obj;
        long j11;
        AtomicLongFieldUpdater atomicLongFieldUpdater = b;
        if (z10) {
            while (true) {
                long j12 = atomicLongFieldUpdater.get(this);
                if (((int) (j12 >> 60)) != 0) {
                    break;
                }
                C1783i c1783i = AbstractC1777c.f5449a;
                aVar = this;
                if (atomicLongFieldUpdater.compareAndSet(aVar, j12, (j12 & 1152921504606846975L) + (1 << 60))) {
                    break;
                }
                this = aVar;
            }
        } else {
            aVar = this;
        }
        boolean zCompareAndSet = i.compareAndSet(aVar, AbstractC1777c.f5453s, th);
        if (z10) {
            do {
                j11 = atomicLongFieldUpdater.get(aVar);
            } while (!atomicLongFieldUpdater.compareAndSet(aVar, j11, (j11 & 1152921504606846975L) + (3 << 60)));
        } else {
            do {
                j5 = atomicLongFieldUpdater.get(aVar);
                int i6 = (int) (j5 >> 60);
                if (i6 == 0) {
                    j6 = j5 & 1152921504606846975L;
                    j10 = 2;
                } else {
                    if (i6 != 1) {
                        break;
                    }
                    j6 = j5 & 1152921504606846975L;
                    j10 = 3;
                }
            } while (!atomicLongFieldUpdater.compareAndSet(aVar, j5, (j10 << 60) + j6));
        }
        aVar.z();
        if (zCompareAndSet) {
            do {
                atomicReferenceFieldUpdater = f5193j;
                obj = atomicReferenceFieldUpdater.get(aVar);
            } while (!atomicReferenceFieldUpdater.compareAndSet(aVar, obj, obj == null ? AbstractC1777c.f5451q : AbstractC1777c.f5452r));
            if (obj != null) {
                kotlin.jvm.internal.p.e(1, obj);
                ((S7.k) obj).invoke(aVar.l());
            }
        }
        return zCompareAndSet;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x008d, code lost:
    
        r1 = (o9.C1783i) ((s9.AbstractC1922b) s9.AbstractC1922b.b.get(r1));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final o9.C1783i h(long r13) {
        /*
            Method dump skipped, instructions count: 298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.a.h(long):o9.i");
    }

    public final void i(long j5) {
        C1783i c1783i = (C1783i) g.get(this);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = c;
            long j6 = atomicLongFieldUpdater.get(this);
            if (j5 < Math.max(this.f5194a + j6, d.get(this))) {
                return;
            }
            a aVar = this;
            if (atomicLongFieldUpdater.compareAndSet(aVar, j6, 1 + j6)) {
                long j10 = AbstractC1777c.b;
                long j11 = j6 / j10;
                int i6 = (int) (j6 % j10);
                if (c1783i.c != j11) {
                    C1783i c1783iK = aVar.k(j11, c1783i);
                    if (c1783iK != null) {
                        c1783i = c1783iK;
                    }
                }
                C1783i c1783i2 = c1783i;
                if (aVar.J(c1783i2, i6, j6, null) != AbstractC1777c.o || j6 < aVar.v()) {
                    c1783i2.a();
                }
                this = aVar;
                c1783i = c1783i2;
            }
            this = aVar;
        }
    }

    @Override // o9.n
    public final C1776b iterator() {
        return new C1776b(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x017b, code lost:
    
        w(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x017e, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j() {
        /*
            Method dump skipped, instructions count: 383
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.a.j():void");
    }

    public final C1783i k(long j5, C1783i c1783i) {
        Object objB;
        a aVar;
        C1783i c1783i2 = AbstractC1777c.f5449a;
        BufferedChannelKt$createSegmentFunction$1 bufferedChannelKt$createSegmentFunction$1 = BufferedChannelKt$createSegmentFunction$1.f5191a;
        loop0: while (true) {
            objB = AbstractC1921a.b(c1783i, j5, bufferedChannelKt$createSegmentFunction$1);
            if (!AbstractC1921a.e(objB)) {
                p pVarC = AbstractC1921a.c(objB);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = g;
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
        if (AbstractC1921a.e(objB)) {
            z();
            if (c1783i.c * AbstractC1777c.b < v()) {
                c1783i.a();
                return null;
            }
        } else {
            C1783i c1783i3 = (C1783i) AbstractC1921a.c(objB);
            long j6 = c1783i3.c;
            if (!B() && j5 <= d.get(this) / AbstractC1777c.b) {
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = h;
                    p pVar2 = (p) atomicReferenceFieldUpdater2.get(this);
                    if (pVar2.c >= j6 || !c1783i3.j()) {
                        break;
                    }
                    if (atomicReferenceFieldUpdater2.compareAndSet(this, pVar2, c1783i3)) {
                        if (pVar2.f()) {
                            pVar2.e();
                        }
                    } else if (c1783i3.f()) {
                        c1783i3.e();
                    }
                }
            }
            if (j6 <= j5) {
                return c1783i3;
            }
            long j10 = j6 * AbstractC1777c.b;
            while (true) {
                long j11 = c.get(this);
                if (j11 >= j10) {
                    aVar = this;
                    break;
                }
                aVar = this;
                if (c.compareAndSet(aVar, j11, j10)) {
                    break;
                }
                this = aVar;
            }
            if (j6 * AbstractC1777c.b < aVar.v()) {
                c1783i3.a();
            }
        }
        return null;
    }

    public final Throwable l() {
        return (Throwable) i.get(this);
    }

    @Override // o9.n
    public final u1.d m() {
        BufferedChannel$onReceive$1 bufferedChannel$onReceive$1 = BufferedChannel$onReceive$1.f5185a;
        k.d(bufferedChannel$onReceive$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        kotlin.jvm.internal.p.e(3, bufferedChannel$onReceive$1);
        BufferedChannel$onReceive$2 bufferedChannel$onReceive$2 = BufferedChannel$onReceive$2.f5186a;
        k.d(bufferedChannel$onReceive$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        kotlin.jvm.internal.p.e(3, bufferedChannel$onReceive$2);
        return new u1.d(this, bufferedChannel$onReceive$1, bufferedChannel$onReceive$2, null, 21);
    }

    public final Throwable n() {
        Throwable thL = l();
        return thL == null ? new ClosedReceiveChannelException("Channel was closed") : thL;
    }

    @Override // o9.n
    public final u1.d o() {
        BufferedChannel$onReceiveCatching$1 bufferedChannel$onReceiveCatching$1 = BufferedChannel$onReceiveCatching$1.f5187a;
        k.d(bufferedChannel$onReceiveCatching$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        kotlin.jvm.internal.p.e(3, bufferedChannel$onReceiveCatching$1);
        BufferedChannel$onReceiveCatching$2 bufferedChannel$onReceiveCatching$2 = BufferedChannel$onReceiveCatching$2.f5188a;
        k.d(bufferedChannel$onReceiveCatching$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        kotlin.jvm.internal.p.e(3, bufferedChannel$onReceiveCatching$2);
        return new u1.d(this, bufferedChannel$onReceiveCatching$1, bufferedChannel$onReceiveCatching$2, null, 21);
    }

    /* JADX WARN: Removed duplicated region for block: B:85:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x014f A[RETURN] */
    @Override // o9.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object p(H7.c r23, java.lang.Object r24) {
        /*
            Method dump skipped, instructions count: 361
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.a.p(H7.c, java.lang.Object):java.lang.Object");
    }

    @Override // o9.n
    public final Object q() {
        C1783i c1783i;
        AtomicLongFieldUpdater atomicLongFieldUpdater = c;
        long j5 = atomicLongFieldUpdater.get(this);
        long j6 = b.get(this);
        if (x(j6, true)) {
            return new C1780f(l());
        }
        long j10 = j6 & 1152921504606846975L;
        C1781g c1781g = C1782h.b;
        if (j5 >= j10) {
            return c1781g;
        }
        Object obj = AbstractC1777c.k;
        C1783i c1783i2 = (C1783i) g.get(this);
        while (!this.y()) {
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(this);
            long j11 = AbstractC1777c.b;
            long j12 = andIncrement / j11;
            int i6 = (int) (andIncrement % j11);
            if (c1783i2.c != j12) {
                C1783i c1783iK = this.k(j12, c1783i2);
                if (c1783iK == null) {
                    continue;
                } else {
                    c1783i = c1783iK;
                }
            } else {
                c1783i = c1783i2;
            }
            a aVar = this;
            Object objJ = aVar.J(c1783i, i6, andIncrement, obj);
            c1783i2 = c1783i;
            if (objJ == AbstractC1777c.m) {
                y0 y0Var = obj instanceof y0 ? (y0) obj : null;
                if (y0Var != null) {
                    y0Var.c(c1783i2, i6);
                }
                aVar.L(andIncrement);
                c1783i2.i();
                return c1781g;
            }
            if (objJ != AbstractC1777c.o) {
                if (objJ == AbstractC1777c.n) {
                    throw new IllegalStateException("unexpected");
                }
                c1783i2.a();
                return objJ;
            }
            if (andIncrement < aVar.v()) {
                c1783i2.a();
            }
            this = aVar;
        }
        return new C1780f(this.l());
    }

    public final Throwable r() {
        Throwable thL = l();
        return thL == null ? new ClosedSendChannelException("Channel was closed") : thL;
    }

    @Override // o9.o
    public final boolean s(Throwable th) {
        return g(th, false);
    }

    @Override // o9.n
    public final Object t(c cVar) {
        return E(this, (ContinuationImpl) cVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:83:0x01b0, code lost:
    
        r3 = (o9.C1783i) r3.c();
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01b7, code lost:
    
        if (r3 != null) goto L90;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String toString() {
        /*
            Method dump skipped, instructions count: 480
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.a.toString():java.lang.String");
    }

    @Override // o9.n
    public final Object u(SuspendLambda suspendLambda) throws Throwable {
        C1783i c1783i;
        Throwable th;
        C1783i c1783i2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = g;
        C1783i c1783i3 = (C1783i) atomicReferenceFieldUpdater.get(this);
        while (!this.y()) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = c;
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(this);
            long j5 = AbstractC1777c.b;
            long j6 = andIncrement / j5;
            int i6 = (int) (andIncrement % j5);
            if (c1783i3.c != j6) {
                C1783i c1783iK = this.k(j6, c1783i3);
                if (c1783iK == null) {
                    continue;
                } else {
                    c1783i = c1783iK;
                }
            } else {
                c1783i = c1783i3;
            }
            a aVar = this;
            Object objJ = aVar.J(c1783i, i6, andIncrement, null);
            d dVar = AbstractC1777c.m;
            if (objJ == dVar) {
                throw new IllegalStateException("unexpected");
            }
            d dVar2 = AbstractC1777c.o;
            if (objJ == dVar2) {
                if (andIncrement < aVar.v()) {
                    c1783i.a();
                }
                this = aVar;
                c1783i3 = c1783i;
            } else {
                if (objJ != AbstractC1777c.n) {
                    c1783i.a();
                    return objJ;
                }
                C1718k c1718kJ = AbstractC1683A.j(U7.a.I(suspendLambda));
                try {
                    Object objJ2 = aVar.J(c1783i, i6, andIncrement, c1718kJ);
                    if (objJ2 == dVar) {
                        c1718kJ.c(c1783i, i6);
                    } else {
                        if (objJ2 == dVar2) {
                            if (andIncrement < aVar.v()) {
                                c1783i.a();
                            }
                            C1783i c1783i4 = (C1783i) atomicReferenceFieldUpdater.get(aVar);
                            while (true) {
                                if (aVar.y()) {
                                    c1718kJ.resumeWith(kotlin.b.a(aVar.n()));
                                    break;
                                }
                                C1718k c1718k = c1718kJ;
                                try {
                                    long andIncrement2 = atomicLongFieldUpdater.getAndIncrement(aVar);
                                    long j10 = AbstractC1777c.b;
                                    long j11 = andIncrement2 / j10;
                                    int i10 = (int) (andIncrement2 % j10);
                                    if (c1783i4.c != j11) {
                                        try {
                                            C1783i c1783iK2 = aVar.k(j11, c1783i4);
                                            if (c1783iK2 == null) {
                                                c1718kJ = c1718k;
                                            } else {
                                                c1783i2 = c1783iK2;
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            c1718kJ = c1718k;
                                            c1718kJ.E();
                                            throw th;
                                        }
                                    } else {
                                        c1783i2 = c1783i4;
                                    }
                                    a aVar2 = aVar;
                                    objJ2 = aVar2.J(c1783i2, i10, andIncrement2, c1718k);
                                    aVar = aVar2;
                                    C1783i c1783i5 = c1783i2;
                                    c1718kJ = c1718k;
                                    if (objJ2 == AbstractC1777c.m) {
                                        c1718kJ.c(c1783i5, i10);
                                        break;
                                    }
                                    if (objJ2 == AbstractC1777c.o) {
                                        if (andIncrement2 < aVar.v()) {
                                            c1783i5.a();
                                        }
                                        c1783i4 = c1783i5;
                                    } else {
                                        if (objJ2 == AbstractC1777c.n) {
                                            throw new IllegalStateException("unexpected");
                                        }
                                        c1783i5.a();
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    c1718kJ = c1718k;
                                    th = th;
                                    c1718kJ.E();
                                    throw th;
                                }
                            }
                        } else {
                            c1783i.a();
                        }
                        c1718kJ.d(objJ2, null);
                    }
                    Object objX = c1718kJ.x();
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                    return objX;
                } catch (Throwable th4) {
                    th = th4;
                }
            }
        }
        Throwable thN = this.n();
        int i11 = q.f6006a;
        throw thN;
    }

    public final long v() {
        return b.get(this) & 1152921504606846975L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x00a2, code lost:
    
        r0 = (o9.C1783i) ((s9.AbstractC1922b) s9.AbstractC1922b.b.get(r0));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean x(long r14, boolean r16) {
        /*
            Method dump skipped, instructions count: 368
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.a.x(long, boolean):boolean");
    }

    public final boolean y() {
        return x(b.get(this), true);
    }

    public final boolean z() {
        return x(b.get(this), false);
    }
}

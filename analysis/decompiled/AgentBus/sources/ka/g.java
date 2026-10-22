package ka;

import ia.d0;
import ia.g2;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import w7.e0;

/* loaded from: classes.dex */
public class g implements k {

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f5677g = AtomicLongFieldUpdater.newUpdater(g.class, "sendersAndCloseStatus$volatile");

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f5678h = AtomicLongFieldUpdater.newUpdater(g.class, "receivers$volatile");

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f5679i = AtomicLongFieldUpdater.newUpdater(g.class, "bufferEnd$volatile");

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f5680j = AtomicLongFieldUpdater.newUpdater(g.class, "completedExpandBuffersAndPauseFlag$volatile");

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f5681k = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "sendSegment$volatile");

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f5682l = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "receiveSegment$volatile");

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f5683m = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "bufferEndSegment$volatile");

    /* renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f5684n = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "_closeCause$volatile");

    /* renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f5685o = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "closeHandler$volatile");
    private volatile /* synthetic */ Object _closeCause$volatile;
    private volatile /* synthetic */ long bufferEnd$volatile;
    private volatile /* synthetic */ Object bufferEndSegment$volatile;
    private volatile /* synthetic */ Object closeHandler$volatile;
    private volatile /* synthetic */ long completedExpandBuffersAndPauseFlag$volatile;

    /* renamed from: f, reason: collision with root package name */
    public final int f5686f;
    private volatile /* synthetic */ Object receiveSegment$volatile;
    private volatile /* synthetic */ long receivers$volatile;
    private volatile /* synthetic */ Object sendSegment$volatile;
    private volatile /* synthetic */ long sendersAndCloseStatus$volatile;

    public g(int i2) {
        this.f5686f = i2;
        if (i2 < 0) {
            throw new IllegalArgumentException(a1.a.f(i2, "Invalid channel capacity: ", ", should be >=0").toString());
        }
        o oVar = i.f5688a;
        this.bufferEnd$volatile = i2 != 0 ? i2 != Integer.MAX_VALUE ? i2 : Long.MAX_VALUE : 0L;
        this.completedExpandBuffersAndPauseFlag$volatile = f5679i.get(this);
        o oVar2 = new o(0L, null, this, 3);
        this.sendSegment$volatile = oVar2;
        this.receiveSegment$volatile = oVar2;
        if (A()) {
            oVar2 = i.f5688a;
            q7.k.c(oVar2, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
        }
        this.bufferEndSegment$volatile = oVar2;
        this._closeCause$volatile = i.f5706s;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object D(ka.g r13, i7.c r14) throws ia.k0 {
        /*
            boolean r0 = r14 instanceof ka.e
            if (r0 == 0) goto L14
            r0 = r14
            ka.e r0 = (ka.e) r0
            int r1 = r0.f5673h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f5673h = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            ka.e r0 = new ka.e
            r0.<init>(r13, r14)
            goto L12
        L1a:
            java.lang.Object r14 = r6.f5671f
            h7.a r0 = h7.a.f4212f
            int r1 = r6.f5673h
            r2 = 1
            if (r1 == 0) goto L35
            if (r1 != r2) goto L2d
            w7.e0.N(r14)
            ka.n r14 = (ka.n) r14
            java.lang.Object r13 = r14.f5712a
            return r13
        L2d:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L35:
            w7.e0.N(r14)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r14 = ka.g.f5682l
            java.lang.Object r14 = r14.get(r13)
            ka.o r14 = (ka.o) r14
        L40:
            boolean r1 = r13.x()
            if (r1 == 0) goto L50
            java.lang.Throwable r13 = r13.o()
            ka.l r14 = new ka.l
            r14.<init>(r13)
            return r14
        L50:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = ka.g.f5678h
            long r4 = r1.getAndIncrement(r13)
            int r1 = ka.i.f5689b
            long r7 = (long) r1
            long r9 = r4 / r7
            long r7 = r4 % r7
            int r3 = (int) r7
            long r7 = r14.f6927c
            int r1 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r1 == 0) goto L6d
            ka.o r1 = r13.n(r9, r14)
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
            java.lang.Object r13 = r7.I(r8, r9, r10, r12)
            r1 = r7
            f8.x r14 = ka.i.f5700m
            if (r13 == r14) goto La0
            f8.x r14 = ka.i.f5702o
            if (r13 != r14) goto L8d
            long r13 = r1.s()
            int r13 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r13 >= 0) goto L8a
            r8.b()
        L8a:
            r13 = r1
            r14 = r8
            goto L40
        L8d:
            f8.x r14 = ka.i.f5701n
            if (r13 != r14) goto L9c
            r6.f5673h = r2
            r2 = r8
            java.lang.Object r13 = r1.E(r2, r3, r4, r6)
            if (r13 != r0) goto L9b
            return r0
        L9b:
            return r13
        L9c:
            r8.b()
            return r13
        La0:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "unexpected"
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: ka.g.D(ka.g, i7.c):java.lang.Object");
    }

    public static boolean H(Object obj) {
        if (obj instanceof ia.k) {
            return i.a((ia.k) obj, c7.r.f1986a, null);
        }
        throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
    }

    public static final o b(g gVar, long j2, o oVar) {
        Object objB;
        g gVar2;
        o oVar2 = i.f5688a;
        h hVar = h.f5687n;
        loop0: while (true) {
            objB = na.b.b(oVar, j2, hVar);
            if (!na.b.e(objB)) {
                na.s sVarC = na.b.c(objB);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f5681k;
                    na.s sVar = (na.s) atomicReferenceFieldUpdater.get(gVar);
                    if (sVar.f6927c >= sVarC.f6927c) {
                        break loop0;
                    }
                    if (!sVarC.j()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(gVar, sVar, sVarC)) {
                        if (atomicReferenceFieldUpdater.get(gVar) != sVar) {
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
        boolean zE = na.b.e(objB);
        AtomicLongFieldUpdater atomicLongFieldUpdater = f5678h;
        if (zE) {
            gVar.y();
            if (oVar.f6927c * i.f5689b < atomicLongFieldUpdater.get(gVar)) {
                oVar.b();
                return null;
            }
        } else {
            o oVar3 = (o) na.b.c(objB);
            long j4 = oVar3.f6927c;
            if (j4 <= j2) {
                return oVar3;
            }
            long j10 = i.f5689b * j4;
            while (true) {
                long j11 = f5677g.get(gVar);
                long j12 = 1152921504606846975L & j11;
                if (j12 >= j10) {
                    gVar2 = gVar;
                    break;
                }
                gVar2 = gVar;
                if (f5677g.compareAndSet(gVar2, j11, (((int) (j11 >> 60)) << 60) + j12)) {
                    break;
                }
                gVar = gVar2;
            }
            if (j4 * i.f5689b < atomicLongFieldUpdater.get(gVar2)) {
                oVar3.b();
            }
        }
        return null;
    }

    public static final void e(g gVar, Object obj, ia.m mVar) {
        mVar.resumeWith(e0.n(gVar.r()));
    }

    public static final int f(g gVar, o oVar, int i2, Object obj, long j2, Object obj2, boolean z4) {
        oVar.n(i2, obj);
        if (z4) {
            return gVar.J(oVar, i2, obj, j2, obj2, z4);
        }
        Object objL = oVar.l(i2);
        if (objL == null) {
            if (gVar.g(j2)) {
                if (oVar.k(i2, null, i.f5691d)) {
                    return 1;
                }
            } else {
                if (obj2 == null) {
                    return 3;
                }
                if (oVar.k(i2, null, obj2)) {
                    return 2;
                }
            }
        } else if (objL instanceof g2) {
            oVar.n(i2, null);
            if (gVar.G(objL, obj)) {
                oVar.o(i2, i.f5696i);
                return 0;
            }
            f8.x xVar = i.f5698k;
            if (oVar.f5714f.getAndSet((i2 * 2) + 1, xVar) == xVar) {
                return 5;
            }
            oVar.m(i2, true);
            return 5;
        }
        return gVar.J(oVar, i2, obj, j2, obj2, z4);
    }

    public static void t(g gVar) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f5680j;
        if ((atomicLongFieldUpdater.addAndGet(gVar, 1L) & 4611686018427387904L) != 0) {
            while ((atomicLongFieldUpdater.get(gVar) & 4611686018427387904L) != 0) {
            }
        }
    }

    public final boolean A() {
        long j2 = f5679i.get(this);
        return j2 == 0 || j2 == Long.MAX_VALUE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0011, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void B(long r5, ka.o r7) {
        /*
            r4 = this;
        L0:
            long r0 = r7.f6927c
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 >= 0) goto L11
            na.c r0 = r7.c()
            ka.o r0 = (ka.o) r0
            if (r0 != 0) goto Lf
            goto L11
        Lf:
            r7 = r0
            goto L0
        L11:
            boolean r5 = r7.d()
            if (r5 == 0) goto L22
            na.c r5 = r7.c()
            ka.o r5 = (ka.o) r5
            if (r5 != 0) goto L20
            goto L22
        L20:
            r7 = r5
            goto L11
        L22:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = ka.g.f5683m
            java.lang.Object r6 = r5.get(r4)
            na.s r6 = (na.s) r6
            long r0 = r6.f6927c
            long r2 = r7.f6927c
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 < 0) goto L33
            goto L49
        L33:
            boolean r0 = r7.j()
            if (r0 != 0) goto L3a
            goto L11
        L3a:
            boolean r0 = r5.compareAndSet(r4, r6, r7)
            if (r0 == 0) goto L4a
            boolean r4 = r6.f()
            if (r4 == 0) goto L49
            r6.e()
        L49:
            return
        L4a:
            java.lang.Object r0 = r5.get(r4)
            if (r0 == r6) goto L3a
            boolean r5 = r7.f()
            if (r5 == 0) goto L22
            r7.e()
            goto L22
        */
        throw new UnsupportedOperationException("Method not decompiled: ka.g.B(long, ka.o):void");
    }

    public final Object C(g7.d dVar, Object obj) {
        ia.m mVar = new ia.m(1, ib.k.C(dVar));
        mVar.s();
        mVar.resumeWith(e0.n(r()));
        Object objR = mVar.r();
        return objR == h7.a.f4212f ? objR : c7.r.f1986a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object E(ka.o r9, int r10, long r11, i7.c r13) throws ia.k0 {
        /*
            Method dump skipped, instructions count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ka.g.E(ka.o, int, long, i7.c):java.lang.Object");
    }

    public final void F(g2 g2Var, boolean z4) {
        if (g2Var instanceof ia.k) {
            ((g7.d) g2Var).resumeWith(e0.n(z4 ? q() : r()));
            return;
        }
        if (g2Var instanceof u) {
            ((u) g2Var).f5720f.resumeWith(new n(new l(o())));
            return;
        }
        if (!(g2Var instanceof b)) {
            throw new IllegalStateException(("Unexpected waiter: " + g2Var).toString());
        }
        b bVar = (b) g2Var;
        ia.m mVar = bVar.f5667g;
        q7.k.b(mVar);
        bVar.f5667g = null;
        bVar.f5666f = i.f5699l;
        Throwable thO = bVar.f5668h.o();
        if (thO == null) {
            mVar.resumeWith(Boolean.FALSE);
        } else {
            mVar.resumeWith(e0.n(thO));
        }
    }

    public final boolean G(Object obj, Object obj2) {
        if (obj instanceof u) {
            return i.a(((u) obj).f5720f, new n(obj2), null);
        }
        if (!(obj instanceof b)) {
            if (obj instanceof ia.k) {
                return i.a((ia.k) obj, obj2, null);
            }
            throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
        }
        b bVar = (b) obj;
        ia.m mVar = bVar.f5667g;
        q7.k.b(mVar);
        bVar.f5667g = null;
        bVar.f5666f = obj2;
        Boolean bool = Boolean.TRUE;
        bVar.f5668h.getClass();
        return i.a(mVar, bool, null);
    }

    public final Object I(o oVar, int i2, long j2, Object obj) {
        Object objL = oVar.l(i2);
        AtomicReferenceArray atomicReferenceArray = oVar.f5714f;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f5677g;
        if (objL == null) {
            if (j2 >= (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    return i.f5701n;
                }
                if (oVar.k(i2, objL, obj)) {
                    m();
                    return i.f5700m;
                }
            }
        } else if (objL == i.f5691d && oVar.k(i2, objL, i.f5696i)) {
            m();
            Object obj2 = atomicReferenceArray.get(i2 * 2);
            oVar.n(i2, null);
            return obj2;
        }
        while (true) {
            Object objL2 = oVar.l(i2);
            if (objL2 == null || objL2 == i.f5692e) {
                if (j2 < (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                    if (oVar.k(i2, objL2, i.f5695h)) {
                        m();
                        return i.f5702o;
                    }
                } else {
                    if (obj == null) {
                        return i.f5701n;
                    }
                    if (oVar.k(i2, objL2, obj)) {
                        m();
                        return i.f5700m;
                    }
                }
            } else {
                if (objL2 != i.f5691d) {
                    f8.x xVar = i.f5697j;
                    if (objL2 != xVar && objL2 != i.f5695h) {
                        if (objL2 == i.f5699l) {
                            m();
                            return i.f5702o;
                        }
                        if (objL2 != i.f5694g && oVar.k(i2, objL2, i.f5693f)) {
                            boolean z4 = objL2 instanceof a0;
                            if (z4) {
                                objL2 = ((a0) objL2).f5665a;
                            }
                            if (H(objL2)) {
                                oVar.o(i2, i.f5696i);
                                m();
                                Object obj3 = atomicReferenceArray.get(i2 * 2);
                                oVar.n(i2, null);
                                return obj3;
                            }
                            oVar.o(i2, xVar);
                            oVar.i();
                            if (z4) {
                                m();
                            }
                            return i.f5702o;
                        }
                    }
                    return i.f5702o;
                }
                if (oVar.k(i2, objL2, i.f5696i)) {
                    m();
                    Object obj4 = atomicReferenceArray.get(i2 * 2);
                    oVar.n(i2, null);
                    return obj4;
                }
            }
        }
    }

    public final int J(o oVar, int i2, Object obj, long j2, Object obj2, boolean z4) {
        while (true) {
            Object objL = oVar.l(i2);
            if (objL == null) {
                if (!g(j2) || z4) {
                    if (z4) {
                        if (oVar.k(i2, null, i.f5697j)) {
                            oVar.i();
                            return 4;
                        }
                    } else {
                        if (obj2 == null) {
                            return 3;
                        }
                        if (oVar.k(i2, null, obj2)) {
                            return 2;
                        }
                    }
                } else if (oVar.k(i2, null, i.f5691d)) {
                    break;
                }
            } else {
                if (objL != i.f5692e) {
                    f8.x xVar = i.f5698k;
                    if (objL == xVar) {
                        oVar.n(i2, null);
                        return 5;
                    }
                    if (objL == i.f5695h) {
                        oVar.n(i2, null);
                        return 5;
                    }
                    if (objL == i.f5699l) {
                        oVar.n(i2, null);
                        y();
                        return 4;
                    }
                    oVar.n(i2, null);
                    if (objL instanceof a0) {
                        objL = ((a0) objL).f5665a;
                    }
                    if (G(objL, obj)) {
                        oVar.o(i2, i.f5696i);
                        return 0;
                    }
                    if (oVar.f5714f.getAndSet((i2 * 2) + 1, xVar) != xVar) {
                        oVar.m(i2, true);
                    }
                    return 5;
                }
                if (oVar.k(i2, objL, i.f5691d)) {
                    break;
                }
            }
        }
        return 1;
    }

    public final void K(long j2) {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        g gVar = this;
        if (gVar.A()) {
            return;
        }
        while (true) {
            atomicLongFieldUpdater = f5679i;
            if (atomicLongFieldUpdater.get(gVar) > j2) {
                break;
            } else {
                gVar = this;
            }
        }
        int i2 = i.f5690c;
        int i10 = 0;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater2 = f5680j;
            if (i10 < i2) {
                long j4 = atomicLongFieldUpdater.get(gVar);
                if (j4 == (4611686018427387903L & atomicLongFieldUpdater2.get(gVar)) && j4 == atomicLongFieldUpdater.get(gVar)) {
                    return;
                } else {
                    i10++;
                }
            } else {
                while (true) {
                    long j10 = atomicLongFieldUpdater2.get(gVar);
                    if (atomicLongFieldUpdater2.compareAndSet(gVar, j10, (j10 & 4611686018427387903L) + 4611686018427387904L)) {
                        break;
                    } else {
                        gVar = this;
                    }
                }
                while (true) {
                    long j11 = atomicLongFieldUpdater.get(gVar);
                    long j12 = atomicLongFieldUpdater2.get(gVar);
                    long j13 = j12 & 4611686018427387903L;
                    boolean z4 = (j12 & 4611686018427387904L) != 0;
                    if (j11 == j13 && j11 == atomicLongFieldUpdater.get(gVar)) {
                        break;
                    }
                    if (z4) {
                        gVar = this;
                    } else {
                        gVar = this;
                        atomicLongFieldUpdater2.compareAndSet(gVar, j12, 4611686018427387904L + j13);
                    }
                }
                while (true) {
                    long j14 = atomicLongFieldUpdater2.get(gVar);
                    if (atomicLongFieldUpdater2.compareAndSet(gVar, j14, j14 & 4611686018427387903L)) {
                        return;
                    } else {
                        gVar = this;
                    }
                }
            }
        }
    }

    @Override // ka.x
    public final boolean a(Throwable th) {
        if (th == null) {
            th = new CancellationException("Channel was cancelled");
        }
        return h(th, true);
    }

    @Override // ka.x
    public final Object c(g7.d dVar) throws Throwable {
        o oVar;
        Throwable th;
        o oVar2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f5682l;
        o oVar3 = (o) atomicReferenceFieldUpdater.get(this);
        while (!this.x()) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f5678h;
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(this);
            long j2 = i.f5689b;
            long j4 = andIncrement / j2;
            int i2 = (int) (andIncrement % j2);
            if (oVar3.f6927c != j4) {
                o oVarN = this.n(j4, oVar3);
                if (oVarN == null) {
                    continue;
                } else {
                    oVar = oVarN;
                }
            } else {
                oVar = oVar3;
            }
            g gVar = this;
            Object objI = gVar.I(oVar, i2, andIncrement, null);
            f8.x xVar = i.f5700m;
            if (objI == xVar) {
                throw new IllegalStateException("unexpected");
            }
            f8.x xVar2 = i.f5702o;
            if (objI == xVar2) {
                if (andIncrement < gVar.s()) {
                    oVar.b();
                }
                this = gVar;
                oVar3 = oVar;
            } else {
                if (objI != i.f5701n) {
                    oVar.b();
                    return objI;
                }
                ia.m mVarM = d0.m(ib.k.C(dVar));
                try {
                    Object objI2 = gVar.I(oVar, i2, andIncrement, mVarM);
                    if (objI2 == xVar) {
                        mVarM.b(oVar, i2);
                    } else {
                        if (objI2 == xVar2) {
                            if (andIncrement < gVar.s()) {
                                oVar.b();
                            }
                            o oVar4 = (o) atomicReferenceFieldUpdater.get(gVar);
                            while (true) {
                                if (gVar.x()) {
                                    mVarM.resumeWith(e0.n(gVar.q()));
                                    break;
                                }
                                ia.m mVar = mVarM;
                                try {
                                    long andIncrement2 = atomicLongFieldUpdater.getAndIncrement(gVar);
                                    long j10 = i.f5689b;
                                    long j11 = andIncrement2 / j10;
                                    int i10 = (int) (andIncrement2 % j10);
                                    if (oVar4.f6927c != j11) {
                                        try {
                                            o oVarN2 = gVar.n(j11, oVar4);
                                            if (oVarN2 == null) {
                                                mVarM = mVar;
                                            } else {
                                                oVar2 = oVarN2;
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            mVarM = mVar;
                                            mVarM.B();
                                            throw th;
                                        }
                                    } else {
                                        oVar2 = oVar4;
                                    }
                                    g gVar2 = gVar;
                                    objI2 = gVar2.I(oVar2, i10, andIncrement2, mVar);
                                    gVar = gVar2;
                                    o oVar5 = oVar2;
                                    mVarM = mVar;
                                    if (objI2 == i.f5700m) {
                                        mVarM.b(oVar5, i10);
                                        break;
                                    }
                                    if (objI2 == i.f5702o) {
                                        if (andIncrement2 < gVar.s()) {
                                            oVar5.b();
                                        }
                                        oVar4 = oVar5;
                                    } else {
                                        if (objI2 == i.f5701n) {
                                            throw new IllegalStateException("unexpected");
                                        }
                                        oVar5.b();
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    mVarM = mVar;
                                    th = th;
                                    mVarM.B();
                                    throw th;
                                }
                            }
                        } else {
                            oVar.b();
                        }
                        mVarM.m(objI2, null);
                    }
                    Object objR = mVarM.r();
                    h7.a aVar = h7.a.f4212f;
                    return objR;
                } catch (Throwable th4) {
                    th = th4;
                }
            }
        }
        Throwable thQ = this.q();
        int i11 = na.t.f6928a;
        throw thQ;
    }

    @Override // ka.x
    public final void d(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new CancellationException("Channel was cancelled");
        }
        h(cancellationException, true);
    }

    public final boolean g(long j2) {
        return j2 < f5679i.get(this) || j2 < f5678h.get(this) + ((long) this.f5686f);
    }

    public final boolean h(Throwable th, boolean z4) {
        g gVar;
        boolean z10;
        long j2;
        long j4;
        long j10;
        Object obj;
        long j11;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f5677g;
        if (z4) {
            while (true) {
                long j12 = atomicLongFieldUpdater.get(this);
                if (((int) (j12 >> 60)) != 0) {
                    break;
                }
                o oVar = i.f5688a;
                gVar = this;
                if (atomicLongFieldUpdater.compareAndSet(gVar, j12, (j12 & 1152921504606846975L) + (1 << 60))) {
                    break;
                }
                this = gVar;
            }
        } else {
            gVar = this;
        }
        f8.x xVar = i.f5706s;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f5684n;
            if (atomicReferenceFieldUpdater.compareAndSet(gVar, xVar, th)) {
                z10 = true;
                break;
            }
            if (atomicReferenceFieldUpdater.get(gVar) != xVar) {
                z10 = false;
                break;
            }
        }
        if (z4) {
            do {
                j11 = atomicLongFieldUpdater.get(gVar);
            } while (!atomicLongFieldUpdater.compareAndSet(gVar, j11, (3 << 60) + (j11 & 1152921504606846975L)));
        } else {
            do {
                j2 = atomicLongFieldUpdater.get(gVar);
                int i2 = (int) (j2 >> 60);
                if (i2 == 0) {
                    j4 = j2 & 1152921504606846975L;
                    j10 = 2;
                } else {
                    if (i2 != 1) {
                        break;
                    }
                    j4 = j2 & 1152921504606846975L;
                    j10 = 3;
                }
            } while (!atomicLongFieldUpdater.compareAndSet(gVar, j2, (j10 << 60) + j4));
        }
        gVar.y();
        if (z10) {
            loop3: while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f5685o;
                obj = atomicReferenceFieldUpdater2.get(gVar);
                f8.x xVar2 = obj == null ? i.f5704q : i.f5705r;
                while (!atomicReferenceFieldUpdater2.compareAndSet(gVar, obj, xVar2)) {
                    if (atomicReferenceFieldUpdater2.get(gVar) != obj) {
                        break;
                    }
                }
            }
            if (obj != null) {
                q7.z.c(1, obj);
                ((p7.k) obj).invoke(gVar.o());
                return z10;
            }
        }
        return z10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x008d, code lost:
    
        r1 = (ka.o) ((na.c) na.c.f6895b.get(r1));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final ka.o i(long r13) {
        /*
            Method dump skipped, instructions count: 306
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ka.g.i(long):ka.o");
    }

    @Override // ka.x
    public final b iterator() {
        return new b(this);
    }

    @Override // ka.z
    public final boolean j(Throwable th) {
        return h(th, false);
    }

    public final void k(long j2) {
        o oVar = (o) f5682l.get(this);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f5678h;
            long j4 = atomicLongFieldUpdater.get(this);
            if (j2 < Math.max(this.f5686f + j4, f5679i.get(this))) {
                return;
            }
            g gVar = this;
            if (atomicLongFieldUpdater.compareAndSet(gVar, j4, 1 + j4)) {
                long j10 = i.f5689b;
                long j11 = j4 / j10;
                int i2 = (int) (j4 % j10);
                if (oVar.f6927c != j11) {
                    o oVarN = gVar.n(j11, oVar);
                    if (oVarN != null) {
                        oVar = oVarN;
                    }
                }
                o oVar2 = oVar;
                if (gVar.I(oVar2, i2, j4, null) != i.f5702o || j4 < gVar.s()) {
                    oVar2.b();
                }
                this = gVar;
                oVar = oVar2;
            }
            this = gVar;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:85:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x014f A[RETURN] */
    @Override // ka.z
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object l(g7.d r23, java.lang.Object r24) throws ia.k0 {
        /*
            Method dump skipped, instructions count: 361
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ka.g.l(g7.d, java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x018e, code lost:
    
        t(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0191, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m() {
        /*
            Method dump skipped, instructions count: 402
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ka.g.m():void");
    }

    public final o n(long j2, o oVar) {
        Object objB;
        g gVar;
        o oVar2 = i.f5688a;
        h hVar = h.f5687n;
        loop0: while (true) {
            objB = na.b.b(oVar, j2, hVar);
            if (!na.b.e(objB)) {
                na.s sVarC = na.b.c(objB);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f5682l;
                    na.s sVar = (na.s) atomicReferenceFieldUpdater.get(this);
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
        if (na.b.e(objB)) {
            y();
            if (oVar.f6927c * i.f5689b < s()) {
                oVar.b();
                return null;
            }
        } else {
            o oVar3 = (o) na.b.c(objB);
            long j4 = oVar3.f6927c;
            if (!A() && j2 <= f5679i.get(this) / i.f5689b) {
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f5683m;
                    na.s sVar2 = (na.s) atomicReferenceFieldUpdater2.get(this);
                    if (sVar2.f6927c >= j4 || !oVar3.j()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater2.compareAndSet(this, sVar2, oVar3)) {
                        if (atomicReferenceFieldUpdater2.get(this) != sVar2) {
                            if (oVar3.f()) {
                                oVar3.e();
                            }
                        }
                    }
                    if (sVar2.f()) {
                        sVar2.e();
                    }
                }
            }
            if (j4 <= j2) {
                return oVar3;
            }
            long j10 = j4 * i.f5689b;
            while (true) {
                long j11 = f5678h.get(this);
                if (j11 >= j10) {
                    gVar = this;
                    break;
                }
                gVar = this;
                if (f5678h.compareAndSet(gVar, j11, j10)) {
                    break;
                }
                this = gVar;
            }
            if (j4 * i.f5689b < gVar.s()) {
                oVar3.b();
            }
        }
        return null;
    }

    public final Throwable o() {
        return (Throwable) f5684n.get(this);
    }

    @Override // ka.x
    public final Object p() {
        o oVar;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f5678h;
        long j2 = atomicLongFieldUpdater.get(this);
        long j4 = f5677g.get(this);
        if (w(j4, true)) {
            return new l(o());
        }
        long j10 = j4 & 1152921504606846975L;
        m mVar = n.f5711b;
        if (j2 >= j10) {
            return mVar;
        }
        Object obj = i.f5698k;
        o oVar2 = (o) f5682l.get(this);
        while (!this.x()) {
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(this);
            long j11 = i.f5689b;
            long j12 = andIncrement / j11;
            int i2 = (int) (andIncrement % j11);
            if (oVar2.f6927c != j12) {
                o oVarN = this.n(j12, oVar2);
                if (oVarN == null) {
                    continue;
                } else {
                    oVar = oVarN;
                }
            } else {
                oVar = oVar2;
            }
            g gVar = this;
            Object objI = gVar.I(oVar, i2, andIncrement, obj);
            oVar2 = oVar;
            if (objI == i.f5700m) {
                g2 g2Var = obj instanceof g2 ? (g2) obj : null;
                if (g2Var != null) {
                    g2Var.b(oVar2, i2);
                }
                gVar.K(andIncrement);
                oVar2.i();
                return mVar;
            }
            if (objI != i.f5702o) {
                if (objI == i.f5701n) {
                    throw new IllegalStateException("unexpected");
                }
                oVar2.b();
                return objI;
            }
            if (andIncrement < gVar.s()) {
                oVar2.b();
            }
            this = gVar;
        }
        return new l(this.o());
    }

    public final Throwable q() {
        Throwable thO = o();
        return thO == null ? new p("Channel was closed") : thO;
    }

    public final Throwable r() {
        Throwable thO = o();
        return thO == null ? new d5.f("Channel was closed") : thO;
    }

    public final long s() {
        return f5677g.get(this) & 1152921504606846975L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x0194, code lost:
    
        r3 = (ka.o) r3.c();
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x019b, code lost:
    
        if (r3 != null) goto L80;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String toString() {
        /*
            Method dump skipped, instructions count: 452
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ka.g.toString():java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00be A[SYNTHETIC] */
    @Override // ka.z
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object u(java.lang.Object r16) {
        /*
            r15 = this;
            java.util.concurrent.atomic.AtomicLongFieldUpdater r8 = ka.g.f5677g
            long r1 = r8.get(r15)
            r9 = 0
            boolean r3 = r15.w(r1, r9)
            r10 = 1
            r11 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            if (r3 == 0) goto L15
            r1 = r9
            goto L1b
        L15:
            long r1 = r1 & r11
            boolean r1 = r15.g(r1)
            r1 = r1 ^ r10
        L1b:
            ka.m r13 = ka.n.f5711b
            if (r1 == 0) goto L20
            return r13
        L20:
            f8.x r6 = ka.i.f5697j
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = ka.g.f5681k
            java.lang.Object r1 = r1.get(r15)
            ka.o r1 = (ka.o) r1
        L2a:
            long r2 = r8.getAndIncrement(r15)
            long r4 = r2 & r11
            boolean r7 = r15.w(r2, r9)
            int r14 = ka.i.f5689b
            long r2 = (long) r14
            long r11 = r4 / r2
            long r2 = r4 % r2
            int r2 = (int) r2
            long r9 = r1.f6927c
            int r3 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r3 == 0) goto L5d
            ka.o r3 = b(r15, r11, r1)
            if (r3 != 0) goto L5c
            if (r7 == 0) goto L54
            java.lang.Throwable r0 = r15.r()
            ka.l r1 = new ka.l
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
            int r9 = f(r0, r1, r2, r3, r4, r6, r7)
            c7.r r3 = c7.r.f1986a
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
            r1.b()
        L7b:
            r9 = 0
            goto L56
        L7d:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = ka.g.f5678h
            long r2 = r2.get(r15)
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 >= 0) goto L8a
            r1.b()
        L8a:
            java.lang.Throwable r0 = r15.r()
            ka.l r1 = new ka.l
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
            ka.l r1 = new ka.l
            r1.<init>(r0)
            return r1
        Lab:
            boolean r0 = r6 instanceof ia.g2
            if (r0 == 0) goto Lb2
            ia.g2 r6 = (ia.g2) r6
            goto Lb3
        Lb2:
            r6 = 0
        Lb3:
            if (r6 == 0) goto Lb9
            int r2 = r2 + r14
            r6.b(r1, r2)
        Lb9:
            r1.i()
            return r13
        Lbd:
            return r3
        Lbe:
            r1.b()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: ka.g.u(java.lang.Object):java.lang.Object");
    }

    @Override // ka.x
    public final Object v(w wVar) {
        return D(this, wVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x00a2, code lost:
    
        r0 = (ka.o) ((na.c) na.c.f6895b.get(r0));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean w(long r14, boolean r16) {
        /*
            Method dump skipped, instructions count: 368
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ka.g.w(long, boolean):boolean");
    }

    public final boolean x() {
        return w(f5677g.get(this), true);
    }

    public final boolean y() {
        return w(f5677g.get(this), false);
    }

    public boolean z() {
        return false;
    }
}

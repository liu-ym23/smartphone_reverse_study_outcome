package mc;

import java.lang.invoke.VarHandle;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import jb.v;
import kc.t1;
import kc.w;
import yb.x;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class e implements i {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f8563f = AtomicLongFieldUpdater.newUpdater(e.class, "sendersAndCloseStatus$volatile");

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f8564g = AtomicLongFieldUpdater.newUpdater(e.class, "receivers$volatile");

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f8565h = AtomicLongFieldUpdater.newUpdater(e.class, "bufferEnd$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater i = AtomicLongFieldUpdater.newUpdater(e.class, "completedExpandBuffersAndPauseFlag$volatile");

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f8566j = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "sendSegment$volatile");

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f8567k = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "receiveSegment$volatile");

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f8568l = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "bufferEndSegment$volatile");

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f8569m = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "_closeCause$volatile");

    /* renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f8570n = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "closeHandler$volatile");
    private volatile /* synthetic */ Object _closeCause$volatile;
    private volatile /* synthetic */ long bufferEnd$volatile;
    private volatile /* synthetic */ Object bufferEndSegment$volatile;

    /* renamed from: c, reason: collision with root package name */
    public final int f8571c;
    private volatile /* synthetic */ Object closeHandler$volatile;
    private volatile /* synthetic */ long completedExpandBuffersAndPauseFlag$volatile;
    private volatile /* synthetic */ Object receiveSegment$volatile;
    private volatile /* synthetic */ long receivers$volatile;
    private volatile /* synthetic */ Object sendSegment$volatile;
    private volatile /* synthetic */ long sendersAndCloseStatus$volatile;

    public e(int i3) {
        this.f8571c = i3;
        if (i3 < 0) {
            od.f.c(k0.a.k(i3, "Invalid channel capacity: ", ", should be >=0"));
            throw null;
        }
        m mVar = g.f8573a;
        this.bufferEnd$volatile = i3 != 0 ? i3 != Integer.MAX_VALUE ? i3 : Long.MAX_VALUE : 0L;
        this.completedExpandBuffersAndPauseFlag$volatile = f8565h.get(this);
        m mVar2 = new m(0L, null, this, 3);
        this.sendSegment$volatile = mVar2;
        this.receiveSegment$volatile = mVar2;
        if (z()) {
            mVar2 = g.f8573a;
            mVar2.getClass();
        }
        this.bufferEndSegment$volatile = mVar2;
        this._closeCause$volatile = g.f8590s;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object C(mc.e r13, pb.c r14) {
        /*
            boolean r0 = r14 instanceof mc.c
            if (r0 == 0) goto L14
            r0 = r14
            mc.c r0 = (mc.c) r0
            int r1 = r0.f8559g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f8559g = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            mc.c r0 = new mc.c
            r0.<init>(r13, r14)
            goto L12
        L1a:
            java.lang.Object r14 = r6.f8557c
            ob.a r0 = ob.a.f9351c
            int r1 = r6.f8559g
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L34
            if (r1 != r3) goto L2e
            id.c.I(r14)
            mc.l r14 = (mc.l) r14
            java.lang.Object r13 = r14.f8596a
            return r13
        L2e:
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r13)
            return r2
        L34:
            id.c.I(r14)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r14 = mc.e.f8567k
            java.lang.Object r14 = r14.get(r13)
            mc.m r14 = (mc.m) r14
        L3f:
            boolean r1 = r13.w()
            if (r1 == 0) goto L54
            java.lang.Throwable r13 = r13.q()
            mc.j r14 = new mc.j
            r14.<init>()
            r14.f8594a = r13
            java.lang.invoke.VarHandle.storeStoreFence()
            return r14
        L54:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = mc.e.f8564g
            long r4 = r1.getAndIncrement(r13)
            int r1 = mc.g.f8574b
            long r7 = (long) r1
            long r9 = r4 / r7
            long r7 = r4 % r7
            int r1 = (int) r7
            long r7 = r14.f9982c
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L71
            mc.m r7 = r13.p(r9, r14)
            if (r7 != 0) goto L6f
            goto L3f
        L6f:
            r8 = r7
            goto L72
        L71:
            r8 = r14
        L72:
            r12 = 0
            r7 = r13
            r9 = r1
            r10 = r4
            java.lang.Object r13 = r7.H(r8, r9, r10, r12)
            r1 = r7
            pc.t r14 = mc.g.f8584m
            if (r13 == r14) goto La5
            pc.t r14 = mc.g.f8586o
            if (r13 != r14) goto L91
            long r13 = r1.t()
            int r13 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r13 >= 0) goto L8e
            r8.a()
        L8e:
            r13 = r1
            r14 = r8
            goto L3f
        L91:
            pc.t r14 = mc.g.f8585n
            if (r13 != r14) goto La1
            r6.f8559g = r3
            r2 = r8
            r3 = r9
            java.lang.Object r13 = r1.D(r2, r3, r4, r6)
            if (r13 != r0) goto La0
            return r0
        La0:
            return r13
        La1:
            r8.a()
            return r13
        La5:
            java.lang.String r13 = "unexpected"
            od.f.e(r13)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: mc.e.C(mc.e, pb.c):java.lang.Object");
    }

    public static boolean G(Object obj) {
        if (obj instanceof kc.f) {
            return g.a((kc.f) obj, v.f6774a, null);
        }
        g5.f.n(obj, "Unexpected waiter: ");
        return false;
    }

    public static final m d(e eVar, long j10, m mVar) {
        Object objB;
        e eVar2;
        m mVar2 = g.f8573a;
        f fVar = f.f8572m;
        loop0: while (true) {
            objB = pc.a.b(mVar, j10, fVar);
            if (!pc.a.e(objB)) {
                pc.r rVarC = pc.a.c(objB);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f8566j;
                    pc.r rVar = (pc.r) atomicReferenceFieldUpdater.get(eVar);
                    if (rVar.f9982c >= rVarC.f9982c) {
                        break loop0;
                    }
                    if (!rVarC.i()) {
                        break;
                    }
                    if (atomicReferenceFieldUpdater.compareAndSet(eVar, rVar, rVarC)) {
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
        boolean zE = pc.a.e(objB);
        AtomicLongFieldUpdater atomicLongFieldUpdater = f8564g;
        if (zE) {
            eVar.x();
            if (mVar.f9982c * g.f8574b < atomicLongFieldUpdater.get(eVar)) {
                mVar.a();
                return null;
            }
        } else {
            m mVar3 = (m) pc.a.c(objB);
            long j11 = mVar3.f9982c;
            if (j11 <= j10) {
                return mVar3;
            }
            long j12 = g.f8574b * j11;
            while (true) {
                long j13 = f8563f.get(eVar);
                long j14 = 1152921504606846975L & j13;
                if (j14 >= j12) {
                    eVar2 = eVar;
                    break;
                }
                eVar2 = eVar;
                if (f8563f.compareAndSet(eVar2, j13, (((int) (j13 >> 60)) << 60) + j14)) {
                    break;
                }
                eVar = eVar2;
            }
            if (j11 * g.f8574b < atomicLongFieldUpdater.get(eVar2)) {
                mVar3.a();
            }
        }
        return null;
    }

    public static final void f(e eVar, Object obj, kc.g gVar) {
        gVar.resumeWith(id.c.l(eVar.s()));
    }

    public static final int g(e eVar, m mVar, int i3, Object obj, long j10, Object obj2, boolean z10) {
        mVar.m(i3, obj);
        if (z10) {
            return eVar.I(mVar, i3, obj, j10, obj2, z10);
        }
        Object objK = mVar.k(i3);
        if (objK == null) {
            if (eVar.i(j10)) {
                if (mVar.j(i3, null, g.f8576d)) {
                    return 1;
                }
            } else {
                if (obj2 == null) {
                    return 3;
                }
                if (mVar.j(i3, null, obj2)) {
                    return 2;
                }
            }
        } else if (objK instanceof t1) {
            mVar.m(i3, null);
            if (eVar.F(objK, obj)) {
                mVar.n(i3, g.i);
                return 0;
            }
            pc.t tVar = g.f8582k;
            if (mVar.f8598f.getAndSet((i3 * 2) + 1, tVar) == tVar) {
                return 5;
            }
            mVar.l(i3, true);
            return 5;
        }
        return eVar.I(mVar, i3, obj, j10, obj2, z10);
    }

    public static void u(e eVar) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = i;
        if ((atomicLongFieldUpdater.addAndGet(eVar, 1L) & 4611686018427387904L) != 0) {
            while ((atomicLongFieldUpdater.get(eVar) & 4611686018427387904L) != 0) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0011, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A(long r5, mc.m r7) {
        /*
            r4 = this;
        L0:
            long r0 = r7.f9982c
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 >= 0) goto L11
            pc.b r0 = r7.b()
            mc.m r0 = (mc.m) r0
            if (r0 != 0) goto Lf
            goto L11
        Lf:
            r7 = r0
            goto L0
        L11:
            boolean r5 = r7.c()
            if (r5 == 0) goto L22
            pc.b r5 = r7.b()
            mc.m r5 = (mc.m) r5
            if (r5 != 0) goto L20
            goto L22
        L20:
            r7 = r5
            goto L11
        L22:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = mc.e.f8568l
            java.lang.Object r6 = r5.get(r4)
            pc.r r6 = (pc.r) r6
            long r0 = r6.f9982c
            long r2 = r7.f9982c
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 < 0) goto L33
            goto L49
        L33:
            boolean r0 = r7.i()
            if (r0 != 0) goto L3a
            goto L11
        L3a:
            boolean r5 = r5.compareAndSet(r4, r6, r7)
            if (r5 == 0) goto L4a
            boolean r4 = r6.e()
            if (r4 == 0) goto L49
            r6.d()
        L49:
            return
        L4a:
            boolean r5 = r7.e()
            if (r5 == 0) goto L22
            r7.d()
            goto L22
        */
        throw new UnsupportedOperationException("Method not decompiled: mc.e.A(long, mc.m):void");
    }

    public final Object B(Object obj, nb.c cVar) {
        kc.g gVar = new kc.g(1, td.h.y(cVar));
        gVar.s();
        gVar.resumeWith(id.c.l(s()));
        Object objR = gVar.r();
        return objR == ob.a.f9351c ? objR : v.f6774a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object D(mc.m r11, int r12, long r13, pb.c r15) {
        /*
            Method dump skipped, instructions count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: mc.e.D(mc.m, int, long, pb.c):java.lang.Object");
    }

    public final void E(t1 t1Var, boolean z10) {
        if (t1Var instanceof kc.f) {
            ((nb.c) t1Var).resumeWith(id.c.l(z10 ? r() : s()));
            return;
        }
        if (t1Var instanceof s) {
            kc.g gVar = ((s) t1Var).f8604c;
            Throwable thQ = q();
            j jVar = new j();
            jVar.f8594a = thQ;
            VarHandle.storeStoreFence();
            gVar.resumeWith(l.a(jVar));
            return;
        }
        if (!(t1Var instanceof b)) {
            g5.f.n(t1Var, "Unexpected waiter: ");
            return;
        }
        b bVar = (b) t1Var;
        kc.g gVar2 = bVar.f8555f;
        gVar2.getClass();
        bVar.f8555f = null;
        bVar.f8554c = g.f8583l;
        Throwable thQ2 = bVar.f8556g.q();
        if (thQ2 == null) {
            gVar2.resumeWith(Boolean.FALSE);
        } else {
            gVar2.resumeWith(id.c.l(thQ2));
        }
    }

    public final boolean F(Object obj, Object obj2) {
        if (obj instanceof s) {
            return g.a(((s) obj).f8604c, l.a(obj2), null);
        }
        if (!(obj instanceof b)) {
            if (obj instanceof kc.f) {
                return g.a((kc.f) obj, obj2, null);
            }
            g5.f.n(obj, "Unexpected receiver type: ");
            return false;
        }
        b bVar = (b) obj;
        kc.g gVar = bVar.f8555f;
        gVar.getClass();
        bVar.f8555f = null;
        bVar.f8554c = obj2;
        return g.a(gVar, Boolean.TRUE, null);
    }

    public final Object H(m mVar, int i3, long j10, Object obj) {
        Object objK = mVar.k(i3);
        AtomicReferenceArray atomicReferenceArray = mVar.f8598f;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f8563f;
        if (objK == null) {
            if (j10 >= (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    return g.f8585n;
                }
                if (mVar.j(i3, objK, obj)) {
                    o();
                    return g.f8584m;
                }
            }
        } else if (objK == g.f8576d && mVar.j(i3, objK, g.i)) {
            o();
            Object obj2 = atomicReferenceArray.get(i3 * 2);
            mVar.m(i3, null);
            return obj2;
        }
        while (true) {
            Object objK2 = mVar.k(i3);
            if (objK2 == null || objK2 == g.f8577e) {
                if (j10 < (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                    if (mVar.j(i3, objK2, g.f8580h)) {
                        o();
                        return g.f8586o;
                    }
                } else {
                    if (obj == null) {
                        return g.f8585n;
                    }
                    if (mVar.j(i3, objK2, obj)) {
                        o();
                        return g.f8584m;
                    }
                }
            } else if (objK2 != g.f8576d) {
                pc.t tVar = g.f8581j;
                if (objK2 == tVar) {
                    return g.f8586o;
                }
                if (objK2 == g.f8580h) {
                    return g.f8586o;
                }
                if (objK2 == g.f8583l) {
                    o();
                    return g.f8586o;
                }
                if (objK2 != g.f8579g && mVar.j(i3, objK2, g.f8578f)) {
                    boolean z10 = objK2 instanceof u;
                    if (z10) {
                        objK2 = ((u) objK2).f8605a;
                    }
                    if (G(objK2)) {
                        mVar.n(i3, g.i);
                        o();
                        Object obj3 = atomicReferenceArray.get(i3 * 2);
                        mVar.m(i3, null);
                        return obj3;
                    }
                    mVar.n(i3, tVar);
                    mVar.h();
                    if (z10) {
                        o();
                    }
                    return g.f8586o;
                }
            } else if (mVar.j(i3, objK2, g.i)) {
                o();
                Object obj4 = atomicReferenceArray.get(i3 * 2);
                mVar.m(i3, null);
                return obj4;
            }
        }
    }

    public final int I(m mVar, int i3, Object obj, long j10, Object obj2, boolean z10) {
        while (true) {
            Object objK = mVar.k(i3);
            if (objK == null) {
                if (!i(j10) || z10) {
                    if (z10) {
                        if (mVar.j(i3, null, g.f8581j)) {
                            mVar.h();
                            return 4;
                        }
                    } else {
                        if (obj2 == null) {
                            return 3;
                        }
                        if (mVar.j(i3, null, obj2)) {
                            return 2;
                        }
                    }
                } else if (mVar.j(i3, null, g.f8576d)) {
                    break;
                }
            } else {
                if (objK != g.f8577e) {
                    pc.t tVar = g.f8582k;
                    if (objK == tVar) {
                        mVar.m(i3, null);
                        return 5;
                    }
                    if (objK == g.f8580h) {
                        mVar.m(i3, null);
                        return 5;
                    }
                    if (objK == g.f8583l) {
                        mVar.m(i3, null);
                        x();
                        return 4;
                    }
                    mVar.m(i3, null);
                    if (objK instanceof u) {
                        objK = ((u) objK).f8605a;
                    }
                    if (F(objK, obj)) {
                        mVar.n(i3, g.i);
                        return 0;
                    }
                    if (mVar.f8598f.getAndSet((i3 * 2) + 1, tVar) != tVar) {
                        mVar.l(i3, true);
                    }
                    return 5;
                }
                if (mVar.j(i3, objK, g.f8576d)) {
                    break;
                }
            }
        }
        return 1;
    }

    public final void J(long j10) {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        e eVar = this;
        if (eVar.z()) {
            return;
        }
        while (true) {
            atomicLongFieldUpdater = f8565h;
            if (atomicLongFieldUpdater.get(eVar) > j10) {
                break;
            } else {
                eVar = this;
            }
        }
        int i3 = g.f8575c;
        int i10 = 0;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater2 = i;
            if (i10 < i3) {
                long j11 = atomicLongFieldUpdater.get(eVar);
                if (j11 == (4611686018427387903L & atomicLongFieldUpdater2.get(eVar)) && j11 == atomicLongFieldUpdater.get(eVar)) {
                    return;
                } else {
                    i10++;
                }
            } else {
                while (true) {
                    long j12 = atomicLongFieldUpdater2.get(eVar);
                    if (atomicLongFieldUpdater2.compareAndSet(eVar, j12, (j12 & 4611686018427387903L) + 4611686018427387904L)) {
                        break;
                    } else {
                        eVar = this;
                    }
                }
                while (true) {
                    long j13 = atomicLongFieldUpdater.get(eVar);
                    long j14 = atomicLongFieldUpdater2.get(eVar);
                    long j15 = j14 & 4611686018427387903L;
                    boolean z10 = (j14 & 4611686018427387904L) != 0;
                    if (j13 == j15 && j13 == atomicLongFieldUpdater.get(eVar)) {
                        break;
                    }
                    if (z10) {
                        eVar = this;
                    } else {
                        eVar = this;
                        atomicLongFieldUpdater2.compareAndSet(eVar, j14, 4611686018427387904L + j15);
                    }
                }
                while (true) {
                    long j16 = atomicLongFieldUpdater2.get(eVar);
                    if (atomicLongFieldUpdater2.compareAndSet(eVar, j16, j16 & 4611686018427387903L)) {
                        return;
                    } else {
                        eVar = this;
                    }
                }
            }
        }
    }

    @Override // mc.i
    public final Object a(pb.i iVar) throws Throwable {
        m mVar;
        Throwable th;
        m mVar2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f8567k;
        m mVar3 = (m) atomicReferenceFieldUpdater.get(this);
        while (!this.w()) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f8564g;
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(this);
            long j10 = g.f8574b;
            long j11 = andIncrement / j10;
            int i3 = (int) (andIncrement % j10);
            if (mVar3.f9982c != j11) {
                m mVarP = this.p(j11, mVar3);
                if (mVarP == null) {
                    continue;
                } else {
                    mVar = mVarP;
                }
            } else {
                mVar = mVar3;
            }
            e eVar = this;
            Object objH = eVar.H(mVar, i3, andIncrement, null);
            pc.t tVar = g.f8584m;
            if (objH == tVar) {
                od.f.e("unexpected");
                return null;
            }
            pc.t tVar2 = g.f8586o;
            if (objH == tVar2) {
                if (andIncrement < eVar.t()) {
                    mVar.a();
                }
                this = eVar;
                mVar3 = mVar;
            } else {
                if (objH != g.f8585n) {
                    mVar.a();
                    return objH;
                }
                kc.g gVarO = w.o(td.h.y(iVar));
                try {
                    Object objH2 = eVar.H(mVar, i3, andIncrement, gVarO);
                    if (objH2 == tVar) {
                        gVarO.a(mVar, i3);
                    } else {
                        if (objH2 == tVar2) {
                            if (andIncrement < eVar.t()) {
                                mVar.a();
                            }
                            m mVar4 = (m) atomicReferenceFieldUpdater.get(eVar);
                            while (true) {
                                if (eVar.w()) {
                                    gVarO.resumeWith(id.c.l(eVar.r()));
                                    break;
                                }
                                kc.g gVar = gVarO;
                                try {
                                    long andIncrement2 = atomicLongFieldUpdater.getAndIncrement(eVar);
                                    long j12 = g.f8574b;
                                    long j13 = andIncrement2 / j12;
                                    int i10 = (int) (andIncrement2 % j12);
                                    if (mVar4.f9982c != j13) {
                                        try {
                                            m mVarP2 = eVar.p(j13, mVar4);
                                            if (mVarP2 == null) {
                                                gVarO = gVar;
                                            } else {
                                                mVar2 = mVarP2;
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            gVarO = gVar;
                                            gVarO.z();
                                            throw th;
                                        }
                                    } else {
                                        mVar2 = mVar4;
                                    }
                                    e eVar2 = eVar;
                                    objH2 = eVar2.H(mVar2, i10, andIncrement2, gVar);
                                    eVar = eVar2;
                                    m mVar5 = mVar2;
                                    gVarO = gVar;
                                    if (objH2 == g.f8584m) {
                                        gVarO.a(mVar5, i10);
                                        break;
                                    }
                                    if (objH2 == g.f8586o) {
                                        if (andIncrement2 < eVar.t()) {
                                            mVar5.a();
                                        }
                                        mVar4 = mVar5;
                                    } else {
                                        if (objH2 == g.f8585n) {
                                            throw new IllegalStateException("unexpected");
                                        }
                                        mVar5.a();
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    gVarO = gVar;
                                    th = th;
                                    gVarO.z();
                                    throw th;
                                }
                            }
                        } else {
                            mVar.a();
                        }
                        gVarO.l(objH2, null);
                    }
                    Object objR = gVarO.r();
                    ob.a aVar = ob.a.f9351c;
                    return objR;
                } catch (Throwable th4) {
                    th = th4;
                }
            }
        }
        Throwable thR = this.r();
        int i11 = pc.s.f9983a;
        throw thR;
    }

    @Override // mc.i
    public final Object b() {
        m mVar;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f8564g;
        long j10 = atomicLongFieldUpdater.get(this);
        long j11 = f8563f.get(this);
        if (v(j11, true)) {
            Throwable thQ = q();
            j jVar = new j();
            jVar.f8594a = thQ;
            VarHandle.storeStoreFence();
            return jVar;
        }
        long j12 = j11 & 1152921504606846975L;
        k kVar = l.f8595b;
        if (j10 >= j12) {
            return kVar;
        }
        Object obj = g.f8582k;
        m mVar2 = (m) f8567k.get(this);
        while (!this.w()) {
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(this);
            long j13 = g.f8574b;
            long j14 = andIncrement / j13;
            int i3 = (int) (andIncrement % j13);
            if (mVar2.f9982c != j14) {
                m mVarP = this.p(j14, mVar2);
                if (mVarP == null) {
                    continue;
                } else {
                    mVar = mVarP;
                }
            } else {
                mVar = mVar2;
            }
            e eVar = this;
            Object objH = eVar.H(mVar, i3, andIncrement, obj);
            mVar2 = mVar;
            if (objH == g.f8584m) {
                t1 t1Var = obj instanceof t1 ? (t1) obj : null;
                if (t1Var != null) {
                    t1Var.a(mVar2, i3);
                }
                eVar.J(andIncrement);
                mVar2.h();
                return kVar;
            }
            if (objH != g.f8586o) {
                if (objH != g.f8585n) {
                    mVar2.a();
                    return objH;
                }
                od.f.e("unexpected");
                return null;
            }
            if (andIncrement < eVar.t()) {
                mVar2.a();
            }
            this = eVar;
        }
        Throwable thQ2 = this.q();
        j jVar2 = new j();
        jVar2.f8594a = thQ2;
        VarHandle.storeStoreFence();
        return jVar2;
    }

    @Override // mc.i
    public final Object c(oc.o oVar) {
        return C(this, oVar);
    }

    @Override // mc.i
    public final void e(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new CancellationException("Channel was cancelled");
        }
        l(cancellationException, true);
    }

    @Override // mc.t
    public Object h(Object obj) {
        Throwable thS;
        j jVar;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f8563f;
        boolean z10 = false;
        long j10 = 1152921504606846975L;
        boolean z11 = v(atomicLongFieldUpdater.get(this), false) ? false : !i(r1 & 1152921504606846975L);
        k kVar = l.f8595b;
        if (z11) {
            return kVar;
        }
        Object obj2 = g.f8581j;
        m mVar = (m) f8566j.get(this);
        while (true) {
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(this);
            long j11 = andIncrement & j10;
            boolean zV = v(andIncrement, z10);
            int i3 = g.f8574b;
            long j12 = i3;
            long j13 = j11 / j12;
            int i10 = (int) (j11 % j12);
            if (mVar.f9982c != j13) {
                m mVarD = d(this, j13, mVar);
                if (mVarD != null) {
                    mVar = mVarD;
                } else {
                    if (zV) {
                        thS = s();
                        jVar = new j();
                        break;
                    }
                    z10 = false;
                    j10 = 1152921504606846975L;
                }
            }
            int iG = g(this, mVar, i10, obj, j11, obj2, zV);
            v vVar = v.f6774a;
            if (iG == 0) {
                mVar.a();
                return vVar;
            }
            if (iG == 1) {
                return vVar;
            }
            if (iG != 2) {
                if (iG == 3) {
                    od.f.e("unexpected");
                    return null;
                }
                if (iG != 4) {
                    if (iG == 5) {
                        mVar.a();
                    }
                    z10 = false;
                    j10 = 1152921504606846975L;
                } else {
                    if (j11 < f8564g.get(this)) {
                        mVar.a();
                    }
                    thS = s();
                    jVar = new j();
                }
            } else {
                if (!zV) {
                    t1 t1Var = obj2 instanceof t1 ? (t1) obj2 : null;
                    if (t1Var != null) {
                        t1Var.a(mVar, i10 + i3);
                    }
                    mVar.h();
                    return kVar;
                }
                mVar.h();
                thS = s();
                jVar = new j();
            }
        }
        jVar.f8594a = thS;
        VarHandle.storeStoreFence();
        return jVar;
    }

    public final boolean i(long j10) {
        return j10 < f8565h.get(this) || j10 < f8564g.get(this) + ((long) this.f8571c);
    }

    @Override // mc.i
    public final b iterator() {
        b bVar = new b();
        bVar.f8556g = this;
        bVar.f8554c = g.f8587p;
        VarHandle.storeStoreFence();
        return bVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:85:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x014f A[RETURN] */
    @Override // mc.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object j(java.lang.Object r23, nb.c r24) {
        /*
            Method dump skipped, instructions count: 361
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: mc.e.j(java.lang.Object, nb.c):java.lang.Object");
    }

    public final boolean k(Throwable th) {
        return l(th, false);
    }

    public final boolean l(Throwable th, boolean z10) {
        e eVar;
        long j10;
        long j11;
        long j12;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Object obj;
        long j13;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f8563f;
        if (z10) {
            while (true) {
                long j14 = atomicLongFieldUpdater.get(this);
                if (((int) (j14 >> 60)) != 0) {
                    break;
                }
                m mVar = g.f8573a;
                eVar = this;
                if (atomicLongFieldUpdater.compareAndSet(eVar, j14, (j14 & 1152921504606846975L) + (1 << 60))) {
                    break;
                }
                this = eVar;
            }
        } else {
            eVar = this;
        }
        boolean zCompareAndSet = f8569m.compareAndSet(eVar, g.f8590s, th);
        if (z10) {
            do {
                j13 = atomicLongFieldUpdater.get(eVar);
            } while (!atomicLongFieldUpdater.compareAndSet(eVar, j13, (j13 & 1152921504606846975L) + (3 << 60)));
        } else {
            do {
                j10 = atomicLongFieldUpdater.get(eVar);
                int i3 = (int) (j10 >> 60);
                if (i3 == 0) {
                    j11 = j10 & 1152921504606846975L;
                    j12 = 2;
                } else {
                    if (i3 != 1) {
                        break;
                    }
                    j11 = j10 & 1152921504606846975L;
                    j12 = 3;
                }
            } while (!atomicLongFieldUpdater.compareAndSet(eVar, j10, (j12 << 60) + j11));
        }
        eVar.x();
        if (zCompareAndSet) {
            do {
                atomicReferenceFieldUpdater = f8570n;
                obj = atomicReferenceFieldUpdater.get(eVar);
            } while (!atomicReferenceFieldUpdater.compareAndSet(eVar, obj, obj == null ? g.f8588q : g.f8589r));
            if (obj != null) {
                x.c(1, obj);
                ((xb.l) obj).invoke(eVar.q());
            }
        }
        return zCompareAndSet;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x008d, code lost:
    
        r1 = (mc.m) ((pc.b) pc.b.f9951b.get(r1));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final mc.m m(long r13) {
        /*
            Method dump skipped, instructions count: 298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: mc.e.m(long):mc.m");
    }

    public final void n(long j10) {
        m mVar = (m) f8567k.get(this);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f8564g;
            long j11 = atomicLongFieldUpdater.get(this);
            if (j10 < Math.max(this.f8571c + j11, f8565h.get(this))) {
                return;
            }
            e eVar = this;
            if (atomicLongFieldUpdater.compareAndSet(eVar, j11, 1 + j11)) {
                long j12 = g.f8574b;
                long j13 = j11 / j12;
                int i3 = (int) (j11 % j12);
                if (mVar.f9982c != j13) {
                    m mVarP = eVar.p(j13, mVar);
                    if (mVarP != null) {
                        mVar = mVarP;
                    }
                }
                m mVar2 = mVar;
                if (eVar.H(mVar2, i3, j11, null) != g.f8586o || j11 < eVar.t()) {
                    mVar2.a();
                }
                this = eVar;
                mVar = mVar2;
            }
            this = eVar;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x017a, code lost:
    
        u(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x017d, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void o() {
        /*
            Method dump skipped, instructions count: 382
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: mc.e.o():void");
    }

    public final m p(long j10, m mVar) {
        Object objB;
        e eVar;
        m mVar2 = g.f8573a;
        f fVar = f.f8572m;
        loop0: while (true) {
            objB = pc.a.b(mVar, j10, fVar);
            if (!pc.a.e(objB)) {
                pc.r rVarC = pc.a.c(objB);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f8567k;
                    pc.r rVar = (pc.r) atomicReferenceFieldUpdater.get(this);
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
        if (pc.a.e(objB)) {
            x();
            if (mVar.f9982c * g.f8574b < t()) {
                mVar.a();
                return null;
            }
        } else {
            m mVar3 = (m) pc.a.c(objB);
            long j11 = mVar3.f9982c;
            if (!z() && j10 <= f8565h.get(this) / g.f8574b) {
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f8568l;
                    pc.r rVar2 = (pc.r) atomicReferenceFieldUpdater2.get(this);
                    if (rVar2.f9982c >= j11 || !mVar3.i()) {
                        break;
                    }
                    if (atomicReferenceFieldUpdater2.compareAndSet(this, rVar2, mVar3)) {
                        if (rVar2.e()) {
                            rVar2.d();
                        }
                    } else if (mVar3.e()) {
                        mVar3.d();
                    }
                }
            }
            if (j11 <= j10) {
                return mVar3;
            }
            long j12 = j11 * g.f8574b;
            while (true) {
                long j13 = f8564g.get(this);
                if (j13 >= j12) {
                    eVar = this;
                    break;
                }
                eVar = this;
                if (f8564g.compareAndSet(eVar, j13, j12)) {
                    break;
                }
                this = eVar;
            }
            if (j11 * g.f8574b < eVar.t()) {
                mVar3.a();
            }
        }
        return null;
    }

    public final Throwable q() {
        return (Throwable) f8569m.get(this);
    }

    public final Throwable r() {
        Throwable thQ = q();
        return thQ == null ? new n("Channel was closed") : thQ;
    }

    public final Throwable s() {
        Throwable thQ = q();
        return thQ == null ? new o("Channel was closed") : thQ;
    }

    public final long t() {
        return f8563f.get(this) & 1152921504606846975L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x0194, code lost:
    
        r3 = (mc.m) r3.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x019b, code lost:
    
        if (r3 != null) goto L84;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String toString() {
        /*
            Method dump skipped, instructions count: 467
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: mc.e.toString():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x00a2, code lost:
    
        r0 = (mc.m) ((pc.b) pc.b.f9951b.get(r0));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean v(long r14, boolean r16) {
        /*
            Method dump skipped, instructions count: 363
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: mc.e.v(long, boolean):boolean");
    }

    public final boolean w() {
        return v(f8563f.get(this), true);
    }

    public final boolean x() {
        return v(f8563f.get(this), false);
    }

    public boolean y() {
        return false;
    }

    public final boolean z() {
        long j10 = f8565h.get(this);
        return j10 == 0 || j10 == Long.MAX_VALUE;
    }
}

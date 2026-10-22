package c6;

import a6.g2;
import a6.i0;
import a6.o0;
import b5.a0;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.d0;
import org.tukaani.xz.common.Util;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class c implements g {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f1108b = AtomicLongFieldUpdater.newUpdater(c.class, "sendersAndCloseStatus$volatile");

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f1109c = AtomicLongFieldUpdater.newUpdater(c.class, "receivers$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater d = AtomicLongFieldUpdater.newUpdater(c.class, "bufferEnd$volatile");

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f1110e = AtomicLongFieldUpdater.newUpdater(c.class, "completedExpandBuffersAndPauseFlag$volatile");

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f1111f = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "sendSegment$volatile");

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f1112g = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "receiveSegment$volatile");

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f1113h = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "bufferEndSegment$volatile");

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f1114j = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_closeCause$volatile");

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f1115k = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "closeHandler$volatile");
    private volatile /* synthetic */ Object _closeCause$volatile;

    /* renamed from: a, reason: collision with root package name */
    public final int f1116a;
    private volatile /* synthetic */ long bufferEnd$volatile;
    private volatile /* synthetic */ Object bufferEndSegment$volatile;
    private volatile /* synthetic */ Object closeHandler$volatile;
    private volatile /* synthetic */ long completedExpandBuffersAndPauseFlag$volatile;
    private volatile /* synthetic */ Object receiveSegment$volatile;
    private volatile /* synthetic */ long receivers$volatile;
    private volatile /* synthetic */ Object sendSegment$volatile;
    private volatile /* synthetic */ long sendersAndCloseStatus$volatile;

    public c(int i8) {
        this.f1116a = i8;
        if (i8 < 0) {
            throw new IllegalArgumentException(a8.b.k(i8, "Invalid channel capacity: ", ", should be >=0").toString());
        }
        k kVar = e.f1118a;
        this.bufferEnd$volatile = i8 != 0 ? i8 != Integer.MAX_VALUE ? i8 : Util.VLI_MAX : 0L;
        this.completedExpandBuffersAndPauseFlag$volatile = d.get(this);
        k kVar2 = new k(0L, null, this, 3);
        this.sendSegment$volatile = kVar2;
        this.receiveSegment$volatile = kVar2;
        if (x()) {
            kVar2 = e.f1118a;
            kotlin.jvm.internal.p.c(kVar2, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
        }
        this.bufferEndSegment$volatile = kVar2;
        this._closeCause$volatile = e.f1135s;
    }

    public static boolean C(Object obj) {
        if (!(obj instanceof a6.k)) {
            throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
        }
        a6.k kVar = (a6.k) obj;
        k kVar2 = e.f1118a;
        androidx.emoji2.text.r rVarP = kVar.p(a0.f883a, null);
        if (rVarP == null) {
            return false;
        }
        kVar.m(rVarP);
        return true;
    }

    public static final k a(c cVar, long j4, k kVar) throws o0 {
        Object objB;
        c cVar2;
        k kVar2 = e.f1118a;
        d dVar = d.f1117a;
        loop0: while (true) {
            objB = f6.a.b(kVar, j4, dVar);
            if (!f6.a.e(objB)) {
                f6.q qVarC = f6.a.c(objB);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1111f;
                    f6.q qVar = (f6.q) atomicReferenceFieldUpdater.get(cVar);
                    if (qVar.f2659c >= qVarC.f2659c) {
                        break loop0;
                    }
                    if (!qVarC.j()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(cVar, qVar, qVarC)) {
                        if (atomicReferenceFieldUpdater.get(cVar) != qVar) {
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
        boolean zE = f6.a.e(objB);
        AtomicLongFieldUpdater atomicLongFieldUpdater = f1109c;
        if (zE) {
            cVar.m();
            if (kVar.f2659c * e.f1119b < atomicLongFieldUpdater.get(cVar)) {
                kVar.b();
                return null;
            }
        } else {
            k kVar3 = (k) f6.a.c(objB);
            long j8 = kVar3.f2659c;
            if (j8 <= j4) {
                return kVar3;
            }
            long j9 = e.f1119b * j8;
            while (true) {
                long j10 = f1108b.get(cVar);
                long j11 = 1152921504606846975L & j10;
                if (j11 >= j9) {
                    cVar2 = cVar;
                    break;
                }
                cVar2 = cVar;
                if (f1108b.compareAndSet(cVar2, j10, (((int) (j10 >> 60)) << 60) + j11)) {
                    break;
                }
                cVar = cVar2;
            }
            if (j8 * e.f1119b < atomicLongFieldUpdater.get(cVar2)) {
                kVar3.b();
            }
        }
        return null;
    }

    public static final void b(c cVar, Object obj, a6.m mVar) throws o0 {
        mVar.resumeWith(a.a.o(cVar.s()));
    }

    public static final int g(c cVar, k kVar, int i8, Object obj, long j4, Object obj2, boolean z) {
        kVar.n(i8, obj);
        if (z) {
            return cVar.E(kVar, i8, obj, j4, obj2, z);
        }
        Object objL = kVar.l(i8);
        if (objL == null) {
            if (cVar.h(j4)) {
                if (kVar.k(null, i8, e.d)) {
                    return 1;
                }
            } else {
                if (obj2 == null) {
                    return 3;
                }
                if (kVar.k(null, i8, obj2)) {
                    return 2;
                }
            }
        } else if (objL instanceof g2) {
            kVar.n(i8, null);
            if (cVar.B(objL, obj)) {
                kVar.o(i8, e.f1125i);
                return 0;
            }
            androidx.emoji2.text.r rVar = e.f1127k;
            if (kVar.f1142f.getAndSet((i8 * 2) + 1, rVar) == rVar) {
                return 5;
            }
            kVar.m(i8, true);
            return 5;
        }
        return cVar.E(kVar, i8, obj, j4, obj2, z);
    }

    public static void u(c cVar) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f1110e;
        if ((atomicLongFieldUpdater.addAndGet(cVar, 1L) & 4611686018427387904L) != 0) {
            while ((atomicLongFieldUpdater.get(cVar) & 4611686018427387904L) != 0) {
            }
        }
    }

    public final void A(g2 g2Var, boolean z) throws o0 {
        if (g2Var instanceof a6.k) {
            ((f5.c) g2Var).resumeWith(a.a.o(z ? r() : s()));
            return;
        }
        if (!(g2Var instanceof b)) {
            throw new IllegalStateException(("Unexpected waiter: " + g2Var).toString());
        }
        b bVar = (b) g2Var;
        a6.m mVar = bVar.f1106b;
        kotlin.jvm.internal.p.b(mVar);
        bVar.f1106b = null;
        bVar.f1105a = e.f1128l;
        Throwable thQ = bVar.f1107c.q();
        if (thQ == null) {
            mVar.resumeWith(Boolean.FALSE);
        } else {
            mVar.resumeWith(a.a.o(thQ));
        }
    }

    public final boolean B(Object obj, Object obj2) throws o0 {
        if (!(obj instanceof b)) {
            if (!(obj instanceof a6.k)) {
                throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
            }
            a6.k kVar = (a6.k) obj;
            k kVar2 = e.f1118a;
            androidx.emoji2.text.r rVarP = kVar.p(obj2, null);
            if (rVarP == null) {
                return false;
            }
            kVar.m(rVarP);
            return true;
        }
        b bVar = (b) obj;
        a6.m mVar = bVar.f1106b;
        kotlin.jvm.internal.p.b(mVar);
        bVar.f1106b = null;
        bVar.f1105a = obj2;
        Boolean bool = Boolean.TRUE;
        k kVar3 = e.f1118a;
        androidx.emoji2.text.r rVarP2 = mVar.p(bool, null);
        if (rVarP2 == null) {
            return false;
        }
        mVar.m(rVarP2);
        return true;
    }

    public final Object D(k kVar, int i8, long j4, Object obj) {
        AtomicReferenceArray atomicReferenceArray = kVar.f1142f;
        Object objL = kVar.l(i8);
        AtomicLongFieldUpdater atomicLongFieldUpdater = f1108b;
        if (objL == null) {
            if (j4 >= (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    return e.f1130n;
                }
                if (kVar.k(objL, i8, obj)) {
                    o();
                    return e.f1129m;
                }
            }
        } else if (objL == e.d && kVar.k(objL, i8, e.f1125i)) {
            o();
            Object obj2 = atomicReferenceArray.get(i8 * 2);
            kVar.n(i8, null);
            return obj2;
        }
        while (true) {
            Object objL2 = kVar.l(i8);
            if (objL2 == null || objL2 == e.f1121e) {
                if (j4 < (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                    if (kVar.k(objL2, i8, e.f1124h)) {
                        o();
                        return e.f1131o;
                    }
                } else {
                    if (obj == null) {
                        return e.f1130n;
                    }
                    if (kVar.k(objL2, i8, obj)) {
                        o();
                        return e.f1129m;
                    }
                }
            } else if (objL2 != e.d) {
                androidx.emoji2.text.r rVar = e.f1126j;
                if (objL2 == rVar) {
                    return e.f1131o;
                }
                if (objL2 == e.f1124h) {
                    return e.f1131o;
                }
                if (objL2 == e.f1128l) {
                    o();
                    return e.f1131o;
                }
                if (objL2 != e.f1123g && kVar.k(objL2, i8, e.f1122f)) {
                    boolean z = objL2 instanceof s;
                    if (z) {
                        objL2 = ((s) objL2).f1145a;
                    }
                    if (C(objL2)) {
                        kVar.o(i8, e.f1125i);
                        o();
                        Object obj3 = atomicReferenceArray.get(i8 * 2);
                        kVar.n(i8, null);
                        return obj3;
                    }
                    kVar.o(i8, rVar);
                    kVar.i();
                    if (z) {
                        o();
                    }
                    return e.f1131o;
                }
            } else if (kVar.k(objL2, i8, e.f1125i)) {
                o();
                Object obj4 = atomicReferenceArray.get(i8 * 2);
                kVar.n(i8, null);
                return obj4;
            }
        }
    }

    public final int E(k kVar, int i8, Object obj, long j4, Object obj2, boolean z) throws o0 {
        while (true) {
            Object objL = kVar.l(i8);
            if (objL == null) {
                if (!h(j4) || z) {
                    if (z) {
                        if (kVar.k(null, i8, e.f1126j)) {
                            kVar.i();
                            return 4;
                        }
                    } else {
                        if (obj2 == null) {
                            return 3;
                        }
                        if (kVar.k(null, i8, obj2)) {
                            return 2;
                        }
                    }
                } else if (kVar.k(null, i8, e.d)) {
                    break;
                }
            } else {
                if (objL != e.f1121e) {
                    androidx.emoji2.text.r rVar = e.f1127k;
                    if (objL == rVar) {
                        kVar.n(i8, null);
                        return 5;
                    }
                    if (objL == e.f1124h) {
                        kVar.n(i8, null);
                        return 5;
                    }
                    if (objL == e.f1128l) {
                        kVar.n(i8, null);
                        m();
                        return 4;
                    }
                    kVar.n(i8, null);
                    if (objL instanceof s) {
                        objL = ((s) objL).f1145a;
                    }
                    if (B(objL, obj)) {
                        kVar.o(i8, e.f1125i);
                        return 0;
                    }
                    if (kVar.f1142f.getAndSet((i8 * 2) + 1, rVar) != rVar) {
                        kVar.m(i8, true);
                    }
                    return 5;
                }
                if (kVar.k(objL, i8, e.d)) {
                    break;
                }
            }
        }
        return 1;
    }

    public final void F(long j4) {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        c cVar = this;
        if (cVar.x()) {
            return;
        }
        while (true) {
            atomicLongFieldUpdater = d;
            if (atomicLongFieldUpdater.get(cVar) > j4) {
                break;
            } else {
                cVar = this;
            }
        }
        int i8 = e.f1120c;
        int i9 = 0;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater2 = f1110e;
            if (i9 < i8) {
                long j8 = atomicLongFieldUpdater.get(cVar);
                if (j8 == (4611686018427387903L & atomicLongFieldUpdater2.get(cVar)) && j8 == atomicLongFieldUpdater.get(cVar)) {
                    return;
                } else {
                    i9++;
                }
            } else {
                while (true) {
                    long j9 = atomicLongFieldUpdater2.get(cVar);
                    if (atomicLongFieldUpdater2.compareAndSet(cVar, j9, (j9 & 4611686018427387903L) + 4611686018427387904L)) {
                        break;
                    } else {
                        cVar = this;
                    }
                }
                while (true) {
                    long j10 = atomicLongFieldUpdater.get(cVar);
                    long j11 = atomicLongFieldUpdater2.get(cVar);
                    long j12 = j11 & 4611686018427387903L;
                    boolean z = (j11 & 4611686018427387904L) != 0;
                    if (j10 == j12 && j10 == atomicLongFieldUpdater.get(cVar)) {
                        break;
                    }
                    if (z) {
                        cVar = this;
                    } else {
                        cVar = this;
                        atomicLongFieldUpdater2.compareAndSet(cVar, j11, 4611686018427387904L + j12);
                    }
                }
                while (true) {
                    long j13 = atomicLongFieldUpdater2.get(cVar);
                    if (atomicLongFieldUpdater2.compareAndSet(cVar, j13, j13 & 4611686018427387903L)) {
                        return;
                    } else {
                        cVar = this;
                    }
                }
            }
        }
    }

    @Override // c6.q
    public final Object c(h5.i iVar) throws Throwable {
        k kVar;
        Throwable th;
        k kVar2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1112g;
        k kVar3 = (k) atomicReferenceFieldUpdater.get(this);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f1108b;
            if (this.v(atomicLongFieldUpdater.get(this), true)) {
                Throwable thR = this.r();
                int i8 = f6.r.f2660a;
                throw thR;
            }
            AtomicLongFieldUpdater atomicLongFieldUpdater2 = f1109c;
            long andIncrement = atomicLongFieldUpdater2.getAndIncrement(this);
            long j4 = e.f1119b;
            long j8 = andIncrement / j4;
            int i9 = (int) (andIncrement % j4);
            if (kVar3.f2659c != j8) {
                k kVarP = this.p(j8, kVar3);
                if (kVarP == null) {
                    continue;
                } else {
                    kVar = kVarP;
                }
            } else {
                kVar = kVar3;
            }
            c cVar = this;
            Object objD = cVar.D(kVar, i9, andIncrement, null);
            androidx.emoji2.text.r rVar = e.f1129m;
            if (objD == rVar) {
                throw new IllegalStateException("unexpected");
            }
            androidx.emoji2.text.r rVar2 = e.f1131o;
            if (objD == rVar2) {
                if (andIncrement < cVar.t()) {
                    kVar.b();
                }
                this = cVar;
                kVar3 = kVar;
            } else {
                if (objD != e.f1130n) {
                    kVar.b();
                    return objD;
                }
                a6.m mVarM = i0.m(b8.h.u(iVar));
                try {
                    Object objD2 = cVar.D(kVar, i9, andIncrement, mVarM);
                    if (objD2 == rVar) {
                        mVarM.b(kVar, i9);
                    } else {
                        if (objD2 == rVar2) {
                            if (andIncrement < cVar.t()) {
                                kVar.b();
                            }
                            k kVar4 = (k) atomicReferenceFieldUpdater.get(cVar);
                            while (true) {
                                if (cVar.v(atomicLongFieldUpdater.get(cVar), true)) {
                                    mVarM.resumeWith(a.a.o(cVar.r()));
                                    break;
                                }
                                a6.m mVar = mVarM;
                                try {
                                    long andIncrement2 = atomicLongFieldUpdater2.getAndIncrement(cVar);
                                    long j9 = e.f1119b;
                                    long j10 = andIncrement2 / j9;
                                    int i10 = (int) (andIncrement2 % j9);
                                    if (kVar4.f2659c != j10) {
                                        try {
                                            k kVarP2 = cVar.p(j10, kVar4);
                                            if (kVarP2 == null) {
                                                mVarM = mVar;
                                            } else {
                                                kVar2 = kVarP2;
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            mVarM = mVar;
                                            mVarM.A();
                                            throw th;
                                        }
                                    } else {
                                        kVar2 = kVar4;
                                    }
                                    c cVar2 = cVar;
                                    objD2 = cVar2.D(kVar2, i10, andIncrement2, mVar);
                                    cVar = cVar2;
                                    k kVar5 = kVar2;
                                    mVarM = mVar;
                                    if (objD2 == e.f1129m) {
                                        mVarM.b(kVar5, i10);
                                        break;
                                    }
                                    if (objD2 == e.f1131o) {
                                        if (andIncrement2 < cVar.t()) {
                                            kVar5.b();
                                        }
                                        kVar4 = kVar5;
                                    } else {
                                        if (objD2 == e.f1130n) {
                                            throw new IllegalStateException("unexpected");
                                        }
                                        kVar5.b();
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    mVarM = mVar;
                                    th = th;
                                    mVarM.A();
                                    throw th;
                                }
                            }
                        } else {
                            kVar.b();
                        }
                        mVarM.h(objD2, null);
                    }
                    Object objS = mVarM.s();
                    g5.a aVar = g5.a.f2984a;
                    return objS;
                } catch (Throwable th4) {
                    th = th4;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:85:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x014f A[RETURN] */
    @Override // c6.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object d(f5.c r23, java.lang.Object r24) throws a6.o0 {
        /*
            Method dump skipped, instructions count: 361
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c6.c.d(f5.c, java.lang.Object):java.lang.Object");
    }

    @Override // c6.q
    public final void e(CancellationException cancellationException) throws o0 {
        if (cancellationException == null) {
            cancellationException = new CancellationException("Channel was cancelled");
        }
        j(cancellationException, true);
    }

    @Override // c6.r
    public final boolean f(Throwable th) throws o0 {
        return j(th, false);
    }

    public final boolean h(long j4) {
        return j4 < d.get(this) || j4 < f1109c.get(this) + ((long) this.f1116a);
    }

    @Override // c6.q
    public final Object i() {
        k kVar;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f1109c;
        long j4 = atomicLongFieldUpdater.get(this);
        AtomicLongFieldUpdater atomicLongFieldUpdater2 = f1108b;
        long j8 = atomicLongFieldUpdater2.get(this);
        if (v(j8, true)) {
            return new h(q());
        }
        long j9 = j8 & 1152921504606846975L;
        i iVar = j.f1140a;
        if (j4 >= j9) {
            return iVar;
        }
        Object obj = e.f1127k;
        k kVar2 = (k) f1112g.get(this);
        while (!this.v(atomicLongFieldUpdater2.get(this), true)) {
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(this);
            long j10 = e.f1119b;
            long j11 = andIncrement / j10;
            int i8 = (int) (andIncrement % j10);
            if (kVar2.f2659c != j11) {
                k kVarP = this.p(j11, kVar2);
                if (kVarP == null) {
                    continue;
                } else {
                    kVar = kVarP;
                }
            } else {
                kVar = kVar2;
            }
            c cVar = this;
            Object objD = cVar.D(kVar, i8, andIncrement, obj);
            kVar2 = kVar;
            if (objD == e.f1129m) {
                g2 g2Var = obj instanceof g2 ? (g2) obj : null;
                if (g2Var != null) {
                    g2Var.b(kVar2, i8);
                }
                cVar.F(andIncrement);
                kVar2.i();
                return iVar;
            }
            if (objD != e.f1131o) {
                if (objD == e.f1130n) {
                    throw new IllegalStateException("unexpected");
                }
                kVar2.b();
                return objD;
            }
            if (andIncrement < cVar.t()) {
                kVar2.b();
            }
            this = cVar;
        }
        return new h(this.q());
    }

    @Override // c6.q
    public final b iterator() {
        return new b(this);
    }

    public final boolean j(Throwable th, boolean z) throws o0 {
        c cVar;
        boolean z2;
        long j4;
        long j8;
        long j9;
        Object obj;
        long j10;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f1108b;
        if (z) {
            while (true) {
                long j11 = atomicLongFieldUpdater.get(this);
                if (((int) (j11 >> 60)) != 0) {
                    break;
                }
                k kVar = e.f1118a;
                cVar = this;
                if (atomicLongFieldUpdater.compareAndSet(cVar, j11, (j11 & 1152921504606846975L) + (1 << 60))) {
                    break;
                }
                this = cVar;
            }
        } else {
            cVar = this;
        }
        androidx.emoji2.text.r rVar = e.f1135s;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1114j;
            if (atomicReferenceFieldUpdater.compareAndSet(cVar, rVar, th)) {
                z2 = true;
                break;
            }
            if (atomicReferenceFieldUpdater.get(cVar) != rVar) {
                z2 = false;
                break;
            }
        }
        if (z) {
            do {
                j10 = atomicLongFieldUpdater.get(cVar);
            } while (!atomicLongFieldUpdater.compareAndSet(cVar, j10, (3 << 60) + (j10 & 1152921504606846975L)));
        } else {
            do {
                j4 = atomicLongFieldUpdater.get(cVar);
                int i8 = (int) (j4 >> 60);
                if (i8 == 0) {
                    j8 = j4 & 1152921504606846975L;
                    j9 = 2;
                } else {
                    if (i8 != 1) {
                        break;
                    }
                    j8 = j4 & 1152921504606846975L;
                    j9 = 3;
                }
            } while (!atomicLongFieldUpdater.compareAndSet(cVar, j4, (j9 << 60) + j8));
        }
        cVar.m();
        if (z2) {
            loop3: while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f1115k;
                obj = atomicReferenceFieldUpdater2.get(cVar);
                androidx.emoji2.text.r rVar2 = obj == null ? e.f1133q : e.f1134r;
                while (!atomicReferenceFieldUpdater2.compareAndSet(cVar, obj, rVar2)) {
                    if (atomicReferenceFieldUpdater2.get(cVar) != obj) {
                        break;
                    }
                }
            }
            if (obj != null) {
                d0.a(1, obj);
                ((p5.l) obj).invoke(cVar.q());
                return z2;
            }
        }
        return z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00be A[SYNTHETIC] */
    @Override // c6.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object k(java.lang.Object r16) throws a6.o0 {
        /*
            r15 = this;
            java.util.concurrent.atomic.AtomicLongFieldUpdater r8 = c6.c.f1108b
            long r1 = r8.get(r15)
            r9 = 0
            boolean r3 = r15.v(r1, r9)
            r10 = 1
            r11 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            if (r3 == 0) goto L15
            r1 = r9
            goto L1b
        L15:
            long r1 = r1 & r11
            boolean r1 = r15.h(r1)
            r1 = r1 ^ r10
        L1b:
            c6.i r13 = c6.j.f1140a
            if (r1 == 0) goto L20
            return r13
        L20:
            androidx.emoji2.text.r r6 = c6.e.f1126j
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = c6.c.f1111f
            java.lang.Object r1 = r1.get(r15)
            c6.k r1 = (c6.k) r1
        L2a:
            long r2 = r8.getAndIncrement(r15)
            long r4 = r2 & r11
            boolean r7 = r15.v(r2, r9)
            int r14 = c6.e.f1119b
            long r2 = (long) r14
            long r11 = r4 / r2
            long r2 = r4 % r2
            int r2 = (int) r2
            long r9 = r1.f2659c
            int r3 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r3 == 0) goto L5d
            c6.k r3 = a(r15, r11, r1)
            if (r3 != 0) goto L5c
            if (r7 == 0) goto L54
            java.lang.Throwable r0 = r15.s()
            c6.h r1 = new c6.h
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
            int r9 = g(r0, r1, r2, r3, r4, r6, r7)
            b5.a0 r3 = b5.a0.f883a
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
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = c6.c.f1109c
            long r2 = r2.get(r15)
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 >= 0) goto L8a
            r1.b()
        L8a:
            java.lang.Throwable r0 = r15.s()
            c6.h r1 = new c6.h
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
            java.lang.Throwable r0 = r15.s()
            c6.h r1 = new c6.h
            r1.<init>(r0)
            return r1
        Lab:
            boolean r0 = r6 instanceof a6.g2
            if (r0 == 0) goto Lb2
            a6.g2 r6 = (a6.g2) r6
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
        throw new UnsupportedOperationException("Method not decompiled: c6.c.k(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x008d, code lost:
    
        r1 = (c6.k) ((f6.b) f6.b.f2634b.get(r1));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final c6.k l(long r13) throws a6.o0 {
        /*
            Method dump skipped, instructions count: 306
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c6.c.l(long):c6.k");
    }

    public final void m() throws o0 {
        v(f1108b.get(this), false);
    }

    public final void n(long j4) {
        k kVar = (k) f1112g.get(this);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f1109c;
            long j8 = atomicLongFieldUpdater.get(this);
            if (j4 < Math.max(this.f1116a + j8, d.get(this))) {
                return;
            }
            c cVar = this;
            if (atomicLongFieldUpdater.compareAndSet(cVar, j8, 1 + j8)) {
                long j9 = e.f1119b;
                long j10 = j8 / j9;
                int i8 = (int) (j8 % j9);
                if (kVar.f2659c != j10) {
                    k kVarP = cVar.p(j10, kVar);
                    if (kVarP != null) {
                        kVar = kVarP;
                    }
                }
                k kVar2 = kVar;
                if (cVar.D(kVar2, i8, j8, null) != e.f1131o || j8 < cVar.t()) {
                    kVar2.b();
                }
                this = cVar;
                kVar = kVar2;
            }
            this = cVar;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x018e, code lost:
    
        u(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0191, code lost:
    
        return;
     */
    /* JADX WARN: Failed to analyze thrown exceptions
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$Itr.checkForComodification(Unknown Source)
    	at java.base/java.util.ArrayList$Itr.next(Unknown Source)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:118)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:179)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:132)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:179)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:132)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:179)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:132)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:179)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:132)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:179)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:132)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:179)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:132)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:179)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:132)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:179)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:132)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void o() {
        /*
            Method dump skipped, instructions count: 402
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c6.c.o():void");
    }

    public final k p(long j4, k kVar) {
        Object objB;
        c cVar;
        k kVar2 = e.f1118a;
        d dVar = d.f1117a;
        loop0: while (true) {
            objB = f6.a.b(kVar, j4, dVar);
            if (!f6.a.e(objB)) {
                f6.q qVarC = f6.a.c(objB);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1112g;
                    f6.q qVar = (f6.q) atomicReferenceFieldUpdater.get(this);
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
        if (f6.a.e(objB)) {
            m();
            if (kVar.f2659c * e.f1119b < t()) {
                kVar.b();
                return null;
            }
        } else {
            k kVar3 = (k) f6.a.c(objB);
            long j8 = kVar3.f2659c;
            if (!x() && j4 <= d.get(this) / e.f1119b) {
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f1113h;
                    f6.q qVar2 = (f6.q) atomicReferenceFieldUpdater2.get(this);
                    if (qVar2.f2659c >= j8 || !kVar3.j()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater2.compareAndSet(this, qVar2, kVar3)) {
                        if (atomicReferenceFieldUpdater2.get(this) != qVar2) {
                            if (kVar3.f()) {
                                kVar3.e();
                            }
                        }
                    }
                    if (qVar2.f()) {
                        qVar2.e();
                    }
                }
            }
            if (j8 <= j4) {
                return kVar3;
            }
            long j9 = j8 * e.f1119b;
            while (true) {
                long j10 = f1109c.get(this);
                if (j10 >= j9) {
                    cVar = this;
                    break;
                }
                cVar = this;
                if (f1109c.compareAndSet(cVar, j10, j9)) {
                    break;
                }
                this = cVar;
            }
            if (j8 * e.f1119b < cVar.t()) {
                kVar3.b();
            }
        }
        return null;
    }

    public final Throwable q() {
        return (Throwable) f1114j.get(this);
    }

    public final Throwable r() {
        Throwable thQ = q();
        return thQ == null ? new l("Channel was closed") : thQ;
    }

    public final Throwable s() {
        Throwable thQ = q();
        return thQ == null ? new m("Channel was closed", 0) : thQ;
    }

    public final long t() {
        return f1108b.get(this) & 1152921504606846975L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x018b, code lost:
    
        r3 = (c6.k) r3.c();
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0192, code lost:
    
        if (r3 != null) goto L77;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String toString() {
        /*
            Method dump skipped, instructions count: 443
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c6.c.toString():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x00a2, code lost:
    
        r0 = (c6.k) ((f6.b) f6.b.f2634b.get(r0));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean v(long r14, boolean r16) throws a6.o0 {
        /*
            Method dump skipped, instructions count: 368
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c6.c.v(long, boolean):boolean");
    }

    public boolean w() {
        return false;
    }

    public final boolean x() {
        long j4 = d.get(this);
        return j4 == 0 || j4 == Util.VLI_MAX;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0011, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void y(long r5, c6.k r7) {
        /*
            r4 = this;
        L0:
            long r0 = r7.f2659c
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 >= 0) goto L11
            f6.b r0 = r7.c()
            c6.k r0 = (c6.k) r0
            if (r0 != 0) goto Lf
            goto L11
        Lf:
            r7 = r0
            goto L0
        L11:
            boolean r5 = r7.d()
            if (r5 == 0) goto L22
            f6.b r5 = r7.c()
            c6.k r5 = (c6.k) r5
            if (r5 != 0) goto L20
            goto L22
        L20:
            r7 = r5
            goto L11
        L22:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = c6.c.f1113h
            java.lang.Object r6 = r5.get(r4)
            f6.q r6 = (f6.q) r6
            long r0 = r6.f2659c
            long r2 = r7.f2659c
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
        throw new UnsupportedOperationException("Method not decompiled: c6.c.y(long, c6.k):void");
    }

    public final Object z(f5.c cVar, Object obj) throws o0 {
        a6.m mVar = new a6.m(1, b8.h.u(cVar));
        mVar.t();
        mVar.resumeWith(a.a.o(s()));
        Object objS = mVar.s();
        return objS == g5.a.f2984a ? objS : a0.f883a;
    }
}

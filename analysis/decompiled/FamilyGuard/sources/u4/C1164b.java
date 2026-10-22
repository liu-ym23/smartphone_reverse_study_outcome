package u4;

import V3.n;
import V3.o;
import V3.v;
import a4.C0428b;
import i4.InterfaceC0772l;
import i4.p;
import i4.q;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import s4.C1082l;
import s4.C1086n;
import s4.InterfaceC1080k;
import s4.L0;
import x4.AbstractC1291C;
import x4.AbstractC1304d;
import x4.C1292D;
import x4.C1293E;
import x4.C1303c;
import x4.C1312l;
import x4.O;
import x4.x;

/* renamed from: u4.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1164b<E> implements InterfaceC1166d<E> {

    /* renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f22919e = AtomicLongFieldUpdater.newUpdater(C1164b.class, "sendersAndCloseStatus$volatile");

    /* renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f22920f = AtomicLongFieldUpdater.newUpdater(C1164b.class, "receivers$volatile");

    /* renamed from: g, reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f22921g = AtomicLongFieldUpdater.newUpdater(C1164b.class, "bufferEnd$volatile");

    /* renamed from: h, reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f22922h = AtomicLongFieldUpdater.newUpdater(C1164b.class, "completedExpandBuffersAndPauseFlag$volatile");

    /* renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f22923i = AtomicReferenceFieldUpdater.newUpdater(C1164b.class, Object.class, "sendSegment$volatile");

    /* renamed from: j, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f22924j = AtomicReferenceFieldUpdater.newUpdater(C1164b.class, Object.class, "receiveSegment$volatile");

    /* renamed from: k, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f22925k = AtomicReferenceFieldUpdater.newUpdater(C1164b.class, Object.class, "bufferEndSegment$volatile");

    /* renamed from: l, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f22926l = AtomicReferenceFieldUpdater.newUpdater(C1164b.class, Object.class, "_closeCause$volatile");

    /* renamed from: m, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f22927m = AtomicReferenceFieldUpdater.newUpdater(C1164b.class, Object.class, "closeHandler$volatile");
    private volatile /* synthetic */ Object _closeCause$volatile;

    /* renamed from: b, reason: collision with root package name */
    private final int f22928b;
    private volatile /* synthetic */ long bufferEnd$volatile;
    private volatile /* synthetic */ Object bufferEndSegment$volatile;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC0772l<E, v> f22929c;
    private volatile /* synthetic */ Object closeHandler$volatile;
    private volatile /* synthetic */ long completedExpandBuffersAndPauseFlag$volatile;

    /* renamed from: d, reason: collision with root package name */
    private final q<A4.b<?>, Object, Object, InterfaceC0772l<Throwable, v>> f22930d;
    private volatile /* synthetic */ Object receiveSegment$volatile;
    private volatile /* synthetic */ long receivers$volatile;
    private volatile /* synthetic */ Object sendSegment$volatile;
    private volatile /* synthetic */ long sendersAndCloseStatus$volatile;

    /* renamed from: u4.b$a */
    private final class a implements L0 {

        /* renamed from: a, reason: collision with root package name */
        private Object f22931a;

        /* renamed from: b, reason: collision with root package name */
        private C1082l<? super Boolean> f22932b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ C1164b<E> f22933c;

        public final boolean a(E e6) {
            C1082l<? super Boolean> c1082l = this.f22932b;
            j4.k.d(c1082l);
            this.f22932b = null;
            this.f22931a = e6;
            Boolean bool = Boolean.TRUE;
            InterfaceC0772l<E, v> interfaceC0772l = this.f22933c.f22929c;
            return C1165c.A(c1082l, bool, interfaceC0772l != null ? x.a(interfaceC0772l, e6, c1082l.getContext()) : null);
        }

        public final void b() {
            C1082l<? super Boolean> c1082l = this.f22932b;
            j4.k.d(c1082l);
            this.f22932b = null;
            this.f22931a = C1165c.y();
            Throwable thF = this.f22933c.F();
            if (thF == null) {
                n.a aVar = V3.n.f5531a;
                c1082l.resumeWith(V3.n.a(Boolean.FALSE));
            } else {
                n.a aVar2 = V3.n.f5531a;
                c1082l.resumeWith(V3.n.a(o.a(thF)));
            }
        }

        @Override // s4.L0
        public void c(AbstractC1291C<?> abstractC1291C, int i5) {
            C1082l<? super Boolean> c1082l = this.f22932b;
            if (c1082l != null) {
                c1082l.c(abstractC1291C, i5);
            }
        }
    }

    /* renamed from: u4.b$b, reason: collision with other inner class name */
    private static final class C0251b implements L0 {

        /* renamed from: a, reason: collision with root package name */
        private final InterfaceC1080k<Boolean> f22934a;

        /* renamed from: b, reason: collision with root package name */
        private final /* synthetic */ C1082l<Boolean> f22935b;

        public final InterfaceC1080k<Boolean> a() {
            return this.f22934a;
        }

        @Override // s4.L0
        public void c(AbstractC1291C<?> abstractC1291C, int i5) {
            this.f22935b.c(abstractC1291C, i5);
        }
    }

    /* renamed from: u4.b$c */
    static final class c extends j4.l implements q<A4.b<?>, Object, Object, InterfaceC0772l<? super Throwable, ? extends v>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ C1164b<E> f22936a;

        /* renamed from: u4.b$c$a */
        static final class a extends j4.l implements InterfaceC0772l<Throwable, v> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Object f22937a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ C1164b<E> f22938b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ A4.b<?> f22939c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Object obj, C1164b<E> c1164b, A4.b<?> bVar) {
                super(1);
                this.f22937a = obj;
                this.f22938b = c1164b;
                this.f22939c = bVar;
            }

            public final void b(Throwable th) {
                if (this.f22937a != C1165c.y()) {
                    x.b(this.f22938b.f22929c, this.f22937a, this.f22939c.getContext());
                }
            }

            @Override // i4.InterfaceC0772l
            public /* bridge */ /* synthetic */ v invoke(Throwable th) {
                b(th);
                return v.f5542a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(C1164b<E> c1164b) {
            super(3);
            this.f22936a = c1164b;
        }

        @Override // i4.q
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final InterfaceC0772l<Throwable, v> a(A4.b<?> bVar, Object obj, Object obj2) {
            return new a(obj2, this.f22936a, bVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C1164b(int i5, InterfaceC0772l<? super E, v> interfaceC0772l) {
        this.f22928b = i5;
        this.f22929c = interfaceC0772l;
        if (i5 < 0) {
            throw new IllegalArgumentException(("Invalid channel capacity: " + i5 + ", should be >=0").toString());
        }
        this.bufferEnd$volatile = C1165c.z(i5);
        this.completedExpandBuffersAndPauseFlag$volatile = D();
        C1169g c1169g = new C1169g(0L, null, this, 3);
        this.sendSegment$volatile = c1169g;
        this.receiveSegment$volatile = c1169g;
        if (c0()) {
            c1169g = C1165c.f22940a;
            j4.k.e(c1169g, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
        }
        this.bufferEndSegment$volatile = c1169g;
        this.f22930d = interfaceC0772l != 0 ? new c(this) : null;
        this._closeCause$volatile = C1165c.f22958s;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C1169g<E> A(long j5, C1169g<E> c1169g) {
        Object objC;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f22924j;
        p pVar = (p) C1165c.x();
        loop0: while (true) {
            objC = C1303c.c(c1169g, j5, pVar);
            if (!C1292D.c(objC)) {
                AbstractC1291C abstractC1291CB = C1292D.b(objC);
                while (true) {
                    AbstractC1291C abstractC1291C = (AbstractC1291C) atomicReferenceFieldUpdater.get(this);
                    if (abstractC1291C.f23829c >= abstractC1291CB.f23829c) {
                        break loop0;
                    }
                    if (!abstractC1291CB.u()) {
                        break;
                    }
                    if (atomicReferenceFieldUpdater.compareAndSet(this, abstractC1291C, abstractC1291CB)) {
                        if (abstractC1291C.p()) {
                            abstractC1291C.n();
                        }
                    } else if (abstractC1291CB.p()) {
                        abstractC1291CB.n();
                    }
                }
            } else {
                break;
            }
        }
        if (C1292D.c(objC)) {
            w();
            if (c1169g.f23829c * C1165c.f22941b < P()) {
                c1169g.c();
            }
            return null;
        }
        C1169g<E> c1169g2 = (C1169g) C1292D.b(objC);
        if (!c0() && j5 <= D() / C1165c.f22941b) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f22925k;
            while (true) {
                AbstractC1291C abstractC1291C2 = (AbstractC1291C) atomicReferenceFieldUpdater2.get(this);
                if (abstractC1291C2.f23829c >= c1169g2.f23829c || !c1169g2.u()) {
                    break;
                }
                if (atomicReferenceFieldUpdater2.compareAndSet(this, abstractC1291C2, c1169g2)) {
                    if (abstractC1291C2.p()) {
                        abstractC1291C2.n();
                    }
                } else if (c1169g2.p()) {
                    c1169g2.n();
                }
            }
        }
        long j6 = c1169g2.f23829c;
        if (j6 <= j5) {
            return c1169g2;
        }
        int i5 = C1165c.f22941b;
        E0(j6 * i5);
        if (c1169g2.f23829c * i5 < P()) {
            c1169g2.c();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object A0(C1169g<E> c1169g, int i5, long j5, Object obj) {
        Object objB = c1169g.B(i5);
        if (objB == null) {
            if (j5 >= (f22919e.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    return C1165c.f22953n;
                }
                if (c1169g.v(i5, objB, obj)) {
                    y();
                    return C1165c.f22952m;
                }
            }
        } else if (objB == C1165c.f22943d && c1169g.v(i5, objB, C1165c.f22948i)) {
            y();
            return c1169g.D(i5);
        }
        return B0(c1169g, i5, j5, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C1169g<E> B(long j5, C1169g<E> c1169g) {
        Object objC;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f22923i;
        p pVar = (p) C1165c.x();
        loop0: while (true) {
            objC = C1303c.c(c1169g, j5, pVar);
            if (!C1292D.c(objC)) {
                AbstractC1291C abstractC1291CB = C1292D.b(objC);
                while (true) {
                    AbstractC1291C abstractC1291C = (AbstractC1291C) atomicReferenceFieldUpdater.get(this);
                    if (abstractC1291C.f23829c >= abstractC1291CB.f23829c) {
                        break loop0;
                    }
                    if (!abstractC1291CB.u()) {
                        break;
                    }
                    if (atomicReferenceFieldUpdater.compareAndSet(this, abstractC1291C, abstractC1291CB)) {
                        if (abstractC1291C.p()) {
                            abstractC1291C.n();
                        }
                    } else if (abstractC1291CB.p()) {
                        abstractC1291CB.n();
                    }
                }
            } else {
                break;
            }
        }
        if (C1292D.c(objC)) {
            w();
            if (c1169g.f23829c * C1165c.f22941b < L()) {
                c1169g.c();
            }
            return null;
        }
        C1169g<E> c1169g2 = (C1169g) C1292D.b(objC);
        long j6 = c1169g2.f23829c;
        if (j6 <= j5) {
            return c1169g2;
        }
        int i5 = C1165c.f22941b;
        F0(j6 * i5);
        if (c1169g2.f23829c * i5 < L()) {
            c1169g2.c();
        }
        return null;
    }

    private final Object B0(C1169g<E> c1169g, int i5, long j5, Object obj) {
        while (true) {
            Object objB = c1169g.B(i5);
            if (objB == null || objB == C1165c.f22944e) {
                if (j5 < (f22919e.get(this) & 1152921504606846975L)) {
                    if (c1169g.v(i5, objB, C1165c.f22947h)) {
                        y();
                        return C1165c.f22954o;
                    }
                } else {
                    if (obj == null) {
                        return C1165c.f22953n;
                    }
                    if (c1169g.v(i5, objB, obj)) {
                        y();
                        return C1165c.f22952m;
                    }
                }
            } else {
                if (objB != C1165c.f22943d) {
                    if (objB != C1165c.f22949j && objB != C1165c.f22947h) {
                        if (objB == C1165c.y()) {
                            y();
                            return C1165c.f22954o;
                        }
                        if (objB != C1165c.f22946g && c1169g.v(i5, objB, C1165c.f22945f)) {
                            boolean z5 = objB instanceof C1176n;
                            if (z5) {
                                objB = ((C1176n) objB).f22972a;
                            }
                            if (w0(objB, c1169g, i5)) {
                                c1169g.F(i5, C1165c.f22948i);
                                y();
                                return c1169g.D(i5);
                            }
                            c1169g.F(i5, C1165c.f22949j);
                            c1169g.C(i5, false);
                            if (z5) {
                                y();
                            }
                            return C1165c.f22954o;
                        }
                    }
                    return C1165c.f22954o;
                }
                if (c1169g.v(i5, objB, C1165c.f22948i)) {
                    y();
                    return c1169g.D(i5);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int C0(C1169g<E> c1169g, int i5, E e6, long j5, Object obj, boolean z5) {
        c1169g.G(i5, e6);
        if (z5) {
            return D0(c1169g, i5, e6, j5, obj, z5);
        }
        Object objB = c1169g.B(i5);
        if (objB == null) {
            if (q(j5)) {
                if (c1169g.v(i5, null, C1165c.f22943d)) {
                    return 1;
                }
            } else {
                if (obj == null) {
                    return 3;
                }
                if (c1169g.v(i5, null, obj)) {
                    return 2;
                }
            }
        } else if (objB instanceof L0) {
            c1169g.w(i5);
            if (v0(objB, e6)) {
                c1169g.F(i5, C1165c.f22948i);
                k0();
                return 0;
            }
            if (c1169g.x(i5, C1165c.f22950k) == C1165c.f22950k) {
                return 5;
            }
            c1169g.C(i5, true);
            return 5;
        }
        return D0(c1169g, i5, e6, j5, obj, z5);
    }

    private final long D() {
        return f22921g.get(this);
    }

    private final int D0(C1169g<E> c1169g, int i5, E e6, long j5, Object obj, boolean z5) {
        while (true) {
            Object objB = c1169g.B(i5);
            if (objB == null) {
                if (!q(j5) || z5) {
                    if (z5) {
                        if (c1169g.v(i5, null, C1165c.f22949j)) {
                            c1169g.C(i5, false);
                            return 4;
                        }
                    } else {
                        if (obj == null) {
                            return 3;
                        }
                        if (c1169g.v(i5, null, obj)) {
                            return 2;
                        }
                    }
                } else if (c1169g.v(i5, null, C1165c.f22943d)) {
                    return 1;
                }
            } else {
                if (objB != C1165c.f22944e) {
                    if (objB == C1165c.f22950k) {
                        c1169g.w(i5);
                        return 5;
                    }
                    if (objB == C1165c.f22947h) {
                        c1169g.w(i5);
                        return 5;
                    }
                    if (objB == C1165c.y()) {
                        c1169g.w(i5);
                        w();
                        return 4;
                    }
                    c1169g.w(i5);
                    if (objB instanceof C1176n) {
                        objB = ((C1176n) objB).f22972a;
                    }
                    if (v0(objB, e6)) {
                        c1169g.F(i5, C1165c.f22948i);
                        k0();
                        return 0;
                    }
                    if (c1169g.x(i5, C1165c.f22950k) != C1165c.f22950k) {
                        c1169g.C(i5, true);
                    }
                    return 5;
                }
                if (c1169g.v(i5, objB, C1165c.f22943d)) {
                    return 1;
                }
            }
        }
    }

    private final void E0(long j5) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f22920f;
        while (true) {
            long j6 = atomicLongFieldUpdater.get(this);
            if (j6 >= j5) {
                return;
            }
            C1164b<E> c1164b = this;
            long j7 = j5;
            if (f22920f.compareAndSet(c1164b, j6, j7)) {
                return;
            }
            this = c1164b;
            j5 = j7;
        }
    }

    private final void F0(long j5) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f22919e;
        while (true) {
            long j6 = atomicLongFieldUpdater.get(this);
            long j7 = 1152921504606846975L & j6;
            if (j7 >= j5) {
                return;
            }
            C1164b<E> c1164b = this;
            if (f22919e.compareAndSet(c1164b, j6, C1165c.v(j7, (int) (j6 >> 60)))) {
                return;
            } else {
                this = c1164b;
            }
        }
    }

    private final Throwable I() {
        Throwable thF = F();
        return thF == null ? new C1170h("Channel was closed") : thF;
    }

    private final void S(long j5) {
        if ((f22922h.addAndGet(this, j5) & 4611686018427387904L) != 0) {
            while ((f22922h.get(this) & 4611686018427387904L) != 0) {
            }
        }
    }

    static /* synthetic */ void T(C1164b c1164b, long j5, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incCompletedExpandBufferAttempts");
        }
        if ((i5 & 1) != 0) {
            j5 = 1;
        }
        c1164b.S(j5);
    }

    private final void U() {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f22927m;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
        } while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, obj == null ? C1165c.f22956q : C1165c.f22957r));
        if (obj == null) {
            return;
        }
        ((InterfaceC0772l) obj).invoke(F());
    }

    private final boolean V(C1169g<E> c1169g, int i5, long j5) {
        Object objB;
        do {
            objB = c1169g.B(i5);
            if (objB != null && objB != C1165c.f22944e) {
                if (objB == C1165c.f22943d) {
                    return true;
                }
                if (objB == C1165c.f22949j || objB == C1165c.y() || objB == C1165c.f22948i || objB == C1165c.f22947h) {
                    return false;
                }
                if (objB == C1165c.f22946g) {
                    return true;
                }
                return objB != C1165c.f22945f && j5 == L();
            }
        } while (!c1169g.v(i5, objB, C1165c.f22947h));
        y();
        return false;
    }

    private final boolean W(long j5, boolean z5) {
        int i5 = (int) (j5 >> 60);
        if (i5 == 0 || i5 == 1) {
            return false;
        }
        if (i5 == 2) {
            v(j5 & 1152921504606846975L);
            return (z5 && R()) ? false : true;
        }
        if (i5 == 3) {
            u(j5 & 1152921504606846975L);
            return true;
        }
        throw new IllegalStateException(("unexpected close status: " + i5).toString());
    }

    private final boolean Y(long j5) {
        return W(j5, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean a0(long j5) {
        return W(j5, false);
    }

    private final boolean c0() {
        long jD = D();
        return jD == 0 || jD == Long.MAX_VALUE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003c, code lost:
    
        r8 = (u4.C1169g) r8.h();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final long d0(u4.C1169g<E> r8) {
        /*
            r7 = this;
        L0:
            int r0 = u4.C1165c.f22941b
            int r0 = r0 + (-1)
        L4:
            r1 = -1
            r3 = -1
            if (r3 >= r0) goto L3c
            long r3 = r8.f23829c
            int r5 = u4.C1165c.f22941b
            long r5 = (long) r5
            long r3 = r3 * r5
            long r5 = (long) r0
            long r3 = r3 + r5
            long r5 = r7.L()
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 >= 0) goto L1a
            return r1
        L1a:
            java.lang.Object r1 = r8.B(r0)
            if (r1 == 0) goto L2c
            x4.F r2 = u4.C1165c.k()
            if (r1 != r2) goto L27
            goto L2c
        L27:
            x4.F r2 = u4.C1165c.f22943d
            if (r1 != r2) goto L39
            return r3
        L2c:
            x4.F r2 = u4.C1165c.y()
            boolean r1 = r8.v(r0, r1, r2)
            if (r1 == 0) goto L1a
            r8.t()
        L39:
            int r0 = r0 + (-1)
            goto L4
        L3c:
            x4.d r8 = r8.h()
            u4.g r8 = (u4.C1169g) r8
            if (r8 != 0) goto L0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: u4.C1164b.d0(u4.g):long");
    }

    private final void e0() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f22919e;
        while (true) {
            long j5 = atomicLongFieldUpdater.get(this);
            if (((int) (j5 >> 60)) != 0) {
                return;
            }
            C1164b<E> c1164b = this;
            if (atomicLongFieldUpdater.compareAndSet(c1164b, j5, C1165c.v(1152921504606846975L & j5, 1))) {
                return;
            } else {
                this = c1164b;
            }
        }
    }

    private final void f0() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f22919e;
        while (true) {
            long j5 = atomicLongFieldUpdater.get(this);
            C1164b<E> c1164b = this;
            if (atomicLongFieldUpdater.compareAndSet(c1164b, j5, C1165c.v(1152921504606846975L & j5, 3))) {
                return;
            } else {
                this = c1164b;
            }
        }
    }

    private final void g0() {
        long jV;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f22919e;
        while (true) {
            long j5 = atomicLongFieldUpdater.get(this);
            int i5 = (int) (j5 >> 60);
            if (i5 == 0) {
                jV = C1165c.v(1152921504606846975L & j5, 2);
            } else if (i5 != 1) {
                return;
            } else {
                jV = C1165c.v(1152921504606846975L & j5, 3);
            }
            C1164b<E> c1164b = this;
            if (atomicLongFieldUpdater.compareAndSet(c1164b, j5, jV)) {
                return;
            } else {
                this = c1164b;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0011, code lost:
    
        continue;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void h0(long r5, u4.C1169g<E> r7) {
        /*
            r4 = this;
        L0:
            long r0 = r7.f23829c
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 >= 0) goto L11
            x4.d r0 = r7.f()
            u4.g r0 = (u4.C1169g) r0
            if (r0 != 0) goto Lf
            goto L11
        Lf:
            r7 = r0
            goto L0
        L11:
            boolean r5 = r7.k()
            if (r5 == 0) goto L22
            x4.d r5 = r7.f()
            u4.g r5 = (u4.C1169g) r5
            if (r5 != 0) goto L20
            goto L22
        L20:
            r7 = r5
            goto L11
        L22:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = E()
        L26:
            java.lang.Object r6 = r5.get(r4)
            x4.C r6 = (x4.AbstractC1291C) r6
            long r0 = r6.f23829c
            long r2 = r7.f23829c
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 < 0) goto L35
            return
        L35:
            boolean r0 = r7.u()
            if (r0 != 0) goto L3c
            goto L11
        L3c:
            boolean r0 = r5.compareAndSet(r4, r6, r7)
            if (r0 == 0) goto L4c
            boolean r4 = r6.p()
            if (r4 == 0) goto L4b
            r6.n()
        L4b:
            return
        L4c:
            boolean r6 = r7.p()
            if (r6 == 0) goto L26
            r7.n()
            goto L26
        */
        throw new UnsupportedOperationException("Method not decompiled: u4.C1164b.h0(long, u4.g):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j0(InterfaceC1080k<? super E> interfaceC1080k) {
        n.a aVar = V3.n.f5531a;
        interfaceC1080k.resumeWith(V3.n.a(o.a(I())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m0(L0 l02, C1169g<E> c1169g, int i5) {
        l0();
        l02.c(c1169g, i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n0(L0 l02, C1169g<E> c1169g, int i5) {
        l02.c(c1169g, i5 + C1165c.f22941b);
    }

    static /* synthetic */ <E> Object o0(C1164b<E> c1164b, Z3.e<? super E> eVar) throws Throwable {
        C1169g<E> c1169g;
        C1169g<E> c1169g2 = (C1169g) f22924j.get(c1164b);
        while (!c1164b.X()) {
            long andIncrement = f22920f.getAndIncrement(c1164b);
            int i5 = C1165c.f22941b;
            long j5 = andIncrement / i5;
            int i6 = (int) (andIncrement % i5);
            if (c1169g2.f23829c != j5) {
                C1169g<E> c1169gA = c1164b.A(j5, c1169g2);
                if (c1169gA == null) {
                    continue;
                } else {
                    c1169g = c1169gA;
                }
            } else {
                c1169g = c1169g2;
            }
            C1164b<E> c1164b2 = c1164b;
            Object objA0 = c1164b2.A0(c1169g, i6, andIncrement, null);
            if (objA0 == C1165c.f22952m) {
                throw new IllegalStateException("unexpected");
            }
            if (objA0 != C1165c.f22954o) {
                if (objA0 == C1165c.f22953n) {
                    return c1164b2.p0(c1169g, i6, andIncrement, eVar);
                }
                c1169g.c();
                return objA0;
            }
            if (andIncrement < c1164b2.P()) {
                c1169g.c();
            }
            c1164b = c1164b2;
            c1169g2 = c1169g;
        }
        throw C1293E.a(c1164b.I());
    }

    private final Object p0(C1169g<E> c1169g, int i5, long j5, Z3.e<? super E> eVar) {
        C1169g c1169g2;
        C1082l c1082lB = C1086n.b(C0428b.c(eVar));
        try {
            Object objA0 = A0(c1169g, i5, j5, c1082lB);
            if (objA0 == C1165c.f22952m) {
                m0(c1082lB, c1169g, i5);
            } else {
                InterfaceC0772l<Throwable, v> interfaceC0772lA = null;
                interfaceC0772lA = null;
                if (objA0 == C1165c.f22954o) {
                    if (j5 < P()) {
                        c1169g.c();
                    }
                    C1169g c1169g3 = (C1169g) f22924j.get(this);
                    while (true) {
                        if (X()) {
                            j0(c1082lB);
                            break;
                        }
                        long andIncrement = f22920f.getAndIncrement(this);
                        int i6 = C1165c.f22941b;
                        long j6 = andIncrement / i6;
                        int i7 = (int) (andIncrement % i6);
                        if (c1169g3.f23829c != j6) {
                            C1169g c1169gA = A(j6, c1169g3);
                            if (c1169gA != null) {
                                c1169g2 = c1169gA;
                            }
                        } else {
                            c1169g2 = c1169g3;
                        }
                        objA0 = A0(c1169g2, i7, andIncrement, c1082lB);
                        C1169g c1169g4 = c1169g2;
                        if (objA0 == C1165c.f22952m) {
                            C1082l c1082l = c1082lB != null ? c1082lB : null;
                            if (c1082l != null) {
                                m0(c1082l, c1169g4, i7);
                            }
                        } else if (objA0 == C1165c.f22954o) {
                            if (andIncrement < P()) {
                                c1169g4.c();
                            }
                            c1169g3 = c1169g4;
                        } else {
                            if (objA0 == C1165c.f22953n) {
                                throw new IllegalStateException("unexpected");
                            }
                            c1169g4.c();
                            InterfaceC0772l<E, v> interfaceC0772l = this.f22929c;
                            if (interfaceC0772l != null) {
                                interfaceC0772lA = x.a(interfaceC0772l, objA0, c1082lB.getContext());
                            }
                        }
                    }
                } else {
                    c1169g.c();
                    InterfaceC0772l<E, v> interfaceC0772l2 = this.f22929c;
                    if (interfaceC0772l2 != null) {
                        interfaceC0772lA = x.a(interfaceC0772l2, objA0, c1082lB.getContext());
                    }
                }
                c1082lB.b(objA0, interfaceC0772lA);
            }
            Object objX = c1082lB.x();
            if (objX == C0428b.e()) {
                kotlin.coroutines.jvm.internal.h.c(eVar);
            }
            return objX;
        } catch (Throwable th) {
            c1082lB.M();
            throw th;
        }
    }

    private final boolean q(long j5) {
        return j5 < D() || j5 < L() + ((long) this.f22928b);
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00b3, code lost:
    
        r12 = (u4.C1169g) r12.h();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void q0(u4.C1169g<E> r12) {
        /*
            r11 = this;
            i4.l<E, V3.v> r0 = r11.f22929c
            r1 = 0
            r2 = 1
            java.lang.Object r3 = x4.C1312l.b(r1, r2, r1)
        L8:
            int r4 = u4.C1165c.f22941b
            int r4 = r4 - r2
        Lb:
            r5 = -1
            if (r5 >= r4) goto Lb3
            long r6 = r12.f23829c
            int r8 = u4.C1165c.f22941b
            long r8 = (long) r8
            long r6 = r6 * r8
            long r8 = (long) r4
            long r6 = r6 + r8
        L16:
            java.lang.Object r8 = r12.B(r4)
            x4.F r9 = u4.C1165c.f()
            if (r8 == r9) goto Lbb
            x4.F r9 = u4.C1165c.f22943d
            if (r8 != r9) goto L48
            long r9 = r11.L()
            int r9 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r9 < 0) goto Lbb
            x4.F r9 = u4.C1165c.y()
            boolean r8 = r12.v(r4, r8, r9)
            if (r8 == 0) goto L16
            if (r0 == 0) goto L40
            java.lang.Object r5 = r12.A(r4)
            x4.O r1 = x4.x.c(r0, r5, r1)
        L40:
            r12.w(r4)
            r12.t()
            goto Laf
        L48:
            x4.F r9 = u4.C1165c.k()
            if (r8 == r9) goto La2
            if (r8 != 0) goto L51
            goto La2
        L51:
            boolean r9 = r8 instanceof s4.L0
            if (r9 != 0) goto L6e
            boolean r9 = r8 instanceof u4.C1176n
            if (r9 == 0) goto L5a
            goto L6e
        L5a:
            x4.F r9 = u4.C1165c.o()
            if (r8 == r9) goto Lbb
            x4.F r9 = u4.C1165c.p()
            if (r8 != r9) goto L67
            goto Lbb
        L67:
            x4.F r9 = u4.C1165c.o()
            if (r8 == r9) goto L16
            goto Laf
        L6e:
            long r9 = r11.L()
            int r9 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r9 < 0) goto Lbb
            boolean r9 = r8 instanceof u4.C1176n
            if (r9 == 0) goto L80
            r9 = r8
            u4.n r9 = (u4.C1176n) r9
            s4.L0 r9 = r9.f22972a
            goto L83
        L80:
            r9 = r8
            s4.L0 r9 = (s4.L0) r9
        L83:
            x4.F r10 = u4.C1165c.y()
            boolean r8 = r12.v(r4, r8, r10)
            if (r8 == 0) goto L16
            if (r0 == 0) goto L97
            java.lang.Object r5 = r12.A(r4)
            x4.O r1 = x4.x.c(r0, r5, r1)
        L97:
            java.lang.Object r3 = x4.C1312l.c(r3, r9)
            r12.w(r4)
            r12.t()
            goto Laf
        La2:
            x4.F r9 = u4.C1165c.y()
            boolean r8 = r12.v(r4, r8, r9)
            if (r8 == 0) goto L16
            r12.t()
        Laf:
            int r4 = r4 + (-1)
            goto Lb
        Lb3:
            x4.d r12 = r12.h()
            u4.g r12 = (u4.C1169g) r12
            if (r12 != 0) goto L8
        Lbb:
            if (r3 == 0) goto Le1
            boolean r12 = r3 instanceof java.util.ArrayList
            if (r12 != 0) goto Lc7
            s4.L0 r3 = (s4.L0) r3
            r11.s0(r3)
            goto Le1
        Lc7:
            java.lang.String r12 = "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }"
            j4.k.e(r3, r12)
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            int r12 = r3.size()
            int r12 = r12 - r2
        Ld3:
            if (r5 >= r12) goto Le1
            java.lang.Object r0 = r3.get(r12)
            s4.L0 r0 = (s4.L0) r0
            r11.s0(r0)
            int r12 = r12 + (-1)
            goto Ld3
        Le1:
            if (r1 != 0) goto Le4
            return
        Le4:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: u4.C1164b.q0(u4.g):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void r(C1169g<E> c1169g, long j5) {
        Object objB = C1312l.b(null, 1, null);
        loop0: while (c1169g != null) {
            for (int i5 = C1165c.f22941b - 1; -1 < i5; i5--) {
                if ((c1169g.f23829c * C1165c.f22941b) + i5 < j5) {
                    break loop0;
                }
                while (true) {
                    Object objB2 = c1169g.B(i5);
                    if (objB2 != null && objB2 != C1165c.f22944e) {
                        if (!(objB2 instanceof C1176n)) {
                            if (!(objB2 instanceof L0)) {
                                break;
                            }
                            if (c1169g.v(i5, objB2, C1165c.y())) {
                                objB = C1312l.c(objB, objB2);
                                c1169g.C(i5, true);
                                break;
                            }
                        } else {
                            if (c1169g.v(i5, objB2, C1165c.y())) {
                                objB = C1312l.c(objB, ((C1176n) objB2).f22972a);
                                c1169g.C(i5, true);
                                break;
                            }
                        }
                    } else {
                        if (c1169g.v(i5, objB2, C1165c.y())) {
                            c1169g.t();
                            break;
                        }
                    }
                }
            }
            c1169g = (C1169g) c1169g.h();
        }
        if (objB != null) {
            if (!(objB instanceof ArrayList)) {
                r0((L0) objB);
                return;
            }
            j4.k.e(objB, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
            ArrayList arrayList = (ArrayList) objB;
            for (int size = arrayList.size() - 1; -1 < size; size--) {
                r0((L0) arrayList.get(size));
            }
        }
    }

    private final void r0(L0 l02) {
        t0(l02, true);
    }

    private final C1169g<E> s() {
        Object obj = f22925k.get(this);
        C1169g c1169g = (C1169g) f22923i.get(this);
        if (c1169g.f23829c > ((C1169g) obj).f23829c) {
            obj = c1169g;
        }
        C1169g c1169g2 = (C1169g) f22924j.get(this);
        if (c1169g2.f23829c > ((C1169g) obj).f23829c) {
            obj = c1169g2;
        }
        return (C1169g) C1303c.b((AbstractC1304d) obj);
    }

    private final void s0(L0 l02) {
        t0(l02, false);
    }

    private final void t0(L0 l02, boolean z5) {
        if (l02 instanceof C0251b) {
            InterfaceC1080k<Boolean> interfaceC1080kA = ((C0251b) l02).a();
            n.a aVar = V3.n.f5531a;
            interfaceC1080kA.resumeWith(V3.n.a(Boolean.FALSE));
            return;
        }
        if (l02 instanceof InterfaceC1080k) {
            Z3.e eVar = (Z3.e) l02;
            n.a aVar2 = V3.n.f5531a;
            eVar.resumeWith(V3.n.a(o.a(z5 ? I() : M())));
        } else if (l02 instanceof C1173k) {
            C1082l<C1168f<? extends E>> c1082l = ((C1173k) l02).f22971a;
            n.a aVar3 = V3.n.f5531a;
            c1082l.resumeWith(V3.n.a(C1168f.b(C1168f.f22963b.a(F()))));
        } else if (l02 instanceof a) {
            ((a) l02).b();
        } else {
            if (l02 instanceof A4.b) {
                ((A4.b) l02).b(this, C1165c.y());
                return;
            }
            throw new IllegalStateException(("Unexpected waiter: " + l02).toString());
        }
    }

    private final void u(long j5) {
        q0(v(j5));
    }

    private final boolean u0(long j5) {
        if (a0(j5)) {
            return false;
        }
        return !q(j5 & 1152921504606846975L);
    }

    private final C1169g<E> v(long j5) {
        C1169g<E> c1169gS = s();
        if (b0()) {
            long jD0 = d0(c1169gS);
            if (jD0 != -1) {
                x(jD0);
            }
        }
        r(c1169gS, j5);
        return c1169gS;
    }

    private final boolean v0(Object obj, E e6) {
        if (obj instanceof A4.b) {
            return ((A4.b) obj).b(this, e6);
        }
        if (obj instanceof C1173k) {
            j4.k.e(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
            C1173k c1173k = (C1173k) obj;
            C1082l<C1168f<? extends E>> c1082l = c1173k.f22971a;
            C1168f c1168fB = C1168f.b(C1168f.f22963b.c(e6));
            InterfaceC0772l<E, v> interfaceC0772l = this.f22929c;
            return C1165c.A(c1082l, c1168fB, interfaceC0772l != null ? x.a(interfaceC0772l, e6, c1173k.f22971a.getContext()) : null);
        }
        if (obj instanceof a) {
            j4.k.e(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
            return ((a) obj).a(e6);
        }
        if (obj instanceof InterfaceC1080k) {
            j4.k.e(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
            InterfaceC1080k interfaceC1080k = (InterfaceC1080k) obj;
            InterfaceC0772l<E, v> interfaceC0772l2 = this.f22929c;
            return C1165c.A(interfaceC1080k, e6, interfaceC0772l2 != null ? x.a(interfaceC0772l2, e6, interfaceC1080k.getContext()) : null);
        }
        throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
    }

    private final void w() {
        Z();
    }

    private final boolean w0(Object obj, C1169g<E> c1169g, int i5) {
        if (obj instanceof InterfaceC1080k) {
            j4.k.e(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            return C1165c.B((InterfaceC1080k) obj, v.f5542a, null, 2, null);
        }
        if (obj instanceof A4.b) {
            j4.k.e(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
            A4.d dVarG = ((A4.a) obj).g(this, v.f5542a);
            if (dVarG == A4.d.f186b) {
                c1169g.w(i5);
            }
            return dVarG == A4.d.f185a;
        }
        if (obj instanceof C0251b) {
            return C1165c.B(((C0251b) obj).a(), Boolean.TRUE, null, 2, null);
        }
        throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
    }

    private final void y() {
        C1164b<E> c1164b;
        if (c0()) {
            return;
        }
        C1169g<E> c1169g = (C1169g) f22925k.get(this);
        while (true) {
            long andIncrement = f22921g.getAndIncrement(this);
            int i5 = C1165c.f22941b;
            long j5 = andIncrement / i5;
            if (this.P() <= andIncrement) {
                if (c1169g.f23829c < j5 && c1169g.f() != 0) {
                    this.h0(j5, c1169g);
                }
                T(this, 0L, 1, null);
                return;
            }
            if (c1169g.f23829c != j5) {
                c1164b = this;
                C1169g<E> c1169gZ = c1164b.z(j5, c1169g, andIncrement);
                if (c1169gZ == null) {
                    continue;
                    this = c1164b;
                } else {
                    c1169g = c1169gZ;
                }
            } else {
                c1164b = this;
            }
            if (c1164b.y0(c1169g, (int) (andIncrement % i5), andIncrement)) {
                T(c1164b, 0L, 1, null);
                return;
            } else {
                T(c1164b, 0L, 1, null);
                this = c1164b;
            }
        }
    }

    private final boolean y0(C1169g<E> c1169g, int i5, long j5) {
        Object objB = c1169g.B(i5);
        if (!(objB instanceof L0) || j5 < f22920f.get(this) || !c1169g.v(i5, objB, C1165c.f22946g)) {
            return z0(c1169g, i5, j5);
        }
        if (w0(objB, c1169g, i5)) {
            c1169g.F(i5, C1165c.f22943d);
            return true;
        }
        c1169g.F(i5, C1165c.f22949j);
        c1169g.C(i5, false);
        return false;
    }

    private final C1169g<E> z(long j5, C1169g<E> c1169g, long j6) {
        Object objC;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f22925k;
        p pVar = (p) C1165c.x();
        loop0: while (true) {
            objC = C1303c.c(c1169g, j5, pVar);
            if (!C1292D.c(objC)) {
                AbstractC1291C abstractC1291CB = C1292D.b(objC);
                while (true) {
                    AbstractC1291C abstractC1291C = (AbstractC1291C) atomicReferenceFieldUpdater.get(this);
                    if (abstractC1291C.f23829c >= abstractC1291CB.f23829c) {
                        break loop0;
                    }
                    if (!abstractC1291CB.u()) {
                        break;
                    }
                    if (atomicReferenceFieldUpdater.compareAndSet(this, abstractC1291C, abstractC1291CB)) {
                        if (abstractC1291C.p()) {
                            abstractC1291C.n();
                        }
                    } else if (abstractC1291CB.p()) {
                        abstractC1291CB.n();
                    }
                }
            } else {
                break;
            }
        }
        if (C1292D.c(objC)) {
            w();
            h0(j5, c1169g);
            T(this, 0L, 1, null);
            return null;
        }
        C1169g<E> c1169g2 = (C1169g) C1292D.b(objC);
        if (c1169g2.f23829c <= j5) {
            return c1169g2;
        }
        long j7 = c1169g2.f23829c;
        int i5 = C1165c.f22941b;
        if (f22921g.compareAndSet(this, j6 + 1, j7 * i5)) {
            S((c1169g2.f23829c * i5) - j6);
        } else {
            T(this, 0L, 1, null);
        }
        return null;
    }

    private final boolean z0(C1169g<E> c1169g, int i5, long j5) {
        while (true) {
            Object objB = c1169g.B(i5);
            if (objB instanceof L0) {
                if (j5 < f22920f.get(this)) {
                    if (c1169g.v(i5, objB, new C1176n((L0) objB))) {
                        return true;
                    }
                } else if (c1169g.v(i5, objB, C1165c.f22946g)) {
                    if (w0(objB, c1169g, i5)) {
                        c1169g.F(i5, C1165c.f22943d);
                        return true;
                    }
                    c1169g.F(i5, C1165c.f22949j);
                    c1169g.C(i5, false);
                    return false;
                }
            } else {
                if (objB == C1165c.f22949j) {
                    return false;
                }
                if (objB == null) {
                    if (c1169g.v(i5, objB, C1165c.f22944e)) {
                        return true;
                    }
                } else {
                    if (objB == C1165c.f22943d || objB == C1165c.f22947h || objB == C1165c.f22948i || objB == C1165c.f22950k || objB == C1165c.y()) {
                        return true;
                    }
                    if (objB != C1165c.f22945f) {
                        throw new IllegalStateException(("Unexpected cell state: " + objB).toString());
                    }
                }
            }
        }
    }

    protected final Throwable F() {
        return (Throwable) f22926l.get(this);
    }

    public final void G0(long j5) {
        C1164b<E> c1164b = this;
        if (c1164b.c0()) {
            return;
        }
        while (c1164b.D() <= j5) {
            c1164b = this;
        }
        int i5 = C1165c.f22942c;
        for (int i6 = 0; i6 < i5; i6++) {
            long jD = c1164b.D();
            if (jD == (4611686018427387903L & f22922h.get(c1164b)) && jD == c1164b.D()) {
                return;
            }
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = f22922h;
        while (true) {
            long j6 = atomicLongFieldUpdater.get(c1164b);
            if (atomicLongFieldUpdater.compareAndSet(c1164b, j6, C1165c.u(j6 & 4611686018427387903L, true))) {
                break;
            } else {
                c1164b = this;
            }
        }
        while (true) {
            long jD2 = c1164b.D();
            long j7 = f22922h.get(c1164b);
            long j8 = j7 & 4611686018427387903L;
            boolean z5 = (4611686018427387904L & j7) != 0;
            if (jD2 == j8 && jD2 == c1164b.D()) {
                break;
            }
            if (z5) {
                c1164b = this;
            } else {
                c1164b = this;
                f22922h.compareAndSet(c1164b, j7, C1165c.u(j8, true));
            }
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater2 = f22922h;
        while (true) {
            long j9 = atomicLongFieldUpdater2.get(c1164b);
            boolean zCompareAndSet = atomicLongFieldUpdater2.compareAndSet(c1164b, j9, C1165c.u(j9 & 4611686018427387903L, false));
            AtomicLongFieldUpdater atomicLongFieldUpdater3 = atomicLongFieldUpdater2;
            if (zCompareAndSet) {
                return;
            }
            atomicLongFieldUpdater2 = atomicLongFieldUpdater3;
            c1164b = this;
        }
    }

    public final long L() {
        return f22920f.get(this);
    }

    protected final Throwable M() {
        Throwable thF = F();
        return thF == null ? new C1171i("Channel was closed") : thF;
    }

    public final long P() {
        return f22919e.get(this) & 1152921504606846975L;
    }

    public final boolean R() {
        while (true) {
            C1169g<E> c1169gA = (C1169g) f22924j.get(this);
            long jL = L();
            if (P() <= jL) {
                return false;
            }
            int i5 = C1165c.f22941b;
            long j5 = jL / i5;
            if (c1169gA.f23829c == j5 || (c1169gA = A(j5, c1169gA)) != null) {
                c1169gA.c();
                if (V(c1169gA, (int) (jL % i5), jL)) {
                    return true;
                }
                f22920f.compareAndSet(this, jL, 1 + jL);
            } else if (((C1169g) f22924j.get(this)).f23829c < j5) {
                return false;
            }
        }
    }

    public boolean X() {
        return Y(f22919e.get(this));
    }

    public boolean Z() {
        return a0(f22919e.get(this));
    }

    @Override // u4.InterfaceC1174l
    public Object a(Z3.e<? super E> eVar) {
        return o0(this, eVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // u4.InterfaceC1174l
    public Object b() {
        C1169g c1169gA;
        long j5 = f22920f.get(this);
        long j6 = f22919e.get(this);
        if (Y(j6)) {
            return C1168f.f22963b.a(F());
        }
        if (j5 >= (j6 & 1152921504606846975L)) {
            return C1168f.f22963b.b();
        }
        Object obj = C1165c.f22950k;
        C1169g c1169g = (C1169g) f22924j.get(this);
        while (!this.X()) {
            long andIncrement = f22920f.getAndIncrement(this);
            int i5 = C1165c.f22941b;
            long j7 = andIncrement / i5;
            int i6 = (int) (andIncrement % i5);
            if (c1169g.f23829c != j7) {
                c1169gA = this.A(j7, c1169g);
                if (c1169gA == null) {
                    continue;
                }
            } else {
                c1169gA = c1169g;
            }
            C1164b<E> c1164b = this;
            Object objA0 = c1164b.A0(c1169gA, i6, andIncrement, obj);
            c1169g = c1169gA;
            if (objA0 == C1165c.f22952m) {
                L0 l02 = obj instanceof L0 ? (L0) obj : null;
                if (l02 != null) {
                    c1164b.m0(l02, c1169g, i6);
                }
                c1164b.G0(andIncrement);
                c1169g.t();
                return C1168f.f22963b.b();
            }
            if (objA0 != C1165c.f22954o) {
                if (objA0 == C1165c.f22953n) {
                    throw new IllegalStateException("unexpected");
                }
                c1169g.c();
                return C1168f.f22963b.c(objA0);
            }
            if (andIncrement < c1164b.P()) {
                c1169g.c();
            }
            this = c1164b;
        }
        return C1168f.f22963b.a(this.F());
    }

    protected boolean b0() {
        return false;
    }

    @Override // u4.InterfaceC1175m
    public boolean c(Throwable th) {
        return t(th, false);
    }

    @Override // u4.InterfaceC1175m
    public Object d(E e6) {
        E e7;
        int i5;
        C1169g c1169g;
        C1164b<E> c1164b;
        if (u0(f22919e.get(this))) {
            return C1168f.f22963b.b();
        }
        Object obj = C1165c.f22949j;
        C1169g c1169g2 = (C1169g) f22923i.get(this);
        while (true) {
            long andIncrement = f22919e.getAndIncrement(this);
            long j5 = andIncrement & 1152921504606846975L;
            boolean zA0 = this.a0(andIncrement);
            int i6 = C1165c.f22941b;
            long j6 = j5 / i6;
            int i7 = (int) (j5 % i6);
            if (c1169g2.f23829c != j6) {
                C1169g c1169gB = this.B(j6, c1169g2);
                if (c1169gB != null) {
                    i5 = i7;
                    c1169g = c1169gB;
                    c1164b = this;
                    e7 = e6;
                } else if (zA0) {
                    return C1168f.f22963b.a(this.M());
                }
            } else {
                e7 = e6;
                i5 = i7;
                c1169g = c1169g2;
                c1164b = this;
            }
            int iC0 = c1164b.C0(c1169g, i5, e7, j5, obj, zA0);
            C1164b<E> c1164b2 = c1164b;
            c1169g2 = c1169g;
            if (iC0 == 0) {
                c1169g2.c();
                return C1168f.f22963b.c(v.f5542a);
            }
            if (iC0 == 1) {
                return C1168f.f22963b.c(v.f5542a);
            }
            if (iC0 == 2) {
                if (zA0) {
                    c1169g2.t();
                    return C1168f.f22963b.a(c1164b2.M());
                }
                L0 l02 = obj instanceof L0 ? (L0) obj : null;
                if (l02 != null) {
                    c1164b2.n0(l02, c1169g2, i5);
                }
                c1169g2.t();
                return C1168f.f22963b.b();
            }
            if (iC0 == 3) {
                throw new IllegalStateException("unexpected");
            }
            if (iC0 == 4) {
                if (j5 < c1164b2.L()) {
                    c1169g2.c();
                }
                return C1168f.f22963b.a(c1164b2.M());
            }
            if (iC0 == 5) {
                c1169g2.c();
            }
            this = c1164b2;
            e6 = e7;
        }
    }

    protected void i0() {
    }

    protected void k0() {
    }

    protected void l0() {
    }

    protected boolean t(Throwable th, boolean z5) {
        if (z5) {
            e0();
        }
        boolean zCompareAndSet = f22926l.compareAndSet(this, C1165c.f22958s, th);
        if (z5) {
            f0();
        } else {
            g0();
        }
        w();
        i0();
        if (zCompareAndSet) {
            U();
        }
        return zCompareAndSet;
    }

    /* JADX WARN: Code restructure failed: missing block: B:91:0x01e1, code lost:
    
        r3 = (u4.C1169g) r3.f();
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01e8, code lost:
    
        if (r3 != null) goto L98;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            Method dump skipped, instructions count: 529
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u4.C1164b.toString():java.lang.String");
    }

    protected final void x(long j5) {
        C1169g<E> c1169g;
        O oD;
        C1169g<E> c1169g2 = (C1169g) f22924j.get(this);
        while (true) {
            long j6 = f22920f.get(this);
            if (j5 < Math.max(this.f22928b + j6, this.D())) {
                return;
            }
            C1164b<E> c1164b = this;
            if (f22920f.compareAndSet(c1164b, j6, 1 + j6)) {
                int i5 = C1165c.f22941b;
                long j7 = j6 / i5;
                int i6 = (int) (j6 % i5);
                if (c1169g2.f23829c != j7) {
                    C1169g<E> c1169gA = c1164b.A(j7, c1169g2);
                    if (c1169gA != null) {
                        c1169g = c1169gA;
                    }
                } else {
                    c1169g = c1169g2;
                }
                Object objA0 = c1164b.A0(c1169g, i6, j6, null);
                if (objA0 != C1165c.f22954o) {
                    c1169g.c();
                    InterfaceC0772l<E, v> interfaceC0772l = c1164b.f22929c;
                    if (interfaceC0772l != null && (oD = x.d(interfaceC0772l, objA0, null, 2, null)) != null) {
                        throw oD;
                    }
                } else if (j6 < c1164b.P()) {
                    c1169g.c();
                }
                this = c1164b;
                c1169g2 = c1169g;
            }
            this = c1164b;
        }
    }

    protected final Object x0(E e6) {
        C1169g c1169gB;
        int i5;
        C1164b<E> c1164b;
        Object obj = C1165c.f22943d;
        C1169g c1169g = (C1169g) f22923i.get(this);
        while (true) {
            long andIncrement = f22919e.getAndIncrement(this);
            long j5 = andIncrement & 1152921504606846975L;
            boolean zA0 = this.a0(andIncrement);
            int i6 = C1165c.f22941b;
            long j6 = j5 / i6;
            int i7 = (int) (j5 % i6);
            if (c1169g.f23829c != j6) {
                c1169gB = this.B(j6, c1169g);
                if (c1169gB != null) {
                    c1164b = this;
                    i5 = i7;
                } else if (zA0) {
                    return C1168f.f22963b.a(this.M());
                }
            } else {
                c1169gB = c1169g;
                i5 = i7;
                c1164b = this;
            }
            E e7 = e6;
            int iC0 = c1164b.C0(c1169gB, i5, e7, j5, obj, zA0);
            C1164b<E> c1164b2 = c1164b;
            c1169g = c1169gB;
            if (iC0 == 0) {
                c1169g.c();
                return C1168f.f22963b.c(v.f5542a);
            }
            if (iC0 == 1) {
                return C1168f.f22963b.c(v.f5542a);
            }
            if (iC0 == 2) {
                if (zA0) {
                    c1169g.t();
                    return C1168f.f22963b.a(c1164b2.M());
                }
                L0 l02 = obj instanceof L0 ? (L0) obj : null;
                if (l02 != null) {
                    c1164b2.n0(l02, c1169g, i5);
                }
                c1164b2.x((c1169g.f23829c * i6) + i5);
                return C1168f.f22963b.c(v.f5542a);
            }
            if (iC0 == 3) {
                throw new IllegalStateException("unexpected");
            }
            if (iC0 == 4) {
                if (j5 < c1164b2.L()) {
                    c1169g.c();
                }
                return C1168f.f22963b.a(c1164b2.M());
            }
            if (iC0 == 5) {
                c1169g.c();
            }
            this = c1164b2;
            e6 = e7;
        }
    }
}

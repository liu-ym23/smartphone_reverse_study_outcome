package ia;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public class m extends m0 implements k, i7.d, g2 {

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f4971k = AtomicIntegerFieldUpdater.newUpdater(m.class, "_decisionAndIndex$volatile");

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f4972l = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "_state$volatile");

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f4973m = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "_parentHandle$volatile");
    private volatile /* synthetic */ int _decisionAndIndex$volatile;
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    /* renamed from: i, reason: collision with root package name */
    public final g7.d f4974i;

    /* renamed from: j, reason: collision with root package name */
    public final g7.l f4975j;

    public m(int i2, g7.d dVar) {
        super(i2);
        this.f4974i = dVar;
        this.f4975j = dVar.getContext();
        this._decisionAndIndex$volatile = 536870911;
        this._state$volatile = b.f4919a;
    }

    public static Object E(t1 t1Var, Object obj, int i2, p7.o oVar, Object obj2) {
        if (obj instanceof v) {
            return obj;
        }
        if ((i2 == 1 || i2 == 2 || obj2 != null) && !(oVar == null && !(t1Var instanceof i) && obj2 == null)) {
            return new u(obj, t1Var instanceof i ? (i) t1Var : null, oVar, obj2, null, 16);
        }
        return obj;
    }

    public static void z(Object obj, Object obj2) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + obj + ", already has " + obj2).toString());
    }

    public String A() {
        return "CancellableContinuation";
    }

    public final void B() throws k0 {
        g7.d dVar = this.f4974i;
        Throwable th = null;
        na.g gVar = dVar instanceof na.g ? (na.g) dVar : null;
        if (gVar != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = na.g.f6899m;
            loop0: while (true) {
                Object obj = atomicReferenceFieldUpdater.get(gVar);
                f8.x xVar = na.b.f6889c;
                if (obj == xVar) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(gVar, xVar, this)) {
                        if (atomicReferenceFieldUpdater.get(gVar) != xVar) {
                            break;
                        }
                    }
                    break loop0;
                } else {
                    if (!(obj instanceof Throwable)) {
                        throw new IllegalStateException(("Inconsistent state " + obj).toString());
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(gVar, obj, null)) {
                        if (atomicReferenceFieldUpdater.get(gVar) != obj) {
                            throw new IllegalArgumentException("Failed requirement.");
                        }
                    }
                    th = (Throwable) obj;
                }
            }
            if (th == null) {
                return;
            }
            o();
            a(th);
        }
    }

    public final void C(Object obj, int i2, p7.o oVar) throws k0 {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4972l;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof t1) {
                Object objE = E((t1) obj2, obj, i2, oVar, null);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, objE)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj2) {
                        break;
                    }
                }
                if (!y()) {
                    o();
                }
                p(i2);
                return;
            }
            if (obj2 instanceof n) {
                n nVar = (n) obj2;
                if (n.f4981c.compareAndSet(nVar, 0, 1)) {
                    if (oVar != null) {
                        l(oVar, nVar.f5011a, obj);
                        return;
                    }
                    return;
                }
            }
            throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
        }
    }

    public final void D(x xVar) {
        g7.d dVar = this.f4974i;
        na.g gVar = dVar instanceof na.g ? (na.g) dVar : null;
        C(c7.r.f1986a, (gVar != null ? gVar.f6900i : null) == xVar ? 4 : this.f4976h, null);
    }

    public final f8.x F(Object obj, Object obj2, p7.o oVar) {
        f8.x xVar = d0.f4935a;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4972l;
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (obj3 instanceof t1) {
                Object objE = E((t1) obj3, obj, this.f4976h, oVar, obj2);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj3, objE)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj3) {
                        break;
                    }
                }
                if (!y()) {
                    o();
                    return xVar;
                }
            } else if (!(obj3 instanceof u) || obj2 == null || ((u) obj3).f5006d != obj2) {
                return null;
            }
        }
        return xVar;
    }

    @Override // ia.k
    public final boolean a(Throwable th) throws k0 {
        Throwable cancellationException;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4972l;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof t1)) {
                return false;
            }
            boolean z4 = (obj instanceof i) || (obj instanceof na.s);
            if (th == null) {
                cancellationException = new CancellationException("Continuation " + this + " was cancelled normally");
            } else {
                cancellationException = th;
            }
            n nVar = new n(cancellationException, z4);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, nVar)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    break;
                }
            }
            t1 t1Var = (t1) obj;
            if (t1Var instanceof i) {
                k((i) obj, th);
            } else if (t1Var instanceof na.s) {
                n((na.s) obj, th);
            }
            if (!y()) {
                o();
            }
            p(this.f4976h);
            return true;
        }
    }

    @Override // ia.g2
    public final void b(na.s sVar, int i2) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i10;
        do {
            atomicIntegerFieldUpdater = f4971k;
            i10 = atomicIntegerFieldUpdater.get(this);
            if ((i10 & 536870911) != 536870911) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once");
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i10, ((i10 >> 29) << 29) + i2));
        v(sVar);
    }

    @Override // ia.m0
    public final void c(CancellationException cancellationException) {
        CancellationException cancellationException2;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4972l;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof t1) {
                throw new IllegalStateException("Not completed");
            }
            if (obj instanceof v) {
                return;
            }
            if (!(obj instanceof u)) {
                cancellationException2 = cancellationException;
                u uVar = new u(obj, null, null, null, cancellationException2, 14);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, uVar)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        break;
                    }
                }
                return;
            }
            u uVar2 = (u) obj;
            if (uVar2.f5007e != null) {
                throw new IllegalStateException("Must be called at most once");
            }
            u uVarA = u.a(uVar2, null, cancellationException, 15);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, uVarA)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    cancellationException2 = cancellationException;
                }
            }
            i iVar = uVar2.f5004b;
            if (iVar != null) {
                k(iVar, cancellationException);
            }
            p7.o oVar = uVar2.f5005c;
            if (oVar != null) {
                l(oVar, cancellationException, uVar2.f5003a);
                return;
            }
            return;
            cancellationException = cancellationException2;
        }
    }

    @Override // ia.m0
    public final g7.d d() {
        return this.f4974i;
    }

    @Override // ia.m0
    public final Throwable e(Object obj) {
        Throwable thE = super.e(obj);
        if (thE != null) {
            return thE;
        }
        return null;
    }

    @Override // ia.k
    public final f8.x f(Object obj, Object obj2) {
        return F(obj, obj2, null);
    }

    @Override // ia.m0
    public final Object g(Object obj) {
        return obj instanceof u ? ((u) obj).f5003a : obj;
    }

    @Override // i7.d
    public final i7.d getCallerFrame() {
        g7.d dVar = this.f4974i;
        if (dVar instanceof i7.d) {
            return (i7.d) dVar;
        }
        return null;
    }

    @Override // g7.d
    public final g7.l getContext() {
        return this.f4975j;
    }

    @Override // ia.k
    public final f8.x h(Object obj, p7.o oVar) {
        return F(obj, null, oVar);
    }

    @Override // ia.m0
    public final Object j() {
        return f4972l.get(this);
    }

    public final void k(i iVar, Throwable th) {
        try {
            iVar.a(th);
        } catch (Throwable th2) {
            d0.n(this.f4975j, new a4.u("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void l(p7.o oVar, Throwable th, Object obj) {
        g7.l lVar = this.f4975j;
        try {
            oVar.j(th, obj, lVar);
        } catch (Throwable th2) {
            d0.n(lVar, new a4.u("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    @Override // ia.k
    public final void m(Object obj, p7.o oVar) throws k0 {
        C(obj, this.f4976h, oVar);
    }

    public final void n(na.s sVar, Throwable th) {
        g7.l lVar = this.f4975j;
        int i2 = f4971k.get(this) & 536870911;
        if (i2 == 536870911) {
            throw new IllegalStateException("The index for Segment.onCancellation(..) is broken");
        }
        try {
            sVar.h(i2, lVar);
        } catch (Throwable th2) {
            d0.n(lVar, new a4.u("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void o() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4973m;
        p0 p0Var = (p0) atomicReferenceFieldUpdater.get(this);
        if (p0Var == null) {
            return;
        }
        p0Var.a();
        atomicReferenceFieldUpdater.set(this, s1.f5001f);
    }

    public final void p(int i2) throws k0 {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i10;
        do {
            atomicIntegerFieldUpdater = f4971k;
            i10 = atomicIntegerFieldUpdater.get(this);
            int i11 = i10 >> 29;
            if (i11 != 0) {
                if (i11 != 1) {
                    throw new IllegalStateException("Already resumed");
                }
                boolean z4 = i2 == 4;
                g7.d dVar = this.f4974i;
                if (!z4 && (dVar instanceof na.g)) {
                    boolean z10 = i2 == 1 || i2 == 2;
                    int i12 = this.f4976h;
                    if (z10 == (i12 == 1 || i12 == 2)) {
                        na.g gVar = (na.g) dVar;
                        x xVar = gVar.f6900i;
                        g7.l context = gVar.f6901j.getContext();
                        if (na.b.j(xVar, context)) {
                            na.b.i(xVar, context, this);
                            return;
                        }
                        x0 x0VarA = z1.a();
                        if (x0VarA.f5023h >= 4294967296L) {
                            x0VarA.V(this);
                            return;
                        }
                        x0VarA.X(true);
                        try {
                            d0.v(this, dVar, true);
                            do {
                            } while (x0VarA.Z());
                        } finally {
                            try {
                                return;
                            } finally {
                            }
                        }
                        return;
                    }
                }
                d0.v(this, dVar, z4);
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i10, 1073741824 + (536870911 & i10)));
    }

    public Throwable q(o1 o1Var) {
        return o1Var.E();
    }

    public final Object r() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i2;
        g1 g1Var;
        boolean zY = y();
        do {
            atomicIntegerFieldUpdater = f4971k;
            i2 = atomicIntegerFieldUpdater.get(this);
            int i10 = i2 >> 29;
            if (i10 != 0) {
                if (i10 != 2) {
                    throw new IllegalStateException("Already suspended");
                }
                if (zY) {
                    B();
                }
                Object obj = f4972l.get(this);
                if (obj instanceof v) {
                    throw ((v) obj).f5011a;
                }
                int i11 = this.f4976h;
                if ((i11 != 1 && i11 != 2) || (g1Var = (g1) this.f4975j.o(z.f5027g)) == null || g1Var.b()) {
                    return g(obj);
                }
                CancellationException cancellationExceptionE = g1Var.E();
                c(cancellationExceptionE);
                throw cancellationExceptionE;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i2, 536870912 + (536870911 & i2)));
        if (((p0) f4973m.get(this)) == null) {
            t();
        }
        if (zY) {
            B();
        }
        return h7.a.f4212f;
    }

    @Override // g7.d
    public final void resumeWith(Object obj) {
        Throwable thA = c7.m.a(obj);
        if (thA != null) {
            obj = new v(thA, false);
        }
        C(obj, this.f4976h, null);
    }

    public final void s() {
        p0 p0VarT = t();
        if (p0VarT == null || (f4972l.get(this) instanceof t1)) {
            return;
        }
        p0VarT.a();
        f4973m.set(this, s1.f5001f);
    }

    public final p0 t() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        g1 g1Var = (g1) this.f4975j.o(z.f5027g);
        if (g1Var == null) {
            return null;
        }
        p0 p0VarO = d0.o(g1Var, true, new o(this, 0));
        do {
            atomicReferenceFieldUpdater = f4973m;
            if (atomicReferenceFieldUpdater.compareAndSet(this, null, p0VarO)) {
                break;
            }
        } while (atomicReferenceFieldUpdater.get(this) == null);
        return p0VarO;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(A());
        sb2.append('(');
        sb2.append(d0.y(this.f4974i));
        sb2.append("){");
        Object obj = f4972l.get(this);
        sb2.append(obj instanceof t1 ? "Active" : obj instanceof n ? "Cancelled" : "Completed");
        sb2.append("}@");
        sb2.append(d0.k(this));
        return sb2.toString();
    }

    public final void u(p7.k kVar) {
        v(new h(1, kVar));
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x00af, code lost:
    
        z(r9, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00b2, code lost:
    
        throw null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void v(ia.t1 r9) {
        /*
            r8 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = ia.m.f4972l
            java.lang.Object r2 = r0.get(r8)
            boolean r1 = r2 instanceof ia.b
            if (r1 == 0) goto L19
        La:
            boolean r1 = r0.compareAndSet(r8, r2, r9)
            if (r1 == 0) goto L12
            goto La6
        L12:
            java.lang.Object r1 = r0.get(r8)
            if (r1 == r2) goto La
            goto L0
        L19:
            boolean r1 = r2 instanceof ia.i
            r3 = 0
            if (r1 != 0) goto Laf
            boolean r1 = r2 instanceof na.s
            if (r1 != 0) goto Laf
            boolean r1 = r2 instanceof ia.v
            if (r1 == 0) goto L52
            r0 = r2
            ia.v r0 = (ia.v) r0
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r1 = ia.v.f5010b
            r4 = 0
            r5 = 1
            boolean r1 = r1.compareAndSet(r0, r4, r5)
            if (r1 == 0) goto L4e
            boolean r1 = r2 instanceof ia.n
            if (r1 == 0) goto La6
            java.lang.Throwable r0 = r0.f5011a
            boolean r1 = r9 instanceof ia.i
            if (r1 == 0) goto L43
            ia.i r9 = (ia.i) r9
            r8.k(r9, r0)
            return
        L43:
            java.lang.String r1 = "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>"
            q7.k.c(r9, r1)
            na.s r9 = (na.s) r9
            r8.n(r9, r0)
            return
        L4e:
            z(r9, r2)
            throw r3
        L52:
            boolean r1 = r2 instanceof ia.u
            java.lang.String r4 = "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler"
            if (r1 == 0) goto L8b
            r1 = r2
            ia.u r1 = (ia.u) r1
            ia.i r5 = r1.f5004b
            if (r5 != 0) goto L87
            boolean r5 = r9 instanceof na.s
            if (r5 == 0) goto L64
            return
        L64:
            q7.k.c(r9, r4)
            r4 = r9
            ia.i r4 = (ia.i) r4
            java.lang.Throwable r5 = r1.f5007e
            if (r5 == 0) goto L72
            r8.k(r4, r5)
            return
        L72:
            r5 = 29
            ia.u r1 = ia.u.a(r1, r4, r3, r5)
        L78:
            boolean r3 = r0.compareAndSet(r8, r2, r1)
            if (r3 == 0) goto L7f
            goto La6
        L7f:
            java.lang.Object r3 = r0.get(r8)
            if (r3 == r2) goto L78
            goto L0
        L87:
            z(r9, r2)
            throw r3
        L8b:
            boolean r1 = r9 instanceof na.s
            if (r1 == 0) goto L90
            return
        L90:
            q7.k.c(r9, r4)
            r3 = r9
            ia.i r3 = (ia.i) r3
            ia.u r1 = new ia.u
            r6 = 0
            r7 = 28
            r4 = 0
            r5 = 0
            r1.<init>(r2, r3, r4, r5, r6, r7)
        La0:
            boolean r3 = r0.compareAndSet(r8, r2, r1)
            if (r3 == 0) goto La7
        La6:
            return
        La7:
            java.lang.Object r3 = r0.get(r8)
            if (r3 == r2) goto La0
            goto L0
        Laf:
            z(r9, r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: ia.m.v(ia.t1):void");
    }

    public final boolean w() {
        return f4972l.get(this) instanceof t1;
    }

    @Override // ia.k
    public final void x(Object obj) throws k0 {
        p(this.f4976h);
    }

    public final boolean y() {
        if (this.f4976h != 2) {
            return false;
        }
        g7.d dVar = this.f4974i;
        q7.k.c(dVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return na.g.f6899m.get((na.g) dVar) != null;
    }
}

package a6;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class m extends q0 implements k, h5.d, g2 {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f189f = AtomicIntegerFieldUpdater.newUpdater(m.class, "_decisionAndIndex$volatile");

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f190g = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "_state$volatile");

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f191h = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "_parentHandle$volatile");
    private volatile /* synthetic */ int _decisionAndIndex$volatile;
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;
    public final f5.c d;

    /* renamed from: e, reason: collision with root package name */
    public final f5.h f192e;

    public m(int i8, f5.c cVar) {
        super(i8);
        this.d = cVar;
        this.f192e = cVar.getContext();
        this._decisionAndIndex$volatile = 536870911;
        this._state$volatile = b.f135a;
    }

    public static Object D(t1 t1Var, Object obj, int i8, p5.q qVar) {
        if (obj instanceof v) {
            return obj;
        }
        if (i8 != 1 && i8 != 2) {
            return obj;
        }
        if (qVar != null || (t1Var instanceof j)) {
            return new u(obj, t1Var instanceof j ? (j) t1Var : null, qVar, (Throwable) null, 16);
        }
        return obj;
    }

    public static void y(t1 t1Var, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + t1Var + ", already has " + obj).toString());
    }

    public final void A() throws o0 {
        f5.c cVar = this.d;
        Throwable th = null;
        f6.e eVar = cVar instanceof f6.e ? (f6.e) cVar : null;
        if (eVar != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6.e.f2637h;
            loop0: while (true) {
                Object obj = atomicReferenceFieldUpdater.get(eVar);
                androidx.emoji2.text.r rVar = f6.a.f2629c;
                if (obj == rVar) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(eVar, rVar, this)) {
                        if (atomicReferenceFieldUpdater.get(eVar) != rVar) {
                            break;
                        }
                    }
                    break loop0;
                } else {
                    if (!(obj instanceof Throwable)) {
                        throw new IllegalStateException(("Inconsistent state " + obj).toString());
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(eVar, obj, null)) {
                        if (atomicReferenceFieldUpdater.get(eVar) != obj) {
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
            n(th);
        }
    }

    public final void B(Object obj, int i8, p5.q qVar) throws o0 {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f190g;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof t1) {
                Object objD = D((t1) obj2, obj, i8, qVar);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, objD)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj2) {
                        break;
                    }
                }
                if (!x()) {
                    o();
                }
                q(i8);
                return;
            }
            if (obj2 instanceof n) {
                n nVar = (n) obj2;
                if (n.f194c.compareAndSet(nVar, 0, 1)) {
                    if (qVar != null) {
                        k(qVar, nVar.f222a, obj);
                        return;
                    }
                    return;
                }
            }
            throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
        }
    }

    public final void C(b0 b0Var) throws o0 {
        f5.c cVar = this.d;
        f6.e eVar = cVar instanceof f6.e ? (f6.e) cVar : null;
        B(b5.a0.f883a, (eVar != null ? eVar.d : null) == b0Var ? 4 : this.f209c, null);
    }

    public final androidx.emoji2.text.r E(Object obj, p5.q qVar) {
        androidx.emoji2.text.r rVar = i0.f172a;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f190g;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (!(obj2 instanceof t1)) {
                return null;
            }
            Object objD = D((t1) obj2, obj, this.f209c, qVar);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, objD)) {
                if (atomicReferenceFieldUpdater.get(this) != obj2) {
                    break;
                }
            }
            if (!x()) {
                o();
            }
            return rVar;
        }
    }

    @Override // a6.k
    public final boolean a() {
        return f190g.get(this) instanceof t1;
    }

    @Override // a6.g2
    public final void b(f6.q qVar, int i8) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i9;
        do {
            atomicIntegerFieldUpdater = f189f;
            i9 = atomicIntegerFieldUpdater.get(this);
            if ((i9 & 536870911) != 536870911) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once");
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i9, ((i9 >> 29) << 29) + i8));
        w(qVar);
    }

    @Override // a6.q0
    public final void c(CancellationException cancellationException) {
        CancellationException cancellationException2;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f190g;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof t1) {
                throw new IllegalStateException("Not completed");
            }
            if (obj instanceof v) {
                return;
            }
            if (!(obj instanceof u)) {
                cancellationException2 = cancellationException;
                u uVar = new u(obj, (j) null, (p5.q) null, cancellationException2, 14);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, uVar)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        break;
                    }
                }
                return;
            }
            u uVar2 = (u) obj;
            if (uVar2.f219e != null) {
                throw new IllegalStateException("Must be called at most once");
            }
            u uVarA = u.a(uVar2, null, cancellationException, 15);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, uVarA)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    cancellationException2 = cancellationException;
                }
            }
            j jVar = uVar2.f217b;
            if (jVar != null) {
                j(jVar, cancellationException);
            }
            p5.q qVar = uVar2.f218c;
            if (qVar != null) {
                k(qVar, cancellationException, uVar2.f216a);
                return;
            }
            return;
            cancellationException = cancellationException2;
        }
    }

    @Override // a6.q0
    public final f5.c d() {
        return this.d;
    }

    @Override // a6.q0
    public final Throwable e(Object obj) {
        Throwable thE = super.e(obj);
        if (thE != null) {
            return thE;
        }
        return null;
    }

    @Override // a6.q0
    public final Object f(Object obj) {
        return obj instanceof u ? ((u) obj).f216a : obj;
    }

    @Override // h5.d
    public final h5.d getCallerFrame() {
        f5.c cVar = this.d;
        if (cVar instanceof h5.d) {
            return (h5.d) cVar;
        }
        return null;
    }

    @Override // f5.c
    public final f5.h getContext() {
        return this.f192e;
    }

    @Override // a6.k
    public final void h(Object obj, p5.q qVar) throws o0 {
        B(obj, this.f209c, qVar);
    }

    @Override // a6.q0
    public final Object i() {
        return f190g.get(this);
    }

    public final void j(j jVar, Throwable th) {
        try {
            jVar.a(th);
        } catch (Throwable th2) {
            i0.n(this.f192e, new w("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void k(p5.q qVar, Throwable th, Object obj) {
        f5.h hVar = this.f192e;
        try {
            qVar.invoke(th, obj, hVar);
        } catch (Throwable th2) {
            i0.n(hVar, new w("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    public final void l(f6.q qVar, Throwable th) {
        f5.h hVar = this.f192e;
        int i8 = f189f.get(this) & 536870911;
        if (i8 == 536870911) {
            throw new IllegalStateException("The index for Segment.onCancellation(..) is broken");
        }
        try {
            qVar.h(i8, hVar);
        } catch (Throwable th2) {
            i0.n(hVar, new w("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    @Override // a6.k
    public final void m(Object obj) throws o0 {
        q(this.f209c);
    }

    public final void n(Throwable th) throws o0 {
        Throwable cancellationException;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f190g;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof t1) {
                boolean z = (obj instanceof j) || (obj instanceof f6.q);
                if (th == null) {
                    cancellationException = new CancellationException("Continuation " + this + " was cancelled normally");
                } else {
                    cancellationException = th;
                }
                n nVar = new n(cancellationException, z);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, nVar)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        break;
                    }
                }
                t1 t1Var = (t1) obj;
                if (t1Var instanceof j) {
                    j((j) obj, th);
                } else if (t1Var instanceof f6.q) {
                    l((f6.q) obj, th);
                }
                if (!x()) {
                    o();
                }
                q(this.f209c);
                return;
            }
            return;
        }
    }

    public final void o() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f191h;
        s0 s0Var = (s0) atomicReferenceFieldUpdater.get(this);
        if (s0Var == null) {
            return;
        }
        s0Var.b();
        atomicReferenceFieldUpdater.set(this, s1.f213a);
    }

    @Override // a6.k
    public final androidx.emoji2.text.r p(Object obj, p5.q qVar) {
        return E(obj, qVar);
    }

    public final void q(int i8) throws o0 {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i9;
        do {
            atomicIntegerFieldUpdater = f189f;
            i9 = atomicIntegerFieldUpdater.get(this);
            int i10 = i9 >> 29;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("Already resumed");
                }
                boolean z = i8 == 4;
                f5.c cVar = this.d;
                if (!z && (cVar instanceof f6.e)) {
                    boolean z2 = i8 == 1 || i8 == 2;
                    int i11 = this.f209c;
                    if (z2 == (i11 == 1 || i11 == 2)) {
                        f6.e eVar = (f6.e) cVar;
                        b0 b0Var = eVar.d;
                        f5.h context = eVar.f2638e.getContext();
                        if (f6.a.j(b0Var, context)) {
                            f6.a.i(b0Var, context, this);
                            return;
                        }
                        a1 a1VarA = z1.a();
                        if (a1VarA.f132c >= 4294967296L) {
                            a1VarA.I(this);
                            return;
                        }
                        a1VarA.K(true);
                        try {
                            i0.t(this, cVar, true);
                            do {
                            } while (a1VarA.M());
                        } finally {
                            try {
                                return;
                            } finally {
                            }
                        }
                        return;
                    }
                }
                i0.t(this, cVar, z);
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i9, 1073741824 + (536870911 & i9)));
    }

    public Throwable r(p1 p1Var) {
        return p1Var.v();
    }

    @Override // f5.c
    public final void resumeWith(Object obj) throws o0 {
        Throwable thA = b5.i.a(obj);
        if (thA != null) {
            obj = new v(thA, false);
        }
        B(obj, this.f209c, null);
    }

    public final Object s() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i8;
        h1 h1Var;
        boolean zX = x();
        do {
            atomicIntegerFieldUpdater = f189f;
            i8 = atomicIntegerFieldUpdater.get(this);
            int i9 = i8 >> 29;
            if (i9 != 0) {
                if (i9 != 2) {
                    throw new IllegalStateException("Already suspended");
                }
                if (zX) {
                    A();
                }
                Object obj = f190g.get(this);
                if (obj instanceof v) {
                    throw ((v) obj).f222a;
                }
                int i10 = this.f209c;
                if ((i10 != 1 && i10 != 2) || (h1Var = (h1) this.f192e.o(c0.f143b)) == null || h1Var.a()) {
                    return f(obj);
                }
                CancellationException cancellationExceptionV = h1Var.v();
                c(cancellationExceptionV);
                throw cancellationExceptionV;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i8, 536870912 + (536870911 & i8)));
        if (((s0) f191h.get(this)) == null) {
            u();
        }
        if (zX) {
            A();
        }
        return g5.a.f2984a;
    }

    public final void t() {
        s0 s0VarU = u();
        if (s0VarU == null || (f190g.get(this) instanceof t1)) {
            return;
        }
        s0VarU.b();
        f191h.set(this, s1.f213a);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(z());
        sb.append('(');
        sb.append(i0.x(this.d));
        sb.append("){");
        Object obj = f190g.get(this);
        sb.append(obj instanceof t1 ? "Active" : obj instanceof n ? "Cancelled" : "Completed");
        sb.append("}@");
        sb.append(i0.k(this));
        return sb.toString();
    }

    public final s0 u() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        h1 h1Var = (h1) this.f192e.o(c0.f143b);
        if (h1Var == null) {
            return null;
        }
        s0 s0VarO = i0.o(h1Var, true, new o(this, 0));
        do {
            atomicReferenceFieldUpdater = f191h;
            if (atomicReferenceFieldUpdater.compareAndSet(this, null, s0VarO)) {
                break;
            }
        } while (atomicReferenceFieldUpdater.get(this) == null);
        return s0VarO;
    }

    public final void v(p5.l lVar) {
        w(new i(0, lVar));
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x00a0, code lost:
    
        y(r8, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00a3, code lost:
    
        throw null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void w(a6.t1 r8) {
        /*
            r7 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = a6.m.f190g
            java.lang.Object r2 = r0.get(r7)
            boolean r1 = r2 instanceof a6.b
            if (r1 == 0) goto L19
        La:
            boolean r1 = r0.compareAndSet(r7, r2, r8)
            if (r1 == 0) goto L12
            goto L97
        L12:
            java.lang.Object r1 = r0.get(r7)
            if (r1 == r2) goto La
            goto L0
        L19:
            boolean r1 = r2 instanceof a6.j
            r3 = 0
            if (r1 != 0) goto La0
            boolean r1 = r2 instanceof f6.q
            if (r1 != 0) goto La0
            boolean r1 = r2 instanceof a6.v
            if (r1 == 0) goto L4d
            r0 = r2
            a6.v r0 = (a6.v) r0
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r1 = a6.v.f221b
            r4 = 0
            r5 = 1
            boolean r1 = r1.compareAndSet(r0, r4, r5)
            if (r1 == 0) goto L49
            boolean r1 = r2 instanceof a6.n
            if (r1 == 0) goto L97
            java.lang.Throwable r0 = r0.f222a
            boolean r1 = r8 instanceof a6.j
            if (r1 == 0) goto L43
            a6.j r8 = (a6.j) r8
            r7.j(r8, r0)
            return
        L43:
            f6.q r8 = (f6.q) r8
            r7.l(r8, r0)
            return
        L49:
            y(r8, r2)
            throw r3
        L4d:
            boolean r1 = r2 instanceof a6.u
            if (r1 == 0) goto L80
            r1 = r2
            a6.u r1 = (a6.u) r1
            a6.j r4 = r1.f217b
            if (r4 != 0) goto L7c
            boolean r4 = r8 instanceof f6.q
            if (r4 == 0) goto L5d
            goto L97
        L5d:
            r4 = r8
            a6.j r4 = (a6.j) r4
            java.lang.Throwable r5 = r1.f219e
            if (r5 == 0) goto L68
            r7.j(r4, r5)
            return
        L68:
            r5 = 29
            a6.u r1 = a6.u.a(r1, r4, r3, r5)
        L6e:
            boolean r3 = r0.compareAndSet(r7, r2, r1)
            if (r3 == 0) goto L75
            goto L97
        L75:
            java.lang.Object r3 = r0.get(r7)
            if (r3 == r2) goto L6e
            goto L0
        L7c:
            y(r8, r2)
            throw r3
        L80:
            boolean r1 = r8 instanceof f6.q
            if (r1 == 0) goto L85
            goto L97
        L85:
            r3 = r8
            a6.j r3 = (a6.j) r3
            a6.u r1 = new a6.u
            r5 = 0
            r6 = 28
            r4 = 0
            r1.<init>(r2, r3, r4, r5, r6)
        L91:
            boolean r3 = r0.compareAndSet(r7, r2, r1)
            if (r3 == 0) goto L98
        L97:
            return
        L98:
            java.lang.Object r3 = r0.get(r7)
            if (r3 == r2) goto L91
            goto L0
        La0:
            y(r8, r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: a6.m.w(a6.t1):void");
    }

    public final boolean x() {
        if (this.f209c != 2) {
            return false;
        }
        f5.c cVar = this.d;
        kotlin.jvm.internal.p.c(cVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return f6.e.f2637h.get((f6.e) cVar) != null;
    }

    public String z() {
        return "CancellableContinuation";
    }
}

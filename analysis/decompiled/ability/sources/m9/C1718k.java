package m9;

import Ca.C0203b;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlinx.coroutines.CompletionHandlerException;
import s9.AbstractC1921a;
import s9.C1925e;

/* renamed from: m9.k, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C1718k extends AbstractC1689G implements InterfaceC1717j, J7.b, y0 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater f = AtomicIntegerFieldUpdater.newUpdater(C1718k.class, "_decisionAndIndex$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater g = AtomicReferenceFieldUpdater.newUpdater(C1718k.class, Object.class, "_state$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater h = AtomicReferenceFieldUpdater.newUpdater(C1718k.class, Object.class, "_parentHandle$volatile");
    private volatile /* synthetic */ int _decisionAndIndex$volatile;
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;
    public final H7.c d;
    public final H7.h e;

    public C1718k(int i, H7.c cVar) {
        super(i);
        this.d = cVar;
        this.e = cVar.getContext();
        this._decisionAndIndex$volatile = 536870911;
        this._state$volatile = C1709b.f5324a;
    }

    public static void C(Object obj, Object obj2) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + obj + ", already has " + obj2).toString());
    }

    public static Object H(o0 o0Var, Object obj, int i, S7.o oVar) {
        if (obj instanceof C1727t) {
            return obj;
        }
        if (i != 1 && i != 2) {
            return obj;
        }
        if (oVar != null || (o0Var instanceof InterfaceC1716i)) {
            return new C1726s(obj, o0Var instanceof InterfaceC1716i ? (InterfaceC1716i) o0Var : null, oVar, (Throwable) null, 16);
        }
        return obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x00a0, code lost:
    
        C(r8, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00a3, code lost:
    
        throw null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A(m9.o0 r8) {
        /*
            r7 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = m9.C1718k.g
            java.lang.Object r2 = r0.get(r7)
            boolean r1 = r2 instanceof m9.C1709b
            if (r1 == 0) goto L12
            boolean r0 = r0.compareAndSet(r7, r2, r8)
            if (r0 == 0) goto L0
            goto L9f
        L12:
            boolean r1 = r2 instanceof m9.InterfaceC1716i
            r3 = 0
            if (r1 != 0) goto La0
            boolean r1 = r2 instanceof s9.p
            if (r1 != 0) goto La0
            boolean r1 = r2 instanceof m9.C1727t
            if (r1 == 0) goto L54
            r0 = r2
            m9.t r0 = (m9.C1727t) r0
            r0.getClass()
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r1 = m9.C1727t.b
            r4 = 0
            r5 = 1
            boolean r1 = r1.compareAndSet(r0, r4, r5)
            if (r1 == 0) goto L50
            boolean r1 = r2 instanceof m9.C1719l
            if (r1 == 0) goto L9f
            if (r2 == 0) goto L36
            goto L37
        L36:
            r0 = r3
        L37:
            if (r0 == 0) goto L3b
            java.lang.Throwable r3 = r0.f5333a
        L3b:
            boolean r0 = r8 instanceof m9.InterfaceC1716i
            if (r0 == 0) goto L45
            m9.i r8 = (m9.InterfaceC1716i) r8
            r7.q(r8, r3)
            return
        L45:
            java.lang.String r0 = "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>"
            kotlin.jvm.internal.k.d(r8, r0)
            s9.p r8 = (s9.p) r8
            r7.s(r8, r3)
            return
        L50:
            C(r8, r2)
            throw r3
        L54:
            boolean r1 = r2 instanceof m9.C1726s
            java.lang.String r4 = "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler"
            if (r1 == 0) goto L85
            r1 = r2
            m9.s r1 = (m9.C1726s) r1
            m9.i r5 = r1.b
            if (r5 != 0) goto L81
            boolean r5 = r8 instanceof s9.p
            if (r5 == 0) goto L66
            return
        L66:
            kotlin.jvm.internal.k.d(r8, r4)
            r4 = r8
            m9.i r4 = (m9.InterfaceC1716i) r4
            java.lang.Throwable r5 = r1.e
            if (r5 == 0) goto L74
            r7.q(r4, r5)
            return
        L74:
            r5 = 29
            m9.s r1 = m9.C1726s.a(r1, r4, r3, r5)
            boolean r0 = r0.compareAndSet(r7, r2, r1)
            if (r0 == 0) goto L0
            goto L9f
        L81:
            C(r8, r2)
            throw r3
        L85:
            boolean r1 = r8 instanceof s9.p
            if (r1 == 0) goto L8a
            return
        L8a:
            kotlin.jvm.internal.k.d(r8, r4)
            r3 = r8
            m9.i r3 = (m9.InterfaceC1716i) r3
            m9.s r1 = new m9.s
            r5 = 0
            r6 = 28
            r4 = 0
            r1.<init>(r2, r3, r4, r5, r6)
            boolean r0 = r0.compareAndSet(r7, r2, r1)
            if (r0 == 0) goto L0
        L9f:
            return
        La0:
            C(r8, r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: m9.C1718k.A(m9.o0):void");
    }

    public final boolean B() {
        if (this.c != 2) {
            return false;
        }
        H7.c cVar = this.d;
        kotlin.jvm.internal.k.d(cVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return C1925e.h.get((C1925e) cVar) != null;
    }

    public String D() {
        return "CancellableContinuation";
    }

    public final void E() {
        H7.c cVar = this.d;
        Throwable th = null;
        C1925e c1925e = cVar instanceof C1925e ? (C1925e) cVar : null;
        if (c1925e != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = C1925e.h;
            while (true) {
                Object obj = atomicReferenceFieldUpdater.get(c1925e);
                a5.d dVar = AbstractC1921a.c;
                if (obj == dVar) {
                    if (atomicReferenceFieldUpdater.compareAndSet(c1925e, dVar, this)) {
                        break;
                    }
                } else {
                    if (!(obj instanceof Throwable)) {
                        throw new IllegalStateException(androidx.compose.foundation.b.r(obj, "Inconsistent state "));
                    }
                    if (!atomicReferenceFieldUpdater.compareAndSet(c1925e, obj, null)) {
                        throw new IllegalArgumentException("Failed requirement.");
                    }
                    th = (Throwable) obj;
                }
            }
            if (th == null) {
                return;
            }
            t();
            l(th);
        }
    }

    public final void F(Object obj, int i, S7.o oVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Object obj2;
        do {
            atomicReferenceFieldUpdater = g;
            obj2 = atomicReferenceFieldUpdater.get(this);
            if (!(obj2 instanceof o0)) {
                if (obj2 instanceof C1719l) {
                    C1719l c1719l = (C1719l) obj2;
                    c1719l.getClass();
                    if (C1719l.c.compareAndSet(c1719l, 0, 1)) {
                        if (oVar != null) {
                            r(oVar, c1719l.f5333a, obj);
                            return;
                        }
                        return;
                    }
                }
                throw new IllegalStateException(androidx.compose.foundation.b.r(obj, "Already resumed, but proposed with update "));
            }
        } while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, H((o0) obj2, obj, i, oVar)));
        if (!B()) {
            t();
        }
        u(i);
    }

    public final void G(AbstractC1729v abstractC1729v) {
        H7.c cVar = this.d;
        C1925e c1925e = cVar instanceof C1925e ? (C1925e) cVar : null;
        F(C7.r.f317a, (c1925e != null ? c1925e.d : null) == abstractC1729v ? 4 : this.c, null);
    }

    public final a5.d I(Object obj, S7.o oVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Object obj2;
        a5.d dVar = AbstractC1683A.f5311a;
        do {
            atomicReferenceFieldUpdater = g;
            obj2 = atomicReferenceFieldUpdater.get(this);
            if (!(obj2 instanceof o0)) {
                return null;
            }
        } while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, H((o0) obj2, obj, this.c, oVar)));
        if (!B()) {
            t();
        }
        return dVar;
    }

    @Override // m9.y0
    public final void c(s9.p pVar, int i) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i6;
        do {
            atomicIntegerFieldUpdater = f;
            i6 = atomicIntegerFieldUpdater.get(this);
            if ((i6 & 536870911) != 536870911) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once");
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i6, ((i6 >> 29) << 29) + i));
        A(pVar);
    }

    @Override // m9.InterfaceC1717j
    public final void d(Object obj, S7.o oVar) {
        F(obj, this.c, oVar);
    }

    @Override // m9.InterfaceC1717j
    public final void e(S7.k kVar, Object obj) {
        F(obj, this.c, kVar != null ? new C0203b(kVar, 2) : null);
    }

    @Override // J7.b
    public final J7.b getCallerFrame() {
        H7.c cVar = this.d;
        if (cVar instanceof J7.b) {
            return (J7.b) cVar;
        }
        return null;
    }

    @Override // H7.c
    public final H7.h getContext() {
        return this.e;
    }

    @Override // m9.InterfaceC1717j
    public final a5.d h(Object obj, S7.o oVar) {
        return I(obj, oVar);
    }

    @Override // m9.AbstractC1689G
    public final void i(CancellationException cancellationException) {
        CancellationException cancellationException2;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = g;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof o0) {
                throw new IllegalStateException("Not completed");
            }
            if (obj instanceof C1727t) {
                return;
            }
            if (obj instanceof C1726s) {
                C1726s c1726s = (C1726s) obj;
                if (c1726s.e != null) {
                    throw new IllegalStateException("Must be called at most once");
                }
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj, C1726s.a(c1726s, null, cancellationException, 15))) {
                    InterfaceC1716i interfaceC1716i = c1726s.b;
                    if (interfaceC1716i != null) {
                        q(interfaceC1716i, cancellationException);
                    }
                    S7.o oVar = c1726s.c;
                    if (oVar != null) {
                        r(oVar, cancellationException, c1726s.f5332a);
                        return;
                    }
                    return;
                }
                cancellationException2 = cancellationException;
            } else {
                cancellationException2 = cancellationException;
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj, new C1726s(obj, (InterfaceC1716i) null, (S7.o) null, cancellationException2, 14))) {
                    return;
                }
            }
            cancellationException = cancellationException2;
        }
    }

    @Override // m9.InterfaceC1717j
    public final boolean isActive() {
        return g.get(this) instanceof o0;
    }

    @Override // m9.InterfaceC1717j
    public final void j(S7.k kVar) {
        A(new C1715h(kVar, 1));
    }

    @Override // m9.AbstractC1689G
    public final H7.c k() {
        return this.d;
    }

    @Override // m9.InterfaceC1717j
    public final boolean l(Throwable th) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Object obj;
        do {
            atomicReferenceFieldUpdater = g;
            obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof o0)) {
                return false;
            }
        } while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, new C1719l(this, th, (obj instanceof InterfaceC1716i) || (obj instanceof s9.p))));
        o0 o0Var = (o0) obj;
        if (o0Var instanceof InterfaceC1716i) {
            q((InterfaceC1716i) obj, th);
        } else if (o0Var instanceof s9.p) {
            s((s9.p) obj, th);
        }
        if (!B()) {
            t();
        }
        u(this.c);
        return true;
    }

    @Override // m9.AbstractC1689G
    public final Throwable m(Object obj) {
        Throwable thM = super.m(obj);
        if (thM != null) {
            return thM;
        }
        return null;
    }

    @Override // m9.AbstractC1689G
    public final Object n(Object obj) {
        return obj instanceof C1726s ? ((C1726s) obj).f5332a : obj;
    }

    @Override // m9.AbstractC1689G
    public final Object p() {
        return g.get(this);
    }

    public final void q(InterfaceC1716i interfaceC1716i, Throwable th) {
        try {
            interfaceC1716i.b(th);
        } catch (Throwable th2) {
            AbstractC1683A.k(this.e, new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void r(S7.o oVar, Throwable th, Object obj) {
        H7.h hVar = this.e;
        try {
            oVar.invoke(th, obj, hVar);
        } catch (Throwable th2) {
            AbstractC1683A.k(hVar, new CompletionHandlerException("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    @Override // H7.c
    public final void resumeWith(Object obj) {
        Throwable thA = Result.a(obj);
        if (thA != null) {
            obj = new C1727t(thA, false);
        }
        F(obj, this.c, null);
    }

    public final void s(s9.p pVar, Throwable th) {
        H7.h hVar = this.e;
        int i = f.get(this) & 536870911;
        if (i == 536870911) {
            throw new IllegalStateException("The index for Segment.onCancellation(..) is broken");
        }
        try {
            pVar.h(i, hVar);
        } catch (Throwable th2) {
            AbstractC1683A.k(hVar, new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void t() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = h;
        InterfaceC1693K interfaceC1693K = (InterfaceC1693K) atomicReferenceFieldUpdater.get(this);
        if (interfaceC1693K == null) {
            return;
        }
        interfaceC1693K.dispose();
        atomicReferenceFieldUpdater.set(this, n0.f5331a);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(D());
        sb.append('(');
        sb.append(AbstractC1683A.t(this.d));
        sb.append("){");
        Object obj = g.get(this);
        sb.append(obj instanceof o0 ? "Active" : obj instanceof C1719l ? "Cancelled" : "Completed");
        sb.append("}@");
        sb.append(AbstractC1683A.i(this));
        return sb.toString();
    }

    public final void u(int i) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i6;
        do {
            atomicIntegerFieldUpdater = f;
            i6 = atomicIntegerFieldUpdater.get(this);
            int i10 = i6 >> 29;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("Already resumed");
                }
                boolean z10 = i == 4;
                H7.c cVar = this.d;
                if (!z10 && (cVar instanceof C1925e)) {
                    boolean z11 = i == 1 || i == 2;
                    int i11 = this.c;
                    if (z11 == (i11 == 1 || i11 == 2)) {
                        C1925e c1925e = (C1925e) cVar;
                        AbstractC1729v abstractC1729v = c1925e.d;
                        H7.h context = c1925e.e.getContext();
                        if (abstractC1729v.isDispatchNeeded(context)) {
                            abstractC1729v.dispatch(context, this);
                            return;
                        }
                        AbstractC1701T abstractC1701TA = t0.a();
                        if (abstractC1701TA.f5319a >= 4294967296L) {
                            abstractC1701TA.F(this);
                            return;
                        }
                        abstractC1701TA.H(true);
                        try {
                            AbstractC1683A.q(this, cVar, true);
                            do {
                            } while (abstractC1701TA.J());
                        } finally {
                            try {
                                return;
                            } finally {
                            }
                        }
                        return;
                    }
                }
                AbstractC1683A.q(this, cVar, z10);
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i6, BasicMeasure.EXACTLY + (536870911 & i6)));
    }

    @Override // m9.InterfaceC1717j
    public final void v(Object obj) {
        u(this.c);
    }

    public Throwable w(kotlinx.coroutines.c cVar) {
        return cVar.i();
    }

    public final Object x() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i;
        c0 c0Var;
        boolean zB = B();
        do {
            atomicIntegerFieldUpdater = f;
            i = atomicIntegerFieldUpdater.get(this);
            int i6 = i >> 29;
            if (i6 != 0) {
                if (i6 != 2) {
                    throw new IllegalStateException("Already suspended");
                }
                if (zB) {
                    E();
                }
                Object obj = g.get(this);
                if (obj instanceof C1727t) {
                    throw ((C1727t) obj).f5333a;
                }
                int i10 = this.c;
                if ((i10 != 1 && i10 != 2) || (c0Var = (c0) this.e.get(b0.f5325a)) == null || c0Var.isActive()) {
                    return n(obj);
                }
                CancellationException cancellationExceptionI = c0Var.i();
                i(cancellationExceptionI);
                throw cancellationExceptionI;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, 536870912 + (536870911 & i)));
        if (((InterfaceC1693K) h.get(this)) == null) {
            z();
        }
        if (zB) {
            E();
        }
        return CoroutineSingletons.f4909a;
    }

    public final void y() {
        InterfaceC1693K interfaceC1693KZ = z();
        if (interfaceC1693KZ == null || (g.get(this) instanceof o0)) {
            return;
        }
        interfaceC1693KZ.dispose();
        h.set(this, n0.f5331a);
    }

    public final InterfaceC1693K z() {
        c0 c0Var = (c0) this.e.get(b0.f5325a);
        if (c0Var == null) {
            return null;
        }
        InterfaceC1693K interfaceC1693KJ = kotlinx.coroutines.a.j(c0Var, true, new C1720m(this, 0));
        h.compareAndSet(this, null, interfaceC1693KJ);
        return interfaceC1693KJ;
    }
}

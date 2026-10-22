package s4;

import Z3.i;
import a4.C0428b;
import i4.InterfaceC0772l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import s4.InterfaceC1081k0;
import s4.n0;
import x4.q;

/* loaded from: classes.dex */
public class u0 implements n0, InterfaceC1090s, B0 {

    /* renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f20371a = AtomicReferenceFieldUpdater.newUpdater(u0.class, Object.class, "_state$volatile");

    /* renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f20372b = AtomicReferenceFieldUpdater.newUpdater(u0.class, Object.class, "_parentHandle$volatile");
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    private static final class a<T> extends C1082l<T> {

        /* renamed from: i, reason: collision with root package name */
        private final u0 f20373i;

        public a(Z3.e<? super T> eVar, u0 u0Var) {
            super(eVar, 1);
            this.f20373i = u0Var;
        }

        @Override // s4.C1082l
        protected String K() {
            return "AwaitContinuation";
        }

        @Override // s4.C1082l
        public Throwable v(n0 n0Var) {
            Throwable thF;
            Object objB0 = this.f20373i.b0();
            return (!(objB0 instanceof c) || (thF = ((c) objB0).f()) == null) ? objB0 instanceof C1096y ? ((C1096y) objB0).f20398a : n0Var.w() : thF;
        }
    }

    private static final class b extends t0 {

        /* renamed from: e, reason: collision with root package name */
        private final u0 f20374e;

        /* renamed from: f, reason: collision with root package name */
        private final c f20375f;

        /* renamed from: g, reason: collision with root package name */
        private final r f20376g;

        /* renamed from: h, reason: collision with root package name */
        private final Object f20377h;

        public b(u0 u0Var, c cVar, r rVar, Object obj) {
            this.f20374e = u0Var;
            this.f20375f = cVar;
            this.f20376g = rVar;
            this.f20377h = obj;
        }

        @Override // s4.InterfaceC1081k0
        public void a(Throwable th) {
            this.f20374e.H(this.f20375f, this.f20376g, this.f20377h);
        }
    }

    private static final class c implements InterfaceC1077i0 {

        /* renamed from: b, reason: collision with root package name */
        private static final /* synthetic */ AtomicIntegerFieldUpdater f20378b = AtomicIntegerFieldUpdater.newUpdater(c.class, "_isCompleting$volatile");

        /* renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ AtomicReferenceFieldUpdater f20379c = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_rootCause$volatile");

        /* renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ AtomicReferenceFieldUpdater f20380d = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_exceptionsHolder$volatile");
        private volatile /* synthetic */ Object _exceptionsHolder$volatile;
        private volatile /* synthetic */ int _isCompleting$volatile;
        private volatile /* synthetic */ Object _rootCause$volatile;

        /* renamed from: a, reason: collision with root package name */
        private final y0 f20381a;

        public c(y0 y0Var, boolean z5, Throwable th) {
            this.f20381a = y0Var;
            this._isCompleting$volatile = z5 ? 1 : 0;
            this._rootCause$volatile = th;
        }

        private final ArrayList<Throwable> b() {
            return new ArrayList<>(4);
        }

        private final Object e() {
            return f20380d.get(this);
        }

        private final void o(Object obj) {
            f20380d.set(this, obj);
        }

        public final void a(Throwable th) {
            Throwable thF = f();
            if (thF == null) {
                p(th);
                return;
            }
            if (th == thF) {
                return;
            }
            Object objE = e();
            if (objE == null) {
                o(th);
                return;
            }
            if (objE instanceof Throwable) {
                if (th == objE) {
                    return;
                }
                ArrayList<Throwable> arrayListB = b();
                arrayListB.add(objE);
                arrayListB.add(th);
                o(arrayListB);
                return;
            }
            if (objE instanceof ArrayList) {
                ((ArrayList) objE).add(th);
                return;
            }
            throw new IllegalStateException(("State is " + objE).toString());
        }

        @Override // s4.InterfaceC1077i0
        public boolean c() {
            return f() == null;
        }

        @Override // s4.InterfaceC1077i0
        public y0 d() {
            return this.f20381a;
        }

        public final Throwable f() {
            return (Throwable) f20379c.get(this);
        }

        public final boolean j() {
            return f() != null;
        }

        public final boolean k() {
            return f20378b.get(this) != 0;
        }

        public final boolean l() {
            return e() == v0.f20388e;
        }

        public final List<Throwable> m(Throwable th) {
            ArrayList<Throwable> arrayListB;
            Object objE = e();
            if (objE == null) {
                arrayListB = b();
            } else if (objE instanceof Throwable) {
                ArrayList<Throwable> arrayListB2 = b();
                arrayListB2.add(objE);
                arrayListB = arrayListB2;
            } else {
                if (!(objE instanceof ArrayList)) {
                    throw new IllegalStateException(("State is " + objE).toString());
                }
                arrayListB = (ArrayList) objE;
            }
            Throwable thF = f();
            if (thF != null) {
                arrayListB.add(0, thF);
            }
            if (th != null && !j4.k.b(th, thF)) {
                arrayListB.add(th);
            }
            o(v0.f20388e);
            return arrayListB;
        }

        public final void n(boolean z5) {
            f20378b.set(this, z5 ? 1 : 0);
        }

        public final void p(Throwable th) {
            f20379c.set(this, th);
        }

        public String toString() {
            return "Finishing[cancelling=" + j() + ", completing=" + k() + ", rootCause=" + f() + ", exceptions=" + e() + ", list=" + d() + ']';
        }
    }

    public static final class d extends q.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ u0 f20382d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Object f20383e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(x4.q qVar, u0 u0Var, Object obj) {
            super(qVar);
            this.f20382d = u0Var;
            this.f20383e = obj;
        }

        @Override // x4.AbstractC1302b
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public Object e(x4.q qVar) {
            if (this.f20382d.b0() == this.f20383e) {
                return null;
            }
            return x4.p.a();
        }
    }

    public u0(boolean z5) {
        this._state$volatile = z5 ? v0.f20390g : v0.f20389f;
    }

    private final String A0(Object obj) {
        if (!(obj instanceof c)) {
            return obj instanceof InterfaceC1077i0 ? ((InterfaceC1077i0) obj).c() ? "Active" : "New" : obj instanceof C1096y ? "Cancelled" : "Completed";
        }
        c cVar = (c) obj;
        return cVar.j() ? "Cancelling" : cVar.k() ? "Completing" : "Active";
    }

    public static /* synthetic */ CancellationException C0(u0 u0Var, Throwable th, String str, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
        }
        if ((i5 & 1) != 0) {
            str = null;
        }
        return u0Var.B0(th, str);
    }

    private final boolean E0(InterfaceC1077i0 interfaceC1077i0, Object obj) throws Throwable {
        if (!f20371a.compareAndSet(this, interfaceC1077i0, v0.g(obj))) {
            return false;
        }
        s0(null);
        t0(obj);
        F(interfaceC1077i0, obj);
        return true;
    }

    private final void F(InterfaceC1077i0 interfaceC1077i0, Object obj) throws Throwable {
        InterfaceC1089q interfaceC1089qA0 = a0();
        if (interfaceC1089qA0 != null) {
            interfaceC1089qA0.dispose();
            y0(z0.f20401a);
        }
        C1096y c1096y = obj instanceof C1096y ? (C1096y) obj : null;
        Throwable th = c1096y != null ? c1096y.f20398a : null;
        if (!(interfaceC1077i0 instanceof t0)) {
            y0 y0VarD = interfaceC1077i0.d();
            if (y0VarD != null) {
                r0(y0VarD, th);
                return;
            }
            return;
        }
        try {
            ((t0) interfaceC1077i0).a(th);
        } catch (Throwable th2) {
            f0(new C1052A("Exception in completion handler " + interfaceC1077i0 + " for " + this, th2));
        }
    }

    private final boolean F0(InterfaceC1077i0 interfaceC1077i0, Throwable th) throws Throwable {
        y0 y0VarZ = Z(interfaceC1077i0);
        if (y0VarZ == null) {
            return false;
        }
        if (!f20371a.compareAndSet(this, interfaceC1077i0, new c(y0VarZ, false, th))) {
            return false;
        }
        q0(y0VarZ, th);
        return true;
    }

    private final Object G0(Object obj, Object obj2) {
        return !(obj instanceof InterfaceC1077i0) ? v0.f20384a : ((!(obj instanceof Z) && !(obj instanceof t0)) || (obj instanceof r) || (obj2 instanceof C1096y)) ? H0((InterfaceC1077i0) obj, obj2) : E0((InterfaceC1077i0) obj, obj2) ? obj2 : v0.f20386c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(c cVar, r rVar, Object obj) {
        r rVarP0 = p0(rVar);
        if (rVarP0 == null || !I0(cVar, rVarP0, obj)) {
            l(K(cVar, obj));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r2v2 */
    private final Object H0(InterfaceC1077i0 interfaceC1077i0, Object obj) throws Throwable {
        y0 y0VarZ = Z(interfaceC1077i0);
        if (y0VarZ == null) {
            return v0.f20386c;
        }
        c cVar = interfaceC1077i0 instanceof c ? (c) interfaceC1077i0 : null;
        if (cVar == null) {
            cVar = new c(y0VarZ, false, null);
        }
        j4.v vVar = new j4.v();
        synchronized (cVar) {
            if (cVar.k()) {
                return v0.f20384a;
            }
            cVar.n(true);
            if (cVar != interfaceC1077i0 && !f20371a.compareAndSet(this, interfaceC1077i0, cVar)) {
                return v0.f20386c;
            }
            boolean zJ = cVar.j();
            C1096y c1096y = obj instanceof C1096y ? (C1096y) obj : null;
            if (c1096y != null) {
                cVar.a(c1096y.f20398a);
            }
            ?? F5 = zJ ? 0 : cVar.f();
            vVar.f17836a = F5;
            V3.v vVar2 = V3.v.f5542a;
            if (F5 != 0) {
                q0(y0VarZ, F5);
            }
            r rVarM = M(interfaceC1077i0);
            return (rVarM == null || !I0(cVar, rVarM, obj)) ? K(cVar, obj) : v0.f20385b;
        }
    }

    private final boolean I0(c cVar, r rVar, Object obj) {
        while (s0.h(rVar.f20369e, false, false, new b(this, cVar, rVar, obj), 1, null) == z0.f20401a) {
            rVar = p0(rVar);
            if (rVar == null) {
                return false;
            }
        }
        return true;
    }

    private final Throwable J(Object obj) {
        if (obj == null ? true : obj instanceof Throwable) {
            Throwable th = (Throwable) obj;
            return th == null ? new o0(z(), null, this) : th;
        }
        j4.k.e(obj, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((B0) obj).U();
    }

    private final Object K(c cVar, Object obj) throws Throwable {
        boolean zJ;
        Throwable thQ;
        C1096y c1096y = obj instanceof C1096y ? (C1096y) obj : null;
        Throwable th = c1096y != null ? c1096y.f20398a : null;
        synchronized (cVar) {
            zJ = cVar.j();
            List<Throwable> listM = cVar.m(th);
            thQ = Q(cVar, listM);
            if (thQ != null) {
                k(thQ, listM);
            }
        }
        if (thQ != null && thQ != th) {
            obj = new C1096y(thQ, false, 2, null);
        }
        if (thQ != null && (y(thQ) || e0(thQ))) {
            j4.k.e(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            ((C1096y) obj).c();
        }
        if (!zJ) {
            s0(thQ);
        }
        t0(obj);
        f20371a.compareAndSet(this, cVar, v0.g(obj));
        F(cVar, obj);
        return obj;
    }

    private final r M(InterfaceC1077i0 interfaceC1077i0) {
        r rVar = interfaceC1077i0 instanceof r ? (r) interfaceC1077i0 : null;
        if (rVar != null) {
            return rVar;
        }
        y0 y0VarD = interfaceC1077i0.d();
        if (y0VarD != null) {
            return p0(y0VarD);
        }
        return null;
    }

    private final Throwable P(Object obj) {
        C1096y c1096y = obj instanceof C1096y ? (C1096y) obj : null;
        if (c1096y != null) {
            return c1096y.f20398a;
        }
        return null;
    }

    private final Throwable Q(c cVar, List<? extends Throwable> list) {
        Object obj = null;
        if (list.isEmpty()) {
            if (cVar.j()) {
                return new o0(z(), null, this);
            }
            return null;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (!(((Throwable) next) instanceof CancellationException)) {
                obj = next;
                break;
            }
        }
        Throwable th = (Throwable) obj;
        return th != null ? th : list.get(0);
    }

    private final y0 Z(InterfaceC1077i0 interfaceC1077i0) {
        y0 y0VarD = interfaceC1077i0.d();
        if (y0VarD != null) {
            return y0VarD;
        }
        if (interfaceC1077i0 instanceof Z) {
            return new y0();
        }
        if (interfaceC1077i0 instanceof t0) {
            w0((t0) interfaceC1077i0);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + interfaceC1077i0).toString());
    }

    private final boolean j(Object obj, y0 y0Var, t0 t0Var) {
        int iU;
        d dVar = new d(t0Var, this, obj);
        do {
            iU = y0Var.m().u(t0Var, y0Var, dVar);
            if (iU == 1) {
                return true;
            }
        } while (iU != 2);
        return false;
    }

    private final void k(Throwable th, List<? extends Throwable> list) {
        if (list.size() <= 1) {
            return;
        }
        Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
        for (Throwable th2 : list) {
            if (th2 != th && th2 != th && !(th2 instanceof CancellationException) && setNewSetFromMap.add(th2)) {
                V3.a.a(th, th2);
            }
        }
    }

    private final Object k0(Object obj) throws Throwable {
        Throwable thJ = null;
        while (true) {
            Object objB0 = b0();
            if (objB0 instanceof c) {
                synchronized (objB0) {
                    if (((c) objB0).l()) {
                        return v0.f20387d;
                    }
                    boolean zJ = ((c) objB0).j();
                    if (obj != null || !zJ) {
                        if (thJ == null) {
                            thJ = J(obj);
                        }
                        ((c) objB0).a(thJ);
                    }
                    Throwable thF = zJ ? null : ((c) objB0).f();
                    if (thF != null) {
                        q0(((c) objB0).d(), thF);
                    }
                    return v0.f20384a;
                }
            }
            if (!(objB0 instanceof InterfaceC1077i0)) {
                return v0.f20387d;
            }
            if (thJ == null) {
                thJ = J(obj);
            }
            InterfaceC1077i0 interfaceC1077i0 = (InterfaceC1077i0) objB0;
            if (!interfaceC1077i0.c()) {
                Object objG0 = G0(objB0, new C1096y(thJ, false, 2, null));
                if (objG0 == v0.f20384a) {
                    throw new IllegalStateException(("Cannot happen in " + objB0).toString());
                }
                if (objG0 != v0.f20386c) {
                    return objG0;
                }
            } else if (F0(interfaceC1077i0, thJ)) {
                return v0.f20384a;
            }
        }
    }

    private final t0 n0(InterfaceC1081k0 interfaceC1081k0, boolean z5) {
        t0 c1085m0;
        if (z5) {
            c1085m0 = interfaceC1081k0 instanceof p0 ? (p0) interfaceC1081k0 : null;
            if (c1085m0 == null) {
                c1085m0 = new C1083l0(interfaceC1081k0);
            }
        } else {
            c1085m0 = interfaceC1081k0 instanceof t0 ? (t0) interfaceC1081k0 : null;
            if (c1085m0 == null) {
                c1085m0 = new C1085m0(interfaceC1081k0);
            }
        }
        c1085m0.w(this);
        return c1085m0;
    }

    private final Object p(Z3.e<Object> eVar) {
        a aVar = new a(C0428b.c(eVar), this);
        aVar.D();
        C1086n.a(aVar, s0.h(this, false, false, new C0(aVar), 3, null));
        Object objX = aVar.x();
        if (objX == C0428b.e()) {
            kotlin.coroutines.jvm.internal.h.c(eVar);
        }
        return objX;
    }

    private final r p0(x4.q qVar) {
        while (qVar.q()) {
            qVar = qVar.m();
        }
        while (true) {
            qVar = qVar.l();
            if (!qVar.q()) {
                if (qVar instanceof r) {
                    return (r) qVar;
                }
                if (qVar instanceof y0) {
                    return null;
                }
            }
        }
    }

    private final void q0(y0 y0Var, Throwable th) throws Throwable {
        s0(th);
        Object objK = y0Var.k();
        j4.k.e(objK, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        C1052A c1052a = null;
        for (x4.q qVarL = (x4.q) objK; !j4.k.b(qVarL, y0Var); qVarL = qVarL.l()) {
            if (qVarL instanceof p0) {
                t0 t0Var = (t0) qVarL;
                try {
                    t0Var.a(th);
                } catch (Throwable th2) {
                    if (c1052a != null) {
                        V3.a.a(c1052a, th2);
                    } else {
                        c1052a = new C1052A("Exception in completion handler " + t0Var + " for " + this, th2);
                        V3.v vVar = V3.v.f5542a;
                    }
                }
            }
        }
        if (c1052a != null) {
            f0(c1052a);
        }
        y(th);
    }

    private final void r0(y0 y0Var, Throwable th) throws Throwable {
        Object objK = y0Var.k();
        j4.k.e(objK, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        C1052A c1052a = null;
        for (x4.q qVarL = (x4.q) objK; !j4.k.b(qVarL, y0Var); qVarL = qVarL.l()) {
            if (qVarL instanceof t0) {
                t0 t0Var = (t0) qVarL;
                try {
                    t0Var.a(th);
                } catch (Throwable th2) {
                    if (c1052a != null) {
                        V3.a.a(c1052a, th2);
                    } else {
                        c1052a = new C1052A("Exception in completion handler " + t0Var + " for " + this, th2);
                        V3.v vVar = V3.v.f5542a;
                    }
                }
            }
        }
        if (c1052a != null) {
            f0(c1052a);
        }
    }

    private final Object t(Object obj) {
        Object objG0;
        do {
            Object objB0 = b0();
            if (!(objB0 instanceof InterfaceC1077i0) || ((objB0 instanceof c) && ((c) objB0).k())) {
                return v0.f20384a;
            }
            objG0 = G0(objB0, new C1096y(J(obj), false, 2, null));
        } while (objG0 == v0.f20386c);
        return objG0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [s4.h0] */
    private final void v0(Z z5) {
        y0 y0Var = new y0();
        if (!z5.c()) {
            y0Var = new C1075h0(y0Var);
        }
        f20371a.compareAndSet(this, z5, y0Var);
    }

    private final void w0(t0 t0Var) {
        t0Var.g(new y0());
        f20371a.compareAndSet(this, t0Var, t0Var.l());
    }

    private final boolean y(Throwable th) {
        if (j0()) {
            return true;
        }
        boolean z5 = th instanceof CancellationException;
        InterfaceC1089q interfaceC1089qA0 = a0();
        return (interfaceC1089qA0 == null || interfaceC1089qA0 == z0.f20401a) ? z5 : interfaceC1089qA0.b(th) || z5;
    }

    private final int z0(Object obj) {
        if (obj instanceof Z) {
            if (((Z) obj).c()) {
                return 0;
            }
            if (!f20371a.compareAndSet(this, obj, v0.f20390g)) {
                return -1;
            }
            u0();
            return 1;
        }
        if (!(obj instanceof C1075h0)) {
            return 0;
        }
        if (!f20371a.compareAndSet(this, obj, ((C1075h0) obj).d())) {
            return -1;
        }
        u0();
        return 1;
    }

    public boolean B(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return r(th) && R();
    }

    protected final CancellationException B0(Throwable th, String str) {
        CancellationException o0Var = th instanceof CancellationException ? (CancellationException) th : null;
        if (o0Var == null) {
            if (str == null) {
                str = z();
            }
            o0Var = new o0(str, th, this);
        }
        return o0Var;
    }

    @Override // Z3.i
    public Z3.i C(Z3.i iVar) {
        return n0.a.e(this, iVar);
    }

    public final String D0() {
        return o0() + '{' + A0(b0()) + '}';
    }

    @Override // s4.InterfaceC1090s
    public final void E(B0 b02) throws Throwable {
        r(b02);
    }

    public boolean R() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Throwable] */
    @Override // s4.B0
    public CancellationException U() {
        CancellationException cancellationExceptionF;
        Object objB0 = b0();
        if (objB0 instanceof c) {
            cancellationExceptionF = ((c) objB0).f();
        } else if (objB0 instanceof C1096y) {
            cancellationExceptionF = ((C1096y) objB0).f20398a;
        } else {
            if (objB0 instanceof InterfaceC1077i0) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + objB0).toString());
            }
            cancellationExceptionF = null;
        }
        CancellationException cancellationException = cancellationExceptionF instanceof CancellationException ? cancellationExceptionF : null;
        if (cancellationException != null) {
            return cancellationException;
        }
        return new o0("Parent job is " + A0(objB0), cancellationExceptionF, this);
    }

    @Override // Z3.i
    public Z3.i W(i.c<?> cVar) {
        return n0.a.d(this, cVar);
    }

    @Override // s4.n0
    public void X(CancellationException cancellationException) throws Throwable {
        if (cancellationException == null) {
            cancellationException = new o0(z(), null, this);
        }
        s(cancellationException);
    }

    public boolean Y() {
        return false;
    }

    @Override // Z3.i.b, Z3.i
    public <E extends i.b> E a(i.c<E> cVar) {
        return (E) n0.a.c(this, cVar);
    }

    public final InterfaceC1089q a0() {
        return (InterfaceC1089q) f20372b.get(this);
    }

    public final Object b0() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f20371a;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof x4.y)) {
                return obj;
            }
            ((x4.y) obj).a(this);
        }
    }

    @Override // s4.n0
    public boolean c() {
        Object objB0 = b0();
        return (objB0 instanceof InterfaceC1077i0) && ((InterfaceC1077i0) objB0).c();
    }

    protected boolean e0(Throwable th) {
        return false;
    }

    public void f0(Throwable th) throws Throwable {
        throw th;
    }

    protected final void g0(n0 n0Var) {
        if (n0Var == null) {
            y0(z0.f20401a);
            return;
        }
        n0Var.start();
        InterfaceC1089q interfaceC1089qM = n0Var.m(this);
        y0(interfaceC1089qM);
        if (i0()) {
            interfaceC1089qM.dispose();
            y0(z0.f20401a);
        }
    }

    @Override // Z3.i.b
    public final i.c<?> getKey() {
        return n0.f20363P;
    }

    @Override // s4.n0
    public n0 getParent() {
        InterfaceC1089q interfaceC1089qA0 = a0();
        if (interfaceC1089qA0 != null) {
            return interfaceC1089qA0.getParent();
        }
        return null;
    }

    public final X h0(boolean z5, boolean z6, InterfaceC1081k0 interfaceC1081k0) {
        t0 t0VarN0 = n0(interfaceC1081k0, z5);
        while (true) {
            Object objB0 = b0();
            if (objB0 instanceof Z) {
                Z z7 = (Z) objB0;
                if (!z7.c()) {
                    v0(z7);
                } else if (f20371a.compareAndSet(this, objB0, t0VarN0)) {
                    break;
                }
            } else {
                if (!(objB0 instanceof InterfaceC1077i0)) {
                    if (z6) {
                        C1096y c1096y = objB0 instanceof C1096y ? (C1096y) objB0 : null;
                        interfaceC1081k0.a(c1096y != null ? c1096y.f20398a : null);
                    }
                    return z0.f20401a;
                }
                y0 y0VarD = ((InterfaceC1077i0) objB0).d();
                if (y0VarD == null) {
                    j4.k.e(objB0, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    w0((t0) objB0);
                } else {
                    X x5 = z0.f20401a;
                    if (z5 && (objB0 instanceof c)) {
                        synchronized (objB0) {
                            try {
                                thF = ((c) objB0).f();
                                if (thF == null || ((interfaceC1081k0 instanceof r) && !((c) objB0).k())) {
                                    if (j(objB0, y0VarD, t0VarN0)) {
                                        if (thF == null) {
                                            return t0VarN0;
                                        }
                                        x5 = t0VarN0;
                                    }
                                }
                                V3.v vVar = V3.v.f5542a;
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                    if (thF != null) {
                        if (z6) {
                            interfaceC1081k0.a(thF);
                        }
                        return x5;
                    }
                    if (j(objB0, y0VarD, t0VarN0)) {
                        break;
                    }
                }
            }
        }
        return t0VarN0;
    }

    public final boolean i0() {
        return !(b0() instanceof InterfaceC1077i0);
    }

    protected boolean j0() {
        return false;
    }

    protected void l(Object obj) {
    }

    public final boolean l0(Object obj) {
        Object objG0;
        do {
            objG0 = G0(b0(), obj);
            if (objG0 == v0.f20384a) {
                return false;
            }
            if (objG0 == v0.f20385b) {
                return true;
            }
        } while (objG0 == v0.f20386c);
        l(objG0);
        return true;
    }

    @Override // s4.n0
    public final InterfaceC1089q m(InterfaceC1090s interfaceC1090s) {
        X xH = s0.h(this, true, false, new r(interfaceC1090s), 2, null);
        j4.k.e(xH, "null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
        return (InterfaceC1089q) xH;
    }

    public final Object m0(Object obj) {
        Object objG0;
        do {
            objG0 = G0(b0(), obj);
            if (objG0 == v0.f20384a) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, P(obj));
            }
        } while (objG0 == v0.f20386c);
        return objG0;
    }

    protected final Object n(Z3.e<Object> eVar) throws Throwable {
        Object objB0;
        do {
            objB0 = b0();
            if (!(objB0 instanceof InterfaceC1077i0)) {
                if (objB0 instanceof C1096y) {
                    throw ((C1096y) objB0).f20398a;
                }
                return v0.h(objB0);
            }
        } while (z0(objB0) < 0);
        return p(eVar);
    }

    @Override // Z3.i
    public <R> R o(R r5, i4.p<? super R, ? super i.b, ? extends R> pVar) {
        return (R) n0.a.b(this, r5, pVar);
    }

    public String o0() {
        return M.a(this);
    }

    public final boolean q(Throwable th) {
        return r(th);
    }

    public final boolean r(Object obj) throws Throwable {
        Object objK0 = v0.f20384a;
        if (Y() && (objK0 = t(obj)) == v0.f20385b) {
            return true;
        }
        if (objK0 == v0.f20384a) {
            objK0 = k0(obj);
        }
        if (objK0 == v0.f20384a || objK0 == v0.f20385b) {
            return true;
        }
        if (objK0 == v0.f20387d) {
            return false;
        }
        l(objK0);
        return true;
    }

    public void s(Throwable th) throws Throwable {
        r(th);
    }

    protected void s0(Throwable th) {
    }

    @Override // s4.n0
    public final boolean start() {
        int iZ0;
        do {
            iZ0 = z0(b0());
            if (iZ0 == 0) {
                return false;
            }
        } while (iZ0 != 1);
        return true;
    }

    protected void t0(Object obj) {
    }

    public String toString() {
        return D0() + '@' + M.b(this);
    }

    @Override // s4.n0
    public final X u(InterfaceC0772l<? super Throwable, V3.v> interfaceC0772l) {
        return h0(false, true, new InterfaceC1081k0.a(interfaceC0772l));
    }

    protected void u0() {
    }

    @Override // s4.n0
    public final CancellationException w() {
        Object objB0 = b0();
        if (!(objB0 instanceof c)) {
            if (objB0 instanceof InterfaceC1077i0) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            if (objB0 instanceof C1096y) {
                return C0(this, ((C1096y) objB0).f20398a, null, 1, null);
            }
            return new o0(M.a(this) + " has completed normally", null, this);
        }
        Throwable thF = ((c) objB0).f();
        if (thF != null) {
            CancellationException cancellationExceptionB0 = B0(thF, M.a(this) + " is cancelling");
            if (cancellationExceptionB0 != null) {
                return cancellationExceptionB0;
            }
        }
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    @Override // s4.n0
    public final X x(boolean z5, boolean z6, InterfaceC0772l<? super Throwable, V3.v> interfaceC0772l) {
        return h0(z5, z6, new InterfaceC1081k0.a(interfaceC0772l));
    }

    public final void x0(t0 t0Var) {
        Object objB0;
        do {
            objB0 = b0();
            if (!(objB0 instanceof t0)) {
                if (!(objB0 instanceof InterfaceC1077i0) || ((InterfaceC1077i0) objB0).d() == null) {
                    return;
                }
                t0Var.r();
                return;
            }
            if (objB0 != t0Var) {
                return;
            }
        } while (!f20371a.compareAndSet(this, objB0, v0.f20390g));
    }

    public final void y0(InterfaceC1089q interfaceC1089q) {
        f20372b.set(this, interfaceC1089q);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String z() {
        return "Job was cancelled";
    }
}

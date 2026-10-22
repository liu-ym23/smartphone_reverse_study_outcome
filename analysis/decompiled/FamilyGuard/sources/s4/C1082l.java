package s4;

import a4.C0428b;
import i4.InterfaceC0772l;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import s4.InterfaceC1078j;
import x4.AbstractC1291C;
import x4.C1294F;
import x4.C1310j;

/* renamed from: s4.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1082l<T> extends U<T> implements InterfaceC1080k<T>, kotlin.coroutines.jvm.internal.e, L0 {

    /* renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f20354f = AtomicIntegerFieldUpdater.newUpdater(C1082l.class, "_decisionAndIndex$volatile");

    /* renamed from: g, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f20355g = AtomicReferenceFieldUpdater.newUpdater(C1082l.class, Object.class, "_state$volatile");

    /* renamed from: h, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f20356h = AtomicReferenceFieldUpdater.newUpdater(C1082l.class, Object.class, "_parentHandle$volatile");
    private volatile /* synthetic */ int _decisionAndIndex$volatile;
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    /* renamed from: d, reason: collision with root package name */
    private final Z3.e<T> f20357d;

    /* renamed from: e, reason: collision with root package name */
    private final Z3.i f20358e;

    /* JADX WARN: Multi-variable type inference failed */
    public C1082l(Z3.e<? super T> eVar, int i5) {
        super(i5);
        this.f20357d = eVar;
        this.f20358e = eVar.getContext();
        this._decisionAndIndex$volatile = 536870911;
        this._state$volatile = C1066d.f20341a;
    }

    private final X E() {
        n0 n0Var = (n0) getContext().a(n0.f20363P);
        if (n0Var == null) {
            return null;
        }
        X xH = s0.h(n0Var, true, false, new C1088p(this), 2, null);
        f20356h.compareAndSet(this, null, xH);
        return xH;
    }

    private final void F(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f20355g;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (!(obj2 instanceof C1066d)) {
                if (obj2 instanceof InterfaceC1078j ? true : obj2 instanceof AbstractC1291C) {
                    J(obj, obj2);
                } else {
                    if (obj2 instanceof C1096y) {
                        C1096y c1096y = (C1096y) obj2;
                        if (!c1096y.c()) {
                            J(obj, obj2);
                        }
                        if (obj2 instanceof C1087o) {
                            if (obj2 == null) {
                                c1096y = null;
                            }
                            Throwable th = c1096y != null ? c1096y.f20398a : null;
                            if (obj instanceof InterfaceC1078j) {
                                n((InterfaceC1078j) obj, th);
                                return;
                            } else {
                                j4.k.e(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
                                p((AbstractC1291C) obj, th);
                                return;
                            }
                        }
                        return;
                    }
                    if (obj2 instanceof C1095x) {
                        C1095x c1095x = (C1095x) obj2;
                        if (c1095x.f20393b != null) {
                            J(obj, obj2);
                        }
                        if (obj instanceof AbstractC1291C) {
                            return;
                        }
                        j4.k.e(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                        InterfaceC1078j interfaceC1078j = (InterfaceC1078j) obj;
                        if (c1095x.c()) {
                            n(interfaceC1078j, c1095x.f20396e);
                            return;
                        } else {
                            if (f20355g.compareAndSet(this, obj2, C1095x.b(c1095x, null, interfaceC1078j, null, null, null, 29, null))) {
                                return;
                            }
                        }
                    } else {
                        if (obj instanceof AbstractC1291C) {
                            return;
                        }
                        j4.k.e(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                        if (f20355g.compareAndSet(this, obj2, new C1095x(obj2, (InterfaceC1078j) obj, null, null, null, 28, null))) {
                            return;
                        }
                    }
                }
            } else if (f20355g.compareAndSet(this, obj2, obj)) {
                return;
            }
        }
    }

    private final boolean I() {
        if (!V.c(this.f20322c)) {
            return false;
        }
        Z3.e<T> eVar = this.f20357d;
        j4.k.e(eVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return ((C1310j) eVar).q();
    }

    private final void J(Object obj, Object obj2) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + obj + ", already has " + obj2).toString());
    }

    private final void O(Object obj, int i5, InterfaceC0772l<? super Throwable, V3.v> interfaceC0772l) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f20355g;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (!(obj2 instanceof A0)) {
                C1082l<T> c1082l = this;
                Object obj3 = obj;
                InterfaceC0772l<? super Throwable, V3.v> interfaceC0772l2 = interfaceC0772l;
                if (obj2 instanceof C1087o) {
                    C1087o c1087o = (C1087o) obj2;
                    if (c1087o.e()) {
                        if (interfaceC0772l2 != null) {
                            c1082l.o(interfaceC0772l2, c1087o.f20398a);
                            return;
                        }
                        return;
                    }
                }
                c1082l.m(obj3);
                throw new V3.d();
            }
            C1082l<T> c1082l2 = this;
            Object obj4 = obj;
            int i6 = i5;
            InterfaceC0772l<? super Throwable, V3.v> interfaceC0772l3 = interfaceC0772l;
            if (f20355g.compareAndSet(c1082l2, obj2, c1082l2.Q((A0) obj2, obj4, i6, interfaceC0772l3, null))) {
                c1082l2.t();
                c1082l2.u(i6);
                return;
            } else {
                this = c1082l2;
                obj = obj4;
                i5 = i6;
                interfaceC0772l = interfaceC0772l3;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void P(C1082l c1082l, Object obj, int i5, InterfaceC0772l interfaceC0772l, int i6, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
        }
        if ((i6 & 4) != 0) {
            interfaceC0772l = null;
        }
        c1082l.O(obj, i5, interfaceC0772l);
    }

    private final Object Q(A0 a02, Object obj, int i5, InterfaceC0772l<? super Throwable, V3.v> interfaceC0772l, Object obj2) {
        if (obj instanceof C1096y) {
            return obj;
        }
        if ((V.b(i5) || obj2 != null) && !(interfaceC0772l == null && !(a02 instanceof InterfaceC1078j) && obj2 == null)) {
            return new C1095x(obj, a02 instanceof InterfaceC1078j ? (InterfaceC1078j) a02 : null, interfaceC0772l, obj2, null, 16, null);
        }
        return obj;
    }

    private final boolean R() {
        int i5;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f20354f;
        do {
            i5 = atomicIntegerFieldUpdater.get(this);
            int i6 = i5 >> 29;
            if (i6 != 0) {
                if (i6 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed");
            }
        } while (!f20354f.compareAndSet(this, i5, 1073741824 + (536870911 & i5)));
        return true;
    }

    private final C1294F S(Object obj, Object obj2, InterfaceC0772l<? super Throwable, V3.v> interfaceC0772l) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f20355g;
        while (true) {
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (!(obj3 instanceof A0)) {
                Object obj4 = obj2;
                if ((obj3 instanceof C1095x) && obj4 != null && ((C1095x) obj3).f20395d == obj4) {
                    return C1084m.f20361a;
                }
                return null;
            }
            C1082l<T> c1082l = this;
            Object obj5 = obj;
            Object obj6 = obj2;
            InterfaceC0772l<? super Throwable, V3.v> interfaceC0772l2 = interfaceC0772l;
            if (f20355g.compareAndSet(c1082l, obj3, c1082l.Q((A0) obj3, obj5, this.f20322c, interfaceC0772l2, obj6))) {
                c1082l.t();
                return C1084m.f20361a;
            }
            this = c1082l;
            obj = obj5;
            interfaceC0772l = interfaceC0772l2;
            obj2 = obj6;
        }
    }

    private final boolean T() {
        int i5;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f20354f;
        do {
            i5 = atomicIntegerFieldUpdater.get(this);
            int i6 = i5 >> 29;
            if (i6 != 0) {
                if (i6 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended");
            }
        } while (!f20354f.compareAndSet(this, i5, 536870912 + (536870911 & i5)));
        return true;
    }

    private final Void m(Object obj) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
    }

    private final void p(AbstractC1291C<?> abstractC1291C, Throwable th) {
        int i5 = f20354f.get(this) & 536870911;
        if (i5 == 536870911) {
            throw new IllegalStateException("The index for Segment.onCancellation(..) is broken");
        }
        try {
            abstractC1291C.s(i5, th, getContext());
        } catch (Throwable th2) {
            C1058G.a(getContext(), new C1052A("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    private final boolean r(Throwable th) {
        if (!I()) {
            return false;
        }
        Z3.e<T> eVar = this.f20357d;
        j4.k.e(eVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return ((C1310j) eVar).r(th);
    }

    private final void t() {
        if (I()) {
            return;
        }
        s();
    }

    private final void u(int i5) {
        if (R()) {
            return;
        }
        V.a(this, i5);
    }

    private final X w() {
        return (X) f20356h.get(this);
    }

    private final String z() {
        Object objY = y();
        return objY instanceof A0 ? "Active" : objY instanceof C1087o ? "Cancelled" : "Completed";
    }

    public void D() {
        X xE = E();
        if (xE != null && H()) {
            xE.dispose();
            f20356h.set(this, z0.f20401a);
        }
    }

    public final void G(InterfaceC1078j interfaceC1078j) {
        F(interfaceC1078j);
    }

    public boolean H() {
        return !(y() instanceof A0);
    }

    protected String K() {
        return "CancellableContinuation";
    }

    public final void L(Throwable th) {
        if (r(th)) {
            return;
        }
        q(th);
        t();
    }

    public final void M() {
        Throwable thT;
        Z3.e<T> eVar = this.f20357d;
        C1310j c1310j = eVar instanceof C1310j ? (C1310j) eVar : null;
        if (c1310j == null || (thT = c1310j.t(this)) == null) {
            return;
        }
        s();
        q(thT);
    }

    public final boolean N() {
        Object obj = f20355g.get(this);
        if ((obj instanceof C1095x) && ((C1095x) obj).f20395d != null) {
            s();
            return false;
        }
        f20354f.set(this, 536870911);
        f20355g.set(this, C1066d.f20341a);
        return true;
    }

    @Override // s4.U
    public void a(Object obj, Throwable th) {
        Throwable th2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f20355g;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof A0) {
                throw new IllegalStateException("Not completed");
            }
            if (obj2 instanceof C1096y) {
                return;
            }
            if (obj2 instanceof C1095x) {
                C1095x c1095x = (C1095x) obj2;
                if (c1095x.c()) {
                    throw new IllegalStateException("Must be called at most once");
                }
                Throwable th3 = th;
                th2 = th3;
                if (f20355g.compareAndSet(this, obj2, C1095x.b(c1095x, null, null, null, null, th3, 15, null))) {
                    c1095x.d(this, th2);
                    return;
                }
            } else {
                th2 = th;
                if (f20355g.compareAndSet(this, obj2, new C1095x(obj2, null, null, null, th2, 14, null))) {
                    return;
                }
            }
            th = th2;
        }
    }

    @Override // s4.InterfaceC1080k
    public void b(T t5, InterfaceC0772l<? super Throwable, V3.v> interfaceC0772l) {
        O(t5, this.f20322c, interfaceC0772l);
    }

    @Override // s4.L0
    public void c(AbstractC1291C<?> abstractC1291C, int i5) {
        int i6;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f20354f;
        do {
            i6 = atomicIntegerFieldUpdater.get(this);
            if ((i6 & 536870911) != 536870911) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once");
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i6, ((i6 >> 29) << 29) + i5));
        F(abstractC1291C);
    }

    @Override // s4.InterfaceC1080k
    public void d(AbstractC1056E abstractC1056E, T t5) {
        Z3.e<T> eVar = this.f20357d;
        C1310j c1310j = eVar instanceof C1310j ? (C1310j) eVar : null;
        P(this, t5, (c1310j != null ? c1310j.f23857d : null) == abstractC1056E ? 4 : this.f20322c, null, 4, null);
    }

    @Override // s4.InterfaceC1080k
    public Object e(T t5, Object obj, InterfaceC0772l<? super Throwable, V3.v> interfaceC0772l) {
        return S(t5, obj, interfaceC0772l);
    }

    @Override // s4.InterfaceC1080k
    public void f(InterfaceC0772l<? super Throwable, V3.v> interfaceC0772l) {
        C1086n.c(this, new InterfaceC1078j.a(interfaceC0772l));
    }

    @Override // s4.U
    public final Z3.e<T> g() {
        return this.f20357d;
    }

    @Override // kotlin.coroutines.jvm.internal.e
    public kotlin.coroutines.jvm.internal.e getCallerFrame() {
        Z3.e<T> eVar = this.f20357d;
        if (eVar instanceof kotlin.coroutines.jvm.internal.e) {
            return (kotlin.coroutines.jvm.internal.e) eVar;
        }
        return null;
    }

    @Override // Z3.e
    public Z3.i getContext() {
        return this.f20358e;
    }

    @Override // s4.InterfaceC1080k
    public void h(Object obj) {
        u(this.f20322c);
    }

    @Override // s4.U
    public Throwable i(Object obj) {
        Throwable thI = super.i(obj);
        if (thI != null) {
            return thI;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // s4.U
    public <T> T j(Object obj) {
        return obj instanceof C1095x ? (T) ((C1095x) obj).f20392a : obj;
    }

    @Override // s4.U
    public Object l() {
        return y();
    }

    public final void n(InterfaceC1078j interfaceC1078j, Throwable th) {
        try {
            interfaceC1078j.a(th);
        } catch (Throwable th2) {
            C1058G.a(getContext(), new C1052A("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void o(InterfaceC0772l<? super Throwable, V3.v> interfaceC0772l, Throwable th) {
        try {
            interfaceC0772l.invoke(th);
        } catch (Throwable th2) {
            C1058G.a(getContext(), new C1052A("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    public boolean q(Throwable th) {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f20355g;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof A0)) {
                return false;
            }
        } while (!f20355g.compareAndSet(this, obj, new C1087o(this, th, (obj instanceof InterfaceC1078j) || (obj instanceof AbstractC1291C))));
        A0 a02 = (A0) obj;
        if (a02 instanceof InterfaceC1078j) {
            n((InterfaceC1078j) obj, th);
        } else if (a02 instanceof AbstractC1291C) {
            p((AbstractC1291C) obj, th);
        }
        t();
        u(this.f20322c);
        return true;
    }

    @Override // Z3.e
    public void resumeWith(Object obj) {
        P(this, C1053B.c(obj, this), this.f20322c, null, 4, null);
    }

    public final void s() {
        X xW = w();
        if (xW == null) {
            return;
        }
        xW.dispose();
        f20356h.set(this, z0.f20401a);
    }

    public String toString() {
        return K() + '(' + M.c(this.f20357d) + "){" + z() + "}@" + M.b(this);
    }

    public Throwable v(n0 n0Var) {
        return n0Var.w();
    }

    public final Object x() {
        n0 n0Var;
        boolean zI = I();
        if (T()) {
            if (w() == null) {
                E();
            }
            if (zI) {
                M();
            }
            return C0428b.e();
        }
        if (zI) {
            M();
        }
        Object objY = y();
        if (objY instanceof C1096y) {
            throw ((C1096y) objY).f20398a;
        }
        if (!V.b(this.f20322c) || (n0Var = (n0) getContext().a(n0.f20363P)) == null || n0Var.c()) {
            return j(objY);
        }
        CancellationException cancellationExceptionW = n0Var.w();
        a(objY, cancellationExceptionW);
        throw cancellationExceptionW;
    }

    public final Object y() {
        return f20355g.get(this);
    }
}

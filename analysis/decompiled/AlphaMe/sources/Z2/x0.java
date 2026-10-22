package Z2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public class x0 implements o0, InterfaceC0138m, C0 {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f2258a = AtomicReferenceFieldUpdater.newUpdater(x0.class, Object.class, "_state");

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f2259b = AtomicReferenceFieldUpdater.newUpdater(x0.class, Object.class, "_parentHandle");

    @Volatile
    @Nullable
    private volatile Object _parentHandle;

    @Volatile
    @Nullable
    private volatile Object _state;

    public x0(boolean z4) {
        this._state = z4 ? I.f2179l : I.f2178k;
    }

    public static C0136l P(d3.m mVar) {
        while (mVar.h()) {
            d3.m mVarD = mVar.d();
            if (mVarD == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = d3.m.f12466b;
                Object obj = atomicReferenceFieldUpdater.get(mVar);
                while (true) {
                    mVar = (d3.m) obj;
                    if (!mVar.h()) {
                        break;
                    }
                    obj = atomicReferenceFieldUpdater.get(mVar);
                }
            } else {
                mVar = mVarD;
            }
        }
        while (true) {
            mVar = mVar.g();
            if (!mVar.h()) {
                if (mVar instanceof C0136l) {
                    return (C0136l) mVar;
                }
                if (mVar instanceof z0) {
                    return null;
                }
            }
        }
    }

    public static String V(Object obj) {
        if (!(obj instanceof v0)) {
            return obj instanceof InterfaceC0131i0 ? ((InterfaceC0131i0) obj).a() ? "Active" : "New" : obj instanceof r ? "Cancelled" : "Completed";
        }
        v0 v0Var = (v0) obj;
        return v0Var.e() ? "Cancelling" : v0Var.f() ? "Completing" : "Active";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.lang.Throwable] */
    public final Throwable A(Object obj) {
        CancellationException cancellationExceptionD;
        if (obj == null || (obj instanceof Throwable)) {
            Throwable th = (Throwable) obj;
            return th == null ? new p0(x(), null, this) : th;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        x0 x0Var = (x0) ((C0) obj);
        Object objG = x0Var.G();
        if (objG instanceof v0) {
            cancellationExceptionD = ((v0) objG).d();
        } else if (objG instanceof r) {
            cancellationExceptionD = ((r) objG).f2238a;
        } else {
            if (objG instanceof InterfaceC0131i0) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + objG).toString());
            }
            cancellationExceptionD = null;
        }
        CancellationException p0Var = cancellationExceptionD instanceof CancellationException ? cancellationExceptionD : null;
        if (p0Var == null) {
            p0Var = new p0("Parent job is ".concat(V(objG)), cancellationExceptionD, x0Var);
        }
        return p0Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object B(v0 v0Var, Object obj) {
        Throwable p0Var = null;
        r rVar = obj instanceof r ? (r) obj : null;
        Throwable th = rVar != null ? rVar.f2238a : null;
        synchronized (v0Var) {
            v0Var.e();
            ArrayList<Throwable> arrayListG = v0Var.g(th);
            if (!arrayListG.isEmpty()) {
                Iterator it = arrayListG.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (!(((Throwable) next) instanceof CancellationException)) {
                        p0Var = next;
                        break;
                    }
                }
                p0Var = p0Var;
                if (p0Var == null) {
                    p0Var = (Throwable) arrayListG.get(0);
                }
            } else if (v0Var.e()) {
                p0Var = new p0(x(), null, this);
            }
            if (p0Var != null && arrayListG.size() > 1) {
                Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(arrayListG.size()));
                for (Throwable th2 : arrayListG) {
                    if (th2 != p0Var && th2 != p0Var && !(th2 instanceof CancellationException) && setNewSetFromMap.add(th2)) {
                        ExceptionsKt.addSuppressed(p0Var, th2);
                    }
                }
            }
        }
        if (p0Var != null && p0Var != th) {
            obj = new r(p0Var, false);
        }
        if (p0Var != null && (w(p0Var) || H(p0Var))) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            r rVar2 = (r) obj;
            rVar2.getClass();
            r.f2237b.compareAndSet(rVar2, 0, 1);
        }
        R(obj);
        f2258a.compareAndSet(this, v0Var, obj instanceof InterfaceC0131i0 ? new C0133j0((InterfaceC0131i0) obj) : obj);
        z(v0Var, obj);
        return obj;
    }

    public final CancellationException C() {
        CancellationException cancellationException;
        Object objG = G();
        if (!(objG instanceof v0)) {
            if (objG instanceof InterfaceC0131i0) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            if (!(objG instanceof r)) {
                return new p0(getClass().getSimpleName().concat(" has completed normally"), null, this);
            }
            Throwable th = ((r) objG).f2238a;
            cancellationException = th instanceof CancellationException ? (CancellationException) th : null;
            return cancellationException == null ? new p0(x(), th, this) : cancellationException;
        }
        Throwable thD = ((v0) objG).d();
        if (thD == null) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        String strConcat = getClass().getSimpleName().concat(" is cancelling");
        cancellationException = thD instanceof CancellationException ? (CancellationException) thD : null;
        if (cancellationException != null) {
            return cancellationException;
        }
        if (strConcat == null) {
            strConcat = x();
        }
        return new p0(strConcat, thD, this);
    }

    public boolean D() {
        return true;
    }

    public boolean E() {
        return this instanceof C0141o;
    }

    public final z0 F(InterfaceC0131i0 interfaceC0131i0) {
        z0 z0VarC = interfaceC0131i0.c();
        if (z0VarC != null) {
            return z0VarC;
        }
        if (interfaceC0131i0 instanceof U) {
            return new z0();
        }
        if (interfaceC0131i0 instanceof s0) {
            T((s0) interfaceC0131i0);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + interfaceC0131i0).toString());
    }

    public final Object G() {
        while (true) {
            Object obj = f2258a.get(this);
            if (!(obj instanceof d3.r)) {
                return obj;
            }
            ((d3.r) obj).a(this);
        }
    }

    public boolean H(Throwable th) {
        return false;
    }

    public void I(androidx.fragment.app.A a4) {
        throw a4;
    }

    public final void J(o0 o0Var) {
        int iU;
        A0 a02 = A0.f2162a;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2259b;
        if (o0Var == null) {
            atomicReferenceFieldUpdater.set(this, a02);
            return;
        }
        x0 x0Var = (x0) o0Var;
        do {
            iU = x0Var.U(x0Var.G());
            if (iU == 0) {
                break;
            }
        } while (iU != 1);
        T tA = AbstractC0139m0.a(x0Var, true, new C0136l(this), 2);
        Intrinsics.checkNotNull(tA, "null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
        InterfaceC0134k interfaceC0134k = (InterfaceC0134k) tA;
        atomicReferenceFieldUpdater.set(this, interfaceC0134k);
        if (!(G() instanceof InterfaceC0131i0)) {
            interfaceC0134k.dispose();
            atomicReferenceFieldUpdater.set(this, a02);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00a6 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v3, types: [Z2.h0] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final Z2.T K(boolean r8, boolean r9, kotlin.jvm.functions.Function1 r10) {
        /*
            Method dump skipped, instructions count: 199
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Z2.x0.K(boolean, boolean, kotlin.jvm.functions.Function1):Z2.T");
    }

    public final boolean L() {
        Object objG = G();
        return (objG instanceof r) || ((objG instanceof v0) && ((v0) objG).e());
    }

    public boolean M() {
        return this instanceof C0118c;
    }

    public final Object N(Object obj) {
        Object objW;
        do {
            objW = W(G(), obj);
            if (objW == I.f2173f) {
                String str = "Job " + this + " is already complete or completing, but is being completed with " + obj;
                r rVar = obj instanceof r ? (r) obj : null;
                throw new IllegalStateException(str, rVar != null ? rVar.f2238a : null);
            }
        } while (objW == I.f2175h);
        return objW;
    }

    public String O() {
        return getClass().getSimpleName();
    }

    public final void Q(z0 z0Var, Throwable th) {
        Object objF = z0Var.f();
        Intrinsics.checkNotNull(objF, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        androidx.fragment.app.A a4 = null;
        for (d3.m mVarG = (d3.m) objF; !Intrinsics.areEqual(mVarG, z0Var); mVarG = mVarG.g()) {
            if (mVarG instanceof q0) {
                s0 s0Var = (s0) mVarG;
                try {
                    s0Var.j(th);
                } catch (Throwable th2) {
                    if (a4 != null) {
                        ExceptionsKt.addSuppressed(a4, th2);
                    } else {
                        a4 = new androidx.fragment.app.A("Exception in completion handler " + s0Var + " for " + this, 8, th2);
                        Unit unit = Unit.INSTANCE;
                    }
                }
            }
        }
        if (a4 != null) {
            I(a4);
        }
        w(th);
    }

    public void R(Object obj) {
    }

    public void S() {
    }

    public final void T(s0 s0Var) {
        z0 z0Var = new z0();
        s0Var.getClass();
        d3.m.f12466b.lazySet(z0Var, s0Var);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = d3.m.f12465a;
        atomicReferenceFieldUpdater.lazySet(z0Var, s0Var);
        while (true) {
            if (s0Var.f() != s0Var) {
                break;
            } else if (atomicReferenceFieldUpdater.compareAndSet(s0Var, s0Var, z0Var)) {
                z0Var.e(s0Var);
                break;
            }
        }
        f2258a.compareAndSet(this, s0Var, s0Var.g());
    }

    public final int U(Object obj) {
        boolean z4 = obj instanceof U;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2258a;
        if (z4) {
            if (((U) obj).f2192a) {
                return 0;
            }
            return !atomicReferenceFieldUpdater.compareAndSet(this, obj, I.f2179l) ? -1 : 1;
        }
        if (obj instanceof C0129h0) {
            return !atomicReferenceFieldUpdater.compareAndSet(this, obj, ((C0129h0) obj).f2221a) ? -1 : 1;
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [T, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r6v9 */
    public final Object W(Object obj, Object obj2) {
        if (!(obj instanceof InterfaceC0131i0)) {
            return I.f2173f;
        }
        if (((obj instanceof U) || (obj instanceof s0)) && !(obj instanceof C0136l) && !(obj2 instanceof r)) {
            InterfaceC0131i0 interfaceC0131i0 = (InterfaceC0131i0) obj;
            if (!f2258a.compareAndSet(this, interfaceC0131i0, obj2 instanceof InterfaceC0131i0 ? new C0133j0((InterfaceC0131i0) obj2) : obj2)) {
                return I.f2175h;
            }
            R(obj2);
            z(interfaceC0131i0, obj2);
            return obj2;
        }
        InterfaceC0131i0 interfaceC0131i02 = (InterfaceC0131i0) obj;
        z0 z0VarF = F(interfaceC0131i02);
        if (z0VarF == null) {
            return I.f2175h;
        }
        C0136l c0136lP = null;
        v0 v0Var = interfaceC0131i02 instanceof v0 ? (v0) interfaceC0131i02 : null;
        if (v0Var == null) {
            v0Var = new v0(z0VarF, null);
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        synchronized (v0Var) {
            if (v0Var.f()) {
                return I.f2173f;
            }
            v0.f2249b.set(v0Var, 1);
            if (v0Var != interfaceC0131i02 && !f2258a.compareAndSet(this, interfaceC0131i02, v0Var)) {
                return I.f2175h;
            }
            boolean zE = v0Var.e();
            r rVar = obj2 instanceof r ? (r) obj2 : null;
            if (rVar != null) {
                v0Var.b(rVar.f2238a);
            }
            ?? D4 = zE ^ true ? v0Var.d() : 0;
            objectRef.element = D4;
            Unit unit = Unit.INSTANCE;
            if (D4 != 0) {
                Q(z0VarF, D4);
            }
            C0136l c0136l = interfaceC0131i02 instanceof C0136l ? (C0136l) interfaceC0131i02 : null;
            if (c0136l == null) {
                z0 z0VarC = interfaceC0131i02.c();
                if (z0VarC != null) {
                    c0136lP = P(z0VarC);
                }
            } else {
                c0136lP = c0136l;
            }
            if (c0136lP != null) {
                while (AbstractC0139m0.a(c0136lP.f2227e, false, new u0(this, v0Var, c0136lP, obj2), 1) == A0.f2162a) {
                    c0136lP = P(c0136lP);
                    if (c0136lP == null) {
                    }
                }
                return I.f2174g;
            }
            return B(v0Var, obj2);
        }
    }

    @Override // Z2.o0
    public boolean a() {
        Object objG = G();
        return (objG instanceof InterfaceC0131i0) && ((InterfaceC0131i0) objG).a();
    }

    @Override // Z2.o0
    public void b(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new p0(x(), null, this);
        }
        v(cancellationException);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public final Object fold(Object obj, Function2 function2) {
        return CoroutineContext.Element.DefaultImpls.fold(this, obj, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext, kotlin.coroutines.ContinuationInterceptor
    public final CoroutineContext.Element get(CoroutineContext.Key key) {
        return CoroutineContext.Element.DefaultImpls.get(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key getKey() {
        return n0.f2230a;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext, kotlin.coroutines.ContinuationInterceptor
    public final CoroutineContext minusKey(CoroutineContext.Key key) {
        return CoroutineContext.Element.DefaultImpls.minusKey(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext plus(CoroutineContext coroutineContext) {
        return CoroutineContext.Element.DefaultImpls.plus(this, coroutineContext);
    }

    public final boolean r(Object obj, z0 z0Var, s0 s0Var) {
        char c4;
        w0 w0Var = new w0(s0Var, this, obj);
        do {
            d3.m mVarD = z0Var.d();
            if (mVarD == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = d3.m.f12466b;
                Object obj2 = atomicReferenceFieldUpdater.get(z0Var);
                while (true) {
                    mVarD = (d3.m) obj2;
                    if (!mVarD.h()) {
                        break;
                    }
                    obj2 = atomicReferenceFieldUpdater.get(mVarD);
                }
            }
            d3.m.f12466b.lazySet(s0Var, mVarD);
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = d3.m.f12465a;
            atomicReferenceFieldUpdater2.lazySet(s0Var, z0Var);
            w0Var.f2255c = z0Var;
            c4 = !atomicReferenceFieldUpdater2.compareAndSet(mVarD, z0Var, w0Var) ? (char) 0 : w0Var.a(mVarD) == null ? (char) 1 : (char) 2;
            if (c4 == 1) {
                return true;
            }
        } while (c4 != 2);
        return false;
    }

    public void s(Object obj) {
    }

    public void t(Object obj) {
        s(obj);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(O() + '{' + V(G()) + '}');
        sb.append('@');
        sb.append(I.p(this));
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0058, code lost:
    
        r0 = r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean u(java.lang.Object r9) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Z2.x0.u(java.lang.Object):boolean");
    }

    public void v(CancellationException cancellationException) {
        u(cancellationException);
    }

    public final boolean w(Throwable th) {
        if (M()) {
            return true;
        }
        boolean z4 = th instanceof CancellationException;
        InterfaceC0134k interfaceC0134k = (InterfaceC0134k) f2259b.get(this);
        return (interfaceC0134k == null || interfaceC0134k == A0.f2162a) ? z4 : interfaceC0134k.b(th) || z4;
    }

    public String x() {
        return "Job was cancelled";
    }

    public boolean y(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return u(th) && D();
    }

    public final void z(InterfaceC0131i0 interfaceC0131i0, Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2259b;
        InterfaceC0134k interfaceC0134k = (InterfaceC0134k) atomicReferenceFieldUpdater.get(this);
        if (interfaceC0134k != null) {
            interfaceC0134k.dispose();
            atomicReferenceFieldUpdater.set(this, A0.f2162a);
        }
        androidx.fragment.app.A a4 = null;
        r rVar = obj instanceof r ? (r) obj : null;
        Throwable th = rVar != null ? rVar.f2238a : null;
        if (interfaceC0131i0 instanceof s0) {
            try {
                ((s0) interfaceC0131i0).j(th);
                return;
            } catch (Throwable th2) {
                I(new androidx.fragment.app.A("Exception in completion handler " + interfaceC0131i0 + " for " + this, 8, th2));
                return;
            }
        }
        z0 z0VarC = interfaceC0131i0.c();
        if (z0VarC != null) {
            Object objF = z0VarC.f();
            Intrinsics.checkNotNull(objF, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            for (d3.m mVarG = (d3.m) objF; !Intrinsics.areEqual(mVarG, z0VarC); mVarG = mVarG.g()) {
                if (mVarG instanceof s0) {
                    s0 s0Var = (s0) mVarG;
                    try {
                        s0Var.j(th);
                    } catch (Throwable th3) {
                        if (a4 != null) {
                            ExceptionsKt.addSuppressed(a4, th3);
                        } else {
                            a4 = new androidx.fragment.app.A("Exception in completion handler " + s0Var + " for " + this, 8, th3);
                            Unit unit = Unit.INSTANCE;
                        }
                    }
                }
            }
            if (a4 != null) {
                I(a4);
            }
        }
    }
}

package Z2;

import ch.qos.logback.core.CoreConstants;
import d3.AbstractC0539a;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.zetetic.database.sqlcipher.SQLiteDatabase;
import org.jetbrains.annotations.Nullable;

/* renamed from: Z2.h, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C0128h extends O implements InterfaceC0126g, CoroutineStackFrame, K0 {

    /* renamed from: f, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f2216f = AtomicIntegerFieldUpdater.newUpdater(C0128h.class, "_decisionAndIndex");

    /* renamed from: g, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f2217g = AtomicReferenceFieldUpdater.newUpdater(C0128h.class, Object.class, "_state");

    /* renamed from: h, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f2218h = AtomicReferenceFieldUpdater.newUpdater(C0128h.class, Object.class, "_parentHandle");

    @Volatile
    private volatile int _decisionAndIndex;

    @Volatile
    @Nullable
    private volatile Object _parentHandle;

    @Volatile
    @Nullable
    private volatile Object _state;

    /* renamed from: d, reason: collision with root package name */
    public final Continuation f2219d;

    /* renamed from: e, reason: collision with root package name */
    public final CoroutineContext f2220e;

    public C0128h(int i4, Continuation continuation) {
        super(i4);
        this.f2219d = continuation;
        this.f2220e = continuation.get$context();
        this._decisionAndIndex = 536870911;
        this._state = C0116b.f2207a;
    }

    public static Object C(B0 b02, Object obj, int i4, Function1 function1) {
        if ((obj instanceof r) || !P.a(i4)) {
            return obj;
        }
        if (function1 != null || (b02 instanceof AbstractC0124f)) {
            return new C0143q(obj, b02 instanceof AbstractC0124f ? (AbstractC0124f) b02 : null, function1, (CancellationException) null, 16);
        }
        return obj;
    }

    public static void y(Object obj, Object obj2) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + obj + ", already has " + obj2).toString());
    }

    public final void A() {
        Continuation continuation = this.f2219d;
        Throwable th = null;
        d3.i iVar = continuation instanceof d3.i ? (d3.i) continuation : null;
        if (iVar != null) {
            while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = d3.i.f12454h;
                Object obj = atomicReferenceFieldUpdater.get(iVar);
                X.r rVar = AbstractC0539a.f12444c;
                if (obj == rVar) {
                    if (atomicReferenceFieldUpdater.compareAndSet(iVar, rVar, this)) {
                        break;
                    }
                } else {
                    if (!(obj instanceof Throwable)) {
                        throw new IllegalStateException(("Inconsistent state " + obj).toString());
                    }
                    if (!atomicReferenceFieldUpdater.compareAndSet(iVar, obj, null)) {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                    th = (Throwable) obj;
                }
            }
            if (th == null) {
                return;
            }
            p();
            i(th);
        }
    }

    public final void B(Object obj, int i4, Function1 function1) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Object obj2;
        do {
            atomicReferenceFieldUpdater = f2217g;
            obj2 = atomicReferenceFieldUpdater.get(this);
            if (!(obj2 instanceof B0)) {
                if (obj2 instanceof C0130i) {
                    C0130i c0130i = (C0130i) obj2;
                    c0130i.getClass();
                    if (C0130i.f2222c.compareAndSet(c0130i, 0, 1)) {
                        if (function1 != null) {
                            m(function1, c0130i.f2238a);
                            return;
                        }
                        return;
                    }
                }
                throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
            }
        } while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, C((B0) obj2, obj, i4, function1)));
        if (!x()) {
            p();
        }
        r(i4);
    }

    @Override // Z2.K0
    public final void a(d3.v vVar, int i4) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i5;
        do {
            atomicIntegerFieldUpdater = f2216f;
            i5 = atomicIntegerFieldUpdater.get(this);
            if ((i5 & 536870911) != 536870911) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once".toString());
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i5, ((i5 >> 29) << 29) + i4));
        w(vVar);
    }

    @Override // Z2.O
    public final void b(Object obj, CancellationException cancellationException) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2217g;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof B0) {
                throw new IllegalStateException("Not completed".toString());
            }
            if (obj2 instanceof r) {
                return;
            }
            if (obj2 instanceof C0143q) {
                C0143q c0143q = (C0143q) obj2;
                if (!(!(c0143q.f2236e != null))) {
                    throw new IllegalStateException("Must be called at most once".toString());
                }
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, C0143q.a(c0143q, null, cancellationException, 15))) {
                    AbstractC0124f abstractC0124f = c0143q.f2233b;
                    if (abstractC0124f != null) {
                        l(abstractC0124f, cancellationException);
                    }
                    Function1 function1 = c0143q.f2234c;
                    if (function1 != null) {
                        m(function1, cancellationException);
                        return;
                    }
                    return;
                }
            } else if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, new C0143q(obj2, (AbstractC0124f) null, (Function1) null, cancellationException, 14))) {
                return;
            }
        }
    }

    @Override // Z2.O
    public final Continuation c() {
        return this.f2219d;
    }

    @Override // Z2.O
    public final Throwable d(Object obj) {
        Throwable thD = super.d(obj);
        if (thD != null) {
            return thD;
        }
        return null;
    }

    @Override // Z2.O
    public final Object e(Object obj) {
        return obj instanceof C0143q ? ((C0143q) obj).f2232a : obj;
    }

    @Override // Z2.InterfaceC0126g
    public final void g(Object obj, Function1 function1) {
        B(obj, this.f2188c, function1);
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame getCallerFrame() {
        Continuation continuation = this.f2219d;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    /* renamed from: getContext */
    public final CoroutineContext get$context() {
        return this.f2220e;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // Z2.InterfaceC0126g
    public final X.r h(Object obj, Function1 function1) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Object obj2;
        X.r rVar;
        do {
            atomicReferenceFieldUpdater = f2217g;
            obj2 = atomicReferenceFieldUpdater.get(this);
            boolean z4 = obj2 instanceof B0;
            rVar = I.f2170c;
            if (!z4) {
                boolean z5 = obj2 instanceof C0143q;
                return null;
            }
        } while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, C((B0) obj2, obj, this.f2188c, function1)));
        if (x()) {
            return rVar;
        }
        p();
        return rVar;
    }

    @Override // Z2.InterfaceC0126g
    public final boolean i(Throwable th) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Object obj;
        do {
            atomicReferenceFieldUpdater = f2217g;
            obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof B0)) {
                return false;
            }
        } while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, new C0130i(this, th, (obj instanceof AbstractC0124f) || (obj instanceof d3.v))));
        B0 b02 = (B0) obj;
        if (b02 instanceof AbstractC0124f) {
            l((AbstractC0124f) obj, th);
        } else if (b02 instanceof d3.v) {
            n((d3.v) obj, th);
        }
        if (!x()) {
            p();
        }
        r(this.f2188c);
        return true;
    }

    @Override // Z2.InterfaceC0126g
    public final void j(A a4, Object obj) {
        Continuation continuation = this.f2219d;
        d3.i iVar = continuation instanceof d3.i ? (d3.i) continuation : null;
        B(obj, (iVar != null ? iVar.f12455d : null) == a4 ? 4 : this.f2188c, null);
    }

    @Override // Z2.O
    public final Object k() {
        return f2217g.get(this);
    }

    public final void l(AbstractC0124f abstractC0124f, Throwable th) {
        try {
            abstractC0124f.a(th);
        } catch (Throwable th2) {
            C.a(this.f2220e, new androidx.fragment.app.A("Exception in invokeOnCancellation handler for " + this, 8, th2));
        }
    }

    public final void m(Function1 function1, Throwable th) {
        try {
            function1.invoke(th);
        } catch (Throwable th2) {
            C.a(this.f2220e, new androidx.fragment.app.A("Exception in resume onCancellation handler for " + this, 8, th2));
        }
    }

    public final void n(d3.v vVar, Throwable th) {
        CoroutineContext coroutineContext = this.f2220e;
        int i4 = f2216f.get(this) & 536870911;
        if (i4 == 536870911) {
            throw new IllegalStateException("The index for Segment.onCancellation(..) is broken".toString());
        }
        try {
            vVar.g(i4, coroutineContext);
        } catch (Throwable th2) {
            C.a(coroutineContext, new androidx.fragment.app.A("Exception in invokeOnCancellation handler for " + this, 8, th2));
        }
    }

    @Override // Z2.InterfaceC0126g
    public final void o(Function1 function1) {
        w(function1 instanceof AbstractC0124f ? (AbstractC0124f) function1 : new C0122e(2, function1));
    }

    public final void p() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2218h;
        T t4 = (T) atomicReferenceFieldUpdater.get(this);
        if (t4 == null) {
            return;
        }
        t4.dispose();
        atomicReferenceFieldUpdater.set(this, A0.f2162a);
    }

    @Override // Z2.InterfaceC0126g
    public final void q(Object obj) {
        r(this.f2188c);
    }

    public final void r(int i4) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i5;
        do {
            atomicIntegerFieldUpdater = f2216f;
            i5 = atomicIntegerFieldUpdater.get(this);
            int i6 = i5 >> 29;
            if (i6 != 0) {
                if (i6 != 1) {
                    throw new IllegalStateException("Already resumed".toString());
                }
                boolean z4 = i4 == 4;
                Continuation continuation = this.f2219d;
                if (z4 || !(continuation instanceof d3.i) || P.a(i4) != P.a(this.f2188c)) {
                    P.b(this, continuation, z4);
                    return;
                }
                A a4 = ((d3.i) continuation).f12455d;
                CoroutineContext context = continuation.get$context();
                if (a4.isDispatchNeeded(context)) {
                    a4.dispatch(context, this);
                    return;
                }
                V vA = G0.a();
                if (vA.u()) {
                    vA.l(this);
                    return;
                }
                vA.m(true);
                try {
                    P.b(this, continuation, true);
                    do {
                    } while (vA.C());
                } finally {
                    try {
                        return;
                    } finally {
                    }
                }
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i5, 1073741824 + (536870911 & i5)));
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        Throwable thM25exceptionOrNullimpl = Result.m25exceptionOrNullimpl(obj);
        if (thM25exceptionOrNullimpl != null) {
            obj = new r(thM25exceptionOrNullimpl, false);
        }
        B(obj, this.f2188c, null);
    }

    public Throwable s(x0 x0Var) {
        return x0Var.C();
    }

    public final Object t() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i4;
        boolean zX = x();
        do {
            atomicIntegerFieldUpdater = f2216f;
            i4 = atomicIntegerFieldUpdater.get(this);
            int i5 = i4 >> 29;
            if (i5 != 0) {
                if (i5 != 2) {
                    throw new IllegalStateException("Already suspended".toString());
                }
                if (zX) {
                    A();
                }
                Object obj = f2217g.get(this);
                if (obj instanceof r) {
                    throw ((r) obj).f2238a;
                }
                if (P.a(this.f2188c)) {
                    o0 o0Var = (o0) this.f2220e.get(n0.f2230a);
                    if (o0Var != null && !o0Var.a()) {
                        CancellationException cancellationExceptionC = ((x0) o0Var).C();
                        b(obj, cancellationExceptionC);
                        throw cancellationExceptionC;
                    }
                }
                return e(obj);
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i4, SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING + (536870911 & i4)));
        if (((T) f2218h.get(this)) == null) {
            v();
        }
        if (zX) {
            A();
        }
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(z());
        sb.append(CoreConstants.LEFT_PARENTHESIS_CHAR);
        sb.append(I.F(this.f2219d));
        sb.append("){");
        Object obj = f2217g.get(this);
        sb.append(obj instanceof B0 ? "Active" : obj instanceof C0130i ? "Cancelled" : "Completed");
        sb.append("}@");
        sb.append(I.p(this));
        return sb.toString();
    }

    public final void u() {
        T tV = v();
        if (tV != null && (!(f2217g.get(this) instanceof B0))) {
            tV.dispose();
            f2218h.set(this, A0.f2162a);
        }
    }

    public final T v() {
        o0 o0Var = (o0) this.f2220e.get(n0.f2230a);
        if (o0Var == null) {
            return null;
        }
        T tA = AbstractC0139m0.a(o0Var, true, new C0132j(this), 2);
        f2218h.compareAndSet(this, null, tA);
        return tA;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a1, code lost:
    
        y(r10, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00a4, code lost:
    
        throw null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void w(java.lang.Object r10) {
        /*
            r9 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = Z2.C0128h.f2217g
            java.lang.Object r7 = r0.get(r9)
            boolean r1 = r7 instanceof Z2.C0116b
            if (r1 == 0) goto L11
            boolean r0 = r0.compareAndSet(r9, r7, r10)
            if (r0 == 0) goto L0
            return
        L11:
            boolean r1 = r7 instanceof Z2.AbstractC0124f
            r2 = 0
            if (r1 != 0) goto La1
            boolean r1 = r7 instanceof d3.v
            if (r1 != 0) goto La1
            boolean r1 = r7 instanceof Z2.r
            if (r1 == 0) goto L53
            r0 = r7
            Z2.r r0 = (Z2.r) r0
            r0.getClass()
            r3 = 1
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r4 = Z2.r.f2237b
            r5 = 0
            boolean r3 = r4.compareAndSet(r0, r5, r3)
            if (r3 == 0) goto L4f
            boolean r3 = r7 instanceof Z2.C0130i
            if (r3 == 0) goto L4e
            if (r1 == 0) goto L35
            goto L36
        L35:
            r0 = r2
        L36:
            if (r0 == 0) goto L3a
            java.lang.Throwable r2 = r0.f2238a
        L3a:
            boolean r0 = r10 instanceof Z2.AbstractC0124f
            if (r0 == 0) goto L44
            Z2.f r10 = (Z2.AbstractC0124f) r10
            r9.l(r10, r2)
            goto L4e
        L44:
            java.lang.String r0 = "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10, r0)
            d3.v r10 = (d3.v) r10
            r9.n(r10, r2)
        L4e:
            return
        L4f:
            y(r10, r7)
            throw r2
        L53:
            boolean r1 = r7 instanceof Z2.C0143q
            java.lang.String r3 = "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler"
            if (r1 == 0) goto L84
            r1 = r7
            Z2.q r1 = (Z2.C0143q) r1
            Z2.f r4 = r1.f2233b
            if (r4 != 0) goto L80
            boolean r4 = r10 instanceof d3.v
            if (r4 == 0) goto L65
            return
        L65:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10, r3)
            r3 = r10
            Z2.f r3 = (Z2.AbstractC0124f) r3
            java.lang.Throwable r4 = r1.f2236e
            if (r4 == 0) goto L73
            r9.l(r3, r4)
            return
        L73:
            r4 = 29
            Z2.q r1 = Z2.C0143q.a(r1, r3, r2, r4)
            boolean r0 = r0.compareAndSet(r9, r7, r1)
            if (r0 == 0) goto L0
            return
        L80:
            y(r10, r7)
            throw r2
        L84:
            boolean r1 = r10 instanceof d3.v
            if (r1 == 0) goto L89
            return
        L89:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10, r3)
            r3 = r10
            Z2.f r3 = (Z2.AbstractC0124f) r3
            Z2.q r8 = new Z2.q
            r4 = 0
            r5 = 0
            r6 = 28
            r1 = r8
            r2 = r7
            r1.<init>(r2, r3, r4, r5, r6)
            boolean r0 = r0.compareAndSet(r9, r7, r8)
            if (r0 == 0) goto L0
            return
        La1:
            y(r10, r7)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: Z2.C0128h.w(java.lang.Object):void");
    }

    public final boolean x() {
        if (this.f2188c == 2) {
            Continuation continuation = this.f2219d;
            Intrinsics.checkNotNull(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
            d3.i iVar = (d3.i) continuation;
            iVar.getClass();
            if (d3.i.f12454h.get(iVar) != null) {
                return true;
            }
        }
        return false;
    }

    public String z() {
        return "CancellableContinuation";
    }
}

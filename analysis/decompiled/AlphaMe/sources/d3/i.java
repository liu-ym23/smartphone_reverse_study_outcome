package d3;

import Z2.C0144s;
import Z2.G0;
import Z2.I;
import Z2.O;
import Z2.V;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public final class i extends O implements CoroutineStackFrame, Continuation {

    /* renamed from: h, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f12454h = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "_reusableCancellableContinuation");

    @Volatile
    @Nullable
    private volatile Object _reusableCancellableContinuation;

    /* renamed from: d, reason: collision with root package name */
    public final Z2.A f12455d;

    /* renamed from: e, reason: collision with root package name */
    public final Continuation f12456e;

    /* renamed from: f, reason: collision with root package name */
    public Object f12457f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f12458g;

    public i(Z2.A a4, Continuation continuation) {
        super(-1);
        this.f12455d = a4;
        this.f12456e = continuation;
        this.f12457f = AbstractC0539a.f12443b;
        Object objFold = continuation.get$context().fold(0, B.f12434b);
        Intrinsics.checkNotNull(objFold);
        this.f12458g = objFold;
    }

    @Override // Z2.O
    public final void b(Object obj, CancellationException cancellationException) {
        if (obj instanceof C0144s) {
            ((C0144s) obj).f2241b.invoke(cancellationException);
        }
    }

    @Override // Z2.O
    public final Continuation c() {
        return this;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame getCallerFrame() {
        Continuation continuation = this.f12456e;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    /* renamed from: getContext */
    public final CoroutineContext get$context() {
        return this.f12456e.get$context();
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // Z2.O
    public final Object k() {
        Object obj = this.f12457f;
        this.f12457f = AbstractC0539a.f12443b;
        return obj;
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        Continuation continuation = this.f12456e;
        CoroutineContext context = continuation.get$context();
        Throwable thM25exceptionOrNullimpl = Result.m25exceptionOrNullimpl(obj);
        Object rVar = thM25exceptionOrNullimpl == null ? obj : new Z2.r(thM25exceptionOrNullimpl, false);
        Z2.A a4 = this.f12455d;
        if (a4.isDispatchNeeded(context)) {
            this.f12457f = rVar;
            this.f2188c = 0;
            a4.dispatch(context, this);
            return;
        }
        V vA = G0.a();
        if (vA.u()) {
            this.f12457f = rVar;
            this.f2188c = 0;
            vA.l(this);
            return;
        }
        vA.m(true);
        try {
            CoroutineContext context2 = continuation.get$context();
            Object objB = B.b(context2, this.f12458g);
            try {
                continuation.resumeWith(obj);
                Unit unit = Unit.INSTANCE;
                while (vA.C()) {
                }
            } finally {
                B.a(context2, objB);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public final String toString() {
        return "DispatchedContinuation[" + this.f12455d + ", " + I.F(this.f12456e) + ']';
    }
}

package kotlinx.coroutines;

import com.google.common.primitives.Ints;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class n extends j0 implements CancellableContinuation, CoroutineStackFrame, Waiter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f21647f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f21648g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f21649h = null;

    @Volatile
    private volatile int _decisionAndIndex;

    @Volatile
    @Nullable
    private volatile Object _parentHandle;

    @Volatile
    @Nullable
    private volatile Object _state;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Continuation f21650d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CoroutineContext f21651e;

    static {
        f21647f = AtomicIntegerFieldUpdater.newUpdater(n.class, "_decisionAndIndex");
        f21648g = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "_state");
        f21649h = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "_parentHandle");
    }

    public n(Continuation r10, int r11) {
        super(r11);
        this.f21650d = r10;
        this.f21651e = r10.getContext();
        this._decisionAndIndex = 536870911;
        this._state = d.f21370a;
    }

    public static /* synthetic */ void D(n r10, Object r11, int r12, Function1 r13, int r14, Object r15) {
        if (r15 != null) goto L9;
        if ((r14 & 4) == 0) goto L6;
        r13 = null;
    L6:
        r10.C(r11, r12, r13);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
    }

    private final boolean v() {
        if (k0.c(this.f21631c) == false) goto L7;
        Continuation r10 = this.f21650d;
        kotlin.jvm.internal.q.e(r10, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        if (((kotlinx.coroutines.internal.i) r10).k() == false) goto L7;
        return true;
    L7:
        return false;
    }

    public final void A() {
        Continuation r10 = this.f21650d;
        if ((r10 instanceof kotlinx.coroutines.internal.i) == false) goto L5;
        kotlinx.coroutines.internal.i r11 = (kotlinx.coroutines.internal.i) r10;
    L6:
        if (r11 == null) goto L12;
        Throwable r12 = r11.n(this);
        if (r12 == null) goto L13;
        l();
        cancel(r12);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r11 = null;
        goto L6
    }

    public final boolean B() {
        AtomicReferenceFieldUpdater r10 = f21648g;
        Object r11 = r10.get(this);
        if ((r11 instanceof v) == true) goto L5;
    L8:
        f21647f.set(this, 536870911);
        r10.set(this, d.f21370a);
        return true;
    L5:
        if (((v) r11).f21765d == null) goto L8;
        l();
        return false;
    }

    public final void C(Object r10, int r11, Function1 r12) {
        AtomicReferenceFieldUpdater r13 = f21648g;
    L3:
        Object r14 = r13.get(this);
        if ((r14 instanceof NotCompleted) == false) goto L10;
        Object r15 = E((NotCompleted) r14, r10, r11, r12, null);
        if (androidx.concurrent.futures.a.a(f21648g, this, r14, r15) == false) goto L3;
        m();
        n(r11);
        return;
    L10:
        if ((r14 instanceof q) == false) goto L16;
        q r16 = (q) r14;
        if (r16.c() == false) goto L16;
        if (r12 == null) goto L21;
        i(r12, r16.f21768a);
        return;
    L21:
        return;
    L16:
        g(r10);
        throw new KotlinNothingValueException();
    }

    public final Object E(NotCompleted r10, Object r11, int r12, Function1 r13, Object r14) {
        if ((r11 instanceof w) == false) goto L6;
        return r11;
    L6:
        if (k0.b(r12) == true) goto L9;
        if (r14 != null) goto L9;
        return r11;
    L9:
        if (r13 != null) goto L14;
        if ((r10 instanceof l) == true) goto L14;
        if (r14 != null) goto L14;
        return r11;
    L14:
        if ((r10 instanceof l) == false) goto L17;
        l r15 = (l) r10;
    L19:
        return new v(r11, r15, r13, r14, null, 16, null);
    L17:
        r15 = null;
        goto L19
    }

    public final boolean F() {
        AtomicIntegerFieldUpdater r10 = f21647f;
    L3:
        int r11 = r10.get(this);
        int r12 = r11 >> 29;
        if (r12 != 0) goto L5;
        if (f21647f.compareAndSet(this, r11, Ints.MAX_POWER_OF_TWO + (536870911 & r11)) == false) goto L3;
        return true;
    L5:
        if (r12 != 1) goto L9;
        return false;
    L9:
        throw new IllegalStateException("Already resumed");
    }

    public final kotlinx.coroutines.internal.b0 G(Object r10, Object r11, Function1 r12) {
        AtomicReferenceFieldUpdater r13 = f21648g;
    L3:
        Object r14 = r13.get(this);
        if ((r14 instanceof NotCompleted) == false) goto L10;
        Object r15 = E((NotCompleted) r14, r10, this.f21631c, r12, r11);
        if (androidx.concurrent.futures.a.a(f21648g, this, r14, r15) == false) goto L3;
        m();
        return o.f21654a;
    L10:
        if ((r14 instanceof v) == false) goto L19;
        if (r11 != null) goto L13;
        return null;
    L13:
        if (((v) r14).f21765d == r11) goto L15;
        return null;
    L15:
        return o.f21654a;
    L19:
        return null;
    }

    public final boolean H() {
        AtomicIntegerFieldUpdater r10 = f21647f;
    L3:
        int r11 = r10.get(this);
        int r12 = r11 >> 29;
        if (r12 != 0) goto L6;
        if (f21647f.compareAndSet(this, r11, 536870912 + (536870911 & r11)) == false) goto L3;
        return true;
    L6:
        if (r12 != 2) goto L10;
        return false;
    L10:
        throw new IllegalStateException("Already suspended");
    }

    @Override // kotlinx.coroutines.j0
    public void a(Object r20, Throwable r21) {
        AtomicReferenceFieldUpdater r10 = f21648g;
    L3:
        Object r11 = r10.get(this);
        if ((r11 instanceof NotCompleted) == true) goto L22;
        if ((r11 instanceof w) == true) goto L7;
        if ((r11 instanceof v) == true) goto L10;
        if (androidx.concurrent.futures.a.a(f21648g, this, r11, new v(r11, null, null, null, r21, 14, null)) == false) goto L3;
        return;
    L10:
        v r12 = (v) r11;
        if (r12.c() == true) goto L17;
        v r13 = v.b(r12, null, null, null, null, r21, 15, null);
        if (androidx.concurrent.futures.a.a(f21648g, this, r11, r13) == false) goto L3;
        r12.d(this, r21);
        return;
    L17:
        throw new IllegalStateException("Must be called at most once");
    L7:
        return;
    L22:
        throw new IllegalStateException("Not completed");
    }

    @Override // kotlinx.coroutines.j0
    public final Continuation b() {
        return this.f21650d;
    }

    @Override // kotlinx.coroutines.j0
    public Throwable c(Object r10) {
        Throwable r11 = super.c(r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean cancel(Throwable r10) {
        AtomicReferenceFieldUpdater r11 = f21648g;
    L3:
        Object r12 = r11.get(this);
        boolean r13 = false;
        if ((r12 instanceof NotCompleted) == false) goto L5;
        if ((r12 instanceof l) == false) goto L9;
    L10:
        r13 = true;
    L12:
        if (androidx.concurrent.futures.a.a(f21648g, this, r12, new q(this, r10, r13)) == false) goto L3;
        NotCompleted r14 = (NotCompleted) r12;
        if ((r14 instanceof l) == false) goto L17;
        h((l) r12, r10);
    L19:
        m();
        n(this.f21631c);
        return true;
    L17:
        if ((r14 instanceof kotlinx.coroutines.internal.y) == false) goto L19;
        j((kotlinx.coroutines.internal.y) r12, r10);
        goto L19
    L9:
        if ((r12 instanceof kotlinx.coroutines.internal.y) == false) goto L12;
    L5:
        return false;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void completeResume(Object r10) {
        n(this.f21631c);
    }

    @Override // kotlinx.coroutines.j0
    public Object d(Object r10) {
        if ((r10 instanceof v) == true) goto L5;
        return r10;
    L5:
        return ((v) r10).f21762a;
    }

    @Override // kotlinx.coroutines.j0
    public Object f() {
        return r();
    }

    public final Void g(Object r10) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + r10).toString());
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation r10 = this.f21650d;
        if ((r10 instanceof CoroutineStackFrame) == true) goto L7;
        return null;
    L7:
        return (CoroutineStackFrame) r10;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.f21651e;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public final void h(l r10, Throwable r11) {
        r10.a(r11);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        a0.a(getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th));
    }

    public final void i(Function1 r10, Throwable r11) {
        r10.invoke(r11);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        a0.a(getContext(), new CompletionHandlerException("Exception in resume onCancellation handler for " + this, th));
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void initCancellability() {
        DisposableHandle r10 = t();
        if (r10 != null) goto L6;
        return;
    L6:
        if (isCompleted() == false) goto L9;
        r10.dispose();
        f21649h.set(this, r1.f21672a);
        return;
    }

    @Override // kotlinx.coroutines.Waiter
    public void invokeOnCancellation(kotlinx.coroutines.internal.y r10, int r11) {
        AtomicIntegerFieldUpdater r12 = f21647f;
    L3:
        int r13 = r12.get(this);
        if ((r13 & 536870911) != 536870911) goto L10;
        if (r12.compareAndSet(this, r13, ((r13 >> 29) << 29) + r11) == false) goto L3;
        u(r10);
        return;
    L10:
        throw new IllegalStateException("invokeOnCancellation should be called at most once");
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean isActive() {
        return r() instanceof NotCompleted;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean isCancelled() {
        return r() instanceof q;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean isCompleted() {
        return !(r() instanceof NotCompleted);
    }

    public final void j(kotlinx.coroutines.internal.y r10, Throwable r11) {
        int r12 = f21647f.get(this) & 536870911;
        if (r12 == 536870911) goto L10;
        r10.o(r12, r11, getContext());     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        a0.a(getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th));
        return;
    L10:
        throw new IllegalStateException("The index for Segment.onCancellation(..) is broken");
    }

    public final boolean k(Throwable r10) {
        if (v() == true) goto L6;
        return false;
    L6:
        Continuation r11 = this.f21650d;
        kotlin.jvm.internal.q.e(r11, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return ((kotlinx.coroutines.internal.i) r11).l(r10);
    }

    public final void l() {
        DisposableHandle r10 = p();
        if (r10 != null) goto L5;
        return;
    L5:
        r10.dispose();
        f21649h.set(this, r1.f21672a);
    }

    public final void m() {
        if (v() == true) goto L6;
        l();
        return;
    }

    public final void n(int r10) {
        if (F() == false) goto L5;
        return;
    L5:
        k0.a(this, r10);
    }

    public Throwable o(Job r10) {
        return r10.getCancellationException();
    }

    public final DisposableHandle p() {
        return (DisposableHandle) f21649h.get(this);
    }

    public final Object q() {
        boolean r10 = v();
        if (H() == true) goto L5;
        if (r10 == false) goto L13;
        A();
    L13:
        Object r11 = r();
        if ((r11 instanceof w) == true) goto L27;
        if (k0.b(this.f21631c) == false) goto L25;
        Job r12 = (Job) getContext().get(Job.Key);
        if (r12 == null) goto L25;
        if (r12.isActive() == true) goto L25;
        CancellationException r13 = r12.getCancellationException();
        a(r11, r13);
        throw r13;
    L25:
        return d(r11);
    L27:
        throw ((w) r11).f21768a;
    L5:
        if (p() != null) goto L7;
        t();
    L7:
        if (r10 == false) goto L10;
        A();
    L10:
        return kotlin.coroutines.intrinsics.a.d();
    }

    public final Object r() {
        return f21648g.get(this);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void resume(Object r10, Function1 r11) {
        C(r10, this.f21631c, r11);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void resumeUndispatched(CoroutineDispatcher r10, Object r11) {
        Continuation r12 = this.f21650d;
        CoroutineDispatcher r13 = null;
        if ((r12 instanceof kotlinx.coroutines.internal.i) == false) goto L5;
        kotlinx.coroutines.internal.i r14 = (kotlinx.coroutines.internal.i) r12;
    L6:
        if (r14 == null) goto L8;
        r13 = r14.f21594d;
    L8:
        if (r13 != r10) goto L11;
        int r15 = 4;
    L12:
        D(this, r11, r15, null, 4, null);
        return;
    L11:
        r15 = this.f21631c;
        goto L12
    L5:
        r14 = null;
        goto L6
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void resumeUndispatchedWithException(CoroutineDispatcher r10, Throwable r11) {
        Continuation r12 = this.f21650d;
        CoroutineDispatcher r13 = null;
        if ((r12 instanceof kotlinx.coroutines.internal.i) == false) goto L5;
        kotlinx.coroutines.internal.i r14 = (kotlinx.coroutines.internal.i) r12;
    L6:
        w r15 = new w(r11, false, 2, null);
        if (r14 == null) goto L9;
        r13 = r14.f21594d;
    L9:
        if (r13 != r10) goto L12;
        int r16 = 4;
    L13:
        D(this, r15, r16, null, 4, null);
        return;
    L12:
        r16 = this.f21631c;
        goto L13
    L5:
        r14 = null;
        goto L6
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object r10) {
        D(this, z.c(r10, this), this.f21631c, null, 4, null);
    }

    public final String s() {
        Object r10 = r();
        if ((r10 instanceof NotCompleted) == false) goto L6;
        return "Active";
    L6:
        if ((r10 instanceof q) == false) goto L8;
        return "Cancelled";
    L8:
        return "Completed";
    }

    public final DisposableHandle t() {
        Job r10 = (Job) getContext().get(Job.Key);
        if (r10 != null) goto L5;
        return null;
    L5:
        DisposableHandle r11 = Job.a.e(r10, true, false, new r(this), 2, null);
        androidx.concurrent.futures.a.a(f21649h, this, null, r11);
        return r11;
    }

    public String toString() {
        return y() + '(' + e0.c(this.f21650d) + "){" + s() + "}@" + e0.b(this);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public Object tryResume(Object r10, Object r11) {
        return G(r10, r11, null);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public Object tryResumeWithException(Throwable r10) {
        return G(new w(r10, false, 2, null), null, null);
    }

    public final void u(Object r21) {
        AtomicReferenceFieldUpdater r10 = f21648g;
    L3:
        Object r11 = r10.get(this);
        if ((r11 instanceof d) == true) goto L6;
        if ((r11 instanceof l) == false) goto L11;
        boolean r12 = true;
    L12:
        if (r12 == true) goto L13;
        if ((r11 instanceof w) == true) goto L16;
        if ((r11 instanceof v) == true) goto L34;
        if ((r21 instanceof kotlinx.coroutines.internal.y) == true) goto L49;
        kotlin.jvm.internal.q.e(r21, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
        if (androidx.concurrent.futures.a.a(f21648g, this, r11, new v(r11, (l) r21, null, null, null, 28, null)) == false) goto L3;
        return;
    L49:
        return;
    L34:
        v r13 = (v) r11;
        if (r13.f21763b == null) goto L38;
        x(r21, r11);
    L38:
        if ((r21 instanceof kotlinx.coroutines.internal.y) == true) goto L39;
        kotlin.jvm.internal.q.e(r21, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
        l r14 = (l) r21;
        if (r13.c() == true) goto L42;
        if (androidx.concurrent.futures.a.a(f21648g, this, r11, v.b(r13, null, r14, null, null, null, 29, null)) == false) goto L3;
        return;
    L42:
        h(r14, r13.f21766e);
        return;
    L39:
        return;
    L16:
        w r15 = (w) r11;
        if (r15.b() == true) goto L20;
        x(r21, r11);
    L20:
        if ((r11 instanceof q) == false) goto L71;
        Throwable r16 = null;
        if ((r11 instanceof w) == true) goto L25;
        r15 = null;
    L25:
        if (r15 == null) goto L28;
        r16 = r15.f21768a;
    L28:
        if ((r21 instanceof l) == false) goto L30;
        h((l) r21, r16);
        return;
    L30:
        kotlin.jvm.internal.q.e(r21, "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
        j((kotlinx.coroutines.internal.y) r21, r16);
        return;
    L71:
        return;
    L13:
        x(r21, r11);
        goto L3
    L11:
        r12 = r11 instanceof kotlinx.coroutines.internal.y;
        goto L12
    L6:
        if (androidx.concurrent.futures.a.a(f21648g, this, r11, r21) == false) goto L3;
    }

    public final l w(Function1 r10) {
        if ((r10 instanceof l) == false) goto L6;
        return (l) r10;
    L6:
        return new c1(r10);
    }

    public final void x(Object r10, Object r11) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + r10 + ", already has " + r11).toString());
    }

    public String y() {
        return "CancellableContinuation";
    }

    public final void z(Throwable r10) {
        if (k(r10) == false) goto L5;
        return;
    L5:
        cancel(r10);
        m();
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public Object tryResume(Object r10, Object r11, Function1 r12) {
        return G(r10, r11, r12);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void invokeOnCancellation(Function1 r10) {
        u(w(r10));
    }
}

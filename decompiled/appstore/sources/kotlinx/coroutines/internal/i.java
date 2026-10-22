package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.Volatile;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.q0;
import kotlinx.coroutines.z1;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class i extends kotlinx.coroutines.j0 implements CoroutineStackFrame, Continuation {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f21593h = null;

    @Volatile
    @Nullable
    private volatile Object _reusableCancellableContinuation;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CoroutineDispatcher f21594d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Continuation f21595e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f21596f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f21597g;

    static {
        f21593h = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "_reusableCancellableContinuation");
    }

    public i(CoroutineDispatcher r10, Continuation r11) {
        super(-1);
        this.f21594d = r10;
        this.f21595e = r11;
        this.f21596f = j.a();
        this.f21597g = ThreadContextKt.b(getContext());
    }

    @Override // kotlinx.coroutines.j0
    public void a(Object r10, Throwable r11) {
        if ((r10 instanceof kotlinx.coroutines.x) == false) goto L6;
        ((kotlinx.coroutines.x) r10).f21771b.invoke(r11);
        return;
    }

    @Override // kotlinx.coroutines.j0
    public Continuation b() {
        return this;
    }

    @Override // kotlinx.coroutines.j0
    public Object f() {
        Object r10 = this.f21596f;
        this.f21596f = j.a();
        return r10;
    }

    public final void g() {
        AtomicReferenceFieldUpdater r10 = f21593h;
    L4:
        if (r10.get(this) == j.f21601b) goto L4;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation r10 = this.f21595e;
        if ((r10 instanceof CoroutineStackFrame) == true) goto L7;
        return null;
    L7:
        return (CoroutineStackFrame) r10;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.f21595e.getContext();
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public final kotlinx.coroutines.n h() {
        AtomicReferenceFieldUpdater r10 = f21593h;
    L3:
        Object r11 = r10.get(this);
        if (r11 == null) goto L5;
        if ((r11 instanceof kotlinx.coroutines.n) == true) goto L10;
        if (r11 == j.f21601b) goto L3;
        if ((r11 instanceof Throwable) == true) goto L3;
        throw new IllegalStateException(("Inconsistent state " + r11).toString());
    L10:
        if (androidx.concurrent.futures.a.a(f21593h, this, r11, j.f21601b) == false) goto L3;
        return (kotlinx.coroutines.n) r11;
    L5:
        f21593h.set(this, j.f21601b);
        return null;
    }

    public final void i(CoroutineContext r10, Object r11) {
        this.f21596f = r11;
        this.f21631c = 1;
        this.f21594d.b(r10, this);
    }

    public final kotlinx.coroutines.n j() {
        Object r10 = f21593h.get(this);
        if ((r10 instanceof kotlinx.coroutines.n) == true) goto L7;
        return null;
    L7:
        return (kotlinx.coroutines.n) r10;
    }

    public final boolean k() {
        if (f21593h.get(this) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean l(Throwable r10) {
        AtomicReferenceFieldUpdater r11 = f21593h;
    L3:
        Object r12 = r11.get(this);
        b0 r13 = j.f21601b;
        if (kotlin.jvm.internal.q.b(r12, r13) == true) goto L6;
        if ((r12 instanceof Throwable) == true) goto L10;
        if (androidx.concurrent.futures.a.a(f21593h, this, r12, null) == false) goto L3;
        return false;
    L10:
        return true;
    L6:
        if (androidx.concurrent.futures.a.a(f21593h, this, r13, r10) == false) goto L3;
        return true;
    }

    public final void m() {
        g();
        kotlinx.coroutines.n r10 = j();
        if (r10 == null) goto L6;
        r10.l();
        return;
    }

    public final Throwable n(CancellableContinuation r10) {
        AtomicReferenceFieldUpdater r11 = f21593h;
    L3:
        Object r12 = r11.get(this);
        b0 r13 = j.f21601b;
        if (r12 != r13) goto L9;
        if (androidx.concurrent.futures.a.a(f21593h, this, r13, r10) == false) goto L3;
        return null;
    L9:
        if ((r12 instanceof Throwable) == false) goto L17;
        if (androidx.concurrent.futures.a.a(f21593h, this, r12, null) == false) goto L15;
        return (Throwable) r12;
    L15:
        throw new IllegalArgumentException("Failed requirement.");
    L17:
        throw new IllegalStateException(("Inconsistent state " + r12).toString());
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object r10) {
        CoroutineContext r11 = this.f21595e.getContext();
        Object r12 = kotlinx.coroutines.z.d(r10, null, 1, null);
        if (this.f21594d.c(r11) == false) goto L5;
        this.f21596f = r12;
        this.f21631c = 0;
        this.f21594d.a(r11, this);
        return;
    L5:
        q0 r13 = z1.f21774a.b();
        if (r13.l() == false) goto L8;
        this.f21596f = r12;
        this.f21631c = 0;
        r13.h(this);
        return;
    L8:
        r13.j(true);
        CoroutineContext r14 = getContext();     // Catch: Throwable -> L15
        Object r15 = ThreadContextKt.c(r14, this.f21597g);     // Catch: Throwable -> L15
        this.f21595e.resumeWith(r10);     // Catch: Throwable -> L17
        Unit r16 = Unit.f21064a;     // Catch: Throwable -> L17
        ThreadContextKt.a(r14, r15);     // Catch: Throwable -> L15
    L13:
        if (r13.o() == true) goto L13;
    L14:
        r13.e(true);
        return;
    L17:
        th = move-exception;
        ThreadContextKt.a(r14, r15);     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        e(th, null);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        r13.e(true);
        throw th;
    }

    public String toString() {
        return "DispatchedContinuation[" + this.f21594d + ", " + kotlinx.coroutines.e0.c(this.f21595e) + ']';
    }
}

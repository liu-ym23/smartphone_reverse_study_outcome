package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.e0;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.y;
import kotlinx.coroutines.n;
import kotlinx.coroutines.p;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectInstanceInternal;
import kotlinx.coroutines.selects.e;
import org.jetbrains.annotations.Nullable;
import tf.d;

/* JADX INFO: loaded from: classes4.dex */
public class MutexImpl extends SemaphoreImpl implements Mutex {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f21733i = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function3 f21734h;

    @Volatile
    @Nullable
    private volatile Object owner;

    public final class CancellableContinuationWithOwner implements CancellableContinuation, Waiter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final n f21735a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f21736b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ MutexImpl f21737c;

        public CancellableContinuationWithOwner(MutexImpl r10, n r11, Object r12) {
            this.f21737c = r10;
            this.f21735a = r11;
            this.f21736b = r12;
        }

        public void a(Unit r10, Function1 r11) {
            MutexImpl.k().set(this.f21737c, this.f21736b);
            n r12 = this.f21735a;
            final MutexImpl r13 = this.f21737c;
            r12.resume(r10, new MutexImpl$CancellableContinuationWithOwner$resume$2(r13, this));
        }

        public void b(CoroutineDispatcher r10, Unit r11) {
            this.f21735a.resumeUndispatched(r10, r11);
        }

        public Object c(Unit r10, Object r11) {
            return this.f21735a.tryResume(r10, r11);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public boolean cancel(Throwable r10) {
            return this.f21735a.cancel(r10);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public void completeResume(Object r10) {
            this.f21735a.completeResume(r10);
        }

        public Object d(Unit r10, Object r11, Function1 r12) {
            final MutexImpl r13 = this.f21737c;
            Object r14 = this.f21735a.tryResume(r10, r11, new MutexImpl$CancellableContinuationWithOwner$tryResume$token$1(r13, this));
            if (r14 == null) goto L5;
            MutexImpl.k().set(this.f21737c, this.f21736b);
        L5:
            return r14;
        }

        @Override // kotlin.coroutines.Continuation
        public CoroutineContext getContext() {
            return this.f21735a.getContext();
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public void initCancellability() {
            this.f21735a.initCancellability();
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public void invokeOnCancellation(Function1 r10) {
            this.f21735a.invokeOnCancellation(r10);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public boolean isActive() {
            return this.f21735a.isActive();
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public boolean isCancelled() {
            return this.f21735a.isCancelled();
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public boolean isCompleted() {
            return this.f21735a.isCompleted();
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public /* bridge */ /* synthetic */ void resume(Object r10, Function1 r11) {
            a((Unit) r10, r11);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public /* bridge */ /* synthetic */ void resumeUndispatched(CoroutineDispatcher r10, Object r11) {
            b(r10, (Unit) r11);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public void resumeUndispatchedWithException(CoroutineDispatcher r10, Throwable r11) {
            this.f21735a.resumeUndispatchedWithException(r10, r11);
        }

        @Override // kotlin.coroutines.Continuation
        public void resumeWith(Object r10) {
            this.f21735a.resumeWith(r10);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public /* bridge */ /* synthetic */ Object tryResume(Object r10, Object r11) {
            return c((Unit) r10, r11);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public Object tryResumeWithException(Throwable r10) {
            return this.f21735a.tryResumeWithException(r10);
        }

        @Override // kotlinx.coroutines.Waiter
        public void invokeOnCancellation(y r10, int r11) {
            this.f21735a.invokeOnCancellation(r10, r11);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public /* bridge */ /* synthetic */ Object tryResume(Object r10, Object r11, Function1 r12) {
            return d((Unit) r10, r11, r12);
        }
    }

    public final class a implements SelectInstanceInternal {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SelectInstanceInternal f21738a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f21739b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ MutexImpl f21740c;

        public a(MutexImpl r10, SelectInstanceInternal r11, Object r12) {
            this.f21740c = r10;
            this.f21738a = r11;
            this.f21739b = r12;
        }

        @Override // kotlinx.coroutines.selects.SelectInstance
        public void disposeOnCompletion(DisposableHandle r10) {
            this.f21738a.disposeOnCompletion(r10);
        }

        @Override // kotlinx.coroutines.selects.SelectInstance
        public CoroutineContext getContext() {
            return this.f21738a.getContext();
        }

        @Override // kotlinx.coroutines.Waiter
        public void invokeOnCancellation(y r10, int r11) {
            this.f21738a.invokeOnCancellation(r10, r11);
        }

        @Override // kotlinx.coroutines.selects.SelectInstance
        public void selectInRegistrationPhase(Object r10) {
            MutexImpl.k().set(this.f21740c, this.f21739b);
            this.f21738a.selectInRegistrationPhase(r10);
        }

        @Override // kotlinx.coroutines.selects.SelectInstance
        public boolean trySelect(Object r10, Object r11) {
            boolean r12 = this.f21738a.trySelect(r10, r11);
            MutexImpl r13 = this.f21740c;
            if (r12 == false) goto L5;
            MutexImpl.k().set(r13, this.f21739b);
        L5:
            return r12;
        }
    }

    static {
        f21733i = AtomicReferenceFieldUpdater.newUpdater(MutexImpl.class, Object.class, "owner");
    }

    public MutexImpl(boolean r10) {
        super(1, r10 ? 1 : 0);
        if (r10 == false) goto L5;
        b0 r11 = null;
    L6:
        this.owner = r11;
        this.f21734h = new MutexImpl$onSelectCancellationUnlockConstructor$1(this);
        return;
    L5:
        r11 = MutexKt.c();
        goto L6
    }

    public static final /* synthetic */ AtomicReferenceFieldUpdater k() {
        return f21733i;
    }

    public static /* synthetic */ Object l(MutexImpl r10, Object r11, Continuation r12) {
        if (r10.tryLock(r11) == true) goto L5;
        Object r13 = r10.m(r11, r12);
        if (r13 != kotlin.coroutines.intrinsics.a.d()) goto L10;
        return r13;
    L10:
        return Unit.f21064a;
    L5:
        return Unit.f21064a;
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public SelectClause2 getOnLock() {
        MutexImpl$onLock$1 r10 = MutexImpl$onLock$1.INSTANCE;
        q.e(r10, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 r11 = (Function3) kotlin.jvm.internal.y.e(r10, 3);
        MutexImpl$onLock$2 r12 = MutexImpl$onLock$2.INSTANCE;
        q.e(r12, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new e(this, r11, (Function3) kotlin.jvm.internal.y.e(r12, 3), this.f21734h);
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public boolean holdsLock(Object r10) {
    L3:
        if (isLocked() == false) goto L4;
        Object r11 = f21733i.get(this);
        if (r11 == MutexKt.c()) goto L3;
        if (r11 != r10) goto L13;
        return true;
    L13:
        return false;
    L4:
        return false;
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public boolean isLocked() {
        if (getAvailablePermits() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public Object lock(Object r10, Continuation r11) {
        return l(this, r10, r11);
    }

    public final Object m(Object r10, Continuation r11) {
        n r12 = p.b(IntrinsicsKt__IntrinsicsJvmKt.c(r11));
        b(new CancellableContinuationWithOwner(this, r12, r10));     // Catch: Throwable -> L12
        Object r13 = r12.q();
        if (r13 != kotlin.coroutines.intrinsics.a.d()) goto L8;
        d.c(r11);
    L8:
        if (r13 != kotlin.coroutines.intrinsics.a.d()) goto L11;
        return r13;
    L11:
        return Unit.f21064a;
    L12:
        th = move-exception;
        r12.A();
        throw th;
    }

    public Object n(Object r10, Object r11) {
        if (q.b(r11, MutexKt.d()) == true) goto L6;
        return this;
    L6:
        throw new IllegalStateException(("This mutex is already locked by the specified owner: " + r10).toString());
    }

    public void o(SelectInstance r10, Object r11) {
        if (r11 != null) goto L4;
    L6:
        q.e(r10, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectInstanceInternal<*>");
        h(new a(this, (SelectInstanceInternal) r10, r11), r11);
        return;
    L4:
        if (holdsLock(r11) == false) goto L6;
        r10.selectInRegistrationPhase(MutexKt.d());
    }

    public final int p(Object r10) {
    L3:
        if (tryAcquire() == true) goto L4;
        if (r10 == null) goto L13;
        if (holdsLock(r10) == true) goto L9;
        if (isLocked() == false) goto L3;
        return 1;
    L9:
        return 2;
    L13:
        return 1;
    L4:
        f21733i.set(this, r10);
        return 0;
    }

    public String toString() {
        return "Mutex@" + e0.b(this) + "[isLocked=" + isLocked() + ",owner=" + f21733i.get(this) + ']';
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public boolean tryLock(Object r10) {
        int r11 = p(r10);
        if (r11 == 0) goto L13;
        if (r11 != 1) goto L6;
        return false;
    L6:
        if (r11 == 2) goto L10;
        throw new IllegalStateException("unexpected");
    L10:
        throw new IllegalStateException(("This mutex is already locked by the specified owner: " + r10).toString());
    L13:
        return true;
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public void unlock(Object r10) {
    L3:
        if (isLocked() == false) goto L16;
        AtomicReferenceFieldUpdater r11 = f21733i;
        Object r12 = r11.get(this);
        if (r12 == MutexKt.c()) goto L3;
        if (r12 == r10) goto L12;
        if (r10 == null) goto L12;
        throw new IllegalStateException(("This mutex is locked by " + r12 + ", but " + r10 + " is expected").toString());
    L12:
        if (androidx.concurrent.futures.a.a(r11, this, r12, MutexKt.c()) == false) goto L3;
        release();
        return;
    L16:
        throw new IllegalStateException("This mutex is not locked");
    }
}

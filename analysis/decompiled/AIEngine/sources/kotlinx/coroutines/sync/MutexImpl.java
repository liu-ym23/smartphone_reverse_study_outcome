package kotlinx.coroutines.sync;

import b6.h;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.sync.MutexImpl;
import lb.n;
import zb.l;
import zb.q;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class MutexImpl extends SemaphoreAndMutexImpl implements Mutex {
    private static final /* synthetic */ AtomicReferenceFieldUpdater owner$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(MutexImpl.class, Object.class, "owner$volatile");
    private final q<SelectInstance<?>, Object, Object, q<Throwable, Object, d, n>> onSelectCancellationUnlockConstructor;
    private volatile /* synthetic */ Object owner$volatile;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public final class CancellableContinuationWithOwner implements CancellableContinuation<n>, Waiter {
        public final CancellableContinuationImpl<n> cont;
        public final Object owner;

        /* JADX WARN: Multi-variable type inference failed */
        public CancellableContinuationWithOwner(CancellableContinuationImpl<? super n> cancellableContinuationImpl, Object obj) {
            this.cont = cancellableContinuationImpl;
            this.owner = obj;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final n resume$lambda$6(MutexImpl mutexImpl, CancellableContinuationWithOwner cancellableContinuationWithOwner, Throwable th) {
            mutexImpl.unlock(cancellableContinuationWithOwner.owner);
            return n.f10413a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final n tryResume$lambda$3(MutexImpl mutexImpl, CancellableContinuationWithOwner cancellableContinuationWithOwner, Throwable th, n nVar, d dVar) {
            MutexImpl.getOwner$volatile$FU().set(mutexImpl, cancellableContinuationWithOwner.owner);
            mutexImpl.unlock(cancellableContinuationWithOwner.owner);
            return n.f10413a;
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public boolean cancel(Throwable th) {
            return this.cont.cancel(th);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public void completeResume(Object obj) {
            this.cont.completeResume(obj);
        }

        @Override // qb.b
        public d getContext() {
            return this.cont.getContext();
        }

        @Override // kotlinx.coroutines.Waiter
        public void invokeOnCancellation(Segment<?> segment, int i10) {
            this.cont.invokeOnCancellation(segment, i10);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public boolean isActive() {
            return this.cont.isActive();
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public boolean isCompleted() {
            return this.cont.isCompleted();
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public /* bridge */ /* synthetic */ void resume(Object obj, q qVar) {
            resume((CancellableContinuationWithOwner) obj, (q<? super Throwable, ? super CancellableContinuationWithOwner, ? super d, n>) qVar);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public void resumeUndispatched(CoroutineDispatcher coroutineDispatcher, n nVar) {
            this.cont.resumeUndispatched(coroutineDispatcher, nVar);
        }

        @Override // qb.b
        public void resumeWith(Object obj) {
            this.cont.resumeWith(obj);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public /* bridge */ /* synthetic */ Object tryResume(Object obj, Object obj2, q qVar) {
            return tryResume((CancellableContinuationWithOwner) obj, obj2, (q<? super Throwable, ? super CancellableContinuationWithOwner, ? super d, n>) qVar);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public Object tryResumeWithException(Throwable th) {
            return this.cont.tryResumeWithException(th);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public void invokeOnCancellation(l<? super Throwable, n> lVar) {
            this.cont.invokeOnCancellation(lVar);
        }

        public <R extends n> void resume(R r, q<? super Throwable, ? super R, ? super d, n> qVar) {
            MutexImpl.getOwner$volatile$FU().set(MutexImpl.this, this.owner);
            CancellableContinuationImpl<n> cancellableContinuationImpl = this.cont;
            final MutexImpl mutexImpl = MutexImpl.this;
            cancellableContinuationImpl.resume((CancellableContinuationImpl<n>) r, new l() { // from class: kotlinx.coroutines.sync.b
                @Override // zb.l
                public final Object invoke(Object obj) {
                    return MutexImpl.CancellableContinuationWithOwner.resume$lambda$6(mutexImpl, this, (Throwable) obj);
                }
            });
        }

        public <R extends n> Object tryResume(R r, Object obj, q<? super Throwable, ? super R, ? super d, n> qVar) {
            final MutexImpl mutexImpl = MutexImpl.this;
            Object objTryResume = this.cont.tryResume(r, obj, new q() { // from class: kotlinx.coroutines.sync.a
                @Override // zb.q
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return MutexImpl.CancellableContinuationWithOwner.tryResume$lambda$3(mutexImpl, this, (Throwable) obj2, (n) obj3, (d) obj4);
                }
            });
            if (objTryResume != null) {
                MutexImpl.getOwner$volatile$FU().set(MutexImpl.this, this.owner);
            }
            return objTryResume;
        }
    }

    public MutexImpl(boolean z) {
        super(1, z ? 1 : 0);
        this.owner$volatile = z ? null : MutexKt.NO_OWNER;
        this.onSelectCancellationUnlockConstructor = new h(this, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ AtomicReferenceFieldUpdater getOwner$volatile$FU() {
        return owner$volatile$FU;
    }

    private final int holdsLockImpl(Object obj) {
        while (isLocked()) {
            Object obj2 = owner$volatile$FU.get(this);
            if (obj2 != MutexKt.NO_OWNER) {
                return obj2 == obj ? 1 : 2;
            }
        }
        return 0;
    }

    public static Object lock$suspendImpl(MutexImpl mutexImpl, Object obj, qb.b<? super n> bVar) {
        if (mutexImpl.tryLock(obj)) {
            return n.f10413a;
        }
        Object objLockSuspend = mutexImpl.lockSuspend(obj, bVar);
        return objLockSuspend == CoroutineSingletons.f10059a ? objLockSuspend : n.f10413a;
    }

    private final Object lockSuspend(Object obj, qb.b<? super n> bVar) {
        CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(jd.b.w(bVar));
        try {
            acquire((CancellableContinuation<? super n>) new CancellableContinuationWithOwner(orCreateCancellableContinuation, obj));
            Object result = orCreateCancellableContinuation.getResult();
            return result == CoroutineSingletons.f10059a ? result : n.f10413a;
        } catch (Throwable th) {
            orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final q onSelectCancellationUnlockConstructor$lambda$1(final MutexImpl mutexImpl, SelectInstance selectInstance, final Object obj, Object obj2) {
        return new q() { // from class: oc.a
            @Override // zb.q
            public final Object invoke(Object obj3, Object obj4, Object obj5) {
                return MutexImpl.onSelectCancellationUnlockConstructor$lambda$1$lambda$0(this.f10854a, obj, (Throwable) obj3, obj4, (d) obj5);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n onSelectCancellationUnlockConstructor$lambda$1$lambda$0(MutexImpl mutexImpl, Object obj, Throwable th, Object obj2, d dVar) {
        mutexImpl.unlock(obj);
        return n.f10413a;
    }

    private final int tryLockImpl(Object obj) {
        while (!tryAcquire()) {
            if (obj == null) {
                return 1;
            }
            int iHoldsLockImpl = holdsLockImpl(obj);
            if (iHoldsLockImpl == 1) {
                return 2;
            }
            if (iHoldsLockImpl == 2) {
                return 1;
            }
        }
        owner$volatile$FU.set(this, obj);
        return 0;
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public boolean isLocked() {
        return getAvailablePermits() == 0;
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public Object lock(Object obj, qb.b<? super n> bVar) {
        return lock$suspendImpl(this, obj, bVar);
    }

    public String toString() {
        return "Mutex@" + DebugStringsKt.getHexAddress(this) + "[isLocked=" + isLocked() + ",owner=" + owner$volatile$FU.get(this) + ']';
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public boolean tryLock(Object obj) {
        int iTryLockImpl = tryLockImpl(obj);
        if (iTryLockImpl == 0) {
            return true;
        }
        if (iTryLockImpl == 1) {
            return false;
        }
        if (iTryLockImpl != 2) {
            throw new IllegalStateException("unexpected");
        }
        throw new IllegalStateException(("This mutex is already locked by the specified owner: " + obj).toString());
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public void unlock(Object obj) {
        while (isLocked()) {
            Object obj2 = owner$volatile$FU.get(this);
            if (obj2 != MutexKt.NO_OWNER) {
                if (obj2 != obj && obj != null) {
                    throw new IllegalStateException(("This mutex is locked by " + obj2 + ", but " + obj + " is expected").toString());
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = owner$volatile$FU;
                Symbol symbol = MutexKt.NO_OWNER;
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, symbol)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj2) {
                        break;
                    }
                }
                release();
                return;
            }
        }
        throw new IllegalStateException("This mutex is not locked");
    }
}

package androidx.room;

import C7.r;
import S7.n;
import androidx.room.ObservedTableStates;
import androidx.room.Transactor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@J7.c(c = "androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1", f = "InvalidationTracker.kt", l = {306, 313}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/room/Transactor;", "connection", "LC7/r;", "<anonymous>", "(Landroidx/room/Transactor;)V"}, k = 3, mv = {2, 1, 0})
/* loaded from: classes2.dex */
public final class TriggerBasedInvalidationTracker$syncTriggers$2$1 extends SuspendLambda implements n {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TriggerBasedInvalidationTracker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TriggerBasedInvalidationTracker$syncTriggers$2$1(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, H7.c<? super TriggerBasedInvalidationTracker$syncTriggers$2$1> cVar) {
        super(2, cVar);
        this.this$0 = triggerBasedInvalidationTracker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        TriggerBasedInvalidationTracker$syncTriggers$2$1 triggerBasedInvalidationTracker$syncTriggers$2$1 = new TriggerBasedInvalidationTracker$syncTriggers$2$1(this.this$0, cVar);
        triggerBasedInvalidationTracker$syncTriggers$2$1.L$0 = obj;
        return triggerBasedInvalidationTracker$syncTriggers$2$1;
    }

    @Override // S7.n
    public final Object invoke(Transactor transactor, H7.c<? super r> cVar) {
        return ((TriggerBasedInvalidationTracker$syncTriggers$2$1) create(transactor, cVar)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Transactor transactor;
        Object objInTransaction;
        ReentrantLock reentrantLock;
        ReentrantLock reentrantLock2;
        boolean z10;
        ObservedTableStates.ObserveOp observeOp;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.label;
        r rVar = r.f317a;
        if (i == 0) {
            kotlin.b.b(obj);
            transactor = (Transactor) this.L$0;
            this.L$0 = transactor;
            this.label = 1;
            objInTransaction = transactor.inTransaction(this);
            if (objInTransaction != coroutineSingletons) {
            }
            return coroutineSingletons;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            reentrantLock2 = (ReentrantLock) this.L$0;
            try {
                kotlin.b.b(obj);
                reentrantLock = reentrantLock2;
                reentrantLock.unlock();
                return rVar;
            } catch (Throwable th) {
                th = th;
                reentrantLock2.unlock();
                throw th;
            }
        }
        transactor = (Transactor) this.L$0;
        kotlin.b.b(obj);
        objInTransaction = obj;
        if (((Boolean) objInTransaction).booleanValue()) {
            return rVar;
        }
        ObservedTableStates observedTableStates = this.this$0.observedTableStates;
        TriggerBasedInvalidationTracker triggerBasedInvalidationTracker = this.this$0;
        reentrantLock = observedTableStates.lock;
        reentrantLock.lock();
        try {
            if (observedTableStates.needsSync) {
                observedTableStates.needsSync = false;
                int length = observedTableStates.tableObserversCount.length;
                ObservedTableStates.ObserveOp[] observeOpArr = new ObservedTableStates.ObserveOp[length];
                int i6 = 0;
                boolean z11 = false;
                while (i6 < length) {
                    boolean z12 = observedTableStates.tableObserversCount[i6] > 0;
                    if (z12 != observedTableStates.tableObservedState[i6]) {
                        observedTableStates.tableObservedState[i6] = z12;
                        observeOp = z12 ? ObservedTableStates.ObserveOp.ADD : ObservedTableStates.ObserveOp.REMOVE;
                        z10 = true;
                    } else {
                        z10 = z11;
                        observeOp = ObservedTableStates.ObserveOp.NO_OP;
                    }
                    observeOpArr[i6] = observeOp;
                    i6++;
                    z11 = z10;
                }
                if (z11) {
                    Transactor.SQLiteTransactionType sQLiteTransactionType = Transactor.SQLiteTransactionType.IMMEDIATE;
                    TriggerBasedInvalidationTracker$syncTriggers$2$1$1$1 triggerBasedInvalidationTracker$syncTriggers$2$1$1$1 = new TriggerBasedInvalidationTracker$syncTriggers$2$1$1$1(observeOpArr, triggerBasedInvalidationTracker, transactor, null);
                    this.L$0 = reentrantLock;
                    this.label = 2;
                    if (transactor.withTransaction(sQLiteTransactionType, triggerBasedInvalidationTracker$syncTriggers$2$1$1$1, this) != coroutineSingletons) {
                        reentrantLock2 = reentrantLock;
                        reentrantLock = reentrantLock2;
                    }
                    return coroutineSingletons;
                }
            }
            reentrantLock.unlock();
            return rVar;
        } catch (Throwable th2) {
            th = th2;
            reentrantLock2 = reentrantLock;
            reentrantLock2.unlock();
            throw th;
        }
    }
}

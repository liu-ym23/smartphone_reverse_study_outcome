package androidx.room;

import androidx.lifecycle.LiveData;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
class RoomTrackingLiveData<T> extends LiveData<T> {
    final Callable<T> mComputeFunction;
    final AtomicBoolean mComputing;
    private final InvalidationLiveDataContainer mContainer;
    final RoomDatabase mDatabase;
    final boolean mInTransaction;
    final AtomicBoolean mInvalid;
    final Runnable mInvalidationRunnable;
    final InvalidationTracker.Observer mObserver;
    final Runnable mRefreshRunnable;
    final AtomicBoolean mRegisteredObserver;

    static /* synthetic */ void access$000(RoomTrackingLiveData r0, Object r1) {
        r0.postValue(r1);
    }

    RoomTrackingLiveData(RoomDatabase database, InvalidationLiveDataContainer container, boolean inTransaction, Callable<T> computeFunction, final String[] tableNames) {
        this.mInvalid = new AtomicBoolean(true);
        this.mComputing = new AtomicBoolean(false);
        this.mRegisteredObserver = new AtomicBoolean(false);
        this.mRefreshRunnable = new AnonymousClass1(this);
        this.mInvalidationRunnable = new AnonymousClass2(this);
        this.mDatabase = database;
        this.mInTransaction = inTransaction;
        this.mComputeFunction = computeFunction;
        this.mContainer = container;
        this.mObserver = new AnonymousClass3(this, tableNames);
    }

    @Override // androidx.lifecycle.LiveData
    protected void onActive() {
        super.onActive();
        this.mContainer.onActive(this);
        getQueryExecutor().execute(this.mRefreshRunnable);
    }

    @Override // androidx.lifecycle.LiveData
    protected void onInactive() {
        super.onInactive();
        this.mContainer.onInactive(this);
    }

    Executor getQueryExecutor() {
        if (this.mInTransaction == false) goto L7;
        return this.mDatabase.getTransactionExecutor();
    L7:
        return this.mDatabase.getQueryExecutor();
    }
}

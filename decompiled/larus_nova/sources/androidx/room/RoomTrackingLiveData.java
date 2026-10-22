package androidx.room;

import androidx.lifecycle.LiveData;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes6.dex */
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

    public Executor getQueryExecutor() {
        if (this.mInTransaction == false) goto L7;
        return this.mDatabase.getTransactionExecutor();
    L7:
        return this.mDatabase.getQueryExecutor();
    }

    @Override // androidx.lifecycle.LiveData
    public void onActive() {
        super.onActive();
        this.mContainer.onActive(this);
        getQueryExecutor().execute(this.mRefreshRunnable);
    }

    @Override // androidx.lifecycle.LiveData
    public void onInactive() {
        super.onInactive();
        this.mContainer.onInactive(this);
    }

    public static /* synthetic */ void access$000(RoomTrackingLiveData r100, Object r101) {
        r100.postValue(r101);
    }

    public RoomTrackingLiveData(RoomDatabase r100, InvalidationLiveDataContainer r101, boolean r102, Callable<T> r103, final String[] r104) {
        this.mInvalid = new AtomicBoolean(true);
        this.mComputing = new AtomicBoolean(false);
        this.mRegisteredObserver = new AtomicBoolean(false);
        this.mRefreshRunnable = new AnonymousClass1(this);
        this.mInvalidationRunnable = new AnonymousClass2(this);
        this.mDatabase = r100;
        this.mInTransaction = r102;
        this.mComputeFunction = r103;
        this.mContainer = r101;
        this.mObserver = new AnonymousClass3(this, r104);
    }
}

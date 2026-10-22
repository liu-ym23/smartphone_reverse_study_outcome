package androidx.camera.core.impl;

import android.os.SystemClock;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public final class LiveDataObservable<T> implements Observable<T> {
    final MutableLiveData<Result<T>> mLiveData;
    private final Map<Observable.Observer<? super T>, LiveDataObserverAdapter<T>> mObservers;

    public static final class LiveDataObserverAdapter<T> implements Observer<Result<T>> {
        final AtomicBoolean mActive;
        final Executor mExecutor;
        final Observable.Observer<? super T> mObserver;

        public static /* synthetic */ void a(LiveDataObserverAdapter r100, Result r101) {
            r100.lambda$onChanged$0(r101);
        }

        public void disable() {
            this.mActive.set(false);
        }

        private /* synthetic */ void lambda$onChanged$0(Result r100) {
            if (this.mActive.get() == true) goto L6;
            return;
        L6:
            if (r100.completedSuccessfully() == false) goto L8;
            this.mObserver.onNewData((Object) r100.getValue());
            return;
        L8:
            Preconditions.checkNotNull(r100.getError());
            this.mObserver.onError(r100.getError());
        }

        public void onChanged(final Result<T> r100) {
            this.mExecutor.execute(new s(this, r100));
        }

        @Override // androidx.lifecycle.Observer
        public /* bridge */ /* synthetic */ void onChanged(Object r100) {
            onChanged((Result) r100);
        }

        public LiveDataObserverAdapter(Executor r100, Observable.Observer<? super T> r101) {
            this.mActive = new AtomicBoolean(true);
            this.mExecutor = r100;
            this.mObserver = r101;
        }
    }

    public static final class Result<T> {
        private final Throwable mError;
        private final T mValue;

        public boolean completedSuccessfully() {
            if (this.mError != null) goto L5;
            return true;
        L5:
            return false;
        }

        public String toString() {
            StringBuilder r100 = new StringBuilder("[Result: <");
            if (completedSuccessfully() == false) goto L5;
            String r101 = "Value: " + this.mValue;
        L6:
            r100.append(r101);
            r100.append(">]");
            return r100.toString();
        L5:
            r101 = "Error: " + this.mError;
            goto L6
        }

        public T getValue() {
            if (completedSuccessfully() == false) goto L7;
            return this.mValue;
        L7:
            throw new IllegalStateException("Result contains an error. Does not contain a value.");
        }

        public Throwable getError() {
            return this.mError;
        }

        public static <T> Result<T> fromError(Throwable r100) {
            return new Result(null, (Throwable) Preconditions.checkNotNull(r100));
        }

        public static <T> Result<T> fromValue(T r100) {
            return new Result(r100, null);
        }

        private Result(T r100, Throwable r101) {
            this.mValue = r100;
            this.mError = r101;
        }
    }

    public static /* synthetic */ void a(LiveDataObservable r100, LiveDataObserverAdapter r101) {
        r100.lambda$removeObserver$3(r101);
    }

    public static /* synthetic */ void b(LiveDataObservable r100, LiveDataObserverAdapter r101, LiveDataObserverAdapter r102) {
        r100.lambda$addObserver$2(r101, r102);
    }

    public static /* synthetic */ void c(LiveDataObservable r100, CallbackToFutureAdapter.Completer r101) {
        r100.lambda$fetchData$0(r101);
    }

    public static /* synthetic */ Object d(LiveDataObservable r100, CallbackToFutureAdapter.Completer r101) {
        return r100.lambda$fetchData$1(r101);
    }

    @Override // androidx.camera.core.impl.Observable
    public ListenableFuture<T> fetchData() {
        return CallbackToFutureAdapter.getFuture(new o(this));
    }

    public LiveDataObservable() {
        this.mLiveData = new MutableLiveData();
        this.mObservers = new HashMap();
    }

    public LiveData<Result<T>> getLiveData() {
        return this.mLiveData;
    }

    private /* synthetic */ void lambda$fetchData$0(CallbackToFutureAdapter.Completer r100) {
        Result<T> r101 = this.mLiveData.getValue();
        if (r101 != null) goto L6;
        r100.setException(new IllegalStateException("Observable has not yet been initialized with a value."));
        return;
    L6:
        if (r101.completedSuccessfully() == false) goto L8;
        r100.set(r101.getValue());
        return;
    L8:
        Preconditions.checkNotNull(r101.getError());
        r100.setException(r101.getError());
    }

    private /* synthetic */ Object lambda$fetchData$1(final CallbackToFutureAdapter.Completer r100) throws Exception {
        CameraXExecutors.mainThreadExecutor().execute(new p(this, r100));
        return this + " [fetch@" + SystemClock.uptimeMillis() + "]";
    }

    private /* synthetic */ void lambda$removeObserver$3(LiveDataObserverAdapter r100) {
        this.mLiveData.removeObserver(r100);
    }

    public void postError(Throwable r100) {
        this.mLiveData.postValue(Result.fromError(r100));
    }

    public void postValue(T r100) {
        this.mLiveData.postValue(Result.fromValue(r100));
    }

    @Override // androidx.camera.core.impl.Observable
    public void removeObserver(Observable.Observer<? super T> r100) {
        Map<Observable.Observer<? super T>, LiveDataObserverAdapter<T>> r101 = this.mObservers;
        monitor-enter(r101);
        final LiveDataObserverAdapter<T> r102 = this.mObservers.remove(r100);     // Catch: Throwable -> L9
        if (r102 == null) goto L7;
        r102.disable();     // Catch: Throwable -> L9
        CameraXExecutors.mainThreadExecutor().execute(new q(this, r102));     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$addObserver$2(LiveDataObserverAdapter r100, LiveDataObserverAdapter r101) {
        if (r100 == null) goto L4;
        this.mLiveData.removeObserver(r100);
    L4:
        this.mLiveData.observeForever(r101);
    }

    @Override // androidx.camera.core.impl.Observable
    public void addObserver(Executor r100, Observable.Observer<? super T> r101) {
        Map<Observable.Observer<? super T>, LiveDataObserverAdapter<T>> r102 = this.mObservers;
        monitor-enter(r102);
        final LiveDataObserverAdapter<T> r103 = this.mObservers.get(r101);     // Catch: Throwable -> L10
        if (r103 == null) goto L7;
        r103.disable();     // Catch: Throwable -> L10
    L7:
        final LiveDataObserverAdapter<T> r104 = new LiveDataObserverAdapter(r100, r101);     // Catch: Throwable -> L10
        this.mObservers.put(r101, r104);     // Catch: Throwable -> L10
        CameraXExecutors.mainThreadExecutor().execute(new r(this, r103, r104));     // Catch: Throwable -> L10
        monitor-exit(r102);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }
}

package androidx.camera.core.impl;

import androidx.camera.core.impl.utils.futures.Futures;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes2.dex */
public abstract class StateObservable<T> implements Observable<T> {
    private static final int INITIAL_VERSION = 0;
    private final Object mLock;
    private final CopyOnWriteArraySet<ObserverWrapper<T>> mNotifySet;
    private final AtomicReference<Object> mState;
    private boolean mUpdating;
    private int mVersion;
    private final Map<Observable.Observer<? super T>, ObserverWrapper<T>> mWrapperMap;

    public static abstract class ErrorWrapper {
        public ErrorWrapper() {
        }

        public abstract Throwable getError();

        public static ErrorWrapper wrap(Throwable r100) {
            return new AutoValue_StateObservable_ErrorWrapper(r100);
        }
    }

    public static final class ObserverWrapper<T> implements Runnable {
        private static final Object NOT_SET = null;
        private static final int NO_VERSION = -1;
        private final AtomicBoolean mActive;
        private final Executor mExecutor;
        private Object mLastState;
        private int mLatestSignalledVersion;
        private final Observable.Observer<? super T> mObserver;
        private final AtomicReference<Object> mStateRef;
        private boolean mWrapperUpdating;

        public void androidx_camera_core_impl_StateObservable$ObserverWrapper__run$___twin___() {
            monitor-enter(this);
        L31:
            th = move-exception;
            throw th;
        L4:
            if (this.mActive.get() == true) goto L8;
            this.mWrapperUpdating = false;     // Catch: Throwable -> L31
            monitor-exit(this);     // Catch: Throwable -> L31
            return;
        L8:
            Object r100 = this.mStateRef.get();     // Catch: Throwable -> L31
            int r101 = this.mLatestSignalledVersion;     // Catch: Throwable -> L31
            monitor-exit(this);     // Catch: Throwable -> L31
        L11:
            if (Objects.equals(this.mLastState, r100) == true) goto L16;
            this.mLastState = r100;
            if ((r100 instanceof ErrorWrapper) == false) goto L15;
            this.mObserver.onError(((ErrorWrapper) r100).getError());
            goto L16
        L15:
            this.mObserver.onNewData(r100);
        L16:
            monitor-enter(this);
        L28:
            th = move-exception;
            throw th;
        L18:
            if (r101 == this.mLatestSignalledVersion) goto L25;
            if (this.mActive.get() == false) goto L25;
            r100 = this.mStateRef.get();     // Catch: Throwable -> L28
            r101 = this.mLatestSignalledVersion;     // Catch: Throwable -> L28
            monitor-exit(this);     // Catch: Throwable -> L28
        L25:
            this.mWrapperUpdating = false;     // Catch: Throwable -> L28
            monitor-exit(this);     // Catch: Throwable -> L28
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx_camera_core_impl_StateObservable$ObserverWrapper_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        static {
            NOT_SET = new Object();
        }

        public void close() {
            this.mActive.set(false);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void androidx_camera_core_impl_StateObservable$ObserverWrapper_com_larus_apm_impl_protector_RunnableLancet_run(ObserverWrapper r100) {
            r100.androidx_camera_core_impl_StateObservable$ObserverWrapper__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public void update(int r100) {
            monitor-enter(this);
        L27:
            th = move-exception;
            throw th;
        L4:
            if (this.mActive.get() == true) goto L8;
            monitor-exit(this);     // Catch: Throwable -> L27
            return;
        L8:
            if (r100 > this.mLatestSignalledVersion) goto L11;
            monitor-exit(this);     // Catch: Throwable -> L27
            return;
        L11:
            this.mLatestSignalledVersion = r100;     // Catch: Throwable -> L27
            if (this.mWrapperUpdating == false) goto L15;
            monitor-exit(this);     // Catch: Throwable -> L27
            return;
        L15:
            this.mWrapperUpdating = true;     // Catch: Throwable -> L27
            monitor-exit(this);     // Catch: Throwable -> L27
            this.mExecutor.execute(this);     // Catch: Throwable -> L19
            return;
        L19:
            monitor-enter(this);
            this.mWrapperUpdating = false;     // Catch: Throwable -> L24
            return;
        L24:
            th = move-exception;
            throw th;
        }

        public ObserverWrapper(AtomicReference<Object> r100, Executor r101, Observable.Observer<? super T> r102) {
            this.mActive = new AtomicBoolean(true);
            this.mLastState = NOT_SET;
            this.mLatestSignalledVersion = -1;
            this.mWrapperUpdating = false;
            this.mStateRef = r100;
            this.mExecutor = r101;
            this.mObserver = r102;
        }
    }

    @Override // androidx.camera.core.impl.Observable
    public ListenableFuture<T> fetchData() {
        Object r100 = this.mState.get();
        if ((r100 instanceof ErrorWrapper) == false) goto L7;
        return Futures.immediateFailedFuture(((ErrorWrapper) r100).getError());
    L7:
        return Futures.immediateFuture(r100);
    }

    public void removeObservers() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        Iterator r101 = new HashSet(this.mWrapperMap.keySet()).iterator();     // Catch: Throwable -> L10
    L6:
        if (r101.hasNext() == false) goto L8;
        removeObserverLocked((Observable.Observer) r101.next());     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r100);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void removeObserverLocked(Observable.Observer<? super T> r100) {
        ObserverWrapper<T> r101 = this.mWrapperMap.remove(r100);
        if (r101 == null) goto L6;
        r101.close();
        this.mNotifySet.remove(r101);
        return;
    }

    private void updateStateInternal(Object r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
    L30:
        th = move-exception;
        throw th;
    L5:
        if (Objects.equals(this.mState.getAndSet(r100), r100) == false) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L30
        return;
    L8:
        int r102 = this.mVersion + 1;     // Catch: Throwable -> L30
        this.mVersion = r102;     // Catch: Throwable -> L30
        if (this.mUpdating == false) goto L12;
        monitor-exit(r101);     // Catch: Throwable -> L30
        return;
    L12:
        this.mUpdating = true;     // Catch: Throwable -> L30
        Iterator<ObserverWrapper<T>> r103 = this.mNotifySet.iterator();     // Catch: Throwable -> L30
        monitor-exit(r101);     // Catch: Throwable -> L30
    L15:
        if (r103.hasNext() == true) goto L16;
        Object r104 = this.mLock;
        monitor-enter(r104);
    L27:
        th = move-exception;
        throw th;
    L20:
        if (this.mVersion == r102) goto L21;
        Iterator<ObserverWrapper<T>> r105 = this.mNotifySet.iterator();     // Catch: Throwable -> L27
        int r106 = this.mVersion;     // Catch: Throwable -> L27
        monitor-exit(r104);     // Catch: Throwable -> L27
        r103 = r105;
        r102 = r106;
        goto L15
    L21:
        this.mUpdating = false;     // Catch: Throwable -> L27
        monitor-exit(r104);     // Catch: Throwable -> L27
        return;
    L16:
        r103.next().update(r102);
        goto L15
    }

    @Override // androidx.camera.core.impl.Observable
    public void removeObserver(Observable.Observer<? super T> r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        removeObserverLocked(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void updateState(T r100) {
        updateStateInternal(r100);
    }

    public void updateStateAsError(Throwable r100) {
        updateStateInternal(ErrorWrapper.wrap(r100));
    }

    public StateObservable(Object r100, boolean r101) {
        this.mLock = new Object();
        this.mVersion = 0;
        this.mUpdating = false;
        this.mWrapperMap = new HashMap();
        this.mNotifySet = new CopyOnWriteArraySet();
        if (r101 == false) goto L5;
        Preconditions.checkArgument(r100 instanceof Throwable, "Initial errors must be Throwable");
        this.mState = new AtomicReference(ErrorWrapper.wrap((Throwable) r100));
        return;
    L5:
        this.mState = new AtomicReference(r100);
    }

    @Override // androidx.camera.core.impl.Observable
    public void addObserver(Executor r100, Observable.Observer<? super T> r101) {
        Object r102 = this.mLock;
        monitor-enter(r102);
        removeObserverLocked(r101);     // Catch: Throwable -> L8
        ObserverWrapper<T> r103 = new ObserverWrapper(this.mState, r100, r101);     // Catch: Throwable -> L8
        this.mWrapperMap.put(r101, r103);     // Catch: Throwable -> L8
        this.mNotifySet.add(r103);     // Catch: Throwable -> L8
        monitor-exit(r102);     // Catch: Throwable -> L8
        r103.update(0);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}

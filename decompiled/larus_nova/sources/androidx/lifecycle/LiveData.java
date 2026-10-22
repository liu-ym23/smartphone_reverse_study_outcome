package androidx.lifecycle;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.SafeIterableMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class LiveData<T> {
    static final Object NOT_SET = null;
    static final int START_VERSION = -1;
    int mActiveCount;
    private boolean mChangingActiveState;
    private volatile Object mData;
    final Object mDataLock;
    private boolean mDispatchInvalidated;
    private boolean mDispatchingValue;
    private SafeIterableMap<Observer<? super T>, LiveData<T>.ObserverWrapper> mObservers;
    volatile Object mPendingData;
    private final Runnable mPostValueRunnable;
    private int mVersion;

    /* JADX INFO: loaded from: classes3.dex */
    public class AlwaysActiveObserver extends LiveData<T>.ObserverWrapper {
        final /* synthetic */ LiveData this$0;

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        public boolean shouldBeActive() {
            return true;
        }

        public AlwaysActiveObserver(LiveData r100, Observer<? super T> r101) {
            this.this$0 = r100;
            super(r100, r101);
        }
    }

    public class LifecycleBoundObserver extends LiveData<T>.ObserverWrapper implements LifecycleEventObserver {
        final LifecycleOwner mOwner;
        final /* synthetic */ LiveData this$0;

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        public void detachObserver() {
            this.mOwner.getLifecycle().removeObserver(this);
        }

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        public boolean shouldBeActive() {
            return this.mOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED);
        }

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        public boolean isAttachedTo(LifecycleOwner r100) {
            if (this.mOwner != r100) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(LifecycleOwner r100, Lifecycle.Event r101) {
            Lifecycle.State r102 = this.mOwner.getLifecycle().getCurrentState();
            if (r102 != Lifecycle.State.DESTROYED) goto L6;
            this.this$0.removeObserver(this.mObserver);
            return;
        L6:
            Lifecycle.State r103 = null;
        L7:
            if (r103 == r102) goto L9;
            activeStateChanged(shouldBeActive());
            Lifecycle.State r104 = this.mOwner.getLifecycle().getCurrentState();
            r103 = r102;
            r102 = r104;
            goto L7
        }

        public LifecycleBoundObserver(LiveData r100, LifecycleOwner r101, Observer<? super T> r102) {
            this.this$0 = r100;
            super(r100, r102);
            this.mOwner = r101;
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public abstract class ObserverWrapper {
        boolean mActive;
        int mLastVersion;
        final Observer<? super T> mObserver;
        final /* synthetic */ LiveData this$0;

        void detachObserver() {
        }

        boolean isAttachedTo(LifecycleOwner r100) {
            return false;
        }

        abstract boolean shouldBeActive();

        public void activeStateChanged(boolean r100) {
            if (r100 != this.mActive) goto L5;
            return;
        L5:
            this.mActive = r100;
            LiveData r101 = this.this$0;
            if (r100 == false) goto L8;
            int r102 = 1;
        L9:
            r101.changeActiveCounter(r102);
            if (this.mActive == false) goto L13;
            this.this$0.dispatchingValue(this);
            return;
        L13:
            return;
        L8:
            r102 = -1;
            goto L9
        }

        public ObserverWrapper(LiveData r100, Observer<? super T> r101) {
            this.this$0 = r100;
            this.mLastVersion = -1;
            this.mObserver = r101;
        }
    }

    public void onActive() {
    }

    public void onInactive() {
    }

    static {
        NOT_SET = new Object();
    }

    public T getValue() {
        T r100 = (T) this.mData;
        if (r100 == NOT_SET) goto L5;
        return r100;
    L5:
        return null;
    }

    public boolean hasActiveObservers() {
        if (this.mActiveCount <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasObservers() {
        if (this.mObservers.size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isInitialized() {
        if (this.mData == NOT_SET) goto L5;
        return true;
    L5:
        return false;
    }

    public LiveData() {
        this.mDataLock = new Object();
        this.mObservers = new SafeIterableMap();
        this.mActiveCount = 0;
        Object r100 = NOT_SET;
        this.mPendingData = r100;
        this.mPostValueRunnable = new AnonymousClass1(this);
        this.mData = r100;
        this.mVersion = -1;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public LiveData(T r100) {
        this.mDataLock = new Object();
        this.mObservers = new SafeIterableMap();
        this.mActiveCount = 0;
        this.mPendingData = NOT_SET;
        this.mPostValueRunnable = new AnonymousClass1(this);
        this.mData = r100;
        this.mVersion = 0;
    }

    public static void assertMainThread(String r100) {
        if (ArchTaskExecutor.getInstance().isMainThread() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Cannot invoke " + r100 + " on a background thread");
    }

    private void considerNotify(LiveData<T>.ObserverWrapper r100) {
        if (r100.mActive == true) goto L6;
        return;
    L6:
        if (r100.shouldBeActive() == true) goto L9;
        r100.activeStateChanged(false);
        return;
    L9:
        int r101 = r100.mLastVersion;
        int r102 = this.mVersion;
        if (r101 < r102) goto L12;
        return;
    L12:
        r100.mLastVersion = r102;
        r100.mObserver.onChanged((Object) this.mData);
    }

    public void changeActiveCounter(int r100) {
        int r101 = this.mActiveCount;
        this.mActiveCount = r100 + r101;
        if (this.mChangingActiveState == false) goto L5;
        return;
    L5:
        this.mChangingActiveState = true;
    L27:
        int r102 = this.mActiveCount;     // Catch: Throwable -> L24
        if (r101 == r102) goto L22;
        if (r101 != 0) goto L12;
        if (r102 <= 0) goto L12;
        boolean r103 = true;
    L13:
        if (r101 <= 0) goto L16;
        if (r102 != 0) goto L16;
        boolean r104 = true;
    L17:
        if (r103 == false) goto L19;
        onActive();     // Catch: Throwable -> L24
    L21:
        r101 = r102;
        goto L27
    L19:
        if (r104 == false) goto L21;
        onInactive();     // Catch: Throwable -> L24
    L16:
        r104 = false;
    L12:
        r103 = false;
        goto L13
    L22:
        this.mChangingActiveState = false;
        return;
    L24:
        th = move-exception;
        this.mChangingActiveState = false;
        throw th;
    }

    public void dispatchingValue(LiveData<T>.ObserverWrapper r100) {
        if (this.mDispatchingValue == false) goto L6;
        this.mDispatchInvalidated = true;
        return;
    L6:
        this.mDispatchingValue = true;
    L7:
        this.mDispatchInvalidated = false;
        if (r100 == null) goto L10;
        considerNotify(r100);
        r100 = null;
    L16:
        if (this.mDispatchInvalidated == true) goto L7;
        this.mDispatchingValue = false;
        return;
    L10:
        SafeIterableMap<Observer<? super T>, LiveData<T>.ObserverWrapper>.IteratorWithAdditions r101 = this.mObservers.iteratorWithAdditions();
    L12:
        if (r101.hasNext() == false) goto L16;
        considerNotify((ObserverWrapper) r101.next().getValue());
        if (this.mDispatchInvalidated == false) goto L12;
        goto L16
    }

    public void observeForever(Observer<? super T> r100) {
        assertMainThread("observeForever");
        AlwaysActiveObserver r101 = new AlwaysActiveObserver(this, r100);
        LiveData<T>.ObserverWrapper r102 = this.mObservers.putIfAbsent(r100, r101);
        if ((r102 instanceof LifecycleBoundObserver) == true) goto L9;
        if (r102 == null) goto L6;
        return;
    L6:
        r101.activeStateChanged(true);
        return;
    L9:
        throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
    }

    public void postValue(T r100) {
        Object r101 = this.mDataLock;
        monitor-enter(r101);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.mPendingData != NOT_SET) goto L7;
        boolean r102 = true;
    L8:
        this.mPendingData = r100;     // Catch: Throwable -> L14
        monitor-exit(r101);     // Catch: Throwable -> L14
        if (r102 == true) goto L12;
        return;
    L12:
        ArchTaskExecutor.getInstance().postToMainThread(this.mPostValueRunnable);
        return;
    L7:
        r102 = false;
        goto L8
    }

    public void removeObserver(Observer<? super T> r100) {
        assertMainThread("removeObserver");
        LiveData<T>.ObserverWrapper r101 = this.mObservers.remove(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        r101.detachObserver();
        r101.activeStateChanged(false);
    }

    public void removeObservers(LifecycleOwner r100) {
        assertMainThread("removeObservers");
        Iterator<Map.Entry<Observer<? super T>, LiveData<T>.ObserverWrapper>> r101 = this.mObservers.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Map.Entry<Observer<? super T>, LiveData<T>.ObserverWrapper> r102 = r101.next();
        if (r102.getValue().isAttachedTo(r100) == false) goto L4;
        removeObserver(r102.getKey());
        goto L4
    }

    public void setValue(T r100) {
        assertMainThread("setValue");
        this.mVersion++;
        this.mData = r100;
        dispatchingValue(null);
    }

    public void observe(LifecycleOwner r100, Observer<? super T> r101) {
        assertMainThread("observe");
        if (r100.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        return;
    L5:
        LifecycleBoundObserver r102 = new LifecycleBoundObserver(this, r100, r101);
        LiveData<T>.ObserverWrapper r103 = this.mObservers.putIfAbsent(r101, r102);
        if (r103 != null) goto L8;
    L12:
        if (r103 == null) goto L14;
        return;
    L14:
        r100.getLifecycle().addObserver(r102);
        return;
    L8:
        if (r103.isAttachedTo(r100) == true) goto L12;
        throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
    }
}

package androidx.paging;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.ref.WeakReference;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes17.dex */
public abstract class PagedList<T> extends AbstractList<T> {
    final Executor mBackgroundThreadExecutor;
    final BoundaryCallback<T> mBoundaryCallback;
    boolean mBoundaryCallbackBeginDeferred;
    boolean mBoundaryCallbackEndDeferred;
    private final ArrayList<WeakReference<Callback>> mCallbacks;
    final Config mConfig;
    private final AtomicBoolean mDetached;
    private int mHighestIndexAccessed;
    T mLastItem;
    int mLastLoad;
    private int mLowestIndexAccessed;
    final Executor mMainThreadExecutor;
    final int mRequiredRemainder;
    final PagedStorage<T> mStorage;

    public static abstract class BoundaryCallback<T> {
        public BoundaryCallback() {
        }

        public void onItemAtEndLoaded(T r100) {
        }

        public void onItemAtFrontLoaded(T r100) {
        }

        public void onZeroItemsLoaded() {
        }
    }

    public static final class Builder<Key, Value> {
        private BoundaryCallback mBoundaryCallback;
        private final Config mConfig;
        private final DataSource<Key, Value> mDataSource;
        private Executor mFetchExecutor;
        private Key mInitialKey;
        private Executor mNotifyExecutor;

        public PagedList<Value> build() {
            Executor r100 = this.mNotifyExecutor;
            if (r100 == null) goto L11;
            Executor r101 = this.mFetchExecutor;
            if (r101 == null) goto L9;
            return PagedList.create(this.mDataSource, r100, r101, this.mBoundaryCallback, this.mConfig, this.mInitialKey);
        L9:
            throw new IllegalArgumentException("BackgroundThreadExecutor required");
        L11:
            throw new IllegalArgumentException("MainThreadExecutor required");
        }

        public Builder<Key, Value> setBoundaryCallback(BoundaryCallback r100) {
            this.mBoundaryCallback = r100;
            return this;
        }

        public Builder<Key, Value> setFetchExecutor(Executor r100) {
            this.mFetchExecutor = r100;
            return this;
        }

        public Builder<Key, Value> setInitialKey(Key r100) {
            this.mInitialKey = r100;
            return this;
        }

        public Builder<Key, Value> setNotifyExecutor(Executor r100) {
            this.mNotifyExecutor = r100;
            return this;
        }

        public Builder(DataSource<Key, Value> r100, Config r101) {
            if (r100 == null) goto L10;
            if (r101 == null) goto L8;
            this.mDataSource = r100;
            this.mConfig = r101;
            return;
        L8:
            throw new IllegalArgumentException("Config may not be null");
        L10:
            throw new IllegalArgumentException("DataSource may not be null");
        }

        public Builder(DataSource<Key, Value> r100, int r101) {
            this(r100, new Config.Builder().setPageSize(r101).build());
        }
    }

    public static abstract class Callback {
        public Callback() {
        }

        public abstract void onChanged(int r100, int r101);

        public abstract void onInserted(int r100, int r101);

        public abstract void onRemoved(int r100, int r101);
    }

    public static class Config {
        public static final int MAX_SIZE_UNBOUNDED = Integer.MAX_VALUE;
        public final boolean enablePlaceholders;
        public final int initialLoadSizeHint;
        public final int maxSize;
        public final int pageSize;
        public final int prefetchDistance;

        public static final class Builder {
            static final int DEFAULT_INITIAL_PAGE_MULTIPLIER = 3;
            private boolean mEnablePlaceholders;
            private int mInitialLoadSizeHint;
            private int mMaxSize;
            private int mPageSize;
            private int mPrefetchDistance;

            public Config build() {
                if (this.mPrefetchDistance >= 0) goto L6;
                this.mPrefetchDistance = this.mPageSize;
            L6:
                if (this.mInitialLoadSizeHint >= 0) goto L8;
                this.mInitialLoadSizeHint = this.mPageSize * 3;
            L8:
                boolean r100 = this.mEnablePlaceholders;
                if (r100 == false) goto L11;
            L15:
                int r101 = this.mMaxSize;
                if (r101 == Integer.MAX_VALUE) goto L23;
                if (r101 >= (this.mPageSize + (this.mPrefetchDistance * 2))) goto L23;
                throw new IllegalArgumentException("Maximum size must be at least pageSize + 2*prefetchDist, pageSize=" + this.mPageSize + ", prefetchDist=" + this.mPrefetchDistance + ", maxSize=" + this.mMaxSize);
            L23:
                return new Config(this.mPageSize, this.mPrefetchDistance, r100, this.mInitialLoadSizeHint, r101);
            L11:
                if (this.mPrefetchDistance != 0) goto L15;
                throw new IllegalArgumentException("Placeholders and prefetch are the only ways to trigger loading of more data in the PagedList, so either placeholders must be enabled, or prefetch distance must be > 0.");
            }

            public Builder() {
                this.mPageSize = -1;
                this.mPrefetchDistance = -1;
                this.mInitialLoadSizeHint = -1;
                this.mEnablePlaceholders = true;
                this.mMaxSize = Integer.MAX_VALUE;
            }

            public Builder setEnablePlaceholders(boolean r100) {
                this.mEnablePlaceholders = r100;
                return this;
            }

            public Builder setInitialLoadSizeHint(int r100) {
                this.mInitialLoadSizeHint = r100;
                return this;
            }

            public Builder setMaxSize(int r100) {
                this.mMaxSize = r100;
                return this;
            }

            public Builder setPageSize(int r100) {
                if (r100 < 1) goto L7;
                this.mPageSize = r100;
                return this;
            L7:
                throw new IllegalArgumentException("Page size must be a positive number");
            }

            public Builder setPrefetchDistance(int r100) {
                this.mPrefetchDistance = r100;
                return this;
            }
        }

        public Config(int r100, int r101, boolean r102, int r103, int r104) {
            this.pageSize = r100;
            this.prefetchDistance = r101;
            this.enablePlaceholders = r102;
            this.initialLoadSizeHint = r103;
            this.maxSize = r104;
        }
    }

    public abstract void dispatchUpdatesSinceSnapshot(PagedList<T> r100, Callback r101);

    public abstract DataSource<?, T> getDataSource();

    public abstract Object getLastKey();

    public abstract boolean isContiguous();

    public abstract void loadAroundInternal(int r100);

    public void detach() {
        this.mDetached.set(true);
    }

    public int getLoadedCount() {
        return this.mStorage.getLoadedCount();
    }

    public int getPositionOffset() {
        return this.mStorage.getPositionOffset();
    }

    public boolean isDetached() {
        return this.mDetached.get();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.mStorage.size();
    }

    public boolean isImmutable() {
        return isDetached();
    }

    public List<T> snapshot() {
        if (isImmutable() == false) goto L6;
        return this;
    L6:
        return new SnapshotPagedList(this);
    }

    public Config getConfig() {
        return this.mConfig;
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int r100) {
        T r101 = this.mStorage.get(r100);
        if (r101 == null) goto L5;
        this.mLastItem = r101;
    L5:
        return r101;
    }

    public void loadAround(int r100) {
        if (r100 < 0) goto L8;
        if (r100 >= size()) goto L8;
        this.mLastLoad = getPositionOffset() + r100;
        loadAroundInternal(r100);
        this.mLowestIndexAccessed = Math.min(this.mLowestIndexAccessed, r100);
        this.mHighestIndexAccessed = Math.max(this.mHighestIndexAccessed, r100);
        tryDispatchBoundaryCallbacks(true);
        return;
    L8:
        throw new IndexOutOfBoundsException("Index: " + r100 + ", Size: " + size());
    }

    public void offsetAccessIndices(int r100) {
        this.mLastLoad += r100;
        this.mLowestIndexAccessed += r100;
        this.mHighestIndexAccessed += r100;
    }

    public void removeWeakCallback(Callback r100) {
        int r101 = this.mCallbacks.size() - 1;
    L3:
        if (r101 < 0) goto L9;
        Callback r102 = (Callback) ((WeakReference) ListProtector.get(this.mCallbacks, r101)).get();
        if (r102 == null) goto L7;
        if (r102 == r100) goto L7;
    L8:
        r101 = r101 - 1;
    L7:
        ListProtector.remove(this.mCallbacks, r101);
        goto L8
    }

    public void tryDispatchBoundaryCallbacks(boolean r100) {
        final boolean r101 = true;
        if (this.mBoundaryCallbackBeginDeferred == true) goto L5;
    L7:
        final boolean r102 = false;
    L9:
        if (this.mBoundaryCallbackEndDeferred == true) goto L11;
    L13:
        r101 = false;
    L14:
        if (r102 == true) goto L17;
        if (r101 == true) goto L17;
        return;
    L17:
        if (r102 == false) goto L19;
        this.mBoundaryCallbackBeginDeferred = false;
    L19:
        if (r101 == false) goto L21;
        this.mBoundaryCallbackEndDeferred = false;
    L21:
        if (r100 == false) goto L23;
        this.mMainThreadExecutor.execute(new AnonymousClass2(this, r102, r101));
        return;
    L23:
        dispatchBoundaryCallbacks(r102, r101);
        return;
    L11:
        if (this.mHighestIndexAccessed < ((size() - 1) - this.mConfig.prefetchDistance)) goto L13;
    L5:
        if (this.mLowestIndexAccessed > this.mConfig.prefetchDistance) goto L7;
        r102 = true;
        goto L9
    }

    public void addWeakCallback(List<T> r100, Callback r101) {
        if (r100 == null) goto L10;
        if (r100 == this) goto L10;
        if (r100.isEmpty() == true) goto L7;
        dispatchUpdatesSinceSnapshot((PagedList) r100, r101);
        goto L10
    L7:
        if (this.mStorage.isEmpty() == true) goto L10;
        r101.onInserted(0, this.mStorage.size());
    L10:
        int r102 = this.mCallbacks.size() - 1;
    L11:
        if (r102 < 0) goto L16;
        if (((Callback) ((WeakReference) ListProtector.get(this.mCallbacks, r102)).get()) != null) goto L15;
        ListProtector.remove(this.mCallbacks, r102);
    L15:
        r102 = r102 - 1;
        goto L11
    L16:
        this.mCallbacks.add(new WeakReference(r101));
    }

    public void dispatchBoundaryCallbacks(boolean r100, boolean r101) {
        if (r100 == false) goto L4;
        this.mBoundaryCallback.onItemAtFrontLoaded(this.mStorage.getFirstLoadedItem());
    L4:
        if (r101 == false) goto L7;
        this.mBoundaryCallback.onItemAtEndLoaded(this.mStorage.getLastLoadedItem());
        return;
    }

    public void notifyChanged(int r100, int r101) {
        if (r101 == 0) goto L9;
        int r102 = this.mCallbacks.size() - 1;
    L4:
        if (r102 < 0) goto L13;
        Callback r103 = (Callback) ((WeakReference) ListProtector.get(this.mCallbacks, r102)).get();
        if (r103 == null) goto L8;
        r103.onChanged(r100, r101);
    L8:
        r102 = r102 - 1;
        goto L4
    L13:
        return;
    }

    public void notifyInserted(int r100, int r101) {
        if (r101 == 0) goto L9;
        int r102 = this.mCallbacks.size() - 1;
    L4:
        if (r102 < 0) goto L13;
        Callback r103 = (Callback) ((WeakReference) ListProtector.get(this.mCallbacks, r102)).get();
        if (r103 == null) goto L8;
        r103.onInserted(r100, r101);
    L8:
        r102 = r102 - 1;
        goto L4
    L13:
        return;
    }

    public void notifyRemoved(int r100, int r101) {
        if (r101 == 0) goto L9;
        int r102 = this.mCallbacks.size() - 1;
    L4:
        if (r102 < 0) goto L13;
        Callback r103 = (Callback) ((WeakReference) ListProtector.get(this.mCallbacks, r102)).get();
        if (r103 == null) goto L8;
        r103.onRemoved(r100, r101);
    L8:
        r102 = r102 - 1;
        goto L4
    L13:
        return;
    }

    public void deferBoundaryCallbacks(final boolean r100, final boolean r101, final boolean r102) {
        if (this.mBoundaryCallback == null) goto L16;
        if (this.mLowestIndexAccessed != Integer.MAX_VALUE) goto L8;
        this.mLowestIndexAccessed = this.mStorage.size();
    L8:
        if (this.mHighestIndexAccessed != Integer.MIN_VALUE) goto L10;
        this.mHighestIndexAccessed = 0;
    L10:
        if (r100 == true) goto L13;
        if (r101 == true) goto L13;
        if (r102 == true) goto L13;
        return;
    L13:
        this.mMainThreadExecutor.execute(new AnonymousClass1(this, r100, r101, r102));
        return;
    L16:
        throw new IllegalStateException("Can't defer BoundaryCallback, no instance");
    }

    public PagedList(PagedStorage<T> r100, Executor r101, Executor r102, BoundaryCallback<T> r103, Config r104) {
        this.mLastLoad = 0;
        this.mLastItem = null;
        this.mBoundaryCallbackBeginDeferred = false;
        this.mBoundaryCallbackEndDeferred = false;
        this.mLowestIndexAccessed = Integer.MAX_VALUE;
        this.mHighestIndexAccessed = Integer.MIN_VALUE;
        this.mDetached = new AtomicBoolean(false);
        this.mCallbacks = new ArrayList();
        this.mStorage = r100;
        this.mMainThreadExecutor = r101;
        this.mBackgroundThreadExecutor = r102;
        this.mBoundaryCallback = r103;
        this.mConfig = r104;
        this.mRequiredRemainder = (r104.prefetchDistance * 2) + r104.pageSize;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, T> PagedList<T> create(DataSource<K, T> r100, Executor r101, Executor r110, BoundaryCallback<T> r111, Config r112, K r113) {
        if (r100.isContiguous() == true) goto L14;
        if (r112.enablePlaceholders == false) goto L14;
        PositionalDataSource r102 = (PositionalDataSource) r100;
        if (r113 == 0) goto L10;
        int r103 = ((Integer) r113).intValue();
    L12:
        return new TiledPagedList(r102, r101, r110, r111, r112, r103);
    L10:
        r103 = 0;
    L14:
        if (r100.isContiguous() == true) goto L18;
        r100 = ((PositionalDataSource) r100).wrapAsContiguousWithoutPlaceholders();
        if (r113 == 0) goto L18;
        int r104 = ((Integer) r113).intValue();
    L20:
        return new ContiguousPagedList((ContiguousDataSource) r100, r101, r110, r111, r112, r113, r104);
    L18:
        r104 = -1;
        goto L20
    }
}

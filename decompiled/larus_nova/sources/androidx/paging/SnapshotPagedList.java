package androidx.paging;

/* JADX INFO: loaded from: classes17.dex */
class SnapshotPagedList<T> extends PagedList<T> {
    private final boolean mContiguous;
    private final DataSource<?, T> mDataSource;
    private final Object mLastKey;

    @Override // androidx.paging.PagedList
    public void dispatchUpdatesSinceSnapshot(PagedList<T> r100, PagedList.Callback r101) {
    }

    @Override // androidx.paging.PagedList
    public boolean isDetached() {
        return true;
    }

    @Override // androidx.paging.PagedList
    public boolean isImmutable() {
        return true;
    }

    @Override // androidx.paging.PagedList
    public void loadAroundInternal(int r100) {
    }

    @Override // androidx.paging.PagedList
    public DataSource<?, T> getDataSource() {
        return this.mDataSource;
    }

    @Override // androidx.paging.PagedList
    public Object getLastKey() {
        return this.mLastKey;
    }

    @Override // androidx.paging.PagedList
    public boolean isContiguous() {
        return this.mContiguous;
    }

    public SnapshotPagedList(PagedList<T> r100) {
        super(r100.mStorage.snapshot(), r100.mMainThreadExecutor, r100.mBackgroundThreadExecutor, null, r100.mConfig);
        this.mDataSource = r100.getDataSource();
        this.mContiguous = r100.isContiguous();
        this.mLastLoad = r100.mLastLoad;
        this.mLastKey = r100.getLastKey();
    }
}

package androidx.paging;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes17.dex */
class TiledPagedList<T> extends PagedList<T> implements PagedStorage.Callback {
    final PositionalDataSource<T> mDataSource;
    PageResult.Receiver<T> mReceiver;

    @Override // androidx.paging.PagedList
    public boolean isContiguous() {
        return false;
    }

    @Override // androidx.paging.PagedList
    public Object getLastKey() {
        return Integer.valueOf(this.mLastLoad);
    }

    @Override // androidx.paging.PagedStorage.Callback
    public void onEmptyAppend() {
        throw new IllegalStateException("Contiguous callback on TiledPagedList");
    }

    @Override // androidx.paging.PagedStorage.Callback
    public void onEmptyPrepend() {
        throw new IllegalStateException("Contiguous callback on TiledPagedList");
    }

    @Override // androidx.paging.PagedList
    public DataSource<?, T> getDataSource() {
        return this.mDataSource;
    }

    @Override // androidx.paging.PagedList
    public void loadAroundInternal(int r100) {
        PagedStorage<T> r101 = this.mStorage;
        PagedList.Config r102 = this.mConfig;
        r101.allocatePlaceholders(r100, r102.prefetchDistance, r102.pageSize, this);
    }

    @Override // androidx.paging.PagedStorage.Callback
    public void onInitialized(int r100) {
        notifyInserted(0, r100);
    }

    @Override // androidx.paging.PagedStorage.Callback
    public void onPagePlaceholderInserted(final int r100) {
        this.mBackgroundThreadExecutor.execute(new AnonymousClass2(this, r100));
    }

    @Override // androidx.paging.PagedList
    public void dispatchUpdatesSinceSnapshot(PagedList<T> r110, PagedList.Callback r111) {
        PagedStorage<T> r112 = r110.mStorage;
        if (r112.isEmpty() == true) goto L21;
        if (this.mStorage.size() != r112.size()) goto L21;
        int r100 = this.mConfig.pageSize;
        int r101 = this.mStorage.getLeadingNullCount() / r100;
        int r102 = this.mStorage.getPageCount();
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L19;
        int r104 = r103 + r101;
        int r105 = 0;
    L10:
        if (r105 >= this.mStorage.getPageCount()) goto L16;
        int r106 = r104 + r105;
        if (this.mStorage.hasPage(r100, r106) == false) goto L16;
        if (r112.hasPage(r100, r106) == true) goto L16;
        r105 = r105 + 1;
    L16:
        if (r105 <= 0) goto L18;
        r111.onChanged(r104 * r100, r100 * r105);
        r103 = r103 + (r105 - 1);
    L18:
        r103 = r103 + 1;
        goto L7
    L19:
        return;
    L21:
        throw new IllegalArgumentException("Invalid snapshot provided - doesn't appear to be a snapshot of this PagedList");
    }

    @Override // androidx.paging.PagedStorage.Callback
    public void onPageInserted(int r100, int r101) {
        notifyChanged(r100, r101);
    }

    @Override // androidx.paging.PagedStorage.Callback
    public void onPagesRemoved(int r100, int r101) {
        notifyRemoved(r100, r101);
    }

    @Override // androidx.paging.PagedStorage.Callback
    public void onPagesSwappedToPlaceholder(int r100, int r101) {
        notifyChanged(r100, r101);
    }

    @Override // androidx.paging.PagedStorage.Callback
    public void onPageAppended(int r100, int r101, int r102) {
        throw new IllegalStateException("Contiguous callback on TiledPagedList");
    }

    @Override // androidx.paging.PagedStorage.Callback
    public void onPagePrepended(int r100, int r101, int r102) {
        throw new IllegalStateException("Contiguous callback on TiledPagedList");
    }

    public TiledPagedList(PositionalDataSource<T> r100, Executor r101, Executor r110, PagedList.BoundaryCallback<T> r111, PagedList.Config r112, int r113) {
        super(new PagedStorage(), r101, r110, r111, r112);
        this.mReceiver = new AnonymousClass1(this);
        this.mDataSource = r100;
        int r102 = this.mConfig.pageSize;
        this.mLastLoad = r113;
        if (r100.isInvalid() == false) goto L5;
        detach();
        return;
    L5:
        int r103 = Math.max(this.mConfig.initialLoadSizeHint / r102, 2) * r102;
        r100.dispatchLoadInitial(true, Math.max(0, ((r113 - (r103 / 2)) / r102) * r102), r103, r102, this.mMainThreadExecutor, this.mReceiver);
    }
}

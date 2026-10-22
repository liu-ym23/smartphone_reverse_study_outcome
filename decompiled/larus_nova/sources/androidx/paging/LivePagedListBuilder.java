package androidx.paging;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.lifecycle.LiveData;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes17.dex */
public final class LivePagedListBuilder<Key, Value> {
    private PagedList.BoundaryCallback mBoundaryCallback;
    private PagedList.Config mConfig;
    private DataSource.Factory<Key, Value> mDataSourceFactory;
    private Executor mFetchExecutor;
    private Key mInitialLoadKey;

    public LiveData<PagedList<Value>> build() {
        return create(this.mInitialLoadKey, this.mConfig, this.mBoundaryCallback, this.mDataSourceFactory, ArchTaskExecutor.getMainThreadExecutor(), this.mFetchExecutor);
    }

    public LivePagedListBuilder<Key, Value> setBoundaryCallback(PagedList.BoundaryCallback<Value> r100) {
        this.mBoundaryCallback = r100;
        return this;
    }

    public LivePagedListBuilder<Key, Value> setFetchExecutor(Executor r100) {
        this.mFetchExecutor = r100;
        return this;
    }

    public LivePagedListBuilder<Key, Value> setInitialLoadKey(Key r100) {
        this.mInitialLoadKey = r100;
        return this;
    }

    public LivePagedListBuilder(DataSource.Factory<Key, Value> r100, PagedList.Config r101) {
        this.mFetchExecutor = ArchTaskExecutor.getIOThreadExecutor();
        if (r101 == null) goto L10;
        if (r100 == null) goto L8;
        this.mDataSourceFactory = r100;
        this.mConfig = r101;
        return;
    L8:
        throw new IllegalArgumentException("DataSource.Factory must be provided");
    L10:
        throw new IllegalArgumentException("PagedList.Config must be provided");
    }

    public LivePagedListBuilder(DataSource.Factory<Key, Value> r100, int r101) {
        this(r100, new PagedList.Config.Builder().setPageSize(r101).build());
    }

    private static <Key, Value> LiveData<PagedList<Value>> create(final Key r100, final PagedList.Config r110, final PagedList.BoundaryCallback r111, final DataSource.Factory<Key, Value> r112, final Executor r113, final Executor r114) {
        return new AnonymousClass1(r114, r100, r112, r110, r113, r114, r111).getLiveData();
    }
}

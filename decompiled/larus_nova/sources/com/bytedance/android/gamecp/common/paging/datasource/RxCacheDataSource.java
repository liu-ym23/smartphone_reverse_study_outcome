package com.bytedance.android.gamecp.common.paging.datasource;

import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;

/* JADX INFO: loaded from: classes44.dex */
public abstract class RxCacheDataSource<DataKey, V, CacheKey> extends PageKeyedDataSource<DataKey, V> implements DataSource.InvalidatedCallback {
    @Override // androidx.paging.PageKeyedDataSource
    public final void loadBefore(PageKeyedDataSource.LoadParams<DataKey> r100, PageKeyedDataSource.LoadCallback<DataKey, V> r101) {
    }

    @Override // androidx.paging.DataSource.InvalidatedCallback
    public final void onInvalidated() {
        throw null;
    }

    @Override // androidx.paging.PageKeyedDataSource
    public final void loadAfter(PageKeyedDataSource.LoadParams<DataKey> r100, PageKeyedDataSource.LoadCallback<DataKey, V> r101) {
        throw null;
    }

    @Override // androidx.paging.PageKeyedDataSource
    public final void loadInitial(PageKeyedDataSource.LoadInitialParams<DataKey> r100, PageKeyedDataSource.LoadInitialCallback<DataKey, V> r101) {
        throw null;
    }
}

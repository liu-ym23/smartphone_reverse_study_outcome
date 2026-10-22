package com.bytedance.android.live.core.paging.datasource;

import com.bytedance.android.live.base.model.feed.FeedExtra;
import f60.a;
import io.reactivex.Observable;

/* JADX INFO: loaded from: classes45.dex */
public class DefaultRxCacheDataSource<CacheKey, V> extends RxCacheDataSource<Long, V, CacheKey> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final PagingLoadCallback<V> f65089m;

    public DefaultRxCacheDataSource(a<CacheKey, V> r100) {
        super(r100);
        this.f65089m = r100.f475683r;
    }

    @Override // com.bytedance.android.live.core.paging.datasource.RxCacheDataSource
    public final Long h(FeedExtra r100) {
        if (r100 != null) goto L4;
    L6:
        return null;
    L4:
        if (r100.hasMore == false) goto L6;
        return Long.valueOf(r100.maxTime);
    }

    @Override // com.bytedance.android.live.core.paging.datasource.RxCacheDataSource
    public final Observable e(boolean r100, Long r101, int r102) {
        PagingLoadCallback<V> r103 = this.f65089m;
        return r103.createObservable(r100, r101, r102);
    }
}

package com.bytedance.android.live.core.paging.builder;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.PagedList;
import com.bytedance.android.live.core.cache.f;
import com.bytedance.android.live.core.cache.n;
import com.bytedance.android.live.core.network.NetworkStat;
import com.bytedance.android.live.core.paging.Listing;
import com.bytedance.android.live.core.paging.datasource.PagingLoadCallback;
import f60.a;
import io.reactivex.subjects.PublishSubject;

/* JADX INFO: loaded from: classes45.dex */
public class LiveDataBuilder<V> implements DataBuilder<V> {
    private a<String, V> liveDataBuilder;

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public Listing<V> build() {
        a<String, V> r100 = this.liveDataBuilder;
        r100.f475679n = "single.memory.list.cache.default.key";
        n r101 = new n();
        f r102 = new f();
        r100.f475680o = r101;
        r100.f475681p = r102;
        return r100.build();
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public PagingLoadCallback<V> callback() {
        return this.liveDataBuilder.f475683r;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public MutableLiveData<Boolean> empty() {
        return this.liveDataBuilder.f475670e;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public long getGeneration() {
        return this.liveDataBuilder.getGeneration();
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public MutableLiveData<Boolean> hasMore() {
        return this.liveDataBuilder.f475669d;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public boolean hasRefreshFlag() {
        return this.liveDataBuilder.f475675j;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public boolean hasUpdateFlag() {
        return this.liveDataBuilder.f475676k;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public long makeGeneration() {
        return this.liveDataBuilder.makeGeneration();
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public MutableLiveData<NetworkStat> networkState() {
        return this.liveDataBuilder.f475666a;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public PublishSubject<Object> refresh() {
        return this.liveDataBuilder.f475671f;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public MutableLiveData<NetworkStat> refreshState() {
        return this.liveDataBuilder.f475667b;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public boolean refreshing() {
        return this.liveDataBuilder.f475674i;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public PublishSubject<Object> retry() {
        return this.liveDataBuilder.f475672g;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public PublishSubject<Object> update() {
        return this.liveDataBuilder.update();
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public MutableLiveData<Integer> updateAdapterItem() {
        return this.liveDataBuilder.f475677l;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public MutableLiveData<NetworkStat> updateState() {
        return this.liveDataBuilder.f475668c;
    }

    public LiveDataBuilder() {
        this.liveDataBuilder = new a();
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public Listing<V> build(LiveData<PagedList<V>> r100) {
        return build();
    }

    public LiveDataBuilder<V> hasMore(MutableLiveData<Boolean> r100) {
        this.liveDataBuilder.f475669d = r100;
        return this;
    }

    public LiveDataBuilder<V> loadMoreCallback(PagingLoadCallback<V> r100) {
        this.liveDataBuilder.f475683r = r100;
        return this;
    }

    public LiveDataBuilder<V> networkStat(MutableLiveData<NetworkStat> r100) {
        this.liveDataBuilder.f475666a = r100;
        return this;
    }

    public LiveDataBuilder<V> pageConfig(int r100) {
        a<String, V> r101 = this.liveDataBuilder;
        r101.getClass();
        r101.f475682q = new PagedList.Config.Builder().setPageSize(r100).build();
        return this;
    }

    public LiveDataBuilder refresh(PublishSubject<Object> r100) {
        this.liveDataBuilder.f475671f = r100;
        return this;
    }

    public LiveDataBuilder<V> refreshStat(MutableLiveData<NetworkStat> r100) {
        this.liveDataBuilder.f475667b = r100;
        return this;
    }

    public LiveDataBuilder retry(PublishSubject<Object> r100) {
        this.liveDataBuilder.f475672g = r100;
        return this;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public void setRefreshFlag(boolean r100) {
        this.liveDataBuilder.f475675j = r100;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public void setRefreshing(boolean r100) {
        this.liveDataBuilder.f475674i = r100;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public void setUpdateFlag(boolean r100) {
        this.liveDataBuilder.f475676k = r100;
    }

    public LiveDataBuilder<V> pageConfig(PagedList.Config r100) {
        this.liveDataBuilder.f475682q = r100;
        return this;
    }
}

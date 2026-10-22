package com.bytedance.android.live.core.paging.builder;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.PagedList;
import com.bytedance.android.live.core.network.NetworkStat;
import com.bytedance.android.live.core.paging.Listing;
import com.bytedance.android.live.core.paging.datasource.PagingLoadCallback;
import io.reactivex.subjects.PublishSubject;

/* JADX INFO: loaded from: classes45.dex */
public interface DataBuilder<V> {
    Listing<V> build();

    Listing<V> build(LiveData<PagedList<V>> r100);

    PagingLoadCallback<V> callback();

    MutableLiveData<Boolean> empty();

    long getGeneration();

    MutableLiveData<Boolean> hasMore();

    boolean hasRefreshFlag();

    boolean hasUpdateFlag();

    long makeGeneration();

    MutableLiveData<NetworkStat> networkState();

    PublishSubject<Object> refresh();

    MutableLiveData<NetworkStat> refreshState();

    boolean refreshing();

    PublishSubject<Object> retry();

    void setRefreshFlag(boolean r100);

    void setRefreshing(boolean r100);

    void setUpdateFlag(boolean r100);

    PublishSubject<Object> update();

    MutableLiveData<Integer> updateAdapterItem();

    MutableLiveData<NetworkStat> updateState();
}

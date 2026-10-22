package com.bytedance.android.live.core.paging;

import android.util.Pair;
import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;
import com.bytedance.android.live.core.cache.j;
import com.bytedance.android.live.core.network.NetworkStat;
import io.reactivex.subjects.PublishSubject;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public interface Listing<T> {
    void add(int r100, T r101);

    void add(int r100, List<T> r101);

    T find(j<T> r100);

    T get(int r100);

    LiveData<NetworkStat> getNetworkStat();

    LiveData<PagedList<T>> getPageList();

    LiveData<NetworkStat> getRefreshStat();

    PublishSubject<Pair<String, String>> getReqFrom();

    LiveData<NetworkStat> getUpdateStat();

    LiveData<Boolean> hasMore();

    int indexOf(T r100);

    LiveData<Boolean> isEmpty();

    void put(int r100, T r101);

    void refresh();

    void remove(int r100);

    void remove(T r100);

    void retry();

    void setReqFrom(String r100, String r101);

    int size();

    void update();

    void updateAdapterItem(int r100);

    LiveData<Integer> updateAdapterItemEvent();
}

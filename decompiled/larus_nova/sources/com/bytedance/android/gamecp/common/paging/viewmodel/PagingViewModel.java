package com.bytedance.android.gamecp.common.paging.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.gamecp.common.utils.rx.RxViewModel;
import qu.a;

/* JADX INFO: loaded from: classes44.dex */
public class PagingViewModel<T> extends RxViewModel {
    private a<T> listing;
    private MutableLiveData<Object> networkState;
    private MutableLiveData<Object> refreshState;

    public void retry() {
        a<T> r100 = this.listing;
        if (r100 == null) goto L6;
        r100.retry();
        return;
    }

    public PagingViewModel() {
        this.networkState = new MutableLiveData();
        this.refreshState = new MutableLiveData();
    }

    public LiveData<Object> networkStat() {
        return this.networkState;
    }

    public LiveData<Object> refreshStat() {
        return this.refreshState;
    }
}

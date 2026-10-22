package com.bytedance.android.live.core.paging.builder;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.PagedList;

/* JADX INFO: loaded from: classes45.dex */
public class DefaultBoundaryCallback<V> extends PagedList.BoundaryCallback<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData<Boolean> f65087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData<Boolean> f65088b;

    @Override // androidx.paging.PagedList.BoundaryCallback
    public final void onZeroItemsLoaded() {
        super.onZeroItemsLoaded();
        this.f65088b.postValue(Boolean.TRUE);
    }

    @Override // androidx.paging.PagedList.BoundaryCallback
    public final void onItemAtEndLoaded(V r100) {
        super.onItemAtEndLoaded(r100);
        this.f65087a.postValue(Boolean.FALSE);
    }

    public DefaultBoundaryCallback(MutableLiveData<Boolean> r100, MutableLiveData<Boolean> r101) {
        this.f65087a = new MutableLiveData();
        this.f65088b = new MutableLiveData();
        this.f65087a = r100;
        this.f65088b = r101;
    }
}

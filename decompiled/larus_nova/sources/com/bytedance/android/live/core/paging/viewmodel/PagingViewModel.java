package com.bytedance.android.live.core.paging.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.PagedList;
import com.bytedance.android.live.core.cache.j;
import com.bytedance.android.live.core.network.NetworkStat;
import com.bytedance.android.live.core.paging.Listing;
import com.bytedance.android.live.core.utils.rxutils.RxViewModel;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import h60.a;
import h60.b;
import h60.c;
import h60.d;
import h60.e;
import h60.f;
import h60.g;

/* JADX INFO: loaded from: classes45.dex */
public class PagingViewModel<T> extends RxViewModel {
    private final Observer<PagedList<T>> dataObserver;
    private MutableLiveData<Boolean> empty;
    private final Observer<Boolean> emptyObserver;
    private MutableLiveData<PagedList<T>> listData;
    private Listing<T> listing;
    private MutableLiveData<Boolean> more;
    private final Observer<Boolean> moreObserver;
    private final Observer<NetworkStat> networkObserver;
    private MutableLiveData<NetworkStat> networkState;
    private final Observer<NetworkStat> refreshObserver;
    private MutableLiveData<NetworkStat> refreshState;
    private MutableLiveData<Integer> updateAdapterItem;
    private final Observer<Integer> updateAdapterItemObserver;
    private final Observer<NetworkStat> updateObserver;
    private MutableLiveData<NetworkStat> updateState;

    public static /* synthetic */ void Mo(PagingViewModel r100, Boolean r101) {
        r100.lambda$new$5(r101);
    }

    public static /* synthetic */ void No(PagingViewModel r100, NetworkStat r101) {
        r100.lambda$new$1(r101);
    }

    public static /* synthetic */ void Oo(PagingViewModel r100, NetworkStat r101) {
        r100.lambda$new$2(r101);
    }

    public static /* synthetic */ void Po(PagingViewModel r100, NetworkStat r101) {
        r100.lambda$new$0(r101);
    }

    public static /* synthetic */ void Qo(PagingViewModel r100, Integer r101) {
        r100.lambda$new$6(r101);
    }

    public static /* synthetic */ void So(PagingViewModel r100, Boolean r101) {
        r100.lambda$new$4(r101);
    }

    public static /* synthetic */ void yo(PagingViewModel r100, PagedList r101) {
        r100.lambda$new$3(r101);
    }

    public boolean refresh() {
        if (this.refreshState.getValue() != null) goto L5;
    L7:
        Listing<T> r100 = this.listing;
        if (r100 == null) goto L11;
        r100.refresh();
        return true;
    L11:
        return false;
    L5:
        if (this.refreshState.getValue().isLoading() == false) goto L7;
        return false;
    }

    public void retry() {
        Listing<T> r100 = this.listing;
        if (r100 == null) goto L6;
        r100.retry();
        return;
    }

    public void setLiveDataEmpty() {
        this.listData.postValue(null);
    }

    public void update() {
        Listing<T> r100 = this.listing;
        if (r100 == null) goto L6;
        r100.update();
        return;
    }

    public PagingViewModel() {
        this.networkState = new MutableLiveData();
        this.refreshState = new MutableLiveData();
        this.updateState = new MutableLiveData();
        this.empty = new MutableLiveData();
        this.more = new MutableLiveData();
        this.updateAdapterItem = new MutableLiveData();
        this.listData = new MutableLiveData();
        this.networkObserver = new a(this);
        this.refreshObserver = new b(this);
        this.updateObserver = new c(this);
        this.dataObserver = new d(this);
        this.emptyObserver = new e(this);
        this.moreObserver = new f(this);
        this.updateAdapterItemObserver = new g(this);
    }

    public LiveData<Boolean> hasMore() {
        return this.more;
    }

    public LiveData<Boolean> isDataEmpty() {
        return this.empty;
    }

    public Listing<T> listing() {
        return this.listing;
    }

    public LiveData<PagedList<T>> liveData() {
        return this.listData;
    }

    public LiveData<NetworkStat> networkStat() {
        return this.networkState;
    }

    public LiveData<NetworkStat> refreshStat() {
        return this.refreshState;
    }

    public LiveData<Integer> updateAdapterItem() {
        return this.updateAdapterItem;
    }

    public LiveData<NetworkStat> updateStat() {
        return this.updateState;
    }

    private /* synthetic */ void lambda$new$0(NetworkStat r100) {
        this.networkState.postValue(r100);
    }

    private /* synthetic */ void lambda$new$1(NetworkStat r100) {
        this.refreshState.postValue(r100);
    }

    private /* synthetic */ void lambda$new$2(NetworkStat r100) {
        this.updateState.postValue(r100);
    }

    private /* synthetic */ void lambda$new$3(PagedList r100) {
        this.listData.postValue(r100);
    }

    private /* synthetic */ void lambda$new$4(Boolean r100) {
        this.empty.postValue(r100);
    }

    private /* synthetic */ void lambda$new$5(Boolean r100) {
        this.more.postValue(r100);
    }

    private /* synthetic */ void lambda$new$6(Integer r100) {
        this.updateAdapterItem.setValue(r100);
    }

    public T find(j<T> r100) {
        if (listing() != null) goto L5;
        return null;
    L5:
        return listing().find(r100);
    }

    public T get(int r100) {
        if (listing() != null) goto L5;
        return null;
    L5:
        return listing().get(r100);
    }

    public int indexOf(T r100) {
        if (listing() != null) goto L5;
        return -1;
    L5:
        return listing().indexOf(r100);
    }

    public void register(Listing<T> r100) {
        Listing<T> r101 = this.listing;
        if (r101 == null) goto L5;
        r101.getNetworkStat().removeObserver(this.networkObserver);
        this.listing.getRefreshStat().removeObserver(this.refreshObserver);
        this.listing.getUpdateStat().removeObserver(this.updateObserver);
        this.listing.getPageList().removeObserver(this.dataObserver);
        this.listing.isEmpty().removeObserver(this.emptyObserver);
        this.listing.hasMore().removeObserver(this.moreObserver);
        this.listing.updateAdapterItemEvent().removeObserver(this.updateAdapterItemObserver);
    L5:
        this.listing = r100;
        if (r100 == null) goto L9;
        r100.getNetworkStat().observeForever(this.networkObserver);
        this.listing.getRefreshStat().observeForever(this.refreshObserver);
        this.listing.getUpdateStat().observeForever(this.updateObserver);
        this.listing.getPageList().observeForever(this.dataObserver);
        this.listing.isEmpty().observeForever(this.emptyObserver);
        this.listing.hasMore().observeForever(this.moreObserver);
        this.listing.updateAdapterItemEvent().observeForever(this.updateAdapterItemObserver);
        return;
    }

    public void remove(T r100) {
        if (listing() == null) goto L7;
        if (r100 == null) goto L8;
        listing().remove(r100);
        return;
    L8:
        return;
    }

    public void updateAdapterItem(int r100) {
        Listing<T> r101 = this.listing;
        if (r101 == null) goto L6;
        r101.updateAdapterItem(r100);
        return;
    }

    public void remove(int r100) {
        if (listing() == null) goto L6;
        listing().remove(r100);
        return;
    }

    public void add(int r100, T r101) {
        if (listing() == null) goto L6;
        listing().add(r100, r101);
        return;
    }

    public void put(int r100, T r101) {
        if (listing() == null) goto L6;
        listing().put(r100, r101);
        return;
    }
}

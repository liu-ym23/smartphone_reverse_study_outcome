package com.bytedance.android.shopping.anchorv3.auction;

import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;
import com.bytedance.android.ec.core.arch.viewmodel.BaseViewModel;
import com.bytedance.android.ec.core.data.LoadingStatus;
import com.bytedance.android.ec.core.data.PagingLoadingStatus;
import com.bytedance.android.shopping.anchorv3.auction.data.AuctionRepository;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b%\u0010&J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\nR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\r\u0010\u000eR.\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00100\u000f8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R(\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u000f8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R(\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000f8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u0016R#\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040 0\u001f8\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/auction/AuctionOfferRecordsViewModel;", "Lcom/bytedance/android/ec/core/arch/viewmodel/BaseViewModel;", "Lcom/bytedance/android/shopping/anchorv3/auction/AnchorV3AuctionOfferRecordsFragment$OfferRecordsParams;", "params", "", "init", "closePage", "Lcom/bytedance/android/shopping/anchorv3/auction/data/AuctionRepository;", "repository", "Lcom/bytedance/android/shopping/anchorv3/auction/data/AuctionRepository;", "Lcom/bytedance/android/shopping/anchorv3/auction/AnchorV3AuctionOfferRecordsFragment$OfferRecordsParams;", "Lmg3/a;", "Lj53/a;", "listing", "Lmg3/a;", "Landroidx/lifecycle/LiveData;", "Landroidx/paging/PagedList;", "records", "Landroidx/lifecycle/LiveData;", "getRecords", "()Landroidx/lifecycle/LiveData;", "setRecords", "(Landroidx/lifecycle/LiveData;)V", "Lcom/bytedance/android/ec/core/data/PagingLoadingStatus;", "pagingLoadingStatus", "getPagingLoadingStatus", "setPagingLoadingStatus", "Lcom/bytedance/android/ec/core/data/LoadingStatus;", "refreshLoadingStatus", "getRefreshLoadingStatus", "setRefreshLoadingStatus", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "Lrg/a;", "closePageAction", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "getClosePageAction", "()Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AuctionOfferRecordsViewModel extends BaseViewModel {
    private final QLiveData<rg.a<Unit>> closePageAction;
    private mg3.a<j53.a> listing;
    public LiveData<PagingLoadingStatus> pagingLoadingStatus;
    private AnchorV3AuctionOfferRecordsFragment.OfferRecordsParams params;
    public LiveData<PagedList<j53.a>> records;
    public LiveData<LoadingStatus> refreshLoadingStatus;
    private final AuctionRepository repository;

    /* JADX WARN: Multi-variable type inference failed */
    public AuctionOfferRecordsViewModel() {
        Object[] r100 = 0 == true ? 1 : 0;
        super(null, r100, 3, 0 == true ? 1 : 0);
        this.repository = new AuctionRepository(new i53.a(), this);
        this.closePageAction = new QLiveData();
    }

    public final void closePage() {
        this.closePageAction.g(new rg.a(Unit.INSTANCE));
    }

    public final LiveData<PagingLoadingStatus> getPagingLoadingStatus() {
        LiveData<PagingLoadingStatus> r100 = this.pagingLoadingStatus;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pagingLoadingStatus");
    L5:
        return r100;
    }

    public final LiveData<PagedList<j53.a>> getRecords() {
        LiveData<PagedList<j53.a>> r100 = this.records;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("records");
    L5:
        return r100;
    }

    public final LiveData<LoadingStatus> getRefreshLoadingStatus() {
        LiveData<LoadingStatus> r100 = this.refreshLoadingStatus;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("refreshLoadingStatus");
    L5:
        return r100;
    }

    public final QLiveData<rg.a<Unit>> getClosePageAction() {
        return this.closePageAction;
    }

    public final void init(AnchorV3AuctionOfferRecordsFragment.OfferRecordsParams r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.params = r100;
        mg3.a<j53.a> r101 = this.repository.a(r100);
        this.listing = r101;
        this.records = r101.f513717a;
        mg3.a<j53.a> r102 = this.listing;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("listing");
    L5:
        this.pagingLoadingStatus = r102.f513718b;
        mg3.a<j53.a> r103 = this.listing;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("listing");
    L8:
        this.refreshLoadingStatus = r103.f513719c;
    }

    public final void setPagingLoadingStatus(LiveData<PagingLoadingStatus> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.pagingLoadingStatus = r100;
    }

    public final void setRecords(LiveData<PagedList<j53.a>> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.records = r100;
    }

    public final void setRefreshLoadingStatus(LiveData<LoadingStatus> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.refreshLoadingStatus = r100;
    }
}
